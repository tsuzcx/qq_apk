package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentInheritView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class ComponentContentSmall
  extends RelativeLayout
  implements ComponentInheritView
{
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  
  public ComponentContentSmall(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentSmall(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentContentSmall(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969569, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131366971));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramObject);
      b();
      paramObject = paramObject.a();
      if (paramObject != null) {}
    }
    else
    {
      return;
    }
    ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramObject.mSinglePicture, getContext());
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.b()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.c()))
    {
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = AIOUtils.a(104.0F, getResources());
      localLayoutParams.height = AIOUtils.a(79.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      return;
    }
    UtilsForComponent.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmall
 * JD-Core Version:    0.7.0.1
 */