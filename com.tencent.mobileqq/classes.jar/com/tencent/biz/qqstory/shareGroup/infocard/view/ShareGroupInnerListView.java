package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import bcwh;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import waz;
import wba;
import wix;
import xrv;

public class ShareGroupInnerListView
  extends StoryHomeHorizontalListView
{
  public String a;
  public wba a;
  protected wix a;
  protected xrv a;
  
  public ShareGroupInnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShareGroupInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = bcwh.a(paramContext, 82.0F);
    this.jdField_a_of_type_Wix = new wix(paramContext);
    setAdapter(this.jdField_a_of_type_Wix);
    setOnItemClickListener(this.jdField_a_of_type_Wix);
    this.jdField_a_of_type_Xrv = new waz(this);
    setOnLoadMoreListener(this.jdField_a_of_type_Xrv);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Wix;
  }
  
  public void setData(VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    if (paramVideoCollectionItem.collectionCount > paramVideoCollectionItem.videoVidList.size()) {}
    for (boolean bool = true;; bool = false)
    {
      setLoadMoreComplete(bool);
      this.jdField_a_of_type_Wix.a(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
      int i = this.b / this.c;
      if (paramVideoCollectionItem.collectionVideoUIItemList.size() < i) {
        break;
      }
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreDataListener(wba paramwba)
  {
    this.jdField_a_of_type_Wba = paramwba;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView
 * JD-Core Version:    0.7.0.1
 */