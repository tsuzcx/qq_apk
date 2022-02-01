package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyle;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.ImgNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.LayoutNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.TextNode;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class RichTextParser
{
  private final Context context;
  
  public RichTextParser(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void addExtraInfo(Node paramNode1, Node paramNode2, CssStyleSet paramCssStyleSet, JSONObject paramJSONObject)
  {
    if (paramNode2 == null) {}
    do
    {
      return;
      paramNode2.cssStyleSet = paramCssStyleSet;
      paramNode2.nodeRatio = paramNode1.nodeRatio;
    } while ((paramJSONObject == null) || (!paramJSONObject.has("ratio")));
    paramNode2.nodeRatio = paramJSONObject.optDouble("ratio", 1.0D);
  }
  
  private Node createNode(Node paramNode, String paramString1, String paramString2, CssStyleSet paramCssStyleSet, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
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
      addExtraInfo(paramNode, paramString1, paramCssStyleSet, paramJSONObject2);
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
  
  private CssStyleSet getCssStyleSet(String paramString1, String paramString2, Node paramNode, JSONObject paramJSONObject)
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
      if (paramString1 == null) {
        break;
      }
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
  
  public Node parse(JSONArray paramJSONArray)
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
  
  public Node parseNodeItem(JSONObject paramJSONObject, Node paramNode)
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