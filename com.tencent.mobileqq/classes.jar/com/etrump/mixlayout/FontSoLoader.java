package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anvk;
import avjz;
import bdla;
import bhiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class FontSoLoader
{
  public static final String SO_PATH_NAME = "/txlib/";
  public static final String STR_RES_NAME = "qq.android.native.vipfont.v5";
  public static final String TAG = "VipFontSoLoader";
  public static final String VIP_FONT_SP_NAME = "early_qq.android.native.vipfont.v5";
  public static AtomicBoolean sIsVipFontSoLoaded = new AtomicBoolean(false);
  
  public static String getSoLibPath()
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
  
  public static boolean isVipFontSoDownloaded()
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
        String str = bhiw.a();
        bool1 = new File(str + "libvipfont808.so").exists();
      }
      return bool1;
    }
    finally {}
  }
  
  public static boolean isVipFontSoLoaded()
  {
    try
    {
      boolean bool = sIsVipFontSoLoaded.get();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean loadSoLib()
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
        switch (bhiw.a(bhiw.a(), "libvipfont808.so"))
        {
        case 1: 
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if (!(localObject1 instanceof QQAppInterface)) {
            break label251;
          }
          QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
          ((VasQuickUpdateManager)localQQAppInterface.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).downloadItem(1004L, "libVipFont_808", "FontManager_initHYEngine");
          localObject1 = ((anvk)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(localQQAppInterface.getAccount());
          if ((localObject1 != null) && (0L != ((ExtensionInfo)localObject1).uVipFont) && (((ExtensionInfo)localObject1).vipFontType == 1))
          {
            localObject1 = "0";
            bdla.b(localQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80072C8", 0, 0, "1", (String)localObject1, "", "");
            if (!QLog.isColorLevel()) {
              break label251;
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
      avjz.a().a();
      sIsVipFontSoLoaded.set(true);
      BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 4).edit().putBoolean("vip_font_so_downloaded", true).commit();
      boolean bool = true;
      continue;
      label251:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontSoLoader
 * JD-Core Version:    0.7.0.1
 */