import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
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

public class bcgs
  extends bbyd
{
  public static long a;
  public int a;
  bckv a;
  public bidc a;
  public PanelIconLinearLayout a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
  public bcgs(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_AndroidWidgetImageView = paramTroopChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView = new RedDotAnimateView(paramBaseActivity.getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(aepi.a(9.0F, paramBaseActivity.getActivity().getResources()), aepi.a(9.0F, paramBaseActivity.getActivity().getResources()));
    localLayoutParams.addRule(7, 2131375871);
    localLayoutParams.addRule(6, 2131375871);
    localLayoutParams.rightMargin = aepi.a(4.0F, paramBaseActivity.getActivity().getResources());
    localLayoutParams.topMargin = aepi.a(11.0F, paramBaseActivity.getActivity().getResources());
    paramTroopChatPie.b().addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = paramTroopChatPie.a();
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
      paramConfig = aozj.a(paramConfig);
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
              ((bcll)paramQQAppInterface.getManager(262)).a((String)localObject);
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
        localObject = (bbye)paramQQAppInterface.getManager(289);
        if ((((bbye)localObject).a instanceof bcgs)) {
          ((bcgs)((bbye)localObject).a).a(l1);
        }
        ((bclu)paramQQAppInterface.getManager(109)).a(paramConfig);
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
    bdes.a(paramQQAppInterface, paramString, "homework", "AioAssign_Show", 0, 0, new String[] { paramString, "", "", bdes.a(paramQQAppInterface, paramString) });
    bdes.a(paramQQAppInterface, paramString, "Grp_notice", "CreateNotice_Show", 0, 0, new String[] { paramString, "", "", "" });
  }
  
  private boolean a()
  {
    aool localaool = aoom.a();
    return (localaool != null) && (localaool.g());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bidc != null)
    {
      this.jdField_a_of_type_Bidc.dismiss();
      this.jdField_a_of_type_Bidc = null;
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    if ((paramTroopChatPie.jdField_a_of_type_Agzw != null) && (paramTroopChatPie.jdField_a_of_type_Agzw.a(paramTroopChatPie.a()))) {}
    do
    {
      return;
      if (!((atpl)paramTroopChatPie.a(33)).c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("HomeworkTroopController", 2, "showHomeworkTroopIdentityAIOTip. isListenTogetherTime");
    return;
    if (paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getInt("homework_troop_aio_tip_show", 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "showHomeworkTroopIdentityAIOTip. show = ", Boolean.valueOf(bool) });
      }
      if (!bool) {
        break;
      }
      if (paramTroopChatPie.jdField_a_of_type_Agzw == null) {
        paramTroopChatPie.jdField_a_of_type_Agzw = new agzw(paramTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      paramTroopChatPie.jdField_a_of_type_Agzw.a(paramTroopChatPie.a(), true);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    e(paramBoolean);
  }
  
  public void a(boolean paramBoolean, bckv parambckv, TroopChatPie paramTroopChatPie)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if ((localTroopInfo != null) && (localTroopInfo.isHomeworkTroop())) {
      if (parambckv != null) {
        bckt.a(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), parambckv, paramBoolean);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (this.jdField_a_of_type_Bckv == null) {
        this.jdField_a_of_type_Bckv = new bcgw(this, paramTroopChatPie);
      }
      bckt.a(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Bckv, paramBoolean);
      return;
    }
    if (localTroopInfo == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("HomeworkTroopController", 2, new Object[] { "checkHomeworkTroopIdentity skip. has troopInfo = ", Boolean.valueOf(paramBoolean) });
      return;
    }
  }
  
  public void a(boolean paramBoolean, TroopChatPie paramTroopChatPie)
  {
    a(paramBoolean, new bcgv(this), paramTroopChatPie);
  }
  
  public void a(boolean paramBoolean1, TroopChatPie paramTroopChatPie, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, "updateTroopAioUI" + paramBoolean1);
    }
    if (paramBoolean2)
    {
      paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramTroopChatPie);
      if (paramBoolean1) {
        a(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
    c(paramBoolean1);
    if (!paramBoolean1)
    {
      if (paramTroopChatPie.jdField_a_of_type_Agzw != null) {
        paramTroopChatPie.jdField_a_of_type_Agzw.a(paramTroopChatPie.a(), false);
      }
      e(false);
      b(false);
      return;
    }
    a(true, null, paramTroopChatPie);
    if (paramTroopChatPie.a().isResume())
    {
      b(true);
      return;
    }
    paramTroopChatPie.ad = true;
  }
  
  public void b()
  {
    d(false);
    a();
  }
  
  public void b(TroopChatPie paramTroopChatPie)
  {
    if ((paramTroopChatPie.d != null) && (paramTroopChatPie.d.isShowing())) {
      return;
    }
    a(paramTroopChatPie);
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
      paramBoolean = bckt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_homework");
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip hasHomeworkShown=", Boolean.valueOf(paramBoolean) });
      }
      if (!paramBoolean)
      {
        a(1, 500L);
        bckt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_homework", true);
        return;
      }
      paramBoolean = bckt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_notification");
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip hasNotificationShown=", Boolean.valueOf(paramBoolean) });
      }
    } while (paramBoolean);
    a(2, 500L);
    bckt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_notification", true);
    return;
    label238:
    a();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bidc != null) && (this.jdField_a_of_type_Bidc.isShowing()) && (this.jdField_a_of_type_Int > 0)) {
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
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bcgt(this));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843362);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      bdes.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework", "AioSee_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", bdes.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) });
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
        bdes.a("Grp_edu", "homework", "AioSee_Reddot_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
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
      int i = bckt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgs
 * JD-Core Version:    0.7.0.1
 */