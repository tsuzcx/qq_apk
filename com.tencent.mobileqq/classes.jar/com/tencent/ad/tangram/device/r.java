package com.tencent.ad.tangram.device;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.ad.tangram.file.AdFile;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForDeviceInfo;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForDeviceInfo.UUID;
import com.tencent.ad.tangram.settings.AdSettingsManager;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.util.e;
import java.io.File;

final class r
{
  static final String TAG = "AdUUIDUtil";
  private static q uuidInfo;
  
  private static String getDirectoryAbsolutePath(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (Environment.getExternalStorageDirectory() == null)) {
      return null;
    }
    return new File(Environment.getExternalStorageDirectory(), paramString).getAbsolutePath();
  }
  
  public static r.a getUUID(Context paramContext, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    r.a locala = new r.a();
    locala.error = 1;
    Object localObject1 = uuidInfo;
    if (localObject1 != null)
    {
      locala.uuidInfo = ((q)localObject1);
      locala.error = 0;
      locala.cached = true;
    }
    else
    {
      localObject1 = AdSettingsManager.INSTANCE.getCache();
      if (localObject1 == null)
      {
        locala.error = 106;
      }
      else
      {
        q.a locala1 = new q.a(((gdt_settings.Settings)localObject1).settingsForDeviceInfo.uuid);
        if (!locala1.isValid())
        {
          locala.error = 4;
        }
        else if ((paramBoolean) && (!e.checkPermission(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE")))
        {
          locala.error = 17;
        }
        else if (!TextUtils.equals(Environment.getExternalStorageState(), "mounted"))
        {
          locala.error = 213;
        }
        else
        {
          AdFile localAdFile1 = new AdFile(getDirectoryAbsolutePath("Tencent/ams/cache"), "meta.dat", "UTF-8", true);
          AdFile localAdFile2 = new AdFile(getDirectoryAbsolutePath("Android/data/com.tencent.ams/cache"), "meta.dat", "UTF-8", true);
          if ((localAdFile1.open()) && (localAdFile2.open()))
          {
            int i = ((gdt_settings.Settings)localObject1).settingsForDeviceInfo.uuid.maxLength;
            String str1 = localAdFile1.readFully(i);
            q localq1 = q.fromString(str1);
            String str2 = localAdFile2.readFully(i);
            q localq2 = q.fromString(str2);
            q localq3 = q.create(locala1);
            Object localObject2 = null;
            if (localq3 != null) {
              localObject1 = localq3.toString();
            } else {
              localObject1 = null;
            }
            if ((localq1 != null) && (localq1.isValid(locala1)))
            {
              localObject2 = str1;
              localObject1 = localq1;
            }
            else if ((localq2 != null) && (localq2.isValid(locala1)))
            {
              localObject2 = str2;
              localObject1 = localq2;
            }
            else if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = localObject1;
              localObject1 = localq3;
            }
            else
            {
              localObject1 = null;
            }
            if ((localAdFile1.writeFully((String)localObject2)) && (localAdFile2.writeFully((String)localObject2)))
            {
              uuidInfo = (q)localObject1;
              locala.uuidInfo = uuidInfo;
              locala.error = 0;
            }
            localAdFile1.close();
            localAdFile2.close();
            AdAnalysisHelperForUtil.reportForUUID(paramContext, localq1, localq2, locala1);
          }
          else
          {
            localAdFile1.close();
            localAdFile2.close();
            locala.error = 18;
          }
        }
      }
    }
    AdLog.i("AdUUIDUtil", String.format("getUUID %d", new Object[] { Integer.valueOf(locala.error) }));
    locala.duration = (System.currentTimeMillis() - l);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.r
 * JD-Core Version:    0.7.0.1
 */