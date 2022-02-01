package com.tencent.av.ui;

public class ControlUIObserver$RequestPlayMagicFace
  extends ControlUIObserver.CPreEventInfo
{
  public static int b;
  public static boolean c;
  public static String d;
  public final int a;
  public final boolean a;
  public final String c;
  
  public ControlUIObserver$RequestPlayMagicFace(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    super(6100, null);
    a(paramLong, null);
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    d = paramString;
    jdField_c_of_type_Boolean = paramBoolean;
    b = paramInt;
  }
  
  public String toString()
  {
    return "mId[" + this.jdField_c_of_type_JavaLangString + "], mFrom[" + this.jdField_a_of_type_Int + "], mSender[" + this.jdField_a_of_type_Boolean + "], seq[" + a() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.ControlUIObserver.RequestPlayMagicFace
 * JD-Core Version:    0.7.0.1
 */