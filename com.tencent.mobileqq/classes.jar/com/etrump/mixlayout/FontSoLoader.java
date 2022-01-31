package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.earlydownload.xmldata.VipFontData;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class FontSoLoader
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  public static AtomicBoolean b = new AtomicBoolean(false);
  
  public static String a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (BaseApplicationImpl.getContext() != null)
    {
      File localFile = BaseApplicationImpl.getContext().getFilesDir();
      localObject1 = localObject2;
      if (localFile != null) {
        localObject1 = localFile.getParent() + "/txlib/";
      }
    }
    return localObject1;
  }
  
  public static boolean a()
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 4).getBoolean("vip_font_so_downloaded", false);
      if (QLog.isColorLevel()) {
        QLog.d("VipFontSoLoader", 2, "VipFontData in sp: vip_font_so_downloaded=" + bool2);
      }
      if (bool2)
      {
        String str = VasUtils.a();
        bool1 = new File(str + "libvipfont765.so").exists();
      }
      return bool1;
    }
    finally {}
  }
  
  public static boolean a(VipFontData paramVipFontData)
  {
    if ((paramVipFontData == null) || (TextUtils.isEmpty(paramVipFontData.SoMD5))) {}
    File localFile;
    String str;
    do
    {
      return false;
      localFile = new File(a() + "libvipfont_v5.so");
      str = FileUtils.b(localFile.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d("VipFontSoLoader", 2, "checkUpdate: LocalSoMD5=" + str + ", ServerSoMD5=" + paramVipFontData.SoMD5);
      }
    } while (paramVipFontData.SoMD5.equalsIgnoreCase(str));
    localFile.delete();
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    for (;;)
    {
      File localFile;
      try
      {
        String str = a();
        localFile = new File(str, "libvipfont_v5.so");
        boolean bool3 = TextUtils.isEmpty(str);
        bool1 = bool2;
        if (!bool3) {}
        try
        {
          FileUtils.a(paramString1, str, false);
          str = FileUtils.b(str + "libvipfont_v5.so");
          if (QLog.isColorLevel()) {
            QLog.d("VipFontSoLoader", 2, "LocalSoMD5=" + str + ", ServerSoMD5=" + paramString2);
          }
          if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(paramString2))) {
            break label225;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VipFontSoLoader", 2, "uncompress zip success, filepath=" + paramString1);
          }
          bool1 = true;
        }
        catch (IOException paramString2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VipFontSoLoader", 2, "uncompress zip failed, filepath=" + paramString1, paramString2);
          bool1 = bool2;
          if (!localFile.exists()) {
            continue;
          }
          localFile.delete();
          bool1 = bool2;
          continue;
        }
        return bool1;
      }
      finally {}
      label225:
      boolean bool1 = bool2;
      if (localFile.exists())
      {
        localFile.delete();
        bool1 = bool2;
      }
    }
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = a.get();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean c()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = BaseApplicationImpl.getApplication();
        if (localObject1 == null)
        {
          bool = false;
          return bool;
        }
        switch (VasUtils.a(VasUtils.a(), "libvipfont765.so"))
        {
        case 1: 
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if (!(localObject1 instanceof QQAppInterface)) {
            break label250;
          }
          QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
          ((VasQuickUpdateManager)localQQAppInterface.getManager(183)).a(1004L, "libVipFont_765", "FontManager_initHYEngine");
          localObject1 = ((FriendsManager)localQQAppInterface.getManager(50)).a(localQQAppInterface.getAccount());
          if ((localObject1 != null) && (0L != ((ExtensionInfo)localObject1).uVipFont) && (((ExtensionInfo)localObject1).vipFontType == 1))
          {
            localObject1 = "0";
            ReportController.b(localQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80072C8", 0, 0, "1", (String)localObject1, "", "");
            if (!QLog.isColorLevel()) {
              break label250;
            }
            QLog.d("VipFontSoLoader", 2, "VipFontReport: early download start, restartDownload=true, type=" + (String)localObject1);
          }
          break;
        }
      }
      finally {}
      String str = "1";
      continue;
      ETEngine.isSOLoaded.set(true);
      HiBoomFont.a().a();
      a.set(true);
      BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 0).edit().putBoolean("vip_font_so_downloaded", true).commit();
      boolean bool = true;
      continue;
      label250:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.FontSoLoader
 * JD-Core Version:    0.7.0.1
 */