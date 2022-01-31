package com.tencent.gdtad.aditem;

import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import org.json.JSONObject;

public class GdtBaseAdItem
  implements Serializable
{
  public boolean autoDownLoad;
  public Class clz;
  public String deepLinkUrl;
  public String downloadScheme;
  public boolean openmain;
  public String packageName;
  public String productId;
  public String traceId;
  public String urlForClick;
  
  private GdtBaseAdItem() {}
  
  public GdtBaseAdItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, Class paramClass, boolean paramBoolean2)
  {
    this.packageName = paramString1;
    this.downloadScheme = paramString2;
    this.deepLinkUrl = paramString3;
    this.traceId = paramString4;
    this.productId = paramString5;
    this.autoDownLoad = paramBoolean1;
    this.clz = paramClass;
  }
  
  public static GdtBaseAdItem obtain()
  {
    return new GdtBaseAdItem();
  }
  
  public static GdtBaseAdItem obtain(String paramString)
  {
    localGdtBaseAdItem = new GdtBaseAdItem();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      try
      {
        paramString = Class.forName(localJSONObject.optString("class"));
        localGdtBaseAdItem.setPackageName(localJSONObject.optString("packageName")).setTraceId(localJSONObject.optString("traceId")).setDeepLinkUrl(localJSONObject.optString("invokeUrl")).setDownloadScheme(localJSONObject.optString("appDownloadSchema")).setProductId(localJSONObject.optString("productId")).setClz(paramString).setUrlForClick(localJSONObject.optString("urlForClick")).setAutoDownLoad("1".equals(localJSONObject.optString("autoDownload")));
        paramString = localJSONObject.optString("pkg_name");
        if (!TextUtils.isEmpty(paramString))
        {
          localGdtBaseAdItem.setPackageName(paramString);
          return localGdtBaseAdItem;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QZLog.w(paramString);
          paramString = null;
        }
      }
      return localGdtBaseAdItem;
    }
    catch (Exception paramString) {}
  }
  
  public GdtBaseAdItem setAutoDownLoad(boolean paramBoolean)
  {
    this.autoDownLoad = paramBoolean;
    return this;
  }
  
  public GdtBaseAdItem setClz(Class paramClass)
  {
    this.clz = paramClass;
    return this;
  }
  
  public GdtBaseAdItem setDeepLinkUrl(String paramString)
  {
    this.deepLinkUrl = paramString;
    return this;
  }
  
  public GdtBaseAdItem setDownloadScheme(String paramString)
  {
    this.downloadScheme = paramString;
    return this;
  }
  
  public GdtBaseAdItem setPackageName(String paramString)
  {
    this.packageName = paramString;
    return this;
  }
  
  public GdtBaseAdItem setProductId(String paramString)
  {
    this.productId = paramString;
    return this;
  }
  
  public GdtBaseAdItem setTraceId(String paramString)
  {
    this.traceId = paramString;
    return this;
  }
  
  public GdtBaseAdItem setUrlForClick(String paramString)
  {
    this.urlForClick = paramString;
    return this;
  }
  
  public String toString()
  {
    return "GdtBaseAdItem|" + this.packageName + "\n" + this.downloadScheme + "\n" + this.deepLinkUrl + "\n" + this.traceId + "\n" + this.productId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtBaseAdItem
 * JD-Core Version:    0.7.0.1
 */