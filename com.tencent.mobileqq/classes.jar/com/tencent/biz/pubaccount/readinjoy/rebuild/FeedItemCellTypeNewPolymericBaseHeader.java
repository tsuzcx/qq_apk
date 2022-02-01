package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import cooperation.readinjoy.ReadInJoyHelper;

public abstract class FeedItemCellTypeNewPolymericBaseHeader
  extends FeedItemCell
{
  private void a(LinearLayout paramLinearLayout, IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel.e() == 56)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setDividerWidth(AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 6.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 6.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setClipToPadding(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setClipChildren(false);
      paramLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setDividerWidth(AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (RIJFeedsType.m(paramIReadInJoyModel.a())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
      } else {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      }
    }
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof ReadInJoyNewFeedsActivity)) {}
    for (;;)
    {
      return;
      if (ReadInJoyHelper.m()) {
        try
        {
          ReadinjoyTabFrame localReadinjoyTabFrame = (ReadinjoyTabFrame)FrameHelperActivity.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext).a(ReadinjoyTabFrame.class);
          if (localReadinjoyTabFrame != null)
          {
            localReadinjoyTabFrame.a(paramView);
            return;
          }
        }
        catch (Exception paramView)
        {
          QLog.d("FeedItemCellTypeNewPolymericBaseHeader", 2, "readinjoy tab add dispatch touch event view fail ! e : " + paramView);
          paramView.printStackTrace();
        }
      }
    }
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return v().u().n().l();
  }
  
  protected abstract void a(LinearLayout paramLinearLayout);
  
  public FeedItemCell d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    a(localLinearLayout);
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView != null))
    {
      ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a();
      a(localLinearLayout, (IReadInJoyModel)this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace);
    }
    a(localLinearLayout);
    b(a());
    return this;
  }
  
  public FeedItemCell e()
  {
    return this;
  }
  
  public FeedItemCell o()
  {
    super.o();
    w();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.a(this.jdField_a_of_type_JavaLangObject);
    }
    try
    {
      e();
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("FeedItemCellTypeNewPolymericBaseHeader", 1, localException, new Object[0]);
    }
    return this;
  }
  
  public FeedItemCell p()
  {
    super.p();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
    }
    return this;
  }
  
  protected abstract FeedItemCell v();
  
  protected abstract FeedItemCell w();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeNewPolymericBaseHeader
 * JD-Core Version:    0.7.0.1
 */