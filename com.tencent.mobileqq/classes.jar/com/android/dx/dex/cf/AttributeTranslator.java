package com.android.dx.dex.cf;

import com.android.dx.cf.attrib.AttAnnotationDefault;
import com.android.dx.cf.attrib.AttEnclosingMethod;
import com.android.dx.cf.attrib.AttExceptions;
import com.android.dx.cf.attrib.AttInnerClasses;
import com.android.dx.cf.attrib.AttRuntimeInvisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeInvisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttSignature;
import com.android.dx.cf.attrib.InnerClassList;
import com.android.dx.cf.attrib.InnerClassList.Item;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.Method;
import com.android.dx.cf.iface.MethodList;
import com.android.dx.dex.file.AnnotationUtils;
import com.android.dx.rop.annotation.Annotation;
import com.android.dx.rop.annotation.AnnotationVisibility;
import com.android.dx.rop.annotation.Annotations;
import com.android.dx.rop.annotation.AnnotationsList;
import com.android.dx.rop.annotation.NameValuePair;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.Warning;
import java.io.PrintStream;
import java.util.ArrayList;

class AttributeTranslator
{
  public static Annotations getAnnotations(AttributeList paramAttributeList)
  {
    Annotations localAnnotations = getAnnotations0(paramAttributeList);
    Annotation localAnnotation = getSignature(paramAttributeList);
    paramAttributeList = localAnnotations;
    if (localAnnotation != null) {
      paramAttributeList = Annotations.combine(localAnnotations, localAnnotation);
    }
    return paramAttributeList;
  }
  
  private static Annotations getAnnotations0(AttributeList paramAttributeList)
  {
    AttRuntimeVisibleAnnotations localAttRuntimeVisibleAnnotations = (AttRuntimeVisibleAnnotations)paramAttributeList.findFirst("RuntimeVisibleAnnotations");
    paramAttributeList = (AttRuntimeInvisibleAnnotations)paramAttributeList.findFirst("RuntimeInvisibleAnnotations");
    if (localAttRuntimeVisibleAnnotations == null)
    {
      if (paramAttributeList == null) {
        return Annotations.EMPTY;
      }
      return paramAttributeList.getAnnotations();
    }
    if (paramAttributeList == null) {
      return localAttRuntimeVisibleAnnotations.getAnnotations();
    }
    return Annotations.combine(localAttRuntimeVisibleAnnotations.getAnnotations(), paramAttributeList.getAnnotations());
  }
  
  public static Annotations getClassAnnotations(DirectClassFile paramDirectClassFile, CfOptions paramCfOptions)
  {
    Object localObject1 = paramDirectClassFile.getThisClass();
    Object localObject3 = paramDirectClassFile.getAttributes();
    localAnnotations = getAnnotations((AttributeList)localObject3);
    Annotation localAnnotation = translateEnclosingMethod((AttributeList)localObject3);
    if (localAnnotation == null) {}
    for (boolean bool = true;; bool = false)
    {
      try
      {
        localObject3 = translateInnerClasses((CstType)localObject1, (AttributeList)localObject3, bool);
        localObject1 = localAnnotations;
        if (localObject3 != null) {
          localObject1 = Annotations.combine(localAnnotations, (Annotations)localObject3);
        }
      }
      catch (Warning localWarning)
      {
        for (;;)
        {
          paramCfOptions.warn.println("warning: " + localWarning.getMessage());
          Object localObject2 = localAnnotations;
        }
      }
      paramCfOptions = (CfOptions)localObject1;
      if (localAnnotation != null) {
        paramCfOptions = Annotations.combine((Annotations)localObject1, localAnnotation);
      }
      localObject1 = paramCfOptions;
      if (AccessFlags.isAnnotation(paramDirectClassFile.getAccessFlags()))
      {
        paramDirectClassFile = translateAnnotationDefaults(paramDirectClassFile);
        localObject1 = paramCfOptions;
        if (paramDirectClassFile != null) {
          localObject1 = Annotations.combine(paramCfOptions, paramDirectClassFile);
        }
      }
      return localObject1;
    }
  }
  
  public static TypeList getExceptions(Method paramMethod)
  {
    paramMethod = (AttExceptions)paramMethod.getAttributes().findFirst("Exceptions");
    if (paramMethod == null) {
      return StdTypeList.EMPTY;
    }
    return paramMethod.getExceptions();
  }
  
  public static Annotations getMethodAnnotations(Method paramMethod)
  {
    Annotations localAnnotations = getAnnotations(paramMethod.getAttributes());
    TypeList localTypeList = getExceptions(paramMethod);
    paramMethod = localAnnotations;
    if (localTypeList.size() != 0) {
      paramMethod = Annotations.combine(localAnnotations, AnnotationUtils.makeThrows(localTypeList));
    }
    return paramMethod;
  }
  
