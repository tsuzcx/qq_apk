import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController.2;
import com.tencent.mobileqq.troop.widget.RedDotAnimateView;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class azco
  extends ayut
{
  public static long a;
  public int a;
  azgj a;
  public bepn a;
  public PanelIconLinearLayout a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
  public azco(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, aejb paramaejb)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramaejb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_AndroidWidgetImageView = paramaejb.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView = new RedDotAnimateView(paramBaseActivity.getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(aciy.a(9.0F, paramBaseActivity.getActivity().getResources()), aciy.a(9.0F, paramBaseActivity.getActivity().getResources()));
    localLayoutParams.addRule(7, 2131309583);
    localLayoutParams.addRule(6, 2131309583);
    localLayoutParams.rightMargin = aciy.a(4.0F, paramBaseActivity.getActivity().getResources());
    localLayoutParams.topMargin = aciy.a(11.0F, paramBaseActivity.getActivity().getResources());
    paramaejb.b().addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = paramaejb.a();
    if ((jdField_a_of_type_Long < 0L) && (jdField_a_of_type_Long != -9223372036854775808L))
    {
      a(paramQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + paramQQAppInterface.c(), 0).getLong("homework_troop_ent", -9223372036854775808L));
      return;
    }
    a(jdField_a_of_type_Long);
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new HomeworkTroopController.2(this, paramInt), paramLong);
  }
  
  private void a(long paramLong)
  {
    boolean bool2 = false;
    bool3 = true;
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (paramLong != -9223372036854775808L)
      {
        bool1 = bool2;
        if (paramLong >= 0L)
        {
          bool1 = bool2;
          if (l >= paramLong) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        boolean bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.e("HomeworkTroopController", 2, new Object[] { "parse troopUin error. troopUin=", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
          bool1 = bool3;
        }
      }
    }
    this.jdField_a_of_type_Boolean = bool1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = paramQQAppInterface.getPreferences().getInt("homework_troop_config_version", 0);
    if (QLog.isColorLevel()) {
      QLog.i("HomeworkTroopController", 2, "handleHomeworkTroopConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      paramConfig = amnh.a(paramConfig);
      localEditor = paramQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + paramQQAppInterface.c(), 0).edit();
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        str = (String)paramConfig.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("HomeworkTroopController", 2, new Object[] { "parse handleHomeworkTroopConfig: ", str });
        }
        for (;;)
        {
          try
          {
            paramConfig = new JSONObject(str);
            if (paramConfig.has("HWTroopAIOTip"))
            {
              localObject = paramConfig.getJSONObject("HWTroopAIOTip");
              if (((JSONObject)localObject).has("show")) {
                localEditor.putInt("homework_troop_aio_tip_show", ((JSONObject)localObject).getInt("show"));
              }
            }
            if (paramConfig.has("keywordConfigs"))
            {
              localObject = paramConfig.getJSONArray("keywordConfigs").toString();
              localEditor.putString("troop_school_keyword_config", (String)localObject);
              ((azgz)paramQQAppInterface.getManager(262)).a((String)localObject);
            }
            localObject = paramConfig.optString("grayTroopUin");
            l1 = 0L;
          }
          catch (JSONException paramConfig)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            paramConfig = str;
            if (str != null) {
              continue;
            }
            paramConfig = "";
            QLog.e("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopConfig json fail. content: ", paramConfig });
            localEditor.clear();
            continue;
          }
          try
          {
            l2 = Long.parseLong((String)localObject);
            l1 = l2;
            localEditor.putLong("homework_troop_ent", l2);
            l1 = l2;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localEditor.putLong("homework_troop_ent", -9223372036854775808L);
          }
        }
        localObject = (ayuu)paramQQAppInterface.getManager(289);
        if ((((ayuu)localObject).a instanceof azco)) {
          ((azco)((ayuu)localObject).a).a(l1);
        }
        ((azhi)paramQQAppInterface.getManager(109)).a(paramConfig);
        localEditor.apply();
        paramQQAppInterface.getPreferences().edit().putInt("homework_troop_config_version", i).apply();
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        SharedPreferences.Editor localEditor;
        String str;
        Object localObject;
        long l1;
        long l2;
        return;
        localEditor.clear();
      }
    }
    QLog.i("HomeworkTroopController", 2, "handleHomeworkTroopConfig:localVersion == version = " + i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    azzx.a(paramQQAppInterface, paramString, "homework", "AioAssign_Show", 0, 0, new String[] { paramString, "", "", azzx.a(paramQQAppInterface, paramString) });
    azzx.a(paramQQAppInterface, paramString, "Grp_notice", "CreateNotice_Show", 0, 0, new String[] { paramString, "", "", "" });
  }
  
  private boolean a()
  {
    amcz localamcz = amda.a();
    return (localamcz != null) && (localamcz.g());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bepn != null)
    {
      this.jdField_a_of_type_Bepn.dismiss();
      this.jdField_a_of_type_Bepn = null;
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void a(aejb paramaejb)
  {
    if ((paramaejb.jdField_a_of_type_Aenj != null) && (paramaejb.jdField_a_of_type_Aenj.a(paramaejb.a()))) {}
    do
    {
      return;
      if (!((aqyr)paramaejb.a(33)).c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("HomeworkTroopController", 2, "showHomeworkTroopIdentityAIOTip. isListenTogetherTime");
    return;
    if (paramaejb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + paramaejb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getInt("homework_troop_aio_tip_show", 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "showHomeworkTroopIdentityAIOTip. show = ", Boolean.valueOf(bool) });
      }
      if (!bool) {
        break;
      }
      if (paramaejb.jdField_a_of_type_Aenj == null) {
        paramaejb.jdField_a_of_type_Aenj = new aenj(paramaejb.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramaejb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramaejb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      paramaejb.jdField_a_of_type_Aenj.a(paramaejb.a(), true);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    e(paramBoolean);
  }
  
  public void a(boolean paramBoolean, aejb paramaejb)
  {
    a(paramBoolean, new azcr(this), paramaejb);
  }
  
  public void a(boolean paramBoolean1, aejb paramaejb, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, "updateTroopAioUI" + paramBoolean1);
    }
    if (paramBoolean2)
    {
      paramaejb.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(paramaejb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaejb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramaejb);
      if (paramBoolean1) {
        a(paramaejb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaejb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
    c(paramBoolean1);
    if (!paramBoolean1)
    {
      if (paramaejb.jdField_a_of_type_Aenj != null) {
        paramaejb.jdField_a_of_type_Aenj.a(paramaejb.a(), false);
      }
      e(false);
      b(false);
      return;
    }
    a(true, null, paramaejb);
    if (paramaejb.a().isResume())
    {
      b(true);
      return;
    }
    paramaejb.ad = true;
  }
  
  public void a(boolean paramBoolean, azgj paramazgj, aejb paramaejb)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramaejb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramaejb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if ((localTroopInfo != null) && (localTroopInfo.isHomeworkTroop())) {
      if (paramazgj != null) {
        azgh.a(paramaejb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaejb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramaejb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramazgj, paramBoolean);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (this.jdField_a_of_type_Azgj == null) {
        this.jdField_a_of_type_Azgj = new azcs(this, paramaejb);
      }
      azgh.a(paramaejb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaejb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramaejb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Azgj, paramBoolean);
      return;
    }
    if (localTroopInfo == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("HomeworkTroopController", 2, new Object[] { "checkHomeworkTroopIdentity skip. has troopInfo = ", Boolean.valueOf(paramBoolean) });
      return;
    }
  }
  
  public void b()
  {
    d(false);
    a();
  }
  
  public void b(aejb paramaejb)
  {
    if ((paramaejb.d != null) && (paramaejb.d.isShowing())) {
      return;
    }
    a(paramaejb);
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool;
    if ((this.jdField_a_of_type_Boolean) && (TroopInfo.isAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip start. isHomeworkTroop=", Boolean.valueOf(paramBoolean), ", canShow=", Boolean.valueOf(bool) });
      }
      if (bool) {
        break label78;
      }
    }
    label78:
    do
    {
      return;
      bool = false;
      break;
      if (!paramBoolean) {
        break label238;
      }
      paramBoolean = azgh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_homework");
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip hasHomeworkShown=", Boolean.valueOf(paramBoolean) });
      }
      if (!paramBoolean)
      {
        a(1, 500L);
        azgh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_homework", true);
        return;
      }
      paramBoolean = azgh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_notification");
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip hasNotificationShown=", Boolean.valueOf(paramBoolean) });
      }
    } while (paramBoolean);
    a(2, 500L);
    azgh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_notification", true);
    return;
    label238:
    a();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bepn != null) && (this.jdField_a_of_type_Bepn.isShowing()) && (this.jdField_a_of_type_Int > 0)) {
      a(this.jdField_a_of_type_Int, 0L);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListIcon start. isHomeworkTroop=", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean))
    {
      if (!a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new azcp(this));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843081);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      azzx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework", "AioSee_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", azzx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) });
      localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (localWebProcessManager != null) {}
    }
    while (a())
    {
      do
      {
        WebProcessManager localWebProcessManager;
        do
        {
          return;
        } while (!localWebProcessManager.d());
        localWebProcessManager.e();
      } while (!QLog.isColorLevel());
      QLog.d("HomeworkTroopController", 2, "start preloadWebProcess");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, " hide troop class hw rightbtn");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void d(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, "showHomeworkListRedDot,show = " + paramBoolean + ",context = " + localBaseActivity + ",mRightRedDot = " + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView);
    }
    if (localBaseActivity == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView == null) {
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.getVisibility() != 0) {
        azzx.a("Grp_edu", "homework", "AioSee_Reddot_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibleAndZeroRadius();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibility(8);
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListRedPoint start. show=", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean))
    {
      int i = azgh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListRedPoint check cache. troopUin=", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ", result=", Integer.valueOf(i) });
      }
      if (i != 0)
      {
        d(true);
        return;
      }
    }
    d(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azco
 * JD-Core Version:    0.7.0.1
 */