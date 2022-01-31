package com.tencent.av.business.manager.magicface;

public class MagicfaceDataPendantJason
{
  public static final String BELONG_TO_BOTH = "both";
  public static final String BELONG_TO_RECEIVER = "reciever";
  public static final String BELONG_TO_SENDER = "sender";
  public static final String TRIGGER_HIT = "hit";
  public static final String TRIGGER_MISS = "miss";
  public String belongto;
  public int duration = 3;
  public boolean mirror;
  public String name;
  public int startframe;
  public String trigger;
  
  public String toString()
  {
    return "MagicfaceDataPendantJason{name='" + this.name + '\'' + ", belongto='" + this.belongto + '\'' + ", trigger='" + this.trigger + '\'' + ", startframe=" + this.startframe + ", duration=" + this.duration + ", mirror=" + this.mirror + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceDataPendantJason
 * JD-Core Version:    0.7.0.1
 */