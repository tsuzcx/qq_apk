package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import bggq;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import xyt;
import xyu;
import ygr;
import zpp;

public class ShareGroupInnerListView
  extends StoryHomeHorizontalListView
{
  public String a;
  public xyu a;
  protected ygr a;
  protected zpp a;
  
  public ShareGroupInnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShareGroupInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = bggq.a(paramContext, 82.0F);
    this.jdField_a_of_type_Ygr = new ygr(paramContext);
    setAdapter(this.jdField_a_of_type_Ygr);
    setOnItemClickListener(this.jdField_a_of_type_Ygr);
    this.jdField_a_of_type_Zpp = new xyt(this);
    setOnLoadMoreListener(this.jdField_a_of_type_Zpp);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Ygr;
  }
  
  public void setData(VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    if (paramVideoCollectionItem.collectionCount > paramVideoCollectionItem.videoVidList.size()) {}
    for (boolean bool = true;; bool = false)
    {
      setLoadMoreComplete(bool);
      this.jdField_a_of_type_Ygr.a(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
      int i = this.b / this.c;
      if (paramVideoCollectionItem.collectionVideoUIItemList.size() < i) {
        break;
      }
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreDataListener(xyu paramxyu)
  {
    this.jdField_a_of_type_Xyu = paramxyu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView
 * JD-Core Version:    0.7.0.1
 */