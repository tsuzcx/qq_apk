package com.tencent.mobileqq.activity;

import aasr;
import aezy;
import aezz;
import afaa;
import afab;
import afac;
import afad;
import afae;
import afaf;
import afag;
import afah;
import afai;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import aqcx;
import arnf;
import arng;
import aroe;
import arof;
import ascz;
import asdd;
import ashz;
import bdla;
import beau;
import bebi;
import becb;
import becg;
import beco;
import becr;
import becx;
import becy;
import bedb;
import beeg;
import bhcc;
import bheg;
import bieo;
import bigl;
import biho;
import bihv;
import biis;
import biit;
import bkys;
import bkzi;
import bkzz;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lka;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nwo;
import org.json.JSONException;
import org.json.JSONObject;

public class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
  extends WebViewFragment
{
  public int a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aezy(this);
  Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new aezz(this);
  public Button a;
  public EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private aqcx jdField_a_of_type_Aqcx;
  private bebi jdField_a_of_type_Bebi;
  private bedb jdField_a_of_type_Bedb;
  bkys jdField_a_of_type_Bkys;
  public InputLinearLayout a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  String jdField_a_of_type_JavaLangString = "";
  public boolean a;
  public int b;
  Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new afab(this);
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public String b;
  public boolean b;
  public int c;
  ImageView c;
  public String c;
  public boolean c;
  public int d;
  private ImageView d;
  public boolean d;
  public int e;
  boolean e = false;
  private int jdField_f_of_type_Int = -1;
  boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = -1000;
  boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l = true;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
  }
  
  private String a()
  {
    String str2 = getWebView().getUrl();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      int i1 = str2.indexOf("&preview=1");
      str1 = str2;
      if (i1 >= 0) {
        str1 = str2.substring(0, i1 - 1);
      }
    }
    return str1;
  }
  
  private void a(int paramInt, String paramString, ImageView paramImageView)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    switch (paramInt)
    {
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      if (paramInt != -1) {
        this.jdField_a_of_type_Aqcx = new aqcx(getHostActivity(), paramInt);
      }
      if (this.jdField_a_of_type_Aqcx == null) {
        break;
      }
      this.jdField_a_of_type_Aqcx.a();
      this.jdField_a_of_type_Aqcx.a(new afag(this, paramImageView));
      this.jdField_a_of_type_Aqcx.a(paramString, true);
      return;
      paramInt = 1;
      continue;
      paramInt = 4;
      continue;
      paramInt = 101;
    }
  }
  
  private boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      paramTeamWorkFileImportInfo = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
    }
    for (;;)
    {
      return (paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 12);
    }
  }
  
  private void d(int paramInt)
  {
    if (getActivity() == null) {
      return;
    }
    String str1;
    String str2;
    Object localObject2;
    SharedPreferences localSharedPreferences;
    int i1;
    switch (paramInt)
    {
    default: 
      str1 = "key_team_work_user_click_count";
      paramInt = arng.a().c();
      str2 = arng.a().b();
      localObject2 = arng.a().c();
      localObject1 = anvx.a(2131714186);
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("tim_convert_teamwork_pre_" + getActivity().getCurrentAccountUin(), 4);
      i1 = localSharedPreferences.getInt(str1, 0);
      if (i1 >= paramInt) {
        break label396;
      }
      if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty((CharSequence)localObject2))) {
        break;
      }
    }
    for (Object localObject1 = getResources().getString(2131719285);; localObject1 = str2 + "\n" + (String)localObject2)
    {
      localObject2 = new Intent(getActivity(), DialogActivity.class);
      ((Intent)localObject2).addFlags(268435456);
      ((Intent)localObject2).addFlags(536870912);
      ((Intent)localObject2).addFlags(67108864);
      ((Intent)localObject2).addFlags(131072);
      ((Intent)localObject2).putExtra("key_dialog_type", DialogActivity.jdField_d_of_type_Int);
      ((Intent)localObject2).putExtra("key_dialog_title", anvx.a(2131714125));
      ((Intent)localObject2).putExtra("key_dialog_content", (String)localObject1);
      ((Intent)localObject2).putExtra("key_teamwork_url", a());
      getActivity().startActivity((Intent)localObject2);
      a(20);
      localObject1 = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject1).putInt(str1, i1 + 1);
      ((SharedPreferences.Editor)localObject1).commit();
      return;
      str1 = "key_team_work_user_click_count";
      paramInt = arng.a().c();
      str2 = arng.a().d();
      localObject2 = arng.a().e();
      localObject1 = anvx.a(2131714137);
      break;
      str1 = "key_team_work_content_edit_click_count";
      paramInt = arng.a().d();
      str2 = arng.a().f();
      localObject2 = arng.a().g();
      localObject1 = anvx.a(2131714136);
      break;
    }
    label396:
    QQToast.a(getActivity(), (CharSequence)localObject1, 0).b(getActivity().getResources().getDimensionPixelSize(2131299080));
  }
  
  private void d(String paramString)
  {
    if (HttpUtil.isValidUrl(paramString)) {
      this.webView.loadUrl(paramString);
    }
    this.j = false;
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.mSwiftTitleUI.rightViewText.setOnClickListener(null);
    this.mSwiftTitleUI.rightViewText.setVisibility(8);
    this.mSwiftTitleUI.leftView.setBackgroundResource(2130840360);
    this.mSwiftTitleUI.leftView.setText(2131690499);
    this.jdField_f_of_type_Int = 2;
    d();
    i();
    this.jdField_g_of_type_Boolean = false;
    this.mSwiftTitleUI.rightViewImg.setVisibility(8);
    if (this.i) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void m()
  {
    this.mIpcObserver = new afad(this);
  }
  
  private void n()
  {
    Bundle localBundle = new Bundle();
    if (getIntent().getParcelableExtra("key_team_work_file_import_info") != null) {
      localBundle.putParcelable("key_team_work_file_import_info", getIntent().getParcelableExtra("key_team_work_file_import_info"));
    }
    localBundle = asdd.a("ipc_cmd_get_team_work_url", "", this.mIpcObserver.key, localBundle);
    ashz.a().a(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->service binded  make ipc request");
    }
    this.l = true;
  }
  
  private void o()
  {
    Object localObject2;
    Object localObject1;
    if (this.mUIStyleHandler.mUIStyle.isFullScreen)
    {
      QLog.e("WebLog_WebViewFragment", 1, "isFullScreen");
      if (getIntent().getStringExtra("url") != null)
      {
        localObject2 = new StringBuilder().append("isFullScreen url: ").append(getIntent().getStringExtra("url")).append(" mRulesFromUrl fullScreen ");
        if ((this.mUIStyle.mRulesFromUrl & 0x20000) <= 0L) {
          break label535;
        }
        localObject1 = "true";
        QLog.e("WebLog_WebViewFragment", 1, (String)localObject1);
      }
    }
    boolean bool;
    if (this.mSwiftTitleUI.titleContainer != null)
    {
      this.mSwiftTitleUI.rightViewImg.setVisibility(8);
      localObject1 = getIntent();
      localObject2 = getResources().getColorStateList(2131167021);
      this.mSwiftTitleUI.leftView.setTextColor((ColorStateList)localObject2);
      this.mSwiftTitleUI.rightViewText.setTextColor((ColorStateList)localObject2);
      this.mSwiftTitleUI.leftView.setBackgroundResource(2130840360);
      if ((this.jdField_a_of_type_Bebi == null) || (!this.jdField_a_of_type_Bebi.a())) {
        this.mSwiftTitleUI.titleContainer.setBackgroundColor(Color.parseColor("#f6f7f9"));
      }
      this.mSwiftTitleUI.centerView.setTextSize(18.0F);
      this.mSwiftTitleUI.centerView.setTextColor(Color.parseColor("#333333"));
      this.mSwiftTitleUI.centerView.setMaxEms(13);
      this.mSwiftTitleUI.centerView.getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mSwiftTitleUI.titleContainer.findViewById(2131369281));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(13);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.mSwiftTitleUI.titleContainer.findViewById(2131369250));
      this.jdField_d_of_type_Int = ((Intent)localObject1).getIntExtra("key_team_work_pad_list_type", -1);
      if ((!((Intent)localObject1).getBooleanExtra("temp_preview_from_qq", false)) || (getCurrentUrl() == null) || (!getCurrentUrl().contains("preview=1"))) {
        break label542;
      }
      bool = true;
      label383:
      this.j = bool;
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "getShareUrl:" + getShareUrl() + "  tempPreviewFromQQ:" + this.j);
      }
      if (!this.j) {
        break label683;
      }
      localObject1 = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
      if ((this.jdField_a_of_type_Int == 0) && (localObject1 != null))
      {
        if (((TeamWorkFileImportInfo)localObject1).e != 3) {
          break label547;
        }
        this.jdField_a_of_type_Int = 1;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bebi == null) || (!this.jdField_a_of_type_Bebi.a())) {
        break label564;
      }
      this.mSwiftTitleUI.rightViewImg.setVisibility(8);
      this.mSwiftTitleUI.rightViewText.setVisibility(8);
      this.mSwiftTitleUI.leftView.setVisibility(8);
      return;
      label535:
      localObject1 = "false";
      break;
      label542:
      bool = false;
      break label383;
      label547:
      if (((TeamWorkFileImportInfo)localObject1).e == 6) {
        this.jdField_a_of_type_Int = 2;
      }
    }
    label564:
    this.mSwiftTitleUI.rightViewText.setVisibility(0);
    this.mSwiftTitleUI.leftView.setVisibility(0);
    j();
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.mSwiftTitleUI.rightViewImg.setVisibility(8);
    this.mSwiftTitleUI.rightViewText.setVisibility(0);
    this.mSwiftTitleUI.rightViewText.setText(anvx.a(2131714132));
    this.mSwiftTitleUI.leftView.setText(anvx.a(2131714152));
    this.jdField_f_of_type_Int = 1;
    this.mSwiftTitleUI.rightViewText.setOnClickListener(new afaf(this));
    for (;;)
    {
      setMiniAIOEntry(true);
      return;
      label683:
      if (((Intent)localObject1).getBooleanExtra("temp_preview_from_qq", false))
      {
        this.jdField_f_of_type_Int = 3;
        j();
      }
      else
      {
        j();
      }
    }
  }
  
  private void p()
  {
    becr.a((TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info"), getCurrentUrl(), "0X8009F33");
    q();
  }
  
  private void q()
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
    if (a(localTeamWorkFileImportInfo))
    {
      beeg.a(null, "0X800A753");
      bdla.b(null, "dc00898", "", "", "0X800A757", "0X800A757", 0, 0, "", "", String.valueOf(SystemClock.elapsedRealtime() - localTeamWorkFileImportInfo.jdField_c_of_type_Long), "");
    }
  }
  
  public bedb a(ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    if ((this.mUIStyle.mWWVRulesFromUrl & 0x40) != 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Bedb = new bedb(this.mApp, super.getActivity(), this, this.intent, bool1);
      this.jdField_a_of_type_Bedb.a(this.sonicClient);
      TouchWebView localTouchWebView = this.jdField_a_of_type_Bedb.a();
      if (this.sonicClient != null) {
        this.sonicClient.bindWebView(localTouchWebView);
      }
      this.mPluginEngine.a(localTouchWebView);
      localTouchWebView.setPluginEngine(this.mPluginEngine);
      if ((localTouchWebView instanceof SwiftReuseTouchWebView))
      {
        bihv localbihv = this.mStatistics;
        bool1 = bool2;
        if (1 == ((SwiftReuseTouchWebView)localTouchWebView).jdField_b_of_type_Int) {
          bool1 = true;
        }
        localbihv.u = bool1;
      }
      if (localTouchWebView.getX5WebViewExtension() != null) {
        this.e = true;
      }
      localTouchWebView.getView().setOnTouchListener(this);
      if (this.mNightMode) {
        localTouchWebView.setMask(true);
      }
      if (paramViewGroup != null) {
        paramViewGroup.addView(localTouchWebView);
      }
      return this.jdField_a_of_type_Bedb;
    }
  }
  
  public void a()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    String str = "";
    int i1 = getIntent().getIntExtra("tdsourcetab", -1);
    if (paramInt == 0) {
      if (i1 == 3)
      {
        bdla.b(getActivity().app, "dc00898", "", "", "0X800A074", "0X800A074", 0, 0, "", "", "", "");
        str = "0X80074D2";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        bdla.b(getActivity().app, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if (i1 != 20) {
        break;
      }
      bdla.b(getActivity().app, "dc00898", "", "", "0X800A07C", "0X800A07C", 0, 0, "", "", "", "");
      break;
      if (paramInt == 1)
      {
        if (i1 == 3) {
          bdla.b(getActivity().app, "dc00898", "", "", "0X800A075", "0X800A075", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          str = "0X80074D3";
          break;
          if (i1 == 20) {
            bdla.b(getActivity().app, "dc00898", "", "", "0X800A07D", "0X800A07D", 0, 0, "", "", "", "");
          }
        }
      }
      if (paramInt == 2)
      {
        if (i1 == 3) {
          bdla.b(getActivity().app, "dc00898", "", "", "0X800A076", "0X800A076", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          str = "0X80074D4";
          break;
          if (i1 == 20) {
            bdla.b(getActivity().app, "dc00898", "", "", "0X800A07E", "0X800A07E", 0, 0, "", "", "", "");
          }
        }
      }
      if (paramInt == 3)
      {
        str = "0X80075FF";
      }
      else if (paramInt == 4)
      {
        str = "0X80075FE";
      }
      else if (paramInt == 5)
      {
        str = "0X8007762";
      }
      else if (paramInt == 6)
      {
        str = "0X8007764";
      }
      else if (paramInt == 7)
      {
        str = "0X8007763";
      }
      else if (paramInt == 8)
      {
        str = "0X8007A29";
      }
      else if (paramInt == 9)
      {
        str = "0X8007A2A";
      }
      else if (paramInt == 10)
      {
        str = "0X8007A2B";
      }
      else if (paramInt == 11)
      {
        str = "0X8007A2C";
      }
      else if (paramInt == 12)
      {
        str = "0X8007A30";
      }
      else if (paramInt == 13)
      {
        str = "0X8007A31";
      }
      else if (paramInt == 14)
      {
        str = "0X8007CE5";
      }
      else
      {
        if (paramInt == 15)
        {
          if (i1 == 3) {
            bdla.b(getActivity().app, "dc00898", "", "", "0X800A073", "0X800A073", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            str = "0X8008A3B";
            break;
            if (i1 == 20) {
              bdla.b(getActivity().app, "dc00898", "", "", "0X800A07B", "0X800A07B", 0, 0, "", "", "", "");
            }
          }
        }
        if (paramInt == 17) {
          str = "0X8009068";
        } else if (paramInt == 18) {
          str = "0X8008A3A";
        } else if (paramInt == 20) {
          str = "0X8009069";
        } else if (paramInt == 19) {
          str = "0X8008A3E";
        }
      }
    }
  }
  
  public void a(Context paramContext, ArrayList<String> paramArrayList)
  {
    a(paramArrayList);
  }
  
  void a(Intent paramIntent)
  {
    paramIntent = null;
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).getString("camera_photo_path", "");
    if (!((String)localObject).equalsIgnoreCase(""))
    {
      aftr.jdField_a_of_type_JavaLangString = (String)localObject;
      paramIntent = Uri.fromFile(new File((String)localObject));
    }
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().remove("camera_photo_path").commit();
    if (paramIntent == null) {
      return;
    }
    paramIntent = bheg.b(BaseApplicationImpl.getApplication(), paramIntent);
    if (paramIntent != null)
    {
      bheg.a(super.getActivity(), paramIntent);
      if (!FileUtils.isPicFile(paramIntent))
      {
        QQToast.a(super.getActivity(), super.getString(2131692348), 0).b(getTitleBarHeight());
        return;
      }
      if (!new File(paramIntent).exists()) {
        QQToast.a(super.getActivity(), getString(2131694681), 0).b(getTitleBarHeight());
      }
    }
    else
    {
      QQToast.a(super.getActivity(), getString(2131694681), 0).b(getTitleBarHeight());
      return;
    }
    localObject = new Intent();
    ArrayList localArrayList = new ArrayList();
    ((Intent)localObject).setClass(super.getActivity(), CameraPreviewActivity.class);
    localArrayList.add(paramIntent);
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TeamWorkDocEditBrowserActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", TeamWorkDocEditBrowserActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    ((Intent)localObject).putExtra(bhcc.h, 55);
    ((Intent)localObject).putExtra("uin", AppConstants.TEAM_WORK_WORD_UIN);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    ((Intent)localObject).putExtra("LASTFROM", this.mSwiftTitleUI.leftView.getText().toString());
    super.getActivity().startActivity((Intent)localObject);
  }
  
  public void a(String paramString)
  {
    if ((this.mSwiftTitleUI.centerView != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_f_of_type_Boolean = true;
      this.mSwiftTitleUI.centerView.setVisibility(0);
      this.mSwiftTitleUI.centerView.setText(paramString);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.mSwiftTitleUI.centerView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      b();
      int i1 = getShare().b();
      boolean bool = getShare().b();
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 1, "setEditTitle policy:" + i1 + ",editable:" + bool);
      }
      if (paramString1 != null)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramString2));
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
        if (!TextUtils.isEmpty(paramString1)) {
          break label129;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    return;
    label129:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  void a(ArrayList<String> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i1);
      f(this).callJs("readyToInsertImageForNativeJSBridge('" + str + "')");
      i1 += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.k = paramBoolean;
    this.jdField_g_of_type_Int = paramInt;
    if (this.mSwiftTitleUI.centerView == null) {}
    for (;;)
    {
      return;
      Drawable localDrawable;
      if ((!paramBoolean) || (paramInt == 0)) {
        if (!paramBoolean) {
          localDrawable = getResources().getDrawable(2130850569);
        }
      }
      while (localDrawable != null)
      {
        this.mSwiftTitleUI.centerView.setCompoundDrawablePadding(AIOUtils.dp2px(6.0F, getResources()));
        this.mSwiftTitleUI.centerView.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
        return;
        if (paramInt == 0)
        {
          localDrawable = getResources().getDrawable(2130850568);
          continue;
          this.mSwiftTitleUI.centerView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
        else
        {
          localDrawable = null;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    String str = getShare().g();
    if ((paramBoolean) && (!TextUtils.isEmpty(str))) {
      a(str);
    }
    do
    {
      do
      {
        return;
      } while (!TextUtils.isEmpty(str));
      if (this.jdField_f_of_type_Boolean)
      {
        this.jdField_f_of_type_Boolean = false;
        d();
      }
    } while (paramBoolean);
    a(paramString1, paramString2);
  }
  
  public void b()
  {
    if (this.mSwiftTitleUI.centerView != null) {
      this.mSwiftTitleUI.centerView.clearFocus();
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.clearFocus();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 2) {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
        this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height;
      }
    }
    for (;;)
    {
      d();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      break;
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height;
      }
    }
  }
  
  public void b(String paramString)
  {
    a(17);
    ThreadManager.executeOnNetWorkThread(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.8(this, paramString));
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent(super.getActivity(), NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 27);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TeamWorkDocEditBrowserActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra(bhcc.h, 55);
    localIntent.putExtra("uin", AppConstants.TEAM_WORK_WORD_UIN);
    localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("LASTFROM", this.mSwiftTitleUI.leftView.getText().toString());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.putExtra("PhotoConst.original_button", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    }
    super.startActivity(localIntent);
    AlbumUtil.anim(super.getActivity(), false, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_Int == 1))
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void c()
  {
    this.jdField_g_of_type_Boolean = true;
  }
  
  public void c(int paramInt)
  {
    this.o = true;
    this.jdField_h_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    if (paramString != null) {
      try
      {
        QLog.d("WebLog_WebViewFragment", 2, paramString);
        JSONObject localJSONObject = new JSONObject(paramString);
        int i1 = localJSONObject.getInt("ret");
        String str = localJSONObject.optString("url");
        localJSONObject.optString("error");
        if (i1 == 0) {
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, str));
        }
        while (QLog.isColorLevel())
        {
          QLog.e("WebLog_WebViewFragment", 2, "handleSaveTempPadResult: " + paramString);
          return;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, str));
          continue;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3));
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WebLog_WebViewFragment", 2, paramString, new Object[0]);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3));
        return;
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.jdField_a_of_type_Int == 2))
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
  }
  
  public void d()
  {
    boolean bool2 = false;
    if ((this.mSwiftTitleUI == null) || (this.mSwiftTitleUI.centerView == null)) {}
    do
    {
      return;
      if (this.mSwiftTitleUI.centerView.isFocused()) {
        this.mSwiftTitleUI.centerView.clearFocus();
      }
      this.mSwiftTitleUI.centerView.setVisibility(0);
      boolean bool1 = bool2;
      if (this.intent.getBooleanExtra("temp_preview_from_qq", false))
      {
        bool1 = bool2;
        if (getCurrentUrl() != null)
        {
          bool1 = bool2;
          if (getCurrentUrl().contains("preview=1")) {
            bool1 = true;
          }
        }
      }
      this.j = bool1;
      if (this.j)
      {
        this.mSwiftTitleUI.centerView.setText(getResources().getString(2131719292));
        return;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        this.mSwiftTitleUI.centerView.setText(2131719290);
        return;
      }
    } while (this.jdField_a_of_type_Int != 1);
    this.mSwiftTitleUI.centerView.setText(2131719290);
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i1 = super.doCreateLoopStep_Final(paramBundle);
    if ((this.jdField_a_of_type_Bebi != null) && (this.jdField_a_of_type_Bebi.a())) {
      this.mSwiftTitleUI.titleContainer.setBackgroundColor(-1);
    }
    if (getIntent().getBooleanExtra("temp_preview_show_loading", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "-->service KEY_TEMP_SHOW_LOADING");
      }
      m();
      ashz.a().a(this.mIpcObserver);
      if (ashz.a().a()) {
        n();
      }
    }
    if (this.mUIStyleHandler.mRootView == null) {
      this.mUIStyleHandler.mRootView = ((ViewGroup)super.getActivity().findViewById(2131363780));
    }
    this.mUIStyleHandler.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    LayoutInflater.from(super.getActivity()).inflate(2131562936, this.mUIStyleHandler.mRootView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin = AppConstants.TEAM_WORK_WORD_UIN;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType = 7119;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.getActivity().findViewById(2131378528));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.getActivity().findViewById(2131372822));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.getActivity().findViewById(2131377643));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.getActivity().findViewById(2131368204));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = ((InputLinearLayout)super.getActivity().findViewById(2131378550));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.getActivity().findViewById(2131378549));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(1);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new afac(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.getActivity().findViewById(2131378551));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.jdField_a_of_type_Int == 1)
    {
      super.getWebView().requestFocus();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height;
    }
    while (this.jdField_a_of_type_Int != 2)
    {
      o();
      return i1;
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height;
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
  }
  
  public int doCreateLoopStep_InitUIFrame(Bundle paramBundle)
  {
    int i1 = super.doCreateLoopStep_InitUIFrame(paramBundle);
    if (this.mSwiftTitleUI.leftView != null) {
      this.mSwiftTitleUI.leftView.setText(getResources().getString(2131690676));
    }
    if (this.mSwiftTitleUI.rightViewImg != null) {
      this.mSwiftTitleUI.rightViewImg.setVisibility(8);
    }
    if ((getIntent().hasExtra("temp_preview_show_loading")) && ((this.mUIStyleHandler.mRootView instanceof RelativeLayout)))
    {
      this.jdField_a_of_type_Bebi = new bebi((RelativeLayout)this.mUIStyleHandler.mRootView, getActivity(), this.browserApp);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Bebi.a(paramBundle);
      if (a(null)) {
        beeg.a(null, "0X800A752");
      }
    }
    return i1;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        a(paramIntent);
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      localObject = paramIntent.getExtras();
      paramIntent = ((Bundle)localObject).getString("uin");
      paramInt1 = ((Bundle)localObject).getInt("uintype", 0);
    } while ((this.share.a() == null) || ((this.share.a().jdField_a_of_type_Int != 0) && (this.share.a().jdField_a_of_type_Int != 1)));
    Object localObject = new ArrayList(1);
    ((List)localObject).add(paramIntent);
    ThreadManager.excute(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.13(this, paramInt1, (List)localObject), 128, null, false);
  }
  
  public void doOnBackEvent()
  {
    if (this.m)
    {
      this.m = false;
      ThreadManager.excute(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.10(this), 16, null, true);
    }
    label140:
    for (;;)
    {
      return;
      if (this.webView == null)
      {
        super.doOnBackEvent();
        return;
      }
      if (this.webView.canGoBack())
      {
        HashMap localHashMap = new HashMap(1);
        localHashMap.put("target", Integer.valueOf(2));
        if (this.webView.goBack(localHashMap)) {
          reset();
        }
      }
      for (;;)
      {
        if (this.mSwiftTitleUI == null) {
          break label140;
        }
        this.mSwiftTitleUI.mUIStyle.isScreenLandscape = false;
        this.mSwiftTitleUI.mUIStyle.mIsPortraitOnly = Boolean.valueOf(true);
        if (this.mUIStyleHandler == null) {
          break;
        }
        this.mUIStyleHandler.updateScreenOrientation();
        return;
        super.doOnBackEvent();
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setRulesFromUrl(8980L);
    if (this.mSwiftTitleUI.centerView != null) {
      this.mSwiftTitleUI.centerView.clearFocus();
    }
    this.jdField_a_of_type_Bkys = new bkys(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidOsHandler = new bkys(Looper.getMainLooper(), this.jdField_b_of_type_AndroidOsHandler$Callback);
    getIntent().getExtras().setClassLoader(getClass().getClassLoader());
    g();
    return true;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_Bkys != null)
    {
      Message localMessage = this.jdField_a_of_type_Bkys.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramIntent;
      this.jdField_a_of_type_Bkys.sendMessage(localMessage);
    }
  }
  
  public void e()
  {
    if (!isFullScreen())
    {
      super.getActivity().getWindow().setFlags(1024, 1024);
      this.mUIStyle.isFullScreen = true;
      hideVirtualNavBar();
      doShowTitleBar(false);
    }
  }
  
  public void f()
  {
    if (isFullScreen())
    {
      super.getActivity().getWindow().clearFlags(1024);
      this.mUIStyle.isFullScreen = false;
      showVirtualNavBar();
      doShowTitleBar(true);
    }
  }
  
  void g()
  {
    String str = super.getCurrentUrl();
    if (str != null)
    {
      Object localObject = str.split("/");
      if (localObject != null) {
        this.jdField_a_of_type_JavaLangString = localObject[(localObject.length - 1)];
      }
      localObject = Uri.parse(str).getQueryParameter("type");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isDigitsOnly((CharSequence)localObject))) {
        this.jdField_a_of_type_Int = Integer.valueOf((String)localObject).intValue();
      }
    }
    if (this.mApp == null) {
      this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    }
    this.jdField_b_of_type_JavaLangString = this.mApp.getCurrentAccountUin();
    if (!TextUtils.isEmpty(str))
    {
      if (!str.contains("docx.qq.com")) {
        break label184;
      }
      this.jdField_c_of_type_JavaLangString = ("https://" + this.mApp.getCurrentAccountUin() + ".docx.qq.com/ep/api/attach_local?tag=" + this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.i = getActivity().getIntent().getBooleanExtra("doc_from_forward_dialog", false);
      return;
      label184:
      if (str.contains("docs.qq.com")) {
        this.jdField_c_of_type_JavaLangString = ("https://" + this.mApp.getCurrentAccountUin() + ".docs.qq.com/ep/api/attach_local?tag=" + this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Bebi != null) && (this.jdField_a_of_type_Bebi.a())) {}
    do
    {
      return;
      if ((!this.j) && (!this.mUIStyle.hideMore)) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    } while (!this.i);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void i()
  {
    this.mSwiftTitleUI.rightViewImg.setImageResource(2130850570);
    this.mSwiftTitleUI.rightViewImg.setOnClickListener(new afae(this));
  }
  
  public void initNativeMiniAIOUser()
  {
    boolean bool = this.intent.getBooleanExtra("doc_from_aio", false);
    String str1 = this.intent.getStringExtra("doc_from_aio_uin");
    int i1 = this.intent.getIntExtra("doc_from_aio_peertype", -1);
    String str2 = this.intent.getStringExtra("doc_from_aio_nickname");
    if ((bool) && (!TextUtils.isEmpty(str1)) && (i1 != -1))
    {
      if (this.mMiniMsgUser == null)
      {
        this.mMiniMsgUser = new becg(getActivity(), getMiniMsgUserParam(), str1, i1, str2);
        this.mMiniMsgUser.onForeground();
      }
      this.mSwiftTitleUI.getMiniViewLayout().setVisibility(0);
      return;
    }
    this.mSwiftTitleUI.getMiniViewLayout().setVisibility(8);
  }
  
  public void initWebView()
  {
    int i1 = -1;
    long l1;
    long l2;
    if (this.webView == null)
    {
      this.webView = a(null).a();
      this.webView.getView().setOnTouchListener(this);
      this.webView.setOnLongClickListener(new afai(this));
      l1 = System.currentTimeMillis();
      if ((this.mUIStyle.mRulesFromUrl & 0x10000) == 0L) {
        break label434;
      }
      i1 = 2;
      if (AppSetting.jdField_f_of_type_Boolean) {
        i1 = 2;
      }
      this.webView.getSettings().setCacheMode(i1);
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "setCacheMode=" + i1);
      }
      this.webView.getSettings().setAllowFileAccessFromFileURLs(false);
      this.webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
      l2 = System.currentTimeMillis();
      this.mStatistics.n = (l2 - l1);
      this.mStatistics.R = l2;
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init browser, cost = " + this.mStatistics.n);
      }
      l2 = System.currentTimeMillis();
      IX5WebViewExtension localIX5WebViewExtension = this.webView.getX5WebViewExtension();
      if (localIX5WebViewExtension == null) {
        break label489;
      }
      i1 = 1;
      label228:
      if (i1 == 0) {
        break label518;
      }
      Bundle localBundle = biit.a();
      if (localBundle != null) {
        localIX5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
      }
      if (!this.mStatistics.w) {
        break label494;
      }
      l1 = 2L;
      if (!(this.webView instanceof SwiftReuseTouchWebView)) {
        break label542;
      }
      if (1 != ((SwiftReuseTouchWebView)this.webView).jdField_b_of_type_Int) {
        break label513;
      }
      i1 = 1;
    }
    for (;;)
    {
      label295:
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", new Object[] { Long.valueOf(l1), Integer.valueOf(i1), Long.valueOf(biis.a) }));
      }
      System.currentTimeMillis();
      this.webView.reportInitPerformance(l1, i1, this.mStatistics.jdField_c_of_type_Long, biis.a);
      System.currentTimeMillis();
      this.mStatistics.e = 2;
      label513:
      label518:
      for (this.mStatistics.g = String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication()));; this.mStatistics.g = String.valueOf(Build.VERSION.SDK_INT))
      {
        l1 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("WebLog_WebViewFragment", 2, "setDomainsAndArgumentForImageRequest, cost=" + (l1 - l2));
        }
        return;
        label434:
        switch (this.intent.getIntExtra("reqType", -1))
        {
        case 2: 
        case 3: 
        default: 
          break;
        case 1: 
          i1 = 2;
          break;
        case 4: 
          i1 = 0;
          break;
          label489:
          i1 = 0;
          break label228;
          label494:
          if (bihv.s) {}
          for (i1 = 1;; i1 = 0)
          {
            l1 = i1;
            break;
          }
          i1 = 0;
          break label295;
          this.mStatistics.e = 1;
        }
      }
      label542:
      i1 = 0;
    }
  }
  
  public void j()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      Object localObject = new StateListDrawable();
      Drawable localDrawable = getResources().getDrawable(2130850650);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
      localDrawable = getResources().getDrawable(2130850649);
      ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
      localDrawable = getResources().getDrawable(2130850650);
      ((StateListDrawable)localObject).addState(new int[0], localDrawable);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
      localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(16.0F, getResources());
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (biho)this.mComponentsProvider.a(4);
      ((biho)localObject).a(true);
      ((biho)localObject).jdField_b_of_type_Boolean = true;
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new afah(this));
    }
  }
  
  void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
    }
    bihv localbihv = this.mStatistics;
    this.isDestroyed = true;
    localbihv.l = true;
    if (this.jdField_a_of_type_Bedb != null)
    {
      this.jdField_a_of_type_Bedb.a();
      this.jdField_a_of_type_Bedb = null;
      this.webView = null;
    }
    this.mApp = null;
  }
  
  public void l()
  {
    if (lka.b(BaseApplicationImpl.getContext())) {
      return;
    }
    Object localObject1 = super.getActivity();
    Object localObject2 = new File(AppConstants.SDCARD_PATH + "photo/");
    if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs()))
    {
      QQToast.a((Context)localObject1, 2131718340, 0).a();
      return;
    }
    localObject1 = AppConstants.SDCARD_PATH + "photo/" + System.currentTimeMillis() + ".jpg";
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().putString("camera_photo_path", (String)localObject1).commit();
    localObject2 = new Intent();
    FileProvider7Helper.setSystemCapture(super.getActivity(), new File((String)localObject1), (Intent)localObject2);
    super.getActivity().startActivityForResult((Intent)localObject2, 5);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131369231) {
      super.onClick(paramView);
    }
    int i1 = paramView.getId();
    Object localObject1 = (InputMethodManager)super.getActivity().getSystemService("input_method");
    switch (i1)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_f_of_type_Int == 1) && (this.jdField_g_of_type_Boolean))
      {
        a(15);
        localObject1 = (bkzi)bkzz.a(getActivity(), null);
        ((bkzi)localObject1).a(getResources().getString(2131719286));
        ((bkzi)localObject1).a(getResources().getString(2131719284), 5);
        ((bkzi)localObject1).a(getResources().getString(2131719234), 5);
        ((bkzi)localObject1).c(2131690697);
        ((bkzi)localObject1).a(new afaa(this, (bkzi)localObject1));
        ((bkzi)localObject1).show();
      }
      else if ((this.jdField_f_of_type_Int == 2) && (this.jdField_g_of_type_Boolean))
      {
        a(15);
        d(2);
        getActivity().finish();
      }
      else if ((this.jdField_f_of_type_Int == 3) && (this.jdField_g_of_type_Boolean))
      {
        a(15);
        d(3);
        getActivity().finish();
      }
      else
      {
        if ((this.share != null) && (this.n) && (this.share.c()) && (getIntent().getBooleanExtra("key_is_new_pad_flag", false)))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("savedUrl", getCurrentUrl());
          localObject2 = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
          if (localObject2 != null)
          {
            if (this.share.b() != null) {
              break label411;
            }
            ((TeamWorkFileImportInfo)localObject2).jdField_b_of_type_JavaLangString = "";
            label361:
            if (((TeamWorkFileImportInfo)localObject2).e != 3) {
              break label426;
            }
            ((Bundle)localObject1).putInt("editType", 1);
          }
        }
        for (;;)
        {
          ((Bundle)localObject1).putParcelable("key_team_work_file_import_info", (Parcelable)localObject2);
          localObject1 = asdd.a("ipc_save_team_work", "", -1, (Bundle)localObject1);
          ashz.a().a((Bundle)localObject1);
          doOnBackEvent();
          break;
          label411:
          ((TeamWorkFileImportInfo)localObject2).jdField_b_of_type_JavaLangString = this.share.b();
          break label361;
          label426:
          if (((TeamWorkFileImportInfo)localObject2).e == 6) {
            ((Bundle)localObject1).putInt("editType", 2);
          }
        }
        if (localObject1 != null) {
          ((InputMethodManager)localObject1).hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
        }
        b(this).clearFocus();
        if (this.jdField_a_of_type_Bkys != null)
        {
          localObject1 = this.jdField_a_of_type_Bkys.obtainMessage();
          ((Message)localObject1).what = 2;
          this.jdField_a_of_type_Bkys.sendMessageDelayed((Message)localObject1, 500L);
        }
        b(false);
        continue;
        ((InputMethodManager)localObject1).hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
        c(this).clearFocus();
        if (this.jdField_a_of_type_Bkys != null)
        {
          localObject1 = this.jdField_a_of_type_Bkys.obtainMessage();
          ((Message)localObject1).what = 3;
          this.jdField_a_of_type_Bkys.sendMessageDelayed((Message)localObject1, 500L);
        }
        b(false);
        continue;
        ((InputMethodManager)localObject1).hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
        d(this).clearFocus();
        continue;
        Object localObject2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("value", localObject2);
          localObject2 = localJSONObject.toString();
          e(this).callJs("setCellValue(" + (String)localObject2 + ")");
          ((InputMethodManager)localObject1).hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
        }
        catch (JSONException localJSONException) {}
        if (QLog.isDevelopLevel()) {
          QLog.d("WebLog_WebViewFragment", 4, localJSONException, new Object[0]);
        }
      }
    }
  }
  
  @TargetApi(16)
  public void onDestroy()
  {
    p();
    becr.a(getIntent(), "0X800A16C");
    super.onDestroy();
    k();
    if (this.jdField_a_of_type_Bebi != null) {
      this.jdField_a_of_type_Bebi.a();
    }
    if (this.jdField_a_of_type_Bkys != null)
    {
      this.jdField_a_of_type_Bkys.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bkys.removeMessages(0);
      this.jdField_a_of_type_Bkys = null;
    }
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.mRootView != null) && (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null))
    {
      if (Build.VERSION.SDK_INT >= 16) {
        break label133;
      }
      this.mUIStyleHandler.mRootView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      if (this.jdField_a_of_type_Aqcx != null) {
        this.jdField_a_of_type_Aqcx.b();
      }
      return;
      label133:
      this.mUIStyleHandler.mRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((Build.VERSION.SDK_INT >= 19) && (!this.isDestroyed) && (this.jdField_a_of_type_Bedb != null) && (this.jdField_a_of_type_Bedb.a() != null)) {
      onReceivedTitle(paramWebView, paramWebView.getTitle());
    }
    super.getWebView().callJs("setDocxShareInfo", new String[] { "" });
    if (this.mSwiftTitleUI.centerView != null) {
      this.mSwiftTitleUI.centerView.clearFocus();
    }
    if (this.jdField_a_of_type_Int == 1) {
      super.getWebView().requestFocus();
    }
    if ((this.jdField_a_of_type_Bebi != null) && (this.jdField_a_of_type_Bebi.a()))
    {
      this.jdField_a_of_type_Bebi.b();
      o();
      if (this.jdField_g_of_type_Int != -1000)
      {
        a(this.k, this.jdField_g_of_type_Int);
        h();
      }
      paramWebView = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
      if (a(paramWebView))
      {
        beeg.a(null, "0X800A754");
        bdla.b(null, "dc00898", "", "", "0X800A756", "0X800A756", 0, 0, "", "", String.valueOf(SystemClock.elapsedRealtime() - paramWebView.jdField_c_of_type_Long), "");
      }
    }
    if ((paramString != null) && ((paramString.contains("/template")) || (paramString.contains("desktop/m/templates_list.html")) || (paramString.contains("docs.qq.com/desktop/m/send.html"))))
    {
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.mSwiftTitleUI.rightViewImg != null) {
        this.mSwiftTitleUI.rightViewImg.setVisibility(8);
      }
    }
    if ((this.i) && (this.jdField_d_of_type_AndroidWidgetImageView != null)) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.o)
    {
      this.o = false;
      this.share.a(1, this.jdField_h_of_type_Int, 1, true);
    }
  }
  
  public void onStop()
  {
    if (super.getWebView() != null) {
      super.getWebView().clearFocus();
    }
    super.onStop();
  }
  
  public void reset()
  {
    super.reset();
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.mSwiftTitleUI.centerView.setText("");
  }
  
  public void setMiniAIOEntry(boolean paramBoolean)
  {
    if ((this.mSwiftTitleUI.getMiniViewLayout() != null) && (this.intent != null))
    {
      paramBoolean = this.intent.getBooleanExtra("doc_from_aio", false);
      String str = this.intent.getStringExtra("doc_from_aio_uin");
      int i1 = this.intent.getIntExtra("doc_from_aio_peertype", -1);
      if ((paramBoolean) && (!TextUtils.isEmpty(str)) && (i1 != -1))
      {
        this.mSwiftTitleUI.getMiniViewLayout().setVisibility(0);
        initNativeMiniAIOUser();
        a(i1, str, (ImageView)this.mSwiftTitleUI.getMiniViewLayout().findViewById(2131371343));
        return;
      }
    }
    this.mSwiftTitleUI.getMiniViewLayout().setVisibility(8);
  }
  
  public void showActionSheet()
  {
    biho localbiho = (biho)this.mComponentsProvider.a(4);
    if (localbiho != null)
    {
      aasr localaasr = ensureShare();
      if ((localaasr != null) && (becr.a(localaasr.a())))
      {
        getHostActivity().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
        beco localbeco = new beco(getHostActivity());
        localbeco.a((TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info"));
        localbiho.a = localbeco;
      }
      localbiho.a(localaasr, this.mUIStyle.mRulesFromUrl);
      becr.a(getIntent(), "0X800A16D");
    }
  }
  
  public void startLoadUrl()
  {
    nwo.a("Web_readyToLoadUrl");
    if (this.webView == null) {
      return;
    }
    initFinish();
    if ((this.mStatistics.i) && (this.mStatistics.k > 0L))
    {
      bdla.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.mStatistics.k) / 1000000L), "", "", "", "" + this.mStatistics.jdField_c_of_type_Int);
      this.mStatistics.k = 0L;
    }
    this.mStatistics.q = System.currentTimeMillis();
    long l1 = this.mStatistics.q;
    l1 = this.mStatistics.b;
    if (!TextUtils.isEmpty(this.mUrl))
    {
      if ((arof.a().a()) && (!TextUtils.isEmpty(becx.jdField_a_of_type_JavaLangString)) && (this.mUrl.contains(becx.jdField_a_of_type_JavaLangString))) {
        break label221;
      }
      this.webView.loadUrl(this.mUrl);
    }
    for (;;)
    {
      nwo.b("Web_readyToLoadUrl");
      this.mStatistics.a(this.webView, this.mUrl, 0, 0, 0, 0, 0, null);
      return;
      label221:
      if (this.jdField_a_of_type_Bedb.jdField_a_of_type_Boolean) {
        becy.a(becb.a(this.mUrl), this.webView);
      } else {
        this.webView.loadUrl(this.mUrl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment
 * JD-Core Version:    0.7.0.1
 */