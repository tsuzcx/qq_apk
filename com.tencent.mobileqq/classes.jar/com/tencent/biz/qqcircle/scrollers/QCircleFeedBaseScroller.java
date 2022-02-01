package com.tencent.biz.qqcircle.scrollers;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseMultiViewBlock;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class QCircleFeedBaseScroller
  implements SimpleEventReceiver
{
  protected QCircleFeedScrollManager a;
  protected RecyclerView b;
  protected Context c;
  protected QCircleExtraTypeInfo d;
  protected int e;
  protected BaseListViewAdapter f;
  private boolean g = false;
  private int h = -1;
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {}
  
  public void a(Context paramContext, RecyclerView paramRecyclerView, BaseListViewAdapter paramBaseListViewAdapter, QCircleFeedScrollManager paramQCircleFeedScrollManager)
  {
    this.c = paramContext;
    this.b = paramRecyclerView;
    this.f = paramBaseListViewAdapter;
    this.a = paramQCircleFeedScrollManager;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView.getAdapter() instanceof BlockMerger))
    {
      paramRecyclerView = ((BlockMerger)paramRecyclerView.getAdapter()).getDataList().iterator();
      while (paramRecyclerView.hasNext())
      {
        MultiViewBlock localMultiViewBlock = (MultiViewBlock)paramRecyclerView.next();
        if ((localMultiViewBlock instanceof QCircleBaseMultiViewBlock)) {
          this.f = ((QCircleBaseMultiViewBlock)localMultiViewBlock);
        }
      }
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.d = paramQCircleExtraTypeInfo;
  }
  
  protected boolean a(View paramView)
  {
    if (paramView != null)
    {
      Rect localRect = new Rect(0, 0, ImmersiveUtils.b(), ImmersiveUtils.c());
      paramView.getGlobalVisibleRect(localRect);
      int j = paramView.getHeight();
      int i;
      if (localRect.bottom > 0)
      {
        if (localRect.bottom > DisplayUtil.e()) {
          localRect.bottom = DisplayUtil.e();
        }
        i = localRect.bottom - localRect.top;
      }
      else
      {
        i = 0;
      }
      if (i / j >= 0.5D) {
        return f();
      }
    }
    return false;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public boolean b(View paramView)
  {
    int i = ImmersiveUtils.c() / 2;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramView != null)
    {
      Rect localRect = new Rect(0, 0, ImmersiveUtils.b(), ImmersiveUtils.c());
      paramView.getGlobalVisibleRect(localRect);
      bool1 = bool2;
      if (localRect.bottom > i)
      {
        bool1 = bool2;
        if (localRect.top < i) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public boolean f()
  {
    Object localObject = this.f;
    if (!(localObject instanceof QCircleBaseMultiViewBlock)) {
      return true;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((((QCircleBaseMultiViewBlock)localObject).getInteractor() instanceof QCircleInteractor))
    {
      bool1 = bool2;
      if (((QCircleInteractor)((QCircleBaseMultiViewBlock)this.f).getInteractor()).d() == this.e) {
        bool1 = true;
      }
    }
    int i = hashCode();
    if ((bool1 != this.g) || (i != this.h))
    {
      localObject = QCircleFeedScrollManager.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append(":isCurrentPage :");
      localStringBuilder.append(bool1);
      QLog.d((String)localObject, 4, localStringBuilder.toString());
      this.g = bool1;
      this.h = i;
    }
    return bool1;
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedBaseScroller
 * JD-Core Version:    0.7.0.1
 */