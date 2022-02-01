package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;

public final class ProtoIdItem
  extends IndexedItem
{
  private TypeListItem parameterTypes;
  private final Prototype prototype;
  private final CstString shortForm;
  
  public ProtoIdItem(Prototype paramPrototype)
  {
    if (paramPrototype == null) {
      throw new NullPointerException("prototype == null");
    }
    this.prototype = paramPrototype;
    this.shortForm = makeShortForm(paramPrototype);
    paramPrototype = paramPrototype.getParameterTypes();
    if (paramPrototype.size() == 0) {}
    for (paramPrototype = null;; paramPrototype = new TypeListItem(paramPrototype))
    {
      this.parameterTypes = paramPrototype;
      return;
    }
  }
  
  private static CstString makeShortForm(Prototype paramPrototype)
  {
    StdTypeList localStdTypeList = paramPrototype.getParameterTypes();
    int j = localStdTypeList.size();
    StringBuilder localStringBuilder = new StringBuilder(j + 1);
    localStringBuilder.append(shortFormCharFor(paramPrototype.getReturnType()));
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(shortFormCharFor(localStdTypeList.getType(i)));
      i += 1;
    }
    return new CstString(localStringBuilder.toString());
  }
  
  private static char shortFormCharFor(Type paramType)
  {
    char c2 = paramType.getDescriptor().charAt(0);
    char c1 = c2;
    if (c2 == '[') {
      c1 = 'L';
    }
    return c1;
  }
  
  public void addContents(DexFile paramDexFile)
  {
    StringIdsSection localStringIdsSection = paramDexFile.getStringIds();
    TypeIdsSection localTypeIdsSection = paramDexFile.getTypeIds();
    paramDexFile = paramDexFile.getTypeLists();
    localTypeIdsSection.intern(this.prototype.getReturnType());
    localStringIdsSection.intern(this.shortForm);
    if (this.parameterTypes != null) {
      this.parameterTypes = ((TypeListItem)paramDexFile.intern(this.parameterTypes));
    }
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_PROTO_ID_ITEM;
  }
  
  public int writeSize()
  {
    return 12;
  }
  
  public void writeTo(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    int j = paramDexFile.getStringIds().indexOf(this.shortForm);
    int k = paramDexFile.getTypeIds().indexOf(this.prototype.getReturnType());
    int m = OffsettedItem.getAbsoluteOffsetOr0(this.parameterTypes);
    if (paramAnnotatedOutput.annotates())
    {
      paramDexFile = new StringBuilder();
      paramDexFile.append(this.prototype.getReturnType().toHuman());
      paramDexFile.append(" proto(");
      StdTypeList localStdTypeList = this.prototype.getParameterTypes();
      int n = localStdTypeList.size();
      int i = 0;
      while (i < n)
      {
        if (i != 0) {
          paramDexFile.append(", ");
        }
        paramDexFile.append(localStdTypeList.getType(i).toHuman());
        i += 1;
      }
      paramDexFile.append(")");
      paramAnnotatedOutput.annotate(0, indexString() + ' ' + paramDexFile.toString());
      paramAnnotatedOutput.annotate(4, "  shorty_idx:      " + Hex.u4(j) + " // " + this.shortForm.toQuoted());
      paramAnnotatedOutput.annotate(4, "  return_type_idx: " + Hex.u4(k) + " // " + this.prototype.getReturnType().toHuman());
      paramAnnotatedOutput.annotate(4, "  parameters_off:  " + Hex.u4(m));
    }
    paramAnnotatedOutput.writeInt(j);
    paramAnnotatedOutput.writeInt(k);
    paramAnnotatedOutput.writeInt(m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.ProtoIdItem
 * JD-Core Version:    0.7.0.1
 */