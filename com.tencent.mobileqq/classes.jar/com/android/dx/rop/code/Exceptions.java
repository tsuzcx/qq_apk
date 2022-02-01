package com.android.dx.rop.code;

import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;

public final class Exceptions
{
  public static final StdTypeList LIST_Error = StdTypeList.make(TYPE_Error);
  public static final StdTypeList LIST_Error_ArithmeticException = StdTypeList.make(TYPE_Error, TYPE_ArithmeticException);
  public static final StdTypeList LIST_Error_ClassCastException = StdTypeList.make(TYPE_Error, TYPE_ClassCastException);
  public static final StdTypeList LIST_Error_NegativeArraySizeException = StdTypeList.make(TYPE_Error, TYPE_NegativeArraySizeException);
  public static final StdTypeList LIST_Error_NullPointerException = StdTypeList.make(TYPE_Error, TYPE_NullPointerException);
  public static final StdTypeList LIST_Error_Null_ArrayIndexOutOfBounds = StdTypeList.make(TYPE_Error, TYPE_NullPointerException, TYPE_ArrayIndexOutOfBoundsException);
  public static final StdTypeList LIST_Error_Null_ArrayIndex_ArrayStore = StdTypeList.make(TYPE_Error, TYPE_NullPointerException, TYPE_ArrayIndexOutOfBoundsException, TYPE_ArrayStoreException);
  public static final StdTypeList LIST_Error_Null_IllegalMonitorStateException = StdTypeList.make(TYPE_Error, TYPE_NullPointerException, TYPE_IllegalMonitorStateException);
  public static final Type TYPE_ArithmeticException = Type.intern("Ljava/lang/ArithmeticException;");
  public static final Type TYPE_ArrayIndexOutOfBoundsException = Type.intern("Ljava/lang/ArrayIndexOutOfBoundsException;");
  public static final Type TYPE_ArrayStoreException = Type.intern("Ljava/lang/ArrayStoreException;");
  public static final Type TYPE_ClassCastException = Type.intern("Ljava/lang/ClassCastException;");
  public static final Type TYPE_Error = Type.intern("Ljava/lang/Error;");
  public static final Type TYPE_IllegalMonitorStateException = Type.intern("Ljava/lang/IllegalMonitorStateException;");
  public static final Type TYPE_NegativeArraySizeException = Type.intern("Ljava/lang/NegativeArraySizeException;");
  public static final Type TYPE_NullPointerException = Type.intern("Ljava/lang/NullPointerException;");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.Exceptions
 * JD-Core Version:    0.7.0.1
 */