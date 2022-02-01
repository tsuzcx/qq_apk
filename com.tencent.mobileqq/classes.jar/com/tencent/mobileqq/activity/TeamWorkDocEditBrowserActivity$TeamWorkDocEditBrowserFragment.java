package com.tencent.mobileqq.activity;

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
import androidx.fragment.app.FragmentActivity;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationTencentDocs;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigProcessor;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportCover;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder;
import com.tencent.mobileqq.teamwork.TenDocWebPreLoadHelper;
import com.tencent.mobileqq.teamwork.TenDocWebViewPool;
import com.tencent.mobileqq.teamwork.WebViewWrapperForDoc;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewUIUtils;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftMiniAIOHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
  extends WebViewFragment
{
  boolean A = false;
  boolean B = false;
  public int C;
  ViewTreeObserver.OnGlobalLayoutListener D = new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.13(this);
  private int E = -1;
  private ImageView F;
  private boolean G = false;
  private boolean H;
  private WebViewWrapperForDoc I;
  private boolean J;
  private TeamWorkFileImportCover K;
  private View L;
  private boolean M = false;
  private int N = -1000;
  private boolean O = true;
  private boolean P = false;
  private boolean Q = false;
  private long R = 0L;
  private boolean S;
  private int T;
  public int a;
  String b = "";
  public boolean c = true;
  public RelativeLayout d;
  ImageView e;
  ImageView f;
  ImageView g;
  SessionInfo h = new SessionInfo();
  public int i;
  public int j;
  public boolean k = true;
  public InputLinearLayout l;
  public EditText m;
  public Button n;
  public boolean o;
  public String p;
  public String q;
  boolean r;
  TextView s = null;
  public int t = -1;
  boolean u = false;
  WeakReferenceHandler v;
  Handler.Callback w = new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.1(this);
  protected OnRemoteRespObserver x;
  Handler y;
  Handler.Callback z = new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.2(this);
  
  private boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    if (paramTeamWorkFileImportInfo == null) {
      localTeamWorkFileImportInfo = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
    }
    return (localTeamWorkFileImportInfo != null) && (localTeamWorkFileImportInfo.n == 12);
  }
  
  private void d(int paramInt)
  {
    if (getQBaseActivity() == null) {
      return;
    }
    String str = "key_team_work_user_click_count";
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        paramInt = TencentDocConvertConfigProcessor.a().m();
        localObject1 = TencentDocConvertConfigProcessor.a().i();
        localObject2 = TencentDocConvertConfigProcessor.a().j();
        localObject3 = HardCodeUtil.a(2131912120);
      }
      else
      {
        paramInt = TencentDocConvertConfigProcessor.a().p();
        localObject1 = TencentDocConvertConfigProcessor.a().n();
        localObject2 = TencentDocConvertConfigProcessor.a().o();
        localObject3 = HardCodeUtil.a(2131912070);
        str = "key_team_work_content_edit_click_count";
      }
    }
    else
    {
      paramInt = TencentDocConvertConfigProcessor.a().m();
      localObject1 = TencentDocConvertConfigProcessor.a().k();
      localObject2 = TencentDocConvertConfigProcessor.a().l();
      localObject3 = HardCodeUtil.a(2131912071);
    }
    Object localObject4 = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tim_convert_teamwork_pre_");
    localStringBuilder.append(getQBaseActivity().getAppRuntime().getCurrentAccountUin());
    localObject4 = ((BaseApplicationImpl)localObject4).getSharedPreferences(localStringBuilder.toString(), 4);
    int i1 = ((SharedPreferences)localObject4).getInt(str, 0);
    if (i1 < paramInt)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        localObject1 = getResources().getString(2131917128);
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("\n");
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject3).toString();
      }
      localObject2 = new Intent(getQBaseActivity(), DialogActivity.class);
      ((Intent)localObject2).addFlags(268435456);
      ((Intent)localObject2).addFlags(536870912);
      ((Intent)localObject2).addFlags(67108864);
      ((Intent)localObject2).addFlags(131072);
      ((Intent)localObject2).putExtra("key_dialog_type", DialogActivity.d);
      ((Intent)localObject2).putExtra("key_dialog_title", HardCodeUtil.a(2131912059));
      ((Intent)localObject2).putExtra("key_dialog_content", (String)localObject1);
      ((Intent)localObject2).putExtra("key_teamwork_url", n());
      getQBaseActivity().startActivity((Intent)localObject2);
      a(20);
      localObject1 = ((SharedPreferences)localObject4).edit();
      ((SharedPreferences.Editor)localObject1).putInt(str, i1 + 1);
      ((SharedPreferences.Editor)localObject1).commit();
      return;
    }
    QQToast.makeText(getQBaseActivity(), (CharSequence)localObject3, 0).show(getQBaseActivity().getResources().getDimensionPixelSize(2131299920));
  }
  
  private void d(String paramString)
  {
    if (HttpUtil.isValidUrl(paramString)) {
      this.webView.loadUrl(paramString);
    }
    this.J = false;
    this.F.setVisibility(0);
    getSwiftTitleUI().f.setOnClickListener(null);
    getSwiftTitleUI().f.setVisibility(8);
    getSwiftTitleUI().d.setBackgroundResource(2130841082);
    getSwiftTitleUI().d.setText(2131887440);
    this.E = 2;
    e();
    j();
    this.B = false;
    getSwiftTitleUI().h.setVisibility(8);
    if (this.H) {
      this.F.setVisibility(8);
    }
  }
  
  private String n()
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
  
  private void o()
  {
    this.x = new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.7(this);
  }
  
  private void p()
  {
    Bundle localBundle = new Bundle();
    if (getIntent().getParcelableExtra("key_team_work_file_import_info") != null) {
      localBundle.putParcelable("key_team_work_file_import_info", getIntent().getParcelableExtra("key_team_work_file_import_info"));
    }
    localBundle = DataFactory.a("ipc_cmd_get_team_work_url", "", this.x.key, localBundle);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->service binded  make ipc request");
    }
    this.O = true;
  }
  
  private void q()
  {
    Object localObject2;
    Object localObject1;
    if (getUIStyleHandler().f.a)
    {
      QLog.e("WebLog_WebViewFragment", 1, "isFullScreen");
      if (getIntent().getStringExtra("url") != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("isFullScreen url: ");
        ((StringBuilder)localObject2).append(getIntent().getStringExtra("url"));
        ((StringBuilder)localObject2).append(" mRulesFromUrl fullScreen ");
        if ((getUIStyle().c & 0x20000) > 0L) {
          localObject1 = "true";
        } else {
          localObject1 = "false";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.e("WebLog_WebViewFragment", 1, ((StringBuilder)localObject2).toString());
      }
    }
    if (getSwiftTitleUI().o != null)
    {
      getSwiftTitleUI().h.setVisibility(8);
      localObject1 = getIntent();
      localObject2 = getResources().getColorStateList(2131167988);
      getSwiftTitleUI().d.setTextColor((ColorStateList)localObject2);
      getSwiftTitleUI().f.setTextColor((ColorStateList)localObject2);
      getSwiftTitleUI().d.setBackgroundResource(2130841082);
      localObject2 = this.K;
      if ((localObject2 == null) || (!((TeamWorkFileImportCover)localObject2).a())) {
        getSwiftTitleUI().o.setBackgroundColor(Color.parseColor("#f6f7f9"));
      }
      getSwiftTitleUI().e.setTextSize(18.0F);
      getSwiftTitleUI().e.setTextColor(Color.parseColor("#333333"));
      getSwiftTitleUI().e.setMaxEms(13);
      getSwiftTitleUI().e.getLayoutParams().height = -2;
      this.s = ((TextView)getSwiftTitleUI().o.findViewById(2131436230));
      this.s.setTextColor(Color.parseColor("#777777"));
      this.s.setTextSize(12.0F);
      this.s.setMaxEms(13);
      this.F = ((ImageView)getSwiftTitleUI().o.findViewById(2131436199));
      this.t = ((Intent)localObject1).getIntExtra("key_team_work_pad_list_type", -1);
      boolean bool;
      if ((((Intent)localObject1).getBooleanExtra("temp_preview_from_qq", false)) && (getCurrentUrl() != null) && (getCurrentUrl().contains("preview=1"))) {
        bool = true;
      } else {
        bool = false;
      }
      this.J = bool;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getShareUrl:");
        ((StringBuilder)localObject2).append(getShareUrl());
        ((StringBuilder)localObject2).append("  tempPreviewFromQQ:");
        ((StringBuilder)localObject2).append(this.J);
        QLog.i("WebLog_WebViewFragment", 2, ((StringBuilder)localObject2).toString());
      }
      if (this.J)
      {
        localObject1 = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
        if ((this.a == 0) && (localObject1 != null)) {
          if (((TeamWorkFileImportInfo)localObject1).u == 3) {
            this.a = 1;
          } else if (((TeamWorkFileImportInfo)localObject1).u == 6) {
            this.a = 2;
          }
        }
        localObject1 = this.K;
        if ((localObject1 != null) && (((TeamWorkFileImportCover)localObject1).a()))
        {
          getSwiftTitleUI().h.setVisibility(8);
          getSwiftTitleUI().f.setVisibility(8);
          getSwiftTitleUI().d.setVisibility(8);
          return;
        }
        getSwiftTitleUI().f.setVisibility(0);
        getSwiftTitleUI().d.setVisibility(0);
        k();
        this.F.setVisibility(8);
        getSwiftTitleUI().h.setVisibility(8);
        getSwiftTitleUI().f.setVisibility(0);
        getSwiftTitleUI().f.setText(HardCodeUtil.a(2131912066));
        getSwiftTitleUI().d.setText(HardCodeUtil.a(2131912086));
        this.E = 1;
        getSwiftTitleUI().f.setOnClickListener(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.9(this));
      }
      else if (((Intent)localObject1).getBooleanExtra("temp_preview_from_qq", false))
      {
        this.E = 3;
        k();
      }
      else
      {
        k();
      }
      ((SwiftMiniAIOHandler)getComponentProvider().a(256)).a(true);
    }
  }
  
  private void r()
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(localTeamWorkFileImportInfo, getCurrentUrl(), "0X8009F33");
    s();
  }
  
  private void s()
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
    if (a(localTeamWorkFileImportInfo))
    {
      TenDocLogReportHelper.a(null, "0X800A753");
      ReportController.b(null, "dc00898", "", "", "0X800A757", "0X800A757", 0, 0, "", "", String.valueOf(SystemClock.elapsedRealtime() - localTeamWorkFileImportInfo.l), "");
    }
  }
  
  public void a()
  {
    ImageView localImageView = this.F;
    if (localImageView != null) {
      localImageView.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    int i1 = getIntent().getIntExtra("tdsourcetab", -1);
    String str;
    if (paramInt == 0)
    {
      if (i1 == 3) {
        ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A074", "0X800A074", 0, 0, "", "", "", "");
      } else if (i1 == 20) {
        ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A07C", "0X800A07C", 0, 0, "", "", "", "");
      }
      str = "0X80074D2";
    }
    for (;;)
    {
      break;
      if (paramInt == 1)
      {
        if (i1 == 3) {
          ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A075", "0X800A075", 0, 0, "", "", "", "");
        } else if (i1 == 20) {
          ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A07D", "0X800A07D", 0, 0, "", "", "", "");
        }
        str = "0X80074D3";
      }
      else if (paramInt == 2)
      {
        if (i1 == 3) {
          ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A076", "0X800A076", 0, 0, "", "", "", "");
        } else if (i1 == 20) {
          ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A07E", "0X800A07E", 0, 0, "", "", "", "");
        }
        str = "0X80074D4";
      }
      else if (paramInt == 3)
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
      else if (paramInt == 15)
      {
        if (i1 == 3) {
          ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A073", "0X800A073", 0, 0, "", "", "", "");
        } else if (i1 == 20) {
          ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A07B", "0X800A07B", 0, 0, "", "", "", "");
        }
        str = "0X8008A3B";
      }
      else if (paramInt == 17)
      {
        str = "0X8009068";
      }
      else if (paramInt == 18)
      {
        str = "0X8008A3A";
      }
      else if (paramInt == 20)
      {
        str = "0X8009069";
      }
      else if (paramInt == 19)
      {
        str = "0X8008A3E";
      }
      else
      {
        str = "";
      }
    }
    if (!TextUtils.isEmpty(str)) {
      ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
  }
  
  public void a(Context paramContext, ArrayList<String> paramArrayList)
  {
    a(paramArrayList);
  }
  
  void a(Intent paramIntent)
  {
    paramIntent = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).getString("camera_photo_path", "");
    if (!paramIntent.equalsIgnoreCase(""))
    {
      com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils.a = paramIntent;
      paramIntent = Uri.fromFile(new File(paramIntent));
    }
    else
    {
      paramIntent = null;
    }
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().remove("camera_photo_path").commit();
    if (paramIntent == null) {
      return;
    }
    paramIntent = ImageUtil.b(BaseApplicationImpl.getApplication(), paramIntent);
    if (paramIntent != null)
    {
      ImageUtil.b(super.getQBaseActivity(), paramIntent);
      if (!FileUtils.isPicFile(paramIntent))
      {
        QQToast.makeText(super.getActivity(), super.getString(2131889404), 0).show(getWebTitleBarInterface().m());
        return;
      }
      if (!new File(paramIntent).exists()) {
        QQToast.makeText(super.getActivity(), getString(2131892634), 0).show(getWebTitleBarInterface().m());
      }
    }
    else
    {
      QQToast.makeText(super.getActivity(), getString(2131892634), 0).show(getWebTitleBarInterface().m());
    }
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localIntent.setClass(super.getQBaseActivity(), CameraPreviewActivity.class);
    localArrayList.add(paramIntent);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TeamWorkDocEditBrowserActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", TeamWorkDocEditBrowserActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    localIntent.putExtra(AlbumConstants.h, 55);
    localIntent.putExtra("uin", AppConstants.TEAM_WORK_WORD_UIN);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("LASTFROM", getSwiftTitleUI().d.getText().toString());
    super.getQBaseActivity().startActivity(localIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    if (getSwiftTitleUI().d != null) {
      getSwiftTitleUI().d.setText(getResources().getString(2131887625));
    }
    if (getSwiftTitleUI().h != null) {
      getSwiftTitleUI().h.setVisibility(8);
    }
    if ((getIntent().hasExtra("temp_preview_show_loading")) && ((getUIStyleHandler().x instanceof RelativeLayout)))
    {
      this.K = new TeamWorkFileImportCover((RelativeLayout)getUIStyleHandler().x, getActivity(), (AppInterface)getAppRuntime());
      this.L = this.K.a(paramBundle);
      if (a(null)) {
        TenDocLogReportHelper.a(null, "0X800A752");
      }
    }
  }
  
  public void a(Bundle paramBundle, TouchWebView paramTouchWebView, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e0expr(TypeTransformer.java:441)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:710)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(WebView paramWebView, String paramString, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    paramWebViewKernelCallBack.onPageFinished(paramWebView, paramString);
    if ((Build.VERSION.SDK_INT >= 19) && (!isDestroyed()))
    {
      WebViewWrapperForDoc localWebViewWrapperForDoc = this.I;
      if ((localWebViewWrapperForDoc != null) && (localWebViewWrapperForDoc.d() != null)) {
        paramWebViewKernelCallBack.onReceivedTitle(paramWebView, paramWebView.getTitle());
      }
    }
    super.getWebView().callJs("setDocxShareInfo", new String[] { "" });
    if (getSwiftTitleUI().e != null) {
      getSwiftTitleUI().e.clearFocus();
    }
    if (this.a == 1) {
      super.getWebView().requestFocus();
    }
    paramWebView = this.K;
    if ((paramWebView != null) && (paramWebView.a()))
    {
      this.K.c();
      q();
      int i1 = this.N;
      if (i1 != -1000)
      {
        a(this.M, i1);
        i();
      }
      paramWebView = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
      if (a(paramWebView))
      {
        TenDocLogReportHelper.a(null, "0X800A754");
        ReportController.b(null, "dc00898", "", "", "0X800A756", "0X800A756", 0, 0, "", "", String.valueOf(SystemClock.elapsedRealtime() - paramWebView.l), "");
      }
    }
    if ((paramString != null) && ((paramString.contains("/template")) || (paramString.contains("desktop/m/templates_list.html")) || (paramString.contains("docs.qq.com/desktop/m/send.html"))))
    {
      paramWebView = this.F;
      if (paramWebView != null) {
        paramWebView.setVisibility(8);
      }
      if (getSwiftTitleUI().h != null) {
        getSwiftTitleUI().h.setVisibility(8);
      }
    }
    if (this.H)
    {
      paramWebView = this.F;
      if (paramWebView != null) {
        paramWebView.setVisibility(8);
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((getSwiftTitleUI().e != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.A = true;
      getSwiftTitleUI().e.setVisibility(0);
      getSwiftTitleUI().e.setText(paramString);
      paramString = this.s;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((getSwiftTitleUI().e != null) && (this.s != null))
    {
      c();
      Object localObject = (Share)getShare();
      int i1 = ((Share)localObject).l();
      boolean bool = ((Share)localObject).j();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setEditTitle policy:");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(",editable:");
        ((StringBuilder)localObject).append(bool);
        QLog.i("WebLog_WebViewFragment", 1, ((StringBuilder)localObject).toString());
      }
      if (paramString1 != null)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.s.setTextColor(Color.parseColor(paramString2));
        }
        this.s.setText(paramString1);
        if (TextUtils.isEmpty(paramString1))
        {
          this.s.setVisibility(8);
          return;
        }
        this.s.setVisibility(0);
      }
    }
  }
  
  void a(ArrayList<String> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i1);
      CustomWebView localCustomWebView = q(this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readyToInsertImageForNativeJSBridge('");
      localStringBuilder.append(str);
      localStringBuilder.append("')");
      localCustomWebView.callJs(localStringBuilder.toString());
      i1 += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.Q = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.M = paramBoolean;
    this.N = paramInt;
    if (getSwiftTitleUI().e == null) {
      return;
    }
    if ((paramBoolean) && (paramInt != 0))
    {
      getSwiftTitleUI().e.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      return;
    }
    Drawable localDrawable;
    if (!paramBoolean) {
      localDrawable = getResources().getDrawable(2130852784);
    } else if (paramInt == 0) {
      localDrawable = getResources().getDrawable(2130852783);
    } else {
      localDrawable = null;
    }
    if (localDrawable != null)
    {
      getSwiftTitleUI().e.setCompoundDrawablePadding(AIOUtils.b(6.0F, getResources()));
      getSwiftTitleUI().e.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    String str = ((Share)getShare()).m();
    if ((paramBoolean) && (!TextUtils.isEmpty(str)))
    {
      a(str);
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      if (this.A)
      {
        this.A = false;
        e();
      }
      if (!paramBoolean) {
        a(paramString1, paramString2);
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.a = paramInt;
    paramInt = this.a;
    if (paramInt == 2)
    {
      if (this.k) {
        this.l.setVisibility(0);
      } else {
        this.l.setVisibility(8);
      }
      this.i = this.l.getLayoutParams().height;
    }
    else if (paramInt == 1)
    {
      this.i = this.d.getLayoutParams().height;
    }
    e();
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle = this.K;
    if ((paramBundle != null) && (paramBundle.a())) {
      getSwiftTitleUI().o.setBackgroundColor(-1);
    }
    if (getIntent().getBooleanExtra("temp_preview_show_loading", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "-->service KEY_TEMP_SHOW_LOADING");
      }
      o();
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.x);
      if (((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
        p();
      }
    }
    if (getUIStyleHandler().x == null) {
      getUIStyleHandler().x = ((ViewGroup)super.getQBaseActivity().findViewById(2131429740));
    }
    getUIStyleHandler().x.getViewTreeObserver().addOnGlobalLayoutListener(this.D);
    LayoutInflater.from(super.getQBaseActivity()).inflate(2131629374, getUIStyleHandler().x);
    this.h.b = AppConstants.TEAM_WORK_WORD_UIN;
    this.h.a = 7119;
    this.d = ((RelativeLayout)super.getQBaseActivity().findViewById(2131446933));
    this.e = ((ImageView)super.getQBaseActivity().findViewById(2131440274));
    this.e.setOnClickListener(this);
    this.f = ((ImageView)super.getQBaseActivity().findViewById(2131445878));
    this.f.setOnClickListener(this);
    this.g = ((ImageView)super.getQBaseActivity().findViewById(2131435039));
    this.g.setOnClickListener(this);
    this.l = ((InputLinearLayout)super.getQBaseActivity().findViewById(2131446955));
    this.m = ((EditText)super.getQBaseActivity().findViewById(2131446954));
    this.m.setImeOptions(1);
    this.m.setOnEditorActionListener(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.4(this));
    this.n = ((Button)super.getQBaseActivity().findViewById(2131446956));
    this.n.setOnClickListener(this);
    int i1 = this.a;
    if (i1 == 1)
    {
      super.getWebView().requestFocus();
      this.i = this.d.getLayoutParams().height;
    }
    else if (i1 == 2)
    {
      if (this.k) {
        this.l.setVisibility(0);
      } else {
        this.l.setVisibility(8);
      }
      this.i = this.l.getLayoutParams().height;
    }
    q();
  }
  
  public void b(String paramString)
  {
    a(17);
    ThreadManager.executeOnNetWorkThread(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.10(this, paramString));
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent(super.getQBaseActivity(), NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 27);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationTencentDocs.a);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TeamWorkDocEditBrowserActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra(AlbumConstants.h, 55);
    localIntent.putExtra("uin", AppConstants.TEAM_WORK_WORD_UIN);
    localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("LASTFROM", getSwiftTitleUI().d.getText().toString());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.putExtra("PhotoConst.original_button", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    }
    super.startActivity(localIntent);
    AlbumUtil.anim(super.getQBaseActivity(), false, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
    RelativeLayout localRelativeLayout = this.d;
    if ((localRelativeLayout != null) && (this.a == 1))
    {
      if (this.c)
      {
        localRelativeLayout.setVisibility(0);
        return;
      }
      localRelativeLayout.setVisibility(8);
    }
  }
  
  public boolean b()
  {
    if (!TextUtils.isEmpty(this.mUrl)) {
      if ((TencentDocPreloadConfigProcessor.a().a()) && (!TextUtils.isEmpty(TenDocWebPreLoadHelper.a)) && (this.mUrl.contains(TenDocWebPreLoadHelper.a)))
      {
        if (this.I.a) {
          TenDocWebViewPool.a(TeamWorkHandlerUtils.a(this.mUrl), this.webView);
        } else {
          this.webView.loadUrl(this.mUrl);
        }
      }
      else {
        this.webView.loadUrl(this.mUrl);
      }
    }
    return true;
  }
  
  public void c()
  {
    if (getSwiftTitleUI().e != null) {
      getSwiftTitleUI().e.clearFocus();
    }
    TextView localTextView = this.s;
    if (localTextView != null) {
      localTextView.clearFocus();
    }
  }
  
  public void c(int paramInt)
  {
    this.S = true;
    this.T = paramInt;
  }
  
  public void c(String paramString)
  {
    if (paramString != null) {}
    try
    {
      QLog.d("WebLog_WebViewFragment", 2, paramString);
      Object localObject = new JSONObject(paramString);
      int i1 = ((JSONObject)localObject).getInt("ret");
      String str = ((JSONObject)localObject).optString("url");
      ((JSONObject)localObject).optString("error");
      if (i1 == 0) {
        this.y.sendMessage(this.y.obtainMessage(2, str));
      } else {
        this.y.sendMessage(this.y.obtainMessage(3, str));
      }
      if (!QLog.isColorLevel()) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleSaveTempPadResult: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("WebLog_WebViewFragment", 2, ((StringBuilder)localObject).toString());
      return;
    }
    catch (JSONException paramString)
    {
      if (!QLog.isColorLevel()) {
        break label165;
      }
      QLog.e("WebLog_WebViewFragment", 2, paramString, new Object[0]);
      paramString = this.y;
      paramString.sendMessage(paramString.obtainMessage(3));
    }
    this.y.sendMessage(this.y.obtainMessage(3));
    return;
    label165:
  }
  
  public void c(boolean paramBoolean)
  {
    this.k = paramBoolean;
    InputLinearLayout localInputLinearLayout = this.l;
    if ((localInputLinearLayout != null) && (this.a == 2))
    {
      if (this.k)
      {
        localInputLinearLayout.setVisibility(0);
        return;
      }
      localInputLinearLayout.setVisibility(8);
    }
  }
  
  public SwiftBrowserComponentsProvider createComponentsProvider()
  {
    return new SwiftBrowserComponentsProvider(this, 511, new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.3(this));
  }
  
  public WebViewWrapper createWebViewWrapper(boolean paramBoolean)
  {
    WebViewWrapperForDoc localWebViewWrapperForDoc = new WebViewWrapperForDoc(getAppRuntime(), super.getActivity(), getWebViewKernelCallBack(), this.intent, paramBoolean);
    this.I = localWebViewWrapperForDoc;
    return localWebViewWrapperForDoc;
  }
  
  public void d()
  {
    this.B = true;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 5)
    {
      if (paramInt1 != 1001) {
        return;
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        Object localObject = paramIntent.getExtras();
        paramIntent = ((Bundle)localObject).getString("uin");
        paramInt1 = ((Bundle)localObject).getInt("uintype", 0);
        localObject = (Share)this.share;
        if ((((Share)localObject).a() != null) && ((((Share)localObject).a().c == 0) || (((Share)localObject).a().c == 1)))
        {
          ArrayList localArrayList = new ArrayList(1);
          localArrayList.add(paramIntent);
          ThreadManager.excute(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.15(this, (Share)localObject, paramInt1, localArrayList), 128, null, false);
        }
      }
    }
    else if (paramInt2 == -1)
    {
      a(paramIntent);
    }
  }
  
  public void doOnBackEvent()
  {
    if (this.P)
    {
      this.P = false;
      ThreadManager.excute(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.12(this), 16, null, true);
      return;
    }
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
    else
    {
      super.doOnBackEvent();
    }
    if (getSwiftTitleUI() != null)
    {
      getSwiftTitleUI().b.k = false;
      getSwiftTitleUI().b.o = Boolean.valueOf(true);
      if (getUIStyleHandler() != null) {
        getUIStyleHandler().k();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getUIStyleHandler().f.c = 8980L;
    if (getSwiftTitleUI().e != null) {
      getSwiftTitleUI().e.clearFocus();
    }
    this.v = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.w);
    this.y = new WeakReferenceHandler(Looper.getMainLooper(), this.z);
    getIntent().getExtras().setClassLoader(getClass().getClassLoader());
    h();
    return true;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    Object localObject = this.v;
    if (localObject != null)
    {
      localObject = ((WeakReferenceHandler)localObject).obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramIntent;
      this.v.sendMessage((Message)localObject);
    }
  }
  
  public void e()
  {
    if (getSwiftTitleUI() != null)
    {
      if (getSwiftTitleUI().e == null) {
        return;
      }
      if (getSwiftTitleUI().e.isFocused()) {
        getSwiftTitleUI().e.clearFocus();
      }
      TextView localTextView = getSwiftTitleUI().e;
      boolean bool2 = false;
      localTextView.setVisibility(0);
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
      this.J = bool1;
      if (this.J)
      {
        getSwiftTitleUI().e.setText(getResources().getString(2131917135));
        return;
      }
      int i1 = this.a;
      if (i1 == 2)
      {
        getSwiftTitleUI().e.setText(2131917133);
        return;
      }
      if (i1 == 1) {
        getSwiftTitleUI().e.setText(2131917133);
      }
    }
  }
  
  public void f()
  {
    if (!getUIStyleHandler().f.a)
    {
      super.getActivity().getWindow().setFlags(1024, 1024);
      getUIStyle().a = true;
      WebViewUIUtils.b(super.getActivity());
      getWebTitleBarInterface().f(false);
    }
  }
  
  public void g()
  {
    if (getUIStyleHandler().f.a)
    {
      super.getActivity().getWindow().clearFlags(1024);
      getUIStyle().a = false;
      WebViewUIUtils.c(super.getActivity());
      getWebTitleBarInterface().f(true);
    }
  }
  
  public WebUiUtils.WebTitleBarInterface getWebTitleBarInterface()
  {
    return new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.5(this, this.webViewSurface);
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.6(this, this.webViewSurface);
  }
  
  void h()
  {
    Object localObject1 = super.getCurrentUrl();
    if (localObject1 != null)
    {
      Object localObject2 = ((String)localObject1).split("/");
      if (localObject2 != null) {
        this.b = localObject2[(localObject2.length - 1)];
      }
      try
      {
        localObject2 = Uri.parse((String)localObject1).getQueryParameter("type");
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isDigitsOnly((CharSequence)localObject2))) {
          this.a = Integer.valueOf((String)localObject2).intValue();
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TeamWorkDocEditBrowserFragment initData e = ");
        localStringBuilder.append(localException.toString());
        QLog.e("WebLog_WebViewFragment", 1, localStringBuilder.toString());
      }
    }
    if (getAppRuntime() == null) {
      this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    }
    this.p = getAppRuntime().getCurrentAccountUin();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      if (((String)localObject1).contains("docx.qq.com"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("https://");
        ((StringBuilder)localObject1).append(getAppRuntime().getCurrentAccountUin());
        ((StringBuilder)localObject1).append(".docx.qq.com/ep/api/attach_local?tag=");
        ((StringBuilder)localObject1).append(this.b);
        this.q = ((StringBuilder)localObject1).toString();
      }
      else if (((String)localObject1).contains("docs.qq.com"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("https://");
        ((StringBuilder)localObject1).append(getAppRuntime().getCurrentAccountUin());
        ((StringBuilder)localObject1).append(".docs.qq.com/ep/api/attach_local?tag=");
        ((StringBuilder)localObject1).append(this.b);
        this.q = ((StringBuilder)localObject1).toString();
      }
    }
    this.H = getQBaseActivity().getIntent().getBooleanExtra("doc_from_forward_dialog", false);
  }
  
  public void i()
  {
    TeamWorkFileImportCover localTeamWorkFileImportCover = this.K;
    if ((localTeamWorkFileImportCover != null) && (localTeamWorkFileImportCover.a())) {
      return;
    }
    if ((!this.J) && (!getUIStyle().l)) {
      this.F.setVisibility(0);
    }
    if (this.H) {
      this.F.setVisibility(8);
    }
  }
  
  public void j()
  {
    getSwiftTitleUI().h.setImageResource(2130852785);
    getSwiftTitleUI().h.setOnClickListener(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.8(this));
  }
  
  public void k()
  {
    Object localObject = this.F;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(8);
      localObject = new StateListDrawable();
      Drawable localDrawable = getResources().getDrawable(2130853243);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
      localDrawable = getResources().getDrawable(2130853242);
      ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
      localDrawable = getResources().getDrawable(2130853243);
      ((StateListDrawable)localObject).addState(new int[0], localDrawable);
      this.F.setImageDrawable((Drawable)localObject);
      this.F.setClickable(true);
      localObject = (RelativeLayout.LayoutParams)this.F.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(16.0F, getResources());
      this.F.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (SwiftBrowserShareMenuHandler)this.mComponentsProvider.a(4);
      ((SwiftBrowserShareMenuHandler)localObject).b(true);
      ((SwiftBrowserShareMenuHandler)localObject).k = true;
      this.F.setOnClickListener(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.11(this));
    }
  }
  
  void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
    }
    Object localObject = getStatistics();
    this.isDestroyed = true;
    ((SwiftBrowserStatistics)localObject).av = true;
    localObject = this.I;
    if (localObject != null)
    {
      ((WebViewWrapperForDoc)localObject).b();
      this.I = null;
      this.webView = null;
    }
    this.mApp = null;
  }
  
  void m()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return;
    }
    Object localObject1 = super.getQBaseActivity();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject2).append("photo/");
    localObject2 = new File(((StringBuilder)localObject2).toString());
    if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs()))
    {
      QQToast.makeText((Context)localObject1, 2131916075, 0).show();
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject1).append("photo/");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    ((StringBuilder)localObject1).append(".jpg");
    localObject1 = ((StringBuilder)localObject1).toString();
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().putString("camera_photo_path", (String)localObject1).commit();
    localObject2 = new Intent();
    FileProvider7Helper.setSystemCapture(super.getQBaseActivity(), new File((String)localObject1), (Intent)localObject2);
    super.getQBaseActivity().startActivityForResult((Intent)localObject2, 5);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131436180) {
      super.onClick(paramView);
    }
    int i1 = paramView.getId();
    InputMethodManager localInputMethodManager = (InputMethodManager)super.getQBaseActivity().getSystemService("input_method");
    Object localObject2;
    Object localObject3;
    Object localObject1;
    switch (i1)
    {
    default: 
      break;
    case 2131446956: 
      localObject2 = this.m.getText().toString();
      try
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("value", localObject2);
        localObject2 = ((JSONObject)localObject3).toString();
        localObject3 = p(this);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCellValue(");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(")");
        ((CustomWebView)localObject3).callJs(localStringBuilder.toString());
        localInputMethodManager.hideSoftInputFromWindow(super.getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isDevelopLevel()) {
          break;
        }
      }
      QLog.d("WebLog_WebViewFragment", 4, localJSONException, new Object[0]);
      break;
    case 2131445878: 
      localJSONException.hideSoftInputFromWindow(super.getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
      n(this).clearFocus();
      localObject1 = this.v;
      if (localObject1 != null)
      {
        localObject1 = ((WeakReferenceHandler)localObject1).obtainMessage();
        ((Message)localObject1).what = 3;
        this.v.sendMessageDelayed((Message)localObject1, 500L);
      }
      b(false);
      break;
    case 2131440274: 
      if (localObject1 != null) {
        ((InputMethodManager)localObject1).hideSoftInputFromWindow(super.getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
      }
      m(this).clearFocus();
      localObject1 = this.v;
      if (localObject1 != null)
      {
        localObject1 = ((WeakReferenceHandler)localObject1).obtainMessage();
        ((Message)localObject1).what = 2;
        this.v.sendMessageDelayed((Message)localObject1, 500L);
      }
      b(false);
      break;
    case 2131436180: 
      if ((this.E == 1) && (this.B))
      {
        a(15);
        localObject1 = (ActionSheet)ActionSheetHelper.b(getQBaseActivity(), null);
        ((ActionSheet)localObject1).setMainTitle(getResources().getString(2131917129));
        ((ActionSheet)localObject1).addButton(getResources().getString(2131917127), 5);
        ((ActionSheet)localObject1).addButton(getResources().getString(2131917076), 5);
        ((ActionSheet)localObject1).addCancelButton(2131887648);
        ((ActionSheet)localObject1).setOnButtonClickListener(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.14(this, (ActionSheet)localObject1));
        ((ActionSheet)localObject1).show();
      }
      else if ((this.E == 2) && (this.B))
      {
        a(15);
        d(2);
        getQBaseActivity().finish();
      }
      else if ((this.E == 3) && (this.B))
      {
        a(15);
        d(3);
        getQBaseActivity().finish();
      }
      else
      {
        localObject1 = (Share)this.share;
        if ((localObject1 != null) && (this.Q) && (((Share)localObject1).k()) && (getIntent().getBooleanExtra("key_is_new_pad_flag", false)))
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("savedUrl", getCurrentUrl());
          localObject3 = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
          if (localObject3 != null)
          {
            if (((Share)localObject1).d() == null) {
              ((TeamWorkFileImportInfo)localObject3).c = "";
            } else {
              ((TeamWorkFileImportInfo)localObject3).c = ((Share)localObject1).d();
            }
            if (((TeamWorkFileImportInfo)localObject3).u == 3) {
              ((Bundle)localObject2).putInt("editType", 1);
            } else if (((TeamWorkFileImportInfo)localObject3).u == 6) {
              ((Bundle)localObject2).putInt("editType", 2);
            }
            ((Bundle)localObject2).putParcelable("key_team_work_file_import_info", (Parcelable)localObject3);
          }
          localObject1 = DataFactory.a("ipc_save_team_work", "", -1, (Bundle)localObject2);
          ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq((Bundle)localObject1);
        }
        doOnBackEvent();
      }
      break;
    case 2131435039: 
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(super.getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
      o(this).clearFocus();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @TargetApi(16)
  public void onDestroy()
  {
    r();
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(getIntent(), "0X800A16C");
    if (this.x != null) {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.x);
    }
    super.onDestroy();
    l();
    Object localObject = this.K;
    if (localObject != null) {
      ((TeamWorkFileImportCover)localObject).b();
    }
    localObject = this.v;
    if (localObject != null)
    {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
      this.v.removeMessages(0);
      this.v = null;
    }
    if ((getUIStyleHandler() != null) && (getUIStyleHandler().x != null) && (this.D != null)) {
      if (Build.VERSION.SDK_INT < 16) {
        getUIStyleHandler().x.getViewTreeObserver().removeGlobalOnLayoutListener(this.D);
      } else {
        getUIStyleHandler().x.getViewTreeObserver().removeOnGlobalLayoutListener(this.D);
      }
    }
    this.D = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.S)
    {
      this.S = false;
      ((Share)this.share).a(1, this.T, 1, true);
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
    TextView localTextView = this.s;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    getSwiftTitleUI().e.setText("");
  }
  
  public void showActionSheet()
  {
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.mComponentsProvider.a(4);
    if (localSwiftBrowserShareMenuHandler != null)
    {
      Share localShare = (Share)getShare();
      if ((localShare != null) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl(localShare.getShareUrl())))
      {
        getHostActivity().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
        TeamWorkShareActionSheetBuilder localTeamWorkShareActionSheetBuilder = new TeamWorkShareActionSheetBuilder(getHostActivity());
        localTeamWorkShareActionSheetBuilder.a((TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info"));
        localSwiftBrowserShareMenuHandler.h = localTeamWorkShareActionSheetBuilder;
      }
      localSwiftBrowserShareMenuHandler.a(localShare, getUIStyle().c);
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(getIntent(), "0X800A16D");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment
 * JD-Core Version:    0.7.0.1
 */