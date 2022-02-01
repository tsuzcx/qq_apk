package com.tencent.av.ui;

public class ControlUIObserver$RequestPlayMagicFace
  extends ControlUIObserver.CPreEventInfo
{
  public static int b;
  public static boolean c;
  public static String d;
  public final int a;
  public final boolean b;
  public final String c;
  
  public ControlUIObserver$RequestPlayMagicFace(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    super(6100, null);
    a(paramLong, null);
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.a = paramInt;
    d = paramString;
    jdField_c_of_type_Boolean = paramBoolean;
    jdField_b_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mId[");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("], mFrom[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], mSender[");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(a());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ControlUIObserver.RequestPlayMagicFace
 * JD-Core Version:    0.7.0.1
 */