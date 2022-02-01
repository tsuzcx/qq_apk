package com.android.dx;

import com.android.dx.dex.DexOptions;
import com.android.dx.dex.file.ClassDefItem;
import com.android.dx.dex.file.EncodedField;
import com.android.dx.dex.file.EncodedMethod;
import com.android.dx.rop.cst.CstString;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class DexMaker$TypeDeclaration
{
  private boolean declared;
  private final Map<FieldId, DexMaker.FieldDeclaration> fields = new LinkedHashMap();
  private int flags;
  private TypeList interfaces;
  private final Map<MethodId, DexMaker.MethodDeclaration> methods = new LinkedHashMap();
  private String sourceFile;
  private TypeId<?> supertype;
  private final TypeId<?> type;
  
  DexMaker$TypeDeclaration(TypeId<?> paramTypeId)
  {
    this.type = paramTypeId;
  }
  
  ClassDefItem toClassDefItem()
  {
    if (!this.declared) {
      throw new IllegalStateException("Undeclared type " + this.type + " declares members: " + this.fields.keySet() + " " + this.methods.keySet());
    }
    Object localObject1 = new DexOptions();
    ((DexOptions)localObject1).targetApiLevel = 13;
    ClassDefItem localClassDefItem = new ClassDefItem(this.type.constant, this.flags, this.supertype.constant, this.interfaces.ropTypes, new CstString(this.sourceFile));
    Object localObject2 = this.methods.values().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (DexMaker.MethodDeclaration)((Iterator)localObject2).next();
      EncodedMethod localEncodedMethod = ((DexMaker.MethodDeclaration)localObject3).toEncodedMethod((DexOptions)localObject1);
      if (((DexMaker.MethodDeclaration)localObject3).isDirect()) {
        localClassDefItem.addDirectMethod(localEncodedMethod);
      } else {
        localClassDefItem.addVirtualMethod(localEncodedMethod);
      }
    }
    localObject1 = this.fields.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DexMaker.FieldDeclaration)((Iterator)localObject1).next();
      localObject3 = ((DexMaker.FieldDeclaration)localObject2).toEncodedField();
      if (((DexMaker.FieldDeclaration)localObject2).isStatic()) {
        localClassDefItem.addStaticField((EncodedField)localObject3, Constants.getConstant(DexMaker.FieldDeclaration.access$800((DexMaker.FieldDeclaration)localObject2)));
      } else {
        localClassDefItem.addInstanceField((EncodedField)localObject3);
      }
    }
    return localClassDefItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.DexMaker.TypeDeclaration
 * JD-Core Version:    0.7.0.1
 */