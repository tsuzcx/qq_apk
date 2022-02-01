package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.List;
import xsu;
import xsv;
import yas;
import zho;

public class ShareGroupInnerListView
  extends StoryHomeHorizontalListView
{
  public String a;
  public xsv a;
  protected yas a;
  protected zho a;
  
  public ShareGroupInnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShareGroupInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = DisplayUtil.dip2px(paramContext, 82.0F);
    this.jdField_a_of_type_Yas = new yas(paramContext);
    setAdapter(this.jdField_a_of_type_Yas);
    setOnItemClickListener(this.jdField_a_of_type_Yas);
    this.jdField_a_of_type_Zho = new xsu(this);
    setOnLoadMoreListener(this.jdField_a_of_type_Zho);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Yas;
  }
  
  public void setData(VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    if (paramVideoCollectionItem.collectionCount > paramVideoCollectionItem.videoVidList.size()) {}
    for (boolean bool = true;; bool = false)
    {
      setLoadMoreComplete(bool);
      this.jdField_a_of_type_Yas.a(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
      int i = this.b / this.c;
      if (paramVideoCollectionItem.collectionVideoUIItemList.size() < i) {
        break;
      }
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreDataListener(xsv paramxsv)
  {
    this.jdField_a_of_type_Xsv = paramxsv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView
 * JD-Core Version:    0.7.0.1
 */