package com.android.dx.command.findusages;

import com.android.dex.ClassData;
import com.android.dex.ClassData.Field;
import com.android.dex.ClassData.Method;
import com.android.dex.ClassDef;
import com.android.dex.Code;
import com.android.dex.Dex;
import com.android.dex.FieldId;
import com.android.dex.MethodId;
import com.android.dx.io.CodeReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class FindUsages
{
  private final CodeReader codeReader = new CodeReader();
  private ClassDef currentClass;
  private ClassData.Method currentMethod;
  private final Dex dex;
  private final Set<Integer> fieldIds;
  private final Set<Integer> methodIds;
  private final PrintWriter out;
  
  public FindUsages(Dex paramDex, String paramString1, String paramString2, PrintWriter paramPrintWriter)
  {
    this.dex = paramDex;
    this.out = paramPrintWriter;
    HashSet localHashSet2 = new HashSet();
    HashSet localHashSet1 = new HashSet();
    paramString1 = Pattern.compile(paramString1);
    paramString2 = Pattern.compile(paramString2);
    List localList = paramDex.strings();
    int i = 0;
    while (i < localList.size())
    {
      String str = (String)localList.get(i);
      if (paramString1.matcher(str).matches()) {
        localHashSet2.add(Integer.valueOf(i));
      }
      if (paramString2.matcher(str).matches()) {
        localHashSet1.add(Integer.valueOf(i));
      }
      i += 1;
    }
    if ((localHashSet2.isEmpty()) || (localHashSet1.isEmpty()))
    {
      this.fieldIds = null;
      this.methodIds = null;
      return;
    }
    this.methodIds = new HashSet();
    this.fieldIds = new HashSet();
    paramString1 = localHashSet2.iterator();
    while (paramString1.hasNext())
    {
      i = ((Integer)paramString1.next()).intValue();
      i = Collections.binarySearch(paramDex.typeIds(), Integer.valueOf(i));
      if (i >= 0)
      {
        this.methodIds.addAll(getMethodIds(paramDex, localHashSet1, i));
        this.fieldIds.addAll(getFieldIds(paramDex, localHashSet1, i));
      }
    }
    this.codeReader.setFieldVisitor(new FindUsages.1(this, paramPrintWriter, paramDex));
    this.codeReader.setMethodVisitor(new FindUsages.2(this, paramPrintWriter, paramDex));
  }
  
  private Set<Integer> findAssignableTypes(Dex paramDex, int paramInt)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(paramInt));
    paramDex = paramDex.classDefs().iterator();
    label147:
    while (paramDex.hasNext())
    {
      ClassDef localClassDef = (ClassDef)paramDex.next();
      if (localHashSet.contains(Integer.valueOf(localClassDef.getSupertypeIndex())))
      {
        localHashSet.add(Integer.valueOf(localClassDef.getTypeIndex()));
      }
      else
      {
        short[] arrayOfShort = localClassDef.getInterfaces();
        int i = arrayOfShort.length;
        paramInt = 0;
        for (;;)
        {
          if (paramInt >= i) {
            break label147;
          }
          if (localHashSet.contains(Integer.valueOf(arrayOfShort[paramInt])))
          {
            localHashSet.add(Integer.valueOf(localClassDef.getTypeIndex()));
            break;
          }
          paramInt += 1;
        }
      }
    }
    return localHashSet;
  }
  
  private Set<Integer> getFieldIds(Dex paramDex, Set<Integer> paramSet, int paramInt)
  {
    HashSet localHashSet = new HashSet();
    paramDex = paramDex.fieldIds().iterator();
    int i = 0;
    while (paramDex.hasNext())
    {
      FieldId localFieldId = (FieldId)paramDex.next();
      if ((paramSet.contains(Integer.valueOf(localFieldId.getNameIndex()))) && (paramInt == localFieldId.getDeclaringClassIndex())) {
        localHashSet.add(Integer.valueOf(i));
      }
      i += 1;
    }
    return localHashSet;
  }
  
  private Set<Integer> getMethodIds(Dex paramDex, Set<Integer> paramSet, int paramInt)
  {
    Set localSet = findAssignableTypes(paramDex, paramInt);
    HashSet localHashSet = new HashSet();
    paramDex = paramDex.methodIds().iterator();
    paramInt = 0;
    while (paramDex.hasNext())
    {
      MethodId localMethodId = (MethodId)paramDex.next();
      if ((paramSet.contains(Integer.valueOf(localMethodId.getNameIndex()))) && (localSet.contains(Integer.valueOf(localMethodId.getDeclaringClassIndex())))) {
        localHashSet.add(Integer.valueOf(paramInt));
      }
      paramInt += 1;
    }
    return localHashSet;
  }
  
  private String location()
  {
    String str = (String)this.dex.typeNames().get(this.currentClass.getTypeIndex());
    Object localObject = str;
    if (this.currentMethod != null)
    {
      localObject = (MethodId)this.dex.methodIds().get(this.currentMethod.getMethodIndex());
      localObject = str + "." + (String)this.dex.strings().get(((MethodId)localObject).getNameIndex());
    }
    return localObject;
  }
  
  public void findUsages()
  {
    if ((this.fieldIds == null) || (this.methodIds == null)) {
      return;
    }
    Iterator localIterator = this.dex.classDefs().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ClassDef)localIterator.next();
      this.currentClass = ((ClassDef)localObject);
      this.currentMethod = null;
      if (((ClassDef)localObject).getClassDataOffset() != 0)
      {
        localObject = this.dex.readClassData((ClassDef)localObject);
        ClassData.Field[] arrayOfField = ((ClassData)localObject).allFields();
        int j = arrayOfField.length;
        int i = 0;
        int k;
        while (i < j)
        {
          k = arrayOfField[i].getFieldIndex();
          if (this.fieldIds.contains(Integer.valueOf(k))) {
            this.out.println(location() + " field declared " + this.dex.fieldIds().get(k));
          }
          i += 1;
        }
        localObject = ((ClassData)localObject).allMethods();
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          arrayOfField = localObject[i];
          this.currentMethod = arrayOfField;
          k = arrayOfField.getMethodIndex();
          if (this.methodIds.contains(Integer.valueOf(k))) {
            this.out.println(location() + " method declared " + this.dex.methodIds().get(k));
          }
          if (arrayOfField.getCodeOffset() != 0) {
            this.codeReader.visitAll(this.dex.readCode(arrayOfField).getInstructions());
          }
          i += 1;
        }
      }
    }
    this.currentClass = null;
    this.currentMethod = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.findusages.FindUsages
 * JD-Core Version:    0.7.0.1
 */