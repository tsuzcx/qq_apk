package com.tencent.av.business.manager.magicface;

public class MagicfaceDataPendantJason
{
  public static final String BELONG_TO_BOTH = "both";
  public static final String BELONG_TO_RECEIVER = "reciever";
  public static final String BELONG_TO_SENDER = "sender";
  public static final String TRIGGER_HIT = "hit";
  public static final String TRIGGER_MISS = "miss";
  public String belongto = null;
  public int duration = 3;
  public boolean mirror = false;
  public String name = null;
  public int startframe = 0;
  public String trigger = null;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MagicfaceDataPendantJason{name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", belongto='");
    localStringBuilder.append(this.belongto);
    localStringBuilder.append('\'');
    localStringBuilder.append(", trigger='");
    localStringBuilder.append(this.trigger);
    localStringBuilder.append('\'');
    localStringBuilder.append(", startframe=");
    localStringBuilder.append(this.startframe);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.duration);
    localStringBuilder.append(", mirror=");
    localStringBuilder.append(this.mirror);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceDataPendantJason
 * JD-Core Version:    0.7.0.1
 */