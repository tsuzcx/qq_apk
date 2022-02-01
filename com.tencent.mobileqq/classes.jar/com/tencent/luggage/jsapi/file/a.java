package com.tencent.luggage.jsapi.file;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.core.content.FileProvider;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.rc.d;
import com.tencent.luggage.wxa.rt.i;
import java.io.File;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 99;
  private static final String NAME = "openDocument";
  private static long a = -1L;
  
  private void a(Context paramContext, String paramString1, String paramString2, LuggageActivityHelper.ActivityResultCallback paramActivityResultCallback)
  {
    paramString2 = d.a(paramString2);
    try
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(null);
      localIntent.setAction("android.intent.action.VIEW");
      paramString1 = new File(paramString1);
      if (Build.VERSION.SDK_INT >= 24)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(r.b());
        localStringBuilder.append(".shareFileProvide");
        paramString1 = FileProvider.getUriForFile(paramContext, localStringBuilder.toString(), paramString1);
      }
      else
      {
        paramString1 = Uri.fromFile(paramString1);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openOuterAppDirectly: uri = ");
      localStringBuilder.append(paramString1.toString());
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrand.JsApiOpenDocument", localStringBuilder.toString());
      localIntent.setDataAndType(paramString1, paramString2);
      localIntent.addFlags(268435456);
      int i = Build.VERSION.SDK_INT;
      localIntent.addFlags(524288);
      LuggageActivityHelper.FOR(paramContext).startActivityForResult(localIntent, paramActivityResultCallback);
      return;
    }
    catch (Exception paramContext)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrand.JsApiOpenDocument", "start outer view with mime(%s), e = %s", new Object[] { paramString2, paramContext });
      t.a(new a.2(this));
    }
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    long l = af.d();
    if (l - a < 1000L)
    {
      paramc.a(paramInt, b("fail:document viewer already starting"));
      return;
    }
    a = l;
    String str = paramJSONObject.optString("filePath");
    if (af.c(str))
    {
      paramc.a(paramInt, b("fail:invalid data"));
      return;
    }
    Object localObject = paramc.getFileSystem().g(str);
    if (localObject == null)
    {
      paramc.a(paramInt, b("fail:file doesn't exist"));
      return;
    }
    localObject = ((i)localObject).l();
    str = FilenameUtils.getExtension(str);
    paramJSONObject = paramJSONObject.optString("fileType");
    if (af.c(paramJSONObject)) {
      paramJSONObject = str;
    }
    a(paramc.getContext(), (String)localObject, paramJSONObject, new a.1(this, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.jsapi.file.a
 * JD-Core Version:    0.7.0.1
 */