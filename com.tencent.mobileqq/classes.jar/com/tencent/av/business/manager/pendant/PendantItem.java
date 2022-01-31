package com.tencent.av.business.manager.pendant;

import com.tencent.av.business.manager.EffectConfigBase.ItemBase;

public class PendantItem
  extends EffectConfigBase.ItemBase
{
  public static final int Category_Face = 0;
  public static final int Category_FaceAndGesture = 2;
  public static final int Category_Gesture = 1;
  private int category;
  private String desc;
  private String filtername;
  private String gestureType;
  private String gestureWording;
  private String iconurl;
  private String id;
  private boolean isshow = true;
  private String md5;
  private String name = "";
  private int platform;
  private boolean predownload;
  private boolean renderfirst = true;
  private String resurl;
  private int type;
  private boolean usable;
  private int voiceid;
  
  public static boolean isFace(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 0);
  }
  
  public static boolean isGesture(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1);
  }
  
  public int getCategory()
  {
    return this.category;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getFilterName()
  {
    return this.filtername;
  }
  
  public String getGestureType()
  {
    return this.gestureType;
  }
  
  public String getGestureWording()
  {
    return this.gestureWording;
  }
  
  public String getIconurl()
  {
    return this.iconurl;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getPlatform()
  {
    return this.platform;
  }
  
  public boolean getRenderFirst()
  {
    return this.renderfirst;
  }
  
  public String getResurl()
  {
    return this.resurl;
  }
  
  public int getVoiceId()
  {
    return this.voiceid;
  }
  
  public boolean hasFace()
  {
    return isFace(this.category);
  }
  
  public boolean hasGesture()
  {
    return isGesture(this.category);
  }
  
  public boolean isShow()
  {
    return this.isshow;
  }
  
  public boolean isUsable()
  {
    return this.usable;
  }
  
  public void setUsable(boolean paramBoolean)
  {
    this.usable = paramBoolean;
  }
  
  public String toString()
  {
    return "id[" + this.id + "], name[" + this.name + "], type[" + this.type + "], category[" + this.category + "], gestureType[" + this.gestureType + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.PendantItem
 * JD-Core Version:    0.7.0.1
 */