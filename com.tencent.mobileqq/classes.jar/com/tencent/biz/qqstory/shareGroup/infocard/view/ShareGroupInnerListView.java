package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper.OnLoadMoreListener;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.List;

public class ShareGroupInnerListView
  extends StoryHomeHorizontalListView
{
  public ShareGroupInnerListView.ILoadMoreDataListener a;
  protected MemoriesInnerListAdapter a;
  protected LoadingMoreHelper.OnLoadMoreListener a;
  public String a;
  
  public ShareGroupInnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShareGroupInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = DisplayUtil.a(paramContext, 82.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter = new MemoriesInnerListAdapter(paramContext);
    setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter);
    setOnItemClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper$OnLoadMoreListener = new ShareGroupInnerListView.1(this);
    setOnLoadMoreListener(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper$OnLoadMoreListener);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter;
  }
  
  public void setData(VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_JavaLangString = paramVideoCollectionItem.collectionId;
    if (paramVideoCollectionItem.collectionCount > paramVideoCollectionItem.videoVidList.size()) {}
    for (boolean bool = true;; bool = false)
    {
      setLoadMoreComplete(bool);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter.a(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
      int i = this.b / this.c;
      if (paramVideoCollectionItem.collectionVideoUIItemList.size() < i) {
        break;
      }
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreDataListener(ShareGroupInnerListView.ILoadMoreDataListener paramILoadMoreDataListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView$ILoadMoreDataListener = paramILoadMoreDataListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView
 * JD-Core Version:    0.7.0.1
 */