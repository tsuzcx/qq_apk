import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.subscribe.network.GetSubscribeFeedListRequest;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.activity.shopping.ShoppingHeadView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class amgu
  implements aaav<CertifiedAccountRead.StGetFeedListRsp>
{
  public amgu(ShoppingFragment paramShoppingFragment, GetSubscribeFeedListRequest paramGetSubscribeFeedListRequest, aagu paramaagu) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d(ShoppingFragment.a, 2, "refreshAliveList:" + paramBoolean + " " + paramLong + " " + paramString);
    }
    boolean bool2 = VSNetworkHelper.a(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFeedListRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        QQToast.a(ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment), 1, paramString, 0).a();
      }
      if (!bool2) {
        VSBaseRequest.reMoveCache(this.jdField_a_of_type_ComTencentBizSubscribeNetworkGetSubscribeFeedListRequest);
      }
      if (this.jdField_a_of_type_Aagu.getItemCount() == 0) {
        ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment).a(true);
      }
      this.jdField_a_of_type_Aagu.notifyLoadingComplete(paramBoolean);
      return;
    }
    ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment).a(false);
    this.jdField_a_of_type_Aagu.getLoadInfo().d(paramStGetFeedListRsp.livePageInfo.get());
    paramString = paramStGetFeedListRsp.hotLive.get();
    if ((paramString != null) && (paramString.size() > 0))
    {
      aagu localaagu = this.jdField_a_of_type_Aagu;
      COMM.StCommonExt localStCommonExt = paramStGetFeedListRsp.extInfo;
      if (paramStGetFeedListRsp.isFinish.get() == 1) {
        localaagu.a(paramString, localStCommonExt, bool1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aagu.notifyLoadingComplete(paramBoolean);
      return;
      bool1 = false;
      break;
      this.jdField_a_of_type_Aagu.clearData();
      ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment).a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amgu
 * JD-Core Version:    0.7.0.1
 */