package com.tencent.ad.tangram.views.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.Keep;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.canvas.AdReport;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
public class AdCanvasDataBuilderV2
{
  private static final String TAG = "AdCanvasDataBuilderV2";
  private static com.tencent.ad.tangram.views.a imageLoadParams;
  
  public static AdCanvasData build(Context paramContext, Ad paramAd)
  {
    return build(paramContext, paramAd, false);
  }
  
  public static AdCanvasData build(Context paramContext, Ad paramAd, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    boolean bool = true;
    if (paramAd == null)
    {
      AdLog.e("AdCanvasDataBuilderV2", "build error");
      AdReport.reportForCanvasDataBuildError(paramContext, 1, null, null);
      com.tencent.ad.tangram.statistics.canvas.a.reportForCanvasDataBuildError(paramContext, null, String.valueOf(1));
      return null;
    }
    Object localObject = paramAd.getCanvas();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AdLog.e("AdCanvasDataBuilderV2", "build error");
      AdReport.reportForCanvasDataBuildError(paramContext, 2, paramAd, null);
      com.tencent.ad.tangram.statistics.canvas.a.reportForCanvasDataBuildError(paramContext, paramAd, String.valueOf(2));
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("build ");
    localStringBuilder.append((String)localObject);
    AdLog.i("AdCanvasDataBuilderV2", localStringBuilder.toString());
    for (;;)
    {
      try
      {
        localObject = getCanvasData(paramContext, paramAd, new JSONObject((String)localObject), paramBoolean);
        setActiveAppBtnView((AdCanvasData)localObject);
        AdReport.reportForCanvasDataBuildEnd(paramContext, paramAd, System.currentTimeMillis() - l);
        if ((localObject != null) && (((AdCanvasData)localObject).isValid()))
        {
          paramBoolean = bool;
          com.tencent.ad.tangram.statistics.canvas.a.reportForCanvasDataBuildEnd(paramContext, paramAd, paramBoolean, System.currentTimeMillis() - l);
          return localObject;
        }
      }
      catch (Throwable paramContext)
      {
        AdLog.e("AdCanvasDataBuilderV2", "build error", paramContext);
        return null;
      }
      paramBoolean = false;
    }
  }
  
