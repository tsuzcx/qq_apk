package com.android.dx.command.grep;

import com.android.dex.ClassData;
import com.android.dex.ClassData.Method;
import com.android.dex.ClassDef;
import com.android.dex.Code;
import com.android.dex.Dex;
import com.android.dex.EncodedValueReader;
import com.android.dex.MethodId;
import com.android.dx.io.CodeReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Grep
{
  private final CodeReader codeReader = new CodeReader();
  private int count = 0;
  private ClassDef currentClass;
  private ClassData.Method currentMethod;
  private final Dex dex;
  private final PrintWriter out;
  private final Set<Integer> stringIds;
  
  public Grep(Dex paramDex, Pattern paramPattern, PrintWriter paramPrintWriter)
  {
    this.dex = paramDex;
    this.out = paramPrintWriter;
    this.stringIds = getStringIds(paramDex, paramPattern);
    this.codeReader.setStringVisitor(new Grep.1(this));
  }
  
  private void encounterString(int paramInt)
  {
    if (this.stringIds.contains(Integer.valueOf(paramInt)))
    {
      this.out.println(location() + " " + (String)this.dex.strings().get(paramInt));
      this.count += 1;
    }
  }
  
  private Set<Integer> getStringIds(Dex paramDex, Pattern paramPattern)
  {
    HashSet localHashSet = new HashSet();
    paramDex = paramDex.strings().iterator();
    int i = 0;
    while (paramDex.hasNext())
    {
      if (paramPattern.matcher((String)paramDex.next()).find()) {
        localHashSet.add(Integer.valueOf(i));
      }
      i += 1;
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
  
  private void readArray(EncodedValueReader paramEncodedValueReader)
  {
    int i = 0;
    int j = paramEncodedValueReader.readArray();
    if (i < j)
    {
      switch (paramEncodedValueReader.peek())
      {
      }
      for (;;)
      {
        i += 1;
        break;
        encounterString(paramEncodedValueReader.readString());
        continue;
        readArray(paramEncodedValueReader);
      }
    }
  }
  
  public int grep()
  {
    Iterator localIterator = this.dex.classDefs().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ClassDef)localIterator.next();
      this.currentClass = ((ClassDef)localObject);
      this.currentMethod = null;
      if (((ClassDef)localObject).getClassDataOffset() != 0)
      {
        ClassData localClassData = this.dex.readClassData((ClassDef)localObject);
        int i = ((ClassDef)localObject).getStaticValuesOffset();
        if (i != 0) {
          readArray(new EncodedValueReader(this.dex.open(i)));
        }
        localObject = localClassData.allMethods();
        int j = localObject.length;
        i = 0;
        while (i < j)
        {
          localClassData = localObject[i];
          this.currentMethod = localClassData;
          if (localClassData.getCodeOffset() != 0) {
            this.codeReader.visitAll(this.dex.readCode(localClassData).getInstructions());
          }
          i += 1;
        }
      }
    }
    this.currentClass = null;
    this.currentMethod = null;
    return this.count;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.grep.Grep
 * JD-Core Version:    0.7.0.1
 */