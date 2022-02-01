package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet;
import java.util.ArrayList;
import java.util.List;

public class Node
{
  public static final int NODE_TYPE_IMG = 2;
  public static final int NODE_TYPE_LAYOUT = 3;
  public static final int NODE_TYPE_TEXT = 1;
  public List<Node> children = new ArrayList();
  public CssStyleSet cssStyleSet;
  public double nodeRatio = 1.0D;
  public int nodeType;
  
  public Node(int paramInt)
  {
    this.nodeType = paramInt;
  }
  
  public static boolean valueIsLegal(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return false;
      if ((!paramString.startsWith("$")) || (paramString.length() <= 1)) {
        break;
      }
      i = paramString.charAt(1);
    } while (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)) || (i == 95));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node
 * JD-Core Version:    0.7.0.1
 */