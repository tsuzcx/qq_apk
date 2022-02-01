package com.android.dx.dex.file;

import com.android.dx.rop.annotation.Annotation;
import com.android.dx.rop.annotation.AnnotationVisibility;
import com.android.dx.rop.annotation.NameValuePair;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class AnnotationItem
  extends OffsettedItem
{
  private static final int ALIGNMENT = 1;
  private static final AnnotationItem.TypeIdSorter TYPE_ID_SORTER = new AnnotationItem.TypeIdSorter(null);
  private static final int VISIBILITY_BUILD = 0;
  private static final int VISIBILITY_RUNTIME = 1;
  private static final int VISIBILITY_SYSTEM = 2;
  private final Annotation annotation;
  private byte[] encodedForm;
  private TypeIdItem type;
  
  public AnnotationItem(Annotation paramAnnotation, DexFile paramDexFile)
  {
    super(1, -1);
    if (paramAnnotation == null) {
      throw new NullPointerException("annotation == null");
    }
    this.annotation = paramAnnotation;
    this.type = null;
    this.encodedForm = null;
    addContents(paramDexFile);
  }
  
  public static void sortByTypeIdIndex(AnnotationItem[] paramArrayOfAnnotationItem)
  {
    Arrays.sort(paramArrayOfAnnotationItem, TYPE_ID_SORTER);
  }
  
  public void addContents(DexFile paramDexFile)
  {
    this.type = paramDexFile.getTypeIds().intern(this.annotation.getType());
    ValueEncoder.addContents(paramDexFile, this.annotation);
  }
  
  public void annotateTo(AnnotatedOutput paramAnnotatedOutput, String paramString)
  {
    paramAnnotatedOutput.annotate(0, paramString + "visibility: " + this.annotation.getVisibility().toHuman());
    paramAnnotatedOutput.annotate(0, paramString + "type: " + this.annotation.getType().toHuman());
    Iterator localIterator = this.annotation.getNameValuePairs().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (NameValuePair)localIterator.next();
      CstString localCstString = ((NameValuePair)localObject).getName();
      localObject = ((NameValuePair)localObject).getValue();
      paramAnnotatedOutput.annotate(0, paramString + localCstString.toHuman() + ": " + ValueEncoder.constantToHuman((Constant)localObject));
    }
  }
  
  protected int compareTo0(OffsettedItem paramOffsettedItem)
  {
    paramOffsettedItem = (AnnotationItem)paramOffsettedItem;
    return this.annotation.compareTo(paramOffsettedItem.annotation);
  }
  
  public int hashCode()
  {
    return this.annotation.hashCode();
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_ANNOTATION_ITEM;
  }
  
  protected void place0(Section paramSection, int paramInt)
  {
    ByteArrayAnnotatedOutput localByteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput();
    new ValueEncoder(paramSection.getFile(), localByteArrayAnnotatedOutput).writeAnnotation(this.annotation, false);
    this.encodedForm = localByteArrayAnnotatedOutput.toByteArray();
    setWriteSize(this.encodedForm.length + 1);
  }
  
  public String toHuman()
  {
    return this.annotation.toHuman();
  }
  
  protected void writeTo0(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    boolean bool = paramAnnotatedOutput.annotates();
    AnnotationVisibility localAnnotationVisibility = this.annotation.getVisibility();
    if (bool)
    {
      paramAnnotatedOutput.annotate(0, offsetString() + " annotation");
      paramAnnotatedOutput.annotate(1, "  visibility: VISBILITY_" + localAnnotationVisibility);
    }
    switch (AnnotationItem.1.$SwitchMap$com$android$dx$rop$annotation$AnnotationVisibility[localAnnotationVisibility.ordinal()])
    {
    default: 
      throw new RuntimeException("shouldn't happen");
    case 1: 
      paramAnnotatedOutput.writeByte(0);
    }
    while (bool)
    {
      new ValueEncoder(paramDexFile, paramAnnotatedOutput).writeAnnotation(this.annotation, true);
      return;
      paramAnnotatedOutput.writeByte(1);
      continue;
      paramAnnotatedOutput.writeByte(2);
    }
    paramAnnotatedOutput.write(this.encodedForm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.AnnotationItem
 * JD-Core Version:    0.7.0.1
 */