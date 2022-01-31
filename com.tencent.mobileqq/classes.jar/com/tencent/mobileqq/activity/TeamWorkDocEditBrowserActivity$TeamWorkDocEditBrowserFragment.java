package com.tencent.mobileqq.activity;

import abuc;
import abud;
import abue;
import abuf;
import abug;
import abuh;
import abui;
import abuj;
import abuk;
import abul;
import abum;
import aciy;
import ajed;
import ajjy;
import alis;
import amlg;
import amlh;
import amme;
import ammf;
import anad;
import anah;
import android.annotation.TargetApi;
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
import anfc;
import awqx;
import axdv;
import axej;
import axfb;
import axfg;
import axfo;
import axfs;
import axfy;
import axfz;
import axgc;
import axhg;
import baae;
import baaf;
import bace;
import bacm;
import bazb;
import bbaq;
import bbbt;
import bbca;
import bbcj;
import bbcm;
import bbdb;
import bbdc;
import bbmy;
import befq;
import begr;
import behe;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kzy;
import mpl;
import mpw;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import xdt;

public class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
  extends WebViewFragment
{
  private boolean A;
  private boolean B;
  public int a;
  private alis jdField_a_of_type_Alis;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new abuc(this);
  Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new abud(this);
  public Button a;
  public EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private axej jdField_a_of_type_Axej;
  private axgc jdField_a_of_type_Axgc;
  befq jdField_a_of_type_Befq;
  public InputLinearLayout a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  String jdField_a_of_type_JavaLangString = "";
  public boolean a;
  public int b;
  Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new abuf(this);
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
  boolean f = false;
  boolean g = false;
  private int p = -1;
  private int q = -1000;
  private int r;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y = true;
  private boolean z;
  
  public TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
  }
  
  private void J()
  {
    this.jdField_a_of_type_Anad = new abuh(this);
  }
  
  private void K()
  {
    Bundle localBundle = new Bundle();
    if (a().getParcelableExtra("key_team_work_file_import_info") != null) {
      localBundle.putParcelable("key_team_work_file_import_info", a().getParcelableExtra("key_team_work_file_import_info"));
    }
    localBundle = anah.a("ipc_cmd_get_team_work_url", "", this.jdField_a_of_type_Anad.key, localBundle);
    anfc.a().a(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->service binded  make ipc request");
    }
    this.y = true;
  }
  
  private void L()
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_Bbcj.jdField_a_of_type_Bbcm.jdField_a_of_type_Boolean)
    {
      QLog.e("WebLog_WebViewFragment", 1, "isFullScreen");
      if (a().getStringExtra("url") != null)
      {
        localObject2 = new StringBuilder().append("isFullScreen url: ").append(a().getStringExtra("url")).append(" mRulesFromUrl fullScreen ");
        if ((this.jdField_a_of_type_Bbcm.jdField_a_of_type_Long & 0x20000) <= 0L) {
          break label523;
        }
        localObject1 = "true";
        QLog.e("WebLog_WebViewFragment", 1, (String)localObject1);
      }
    }
    boolean bool;
    if (this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject1 = a();
      localObject2 = getResources().getColorStateList(2131101255);
      this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject2);
      this.jdField_a_of_type_Bazb.c.setTextColor((ColorStateList)localObject2);
      this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130839699);
      if ((this.jdField_a_of_type_Axej == null) || (!this.jdField_a_of_type_Axej.a())) {
        this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(Color.parseColor("#f6f7f9"));
      }
      this.jdField_a_of_type_Bazb.b.setTextSize(18.0F);
      this.jdField_a_of_type_Bazb.b.setTextColor(Color.parseColor("#333333"));
      this.jdField_a_of_type_Bazb.b.setMaxEms(13);
      this.jdField_a_of_type_Bazb.b.getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302850));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(13);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302821));
      this.jdField_d_of_type_Int = ((Intent)localObject1).getIntExtra("key_team_work_pad_list_type", -1);
      if ((!((Intent)localObject1).getBooleanExtra("temp_preview_from_qq", false)) || (b() == null) || (!b().contains("preview=1"))) {
        break label530;
      }
      bool = true;
      label372:
      this.w = bool;
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "getShareUrl:" + e() + "  tempPreviewFromQQ:" + this.w);
      }
      if (!this.w) {
        break label671;
      }
      localObject1 = (TeamWorkFileImportInfo)a().getParcelableExtra("key_team_work_file_import_info");
      if ((this.jdField_a_of_type_Int == 0) && (localObject1 != null))
      {
        if (((TeamWorkFileImportInfo)localObject1).e != 3) {
          break label535;
        }
        this.jdField_a_of_type_Int = 1;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Axej == null) || (!this.jdField_a_of_type_Axej.a())) {
        break label552;
      }
      this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Bazb.c.setVisibility(8);
      this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      label523:
      localObject1 = "false";
      break;
      label530:
      bool = false;
      break label372;
      label535:
      if (((TeamWorkFileImportInfo)localObject1).e == 6) {
        this.jdField_a_of_type_Int = 2;
      }
    }
    label552:
    this.jdField_a_of_type_Bazb.c.setVisibility(0);
    this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    r();
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_Bazb.c.setVisibility(0);
    this.jdField_a_of_type_Bazb.c.setText(ajjy.a(2131648960));
    this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131648980));
    this.p = 1;
    this.jdField_a_of_type_Bazb.c.setOnClickListener(new abuj(this));
    for (;;)
    {
      e(true);
      return;
      label671:
      if (((Intent)localObject1).getBooleanExtra("temp_preview_from_qq", false))
      {
        this.p = 3;
        r();
      }
      else
      {
        r();
      }
    }
  }
  
  private void M()
  {
    axfs.a((TeamWorkFileImportInfo)a().getParcelableExtra("key_team_work_file_import_info"), b(), "0X8009F33");
    N();
  }
  
  private void N()
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = (TeamWorkFileImportInfo)a().getParcelableExtra("key_team_work_file_import_info");
    if (a(localTeamWorkFileImportInfo))
    {
      axhg.a(null, "0X800A753");
      awqx.b(null, "dc00898", "", "", "0X800A757", "0X800A757", 0, 0, "", "", String.valueOf(SystemClock.elapsedRealtime() - localTeamWorkFileImportInfo.jdField_c_of_type_Long), "");
    }
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
        this.jdField_a_of_type_Alis = new alis(a(), paramInt);
      }
      if (this.jdField_a_of_type_Alis == null) {
        break;
      }
      this.jdField_a_of_type_Alis.a();
      this.jdField_a_of_type_Alis.a(new abuk(this, paramImageView));
      this.jdField_a_of_type_Alis.a(paramString, true);
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
      paramTeamWorkFileImportInfo = (TeamWorkFileImportInfo)a().getParcelableExtra("key_team_work_file_import_info");
    }
    for (;;)
    {
      return (paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 12);
    }
  }
  
  private void e(String paramString)
  {
    if (mpl.a(paramString)) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramString);
    }
    this.w = false;
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_Bazb.c.setOnClickListener(null);
    this.jdField_a_of_type_Bazb.c.setVisibility(8);
    this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130839699);
    this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView.setText(2131624770);
    this.p = 2;
    k();
    p();
    this.g = false;
    this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.v) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void f(int paramInt)
  {
    if (getActivity() == null) {
      return;
    }
    String str1;
    String str2;
    Object localObject2;
    SharedPreferences localSharedPreferences;
    int i;
    switch (paramInt)
    {
    default: 
      str1 = "key_team_work_user_click_count";
      paramInt = amlh.a().c();
      str2 = amlh.a().b();
      localObject2 = amlh.a().c();
      localObject1 = ajjy.a(2131649014);
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("tim_convert_teamwork_pre_" + getActivity().getCurrentAccountUin(), 4);
      i = localSharedPreferences.getInt(str1, 0);
      if (i >= paramInt) {
        break label400;
      }
      if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty((CharSequence)localObject2))) {
        break;
      }
    }
    for (Object localObject1 = getResources().getString(2131654263);; localObject1 = str2 + "\n" + (String)localObject2)
    {
      localObject2 = new Intent(getActivity(), DialogActivity.class);
      ((Intent)localObject2).addFlags(268435456);
      ((Intent)localObject2).addFlags(536870912);
      ((Intent)localObject2).addFlags(67108864);
      ((Intent)localObject2).addFlags(131072);
      ((Intent)localObject2).putExtra("key_dialog_type", DialogActivity.jdField_d_of_type_Int);
      ((Intent)localObject2).putExtra("key_dialog_title", ajjy.a(2131648953));
      ((Intent)localObject2).putExtra("key_dialog_content", (String)localObject1);
      ((Intent)localObject2).putExtra("key_teamwork_url", i());
      getActivity().startActivity((Intent)localObject2);
      a(20);
      localObject1 = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject1).putInt(str1, i + 1);
      ((SharedPreferences.Editor)localObject1).commit();
      return;
      str1 = "key_team_work_user_click_count";
      paramInt = amlh.a().c();
      str2 = amlh.a().d();
      localObject2 = amlh.a().e();
      localObject1 = ajjy.a(2131648965);
      break;
      str1 = "key_team_work_content_edit_click_count";
      paramInt = amlh.a().d();
      str2 = amlh.a().f();
      localObject2 = amlh.a().g();
      localObject1 = ajjy.a(2131648964);
      break;
    }
    label400:
    bbmy.a(getActivity(), (CharSequence)localObject1, 0).b(getActivity().getResources().getDimensionPixelSize(2131167766));
  }
  
  private String i()
  {
    String str2 = getWebView().getUrl();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      int i = str2.indexOf("&preview=1");
      str1 = str2;
      if (i >= 0) {
        str1 = str2.substring(0, i - 1);
      }
    }
    return str1;
  }
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if ((this.jdField_a_of_type_Axej != null) && (this.jdField_a_of_type_Axej.a())) {
      this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
    }
    if (a().getBooleanExtra("temp_preview_show_loading", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "-->service KEY_TEMP_SHOW_LOADING");
      }
      J();
      anfc.a().a(this.jdField_a_of_type_Anad);
      if (anfc.a().a()) {
        K();
      }
    }
    if (this.jdField_a_of_type_Bbcj.d == null) {
      this.jdField_a_of_type_Bbcj.d = ((ViewGroup)super.getActivity().findViewById(2131297873));
    }
    this.jdField_a_of_type_Bbcj.d.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    LayoutInflater.from(super.getActivity()).inflate(2131496892, this.jdField_a_of_type_Bbcj.d);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = ajed.U;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 7119;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.getActivity().findViewById(2131311094));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.getActivity().findViewById(2131305946));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.getActivity().findViewById(2131310298));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.getActivity().findViewById(2131301902));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = ((InputLinearLayout)super.getActivity().findViewById(2131311114));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.getActivity().findViewById(2131311113));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(1);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new abug(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.getActivity().findViewById(2131311115));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.jdField_a_of_type_Int == 1)
    {
      super.getWebView().requestFocus();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height;
    }
    while (this.jdField_a_of_type_Int != 2)
    {
      L();
      return i;
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
  
  public axgc a(ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_Bbcm.b & 0x40) != 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Axgc = new axgc(this.jdField_a_of_type_ComTencentCommonAppAppInterface, super.getActivity(), this, this.jdField_a_of_type_AndroidContentIntent, bool1);
      this.jdField_a_of_type_Axgc.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
      TouchWebView localTouchWebView = this.jdField_a_of_type_Axgc.a();
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.bindWebView(localTouchWebView);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(localTouchWebView);
      localTouchWebView.setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine);
      if ((localTouchWebView instanceof SwiftReuseTouchWebView))
      {
        bbca localbbca = this.jdField_a_of_type_Bbca;
        bool1 = bool2;
        if (1 == ((SwiftReuseTouchWebView)localTouchWebView).jdField_a_of_type_Int) {
          bool1 = true;
        }
        localbbca.u = bool1;
      }
      if (localTouchWebView.getX5WebViewExtension() != null) {
        this.e = true;
      }
      localTouchWebView.getView().setOnTouchListener(this);
      if (this.jdField_h_of_type_Boolean) {
        localTouchWebView.setMask(true);
      }
      if (paramViewGroup != null) {
        paramViewGroup.addView(localTouchWebView);
      }
      return this.jdField_a_of_type_Axgc;
    }
  }
  
  public void a(int paramInt)
  {
    String str = "";
    int i = a().getIntExtra("tdsourcetab", -1);
    if (paramInt == 0) {
      if (i == 3)
      {
        awqx.b(getActivity().app, "dc00898", "", "", "0X800A074", "0X800A074", 0, 0, "", "", "", "");
        str = "0X80074D2";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        awqx.b(getActivity().app, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if (i != 20) {
        break;
      }
      awqx.b(getActivity().app, "dc00898", "", "", "0X800A07C", "0X800A07C", 0, 0, "", "", "", "");
      break;
      if (paramInt == 1)
      {
        if (i == 3) {
          awqx.b(getActivity().app, "dc00898", "", "", "0X800A075", "0X800A075", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          str = "0X80074D3";
          break;
          if (i == 20) {
            awqx.b(getActivity().app, "dc00898", "", "", "0X800A07D", "0X800A07D", 0, 0, "", "", "", "");
          }
        }
      }
      if (paramInt == 2)
      {
        if (i == 3) {
          awqx.b(getActivity().app, "dc00898", "", "", "0X800A076", "0X800A076", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          str = "0X80074D4";
          break;
          if (i == 20) {
            awqx.b(getActivity().app, "dc00898", "", "", "0X800A07E", "0X800A07E", 0, 0, "", "", "", "");
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
          if (i == 3) {
            awqx.b(getActivity().app, "dc00898", "", "", "0X800A073", "0X800A073", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            str = "0X8008A3B";
            break;
            if (i == 20) {
              awqx.b(getActivity().app, "dc00898", "", "", "0X800A07B", "0X800A07B", 0, 0, "", "", "", "");
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
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
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
        b(paramIntent);
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      localObject = paramIntent.getExtras();
      paramIntent = ((Bundle)localObject).getString("uin");
      paramInt1 = ((Bundle)localObject).getInt("uintype", 0);
    } while ((this.jdField_a_of_type_Xdt.a() == null) || ((this.jdField_a_of_type_Xdt.a().jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Xdt.a().jdField_a_of_type_Int != 1)));
    Object localObject = new ArrayList(1);
    ((List)localObject).add(paramIntent);
    ThreadManager.excute(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.13(this, paramInt1, (List)localObject), 128, null, false);
  }
  
  public void a(Context paramContext, ArrayList<String> paramArrayList)
  {
    a(paramArrayList);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.jdField_a_of_type_Befq != null)
    {
      Message localMessage = this.jdField_a_of_type_Befq.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramIntent;
      this.jdField_a_of_type_Befq.sendMessage(localMessage);
    }
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    if ((Build.VERSION.SDK_INT >= 19) && (!this.i) && (this.jdField_a_of_type_Axgc != null) && (this.jdField_a_of_type_Axgc.a() != null)) {
      b(paramWebView, paramWebView.getTitle());
    }
    super.getWebView().callJs("setDocxShareInfo", new String[] { "" });
    if (this.jdField_a_of_type_Bazb.b != null) {
      this.jdField_a_of_type_Bazb.b.clearFocus();
    }
    if (this.jdField_a_of_type_Int == 1) {
      super.getWebView().requestFocus();
    }
    if ((this.jdField_a_of_type_Axej != null) && (this.jdField_a_of_type_Axej.a()))
    {
      this.jdField_a_of_type_Axej.b();
      L();
      if (this.q != -1000)
      {
        a(this.x, this.q);
        o();
      }
      paramWebView = (TeamWorkFileImportInfo)a().getParcelableExtra("key_team_work_file_import_info");
      if (a(paramWebView))
      {
        axhg.a(null, "0X800A754");
        awqx.b(null, "dc00898", "", "", "0X800A756", "0X800A756", 0, 0, "", "", String.valueOf(SystemClock.elapsedRealtime() - paramWebView.jdField_c_of_type_Long), "");
      }
    }
    if ((paramString != null) && ((paramString.contains("/template")) || (paramString.contains("desktop/m/templates_list.html")) || (paramString.contains("docs.qq.com/desktop/m/send.html"))))
    {
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    if ((this.v) && (this.jdField_d_of_type_AndroidWidgetImageView != null)) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Bazb.b != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.f = true;
      this.jdField_a_of_type_Bazb.b.setVisibility(0);
      this.jdField_a_of_type_Bazb.b.setText(paramString);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Bazb.b != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      i();
      int i = a().b();
      boolean bool = a().b();
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 1, "setEditTitle policy:" + i + ",editable:" + bool);
      }
      if (paramString1 != null)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramString2));
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
        if (!TextUtils.isEmpty(paramString1)) {
          break label128;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    return;
    label128:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  void a(ArrayList<String> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      f(this).callJs("readyToInsertImageForNativeJSBridge('" + str + "')");
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.x = paramBoolean;
    this.q = paramInt;
    if (this.jdField_a_of_type_Bazb.b == null) {}
    for (;;)
    {
      return;
      Drawable localDrawable;
      if ((!paramBoolean) || (paramInt == 0)) {
        if (!paramBoolean) {
          localDrawable = getResources().getDrawable(2130849177);
        }
      }
      while (localDrawable != null)
      {
        this.jdField_a_of_type_Bazb.b.setCompoundDrawablePadding(aciy.a(6.0F, getResources()));
        this.jdField_a_of_type_Bazb.b.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
        return;
        if (paramInt == 0)
        {
          localDrawable = getResources().getDrawable(2130849176);
          continue;
          this.jdField_a_of_type_Bazb.b.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
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
    String str = a().g();
    if ((paramBoolean) && (!TextUtils.isEmpty(str))) {
      a(str);
    }
    do
    {
      do
      {
        return;
      } while (!TextUtils.isEmpty(str));
      if (this.f)
      {
        this.f = false;
        k();
      }
    } while (paramBoolean);
    a(paramString1, paramString2);
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    a(8980L);
    if (this.jdField_a_of_type_Bazb.b != null) {
      this.jdField_a_of_type_Bazb.b.clearFocus();
    }
    this.jdField_a_of_type_Befq = new befq(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidOsHandler = new befq(Looper.getMainLooper(), this.jdField_b_of_type_AndroidOsHandler$Callback);
    a().getExtras().setClassLoader(getClass().getClassLoader());
    n();
    return true;
  }
  
  public void am_()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
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
      k();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      break;
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height;
      }
    }
  }
  
  void b(Intent paramIntent)
  {
    paramIntent = null;
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).getString("camera_photo_path", "");
    if (!((String)localObject).equalsIgnoreCase(""))
    {
      acnc.jdField_a_of_type_JavaLangString = (String)localObject;
      paramIntent = Uri.fromFile(new File((String)localObject));
    }
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().remove("camera_photo_path").commit();
    if (paramIntent == null) {
      return;
    }
    paramIntent = bacm.b(BaseApplicationImpl.getApplication(), paramIntent);
    if (paramIntent != null)
    {
      bacm.a(super.getActivity(), paramIntent);
      if (!bace.e(paramIntent))
      {
        bbmy.a(super.getActivity(), super.getString(2131626922), 0).b(b());
        return;
      }
      if (!new File(paramIntent).exists()) {
        bbmy.a(super.getActivity(), getString(2131629503), 0).b(b());
      }
    }
    else
    {
      bbmy.a(super.getActivity(), getString(2131629503), 0).b(b());
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
    ((Intent)localObject).putExtra(baae.jdField_h_of_type_JavaLangString, 55);
    ((Intent)localObject).putExtra("uin", ajed.U);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    ((Intent)localObject).putExtra("LASTFROM", this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
    super.getActivity().startActivity((Intent)localObject);
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
    localIntent.putExtra(baae.jdField_h_of_type_JavaLangString, 55);
    localIntent.putExtra("uin", ajed.U);
    localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("LASTFROM", this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.putExtra("PhotoConst.original_button", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    }
    super.startActivity(localIntent);
    baaf.a(super.getActivity(), false, true);
  }
  
  public void c()
  {
    bbbt localbbbt = (bbbt)this.jdField_a_of_type_Bbaq.a(4);
    if (localbbbt != null)
    {
      xdt localxdt = b();
      if ((localxdt != null) && (axfs.a(localxdt.a())))
      {
        axfo localaxfo = new axfo(a());
        localaxfo.a((TeamWorkFileImportInfo)a().getParcelableExtra("key_team_work_file_import_info"));
        localbbbt.a = localaxfo;
      }
      localbbbt.a(localxdt, this.jdField_a_of_type_Bbcm.jdField_a_of_type_Long);
      axfs.a(a(), "0X800A16D");
    }
  }
  
  public void c(int paramInt)
  {
    this.B = true;
    this.r = paramInt;
  }
  
  public void c(String paramString)
  {
    if (paramString != null) {
      try
      {
        QLog.d("WebLog_WebViewFragment", 2, paramString);
        JSONObject localJSONObject = new JSONObject(paramString);
        int i = localJSONObject.getInt("ret");
        String str = localJSONObject.optString("url");
        localJSONObject.optString("error");
        if (i == 0) {
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
  
  public void d(boolean paramBoolean)
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
  
  public void e()
  {
    int i = -1;
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = a(null).a();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnLongClickListener(new abum(this));
      l1 = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Bbcm.jdField_a_of_type_Long & 0x10000) == 0L) {
        break label430;
      }
      i = 2;
      if (AppSetting.f) {
        i = 2;
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setCacheMode(i);
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "setCacheMode=" + i);
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setAllowFileAccessFromFileURLs(false);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setAllowUniversalAccessFromFileURLs(false);
      l2 = System.currentTimeMillis();
      this.jdField_a_of_type_Bbca.n = (l2 - l1);
      this.jdField_a_of_type_Bbca.R = l2;
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init browser, cost = " + this.jdField_a_of_type_Bbca.n);
      }
      l2 = System.currentTimeMillis();
      IX5WebViewExtension localIX5WebViewExtension = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension();
      if (localIX5WebViewExtension == null) {
        break label485;
      }
      i = 1;
      label226:
      if (i == 0) {
        break label514;
      }
      Bundle localBundle = bbdc.a();
      if (localBundle != null) {
        localIX5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
      }
      if (!this.jdField_a_of_type_Bbca.w) {
        break label490;
      }
      l1 = 2L;
      if (!(this.jdField_a_of_type_ComTencentBizUiTouchWebView instanceof SwiftReuseTouchWebView)) {
        break label538;
      }
      if (1 != ((SwiftReuseTouchWebView)this.jdField_a_of_type_ComTencentBizUiTouchWebView).jdField_a_of_type_Int) {
        break label509;
      }
      i = 1;
    }
    for (;;)
    {
      label293:
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Long.valueOf(bbdb.jdField_a_of_type_Long) }));
      }
      System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.reportInitPerformance(l1, i, this.jdField_a_of_type_Bbca.jdField_c_of_type_Long, bbdb.jdField_a_of_type_Long);
      System.currentTimeMillis();
      this.jdField_a_of_type_Bbca.e = 2;
      label514:
      for (this.jdField_a_of_type_Bbca.g = String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication()));; this.jdField_a_of_type_Bbca.g = String.valueOf(Build.VERSION.SDK_INT))
      {
        l1 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("WebLog_WebViewFragment", 2, "setDomainsAndArgumentForImageRequest, cost=" + (l1 - l2));
        }
        return;
        label430:
        switch (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("reqType", -1))
        {
        case 2: 
        case 3: 
        default: 
          break;
        case 1: 
          i = 2;
          break;
        case 4: 
          i = 0;
          break;
          label485:
          i = 0;
          break label226;
          label490:
          if (bbca.s) {}
          for (i = 1;; i = 0)
          {
            l1 = i;
            break;
          }
          label509:
          i = 0;
          break label293;
          this.jdField_a_of_type_Bbca.e = 1;
        }
      }
      label538:
      i = 0;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Bazb.a() != null) && (this.jdField_a_of_type_AndroidContentIntent != null))
    {
      paramBoolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("doc_from_aio", false);
      String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("doc_from_aio_uin");
      int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("doc_from_aio_peertype", -1);
      if ((paramBoolean) && (!TextUtils.isEmpty(str)) && (i != -1))
      {
        this.jdField_a_of_type_Bazb.a().setVisibility(0);
        q();
        a(i, str, (ImageView)this.jdField_a_of_type_Bazb.a().findViewById(2131304578));
        return;
      }
    }
    this.jdField_a_of_type_Bazb.a().setVisibility(8);
  }
  
  public int f(Bundle paramBundle)
  {
    int i = super.f(paramBundle);
    if (this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131625011));
    }
    if (this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if ((a().hasExtra("temp_preview_show_loading")) && ((this.jdField_a_of_type_Bbcj.d instanceof RelativeLayout)))
    {
      this.jdField_a_of_type_Axej = new axej((RelativeLayout)this.jdField_a_of_type_Bbcj.d, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Axej.a(paramBundle);
      if (a(null)) {
        axhg.a(null, "0X800A752");
      }
    }
    return i;
  }
  
  public void f()
  {
    if (this.z)
    {
      this.z = false;
      ThreadManager.excute(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.10(this), 16, null, true);
    }
    label140:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
      {
        super.f();
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())
      {
        HashMap localHashMap = new HashMap(1);
        localHashMap.put("target", Integer.valueOf(2));
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack(localHashMap)) {
          s();
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Bazb == null) {
          break label140;
        }
        this.jdField_a_of_type_Bazb.jdField_a_of_type_Bbcm.d = false;
        this.jdField_a_of_type_Bazb.jdField_a_of_type_Bbcm.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
        if (this.jdField_a_of_type_Bbcj == null) {
          break;
        }
        this.jdField_a_of_type_Bbcj.j();
        return;
        super.f();
      }
    }
  }
  
  public void g()
  {
    mpw.a("Web_readyToLoadUrl");
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      return;
    }
    a();
    if ((this.jdField_a_of_type_Bbca.i) && (this.jdField_a_of_type_Bbca.k > 0L))
    {
      awqx.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_Bbca.k) / 1000000L), "", "", "", "" + this.jdField_a_of_type_Bbca.jdField_c_of_type_Int);
      this.jdField_a_of_type_Bbca.k = 0L;
    }
    this.jdField_a_of_type_Bbca.q = System.currentTimeMillis();
    long l = this.jdField_a_of_type_Bbca.q;
    l = this.jdField_a_of_type_Bbca.b;
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
    {
      if ((ammf.a().a()) && (!TextUtils.isEmpty(axfy.jdField_a_of_type_JavaLangString)) && (this.jdField_h_of_type_JavaLangString.contains(axfy.jdField_a_of_type_JavaLangString))) {
        break label221;
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_h_of_type_JavaLangString);
    }
    for (;;)
    {
      mpw.b("Web_readyToLoadUrl");
      this.jdField_a_of_type_Bbca.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.jdField_h_of_type_JavaLangString, 0, 0, 0, 0, 0, null);
      return;
      label221:
      if (this.jdField_a_of_type_Axgc.jdField_a_of_type_Boolean) {
        axfz.a(axfb.a(this.jdField_h_of_type_JavaLangString), this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      } else {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_h_of_type_JavaLangString);
      }
    }
  }
  
  public void g_(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bazb.b != null) {
      this.jdField_a_of_type_Bazb.b.clearFocus();
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.clearFocus();
    }
  }
  
  public void j()
  {
    this.g = true;
  }
  
  public void k()
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_Bazb == null) || (this.jdField_a_of_type_Bazb.b == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bazb.b.isFocused()) {
        this.jdField_a_of_type_Bazb.b.clearFocus();
      }
      this.jdField_a_of_type_Bazb.b.setVisibility(0);
      boolean bool1 = bool2;
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("temp_preview_from_qq", false))
      {
        bool1 = bool2;
        if (b() != null)
        {
          bool1 = bool2;
          if (b().contains("preview=1")) {
            bool1 = true;
          }
        }
      }
      this.w = bool1;
      if (this.w)
      {
        this.jdField_a_of_type_Bazb.b.setText(getResources().getString(2131654270));
        return;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_Bazb.b.setText(2131654268);
        return;
      }
    } while (this.jdField_a_of_type_Int != 1);
    this.jdField_a_of_type_Bazb.b.setText(2131654268);
  }
  
  public void l()
  {
    if (!f())
    {
      super.getActivity().getWindow().setFlags(1024, 1024);
      this.jdField_a_of_type_Bbcm.jdField_a_of_type_Boolean = true;
      D();
      g(false);
    }
  }
  
  public void m()
  {
    if (f())
    {
      super.getActivity().getWindow().clearFlags(1024);
      this.jdField_a_of_type_Bbcm.jdField_a_of_type_Boolean = false;
      E();
      g(true);
    }
  }
  
  void n()
  {
    String str = super.b();
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
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    if (!TextUtils.isEmpty(str))
    {
      if (!str.contains("docx.qq.com")) {
        break label184;
      }
      this.jdField_c_of_type_JavaLangString = ("https://" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + ".docx.qq.com/ep/api/attach_local?tag=" + this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.v = getActivity().getIntent().getBooleanExtra("doc_from_forward_dialog", false);
      return;
      label184:
      if (str.contains("docs.qq.com")) {
        this.jdField_c_of_type_JavaLangString = ("https://" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + ".docs.qq.com/ep/api/attach_local?tag=" + this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void o()
  {
    if ((this.jdField_a_of_type_Axej != null) && (this.jdField_a_of_type_Axej.a())) {}
    do
    {
      return;
      if ((!this.w) && (!this.jdField_a_of_type_Bbcm.e)) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    } while (!this.v);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131302804) {
      super.onClick(paramView);
    }
    int i = paramView.getId();
    paramView = (InputMethodManager)super.getActivity().getSystemService("input_method");
    switch (i)
    {
    }
    label391:
    label405:
    do
    {
      return;
      if ((this.p == 1) && (this.g))
      {
        a(15);
        paramView = (begr)behe.a(getActivity(), null);
        paramView.a(getResources().getString(2131654264));
        paramView.a(getResources().getString(2131654262), 5);
        paramView.a(getResources().getString(2131654212), 5);
        paramView.c(2131625035);
        paramView.a(new abue(this, paramView));
        paramView.show();
        return;
      }
      if ((this.p == 2) && (this.g))
      {
        a(15);
        f(2);
        getActivity().finish();
        return;
      }
      if ((this.p == 3) && (this.g))
      {
        a(15);
        f(3);
        getActivity().finish();
        return;
      }
      if ((this.jdField_a_of_type_Xdt != null) && (this.A) && (this.jdField_a_of_type_Xdt.c()) && (a().getBooleanExtra("key_is_new_pad_flag", false)))
      {
        paramView = new Bundle();
        paramView.putString("savedUrl", b());
        localObject = (TeamWorkFileImportInfo)a().getParcelableExtra("key_team_work_file_import_info");
        if (localObject != null)
        {
          if (this.jdField_a_of_type_Xdt.b() != null) {
            break label391;
          }
          ((TeamWorkFileImportInfo)localObject).jdField_b_of_type_JavaLangString = "";
          if (((TeamWorkFileImportInfo)localObject).e != 3) {
            break label405;
          }
          paramView.putInt("editType", 1);
        }
      }
      for (;;)
      {
        paramView.putParcelable("key_team_work_file_import_info", (Parcelable)localObject);
        paramView = anah.a("ipc_save_team_work", "", -1, paramView);
        anfc.a().a(paramView);
        f();
        return;
        ((TeamWorkFileImportInfo)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Xdt.b();
        break;
        if (((TeamWorkFileImportInfo)localObject).e == 6) {
          paramView.putInt("editType", 2);
        }
      }
      if (paramView != null) {
        paramView.hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
      }
      b(this).clearFocus();
      if (this.jdField_a_of_type_Befq != null)
      {
        paramView = this.jdField_a_of_type_Befq.obtainMessage();
        paramView.what = 2;
        this.jdField_a_of_type_Befq.sendMessageDelayed(paramView, 500L);
      }
      c(false);
      return;
      paramView.hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
      c(this).clearFocus();
      if (this.jdField_a_of_type_Befq != null)
      {
        paramView = this.jdField_a_of_type_Befq.obtainMessage();
        paramView.what = 3;
        this.jdField_a_of_type_Befq.sendMessageDelayed(paramView, 500L);
      }
      c(false);
      return;
      paramView.hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
      d(this).clearFocus();
      return;
      Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("value", localObject);
        localObject = localJSONObject.toString();
        e(this).callJs("setCellValue(" + (String)localObject + ")");
        paramView.hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
        return;
      }
      catch (JSONException paramView) {}
    } while (!QLog.isDevelopLevel());
    QLog.d("WebLog_WebViewFragment", 4, paramView, new Object[0]);
  }
  
  @TargetApi(16)
  public void onDestroy()
  {
    M();
    axfs.a(a(), "0X800A16C");
    super.onDestroy();
    t();
    if (this.jdField_a_of_type_Axej != null) {
      this.jdField_a_of_type_Axej.a();
    }
    if (this.jdField_a_of_type_Befq != null)
    {
      this.jdField_a_of_type_Befq.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Befq.removeMessages(0);
      this.jdField_a_of_type_Befq = null;
    }
    if ((this.jdField_a_of_type_Bbcj != null) && (this.jdField_a_of_type_Bbcj.d != null) && (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null))
    {
      if (Build.VERSION.SDK_INT >= 16) {
        break label133;
      }
      this.jdField_a_of_type_Bbcj.d.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      if (this.jdField_a_of_type_Alis != null) {
        this.jdField_a_of_type_Alis.b();
      }
      return;
      label133:
      this.jdField_a_of_type_Bbcj.d.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.B)
    {
      this.B = false;
      this.jdField_a_of_type_Xdt.a(1, this.r, 1, true);
    }
  }
  
  public void onStop()
  {
    if (super.getWebView() != null) {
      super.getWebView().clearFocus();
    }
    super.onStop();
  }
  
  public void p()
  {
    this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849178);
    this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new abui(this));
  }
  
  public void q()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("doc_from_aio", false);
    String str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("doc_from_aio_uin");
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("doc_from_aio_peertype", -1);
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("doc_from_aio_nickname");
    if ((bool) && (!TextUtils.isEmpty(str1)) && (i != -1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new axfg(getActivity(), a(), str1, i, str2);
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
      }
      this.jdField_a_of_type_Bazb.a().setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Bazb.a().setVisibility(8);
  }
  
  public void r()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      Object localObject = new StateListDrawable();
      Drawable localDrawable = getResources().getDrawable(2130849256);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
      localDrawable = getResources().getDrawable(2130849255);
      ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
      localDrawable = getResources().getDrawable(2130849256);
      ((StateListDrawable)localObject).addState(new int[0], localDrawable);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
      localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = aciy.a(16.0F, getResources());
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (bbbt)this.jdField_a_of_type_Bbaq.a(4);
      ((bbbt)localObject).a(true);
      ((bbbt)localObject).jdField_b_of_type_Boolean = true;
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new abul(this));
    }
  }
  
  public void s()
  {
    super.s();
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_Bazb.b.setText("");
  }
  
  void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
    }
    bbca localbbca = this.jdField_a_of_type_Bbca;
    this.i = true;
    localbbca.l = true;
    if (this.jdField_a_of_type_Axgc != null)
    {
      this.jdField_a_of_type_Axgc.a();
      this.jdField_a_of_type_Axgc = null;
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void u()
  {
    if (kzy.b(BaseApplicationImpl.getContext())) {
      return;
    }
    Object localObject1 = super.getActivity();
    Object localObject2 = new File(ajed.aU + "photo/");
    if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs()))
    {
      bbmy.a((Context)localObject1, 2131653216, 0).a();
      return;
    }
    localObject1 = ajed.aU + "photo/" + System.currentTimeMillis() + ".jpg";
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().putString("camera_photo_path", (String)localObject1).commit();
    localObject2 = new Intent();
    FileProvider7Helper.setSystemCapture(super.getActivity(), new File((String)localObject1), (Intent)localObject2);
    super.getActivity().startActivityForResult((Intent)localObject2, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment
 * JD-Core Version:    0.7.0.1
 */