  public static AnnotationsList getParameterAnnotations(Method paramMethod)
  {
    Object localObject = paramMethod.getAttributes();
    paramMethod = (AttRuntimeVisibleParameterAnnotations)((AttributeList)localObject).findFirst("RuntimeVisibleParameterAnnotations");
    localObject = (AttRuntimeInvisibleParameterAnnotations)((AttributeList)localObject).findFirst("RuntimeInvisibleParameterAnnotations");
    if (paramMethod == null)
    {
      if (localObject == null) {
        return AnnotationsList.EMPTY;
      }
      return ((AttRuntimeInvisibleParameterAnnotations)localObject).getParameterAnnotations();
    }
    if (localObject == null) {
      return paramMethod.getParameterAnnotations();
    }
    return AnnotationsList.combine(paramMethod.getParameterAnnotations(), ((AttRuntimeInvisibleParameterAnnotations)localObject).getParameterAnnotations());
  }
  
  private static Annotation getSignature(AttributeList paramAttributeList)
  {
    paramAttributeList = (AttSignature)paramAttributeList.findFirst("Signature");
    if (paramAttributeList == null) {
      return null;
    }
    return AnnotationUtils.makeSignature(paramAttributeList.getSignature());
  }
  
  private static Annotation translateAnnotationDefaults(DirectClassFile paramDirectClassFile)
  {
    Object localObject = paramDirectClassFile.getThisClass();
    paramDirectClassFile = paramDirectClassFile.getMethods();
    int k = paramDirectClassFile.size();
    localObject = new Annotation((CstType)localObject, AnnotationVisibility.EMBEDDED);
    int j = 0;
    int i = 0;
    if (j < k)
    {
      Method localMethod = paramDirectClassFile.get(j);
      AttAnnotationDefault localAttAnnotationDefault = (AttAnnotationDefault)localMethod.getAttributes().findFirst("AnnotationDefault");
      if (localAttAnnotationDefault == null) {
        break label127;
      }
      ((Annotation)localObject).add(new NameValuePair(localMethod.getNat().getName(), localAttAnnotationDefault.getValue()));
      i = 1;
    }
    label127:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        return null;
      }
      ((Annotation)localObject).setImmutable();
      return AnnotationUtils.makeAnnotationDefault((Annotation)localObject);
    }
  }
  
  private static Annotation translateEnclosingMethod(AttributeList paramAttributeList)
  {
    Object localObject = (AttEnclosingMethod)paramAttributeList.findFirst("EnclosingMethod");
    if (localObject == null) {
      return null;
    }
    paramAttributeList = ((AttEnclosingMethod)localObject).getEnclosingClass();
    localObject = ((AttEnclosingMethod)localObject).getMethod();
    if (localObject == null) {
      return AnnotationUtils.makeEnclosingClass(paramAttributeList);
    }
    return AnnotationUtils.makeEnclosingMethod(new CstMethodRef(paramAttributeList, (CstNat)localObject));
  }
  
  private static Annotations translateInnerClasses(CstType paramCstType, AttributeList paramAttributeList, boolean paramBoolean)
  {
    paramAttributeList = (AttInnerClasses)paramAttributeList.findFirst("InnerClasses");
    if (paramAttributeList == null) {
      return null;
    }
    InnerClassList localInnerClassList = paramAttributeList.getInnerClasses();
    int j = localInnerClassList.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    paramAttributeList = null;
    if (i < j)
    {
      localObject = localInnerClassList.get(i);
      CstType localCstType = ((InnerClassList.Item)localObject).getInnerClass();
      if (localCstType.equals(paramCstType)) {
        paramAttributeList = (AttributeList)localObject;
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramCstType.equals(((InnerClassList.Item)localObject).getOuterClass())) {
          localArrayList.add(localCstType.getClassType());
        }
      }
    }
    j = localArrayList.size();
    if ((paramAttributeList == null) && (j == 0)) {
      return null;
    }
    Object localObject = new Annotations();
    if (paramAttributeList != null)
    {
      ((Annotations)localObject).add(AnnotationUtils.makeInnerClass(paramAttributeList.getInnerName(), paramAttributeList.getAccessFlags()));
      if (paramBoolean)
      {
        if (paramAttributeList.getOuterClass() == null) {
          throw new Warning("Ignoring InnerClasses attribute for an anonymous inner class\n(" + paramCstType.toHuman() + ") that doesn't come with an\nassociated EnclosingMethod attribute. This class was probably produced by a\ncompiler that did not target the modern .class file format. The recommended\nsolution is to recompile the class from source, using an up-to-date compiler\nand without specifying any \"-target\" type options. The consequence of ignoring\nthis warning is that reflective operations on this class will incorrectly\nindicate that it is *not* an inner class.");
        }
        ((Annotations)localObject).add(AnnotationUtils.makeEnclosingClass(paramAttributeList.getOuterClass()));
      }
    }
    if (j != 0)
    {
      paramCstType = new StdTypeList(j);
      i = 0;
      while (i < j)
      {
        paramCstType.set(i, (Type)localArrayList.get(i));
        i += 1;
      }
      paramCstType.setImmutable();
      ((Annotations)localObject).add(AnnotationUtils.makeMemberClasses(paramCstType));
    }
    ((Annotations)localObject).setImmutable();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.cf.AttributeTranslator
 * JD-Core Version:    0.7.0.1
 */