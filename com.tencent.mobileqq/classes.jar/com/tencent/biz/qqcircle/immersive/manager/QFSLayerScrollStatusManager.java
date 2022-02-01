package com.tencent.biz.qqcircle.immersive.manager;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.manager.scroller.QFSLayerBaseScroller;
import com.tencent.biz.qqcircle.immersive.views.QFSLayerFeedItemView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class QFSLayerScrollStatusManager
  implements IQFSLayerScrollerStatus
{
  private HashSet<RecyclerView.ViewHolder> a = new HashSet();
  private ArrayList<QFSLayerBaseScroller> b = new ArrayList();
  
  private void b()
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((QFSLayerBaseScroller)((Iterator)localObject).next()).a(this.a);
    }
  }
  
  public void a()
  {
    QLog.i("QFSLayerScrollStatusManager", 1, "fs_lifecycle onDestroy");
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      if ((localViewHolder.itemView instanceof QFSLayerFeedItemView)) {
        ((QFSLayerFeedItemView)localViewHolder.itemView).a();
      }
    }
    localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((QFSLayerBaseScroller)localIterator.next()).a();
    }
    this.a = null;
    this.b = null;
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (this.b == null) {
        return;
      }
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (RecyclerView.ViewHolder)((Iterator)localObject1).next();
        if (((RecyclerView.ViewHolder)localObject2).getAdapterPosition() == paramInt1)
        {
          if ((((RecyclerView.ViewHolder)localObject2).itemView instanceof QFSLayerFeedItemView)) {
            ((QFSLayerFeedItemView)((RecyclerView.ViewHolder)localObject2).itemView).a(paramInt1, paramFloat, paramInt2);
          }
          localObject2 = this.b.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((QFSLayerBaseScroller)((Iterator)localObject2).next()).a(paramInt1, paramFloat, paramInt2);
          }
        }
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    HashSet localHashSet = this.a;
    if ((localHashSet != null) && (paramViewHolder != null))
    {
      if (localHashSet.contains(paramViewHolder)) {
        return;
      }
      this.a.add(paramViewHolder);
      b();
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("addViewHolder  holderNum = ");
      paramViewHolder.append(this.a.size());
      QLog.i("QFSLayerScrollStatusManager", 1, paramViewHolder.toString());
    }
  }
  
  public void a(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onResumed  position = ");
    ((StringBuilder)localObject).append(paramQFSFeedSelectInfo);
    QLog.i("QFSLayerScrollStatusManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)((Iterator)localObject).next();
      if ((localViewHolder.itemView instanceof QFSLayerFeedItemView)) {
        ((QFSLayerFeedItemView)localViewHolder.itemView).a(paramQFSFeedSelectInfo);
      }
    }
    localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((QFSLayerBaseScroller)((Iterator)localObject).next()).a(paramQFSFeedSelectInfo);
    }
  }
  
  public void a(QFSLayerBaseScroller paramQFSLayerBaseScroller)
  {
    ArrayList localArrayList = this.b;
    if (localArrayList != null)
    {
      if (paramQFSLayerBaseScroller == null) {
        return;
      }
      localArrayList.add(paramQFSLayerBaseScroller);
    }
  }
  
  public void b(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onPaused  position = ");
    ((StringBuilder)localObject).append(paramQFSFeedSelectInfo);
    QLog.i("QFSLayerScrollStatusManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)((Iterator)localObject).next();
      if ((localViewHolder.itemView instanceof QFSLayerFeedItemView)) {
        ((QFSLayerFeedItemView)localViewHolder.itemView).b(paramQFSFeedSelectInfo);
      }
    }
    localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((QFSLayerBaseScroller)((Iterator)localObject).next()).b(paramQFSFeedSelectInfo);
    }
  }
  
  public void c(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onPaused  position = ");
    ((StringBuilder)localObject).append(paramQFSFeedSelectInfo);
    QLog.i("QFSLayerScrollStatusManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)((Iterator)localObject).next();
      if ((localViewHolder.itemView instanceof QFSLayerFeedItemView)) {
        ((QFSLayerFeedItemView)localViewHolder.itemView).c(paramQFSFeedSelectInfo);
      }
    }
    localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((QFSLayerBaseScroller)((Iterator)localObject).next()).c(paramQFSFeedSelectInfo);
    }
  }
  
  public void d(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onSelected  position = ");
    ((StringBuilder)localObject).append(paramQFSFeedSelectInfo);
    QLog.i("QFSLayerScrollStatusManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if ((localObject != null) && (this.b != null))
    {
      if (paramQFSFeedSelectInfo == null) {
        return;
      }
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)((Iterator)localObject).next();
        if (localViewHolder.getAdapterPosition() == paramQFSFeedSelectInfo.b())
        {
          if ((localViewHolder.itemView instanceof QFSLayerFeedItemView)) {
            ((QFSLayerFeedItemView)localViewHolder.itemView).d(paramQFSFeedSelectInfo);
          }
          Iterator localIterator = this.b.iterator();
          while (localIterator.hasNext()) {
            ((QFSLayerBaseScroller)localIterator.next()).a(paramQFSFeedSelectInfo, localViewHolder);
          }
        }
      }
    }
  }
  
  public void e(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onUnSelected  position = ");
    ((StringBuilder)localObject).append(paramQFSFeedSelectInfo);
    QLog.i("QFSLayerScrollStatusManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if ((localObject != null) && (this.b != null))
    {
      if (paramQFSFeedSelectInfo == null) {
        return;
      }
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)((Iterator)localObject).next();
        if (localViewHolder.getAdapterPosition() == paramQFSFeedSelectInfo.b())
        {
          if ((localViewHolder.itemView instanceof QFSLayerFeedItemView)) {
            ((QFSLayerFeedItemView)localViewHolder.itemView).e(paramQFSFeedSelectInfo);
          }
          Iterator localIterator = this.b.iterator();
          while (localIterator.hasNext()) {
            ((QFSLayerBaseScroller)localIterator.next()).b(paramQFSFeedSelectInfo, localViewHolder);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.manager.QFSLayerScrollStatusManager
 * JD-Core Version:    0.7.0.1
 */