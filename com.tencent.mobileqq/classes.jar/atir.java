import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.troop.data.VideoUploadTask;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.BindGroupFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class atir
  extends WebViewPlugin
{
  int jdField_a_of_type_Int;
  ameq jdField_a_of_type_Ameq = new ativ(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  VideoUploadTask jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask;
  String jdField_a_of_type_JavaLangString;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  yqz jdField_a_of_type_Yqz = null;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  yqz jdField_b_of_type_Yqz;
  String c;
  String d;
  String e;
  String f;
  String g;
  
  public atir()
  {
    this.mPluginNameSpace = "troopApi";
  }
  
  private Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.mRuntime.a() != null) {
      QQToast.a(this.mRuntime.a(), paramInt2, this.mRuntime.a().getString(paramInt1), 0).b(this.mRuntime.a().getResources().getDimensionPixelSize(2131298914));
    }
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_Yqz.a(paramTroopInfo.troopuin, this.jdField_b_of_type_Int, this.e);
  }
  
  private void b(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      Intent localIntent = AddFriendLogicActivity.a(a(), paramTroopInfo.troopuin, paramTroopInfo.getTroopName(), paramTroopInfo.cGroupOption, this.jdField_b_of_type_Int, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.c, this.d);
      this.jdField_a_of_type_Int = paramTroopInfo.cGroupOption;
      startActivityForResult(localIntent, (byte)3);
      return;
    }
    this.jdField_a_of_type_Int = -1;
    a(2131721057);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_Yqz = yqz.a();
      this.jdField_a_of_type_Yqz.a();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"troopApi".equals(paramString2)) {
      return false;
    }
    if ("createReward".equals(paramString3)) {}
    label416:
    int i;
    do
    {
      for (;;)
      {
        return true;
        if (!"openRewardDetail".equals(paramString3)) {
          if ("previewRewardVideo".equals(paramString3))
          {
            try
            {
              paramString2 = new JSONObject(paramVarArgs[0]);
              if (QLog.isColorLevel()) {
                QLog.d("TroopApiPlugin", 2, "previewRewardVideo:" + paramString2);
              }
              paramJsBridgeListener = paramString2.optString("troopUin");
              paramString1 = paramString2.optString("rewardId");
              long l1 = paramString2.optLong("videoSize");
              long l2 = paramString2.optLong("videoDuration");
              paramString2 = paramString2.optString("callback");
              this.jdField_a_of_type_Yqz.b(paramJsBridgeListener, paramString1, new atis(this, l1, l2, paramString2));
            }
            catch (Exception paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("TroopApiPlugin", 2, "previewRewardVideo exp", paramJsBridgeListener);
            }
          }
          else if ("setRedPoint".equals(paramString3))
          {
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "setRedPoint:" + paramString1);
              }
              paramJsBridgeListener = paramString1.optString("troopUin");
              paramString1 = paramString1.optString("memberUin");
              if (!bbtx.a().a(paramJsBridgeListener, paramString1)) {
                continue;
              }
              paramString1 = this.mRuntime.a();
              paramJsBridgeListener = this.mRuntime.a();
              if ((paramString1 == null) || (!(paramString1 instanceof AbsBaseWebViewActivity))) {
                break label416;
              }
              paramJsBridgeListener = (AbsBaseWebViewActivity)paramString1;
              paramJsBridgeListener.rightViewImg.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramJsBridgeListener);
              paramString1 = (RelativeLayout)paramJsBridgeListener.findViewById(2131375991);
              if (paramString1 == null) {
                continue;
              }
              paramString2 = new RelativeLayout.LayoutParams(-2, -2);
              paramString2.addRule(7, 2131368655);
              paramString2.setMargins(0, aepi.a(5.0F, paramJsBridgeListener.getResources()), aepi.a(5.0F, paramJsBridgeListener.getResources()), 0);
              this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramString2);
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849802);
              paramString1.addView(this.jdField_a_of_type_AndroidWidgetImageView);
            }
            catch (Exception paramJsBridgeListener) {}
            if (QLog.isColorLevel())
            {
              QLog.w("TroopRankConfig", 2, "setRedPoint exp", paramJsBridgeListener);
              continue;
              if (paramJsBridgeListener != null)
              {
                paramJsBridgeListener.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
                this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramJsBridgeListener.getActivity());
                paramString1 = (RelativeLayout)paramJsBridgeListener.jdField_a_of_type_Bejh.d.findViewById(2131375991);
                if (paramString1 != null)
                {
                  paramString2 = new RelativeLayout.LayoutParams(-2, -2);
                  paramString2.addRule(7, 2131368655);
                  paramString2.setMargins(0, aepi.a(5.0F, paramJsBridgeListener.getResources()), aepi.a(5.0F, paramJsBridgeListener.getResources()), 0);
                  this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramString2);
                  this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
                  this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849802);
                  paramString1.addView(this.jdField_a_of_type_AndroidWidgetImageView);
                }
              }
            }
          }
          else if ("openEditUniqTitle".equals(paramString3))
          {
            try
            {
              paramString2 = new JSONObject(paramVarArgs[0]);
              this.jdField_b_of_type_JavaLangString = paramString2.getString("callback");
              if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "openEditUniqTitle:" + paramString2);
              }
              paramJsBridgeListener = paramString2.optString("troopUin");
              paramString1 = paramString2.optString("memberUin");
              i = paramString2.optInt("memberRole");
              paramString2 = paramString2.optString("uniqueTitle");
              startActivityForResult(EditUniqueTitleActivity.a(this.mRuntime.a(), 1, paramJsBridgeListener, paramString1, i, paramString2), (byte)4);
            }
            catch (Exception paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("TroopRankConfig", 2, "openEditUniqTitle exp", paramJsBridgeListener);
            }
          }
          else if ("saveTroopMemberTitle".equals(paramString3))
          {
            try
            {
              this.jdField_b_of_type_Yqz = yqz.a();
              this.jdField_b_of_type_Yqz.a();
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "saveTroopMemberTitle:" + paramJsBridgeListener);
              }
              paramString1 = paramJsBridgeListener.optString("troopUin");
              paramString2 = paramJsBridgeListener.optString("memberUin");
              i = paramJsBridgeListener.optInt("titleId");
              this.jdField_b_of_type_Yqz.a(paramString1, paramString2, i);
            }
            catch (Exception paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("TroopRankConfig", 2, "saveTroopMemberTitle exp:", paramJsBridgeListener);
            }
          }
          else if ("clickMineButton".equals(paramString3))
          {
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "clickMineButton:" + paramString1);
              }
              paramJsBridgeListener = paramString1.optString("troopUin");
              paramString1 = paramString1.optString("memberUin");
              if (!bbtx.a().a(paramJsBridgeListener, paramString1)) {
                continue;
              }
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              bbtx.a().a(paramJsBridgeListener, paramString1, false);
            }
            catch (Exception paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("TroopRankConfig", 2, "clickMineButton exp", paramJsBridgeListener);
            }
          }
          else if ("addTroop".equals(paramString3))
          {
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              if (QLog.isColorLevel()) {
                QLog.d("TroopApiPlugin", 2, "AddTroop:" + paramString1);
              }
              paramJsBridgeListener = paramString1.optString("troopUin");
              this.jdField_b_of_type_Int = Integer.parseInt(paramString1.optString("sourceid"));
              this.c = paramString1.optString("sourcename");
              this.d = paramString1.optString("authSig");
              this.e = paramString1.optString("authKey");
              this.jdField_a_of_type_JavaLangString = paramString1.optString("callback");
              paramString1 = this.mRuntime.a().getEntityManagerFactory(this.mRuntime.a().getAccount()).createEntityManager();
              paramString2 = (TroopInfo)paramString1.a(TroopInfo.class, paramJsBridgeListener);
              paramString1.a();
              if (paramString2 != null) {
                a(2131690091);
              }
            }
            catch (JSONException paramJsBridgeListener)
            {
              if (QLog.isColorLevel()) {
                QLog.w("TroopApiPlugin", 2, "AddTroop JSONException:" + paramJsBridgeListener);
              }
              callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":-1,\"message\":\"request fail\"}" });
              continue;
              this.jdField_a_of_type_Yqz.a(paramJsBridgeListener, 8390785);
            }
            catch (Exception paramJsBridgeListener)
            {
              if (QLog.isColorLevel()) {
                QLog.w("TroopApiPlugin", 2, "AddTroop Exception:" + paramJsBridgeListener);
              }
              callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":-10,\"message\":\"request fail\"}" });
            }
          }
          else if ("huanjiStatus".equals(paramString3))
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              paramString1 = paramJsBridgeListener.optString("pluginPackageName");
              paramString2 = paramJsBridgeListener.optString("pluginID");
              paramString3 = paramJsBridgeListener.optString("versionCode");
              this.f = paramJsBridgeListener.optString("callback");
              this.jdField_a_of_type_Yqz.a(paramString1, paramString2, paramString3, new atit(this));
            }
            catch (JSONException paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("TroopApiPlugin", 2, "HuanjiStatus JSONException:" + paramJsBridgeListener);
            }
          }
          else if ("huanjiDownload".equals(paramString3))
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              paramString1 = paramJsBridgeListener.optString("via");
              paramString2 = paramJsBridgeListener.optString("startParam");
              paramString3 = paramJsBridgeListener.optString("pluginId");
              i = paramJsBridgeListener.optInt("action");
              this.g = paramJsBridgeListener.optString("callback");
              this.jdField_a_of_type_Yqz.a(i, paramString1, paramString3, paramString2, new atiu(this));
            }
            catch (JSONException paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("TroopApiPlugin", 2, "huanjiDownload JSONException:" + paramJsBridgeListener);
            }
          }
          else if ("thirdAppCreateGroupCallback".equals(paramString3))
          {
            paramJsBridgeListener = paramVarArgs[0];
            try
            {
              QLog.i("TroopAbility.Jsapi", 1, "create troop callback content: " + paramJsBridgeListener);
              paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
              i = paramJsBridgeListener.optInt("retCode");
              paramJsBridgeListener.optString("error");
              paramJsBridgeListener = paramJsBridgeListener.optString("troopUin");
              if (i != 0) {
                continue;
              }
              paramString1 = (BaseActivity)this.mRuntime.a();
              if (paramString1 == null) {
                return false;
              }
              paramString2 = new Intent();
              paramString2.addFlags(603979776);
              paramString2.putExtra("action", 2);
              paramString2.putExtra("troop_uin", paramJsBridgeListener);
              adpn.a(paramString1, paramString2, PublicFragmentActivity.class, BindGroupFragment.class);
              paramString1.overridePendingTransition(0, 0);
            }
            catch (Exception paramJsBridgeListener)
            {
              if (QLog.isColorLevel()) {
                paramJsBridgeListener.printStackTrace();
              }
              return false;
            }
          }
          else
          {
            if (!"openTroopProfile".equals(paramString3)) {
              break;
            }
            if (paramVarArgs != null)
            {
              try
              {
                if (paramVarArgs.length <= 0) {
                  continue;
                }
                if (QLog.isColorLevel()) {
                  QLog.w("TroopApiPlugin", 2, "open troop profile " + paramVarArgs[0]);
                }
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                paramString1 = TroopInfoActivity.a(paramJsBridgeListener.optString("troopUin"), paramJsBridgeListener.optInt("from"));
                paramString1.putString("authSig", paramJsBridgeListener.optString("authSig"));
                bcpx.a(this.mRuntime.a(), paramString1, 2);
              }
              catch (JSONException paramJsBridgeListener) {}
              if (QLog.isColorLevel()) {
                QLog.w("TroopApiPlugin", 2, "open troop profile Exception:" + paramJsBridgeListener);
              }
            }
          }
        }
      }
    } while (!"setGroupMarkSwitch".equals(paramString3));
    for (;;)
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        i = paramJsBridgeListener.getInt("isOn");
        paramJsBridgeListener = paramJsBridgeListener.getString("groupCode");
        if (QLog.isColorLevel()) {
          QLog.d("TroopHonor.jsapi", 2, String.format("troop honor aio switch, troopUin: %s, switch: %s", new Object[] { paramJsBridgeListener, Integer.valueOf(i) }));
        }
        if (TextUtils.isEmpty(paramJsBridgeListener)) {
          break;
        }
        paramString1 = this.jdField_a_of_type_Yqz;
        if (i != 1) {
          break label1917;
        }
        bool = true;
        paramString1.c(paramJsBridgeListener, bool);
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        QLog.d(this.TAG, 1, "JASPI setGroupMarkSwitch", paramJsBridgeListener);
      }
      break;
      label1917:
      boolean bool = false;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 4)
    {
      if (paramInt != -1) {
        break label94;
      }
      if (paramIntent != null) {
        break label75;
      }
      paramIntent = "";
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("code", 0);
        localJSONObject.put("uniqueTitle", paramIntent);
        callJs(this.jdField_b_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
        label75:
        paramIntent = paramIntent.getStringExtra("newUniqueTitle");
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          paramIntent.printStackTrace();
        }
      }
    }
    label94:
    callJs(this.jdField_b_of_type_JavaLangString, new String[] { "{\"code\":-1}" });
  }
  
  public void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localAppInterface == null) || (localActivity == null)) {}
    do
    {
      return;
      a();
    } while (this.jdField_a_of_type_Yqz == null);
    this.jdField_a_of_type_Yqz.a(this.jdField_a_of_type_Ameq);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_Yqz.b(this.jdField_a_of_type_Ameq);
      this.jdField_a_of_type_Yqz.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.a();
    }
    if (this.jdField_b_of_type_Yqz != null) {
      this.jdField_b_of_type_Yqz.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atir
 * JD-Core Version:    0.7.0.1
 */