package com.tencent.av.business.manager.magicface;

import com.tencent.av.business.manager.EffectConfigBase.ItemBase;

public class FaceItem
  extends EffectConfigBase.ItemBase
{
  private String attr;
  private String desc;
  private String icon_url;
  private String id;
  private boolean is_interact = true;
  private boolean isshow = true;
  private String peerdeconame1;
  private int platform;
  private boolean predownload;
  private String res_md5;
  private String res_url;
  private String selfdeconame1;
  private String text;
  private String type = "";
  private boolean usable;
  private int vip_level;
  private long voiceexpired;
  
  public String getAttr()
  {
    return this.attr;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getIconurl()
  {
    return this.icon_url;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getMd5()
  {
    return this.res_md5;
  }
  
  public int getPlatform()
  {
    return this.platform;
  }
  
  public String getResurl()
  {
    return this.res_url;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public int getVipLevel()
  {
    return this.vip_level;
  }
  
  public boolean isInteract()
  {
    return this.is_interact;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.FaceItem
 * JD-Core Version:    0.7.0.1
 */