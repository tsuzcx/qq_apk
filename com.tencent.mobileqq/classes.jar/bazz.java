import KQQ.ReqItem;
import KQQ.RespItem;
import KQQ.UserBitFlagReq;
import KQQ.UserBitFlagRes;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class bazz
  implements axaw
{
  private QQAppInterface a;
  
  public bazz(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSetting", 2, "getCheckUpdateItemData");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.cOperType = 1;
    localReqItem.eServiceID = 106;
    UserBitFlagReq localUserBitFlagReq = new UserBitFlagReq();
    localUserBitFlagReq.cEmotionMall = 0;
    localUserBitFlagReq.cMyWallet = ((byte)bazw.a(this.a));
    localUserBitFlagReq.cPtt2Text = 0;
    localUserBitFlagReq.cAccout2Dis = 0;
    localReqItem.vecParam = localUserBitFlagReq.toByteArray();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQSetting", 2, "handleCheckUpdateItemData");
    }
    if (paramRespItem.eServiceID == 106)
    {
      UserBitFlagRes localUserBitFlagRes = new UserBitFlagRes();
      localUserBitFlagRes.readFrom(new JceInputStream(paramRespItem.vecUpdate));
      int i = localUserBitFlagRes.cEmotionMall;
      int j = localUserBitFlagRes.cMyWallet;
      int k = localUserBitFlagRes.cAccout2Dis;
      if (QLog.isColorLevel()) {
        QLog.d("QQSetting", 2, "vEmotion=" + i + ",cMyWallet=" + j + ",cPtt2Text=" + localUserBitFlagRes.cPtt2Text + " ,cAccout2Dis=" + k);
      }
      if (this.a != null)
      {
        this.a.getApp().getApplicationContext().getSharedPreferences(this.a.getCurrentAccountUin(), 0).edit().putInt("mywallet_flag", j).putInt("select_member_contacts_flag", k).commit();
        paramRespItem = this.a;
        if (localUserBitFlagRes.cPtt2Text != 1) {
          break label211;
        }
      }
    }
    for (;;)
    {
      ayah.a(paramRespItem, bool);
      return;
      label211:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bazz
 * JD-Core Version:    0.7.0.1
 */