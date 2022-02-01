package com.tencent.av.business.manager.magicface;

import com.tencent.av.business.manager.pendant.ItemBase;

public class FaceItem
  extends ItemBase
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
  private String version;
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
  
  public String getIconUrl()
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
  
  public String getResUrl()
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
  
  public String getVersion()
  {
    return this.version;
  }
  
  public int getVipLevel()
  {
    return this.vip_level;
  }
  
  public String getVoiceName()
  {
    String[] arrayOfString = this.voice_text;
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      return arrayOfString[0];
    }
    return null;
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
  
  public void setAttr(String paramString)
  {
    this.attr = paramString;
  }
  
  public void setCompressResMd5(String paramString)
  {
    this.compress_res_md5 = paramString;
  }
  
  public void setCompressResUrl(String paramString)
  {
    this.compress_res_url = paramString;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setIconUrl(String paramString)
  {
    this.icon_url = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setIsInteract(boolean paramBoolean)
  {
    this.is_interact = paramBoolean;
  }
  
  public void setIsshow(boolean paramBoolean)
  {
    this.isshow = paramBoolean;
  }
  
  public void setLastPositionIndex(int paramInt)
  {
    this.lastPositionIndex = paramInt;
  }
  
  public void setPeerdeconame1(String paramString)
  {
    this.peerdeconame1 = paramString;
  }
  
  public void setPlatform(int paramInt)
  {
    this.platform = paramInt;
  }
  
  public void setPredownload(boolean paramBoolean)
  {
    this.predownload = paramBoolean;
  }
  
  public void setResMd5(String paramString)
  {
    this.res_md5 = paramString;
  }
  
  public void setResUrl(String paramString)
  {
    this.res_url = paramString;
  }
  
  public void setSelfdeconame1(String paramString)
  {
    this.selfdeconame1 = paramString;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setUsable(boolean paramBoolean)
  {
    this.usable = paramBoolean;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public void setVipLevel(int paramInt)
  {
    this.vip_level = paramInt;
  }
  
  public void setVoiceText(String[] paramArrayOfString)
  {
    this.voice_text = paramArrayOfString;
  }
  
  public void setVoiceexpired(long paramLong)
  {
    this.voiceexpired = paramLong;
  }
  
  public String toString()
  {
    String[] arrayOfString = this.voice_text;
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (arrayOfString != null)
    {
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= this.voice_text.length) {
          break;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(this.voice_text[i]);
        ((StringBuilder)localObject2).append("|");
        localObject1 = ((StringBuilder)localObject2).toString();
        i += 1;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("FaceItem{id = ");
    ((StringBuilder)localObject1).append(this.id);
    ((StringBuilder)localObject1).append(", vip_level = ");
    ((StringBuilder)localObject1).append(this.vip_level);
    ((StringBuilder)localObject1).append(", text = ");
    ((StringBuilder)localObject1).append(this.text);
    ((StringBuilder)localObject1).append(", predownload = ");
    ((StringBuilder)localObject1).append(this.predownload);
    ((StringBuilder)localObject1).append(", res_url = ");
    ((StringBuilder)localObject1).append(this.res_url);
    ((StringBuilder)localObject1).append(", res_md5 = ");
    ((StringBuilder)localObject1).append(this.res_md5);
    ((StringBuilder)localObject1).append(", icon_url = ");
    ((StringBuilder)localObject1).append(this.icon_url);
    ((StringBuilder)localObject1).append(", peerdeconame1 = ");
    ((StringBuilder)localObject1).append(this.peerdeconame1);
    ((StringBuilder)localObject1).append(", selfdeconame1 = ");
    ((StringBuilder)localObject1).append(this.selfdeconame1);
    ((StringBuilder)localObject1).append(", type = ");
    ((StringBuilder)localObject1).append(this.type);
    ((StringBuilder)localObject1).append(", attr = ");
    ((StringBuilder)localObject1).append(this.attr);
    ((StringBuilder)localObject1).append(", is_interact = ");
    ((StringBuilder)localObject1).append(this.is_interact);
    ((StringBuilder)localObject1).append(", platform = ");
    ((StringBuilder)localObject1).append(this.platform);
    ((StringBuilder)localObject1).append(", usable = ");
    ((StringBuilder)localObject1).append(this.usable);
    ((StringBuilder)localObject1).append(", isshow = ");
    ((StringBuilder)localObject1).append(this.isshow);
    ((StringBuilder)localObject1).append(", voiceexpired = ");
    ((StringBuilder)localObject1).append(this.voiceexpired);
    ((StringBuilder)localObject1).append(", desc = ");
    ((StringBuilder)localObject1).append(this.desc);
    ((StringBuilder)localObject1).append(", voice_text = ");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(", isDownloading = ");
    ((StringBuilder)localObject1).append(this.isDownloading);
    ((StringBuilder)localObject1).append('}');
    return ((StringBuilder)localObject1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.FaceItem
 * JD-Core Version:    0.7.0.1
 */