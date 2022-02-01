package com.tencent.mobileqq.activity.shopping;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ShoppingFragment$6
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetFeedListRsp>
{
  ShoppingFragment$6(ShoppingFragment paramShoppingFragment, RelativeFeedsAdapter paramRelativeFeedsAdapter) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d(ShoppingFragment.a, 2, "loadMore:" + paramBoolean + " " + paramLong + " " + paramString);
    }
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFeedListRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        QQToast.a(ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment), 1, paramString, 0).a();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter.a().b(paramStGetFeedListRsp.livePageInfo.get());
    paramBaseRequest = paramStGetFeedListRsp.hotLive.get();
    paramString = this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter;
    COMM.StCommonExt localStCommonExt = paramStGetFeedListRsp.extInfo;
    if (paramStGetFeedListRsp.isFinish.get() == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramString.b(paramBaseRequest, localStCommonExt, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shopping.ShoppingFragment.6
 * JD-Core Version:    0.7.0.1
 */