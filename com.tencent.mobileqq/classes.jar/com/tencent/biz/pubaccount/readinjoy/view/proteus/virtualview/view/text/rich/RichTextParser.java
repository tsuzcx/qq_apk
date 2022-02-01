package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.RichTextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyle;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.ImgNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.LayoutNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.TextNode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class RichTextParser
{
  private static final Drawable GRAY_PLACEHOLDER = new ColorDrawable(Color.parseColor("#E9E9E9"));
  static final int LINK_TEXT_COLOR = -12541697;
  private static final String TAG = "RichTextParser";
  private static int maxFontSize;
  private static int maxLineHeight = -1;
  private static int maxLines;
  private static int spaceHeight;
  private static TruncateAttr truncateAttr;
  
  static
  {
    maxFontSize = -1;
    spaceHeight = 0;
    maxLines = 100;
  }
  
  private static void addExtraInfo(Node paramNode1, Node paramNode2, JSONObject paramJSONObject1, CssStyleSet paramCssStyleSet, JSONObject paramJSONObject2)
  {
    if (paramNode2 == null) {
      return;
    }
    paramNode2.cssStyleSet = paramCssStyleSet;
    addRatio(paramNode1, paramNode2, paramJSONObject2);
    addTruncateInfo(paramNode2, paramJSONObject1);
  }
  
  private static void addRatio(Node paramNode1, Node paramNode2, JSONObject paramJSONObject)
  {
    paramNode2.nodeRatio = paramNode1.nodeRatio;
    if ((paramJSONObject != null) && (paramJSONObject.has("ratio"))) {
      paramNode2.nodeRatio = paramJSONObject.optDouble("ratio", 1.0D);
    }
  }
  
  private static void addTruncateInfo(Node paramNode, JSONObject paramJSONObject)
  {
    paramNode.truncateAttr = TruncateAttr.parseTruncate(paramJSONObject.optJSONObject("truncationAttrs"));
    if (paramNode.truncateAttr != null) {
      paramNode.truncateAttr.nodeRatio = paramNode.nodeRatio;
    }
  }
  
  private static Node createNode(Node paramNode, String paramString1, String paramString2, CssStyleSet paramCssStyleSet, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    Object localObject = null;
    if ("text".equals(paramString2))
    {
      paramString2 = paramJSONObject1.optString("text");
      paramString1 = localObject;
      if (Node.valueIsLegal(paramString2))
      {
        paramString1 = new TextNode();
        ((TextNode)paramString1).text = paramString2;
      }
    }
    for (;;)
    {
      addExtraInfo(paramNode, paramString1, paramJSONObject1, paramCssStyleSet, paramJSONObject2);
      return paramString1;
      if ("img".equals(paramString1))
      {
        paramString2 = paramJSONObject2.optString("src");
        paramString1 = localObject;
        if (Node.valueIsLegal(paramString2))
        {
          paramString1 = new ImgNode();
          ((ImgNode)paramString1).src = paramString2;
        }
      }
      else
      {
        paramString1 = new LayoutNode();
      }
    }
  }
  
  private static void dealImgNode(TextView paramTextView, ImgNode paramImgNode, int paramInt1, int paramInt2, SpannableStringBuilder paramSpannableStringBuilder)
  {
    Rect localRect = new Rect();
    Object localObject1 = paramImgNode.cssStyleSet.getCssStyleMap();
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
        localObject2 = ((CssStyle)((Map.Entry)localObject3).getValue()).styleName;
        localObject3 = ((CssStyle)((Map.Entry)localObject3).getValue()).styleValue;
        if ("width".equalsIgnoreCase((String)localObject2))
        {
          localRect.left = 0;
          localRect.right = ((Integer)localObject3).intValue();
        }
        else if ("height".equalsIgnoreCase((String)localObject2))
        {
          localRect.top = 0;
          localRect.bottom = ((Integer)localObject3).intValue();
        }
        else if (("display".equalsIgnoreCase((String)localObject2)) && ("block".equals(localObject3)) && (paramSpannableStringBuilder.length() > 0) && (paramSpannableStringBuilder.charAt(paramSpannableStringBuilder.length() - 1) != '\n'))
        {
          paramSpannableStringBuilder.append('\n');
        }
      }
    }
    Object localObject2 = DrawableUtil.getDrawableFromNet(paramTextView.getContext(), paramImgNode.src, GRAY_PLACEHOLDER, GRAY_PLACEHOLDER, localRect.right, localRect.bottom, new RichTextParser.DrawableCallBack(paramTextView));
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      paramTextView = DrawableUtil.getDrawable(paramTextView.getContext(), paramImgNode.src, GRAY_PLACEHOLDER, GRAY_PLACEHOLDER);
      localObject1 = paramTextView;
      if (paramTextView == null)
      {
        LogUtils.d("RichTextParser", "请处理未知图片: " + paramImgNode.src);
        return;
      }
    }
    ((Drawable)localObject1).setBounds(localRect);
    paramSpannableStringBuilder.setSpan(new RichTextParser.CustomImageSpan((Drawable)localObject1, 101), paramInt1, paramInt2, 33);
  }
  
  private static void dealNodeItem(TextView paramTextView, Node paramNode, SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = Math.max(paramSpannableStringBuilder.length(), 0);
    switch (paramNode.nodeType)
    {
    }
    while (paramNode.children != null)
    {
      paramNode = paramNode.children.iterator();
      while (paramNode.hasNext()) {
        dealNodeItem(paramTextView, (Node)paramNode.next(), paramSpannableStringBuilder);
      }
      paramSpannableStringBuilder.append(decodeEmotion(((TextNode)paramNode).text));
      dealTextStyle(paramTextView, paramNode, i, paramSpannableStringBuilder.length(), paramSpannableStringBuilder);
      continue;
      paramSpannableStringBuilder.append(',');
      dealImgNode(paramTextView, (ImgNode)paramNode, i, paramSpannableStringBuilder.length(), paramSpannableStringBuilder);
      continue;
      if (paramNode.truncateAttr != null) {
        truncateAttr = paramNode.truncateAttr;
      }
    }
  }
  
  private static void dealTextStyle(TextView paramTextView, Node paramNode, int paramInt1, int paramInt2, SpannableStringBuilder paramSpannableStringBuilder)
  {
    Map localMap = paramNode.cssStyleSet.getCssStyleMap();
    if (localMap != null)
    {
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        Object localObject1 = ((CssStyle)((Map.Entry)localObject2).getValue()).styleName;
        localObject2 = ((CssStyle)((Map.Entry)localObject2).getValue()).styleValue;
        int i;
        if ("line-height".equalsIgnoreCase((String)localObject1))
        {
          i = (int)(((Integer)localObject2).intValue() * paramNode.nodeRatio);
          if (i > maxLineHeight) {
            maxLineHeight = i;
          }
        }
        else if ("font-size".equalsIgnoreCase((String)localObject1))
        {
          i = (int)(((Integer)localObject2).intValue() * paramNode.nodeRatio);
          maxFontSize = Math.max(maxFontSize, i);
          RichTextUtils.addFontSizeSpan(paramSpannableStringBuilder, i, paramInt1, paramInt2);
        }
        else if ("color".equalsIgnoreCase((String)localObject1))
        {
          paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor((String)localObject2)), paramInt1, paramInt2, 33);
        }
        else if ("font-weight".equalsIgnoreCase((String)localObject1))
        {
          RichTextUtils.addFontWeightSpan(paramSpannableStringBuilder, String.valueOf(localObject2), paramInt1, paramInt2);
        }
        else if ("-webkit-line-clamp".equalsIgnoreCase((String)localObject1))
        {
          maxLines = ((Integer)localObject2).intValue();
          paramTextView.setMaxLines(maxLines);
        }
        else if ((!"display".equalsIgnoreCase((String)localObject1)) && ("href".equalsIgnoreCase((String)localObject1)))
        {
          localObject2 = String.valueOf(localObject2);
          localObject1 = (CssStyle)localMap.get("color");
          if (localObject1 != null) {}
          for (localObject1 = ((CssStyle)localObject1).styleValue;; localObject1 = Integer.valueOf(-12541697))
          {
            RichTextUtils.addClickSpan(paramTextView, paramSpannableStringBuilder, (String)localObject2, getHyperLinkColor(localObject1, -12541697), paramInt1, paramInt2);
            break;
          }
        }
      }
    }
  }
  
  private static CharSequence decodeEmotion(CharSequence paramCharSequence)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (CustomMethodsRegister.customMethodInterface != null)
    {
      Object localObject = CustomMethodsRegister.customMethodInterface.invoke("decodeEmotion", new Object[] { paramCharSequence });
      localCharSequence = paramCharSequence;
      if ((localObject instanceof CharSequence)) {
        localCharSequence = (CharSequence)localObject;
      }
    }
    return localCharSequence;
  }
  
  private static void doLineSpace(TextView paramTextView)
  {
    if ((maxLineHeight > 0) && (maxLineHeight > maxFontSize))
    {
      spaceHeight = maxLineHeight - maxFontSize;
      paramTextView.setLineSpacing(spaceHeight, 1.0F);
    }
  }
  
  private static CssStyleSet getCssStyleSet(String paramString1, String paramString2, Node paramNode, JSONObject paramJSONObject)
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
  
  private static int getHyperLinkColor(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      return paramInt;
    }
    try
    {
      int i = Color.parseColor(String.valueOf(paramObject));
      return i;
    }
    catch (Exception paramObject)
    {
      LogUtils.d("RichTextParser", "getHyperLinkColor error! msg=" + paramObject);
    }
    return paramInt;
  }
  
  public static TruncateAttr getTruncate()
  {
    if (truncateAttr != null) {
      truncateAttr.maxLines = maxLines;
    }
    return truncateAttr;
  }
  
  private static void init()
  {
    maxLineHeight = -1;
    spaceHeight = 0;
    maxFontSize = -1;
    maxLines = 100;
    truncateAttr = null;
  }
  
  private static Node parse(JSONArray paramJSONArray)
  {
    LayoutNode localLayoutNode = new LayoutNode();
    if (paramJSONArray == null) {
      return localLayoutNode;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject != null)
      {
        localObject = parseNodeItem((JSONObject)localObject, localLayoutNode);
        if (localObject != null) {
          localLayoutNode.children.add(localObject);
        }
      }
      i += 1;
    }
    return localLayoutNode;
  }
  
  public static void parse(TextView paramTextView, SpannableStringBuilder paramSpannableStringBuilder, Object paramObject)
  {
    if ((paramSpannableStringBuilder == null) || (paramObject == null)) {
      return;
    }
    init();
    dealNodeItem(paramTextView, parse((JSONArray)paramObject), paramSpannableStringBuilder);
    doLineSpace(paramTextView);
  }
  
  private static Node parseNodeItem(JSONObject paramJSONObject, Node paramNode)
  {
    String str1 = paramJSONObject.optString("name");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("attrs");
    Object localObject = null;
    String str2 = paramJSONObject.optString("type");
    if (localJSONObject != null) {
      localObject = localJSONObject.optString("style");
    }
    paramNode = createNode(paramNode, str1, str2, getCssStyleSet(str1, (String)localObject, paramNode, localJSONObject), paramJSONObject, localJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("children");
    if ((paramJSONObject != null) && (paramNode != null))
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localObject = parseNodeItem(paramJSONObject.optJSONObject(i), paramNode);
        if (localObject != null) {
          paramNode.children.add(localObject);
        }
        i += 1;
      }
    }
    return paramNode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser
 * JD-Core Version:    0.7.0.1
 */