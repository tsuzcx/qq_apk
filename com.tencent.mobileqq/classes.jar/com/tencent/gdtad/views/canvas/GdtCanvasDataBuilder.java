package com.tencent.gdtad.views.canvas;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentData;
import com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoComponentData;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasPageData;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GdtCanvasDataBuilder
{
  private static int a(int paramInt, float paramFloat)
  {
    return (int)(ViewUtils.a() * paramFloat / paramInt);
  }
  
  private static int a(String paramString, int paramInt)
  {
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      GdtLog.d("GdtCanvasDataBuilder", "getColor error", paramString);
    }
    return paramInt;
  }
  
  public static GdtCanvasData a(GdtAd paramGdtAd)
  {
    if ((paramGdtAd == null) || (TextUtils.isEmpty(paramGdtAd.getCanvas())))
    {
      GdtLog.d("GdtCanvasDataBuilder", "build error");
      return null;
    }
    String str = paramGdtAd.getCanvas();
    GdtLog.b("GdtCanvasDataBuilder", "build " + str);
    try
    {
      paramGdtAd = a(paramGdtAd, new JSONObject(str));
      a(paramGdtAd);
      return paramGdtAd;
    }
    catch (JSONException paramGdtAd)
    {
      GdtLog.d("GdtCanvasDataBuilder", "build error", paramGdtAd);
    }
    return null;
  }
  
  private static GdtCanvasData a(GdtAd paramGdtAd, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getCanvasData error");
      return null;
    }
    GdtCanvasData localGdtCanvasData = new GdtCanvasData();
    localGdtCanvasData.ad = paramGdtAd;
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("adCanvasInfo");
      localGdtCanvasData.id = paramJSONObject.optString("id");
      localGdtCanvasData.name = paramJSONObject.optString("canvasName");
      localGdtCanvasData.basicWidth = paramJSONObject.optInt("basicWidth", 1080);
      localGdtCanvasData.pages = a(paramGdtAd, paramJSONObject.optJSONArray("PageList"), localGdtCanvasData.basicWidth);
      return localGdtCanvasData;
    }
    catch (JSONException paramGdtAd)
    {
      paramGdtAd.printStackTrace();
    }
    return localGdtCanvasData;
  }
  
  private static GdtCanvasComponentData a(GdtAd paramGdtAd, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getComponent error");
      localObject1 = localObject2;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        i = paramJSONObject.getInt("type");
        switch (i)
        {
        default: 
          GdtLog.d("GdtCanvasDataBuilder", "getComponent error, type is unknown\n" + paramJSONObject.toString());
          paramJSONObject = (JSONObject)localObject1;
          localObject1 = paramJSONObject;
          if (paramJSONObject == null) {
            continue;
          }
          paramJSONObject.ad = paramGdtAd;
          return paramJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          GdtLog.d("GdtCanvasDataBuilder", "getComponent error", localJSONException);
          int i = -1;
          continue;
          paramJSONObject = a(paramJSONObject, paramInt);
          continue;
          paramJSONObject = a(paramJSONObject, paramInt);
          continue;
          paramJSONObject = a(paramJSONObject, paramInt);
        }
      }
    }
  }
  
  private static GdtCanvasComponentData a(JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getVideoComponent error");
      return null;
    }
    GdtCanvasVideoComponentData localGdtCanvasVideoComponentData = new GdtCanvasVideoComponentData();
    a(paramJSONObject, paramInt, localGdtCanvasVideoComponentData);
    for (;;)
    {
      try
      {
        localGdtCanvasVideoComponentData.width = a(paramInt, paramJSONObject.getInt("videoWidth"));
        localGdtCanvasVideoComponentData.height = a(paramInt, paramJSONObject.getInt("videoHeight"));
        localGdtCanvasVideoComponentData.paddingTop = a(paramInt, paramJSONObject.optInt("paddingTop", 0));
        localGdtCanvasVideoComponentData.paddingBottom = a(paramInt, paramJSONObject.optInt("paddingBottom", 0));
        localGdtCanvasVideoComponentData.videoId = paramJSONObject.optString("videoId");
        paramInt = paramJSONObject.optInt("loopType", 0);
        if (paramInt == 0) {
          localGdtCanvasVideoComponentData.loop = false;
        }
        if (paramInt != 1) {
          continue;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localGdtCanvasVideoComponentData.duration = paramJSONObject.getInt("videoDuration");
          localGdtCanvasVideoComponentData.size = paramJSONObject.getInt("videoSize");
          localGdtCanvasVideoComponentData.url = paramJSONObject.getString("videoUrl");
          localGdtCanvasVideoComponentData.thumbUrl = paramJSONObject.optString("thumbUrl");
          return localGdtCanvasVideoComponentData;
        }
        catch (JSONException localJSONException2)
        {
          GdtLog.d("GdtCanvasDataBuilder", "getVideoComponent error\n" + paramJSONObject.toString(), localJSONException2);
        }
        localJSONException1 = localJSONException1;
        GdtLog.d("GdtCanvasDataBuilder", "getVideoComponent error\n" + paramJSONObject.toString(), localJSONException1);
        return null;
      }
      localJSONException1.loop = true;
    }
    return null;
  }
  
  private static GdtCanvasButtonComponentData a(JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getButtonComponent error");
      return null;
    }
    GdtCanvasButtonComponentData localGdtCanvasButtonComponentData = new GdtCanvasButtonComponentData();
    a(paramJSONObject, paramInt, localGdtCanvasButtonComponentData);
    localGdtCanvasButtonComponentData.width = a(paramInt, paramJSONObject.optInt("btnWidth", 720));
    localGdtCanvasButtonComponentData.height = a(paramInt, paramJSONObject.optInt("btnHeight", 120));
    localGdtCanvasButtonComponentData.paddingTop = a(paramInt, paramJSONObject.optInt("paddingTop", 40));
    localGdtCanvasButtonComponentData.paddingBottom = a(paramInt, paramJSONObject.optInt("paddingBottom", 40));
    localGdtCanvasButtonComponentData.backgroundColor = a(paramJSONObject.optString("btnBgColor"), -1);
    localGdtCanvasButtonComponentData.title = paramJSONObject.optString("btnTitle", "提交");
    localGdtCanvasButtonComponentData.fontColor = a(paramJSONObject.optString("fontColor"), -16777216);
    localGdtCanvasButtonComponentData.fontSize = a(paramInt, paramJSONObject.optInt("fontSize", 52));
    localGdtCanvasButtonComponentData.borderWidth = a(paramInt, paramJSONObject.optInt("borderWidth", 3));
    localGdtCanvasButtonComponentData.borderColor = a(paramJSONObject.optString("borderColor"), -16777216);
    localGdtCanvasButtonComponentData.borderType = paramJSONObject.optInt("borderType");
    localGdtCanvasButtonComponentData.actionUrl = paramJSONObject.optString("btnLinkUrl");
    localGdtCanvasButtonComponentData.borderCornerRadius = a(paramInt, 6.0F);
    return localGdtCanvasButtonComponentData;
  }
  
  /* Error */
  private static com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData a(JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: getstatic 85	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   8: if_acmpne +13 -> 21
    //   11: ldc 27
    //   13: ldc_w 288
    //   16: invokestatic 55	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 290	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData
    //   24: dup
    //   25: invokespecial 291	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:<init>	()V
    //   28: astore_2
    //   29: aload_0
    //   30: iload_1
    //   31: aload_2
    //   32: invokestatic 169	com/tencent/gdtad/views/canvas/GdtCanvasDataBuilder:a	(Lorg/json/JSONObject;ILcom/tencent/gdtad/views/canvas/components/GdtCanvasComponentData;)V
    //   35: aload_2
    //   36: iload_1
    //   37: aload_0
    //   38: ldc_w 293
    //   41: invokevirtual 146	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   44: i2f
    //   45: invokestatic 173	com/tencent/gdtad/views/canvas/GdtCanvasDataBuilder:a	(IF)I
    //   48: putfield 294	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:width	I
    //   51: aload_2
    //   52: iload_1
    //   53: aload_0
    //   54: ldc_w 296
    //   57: invokevirtual 146	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   60: i2f
    //   61: invokestatic 173	com/tencent/gdtad/views/canvas/GdtCanvasDataBuilder:a	(IF)I
    //   64: putfield 297	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:height	I
    //   67: aload_2
    //   68: iload_1
    //   69: aload_0
    //   70: ldc 183
    //   72: iconst_0
    //   73: invokevirtual 119	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   76: i2f
    //   77: invokestatic 173	com/tencent/gdtad/views/canvas/GdtCanvasDataBuilder:a	(IF)I
    //   80: putfield 298	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:paddingTop	I
    //   83: aload_2
    //   84: iload_1
    //   85: aload_0
    //   86: ldc 187
    //   88: iconst_0
    //   89: invokevirtual 119	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   92: i2f
    //   93: invokestatic 173	com/tencent/gdtad/views/canvas/GdtCanvasDataBuilder:a	(IF)I
    //   96: putfield 299	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:paddingBottom	I
    //   99: aload_2
    //   100: aload_0
    //   101: ldc_w 301
    //   104: invokevirtual 106	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: putfield 303	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:imageId	Ljava/lang/String;
    //   110: aload_2
    //   111: aload_0
    //   112: ldc_w 305
    //   115: invokevirtual 215	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: putfield 306	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:url	Ljava/lang/String;
    //   121: aload_2
    //   122: aload_0
    //   123: ldc_w 308
    //   126: invokevirtual 106	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: putfield 309	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:actionUrl	Ljava/lang/String;
    //   132: aload_2
    //   133: areturn
    //   134: astore_2
    //   135: ldc 27
    //   137: new 57	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 311
    //   147: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_0
    //   151: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   154: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: aload_2
    //   161: invokestatic 35	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: aconst_null
    //   165: areturn
    //   166: astore_2
    //   167: ldc 27
    //   169: new 57	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 311
    //   179: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   186: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: aload_2
    //   193: invokestatic 35	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   196: aconst_null
    //   197: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramJSONObject	JSONObject
    //   0	198	1	paramInt	int
    //   28	105	2	localGdtCanvasPictureComponentData	com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData
    //   134	27	2	localJSONException1	JSONException
    //   166	27	2	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   35	67	134	org/json/JSONException
    //   110	121	166	org/json/JSONException
  }
  
  private static GdtCanvasPageData a(GdtAd paramGdtAd, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getPage error");
      return null;
    }
    GdtCanvasPageData localGdtCanvasPageData = new GdtCanvasPageData();
    localGdtCanvasPageData.ad = paramGdtAd;
    localGdtCanvasPageData.id = paramJSONObject.optString("id");
    localGdtCanvasPageData.backgroundColor = a(paramJSONObject.optString("backgroundColor"), -1);
    localGdtCanvasPageData.components = b(paramGdtAd, paramJSONObject.optJSONArray("componentItemList"), paramInt);
    return localGdtCanvasPageData;
  }
  
  private static List a(GdtAd paramGdtAd, JSONArray paramJSONArray, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONArray == null) || (paramJSONArray == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getPageList error");
      return localArrayList;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      GdtCanvasPageData localGdtCanvasPageData = a(paramGdtAd, paramJSONArray.optJSONObject(i), paramInt);
      if (localGdtCanvasPageData != null) {
        localArrayList.add(localGdtCanvasPageData);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static void a(GdtCanvasData paramGdtCanvasData)
  {
    if ((paramGdtCanvasData == null) || (!paramGdtCanvasData.isValid())) {
      GdtLog.d("GdtCanvasDataBuilder", "filter error");
    }
    while (paramGdtCanvasData.pages.size() <= 0) {
      return;
    }
    Object localObject = paramGdtCanvasData.pages.iterator();
    GdtCanvasPageData localGdtCanvasPageData;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localGdtCanvasPageData = (GdtCanvasPageData)((Iterator)localObject).next();
    } while (!localGdtCanvasPageData.isValid());
    for (;;)
    {
      if (localGdtCanvasPageData == null)
      {
        GdtLog.d("GdtCanvasDataBuilder", "filter error, has no valid page");
        return;
      }
      localObject = new ArrayList();
      Iterator localIterator = localGdtCanvasPageData.components.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        GdtCanvasComponentData localGdtCanvasComponentData = (GdtCanvasComponentData)localIterator.next();
        if ((localGdtCanvasComponentData != null) && (localGdtCanvasComponentData.isValid()))
        {
          int j = i;
          if ((localGdtCanvasComponentData instanceof GdtCanvasVideoComponentData))
          {
            if (i == 0) {
              j = 1;
            }
          }
          else
          {
            ((List)localObject).add(localGdtCanvasComponentData);
            i = j;
          }
        }
      }
      localGdtCanvasPageData.components = ((List)localObject);
      paramGdtCanvasData.pages = new ArrayList();
      paramGdtCanvasData.pages.add(localGdtCanvasPageData);
      return;
      localGdtCanvasPageData = null;
    }
  }
  
  private static void a(JSONObject paramJSONObject, int paramInt, GdtCanvasComponentData paramGdtCanvasComponentData)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL) || (paramGdtCanvasComponentData == null))
    {
      GdtLog.d("GdtCanvasDataBuilder", "initComponent error");
      return;
    }
    paramGdtCanvasComponentData.id = paramJSONObject.optString("id");
    paramGdtCanvasComponentData.type = paramJSONObject.optInt("type");
  }
  
  private static List b(GdtAd paramGdtAd, JSONArray paramJSONArray, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONArray == null) || (paramJSONArray == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getCanvasComponents error");
      return localArrayList;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      GdtCanvasComponentData localGdtCanvasComponentData = a(paramGdtAd, paramJSONArray.optJSONObject(i), paramInt);
      if (localGdtCanvasComponentData != null) {
        localArrayList.add(localGdtCanvasComponentData);
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.GdtCanvasDataBuilder
 * JD-Core Version:    0.7.0.1
 */