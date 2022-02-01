import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class anhf
  extends mya
{
  anhf(anha paramanha, long paramLong1, Map paramMap, QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
  
  private void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.curType = this.jdField_a_of_type_Int;
      localSessionInfo.curFriendUin = this.jdField_b_of_type_JavaLangString;
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
      for (String str = "邀请你加入派对";; str = this.jdField_c_of_type_JavaLangString + "邀请你加入派对")
      {
        paramString = new ArkAppMessage(str, "com.tencent.avgame", null, "invite", "1.0.0.1", angu.a(String.valueOf(this.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long).longValue(), paramString), null, null);
        acvv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramString);
        return;
      }
    }
    QLog.e("AvGameRoomListObserver", 1, "requestShareUrlAndSendMsg error");
  }
  
  public void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramLong != this.jdField_a_of_type_Long)
    {
      QLog.e("AvGameRoomListObserver", 1, "requestShareUrlAndSendMsg fail: observer not match");
      return;
    }
    QLog.d("AvGameRoomListObserver", 1, "requestShareUrlAndSendMsg isSuccess: " + paramBoolean + " shareUrl: " + paramString + " mark: " + paramLong);
    mya localmya = (mya)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_Long));
    if (localmya == null)
    {
      QLog.e("AvGameRoomListObserver", 1, "requestShareUrlAndSendMsg fail: observer not exist");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(localmya);
    try
    {
      a(paramBoolean, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("AvGameRoomListObserver", 1, "handleSendMsg exception: " + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhf
 * JD-Core Version:    0.7.0.1
 */