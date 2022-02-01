package com.tencent.hippy.qq.tuwen.adapter;

import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.hippy.qq.tuwen.callback.ITKDTuWenHippyObserver;
import com.tencent.util.Pair;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class TKDTuWenHippyCommentAdapter$MyDataChangeListener
  implements ReadInJoyCommentDataManager.OnDataChangeListener
{
  private TKDTuWenHippyCommentAdapter$MyDataChangeListener(TKDTuWenHippyCommentAdapter paramTKDTuWenHippyCommentAdapter) {}
  
  private void notifyDeleteMainComment(String paramString)
  {
    Iterator localIterator = TKDTuWenHippyCommentAdapter.access$600(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ITKDTuWenHippyObserver localITKDTuWenHippyObserver = (ITKDTuWenHippyObserver)localIterator.next();
      if (localITKDTuWenHippyObserver != null) {
        localITKDTuWenHippyObserver.onDeleteMainComment(paramString);
      }
    }
  }
  
  private void notifyDeleteSubComment(String paramString1, String paramString2)
  {
    Iterator localIterator = TKDTuWenHippyCommentAdapter.access$600(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ITKDTuWenHippyObserver localITKDTuWenHippyObserver = (ITKDTuWenHippyObserver)localIterator.next();
      if (localITKDTuWenHippyObserver != null) {
        localITKDTuWenHippyObserver.onDeleteSubComment(paramString1, paramString2);
      }
    }
  }
  
  private void notifyInsertSubComment(String paramString1, String paramString2, SubCommentData paramSubCommentData)
  {
    Iterator localIterator = TKDTuWenHippyCommentAdapter.access$600(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ITKDTuWenHippyObserver localITKDTuWenHippyObserver = (ITKDTuWenHippyObserver)localIterator.next();
      if (localITKDTuWenHippyObserver != null) {
        localITKDTuWenHippyObserver.onInsertSubComment(paramString1, paramString2, paramSubCommentData);
      }
    }
  }
  
  private void notifyLikeMainComment(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = TKDTuWenHippyCommentAdapter.access$600(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ITKDTuWenHippyObserver localITKDTuWenHippyObserver = (ITKDTuWenHippyObserver)localIterator.next();
      if (localITKDTuWenHippyObserver != null) {
        localITKDTuWenHippyObserver.onLikeMainCommentChanged(paramString, paramBoolean);
      }
    }
  }
  
  public void onCommentBlock(int paramInt, boolean paramBoolean, Pair<List<BaseCommentData>, List<BaseCommentData>> paramPair) {}
  
  public void onCommentCreate(boolean paramBoolean, CommentViewItem paramCommentViewItem, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, CommentViewItem paramCommentViewItem, boolean paramBoolean2, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, CommentViewItem paramCommentViewItem, int paramInt2)
  {
    String str;
    if ((paramBoolean) && (paramCommentViewItem != null))
    {
      paramCommentViewItem = paramCommentViewItem.a;
      if (paramCommentViewItem != null)
      {
        str = paramCommentViewItem.commentId;
        if (!(paramCommentViewItem instanceof SubCommentData)) {
          break label44;
        }
        notifyDeleteSubComment(((SubCommentData)paramCommentViewItem).parentCommentId, str);
      }
    }
    return;
    label44:
    notifyDeleteMainComment(str);
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((paramBoolean) && (paramInt1 == 0) && ((paramBaseCommentData instanceof CommentData))) {
      if (paramInt2 != 1) {
        break label37;
      }
    }
    label37:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      notifyLikeMainComment(paramBaseCommentData.commentId, paramBoolean);
      return;
    }
  }
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2) {}
  
  public void onCommentReply(boolean paramBoolean, CommentViewItem paramCommentViewItem)
  {
    if ((paramBoolean) && (paramCommentViewItem != null))
    {
      paramCommentViewItem = paramCommentViewItem.a;
      if ((paramCommentViewItem != null) && ((paramCommentViewItem instanceof SubCommentData)))
      {
        paramCommentViewItem = (SubCommentData)paramCommentViewItem;
        notifyInsertSubComment(paramCommentViewItem.parentCommentId, paramCommentViewItem.repliedCommentId, paramCommentViewItem);
      }
    }
  }
  
  public void onCommentReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onCommentStateError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.adapter.TKDTuWenHippyCommentAdapter.MyDataChangeListener
 * JD-Core Version:    0.7.0.1
 */