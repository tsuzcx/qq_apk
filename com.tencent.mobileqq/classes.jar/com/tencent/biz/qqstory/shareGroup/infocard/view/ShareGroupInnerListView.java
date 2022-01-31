package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import bdaq;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import wfi;
import wfj;
import wng;
import xwe;

public class ShareGroupInnerListView
  extends StoryHomeHorizontalListView
{
  public String a;
  public wfj a;
  protected wng a;
  protected xwe a;
  
  public ShareGroupInnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShareGroupInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = bdaq.a(paramContext, 82.0F);
    this.jdField_a_of_type_Wng = new wng(paramContext);
    setAdapter(this.jdField_a_of_type_Wng);
    setOnItemClickListener(this.jdField_a_of_type_Wng);
    this.jdField_a_of_type_Xwe = new wfi(this);
    setOnLoadMoreListener(this.jdField_a_of_type_Xwe);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Wng;
  }
  
  public void setData(VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    if (paramVideoCollectionItem.collectionCount > paramVideoCollectionItem.videoVidList.size()) {}
    for (boolean bool = true;; bool = false)
    {
      setLoadMoreComplete(bool);
      this.jdField_a_of_type_Wng.a(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
      int i = this.b / this.c;
      if (paramVideoCollectionItem.collectionVideoUIItemList.size() < i) {
        break;
      }
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreDataListener(wfj paramwfj)
  {
    this.jdField_a_of_type_Wfj = paramwfj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView
 * JD-Core Version:    0.7.0.1
 */