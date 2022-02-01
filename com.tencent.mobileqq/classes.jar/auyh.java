import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.table.LebaBannerLogic.1;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class auyh
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  public FrameLayout a;
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  
  public auyh(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    QLog.i("Q.lebatab.LebaBannerLogic", 1, String.format("jump jumpUrl:%s ,jumpType:%s ,appId:%s ", new Object[] { paramString1, paramString2, paramString3 }));
    try
    {
      if ("url".equals(paramString2))
      {
        paramQQAppInterface = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramQQAppInterface.putExtra("url", paramString1);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramQQAppInterface);
        return;
      }
      paramQQAppInterface = bfwg.a(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString1);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.a();
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.i("Q.lebatab.LebaBannerLogic", 1, "jump exception ", paramQQAppInterface);
      return;
    }
    QLog.i("Q.lebatab.LebaBannerLogic", 1, "jumpAction jAction == null");
  }
  
  private void a(String paramString1, String paramString2, String paramString3, List<String> paramList, int paramInt)
  {
    int i = 0;
    if ((paramList != null) && (paramList.size() > 0)) {}
    for (paramList = (String)paramList.get(0);; paramList = null)
    {
      if ("url".equals(paramString2))
      {
        i = 1;
        if (paramInt != 1) {
          break label113;
        }
        paramString2 = auxt.a("banner_exp");
        paramString2.jdField_b_of_type_Int = i;
        paramString2.a = paramString3;
        paramString2.jdField_b_of_type_JavaLangString = paramList;
        paramString2.e = paramString1;
        bcdg.a(null, paramString2);
      }
      label113:
      while (paramInt != 2)
      {
        return;
        if ("scheme".equals(paramString2))
        {
          i = 2;
          break;
        }
        if (!"miniapp".equals(paramString2)) {
          break;
        }
        i = 3;
        break;
      }
      paramString2 = auxt.a("banner_clk");
      paramString2.jdField_b_of_type_Int = i;
      paramString2.a = paramString3;
      paramString2.jdField_b_of_type_JavaLangString = paramList;
      paramString2.e = paramString1;
      bcdg.a(null, paramString2);
      return;
    }
  }
  
  private void a(AppRuntime paramAppRuntime, BusinessInfoCheckUpdate.AppInfo paramAppInfo, View paramView)
  {
    ((LebaRoundLayout)paramView.findViewById(2131364025)).a = ViewUtils.dip2px(16.0F);
    Object localObject = (LinearLayout)paramView.findViewById(2131370209);
    if (ThemeUtil.isNowThemeIsNight(paramAppRuntime, false, null))
    {
      ((LinearLayout)localObject).setBackgroundResource(2130840511);
      if ((((LinearLayout)localObject).getTag() == null) || (!(((LinearLayout)localObject).getTag() instanceof RedTouch))) {
        break label240;
      }
      paramView = (RedTouch)((LinearLayout)localObject).getTag();
    }
    for (;;)
    {
      if (paramAppInfo.red_display_info == null) {
        break label294;
      }
      localObject = paramAppInfo.red_display_info.red_type_info.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject).next();
        if ((localRedTypeInfo.red_type.get() == 5) || (localRedTypeInfo.red_type.get() == 4)) {
          try
          {
            JSONObject localJSONObject = new JSONObject(localRedTypeInfo.red_desc.get());
            localJSONObject.put("cr", String.format("#%06X", new Object[] { Integer.valueOf(0xFFFFFF & this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167019)) }));
            localRedTypeInfo.red_desc.set(localJSONObject.toString());
          }
          catch (Exception localException)
          {
            QLog.i("Q.lebatab.LebaBannerLogic", 1, "parse json exception", localException);
          }
        }
      }
      ((LinearLayout)localObject).setBackgroundResource(2130839437);
      break;
      label240:
      paramView = paramView.findViewById(2131370127);
      paramView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramView).c(ViewUtils.dpToPx(5.0F)).b(ViewUtils.dpToPx(1.0F)).a(19).a();
      ((LinearLayout)localObject).setTag(paramView);
    }
    label294:
    paramView.a(paramAppInfo);
    if ((!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramAppInfo.uiAppId.get()))) && (paramAppInfo.iNewFlag.get() != 0))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramAppInfo.uiAppId.get()));
      ((azvi)paramAppRuntime.getManager(36)).a(paramAppInfo.uiAppId.get(), 30);
      paramAppRuntime = paramAppInfo.buffer.get();
      paramAppInfo = paramAppInfo.missions.get();
      QLog.i("Q.lebatab.LebaBannerLogic", 1, String.format("reportExposure buffer = %s missions = %s", new Object[] { paramAppRuntime, paramAppInfo }));
    }
    try
    {
      paramAppRuntime = new JSONObject(paramAppRuntime);
      a(paramAppRuntime.optString("_jump_url"), paramAppRuntime.optString("_jump_type"), paramAppRuntime.optString("_app_id"), paramAppInfo, 1);
      if (AppSetting.c) {
        bfpm.a(paramView, paramView.a(), Button.class.getName());
      }
      return;
    }
    catch (Exception paramAppRuntime)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaBannerLogic", 1, "parse json exception", paramAppRuntime);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void c()
  {
    ThreadManager.getUIHandler().post(new LebaBannerLogic.1(this));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      QLog.i("Q.lebatab.LebaBannerLogic", 1, "onClick mRootLayout == null");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = System.currentTimeMillis();
      a();
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        azvi localazvi = (azvi)localAppRuntime.getManager(36);
        if (localazvi != null)
        {
          Object localObject1 = localazvi.a(0, "100000");
          if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() != 0) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).exposure_max.get() >= 0))
          {
            String str1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();
            localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.get();
            QLog.i("Q.lebatab.LebaBannerLogic", 1, String.format("onClick buffer = %s missions = %s time = %d", new Object[] { str1, localObject1, Long.valueOf(System.currentTimeMillis() - l) }));
            try
            {
              Object localObject2 = new JSONObject(str1);
              str1 = ((JSONObject)localObject2).optString("_jump_url");
              String str2 = ((JSONObject)localObject2).optString("_jump_type");
              localObject2 = ((JSONObject)localObject2).optString("_app_id");
              a((QQAppInterface)localAppRuntime, str1, str2, (String)localObject2);
              a(str1, str2, (String)localObject2, (List)localObject1, 2);
              localazvi.a(100000, 31);
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.i("Q.lebatab.LebaBannerLogic", 1, "parse json exception ", localException);
              }
            }
          }
          else
          {
            QLog.i("Q.lebatab.LebaBannerLogic", 1, "onClick appInfo no new");
          }
        }
        else
        {
          QLog.i("Q.lebatab.LebaBannerLogic", 1, "onClick redTouchManager == null");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyh
 * JD-Core Version:    0.7.0.1
 */