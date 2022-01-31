package com.tencent.mobileqq.armap;

import abdg;
import abdh;
import abdi;
import abdj;
import abdk;
import abdl;
import abdm;
import abdn;
import abdo;
import abdp;
import abdq;
import abdr;
import abds;
import abdu;
import abdv;
import abdw;
import abdx;
import abdy;
import abeb;
import abec;
import abed;
import abei;
import abej;
import abek;
import abel;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.ARTransparentWebviewPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.ar.ARArguments;
import com.tencent.mobileqq.ar.ARGlobalRemoteManager;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderTrackInfo;
import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.ar.ARScanFragment.ARScanFragmentCallback;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.mobileqq.ar.arengine.ARLocalRecogResultBase;
import com.tencent.mobileqq.ar.model.ArAwardInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoLogListener;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.mobileqq.olympic.activity.ScreenshotObserver;
import com.tencent.mobileqq.olympic.activity.ScreenshotObserver.Listener;
import com.tencent.mobileqq.olympic.activity.ShopScanToolBaseActivity;
import com.tencent.mobileqq.scanfu.view.CameraDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.ArrayList;
import mqq.app.QQBroadcastReceiver;

public class ShopScanActivity
  extends ShopScanToolBaseActivity
  implements Handler.Callback, View.OnClickListener, ARScanFragment.ARScanFragmentCallback, AREngineCallback, ScreenshotObserver.Listener
{
  public int a;
  public long a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  public ARArguments a;
  public ARScanFragment a;
  private ARTarget jdField_a_of_type_ComTencentMobileqqArARTarget;
  public RemoteArConfigManager a;
  private ArCloudConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  private ArConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
  private ArEffectConfig jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
  private AROnlineVideoLogListener jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoLogListener;
  ArMapObserver jdField_a_of_type_ComTencentMobileqqArmapArMapObserver = new abdy(this);
  public ScanSuccessView a;
  public ShopScanDragView a;
  private ScreenshotObserver jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver;
  public QQProgressDialog a;
  public String a;
  private QQBroadcastReceiver jdField_a_of_type_MqqAppQQBroadcastReceiver = new abdx(this);
  public boolean a;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  public LinearLayout b;
  public RelativeLayout b;
  public TextView b;
  protected TouchWebView b;
  public String b;
  int c;
  public View c;
  public RelativeLayout c;
  public TextView c;
  public String c;
  int d;
  public RelativeLayout d;
  public TextView d;
  private int e;
  public RelativeLayout e;
  public TextView e;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long = -1L;
  public TextView f;
  private long g;
  public TextView g;
  public String g;
  public boolean g;
  private long jdField_h_of_type_Long = -1L;
  public TextView h;
  private String jdField_h_of_type_JavaLangString;
  public boolean h;
  private long jdField_i_of_type_Long;
  private String jdField_i_of_type_JavaLangString;
  public boolean i;
  private long jdField_j_of_type_Long;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean;
  private long jdField_k_of_type_Long = -1L;
  private String jdField_k_of_type_JavaLangString;
  private boolean jdField_k_of_type_Boolean = true;
  private String jdField_l_of_type_JavaLangString;
  private boolean jdField_l_of_type_Boolean = true;
  private String jdField_m_of_type_JavaLangString;
  private boolean jdField_m_of_type_Boolean;
  private String jdField_n_of_type_JavaLangString;
  private boolean jdField_n_of_type_Boolean;
  private String jdField_o_of_type_JavaLangString;
  private boolean jdField_o_of_type_Boolean;
  private boolean p;
  private boolean q;
  private boolean r = true;
  private boolean s;
  
  public ShopScanActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_g_of_type_Long = -1L;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
  }
  
  private void a(ArCloudConfigInfo paramArCloudConfigInfo, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleNoFeatureTrackOpenPOICompleted success: ").append(paramBoolean).append("  noTrackMode?");
      if ((paramArCloudConfigInfo == null) || (paramArCloudConfigInfo.d())) {
        break label117;
      }
    }
    label117:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("ShopScanActivity", 2, bool);
      if ((!paramBoolean) && (paramArCloudConfigInfo != null) && (!paramArCloudConfigInfo.d()) && (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null))
      {
        if ((paramArCloudConfigInfo.jdField_a_of_type_Int != 1) || (paramArCloudConfigInfo.jdField_e_of_type_Int != 0)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(true);
        if (QLog.isColorLevel()) {
          QLog.d("ShopScanActivity", 2, "onNoFeatureTrackAnimOpenPOICompleted notPlayModel");
        }
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.d(paramBoolean);
  }
  
  private void a(ItemInfo paramItemInfo)
  {
    boolean bool = false;
    Object localObject1;
    if ((paramItemInfo == null) || (isFinishing())) {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("showInfoDialog itemInfo == null ? ");
        if (paramItemInfo == null) {
          bool = true;
        }
        QLog.i("ShopScanActivity", 2, bool);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ShopScanActivity", 2, "showInfoDialog itemInfo: " + paramItemInfo);
      }
      Object localObject2;
      if ((paramItemInfo.jdField_b_of_type_Int == 2) || (paramItemInfo.jdField_b_of_type_Int == 6) || (paramItemInfo.jdField_b_of_type_Int == 7))
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null) {
          this.jdField_a_of_type_AndroidAppDialog = new ARMapOpenRedPackDialog(this, this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface);
        }
        for (;;)
        {
          Object localObject3 = (ArCloudConfigInfo)this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.mArCloudConfigInfos.get(0);
          if (((ArCloudConfigInfo)localObject3).jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo == null) {
            break;
          }
          localObject1 = ((ArCloudConfigInfo)localObject3).jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_c_of_type_JavaLangString;
          localObject2 = ((ArCloudConfigInfo)localObject3).jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.e;
          String str = ((ArCloudConfigInfo)localObject3).jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.f;
          localObject3 = ((ArCloudConfigInfo)localObject3).jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.d;
          ((ARMapOpenRedPackDialog)this.jdField_a_of_type_AndroidAppDialog).a((String)localObject1, (String)localObject2, str, (String)localObject3, paramItemInfo);
          this.jdField_a_of_type_AndroidAppDialog.show();
          return;
          if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
            this.jdField_a_of_type_AndroidAppDialog.dismiss();
          }
        }
      }
      if (paramItemInfo.jdField_b_of_type_Int == 4)
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null) {
          this.jdField_a_of_type_AndroidAppDialog = new ARMapOpenKaquanDialog(this);
        }
        for (;;)
        {
          localObject2 = (ArCloudConfigInfo)this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.mArCloudConfigInfos.get(0);
          if (((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo == null) {
            break;
          }
          localObject1 = ((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_c_of_type_JavaLangString;
          localObject2 = ((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.e;
          ((ARMapOpenKaquanDialog)this.jdField_a_of_type_AndroidAppDialog).a((String)localObject1, (String)localObject2, paramItemInfo.jdField_a_of_type_JavaLangString, paramItemInfo.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidAppDialog.show();
          return;
          if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
            this.jdField_a_of_type_AndroidAppDialog.dismiss();
          }
        }
      }
      if (paramItemInfo.jdField_b_of_type_Int == 5)
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null) {
          this.jdField_a_of_type_AndroidAppDialog = new ARMapOpenCardDialog(this);
        }
        for (;;)
        {
          ((ARMapOpenCardDialog)this.jdField_a_of_type_AndroidAppDialog).a(paramItemInfo);
          this.jdField_a_of_type_AndroidAppDialog.show();
          return;
          if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
            this.jdField_a_of_type_AndroidAppDialog.dismiss();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShopScanActivity", 2, "showInfoDialog unkown type: " + paramItemInfo);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "showArProgress");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("ShopScanActivity", 2, paramString.toString());
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i3 = 1;
    int i2 = 0;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_g_of_type_JavaLangString = paramString4;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      i1 = 1;
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label160;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      i1 = 1;
      label91:
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break label172;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      i1 = i3;
      label124:
      paramString1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (i1 == 0) {
        break label184;
      }
    }
    label160:
    label172:
    label184:
    for (int i1 = i2;; i1 = 4)
    {
      paramString1.setVisibility(i1);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      i1 = 0;
      break;
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label91;
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      break label124;
    }
  }
  
  private String b(String paramString)
  {
    paramString = new StringBuilder(paramString);
    paramString.append("?_wv=");
    paramString.append(Integer.toString(17367040));
    return paramString.toString();
  }
  
  private void b(String paramString)
  {
    QLog.d("ShopScanActivity", 1, "scanTorch preLaunchToQQBrowseActivity ");
    paramString = b(paramString);
    this.jdField_b_of_type_ComTencentBizUiTouchWebView.onResume();
    this.jdField_b_of_type_ComTencentBizUiTouchWebView.loadUrl(paramString);
  }
  
  private void c(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppProgressDialog == null)
    {
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131624516);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969180);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363399)).setText(paramString);
    if (!isFinishing()) {
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i3 = 1;
    int i2 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo == null) {
      return;
    }
    label87:
    label125:
    LinearLayout localLinearLayout;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLine1))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLine1);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      i1 = 1;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLine2)) {
        break label169;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLine2);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      i1 = 1;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLineLink)) {
        break label181;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLineLink);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      i1 = i3;
      this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLinkUrl;
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (i1 == 0) {
        break label193;
      }
    }
    label169:
    label181:
    label193:
    for (int i1 = i2;; i1 = 4)
    {
      localLinearLayout.setVisibility(i1);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      i1 = 0;
      break;
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label87;
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      break label125;
    }
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.jdField_f_of_type_Int = localIntent.getIntExtra("taskType", 0);
      this.jdField_i_of_type_Long = localIntent.getLongExtra("taskId", 0L);
      this.jdField_j_of_type_Long = localIntent.getLongExtra("poiId", 0L);
      this.jdField_h_of_type_JavaLangString = localIntent.getStringExtra("tips");
      this.jdField_i_of_type_JavaLangString = localIntent.getStringExtra("logoUrl");
      this.jdField_k_of_type_JavaLangString = localIntent.getStringExtra("imageUrl");
      this.jdField_j_of_type_JavaLangString = localIntent.getStringExtra("logoPath");
      this.jdField_l_of_type_JavaLangString = localIntent.getStringExtra("imagePath");
      this.jdField_m_of_type_JavaLangString = localIntent.getStringExtra("shopName");
      this.jdField_n_of_type_JavaLangString = localIntent.getStringExtra("shopLocation");
      this.jdField_o_of_type_JavaLangString = localIntent.getStringExtra("xmlContent");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShopScanActivity", 2, new Object[] { "initData taskType: ", Integer.valueOf(this.jdField_f_of_type_Int), ", taskId: ", Long.valueOf(this.jdField_i_of_type_Long), ", poiId: ", Long.valueOf(this.jdField_j_of_type_Long), ", logoUrl: ", this.jdField_i_of_type_JavaLangString, ", imageUrl: ", this.jdField_k_of_type_JavaLangString, ", logoPath: ", this.jdField_j_of_type_JavaLangString, ", imagePath: ", this.jdField_l_of_type_JavaLangString, ", shopName: ", this.jdField_m_of_type_JavaLangString, ", shopLocation: ", this.jdField_n_of_type_JavaLangString, ", tips: ", this.jdField_h_of_type_JavaLangString, ", xmlContent: ", this.jdField_o_of_type_JavaLangString });
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
      this.jdField_a_of_type_ComTencentMobileqqArARArguments = new ARArguments(false);
      this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager = new RemoteArConfigManager();
      this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a(this, false, new abdg(this));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ShopScanActivity", 2, "initData intent == null");
      }
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: ldc_w 522
    //   5: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   8: checkcast 525	android/widget/RelativeLayout
    //   11: putfield 527	com/tencent/mobileqq/armap/ShopScanActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   14: aload_0
    //   15: aload_0
    //   16: ldc_w 528
    //   19: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   22: checkcast 525	android/widget/RelativeLayout
    //   25: putfield 530	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   28: aload_0
    //   29: aload_0
    //   30: ldc_w 531
    //   33: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   36: checkcast 303	android/widget/TextView
    //   39: putfield 533	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   42: aload_0
    //   43: aload_0
    //   44: ldc_w 534
    //   47: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   50: checkcast 303	android/widget/TextView
    //   53: putfield 536	com/tencent/mobileqq/armap/ShopScanActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   56: aload_0
    //   57: aload_0
    //   58: ldc_w 537
    //   61: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   64: checkcast 303	android/widget/TextView
    //   67: putfield 301	com/tencent/mobileqq/armap/ShopScanActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   70: aload_0
    //   71: aload_0
    //   72: ldc_w 538
    //   75: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   78: checkcast 303	android/widget/TextView
    //   81: putfield 313	com/tencent/mobileqq/armap/ShopScanActivity:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   84: aload_0
    //   85: aload_0
    //   86: ldc_w 539
    //   89: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   92: checkcast 303	android/widget/TextView
    //   95: putfield 315	com/tencent/mobileqq/armap/ShopScanActivity:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   98: aload_0
    //   99: aload_0
    //   100: ldc_w 540
    //   103: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   106: checkcast 525	android/widget/RelativeLayout
    //   109: putfield 542	com/tencent/mobileqq/armap/ShopScanActivity:jdField_c_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   112: aload_0
    //   113: aload_0
    //   114: ldc_w 543
    //   117: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   120: checkcast 319	android/widget/LinearLayout
    //   123: putfield 317	com/tencent/mobileqq/armap/ShopScanActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   126: aload_0
    //   127: aload_0
    //   128: ldc_w 544
    //   131: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   134: checkcast 525	android/widget/RelativeLayout
    //   137: putfield 546	com/tencent/mobileqq/armap/ShopScanActivity:jdField_d_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   140: aload_0
    //   141: aload_0
    //   142: ldc_w 547
    //   145: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   148: checkcast 319	android/widget/LinearLayout
    //   151: putfield 549	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   154: aload_0
    //   155: aload_0
    //   156: ldc_w 550
    //   159: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   162: checkcast 525	android/widget/RelativeLayout
    //   165: putfield 552	com/tencent/mobileqq/armap/ShopScanActivity:jdField_e_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   168: aload_0
    //   169: aload_0
    //   170: ldc_w 553
    //   173: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   176: checkcast 555	android/widget/ProgressBar
    //   179: putfield 557	com/tencent/mobileqq/armap/ShopScanActivity:jdField_a_of_type_AndroidWidgetProgressBar	Landroid/widget/ProgressBar;
    //   182: aload_0
    //   183: aload_0
    //   184: ldc_w 558
    //   187: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   190: checkcast 303	android/widget/TextView
    //   193: putfield 560	com/tencent/mobileqq/armap/ShopScanActivity:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   196: aload_0
    //   197: aload_0
    //   198: ldc_w 561
    //   201: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   204: checkcast 563	android/widget/ImageView
    //   207: putfield 565	com/tencent/mobileqq/armap/ShopScanActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   210: aload_0
    //   211: getfield 565	com/tencent/mobileqq/armap/ShopScanActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   214: aload_0
    //   215: invokevirtual 569	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   218: aload_0
    //   219: aload_0
    //   220: ldc_w 570
    //   223: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   226: checkcast 303	android/widget/TextView
    //   229: putfield 572	com/tencent/mobileqq/armap/ShopScanActivity:jdField_h_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   232: aload_0
    //   233: getfield 572	com/tencent/mobileqq/armap/ShopScanActivity:jdField_h_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   236: aload_0
    //   237: invokevirtual 573	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   240: aload_0
    //   241: aload_0
    //   242: ldc_w 574
    //   245: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   248: checkcast 303	android/widget/TextView
    //   251: putfield 576	com/tencent/mobileqq/armap/ShopScanActivity:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   254: aload_0
    //   255: getfield 576	com/tencent/mobileqq/armap/ShopScanActivity:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   258: bipush 8
    //   260: invokevirtual 311	android/widget/TextView:setVisibility	(I)V
    //   263: aload_0
    //   264: getfield 533	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   267: ldc_w 578
    //   270: invokevirtual 307	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   273: aload_0
    //   274: getfield 533	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   277: iconst_4
    //   278: invokevirtual 311	android/widget/TextView:setVisibility	(I)V
    //   281: aload_0
    //   282: getfield 301	com/tencent/mobileqq/armap/ShopScanActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   285: aload_0
    //   286: getfield 288	com/tencent/mobileqq/armap/ShopScanActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   289: invokevirtual 307	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   292: aload_0
    //   293: getfield 536	com/tencent/mobileqq/armap/ShopScanActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   296: aload_0
    //   297: invokevirtual 573	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   300: aload_0
    //   301: getfield 315	com/tencent/mobileqq/armap/ShopScanActivity:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   304: aload_0
    //   305: invokevirtual 573	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   308: aload_0
    //   309: getfield 542	com/tencent/mobileqq/armap/ShopScanActivity:jdField_c_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   312: iconst_1
    //   313: invokevirtual 581	android/widget/RelativeLayout:setClickable	(Z)V
    //   316: aload_0
    //   317: getfield 542	com/tencent/mobileqq/armap/ShopScanActivity:jdField_c_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   320: aload_0
    //   321: invokevirtual 582	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   324: aload_0
    //   325: ldc_w 583
    //   328: invokevirtual 584	com/tencent/mobileqq/armap/ShopScanActivity:findViewById	(I)Landroid/view/View;
    //   331: aload_0
    //   332: invokevirtual 587	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   335: aload_0
    //   336: aload_0
    //   337: ldc_w 588
    //   340: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   343: checkcast 590	com/tencent/mobileqq/armap/ShopScanDragView
    //   346: putfield 592	com/tencent/mobileqq/armap/ShopScanActivity:jdField_a_of_type_ComTencentMobileqqArmapShopScanDragView	Lcom/tencent/mobileqq/armap/ShopScanDragView;
    //   349: aload_0
    //   350: aload_0
    //   351: ldc_w 593
    //   354: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   357: putfield 595	com/tencent/mobileqq/armap/ShopScanActivity:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   360: aload_0
    //   361: getfield 595	com/tencent/mobileqq/armap/ShopScanActivity:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   364: aload_0
    //   365: invokevirtual 587	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   368: aload_0
    //   369: invokestatic 601	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   372: ldc_w 602
    //   375: aconst_null
    //   376: invokevirtual 606	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   379: astore_2
    //   380: aload_0
    //   381: aload_2
    //   382: ldc_w 607
    //   385: invokevirtual 608	android/view/View:findViewById	(I)Landroid/view/View;
    //   388: putfield 610	com/tencent/mobileqq/armap/ShopScanActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   391: aload_0
    //   392: aload_2
    //   393: ldc_w 611
    //   396: invokevirtual 608	android/view/View:findViewById	(I)Landroid/view/View;
    //   399: putfield 613	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   402: aload_0
    //   403: getfield 592	com/tencent/mobileqq/armap/ShopScanActivity:jdField_a_of_type_ComTencentMobileqqArmapShopScanDragView	Lcom/tencent/mobileqq/armap/ShopScanDragView;
    //   406: aload_2
    //   407: new 615	android/widget/RelativeLayout$LayoutParams
    //   410: dup
    //   411: iconst_m1
    //   412: bipush 254
    //   414: invokespecial 618	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   417: invokevirtual 622	com/tencent/mobileqq/armap/ShopScanDragView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   420: aload_0
    //   421: getfield 592	com/tencent/mobileqq/armap/ShopScanActivity:jdField_a_of_type_ComTencentMobileqqArmapShopScanDragView	Lcom/tencent/mobileqq/armap/ShopScanDragView;
    //   424: aload_0
    //   425: getfield 610	com/tencent/mobileqq/armap/ShopScanActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   428: aload_0
    //   429: getfield 613	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   432: invokevirtual 626	com/tencent/mobileqq/armap/ShopScanDragView:setAnimView	(Landroid/view/View;Landroid/view/View;)V
    //   435: aload_2
    //   436: ldc_w 627
    //   439: invokevirtual 608	android/view/View:findViewById	(I)Landroid/view/View;
    //   442: checkcast 303	android/widget/TextView
    //   445: astore_1
    //   446: aload_2
    //   447: ldc_w 628
    //   450: invokevirtual 608	android/view/View:findViewById	(I)Landroid/view/View;
    //   453: checkcast 303	android/widget/TextView
    //   456: astore_3
    //   457: aload_1
    //   458: aload_0
    //   459: getfield 431	com/tencent/mobileqq/armap/ShopScanActivity:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   462: invokevirtual 307	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   465: aload_3
    //   466: aload_0
    //   467: getfield 431	com/tencent/mobileqq/armap/ShopScanActivity:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   470: invokevirtual 307	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   473: aload_0
    //   474: getfield 443	com/tencent/mobileqq/armap/ShopScanActivity:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   477: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   480: ifne +253 -> 733
    //   483: aload_0
    //   484: getfield 443	com/tencent/mobileqq/armap/ShopScanActivity:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   487: invokestatic 633	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   490: astore_1
    //   491: aload_2
    //   492: ldc_w 634
    //   495: invokevirtual 608	android/view/View:findViewById	(I)Landroid/view/View;
    //   498: checkcast 563	android/widget/ImageView
    //   501: aload_1
    //   502: invokevirtual 638	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   505: aload_0
    //   506: getfield 447	com/tencent/mobileqq/armap/ShopScanActivity:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   509: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   512: ifne +303 -> 815
    //   515: aload_0
    //   516: getfield 447	com/tencent/mobileqq/armap/ShopScanActivity:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   519: invokestatic 633	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   522: astore_1
    //   523: aload_2
    //   524: ldc_w 639
    //   527: invokevirtual 608	android/view/View:findViewById	(I)Landroid/view/View;
    //   530: checkcast 563	android/widget/ImageView
    //   533: aload_1
    //   534: invokevirtual 638	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   537: aload_2
    //   538: ldc_w 640
    //   541: invokevirtual 608	android/view/View:findViewById	(I)Landroid/view/View;
    //   544: checkcast 303	android/widget/TextView
    //   547: aload_0
    //   548: getfield 328	com/tencent/mobileqq/armap/ShopScanActivity:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   551: invokevirtual 307	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   554: aload_2
    //   555: ldc_w 641
    //   558: invokevirtual 608	android/view/View:findViewById	(I)Landroid/view/View;
    //   561: checkcast 303	android/widget/TextView
    //   564: aload_0
    //   565: getfield 453	com/tencent/mobileqq/armap/ShopScanActivity:jdField_n_of_type_JavaLangString	Ljava/lang/String;
    //   568: invokevirtual 307	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   571: aload_0
    //   572: ldc_w 642
    //   575: invokespecial 523	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:findViewById	(I)Landroid/view/View;
    //   578: checkcast 644	android/widget/FrameLayout
    //   581: astore_1
    //   582: new 615	android/widget/RelativeLayout$LayoutParams
    //   585: dup
    //   586: iconst_m1
    //   587: iconst_m1
    //   588: invokespecial 618	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   591: astore_2
    //   592: aload_0
    //   593: aload_0
    //   594: aconst_null
    //   595: invokespecial 647	com/tencent/mobileqq/olympic/activity/ShopScanToolBaseActivity:b	(Landroid/view/ViewGroup;)Lcom/tencent/biz/ui/TouchWebView;
    //   598: putfield 347	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_ComTencentBizUiTouchWebView	Lcom/tencent/biz/ui/TouchWebView;
    //   601: aload_1
    //   602: aload_0
    //   603: getfield 347	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_ComTencentBizUiTouchWebView	Lcom/tencent/biz/ui/TouchWebView;
    //   606: aload_2
    //   607: invokevirtual 648	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   610: aload_0
    //   611: getfield 347	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_ComTencentBizUiTouchWebView	Lcom/tencent/biz/ui/TouchWebView;
    //   614: iconst_0
    //   615: invokevirtual 651	com/tencent/biz/ui/TouchWebView:setBackgroundColor	(I)V
    //   618: aload_0
    //   619: getfield 347	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_ComTencentBizUiTouchWebView	Lcom/tencent/biz/ui/TouchWebView;
    //   622: iconst_4
    //   623: invokevirtual 652	com/tencent/biz/ui/TouchWebView:setVisibility	(I)V
    //   626: aload_0
    //   627: getfield 347	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_ComTencentBizUiTouchWebView	Lcom/tencent/biz/ui/TouchWebView;
    //   630: invokevirtual 656	com/tencent/biz/ui/TouchWebView:getBackground	()Landroid/graphics/drawable/Drawable;
    //   633: ifnull +14 -> 647
    //   636: aload_0
    //   637: getfield 347	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_ComTencentBizUiTouchWebView	Lcom/tencent/biz/ui/TouchWebView;
    //   640: invokevirtual 656	com/tencent/biz/ui/TouchWebView:getBackground	()Landroid/graphics/drawable/Drawable;
    //   643: iconst_0
    //   644: invokevirtual 661	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   647: aload_0
    //   648: getfield 347	com/tencent/mobileqq/armap/ShopScanActivity:jdField_b_of_type_ComTencentBizUiTouchWebView	Lcom/tencent/biz/ui/TouchWebView;
    //   651: aconst_null
    //   652: invokevirtual 665	com/tencent/biz/ui/TouchWebView:setOnScrollChangedListener	(Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;)V
    //   655: aload_0
    //   656: invokespecial 361	com/tencent/mobileqq/armap/ShopScanActivity:i	()V
    //   659: aload_0
    //   660: invokespecial 396	com/tencent/mobileqq/armap/ShopScanActivity:k	()V
    //   663: invokestatic 670	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   666: iconst_1
    //   667: if_icmpne +55 -> 722
    //   670: aload_0
    //   671: ldc_w 671
    //   674: invokevirtual 584	com/tencent/mobileqq/armap/ShopScanActivity:findViewById	(I)Landroid/view/View;
    //   677: iconst_0
    //   678: aload_0
    //   679: invokestatic 674	com/tencent/widget/immersive/ImmersiveUtils:a	(Landroid/content/Context;)I
    //   682: iconst_0
    //   683: iconst_0
    //   684: invokevirtual 678	android/view/View:setPadding	(IIII)V
    //   687: aload_0
    //   688: ldc_w 540
    //   691: invokevirtual 584	com/tencent/mobileqq/armap/ShopScanActivity:findViewById	(I)Landroid/view/View;
    //   694: iconst_0
    //   695: aload_0
    //   696: invokestatic 674	com/tencent/widget/immersive/ImmersiveUtils:a	(Landroid/content/Context;)I
    //   699: iconst_0
    //   700: iconst_0
    //   701: invokevirtual 678	android/view/View:setPadding	(IIII)V
    //   704: aload_0
    //   705: ldc_w 522
    //   708: invokevirtual 584	com/tencent/mobileqq/armap/ShopScanActivity:findViewById	(I)Landroid/view/View;
    //   711: iconst_0
    //   712: aload_0
    //   713: invokestatic 674	com/tencent/widget/immersive/ImmersiveUtils:a	(Landroid/content/Context;)I
    //   716: ineg
    //   717: iconst_0
    //   718: iconst_0
    //   719: invokevirtual 678	android/view/View:setPadding	(IIII)V
    //   722: return
    //   723: astore_1
    //   724: aload_1
    //   725: invokevirtual 681	java/lang/OutOfMemoryError:printStackTrace	()V
    //   728: aconst_null
    //   729: astore_1
    //   730: goto -239 -> 491
    //   733: aload_0
    //   734: invokevirtual 685	com/tencent/mobileqq/armap/ShopScanActivity:getResources	()Landroid/content/res/Resources;
    //   737: ldc_w 686
    //   740: invokestatic 689	com/tencent/mobileqq/util/BitmapManager:a	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   743: astore_1
    //   744: new 691	android/graphics/drawable/BitmapDrawable
    //   747: dup
    //   748: aload_0
    //   749: invokevirtual 685	com/tencent/mobileqq/armap/ShopScanActivity:getResources	()Landroid/content/res/Resources;
    //   752: aload_1
    //   753: invokespecial 694	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   756: astore_1
    //   757: invokestatic 700	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   760: astore_3
    //   761: aload_3
    //   762: aload_1
    //   763: putfield 704	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   766: aload_3
    //   767: aload_1
    //   768: putfield 707	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   771: aload_2
    //   772: ldc_w 634
    //   775: invokevirtual 608	android/view/View:findViewById	(I)Landroid/view/View;
    //   778: checkcast 563	android/widget/ImageView
    //   781: aload_0
    //   782: getfield 435	com/tencent/mobileqq/armap/ShopScanActivity:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   785: aload_3
    //   786: invokestatic 713	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   789: invokevirtual 717	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   792: goto -287 -> 505
    //   795: astore_1
    //   796: aload_1
    //   797: invokevirtual 681	java/lang/OutOfMemoryError:printStackTrace	()V
    //   800: aconst_null
    //   801: astore_1
    //   802: goto -58 -> 744
    //   805: astore_1
    //   806: aload_1
    //   807: invokevirtual 681	java/lang/OutOfMemoryError:printStackTrace	()V
    //   810: aconst_null
    //   811: astore_1
    //   812: goto -289 -> 523
    //   815: aload_0
    //   816: invokevirtual 685	com/tencent/mobileqq/armap/ShopScanActivity:getResources	()Landroid/content/res/Resources;
    //   819: ldc_w 686
    //   822: invokestatic 689	com/tencent/mobileqq/util/BitmapManager:a	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   825: astore_1
    //   826: new 691	android/graphics/drawable/BitmapDrawable
    //   829: dup
    //   830: aload_0
    //   831: invokevirtual 685	com/tencent/mobileqq/armap/ShopScanActivity:getResources	()Landroid/content/res/Resources;
    //   834: aload_1
    //   835: invokespecial 694	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   838: astore_1
    //   839: invokestatic 700	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   842: astore_3
    //   843: aload_3
    //   844: aload_1
    //   845: putfield 704	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   848: aload_3
    //   849: aload_1
    //   850: putfield 707	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   853: aload_2
    //   854: ldc_w 639
    //   857: invokevirtual 608	android/view/View:findViewById	(I)Landroid/view/View;
    //   860: checkcast 563	android/widget/ImageView
    //   863: aload_0
    //   864: getfield 439	com/tencent/mobileqq/armap/ShopScanActivity:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   867: aload_3
    //   868: invokestatic 713	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   871: invokevirtual 717	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   874: goto -337 -> 537
    //   877: astore_1
    //   878: aload_1
    //   879: invokevirtual 681	java/lang/OutOfMemoryError:printStackTrace	()V
    //   882: aconst_null
    //   883: astore_1
    //   884: goto -58 -> 826
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	887	0	this	ShopScanActivity
    //   445	157	1	localObject1	Object
    //   723	2	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   729	39	1	localObject2	Object
    //   795	2	1	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   801	1	1	localObject3	Object
    //   805	2	1	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   811	39	1	localObject4	Object
    //   877	2	1	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   883	1	1	localObject5	Object
    //   379	475	2	localObject6	Object
    //   456	412	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   483	491	723	java/lang/OutOfMemoryError
    //   733	744	795	java/lang/OutOfMemoryError
    //   515	523	805	java/lang/OutOfMemoryError
    //   815	826	877	java/lang/OutOfMemoryError
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "addFragment hasDestroy: " + this.jdField_m_of_type_Boolean + ", fragment: " + this.jdField_a_of_type_ComTencentMobileqqArARScanFragment);
    }
    if ((this.jdField_m_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)) {
      return;
    }
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    this.jdField_a_of_type_ComTencentMobileqqArARScanFragment = ARScanFragment.a(this.jdField_a_of_type_ComTencentMobileqqArARArguments, this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo);
    localFragmentTransaction.add(2131369525, this.jdField_a_of_type_ComTencentMobileqqArARScanFragment);
    localFragmentTransaction.commitAllowingStateLoss();
    this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(this, this);
    if (this.jdField_h_of_type_Long < 0L) {
      this.jdField_h_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageAtTime(304, 2000L);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "onGetArConfig");
    }
    TVK_SDKMgr.setDebugEnable(false);
    TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoLogListener = new AROnlineVideoLogListener();
    TVK_SDKMgr.setOnLogListener(this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoLogListener);
    boolean bool = TVK_SDKMgr.isInstalled(this);
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "onGetArConfig sdkInstalled: " + bool);
    }
    if (!bool) {
      TVK_SDKMgr.installPlugin(this, new abdr(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new abeb(this));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new abec(this));
  }
  
  private void i()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "showTouchView");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget != null) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null)) {
      return;
    }
    QLog.d("ShopScanActivity", 1, "mArTarget == null || mArTarget.arResourceInfo == null");
  }
  
  private void k()
  {
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "hideArProgress");
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("ShopScanActivity", 2, localException.toString());
    }
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.startsWith("http")) {
        str = "http://" + paramString;
      }
    }
    return str;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, new Object[] { "onARSurfaceChanged, mLastArAnimState=", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(304);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new abdv(this), 3000L);
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(0.0F);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, new Object[] { "onArReady, mLastArAnimState=", Integer.valueOf(this.jdField_a_of_type_Int), ", state=", Integer.valueOf(paramInt1) });
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(304);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new abdw(this), 3000L);
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
      return;
    case 0: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(306);
      return;
    }
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(311);
  }
  
  public void a(int paramInt1, ARTarget paramARTarget, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, new Object[] { "onARAnimationStateChanged, mLastArAnimState=", Integer.valueOf(this.jdField_a_of_type_Int), ", newState=", Integer.valueOf(paramInt1), ", target=", paramARTarget });
    }
    if ((paramARTarget == null) || (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null))
    {
      QLog.d("ShopScanActivity", 1, "onARAnimationStateChanged, arTarget == null || arTarget.arResourceInfo == null");
      return;
    }
    switch (paramInt1)
    {
    default: 
    case 0: 
      do
      {
        this.jdField_a_of_type_Int = paramInt1;
        return;
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqArARTarget = paramARTarget;
        this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
        this.jdField_a_of_type_AndroidOsHandler.post(new abdl(this));
      } while ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.b));
      this.jdField_a_of_type_AndroidOsHandler.post(new abdm(this, paramARTarget));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 10000L);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqArARTarget = paramARTarget;
      if (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d()) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.reportClickEvent("CliOper", "", "", "0X8008144", "0X8008144", 0, 0, "1", this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.getCurrentAccountUin(), paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, "2");
      }
      if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_d_of_type_Int != 0) && (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_d_of_type_Int != 5))
      {
        int i2 = ARVideoUtil.a(paramARTarget);
        i1 = i2;
        if (i2 != 0) {
          break;
        }
      }
      break;
    }
    for (int i1 = 2147483647;; i1 = 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShopScanActivity", 2, "AREngineCallback.AR_ANIMATION_STATE_END, remainCount is " + i1 + ",remainCount" + paramInt2);
      }
      this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_Int == 1) && (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_e_of_type_Int == 0))
      {
        ReportController.b(null, "dc01440", "", "", "0X8007BE2", "0X8007BE2", 0, 0, "1", "", "", "");
        if (this.r)
        {
          if (!NetworkUtil.d(this))
          {
            this.jdField_a_of_type_AndroidOsHandler.post(new abdn(this));
            a(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
            break;
          }
          this.r = false;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(297, 2000L);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(299, 30000L);
          paramARTarget = (ArMapHandler)this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a(2);
          if (paramARTarget != null) {
            paramARTarget.a(this.jdField_i_of_type_Long, this.jdField_j_of_type_Long, 0, 2, 10);
          }
          this.jdField_n_of_type_Boolean = true;
          break;
        }
        a(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
        break;
      }
      if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_Int == 0) || ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_Int == 1) && (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_e_of_type_Int == 1))) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new abdo(this, paramARTarget, paramInt2, bool));
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqArARTarget = null;
      this.jdField_a_of_type_AndroidOsHandler.post(new abdp(this));
      break;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqArARTarget = null;
      this.jdField_a_of_type_AndroidOsHandler.post(new abdq(this));
      break;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.post(new abei(this, paramString));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 10000L);
  }
  
  public void a(long paramLong, int paramInt, ARRenderTrackInfo paramARRenderTrackInfo, ARLocalRecogResultBase paramARLocalRecogResultBase) {}
  
  public void a(long paramLong, ARTarget paramARTarget)
  {
    if ((paramARTarget == null) || (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ShopScanActivity", 1, "onARRecogComplete empty value");
      }
    }
    label344:
    label354:
    for (;;)
    {
      return;
      if (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f())
      {
        if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_Int == 1) && (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_e_of_type_Int == 0))
        {
          this.jdField_a_of_type_AndroidOsHandler.post(new abek(this));
          if (!this.r) {
            break label344;
          }
          if (!NetworkUtil.d(this))
          {
            this.jdField_a_of_type_AndroidOsHandler.post(new abel(this));
            a(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
            return;
          }
          this.r = false;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(297, 2000L);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(299, 30000L);
          ArMapHandler localArMapHandler = (ArMapHandler)this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a(2);
          if (localArMapHandler != null) {
            localArMapHandler.a(this.jdField_i_of_type_Long, this.jdField_j_of_type_Long, 0, 2, 10);
          }
          this.jdField_n_of_type_Boolean = true;
        }
        for (;;)
        {
          if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.b) || (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString))) {
            break label354;
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new abdh(this, paramARTarget));
          if (!this.jdField_g_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(306);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageAtTime(320, 100L);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 10000L);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ShopScanActivity", 1, "onARRecogComplete start jump :" + paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
          return;
          a(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
        }
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, ARTarget paramARTarget)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "onAREnableModelRender, isEnable = " + paramBoolean);
    }
    if (!paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArARScanFragment == null) || ((!this.r) && (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())) || (this.s == true)) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(true);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new abdi(this));
      return;
    }
    if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_Int == 1) && (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_e_of_type_Int == 0)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) && ((i1 == 0) || (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())))
      {
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(false);
        this.jdField_a_of_type_AndroidOsHandler.post(new abdj(this));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_Int != 1) || (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_e_of_type_Int != 0)) {
        break;
      }
      ReportController.b(null, "dc01440", "", "", "0X8007BE2", "0X8007BE2", 0, 0, "1", "", "", "");
      if (!this.r) {
        break label376;
      }
      if (NetworkUtil.d(this)) {
        break label302;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new abdk(this));
      a(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
      return;
    }
    label302:
    this.r = false;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(297, 2000L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(299, 30000L);
    paramARTarget = (ArMapHandler)this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a(2);
    if (paramARTarget != null) {
      paramARTarget.a(this.jdField_i_of_type_Long, this.jdField_j_of_type_Long, 0, 2, 10);
    }
    this.jdField_n_of_type_Boolean = true;
    return;
    label376:
    a(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
  }
  
  public void a(Uri paramUri)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = paramUri;
      if (paramUri == null) {
        localObject = "null";
      }
      QLog.d("ShopScanActivity", 2, new Object[] { "onDetectScreenshot, uri=", localObject });
    }
    if (!this.jdField_a_of_type_Boolean) {}
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo1, ArCloudConfigInfo paramArCloudConfigInfo2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult, ArLBSActivity paramArLBSActivity) {}
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new abds(this, paramARRenderMangerInnerCallback, paramArVideoResourceInfo));
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(312);
    QLog.d("ShopScanActivity", 1, "scanTorch notifyRenderReady " + this.jdField_h_of_type_Boolean);
    if (this.jdField_h_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(320);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShopScanActivity", 2, "onInitComplete retCode" + paramInt);
    }
    if (paramInt != 0)
    {
      if (paramInt != 8) {
        break label49;
      }
      d(8);
    }
    label49:
    while (paramInt != 3) {
      return;
    }
    d(3);
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(int paramInt) {}
  
  public void d()
  {
    QLog.d("ShopScanActivity", 1, "scanTorch notifyRenderReady isNotifyRecivied " + this.jdField_i_of_type_Boolean);
    if (this.jdField_i_of_type_Boolean)
    {
      ARTransparentWebviewPlugin.b();
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_b_of_type_ComTencentBizUiTouchWebView.setVisibility(0);
      }
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, new Object[] { "onARStartComplete, mLastArAnimState=", Integer.valueOf(this.jdField_a_of_type_Int), ", retCode=", Integer.valueOf(paramInt) });
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(304);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new abdu(this), 3000L);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(305);
      return;
    case 0: 
      if (this.jdField_g_of_type_Long < 0L) {
        this.jdField_g_of_type_Long = System.currentTimeMillis();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShopScanActivity", 2, "onArReady success");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(295);
      return;
    case 2: 
      if (this.jdField_g_of_type_Long < 0L) {
        this.jdField_g_of_type_Long = System.currentTimeMillis();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShopScanActivity", 2, "onArReady open camera failed.");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(294);
      return;
    case 3: 
      if (this.jdField_g_of_type_Long < 0L) {
        this.jdField_g_of_type_Long = System.currentTimeMillis();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShopScanActivity", 2, "onArReady start ar failed.");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(296);
      return;
    case 6: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(308);
      return;
    case 7: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(309);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(310);
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShopScanActivity", 2, "doOnBackPressed");
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShopScanActivity", 2, "doOnCreate");
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().addFlags(128);
    setContentView(2130970620);
    super.hideTitleBar();
    this.jdField_c_of_type_Int = getWindowManager().getDefaultDisplay().getWidth();
    this.jdField_b_of_type_Int = getWindowManager().getDefaultDisplay().getHeight();
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    this.jdField_m_of_type_Boolean = false;
    e();
    f();
    ARGlobalRemoteManager.a(this).a();
    if (this.jdField_a_of_type_MqqAppQQBroadcastReceiver != null)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq__alive");
      registerReceiver(this.jdField_a_of_type_MqqAppQQBroadcastReceiver, paramBundle);
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver = new ScreenshotObserver(this.jdField_a_of_type_AndroidOsHandler, this);
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver.a(this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    a("正在加载...");
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShopScanActivity", 2, "doOnDestroy");
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    m();
    try
    {
      if (this.jdField_a_of_type_MqqAppQQBroadcastReceiver != null) {
        unregisterReceiver(this.jdField_a_of_type_MqqAppQQBroadcastReceiver);
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a();
        }
        super.doOnDestroy();
        this.jdField_m_of_type_Boolean = true;
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShopScanActivity", 2, "e= " + localException2.getMessage());
          }
        }
      }
    }
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShopScanActivity", 2, "doOnPause");
    }
    if (this.jdField_b_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_b_of_type_ComTencentBizUiTouchWebView.onPause();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShopScanActivity", 2, "doOnResume");
    }
    if (this.s == true) {
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) && (this.s == true))
    {
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(true);
      if (this.jdField_b_of_type_ComTencentBizUiTouchWebView != null) {
        this.jdField_b_of_type_ComTencentBizUiTouchWebView.setVisibility(4);
      }
    }
    this.s = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShopScanActivity", 2, "doOnStart");
    }
    super.doOnStart();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver.a();
    }
  }
  
  protected void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShopScanActivity", 2, "doOnStop");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver.b();
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "finish");
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("flag_refresh_poi", false);
    localIntent.putExtra("flag_open_failed", this.jdField_o_of_type_Boolean);
    localIntent.putExtra("flag_open_success", this.p);
    localIntent.putExtra("poi_id", this.jdField_j_of_type_Long);
    localIntent.putExtra("task_id", this.jdField_i_of_type_Long);
    localIntent.putExtra("task_type", this.jdField_f_of_type_Int);
    localIntent.putExtra("flag_has_open", this.jdField_n_of_type_Boolean);
    localIntent.putExtra("flag_server_resp_success", this.q);
    setResult(-1, localIntent);
    super.finish();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 293: 
    case 300: 
    case 301: 
    case 302: 
    case 303: 
    case 313: 
    case 314: 
    case 315: 
    case 316: 
    case 317: 
    case 318: 
    case 319: 
    default: 
    case 292: 
    case 304: 
    case 320: 
    case 312: 
    case 306: 
    case 311: 
    case 307: 
    case 294: 
    case 295: 
    case 305: 
    case 296: 
    case 308: 
    case 309: 
    case 310: 
    case 297: 
    case 298: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return true;
                    l();
                    return true;
                    a("正在加载...");
                    return true;
                    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(320, 50L);
                    this.jdField_d_of_type_Int += 1;
                  } while (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null);
                  this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setTotalProgress(this.jdField_d_of_type_Int);
                  return true;
                } while (this.jdField_b_of_type_ComTencentBizUiTouchWebView == null);
                this.jdField_b_of_type_ComTencentBizUiTouchWebView.onPause();
                return true;
              } while (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView != null);
              paramMessage = new RelativeLayout.LayoutParams(-1, -1);
              this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this);
              this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
              this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(this.jdField_c_of_type_Int);
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, paramMessage);
              return true;
            } while (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null);
            this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setTotalProgress(this.jdField_d_of_type_Int);
            return true;
          } while (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView);
          this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = null;
          return true;
          l();
          try
          {
            paramMessage = new CameraDialog(this);
            paramMessage.a(new abej(this, paramMessage));
            paramMessage.show();
            return true;
          }
          catch (Exception paramMessage)
          {
            paramMessage.printStackTrace();
            return true;
          }
          c(false);
          l();
        } while (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment == null);
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(1.0F, 0.0F);
        return true;
        l();
        QQToast.a(this, 0, "摄像头被占用", 0).b(getTitleBarHeight());
        finish();
        return true;
        l();
        a("启动AR失败", "加载失败，请重试", null, null);
        return true;
        l();
        a("启动AR失败", "加载失败，请重试", null, null);
        return true;
        l();
        a("启动AR失败", "加载失败，请重试", null, null);
        return true;
        l();
        a("启动AR失败", "加载失败，请重试", null, null);
        return true;
        c("正在请求...");
        return true;
        this.r = true;
      } while (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment == null);
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(true);
      return true;
    }
    n();
    QQToast.a(this, 0, "请求超时，请检查你的网络", 0).b(getTitleBarHeight());
    finish();
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShopScanActivity", 2, "onClick");
    }
    long l1 = this.jdField_k_of_type_Long;
    this.jdField_k_of_type_Long = System.currentTimeMillis();
    switch (paramView.getId())
    {
    default: 
    case 2131369493: 
    case 2131371457: 
    case 2131371455: 
    case 2131363274: 
    case 2131363275: 
      do
      {
        do
        {
          do
          {
            return;
            doOnBackPressed();
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqArmapShopScanDragView != null) {
              this.jdField_a_of_type_ComTencentMobileqqArmapShopScanDragView.b();
            }
            ReportController.b(null, "dc01440", "", "", "0X8007BE3", "0X8007BE3", 0, 0, "1", "", "", "");
            return;
            if (QLog.isColorLevel()) {
              QLog.i("ShopScanActivity", 2, "onClick R.id.text_help");
            }
          } while (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString));
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", this.jdField_g_of_type_JavaLangString);
          startActivity(paramView);
          ReportController.b(null, "dc01440", "", "", "0X80069D3", "0X80069D3", 0, 0, "1", "", "", "");
          return;
          if (QLog.isColorLevel()) {
            QLog.i("ShopScanActivity", 2, "onClick R.id.touch_view");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget == null) || (this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_e_of_type_Int != 1)) {
            break label528;
          }
          ReportController.b(null, "dc01440", "", "", "0X8007BE2", "0X8007BE2", 0, 0, "1", "", "", "");
          if (!this.r) {
            break label467;
          }
          if (NetworkUtil.d(this)) {
            break;
          }
          if (this.jdField_k_of_type_Long - l1 > 2000L)
          {
            QQToast.a(getApplicationContext(), "当前网络不可用，请检查你的网络设置。", 1).b(getTitleBarHeight());
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.i("ShopScanActivity", 2, "onClick R.id.touch_view click too much");
        return;
        this.r = false;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(297, 2000L);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(299, 30000L);
        paramView = (ArMapHandler)this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a(2);
        if (paramView != null) {
          paramView.a(this.jdField_i_of_type_Long, this.jdField_j_of_type_Long, 0, 2, 10);
        }
        this.jdField_n_of_type_Boolean = true;
        k();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShopScanActivity", 2, new Object[] { "onARAnimationStateChanged, mCanLottery=", Boolean.valueOf(this.r) });
        }
        QQToast.a(getApplicationContext(), "你已经参加过抽奖啦，不要太贪心哦。", 1).b(getTitleBarHeight());
        a(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqArARTarget == null) || (this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)));
      if (!this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.b)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
        setResult(11);
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("url", a(paramView));
        startActivity(localIntent);
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(true);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget != null) && (!this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())) {
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.reportClickEvent("CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, "2");
        }
        k();
        return;
        this.s = true;
        if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.e(true);
          this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(false);
          this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(1L);
          this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b();
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        i();
        d();
      }
    case 2131371454: 
      if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.getApp()))
      {
        QQToast.a(this, 0, 2131435603, 0).a();
        return;
      }
      this.jdField_j_of_type_Boolean = true;
      if (!TVK_SDKMgr.isInstalled(this))
      {
        this.jdField_l_of_type_Boolean = false;
        TVK_SDKMgr.installPlugin(this, new abed(this));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.c();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 2131371453: 
      label467:
      if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.getApp()))
      {
        QQToast.a(this, 0, 2131435603, 0).a();
        return;
      }
      label528:
      this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.c();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.b();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ShopScanActivity
 * JD-Core Version:    0.7.0.1
 */