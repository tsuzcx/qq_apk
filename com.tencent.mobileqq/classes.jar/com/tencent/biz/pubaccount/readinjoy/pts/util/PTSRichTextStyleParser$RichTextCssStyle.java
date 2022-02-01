package com.tencent.biz.pubaccount.readinjoy.pts.util;

import android.graphics.Color;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyle;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.pts.utils.PTSLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class PTSRichTextStyleParser$RichTextCssStyle
{
  public static CssStyleSet a(String paramString1, String paramString2, Node paramNode, JSONObject paramJSONObject)
  {
    CssStyleSet localCssStyleSet = new CssStyleSet();
    if ((paramNode != null) && (paramNode.cssStyleSet != null)) {
      localCssStyleSet.addInheritStyle(paramNode.cssStyleSet);
    }
    if (("div".equalsIgnoreCase(paramString1)) || ("p".equalsIgnoreCase(paramString1))) {
      localCssStyleSet.addCssStyle(CssStyle.getDisplay(true));
    }
    while (paramString2 != null)
    {
      paramString1 = paramString2.split("[;]");
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        paramString2 = paramString1[i];
        if (paramString2 != null)
        {
          paramString2 = paramString2.split(":");
          if (paramString2.length == 2) {
            localCssStyleSet.addCssStyle(CssStyle.createStyle(paramString2[0].trim(), paramString2[1].trim()));
          }
        }
        i += 1;
      }
      if ("strong".equalsIgnoreCase(paramString1)) {
        localCssStyleSet.addCssStyle(CssStyle.createStyle("font-weight", "bold"));
      } else if (("a".equalsIgnoreCase(paramString1)) && (paramJSONObject != null)) {
        localCssStyleSet.addCssStyle(CssStyle.createStyle("href", paramJSONObject.optString("href")));
      } else {
        localCssStyleSet.addCssStyle(CssStyle.getDisplay(false));
      }
    }
    return localCssStyleSet;
  }
  
  public static void a(Node paramNode)
  {
    Map localMap = paramNode.cssStyleSet.getCssStyleMap();
    if ((localMap == null) || (localMap.size() <= 0)) {
      PTSLog.e("RichTextStyleParser", "RichTextCssStyle dealTextStyle node.cssStyleSet.getCssStyleMap null!");
    }
    for (;;)
    {
      return;
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = ((CssStyle)((Map.Entry)localObject).getValue()).styleName;
        localObject = ((CssStyle)((Map.Entry)localObject).getValue()).styleValue;
        int i;
        if ("line-height".equalsIgnoreCase(str))
        {
          i = (int)(((Integer)localObject).intValue() * paramNode.nodeRatio);
          if (PTSRichTextStyleParser.a < i) {
            PTSRichTextStyleParser.a = i;
          }
        }
        else if ("font-size".equalsIgnoreCase(str))
        {
          i = (int)(((Integer)localObject).intValue() * paramNode.nodeRatio);
          if (PTSRichTextStyleParser.b < i) {
            PTSRichTextStyleParser.b = i;
          }
        }
        else if ("color".equalsIgnoreCase(str))
        {
          i = Color.parseColor((String)localObject);
          PTSLog.d("RichTextStyleParser", "dealTextStyle colorInt = " + i);
        }
        else if ("font-weight".equalsIgnoreCase(str))
        {
          i = ((Integer)localObject).intValue();
          if (PTSRichTextStyleParser.c < i) {
            PTSRichTextStyleParser.b = i;
          }
        }
        else if ("-webkit-line-clamp".equalsIgnoreCase(str))
        {
          i = ((Integer)localObject).intValue();
          if (PTSRichTextStyleParser.d < i) {
            PTSRichTextStyleParser.d = i;
          }
        }
        else if ("display".equalsIgnoreCase(str))
        {
          PTSLog.d("RichTextStyleParser", "dealTextStyle DISPLAY_STYLE");
        }
        else if ("href".equalsIgnoreCase(str))
        {
          str = String.valueOf(localObject);
          localObject = (CssStyle)localMap.get("color");
          PTSLog.d("RichTextStyleParser", "dealTextStyle href = " + str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.util.PTSRichTextStyleParser.RichTextCssStyle
 * JD-Core Version:    0.7.0.1
 */