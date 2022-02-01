package com.tencent.luggage.wxa.mz;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  extends com.tencent.luggage.wxa.kq.c
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  private int[] a(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = com.tencent.luggage.wxa.pc.c.a(paramByteBuffer);
    int[] arrayOfInt = new int[paramByteBuffer.length / 4];
    int i = 0;
    int m;
    for (int j = 0; i < arrayOfInt.length; j = m + 1)
    {
      m = j + 1;
      j = paramByteBuffer[j];
      int k = m + 1;
      int n = paramByteBuffer[m];
      m = k + 1;
      arrayOfInt[i] = ((j & 0xFF) << 16 | (n & 0xFF) << 8 | paramByteBuffer[k] & 0xFF | (paramByteBuffer[m] & 0xFF) << 24);
      i += 1;
    }
    return arrayOfInt;
  }
  
  private void b(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiXWebCanvasToTempFilePath", "invokeXWebCanvasJsApi data:%s", new Object[] { paramJSONObject });
    int i = paramJSONObject.optInt("width", 300);
    int j = paramJSONObject.optInt("height", 150);
    float f1 = af.a(paramJSONObject.optString("destWidth"), i);
    float f2 = af.a(paramJSONObject.optString("destHeight"), j);
    try
    {
      Object localObject1 = paramJSONObject.get("data");
      if (!(localObject1 instanceof ByteBuffer))
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiXWebCanvasToTempFilePath", "get data failed, value is not a ByteBuffer");
        paramc.a(paramInt, b("fail:illegal data"));
        return;
      }
      localObject1 = (ByteBuffer)localObject1;
      Object localObject2 = a((ByteBuffer)localObject1);
      localObject1 = null;
      try
      {
        localObject2 = Bitmap.createBitmap((int[])localObject2, i, j, Bitmap.Config.ARGB_8888);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable1)
      {
        com.tencent.luggage.wxa.qz.o.h("MicroMsg.JsApiXWebCanvasToTempFilePath", "create bitmap fail:%s", new Object[] { localThrowable1 });
      }
      catch (Exception localException1)
      {
        com.tencent.luggage.wxa.qz.o.h("MicroMsg.JsApiXWebCanvasToTempFilePath", "create bitmap fail:%s", new Object[] { localException1 });
      }
      if (localObject1 == null)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiXWebCanvasToTempFilePath", "oriBitmap is null, err, return");
        paramc.a(paramInt, b("fail:illegal bitmap"));
        return;
      }
      if ((((Bitmap)localObject1).getWidth() != f1) || (((Bitmap)localObject1).getHeight() != f2))
      {
        i = (int)f1;
        j = (int)f2;
        try
        {
          Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject1, i, j, false);
          com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiXWebCanvasToTempFilePath", "bitmap recycle %s %s ", new Object[] { localObject1, localBitmap });
          localObject1 = localBitmap;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.luggage.wxa.qz.o.h("MicroMsg.JsApiXWebCanvasToTempFilePath", "create scaledbitmap fail:%s", new Object[] { localThrowable2 });
        }
        catch (Exception localException2)
        {
          com.tencent.luggage.wxa.qz.o.h("MicroMsg.JsApiXWebCanvasToTempFilePath", "create scaledbitmap fail:%s", new Object[] { localException2 });
        }
      }
      if (localObject1 == null)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiXWebCanvasToTempFilePath", "oriBitmap is null, err, return");
        paramc.a(paramInt, b("fail:illegal bitmap"));
        return;
      }
      Bitmap.CompressFormat localCompressFormat = b(paramJSONObject);
      String str;
      if (localCompressFormat == Bitmap.CompressFormat.JPEG) {
        str = "jpg";
      } else {
        str = "png";
      }
      Object localObject3 = paramc.getFileSystem();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canvas_");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(".");
      localStringBuilder.append(str);
      localObject3 = ((com.tencent.mm.plugin.appbrand.appstorage.o)localObject3).i(localStringBuilder.toString());
      if (localObject3 == null)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, alloc file failed");
        paramc.a(paramInt, b("fail alloc file failed"));
        return;
      }
      localObject3 = ((com.tencent.luggage.wxa.rt.i)localObject3).l();
      com.tencent.luggage.wxa.qz.o.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, savePath = %s", new Object[] { localObject3 });
      try
      {
        b.a((Bitmap)localObject1, a(paramJSONObject), localCompressFormat, (String)localObject3, true);
        paramJSONObject = new com.tencent.luggage.wxa.pc.i();
        paramc.getFileSystem().a(new com.tencent.luggage.wxa.rt.i((String)localObject3), str, true, paramJSONObject);
        paramJSONObject = (String)paramJSONObject.a;
        com.tencent.luggage.wxa.qz.o.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, returnPath = %s", new Object[] { paramJSONObject });
        localObject1 = new HashMap();
        ((Map)localObject1).put("tempFilePath", paramJSONObject);
        paramc.a(paramInt, a("ok", (Map)localObject1));
        return;
      }
      catch (IOException paramJSONObject)
      {
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiXWebCanvasToTempFilePath", "save bitmap to file failed. exception : %s", new Object[] { paramJSONObject });
        paramc.a(paramInt, b("fail:write file failed"));
        return;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiXWebCanvasToTempFilePath", "get data failed, %s", new Object[] { Log.getStackTraceString(paramJSONObject) });
      paramc.a(paramInt, b("fail:missing data"));
    }
  }
  
  private boolean c(JSONObject paramJSONObject)
  {
    return (paramJSONObject != null) && (paramJSONObject.has("data"));
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (c(paramJSONObject))
    {
      b(paramc, paramJSONObject, paramInt);
      return;
    }
    super.a(paramc, paramJSONObject, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mz.f
 * JD-Core Version:    0.7.0.1
 */