package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstArray;
import com.android.dx.rop.cst.CstArray.List;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstLiteralBits;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.Zeroes;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import com.android.dx.util.Writers;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public final class ClassDataItem
  extends OffsettedItem
{
  private final ArrayList<EncodedMethod> directMethods;
  private byte[] encodedForm;
  private final ArrayList<EncodedField> instanceFields;
  private final ArrayList<EncodedField> staticFields;
  private final HashMap<EncodedField, Constant> staticValues;
  private CstArray staticValuesConstant;
  private final CstType thisClass;
  private final ArrayList<EncodedMethod> virtualMethods;
  
  public ClassDataItem(CstType paramCstType)
  {
    super(1, -1);
    if (paramCstType == null) {
      throw new NullPointerException("thisClass == null");
    }
    this.thisClass = paramCstType;
    this.staticFields = new ArrayList(20);
    this.staticValues = new HashMap(40);
    this.instanceFields = new ArrayList(20);
    this.directMethods = new ArrayList(20);
    this.virtualMethods = new ArrayList(20);
    this.staticValuesConstant = null;
  }
  
  private static void encodeList(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput, String paramString, ArrayList<? extends EncodedMember> paramArrayList)
  {
    int k = paramArrayList.size();
    if (k == 0) {}
    for (;;)
    {
      return;
      if (paramAnnotatedOutput.annotates()) {
        paramAnnotatedOutput.annotate(0, "  " + paramString + ":");
      }
      int i = 0;
      int j = 0;
      while (i < k)
      {
        j = ((EncodedMember)paramArrayList.get(i)).encode(paramDexFile, paramAnnotatedOutput, j, i);
        i += 1;
      }
    }
  }
  
  private void encodeOutput(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    boolean bool = paramAnnotatedOutput.annotates();
    if (bool) {
      paramAnnotatedOutput.annotate(0, offsetString() + " class data for " + this.thisClass.toHuman());
    }
    encodeSize(paramDexFile, paramAnnotatedOutput, "static_fields", this.staticFields.size());
    encodeSize(paramDexFile, paramAnnotatedOutput, "instance_fields", this.instanceFields.size());
    encodeSize(paramDexFile, paramAnnotatedOutput, "direct_methods", this.directMethods.size());
    encodeSize(paramDexFile, paramAnnotatedOutput, "virtual_methods", this.virtualMethods.size());
    encodeList(paramDexFile, paramAnnotatedOutput, "static_fields", this.staticFields);
    encodeList(paramDexFile, paramAnnotatedOutput, "instance_fields", this.instanceFields);
    encodeList(paramDexFile, paramAnnotatedOutput, "direct_methods", this.directMethods);
    encodeList(paramDexFile, paramAnnotatedOutput, "virtual_methods", this.virtualMethods);
    if (bool) {
      paramAnnotatedOutput.endAnnotation();
    }
  }
  
  private static void encodeSize(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput, String paramString, int paramInt)
  {
    if (paramAnnotatedOutput.annotates()) {
      paramAnnotatedOutput.annotate(String.format("  %-21s %08x", new Object[] { paramString + "_size:", Integer.valueOf(paramInt) }));
    }
    paramAnnotatedOutput.writeUleb128(paramInt);
  }
  
  private CstArray makeStaticValuesConstant()
  {
    Collections.sort(this.staticFields);
    int i = this.staticFields.size();
    Object localObject;
    for (;;)
    {
      if (i > 0)
      {
        localObject = (EncodedField)this.staticFields.get(i - 1);
        localObject = (Constant)this.staticValues.get(localObject);
        if (!(localObject instanceof CstLiteralBits)) {
          break label70;
        }
        if (((CstLiteralBits)localObject).getLongBits() == 0L) {
          break label74;
        }
      }
      label70:
      while (localObject != null)
      {
        if (i != 0) {
          break;
        }
        return null;
      }
      label74:
      i -= 1;
    }
    CstArray.List localList = new CstArray.List(i);
    int j = 0;
    while (j < i)
    {
      EncodedField localEncodedField = (EncodedField)this.staticFields.get(j);
      Constant localConstant = (Constant)this.staticValues.get(localEncodedField);
      localObject = localConstant;
      if (localConstant == null) {
        localObject = Zeroes.zeroFor(localEncodedField.getRef().getType());
      }
      localList.set(j, (Constant)localObject);
      j += 1;
    }
    localList.setImmutable();
    return new CstArray(localList);
  }
  
  public void addContents(DexFile paramDexFile)
  {
    Iterator localIterator;
    if (!this.staticFields.isEmpty())
    {
      getStaticValuesConstant();
      localIterator = this.staticFields.iterator();
      while (localIterator.hasNext()) {
        ((EncodedField)localIterator.next()).addContents(paramDexFile);
      }
    }
    if (!this.instanceFields.isEmpty())
    {
      Collections.sort(this.instanceFields);
      localIterator = this.instanceFields.iterator();
      while (localIterator.hasNext()) {
        ((EncodedField)localIterator.next()).addContents(paramDexFile);
      }
    }
    if (!this.directMethods.isEmpty())
    {
      Collections.sort(this.directMethods);
      localIterator = this.directMethods.iterator();
      while (localIterator.hasNext()) {
        ((EncodedMethod)localIterator.next()).addContents(paramDexFile);
      }
    }
    if (!this.virtualMethods.isEmpty())
    {
      Collections.sort(this.virtualMethods);
      localIterator = this.virtualMethods.iterator();
      while (localIterator.hasNext()) {
        ((EncodedMethod)localIterator.next()).addContents(paramDexFile);
      }
    }
  }
  
  public void addDirectMethod(EncodedMethod paramEncodedMethod)
  {
    if (paramEncodedMethod == null) {
      throw new NullPointerException("method == null");
    }
    this.directMethods.add(paramEncodedMethod);
  }
  
  public void addInstanceField(EncodedField paramEncodedField)
  {
    if (paramEncodedField == null) {
      throw new NullPointerException("field == null");
    }
    this.instanceFields.add(paramEncodedField);
  }
  
  public void addStaticField(EncodedField paramEncodedField, Constant paramConstant)
  {
    if (paramEncodedField == null) {
      throw new NullPointerException("field == null");
    }
    if (this.staticValuesConstant != null) {
      throw new UnsupportedOperationException("static fields already sorted");
    }
    this.staticFields.add(paramEncodedField);
    this.staticValues.put(paramEncodedField, paramConstant);
  }
  
  public void addVirtualMethod(EncodedMethod paramEncodedMethod)
  {
    if (paramEncodedMethod == null) {
      throw new NullPointerException("method == null");
    }
    this.virtualMethods.add(paramEncodedMethod);
  }
  
  public void debugPrint(Writer paramWriter, boolean paramBoolean)
  {
    int j = 0;
    paramWriter = Writers.printWriterFor(paramWriter);
    int k = this.staticFields.size();
    int i = 0;
    while (i < k)
    {
      paramWriter.println("  sfields[" + i + "]: " + this.staticFields.get(i));
      i += 1;
    }
    k = this.instanceFields.size();
    i = 0;
    while (i < k)
    {
      paramWriter.println("  ifields[" + i + "]: " + this.instanceFields.get(i));
      i += 1;
    }
    k = this.directMethods.size();
    i = 0;
    while (i < k)
    {
      paramWriter.println("  dmeths[" + i + "]:");
      ((EncodedMethod)this.directMethods.get(i)).debugPrint(paramWriter, paramBoolean);
      i += 1;
    }
    k = this.virtualMethods.size();
    i = j;
    while (i < k)
    {
      paramWriter.println("  vmeths[" + i + "]:");
      ((EncodedMethod)this.virtualMethods.get(i)).debugPrint(paramWriter, paramBoolean);
      i += 1;
    }
  }
  
  public ArrayList<EncodedMethod> getMethods()
  {
    ArrayList localArrayList = new ArrayList(this.directMethods.size() + this.virtualMethods.size());
    localArrayList.addAll(this.directMethods);
    localArrayList.addAll(this.virtualMethods);
    return localArrayList;
  }
  
  public CstArray getStaticValuesConstant()
  {
    if ((this.staticValuesConstant == null) && (this.staticFields.size() != 0)) {
      this.staticValuesConstant = makeStaticValuesConstant();
    }
    return this.staticValuesConstant;
  }
  
  public boolean isEmpty()
  {
    return (this.staticFields.isEmpty()) && (this.instanceFields.isEmpty()) && (this.directMethods.isEmpty()) && (this.virtualMethods.isEmpty());
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_CLASS_DATA_ITEM;
  }
  
  protected void place0(Section paramSection, int paramInt)
  {
    ByteArrayAnnotatedOutput localByteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput();
    encodeOutput(paramSection.getFile(), localByteArrayAnnotatedOutput);
    this.encodedForm = localByteArrayAnnotatedOutput.toByteArray();
    setWriteSize(this.encodedForm.length);
  }
  
  public String toHuman()
  {
    return toString();
  }
  
  public void writeTo0(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    if (paramAnnotatedOutput.annotates())
    {
      encodeOutput(paramDexFile, paramAnnotatedOutput);
      return;
    }
    paramAnnotatedOutput.write(this.encodedForm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.ClassDataItem
 * JD-Core Version:    0.7.0.1
 */