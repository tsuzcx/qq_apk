package com.tencent.comic.quickupdate;

import com.tencent.comic.VipComicNavConfigHelper;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.jetbrains.annotations.NotNull;

public class QQComicUpdateBusiness
  extends BaseUpdateCallback
{
  public static final String TAG = "QQComicUpdateBusiness";
  public static QQComicUpdateBusiness sInstance = new QQComicUpdateBusiness();
  
  @NotNull
  private TagItemInfo getBidComicInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.jdField_a_of_type_Boolean = false;
    if (paramString.equals("vipComic_nav_config.json"))
    {
      paramTagItemInfo.b = false;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = VipComicNavConfigHelper.b().getAbsolutePath();
      return paramTagItemInfo;
    }
    if (paramString.equals("vipComic_nav_tabIcon.zip"))
    {
      paramTagItemInfo.b = true;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = VipComicNavConfigHelper.c().getAbsolutePath();
    }
    return paramTagItemInfo;
  }
  
  private boolean isComicExist(String paramString)
  {
    if (paramString.equals("vipComic_nav_config.json")) {
      return VipComicNavConfigHelper.a();
    }
    if (paramString.equals("vipComic_nav_tabIcon.zip")) {
      return VipComicNavConfigHelper.b();
    }
    return false;
  }
  
  private void onComicCompleted(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      if (paramString.equals("vipComic_nav_config.json"))
      {
        VipComicNavConfigHelper.a();
        return;
      }
      if (paramString.equals("vipComic_nav_tabIcon.zip")) {
        VipComicNavConfigHelper.b();
      }
    }
  }
  
  public void doOnCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super.doOnCompleted(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("doOnCompleted: bid=");
      paramString2.append(paramLong);
      paramString2.append(", scid=");
      paramString2.append(paramString1);
      paramString2.append(", errorCode=");
      paramString2.append(paramInt1);
      QLog.i("QQComicUpdateBusiness", 2, paramString2.toString());
    }
    if (paramLong == 100L) {
      onComicCompleted(paramString1, paramInt1);
    }
  }
  
  public long getBID()
  {
    return 100L;
  }
  
  public TagItemInfo getItemInfo(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getItemInfo: bid=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", scid=");
      localStringBuilder.append(paramString);
      QLog.i("QQComicUpdateBusiness", 2, localStringBuilder.toString());
    }
    if (paramLong == 100L) {
      return getBidComicInfo(paramString, new TagItemInfo());
    }
    return null;
  }
  
  public boolean isFileExists(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQComicUpdateBusiness", 2, "isFileExists");
    }
    if (paramLong == 100L) {
      return isComicExist(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.quickupdate.QQComicUpdateBusiness
 * JD-Core Version:    0.7.0.1
 */