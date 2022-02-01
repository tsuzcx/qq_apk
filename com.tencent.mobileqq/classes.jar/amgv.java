import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class amgv
  implements aaav<CertifiedAccountRead.StGetFeedListRsp>
{
  public amgv(ShoppingFragment paramShoppingFragment, aagu paramaagu) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedListRsp paramStGetFeedListRsp)
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
    this.jdField_a_of_type_Aagu.getLoadInfo().d(paramStGetFeedListRsp.livePageInfo.get());
    paramString = paramStGetFeedListRsp.hotLive.get();
    aagu localaagu = this.jdField_a_of_type_Aagu;
    COMM.StCommonExt localStCommonExt = paramStGetFeedListRsp.extInfo;
    if (paramStGetFeedListRsp.isFinish.get() == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localaagu.b(paramString, localStCommonExt, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amgv
 * JD-Core Version:    0.7.0.1
 */