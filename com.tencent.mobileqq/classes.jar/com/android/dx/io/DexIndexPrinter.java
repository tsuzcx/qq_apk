package com.android.dx.io;

import com.android.dex.ClassDef;
import com.android.dex.Dex;
import com.android.dex.Dex.Section;
import com.android.dex.FieldId;
import com.android.dex.MethodId;
import com.android.dex.ProtoId;
import com.android.dex.TableOfContents;
import com.android.dex.TableOfContents.Section;
import java.io.File;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

public final class DexIndexPrinter
{
  private final Dex dex;
  private final TableOfContents tableOfContents;
  
  public DexIndexPrinter(File paramFile)
  {
    this.dex = new Dex(paramFile);
    this.tableOfContents = this.dex.getTableOfContents();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    paramArrayOfString = new DexIndexPrinter(new File(paramArrayOfString[0]));
    paramArrayOfString.printMap();
    paramArrayOfString.printStrings();
    paramArrayOfString.printTypeIds();
    paramArrayOfString.printProtoIds();
    paramArrayOfString.printFieldIds();
    paramArrayOfString.printMethodIds();
    paramArrayOfString.printTypeLists();
    paramArrayOfString.printClassDefs();
  }
  
  private void printClassDefs()
  {
    Iterator localIterator = this.dex.classDefs().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ClassDef localClassDef = (ClassDef)localIterator.next();
      System.out.println("class def " + i + ": " + localClassDef);
      i += 1;
    }
  }
  
  private void printFieldIds()
  {
    Iterator localIterator = this.dex.fieldIds().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      FieldId localFieldId = (FieldId)localIterator.next();
      System.out.println("field " + i + ": " + localFieldId);
      i += 1;
    }
  }
  
  private void printMap()
  {
    TableOfContents.Section[] arrayOfSection = this.tableOfContents.sections;
    int j = arrayOfSection.length;
    int i = 0;
    while (i < j)
    {
      TableOfContents.Section localSection = arrayOfSection[i];
      if (localSection.off != -1) {
        System.out.println("section " + Integer.toHexString(localSection.type) + " off=" + Integer.toHexString(localSection.off) + " size=" + Integer.toHexString(localSection.size) + " byteCount=" + Integer.toHexString(localSection.byteCount));
      }
      i += 1;
    }
  }
  
  private void printMethodIds()
  {
    Iterator localIterator = this.dex.methodIds().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      MethodId localMethodId = (MethodId)localIterator.next();
      System.out.println("methodId " + i + ": " + localMethodId);
      i += 1;
    }
  }
  
  private void printProtoIds()
  {
    Iterator localIterator = this.dex.protoIds().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ProtoId localProtoId = (ProtoId)localIterator.next();
      System.out.println("proto " + i + ": " + localProtoId);
      i += 1;
    }
  }
  
  private void printStrings()
  {
    Iterator localIterator = this.dex.strings().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      System.out.println("string " + i + ": " + str);
      i += 1;
    }
  }
  
  private void printTypeIds()
  {
    Iterator localIterator = this.dex.typeIds().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      System.out.println("type " + i + ": " + (String)this.dex.strings().get(localInteger.intValue()));
      i += 1;
    }
  }
  
  private void printTypeLists()
  {
    if (this.tableOfContents.typeLists.off == -1) {
      System.out.println("No type lists");
    }
    for (;;)
    {
      return;
      Dex.Section localSection = this.dex.open(this.tableOfContents.typeLists.off);
      int i = 0;
      while (i < this.tableOfContents.typeLists.size)
      {
        int k = localSection.readInt();
        System.out.print("Type list i=" + i + ", size=" + k + ", elements=");
        int j = 0;
        while (j < k)
        {
          System.out.print(" " + (String)this.dex.typeNames().get(localSection.readShort()));
          j += 1;
        }
        if (k % 2 == 1) {
          localSection.readShort();
        }
        System.out.println();
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.DexIndexPrinter
 * JD-Core Version:    0.7.0.1
 */