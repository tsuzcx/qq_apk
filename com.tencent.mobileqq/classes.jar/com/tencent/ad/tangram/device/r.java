package com.tencent.ad.tangram.device;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.ad.tangram.file.AdFile;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForUUID;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.util.e;
import java.io.File;

final class r
{
  static final String TAG = "AdUUIDUtil";
  private static q uuidInfo;
  
  private static String getDirectoryAbsolutePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (Environment.getExternalStorageDirectory() == null) {
      return null;
    }
    return new File(Environment.getExternalStorageDirectory(), paramString).getAbsolutePath();
  }
  
  public static r.a getUUID(Context paramContext, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    r.a locala = new r.a();
    locala.error = 1;
    if (uuidInfo != null)
    {
      locala.uuidInfo = uuidInfo;
      locala.error = 0;
      locala.cached = true;
    }
    Object localObject;
    q.a locala1;
    AdFile localAdFile1;
    AdFile localAdFile2;
    for (;;)
    {
      AdLog.i("AdUUIDUtil", String.format("getUUID %d", new Object[] { Integer.valueOf(locala.error) }));
      locala.duration = (System.currentTimeMillis() - l);
      return locala;
      localObject = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
      if (localObject == null)
      {
        locala.error = 106;
      }
      else
      {
        locala1 = new q.a(((gdt_settings.Settings)localObject).settingsForUUID);
        if ((locala1 == null) || (!locala1.isValid()))
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
          localAdFile1 = new AdFile(getDirectoryAbsolutePath("Tencent/ams/cache"), "meta.dat", "UTF-8", true);
          localAdFile2 = new AdFile(getDirectoryAbsolutePath("Android/data/com.tencent.ams/cache"), "meta.dat", "UTF-8", true);
          if ((localAdFile1.open()) && (localAdFile2.open())) {
            break;
          }
          localAdFile1.close();
          localAdFile2.close();
          locala.error = 18;
        }
      }
    }
    int i = ((gdt_settings.Settings)localObject).settingsForUUID.maxLength;
    String str1 = localAdFile1.readFully(i);
    q localq2 = q.fromString(str1);
    String str2 = localAdFile2.readFully(i);
    q localq3 = q.fromString(str2);
    q localq1 = q.create(locala1);
    if (localq1 != null)
    {
      localObject = localq1.toString();
      label320:
      if ((localq2 == null) || (!localq2.isValid(locala1))) {
        break label411;
      }
      localq1 = localq2;
      localObject = str1;
    }
    for (;;)
    {
      if ((localAdFile1.writeFully((String)localObject)) && (localAdFile2.writeFully((String)localObject)))
      {
        uuidInfo = localq1;
        locala.uuidInfo = uuidInfo;
        locala.error = 0;
      }
      localAdFile1.close();
      localAdFile2.close();
      AdReporterForAnalysis.reportForUUID(paramContext, localq2, localq3, locala1);
      break;
      localObject = null;
      break label320;
      label411:
      if ((localq3 != null) && (localq3.isValid(locala1)))
      {
        localObject = str2;
        localq1 = localq3;
      }
      else if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = null;
        localq1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.r
 * JD-Core Version:    0.7.0.1
 */