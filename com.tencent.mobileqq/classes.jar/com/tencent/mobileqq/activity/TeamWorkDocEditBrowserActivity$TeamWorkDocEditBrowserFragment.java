package com.tencent.mobileqq.activity;

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
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportCover;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import trx;
import try;
import trz;
import tsa;
import tsb;
import tsc;
import tsd;
import tse;
import tsf;
import tsg;

public class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
  extends WebViewFragment
{
  public int a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new trx(this);
  Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new tsg(this);
  public Button a;
  public EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public InputLinearLayout a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  private TeamWorkFileImportCover jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  String jdField_a_of_type_JavaLangString = "";
  public boolean a;
  public int b;
  Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new trz(this);
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
  private int n = -1;
  private int o = -1000;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v = true;
  private boolean w;
  
  public TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
  }
  
  private void E()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new tsb(this);
  }
  
  private void F()
  {
    Bundle localBundle = new Bundle();
    if (a().getParcelableExtra("key_team_work_file_import_info") != null) {
      localBundle.putParcelable("key_team_work_file_import_info", a().getParcelableExtra("key_team_work_file_import_info"));
    }
    localBundle = DataFactory.a("ipc_cmd_get_team_work_url", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, localBundle);
    WebIPCOperator.a().a(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->service binded  make ipc request");
    }
    this.v = true;
  }
  
  private void G()
  {
    Object localObject = a();
    ColorStateList localColorStateList = getResources().getColorStateList(2131494204);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c.setTextColor(localColorStateList);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130839138);
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover == null) || (!this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover.a())) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(Color.parseColor("#f6f7f9"));
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setTextSize(18.0F);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setTextColor(Color.parseColor("#333333"));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setMaxEms(13);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.getLayoutParams().height = -2;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363451));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(13);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363457));
    this.jdField_d_of_type_Int = ((Intent)localObject).getIntExtra("key_team_work_pad_list_type", -1);
    boolean bool;
    if ((((Intent)localObject).getBooleanExtra("temp_preview_from_qq", false)) && (b() != null) && (b().contains("preview=1")))
    {
      bool = true;
      this.t = bool;
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "getShareUrl:" + e() + "  tempPreviewFromQQ:" + this.t);
      }
      if (!this.t) {
        break label548;
      }
      localObject = (TeamWorkFileImportInfo)a().getParcelableExtra("key_team_work_file_import_info");
      if ((this.jdField_a_of_type_Int == 0) && (localObject != null))
      {
        if (((TeamWorkFileImportInfo)localObject).jdField_d_of_type_Int != 3) {
          break label401;
        }
        this.jdField_a_of_type_Int = 1;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover == null) || (!this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover.a())) {
        break label418;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      bool = false;
      break;
      label401:
      if (((TeamWorkFileImportInfo)localObject).jdField_d_of_type_Int == 6) {
        this.jdField_a_of_type_Int = 2;
      }
    }
    label418:
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    m();
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c.setText("保存");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setText("关闭");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    this.n = 1;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c.setOnClickListener(new tsd(this));
    return;
    label548:
    if (((Intent)localObject).getBooleanExtra("temp_preview_from_qq", false))
    {
      this.n = 3;
      m();
      return;
    }
    m();
  }
  
  private void e(int paramInt)
  {
    String str1;
    String str3;
    String str2;
    Object localObject2;
    SharedPreferences localSharedPreferences;
    switch (paramInt)
    {
    default: 
      str1 = "key_team_work_user_click_count";
      str3 = "tim_convert_teamwork_save_tip_count";
      str2 = "tim_convert_teamwork_save_tip_0";
      localObject2 = "tim_convert_teamwork_save_tip_1";
      localObject1 = "已保存为腾讯文档，可到“我的文件”查看。";
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("tim_convert_teamwork_pre_" + getActivity().getCurrentAccountUin(), 4);
      paramInt = localSharedPreferences.getInt(str1, 0);
      if (paramInt >= localSharedPreferences.getInt(str3, -1)) {
        break label379;
      }
      localObject1 = localSharedPreferences.getString(str2, "");
      localObject2 = localSharedPreferences.getString((String)localObject2, "");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty((CharSequence)localObject2))) {
        break;
      }
    }
    for (Object localObject1 = getResources().getString(2131439129);; localObject1 = (String)localObject1 + "\n" + (String)localObject2)
    {
      localObject2 = new Intent(getActivity(), DialogActivity.class);
      ((Intent)localObject2).addFlags(268435456);
      ((Intent)localObject2).addFlags(536870912);
      ((Intent)localObject2).addFlags(67108864);
      ((Intent)localObject2).addFlags(131072);
      ((Intent)localObject2).putExtra("key_dialog_type", DialogActivity.jdField_d_of_type_Int);
      ((Intent)localObject2).putExtra("key_dialog_title", "腾讯文档保存成功");
      ((Intent)localObject2).putExtra("key_dialog_content", (String)localObject1);
      ((Intent)localObject2).putExtra("key_teamwork_url", i());
      getActivity().startActivity((Intent)localObject2);
      a(20);
      localObject1 = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject1).putInt(str1, paramInt + 1);
      ((SharedPreferences.Editor)localObject1).commit();
      return;
      str1 = "key_team_work_user_click_count";
      str3 = "tim_convert_teamwork_save_tip_count";
      str2 = "tim_convert_teamwork_save_and_close_tip_0";
      localObject2 = "tim_convert_teamwork_save_and_close_tip_1";
      localObject1 = "已保存为腾讯文档，可到“我的文件”查看。";
      break;
      str1 = "key_team_work_content_edit_click_count";
      str3 = "tim_convert_teamwork_content_edit_tip_count";
      str2 = "tim_convert_teamwork_content_edit_tip_0";
      localObject2 = "tim_convert_teamwork_content_edit_tip_1";
      localObject1 = "该腾讯文档已更新，可到“我的文件”查看。";
      break;
    }
    label379:
    QQToast.a(getActivity(), (CharSequence)localObject1, 0).b(getActivity().getResources().getDimensionPixelSize(2131558448));
  }
  
  private void e(String paramString)
  {
    this.t = false;
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c.setOnClickListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130839138);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setText(2131432397);
    this.n = 2;
    i();
    l();
    this.f = false;
    if (!BaseApplicationImpl.getApplication().getSharedPreferences("tim_convert_teamwork_pre_" + getActivity().getCurrentAccountUin(), 4).getBoolean("tim_teamwork_hide_authorize_setting", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private String i()
  {
    String str2 = a().getUrl();
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
  
  protected int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover.a())) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
    }
    if (a().getBooleanExtra("temp_preview_show_loading", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "-->service KEY_TEMP_SHOW_LOADING");
      }
      E();
      WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
      if (WebIPCOperator.a().a()) {
        F();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b == null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b = ((ViewGroup)super.getActivity().findViewById(2131363436));
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    LayoutInflater.from(super.getActivity()).inflate(2130971587, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.R;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 7119;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.getActivity().findViewById(2131375043));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.getActivity().findViewById(2131375044));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.getActivity().findViewById(2131375045));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.getActivity().findViewById(2131375046));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = ((InputLinearLayout)super.getActivity().findViewById(2131375047));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.getActivity().findViewById(2131375049));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(1);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new tsa(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.getActivity().findViewById(2131375050));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.jdField_a_of_type_Int == 1)
    {
      super.a().requestFocus();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height;
    }
    while (this.jdField_a_of_type_Int != 2)
    {
      G();
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
  
  public void a(int paramInt)
  {
    String str = "";
    if (paramInt == 0) {
      str = "0X80074D2";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        ReportController.b(getActivity().app, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if (paramInt == 1) {
        str = "0X80074D3";
      } else if (paramInt == 2) {
        str = "0X80074D4";
      } else if (paramInt == 3) {
        str = "0X80075FF";
      } else if (paramInt == 4) {
        str = "0X80075FE";
      } else if (paramInt == 5) {
        str = "0X8007762";
      } else if (paramInt == 6) {
        str = "0X8007764";
      } else if (paramInt == 7) {
        str = "0X8007763";
      } else if (paramInt == 8) {
        str = "0X8007A29";
      } else if (paramInt == 9) {
        str = "0X8007A2A";
      } else if (paramInt == 10) {
        str = "0X8007A2B";
      } else if (paramInt == 11) {
        str = "0X8007A2C";
      } else if (paramInt == 12) {
        str = "0X8007A30";
      } else if (paramInt == 13) {
        str = "0X8007A31";
      } else if (paramInt == 14) {
        str = "0X8007CE5";
      } else if (paramInt == 15) {
        str = "0X8008A3B";
      } else if (paramInt == 17) {
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
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    b(paramIntent);
  }
  
  public void a(Context paramContext, ArrayList paramArrayList)
  {
    a(paramArrayList);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramIntent;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
    }
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    super.a().a("setDocxShareInfo", new String[] { "" });
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.clearFocus();
    }
    if (this.jdField_a_of_type_Int == 1) {
      super.a().requestFocus();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover.c();
      G();
      if (this.o != -1000)
      {
        a(this.u, this.o);
        k();
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.e = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setText(paramString);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      f();
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
  
  void a(ArrayList paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      k(this).c("readyToInsertImageForNativeJSBridge('" + str + "')");
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.u = paramBoolean;
    this.o = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b == null) {}
    for (;;)
    {
      return;
      Drawable localDrawable;
      if ((!paramBoolean) || (paramInt == 0)) {
        if (!paramBoolean) {
          localDrawable = getResources().getDrawable(2130846026);
        }
      }
      while (localDrawable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setCompoundDrawablePadding(AIOUtils.a(6.0F, getResources()));
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
        return;
        if (paramInt == 0)
        {
          localDrawable = getResources().getDrawable(2130846025);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
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
      if (this.e)
      {
        this.e = false;
        i();
      }
    } while (paramBoolean);
    a(paramString1, paramString2);
  }
  
  protected boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    a(8980L);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.clearFocus();
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.jdField_b_of_type_AndroidOsHandler$Callback);
    a().getExtras().setClassLoader(getClass().getClassLoader());
    j();
    return true;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 1) {
      a(this).requestFocus();
    }
    if (this.jdField_a_of_type_Int == 2) {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
        this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height;
      }
    }
    for (;;)
    {
      i();
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
      com.tencent.mobileqq.activity.aio.PlusPanelUtils.jdField_a_of_type_JavaLangString = (String)localObject;
      paramIntent = Uri.fromFile(new File((String)localObject));
    }
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().remove("camera_photo_path").commit();
    if (paramIntent == null) {
      return;
    }
    paramIntent = ImageUtil.b(BaseApplicationImpl.getApplication(), paramIntent);
    if (paramIntent != null)
    {
      ImageUtil.a(super.getActivity(), paramIntent);
      if (!FileUtils.e(paramIntent))
      {
        QQToast.a(super.getActivity(), super.getString(2131434487), 0).b(b());
        return;
      }
      if (!new File(paramIntent).exists()) {
        QQToast.a(super.getActivity(), getString(2131434488), 0).b(b());
      }
    }
    else
    {
      QQToast.a(super.getActivity(), getString(2131434488), 0).b(b());
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
    ((Intent)localObject).putExtra(AlbumConstants.h, 55);
    ((Intent)localObject).putExtra("uin", AppConstants.R);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    ((Intent)localObject).putExtra("LASTFROM", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
    super.getActivity().startActivity((Intent)localObject);
  }
  
  public void b(String paramString)
  {
    a(17);
    ThreadManager.executeOnNetWorkThread(new tse(this, paramString));
  }
  
  public void b(ArrayList paramArrayList)
  {
    Intent localIntent = new Intent(super.getActivity(), PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TeamWorkDocEditBrowserActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra(AlbumConstants.h, 55);
    localIntent.putExtra("uin", AppConstants.R);
    localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("LASTFROM", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.putExtra("PhotoConst.original_button", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    }
    super.startActivity(localIntent);
    AlbumUtil.a(super.getActivity(), false, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.w = paramBoolean;
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
  
  protected int e(Bundle paramBundle)
  {
    int i = super.e(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131433681));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if ((a().hasExtra("temp_preview_show_loading")) && ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b instanceof RelativeLayout)))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover = new TeamWorkFileImportCover((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover.a(paramBundle);
    }
    return i;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.clearFocus();
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.clearFocus();
    }
  }
  
  public void h()
  {
    this.f = true;
  }
  
  public void i()
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 1) {
        a().requestFocus();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.isFocused()) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.clearFocus();
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setVisibility(0);
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
      this.t = bool1;
      if (this.t)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setText(getResources().getString(2131439126));
        return;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setText(2131439125);
        return;
      }
    } while (this.jdField_a_of_type_Int != 1);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setText(2131439124);
  }
  
  void j()
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
        break label166;
      }
      this.jdField_c_of_type_JavaLangString = ("https://" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + ".docx.qq.com/ep/api/attach_local?tag=" + this.jdField_a_of_type_JavaLangString);
    }
    label166:
    while (!str.contains("docs.qq.com")) {
      return;
    }
    this.jdField_c_of_type_JavaLangString = ("https://" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + ".docs.qq.com/ep/api/attach_local?tag=" + this.jdField_a_of_type_JavaLangString);
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover.a())) {}
    label141:
    label180:
    label195:
    label208:
    for (;;)
    {
      return;
      a();
      String str = e();
      boolean bool1;
      if ((!TextUtils.isEmpty(str)) && (str.contains(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
      {
        bool1 = true;
        boolean bool2 = BaseApplicationImpl.getApplication().getSharedPreferences("tim_convert_teamwork_pre_" + getActivity().getCurrentAccountUin(), 4).getBoolean("tim_teamwork_hide_authorize_setting", false);
        if (!TextUtils.isEmpty(str))
        {
          if ((!bool1) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView == null) || (this.t)) {
            break label195;
          }
          if (bool2) {
            break label180;
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          l();
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c.setVisibility(8);
        }
      }
      for (;;)
      {
        if (this.t) {
          break label208;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
        bool1 = a().c();
        break;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label141;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846027);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new tsc(this));
  }
  
  public void m()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      Object localObject = new StateListDrawable();
      Drawable localDrawable = getResources().getDrawable(2130846133);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
      localDrawable = getResources().getDrawable(2130846132);
      ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
      localDrawable = getResources().getDrawable(2130846133);
      ((StateListDrawable)localObject).addState(new int[0], localDrawable);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
      localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(16.0F, getResources());
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
      ((SwiftBrowserShareMenuHandler)localObject).a(true);
      ((SwiftBrowserShareMenuHandler)localObject).jdField_b_of_type_Boolean = true;
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new tsf(this));
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())
    {
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("target", Integer.valueOf(2));
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.a(localHashMap)) {
        o();
      }
    }
    super.n();
  }
  
  protected void o()
  {
    super.o();
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setText("");
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131363227) {
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
      if ((this.n == 1) && (this.f))
      {
        a(15);
        paramView = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
        paramView.a(getResources().getString(2131439128));
        paramView.a(getResources().getString(2131439130), 5);
        paramView.a(getResources().getString(2131439131), 5);
        paramView.c(2131432998);
        paramView.a(new try(this, paramView));
        paramView.show();
        return;
      }
      if ((this.n == 2) && (this.f))
      {
        a(15);
        e(2);
        getActivity().finish();
        return;
      }
      if ((this.n == 3) && (this.f))
      {
        a(15);
        e(3);
        getActivity().finish();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare != null) && (this.w) && (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c()) && (a().getBooleanExtra("key_is_new_pad_flag", false)))
      {
        paramView = new Bundle();
        paramView.putString("savedUrl", b());
        localObject = (TeamWorkFileImportInfo)a().getParcelableExtra("key_team_work_file_import_info");
        if (localObject != null)
        {
          if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b() != null) {
            break label391;
          }
          ((TeamWorkFileImportInfo)localObject).jdField_b_of_type_JavaLangString = "";
          if (((TeamWorkFileImportInfo)localObject).jdField_d_of_type_Int != 3) {
            break label405;
          }
          paramView.putInt("editType", 1);
        }
      }
      for (;;)
      {
        paramView.putParcelable("key_team_work_file_import_info", (Parcelable)localObject);
        paramView = DataFactory.a("ipc_save_team_work", "", -1, paramView);
        WebIPCOperator.a().a(paramView);
        n();
        return;
        ((TeamWorkFileImportInfo)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b();
        break;
        if (((TeamWorkFileImportInfo)localObject).jdField_d_of_type_Int == 6) {
          paramView.putInt("editType", 2);
        }
      }
      if (paramView != null) {
        paramView.hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
      }
      g(this).clearFocus();
      if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        paramView = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        paramView.what = 2;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(paramView, 500L);
      }
      c(false);
      return;
      paramView.hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
      h(this).clearFocus();
      if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        paramView = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        paramView.what = 3;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(paramView, 500L);
      }
      c(false);
      return;
      paramView.hideSoftInputFromWindow(super.getActivity().getWindow().getDecorView().getWindowToken(), 0);
      i(this).clearFocus();
      return;
      Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("value", localObject);
        localObject = localJSONObject.toString();
        j(this).c("setCellValue(" + (String)localObject + ")");
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
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportCover.a();
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b != null) && (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null))
    {
      if (Build.VERSION.SDK_INT >= 16) {
        break label101;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      return;
      label101:
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void onStop()
  {
    if (super.a() != null) {
      super.a().clearFocus();
    }
    super.onStop();
  }
  
  public void p()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return;
    }
    Object localObject1 = super.getActivity();
    Object localObject2 = new File(AppConstants.aJ + "photo/");
    if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs()))
    {
      QQToast.a((Context)localObject1, 2131434753, 0).a();
      return;
    }
    localObject2 = AppConstants.aJ + "photo/" + System.currentTimeMillis() + ".jpg";
    localObject1 = Uri.fromFile(new File((String)localObject2));
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().putString("camera_photo_path", (String)localObject2).commit();
    localObject2 = new Intent("android.media.action.IMAGE_CAPTURE");
    ((Intent)localObject2).putExtra("output", (Parcelable)localObject1);
    ((Intent)localObject2).putExtra("android.intent.extra.videoQuality", 100);
    super.getActivity().startActivityForResult((Intent)localObject2, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment
 * JD-Core Version:    0.7.0.1
 */