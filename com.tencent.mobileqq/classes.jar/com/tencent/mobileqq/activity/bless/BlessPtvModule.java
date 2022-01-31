package com.tencent.mobileqq.activity.bless;

import aepi;
import alud;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import arso;
import awge;
import awhs;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.File;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="id")
public class BlessPtvModule
  extends awge
{
  public static final String DEFAULT_MODULE_ID = "0";
  public static final String DEFAULT_MODULE_TITLE = alud.a(2131701542);
  public static final String DEFAULT_VIP_LEVEL = "0";
  public static String path;
  public int audioLength;
  public boolean broken;
  public String data;
  private String defaultM4aPath;
  public boolean downloaded;
  @awhs
  public String id;
  public String shareTitle;
  public String title;
  public String vipLevel;
  
  public BlessPtvModule() {}
  
  public BlessPtvModule(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    this.title = paramString1;
    this.data = paramString2;
    this.id = paramString3;
    this.vipLevel = paramString4;
    this.audioLength = paramInt;
    this.shareTitle = paramString5;
  }
  
  public String getLrcPath()
  {
    return path + File.separator + this.id + File.separator + this.id + ".qrc";
  }
  
  public String getM4aPath()
  {
    if ("0".equals(this.id)) {
      return this.defaultM4aPath;
    }
    return path + File.separator + this.id + File.separator + this.id + ".m4a";
  }
  
  public String getPicPath()
  {
    return path + File.separator + this.id + File.separator + this.id + ".png";
  }
  
  public Drawable getPngDrawable(Activity paramActivity)
  {
    if ("0".equals(this.id)) {
      return paramActivity.getResources().getDrawable(2130838615);
    }
    String str = path + File.separator + this.id + File.separator + this.id + ".png";
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      int i = aepi.a(56.0F, paramActivity.getResources());
      localURLDrawableOptions.mRequestHeight = i;
      localURLDrawableOptions.mRequestWidth = i;
      paramActivity = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
      return paramActivity;
    }
    catch (OutOfMemoryError paramActivity) {}
    return null;
  }
  
  public String getZipPath()
  {
    return path + File.separator + this.id + File.separator + this.id + ".zip";
  }
  
  public boolean isComplete()
  {
    if (this.id == "0")
    {
      if ((this.defaultM4aPath == null) || (!arso.a(this.defaultM4aPath))) {}
    }
    else {
      while ((arso.a(getLrcPath())) && (arso.a(getM4aPath())) && (arso.a(getPicPath()))) {
        return true;
      }
    }
    return false;
  }
  
  public void setDefaultModule(String paramString)
  {
    this.defaultM4aPath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessPtvModule
 * JD-Core Version:    0.7.0.1
 */