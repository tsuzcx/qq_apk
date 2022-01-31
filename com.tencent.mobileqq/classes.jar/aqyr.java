import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.ui.MusicPanelView;
import com.tencent.qphone.base.util.QLog;

public class aqyr
  extends aqyg
{
  public aqyr(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  public static aqyr a(BaseChatPie paramBaseChatPie)
  {
    return (aqyr)paramBaseChatPie.a(33);
  }
  
  public MusicPanelView a()
  {
    return new MusicPanelView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aejb)) {
      ((aejb)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bD();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel_Troop", 2, "onShowTroopType hasAnythingDiglog2Show:" + paramBoolean);
    }
  }
  
  public boolean a()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(52)).c(this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString);
    boolean bool = false;
    if (localTroopInfo != null) {
      bool = localTroopInfo.isAdmin();
    }
    return bool;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin().equalsIgnoreCase(this.jdField_a_of_type_Aqyo.c)) {
      return true;
    }
    return a();
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if (this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString = "";
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c();
    this.jdField_a_of_type_Aqyn = new aqyn();
    this.jdField_a_of_type_Aqyn.jdField_a_of_type_JavaLangString = "Grp_AIO";
    int i = aqvv.a(str, this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Aqyn.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_Aqyn.b = this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString;
  }
  
  public void j()
  {
    super.j();
    this.d = true;
  }
  
  protected void k()
  {
    if (!this.c) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Aqyo.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession != null) && (this.jdField_a_of_type_Aqyo.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.c) && (this.jdField_a_of_type_Aqyo.b != 3)) {
        if (this.jdField_a_of_type_Aqyo.jdField_a_of_type_Boolean) {
          try
          {
            if (aqvv.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "listen_together_allow_start_admin_guide", false, false)) {
              continue;
            }
            aqvv.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "listen_together_allow_start_admin_guide", true, false);
            bafb localbafb = babr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230);
            localbafb.setMessage("一起听歌允许群成员开启，你可以在一起听歌-设置 中关闭此权限。").setTitle("一起听歌功能更新").setPositiveButton("知道了", new aqys(this, localbafb));
            localbafb.show();
            return;
          }
          catch (Exception localException1)
          {
            aqvv.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "listen_together_allow_start_admin_guide", true, false);
            QLog.e("BaseListenTogetherPanel_Troop", 1, "showAllowMemStartGuide, admin exception:", localException1);
            return;
          }
        } else {
          try
          {
            Object localObject = aqvv.a(this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int, this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString);
            if (!aqvv.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, (String)localObject, false, false))
            {
              aqvv.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, (String)localObject, true, false);
              localObject = babr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230);
              ((bafb)localObject).setMessage("本群支持群成员开启一起听歌功能").setTitle("一起听歌功能更新").setPositiveButton("知道了", new aqyt(this, (bafb)localObject));
              ((bafb)localObject).show();
              return;
            }
          }
          catch (Exception localException2)
          {
            String str = aqvv.a(this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int, this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString);
            aqvv.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, str, true, false);
            QLog.e("BaseListenTogetherPanel_Troop", 1, "showAllowMemStartGuide mem exception:", localException2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqyr
 * JD-Core Version:    0.7.0.1
 */