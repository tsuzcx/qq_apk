package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.List;
import xdz;
import xea;
import xlx;
import ysv;

public class ShareGroupInnerListView
  extends StoryHomeHorizontalListView
{
  public String a;
  public xea a;
  protected xlx a;
  protected ysv a;
  
  public ShareGroupInnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShareGroupInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = DisplayUtil.dip2px(paramContext, 82.0F);
    this.jdField_a_of_type_Xlx = new xlx(paramContext);
    setAdapter(this.jdField_a_of_type_Xlx);
    setOnItemClickListener(this.jdField_a_of_type_Xlx);
    this.jdField_a_of_type_Ysv = new xdz(this);
    setOnLoadMoreListener(this.jdField_a_of_type_Ysv);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Xlx;
  }
  
  public void setData(VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    if (paramVideoCollectionItem.collectionCount > paramVideoCollectionItem.videoVidList.size()) {}
    for (boolean bool = true;; bool = false)
    {
      setLoadMoreComplete(bool);
      this.jdField_a_of_type_Xlx.a(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
      int i = this.b / this.c;
      if (paramVideoCollectionItem.collectionVideoUIItemList.size() < i) {
        break;
      }
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreDataListener(xea paramxea)
  {
    this.jdField_a_of_type_Xea = paramxea;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView
 * JD-Core Version:    0.7.0.1
 */