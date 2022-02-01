package com.tencent.av.business.manager.magicface;

import lgl;

public class FaceItem
  extends lgl
{
  private String attr;
  private String compress_res_md5;
  private String compress_res_url;
  private String desc;
  private String icon_url;
  private String id;
  private boolean is_interact = true;
  private boolean isshow = true;
  public int lastPositionIndex = -1;
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
  public String[] voice_text;
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
  
  public boolean getPredownload()
  {
    return this.predownload;
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
  
  public String getVoiceName()
  {
    if ((this.voice_text != null) && (this.voice_text.length > 0)) {
      return this.voice_text[0];
    }
    return null;
  }
  
  public boolean isInCreative()
  {
    return this.type.equalsIgnoreCase("creativecop");
  }
  
  public boolean isInteract()
  {
    return this.is_interact;
  }
  
  public boolean isSameType(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.equalsIgnoreCase(this.type);
  }
  
  public boolean isShow()
  {
    return this.isshow;
  }
  
  public boolean isUsable()
  {
    return this.usable;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setUsable(boolean paramBoolean)
  {
    this.usable = paramBoolean;
  }
  
  public String toString()
  {
    String str1 = "";
    String str2 = str1;
    if (this.voice_text != null)
    {
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= this.voice_text.length) {
          break;
        }
        str1 = str1 + this.voice_text[i] + "|";
        i += 1;
      }
    }
    return "FaceItem{id = " + this.id + ", vip_level = " + this.vip_level + ", text = " + this.text + ", predownload = " + this.predownload + ", res_url = " + this.res_url + ", res_md5 = " + this.res_md5 + ", icon_url = " + this.icon_url + ", peerdeconame1 = " + this.peerdeconame1 + ", selfdeconame1 = " + this.selfdeconame1 + ", type = " + this.type + ", attr = " + this.attr + ", is_interact = " + this.is_interact + ", platform = " + this.platform + ", usable = " + this.usable + ", isshow = " + this.isshow + ", voiceexpired = " + this.voiceexpired + ", desc = " + this.desc + ", voice_text = " + str2 + ", isDownloading = " + this.isDownloading + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.FaceItem
 * JD-Core Version:    0.7.0.1
 */