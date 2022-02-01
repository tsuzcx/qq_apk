package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import cooperation.readinjoy.ReadInJoyHelper;

public class FeedItemCellTypePolymeric
  extends FeedItemCell
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = FeedItemCellTypePolymeric.class.getSimpleName();
  }
  
  public FeedItemCellTypePolymeric(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setDividerWidth(AIOUtils.a(1.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 6.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 9) || (paramInt == 10) || (paramInt == 11);
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
          QLog.d(jdField_a_of_type_JavaLangString, 2, "readinjoy tab add dispatch touch event view fail ! e : " + paramView);
          paramView.printStackTrace();
        }
      }
    }
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel)) && (((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).e() == 56))
    {
      if (((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).b() == 53) {
        return b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).u().n();
      }
      return b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).u().n().l().m();
    }
    return b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).u().n().l();
  }
  
  public FeedItemCell d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric);
    }
    Object localObject;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView != null))
    {
      localObject = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a();
      if ((((ArticleInfo)localObject).mPolymericInfo == null) || (!a(((ArticleInfo)localObject).mPolymericInfo.a))) {
        break label193;
      }
      a(localLinearLayout, (IReadInJoyModel)this.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
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
      label193:
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
      ((LinearLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setDividerWidth(AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public FeedItemCell e()
  {
    return this;
  }
  
  public FeedItemCell o()
  {
    super.o();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.a(this.jdField_a_of_type_JavaLangObject);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypePolymeric
 * JD-Core Version:    0.7.0.1
 */