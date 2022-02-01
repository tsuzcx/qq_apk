package com.android.dx.dex.file;

import com.android.dx.rop.annotation.Annotation;
import com.android.dx.rop.annotation.AnnotationVisibility;
import com.android.dx.rop.annotation.NameValuePair;
import com.android.dx.rop.cst.CstAnnotation;
import com.android.dx.rop.cst.CstArray;
import com.android.dx.rop.cst.CstArray.List;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import java.util.ArrayList;

public final class AnnotationUtils
{
  private static final CstString ACCESS_FLAGS_STRING = new CstString("accessFlags");
  private static final CstType ANNOTATION_DEFAULT_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/AnnotationDefault;"));
  private static final CstType ENCLOSING_CLASS_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/EnclosingClass;"));
  private static final CstType ENCLOSING_METHOD_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/EnclosingMethod;"));
  private static final CstType INNER_CLASS_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/InnerClass;"));
  private static final CstType MEMBER_CLASSES_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/MemberClasses;"));
  private static final CstString NAME_STRING = new CstString("name");
  private static final CstType SIGNATURE_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/Signature;"));
  private static final CstType THROWS_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/Throws;"));
  private static final CstString VALUE_STRING = new CstString("value");
  
  public static Annotation makeAnnotationDefault(Annotation paramAnnotation)
  {
    Annotation localAnnotation = new Annotation(ANNOTATION_DEFAULT_TYPE, AnnotationVisibility.SYSTEM);
    localAnnotation.put(new NameValuePair(VALUE_STRING, new CstAnnotation(paramAnnotation)));
    localAnnotation.setImmutable();
    return localAnnotation;
  }
  
  private static CstArray makeCstArray(TypeList paramTypeList)
  {
    int j = paramTypeList.size();
    CstArray.List localList = new CstArray.List(j);
    int i = 0;
    while (i < j)
    {
      localList.set(i, CstType.intern(paramTypeList.getType(i)));
      i += 1;
    }
    localList.setImmutable();
    return new CstArray(localList);
  }
  
  public static Annotation makeEnclosingClass(CstType paramCstType)
  {
    Annotation localAnnotation = new Annotation(ENCLOSING_CLASS_TYPE, AnnotationVisibility.SYSTEM);
    localAnnotation.put(new NameValuePair(VALUE_STRING, paramCstType));
    localAnnotation.setImmutable();
    return localAnnotation;
  }
  
  public static Annotation makeEnclosingMethod(CstMethodRef paramCstMethodRef)
  {
    Annotation localAnnotation = new Annotation(ENCLOSING_METHOD_TYPE, AnnotationVisibility.SYSTEM);
    localAnnotation.put(new NameValuePair(VALUE_STRING, paramCstMethodRef));
    localAnnotation.setImmutable();
    return localAnnotation;
  }
  
  public static Annotation makeInnerClass(CstString paramCstString, int paramInt)
  {
    Annotation localAnnotation = new Annotation(INNER_CLASS_TYPE, AnnotationVisibility.SYSTEM);
    if (paramCstString != null) {}
    for (;;)
    {
      localAnnotation.put(new NameValuePair(NAME_STRING, paramCstString));
      localAnnotation.put(new NameValuePair(ACCESS_FLAGS_STRING, CstInteger.make(paramInt)));
      localAnnotation.setImmutable();
      return localAnnotation;
      paramCstString = CstKnownNull.THE_ONE;
    }
  }
  
  public static Annotation makeMemberClasses(TypeList paramTypeList)
  {
    paramTypeList = makeCstArray(paramTypeList);
    Annotation localAnnotation = new Annotation(MEMBER_CLASSES_TYPE, AnnotationVisibility.SYSTEM);
    localAnnotation.put(new NameValuePair(VALUE_STRING, paramTypeList));
    localAnnotation.setImmutable();
    return localAnnotation;
  }
  
  public static Annotation makeSignature(CstString paramCstString)
  {
    int m = 0;
    Annotation localAnnotation = new Annotation(SIGNATURE_TYPE, AnnotationVisibility.SYSTEM);
    Object localObject = paramCstString.getString();
    int n = ((String)localObject).length();
    paramCstString = new ArrayList(20);
    int k = 0;
    if (k < n)
    {
      int i1 = ((String)localObject).charAt(k);
      i = k + 1;
      j = i;
      if (i1 == 76)
      {
        j = i;
        label72:
        i = j;
        if (j < n)
        {
          i1 = ((String)localObject).charAt(j);
          if (i1 != 59) {
            break label116;
          }
          i = j + 1;
        }
      }
      for (;;)
      {
        paramCstString.add(((String)localObject).substring(k, i));
        k = i;
        break;
        label116:
        i = j;
        if (i1 != 60)
        {
          j += 1;
          break label72;
          do
          {
            j += 1;
            i = j;
            if (j >= n) {
              break;
            }
          } while (((String)localObject).charAt(j) != 'L');
          i = j;
        }
      }
    }
    int j = paramCstString.size();
    localObject = new CstArray.List(j);
    int i = m;
    while (i < j)
    {
      ((CstArray.List)localObject).set(i, new CstString((String)paramCstString.get(i)));
      i += 1;
    }
    ((CstArray.List)localObject).setImmutable();
    localAnnotation.put(new NameValuePair(VALUE_STRING, new CstArray((CstArray.List)localObject)));
    localAnnotation.setImmutable();
    return localAnnotation;
  }
  
  public static Annotation makeThrows(TypeList paramTypeList)
  {
    paramTypeList = makeCstArray(paramTypeList);
    Annotation localAnnotation = new Annotation(THROWS_TYPE, AnnotationVisibility.SYSTEM);
    localAnnotation.put(new NameValuePair(VALUE_STRING, paramTypeList));
    localAnnotation.setImmutable();
    return localAnnotation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.AnnotationUtils
 * JD-Core Version:    0.7.0.1
 */