package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import baxn;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import umh;
import umi;
import uuf;
import wdd;

public class ShareGroupInnerListView
  extends StoryHomeHorizontalListView
{
  public String a;
  public umi a;
  protected uuf a;
  protected wdd a;
  
  public ShareGroupInnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShareGroupInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = baxn.a(paramContext, 82.0F);
    this.jdField_a_of_type_Uuf = new uuf(paramContext);
    setAdapter(this.jdField_a_of_type_Uuf);
    setOnItemClickListener(this.jdField_a_of_type_Uuf);
    this.jdField_a_of_type_Wdd = new umh(this);
    setOnLoadMoreListener(this.jdField_a_of_type_Wdd);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Uuf;
  }
  
  public void setData(VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    if (paramVideoCollectionItem.collectionCount > paramVideoCollectionItem.videoVidList.size()) {}
    for (boolean bool = true;; bool = false)
    {
      setLoadMoreComplete(bool);
      this.jdField_a_of_type_Uuf.a(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
      int i = this.b / this.c;
      if (paramVideoCollectionItem.collectionVideoUIItemList.size() < i) {
        break;
      }
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreDataListener(umi paramumi)
  {
    this.jdField_a_of_type_Umi = paramumi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView
 * JD-Core Version:    0.7.0.1
 */