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
  public String a;
  protected MemoriesInnerListAdapter b;
  protected LoadingMoreHelper.OnLoadMoreListener c;
  public ShareGroupInnerListView.ILoadMoreDataListener d;
  
  public ShareGroupInnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShareGroupInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = DisplayUtil.a(paramContext, 82.0F);
    this.b = new MemoriesInnerListAdapter(paramContext);
    setAdapter(this.b);
    setOnItemClickListener(this.b);
    this.c = new ShareGroupInnerListView.1(this);
    setOnLoadMoreListener(this.c);
  }
  
  public BaseAdapter getAdapter()
  {
    return this.b;
  }
  
  public void setData(VideoCollectionItem paramVideoCollectionItem)
  {
    this.a = paramVideoCollectionItem.collectionId;
    boolean bool;
    if (paramVideoCollectionItem.collectionCount > paramVideoCollectionItem.videoVidList.size()) {
      bool = true;
    } else {
      bool = false;
    }
    setLoadMoreComplete(bool);
    this.b.a(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
    int i = this.f / this.g;
    if (paramVideoCollectionItem.collectionVideoUIItemList.size() >= i)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreDataListener(ShareGroupInnerListView.ILoadMoreDataListener paramILoadMoreDataListener)
  {
    this.d = paramILoadMoreDataListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView
 * JD-Core Version:    0.7.0.1
 */