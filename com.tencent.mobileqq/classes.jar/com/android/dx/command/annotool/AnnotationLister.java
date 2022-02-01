package com.android.dx.command.annotool;

import com.android.dx.cf.attrib.BaseAnnotations;
import com.android.dx.cf.direct.ClassPathOpener;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.rop.annotation.Annotation;
import com.android.dx.rop.annotation.Annotations;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import java.io.PrintStream;
import java.lang.annotation.ElementType;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;

class AnnotationLister
{
  private static final String PACKAGE_INFO = "package-info";
  private final Main.Arguments args;
  HashSet<String> matchInnerClassesOf = new HashSet();
  HashSet<String> matchPackages = new HashSet();
  
  AnnotationLister(Main.Arguments paramArguments)
  {
    this.args = paramArguments;
  }
  
  private boolean isMatchingInnerClass(String paramString)
  {
    boolean bool2 = false;
    String str;
    do
    {
      int i = paramString.lastIndexOf('$');
      bool1 = bool2;
      if (i <= 0) {
        break;
      }
      str = paramString.substring(0, i);
      paramString = str;
    } while (!this.matchInnerClassesOf.contains(str));
    boolean bool1 = true;
    return bool1;
  }
  
  private boolean isMatchingPackage(String paramString)
  {
    int i = paramString.lastIndexOf('/');
    if (i == -1) {}
    for (paramString = "";; paramString = paramString.substring(0, i)) {
      return this.matchPackages.contains(paramString);
    }
  }
  
  private void printMatch(DirectClassFile paramDirectClassFile)
  {
    Iterator localIterator = this.args.printTypes.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Main.PrintType)localIterator.next();
      switch (AnnotationLister.2.$SwitchMap$com$android$dx$command$annotool$Main$PrintType[localObject.ordinal()])
      {
      case 3: 
      default: 
        break;
      case 1: 
        localObject = paramDirectClassFile.getThisClass().getClassType().getClassName().replace('/', '.');
        System.out.println((String)localObject);
        break;
      case 2: 
        this.matchInnerClassesOf.add(paramDirectClassFile.getThisClass().getClassType().getClassName());
      }
    }
  }
  
  private void printMatchPackage(String paramString)
  {
    Iterator localIterator = this.args.printTypes.iterator();
    while (localIterator.hasNext())
    {
      Main.PrintType localPrintType = (Main.PrintType)localIterator.next();
      switch (AnnotationLister.2.$SwitchMap$com$android$dx$command$annotool$Main$PrintType[localPrintType.ordinal()])
      {
      default: 
        break;
      case 1: 
      case 2: 
      case 3: 
        this.matchPackages.add(paramString);
        break;
      case 4: 
        System.out.println(paramString.replace('/', '.'));
      }
    }
  }
  
  private void visitClassAnnotation(DirectClassFile paramDirectClassFile, BaseAnnotations paramBaseAnnotations)
  {
    if (!this.args.eTypes.contains(ElementType.TYPE)) {}
    for (;;)
    {
      return;
      paramBaseAnnotations = paramBaseAnnotations.getAnnotations().getAnnotations().iterator();
      while (paramBaseAnnotations.hasNext())
      {
        String str = ((Annotation)paramBaseAnnotations.next()).getType().getClassType().getClassName();
        if (this.args.aclass.equals(str)) {
          printMatch(paramDirectClassFile);
        }
      }
    }
  }
  
  private void visitPackageAnnotation(DirectClassFile paramDirectClassFile, BaseAnnotations paramBaseAnnotations)
  {
    if (!this.args.eTypes.contains(ElementType.PACKAGE)) {
      return;
    }
    paramDirectClassFile = paramDirectClassFile.getThisClass().getClassType().getClassName();
    int i = paramDirectClassFile.lastIndexOf('/');
    if (i == -1) {}
    for (paramDirectClassFile = "";; paramDirectClassFile = paramDirectClassFile.substring(0, i))
    {
      paramBaseAnnotations = paramBaseAnnotations.getAnnotations().getAnnotations().iterator();
      while (paramBaseAnnotations.hasNext())
      {
        String str = ((Annotation)paramBaseAnnotations.next()).getType().getClassType().getClassName();
        if (this.args.aclass.equals(str)) {
          printMatchPackage(paramDirectClassFile);
        }
      }
      break;
    }
  }
  
  void process()
  {
    String[] arrayOfString = this.args.files;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      new ClassPathOpener(arrayOfString[i], true, new AnnotationLister.1(this)).process();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.annotool.AnnotationLister
 * JD-Core Version:    0.7.0.1
 */