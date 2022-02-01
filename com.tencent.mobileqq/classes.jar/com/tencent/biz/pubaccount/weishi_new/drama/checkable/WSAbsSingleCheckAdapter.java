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
  protected int a;
  private final RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private OnCheckedListener<M> jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCheckableOnCheckedListener;
  private WSCenterLayoutManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSCenterLayoutManager;
  
  public WSAbsSingleCheckAdapter(Context paramContext, RecyclerView paramRecyclerView)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean);
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(paramInt);
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
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public WSCenterLayoutManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSCenterLayoutManager;
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    if (i == paramInt) {
      return;
    }
    b(i, false);
    this.jdField_a_of_type_Int = paramInt;
    b(paramInt, true);
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    ((Checkable)getDataList().get(paramInt)).a(paramBoolean);
  }
  
  public void a(M paramM, int paramInt)
  {
    OnCheckedListener localOnCheckedListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCheckableOnCheckedListener;
    if (localOnCheckedListener != null) {
      localOnCheckedListener.a(paramM, paramInt);
    }
  }
  
  public void a(OnCheckedListener<M> paramOnCheckedListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCheckableOnCheckedListener = paramOnCheckedListener;
  }
  
  public void a(WSCenterLayoutManager paramWSCenterLayoutManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaEpisodeWSCenterLayoutManager = paramWSCenterLayoutManager;
  }
  
  public void b(M paramM, int paramInt)
  {
    if (paramM.a())
    {
      a(paramM, paramInt);
      return;
    }
    a(paramInt);
    OnCheckedListener localOnCheckedListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCheckableOnCheckedListener;
    if (localOnCheckedListener != null) {
      localOnCheckedListener.b(paramM, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsSingleCheckAdapter
 * JD-Core Version:    0.7.0.1
 */