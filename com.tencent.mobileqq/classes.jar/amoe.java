import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

class amoe
  extends CardObserver
{
  amoe(amod paramamod) {}
  
  public void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb onCardDownload ");
    }
    if ((paramObject instanceof Card))
    {
      paramObject = (Card)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("BabyQIPCModule", 2, "babyqWeb onCardDownload set card info uin = " + paramObject.uin);
      }
      if (AppConstants.BABY_Q_UIN.equals(paramObject.uin))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqDataCard = paramObject;
        this.a.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqDataCard = this.a.jdField_a_of_type_ComTencentMobileqqDataCard;
        this.a.jdField_a_of_type_Aymg.jdField_a_of_type_ArrayOfJavaLangString[0] = this.a.jdField_a_of_type_ComTencentMobileqqDataCard.strNick;
        this.a.jdField_a_of_type_Aymg.jdField_a_of_type_ArrayOfJavaLangString[4] = this.a.jdField_a_of_type_ComTencentMobileqqDataCard.strReMark;
      }
    }
    if (amod.a(this.a).get("getZanVoteCount") != null)
    {
      paramObject = (Bundle)amod.a(this.a).get("getZanVoteCount");
      int i = paramObject.getInt("key_process_callback_id");
      paramObject = paramObject.getString("key_js_callback_id");
      Bundle localBundle = new Bundle();
      localBundle.putString("key_method_action", "getZanVoteCount");
      localBundle.putLong("key_get_zan_vote_count", this.a.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount);
      localBundle.putString("web_js_call_back_id", paramObject);
      this.a.callbackResult(i, EIPCResult.createSuccessResult(localBundle));
      amod.a(this.a).remove("getZanVoteCount");
    }
  }
  
  public void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqDataCard.babyQSwitch = paramBoolean2;
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb onGetBabyQSwitch babyQSwitch = " + paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amoe
 * JD-Core Version:    0.7.0.1
 */