  private static com.tencent.ad.tangram.views.canvas.components.appbutton.c getAppButtonComponent(Context paramContext, JSONObject paramJSONObject, int paramInt)
  {
    if (JSONObject.NULL.equals(paramJSONObject))
    {
      AdLog.e("AdCanvasDataBuilderV2", "getAppButtonComponent error");
      return null;
    }
    JSONObject localJSONObject = paramJSONObject.getJSONObject("config");
    com.tencent.ad.tangram.views.canvas.components.appbutton.c localc = new com.tencent.ad.tangram.views.canvas.components.appbutton.c();
    initComponent(paramJSONObject, paramInt, localc);
    localc.button.text.text = unescapeHtml(localJSONObject.getJSONObject("content").getString("text"));
    if (!localc.button.text.text.contains("下载")) {
      localc.button.text.text = "下载APP";
    }
    paramJSONObject = localJSONObject.getJSONObject("style");
    localc.button.text.color = getColor(paramJSONObject.getString("color"));
    localc.button.backgroundColor = getColor(paramJSONObject.getString("backgroundColor"));
    localc.button.borderCornerRadius = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("borderRadius"));
    localc.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("fontSize"));
    int i = paramJSONObject.getInt("width");
    localc.height = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("lineHeight"));
    paramJSONObject = localJSONObject.getJSONObject("wrapper");
    String str = paramJSONObject.getString("textAlign");
    if (TextUtils.equals(str, "center"))
    {
      localc.gravity = 17;
    }
    else if (TextUtils.equals(str, "left"))
    {
      localc.gravity = 3;
    }
    else
    {
      if (!TextUtils.equals(str, "right")) {
        break label471;
      }
      localc.gravity = 5;
    }
    localc.paddingLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("marginLeft"));
    localc.paddingRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("marginRight"));
    localc.width = ((AdUIUtils.getPhysicalScreenWidth(paramContext) - localc.paddingLeft - localc.paddingRight) * i / 100);
    localc.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("marginTop"));
    localc.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("marginBottom"));
    localc.isFixed = localJSONObject.getBoolean("isFixed");
    if (localc.isFixed)
    {
      paramJSONObject = localJSONObject.getJSONObject("position");
      localc.toBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("toBottom"));
      localc.whiteSpace = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("whiteSpace"));
    }
    paramContext = imageLoadParams;
    if (paramContext != null) {
      paramContext.currentLength += localc.paddingBottom + localc.paddingTop + localc.height;
    }
    return localc;
    label471:
    throw new Exception("unknow button align");
  }
  
  private static AdCanvasComponentData getAppIconComponent(Context paramContext, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      com.tencent.ad.tangram.views.canvas.components.appIcon.a locala = new com.tencent.ad.tangram.views.canvas.components.appIcon.a();
      initComponent(paramJSONObject, paramAdCanvasData.basicWidth, locala);
      JSONObject localJSONObject = paramJSONObject.getJSONObject("config");
      paramJSONObject = localJSONObject.getJSONObject("appInfo");
      localJSONObject = localJSONObject.getJSONObject("wrapper");
      int i = paramAdCanvasData.basicWidth;
      locala.logoWidth = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 64);
      locala.logoHeight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 64);
      locala.logoUrl = paramJSONObject.getString("logoUrl");
      locala.name = paramJSONObject.getString("name");
      locala.downloadCount = paramJSONObject.optLong("downloadCount");
      locala.fileSize = paramJSONObject.getLong("fileSize");
      if (paramJSONObject.isNull("starCount")) {
        locala.starCount = 4;
      } else {
        locala.starCount = paramJSONObject.getInt("starCount");
      }
      locala.marginLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, localJSONObject.getInt("marginLeft"));
      locala.marginTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, localJSONObject.getInt("marginTop"));
      locala.marginRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, localJSONObject.getInt("marginRight"));
      locala.marginBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, localJSONObject.getInt("marginBottom"));
      paramJSONObject = new com.tencent.ad.tangram.views.canvas.components.appbutton.c();
      paramAdCanvasData = new StringBuilder();
      paramAdCanvasData.append("XJAppIcon_AppBtn_");
      paramAdCanvasData.append(locala.logoUrl.hashCode());
      paramJSONObject.id = paramAdCanvasData.toString();
      paramJSONObject.width = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 71);
      paramJSONObject.height = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 36);
      paramJSONObject.fontColor = -1;
      paramJSONObject.gravity = 17;
      paramJSONObject.button.borderCornerRadius = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 17);
      paramJSONObject.button.text.text = "下载";
      paramJSONObject.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 16);
      paramJSONObject.button.text.color = -1;
      paramJSONObject.button.backgroundColor = getColor("#20A0FF");
      locala.adCanvasAppBtnComponentData = paramJSONObject;
      paramContext = imageLoadParams;
      if (paramContext != null) {
        paramContext.currentLength += locala.logoHeight + locala.marginBottom + locala.marginTop;
      }
      return locala;
    }
    AdLog.e("AdCanvasDataBuilderV2", "getAppIconComponent error");
    return null;
  }
  
  private static com.tencent.ad.tangram.views.canvas.components.appInfoButton.a getAppInfoButtonComponent(Context paramContext, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
  {
    if (JSONObject.NULL.equals(paramJSONObject))
    {
      AdLog.e("AdCanvasDataBuilderV2", "getAppInfoButtonComponent error");
      return null;
    }
    com.tencent.ad.tangram.views.canvas.components.appInfoButton.a locala = new com.tencent.ad.tangram.views.canvas.components.appInfoButton.a();
    initComponent(paramJSONObject, paramAdCanvasData.basicWidth, locala);
    paramJSONObject = paramJSONObject.getJSONObject("config");
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject("appInfo");
    JSONObject localJSONObject2 = paramJSONObject.getJSONObject("style");
    JSONObject localJSONObject3 = paramJSONObject.getJSONObject("content");
    int i = paramAdCanvasData.basicWidth;
    locala.downloadCount = localJSONObject1.optLong("downloadCount");
    locala.logoUrl = localJSONObject1.getString("logoUrl");
    locala.appName = localJSONObject1.getString("name");
    locala.fileSize = localJSONObject1.getLong("fileSize");
    locala.desc = unescapeHtml(localJSONObject3.getString("text"));
    locala.backgroundColor = getColor(paramJSONObject.getString("backgroundColor"));
    locala.button.backgroundColor = getColor(localJSONObject2.getString("backgroundColor"));
    locala.button.text.text = "立即下载";
    locala.button.text.color = getColor(localJSONObject2.getString("color"));
    locala.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, AdUIUtils.getPxFromString(localJSONObject2.getString("fontSize"), "appInfo button fontSize"));
    locala.button.borderCornerRadius = AdUIUtils.getPxFromString(localJSONObject2.getString("borderRadius"), "appInfo button borderRadius");
    locala.width = (AdUIUtils.getPhysicalScreenWidth(paramContext) * AdUIUtils.getPercentageFromString(localJSONObject2.getString("width"), "appInfo button width") / 100);
    locala.height = AdUIUtils.dp2px(AdUIUtils.getPxFromString(localJSONObject2.getString("height"), "appInfo button height"), paramContext.getResources());
    return locala;
  }
  
  private static List<AdCanvasComponentData> getCanvasComponents(Context paramContext, Ad paramAd, JSONArray paramJSONArray, AdCanvasData paramAdCanvasData)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONArray != null) && (!JSONObject.NULL.equals(paramJSONArray)))
    {
      boolean bool = paramAd.isHitFirstLoadImageExp();
      int j = 0;
      int i = j;
      if (bool)
      {
        imageLoadParams = new com.tencent.ad.tangram.views.a(0, false, new AtomicInteger(0));
        i = j;
      }
      while (i < paramJSONArray.length())
      {
        AdCanvasComponentData localAdCanvasComponentData = getComponent(paramContext, paramAd, paramJSONArray.getJSONObject(i), paramAdCanvasData);
        if (localAdCanvasComponentData != null) {
          if ((localAdCanvasComponentData instanceof com.tencent.ad.tangram.views.canvas.components.fixedbutton.a))
          {
            paramAdCanvasData.fixedButtonComponentDataList.add((com.tencent.ad.tangram.views.canvas.components.fixedbutton.a)localAdCanvasComponentData);
          }
          else if ((localAdCanvasComponentData instanceof com.tencent.ad.tangram.views.canvas.components.appbutton.c))
          {
            com.tencent.ad.tangram.views.canvas.components.appbutton.c localc = (com.tencent.ad.tangram.views.canvas.components.appbutton.c)localAdCanvasComponentData;
            if (localc.isFixed) {
              paramAdCanvasData.appFixedButtonComponentDataList.add(localc);
            } else {
              localArrayList.add(localAdCanvasComponentData);
            }
          }
          else
          {
            localArrayList.add(localAdCanvasComponentData);
          }
        }
        i += 1;
      }
      return localArrayList;
    }
    AdLog.e("AdCanvasDataBuilderV2", "getCanvasComponents error");
    AdReport.reportForCanvasDataBuildError(paramContext, 5, paramAd, null);
    com.tencent.ad.tangram.statistics.canvas.a.reportForCanvasDataBuildError(paramContext, paramAd, String.valueOf(5));
    return localArrayList;
  }
  
  private static AdCanvasData getCanvasData(Context paramContext, Ad paramAd, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if ((paramAd != null) && (paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      AdCanvasData localAdCanvasData = new AdCanvasData();
      localAdCanvasData.ad = paramAd;
      localAdCanvasData.setAutodownload(paramBoolean);
      Object localObject = paramJSONObject.optJSONObject("content");
      if ((localObject != null) && (!JSONObject.NULL.equals(localObject)))
      {
        getPageList(paramContext, paramAd, localAdCanvasData, (JSONObject)localObject);
        return localAdCanvasData;
      }
      paramJSONObject = paramJSONObject.getString("canvas_json_key");
      paramJSONObject = AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramAd, paramJSONObject, true);
      if (TextUtils.isEmpty(paramJSONObject))
      {
        AdReport.reportForCanvasDataBuildError(paramContext, 3, paramAd, null);
        com.tencent.ad.tangram.statistics.canvas.a.reportForCanvasDataBuildError(paramContext, paramAd, String.valueOf(3));
        return null;
      }
      JSONObject localJSONObject = new JSONObject(paramJSONObject);
      paramJSONObject = localJSONObject.getJSONObject("content");
      localObject = localJSONObject.getString("lastModTime");
      localJSONObject = localJSONObject.getJSONObject("appRights");
      String str = localJSONObject.getString("appCriteriaTime");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
      {
        long l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str, new ParsePosition(0)).getTime();
        if (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)localObject, new ParsePosition(0)).getTime() < l)
        {
          AdLog.e("AdCanvasDataBuilderV2", "getCanvasData return null cause lastModTimeMillis < inValidTimeMillis");
          return null;
        }
      }
      localAdCanvasData.appInfoRightUrl = localJSONObject.optString("appInfoRightUrl");
      getPageList(paramContext, paramAd, localAdCanvasData, paramJSONObject);
      return localAdCanvasData;
    }
    AdLog.e("AdCanvasDataBuilderV2", "getCanvasData error");
    return null;
  }
  
  public static int getColor(String paramString)
  {
    if (paramString.indexOf("rgb") >= 0) {
      return getRgbColor(paramString);
    }
    Object localObject = paramString;
    if (paramString.length() == 4)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(paramString.substring(1, 4));
      localObject = ((StringBuilder)localObject).toString();
    }
    return Color.parseColor((String)localObject);
  }
  
  private static AdCanvasComponentData getComponent(Context paramContext, Ad paramAd, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
  {
    Context localContext = null;
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      String str = paramJSONObject.getString("type");
      if (!TextUtils.isEmpty(str)) {
        if (str.equals("XJAPPH5Images"))
        {
          paramContext = getMulitiPictureComponent(paramContext, paramJSONObject, paramAdCanvasData);
          localContext = paramContext;
          if (paramContext != null)
          {
            paramAdCanvasData.hasMultiPictureData = true;
            return paramContext;
          }
        }
        else
        {
          if (str.equals("XJAppH5Button")) {
            return getAppButtonComponent(paramContext, paramJSONObject, paramAdCanvasData.basicWidth);
          }
          if (str.equals("XJFixedButton"))
          {
            paramContext = getFixedButtonComponent(paramContext, paramAd, paramJSONObject, paramAdCanvasData.basicWidth);
            localContext = paramContext;
            if (paramContext != null)
            {
              paramAdCanvasData.hasFixedButtonData = true;
              return paramContext;
            }
          }
          else
          {
            if (str.equals("XJText")) {
              return getTextComponent(paramContext, paramAd, paramJSONObject, paramAdCanvasData.basicWidth);
            }
            if (str.equals("XJImages")) {
              return getWebMulitiPictureComponent(paramContext, paramJSONObject, paramAdCanvasData);
            }
            if (str.equals("XJDEFAULTImagesCarousel")) {
              return getImagesCarouselComponent(paramContext, paramJSONObject, paramAdCanvasData);
            }
            if (str.equals("XJAPPIcon")) {
              return getAppIconComponent(paramContext, paramJSONObject, paramAdCanvasData);
            }
            if (str.equals("XJAPPTitle")) {
              return getTitleComponent(paramContext, paramJSONObject, paramAdCanvasData);
            }
            if (str.equals("XJLayerCard")) {
              return getLayerCardComponent(paramContext, paramAd, paramJSONObject, paramAdCanvasData);
            }
            if (str.equals("XJAPPInfoButton")) {
              return getAppInfoButtonComponent(paramContext, paramJSONObject, paramAdCanvasData);
            }
            AdReport.reportForCanvasDataBuildError(paramContext, 0, paramAd, str);
            com.tencent.ad.tangram.statistics.canvas.a.reportForCanvasDataBuildError(paramContext, paramAd, str);
            throw new Exception("unknow type exception");
          }
        }
      }
      return localContext;
    }
    AdLog.e("AdCanvasDataBuilderV2", "getComponent error");
    AdReport.reportForCanvasDataBuildError(paramContext, 6, paramAd, null);
    com.tencent.ad.tangram.statistics.canvas.a.reportForCanvasDataBuildError(paramContext, paramAd, String.valueOf(6));
    return null;
  }
  
  private static com.tencent.ad.tangram.views.canvas.components.fixedbutton.a getFixedButtonComponent(Context paramContext, Ad paramAd, JSONObject paramJSONObject, int paramInt)
  {
    if (JSONObject.NULL.equals(paramJSONObject))
    {
      AdLog.e("AdCanvasDataBuilderV2", "getFixedButtonComponent error");
      return null;
    }
    paramAd = new com.tencent.ad.tangram.views.canvas.components.fixedbutton.a();
    initComponent(paramJSONObject, paramInt, paramAd);
    JSONObject localJSONObject = paramJSONObject.getJSONObject("config");
    paramJSONObject = localJSONObject.getJSONObject("content");
    paramAd.buttonStyle = paramJSONObject.getString("buttonStyle");
    paramAd.position = paramJSONObject.getString("position");
    paramAd.desc = unescapeHtml(paramJSONObject.getString("desc"));
    paramAd.button.text.text = unescapeHtml(paramJSONObject.getString("text"));
    if (!paramAd.button.text.text.contains("下载")) {
      paramAd.button.text.text = "下载APP";
    }
    paramAd.imageUrl = paramJSONObject.getString("logoUrl");
    validateUrl(paramAd.imageUrl);
    paramAd.name = unescapeHtml(paramJSONObject.getString("name"));
    paramAd.fileSize = paramJSONObject.getInt("fileSize");
    localJSONObject = localJSONObject.getJSONObject("style");
    paramAd.button.text.color = getColor(localJSONObject.getString("color"));
    paramAd.button.backgroundColor = getColor(localJSONObject.getString("backgroundColor"));
    if (!TextUtils.isEmpty(paramAd.buttonStyle))
    {
      int i;
      if (paramAd.buttonStyle.equals("fixedBtn-1"))
      {
        paramAd.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, 13);
        paramAd.button.text.text = "下载";
        paramAd.width = AdUIUtils.dp2px(81.0F, paramContext.getResources());
        paramAd.height = AdUIUtils.dp2px(40.0F, paramContext.getResources());
      }
      else
      {
        if (!paramAd.buttonStyle.equals("fixedBtn-2")) {
          break label560;
        }
        paramAd.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, 19);
        paramAd.gravity = 17;
        i = AdUIUtils.dp2px(5.0F, paramContext.getResources());
        paramAd.paddingTop = i;
        paramAd.paddingBottom = i;
        i = AdUIUtils.dp2px(7.5F, paramContext.getResources());
        paramAd.paddingRight = i;
        paramAd.paddingLeft = i;
        paramAd.width = (AdUIUtils.getPhysicalScreenWidth(paramContext) - paramAd.paddingLeft * 2);
        paramAd.height = AdUIUtils.dp2px(40.0F, paramContext.getResources());
      }
      if ((!TextUtils.isEmpty(paramAd.position)) && ((paramAd.position.toLowerCase().equals("top")) || (paramAd.position.toLowerCase().equals("bottom"))))
      {
        i = paramJSONObject.optInt("bottomWhiteSpace");
        int j = paramJSONObject.optInt("topWhiteSpace");
        if (paramAd.position.toLowerCase().equals("top"))
        {
          paramAd.topWhiteSpace += AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, j);
          return paramAd;
        }
        if (paramAd.position.toLowerCase().equals("bottom")) {
          paramAd.bottomWhiteSpace += AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, i);
        }
        return paramAd;
      }
      throw new Exception("unKnow button position");
      label560:
      throw new Exception("unKnow button style");
    }
    throw new Exception("unKnow button style");
  }
  
  private static com.tencent.ad.tangram.views.canvas.components.pictures.c getHotArea(Context paramContext, int paramInt, String paramString, JSONObject paramJSONObject, com.tencent.ad.tangram.views.canvas.components.picture.a parama)
  {
    if (parama == null) {
      return null;
    }
    paramInt = AdUIUtils.getPhysicalScreenWidth(paramContext);
    paramContext = new com.tencent.ad.tangram.views.canvas.components.pictures.c();
    paramString = paramJSONObject.getJSONObject(paramString);
    if (paramString == null) {
      return null;
    }
    int i = parama.height;
    int j = parama.paddingBottom;
    int k = parama.paddingTop;
    float f2 = paramString.getJSONObject("position").getInt("left") / 100.0F;
    float f1 = paramInt;
    paramContext.x = ((int)(f2 * f1));
    f2 = paramString.getJSONObject("position").getInt("top") / 100.0F;
    float f3 = i + j + k;
    paramContext.y = ((int)(f2 * f3));
    paramContext.width = ((int)(paramString.getJSONObject("style").getInt("width") / 100.0F * f1));
    paramContext.height = ((int)(paramString.getJSONObject("style").getInt("height") / 100.0F * f3));
    paramContext.linkType = paramString.getJSONObject("link").getString("linkType");
    paramContext.url = paramString.getJSONObject("link").optString("url");
    return paramContext;
  }
  
  private static AdCanvasComponentData getImagesCarouselComponent(Context paramContext, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a locala = new com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a();
      int m = paramAdCanvasData.basicWidth;
      initComponent(paramJSONObject, m, locala);
      paramAdCanvasData = new ArrayList();
      Object localObject1 = paramJSONObject.getJSONObject("config");
      paramJSONObject = ((JSONObject)localObject1).getJSONArray("images");
      Object localObject2 = ((JSONObject)localObject1).getJSONObject("wrapper");
      locala.displaySpeed = ((Integer)((JSONObject)localObject1).get("displaySpeed")).intValue();
      locala.pageLimit = 2;
      locala.pageMargin = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, 10);
      locala.enableImageRoundRectBackground = true;
      locala.imageRadius = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, 8);
      locala.imageBorderWidth = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, 1);
      locala.imageBorderColor = "#E3E3E3";
      locala.marginLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, ((JSONObject)localObject2).getInt("marginLeft"));
      locala.marginTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, ((JSONObject)localObject2).getInt("marginTop"));
      locala.marginRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, ((JSONObject)localObject2).getInt("marginRight"));
      locala.marginBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, ((JSONObject)localObject2).getInt("marginBottom"));
      int i = 0;
      int j = 0;
      int k = 0;
      while (i < paramJSONObject.length())
      {
        localObject1 = new com.tencent.ad.tangram.views.canvas.components.picture.a();
        localObject2 = ((JSONObject)paramJSONObject.get(i)).getJSONObject("image");
        j = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, ((JSONObject)localObject2).getInt("width"));
        k = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, ((JSONObject)localObject2).getInt("height"));
        ((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject1).width = j;
        ((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject1).height = k;
        ((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject1).url = ((JSONObject)localObject2).getString("url");
        validateUrl(((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject1).url);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject1).url.hashCode());
        ((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject1).id = ((StringBuilder)localObject2).toString();
        paramAdCanvasData.add(localObject1);
        if (imageLoadParams != null) {
          setImageInfo((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject1, paramContext);
        }
        i += 1;
      }
      locala.imageWidth = j;
      locala.imageHeight = k;
      locala.imageList = paramAdCanvasData;
      locala.width = (j * 2);
      locala.height = k;
      paramContext = imageLoadParams;
      if (paramContext != null) {
        paramContext.currentLength += k + locala.marginBottom + locala.marginTop;
      }
      return locala;
    }
    AdLog.e("AdCanvasDataBuilderV2", "getImagesCarouselComponent error");
    return null;
  }
  
  private static AdCanvasComponentData getLayerCardComponent(Context paramContext, Ad paramAd, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      paramAd = new com.tencent.ad.tangram.views.canvas.components.layerCard.a();
      int i = paramAdCanvasData.basicWidth;
      initComponent(paramJSONObject, i, paramAd);
      int j = AdUIUtils.getScreenWidth(paramContext);
      int k = AdUIUtils.getScreenHeight(paramContext);
      paramAd.width = j;
      paramAd.height = k;
      paramJSONObject = paramJSONObject.getJSONObject("config");
      paramAdCanvasData = new ArrayList();
      Object localObject1 = new com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("XJLayerCard_ImageCarousel_");
      ((StringBuilder)localObject2).append(paramAd.id.hashCode());
      ((com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a)localObject1).id = ((StringBuilder)localObject2).toString();
      localObject2 = paramJSONObject.getJSONArray("images");
      k = 0;
      while (k < ((JSONArray)localObject2).length())
      {
        com.tencent.ad.tangram.views.canvas.components.picture.a locala = new com.tencent.ad.tangram.views.canvas.components.picture.a();
        Object localObject3 = ((JSONObject)((JSONArray)localObject2).get(k)).getJSONObject("image");
        locala.width = j;
        double d1 = j;
        double d2 = ((JSONObject)localObject3).getInt("height");
        Double.isNaN(d2);
        double d3 = ((JSONObject)localObject3).getInt("width");
        Double.isNaN(d3);
        d2 = d2 * 1.0D / d3;
        Double.isNaN(d1);
        locala.height = Double.valueOf(d1 * d2).intValue();
        ((com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a)localObject1).width = locala.width;
        ((com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a)localObject1).height = locala.height;
        ((com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a)localObject1).imageWidth = locala.width;
        ((com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a)localObject1).imageHeight = locala.height;
        locala.gaussianUrl = ((JSONObject)localObject3).getString("guassianUrl");
        locala.url = ((JSONObject)localObject3).getString("url");
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(locala.url.hashCode());
        locala.id = ((StringBuilder)localObject3).toString();
        paramAdCanvasData.add(locala);
        if (imageLoadParams != null) {
          setImageInfo(locala, paramContext);
        }
        k += 1;
      }
      ((com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a)localObject1).imageList = paramAdCanvasData;
      ((com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a)localObject1).displaySpeed = 3;
      ((com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a)localObject1).pageLimit = 1;
      paramAd.adCanvasImagesCarouselComponentData = ((com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a)localObject1);
      paramAdCanvasData = paramJSONObject.getJSONObject("appInfo");
      paramAd.logoUrl = paramAdCanvasData.getString("logoUrl");
      j = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 70);
      paramAd.logoHeight = j;
      paramAd.logoWidth = j;
      paramAd.appName = unescapeHtml(paramAdCanvasData.getString("name"));
      paramAd.appDesc = unescapeHtml(paramAdCanvasData.getString("description"));
      paramAd.downloadCount = paramAdCanvasData.optLong("downloadCount");
      if (paramAdCanvasData.isNull("starCount")) {
        paramAd.starCount = 4;
      } else {
        paramAd.starCount = paramAdCanvasData.getInt("starCount");
      }
      paramJSONObject = paramJSONObject.getJSONObject("button");
      paramAdCanvasData = paramJSONObject.getJSONObject("style");
      localObject1 = new com.tencent.ad.tangram.views.canvas.components.appbutton.c();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("XJLayerCard_AppBtn_");
      ((StringBuilder)localObject2).append(paramAd.logoUrl.hashCode());
      ((com.tencent.ad.tangram.views.canvas.components.appbutton.c)localObject1).id = ((StringBuilder)localObject2).toString();
      ((com.tencent.ad.tangram.views.canvas.components.appbutton.c)localObject1).width = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 287);
      ((com.tencent.ad.tangram.views.canvas.components.appbutton.c)localObject1).height = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 40);
      ((com.tencent.ad.tangram.views.canvas.components.appbutton.c)localObject1).gravity = 17;
      ((com.tencent.ad.tangram.views.canvas.components.appbutton.c)localObject1).button.borderCornerRadius = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 3);
      ((com.tencent.ad.tangram.views.canvas.components.appbutton.c)localObject1).button.text.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 14);
      ((com.tencent.ad.tangram.views.canvas.components.appbutton.c)localObject1).button.text.text = unescapeHtml(paramJSONObject.getString("text"));
      ((com.tencent.ad.tangram.views.canvas.components.appbutton.c)localObject1).button.text.color = getColor(paramAdCanvasData.getString("color"));
      ((com.tencent.ad.tangram.views.canvas.components.appbutton.c)localObject1).button.backgroundColor = getColor(paramAdCanvasData.getString("backgroundColor"));
      paramAd.adCanvasAppBtnComponentData = ((com.tencent.ad.tangram.views.canvas.components.appbutton.c)localObject1);
      paramContext = imageLoadParams;
      if (paramContext != null) {
        paramContext.currentLength += paramAd.height;
      }
      return paramAd;
    }
    AdLog.e("AdCanvasDataBuilderV2", "getLayerCardComponent error");
    return null;
  }
  
  private static com.tencent.ad.tangram.views.canvas.components.pictures.a getMulitiPictureComponent(Context paramContext, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      com.tencent.ad.tangram.views.canvas.components.pictures.a locala = new com.tencent.ad.tangram.views.canvas.components.pictures.a();
      initComponent(paramJSONObject, paramAdCanvasData.basicWidth, locala);
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.getJSONObject("config").getJSONArray("images");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        com.tencent.ad.tangram.views.canvas.components.picture.a locala1 = new com.tencent.ad.tangram.views.canvas.components.picture.a();
        Object localObject1 = (JSONObject)paramJSONObject.get(i);
        Object localObject2 = ((JSONObject)localObject1).getJSONObject("padding");
        locala1.paddingLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, ((JSONObject)localObject2).getInt("left"));
        locala1.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, ((JSONObject)localObject2).getInt("top"));
        locala1.paddingRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, ((JSONObject)localObject2).getInt("right"));
        locala1.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, ((JSONObject)localObject2).getInt("bottom"));
        locala1.floatingBarTextColor = -1;
        locala1.floatingBarBackgroundColor = Color.parseColor("#1890ff");
        localObject2 = ((JSONObject)localObject1).getJSONObject("progressBar");
        locala1.floatingBarTextColor = getColor(((JSONObject)localObject2).getString("color"));
        locala1.floatingBarBackgroundColor = getColor(((JSONObject)localObject2).getString("backgroundColor"));
        localObject2 = ((JSONObject)localObject1).getJSONObject("image");
        int j = ((JSONObject)localObject2).getInt("width");
        int k = ((JSONObject)localObject2).getInt("height");
        locala1.width = (AdUIUtils.getPhysicalScreenWidth(paramContext) - locala1.paddingLeft - locala1.paddingRight);
        locala1.height = ((int)(locala1.width * k / j));
        locala1.url = ((JSONObject)localObject2).getString("url");
        validateUrl(locala1.url);
        locala1.gaussianUrl = ((JSONObject)localObject2).optString("guassianUrl");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(locala1.url.hashCode());
        locala1.id = ((StringBuilder)localObject2).toString();
        localObject2 = ((JSONObject)localObject1).getJSONObject("hotArea");
        if (((JSONObject)localObject2).getBoolean("isSet"))
        {
          com.tencent.ad.tangram.views.canvas.components.pictures.c[] arrayOfc = new com.tencent.ad.tangram.views.canvas.components.pictures.c[3];
          arrayOfc[0] = getHotArea(paramContext, paramAdCanvasData.basicWidth, "hotArea1", (JSONObject)localObject1, locala1);
          arrayOfc[1] = getHotArea(paramContext, paramAdCanvasData.basicWidth, "hotArea2", (JSONObject)localObject1, locala1);
          arrayOfc[2] = getHotArea(paramContext, paramAdCanvasData.basicWidth, "hotArea3", (JSONObject)localObject1, locala1);
          localObject1 = new ArrayList();
          k = Integer.parseInt(((JSONObject)localObject2).getString("num"));
          j = 0;
          while (j < k) {
            if (arrayOfc[j] != null)
            {
              ((ArrayList)localObject1).add(arrayOfc[j]);
              j += 1;
            }
            else
            {
              throw new Exception("hot area is null");
            }
          }
          locala1.hotAreaList = ((ArrayList)localObject1);
        }
        else
        {
          locala1.hotAreaList = null;
        }
        localArrayList.add(locala1);
        if ((TextUtils.isEmpty(paramAdCanvasData.firstPictureComponentIdWithHotArea)) && (locala1.isHotAreaValild())) {
          paramAdCanvasData.firstPictureComponentIdWithHotArea = locala1.id;
        }
        if (imageLoadParams != null)
        {
          setImageInfo(locala1, paramContext);
          localObject1 = imageLoadParams;
          ((com.tencent.ad.tangram.views.a)localObject1).currentLength += locala1.height;
        }
        i += 1;
      }
      locala.imageList = localArrayList;
      return locala;
    }
    AdLog.e("AdCanvasDataBuilderV2", "getMulitiPictureComponent error");
    return null;
  }
  
  private static com.tencent.ad.tangram.views.canvas.framework.a getPage(Context paramContext, Ad paramAd, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
  {
    if (JSONObject.NULL.equals(paramJSONObject))
    {
      AdLog.e("AdCanvasDataBuilderV2", "getPage error");
      return null;
    }
    com.tencent.ad.tangram.views.canvas.framework.a locala = new com.tencent.ad.tangram.views.canvas.framework.a();
    locala.floatingBarTextColor = -1;
    locala.floatingBarBackgroundColor = Color.parseColor("#1890ff");
    Object localObject = paramJSONObject.getJSONObject("pageConfig");
    JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("config");
    String str = ((JSONObject)localObject).optString("arkFormApp");
    localObject = ((JSONObject)localObject).optString("arkFormView");
    locala.arkApp = str;
    locala.arkView = ((String)localObject);
    locala.backgroundColor = getColor(localJSONObject.getString("bgColor"));
    locala.components = getCanvasComponents(paramContext, paramAd, paramJSONObject.getJSONArray("modules"), paramAdCanvasData);
    return locala;
  }
  
  private static List<com.tencent.ad.tangram.views.canvas.framework.a> getPageList(Context paramContext, Ad paramAd, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      paramContext = getPage(paramContext, paramAd, paramJSONObject, paramAdCanvasData);
      if (paramContext != null)
      {
        paramContext.hasFixedButtonData = paramAdCanvasData.hasFixedButtonData;
        paramContext.hasMultiPictureData = paramAdCanvasData.hasMultiPictureData;
        paramContext.imageLoadParams = imageLoadParams;
        localArrayList.add(paramContext);
        return localArrayList;
      }
      throw new Exception("getPageList error");
    }
    AdLog.e("AdCanvasDataBuilderV2", "getPageList error");
    AdReport.reportForCanvasDataBuildError(paramContext, 4, paramAd, null);
    com.tencent.ad.tangram.statistics.canvas.a.reportForCanvasDataBuildError(paramContext, paramAd, String.valueOf(4));
    return localArrayList;
  }
  
  private static void getPageList(Context paramContext, Ad paramAd, AdCanvasData paramAdCanvasData, JSONObject paramJSONObject)
  {
    imageLoadParams = null;
    JSONObject localJSONObject = paramJSONObject.getJSONObject("pageConfig");
    paramAdCanvasData.pageTitle = localJSONObject.getJSONObject("config").getString("pageTitle");
    paramAdCanvasData.ad.setActionSetId(localJSONObject.getLong("actionSetId"));
    paramAdCanvasData.pageType = localJSONObject.getString("type");
    paramAdCanvasData.commonPageId = localJSONObject.getString("commonPageId");
    paramAdCanvasData.basicWidth = 375;
    paramAdCanvasData.pages = getPageList(paramContext, paramAd, paramJSONObject, paramAdCanvasData);
  }
  
  public static int getRgbColor(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.toLowerCase().replace(" ", "").replace("rgba", "").replace("rgb", "").replace("(", "").replace(")", "").split(",");
      if ((paramString != null) && (paramString.length >= 3))
      {
        int i;
        if (paramString.length >= 4) {
          i = (int)(Float.parseFloat(paramString[3]) * 255.0F);
        } else {
          i = 255;
        }
        return Color.argb(i, Integer.parseInt(paramString[0]), Integer.parseInt(paramString[1]), Integer.parseInt(paramString[2]));
      }
    }
    throw new Exception("color is null");
  }
  
  private static AdCanvasComponentData getTextComponent(Context paramContext, Ad paramAd, JSONObject paramJSONObject, int paramInt)
  {
    if (JSONObject.NULL.equals(paramJSONObject))
    {
      AdLog.e("AdCanvasDataBuilderV2", "getTextComponent error");
      return null;
    }
    if (paramAd.isAppXiJingDefault())
    {
      paramAd = new com.tencent.ad.tangram.views.canvas.components.text.a();
      initComponent(paramJSONObject, paramInt, paramAd);
      localObject1 = paramJSONObject.getJSONObject("config");
      paramJSONObject = ((JSONObject)localObject1).getJSONObject("content");
      localObject1 = ((JSONObject)localObject1).getJSONObject("style");
      paramAd.content = paramJSONObject.getString("text").replace("\\n", "\n");
      paramAd.fontSize = ((JSONObject)localObject1).getInt("fontSize");
      paramAd.marginLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, ((JSONObject)localObject1).getInt("marginLeft"));
      paramAd.marginTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, ((JSONObject)localObject1).getInt("marginTop"));
      paramAd.marginRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, ((JSONObject)localObject1).getInt("marginRight"));
      paramAd.marginBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, ((JSONObject)localObject1).getInt("marginBottom"));
      return paramAd;
    }
    paramAd = new com.tencent.ad.tangram.views.canvas.components.pictures.a();
    Object localObject1 = new ArrayList();
    initComponent(paramJSONObject, paramInt, paramAd);
    paramJSONObject = paramJSONObject.getJSONObject("config");
    Object localObject2 = paramJSONObject.getJSONObject("style");
    paramAd.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, ((JSONObject)localObject2).getInt("marginTop"));
    paramAd.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, ((JSONObject)localObject2).getInt("marginBottom"));
    paramJSONObject = paramJSONObject.getJSONArray("images");
    paramInt = 0;
    while (paramInt < paramJSONObject.length())
    {
      localObject2 = new com.tencent.ad.tangram.views.canvas.components.picture.a();
      Object localObject3 = (JSONObject)paramJSONObject.get(paramInt);
      int i = ((JSONObject)localObject3).getInt("width");
      int j = ((JSONObject)localObject3).getInt("height");
      ((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject2).width = (AdUIUtils.getPhysicalScreenWidth(paramContext) - ((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject2).paddingLeft - ((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject2).paddingRight);
      ((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject2).height = ((int)(((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject2).width * j / i));
      ((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject2).url = ((JSONObject)localObject3).getString("url");
      validateUrl(((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject2).url);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject2).url.hashCode());
      ((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject2).id = ((StringBuilder)localObject3).toString();
      ((ArrayList)localObject1).add(localObject2);
      if (imageLoadParams != null)
      {
        setImageInfo((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject2, paramContext);
        localObject3 = imageLoadParams;
        ((com.tencent.ad.tangram.views.a)localObject3).currentLength += ((com.tencent.ad.tangram.views.canvas.components.picture.a)localObject2).height;
      }
      paramInt += 1;
    }
    paramAd.imageList = ((ArrayList)localObject1);
    return paramAd;
  }
  
  private static com.tencent.ad.tangram.views.canvas.components.title.a getTitleComponent(Context paramContext, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
  {
    if (JSONObject.NULL.equals(paramJSONObject))
    {
      AdLog.e("AdCanvasDataBuilderV2", "getTitleComponent error");
      return null;
    }
    com.tencent.ad.tangram.views.canvas.components.title.a locala = new com.tencent.ad.tangram.views.canvas.components.title.a();
    initComponent(paramJSONObject, paramAdCanvasData.basicWidth, locala);
    paramJSONObject = paramJSONObject.getJSONObject("config");
    int i = paramAdCanvasData.basicWidth;
    locala.adTextData.text = unescapeHtml(paramJSONObject.getJSONObject("content").getString("text"));
    locala.adTextData.color = getColor(paramJSONObject.getJSONObject("style").getString("color"));
    locala.adTextData.size = paramJSONObject.getJSONObject("style").getInt("fontSize");
    locala.adTextData.weight = paramJSONObject.getJSONObject("style").getString("fontWeight");
    locala.decoration = getColor(paramJSONObject.getString("decoration"));
    locala.textAlignGravity = AdUIUtils.formatStringToGravity(paramJSONObject.getJSONObject("wrapper").getString("textAlign"), "title text align");
    locala.marginBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, paramJSONObject.getJSONObject("wrapper").getInt("marginBottom"));
    locala.marginTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, paramJSONObject.getJSONObject("wrapper").getInt("marginTop"));
    locala.marginLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, paramJSONObject.getJSONObject("wrapper").getInt("marginLeft"));
    locala.marginRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, paramJSONObject.getJSONObject("wrapper").getInt("marginRight"));
    locala.titleDecorationType = paramJSONObject.getString("className");
    locala.backgroundColor = getColor(paramJSONObject.getJSONObject("wrapper").getString("backgroundColor"));
    locala.justifyContent = AdUIUtils.formatStringToRelativeLayoutRule(paramJSONObject.getJSONObject("wrapper").getString("justifyContent"), "title justifyContent");
    return locala;
  }
  
  @Deprecated
  private static AdCanvasComponentData getWebMulitiPictureComponent(Context paramContext, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      com.tencent.ad.tangram.views.canvas.components.pictures.a locala = new com.tencent.ad.tangram.views.canvas.components.pictures.a();
      initComponent(paramJSONObject, paramAdCanvasData.basicWidth, locala);
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.getJSONObject("config").getJSONArray("images");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        com.tencent.ad.tangram.views.canvas.components.picture.a locala1 = new com.tencent.ad.tangram.views.canvas.components.picture.a();
        Object localObject1 = (JSONObject)paramJSONObject.get(i);
        Object localObject2 = ((JSONObject)localObject1).getJSONObject("padding");
        locala1.paddingLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, ((JSONObject)localObject2).getInt("left"));
        locala1.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, ((JSONObject)localObject2).getInt("top"));
        locala1.paddingRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, ((JSONObject)localObject2).getInt("right"));
        locala1.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, ((JSONObject)localObject2).getInt("bottom"));
        locala1.floatingBarTextColor = -1;
        locala1.floatingBarBackgroundColor = Color.parseColor("#1890ff");
        localObject2 = ((JSONObject)localObject1).getJSONObject("image");
        int j = ((JSONObject)localObject2).getInt("width");
        int k = ((JSONObject)localObject2).getInt("height");
        locala1.width = (AdUIUtils.getPhysicalScreenWidth(paramContext) - locala1.paddingLeft - locala1.paddingRight);
        locala1.height = ((int)(locala1.width * k / j));
        locala1.url = ((JSONObject)localObject2).getString("url");
        validateUrl(locala1.url);
        locala1.gaussianUrl = ((JSONObject)localObject2).optString("guassianUrl");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(locala1.url.hashCode());
        locala1.id = ((StringBuilder)localObject2).toString();
        localObject2 = ((JSONObject)localObject1).getJSONObject("hotArea");
        if (((JSONObject)localObject2).getBoolean("isSet"))
        {
          com.tencent.ad.tangram.views.canvas.components.pictures.c[] arrayOfc = new com.tencent.ad.tangram.views.canvas.components.pictures.c[3];
          arrayOfc[0] = getHotArea(paramContext, paramAdCanvasData.basicWidth, "hotArea1", (JSONObject)localObject1, locala1);
          arrayOfc[1] = getHotArea(paramContext, paramAdCanvasData.basicWidth, "hotArea2", (JSONObject)localObject1, locala1);
          arrayOfc[2] = getHotArea(paramContext, paramAdCanvasData.basicWidth, "hotArea3", (JSONObject)localObject1, locala1);
          localObject1 = new ArrayList();
          k = Integer.parseInt(((JSONObject)localObject2).getString("num"));
          j = 0;
          while (j < k) {
            if (arrayOfc[j] != null)
            {
              ((ArrayList)localObject1).add(arrayOfc[j]);
              j += 1;
            }
            else
            {
              throw new Exception("hot area is null");
            }
          }
          locala1.hotAreaList = ((ArrayList)localObject1);
        }
        else
        {
          locala1.hotAreaList = null;
        }
        localArrayList.add(locala1);
        if ((TextUtils.isEmpty(paramAdCanvasData.firstPictureComponentIdWithHotArea)) && (locala1.isHotAreaValild())) {
          paramAdCanvasData.firstPictureComponentIdWithHotArea = locala1.id;
        }
        i += 1;
      }
      locala.imageList = localArrayList;
      return locala;
    }
    AdLog.e("AdCanvasDataBuilderV2", "getMulitiPictureComponent error");
    return null;
  }
  
  private static void initComponent(JSONObject paramJSONObject, int paramInt, AdCanvasComponentData paramAdCanvasComponentData)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)) && (paramAdCanvasComponentData != null))
    {
      paramAdCanvasComponentData.id = paramJSONObject.getString("id");
      return;
    }
    AdLog.e("AdCanvasDataBuilderV2", "initComponent error");
    throw new Exception("initComponent error");
  }
  
  private static void setActiveAppBtnView(AdCanvasData paramAdCanvasData)
  {
    if (paramAdCanvasData != null)
    {
      Object localObject = ((com.tencent.ad.tangram.views.canvas.framework.a)paramAdCanvasData.pages.get(0)).components;
      ArrayList localArrayList = paramAdCanvasData.fixedButtonComponentDataList;
      paramAdCanvasData = paramAdCanvasData.appFixedButtonComponentDataList;
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        paramAdCanvasData = localArrayList.iterator();
      }
      while (paramAdCanvasData.hasNext())
      {
        ((com.tencent.ad.tangram.views.canvas.components.fixedbutton.a)paramAdCanvasData.next()).canShowProgress = true;
        continue;
        if ((paramAdCanvasData != null) && (paramAdCanvasData.size() > 0))
        {
          if (paramAdCanvasData.get(0) != null) {
            ((com.tencent.ad.tangram.views.canvas.components.appbutton.c)paramAdCanvasData.get(0)).canShowProgress = true;
          }
        }
        else if ((localObject != null) && (((List)localObject).size() > 0))
        {
          paramAdCanvasData = ((List)localObject).iterator();
          while (paramAdCanvasData.hasNext())
          {
            localObject = (AdCanvasComponentData)paramAdCanvasData.next();
            if ((localObject instanceof com.tencent.ad.tangram.views.canvas.components.appInfoButton.a)) {
              ((com.tencent.ad.tangram.views.canvas.components.appInfoButton.a)localObject).canShowProgress = true;
            } else if ((localObject instanceof com.tencent.ad.tangram.views.canvas.components.layerCard.a)) {
              ((com.tencent.ad.tangram.views.canvas.components.layerCard.a)localObject).adCanvasAppBtnComponentData.canShowProgress = true;
            } else if ((localObject instanceof com.tencent.ad.tangram.views.canvas.components.appbutton.c)) {
              ((com.tencent.ad.tangram.views.canvas.components.appbutton.c)localObject).canShowProgress = true;
            }
          }
        }
      }
    }
  }
  
  private static void setImageInfo(com.tencent.ad.tangram.views.canvas.components.picture.a parama, Context paramContext)
  {
    parama.hitLoadImageExp = true;
    if ((imageLoadParams.currentLength > paramContext.getResources().getDisplayMetrics().heightPixels) && (imageLoadParams.hasLoadedImage) && (!TextUtils.isEmpty(parama.gaussianUrl)))
    {
      parama.isLoadFirst = false;
      return;
    }
    parama.isLoadFirst = true;
    imageLoadParams.hasLoadedFirstImages.incrementAndGet();
    imageLoadParams.hasLoadedImage = true;
  }
  
  private static String unescapeHtml(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Spanned localSpanned = Html.fromHtml(paramString);
    if (localSpanned == null) {
      return paramString;
    }
    return localSpanned.toString();
  }
  
  private static void validateUrl(String paramString)
  {
    paramString = AdUriUtil.parse(paramString);
    if ((paramString != null) && ((paramString.getScheme().equals("http")) || (paramString.getScheme().equals("https")))) {
      return;
    }
    throw new Exception("url type error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.AdCanvasDataBuilderV2
 * JD-Core Version:    0.7.0.1
 */