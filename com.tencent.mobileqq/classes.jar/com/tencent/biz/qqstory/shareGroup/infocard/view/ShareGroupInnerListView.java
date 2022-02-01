package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import bhgr;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import yco;
import ycp;
import ykm;
import ztk;

public class ShareGroupInnerListView
  extends StoryHomeHorizontalListView
{
  public String a;
  public ycp a;
  protected ykm a;
  protected ztk a;
  
  public ShareGroupInnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShareGroupInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = bhgr.a(paramContext, 82.0F);
    this.jdField_a_of_type_Ykm = new ykm(paramContext);
    setAdapter(this.jdField_a_of_type_Ykm);
    setOnItemClickListener(this.jdField_a_of_type_Ykm);
    this.jdField_a_of_type_Ztk = new yco(this);
    setOnLoadMoreListener(this.jdField_a_of_type_Ztk);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_Ykm;
  }
  
  public void setData(VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    if (paramVideoCollectionItem.collectionCount > paramVideoCollectionItem.videoVidList.size()) {}
    for (boolean bool = true;; bool = false)
    {
      setLoadMoreComplete(bool);
      this.jdField_a_of_type_Ykm.a(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
      int i = this.b / this.c;
      if (paramVideoCollectionItem.collectionVideoUIItemList.size() < i) {
        break;
      }
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreDataListener(ycp paramycp)
  {
    this.jdField_a_of_type_Ycp = paramycp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView
 * JD-Core Version:    0.7.0.1
 */