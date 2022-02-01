package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.RedPoint;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.BaseDynamicGridAdapter;
import java.util.List;

public abstract class RIJBaseChannelGridViewAdapter
  extends ReadInJoyDynamicGridView.BaseDynamicGridAdapter<TabChannelCoverInfo>
{
  protected final int a;
  protected final RIJBaseChannelGridViewAdapter.AdapterCallback a;
  protected boolean a;
  
  public RIJBaseChannelGridViewAdapter(Context paramContext, int paramInt1, int paramInt2, RIJBaseChannelGridViewAdapter.AdapterCallback paramAdapterCallback)
  {
    super(paramContext, paramInt1);
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJBaseChannelGridViewAdapter$AdapterCallback = paramAdapterCallback;
  }
  
  private void d(List<TabChannelCoverInfo> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJBaseChannelGridViewAdapter$AdapterCallback.a((TabChannelCoverInfo)paramList.get(i), i);
      i += 1;
    }
  }
  
  abstract List<TabChannelCoverInfo> a(List<TabChannelCoverInfo> paramList);
  
  protected void a(TabChannelCoverInfo paramTabChannelCoverInfo, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJBaseChannelGridViewAdapter$AdapterCallback.a(paramTabChannelCoverInfo);
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo.redPoint.a)) {
      paramTextView.setText(paramTabChannelCoverInfo.redPoint.a);
    }
    if (paramTabChannelCoverInfo.redPoint.b != 0) {
      paramTextView.setTextColor(paramTabChannelCoverInfo.redPoint.b);
    }
    if (paramTabChannelCoverInfo.redPoint.c != 0) {
      ((GradientDrawable)paramTextView.getBackground()).setColor(paramTabChannelCoverInfo.redPoint.c);
    }
  }
  
  public void a(List<TabChannelCoverInfo> paramList)
  {
    paramList = a(paramList);
    c(paramList);
    d(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.RIJBaseChannelGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */