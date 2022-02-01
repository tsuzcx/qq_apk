package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyle;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class TruncateAttr
{
  private static final String COLOR = "color";
  private static final String FONT_SIZE = "font-size";
  private static final String FONT_WEIGHT = "font-weight";
  private static final String HREF = "href";
  private static final String TAG = "TruncateAttr";
  private static final String TEXT = "text";
  public int color;
  public int fontSize;
  public String fontWeight;
  public String href;
  public List<RichTextParser.CustomImageSpan> imageSpans = new ArrayList();
  public int maxLines = 100;
  public double nodeRatio = 1.0D;
  public String text;
  
  static TruncateAttr parseTruncate(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      Object localObject = paramJSONObject.optString("text", "");
      String str = paramJSONObject.optString("href", "");
      TruncateAttr localTruncateAttr = new TruncateAttr();
      localTruncateAttr.text = ((String)localObject);
      localTruncateAttr.href = str;
      int i = -12541697;
      try
      {
        localObject = paramJSONObject.optString("color");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          i = Color.parseColor((String)localObject);
        }
        localTruncateAttr.color = i;
        int j = Utils.dp2px(16.0D);
        localObject = paramJSONObject.optString("font-size");
        i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = CssStyle.getSize((String)localObject);
          i = j;
          if (localObject != null) {
            i = Integer.parseInt(String.valueOf(localObject));
          }
        }
        localTruncateAttr.fontSize = i;
        localObject = paramJSONObject.optString("font-weight");
        paramJSONObject = localTruncateAttr;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return paramJSONObject;
        }
        localTruncateAttr.fontWeight = ((String)localObject);
        return localTruncateAttr;
      }
      catch (Exception paramJSONObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseTruncate error! msg=");
        ((StringBuilder)localObject).append(paramJSONObject);
        LogUtil.QLog.e("TruncateAttr", 1, ((StringBuilder)localObject).toString());
        return localTruncateAttr;
      }
    }
    else
    {
      paramJSONObject = null;
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.TruncateAttr
 * JD-Core Version:    0.7.0.1
 */