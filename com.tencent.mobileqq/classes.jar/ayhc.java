import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluspanel.appinfo.PlusPanelAppInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class ayhc
  extends aygw
{
  boolean a;
  
  ayhc()
  {
    this.jdField_a_of_type_Boolean = false;
    a(new aygk());
  }
  
  private ayfo a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    ayfo localayfo = new ayfo();
    localayfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramBaseChatPie.app, paramPlusPanelAppInfo);
    localayfo.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localayfo.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localayfo.c = String.valueOf(paramPlusPanelAppInfo.getRedDotID());
    localayfo.e = paramPlusPanelAppInfo.actionType;
    localayfo.d = paramPlusPanelAppInfo.action;
    localayfo.jdField_a_of_type_JavaLangString = a(paramPlusPanelAppInfo);
    localayfo.jdField_b_of_type_JavaLangString = (localayfo.jdField_a_of_type_JavaLangString + amtj.a(2131707412));
    return localayfo;
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.getApp();
    if (localQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "reloadFriend app is null");
      }
    }
    do
    {
      return;
      if (paramSessionInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PlusPanel", 2, "reloadFriend() sessionInfo is null");
    return;
    b(paramBaseChatPie);
    bcef.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
  }
  
  private ayfo b(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    ayfo localayfo = new ayfo();
    localayfo.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localayfo.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localayfo.e = paramPlusPanelAppInfo.actionType;
    localayfo.d = paramPlusPanelAppInfo.action;
    localayfo.jdField_a_of_type_JavaLangString = paramPlusPanelAppInfo.getTitle();
    localayfo.jdField_b_of_type_JavaLangString = (localayfo.jdField_a_of_type_JavaLangString + amtj.a(2131707412));
    if (paramPlusPanelAppInfo.getAppID() == 209)
    {
      localayfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = agxo.a(paramBaseChatPie.app).a();
      localayfo.jdField_a_of_type_JavaLangString = apyt.a().g();
      if (paramPlusPanelAppInfo.getAppID() != 204) {
        break label182;
      }
      if (!ShortVideoUtils.isHotPicConfiginitied) {
        ShortVideoUtils.isHotPicConfiginitied = true;
      }
    }
    for (;;)
    {
      localayfo.jdField_b_of_type_JavaLangString = (paramPlusPanelAppInfo.getTitle() + amtj.a(2131707420));
      return localayfo;
      localayfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(paramPlusPanelAppInfo.defaultDrawableID());
      break;
      label182:
      if (paramPlusPanelAppInfo.getAppID() == 209) {
        localayfo.jdField_a_of_type_Boolean = agxo.a(paramBaseChatPie.app).b();
      } else {
        localayfo.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public ayfo a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return a(paramBaseChatPie, paramPlusPanelAppInfo);
    }
    return b(paramBaseChatPie, paramPlusPanelAppInfo);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a(paramBaseChatPie, paramBaseChatPie.sessionInfo);
    a(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendUin);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  abstract void b(BaseChatPie paramBaseChatPie);
  
  void c(int paramInt)
  {
    if (bbyp.b())
    {
      a(paramInt, 217);
      a(paramInt, 218);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhc
 * JD-Core Version:    0.7.0.1
 */