package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView.ClickableSpanPressed;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;

public class CommonBasicComponent$UserSpan
  extends ClickableSpan
  implements ReadInJoyYAFolderTextView.ClickableSpanPressed
{
  private int jdField_a_of_type_Int = -1;
  protected long a;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  boolean jdField_a_of_type_Boolean;
  
  public CommonBasicComponent$UserSpan(long paramLong, int paramInt, CmpCtxt paramCmpCtxt)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = paramCmpCtxt;
  }
  
  private void a(long paramLong, Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null)) {
      return;
    }
    Object localObject = ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2);
    ReadInJoyUtils.a(paramContext, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("CommonBasicComponent", 2, "personal url =" + (String)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.a = (ArticleInfo)localObject;
    String str = RIJTransMergeKanDianReport.a("3", (ArticleInfo)localObject, paramLong);
    if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e())) {}
    for (paramContext = "0X800935C";; paramContext = "0X8007BA3")
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long), paramContext, paramContext, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mFeedId), "0", "" + ((ArticleInfo)localObject).mStrategyId, str, false);
      RIJFrameworkReportManager.b((ArticleInfo)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidTextTextPaint != null) {
      updateDrawState(this.jdField_a_of_type_AndroidTextTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      a(this.jdField_a_of_type_Long, paramView.getContext());
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#285c95"));
    paramTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_Int;; i = -1)
    {
      paramTextPaint.bgColor = i;
      this.jdField_a_of_type_AndroidTextTextPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CommonBasicComponent.UserSpan
 * JD-Core Version:    0.7.0.1
 */