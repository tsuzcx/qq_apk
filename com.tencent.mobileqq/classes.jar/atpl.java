import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.qphone.base.util.QLog;

public class atpl
  extends atpc
{
  public atpl(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  public static atpl a(BaseChatPie paramBaseChatPie)
  {
    return (atpl)paramBaseChatPie.a(33);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
      ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bI();
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
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(52)).c(this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString);
    boolean bool = false;
    if (localTroopInfo != null) {
      bool = localTroopInfo.isAdmin();
    }
    return bool;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin().equalsIgnoreCase(this.jdField_a_of_type_Atpi.c)) {
      return true;
    }
    return a();
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Atpi.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if (this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString = "";
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c();
    this.jdField_a_of_type_Atph = new atph();
    this.jdField_a_of_type_Atph.jdField_a_of_type_JavaLangString = "Grp_AIO";
    int i = atmr.a(str, this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Atph.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_Atph.b = this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString;
  }
  
  public void g()
  {
    super.g();
    this.c = true;
  }
  
  protected void h()
  {
    if (!this.b) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Atpi.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession != null) && (this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.c) && (this.jdField_a_of_type_Atpi.b != 3)) {
        if (this.jdField_a_of_type_Atpi.jdField_a_of_type_Boolean) {
          try
          {
            if (atmr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "listen_together_allow_start_admin_guide", false, false)) {
              continue;
            }
            atmr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "listen_together_allow_start_admin_guide", true, false);
            bdjz localbdjz = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230);
            localbdjz.setMessage("一起听歌允许群成员开启，你可以在一起听歌-设置 中关闭此权限。").setTitle("一起听歌功能更新").setPositiveButton("知道了", new atpm(this, localbdjz));
            localbdjz.show();
            return;
          }
          catch (Exception localException1)
          {
            atmr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "listen_together_allow_start_admin_guide", true, false);
            QLog.e("BaseListenTogetherPanel_Troop", 1, "showAllowMemStartGuide, admin exception:", localException1);
            return;
          }
        } else {
          try
          {
            Object localObject = atmr.a(this.jdField_a_of_type_Atpi.jdField_a_of_type_Int, this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString);
            if (!atmr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, (String)localObject, false, false))
            {
              atmr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, (String)localObject, true, false);
              localObject = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230);
              ((bdjz)localObject).setMessage("本群支持群成员开启一起听歌功能").setTitle("一起听歌功能更新").setPositiveButton("知道了", new atpn(this, (bdjz)localObject));
              ((bdjz)localObject).show();
              return;
            }
          }
          catch (Exception localException2)
          {
            String str = atmr.a(this.jdField_a_of_type_Atpi.jdField_a_of_type_Int, this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString);
            atmr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, str, true, false);
            QLog.e("BaseListenTogetherPanel_Troop", 1, "showAllowMemStartGuide mem exception:", localException2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atpl
 * JD-Core Version:    0.7.0.1
 */