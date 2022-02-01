import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.relationx.friendclue.FriendClueManager.1;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class bbcx
  implements Handler.Callback, Manager
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private anri jdField_a_of_type_Anri;
  private bbcs jdField_a_of_type_Bbcs;
  private ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new bbcy(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BusinessCard jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
  private boolean jdField_a_of_type_Boolean;
  
  public bbcx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void c(String paramString)
  {
    if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      if (this.jdField_a_of_type_Anri == null) {
        this.jdField_a_of_type_Anri = ((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
      }
      aqjm localaqjm = (aqjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
      if (localaqjm != null) {
        this.jdField_a_of_type_Boolean = localaqjm.a(1);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(paramString, 1);
      long l = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Anri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, 1, 0L, (byte)1, 0L, 0L, null, "", l, 10004, null, (byte)0);
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramString.what = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, 10000L);
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidOsHandler.post(new FriendClueManager.1(this));
    } while (!QLog.isColorLevel());
    QLog.d("FriendClueManager", 2, String.format("network is not available, uin: %s", new Object[] { paramString }));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueManager", 2, String.format("jumpToRemarkEdit, uin: %s", new Object[] { paramString }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = new BusinessCard();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    c(paramString);
  }
  
  public void b(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (this.jdField_a_of_type_Bbcs == null) {
      this.jdField_a_of_type_Bbcs = new bbcs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBaseApplication);
    }
    this.jdField_a_of_type_Bbcs.a(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131693325, 1).a();
      return true;
    }
    Card localCard = null;
    if ((paramMessage.obj instanceof Card)) {
      localCard = (Card)paramMessage.obj;
    }
    if (localCard != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = localCard.getCardInfo();
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;
      paramMessage = new Intent(this.jdField_a_of_type_AndroidContentContext, BusinessCardEditActivity.class);
      paramMessage.addFlags(268435456);
      paramMessage.putExtra("mode_type", 2);
      paramMessage.putExtra("source_activity", 1);
      paramMessage.putExtra("cur_card_body", this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard);
      paramMessage.putExtra("is_edit_mode", true);
      paramMessage.putExtra("finish_immedia", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramMessage);
      return true;
    }
    QLog.e("FriendClueManager", 1, "card get failed ");
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    if (this.jdField_a_of_type_Bbcs != null) {
      this.jdField_a_of_type_Bbcs.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcx
 * JD-Core Version:    0.7.0.1
 */