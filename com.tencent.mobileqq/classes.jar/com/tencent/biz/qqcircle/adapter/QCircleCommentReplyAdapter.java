package com.tencent.biz.qqcircle.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleReplyItemInfo;
import com.tencent.biz.qqcircle.comment.QCircleMoreReplyItemView;
import com.tencent.biz.qqcircle.comment.QCircleReplyItemView;
import com.tencent.biz.qqcircle.widgets.comment.OnCommentElementClickListener;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class QCircleCommentReplyAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private FeedCloudMeta.StFeed a;
  private FeedCloudMeta.StComment b;
  private List<QCircleReplyItemInfo> c;
  private OnCommentElementClickListener d;
  private int e;
  
  public void a(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.d = paramOnCommentElementClickListener;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, List<QCircleReplyItemInfo> paramList, int paramInt)
  {
    this.a = paramStFeed;
    this.b = paramStComment;
    this.c = paramList;
    this.e = paramInt;
  }
  
  public int getItemCount()
  {
    List localList = this.c;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    List localList = this.c;
    if ((localList != null) && (localList.size() > paramInt)) {
      return ((QCircleReplyItemInfo)this.c.get(paramInt)).a;
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    List localList = this.c;
    if ((localList != null) && (localList.size() > paramInt)) {
      ((QCircleCommentReplyAdapter.ReplyItemViewHolder)paramViewHolder).a((QCircleReplyItemInfo)this.c.get(paramInt), this.a, this.b, this.e, paramInt, this.d);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new QCircleCommentReplyAdapter.ReplyItemViewHolder(new QCircleReplyItemView(paramViewGroup.getContext()), null);
    }
    return new QCircleCommentReplyAdapter.ReplyItemViewHolder(new QCircleMoreReplyItemView(paramViewGroup.getContext()), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleCommentReplyAdapter
 * JD-Core Version:    0.7.0.1
 */