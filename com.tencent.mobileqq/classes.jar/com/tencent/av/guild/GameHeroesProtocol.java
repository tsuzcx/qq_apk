package com.tencent.av.guild;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.av.app.SessionInfo.HeroDetail;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jku;
import jkv;
import mqq.manager.TicketManager;

public class GameHeroesProtocol
{
  public VideoAppInterface a;
  public String a;
  public Map a;
  public jku a;
  public String b;
  public String c;
  
  GameHeroesProtocol(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_Jku = null;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount();
    this.b = "7.6.8";
    this.c = ((TicketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_JavaLangString);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        str = ImageResUtil.a() + MD5.toMD5(paramString) + paramString.substring(paramString.lastIndexOf("."));
        if (!FileUtil.a(str))
        {
          File localFile = new File(str);
          boolean bool = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString, localFile);
          if (QLog.isColorLevel()) {
            QLog.d("GameHeroesProtocol", 2, "[GameHeroesProtocol] download hero url=" + paramString + ", path=" + str + ", ret=" + bool);
          }
          bool = FileUtil.a(str);
          paramString = localObject;
          if (!bool) {}
        }
      }
      catch (Exception paramString)
      {
        String str;
        return null;
      }
      try
      {
        paramString = BitmapFactory.decodeFile(str);
        return paramString;
      }
      catch (OutOfMemoryError paramString) {}
      if (QLog.isColorLevel()) {
        QLog.d("GameHeroesProtocol", 2, "[GameHeroesProtocol] download hero exited file=" + str);
      }
    }
    return null;
  }
  
  void a(String paramString, long paramLong, SessionInfo.HeroDetail paramHeroDetail)
  {
    if (paramHeroDetail == null) {
      return;
    }
    if (paramString != null) {}
    for (;;)
    {
      String str;
      try
      {
        l = Long.parseLong(paramString);
        if ((l == -1L) || (paramLong == -1L))
        {
          paramHeroDetail.a -= 1;
          if (this.jdField_a_of_type_Jku == null) {
            break;
          }
          this.jdField_a_of_type_Jku.a();
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l = -1L;
        continue;
        str = "" + l + paramLong;
      }
      if ((jkv)this.jdField_a_of_type_JavaUtilMap.get(str) != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GameHeroesProtocol", 2, "[GameHeroesProtocol] ====== pull info ====== uin(" + paramString + "), groupId(" + paramLong + ")");
      }
      paramString = new jkv(this, l, paramLong, paramHeroDetail);
      this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      paramString.start();
      return;
      long l = -1L;
    }
  }
  
  void a(jku paramjku)
  {
    this.jdField_a_of_type_Jku = paramjku;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.guild.GameHeroesProtocol
 * JD-Core Version:    0.7.0.1
 */