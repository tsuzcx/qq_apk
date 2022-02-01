import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import com.tencent.mobileqq.relationx.friendclue.FriendClueCommonGroupHelper.1;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bbcs
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private auzb jdField_a_of_type_Auzb;
  auzh jdField_a_of_type_Auzh = new bbct(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private String jdField_a_of_type_JavaLangString;
  
  public bbcs(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendClueCommonGroupHelper", 2, "get intimateInfo finished");
      }
      localIntent = new Intent();
      localIntent.addFlags(268435456);
      localIntent.putParcelableArrayListExtra("common_troop_list", (ArrayList)this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList);
      localIntent.putExtra("report_friend_type", 1);
      PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, CommonTroopListActivity.class);
    }
    while (this.jdField_a_of_type_JavaLangString == null)
    {
      Intent localIntent;
      return;
    }
    TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_JavaLangString);
    TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_AndroidContentContext, 2);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) {
        break label92;
      }
      if (this.jdField_a_of_type_Auzb == null) {
        this.jdField_a_of_type_Auzb = ((auzb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Auzh);
      this.jdField_a_of_type_Auzb.a(paramString, false);
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramString.what = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, 10000L);
    }
    label92:
    do
    {
      return;
      this.jdField_a_of_type_AndroidOsHandler.post(new FriendClueCommonGroupHelper.1(this));
    } while (!QLog.isColorLevel());
    QLog.d("FriendClueCommonGroupHelper", 1, String.format("requestIntimateInfo network is not available, uin: %s", new Object[] { paramString }));
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Auzh);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Auzh);
    paramMessage = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693325);
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, paramMessage, 1).a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcs
 * JD-Core Version:    0.7.0.1
 */