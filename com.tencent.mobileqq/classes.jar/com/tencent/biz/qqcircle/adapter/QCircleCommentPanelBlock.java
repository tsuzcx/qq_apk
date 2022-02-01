package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.qqcircle.beans.QCircleCommentItemInfo;
import com.tencent.biz.qqcircle.beans.QCircleReplyItemInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseMultiViewBlock;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.widgets.comment.OnCommentElementClickListener;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QCircleCommentPanelBlock
  extends QCircleBaseMultiViewBlock<QCircleCommentItemInfo>
{
  private OnCommentElementClickListener a;
  private FeedCloudMeta.StFeed b;
  private RecyclerView c;
  private ReportBean<QCircleReportBean> d;
  private int e = 3;
  private int f = 3;
  
  public QCircleCommentPanelBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private int a(String paramString, int paramInt1, int paramInt2, QCircleCommentItemInfo paramQCircleCommentItemInfo)
  {
    int i = 0;
    while (i < paramQCircleCommentItemInfo.b.size())
    {
      FeedCloudMeta.StReply localStReply = ((QCircleReplyItemInfo)paramQCircleCommentItemInfo.b.get(i)).b;
      if ((localStReply != null) && (paramString.equals(localStReply.id.get())))
      {
        paramQCircleCommentItemInfo.a(paramString, this.e);
        return paramInt2;
      }
      i += 1;
    }
    return paramInt1;
  }
  
  private List<QCircleReplyItemInfo> a(QCircleCommentItemInfo paramQCircleCommentItemInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramQCircleCommentItemInfo.a.vecReply.size())
    {
      FeedCloudMeta.StReply localStReply = (FeedCloudMeta.StReply)paramQCircleCommentItemInfo.a.vecReply.get(i);
      if ((!a(paramQCircleCommentItemInfo, localStReply)) && (localArrayList.size() < paramInt)) {
        localArrayList.add(new QCircleReplyItemInfo(1, localStReply));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a()
  {
    RecyclerView localRecyclerView = this.c;
    if (localRecyclerView == null) {
      return;
    }
    localRecyclerView.setItemAnimator(null);
  }
  
  private void a(QCircleCommentItemInfo paramQCircleCommentItemInfo)
  {
    if (paramQCircleCommentItemInfo.a.vecReply.size() <= this.e)
    {
      int i = 0;
      while (i < paramQCircleCommentItemInfo.b.size())
      {
        QCircleReplyItemInfo localQCircleReplyItemInfo = (QCircleReplyItemInfo)paramQCircleCommentItemInfo.b.get(i);
        if ((localQCircleReplyItemInfo != null) && ((localQCircleReplyItemInfo.a == 2) || (localQCircleReplyItemInfo.a == 3)))
        {
          paramQCircleCommentItemInfo.b.remove(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void a(String paramString, QCircleCommentItemInfo paramQCircleCommentItemInfo)
  {
    int i = 0;
    while (i < paramQCircleCommentItemInfo.a.vecReply.get().size())
    {
      FeedCloudMeta.StReply localStReply = (FeedCloudMeta.StReply)paramQCircleCommentItemInfo.a.vecReply.get(i);
      if ((localStReply != null) && (paramString.equals(localStReply.id.get())))
      {
        paramQCircleCommentItemInfo.a.vecReply.remove(i);
        return;
      }
      i += 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    RecyclerView localRecyclerView = this.c;
    if (localRecyclerView != null)
    {
      if (localRecyclerView.isComputingLayout())
      {
        this.c.post(new QCircleCommentPanelBlock.1(this, paramBoolean));
        return;
      }
      if (paramBoolean) {
        a();
      }
      notifyDataSetChanged();
    }
  }
  
  private boolean a(QCircleCommentItemInfo paramQCircleCommentItemInfo, FeedCloudMeta.StReply paramStReply)
  {
    paramQCircleCommentItemInfo = paramQCircleCommentItemInfo.b.iterator();
    while (paramQCircleCommentItemInfo.hasNext())
    {
      QCircleReplyItemInfo localQCircleReplyItemInfo = (QCircleReplyItemInfo)paramQCircleCommentItemInfo.next();
      if ((localQCircleReplyItemInfo.a == 1) && (TextUtils.equals(localQCircleReplyItemInfo.b.id.get(), paramStReply.id.get()))) {
        return true;
      }
    }
    return false;
  }
  
  private List<QCircleCommentItemInfo> b(List<FeedCloudMeta.StComment> paramList)
  {
    if (paramList == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator.next();
      QCircleCommentItemInfo localQCircleCommentItemInfo = new QCircleCommentItemInfo(localStComment);
      int i;
      if ((c()) && (paramList.size() == 1))
      {
        i = localStComment.vecReply.size();
      }
      else
      {
        j = localStComment.vecReply.size();
        i = this.e;
        if (j <= i) {
          i = localStComment.vecReply.size();
        }
      }
      int j = 0;
      while (j < i)
      {
        localQCircleCommentItemInfo.a(1, (FeedCloudMeta.StReply)localStComment.vecReply.get(j));
        j += 1;
      }
      if (i < localStComment.vecReply.size()) {
        localQCircleCommentItemInfo.a(2, localStComment.vecReply.size() - i);
      }
      localArrayList.add(localQCircleCommentItemInfo);
    }
    return localArrayList;
  }
  
  private void b()
  {
    RecyclerView localRecyclerView = this.c;
    if (localRecyclerView == null) {
      return;
    }
    localRecyclerView.setItemAnimator(new EnhanceItemAnimator());
    if (!(this.c.getItemAnimator() instanceof SimpleItemAnimator)) {
      return;
    }
    ((SimpleItemAnimator)this.c.getItemAnimator()).setSupportsChangeAnimations(false);
  }
  
  private boolean c()
  {
    return (getReportBean() != null) && (getReportBean().getPageId() != 69);
  }
  
  private void d(int paramInt)
  {
    RecyclerView localRecyclerView = this.c;
    if (localRecyclerView != null)
    {
      if (localRecyclerView.isComputingLayout())
      {
        this.c.post(new QCircleCommentPanelBlock.3(this, paramInt));
        return;
      }
      if (paramInt != 0) {
        b();
      }
      notifyItemRemoved(paramInt);
      notifyItemRangeChanged(paramInt, this.mDataList.size() - paramInt);
    }
  }
  
  private void e(int paramInt)
  {
    RecyclerView localRecyclerView = this.c;
    if (localRecyclerView != null)
    {
      if (localRecyclerView.isComputingLayout())
      {
        this.c.post(new QCircleCommentPanelBlock.4(this, paramInt));
        return;
      }
      b();
      notifyItemChanged(paramInt);
    }
  }
  
  public int a(int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() >= paramInt)) {
      return ((QCircleCommentItemInfo)this.mDataList.get(paramInt)).a.vecReply.get().size();
    }
    return 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.mDataList.size() <= paramInt1) {
      return;
    }
    Object localObject = (QCircleCommentItemInfo)this.mDataList.get(paramInt1);
    if (((QCircleCommentItemInfo)localObject).b.size() > paramInt2)
    {
      if (((QCircleReplyItemInfo)((QCircleCommentItemInfo)localObject).b.get(paramInt2)).a != 2) {
        return;
      }
      paramInt1 = this.f;
      int i;
      if (((QCircleReplyItemInfo)((QCircleCommentItemInfo)localObject).b.get(paramInt2)).c <= paramInt1)
      {
        paramInt1 = ((QCircleReplyItemInfo)((QCircleCommentItemInfo)localObject).b.get(paramInt2)).c;
        i = 1;
      }
      else
      {
        i = 0;
      }
      List localList = a((QCircleCommentItemInfo)localObject, paramInt1);
      ((QCircleCommentItemInfo)localObject).b.addAll(paramInt2, localList);
      paramInt2 = ((QCircleCommentItemInfo)localObject).b.size() - 1;
      if (i != 0)
      {
        ((QCircleReplyItemInfo)((QCircleCommentItemInfo)localObject).b.get(paramInt2)).a = 3;
        ((QCircleReplyItemInfo)((QCircleCommentItemInfo)localObject).b.get(paramInt2)).c = 0;
      }
      else
      {
        localObject = (QCircleReplyItemInfo)((QCircleCommentItemInfo)localObject).b.get(paramInt2);
        ((QCircleReplyItemInfo)localObject).c -= paramInt1;
      }
      a(false);
    }
  }
  
  public void a(int paramInt, FeedCloudMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (paramInt <= this.mDataList.size())) {
      this.mDataList.add(paramInt, new QCircleCommentItemInfo(paramStComment));
    }
    a(false);
    paramStComment = this.c;
    if (paramStComment != null) {
      paramStComment.scrollToPosition(paramInt);
    }
  }
  
  public void a(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.d = paramReportBean;
  }
  
  public void a(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.a = paramOnCommentElementClickListener;
  }
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    if ((this.mDataList.size() > 0) && (((QCircleCommentItemInfo)this.mDataList.get(0)).a.typeFlag.get() == 1))
    {
      a(1, paramStComment);
      return;
    }
    a(0, paramStComment);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, List<FeedCloudMeta.StComment> paramList)
  {
    this.b = paramStFeed;
    this.mDataList.clear();
    a(true);
    this.mDataList.addAll(b(paramList));
    a(true);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
    while (i < this.mDataList.size())
    {
      if (((QCircleCommentItemInfo)this.mDataList.get(i)).a.id.get().equals(paramString))
      {
        this.mDataList.remove(i);
        break label69;
      }
      i += 1;
    }
    i = -1;
    label69:
    if (i != -1) {
      d(i);
    }
  }
  
  public void a(String paramString, FeedCloudMeta.StComment paramStComment)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
    while (i < this.mDataList.size())
    {
      if (paramString.equals(((QCircleCommentItemInfo)this.mDataList.get(i)).a.id.get()))
      {
        this.mDataList.set(i, new QCircleCommentItemInfo(paramStComment));
        break label77;
      }
      i += 1;
    }
    i = -1;
    label77:
    if (i != -1) {
      e(i);
    }
  }
  
  public void a(String paramString, FeedCloudMeta.StReply paramStReply)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
    while (i < this.mDataList.size())
    {
      QCircleCommentItemInfo localQCircleCommentItemInfo = (QCircleCommentItemInfo)this.mDataList.get(i);
      if (paramString.equals(localQCircleCommentItemInfo.a.id.get()))
      {
        localQCircleCommentItemInfo.a.vecReply.get().add(paramStReply);
        localQCircleCommentItemInfo.a(1, paramStReply);
        break label89;
      }
      i += 1;
    }
    i = -1;
    label89:
    if (i != -1) {
      e(i);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      int i = 0;
      while (i < this.mDataList.size())
      {
        QCircleCommentItemInfo localQCircleCommentItemInfo = (QCircleCommentItemInfo)this.mDataList.get(i);
        if ((paramString1.equals(localQCircleCommentItemInfo.a.id.get())) && (localQCircleCommentItemInfo.b != null) && (localQCircleCommentItemInfo.b.size() > 0))
        {
          a(paramString2, localQCircleCommentItemInfo);
          i = a(paramString2, -1, i, localQCircleCommentItemInfo);
          a(localQCircleCommentItemInfo);
          break label115;
        }
        i += 1;
      }
      i = -1;
      label115:
      if (i != -1) {
        e(i);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, FeedCloudMeta.StReply paramStReply)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      int i = 0;
      while (i < this.mDataList.size())
      {
        QCircleCommentItemInfo localQCircleCommentItemInfo = (QCircleCommentItemInfo)this.mDataList.get(i);
        if (paramString1.equals(localQCircleCommentItemInfo.a.id.get()))
        {
          int j = localQCircleCommentItemInfo.a.vecReply.get().size() - 1;
          while (j >= 0)
          {
            if (paramString2.equals(((FeedCloudMeta.StReply)localQCircleCommentItemInfo.a.vecReply.get(j)).id.get()))
            {
              localQCircleCommentItemInfo.a.vecReply.get().set(j, paramStReply);
              localQCircleCommentItemInfo.a(paramString2, paramStReply);
              break label167;
            }
            j -= 1;
          }
        }
        i += 1;
      }
      i = -1;
      label167:
      if (i != -1) {
        e(i);
      }
    }
  }
  
  public void a(List<FeedCloudMeta.StComment> paramList)
  {
    this.mDataList.addAll(this.mDataList.size(), b(paramList));
    a(true);
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.mDataList.size() <= paramInt1) {
      return;
    }
    QCircleCommentItemInfo localQCircleCommentItemInfo = (QCircleCommentItemInfo)this.mDataList.get(paramInt1);
    if (localQCircleCommentItemInfo.b.size() > paramInt2)
    {
      if (((QCircleReplyItemInfo)localQCircleCommentItemInfo.b.get(paramInt2)).a != 3) {
        return;
      }
      Iterator localIterator = localQCircleCommentItemInfo.b.iterator();
      paramInt1 = 0;
      while (localIterator.hasNext())
      {
        QCircleReplyItemInfo localQCircleReplyItemInfo = (QCircleReplyItemInfo)localIterator.next();
        if (paramInt1 < this.e)
        {
          paramInt1 += 1;
        }
        else
        {
          if (localQCircleReplyItemInfo.a == 3)
          {
            localQCircleReplyItemInfo.a = 2;
            localQCircleReplyItemInfo.c = (localQCircleCommentItemInfo.a.vecReply.size() - (localQCircleCommentItemInfo.b.size() - 1));
            break;
          }
          localIterator.remove();
        }
      }
      a(false);
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext())
    {
      QCircleCommentItemInfo localQCircleCommentItemInfo = (QCircleCommentItemInfo)localIterator.next();
      if (paramString.equals(localQCircleCommentItemInfo.a.id.get())) {
        localQCircleCommentItemInfo.a.typeFlag.set(0);
      }
    }
    a(false);
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject = null;
    if (this.mDataList.size() > 0)
    {
      if ((this.mDataList.get(0) != null) && (((QCircleCommentItemInfo)this.mDataList.get(0)).a.typeFlag.get() == 1)) {
        ((QCircleCommentItemInfo)this.mDataList.get(0)).a.typeFlag.set(0);
      }
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext())
      {
        QCircleCommentItemInfo localQCircleCommentItemInfo = (QCircleCommentItemInfo)localIterator.next();
        if (localQCircleCommentItemInfo.a.id.get().equals(paramString))
        {
          localQCircleCommentItemInfo.a.typeFlag.set(1);
          localObject = localQCircleCommentItemInfo;
        }
        else
        {
          localLinkedList.add(localQCircleCommentItemInfo);
        }
      }
      if (localObject != null) {
        localLinkedList.add(0, localObject);
      }
      this.mDataList.clear();
      a(false);
      this.mDataList.addAll(new ArrayList(localLinkedList));
    }
    a(false);
  }
  
  public void clearData()
  {
    this.mDataList.clear();
    a(true);
  }
  
  public int getItemCount()
  {
    if (this.mDataList == null) {
      return 0;
    }
    return this.mDataList.size();
  }
  
  protected String getLogTag()
  {
    return "QCircleCommentPanelBlock";
  }
  
  public QCircleReportBean getReportBean()
  {
    if (this.mReportBean != null) {
      return QCircleReportBean.getReportBean(getLogTag(), this.mReportBean);
    }
    if (this.d != null) {
      return QCircleReportBean.getReportBean(getLogTag(), (QCircleReportBean)this.d.getReportBean());
    }
    return null;
  }
  
  public int getViewTypeCount()
  {
    return 0;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > paramInt)) {
      ((QCircleCommentPanelBlock.CommentItemHolder)paramViewHolder).a(paramInt, this.b, (QCircleCommentItemInfo)this.mDataList.get(paramInt), this.a);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleCommentItemView(paramViewGroup.getContext());
    paramViewGroup.setReportBean(getReportBean());
    return new QCircleCommentPanelBlock.CommentItemHolder(this, paramViewGroup, null);
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    this.c = getParentRecyclerView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock
 * JD-Core Version:    0.7.0.1
 */