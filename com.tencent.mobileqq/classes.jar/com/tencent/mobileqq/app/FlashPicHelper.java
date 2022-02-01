package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.config.business.AlbumBean;
import com.tencent.mobileqq.config.business.AlbumConfProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class FlashPicHelper
{
  public static void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      paramMessageRecord.saveExtInfoToExtStr("commen_flash_pic", "true");
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (paramMessageRecord.msgtype == -2000)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("");
      paramMessageRecord.saveExtInfoToExtStr("commen_flash_pic", localStringBuilder.toString());
    }
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFlashPicFlag,troopUin:");
      localStringBuilder.append(paramMessageRecord.frienduin);
      localStringBuilder.append(",isReaded:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",msgType:");
      localStringBuilder.append(paramMessageRecord.msgtype);
      QLog.d("FlashPicHelper", 4, localStringBuilder.toString());
    }
  }
  
  public static boolean a()
  {
    AlbumBean localAlbumBean = AlbumConfProcessor.a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAlbumBean != null) {
      if (localAlbumBean.a != 1)
      {
        bool1 = bool2;
        if (localAlbumBean.a != 2) {}
      }
      else
      {
        bool1 = bool2;
        if (localAlbumBean.a == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    if ((paramInt != 0) || (!b()))
    {
      if ((paramInt == 1) && (a())) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && ((paramMessageRecord.msgtype == -2000) || (paramMessageRecord.msgtype == -2006)) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("commen_flash_pic")));
  }
  
  public static boolean b()
  {
    AlbumBean localAlbumBean = AlbumConfProcessor.a();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localAlbumBean != null) {
      if (localAlbumBean.b != 1)
      {
        bool1 = bool2;
        if (localAlbumBean.b != 2) {}
      }
      else
      {
        if (localAlbumBean.b == 1) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = Boolean.valueOf(paramMessageRecord.getExtInfoFromExtStr("commen_flash_pic")).booleanValue();
      return bool;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FlashPicHelper
 * JD-Core Version:    0.7.0.1
 */