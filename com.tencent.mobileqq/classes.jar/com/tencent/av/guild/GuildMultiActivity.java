package com.tencent.av.guild;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.AppUtils;
import com.tencent.av.utils.AvAddFriendHelper;
import com.tencent.av.utils.AvAddFriendHelper.IAvAddFriendCallBack;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.ShareUtils;
import com.tencent.av.utils.SparkDot;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.av.widget.ShareActionSheetBuilder;
import com.tencent.av.widget.stageview.MemberEffect;
import com.tencent.av.widget.stageview.StageEffectView;
import com.tencent.av.widget.stageview.StageEffectView.OnIconClickListener;
import com.tencent.av.widget.stageview.StageEffectView.StageMember;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jjj;
import jjk;
import jjl;
import jjm;
import jjn;
import jjo;
import jjp;
import jjq;
import jju;
import jjv;
import jjw;
import jjx;
import jjy;
import mqq.app.BaseActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GuildMultiActivity
  extends BaseActivity
  implements AdapterView.OnItemClickListener, AvAddFriendHelper.IAvAddFriendCallBack, StageEffectView.OnIconClickListener
{
  public static String a;
  long jdField_a_of_type_Long = 0L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new jjm(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new UITools.MyViewAlphaOnTouchListener();
  Button jdField_a_of_type_AndroidWidgetButton = null;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton = null;
  public TextView a;
  public VideoController a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new jju(this);
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new jjq(this);
  public GameHeroesUi a;
  private SmallScreenActivityPlugin jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
  public AvAddFriendHelper a;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  SensorHelper jdField_a_of_type_ComTencentAvUtilsSensorHelper = null;
  public SparkDot a;
  public TipsManager a;
  TraeHelper jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
  public StageEffectView a;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public Runnable a;
  public HashMap a;
  boolean jdField_a_of_type_Boolean = false;
  Button jdField_b_of_type_AndroidWidgetButton = null;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  public Runnable b;
  public String b;
  public boolean b;
  Button jdField_c_of_type_AndroidWidgetButton = null;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  Runnable jdField_c_of_type_JavaLangRunnable = new jjp(this);
  public String c;
  public boolean c;
  public Runnable d;
  public String d;
  public boolean d;
  public String e = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GuildMultiActivity";
  }
  
  public GuildMultiActivity()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_a_of_type_ComTencentAvUtilsSparkDot = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentAvGuildGameHeroesUi = null;
    this.jdField_b_of_type_JavaLangRunnable = new jjj(this);
    this.jdField_d_of_type_JavaLangRunnable = new jjl(this);
  }
  
  private void a(String paramString1, String paramString2, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView.a(paramString1)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addMemInStageView uin:" + paramString1 + ",nickname:" + paramString2 + ", faceBitmap: " + paramBitmap);
    }
    label68:
    int j;
    int i;
    if (paramBitmap == null)
    {
      paramBitmap = null;
      paramString2 = new StageEffectView.StageMember(paramString1, paramString2, paramBitmap);
      if ((SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_ArrayOfJavaLangString != null) && (SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_ArrayOfJavaLangString != null) && (SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_ArrayOfInt != null))
      {
        j = SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_ArrayOfJavaLangString.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        if (TextUtils.equals(paramString1, SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_ArrayOfJavaLangString[i])) {
          paramString2.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect = new MemberEffect(SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_ArrayOfJavaLangString[i], SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_ArrayOfInt[i]);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView.a(paramString2, paramBoolean);
        if ((this.jdField_c_of_type_JavaLangString.equals(paramString1)) || (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper == null)) {
          break;
        }
        a(paramString1, this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(paramString1));
        return;
        paramBitmap = new BitmapDrawable(paramBitmap);
        break label68;
      }
      i += 1;
    }
  }
  
  private boolean a(String paramString)
  {
    return this.jdField_c_of_type_JavaLangString.equals(paramString);
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = false;
    String str1 = String.valueOf(SessionMgr.a().a(this.e).jdField_f_of_type_Long);
    int i;
    Object localObject1;
    if (this.jdField_d_of_type_Boolean)
    {
      i = 7;
      if (this.jdField_c_of_type_JavaLangString == null) {
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString) != null)
      {
        if (!SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.f) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 1300L);
        }
        localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, str1, i, true, true);
        localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, str1, i);
        if (!this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView.a(this.jdField_c_of_type_JavaLangString)) {
          break label190;
        }
        this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView.a(this.jdField_c_of_type_JavaLangString, (String)localObject2, true);
      }
    }
    for (;;)
    {
      if (SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.f) {
        break label209;
      }
      return;
      i = 9;
      break;
      label190:
      if (localObject1 != null) {
        a(this.jdField_c_of_type_JavaLangString, (String)localObject2, (Bitmap)localObject1, paramBoolean);
      }
    }
    label209:
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (VideoController.GAudioFriends)((Iterator)localObject2).next();
      String str2 = String.valueOf(((VideoController.GAudioFriends)localObject3).jdField_a_of_type_Long);
      if (!str2.equals(this.jdField_c_of_type_JavaLangString))
      {
        localObject1 = (jjy)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(((VideoController.GAudioFriends)localObject3).jdField_a_of_type_Long));
        label328:
        String str3;
        if (localObject1 == null)
        {
          localObject1 = new jjy(this);
          ((jjy)localObject1).jdField_a_of_type_Long = ((VideoController.GAudioFriends)localObject3).jdField_a_of_type_Long;
          ((jjy)localObject1).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((VideoController.GAudioFriends)localObject3).jdField_a_of_type_Long), localObject1);
          localObject3 = this.jdField_a_of_type_ComTencentAvVideoController.a(str2, String.valueOf(SessionMgr.a().a(this.e).jdField_f_of_type_Long), i, false, true);
          str3 = this.jdField_a_of_type_ComTencentAvVideoController.a(str2, str1, i);
          if (str3.equals(str2))
          {
            this.jdField_c_of_type_Boolean = true;
            ((jjy)localObject1).jdField_a_of_type_Boolean = false;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateMemInStage uin : " + str2 + ", name is not ready");
            }
          }
          if (localObject3 == null) {
            break label695;
          }
          if (this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView.a(str2)) {
            break label614;
          }
          a(str2, str3, (Bitmap)localObject3, paramBoolean);
        }
        label794:
        for (;;)
        {
          if ((!str3.equals(str2)) && (localObject3 != null)) {
            ((jjy)localObject1).jdField_a_of_type_Boolean = true;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateMemInStage peerUin : " + str2 + ", refreshCount = " + ((jjy)localObject1).jdField_a_of_type_Int + ", hasGetInfo = " + ((jjy)localObject1).jdField_a_of_type_Boolean);
          break;
          if ((((jjy)localObject1).jdField_a_of_type_Int > 5) || (((jjy)localObject1).jdField_a_of_type_Boolean))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateMemInStage this uin (" + str2 + ") has got infos or there's too much refresh!");
            break;
          }
          ((jjy)localObject1).jdField_a_of_type_Int += 1;
          break label328;
          label614:
          this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView.a(str2, new BitmapDrawable((Bitmap)localObject3), false);
          this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView.a(str2, str3, true);
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateMemInStage setNameText name : " + str3 + ", peerUin : " + str2);
            continue;
            label695:
            this.jdField_c_of_type_Boolean = true;
            ((jjy)localObject1).jdField_a_of_type_Boolean = false;
            if (!this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView.a(str2)) {
              a(str2, str3, ImageUtil.a(), paramBoolean);
            }
            for (;;)
            {
              if (!QLog.isColorLevel()) {
                break label794;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateMemInStage uin : " + str2 + ", face is not ready");
              break;
              this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView.a(str2, new BitmapDrawable(ImageUtil.a()), false);
            }
          }
        }
      }
    }
    f();
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "quitActivity");
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      SessionMgr.a().a().e();
      SessionMgr.a().a().d();
    }
    if (this.jdField_d_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.gameparty.refresh");
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      localIntent.putExtra("teamId", this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
    finish();
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131366026: 
    case 2131366017: 
      do
      {
        return;
        if (SessionMgr.a().a(this.e).N) {
          ReportController.b(null, "CliOper", "", "", "0X80057EE", "0X80057EE", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
          return;
          ReportController.b(null, "CliOper", "", "", "0X80057EF", "0X80057EF", 0, 0, "", "", "", "");
        }
        ReportController.b(null, "CliOper", "", "", "0X80057E9", "0X80057E9", 0, 0, "", "", "", "");
        finish();
        int j = 2131034240;
        int i = j;
        if (this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
          i = j;
          if (paramView != null) {
            i = SmallScreenUtils.a(paramView.jdField_J_of_type_Int);
          }
        }
        overridePendingTransition(0, i);
      } while (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin == null);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a();
      return;
    case 2131366018: 
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet = new ShareActionSheetBuilder(this).a(this);
      }
      break;
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      label329:
      ReportController.b(null, "CliOper", "", "", "0X8005F12", "0X8005F12", 0, 0, "", "", "", "");
      return;
      ReportController.b(null, "CliOper", "", "", "0X80057F2", "0X80057F2", 0, 0, "", "", "", "");
      d();
      return;
      paramView = SessionMgr.a().a(this.e);
      if (!SessionMgr.a().a(this.e).jdField_c_of_type_Boolean) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.jdField_c_of_type_Boolean = bool;
        if (!SessionMgr.a().a(this.e).jdField_c_of_type_Boolean) {
          break;
        }
        ReportController.b(null, "CliOper", "", "", "0X80057F0", "0X80057F0", 0, 0, "", "", "", "");
        this.jdField_b_of_type_AndroidWidgetButton.setSelected(true);
        UITools.a(this.jdField_b_of_type_AndroidWidgetButton, getResources().getString(2131428896));
        this.jdField_a_of_type_ComTencentAvVideoController.a("qav_random_multi_mute_1", SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long, false);
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80057F1", "0X80057F1", 0, 0, "", "", "", "");
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
      UITools.a(this.jdField_b_of_type_AndroidWidgetButton, getResources().getString(2131428895));
      this.jdField_a_of_type_ComTencentAvVideoController.a("qav_random_multi_mute_2", SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long, true);
      return;
      paramView = SessionMgr.a().a(this.e);
      if (paramView != null)
      {
        if (paramView.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_JavaLangString != null) {
          break label735;
        }
        if (paramView.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.f != null)
        {
          Intent localIntent = new Intent(this, QQBrowserActivity.class);
          localIntent.putExtra("url", paramView.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.f);
          startActivity(localIntent);
        }
      }
      for (;;)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005F1B", "0X8005F1B", 0, 0, "", "", "", "");
        return;
        label735:
        if (PackageUtil.a(this, paramView.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_d_of_type_JavaLangString))
        {
          AppUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, paramView.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_JavaLangString, paramView.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.e, paramView.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_d_of_type_JavaLangString, paramView.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_c_of_type_JavaLangString);
          a(paramView, 3);
        }
        else
        {
          paramView = PopupDialog.b(this, 230, null, getString(2131429388), 2131429389, 2131429390, new jjx(this), new jjk(this));
          if (paramView != null) {
            paramView.show();
          }
        }
      }
      h();
      return;
      this.jdField_a_of_type_ComTencentAvGuildGameHeroesUi.b();
      this.jdField_d_of_type_JavaLangString = null;
      return;
    }
    catch (Exception paramView)
    {
      break label329;
    }
  }
  
  public long a(String paramString)
  {
    VideoController.GAudioFriends localGAudioFriends = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString);
    long l = 0L;
    if (localGAudioFriends != null) {
      l = localGAudioFriends.b;
    }
    l = (SystemClock.elapsedRealtime() - l) / 1000L;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getChatingTime with uin :" + paramString + " second: " + l);
    }
    return l;
  }
  
  void a()
  {
    QAVNotification localQAVNotification;
    int i;
    String str;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (!SessionMgr.a().a()))
    {
      localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (this.jdField_a_of_type_ComTencentAvVideoController.h() > 0) {
        break label100;
      }
      if (!this.jdField_d_of_type_Boolean) {
        break label94;
      }
      i = 58;
      str = this.e;
      if (!this.jdField_d_of_type_Boolean) {
        break label119;
      }
    }
    label94:
    label100:
    label119:
    for (int j = 2131429595;; j = 2131429594)
    {
      localQAVNotification.a(str, getString(j), null, null, i, 1011, 3);
      this.jdField_a_of_type_ComTencentAvVideoController.w();
      return;
      i = 53;
      break;
      if (this.jdField_d_of_type_Boolean) {}
      for (i = 59;; i = 54) {
        break;
      }
    }
  }
  
  public void a(long paramLong)
  {
    String str = String.valueOf(paramLong);
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "removeMemInStageView uin:" + paramLong);
    }
    this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView.a(new String[] { String.valueOf(str) });
    if (str.equals(this.jdField_d_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentAvGuildGameHeroesUi.a()) {
        this.jdField_a_of_type_ComTencentAvGuildGameHeroesUi.b();
      }
      this.jdField_d_of_type_JavaLangString = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.b(str);
    }
    f();
  }
  
  public void a(SessionInfo paramSessionInfo, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("https://vp.qq.com/cgi-bin/report?r=reportData/doReport&tbName=dc00472&sq_ver=");
    localStringBuffer.append("7.6.0");
    localStringBuffer.append("&net_type=");
    localStringBuffer.append(com.tencent.mobileqq.app.AppConstants.c[com.tencent.mobileqq.utils.NetworkUtil.a(this)]);
    localStringBuffer.append("&resolution=");
    localStringBuffer.append(DeviceInfoUtil.m().replace("X", "*"));
    localStringBuffer.append("&uin=");
    localStringBuffer.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    localStringBuffer.append("&platid=1&web_id=");
    localStringBuffer.append(paramSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.g);
    localStringBuffer.append("&op_id=");
    localStringBuffer.append(paramSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.h);
    localStringBuffer.append("&game_appid=");
    localStringBuffer.append(paramSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_JavaLangString);
    localStringBuffer.append("&op_type=");
    localStringBuffer.append(paramInt);
    paramSessionInfo = localStringBuffer.toString();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[guild-start] report url: " + paramSessionInfo);
    }
    paramSessionInfo = RandomWebProtocol.a(paramSessionInfo, "", null);
    if (QLog.isColorLevel())
    {
      if (TextUtils.isEmpty(paramSessionInfo)) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[guild-start] report fail");
      }
    }
    else {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "[guild-start] report ret: " + paramSessionInfo);
  }
  
  public void a(StageEffectView paramStageEffectView, View paramView, StageEffectView.StageMember paramStageMember)
  {
    String str = paramStageMember.jdField_a_of_type_JavaLangString;
    paramView = SessionMgr.a().a(this.e);
    long l;
    if (paramView != null)
    {
      l = paramView.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long;
      paramView = paramView.a(str);
    }
    for (;;)
    {
      if (!this.jdField_c_of_type_JavaLangString.equalsIgnoreCase(str))
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(str) != 0) {
          break label138;
        }
        ReportController.b(null, "CliOper", "", "", "0X8005F18", "0X8005F18", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        this.jdField_d_of_type_JavaLangString = str;
        if (!this.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvGuildGameHeroesUi.a(paramStageMember, l, paramView, this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(str), a(str), paramStageEffectView.a());
        }
        return;
        label138:
        if (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(str) == 2) {
          ReportController.b(null, "CliOper", "", "", "0X8005F19", "0X8005F19", 0, 0, "", "", "", "");
        }
      }
      paramView = null;
      l = -1L;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onAddFriendEvent uin :" + paramString);
    }
    a(paramString, this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(paramString));
    if (paramString.equals(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentAvGuildGameHeroesUi.b(this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(paramString), a(paramString));
    }
  }
  
  void a(String paramString, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView.a(paramString, (Drawable)localObject1);
      return;
      localObject1 = getResources().getDrawable(2130840059);
      continue;
      localObject1 = getResources().getDrawable(2130840063);
      continue;
      localObject1 = getResources().getDrawable(2130840061);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showEnterRoomFailDialog: " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_b_of_type_Int == 0) {
      return;
    }
    Context localContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext();
    String str2 = localContext.getString(2131429035);
    if (paramBoolean) {}
    for (String str1 = localContext.getString(2131429385);; str1 = localContext.getString(2131429384))
    {
      PopupDialog.b(localContext, 230, str2, str1, 0, 2131429051, new jjv(this), null);
      return;
    }
  }
  
  void b()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "processIntentData");
    }
    SessionInfo localSessionInfo = SessionMgr.a().a(this.e);
    if (localSessionInfo == null) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      Object localObject1 = super.getIntent();
      if (!this.jdField_b_of_type_Boolean) {
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_Int = 0;
      }
      try
      {
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_Int = Integer.parseInt(((Intent)localObject1).getStringExtra("version"));
        label88:
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Int = 3;
        try
        {
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long = Long.parseLong(((Intent)localObject1).getStringExtra("group_id"));
          label116:
          this.jdField_a_of_type_Long = localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long;
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("room_title");
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_ArrayOfJavaLangString = null;
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_ArrayOfJavaLangString = null;
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_ArrayOfInt = null;
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m = ((Intent)localObject1).getStringExtra("business_type");
          if (this.jdField_d_of_type_Boolean) {}
          Object localObject2 = ChatActivityUtils.a(((Intent)localObject1).getStringExtra("role"));
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "processIntentData role = " + (String)localObject2);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            try
            {
              Object localObject3 = new JSONObject((String)localObject2);
              localObject2 = ((JSONObject)localObject3).getJSONArray("uin");
              JSONArray localJSONArray = ((JSONObject)localObject3).getJSONArray("name");
              localObject3 = ((JSONObject)localObject3).getJSONArray("color");
              int j = ((JSONArray)localObject2).length();
              localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
              localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_ArrayOfJavaLangString = new String[j];
              localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_ArrayOfInt = new int[j];
              int i = 0;
              for (;;)
              {
                if (i < j)
                {
                  String str = ((JSONArray)localObject2).getString(i);
                  byte[] arrayOfByte = Base64Util.decode(str, 0);
                  if (!TextUtils.isEmpty(str)) {
                    localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_ArrayOfJavaLangString[i] = ChatActivityUtils.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), arrayOfByte);
                  }
                  localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_ArrayOfJavaLangString[i] = localJSONArray.getString(i);
                  if (QLog.isColorLevel()) {
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "processIntentData  name[" + i + "] = " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_ArrayOfJavaLangString[i] + ", uin[" + i + "] = " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_ArrayOfJavaLangString[i]);
                  }
                  try
                  {
                    localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_ArrayOfInt[i] = Color.parseColor(((JSONArray)localObject3).getString(i));
                    if (QLog.isColorLevel()) {
                      QLog.d(jdField_a_of_type_JavaLangString, 2, "processIntentData  color[" + i + "] = " + ((JSONArray)localObject3).getString(i));
                    }
                    i += 1;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_ArrayOfInt[i] = -1;
                    }
                  }
                }
              }
              if (!QLog.isColorLevel()) {
                break label613;
              }
            }
            catch (JSONException localJSONException) {}
          } else {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "[guild_share] version: " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_Int);
          }
          label613:
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_c_of_type_Int = 0;
          if (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_Int > 1) {}
          try
          {
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_c_of_type_Int = Integer.parseInt(((Intent)localObject1).getStringExtra("open_game"));
            label653:
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("appID");
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_c_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("flag");
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_d_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("packageName");
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.e = ChatActivityUtils.a(((Intent)localObject1).getStringExtra("paramsStr"));
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.f = ChatActivityUtils.a(((Intent)localObject1).getStringExtra("url"));
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.g = ((Intent)localObject1).getStringExtra("web_id");
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.h = ((Intent)localObject1).getStringExtra("op_id");
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.i = ChatActivityUtils.a(((Intent)localObject1).getStringExtra("image_url"));
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.j = ChatActivityUtils.a(((Intent)localObject1).getStringExtra("title"));
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.k = ChatActivityUtils.a(((Intent)localObject1).getStringExtra("desc"));
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.l = ChatActivityUtils.a(((Intent)localObject1).getStringExtra("share_url"));
            if (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.i != null) {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jjn(this, localSessionInfo), 0L);
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "[guild_share] open_game:" + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_c_of_type_Int + ", share_icon_url: " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.i + ", share_title: " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.j + ", share_desc: " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.k + ", share_url: " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.l);
            }
            localObject1 = localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_JavaLangString;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
              this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
            }
            localObject1 = localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m;
            if ((localObject1 != null) && (((String)localObject1).equals("1"))) {}
            for (;;)
            {
              this.jdField_d_of_type_Boolean = bool;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "processIntentData room_title = " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_JavaLangString + ", group_id = " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long);
              return;
              bool = false;
            }
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            break label653;
          }
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          break label116;
        }
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        break label88;
      }
    }
  }
  
  void c()
  {
    long l = SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long;
    if (this.jdField_d_of_type_Boolean) {}
    for (int i = 7;; i = 9)
    {
      SessionMgr.a().a(this.e).q = String.valueOf(l);
      SessionMgr.a().a(this.e).jdField_f_of_type_Long = l;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[random room owner] relationType = " + i);
      }
      SessionMgr.a().a(this.e).F = i;
      SessionMgr.a().a(this.e).jdField_a_of_type_Boolean = false;
      SessionMgr.a().a(this.e).d = 3;
      SessionMgr.a().a(this.e).i = 1011;
      SessionMgr.a().a(this.e).Q = true;
      SessionMgr.a().a(this.e).jdField_J_of_type_Boolean = false;
      SessionMgr.a().a(this.e).jdField_f_of_type_Int = 3;
      SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int = 3;
      SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 1;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.e) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "StartOrEnterGAudio already in room");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(1, 3, null);
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
    if (!this.jdField_d_of_type_Boolean) {}
    for (int j = 11;; j = 199)
    {
      j = localVideoController.a(i, l, j, SessionMgr.a().a(this.e).jdField_a_of_type_ArrayOfLong, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startGameGuildChat, result:" + j + ", relationType:" + i + ", groupId:" + l + ", sessionType: " + 3);
      return;
    }
  }
  
  public void d()
  {
    int i;
    if (this.jdField_d_of_type_Boolean)
    {
      i = 7;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.e) {
        break label117;
      }
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 91);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(0, 0, null);
      SessionMgr.a().a().d();
      SessionMgr.a().a().e();
      if (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.b(null);
      }
      i();
      return;
      i = 9;
      break;
      label117:
      this.jdField_a_of_type_ComTencentAvVideoController.a(i, this.jdField_a_of_type_Long, 92);
    }
  }
  
  @TargetApi(11)
  protected void e()
  {
    super.setContentView(2130969299);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131366026));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131366028));
    Object localObject1 = (BitmapDrawable)getResources().getDrawable(2130840134);
    Object localObject2 = TintStateDrawable.a(getResources(), 2130840134, 2131494061);
    ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
    this.jdField_b_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject2, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366023));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366019));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366020));
    this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView = ((StageEffectView)findViewById(2131366022));
    this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView.setOnIconClickListener(this);
    this.jdField_a_of_type_ComTencentAvUtilsSparkDot = ((SparkDot)findViewById(2131366024));
    this.jdField_a_of_type_ComTencentAvUtilsSparkDot.setDotCount(6);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131366029));
    this.jdField_c_of_type_AndroidWidgetButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131366018));
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.5F);
    }
    localObject1 = String.format(getResources().getString(2131429386), new Object[] { Integer.valueOf(0) });
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_JavaLangRunnable = new jjo(this);
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null)
    {
      localObject1 = (LinearLayout)super.findViewById(2131364220);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager = new TipsManager(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (LinearLayout)localObject1);
    }
    try
    {
      if (ImageResUtil.a("random_talk_bg_2.png")) {
        findViewById(2131366016).setBackgroundDrawable(new BitmapDrawable(getResources(), ImageResUtil.b() + "random_talk_bg_2.png"));
      }
      int k = UITools.b(getApplicationContext());
      localObject1 = (RelativeLayout)findViewById(2131366021);
      localObject2 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
      int j = k / 6;
      int i = j;
      if (j < getResources().getDimensionPixelSize(2131559907)) {
        i = getResources().getDimensionPixelSize(2131559907);
      }
      j = i;
      if (i > ((RelativeLayout.LayoutParams)localObject2).topMargin) {
        j = ((RelativeLayout.LayoutParams)localObject2).topMargin;
      }
      if (QLog.isColorLevel()) {
        QLog.w("GuildMultiActivity", 2, "GuildMultiActivity adapt stage: screen(" + k + ") oldTop(" + ((RelativeLayout.LayoutParams)localObject2).topMargin + ") newTop(" + j + ").");
      }
      ((RelativeLayout.LayoutParams)localObject2).topMargin = j;
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("RandomBackground", 2, "RandomBackground multi OOM: " + localOutOfMemoryError);
        }
      }
    }
  }
  
  void f()
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.h();
    if (i > 0) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      String str = String.format(getResources().getString(2131429386), new Object[] { Integer.valueOf(i) });
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void g()
  {
    int i = 33;
    int j = SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setMatchingStatus : " + j);
    }
    SparkDot localSparkDot = (SparkDot)findViewById(2131366024);
    localSparkDot.setDotCount(6);
    switch (j)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 1: 
      localSparkDot.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(31, true);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        TipsManager localTipsManager = this.jdField_a_of_type_ComTencentAvUtilsTipsManager;
        if (this.jdField_d_of_type_Boolean) {
          i = 34;
        }
        localTipsManager.b(i, true);
      }
      localSparkDot.setVisibility(0);
      return;
    }
    localSparkDot.b();
    localSparkDot.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(31, false);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(33, false);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(34, false);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  void h()
  {
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      return;
    }
    switch (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_d_of_type_JavaLangString))
    {
    case 1: 
    default: 
      return;
    case 0: 
      ReportController.b(null, "CliOper", "", "", "0X8005F1A", "0X8005F1A", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_d_of_type_JavaLangString, 3025);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_d_of_type_JavaLangString);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 111))
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(paramIntent);
      localIntent.setAction("tencent.video.v2q.generalFuncCall");
      localIntent.putExtra("func", "SEND_STRUCT_MSG");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate");
    }
    super.onCreate(paramBundle);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mApp is null!");
      }
      this.jdField_a_of_type_Boolean = true;
      super.finish();
    }
    long l1;
    label327:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mVideoController is null!");
        }
        this.jdField_a_of_type_Boolean = true;
        super.finish();
        return;
      }
      e();
      this.jdField_a_of_type_ComTencentAvGuildGameHeroesUi = new GameHeroesUi(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, (RelativeLayout)findViewById(2131366030), (RelativeLayout)findViewById(2131366031));
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_a_of_type_AndroidWidgetButton);
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper, this, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(true);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper = new AvAddFriendHelper(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
      paramBundle = super.getIntent();
      if (TextUtils.equals(paramBundle.getStringExtra("Fromwhere"), "AVNotification")) {
        ReportController.b(null, "CliOper", "", "", "0X80057EC", "0X80057EC", 0, 0, "", "", "", "");
      }
      l1 = -1L;
      try
      {
        long l2 = Long.parseLong(paramBundle.getStringExtra("group_id"));
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Object localObject;
        boolean bool;
        int i;
        break label327;
      }
      if ((SessionMgr.a().a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Int != 3) || ((l1 != -1L) && (l1 != SessionMgr.a().a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long))) {
        break;
      }
      this.jdField_b_of_type_Boolean = true;
      this.e = SessionMgr.a().a().jdField_b_of_type_JavaLangString;
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.e))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 93);
        SessionMgr.a().a().e();
        SessionMgr.a().a().d();
      }
      SessionMgr.a().b(this.e);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      if (this.jdField_b_of_type_Boolean) {
        break label784;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b();
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
      this.jdField_a_of_type_ComTencentAvVideoController.f(false);
      b();
      c();
      if ((SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_Int > 1) && (SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_c_of_type_Int > 0) && (this.jdField_c_of_type_AndroidWidgetButton != null) && (!this.jdField_d_of_type_Boolean)) {
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      }
      if ((SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_Int > 1) && (this.jdField_a_of_type_AndroidWidgetImageButton != null) && (!this.jdField_d_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
      g();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = SmallScreenActivityPlugin.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      localObject = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      paramBundle = paramBundle.getStringExtra("is_quit");
    } while ((paramBundle == null) || (!paramBundle.equals("1")));
    d();
    return;
    localObject = paramBundle.getStringExtra("business_type");
    if ((localObject != null) && (((String)localObject).equals("1")))
    {
      bool = true;
      label721:
      this.jdField_d_of_type_Boolean = bool;
      if (!this.jdField_d_of_type_Boolean) {
        break label778;
      }
    }
    label778:
    for (i = 7;; i = 9)
    {
      this.e = SessionMgr.a(i, String.valueOf(l1), new int[0]);
      SessionMgr.a().a(this.e, false);
      this.jdField_b_of_type_Boolean = false;
      break;
      bool = false;
      break label721;
    }
    label784:
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "IsAccompanyReturn");
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    b();
    if (SessionMgr.a().a(this.e).jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(true);
      UITools.a(this.jdField_b_of_type_AndroidWidgetButton, getResources().getString(2131428896));
      this.jdField_a_of_type_ComTencentAvVideoController.a("GuildMultiActivity.onCreate.1", SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long, false);
    }
    for (;;)
    {
      b(false);
      if ((this.jdField_a_of_type_ComTencentAvVideoController.jdField_b_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(38, this.jdField_a_of_type_ComTencentAvVideoController.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentAvUtilsSparkDot.setVisibility(0);
      break;
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
      UITools.a(this.jdField_b_of_type_AndroidWidgetButton, getResources().getString(2131428895));
      this.jdField_a_of_type_ComTencentAvVideoController.a("GuildMultiActivity.onCreate.2", SessionMgr.a().a(this.e).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long, true);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentAvGuildGameHeroesUi != null)
    {
      this.jdField_a_of_type_ComTencentAvGuildGameHeroesUi.c();
      this.jdField_a_of_type_ComTencentAvGuildGameHeroesUi = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    }
    if ((this.jdField_b_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if ((this.jdField_d_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    }
    if ((this.jdField_c_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.e);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(false);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = null;
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = SessionMgr.a().a(this.e);
    if (localObject == null) {
      return;
    }
    if ((((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.l == null) || (((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.i == null))
    {
      QQToast.a(this, -1, getResources().getString(2131429392), 0).b(getResources().getDimensionPixelSize(2131558448));
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      label154:
      int i;
      if (paramInt == 2)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005F15", "0X8005F15", 0, 0, "", "", "", "");
        i = -1;
        if (WXShareHelper.a().a()) {
          break label238;
        }
        i = 2131435302;
      }
      for (;;)
      {
        if (i == -1) {
          break label255;
        }
        QQToast.a(this, 1, i, 0).b(getResources().getDimensionPixelSize(2131558448));
        break;
        ReportController.b(null, "CliOper", "", "", "0X8005F16", "0X8005F16", 0, 0, "", "", "", "");
        break label154;
        label238:
        if (!WXShareHelper.a().b()) {
          i = 2131435303;
        }
      }
      label255:
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new jjw(this);
        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      }
      this.jdField_b_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
      paramAdapterView = WXShareHelper.a();
      paramView = this.jdField_b_of_type_JavaLangString;
      String str1 = ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.j;
      Bitmap localBitmap = ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_AndroidGraphicsBitmap;
      String str2 = ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.k;
      localObject = ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.l;
      if (paramInt == 2) {}
      for (paramInt = 0;; paramInt = 1)
      {
        paramAdapterView.b(paramView, str1, localBitmap, str2, (String)localObject, paramInt);
        break;
      }
      ShareUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, 111, ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.i, ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.j, ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.k, ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.l);
      ReportController.b(null, "CliOper", "", "", "0X8005F13", "0X8005F13", 0, 0, "", "", "", "");
      continue;
      ShareUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.i, ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.j, ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.k, ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.l);
      ReportController.b(null, "CliOper", "", "", "0X8005F14", "0X8005F14", 0, 0, "", "", "", "");
      continue;
      ShareUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_JavaLangString, ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.l);
      ReportController.b(null, "CliOper", "", "", "0X8005F17", "0X8005F17", 0, 0, "", "", "", "");
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
        continue;
        ReportController.b(null, "CliOper", "", "", "0X80057EA", "0X80057EA", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a();
        }
      }
    }
  }
  
  protected void onResume()
  {
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.b();
    }
    super.onResume();
    if (PopupDialog.a()) {
      PopupDialog.a(this);
    }
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_JavaLangString) == null))
    {
      this.jdField_a_of_type_ComTencentAvGuildGameHeroesUi.b();
      this.jdField_d_of_type_JavaLangString = null;
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localQAVNotification != null) {
      localQAVNotification.a(this.e);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.x();
  }
  
  protected void onStop()
  {
    super.onStop();
    a();
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a(this.jdField_a_of_type_Boolean);
    }
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.guild.GuildMultiActivity
 * JD-Core Version:    0.7.0.1
 */