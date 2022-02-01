package com.tencent.biz.qqstory.album.tools;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeoHashTree$TreeNode
{
  public GeoHashTree.TreeNodeBean a;
  public List<TreeNode> b = new ArrayList();
  private boolean c = false;
  
  public GeoHashTree$TreeNode()
  {
    this.a = new GeoHashTree.TreeNodeBean();
    GeoHashTree.TreeNodeBean localTreeNodeBean = this.a;
    localTreeNodeBean.a = 0;
    GeoHashTree.TreeNodeBean.a(localTreeNodeBean, 0);
    this.a.b = null;
  }
  
  public GeoHashTree$TreeNode(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString.substring(0, paramInt1);
    this.a = new GeoHashTree.TreeNodeBean();
    GeoHashTree.TreeNodeBean localTreeNodeBean = this.a;
    localTreeNodeBean.b = str;
    localTreeNodeBean.a = paramInt1;
    GeoHashTree.TreeNodeBean.a(localTreeNodeBean, paramInt2);
    if (paramInt1 < paramString.length())
    {
      paramString = new TreeNode(paramString, paramInt1 + 1, paramInt2);
      this.b.add(paramString);
    }
  }
  
  public void a()
  {
    this.c = true;
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((TreeNode)localIterator.next()).a();
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((this.a.a != 0) && ((paramString.length() <= this.a.a) || (!TextUtils.equals(this.a.b, String.valueOf(paramString.substring(0, this.a.a)))))) {
      return false;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (((TreeNode)localIterator.next()).a(paramString, paramInt))
      {
        paramString = this.a;
        GeoHashTree.TreeNodeBean.a(paramString, GeoHashTree.TreeNodeBean.a(paramString) + paramInt);
        return true;
      }
    }
    paramString = new TreeNode(paramString, this.a.a + 1, paramInt);
    this.b.add(paramString);
    paramString = this.a;
    GeoHashTree.TreeNodeBean.a(paramString, GeoHashTree.TreeNodeBean.a(paramString) + paramInt);
    return true;
  }
  
  public int b()
  {
    if (this.b.size() == 0) {
      return GeoHashTree.TreeNodeBean.a(this.a);
    }
    int i = 0;
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      TreeNode localTreeNode = (TreeNode)localIterator.next();
      if (!localTreeNode.c) {
        i += localTreeNode.b();
      }
    }
    return i;
  }
  
  public List<TreeNode> c()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.b.size() == 0)
    {
      localArrayList.add(this);
      return localArrayList;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      TreeNode localTreeNode = (TreeNode)localIterator.next();
      if (!localTreeNode.c) {
        if (localTreeNode.b.size() == 0) {
          localArrayList.add(localTreeNode);
        } else {
          localArrayList.addAll(localTreeNode.c());
        }
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNodeBean: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append("child count:");
    localStringBuilder.append(this.b.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.GeoHashTree.TreeNode
 * JD-Core Version:    0.7.0.1
 */