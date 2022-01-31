package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import azvv;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import tzo;
import tzp;
import uhm;
import vqk;

public class ShareGroupInnerListView
  extends StoryHomeHorizontalListView
{
  public String a;
  public tzp a;
  protected uhm a;
  protected vqk a;
  
  public ShareGroupInnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShareGroupInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = azvv.a(paramContext, 82.0F);
    this.jdField_a_of_type_Uhm = new uhm(paramContext);
    setAdapter(this.jdField_a_of_type_Uhm);
    setOnItemClickListener(this.jdField_a_of_type_Uhm);
    this.jdField_a_of_type_Vqk = new tzo(this);
    setOnLoadMoreListener(this.jdField_a_of_type_Vqk);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Uhm;
  }
  
  public void setData(VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    if (paramVideoCollectionItem.collectionCount > paramVideoCollectionItem.videoVidList.size()) {}
    for (boolean bool = true;; bool = false)
    {
      setLoadMoreComplete(bool);
      this.jdField_a_of_type_Uhm.a(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
      int i = this.b / this.c;
      if (paramVideoCollectionItem.collectionVideoUIItemList.size() < i) {
        break;
      }
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreDataListener(tzp paramtzp)
  {
    this.jdField_a_of_type_Tzp = paramtzp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView
 * JD-Core Version:    0.7.0.1
 */