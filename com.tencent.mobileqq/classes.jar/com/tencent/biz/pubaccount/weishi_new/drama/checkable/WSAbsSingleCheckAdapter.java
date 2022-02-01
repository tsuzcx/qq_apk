package com.tencent.biz.pubaccount.weishi_new.drama.checkable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSCenterLayoutManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;

public abstract class WSAbsSingleCheckAdapter<M extends Checkable, VH extends BaseViewHolder<M>>
  extends BaseAdapter<M, VH>
  implements OnCheckedListener<M>
{
  protected int a = 0;
  private final RecyclerView b;
  private OnCheckedListener<M> c;
  private WSCenterLayoutManager d;
  
  public WSAbsSingleCheckAdapter(Context paramContext, RecyclerView paramRecyclerView)
  {
    super(paramContext);
    this.b = paramRecyclerView;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean);
    RecyclerView.ViewHolder localViewHolder = this.b.findViewHolderForAdapterPosition(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("position:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", viewHolder:");
    localStringBuilder.append(localViewHolder);
    WSLog.a("WSAbsSingleCheckAdapter-nel-log", localStringBuilder.toString());
    if (localViewHolder == null)
    {
      notifyItemChanged(paramInt);
      return;
    }
    if ((localViewHolder instanceof WSAbsCheckableHolder)) {
      ((WSAbsCheckableHolder)localViewHolder).a(paramBoolean);
    }
  }
  
  public WSCenterLayoutManager a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    int i = this.a;
    if (i == paramInt) {
      return;
    }
    b(i, false);
    this.a = paramInt;
    b(paramInt, true);
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    ((Checkable)getDataList().get(paramInt)).a(paramBoolean);
  }
  
  public void a(M paramM, int paramInt)
  {
    OnCheckedListener localOnCheckedListener = this.c;
    if (localOnCheckedListener != null) {
      localOnCheckedListener.a(paramM, paramInt);
    }
  }
  
  public void a(OnCheckedListener<M> paramOnCheckedListener)
  {
    this.c = paramOnCheckedListener;
  }
  
  public void a(WSCenterLayoutManager paramWSCenterLayoutManager)
  {
    this.d = paramWSCenterLayoutManager;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public void b(M paramM, int paramInt)
  {
    if (paramM.a())
    {
      a(paramM, paramInt);
      return;
    }
    a(paramInt);
    OnCheckedListener localOnCheckedListener = this.c;
    if (localOnCheckedListener != null) {
      localOnCheckedListener.b(paramM, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsSingleCheckAdapter
 * JD-Core Version:    0.7.0.1
 */