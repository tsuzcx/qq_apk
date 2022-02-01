package com.tencent.av.ui;

public class ControlUIObserver$RequestPlayMagicFace
  extends ControlUIObserver.CPreEventInfo
{
  public static String g;
  public static boolean h;
  public static int i;
  public final String b;
  public final boolean c;
  public final int f;
  
  public ControlUIObserver$RequestPlayMagicFace(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    super(6100, null);
    a(paramLong, null);
    this.b = paramString;
    this.c = paramBoolean;
    this.f = paramInt;
    g = paramString;
    h = paramBoolean;
    i = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mId[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], mFrom[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("], mSender[");
    localStringBuilder.append(this.c);
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