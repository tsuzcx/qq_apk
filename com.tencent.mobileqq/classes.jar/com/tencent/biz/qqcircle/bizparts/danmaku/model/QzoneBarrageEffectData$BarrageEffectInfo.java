package com.tencent.biz.qqcircle.bizparts.danmaku.model;

import NS_MOBILE_MATERIAL.BubbleSource;
import NS_MOBILE_MATERIAL.CommentBubble;
import NS_MOBILE_MATERIAL.CommentUgcDeco;
import NS_MOBILE_MATERIAL.MaterialFile;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_MATERIAL.UgcDecoQualReq;
import android.graphics.Color;
import android.text.TextUtils;
import bnjr;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class QzoneBarrageEffectData$BarrageEffectInfo
  implements SmartParcelable
{
  @NeedParcel
  public String actId = "";
  @NeedParcel
  public String coverUrl = "";
  @NeedParcel
  public int fontType;
  @NeedParcel
  public String fontUsedTips = "";
  @NeedParcel
  public boolean hasAuth;
  @NeedParcel
  public int iFrameRate = -1;
  @NeedParcel
  public int id = -1;
  @NeedParcel
  public String name = "";
  @NeedParcel
  public int price;
  @NeedParcel
  public String ruleId = "";
  @NeedParcel
  public BubbleSource stSource;
  @NeedParcel
  public String strAndBgUrl = "";
  @NeedParcel
  public String strFrameZip = "";
  @NeedParcel
  public String strIosBgUrl = "";
  @NeedParcel
  public String strTextColor = "";
  @NeedParcel
  public int type;
  
  public static BarrageEffectInfo fromFeedsJceData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = (CommentUgcDeco)bnjr.a(CommentUgcDeco.class, paramArrayOfByte);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.stBubble == null) || (paramArrayOfByte.stBubble.iItemId <= 0)) {
      return null;
    }
    BarrageEffectInfo localBarrageEffectInfo = new BarrageEffectInfo();
    localBarrageEffectInfo.id = paramArrayOfByte.stBubble.iItemId;
    localBarrageEffectInfo.strAndBgUrl = paramArrayOfByte.stBubble.strAndBgUrl;
    localBarrageEffectInfo.strTextColor = paramArrayOfByte.stBubble.strTextColor;
    localBarrageEffectInfo.strIosBgUrl = paramArrayOfByte.stBubble.strIosBgUrl;
    localBarrageEffectInfo.type = paramArrayOfByte.stBubble.eType;
    localBarrageEffectInfo.stSource = paramArrayOfByte.stBubble.stSource;
    localBarrageEffectInfo.strFrameZip = paramArrayOfByte.stBubble.strFrameZip;
    localBarrageEffectInfo.iFrameRate = paramArrayOfByte.stBubble.iFrameRate;
    return localBarrageEffectInfo;
  }
  
  public static BarrageEffectInfo fromJson(String paramString)
  {
    BarrageEffectInfo localBarrageEffectInfo = new BarrageEffectInfo();
    localBarrageEffectInfo.fillData(paramString);
    return localBarrageEffectInfo;
  }
  
  public static int parseColor(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    String str = paramString.trim();
    paramString = str;
    if (!str.startsWith("#")) {
      paramString = "#" + str;
    }
    try
    {
      i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        int i = 0;
      }
    }
  }
  
  public void fillData(MaterialItem paramMaterialItem)
  {
    if ((paramMaterialItem == null) || (paramMaterialItem.vecFile == null) || (paramMaterialItem.vecFile.size() < 2)) {
      this.id = -1;
    }
    do
    {
      return;
      this.strTextColor = ((String)paramMaterialItem.mapExtInfo.get("TextColor"));
      this.strAndBgUrl = ((MaterialFile)paramMaterialItem.vecFile.get(0)).strUrl;
      this.strIosBgUrl = ((MaterialFile)paramMaterialItem.vecFile.get(1)).strUrl;
    } while (paramMaterialItem.vecFile.size() <= 2);
    this.strFrameZip = ((MaterialFile)paramMaterialItem.vecFile.get(2)).strUrl;
  }
  
  public void fillData(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.id = paramString.optInt("iItemId");
      this.strTextColor = paramString.optString("strTextColor");
      this.strAndBgUrl = paramString.optString("strAndBgUrl");
      this.strIosBgUrl = paramString.optString("strIosBgUrl");
      this.type = paramString.optInt("type");
      BubbleSource localBubbleSource = new BubbleSource();
      localBubbleSource.strAndUrl1 = paramString.optString("strAndUrl1");
      localBubbleSource.strAndUrl2 = paramString.optString("strAndUrl2");
      localBubbleSource.strTextColor1 = paramString.optString("strTextColor1");
      localBubbleSource.strTextColor2 = paramString.optString("strTextColor2");
      this.stSource = localBubbleSource;
      this.strFrameZip = paramString.optString("strFrameZip");
      this.iFrameRate = paramString.optInt("iFrameRate");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public byte[] toJceData()
  {
    if (this.id <= 0) {
      return null;
    }
    CommentUgcDeco localCommentUgcDeco = new CommentUgcDeco();
    localCommentUgcDeco.stBubble = new CommentBubble();
    localCommentUgcDeco.stBubble.iItemId = this.id;
    localCommentUgcDeco.stBubble.strAndBgUrl = this.strAndBgUrl;
    localCommentUgcDeco.stBubble.strTextColor = this.strTextColor;
    localCommentUgcDeco.stBubble.strIosBgUrl = this.strIosBgUrl;
    localCommentUgcDeco.stBubble.eType = this.type;
    localCommentUgcDeco.stBubble.stSource = this.stSource;
    localCommentUgcDeco.stBubble.strFrameZip = this.strFrameZip;
    localCommentUgcDeco.stBubble.iFrameRate = this.iFrameRate;
    return bnjr.a(localCommentUgcDeco);
  }
  
  public byte[] toJceReqData()
  {
    UgcDecoQualReq localUgcDecoQualReq = new UgcDecoQualReq();
    localUgcDecoQualReq.mapItemId = new HashMap();
    localUgcDecoQualReq.mapItemId.put(Integer.valueOf(128), Integer.valueOf(this.id));
    return bnjr.a(localUgcDecoQualReq);
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("iItemId", this.id);
      localJSONObject.put("strTextColor", this.strTextColor);
      localJSONObject.put("strAndBgUrl", this.strAndBgUrl);
      localJSONObject.put("strIosBgUrl", this.strIosBgUrl);
      localJSONObject.put("type", this.type);
      localJSONObject.put("strAndUrl1", this.stSource.strAndUrl1);
      localJSONObject.put("strAndUrl2", this.stSource.strAndUrl2);
      localJSONObject.put("strTextColor1", this.stSource.strTextColor1);
      localJSONObject.put("strTextColor2", this.stSource.strTextColor2);
      localJSONObject.put("iFrameRate", this.iFrameRate);
      localJSONObject.put("strFrameZip", this.strFrameZip);
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.model.QzoneBarrageEffectData.BarrageEffectInfo
 * JD-Core Version:    0.7.0.1
 */