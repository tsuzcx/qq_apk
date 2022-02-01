package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich;

import android.content.Context;
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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.IViewProxy.ViewProxyImpl;
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
  private static int maxFontSize = -1;
  private static int maxLineHeight = -1;
  private static int maxLines = 100;
  private static int spaceHeight;
  private static TruncateAttr truncateAttr;
  
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
    boolean bool = "text".equals(paramString2);
    paramString2 = null;
    String str;
    if (bool)
    {
      str = paramJSONObject1.optString("text");
      paramString1 = paramString2;
      if (Node.valueIsLegal(str))
      {
        paramString1 = new TextNode();
        ((TextNode)paramString1).text = str;
      }
    }
    else if ("img".equals(paramString1))
    {
      str = paramJSONObject2.optString("src");
      paramString1 = paramString2;
      if (Node.valueIsLegal(str))
      {
        paramString1 = new ImgNode();
        ((ImgNode)paramString1).src = str;
      }
    }
    else
    {
      paramString1 = new LayoutNode();
    }
    addExtraInfo(paramNode, paramString1, paramJSONObject1, paramCssStyleSet, paramJSONObject2);
    return paramString1;
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
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
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
    localObject1 = paramTextView.getContext();
    Object localObject2 = paramImgNode.src;
    Object localObject3 = GRAY_PLACEHOLDER;
    localObject2 = DrawableUtil.getDrawableFromNet((Context)localObject1, (String)localObject2, (Drawable)localObject3, (Drawable)localObject3, localRect.right, localRect.bottom, new RichTextParser.DrawableCallBack(paramTextView));
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      paramTextView = paramTextView.getContext();
      localObject1 = paramImgNode.src;
      localObject2 = GRAY_PLACEHOLDER;
      paramTextView = DrawableUtil.getDrawable(paramTextView, (String)localObject1, (Drawable)localObject2, (Drawable)localObject2);
      localObject1 = paramTextView;
      if (paramTextView == null)
      {
        paramTextView = new StringBuilder();
        paramTextView.append("请处理未知图片: ");
        paramTextView.append(paramImgNode.src);
        LogUtils.d("RichTextParser", paramTextView.toString());
        return;
      }
    }
    ((Drawable)localObject1).setBounds(localRect);
    paramTextView = new RichTextParser.CustomImageSpan((Drawable)localObject1, 101);
    paramImgNode = truncateAttr;
    if (paramImgNode != null) {
      paramImgNode.imageSpans.add(paramTextView);
    }
    paramSpannableStringBuilder.setSpan(paramTextView, paramInt1, paramInt2, 33);
  }
  
  private static void dealNodeItem(TextView paramTextView, Node paramNode, SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = Math.max(paramSpannableStringBuilder.length(), 0);
    int j = paramNode.nodeType;
    if (j != 1)
    {
      if (j != 2)
      {
        if ((j == 3) && (paramNode.truncateAttr != null)) {
          truncateAttr = paramNode.truncateAttr;
        }
      }
      else
      {
        paramSpannableStringBuilder.append(',');
        dealImgNode(paramTextView, (ImgNode)paramNode, i, paramSpannableStringBuilder.length(), paramSpannableStringBuilder);
      }
    }
    else
    {
      paramSpannableStringBuilder.append(decodeEmotion(paramTextView, ((TextNode)paramNode).text));
      dealTextStyle(paramTextView, paramNode, i, paramSpannableStringBuilder.length(), paramSpannableStringBuilder);
    }
    if (paramNode.children != null)
    {
      paramNode = paramNode.children.iterator();
      while (paramNode.hasNext()) {
        dealNodeItem(paramTextView, (Node)paramNode.next(), paramSpannableStringBuilder);
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
        double d1;
        double d2;
        int i;
        if ("line-height".equalsIgnoreCase((String)localObject1))
        {
          d1 = ((Integer)localObject2).intValue();
          d2 = paramNode.nodeRatio;
          Double.isNaN(d1);
          i = (int)(d1 * d2);
          if (i > maxLineHeight) {
            maxLineHeight = i;
          }
        }
        else if ("font-size".equalsIgnoreCase((String)localObject1))
        {
          d1 = ((Integer)localObject2).intValue();
          d2 = paramNode.nodeRatio;
          Double.isNaN(d1);
          i = (int)(d1 * d2);
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
          if (localObject1 != null) {
            localObject1 = ((CssStyle)localObject1).styleValue;
          } else {
            localObject1 = Integer.valueOf(-12541697);
          }
          RichTextUtils.addClickSpan(paramTextView, paramSpannableStringBuilder, (String)localObject2, getHyperLinkColor(localObject1, -12541697), paramInt1, paramInt2);
        }
      }
    }
  }
  
  private static CharSequence decodeEmotion(TextView paramTextView, CharSequence paramCharSequence)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (CustomMethodsRegister.customMethodInterface != null)
    {
      paramTextView = CustomMethodsRegister.customMethodInterface.invoke("decodeEmotion", new Object[] { paramCharSequence, new IViewProxy.ViewProxyImpl(paramTextView) });
      localCharSequence = paramCharSequence;
      if ((paramTextView instanceof CharSequence)) {
        localCharSequence = (CharSequence)paramTextView;
      }
    }
    return localCharSequence;
  }
  
  private static void doLineSpace(TextView paramTextView)
  {
    int i = maxLineHeight;
    if (i > 0)
    {
      int j = maxFontSize;
      if (i > j)
      {
        spaceHeight = i - j;
        paramTextView.setLineSpacing(spaceHeight, 1.0F);
      }
    }
  }
  
  private static CssStyleSet getCssStyleSet(String paramString1, String paramString2, Node paramNode, JSONObject paramJSONObject)
  {
    CssStyleSet localCssStyleSet = new CssStyleSet();
    if ((paramNode != null) && (paramNode.cssStyleSet != null)) {
      localCssStyleSet.addInheritStyle(paramNode.cssStyleSet);
    }
    if ((!"div".equalsIgnoreCase(paramString1)) && (!"p".equalsIgnoreCase(paramString1)))
    {
      if ("strong".equalsIgnoreCase(paramString1)) {
        localCssStyleSet.addCssStyle(CssStyle.createStyle("font-weight", "bold"));
      } else if (("a".equalsIgnoreCase(paramString1)) && (paramJSONObject != null)) {
        localCssStyleSet.addCssStyle(CssStyle.createStyle("href", paramJSONObject.optString("href")));
      } else {
        localCssStyleSet.addCssStyle(CssStyle.getDisplay(false));
      }
    }
    else {
      localCssStyleSet.addCssStyle(CssStyle.getDisplay(true));
    }
    if (paramString2 != null)
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHyperLinkColor error! msg=");
      localStringBuilder.append(paramObject);
      LogUtils.d("RichTextParser", localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public static TruncateAttr getTruncate()
  {
    TruncateAttr localTruncateAttr = truncateAttr;
    if (localTruncateAttr != null) {
      localTruncateAttr.maxLines = maxLines;
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
    if (paramSpannableStringBuilder != null)
    {
      if (paramObject == null) {
        return;
      }
      init();
      dealNodeItem(paramTextView, parse((JSONArray)paramObject), paramSpannableStringBuilder);
      doLineSpace(paramTextView);
    }
  }
  
  private static Node parseNodeItem(JSONObject paramJSONObject, Node paramNode)
  {
    String str1 = paramJSONObject.optString("name");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("attrs");
    String str2 = paramJSONObject.optString("type");
    Object localObject;
    if (localJSONObject != null) {
      localObject = localJSONObject.optString("style");
    } else {
      localObject = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser
 * JD-Core Version:    0.7.0.1
 */