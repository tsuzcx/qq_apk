package com.tencent.mobileqq.activity.shopping;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ShoppingFragment$5
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetFeedListRsp>
{
  ShoppingFragment$5(ShoppingFragment paramShoppingFragment, RelativeFeedsAdapter paramRelativeFeedsAdapter) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = ShoppingFragment.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshAliveList:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    boolean bool2 = VSNetworkHelper.isProtocolCache(paramString);
    boolean bool1 = false;
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedListRsp != null))
    {
      ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment).a(false);
      this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter.a().b(paramStGetFeedListRsp.livePageInfo.get());
      paramBaseRequest = paramStGetFeedListRsp.hotLive.get();
      if ((paramBaseRequest != null) && (paramBaseRequest.size() > 0))
      {
        paramString = this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter;
        localObject = paramStGetFeedListRsp.extInfo;
        if (paramStGetFeedListRsp.isFinish.get() == 1) {
          bool1 = true;
        }
        paramString.a(paramBaseRequest, (COMM.StCommonExt)localObject, bool1);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter.a();
        ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment).a(true);
      }
      this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter.d(paramBoolean);
      return;
    }
    if (!TextUtils.isEmpty(paramString)) {
      QQToast.a(ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment), 1, paramString, 0).a();
    }
    if (!bool2) {
      BaseRequest.reMoveCache(paramBaseRequest);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter.getItemCount() == 0) {
      ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment).a(true);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter.d(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shopping.ShoppingFragment.5
 * JD-Core Version:    0.7.0.1
 */