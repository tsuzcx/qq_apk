package com.tencent.mobileqq.activity.bless;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.File;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="id")
public class BlessPtvModule
  extends Entity
{
  public static final String DEFAULT_MODULE_ID = "0";
  public static final String DEFAULT_MODULE_TITLE = HardCodeUtil.a(2131701377);
  public static final String DEFAULT_VIP_LEVEL = "0";
  public static String path;
  public int audioLength;
  public boolean broken = false;
  public String data;
  private String defaultM4aPath;
  public boolean downloaded = false;
  @unique
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(path);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.id);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.id);
    localStringBuilder.append(".qrc");
    return localStringBuilder.toString();
  }
  
  public String getM4aPath()
  {
    if ("0".equals(this.id)) {
      return this.defaultM4aPath;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(path);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.id);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.id);
    localStringBuilder.append(".m4a");
    return localStringBuilder.toString();
  }
  
  public String getPicPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(path);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.id);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.id);
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public Drawable getPngDrawable(Activity paramActivity)
  {
    if ("0".equals(this.id)) {
      return paramActivity.getResources().getDrawable(2130838759);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(path);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.id);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.id);
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      int i = AIOUtils.b(56.0F, paramActivity.getResources());
      localURLDrawableOptions.mRequestHeight = i;
      localURLDrawableOptions.mRequestWidth = i;
      paramActivity = URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions);
      return paramActivity;
    }
    catch (OutOfMemoryError paramActivity)
    {
      label127:
      break label127;
    }
    return null;
  }
  
  public String getZipPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(path);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.id);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.id);
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
  }
  
  public boolean isComplete()
  {
    if (this.id == "0")
    {
      String str = this.defaultM4aPath;
      if ((str != null) && (FileUtil.b(str))) {
        return true;
      }
    }
    else if ((FileUtil.b(getLrcPath())) && (FileUtil.b(getM4aPath())) && (FileUtil.b(getPicPath())))
    {
      return true;
    }
    return false;
  }
  
  public void setDefaultModule(String paramString)
  {
    this.defaultM4aPath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessPtvModule
 * JD-Core Version:    0.7.0.1
 */