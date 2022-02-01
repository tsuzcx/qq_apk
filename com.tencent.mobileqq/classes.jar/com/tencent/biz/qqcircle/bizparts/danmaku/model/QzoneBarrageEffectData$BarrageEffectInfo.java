package com.tencent.biz.qqcircle.bizparts.danmaku.model;

import NS_MOBILE_MATERIAL.BubbleSource;
import NS_MOBILE_MATERIAL.MaterialFile;
import NS_MOBILE_MATERIAL.MaterialItem;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;
import java.util.ArrayList;
import java.util.Map;

public class QzoneBarrageEffectData$BarrageEffectInfo
  implements SmartParcelable
{
  @NeedParcel
  public String a = "";
  @NeedParcel
  public int b = 0;
  @NeedParcel
  public String c = "";
  @NeedParcel
  public int d = 0;
  @NeedParcel
  public boolean e = false;
  @NeedParcel
  public String f = "";
  @NeedParcel
  public String g = "";
  @NeedParcel
  public String h = "";
  @NeedParcel
  public int i = -1;
  @NeedParcel
  public String j = "";
  @NeedParcel
  public String k = "";
  @NeedParcel
  public String l = "";
  @NeedParcel
  public int m = 0;
  @NeedParcel
  public BubbleSource n = null;
  @NeedParcel
  public String o = "";
  @NeedParcel
  public int p = -1;
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    String str = paramString.trim();
    paramString = str;
    if (!str.startsWith("#"))
    {
      paramString = new StringBuilder();
      paramString.append("#");
      paramString.append(str);
      paramString = paramString.toString();
    }
    try
    {
      int i1 = Color.parseColor(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public void a(MaterialItem paramMaterialItem)
  {
    if ((paramMaterialItem != null) && (paramMaterialItem.vecFile != null) && (paramMaterialItem.vecFile.size() >= 2))
    {
      this.j = ((String)paramMaterialItem.mapExtInfo.get("TextColor"));
      this.k = ((MaterialFile)paramMaterialItem.vecFile.get(0)).strUrl;
      this.l = ((MaterialFile)paramMaterialItem.vecFile.get(1)).strUrl;
      if (paramMaterialItem.vecFile.size() > 2) {
        this.o = ((MaterialFile)paramMaterialItem.vecFile.get(2)).strUrl;
      }
      return;
    }
    this.i = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.model.QzoneBarrageEffectData.BarrageEffectInfo
 * JD-Core Version:    0.7.0.1
 */