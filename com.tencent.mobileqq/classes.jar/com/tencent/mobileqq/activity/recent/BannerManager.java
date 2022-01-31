package com.tencent.mobileqq.activity.recent;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.UserInfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.UITools;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.NewUpgradeConfig;
import com.tencent.mobileqq.app.NewUpgradeConfig.Dialog;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PhoneUnityBannerData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlAndQQInterface.WorkState;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import xob;
import xoc;
import xof;
import xog;
import xoh;
import xoi;
import xoj;
import xok;
import xol;
import xom;
import xon;
import xoo;
import xop;
import xoq;
import xor;
import xos;
import xou;
import xov;
import xow;
import xoy;
import xoz;
import xpa;
import xpb;
import xpc;
import xpd;
import xpf;
import xph;
import xpi;
import xpj;
import xpk;
import xpl;
import xpm;
import xpn;
import xpo;
import xpp;
import xpq;
import xpr;
import xps;
import xpt;
import xpu;
import xpv;
import xpw;
import xpx;

public class BannerManager
  implements Handler.Callback
{
  public static final boolean a;
  public int a;
  public long a;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private volatile BannerManager.MessageToShowBanner jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private PhoneContactManager.IPhoneContactListener jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(this);
  private Banner[] jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner = new Banner[35];
  public int b;
  public long b;
  private SparseArray jdField_b_of_type_AndroidUtilSparseArray;
  private volatile BannerManager.MessageToShowBanner jdField_b_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  private String e;
  public boolean e;
  boolean f = false;
  private boolean g = true;
  private boolean h;
  private boolean i = true;
  
  static
  {
    jdField_a_of_type_Boolean = AppSetting.b;
  }
  
  public BannerManager(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
  }
  
  private View A()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130969238, null);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localView.findViewById(2131365697).setVisibility(8);
    ((LinearLayout)localView.findViewById(2131362873)).setOnClickListener(new xpf(this));
    return localView;
  }
  
  private View B()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130842432));
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131437803));
    localTipsBar.setOnClickListener(new xph(this));
    return localTipsBar;
  }
  
  private View C()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130970930, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131372197);
    localView.setOnClickListener(new xpi(this));
    localImageView.setOnClickListener(new xpj(this));
    return localView;
  }
  
  private View D()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(2);
    localTipsBar.b(true);
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  @Nullable
  public static BannerManager.MessageToShowBanner a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, BannerManager.IBannerInteract paramIBannerInteract)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      paramString1 = new BannerManager.MessageToShowBanner(1, paramString1, paramInt, paramString2, paramIBannerInteract);
      paramString2 = paramQQAppInterface.obtainMessage(1134200);
      paramString2.obj = paramString1;
      paramQQAppInterface.sendMessage(paramString2);
      return paramString1;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    int j = 23;
    if (j <= 30)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[j] == null) {}
      for (;;)
      {
        j += 1;
        break;
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[j].jdField_b_of_type_Int == 2) {
          if (j != paramInt)
          {
            b(j, paramInt);
            this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[j].jdField_b_of_type_Int = 0;
          }
          else if ((j == 30) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner != null) && (!this.jdField_b_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner.equals(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner)))
          {
            b(j, paramInt);
          }
        }
      }
    }
  }
  
  private void a(View paramView)
  {
    paramView.setVisibility(0);
    ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435958));
  }
  
  private void a(View paramView, Message paramMessage)
  {
    paramView = (TipsBar)paramView;
    paramView.setVisibility(0);
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      paramView.setTipsText(((UpgradeTIMWrapper)paramMessage.obj).f);
    }
  }
  
  private void a(View paramView, Message paramMessage, int paramInt)
  {
    if ((paramMessage == null) || (paramMessage.obj == null) || (!(paramMessage.obj instanceof PhoneUnityBannerData))) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005B72", "0X8005B72", 0, 0, "", "", "", "");
    paramView.findViewById(2131369812).setVisibility(0);
    paramMessage = (PhoneUnityBannerData)paramMessage.obj;
    ((TextView)paramView.findViewById(2131369814)).setText(paramMessage.jdField_b_of_type_JavaLangString);
    paramView.setOnClickListener(new xpn(this, paramMessage));
  }
  
  private void a(Banner paramBanner)
  {
    if ((paramBanner == null) || (paramBanner.jdField_a_of_type_AndroidViewView != null)) {
      return;
    }
    for (;;)
    {
      try
      {
        int j = paramBanner.jdField_a_of_type_Int;
        switch (j)
        {
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = k();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = a();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = m();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = j();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = h();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = g();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = i();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = l();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = o();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = n();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = n();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = x();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = p();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = A();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = z();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = C();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = q();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = r();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = s();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = t();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = v();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = u();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = w();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = y();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = B();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = d();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = e();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = f();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = c();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = b();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = D();
        continue;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("Q.recent.banner", 4, "initBannerView | banner = " + paramBanner);
      return;
      paramBanner.jdField_a_of_type_AndroidViewView = i();
    }
  }
  
  private void a(Banner paramBanner, Message paramMessage)
  {
    boolean bool = false;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateBanner| banner = ").append(paramBanner).append(", msg = ").append(paramMessage).append(" isGeneral? ");
      if (paramBanner.jdField_a_of_type_Int == 30) {
        bool = true;
      }
      QLog.d("Q.recent.banner", 4, Boolean.toString(bool));
    }
    if ((paramBanner == null) || (paramBanner.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    try
    {
      switch (paramBanner.jdField_a_of_type_Int)
      {
      case 14: 
      case 16: 
      case 1: 
        b(paramBanner.jdField_a_of_type_AndroidViewView);
        return;
      }
    }
    catch (Throwable paramBanner)
    {
      paramBanner.printStackTrace();
      return;
    }
    i(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    f(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    h(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    e(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    a(paramBanner.jdField_a_of_type_AndroidViewView);
    return;
    j(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    c(paramBanner.jdField_a_of_type_AndroidViewView);
    return;
    paramBanner.jdField_a_of_type_AndroidViewView.findViewById(2131375469).setVisibility(0);
    return;
    paramBanner.jdField_a_of_type_AndroidViewView.findViewById(2131375469).setVisibility(0);
    return;
    q(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    d(paramBanner.jdField_a_of_type_AndroidViewView);
    return;
    k(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    l(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    m(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    o(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    n(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    p(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    r(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    e(paramBanner.jdField_a_of_type_AndroidViewView);
    return;
    b(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage, paramBanner.jdField_b_of_type_Int);
    return;
    a(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage, paramBanner.jdField_b_of_type_Int);
    return;
    f(paramBanner.jdField_a_of_type_AndroidViewView);
    return;
    c(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    d(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    g(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    b(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    a(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    s(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
  }
  
  private void a(BannerManager.MessageToShowBanner paramMessageToShowBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBannerInBInternal with: " + paramMessageToShowBanner);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    localMessage.obj = paramMessageToShowBanner;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    int j = 0;
    if ((!paramIntent.hasExtra("banner_businessCategory")) || (!paramIntent.hasExtra("banner_wording"))) {
      return;
    }
    String str1 = paramIntent.getStringExtra("banner_businessCategory");
    String str2 = paramIntent.getStringExtra("banner_wording");
    String str3 = paramIntent.getStringExtra("banner_webViewUrl");
    String str4 = paramIntent.getStringExtra("banner_activityName");
    int k = paramIntent.getIntExtra("banner_activityFlag", 0);
    PendingIntent localPendingIntent = (PendingIntent)paramIntent.getParcelableExtra("banner_pendingIntent");
    Bundle localBundle = paramIntent.getBundleExtra("banner_webview_extra");
    if (!TextUtils.isEmpty(str3)) {
      j = 1;
    }
    if (j != 0)
    {
      a(paramQQAppInterface, str1, str2, str3, str4, k, localBundle);
      return;
    }
    if (localPendingIntent == null)
    {
      a(paramQQAppInterface, paramIntent, str1, str2, str4);
      return;
    }
    a(paramQQAppInterface, paramIntent, localPendingIntent, str1, str2);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, PendingIntent paramPendingIntent, String paramString1, String paramString2)
  {
    int j = paramIntent.getIntExtra("banner_iconIdx", -1);
    if ((paramPendingIntent == null) || (j < 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("Q.recent.banner", 1, "invalid intent extra from pendingIntent, " + paramString1 + " / " + paramString2 + " / " + paramPendingIntent + " / " + j);
      return;
    }
    paramIntent = new xpv(paramPendingIntent, paramQQAppInterface);
    paramIntent.a(a(paramQQAppInterface, j, paramString1, paramString2, paramIntent));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    int j = paramIntent.getIntExtra("banner_plguinType", -1);
    String str1 = paramIntent.getStringExtra("banner_pluginId");
    String str2 = paramIntent.getStringExtra("banner_pluginProxyActivityName");
    Intent localIntent = (Intent)paramIntent.getParcelableExtra("banner_pluginIntent");
    int k = paramIntent.getIntExtra("banner_iconIdx", -1);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (j < 0) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (localIntent == null) || (k < 0))
    {
      QLog.e("Q.recent.banner", 1, "invalid intent extra from plugin, " + paramString1 + " / " + paramString2 + " / " + paramString3 + " / " + j + " / " + str1 + " / " + str2 + " / " + localIntent + " / " + k);
      return;
    }
    paramIntent = new xpw(paramQQAppInterface, paramString3, str2, str1, localIntent, paramQQAppInterface.c(), j);
    paramIntent.a(a(paramQQAppInterface, k, paramString1, paramString2, paramIntent));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, Bundle paramBundle)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      QLog.e("Q.recent.banner", 1, "invalid intent extra from webview, " + paramString1 + " / " + paramString2 + " / " + paramString3);
      return;
    }
    try
    {
      String str1 = new URL(paramString3).getHost();
      paramString3 = new xpx(paramString3, paramQQAppInterface, paramString4, paramInt, paramBundle);
      paramString3.a(a(paramQQAppInterface, BannerIconCollection.a(str1), paramString1, paramString2, paramString3));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
        String str2 = "";
      }
    }
  }
  
  private boolean a(View paramView)
  {
    Config localConfig = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin(), false);
    if (localConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushBannerConfig", 2, "loadPushBanner");
      }
      j();
      return false;
    }
    int n = localConfig.a(0);
    if (n > 0)
    {
      ((ADView)paramView.findViewById(2131365698)).h();
      int j = 0;
      int m;
      for (int k = 0; j < n; k = m)
      {
        m = k;
        if (a(localConfig, j, paramView)) {
          m = k + 1;
        }
        j += 1;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "loadPushBanner, addnum = " + k);
      }
      if (k > 0)
      {
        h();
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, BannerManager.MessageToShowBanner paramMessageToShowBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBannerInB with: " + paramMessageToShowBanner);
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      Message localMessage = paramQQAppInterface.obtainMessage(1134201);
      localMessage.obj = paramMessageToShowBanner;
      paramQQAppInterface.sendMessage(localMessage);
      return true;
    }
    return false;
  }
  
  private boolean a(Config paramConfig, int paramInt, View paramView)
  {
    PushBanner localPushBanner = new PushBanner(paramConfig.a(0, paramInt), paramConfig.b(0, paramInt), paramConfig.a(0, paramInt));
    localPushBanner.l = paramConfig.a(0, paramInt);
    localPushBanner.m = paramConfig.c(0, paramInt);
    boolean bool = localPushBanner.a(paramConfig.a(0, paramInt));
    if ((localPushBanner.jdField_c_of_type_JavaLangString != null) && (localPushBanner.jdField_c_of_type_JavaLangString.contains("|")) && (!CommonUtil.a(Long.parseLong(localPushBanner.jdField_c_of_type_JavaLangString.substring(0, localPushBanner.jdField_c_of_type_JavaLangString.indexOf("|"))), Long.parseLong(localPushBanner.jdField_c_of_type_JavaLangString.substring(localPushBanner.jdField_c_of_type_JavaLangString.indexOf("|") + 1))))) {}
    label467:
    for (;;)
    {
      return false;
      if ((bool) && (!"".equals(localPushBanner.j)))
      {
        localPushBanner.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localPushBanner.j);
        if (localPushBanner.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction == null) {}
        for (int j = 0;; j = 1)
        {
          if (j == 0) {
            break label467;
          }
          Object localObject = paramConfig.a(0, paramInt);
          if (QLog.isDevelopLevel()) {
            QLog.i("PUSH BANNER", 4, "addPushBanner, bannerPic = " + localObject);
          }
          if (localObject == null) {
            break;
          }
          paramConfig = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130969239, null);
          ImageView localImageView = (ImageView)paramConfig.findViewById(2131365700);
          localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          localImageView.setImageBitmap((Bitmap)localObject);
          DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
          j = ((Bitmap)localObject).getHeight() * Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) / ((Bitmap)localObject).getWidth();
          localLayoutParams.height = Math.max((int)(30.0F * localDisplayMetrics.density), Math.min(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 68 / 320, j));
          localImageView.setLayoutParams(localLayoutParams);
          localObject = (ImageView)paramConfig.findViewById(2131365701);
          ((ImageView)localObject).setTag(localPushBanner);
          ((ImageView)localObject).setContentDescription("图片推广位");
          ((ImageView)localObject).setOnClickListener(new xpl(this));
          paramConfig.setTag(localPushBanner);
          ((ADView)paramView.findViewById(2131365698)).a(paramConfig, paramInt);
          paramView.setTag(2131365698, localPushBanner.jdField_a_of_type_JavaLangString);
          return true;
        }
      }
    }
  }
  
  private View b()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846320));
    localTipsBar.b(true);
    UpgradeTIMWrapper localUpgradeTIMWrapper = UpgradeTIMWrapper.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    localTipsBar.setTipsText(localUpgradeTIMWrapper.f);
    localTipsBar.setOnClickListener(new xpp(this, localUpgradeTIMWrapper));
    localTipsBar.setCloseListener(new xpq(this, localUpgradeTIMWrapper));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "[notifyBannerIsOverride], type is " + paramInt1 + " / " + paramInt2);
    }
    if ((paramInt1 == 30) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$IBannerInteract.c();
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 28);
      localObject = CmGameMainManager.a();
    } while (localObject == null);
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (localQQAppInterface == null) {
        break label181;
      }
      if (((CmGameMainManager)localObject).a != null) {
        break label147;
      }
    }
    label147:
    for (Object localObject = "-1";; localObject = ((CmGameMainManager)localObject).a.game.gameId + "")
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "mutex_bar", 0, 0, new String[] { localObject });
      return;
      localQQAppInterface = null;
      break;
    }
    label181:
    QLog.e("Q.recent.banner", 1, "[notifyBannerStateChange] app null");
  }
  
  private void b(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBanner: " + paramMessage);
    }
    if (!(paramMessage.obj instanceof BannerManager.MessageToShowBanner)) {}
    do
    {
      return;
      int j = ((BannerManager.MessageToShowBanner)paramMessage.obj).jdField_a_of_type_Int;
    } while (!paramMessage.obj.equals(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner));
    a(30, 0);
    a(30, paramMessage);
  }
  
  private void b(View paramView)
  {
    paramView.setVisibility(0);
    ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435957));
    if (a(9))
    {
      a(9, 0);
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_b_of_type_Int = -1;
      this.jdField_d_of_type_JavaLangString = null;
    }
  }
  
  private void b(View paramView, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      ((TipsBar)paramView).setTipsText((String)paramMessage.obj);
      paramView.setOnClickListener(new xoo(this));
    }
  }
  
  private void b(View paramView, Message paramMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateMissedCallBar state: " + paramInt);
    }
    paramMessage = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(37);
    if (paramMessage != null) {}
    for (int j = paramMessage.a();; j = 0)
    {
      if (j == 0) {}
      do
      {
        do
        {
          return;
          if (paramInt != 0) {
            break;
          }
        } while (paramView.getVisibility() != 0);
        paramView.setVisibility(8);
        return;
        paramView.findViewById(2131369810).setVisibility(0);
        ((TextView)paramView.findViewById(2131369811)).setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131437006), new Object[] { Integer.valueOf(j) }));
      } while (j > 0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(7);
      return;
    }
  }
  
  private void b(BannerManager.MessageToShowBanner paramMessageToShowBanner)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(201);
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    localMessage.obj = paramMessageToShowBanner;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 900000L);
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getConfiguration().orientation == 1;
  }
  
  private View c()
  {
    return ArkTipsManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  private void c(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof BannerManager.MessageToShowBanner)) {
      return;
    }
    int j = ((BannerManager.MessageToShowBanner)paramMessage.obj).jdField_a_of_type_Int;
    this.jdField_b_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner = ((BannerManager.MessageToShowBanner)paramMessage.obj);
    a(30, 2);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner = this.jdField_b_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner;
    a(30, paramMessage);
    b((BannerManager.MessageToShowBanner)paramMessage.obj);
  }
  
  private void c(View paramView)
  {
    if ((this.jdField_c_of_type_JavaLangString != null) && ("1600000104".equals(this.jdField_c_of_type_JavaLangString.trim())))
    {
      paramView.findViewById(2131365425).setVisibility(8);
      paramView.findViewById(2131365428).setVisibility(0);
      return;
    }
    paramView.findViewById(2131365428).setVisibility(8);
    paramView.findViewById(2131365425).setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131365426);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      localTextView.setText(this.jdField_d_of_type_JavaLangString);
    }
    while (this.jdField_b_of_type_Int == 5)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130838354, 0, 0, 0);
      return;
      paramView = "QQ";
      if (this.jdField_b_of_type_Long == 77313L) {
        paramView = "TIM";
      }
      localTextView.setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435598), new Object[] { paramView }));
    }
    if (this.jdField_b_of_type_Int == 4)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130838356, 0, 0, 0);
      return;
    }
    localTextView.setCompoundDrawablesWithIntrinsicBounds(2130838355, 0, 0, 0);
  }
  
  private void c(View paramView, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    for (;;)
    {
      return;
      paramView.setVisibility(0);
      ((TipsBar)paramView).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131438127));
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {}
      for (QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app; (localQQAppInterface != null) && (paramMessage != null) && (paramMessage.obj != null); localQQAppInterface = null)
      {
        paramView.setOnClickListener(new xpb(this, (String)paramMessage.obj));
        return;
      }
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    a(13, 0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    if ((this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener != null) && (paramQQAppInterface != null))
    {
      ((PhoneContactManagerImp)paramQQAppInterface.getManager(10)).b(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = null;
    }
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), false);
  }
  
  private View d()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131438127));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837753));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void d(View paramView)
  {
    if (QQPlayerService.a())
    {
      paramView.setVisibility(0);
      SongInfo localSongInfo = QQPlayerService.a();
      if (localSongInfo != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436463);
        ((TipsBar)paramView).setTipsText(Html.fromHtml(str + " " + localSongInfo.jdField_b_of_type_JavaLangString));
      }
      return;
    }
    paramView.setVisibility(8);
    a(31, 0);
    a(-1, null);
  }
  
  private void d(View paramView, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (localObject != null) {
        break label28;
      }
    }
    label28:
    while ((paramMessage == null) || (paramMessage.obj == null))
    {
      return;
      localObject = null;
      break;
    }
    paramMessage = (Bundle)paramMessage.obj;
    paramView = (TipsBar)paramView;
    paramView.setVisibility(0);
    paramView.setTipsText(paramMessage.getString("expireMsg"));
    int j = paramMessage.getInt("expireType", 4);
    Object localObject = paramMessage.getString("themeId");
    int k = paramMessage.getInt("authResult");
    ReportController.b(null, "CliOper", "", "", "theme", "0X8007232", 0, 0, String.valueOf(j), "", "", "");
    paramView.setOnClickListener(new xpm(this, k, (String)localObject, j));
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "handleAccountChanged with: " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$IBannerInteract.a())) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner);
    }
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), true);
  }
  
  private View e()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846308));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void e(View paramView)
  {
    paramView.findViewById(2131365697).setVisibility(0);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131365696);
    paramView = (ADView)paramView.findViewById(2131365698);
    if (b())
    {
      localRelativeLayout.setPadding(0, 0, 0, 0);
      paramView.i();
      return;
    }
    localRelativeLayout.setPadding(0, -1, 0, 0);
  }
  
  private void e(View paramView, Message paramMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      if (FileViewMusicService.a().a())
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436463);
        String str = FileViewMusicService.a().a();
        if (str != null)
        {
          ((TipsBar)paramView).setTipsText(paramMessage + "" + str);
          paramView.setVisibility(0);
          return;
        }
        paramView.setVisibility(8);
        return;
      }
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private View f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.", 2, " initApolloGameBanner");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838078));
    localTipsBar.setTipsText("等待好友加入");
    localTipsBar.setVisibility(8);
    localTipsBar.b(true);
    localTipsBar.setOnClickListener(new xpr(this));
    localTipsBar.setCloseListener(new xoc(this));
    return localTipsBar;
  }
  
  private void f(View paramView)
  {
    paramView.findViewById(2131372195).setVisibility(0);
    ((TextView)paramView.findViewById(2131372196)).setText("当前有免费的QQ WiFi，点击连接");
  }
  
  private void f(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.arg1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "updateNetNeedSignOn return, msg == null || msg.arg1==HIDE");
      }
      return;
    }
    if ((paramMessage != null) && ((paramMessage.obj instanceof String))) {}
    for (paramMessage = String.valueOf(paramMessage.obj);; paramMessage = "http://qq.com")
    {
      if (paramView.getVisibility() != 0) {
        paramView.setVisibility(0);
      }
      paramView.setOnClickListener(new xpo(this, paramMessage));
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004028", "0X8004028", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private View g()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839465));
    localTipsBar.setOnClickListener(new xof(this, localTipsBar));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void g(View paramView, Message paramMessage)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateApolloGameBanner: ").append(paramView).append(" / ").append(paramMessage).append(" / ");
      if (paramMessage != null)
      {
        localObject = paramMessage.obj;
        QLog.d("Q.recent.banner", 2, localObject);
      }
    }
    else
    {
      if (paramView != null) {
        break label76;
      }
    }
    label76:
    do
    {
      do
      {
        return;
        localObject = null;
        break;
        paramView.setVisibility(0);
      } while ((paramMessage == null) || (!(paramMessage.obj instanceof String)));
      ((TipsBar)paramView).setTipsText((String)paramMessage.obj);
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.", 2, " updateApolloGameBanner (String) msg.obj:" + (String)paramMessage.obj);
  }
  
  private View h()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130970173, null);
    localView.setOnClickListener(new xog(this));
    localView.findViewById(2131369379).setVisibility(8);
    return localView;
  }
  
  private void h()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(101);
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(11, 0);
    localCalendar.clear(12);
    localCalendar.clear(13);
    localCalendar.clear(14);
    l = localCalendar.getTimeInMillis() - (l - 10L) + 300000L;
    if (QLog.isColorLevel()) {
      QLog.d("PushBanner", 2, "Check banner delay: " + l);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(101, l);
  }
  
  private void h(View paramView, Message paramMessage)
  {
    View localView = paramView.findViewById(2131369379);
    paramMessage = (TextView)paramView.findViewById(2131369380);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a();
      if (j != 0)
      {
        localView.setVisibility(0);
        int k = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a().mMode;
        paramView = "传输";
        if (1 == k) {
          paramView = "发送";
        }
        for (;;)
        {
          paramMessage.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131431957) + paramView + String.valueOf(j) + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131431958));
          return;
          if (2 == k) {
            paramView = "接收";
          }
        }
      }
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(8);
  }
  
  private View i()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435957));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837753));
    localTipsBar.setOnClickListener(new xoh(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      return;
    }
    int j = 0;
    label10:
    Object localObject;
    if (j < 4)
    {
      localObject = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
        break label45;
      }
    }
    for (;;)
    {
      j += 1;
      break label10;
      break;
      label45:
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        int k = ((Integer)((Iterator)localObject).next()).intValue();
        Banner localBanner = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[k];
        if ((localBanner != null) && (localBanner.jdField_a_of_type_AndroidViewView != null) && (localBanner.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(localBanner.jdField_a_of_type_AndroidViewView);
          localBanner.jdField_a_of_type_Boolean = false;
          if (!localBanner.a()) {
            localBanner.jdField_a_of_type_AndroidViewView = null;
          }
        }
      }
    }
  }
  
  private void i(View paramView, Message paramMessage)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131368908);
    if (paramMessage != null)
    {
      if (paramMessage.arg1 != 1) {
        break label42;
      }
      localTextView.setText(2131427544);
    }
    for (;;)
    {
      paramView.findViewById(2131368907).setVisibility(0);
      return;
      label42:
      if (paramMessage.arg1 == 2) {
        localTextView.setText(2131427543);
      }
    }
  }
  
  private View j()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(4);
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433228));
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837753));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void j()
  {
    ThreadManager.post(new xpk(this), 5, null, false);
  }
  
  private void j(View paramView, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 8)) {
      if ((paramMessage.obj instanceof VipBannerInfo))
      {
        paramMessage = (VipBannerInfo)paramMessage.obj;
        localObject2 = paramMessage.jdField_b_of_type_JavaLangString;
        localObject1 = (TextView)paramView.findViewById(2131372608);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        if ((paramMessage.jdField_e_of_type_JavaLangString != null) && (!TextUtils.isEmpty(paramMessage.jdField_e_of_type_JavaLangString)))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApp().getResources().getDrawable(2130844273);
          localObject2 = URLDrawable.getDrawable(paramMessage.jdField_e_of_type_JavaLangString, (Drawable)localObject2, (Drawable)localObject2);
          if (localObject2 != null)
          {
            ((Drawable)localObject2).setBounds(0, 0, DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 22.0F), DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 22.0F));
            ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
          }
        }
        localObject1 = (Button)paramView.findViewById(2131372609);
        if ((paramMessage.f != null) && (!TextUtils.isEmpty(paramMessage.f))) {
          ((Button)localObject1).setText(paramMessage.f);
        }
        localObject2 = paramMessage.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
        localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(35);
        if ((paramMessage.jdField_a_of_type_JavaLangString != null) && (localObject2 != null) && (localRedTouchManager != null))
        {
          ((Button)localObject1).setOnClickListener(new xoj(this, localRedTouchManager, paramMessage, (BusinessInfoCheckUpdate.AppInfo)localObject2));
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(9, paramMessage.jdField_b_of_type_Long);
          localRedTouchManager.a((BusinessInfoCheckUpdate.AppInfo)localObject2, paramMessage.jdField_a_of_type_JavaLangString);
          paramView.setVisibility(0);
        }
      }
    }
    while (paramView.getVisibility() != 8)
    {
      Object localObject2;
      Object localObject1;
      RedTouchManager localRedTouchManager;
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9);
  }
  
  private View k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initMissedCallBar");
    }
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130970257, null);
    ((TextView)localView.findViewById(2131369811)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131437006));
    localView.findViewById(2131369810).setVisibility(8);
    return localView;
  }
  
  private void k(View paramView, Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      return;
      if (paramMessage.what == 1134059)
      {
        paramView.setVisibility(0);
        paramMessage = (Pair)paramMessage.obj;
        ((TipsBar)paramView).setTipsText(Html.fromHtml((String)paramMessage.second + " 代收开启"));
        paramView.setTag(paramMessage);
        return;
      }
    } while (paramMessage.what != 1134060);
    if (paramMessage.obj != null)
    {
      paramMessage = (Long)paramMessage.obj;
      Pair localPair = (Pair)paramView.getTag();
      if ((localPair != null) && (((Long)localPair.first).equals(paramMessage)))
      {
        paramView.setVisibility(8);
        a(29, 0);
      }
    }
    for (;;)
    {
      a(-1, null);
      return;
      paramView.setVisibility(8);
      a(29, 0);
    }
  }
  
  private View l()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130971039, null);
    localView.setVisibility(8);
    return localView;
  }
  
  private void l(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 1134027)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReaderBar", 2, "updateReaderBar msg " + paramMessage);
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ReaderBar", 2, "updateReaderBar msg.obj = " + paramMessage.obj);
        }
      } while (!(paramMessage.obj instanceof String));
      paramMessage = ((String)paramMessage.obj).split("@#");
    } while (paramMessage.length != 3);
    String str1 = paramMessage[0];
    String str2 = paramMessage[2];
    long l = Long.parseLong(paramMessage[1]);
    ((TipsBar)paramView).setTipsText("正在阅读《" + str1 + "》");
    paramView.setOnClickListener(new xor(this, l, str2));
    ((TipsBar)paramView).setCloseListener(new xps(13, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(13);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(13, 900000L);
  }
  
  private View m()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130970068, null);
    localView.findViewById(2131368908).setOnClickListener(new xoi(this));
    localView.findViewById(2131368907).setVisibility(8);
    return localView;
  }
  
  private void m(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 1134043)) {
      if (QLog.isColorLevel()) {
        QLog.d("runningState", 2, "updateRunningBar msg " + paramMessage);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RunningBar", 2, "updateRunningBar msg.obj = " + paramMessage.obj);
      }
      if (!(paramMessage.obj instanceof JSONObject)) {
        continue;
      }
      try
      {
        Long localLong = Long.valueOf(((JSONObject)paramMessage.obj).getLong("runningState"));
        paramMessage = ((JSONObject)paramMessage.obj).getString("cookieUrl");
        if (localLong.longValue() == 1L) {
          ((TipsBar)paramView).setTipsText("【运动进行中】点击查看跑步详情");
        }
        for (;;)
        {
          paramView.setOnClickListener(new xos(this, paramMessage));
          if (!(paramView instanceof TipsBar)) {
            break;
          }
          ((TipsBar)paramView).setCloseListener(new xps(1134044, ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).getHandler(Conversation.class)));
          return;
          if (localLong.longValue() == 2L) {
            ((TipsBar)paramView).setTipsText("【运动已暂停】点击查看跑步详情");
          }
        }
        return;
      }
      catch (JSONException paramView) {}
    }
  }
  
  private View n()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130971735, null);
    TextView localTextView = (TextView)localView.findViewById(2131375470);
    localTextView.setOnClickListener(new xok(this));
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433811));
    ((ImageView)localView.findViewById(2131375471)).setOnClickListener(new xol(this));
    localView.findViewById(2131375469).setVisibility(8);
    return localView;
  }
  
  private void n(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || ((paramMessage.what != 1134041) && (paramMessage.what != 1134042))) {
      if (QLog.isColorLevel()) {
        QLog.d("BrowserBar", 2, "updateBrowserBar msg " + paramMessage);
      }
    }
    TextView localTextView;
    String str;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BrowserBar", 2, "updateBrowserBar msg.obj = " + paramMessage.obj);
        }
        if (paramMessage.what == 1134042)
        {
          paramView.setVisibility(8);
          return;
        }
        localTextView = (TextView)paramView.findViewById(2131363089);
      } while ((!(paramMessage.obj instanceof Bundle)) || (localTextView == null));
      paramMessage = (Bundle)paramMessage.obj;
      str = (String)paramMessage.getCharSequence("tips");
      int j = paramMessage.getInt("icon");
      if (j != -1) {
        ((ImageView)paramView.findViewById(2131363087)).setImageResource(j);
      }
    } while (TextUtils.isEmpty(str));
    localTextView.setText(str);
    paramView.setOnClickListener(new xou(this, paramMessage));
    paramView.findViewById(2131363086).setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(15);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(15, paramMessage.getInt("timeout", 120000));
  }
  
  private View o()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130969151, null);
    View localView2 = localView1.findViewById(2131365426);
    View localView3 = localView1.findViewById(2131365427);
    localView1.findViewById(2131365429);
    View localView4 = localView1.findViewById(2131365430);
    xom localxom = new xom(this);
    localView2.setOnClickListener(localxom);
    localView3.setOnClickListener(localxom);
    localView4.setOnClickListener(localxom);
    localView1.findViewById(2131365425).setVisibility(8);
    localView1.findViewById(2131365428).setVisibility(8);
    return localView1;
  }
  
  private void o(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 1134039)) {
      if (QLog.isColorLevel()) {
        QLog.d("ComicBar", 2, "updateComicBar msg " + paramMessage);
      }
    }
    TextView localTextView;
    String str;
    int k;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ComicBar", 2, "updateComicBar msg.obj = " + paramMessage.obj);
        }
        localTextView = (TextView)paramView.findViewById(2131363093);
      } while ((!(paramMessage.obj instanceof Bundle)) || (localTextView == null));
      localObject = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject).getString("comicName");
      str = ((Bundle)localObject).getString("comicId");
      k = ((Bundle)localObject).getInt("type", -1);
    } while (TextUtils.isEmpty(paramMessage));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
    int m = (int)(localTextView.getPaint().measureText(paramMessage) / paramMessage.length());
    int j;
    if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels)
    {
      j = ((DisplayMetrics)localObject).heightPixels;
      j = (int)((j - ((DisplayMetrics)localObject).density * 65.0F) / m) - 8;
      if (paramMessage.length() <= j) {
        break label398;
      }
      paramMessage = paramMessage.substring(0, j) + "...";
    }
    label398:
    for (;;)
    {
      if ((k >= 100) && (k <= 300)) {
        localTextView.setText("正在观看《" + paramMessage + "》");
      }
      for (;;)
      {
        paramView.setOnClickListener(new xov(this, str));
        paramView.findViewById(2131363090).setVisibility(0);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(14);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(14, 900000L);
        return;
        j = ((DisplayMetrics)localObject).widthPixels;
        break;
        localTextView.setText("正在阅读《" + paramMessage + "》");
      }
    }
  }
  
  private View p()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130968833, null);
    View localView2 = localView1.findViewById(2131364008);
    localView1.setOnClickListener(new xon(this));
    localView2.setVisibility(8);
    return localView1;
  }
  
  private void p(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || ((paramMessage.what != 1134049) && (paramMessage.what != 1134050))) {
      if (QLog.isColorLevel()) {
        QLog.d("GameBar", 2, "updateGameBar msg " + paramMessage);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("GameBar", 2, "updateGameBar msg.obj = " + paramMessage.obj);
      }
      if (paramMessage.what == 1134050)
      {
        paramView.setVisibility(8);
        return;
      }
      if (((paramMessage.obj instanceof Bundle)) && ((paramView instanceof TipsBar)))
      {
        paramView = (TipsBar)paramView;
        paramMessage = (Bundle)paramMessage.obj;
        String str = (String)paramMessage.getCharSequence("tips");
        int j = paramMessage.getInt("icon");
        if (paramMessage.containsKey("iconURLBitmap")) {
          paramView.setTipsIcon(new BitmapDrawable((Bitmap)paramMessage.getParcelable("iconURLBitmap")));
        }
        while (!TextUtils.isEmpty(str))
        {
          paramView.setTipsText(str);
          paramView.setOnClickListener(new xoy(this, paramMessage));
          paramView.setCloseListener(new xps(30, this.jdField_a_of_type_MqqOsMqqHandler));
          paramView.setVisibility(0);
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(30);
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(30, paramMessage.getInt("timeout", 900000));
          return;
          if (j != -1) {
            paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(j));
          }
        }
      }
    }
  }
  
  private View q()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839465));
    localTipsBar.setOnClickListener(new xop(this));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void q(View paramView, Message paramMessage)
  {
    paramView.findViewById(2131375469).setVisibility(0);
    paramView = (TextView)paramView.findViewById(2131375470);
    if (paramMessage != null)
    {
      if (ConfigHandler.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
        break label90;
      }
      paramMessage = UpgradeController.a().a();
      if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null)) {
        paramView.setText(paramMessage.a.dialog.h);
      }
    }
    else
    {
      return;
    }
    paramView.setText("已下载新版QQ,点击安装");
    return;
    label90:
    paramMessage = UpgradeController.a().a();
    if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.a.dialog != null))
    {
      paramView.setText(paramMessage.a.dialog.g);
      return;
    }
    paramView.setText("已通过Wi-Fi下载手机新版本，点击安装。");
  }
  
  private View r()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839464));
    localTipsBar.b(true);
    localTipsBar.setOnClickListener(new xoq(this));
    localTipsBar.setCloseListener(new xps(1134060, ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).getHandler(Conversation.class)));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private void r(View paramView, Message paramMessage)
  {
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    }
    View localView;
    TextView localTextView;
    ImageView localImageView;
    long l;
    int j;
    Object localObject;
    int k;
    boolean bool;
    while ((localQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
    {
      localView = paramView.findViewById(2131365205);
      localTextView = (TextView)paramView.findViewById(2131365207);
      localImageView = (ImageView)paramView.findViewById(2131365206);
      if ((paramMessage != null) && (paramMessage.obj != null))
      {
        l = ((Long)paramMessage.obj).longValue();
        j = localQQAppInterface.a().b(l);
        localObject = (LinearLayout)paramView.findViewById(2131365209);
        if (j != 2) {
          break label559;
        }
        paramMessage = localQQAppInterface.a().a(l);
        ((LinearLayout)localObject).setVisibility(0);
        localObject = new ImageView[3];
        localObject[0] = ((ImageView)paramView.findViewById(2131363025));
        localObject[1] = ((ImageView)paramView.findViewById(2131363026));
        localObject[2] = ((ImageView)paramView.findViewById(2131363027));
        if ((paramMessage == null) || (paramMessage.size() == 0))
        {
          k = localObject.length;
          j = 0;
        }
        for (;;)
        {
          if (j < k)
          {
            localObject[j].setVisibility(8);
            j += 1;
            continue;
            localQQAppInterface = null;
            break;
            if (paramMessage.size() != 1) {
              break label418;
            }
            localObject[0].setVisibility(0);
            localObject[1].setVisibility(8);
            localObject[2].setVisibility(8);
            localObject[0].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)paramMessage.get(0)).a), localQQAppInterface));
          }
        }
      }
      j = localQQAppInterface.a().e();
      k = localQQAppInterface.a().b();
      l = localQQAppInterface.a().c();
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "updateMultiVideoBar randomstatus:" + k + ", session:" + j);
      }
      if (localQQAppInterface.a().g() != 2) {
        break label568;
      }
      bool = true;
    }
    for (;;)
    {
      if (l > 0L)
      {
        k = localQQAppInterface.a().d();
        if (k < 2)
        {
          localTextView.setText(2131433764);
          SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
          return;
          label418:
          if (paramMessage.size() == 2)
          {
            localObject[0].setVisibility(0);
            localObject[1].setVisibility(0);
            localObject[2].setVisibility(8);
            localObject[0].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)paramMessage.get(0)).a), localQQAppInterface));
            localObject[1].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)paramMessage.get(1)).a), localQQAppInterface));
            break;
          }
          j = 0;
          while (j < localObject.length)
          {
            localObject[j].setVisibility(0);
            localObject[j].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)paramMessage.get(j)).a), localQQAppInterface));
            j += 1;
          }
          break;
          label559:
          ((LinearLayout)localObject).setVisibility(0);
          break;
          label568:
          bool = false;
          continue;
        }
        paramView = localQQAppInterface.a().b();
        if ((paramView != null) && (paramView.equals("1")))
        {
          j = 1;
          label599:
          if (j == 0) {
            break label679;
          }
        }
        label679:
        for (j = 2131429364;; j = 2131429360)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(j);
          paramMessage = localQQAppInterface.a().e();
          paramView = String.format(paramView, new Object[] { Integer.valueOf(k) });
          localTextView.setText(paramView + " " + paramMessage);
          break;
          j = 0;
          break label599;
        }
      }
    }
    if (k == 6)
    {
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131429361));
      SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
      return;
    }
    if (k >= 5)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131429360);
      paramView = paramView + " ";
      localTextView.setText(paramView + localQQAppInterface.a().e());
      SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
      return;
    }
    if ((k >= 1) && (k < 5))
    {
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131429366));
      SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
      return;
    }
    label945:
    label1002:
    int m;
    if (j == 3)
    {
      l = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().b();
      j = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().b(l);
      k = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().f();
      if (localQQAppInterface.a().e())
      {
        localTextView.setText(2131433764);
        if ((j == 2) && (!localQQAppInterface.a().a(String.valueOf(l)))) {
          localImageView.setImageDrawable(null);
        }
        if (k == 1)
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131428906);
          paramView = paramMessage;
          if (j == 2) {
            paramView = paramMessage.replace(localQQAppInterface.getApp().getString(2131433846), localQQAppInterface.getApp().getString(2131433848));
          }
          UITools.a(localView, paramView);
          SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
        }
      }
      else
      {
        l = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().b();
        m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a();
        localObject = localQQAppInterface.a().e();
        if (k == 3000)
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433762);
          paramView = paramMessage;
          if (j == 2) {
            paramView = paramMessage.replace(localQQAppInterface.getApp().getString(2131433846), localQQAppInterface.getApp().getString(2131433848));
          }
        }
      }
    }
    label1657:
    for (;;)
    {
      l = localQQAppInterface.a().a(m, l);
      if ((localView != null) && (l == 0L))
      {
        SmallScreenUtils.a(localView, false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
        return;
        if (k == 1)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433763);
          if (j != 2) {
            break label1657;
          }
          paramView = paramView.replace(localQQAppInterface.getApp().getString(2131433846), localQQAppInterface.getApp().getString(2131433848));
          localImageView.setImageDrawable(null);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.recent.banner", 2, "updateMultiVideoBar-->wrong type of UinType.uintype=" + k);
        return;
      }
      if (localView == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.recent.banner", 2, "updateMultiVideoBar-->multiVideoBar is null");
        return;
      }
      paramView = String.format(paramView, new Object[] { Long.valueOf(l) });
      localTextView.setText(paramView + " " + (String)localObject);
      break label945;
      if (k != 3000) {
        break label1002;
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131428905);
      paramView = paramMessage;
      if (j == 2) {
        paramView = paramMessage.replace(localQQAppInterface.getApp().getString(2131433846), localQQAppInterface.getApp().getString(2131433848));
      }
      UITools.a(localView, paramView);
      break label1002;
      if (j == 1)
      {
        if (localQQAppInterface.a().e()) {
          localTextView.setText(2131429087);
        }
        for (;;)
        {
          UITools.a(localView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131428895));
          SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
          return;
          paramView = localQQAppInterface.a().e();
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131429087);
          localTextView.setText(paramMessage + " " + paramView);
        }
      }
      if (j == 5)
      {
        localTextView.setText(2131429566);
        UITools.a(localView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131429567));
        SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
        return;
      }
      if ((j == 2) && (!localQQAppInterface.a().j()))
      {
        if (localQQAppInterface.a().e()) {
          localTextView.setText(2131429088);
        }
        for (;;)
        {
          UITools.a(localView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131428895));
          SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
          return;
          paramView = localQQAppInterface.a().e();
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131429088);
          localTextView.setText(paramMessage + " " + paramView);
        }
      }
      SmallScreenUtils.a(localView, false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
      return;
    }
  }
  
  private View s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReaderBar", 2, "initReaderBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(3);
    localTipsBar.b(true);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837947));
    return localTipsBar;
  }
  
  @SuppressLint({"ResourceType"})
  private void s(View paramView, Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    paramView = (TipsBar)paramView;
    paramMessage = (BannerManager.MessageToShowBanner)paramMessage.obj;
    paramView.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(BannerIconCollection.a(paramMessage.jdField_b_of_type_Int)));
    paramView.setTipsText(paramMessage.jdField_b_of_type_JavaLangString);
    paramView.setOnClickListener(new xpu(paramMessage, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setCloseListener(new xpt(paramMessage, this.jdField_a_of_type_MqqOsMqqHandler));
    paramView.setVisibility(0);
  }
  
  private View t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RunningBar", 2, "initRunningBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(3);
    localTipsBar.setTipsText("【跑步进行中】点击查看跑步详情");
    localTipsBar.b(true);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837948));
    return localTipsBar;
  }
  
  private View u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BrowserBar", 2, "initBrowserBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130968663, null);
    localView.findViewById(2131363086).setVisibility(8);
    return localView;
  }
  
  private View v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComicBar", 2, "initComicBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130968664, null);
    localView.findViewById(2131363090).setVisibility(8);
    return localView;
  }
  
  private View w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameBar", 2, "initGameBar");
    }
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837944));
    localTipsBar.setVisibility(8);
    return localTipsBar;
  }
  
  private View x()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130971734, null);
    TextView localTextView = (TextView)localView.findViewById(2131375470);
    localTextView.setOnClickListener(new xoz(this));
    localTextView.setText("");
    if (AppSetting.b) {
      localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433820));
    }
    ((ImageView)localView.findViewById(2131365699)).setOnClickListener(new xpa(this));
    localView.findViewById(2131375469).setVisibility(8);
    return localView;
  }
  
  private View y()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130969109, null);
    localView.setOnClickListener(new xpc(this));
    localView.findViewById(2131365205).setVisibility(8);
    return localView;
  }
  
  private View z()
  {
    TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localTipsBar.setBarType(2);
    localTipsBar.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838656));
    localTipsBar.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433222));
    localTipsBar.setOnClickListener(new xpd(this));
    return localTipsBar;
  }
  
  public int a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt];
      }
    }
    if (localObject1 == null) {
      return 0;
    }
    return ((Banner)localObject1).jdField_b_of_type_Int;
  }
  
  public int a(SparseArray paramSparseArray, int paramInt)
  {
    int m = 0;
    int k = 0;
    int j;
    if (paramSparseArray == null) {
      j = k;
    }
    do
    {
      do
      {
        return j;
        paramSparseArray = (ArrayList)paramSparseArray.get(paramInt);
        j = k;
      } while (paramSparseArray == null);
      j = k;
    } while (paramSparseArray.size() <= 0);
    paramSparseArray = paramSparseArray.iterator();
    for (paramInt = m;; paramInt = ((Integer)paramSparseArray.next()).intValue() + paramInt)
    {
      j = paramInt;
      if (!paramSparseArray.hasNext()) {
        break;
      }
    }
  }
  
  protected Bitmap a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = FaceDrawable.a(paramQQAppInterface, paramString, (byte)2).a();
    paramString = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      paramString = ImageUtil.a();
    }
    return paramString;
  }
  
  public View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130970258, null);
    localView.findViewById(2131369812).setVisibility(8);
    return localView;
  }
  
  public Object a(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner.length)) {}
    for (Banner localBanner = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt1];; localBanner = null)
    {
      Object localObject1 = localObject2;
      if (localBanner != null)
      {
        localObject1 = localObject2;
        if (localBanner.jdField_a_of_type_AndroidViewView != null)
        {
          if (paramInt2 != 0) {
            break label58;
          }
          localObject1 = localBanner.jdField_a_of_type_AndroidViewView.getTag();
        }
      }
      return localObject1;
      label58:
      return localBanner.jdField_a_of_type_AndroidViewView.getTag(paramInt2);
    }
  }
  
  public MqqHandler a()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().b() <= 0) {
        break label34;
      }
      a(32, 2);
    }
    label34:
    int j;
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c()) {
        break;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().e();
      if (j == 3)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().b() > 0L)
        {
          a(32, 2);
          return;
        }
        a(32, 0);
        return;
      }
      if (j == 1)
      {
        a(32, 2);
        return;
      }
      if (j == 2)
      {
        a(32, 2);
        return;
      }
    } while (j != 5);
    a(32, 2);
    return;
    a(32, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 4, "updateBanerState|[" + paramInt1 + "," + paramInt2 + "]");
    }
    if ((paramInt1 >= 1) && (paramInt1 <= 34))
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt1] == null) {
        break label102;
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt1].jdField_b_of_type_Int = paramInt2;
    }
    for (;;)
    {
      if ((paramInt1 >= 23) && (paramInt1 <= 30) && (paramInt2 == 2)) {
        a(paramInt1);
      }
      return;
      label102:
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt1] == null) && (Banner.a(paramInt2))) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt1] = new Banner(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(int paramInt, Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent.banner", 4, "refreshBanner, id: " + paramInt + " msg: " + paramMessage);
    }
    if (this.jdField_b_of_type_AndroidUtilSparseArray == null) {
      this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(4);
    }
    int j = 0;
    Object localObject1;
    if (j < 4)
    {
      localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(j);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList(1);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(j, localObject1);
      }
      for (;;)
      {
        j += 1;
        break;
        ((ArrayList)localObject1).clear();
      }
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
    }
    j = 1;
    for (;;)
    {
      if (j <= 22)
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[j] == null) || (!this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[j].a())) {
          break label267;
        }
        localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(0);
        if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
          ((ArrayList)localObject1).add(Integer.valueOf(j));
        }
      }
      j = 23;
      while (j <= 30)
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[j] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[j].a()))
        {
          localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(1);
          if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
            ((ArrayList)localObject1).add(Integer.valueOf(j));
          }
        }
        j += 1;
      }
      label267:
      j += 1;
    }
    j = 31;
    if (j <= 31)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[j] == null) || (!this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[j].a())) {
        break label468;
      }
      localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(2);
      if (localObject1 != null) {
        ((ArrayList)localObject1).add(Integer.valueOf(j));
      }
    }
    j = 32;
    label335:
    if (j <= 34)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[j] == null) || (!this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[j].a())) {
        break label475;
      }
      localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(3);
      if (localObject1 != null) {
        ((ArrayList)localObject1).add(Integer.valueOf(j));
      }
    }
    int m = 0;
    j = 1;
    int k = 1;
    label398:
    Object localObject2;
    if (m < 4)
    {
      localObject1 = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(m);
      localObject2 = (List)this.jdField_b_of_type_AndroidUtilSparseArray.get(m);
      if (((List)localObject2).equals(localObject1)) {
        break label984;
      }
      k = 0;
    }
    label468:
    label984:
    for (;;)
    {
      if (!((List)localObject2).isEmpty()) {
        j = 0;
      }
      for (;;)
      {
        m += 1;
        break label398;
        j += 1;
        break;
        label475:
        j += 1;
        break label335;
        if ((k != 0) && (j != 0)) {
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "refreshBanner, no banner");
          }
        }
        for (;;)
        {
          return;
          if (j != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.recent.banner", 2, "refreshBanner| clear banner");
            }
            i();
            return;
          }
          j = a(this.jdField_b_of_type_AndroidUtilSparseArray, 1);
          m = a(this.jdField_a_of_type_AndroidUtilSparseArray, 1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "added banner: " + (j - m));
          }
          if (k == 0)
          {
            i();
            j = 0;
            while (j < 4)
            {
              localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(j);
              if (localObject1 != null) {
                this.jdField_a_of_type_AndroidUtilSparseArray.put(j, (ArrayList)((ArrayList)localObject1).clone());
              }
              j += 1;
            }
          }
          m = 0;
          j = 0;
          while (m < 4)
          {
            localObject1 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(m);
            k = j;
            if (localObject1 != null)
            {
              if (((ArrayList)localObject1).size() == 0) {
                k = j;
              }
            }
            else
            {
              m += 1;
              j = k;
              continue;
            }
            localObject2 = ((ArrayList)localObject1).iterator();
            Banner localBanner;
            do
            {
              k = j;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              k = ((Integer)((Iterator)localObject2).next()).intValue();
              localBanner = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[k];
            } while (localBanner == null);
            a(localBanner);
            k = j;
            for (;;)
            {
              try
              {
                if (localBanner.jdField_a_of_type_AndroidViewView != null)
                {
                  k = j;
                  if (!localBanner.jdField_a_of_type_Boolean) {
                    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localBanner.jdField_a_of_type_AndroidViewView, 1);
                  }
                }
              }
              catch (Exception localException1)
              {
                try
                {
                  localBanner.jdField_a_of_type_Boolean = true;
                  k = 1;
                  j = k;
                  if ((paramMessage != null) && (paramInt == localBanner.jdField_a_of_type_Int)) {
                    break label873;
                  }
                  a(localBanner, null);
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    j = 1;
                  }
                }
                localException1 = localException1;
              }
              if (QLog.isDevelopLevel()) {
                QLog.d("Q.recent.banner", 4, "initBanner|" + localException1.toString());
              }
              continue;
              label873:
              a(localBanner, paramMessage);
            }
          }
          if (j != 0)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {}
            for (paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;; paramMessage = null)
            {
              if ((paramMessage == null) || (!((MsgTabStoryNodeConfigManager)paramMessage.getManager(251)).jdField_a_of_type_Boolean)) {
                break label972;
              }
              paramInt = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
              if (paramInt > this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount()) {
                break;
              }
              j = this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount(0);
              if ((j == -1) || (j > paramInt)) {
                break;
              }
              this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(j);
              return;
            }
          }
        }
      }
    }
  }
  
  public void a(Message paramMessage)
  {
    Bundle localBundle = (Bundle)paramMessage.obj;
    String str = localBundle.getString("iconURL");
    if (!TextUtils.isEmpty(str))
    {
      paramMessage = Message.obtain(paramMessage);
      ImageLoader.a().a(str, new xow(this, localBundle, paramMessage));
      return;
    }
    a(26, 2);
    a(26, paramMessage);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "onDestroy");
      }
      this.f = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener != null) && (paramQQAppInterface != null))
      {
        ((PhoneContactManagerImp)paramQQAppInterface.getManager(10)).b(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
        this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = null;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.recent.banner", 2, "onDestroy", paramQQAppInterface);
    }
  }
  
  public void a(String paramString)
  {
    if ((a(14)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString)) && (this.jdField_e_of_type_JavaLangString.equals(paramString)))
    {
      this.jdField_e_of_type_JavaLangString = "";
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 1000L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[13] != null) {
      a(13, 0);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    if (paramBoolean)
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(10);
      int j;
      if (localPhoneContactManagerImp != null)
      {
        j = localPhoneContactManagerImp.b();
        if (j == 0) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(11, 1000L);
        }
      }
      else
      {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener == null) && (!this.f))
      {
        this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = new xob(this);
        localPhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
      }
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), 0).getBoolean("key_show_contact_banner", true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "checkContactBanner, state = " + j + ", isFirstShow = " + paramBoolean);
      }
      if ((j == 1) && (paramBoolean))
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[13] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[13].jdField_b_of_type_Int != 2)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053D8", "0X80053D8", 0, 0, "", "", "", "");
        }
        a(13, 2);
        return;
      }
      a(13, 0);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(11, 1000L);
  }
  
  public boolean a()
  {
    boolean bool1 = true;
    boolean bool2 = c();
    if ((this.jdField_e_of_type_Boolean) && (!bool2)) {}
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "isNeedShowPushBanner, isNeedShow = " + bool1);
      }
      return bool1;
      if (d())
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[17] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[17] = new Banner(17, 0);
        }
        a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[17]);
        View localView = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[17].jdField_a_of_type_AndroidViewView;
        if (localView != null) {}
        for (bool1 = a(localView);; bool1 = false)
        {
          if (bool1)
          {
            localView.findViewById(2131365697).setVisibility(0);
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), false).commit();
          }
          break;
        }
      }
      bool1 = false;
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt];
      }
    }
    return (localObject1 != null) && (((Banner)localObject1).a());
  }
  
  public void b()
  {
    if (a(9))
    {
      a(9, 0);
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_b_of_type_Int = -1;
      this.jdField_d_of_type_JavaLangString = null;
      this.jdField_b_of_type_Long = 0L;
      a(-1, null);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    c(paramQQAppInterface);
    d(paramQQAppInterface);
  }
  
  public boolean b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt];
      }
    }
    return (localObject1 != null) && (((Banner)localObject1).jdField_a_of_type_Boolean);
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[17];
    ViewGroup localViewGroup;
    int k;
    int j;
    if ((localObject != null) && (((Banner)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      localObject = (ADView)((Banner)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131365698);
      localViewGroup = ((ADView)localObject).a(0);
      if (localViewGroup != null)
      {
        k = localViewGroup.getChildCount();
        j = 0;
        k -= 1;
        if (k >= 0)
        {
          View localView = localViewGroup.getChildAt(k);
          PushBanner localPushBanner = (PushBanner)localView.getTag();
          String str = localPushBanner.jdField_c_of_type_JavaLangString;
          int m = str.indexOf("|");
          if (CommonUtil.a(Long.parseLong(str.substring(0, m)), Long.parseLong(str.substring(m + 1)))) {
            break label296;
          }
          ((ADView)localObject).a(0, k, localView);
          Config.a.b(localPushBanner.l);
          j = 1;
        }
      }
    }
    label296:
    for (;;)
    {
      k -= 1;
      break;
      if (j != 0)
      {
        if (localViewGroup.getChildCount() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime().getAccount(), false).commit();
          ((ADView)localObject).h();
          a(17, 0);
          a(-1, null);
          this.jdField_e_of_type_Boolean = false;
        }
        for (;;)
        {
          localObject = new ConfigManager(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), ConfigServlet.jdField_a_of_type_JavaLangString);
          if (localObject != null)
          {
            ((ConfigManager)localObject).b();
            ((ConfigManager)localObject).c();
          }
          return;
          h();
        }
      }
      h();
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(101);
    a(10, 0);
    a(12, 0);
    a(27, 0);
    a(28, 0);
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[17];
    if ((localObject != null) && (((Banner)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((Banner)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131365696);
      localObject = (ADView)((Banner)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131365698);
      if (localObject != null)
      {
        ((ADView)localObject).j();
        ((ADView)localObject).h();
      }
      if (localRelativeLayout != null) {
        localRelativeLayout.setPadding(0, -1, 0, 0);
      }
    }
    this.jdField_e_of_type_Boolean = false;
    b();
    a(14, 0);
    this.g = true;
    this.h = false;
    this.jdField_e_of_type_JavaLangString = "";
    a(6, 0);
    a(15, 0);
    a(19, 0);
    a(5, 0);
    a(23, 0);
    a();
    f();
    a(-1, null);
    a(false);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void e()
  {
    int n = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "checkIsShowTroopTip");
    }
    QQAppInterface localQQAppInterface;
    List localList;
    int j;
    label83:
    int k;
    label85:
    int m;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if ((localQQAppInterface != null) && ((TroopAssistantManager.a().c(localQQAppInterface, this.jdField_e_of_type_JavaLangString)) || (this.h)))
      {
        localList = localQQAppInterface.a().a().a(false);
        if (localList != null) {
          break label136;
        }
        j = 0;
        k = 0;
        m = n;
        if (k >= j) {
          break label154;
        }
        if (((RecentUser)localList.get(k)).type != 5000) {
          break label147;
        }
        if (this.h) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        }
      }
    }
    label136:
    label147:
    label154:
    do
    {
      return;
      localQQAppInterface = null;
      break;
      j = localList.size();
      break label83;
      k += 1;
      break label85;
      if (m < j)
      {
        RecentUser localRecentUser = (RecentUser)localList.get(m);
        if (localRecentUser.type != 1) {}
        do
        {
          do
          {
            m += 1;
            break;
          } while ((TextUtils.isEmpty(localRecentUser.uin)) || (TroopAssistantManager.a().b(localQQAppInterface, localRecentUser.uin)) || (TroopAssistantManager.a().a(localQQAppInterface, localRecentUser.uin) != 1));
          if (localQQAppInterface.a().a(localRecentUser.uin, localRecentUser.type) > 99)
          {
            if ((this.h) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString.equals(localRecentUser.uin))) {
              break;
            }
            this.jdField_e_of_type_JavaLangString = localRecentUser.uin;
            if ((!this.g) || (!TroopAssistantManager.a().c(localQQAppInterface, this.jdField_e_of_type_JavaLangString))) {
              break;
            }
            return;
          }
        } while ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (!this.jdField_e_of_type_JavaLangString.equals(localRecentUser.uin)));
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        return;
      }
    } while ((!this.h) || (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)));
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
  
  public void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(7, 0L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 0: 
    default: 
    case 1: 
    case 4: 
    case 6: 
    case 7: 
    case 12: 
    case 16: 
    case 8: 
    case 9: 
    case 101: 
      do
      {
        return true;
        a(14, 0);
        this.jdField_e_of_type_JavaLangString = "";
        a(14, paramMessage);
        return true;
        a(15, 0);
        a(15, paramMessage);
        return true;
        a(3, 2);
        a(3, paramMessage);
        return true;
        a(3, 0);
        a(3, paramMessage);
        return true;
        a(20, 0);
        a(20, paramMessage);
        return true;
        a(21, 0);
        a(21, paramMessage);
        return true;
        a(19, 2);
        a(19, paramMessage);
        return true;
        a(19, 0);
        a(19, paramMessage);
        return true;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("PushBanner", 2, "checkAndClosePushBanner");
          }
          c();
          return true;
        }
        catch (Exception paramMessage) {}
      } while (!QLog.isColorLevel());
      QLog.d("PushBanner", 2, "checkAndClosePushBanner Exception:", paramMessage);
      return true;
    case 11: 
      a(true);
      return true;
    case 13: 
      a(23, 0);
      a(23, paramMessage);
      return true;
    case 14: 
      a(24, 0);
      a(24, paramMessage);
      return true;
    case 15: 
      a(25, 0);
      a(25, paramMessage);
      return true;
    case 30: 
      a(26, 0);
      a(26, paramMessage);
      return true;
    case 20: 
      a(22, 0);
      a(22, paramMessage);
      return true;
    case 200: 
      c(paramMessage);
      return true;
    }
    b(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.BannerManager
 * JD-Core Version:    0.7.0.1
 */