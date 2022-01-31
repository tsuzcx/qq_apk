package com.tencent.gdtad.views.canvas;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormItemData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormTableData;
import com.tencent.gdtad.views.canvas.components.form.textbox.GdtCanvasFormItemTextBoxData;
import com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoComponentData;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasButtonData;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasPageData;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasTextData;
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
    return Double.valueOf(1.0D * paramFloat * ViewUtils.a() / paramInt).intValue();
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
    if ((paramGdtAd == null) || (paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getCanvasData error");
      return null;
    }
    GdtCanvasData localGdtCanvasData = new GdtCanvasData();
    localGdtCanvasData.ad = paramGdtAd;
    try
    {
      paramGdtAd = paramJSONObject.getJSONObject("adCanvasInfo");
      localGdtCanvasData.ad.advertiserId = paramGdtAd.optLong("accountId", -2147483648L);
      localGdtCanvasData.id = paramGdtAd.optString("id");
      localGdtCanvasData.name = paramGdtAd.optString("canvasName");
      localGdtCanvasData.actionSetId = paramGdtAd.optLong("actionsetId", -2147483648L);
      localGdtCanvasData.basicWidth = paramGdtAd.optInt("basicWidth", 1080);
      localGdtCanvasData.pages = a(paramGdtAd.optJSONArray("PageList"), localGdtCanvasData.basicWidth);
      return localGdtCanvasData;
    }
    catch (JSONException paramGdtAd)
    {
      GdtLog.d("GdtCanvasDataBuilder", "getCanvasData error");
    }
    return localGdtCanvasData;
  }
  
  private static GdtCanvasComponentData a(JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getComponent error");
      return null;
    }
    try
    {
      i = paramJSONObject.getInt("type");
      switch (i)
      {
      default: 
        GdtLog.d("GdtCanvasDataBuilder", "getComponent error, type is unknown\n" + paramJSONObject.toString());
        return null;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        GdtLog.d("GdtCanvasDataBuilder", "getComponent error", localJSONException);
        int i = -2147483648;
      }
      return a(paramJSONObject, paramInt);
    }
    return a(paramJSONObject, paramInt);
    return a(paramJSONObject, paramInt);
    return a(paramJSONObject, paramInt);
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
    localGdtCanvasButtonComponentData.height = a(paramInt, 124.0F);
    localGdtCanvasButtonComponentData.paddingTop = a(paramInt, paramJSONObject.optInt("paddingTop", 40));
    localGdtCanvasButtonComponentData.paddingBottom = a(paramInt, paramJSONObject.optInt("paddingBottom", 40));
    localGdtCanvasButtonComponentData.paddingLeft = a(paramInt, 60.0F);
    localGdtCanvasButtonComponentData.paddingRight = a(paramInt, 60.0F);
    localGdtCanvasButtonComponentData.button.backgroundColor = a(paramJSONObject.optString("btnBgColor"), 0);
    localGdtCanvasButtonComponentData.button.text.text = paramJSONObject.optString("btnTitle", "提交");
    localGdtCanvasButtonComponentData.button.text.color = a(paramJSONObject.optString("fontColor"), 0);
    localGdtCanvasButtonComponentData.button.text.size = a(paramInt, 40.0F);
    localGdtCanvasButtonComponentData.actionUrl = paramJSONObject.optString("btnLinkUrl");
    localGdtCanvasButtonComponentData.button.borderCornerRadius = a(paramInt, 6.0F);
    return localGdtCanvasButtonComponentData;
  }
  
  private static GdtCanvasFormComponentData a(JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getFormComponent error");
      return null;
    }
    GdtCanvasFormComponentData localGdtCanvasFormComponentData = new GdtCanvasFormComponentData();
    a(paramJSONObject, paramInt, localGdtCanvasFormComponentData);
    Object localObject;
    try
    {
      localGdtCanvasFormComponentData.paddingTop = a(paramInt, paramJSONObject.getInt("paddingTop"));
      localGdtCanvasFormComponentData.paddingBottom = a(paramInt, paramJSONObject.getInt("paddingBottom"));
      localGdtCanvasFormComponentData.formId = paramJSONObject.getLong("formId");
      localGdtCanvasFormComponentData.padding = a(paramInt, 60.0F);
      localGdtCanvasFormComponentData.backgroundColor = a(paramJSONObject.getString("backgroundColor"), 0);
      localObject = paramJSONObject.getJSONObject("title");
      if (((JSONObject)localObject).getBoolean("visible"))
      {
        localGdtCanvasFormComponentData.title = new GdtCanvasTextData();
        localGdtCanvasFormComponentData.title.text = ((JSONObject)localObject).getString("text");
        localGdtCanvasFormComponentData.title.color = a(((JSONObject)localObject).getString("fontColor"), 0);
        localGdtCanvasFormComponentData.title.size = a(paramInt, ((JSONObject)localObject).getInt("fontSize"));
      }
      localObject = paramJSONObject.getJSONObject("submitButton");
      localGdtCanvasFormComponentData.button.text.text = ((JSONObject)localObject).getString("text");
      localGdtCanvasFormComponentData.button.text.color = a(((JSONObject)localObject).getString("fontColor"), 0);
      localGdtCanvasFormComponentData.button.text.size = a(paramInt, 40.0F);
      localGdtCanvasFormComponentData.button.borderCornerRadius = a(paramInt, 6.0F);
      localGdtCanvasFormComponentData.button.backgroundColor = a(((JSONObject)localObject).getString("backgroundColor"), 0);
      localGdtCanvasFormComponentData.buttonHeight = a(paramInt, 124.0F);
      localGdtCanvasFormComponentData.table.borderCornerRadius = a(paramInt, 6.0F);
      localGdtCanvasFormComponentData.table.borderWidth = a(paramInt, 3.0F);
      localGdtCanvasFormComponentData.table.borderColor = a("#EAEAEB", 0);
      localGdtCanvasFormComponentData.table.borderColorError = a("#FE6C6C", 0);
      paramJSONObject = paramJSONObject.getJSONArray("items");
      if (paramJSONObject.length() <= 0)
      {
        GdtLog.d("GdtCanvasDataBuilder", "getFormComponent error");
        return null;
      }
    }
    catch (JSONException paramJSONObject)
    {
      GdtLog.d("GdtCanvasDataBuilder", "getFormComponent", paramJSONObject);
      return null;
    }
    while (i < paramJSONObject.length())
    {
      localObject = a(paramJSONObject.getJSONObject(i), paramInt);
      if (!localGdtCanvasFormComponentData.table.addItem((GdtCanvasFormItemData)localObject)) {
        GdtLog.d("GdtCanvasDataBuilder", "getFormComponent error");
      }
      i += 1;
    }
    return localGdtCanvasFormComponentData;
  }
  
  private static GdtCanvasFormItemData a(JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getFormItem error");
      return null;
    }
    try
    {
      int i = paramJSONObject.getInt("type");
      switch (i)
      {
      default: 
        GdtLog.d("GdtCanvasDataBuilder", "getFormItem error");
        return null;
      }
    }
    catch (JSONException paramJSONObject)
    {
      GdtLog.d("GdtCanvasDataBuilder", "getFormItem", paramJSONObject);
      return null;
    }
    return a(paramJSONObject, paramInt);
  }
  
  private static GdtCanvasFormItemTextBoxData a(JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getFormItemTextBox error");
      return null;
    }
    GdtCanvasFormItemTextBoxData localGdtCanvasFormItemTextBoxData = new GdtCanvasFormItemTextBoxData();
    if (!a(paramJSONObject, paramInt, localGdtCanvasFormItemTextBoxData, 0))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getFormItemTextBox error");
      return null;
    }
    localGdtCanvasFormItemTextBoxData.regexType = paramJSONObject.optInt("regexType", -2147483648);
    localGdtCanvasFormItemTextBoxData.content.color = a("#333333", 0);
    localGdtCanvasFormItemTextBoxData.content.size = a(paramInt, 40.0F);
    localGdtCanvasFormItemTextBoxData.content.lengthMax = paramJSONObject.optInt("maxLength", -2147483648);
    return localGdtCanvasFormItemTextBoxData;
  }
  
  /* Error */
  private static com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData a(JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: getstatic 94	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   8: if_acmpne +13 -> 21
    //   11: ldc 36
    //   13: ldc_w 377
    //   16: invokestatic 64	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 379	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData
    //   24: dup
    //   25: invokespecial 380	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:<init>	()V
    //   28: astore_2
    //   29: aload_0
    //   30: iload_1
    //   31: aload_2
    //   32: invokestatic 193	com/tencent/gdtad/views/canvas/GdtCanvasDataBuilder:a	(Lorg/json/JSONObject;ILcom/tencent/gdtad/views/canvas/components/GdtCanvasComponentData;)V
    //   35: aload_2
    //   36: iload_1
    //   37: aload_0
    //   38: ldc_w 382
    //   41: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   44: i2f
    //   45: invokestatic 196	com/tencent/gdtad/views/canvas/GdtCanvasDataBuilder:a	(IF)I
    //   48: putfield 385	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:width	I
    //   51: aload_2
    //   52: iload_1
    //   53: aload_0
    //   54: ldc_w 387
    //   57: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   60: i2f
    //   61: invokestatic 196	com/tencent/gdtad/views/canvas/GdtCanvasDataBuilder:a	(IF)I
    //   64: putfield 388	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:height	I
    //   67: aload_2
    //   68: iload_1
    //   69: aload_0
    //   70: ldc 201
    //   72: iconst_0
    //   73: invokevirtual 145	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   76: i2f
    //   77: invokestatic 196	com/tencent/gdtad/views/canvas/GdtCanvasDataBuilder:a	(IF)I
    //   80: putfield 389	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:paddingTop	I
    //   83: aload_2
    //   84: iload_1
    //   85: aload_0
    //   86: ldc 205
    //   88: iconst_0
    //   89: invokevirtual 145	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   92: i2f
    //   93: invokestatic 196	com/tencent/gdtad/views/canvas/GdtCanvasDataBuilder:a	(IF)I
    //   96: putfield 390	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:paddingBottom	I
    //   99: aload_2
    //   100: aload_0
    //   101: ldc_w 392
    //   104: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: putfield 394	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:imageId	Ljava/lang/String;
    //   110: aload_2
    //   111: aload_0
    //   112: ldc_w 396
    //   115: invokevirtual 282	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: putfield 399	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:url	Ljava/lang/String;
    //   121: aload_2
    //   122: aload_0
    //   123: ldc_w 401
    //   126: invokevirtual 127	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: putfield 402	com/tencent/gdtad/views/canvas/components/picture/GdtCanvasPictureComponentData:actionUrl	Ljava/lang/String;
    //   132: aload_2
    //   133: areturn
    //   134: astore_2
    //   135: ldc 36
    //   137: new 66	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 404
    //   147: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_0
    //   151: invokevirtual 172	org/json/JSONObject:toString	()Ljava/lang/String;
    //   154: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: aload_2
    //   161: invokestatic 44	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: aconst_null
    //   165: areturn
    //   166: astore_2
    //   167: ldc 36
    //   169: new 66	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 404
    //   179: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: invokevirtual 172	org/json/JSONObject:toString	()Ljava/lang/String;
    //   186: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: aload_2
    //   193: invokestatic 44	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
  
  private static GdtCanvasVideoComponentData a(JSONObject paramJSONObject, int paramInt)
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
  
  private static GdtCanvasPageData a(JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      GdtLog.d("GdtCanvasDataBuilder", "getPage error");
      return null;
    }
    GdtCanvasPageData localGdtCanvasPageData = new GdtCanvasPageData();
    localGdtCanvasPageData.id = paramJSONObject.optString("id");
    localGdtCanvasPageData.backgroundColor = a(paramJSONObject.optString("backgroundColor"), -1);
    localGdtCanvasPageData.components = b(paramJSONObject.optJSONArray("componentItemList"), paramInt);
    return localGdtCanvasPageData;
  }
  
  private static List a(JSONArray paramJSONArray, int paramInt)
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
      GdtCanvasPageData localGdtCanvasPageData = a(paramJSONArray.optJSONObject(i), paramInt);
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
    while (paramGdtCanvasData.getSize() <= 0) {
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
  }
  
  private static boolean a(JSONObject paramJSONObject, int paramInt1, GdtCanvasFormItemData paramGdtCanvasFormItemData, int paramInt2)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL) || (paramGdtCanvasFormItemData == null))
    {
      GdtLog.d("GdtCanvasDataBuilder", "initFormItem error");
      return false;
    }
    try
    {
      if (paramJSONObject.getInt("type") != paramInt2)
      {
        GdtLog.d("GdtCanvasDataBuilder", "initFormItem type error");
        return false;
      }
    }
    catch (JSONException paramJSONObject)
    {
      GdtLog.d("GdtCanvasDataBuilder", "initFormItem", paramJSONObject);
      return false;
    }
    paramGdtCanvasFormItemData.paddingTop = a(paramInt1, 60.0F);
    paramGdtCanvasFormItemData.paddingBottom = a(paramInt1, 60.0F);
    paramGdtCanvasFormItemData.backgroundColor = a("#FDFEFF", 0);
    paramGdtCanvasFormItemData.required = paramJSONObject.getBoolean("require");
    paramGdtCanvasFormItemData.title.text = paramJSONObject.getString("name");
    paramGdtCanvasFormItemData.title.color = a("#333333", 0);
    paramGdtCanvasFormItemData.title.size = a(paramInt1, 40.0F);
    paramGdtCanvasFormItemData.titlePaddingLeft = a(paramInt1, 60.0F);
    paramGdtCanvasFormItemData.titlePaddingRight = a(paramInt1, 15.0F);
    paramGdtCanvasFormItemData.contentPaddingLeft = a(paramInt1, 15.0F);
    paramGdtCanvasFormItemData.contentPaddingRight = a(paramInt1, 60.0F);
    if (paramJSONObject.has("placeholder"))
    {
      paramGdtCanvasFormItemData.placeholder = new GdtCanvasTextData();
      paramGdtCanvasFormItemData.placeholder.text = paramJSONObject.optString("placeholder");
      paramGdtCanvasFormItemData.placeholder.color = a("#B9BDC2", 0);
      paramGdtCanvasFormItemData.placeholder.size = a(paramInt1, 40.0F);
    }
    return true;
  }
  
  private static List b(JSONArray paramJSONArray, int paramInt)
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
      GdtCanvasComponentData localGdtCanvasComponentData = a(paramJSONArray.optJSONObject(i), paramInt);
      if (localGdtCanvasComponentData != null) {
        localArrayList.add(localGdtCanvasComponentData);
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.GdtCanvasDataBuilder
 * JD-Core Version:    0.7.0.1
 */