import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qphone.base.util.QLog;

public class apvo
  extends apnt
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private aptm jdField_a_of_type_Aptm;
  private bepp jdField_a_of_type_Bepp;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public apvo(AIOEmotionFragment paramAIOEmotionFragment) {}
  
  public void a(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, aptm paramaptm, SessionInfo paramSessionInfo, bepp parambepp)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aptm = paramaptm;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Bepp = parambepp;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 2, "onJsonComplete:" + paramEmoticonPackage.epId + " ,currEpid:" + this.jdField_a_of_type_Aptm.a.epId);
    }
    if (this.jdField_a_of_type_Int == 32) {
      if ((paramInt == 0) && (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.jdField_a_of_type_Aptm.a.epId))) {
        AIOEmotionFragment.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment, bool);
      }
    }
    do
    {
      return;
      bool = false;
      break;
      if (paramInt != 0) {
        break label233;
      }
    } while (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.jdField_a_of_type_Aptm.a.epId));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
    afqr.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, this.jdField_a_of_type_Aptm, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Bepp, true);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a.obtainMessage(1000);
    paramBundle.obj = paramEmoticonPackage.name;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a.sendMessage(paramBundle);
    return;
    label233:
    afqr.a(this.jdField_a_of_type_Int + 1000, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, this.jdField_a_of_type_Aptm, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Bepp, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvo
 * JD-Core Version:    0.7.0.1
 */