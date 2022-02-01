package com.tencent.biz.qqstory.album.tools;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeoHashTree$TreeNode
{
  public GeoHashTree.TreeNodeBean a;
  public List<TreeNode> a;
  private boolean a;
  
  public GeoHashTree$TreeNode()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean = new GeoHashTree.TreeNodeBean();
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_Int = 0;
    GeoHashTree.TreeNodeBean.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean, 0);
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_JavaLangString = null;
  }
  
  public GeoHashTree$TreeNode(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    String str = paramString.substring(0, paramInt1);
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean = new GeoHashTree.TreeNodeBean();
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_Int = paramInt1;
    GeoHashTree.TreeNodeBean.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean, paramInt2);
    if (paramInt1 < paramString.length())
    {
      paramString = new TreeNode(paramString, paramInt1 + 1, paramInt2);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
    }
  }
  
  public int a()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      j = GeoHashTree.TreeNodeBean.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean);
    }
    Iterator localIterator;
    int i;
    do
    {
      return j;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      j = i;
    } while (!localIterator.hasNext());
    TreeNode localTreeNode = (TreeNode)localIterator.next();
    if (!localTreeNode.jdField_a_of_type_Boolean) {
      i = localTreeNode.a() + i;
    }
    for (;;)
    {
      break;
    }
  }
  
  public List<TreeNode> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      localArrayList.add(this);
    }
    for (;;)
    {
      return localArrayList;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        TreeNode localTreeNode = (TreeNode)localIterator.next();
        if (!localTreeNode.jdField_a_of_type_Boolean) {
          if (localTreeNode.jdField_a_of_type_JavaUtilList.size() == 0) {
            localArrayList.add(localTreeNode);
          } else {
            localArrayList.addAll(localTreeNode.a());
          }
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((TreeNode)localIterator.next()).a();
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_Int != 0) && ((paramString.length() <= this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_Int) || (!TextUtils.equals(this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_JavaLangString, String.valueOf(paramString.substring(0, this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_Int)))))) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((TreeNode)localIterator.next()).a(paramString, paramInt))
      {
        paramString = this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean;
        GeoHashTree.TreeNodeBean.a(paramString, GeoHashTree.TreeNodeBean.a(paramString) + paramInt);
        return true;
      }
    }
    paramString = new TreeNode(paramString, this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean.jdField_a_of_type_Int + 1, paramInt);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    paramString = this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean;
    GeoHashTree.TreeNodeBean.a(paramString, GeoHashTree.TreeNodeBean.a(paramString) + paramInt);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNodeBean: ").append(this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashTree$TreeNodeBean).append(" ");
    localStringBuilder.append("child count:").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.GeoHashTree.TreeNode
 * JD-Core Version:    0.7.0.1
 */