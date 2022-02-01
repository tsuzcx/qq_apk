package com.tencent.luggage.wxa.bj;

import android.app.IntentService;
import android.content.Intent;
import com.tencent.luggage.wxa.qz.o;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/crash/WxaCrashUploaderService;", "Landroid/app/IntentService;", "()V", "onHandleIntent", "", "intent", "Landroid/content/Intent;", "uploadCrashInfoWithFile", "logPath", "", "uin", "productId", "", "clientVersion", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
  extends IntentService
{
  public static final c.a a = new c.a(null);
  
  public c()
  {
    super("WxaCrashUploader");
  }
  
  private final void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = new File(paramString1);
    if (!((File)localObject).exists())
    {
      o.b("Luggage.WxaCrashUploader", "file not exist, return");
      return;
    }
    for (;;)
    {
      try
      {
        paramString1 = FileUtils.readFileToByteArray((File)localObject);
      }
      catch (IOException paramString1)
      {
        a locala;
        continue;
      }
      o.b("Luggage.WxaCrashUploader", "read log file fail");
      paramString1 = new byte[0];
    }
    FileUtils.deleteQuietly((File)localObject);
    localObject = new HashMap();
    ((HashMap)localObject).put("reporttype", String.valueOf(9999));
    locala = a.a;
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "logData");
    locala.a(paramInt1, paramString2, paramInt2, paramString1, (Map)localObject);
  }
  
  protected void onHandleIntent(@Nullable Intent paramIntent)
  {
    o.d("Luggage.WxaCrashUploader", "onHandleIntent");
    if (paramIntent != null)
    {
      String str1 = paramIntent.getStringExtra("KEY_CRASH_LOG_PATH");
      String str2 = paramIntent.getStringExtra("KEY_CRASH_UIN");
      int k = paramIntent.getIntExtra("KEY_CRASH_PRODUCT_ID", -1);
      int m = paramIntent.getIntExtra("KEY_CLIENT_VERSION", -1);
      paramIntent = (CharSequence)str1;
      int j = 0;
      int i;
      if ((paramIntent != null) && (paramIntent.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        o.b("Luggage.WxaCrashUploader", "log path is null, return");
        return;
      }
      paramIntent = (CharSequence)str2;
      if (paramIntent != null)
      {
        i = j;
        if (paramIntent.length() != 0) {}
      }
      else
      {
        i = 1;
      }
      if (i != 0)
      {
        o.b("Luggage.WxaCrashUploader", "uin is null, return");
        return;
      }
      if (k == -1)
      {
        o.b("Luggage.WxaCrashUploader", "product id not found, return");
        return;
      }
      if (m == -1)
      {
        o.b("Luggage.WxaCrashUploader", "client version not found, return");
        return;
      }
      a(str1, str2, k, m);
      return;
    }
    paramIntent = (c)this;
    o.b("Luggage.WxaCrashUploader", "intent is null, return");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bj.c
 * JD-Core Version:    0.7.0.1
 */