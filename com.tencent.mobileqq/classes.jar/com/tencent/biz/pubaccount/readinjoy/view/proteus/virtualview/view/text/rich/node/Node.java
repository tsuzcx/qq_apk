package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.TruncateAttr;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet;
import java.util.ArrayList;
import java.util.List;

public class Node
{
  public static final String ATTRS_ATTR = "attrs";
  public static final String CHILDREN_ATTR = "children";
  public static final String IMG_NODE = "img";
  public static final String NAME_ATTR = "name";
  public static final int NODE_TYPE_IMG = 2;
  public static final int NODE_TYPE_LAYOUT = 3;
  public static final int NODE_TYPE_TEXT = 1;
  public static final String STYLE_ATTR = "style";
  public static final String TEXT_NODE = "text";
  public static final String TRUNCATE_ATTR = "truncationAttrs";
  public static final String TYPE_ATTR = "type";
  public List<Node> children = new ArrayList();
  public CssStyleSet cssStyleSet;
  public double nodeRatio = 1.0D;
  public int nodeType;
  public TruncateAttr truncateAttr;
  
  public Node(int paramInt)
  {
    this.nodeType = paramInt;
  }
  
  public static boolean valueIsLegal(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if ((paramString.startsWith("$")) && (paramString.length() > 1))
    {
      int i = paramString.charAt(1);
      if (i >= 97)
      {
        bool1 = bool2;
        if (i <= 122) {
          return bool1;
        }
      }
      if (i >= 65)
      {
        bool1 = bool2;
        if (i <= 90) {
          return bool1;
        }
      }
      if (i == 95) {
        return false;
      }
    }
    bool1 = true;
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node
 * JD-Core Version:    0.7.0.1
 */