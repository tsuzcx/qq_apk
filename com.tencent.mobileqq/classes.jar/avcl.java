import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class avcl
  extends avca
{
  public avcl(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  public static avcl a(BaseChatPie paramBaseChatPie)
  {
    return (avcl)paramBaseChatPie.getHelper(33);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) {
      ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).s();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel_Troop", 2, "onShowTroopType hasAnythingDiglog2Show:" + paramBoolean);
    }
  }
  
  public boolean a()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(52)).c(this.jdField_a_of_type_Avci.jdField_a_of_type_JavaLangString);
    boolean bool = false;
    if (localTroopInfo != null) {
      bool = localTroopInfo.isAdmin();
    }
    return bool;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin().equalsIgnoreCase(this.jdField_a_of_type_Avci.c)) {
      return true;
    }
    return a();
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Avci.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Avci.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin();
    if (this.jdField_a_of_type_Avci.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_Avci.jdField_a_of_type_JavaLangString = "";
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin();
    this.jdField_a_of_type_Avch = new avch();
    this.jdField_a_of_type_Avch.jdField_a_of_type_JavaLangString = "Grp_AIO";
    int i = auzn.a(str, this.jdField_a_of_type_Avci.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Avch.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_Avch.b = this.jdField_a_of_type_Avci.jdField_a_of_type_JavaLangString;
  }
  
  public void h()
  {
    super.h();
    this.c = true;
  }
  
  protected void i()
  {
    if (!this.b) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Avci.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Avci.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Avci.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession != null) && (this.jdField_a_of_type_Avci.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.c) && (this.jdField_a_of_type_Avci.b != 3)) {
        if (this.jdField_a_of_type_Avci.jdField_a_of_type_Boolean) {
          try
          {
            if (auzn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "listen_together_allow_start_admin_guide", false, false)) {
              continue;
            }
            auzn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "listen_together_allow_start_admin_guide", true, false);
            QQCustomDialog localQQCustomDialog = bfur.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230);
            localQQCustomDialog.setMessage("一起听歌允许群成员开启，你可以在一起听歌-设置 中关闭此权限。").setTitle("一起听歌功能更新").setPositiveButton("知道了", new avcm(this, localQQCustomDialog));
            localQQCustomDialog.show();
            return;
          }
          catch (Exception localException1)
          {
            auzn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "listen_together_allow_start_admin_guide", true, false);
            QLog.e("BaseListenTogetherPanel_Troop", 1, "showAllowMemStartGuide, admin exception:", localException1);
            return;
          }
        } else {
          try
          {
            Object localObject = auzn.a(this.jdField_a_of_type_Avci.jdField_a_of_type_Int, this.jdField_a_of_type_Avci.jdField_a_of_type_JavaLangString);
            if (!auzn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, (String)localObject, false, false))
            {
              auzn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, (String)localObject, true, false);
              localObject = bfur.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230);
              ((QQCustomDialog)localObject).setMessage("本群支持群成员开启一起听歌功能").setTitle("一起听歌功能更新").setPositiveButton("知道了", new avcn(this, (QQCustomDialog)localObject));
              ((QQCustomDialog)localObject).show();
              return;
            }
          }
          catch (Exception localException2)
          {
            String str = auzn.a(this.jdField_a_of_type_Avci.jdField_a_of_type_Int, this.jdField_a_of_type_Avci.jdField_a_of_type_JavaLangString);
            auzn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, str, true, false);
            QLog.e("BaseListenTogetherPanel_Troop", 1, "showAllowMemStartGuide mem exception:", localException2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcl
 * JD-Core Version:    0.7.0.1
 */