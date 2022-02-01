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
  public int a;
  private long jdField_a_of_type_Long = 0L;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.1(this);
  Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.13(this);
  public Button a;
  public EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public InputLinearLayout a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  protected OnRemoteRespObserver a;
  private TeamWorkFileImportCover jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover;
  private WebViewWrapperForDoc jdField_a_of_type_ComTencentMobileqqTeamworkWebViewWrapperForDoc;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  String jdField_a_of_type_JavaLangString = "";
  public boolean a;
  public int b;
  Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.2(this);
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public String b;
  public boolean b;
  public int c;
  ImageView c;
  public String c;
  public boolean c;
  public int d;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  boolean jdField_d_of_type_Boolean;
  public int e;
  boolean e = false;
  private int jdField_f_of_type_Int = -1;
  boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = -1000;
  boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = false;
  private boolean i;
  private boolean j;
  private boolean k = false;
  private boolean l = true;
  private boolean m = false;
  private boolean n = false;
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
  
  private boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    if (paramTeamWorkFileImportInfo == null) {
      localTeamWorkFileImportInfo = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
    }
    return (localTeamWorkFileImportInfo != null) && (localTeamWorkFileImportInfo.jdField_d_of_type_Int == 12);
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
        paramInt = TencentDocConvertConfigProcessor.a().c();
        localObject1 = TencentDocConvertConfigProcessor.a().b();
        localObject2 = TencentDocConvertConfigProcessor.a().c();
        localObject3 = HardCodeUtil.a(2131714611);
      }
      else
      {
        paramInt = TencentDocConvertConfigProcessor.a().d();
        localObject1 = TencentDocConvertConfigProcessor.a().f();
        localObject2 = TencentDocConvertConfigProcessor.a().g();
        localObject3 = HardCodeUtil.a(2131714561);
        str = "key_team_work_content_edit_click_count";
      }
    }
    else
    {
      paramInt = TencentDocConvertConfigProcessor.a().c();
      localObject1 = TencentDocConvertConfigProcessor.a().d();
      localObject2 = TencentDocConvertConfigProcessor.a().e();
      localObject3 = HardCodeUtil.a(2131714562);
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
        localObject1 = getResources().getString(2131719565);
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
      ((Intent)localObject2).putExtra("key_dialog_type", DialogActivity.jdField_d_of_type_Int);
      ((Intent)localObject2).putExtra("key_dialog_title", HardCodeUtil.a(2131714550));
      ((Intent)localObject2).putExtra("key_dialog_content", (String)localObject1);
      ((Intent)localObject2).putExtra("key_teamwork_url", a());
      getQBaseActivity().startActivity((Intent)localObject2);
      a(20);
      localObject1 = ((SharedPreferences)localObject4).edit();
      ((SharedPreferences.Editor)localObject1).putInt(str, i1 + 1);
      ((SharedPreferences.Editor)localObject1).commit();
      return;
    }
    QQToast.a(getQBaseActivity(), (CharSequence)localObject3, 0).b(getQBaseActivity().getResources().getDimensionPixelSize(2131299168));
  }
  
  private void d(String paramString)
  {
    if (HttpUtil.isValidUrl(paramString)) {
      this.webView.loadUrl(paramString);
    }
    this.j = false;
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    getSwiftTitleUI().c.setOnClickListener(null);
    getSwiftTitleUI().c.setVisibility(8);
    getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840342);
    getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setText(2131690529);
    this.jdField_f_of_type_Int = 2;
    d();
    i();
    this.jdField_g_of_type_Boolean = false;
    getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.i) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver = new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.7(this);
  }
  
  private void n()
  {
    Bundle localBundle = new Bundle();
    if (getIntent().getParcelableExtra("key_team_work_file_import_info") != null) {
      localBundle.putParcelable("key_team_work_file_import_info", getIntent().getParcelableExtra("key_team_work_file_import_info"));
    }
    localBundle = DataFactory.a("ipc_cmd_get_team_work_url", "", this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver.key, localBundle);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->service binded  make ipc request");
    }
    this.l = true;
  }
  
  private void o()
  {
    Object localObject2;
    Object localObject1;
    if (getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean)
    {
      QLog.e("WebLog_WebViewFragment", 1, "isFullScreen");
      if (getIntent().getStringExtra("url") != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("isFullScreen url: ");
        ((StringBuilder)localObject2).append(getIntent().getStringExtra("url"));
        ((StringBuilder)localObject2).append(" mRulesFromUrl fullScreen ");
        if ((getUIStyle().jdField_a_of_type_Long & 0x20000) > 0L) {
          localObject1 = "true";
        } else {
          localObject1 = "false";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.e("WebLog_WebViewFragment", 1, ((StringBuilder)localObject2).toString());
      }
    }
    if (getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup != null)
    {
      getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject1 = getIntent();
      localObject2 = getResources().getColorStateList(2131167051);
      getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject2);
      getSwiftTitleUI().c.setTextColor((ColorStateList)localObject2);
      getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840342);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover;
      if ((localObject2 == null) || (!((TeamWorkFileImportCover)localObject2).a())) {
        getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(Color.parseColor("#f6f7f9"));
      }
      getSwiftTitleUI().b.setTextSize(18.0F);
      getSwiftTitleUI().b.setTextColor(Color.parseColor("#333333"));
      getSwiftTitleUI().b.setMaxEms(13);
      getSwiftTitleUI().b.getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369252));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(13);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369221));
      this.jdField_d_of_type_Int = ((Intent)localObject1).getIntExtra("key_team_work_pad_list_type", -1);
      boolean bool;
      if ((((Intent)localObject1).getBooleanExtra("temp_preview_from_qq", false)) && (getCurrentUrl() != null) && (getCurrentUrl().contains("preview=1"))) {
        bool = true;
      } else {
        bool = false;
      }
      this.j = bool;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getShareUrl:");
        ((StringBuilder)localObject2).append(getShareUrl());
        ((StringBuilder)localObject2).append("  tempPreviewFromQQ:");
        ((StringBuilder)localObject2).append(this.j);
        QLog.i("WebLog_WebViewFragment", 2, ((StringBuilder)localObject2).toString());
      }
      if (this.j)
      {
        localObject1 = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
        if ((this.jdField_a_of_type_Int == 0) && (localObject1 != null)) {
          if (((TeamWorkFileImportInfo)localObject1).e == 3) {
            this.jdField_a_of_type_Int = 1;
          } else if (((TeamWorkFileImportInfo)localObject1).e == 6) {
            this.jdField_a_of_type_Int = 2;
          }
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover;
        if ((localObject1 != null) && (((TeamWorkFileImportCover)localObject1).a()))
        {
          getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          getSwiftTitleUI().c.setVisibility(8);
          getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        getSwiftTitleUI().c.setVisibility(0);
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        j();
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        getSwiftTitleUI().c.setVisibility(0);
        getSwiftTitleUI().c.setText(HardCodeUtil.a(2131714557));
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714577));
        this.jdField_f_of_type_Int = 1;
        getSwiftTitleUI().c.setOnClickListener(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.9(this));
      }
      else if (((Intent)localObject1).getBooleanExtra("temp_preview_from_qq", false))
      {
        this.jdField_f_of_type_Int = 3;
        j();
      }
      else
      {
        j();
      }
      ((SwiftMiniAIOHandler)getComponentProvider().a(256)).a(true);
    }
  }
  
  private void p()
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(localTeamWorkFileImportInfo, getCurrentUrl(), "0X8009F33");
    q();
  }
  
  private void q()
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
    if (a(localTeamWorkFileImportInfo))
    {
      TenDocLogReportHelper.a(null, "0X800A753");
      ReportController.b(null, "dc00898", "", "", "0X800A757", "0X800A757", 0, 0, "", "", String.valueOf(SystemClock.elapsedRealtime() - localTeamWorkFileImportInfo.c), "");
    }
  }
  
  public void a()
  {
    ImageView localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
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
      com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils.jdField_a_of_type_JavaLangString = paramIntent;
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
      ImageUtil.a(super.getQBaseActivity(), paramIntent);
      if (!FileUtils.isPicFile(paramIntent))
      {
        QQToast.a(super.getActivity(), super.getString(2131692416), 0).b(getWebTitleBarInterface().a());
        return;
      }
      if (!new File(paramIntent).exists()) {
        QQToast.a(super.getActivity(), getString(2131694908), 0).b(getWebTitleBarInterface().a());
      }
    }
    else
    {
      QQToast.a(super.getActivity(), getString(2131694908), 0).b(getWebTitleBarInterface().a());
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
    localIntent.putExtra("LASTFROM", getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.getText().toString());
    super.getQBaseActivity().startActivity(localIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    if (getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView != null) {
      getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690706));
    }
    if (getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView != null) {
      getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if ((getIntent().hasExtra("temp_preview_show_loading")) && ((getUIStyleHandler().d instanceof RelativeLayout)))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover = new TeamWorkFileImportCover((RelativeLayout)getUIStyleHandler().d, getActivity(), (AppInterface)getAppRuntime());
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover.a(paramBundle);
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
      WebViewWrapperForDoc localWebViewWrapperForDoc = this.jdField_a_of_type_ComTencentMobileqqTeamworkWebViewWrapperForDoc;
      if ((localWebViewWrapperForDoc != null) && (localWebViewWrapperForDoc.a() != null)) {
        paramWebViewKernelCallBack.onReceivedTitle(paramWebView, paramWebView.getTitle());
      }
    }
    super.getWebView().callJs("setDocxShareInfo", new String[] { "" });
    if (getSwiftTitleUI().b != null) {
      getSwiftTitleUI().b.clearFocus();
    }
    if (this.jdField_a_of_type_Int == 1) {
      super.getWebView().requestFocus();
    }
    paramWebView = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover;
    if ((paramWebView != null) && (paramWebView.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover.b();
      o();
      int i1 = this.jdField_g_of_type_Int;
      if (i1 != -1000)
      {
        a(this.k, i1);
        h();
      }
      paramWebView = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
      if (a(paramWebView))
      {
        TenDocLogReportHelper.a(null, "0X800A754");
        ReportController.b(null, "dc00898", "", "", "0X800A756", "0X800A756", 0, 0, "", "", String.valueOf(SystemClock.elapsedRealtime() - paramWebView.c), "");
      }
    }
    if ((paramString != null) && ((paramString.contains("/template")) || (paramString.contains("desktop/m/templates_list.html")) || (paramString.contains("docs.qq.com/desktop/m/send.html"))))
    {
      paramWebView = this.jdField_d_of_type_AndroidWidgetImageView;
      if (paramWebView != null) {
        paramWebView.setVisibility(8);
      }
      if (getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView != null) {
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    if (this.i)
    {
      paramWebView = this.jdField_d_of_type_AndroidWidgetImageView;
      if (paramWebView != null) {
        paramWebView.setVisibility(8);
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((getSwiftTitleUI().b != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_f_of_type_Boolean = true;
      getSwiftTitleUI().b.setVisibility(0);
      getSwiftTitleUI().b.setText(paramString);
      paramString = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((getSwiftTitleUI().b != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      b();
      Object localObject = (Share)getShare();
      int i1 = ((Share)localObject).b();
      boolean bool = ((Share)localObject).b();
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
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramString2));
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
        if (TextUtils.isEmpty(paramString1))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  void a(ArrayList<String> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i1);
      CustomWebView localCustomWebView = f(this);
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
    this.n = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.k = paramBoolean;
    this.jdField_g_of_type_Int = paramInt;
    if (getSwiftTitleUI().b == null) {
      return;
    }
    if ((paramBoolean) && (paramInt != 0))
    {
      getSwiftTitleUI().b.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      return;
    }
    Drawable localDrawable;
    if (!paramBoolean) {
      localDrawable = getResources().getDrawable(2130850932);
    } else if (paramInt == 0) {
      localDrawable = getResources().getDrawable(2130850931);
    } else {
      localDrawable = null;
    }
    if (localDrawable != null)
    {
      getSwiftTitleUI().b.setCompoundDrawablePadding(AIOUtils.b(6.0F, getResources()));
      getSwiftTitleUI().b.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    String str = ((Share)getShare()).f();
    if ((paramBoolean) && (!TextUtils.isEmpty(str)))
    {
      a(str);
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      if (this.jdField_f_of_type_Boolean)
      {
        this.jdField_f_of_type_Boolean = false;
        d();
      }
      if (!paramBoolean) {
        a(paramString1, paramString2);
      }
    }
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.mUrl)) {
      if ((TencentDocPreloadConfigProcessor.a().a()) && (!TextUtils.isEmpty(TenDocWebPreLoadHelper.jdField_a_of_type_JavaLangString)) && (this.mUrl.contains(TenDocWebPreLoadHelper.jdField_a_of_type_JavaLangString)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTeamworkWebViewWrapperForDoc.jdField_a_of_type_Boolean) {
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
  
  public void b()
  {
    if (getSwiftTitleUI().b != null) {
      getSwiftTitleUI().b.clearFocus();
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.clearFocus();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt == 2)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      }
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height;
    }
    else if (paramInt == 1)
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height;
    }
    d();
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover;
    if ((paramBundle != null) && (paramBundle.a())) {
      getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
    }
    if (getIntent().getBooleanExtra("temp_preview_show_loading", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "-->service KEY_TEMP_SHOW_LOADING");
      }
      m();
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver);
      if (((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
        n();
      }
    }
    if (getUIStyleHandler().d == null) {
      getUIStyleHandler().d = ((ViewGroup)super.getQBaseActivity().findViewById(2131363807));
    }
    getUIStyleHandler().d.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    LayoutInflater.from(super.getQBaseActivity()).inflate(2131562914, getUIStyleHandler().d);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.TEAM_WORK_WORD_UIN;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 7119;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.getQBaseActivity().findViewById(2131378336));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.getQBaseActivity().findViewById(2131372727));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.getQBaseActivity().findViewById(2131377479));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.getQBaseActivity().findViewById(2131368178));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = ((InputLinearLayout)super.getQBaseActivity().findViewById(2131378358));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.getQBaseActivity().findViewById(2131378357));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(1);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.4(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.getQBaseActivity().findViewById(2131378359));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    int i1 = this.jdField_a_of_type_Int;
    if (i1 == 1)
    {
      super.getWebView().requestFocus();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height;
    }
    else if (i1 == 2)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      }
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height;
    }
    o();
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
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationTencentDocs.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TeamWorkDocEditBrowserActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra(AlbumConstants.h, 55);
    localIntent.putExtra("uin", AppConstants.TEAM_WORK_WORD_UIN);
    localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("LASTFROM", getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.getText().toString());
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
    this.jdField_a_of_type_Boolean = paramBoolean;
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if ((localRelativeLayout != null) && (this.jdField_a_of_type_Int == 1))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        localRelativeLayout.setVisibility(0);
        return;
      }
      localRelativeLayout.setVisibility(8);
    }
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
    if (paramString != null) {}
    try
    {
      QLog.d("WebLog_WebViewFragment", 2, paramString);
      Object localObject = new JSONObject(paramString);
      int i1 = ((JSONObject)localObject).getInt("ret");
      String str = ((JSONObject)localObject).optString("url");
      ((JSONObject)localObject).optString("error");
      if (i1 == 0) {
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, str));
      } else {
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, str));
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
      paramString = this.jdField_a_of_type_AndroidOsHandler;
      paramString.sendMessage(paramString.obtainMessage(3));
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3));
    return;
    label165:
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    InputLinearLayout localInputLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
    if ((localInputLinearLayout != null) && (this.jdField_a_of_type_Int == 2))
    {
      if (this.jdField_b_of_type_Boolean)
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
    this.jdField_a_of_type_ComTencentMobileqqTeamworkWebViewWrapperForDoc = localWebViewWrapperForDoc;
    return localWebViewWrapperForDoc;
  }
  
  public void d()
  {
    if (getSwiftTitleUI() != null)
    {
      if (getSwiftTitleUI().b == null) {
        return;
      }
      if (getSwiftTitleUI().b.isFocused()) {
        getSwiftTitleUI().b.clearFocus();
      }
      TextView localTextView = getSwiftTitleUI().b;
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
      this.j = bool1;
      if (this.j)
      {
        getSwiftTitleUI().b.setText(getResources().getString(2131719572));
        return;
      }
      int i1 = this.jdField_a_of_type_Int;
      if (i1 == 2)
      {
        getSwiftTitleUI().b.setText(2131719570);
        return;
      }
      if (i1 == 1) {
        getSwiftTitleUI().b.setText(2131719570);
      }
    }
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
        if ((((Share)localObject).a() != null) && ((((Share)localObject).a().jdField_a_of_type_Int == 0) || (((Share)localObject).a().jdField_a_of_type_Int == 1)))
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
    if (this.m)
    {
      this.m = false;
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
      getSwiftTitleUI().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.d = false;
      getSwiftTitleUI().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      if (getUIStyleHandler() != null) {
        getUIStyleHandler().k();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long = 8980L;
    if (getSwiftTitleUI().b != null) {
      getSwiftTitleUI().b.clearFocus();
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.jdField_b_of_type_AndroidOsHandler$Callback);
    getIntent().getExtras().setClassLoader(getClass().getClassLoader());
    g();
    return true;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    Object localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject != null)
    {
      localObject = ((WeakReferenceHandler)localObject).obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramIntent;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
    }
  }
  
  public void e()
  {
    if (!getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean)
    {
      super.getActivity().getWindow().setFlags(1024, 1024);
      getUIStyle().jdField_a_of_type_Boolean = true;
      WebViewUIUtils.b(super.getActivity());
      getWebTitleBarInterface().e(false);
    }
  }
  
  public void f()
  {
    if (getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean)
    {
      super.getActivity().getWindow().clearFlags(1024);
      getUIStyle().jdField_a_of_type_Boolean = false;
      WebViewUIUtils.c(super.getActivity());
      getWebTitleBarInterface().e(true);
    }
  }
  
  void g()
  {
    Object localObject1 = super.getCurrentUrl();
    if (localObject1 != null)
    {
      Object localObject2 = ((String)localObject1).split("/");
      if (localObject2 != null) {
        this.jdField_a_of_type_JavaLangString = localObject2[(localObject2.length - 1)];
      }
      localObject2 = Uri.parse((String)localObject1).getQueryParameter("type");
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isDigitsOnly((CharSequence)localObject2))) {
        this.jdField_a_of_type_Int = Integer.valueOf((String)localObject2).intValue();
      }
    }
    if (getAppRuntime() == null) {
      this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    }
    this.jdField_b_of_type_JavaLangString = getAppRuntime().getCurrentAccountUin();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      if (((String)localObject1).contains("docx.qq.com"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("https://");
        ((StringBuilder)localObject1).append(getAppRuntime().getCurrentAccountUin());
        ((StringBuilder)localObject1).append(".docx.qq.com/ep/api/attach_local?tag=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        this.jdField_c_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
      }
      else if (((String)localObject1).contains("docs.qq.com"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("https://");
        ((StringBuilder)localObject1).append(getAppRuntime().getCurrentAccountUin());
        ((StringBuilder)localObject1).append(".docs.qq.com/ep/api/attach_local?tag=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        this.jdField_c_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
      }
    }
    this.i = getQBaseActivity().getIntent().getBooleanExtra("doc_from_forward_dialog", false);
  }
  
  public WebUiUtils.WebTitleBarInterface getWebTitleBarInterface()
  {
    return new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.5(this, this.webViewSurface);
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.6(this, this.webViewSurface);
  }
  
  public void h()
  {
    TeamWorkFileImportCover localTeamWorkFileImportCover = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover;
    if ((localTeamWorkFileImportCover != null) && (localTeamWorkFileImportCover.a())) {
      return;
    }
    if ((!this.j) && (!getUIStyle().e)) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (this.i) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void i()
  {
    getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850933);
    getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.8(this));
  }
  
  public void j()
  {
    Object localObject = this.jdField_d_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(8);
      localObject = new StateListDrawable();
      Drawable localDrawable = getResources().getDrawable(2130851014);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
      localDrawable = getResources().getDrawable(2130851013);
      ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
      localDrawable = getResources().getDrawable(2130851014);
      ((StateListDrawable)localObject).addState(new int[0], localDrawable);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
      localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(16.0F, getResources());
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (SwiftBrowserShareMenuHandler)this.mComponentsProvider.a(4);
      ((SwiftBrowserShareMenuHandler)localObject).b(true);
      ((SwiftBrowserShareMenuHandler)localObject).jdField_b_of_type_Boolean = true;
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.11(this));
    }
  }
  
  void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
    }
    Object localObject = getStatistics();
    this.isDestroyed = true;
    ((SwiftBrowserStatistics)localObject).k = true;
    localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkWebViewWrapperForDoc;
    if (localObject != null)
    {
      ((WebViewWrapperForDoc)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkWebViewWrapperForDoc = null;
      this.webView = null;
    }
    this.mApp = null;
  }
  
  void l()
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
      QQToast.a((Context)localObject1, 2131718574, 0).a();
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
    if (paramView.getId() != 2131369202) {
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
    case 2131378359: 
      localObject2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      try
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("value", localObject2);
        localObject2 = ((JSONObject)localObject3).toString();
        localObject3 = e(this);
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
    case 2131377479: 
      localJSONException.hideSoftInputFromWindow(super.getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
      c(this).clearFocus();
      localObject1 = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
      if (localObject1 != null)
      {
        localObject1 = ((WeakReferenceHandler)localObject1).obtainMessage();
        ((Message)localObject1).what = 3;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed((Message)localObject1, 500L);
      }
      b(false);
      break;
    case 2131372727: 
      if (localObject1 != null) {
        ((InputMethodManager)localObject1).hideSoftInputFromWindow(super.getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
      }
      b(this).clearFocus();
      localObject1 = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
      if (localObject1 != null)
      {
        localObject1 = ((WeakReferenceHandler)localObject1).obtainMessage();
        ((Message)localObject1).what = 2;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed((Message)localObject1, 500L);
      }
      b(false);
      break;
    case 2131369202: 
      if ((this.jdField_f_of_type_Int == 1) && (this.jdField_g_of_type_Boolean))
      {
        a(15);
        localObject1 = (ActionSheet)ActionSheetHelper.a(getQBaseActivity(), null);
        ((ActionSheet)localObject1).setMainTitle(getResources().getString(2131719566));
        ((ActionSheet)localObject1).addButton(getResources().getString(2131719564), 5);
        ((ActionSheet)localObject1).addButton(getResources().getString(2131719513), 5);
        ((ActionSheet)localObject1).addCancelButton(2131690728);
        ((ActionSheet)localObject1).setOnButtonClickListener(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.14(this, (ActionSheet)localObject1));
        ((ActionSheet)localObject1).show();
      }
      else if ((this.jdField_f_of_type_Int == 2) && (this.jdField_g_of_type_Boolean))
      {
        a(15);
        d(2);
        getQBaseActivity().finish();
      }
      else if ((this.jdField_f_of_type_Int == 3) && (this.jdField_g_of_type_Boolean))
      {
        a(15);
        d(3);
        getQBaseActivity().finish();
      }
      else
      {
        localObject1 = (Share)this.share;
        if ((localObject1 != null) && (this.n) && (((Share)localObject1).c()) && (getIntent().getBooleanExtra("key_is_new_pad_flag", false)))
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("savedUrl", getCurrentUrl());
          localObject3 = (TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info");
          if (localObject3 != null)
          {
            if (((Share)localObject1).a() == null) {
              ((TeamWorkFileImportInfo)localObject3).jdField_b_of_type_JavaLangString = "";
            } else {
              ((TeamWorkFileImportInfo)localObject3).jdField_b_of_type_JavaLangString = ((Share)localObject1).a();
            }
            if (((TeamWorkFileImportInfo)localObject3).e == 3) {
              ((Bundle)localObject2).putInt("editType", 1);
            } else if (((TeamWorkFileImportInfo)localObject3).e == 6) {
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
    case 2131368178: 
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(super.getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
      d(this).clearFocus();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @TargetApi(16)
  public void onDestroy()
  {
    p();
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(getIntent(), "0X800A16C");
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver != null) {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver);
    }
    super.onDestroy();
    k();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover;
    if (localObject != null) {
      ((TeamWorkFileImportCover)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject != null)
    {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = null;
    }
    if ((getUIStyleHandler() != null) && (getUIStyleHandler().d != null) && (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)) {
      if (Build.VERSION.SDK_INT < 16) {
        getUIStyleHandler().d.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      } else {
        getUIStyleHandler().d.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.o)
    {
      this.o = false;
      ((Share)this.share).a(1, this.jdField_h_of_type_Int, 1, true);
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
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    getSwiftTitleUI().b.setText("");
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
        localSwiftBrowserShareMenuHandler.a = localTeamWorkShareActionSheetBuilder;
      }
      localSwiftBrowserShareMenuHandler.a(localShare, getUIStyle().jdField_a_of_type_Long);
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(getIntent(), "0X800A16D");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment
 * JD-Core Version:    0.7.0.1
 */