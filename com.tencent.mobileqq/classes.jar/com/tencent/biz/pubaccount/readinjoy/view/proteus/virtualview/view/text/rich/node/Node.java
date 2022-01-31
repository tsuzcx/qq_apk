package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node;

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
  public int nodeType;
  
  public Node(int paramInt)
  {
    this.nodeType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node
 * JD-Core Version:    0.7.0.1
 */