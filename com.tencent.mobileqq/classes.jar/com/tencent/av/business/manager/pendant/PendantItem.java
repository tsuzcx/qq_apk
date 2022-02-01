package com.tencent.av.business.manager.pendant;

public class PendantItem
  extends ItemBase
{
  public static final int CATEGORY_BEAUTY_MAKEUP = 3;
  public static final int CATEGORY_FACE = 0;
  public static final int CATEGORY_FACE_AND_GESTURE = 2;
  public static final int CATEGORY_GESTURE = 1;
  private int category;
  private String desc;
  public Object extraParam = null;
  private String filtername;
  private String gestureType;
  private String gestureWording;
  private String iconurl;
  private String id;
  private boolean isshow = true;
  private int kind;
  private String md5;
  private String name = "";
  public boolean needHMirror = false;
  private int platform;
  private boolean predownload;
  private String resurl;
  private int type;
  private boolean usable;
  private String version;
  private int voiceid = 0;
  
  public static boolean isBeautyMakeup(int paramInt)
  {
    return paramInt == 3;
  }
  
  public static boolean isFace(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 0);
  }
  
  public static boolean isGesture(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 2)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean isOnlySupportOldFilter(int paramInt)
  {
    return 22 == paramInt;
  }
  
  public static boolean isPanorama(int paramInt)
  {
    return 7 == paramInt;
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
  
  public String getIconUrl()
  {
    return this.iconurl;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public int getKind()
  {
    return this.kind;
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
  
  public String getResUrl()
  {
    return this.resurl;
  }
  
  public String getVersion()
  {
    return this.version;
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
  
  public void setCategory(int paramInt)
  {
    this.category = paramInt;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setFiltername(String paramString)
  {
    this.filtername = paramString;
  }
  
  public void setGestureType(String paramString)
  {
    this.gestureType = paramString;
  }
  
  public void setGestureWording(String paramString)
  {
    this.gestureWording = paramString;
  }
  
  public void setIconurl(String paramString)
  {
    this.iconurl = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setIsshow(boolean paramBoolean)
  {
    this.isshow = paramBoolean;
  }
  
  public void setKind(int paramInt)
  {
    this.kind = paramInt;
  }
  
  public void setMd5(String paramString)
  {
    this.md5 = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPlatform(int paramInt)
  {
    this.platform = paramInt;
  }
  
  public void setPredownload(boolean paramBoolean)
  {
    this.predownload = paramBoolean;
  }
  
  public void setResurl(String paramString)
  {
    this.resurl = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setUsable(boolean paramBoolean)
  {
    this.usable = paramBoolean;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id[");
    localStringBuilder.append(this.id);
    localStringBuilder.append("], name[");
    localStringBuilder.append(this.name);
    localStringBuilder.append("], type[");
    localStringBuilder.append(this.type);
    localStringBuilder.append("], category[");
    localStringBuilder.append(this.category);
    localStringBuilder.append("], gestureType[");
    localStringBuilder.append(this.gestureType);
    localStringBuilder.append("], kind[");
    localStringBuilder.append(this.kind);
    localStringBuilder.append("], isDownloading[");
    localStringBuilder.append(this.isDownloading);
    localStringBuilder.append("], extraParam[");
    localStringBuilder.append(this.extraParam);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.PendantItem
 * JD-Core Version:    0.7.0.1
 */