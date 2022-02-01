package com.tencent.ad.tangram.device;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.ad.tangram.file.a;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForUUID;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.util.e;
import java.io.File;

final class s
{
  static final String TAG = "AdUUIDUtil";
  private static r uuidInfo;
  
  private static String getDirectoryAbsolutePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (Environment.getExternalStorageDirectory() == null) {
      return null;
    }
    return new File(Environment.getExternalStorageDirectory(), paramString).getAbsolutePath();
  }
  
  public static s.a getUUID(Context paramContext, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    s.a locala = new s.a();
    locala.error = 1;
    if (uuidInfo != null)
    {
      locala.uuidInfo = uuidInfo;
      locala.error = 0;
      locala.cached = true;
    }
    Object localObject;
    r.a locala1;
    a locala2;
    a locala3;
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
        locala1 = new r.a(((gdt_settings.Settings)localObject).settingsForUUID);
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
          locala2 = new a(getDirectoryAbsolutePath("Tencent/ams/cache"), "meta.dat", "UTF-8", true);
          locala3 = new a(getDirectoryAbsolutePath("Android/data/com.tencent.ams/cache"), "meta.dat", "UTF-8", true);
          if ((locala2.open()) && (locala3.open())) {
            break;
          }
          locala2.close();
          locala3.close();
          locala.error = 18;
        }
      }
    }
    int i = ((gdt_settings.Settings)localObject).settingsForUUID.maxLength;
    String str1 = locala2.readFully(i);
    r localr2 = r.fromString(str1);
    String str2 = locala3.readFully(i);
    r localr3 = r.fromString(str2);
    r localr1 = r.create(locala1);
    if (localr1 != null)
    {
      localObject = localr1.toString();
      label320:
      if ((localr2 == null) || (!localr2.isValid(locala1))) {
        break label411;
      }
      localr1 = localr2;
      localObject = str1;
    }
    for (;;)
    {
      if ((locala2.writeFully((String)localObject)) && (locala3.writeFully((String)localObject)))
      {
        uuidInfo = localr1;
        locala.uuidInfo = uuidInfo;
        locala.error = 0;
      }
      locala2.close();
      locala3.close();
      AdReporterForAnalysis.reportForUUID(paramContext, localr2, localr3, locala1);
      break;
      localObject = null;
      break label320;
      label411:
      if ((localr3 != null) && (localr3.isValid(locala1)))
      {
        localObject = str2;
        localr1 = localr3;
      }
      else if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = null;
        localr1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.s
 * JD-Core Version:    0.7.0.1
 */