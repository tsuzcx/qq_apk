package com.tencent.biz.qrcode.activity;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.zxing.common.BitMatrix;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.biz.qrcode.CodeMaskManager.Callback;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate.CallBack;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.chirp.PcmPlayer;
import com.tencent.chirp.PcmPlayer.QQPlayerListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.QrCodeConfBean;
import com.tencent.mobileqq.config.business.QrCodeConfBean.QrCodeList;
import com.tencent.mobileqq.config.business.QrCodeDisplayConfProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipQidConfig;
import com.tencent.mobileqq.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.Callback;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vas.PrettyAccountUtil;
import com.tencent.mobileqq.vas.qid.QidCardManager;
import com.tencent.mobileqq.vas.qid.QidCardManager.QidCardReport;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.mobileqq.vas.qid.QidPagView.QidData;
import com.tencent.mobileqq.vip.PbProtocol;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.pb.qid.QidProfile.GetProfileSSOReq;
import com.tencent.pb.qid.QidProfile.GetProfileSSORsp;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QRDisplayActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener, CodeMaskManager.Callback, CustomAccessibilityDelegate.CallBack, PcmPlayer.QQPlayerListener, ChirpSoHandler.Callback
{
  public static final String j;
  protected int a;
  protected long a;
  protected Bitmap a;
  protected Drawable a;
  protected Bundle a;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer = new QRDisplayActivity.27(this, 1000L, 200L);
  protected Handler a;
  protected View a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  protected BitMatrix a;
  protected CodeMaskManager a;
  QRDisplayActivity.GetNicknameObserver jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver = new QRDisplayActivity.1(this);
  private QRDisplayActivity.MyViewAlphaOnTouchListener jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$MyViewAlphaOnTouchListener;
  private PcmPlayer jdField_a_of_type_ComTencentChirpPcmPlayer;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new QRDisplayActivity.2(this);
  DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new QRDisplayActivity.5(this);
  protected QrCodeConfBean a;
  private ChirpSoHandler jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler;
  protected RedTouch a;
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = null;
  protected QidPagView a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new QRDisplayActivity.9(this);
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  protected Runnable a;
  protected String a;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected boolean a;
  protected int b;
  long jdField_b_of_type_Long;
  protected volatile Bitmap b;
  private Handler jdField_b_of_type_AndroidOsHandler;
  protected View b;
  protected ImageView b;
  protected LinearLayout b;
  protected TextView b;
  protected ActionSheet b;
  protected Runnable b;
  protected String b;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  protected boolean b;
  protected int c;
  protected long c;
  Bitmap c;
  protected View c;
  protected ImageView c;
  protected TextView c;
  protected Runnable c;
  protected String c;
  protected boolean c;
  protected int d;
  Bitmap jdField_d_of_type_AndroidGraphicsBitmap;
  View jdField_d_of_type_AndroidViewView;
  protected ImageView d;
  protected TextView d;
  protected Runnable d;
  protected String d;
  protected boolean d;
  protected int e;
  View e;
  protected ImageView e;
  protected TextView e;
  protected String e;
  protected boolean e;
  int f;
  protected View f;
  protected ImageView f;
  protected TextView f;
  protected String f;
  protected boolean f;
  int jdField_g_of_type_Int;
  protected View g;
  protected ImageView g;
  protected TextView g;
  String jdField_g_of_type_JavaLangString;
  public boolean g;
  protected int h;
  protected View h;
  protected ImageView h;
  protected TextView h;
  protected String h;
  protected boolean h;
  protected int i;
  protected View i;
  protected ImageView i;
  protected TextView i;
  protected String i;
  private boolean i;
  int jdField_j_of_type_Int = -1;
  protected View j;
  protected ImageView j;
  protected TextView j;
  private volatile boolean jdField_j_of_type_Boolean = false;
  int jdField_k_of_type_Int;
  protected View k;
  protected ImageView k;
  protected TextView k;
  private boolean jdField_k_of_type_Boolean = false;
  int l;
  protected View l;
  protected TextView l;
  protected View m;
  protected View n;
  protected View o;
  
  static
  {
    jdField_j_of_type_JavaLangString = HardCodeUtil.a(2131711172);
  }
  
  public QRDisplayActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_h_of_type_Int = -1;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new QRDisplayActivity.6(this);
    this.jdField_b_of_type_JavaLangRunnable = new QRDisplayActivity.7(this);
    this.jdField_c_of_type_JavaLangRunnable = new QRDisplayActivity.8(this);
    this.jdField_d_of_type_JavaLangRunnable = new QRDisplayActivity.10(this);
    this.jdField_b_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Int = -1;
    this.jdField_l_of_type_Int = this.jdField_k_of_type_Int;
  }
  
  private void A()
  {
    DialogUtil.a(this, 232, null, getString(2131699068), getString(2131690800), getString(2131699357), new QRDisplayActivity.34(this), new QRDisplayActivity.35(this)).show();
    QidCardManager.QidCardReport.b("0X800B970");
  }
  
  private void B()
  {
    if (!QVipQidProcessor.c().jdField_b_of_type_Boolean) {
      return;
    }
    PbProtocol.a("vapfService.qidService.GetProfileSSO", new QidProfile.GetProfileSSOReq(), QidProfile.GetProfileSSORsp.class, new QRDisplayActivity.36(this));
  }
  
  private void a(Bundle paramBundle, ArrayList<Rect> paramArrayList, Bitmap paramBitmap)
  {
    Object localObject;
    if (QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString) == 2)
    {
      if (a())
      {
        localObject = ((QrCodeConfBean.QrCodeList)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.get(this.jdField_h_of_type_Int)).jdField_a_of_type_JavaLangString;
        this.jdField_i_of_type_JavaLangString = ((String)localObject);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
        break label340;
      }
      localObject = BitmapFactory.decodeResource(getResources(), 2130847311);
    }
    for (;;)
    {
      paramBundle = QRUtils.a(this, (Bitmap)localObject, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBitmap, paramArrayList, paramBundle.getInt("nameClr"), this.jdField_a_of_type_JavaLangString, String.format(getString(2131699063), new Object[] { this.jdField_c_of_type_JavaLangString }), paramBundle.getInt("tipsClr"), this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_Boolean, this.jdField_h_of_type_JavaLangString, true);
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null)
      {
        this.jdField_h_of_type_AndroidWidgetImageView.setImageBitmap(paramBundle[0]);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
        int i1 = PrettyAccountUtil.a();
        int i2 = PrettyAccountUtil.b();
        paramArrayList = PrettyAccountUtil.a(i1, i2, String.format(getString(2131699063), new Object[] { this.jdField_c_of_type_JavaLangString }), this.jdField_c_of_type_JavaLangString);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(paramArrayList);
        PrettyAccountUtil.a(this.jdField_f_of_type_AndroidWidgetTextView, i1, i2);
        PrettyAccountUtil.a("0X800B239", i1, i2);
        this.jdField_g_of_type_AndroidWidgetTextView.setText(getString(2131699073));
        this.jdField_g_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        y();
        B();
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = paramBundle[1];
      this.jdField_c_of_type_AndroidGraphicsBitmap = paramBundle[1];
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 2, "onMaskReady: qrcodeCardCache = " + this.jdField_b_of_type_AndroidGraphicsBitmap);
      }
      return;
      localObject = null;
      break;
      try
      {
        label340:
        localObject = ImageUtil.b(URLDrawable.getDrawable(this.jdField_i_of_type_JavaLangString).getCurrDrawable().mutate());
      }
      catch (Exception localException)
      {
        Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130847311);
      }
    }
  }
  
  private void a(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean)
  {
    if (paramQrCodeList == null)
    {
      QLog.i("QRDisplayActivity", 2, "setTroopURLDrawable() qrCodeList is null just return");
      return;
    }
    if ("default_bg".equals(paramQrCodeList.jdField_a_of_type_JavaLangString))
    {
      b(paramQrCodeList, paramInt, paramBoolean);
      this.m.setBackgroundResource(2130847311);
      return;
    }
    int i1;
    if (this.m.getBackground() == null) {
      i1 = 1;
    }
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (i1 == 0) {
          break label277;
        }
        localObject = getResources().getDrawable(2130847311);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramQrCodeList.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        if (QLog.isColorLevel())
        {
          if ("setTroopURLDrawable: urlDrawable = " + this.jdField_a_of_type_ComTencentImageURLDrawable + " status = " + this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
            break label335;
          }
          localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus());
          QLog.d("QRDisplayActivity", 2, new Object[] { localObject });
        }
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
          break label289;
        }
        b(paramQrCodeList, paramInt, paramBoolean);
        this.m.setBackgroundDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
        return;
      }
      catch (IllegalArgumentException paramQrCodeList)
      {
        QLog.d("QRDisplayActivity", 1, "setTroopURLDrawable bkgURL is illegal please check manage info e =" + paramQrCodeList);
        QQToast.a(this, getString(2131696445), 0).a();
        y();
      }
      if (i1 == 0) {
        break;
      }
      this.m.setBackgroundResource(2130847311);
      return;
      i1 = 0;
      continue;
      label277:
      Object localObject = this.m.getBackground();
      continue;
      label289:
      if (i1 != 0) {
        this.m.setBackgroundResource(2130847311);
      }
      a(paramQrCodeList, paramInt, paramBoolean, this.jdField_a_of_type_ComTencentImageURLDrawable);
      x();
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
      return;
      label335:
      localObject = " is null";
    }
  }
  
  private void a(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener(): ud = " + paramURLDrawable + " bkgURL = " + paramQrCodeList.jdField_a_of_type_JavaLangString);
    }
    paramURLDrawable.setURLDrawableListener(new QRDisplayActivity.33(this, paramQrCodeList, paramInt, paramBoolean));
  }
  
  private void a(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean1, URLDrawable paramURLDrawable, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setDrawableListener(): ud = " + paramURLDrawable + " bkgURL = " + paramQrCodeList.jdField_a_of_type_JavaLangString);
    }
    paramURLDrawable.setURLDrawableListener(new QRDisplayActivity.32(this, paramQrCodeList, paramInt, paramBoolean1, paramBoolean2));
  }
  
  private void a(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ("default_bg".equals(paramQrCodeList.jdField_a_of_type_JavaLangString))
    {
      b(paramQrCodeList, paramInt, paramBoolean1, paramBoolean2);
      this.jdField_j_of_type_AndroidViewView.setBackgroundResource(2130847311);
      return;
    }
    int i1;
    if (this.jdField_j_of_type_AndroidViewView.getBackground() == null) {
      i1 = 1;
    }
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (i1 == 0) {
          break label245;
        }
        localDrawable = getResources().getDrawable(2130847311);
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramQrCodeList.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "setURLDrawable: urlDrawable = " + this.jdField_a_of_type_ComTencentImageURLDrawable + " status = " + this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus());
        }
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
          break label257;
        }
        b(paramQrCodeList, paramInt, paramBoolean1, paramBoolean2);
        this.jdField_j_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
        return;
      }
      catch (IllegalArgumentException paramQrCodeList)
      {
        QLog.d("QRDisplayActivity", 1, "bkgURL is illegal please check manage info e =" + paramQrCodeList);
        QQToast.a(this, getString(2131696445), 0).a();
        y();
      }
      if (i1 == 0) {
        break;
      }
      this.jdField_j_of_type_AndroidViewView.setBackgroundResource(2130847311);
      return;
      i1 = 0;
      continue;
      label245:
      Drawable localDrawable = this.jdField_j_of_type_AndroidViewView.getBackground();
    }
    label257:
    if (i1 != 0) {
      this.jdField_j_of_type_AndroidViewView.setBackgroundResource(2130847311);
    }
    a(paramQrCodeList, paramInt, paramBoolean1, this.jdField_a_of_type_ComTencentImageURLDrawable, paramBoolean2);
    x();
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
    this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
  }
  
  private void a(QrCodeConfBean.QrCodeList paramQrCodeList, boolean paramBoolean)
  {
    a(paramQrCodeList, paramBoolean, false);
  }
  
  private void a(QrCodeConfBean.QrCodeList paramQrCodeList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramQrCodeList == null) {
      QLog.i("QRDisplayActivity", 2, "switchMyQrTheme() qrCodeList is null just return");
    }
    do
    {
      return;
      if (!paramBoolean2) {
        this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.indexOf(paramQrCodeList);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "switchMyQrTheme().qrCodeList:" + paramQrCodeList.toString());
      }
    } while (TextUtils.isEmpty(paramQrCodeList.jdField_a_of_type_JavaLangString));
    this.jdField_h_of_type_JavaLangString = paramQrCodeList.jdField_b_of_type_JavaLangString;
    this.jdField_e_of_type_Boolean = paramQrCodeList.c();
    this.jdField_i_of_type_JavaLangString = paramQrCodeList.jdField_a_of_type_JavaLangString;
    a(paramQrCodeList, this.jdField_h_of_type_Int, paramBoolean1, paramBoolean2);
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    boolean bool = paramTroopInfo.isOwnerOrAdmin(getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "updateBottomTroopInfoAndTips isOwnerOrAdmin = " + bool);
    }
    TextView localTextView = (TextView)findViewById(2131368116);
    localTextView.setVisibility(0);
    TroopReportor.a("Grp_QR", "search_upgrade", "search_upgrade_exp", 0, 0, new String[] { paramTroopInfo.troopuin });
    if (bool) {}
    String str;
    for (int i1 = 2131717060;; i1 = 2131717059)
    {
      str = paramTroopInfo.troopuin;
      str = String.format(getResources().getString(i1), new Object[] { str });
      if (!bool) {
        break;
      }
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new QRDisplayActivity.4(this, paramTroopInfo), str.length() - 6, str.length(), 33);
      localTextView.setText(localSpannableString);
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      localTextView.setHighlightColor(0);
      return;
    }
    localTextView.setText(str);
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (!(paramObject instanceof QidProfile.GetProfileSSORsp))) {
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 2, "QID_QR,pb request,error:" + paramBoolean);
      }
    }
    QidProfile.GetProfileSSORsp localGetProfileSSORsp;
    do
    {
      return;
      localGetProfileSSORsp = (QidProfile.GetProfileSSORsp)paramObject;
      if (localGetProfileSSORsp.is_set.get() == 0)
      {
        this.jdField_j_of_type_Int = 0;
        QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString, 1);
        return;
      }
    } while (localGetProfileSSORsp.is_set.get() != 1);
    if (localGetProfileSSORsp.pag_url.has()) {
      paramObject = localGetProfileSSORsp.pag_url.get();
    }
    for (;;)
    {
      QidCardManager.QidCardReport.a(paramObject);
      if (this.jdField_j_of_type_Int == 0) {
        QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString, 2);
      }
      this.jdField_j_of_type_Int = 1;
      try
      {
        this.jdField_l_of_type_Int = Color.parseColor(localGetProfileSSORsp.btn_color.get());
        if (localGetProfileSSORsp.main_url.has())
        {
          paramObject = localGetProfileSSORsp.main_url.get();
          QidCardManager.a(this.jdField_c_of_type_JavaLangString, paramObject);
        }
        if (QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString) == 2)
        {
          a(2, false);
          QidCardManager.QidCardReport.b("0X800B9A6");
          QidCardManager.QidCardReport.b("0X800B9A8");
          QidCardManager.QidCardReport.b("0X800B9AA");
          QidCardManager.QidCardReport.b("0X800B972");
          paramObject = new QidPagView.QidData();
          paramObject.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          paramObject.jdField_g_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          paramObject.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
          paramObject.jdField_a_of_type_Int = this.jdField_l_of_type_Int;
          paramObject.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_h_of_type_AndroidWidgetImageView.getDrawable();
          if ((localGetProfileSSORsp.is_lm_show.has()) && (localGetProfileSSORsp.is_lm_show.get() == 1)) {
            paramObject.jdField_d_of_type_JavaLangString = QidCardManager.b(this.jdField_c_of_type_JavaLangString);
          }
          if (localGetProfileSSORsp.qid.has()) {
            paramObject.jdField_e_of_type_JavaLangString = localGetProfileSSORsp.qid.get();
          }
          if (localGetProfileSSORsp.pag_url.has())
          {
            paramObject.jdField_a_of_type_JavaLangString = localGetProfileSSORsp.pag_url.get();
            paramObject.jdField_b_of_type_JavaLangString = QidCardManager.a(paramObject.jdField_a_of_type_JavaLangString);
          }
          if (localGetProfileSSORsp.bg_url.has()) {
            paramObject.jdField_c_of_type_JavaLangString = localGetProfileSSORsp.bg_url.get();
          }
          if (QidCardManager.a(paramObject.jdField_a_of_type_JavaLangString) == null) {
            break label451;
          }
          this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView.a(paramObject);
          return;
          paramObject = "";
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          QLog.d("QRDisplayActivity", 2, "QID_QR,color,parse error:" + paramObject.getMessage());
          continue;
          this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView.jdField_a_of_type_Boolean = true;
        }
        label451:
        QidCardManager.a(this, this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView, paramObject);
      }
    }
  }
  
  private static void a(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    int i1 = 0;
    while (i1 < paramArrayOfShort.length)
    {
      paramArrayOfByte[(i1 * 2)] = ((byte)(paramArrayOfShort[i1] & 0xFF));
      paramArrayOfByte[(i1 * 2 + 1)] = ((byte)(paramArrayOfShort[i1] >> 8 & 0xFF));
      i1 += 1;
    }
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 771	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 773	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 776	java/io/File:exists	()Z
    //   13: ifne +187 -> 200
    //   16: new 778	com/tencent/chirp/ChirpWrapper
    //   19: dup
    //   20: invokespecial 779	com/tencent/chirp/ChirpWrapper:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 780	com/tencent/chirp/ChirpWrapper:a	()I
    //   30: ifne +298 -> 328
    //   33: aload_0
    //   34: getfield 254	com/tencent/biz/qrcode/activity/QRDisplayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 783	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   40: astore_3
    //   41: new 314	java/lang/String
    //   44: dup
    //   45: ldc_w 785
    //   48: invokespecial 786	java/lang/String:<init>	(Ljava/lang/String;)V
    //   51: astore 4
    //   53: new 391	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 788
    //   63: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 4
    //   68: iconst_0
    //   69: bipush 14
    //   71: aload_3
    //   72: invokevirtual 636	java/lang/String:length	()I
    //   75: isub
    //   76: invokevirtual 792	java/lang/String:substring	(II)Ljava/lang/String;
    //   79: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_3
    //   83: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 405	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_3
    //   90: invokestatic 387	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +30 -> 123
    //   96: ldc_w 389
    //   99: iconst_2
    //   100: new 391	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 794
    //   110: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_3
    //   114: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 405	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 408	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload 5
    //   125: aload_3
    //   126: invokevirtual 797	com/tencent/chirp/ChirpWrapper:a	(Ljava/lang/String;)Landroid/util/Pair;
    //   129: astore_3
    //   130: aload_3
    //   131: getfield 803	android/util/Pair:first	Ljava/lang/Object;
    //   134: checkcast 500	java/lang/Integer
    //   137: invokevirtual 806	java/lang/Integer:intValue	()I
    //   140: istore_2
    //   141: aload_3
    //   142: getfield 809	android/util/Pair:second	Ljava/lang/Object;
    //   145: checkcast 811	[S
    //   148: astore 4
    //   150: iload_2
    //   151: ifne +137 -> 288
    //   154: aload 4
    //   156: ifnull +132 -> 288
    //   159: new 813	java/io/FileOutputStream
    //   162: dup
    //   163: aload_1
    //   164: invokespecial 816	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   167: astore_3
    //   168: aload 4
    //   170: arraylength
    //   171: iconst_2
    //   172: imul
    //   173: newarray byte
    //   175: astore_1
    //   176: aload 4
    //   178: aload_1
    //   179: invokestatic 818	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	([S[B)V
    //   182: aload_3
    //   183: aload_1
    //   184: invokevirtual 822	java/io/FileOutputStream:write	([B)V
    //   187: aload_3
    //   188: ifnull +7 -> 195
    //   191: aload_3
    //   192: invokevirtual 825	java/io/FileOutputStream:close	()V
    //   195: aload 5
    //   197: invokevirtual 827	com/tencent/chirp/ChirpWrapper:a	()V
    //   200: iconst_1
    //   201: ireturn
    //   202: astore_1
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload 5
    //   208: invokevirtual 827	com/tencent/chirp/ChirpWrapper:a	()V
    //   211: aload_1
    //   212: athrow
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_1
    //   216: invokestatic 387	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +14 -> 233
    //   222: ldc_w 389
    //   225: iconst_2
    //   226: ldc_w 755
    //   229: aload_3
    //   230: invokestatic 830	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: aload_1
    //   234: astore_3
    //   235: aload_1
    //   236: ifnull +9 -> 245
    //   239: aload_1
    //   240: invokevirtual 825	java/io/FileOutputStream:close	()V
    //   243: aconst_null
    //   244: astore_3
    //   245: aload_3
    //   246: ifnull +7 -> 253
    //   249: aload_3
    //   250: invokevirtual 825	java/io/FileOutputStream:close	()V
    //   253: aload 5
    //   255: invokevirtual 827	com/tencent/chirp/ChirpWrapper:a	()V
    //   258: iconst_0
    //   259: ireturn
    //   260: astore_1
    //   261: aconst_null
    //   262: astore_3
    //   263: goto -18 -> 245
    //   266: astore_1
    //   267: aload_1
    //   268: athrow
    //   269: astore_1
    //   270: aconst_null
    //   271: astore_3
    //   272: aload_3
    //   273: ifnull +7 -> 280
    //   276: aload_3
    //   277: invokevirtual 825	java/io/FileOutputStream:close	()V
    //   280: aload_1
    //   281: athrow
    //   282: astore_1
    //   283: aload_1
    //   284: athrow
    //   285: astore_1
    //   286: aload_1
    //   287: athrow
    //   288: invokestatic 387	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +30 -> 321
    //   294: ldc_w 389
    //   297: iconst_4
    //   298: new 391	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   305: ldc_w 832
    //   308: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: iload_2
    //   312: invokevirtual 563	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: invokevirtual 405	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 408	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: aload 5
    //   323: invokevirtual 827	com/tencent/chirp/ChirpWrapper:a	()V
    //   326: iconst_0
    //   327: ireturn
    //   328: aload 5
    //   330: invokevirtual 827	com/tencent/chirp/ChirpWrapper:a	()V
    //   333: iconst_0
    //   334: ireturn
    //   335: astore_1
    //   336: goto -141 -> 195
    //   339: astore_1
    //   340: goto -87 -> 253
    //   343: astore_3
    //   344: goto -64 -> 280
    //   347: astore_1
    //   348: goto -76 -> 272
    //   351: astore 4
    //   353: aload_1
    //   354: astore_3
    //   355: aload 4
    //   357: astore_1
    //   358: goto -86 -> 272
    //   361: astore 4
    //   363: aload_3
    //   364: astore_1
    //   365: aload 4
    //   367: astore_3
    //   368: goto -152 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	QRDisplayActivity
    //   0	371	1	paramString	String
    //   140	172	2	i1	int
    //   40	152	3	localObject1	Object
    //   213	17	3	localException1	Exception
    //   234	43	3	str	String
    //   343	1	3	localIOException	java.io.IOException
    //   354	14	3	localObject2	Object
    //   51	126	4	localObject3	Object
    //   351	5	4	localObject4	Object
    //   361	5	4	localException2	Exception
    //   23	306	5	localChirpWrapper	ChirpWrapper
    // Exception table:
    //   from	to	target	type
    //   191	195	202	finally
    //   33	123	205	finally
    //   123	150	205	finally
    //   203	205	205	finally
    //   280	282	205	finally
    //   283	285	205	finally
    //   286	288	205	finally
    //   288	321	205	finally
    //   159	168	213	java/lang/Exception
    //   239	243	260	java/io/IOException
    //   239	243	266	finally
    //   159	168	269	finally
    //   267	269	269	finally
    //   249	253	282	finally
    //   276	280	285	finally
    //   191	195	335	java/io/IOException
    //   249	253	339	java/io/IOException
    //   276	280	343	java/io/IOException
    //   168	187	347	finally
    //   216	233	351	finally
    //   168	187	361	java/lang/Exception
  }
  
  public static List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696380);
    localActionSheetItem.icon = 2130839214;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 0;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696394);
    localActionSheetItem.icon = 2130839215;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696401);
    localActionSheetItem.icon = 2130839218;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696383);
    localActionSheetItem.icon = 2130839212;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void b(int paramInt, String paramString)
  {
    try
    {
      ThreadManager.post(new QRDisplayActivity.31(this, "temp_qrcode_share_" + paramString + ".png", paramInt, paramString), 8, null, true);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      QRUtils.a(1, 2131696461);
    }
  }
  
  private void b(Bundle paramBundle, ArrayList<Rect> paramArrayList, Bitmap paramBitmap)
  {
    Bitmap localBitmap1;
    Bitmap localBitmap3;
    int i1;
    String str1;
    String str2;
    int i2;
    boolean bool2;
    String str3;
    if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
    {
      localBitmap1 = BitmapFactory.decodeResource(getResources(), 2130847311);
      localBitmap3 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      i1 = paramBundle.getInt("nameClr");
      str1 = this.jdField_a_of_type_JavaLangString;
      str2 = String.format(getString(2131699430), new Object[] { this.jdField_c_of_type_JavaLangString });
      i2 = paramBundle.getInt("tipsClr");
      paramBundle = this.jdField_b_of_type_JavaLangString;
      bool2 = this.jdField_e_of_type_Boolean;
      str3 = this.jdField_h_of_type_JavaLangString;
      if (this.jdField_f_of_type_Boolean) {
        break label260;
      }
    }
    label260:
    for (boolean bool1 = true;; bool1 = false)
    {
      for (;;)
      {
        paramBundle = QRUtils.a(this, localBitmap1, localBitmap3, paramBitmap, paramArrayList, i1, str1, str2, i2, paramBundle, bool2, str3, bool1);
        if (this.jdField_b_of_type_AndroidGraphicsBitmap == null)
        {
          this.jdField_j_of_type_AndroidWidgetImageView.setImageBitmap(paramBundle[0]);
          this.jdField_i_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
          this.jdField_j_of_type_AndroidWidgetTextView.setText(String.format(getString(2131699430), new Object[] { this.jdField_c_of_type_JavaLangString }));
          this.jdField_k_of_type_AndroidWidgetTextView.setText(getString(2131699073));
          this.jdField_i_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        this.jdField_b_of_type_AndroidGraphicsBitmap = paramBundle[1];
        localBitmap1.recycle();
        return;
        try
        {
          localBitmap1 = ImageUtil.b(URLDrawable.getDrawable(this.jdField_i_of_type_JavaLangString).getCurrDrawable().mutate());
        }
        catch (Exception localException)
        {
          Bitmap localBitmap2 = BitmapFactory.decodeResource(getResources(), 2130847311);
        }
      }
      break;
    }
  }
  
  private void b(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean)
  {
    int i1 = -1;
    if (paramBoolean) {
      h();
    }
    y();
    QRUtils.b(this.app, paramInt);
    Object localObject;
    if (!paramQrCodeList.a())
    {
      paramBoolean = true;
      ImmersiveUtils.setStatusTextColor(paramBoolean, getWindow());
      localObject = getResources().getDrawable(2130851150);
      if (!paramQrCodeList.b()) {
        break label129;
      }
      paramInt = -1;
      label63:
      ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject);
      localObject = this.centerView;
      if (!paramQrCodeList.b()) {
        break label136;
      }
    }
    label129:
    label136:
    for (paramInt = i1;; paramInt = -16777216)
    {
      ((TextView)localObject).setTextColor(paramInt);
      this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130845028);
      this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130845028);
      return;
      paramBoolean = false;
      break;
      paramInt = -16777216;
      break label63;
    }
  }
  
  private void b(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = -1;
    if ((paramBoolean1) && (!paramBoolean2)) {
      h();
    }
    y();
    QRUtils.a(this.app, paramInt);
    Object localObject;
    if (!paramQrCodeList.a())
    {
      paramBoolean1 = true;
      ImmersiveUtils.setStatusTextColor(paramBoolean1, getWindow());
      localObject = getResources().getDrawable(2130843941);
      if (!paramQrCodeList.b()) {
        break label196;
      }
      paramInt = -1;
      label68:
      ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
      this.jdField_f_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = getResources().getDrawable(2130851150);
      if (!paramQrCodeList.b()) {
        break label203;
      }
      paramInt = -1;
      label115:
      ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject);
      localObject = this.centerView;
      if (!paramQrCodeList.b()) {
        break label210;
      }
    }
    label196:
    label203:
    label210:
    for (paramInt = i1;; paramInt = -16777216)
    {
      ((TextView)localObject).setTextColor(paramInt);
      if (!paramBoolean2)
      {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130845028);
        this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130845028);
        this.jdField_h_of_type_AndroidViewView.setBackgroundResource(2130845028);
      }
      return;
      paramBoolean1 = false;
      break;
      paramInt = -16777216;
      break label68;
      paramInt = -16777216;
      break label115;
    }
  }
  
  private void b(QrCodeConfBean.QrCodeList paramQrCodeList, boolean paramBoolean)
  {
    if (paramQrCodeList == null) {
      QLog.i("QRDisplayActivity", 2, "switchMyQrTheme() qrCodeList is null just return");
    }
    do
    {
      return;
      this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.indexOf(paramQrCodeList);
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "switchMyQrTheme().qrCodeList:" + paramQrCodeList.toString());
      }
    } while (TextUtils.isEmpty(paramQrCodeList.jdField_a_of_type_JavaLangString));
    this.jdField_h_of_type_JavaLangString = paramQrCodeList.jdField_b_of_type_JavaLangString;
    this.jdField_e_of_type_Boolean = paramQrCodeList.c();
    this.jdField_i_of_type_JavaLangString = paramQrCodeList.jdField_a_of_type_JavaLangString;
    a(paramQrCodeList, this.jdField_h_of_type_Int, paramBoolean);
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "sendIsResumeBroadcast isNeedSend = " + this.jdField_g_of_type_Boolean + " ,isResume = " + paramBoolean);
    }
    if (this.jdField_g_of_type_Boolean) {
      SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    if (paramBoolean)
    {
      localActionSheet.addButton(2131696453, 1, 10);
      QidCardManager.QidCardReport.b("0X800B973");
    }
    localActionSheet.addButton(2131696446, 1, 7);
    localActionSheet.addButton(2131696452, 1, 8);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new QRDisplayActivity.28(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void q()
  {
    Object localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(null);
    getTitleBarView().setBackgroundColor(0);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    findViewById(2131375162).setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_j_of_type_AndroidViewView = findViewById(16908290);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369501));
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697517));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.leftView.setContentDescription(getString(2131719148));
    this.jdField_k_of_type_AndroidViewView = findViewById(2131375184);
    this.jdField_k_of_type_AndroidViewView.setVisibility(0);
    this.jdField_l_of_type_AndroidViewView = this.jdField_k_of_type_AndroidViewView.findViewById(2131375139);
    this.jdField_l_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_l_of_type_AndroidViewView.setContentDescription(getString(2131699073));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_k_of_type_AndroidViewView.findViewById(2131369733));
    this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_k_of_type_AndroidViewView.findViewById(2131369764));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131380480));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131380683));
    localObject = HardCodeUtil.a(2131696447);
    String str = this.jdField_c_of_type_JavaLangString;
    localObject = LongClickCopyAction.attachCopyAction(this.jdField_f_of_type_AndroidWidgetTextView, (String)localObject, str);
    if (localObject != null) {
      ((LongClickCopyAction)localObject).setCopyListener(new QRDisplayActivity.3(this));
    }
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131380647));
    this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(getString(2131716909));
    this.jdField_b_of_type_JavaLangString = getString(2131717062);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368115));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131375173);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375172));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375174));
    this.jdField_g_of_type_AndroidViewView = findViewById(2131375190);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375189));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375191));
    this.jdField_h_of_type_AndroidViewView = findViewById(2131375197);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375196));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375198));
    int i1 = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131298066) * 3) / 8;
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (localObject != null)
    {
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = i1;
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = i1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$MyViewAlphaOnTouchListener = new QRDisplayActivity.MyViewAlphaOnTouchListener(this, null);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$MyViewAlphaOnTouchListener);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$MyViewAlphaOnTouchListener);
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$MyViewAlphaOnTouchListener);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839549);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374770));
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean = QrCodeDisplayConfProcessor.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.size() <= 0) || (TextUtils.isEmpty(((QrCodeConfBean.QrCodeList)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString))) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_h_of_type_Int = QRUtils.a(this.app);
    if ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.size())) {
      o();
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800AEAB", "0X800AEAB", 0, 0, "", "", "", "");
      QidCardManager.QidCardReport.b("0X800B96E");
      return;
      if (QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString) == 1) {
        a((QrCodeConfBean.QrCodeList)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.get(this.jdField_h_of_type_Int), false);
      }
    }
  }
  
  private void r()
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a(this, getString(2131692257), 0).b(getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "tryToGetShareLink: net is not supported");
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        str1 = "";
        switch (this.jdField_i_of_type_Int)
        {
        }
        while (TextUtils.isEmpty(str1))
        {
          return;
          str1 = "qr_circle";
          continue;
          str1 = "qr_qq";
          continue;
          str1 = "qr_qzone";
          continue;
          str1 = "qr_wechat";
        }
        TroopReportor.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
      }
      this.jdField_i_of_type_Int = -1;
      return;
    }
    String str1 = "temp_qrcode_share_" + this.jdField_c_of_type_JavaLangString + ".png";
    String str3 = "temp_qrcode_share_qid_" + this.jdField_c_of_type_JavaLangString + ".png";
    switch (this.jdField_i_of_type_Int)
    {
    default: 
      return;
    }
    for (;;)
    {
      try
      {
        if (QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString) == 1)
        {
          ThreadManager.post(new QRDisplayActivity.24(this, str1), 8, null, true);
          if (this.jdField_c_of_type_Int != 2) {
            break label654;
          }
          ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qq", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
          return;
          int i1 = -1;
          try
          {
            if (WXShareHelper.a().a()) {
              continue;
            }
            i1 = 2131720753;
            if (i1 == -1) {
              continue;
            }
            QQToast.a(this, getString(i1), 0).b(getTitleBarHeight());
            if (this.jdField_c_of_type_Int == 2)
            {
              if (this.jdField_i_of_type_Int != 2) {
                break label843;
              }
              str1 = "qr_wechat";
              TroopReportor.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
            }
            this.jdField_i_of_type_Int = -1;
            return;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            QRUtils.a(1, 2131696461);
          }
          if (this.jdField_c_of_type_Int != 2) {
            break;
          }
          if (this.jdField_i_of_type_Int == 2)
          {
            localObject = "qr_wechat";
            TroopReportor.a("Grp_share", "grpData_admin", (String)localObject, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
            return;
            if (WXShareHelper.a().b()) {
              continue;
            }
            i1 = 2131720754;
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
            {
              this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new QRDisplayActivity.22(this);
              WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
            }
            ThreadManager.post(new QRDisplayActivity.23(this, (String)localObject, str3), 8, null, true);
            return;
          }
          localObject = "qr_circle";
          continue;
        }
        Object localObject = str3;
        continue;
        if (this.jdField_c_of_type_Int != 2) {
          break;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        QRUtils.a(1, 2131696461);
      }
      TroopReportor.a("Grp_share", "grpData_admin", "qr_qq", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
      return;
      label654:
      if (this.jdField_c_of_type_Int != 5) {
        break;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8006674", "0X8006674", 0, 0, "", "", "", "");
      return;
      g();
      if ((this.jdField_g_of_type_Int & 0x1) != 0) {
        ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qzone", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
        return;
      }
      if (this.jdField_c_of_type_Int != 5) {
        break;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8006675", "0X8006675", 0, 0, "", "", "", "");
      return;
      label843:
      String str2 = "qr_circle";
    }
  }
  
  private void s()
  {
    if ((this.app.isVideoChatting()) || (!AppSetting.jdField_d_of_type_Boolean)) {
      return;
    }
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1000, 5, 0);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void t()
  {
    if ((this.app.isVideoChatting()) || (!AppSetting.jdField_d_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1001, 5, 0).sendToTarget();
  }
  
  private void u()
  {
    Object localObject1 = new ShareActionSheetV2.Param();
    getIntent().putExtra("big_brother_source_key", "biz_src_jc_gxl_ctcshare");
    ((ShareActionSheetV2.Param)localObject1).canceledOnTouchOutside = true;
    ((ShareActionSheetV2.Param)localObject1).context = this;
    ((ShareActionSheetV2.Param)localObject1).fullScreen = true;
    ((ShareActionSheetV2.Param)localObject1).lp = new ViewGroup.LayoutParams(-1, -2);
    localObject1 = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject1);
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_type", 27);
    ((ShareActionSheet)localObject1).setIntentForStartForwardRecentActivity((Intent)localObject2);
    ((ShareActionSheet)localObject1).setRowVisibility(0, 0, 0);
    localObject2 = new ArrayList();
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(26));
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    boolean bool1 = WXShareHelper.a().a();
    boolean bool2 = WXShareHelper.a().b();
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, " showMyQrCodeActionSheet() isWxInstalled = " + bool1 + " isWxSupportApi =" + bool2);
    }
    if ((bool1) && (bool2))
    {
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
    ((ShareActionSheet)localObject1).setActionSheetItems((List)localObject2, localArrayList);
    ((ShareActionSheet)localObject1).setItemClickListenerV2(new QRDisplayActivity.29(this));
    ((ShareActionSheet)localObject1).show();
  }
  
  private void v()
  {
    Object localObject1 = new ShareActionSheetV2.Param();
    getIntent().putExtra("big_brother_source_key", "biz_src_jc_gxl_ctcshare");
    ((ShareActionSheetV2.Param)localObject1).canceledOnTouchOutside = true;
    ((ShareActionSheetV2.Param)localObject1).context = this;
    ((ShareActionSheetV2.Param)localObject1).fullScreen = true;
    ((ShareActionSheetV2.Param)localObject1).lp = new ViewGroup.LayoutParams(-1, -2);
    localObject1 = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject1);
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_type", 27);
    ((ShareActionSheet)localObject1).setIntentForStartForwardRecentActivity((Intent)localObject2);
    ((ShareActionSheet)localObject1).setRowVisibility(0, 0, 0);
    localObject2 = new ArrayList();
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(26));
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    boolean bool1 = WXShareHelper.a().a();
    boolean bool2 = WXShareHelper.a().b();
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, " showMyQrCodeActionSheet() isWxInstalled = " + bool1 + " isWxSupportApi =" + bool2);
    }
    if ((bool1) && (bool2))
    {
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
    ((ShareActionSheet)localObject1).setActionSheetItems((List)localObject2, localArrayList);
    ((ShareActionSheet)localObject1).setItemClickListenerV2(new QRDisplayActivity.30(this));
    ((ShareActionSheet)localObject1).show();
  }
  
  private void w()
  {
    String str = String.format(getString(2131689592), new Object[] { a() });
    if (QLog.isColorLevel()) {
      QLog.i("QRDisplayActivity", 2, "copyTroopLink.text:" + str);
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((android.text.ClipboardManager)getSystemService("clipboard")).setText(str);
    }
    for (;;)
    {
      QQToast.a(this, 2, getString(2131690077), 0).b(getTitleBarHeight());
      this.jdField_i_of_type_Int = -1;
      return;
      ((android.content.ClipboardManager)getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("my_qr_url", str));
    }
  }
  
  private void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "showURLProgressView() mTvProgress =" + this.jdField_h_of_type_AndroidWidgetTextView);
    }
    if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  private void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "hideURLProgressView() mTvProgress =" + this.jdField_h_of_type_AndroidWidgetTextView);
    }
    if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void z()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375188));
    this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView = ((QidPagView)findViewById(2131374423));
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, this.jdField_h_of_type_AndroidViewView).b(53).a(20).e(20).d(20).a();
    this.jdField_k_of_type_Int = getResources().getColor(2131167216);
    int i1 = QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
    if (i1 == 2) {
      a(i1, false);
    }
    if (!QVipQidProcessor.c().jdField_b_of_type_Boolean)
    {
      this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      findViewById(2131375199).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(8);
    }
  }
  
  public Bitmap a()
  {
    if (this.jdField_d_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      getTitleBarView().setVisibility(8);
      Bitmap localBitmap = QRUtils.a(this, QRUtils.a(this.jdField_j_of_type_AndroidViewView), this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView.a());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      getTitleBarView().setVisibility(0);
      return localBitmap;
    }
    return this.jdField_d_of_type_AndroidGraphicsBitmap;
  }
  
  protected BitMatrix a(String paramString, int paramInt1, int paramInt2)
  {
    String str = b();
    if (str == null) {}
    do
    {
      return null;
      str = getSharedPreferences("qrcode", 0).getString(str, null);
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 2, "getPrefMatrix uin: " + paramString + " type: " + paramInt1 + " data: " + str);
      }
    } while (str == null);
    return QRUtils.a(str, paramInt2);
  }
  
  public String a()
  {
    String str = b();
    if (str == null) {
      return null;
    }
    return getSharedPreferences("qrcode", 0).getString(str, null);
  }
  
  protected String a(String paramString)
  {
    paramString = "discussionnick_name" + paramString;
    return getSharedPreferences("qrcode", 0).getString(paramString, null);
  }
  
  protected String a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i1 = 0;
    while (i1 < paramList.size())
    {
      localStringBuffer.append((String)paramList.get(i1));
      if (i1 != paramList.size() - 1) {
        localStringBuffer.append("、");
      }
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "enter focus, " + this.app.isVideoChatting());
    }
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    String str;
    switch (paramInt)
    {
    default: 
      str = HardCodeUtil.a(2131711170);
    }
    for (;;)
    {
      a(2130839715, str);
      finish();
      return;
      str = HardCodeUtil.a(2131711171);
      continue;
      str = HardCodeUtil.a(2131711168);
    }
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (!QVipQidProcessor.c().jdField_b_of_type_Boolean) {
      return;
    }
    if (a()) {}
    for (QrCodeConfBean.QrCodeList localQrCodeList = (QrCodeConfBean.QrCodeList)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.get(this.jdField_h_of_type_Int);; localQrCodeList = null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      switch (paramInt)
      {
      }
      while (paramBoolean)
      {
        QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString, paramInt);
        return;
        localLayoutParams.addRule(3, 2131375184);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_k_of_type_AndroidViewView.setVisibility(0);
        if (a()) {
          a(localQrCodeList, false);
        }
        for (;;)
        {
          b(false);
          break;
          o();
        }
        localLayoutParams.addRule(3, 2131375188);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_k_of_type_AndroidViewView.setVisibility(8);
        a(new QrCodeConfBean.QrCodeList(localQrCodeList, QidCardManager.c(this.jdField_c_of_type_JavaLangString)), false, true);
        b(true);
      }
      break;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "template ready, draw qrcode");
    }
    if ((this.jdField_b_of_type_Boolean) || (super.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    Bitmap localBitmap1 = (Bitmap)paramBundle.getParcelable("bkg");
    Bitmap localBitmap2 = (Bitmap)paramBundle.getParcelable("qrbkg");
    int i4 = paramBundle.getInt("B");
    int i5 = paramBundle.getInt("W");
    Rect localRect = (Rect)paramBundle.getParcelable("qrloc");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("clip");
    if (paramBundle.containsKey("qrsz"))
    {
      i1 = paramBundle.getInt("qrsz");
      localObject = a();
      if (localObject != null) {
        this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = QRUtils.a((String)localObject, i1);
      }
    }
    int i6 = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a();
    Object localObject = new int[i6 * i6];
    int i1 = 0;
    while (i1 < i6)
    {
      i2 = 0;
      if (i2 < i6)
      {
        if (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a(i2, i1)) {}
        for (int i3 = i4;; i3 = i5)
        {
          localObject[(i1 * i6 + i2)] = i3;
          i2 += 1;
          break;
        }
      }
      i1 += 1;
    }
    Bitmap localBitmap3 = Bitmap.createBitmap(i6, i6, Bitmap.Config.ARGB_8888);
    localBitmap3.setPixels((int[])localObject, 0, i6, 0, 0, i6, i6);
    int i2 = 0;
    i1 = i2;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L)
    {
      if (this.jdField_b_of_type_Int == 2) {
        i1 = 2130844081;
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      if (this.jdField_c_of_type_Int != 1) {
        break label378;
      }
      a(paramBundle, localArrayList, localBitmap3);
      label332:
      localBitmap3.recycle();
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        break label453;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      i1 = i2;
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
      i1 = 2130844081;
      break;
      label378:
      if (this.jdField_c_of_type_Int == 2)
      {
        b(paramBundle, localArrayList, localBitmap3);
        break label332;
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = QRUtils.a(this, localBitmap1, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBundle.getInt("nameClr"), this.jdField_a_of_type_JavaLangString, localBitmap2, localBitmap3, paramBundle.getInt("head"), paramBundle.getInt("tipsClr"), this.jdField_b_of_type_JavaLangString, localRect, localArrayList, i1);
      break label332;
      label453:
      if (super.isResume())
      {
        paramBundle = DialogUtil.a(this, 230);
        paramBundle.setMessage(2131718703);
        paramBundle.setPositiveButton(2131694615, new QRDisplayActivity.16(this));
        paramBundle.show();
      }
      else
      {
        super.finish();
      }
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    String str = b();
    if (str == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setPrefMatrix uin: " + paramString1 + " type: " + paramInt + " data: " + paramString2);
    }
    paramString1 = getSharedPreferences("qrcode", 0).edit();
    paramString1.putString(str, paramString2);
    paramString1.commit();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    paramString1 = "discussionnick_name" + paramString1;
    SharedPreferences.Editor localEditor = getSharedPreferences("qrcode", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  void a(boolean paramBoolean)
  {
    Intent localIntent;
    Object localObject;
    if (this.jdField_c_of_type_Int == 11)
    {
      localIntent = getIntent();
      localObject = localIntent.getParcelableExtra("PARAM_QRForwardReceiver");
      if ((localObject instanceof ResultReceiver))
      {
        localObject = (ResultReceiver)localObject;
        if (!paramBoolean) {
          break label55;
        }
      }
    }
    label55:
    for (int i1 = -1;; i1 = 0)
    {
      ((ResultReceiver)localObject).send(i1, localIntent.getExtras());
      return;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.size());
  }
  
  public String b()
  {
    if (this.jdField_c_of_type_Int == 1) {
      return "user" + this.jdField_c_of_type_JavaLangString;
    }
    if (this.jdField_c_of_type_Int == 2) {
      return "group" + this.jdField_c_of_type_JavaLangString;
    }
    if (this.jdField_c_of_type_Int == 5) {
      return "discussion" + this.jdField_c_of_type_JavaLangString;
    }
    if (this.jdField_c_of_type_Int == 11) {
      return "groupqav" + this.jdField_c_of_type_JavaLangString;
    }
    return null;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "enter focus_clear");
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 1001, 3, 0).sendToTarget();
  }
  
  public void b(int paramInt)
  {
    long l1 = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "1", 0, null);
    Intent localIntent = new Intent(this, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=1&seq=" + l1));
    startActivityForResult(localIntent, -1);
  }
  
  public void b(boolean paramBoolean)
  {
    int i1 = 17170445;
    int i3;
    int i2;
    if (paramBoolean)
    {
      i1 = this.jdField_l_of_type_Int;
      this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(this.jdField_l_of_type_Int);
      this.jdField_c_of_type_AndroidWidgetImageView.setColorFilter(this.jdField_l_of_type_Int);
      this.jdField_d_of_type_AndroidWidgetImageView.setColorFilter(this.jdField_l_of_type_Int);
      i3 = 17170445;
      i2 = i1;
    }
    for (;;)
    {
      this.jdField_f_of_type_AndroidViewView.setBackgroundResource(i3);
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(i3);
      this.jdField_h_of_type_AndroidViewView.setBackgroundResource(i3);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i2);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i2);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i2);
      if (this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView != null)
      {
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView.a(this.jdField_l_of_type_Int);
      }
      return;
      if (a()) {
        i1 = 2130845028;
      }
      i2 = this.jdField_k_of_type_Int;
      this.jdField_b_of_type_AndroidWidgetImageView.clearColorFilter();
      this.jdField_c_of_type_AndroidWidgetImageView.clearColorFilter();
      this.jdField_d_of_type_AndroidWidgetImageView.clearColorFilter();
      i3 = i1;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView.a();
  }
  
  protected void c()
  {
    Object localObject1 = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(null);
    getTitleBarView().setBackgroundColor(0);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    findViewById(2131375162).setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.m = findViewById(16908290);
    this.n = findViewById(2131375200);
    this.n.setVisibility(0);
    this.o = this.n.findViewById(2131375138);
    this.o.setOnClickListener(this);
    this.o.setContentDescription(getString(2131699073));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)this.n.findViewById(2131375130));
    this.jdField_i_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)this.n.findViewById(2131375131));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131375135));
    this.jdField_i_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_i_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131375137));
    this.jdField_k_of_type_AndroidWidgetImageView = ((ImageView)this.n.findViewById(2131375132));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131375134));
    Object localObject2 = HardCodeUtil.a(2131696448);
    Object localObject3 = this.jdField_c_of_type_JavaLangString;
    LongClickCopyAction.attachCopyAction(this.jdField_j_of_type_AndroidWidgetTextView, (String)localObject2, (String)localObject3);
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131375136));
    this.jdField_j_of_type_AndroidWidgetTextView.setContentDescription(getString(2131716908));
    localObject2 = findViewById(2131368117);
    ((View)localObject2).setVisibility(0);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131375176);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375175));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375177));
    this.jdField_i_of_type_AndroidViewView = findViewById(2131375202);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375201));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375203));
    localObject3 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject3 != null)
    {
      localObject3 = ((TroopManager)localObject3).b(this.jdField_c_of_type_JavaLangString);
      if (localObject3 != null)
      {
        if (((TroopInfo)localObject3).isNewTroop)
        {
          a((TroopInfo)localObject3);
          this.jdField_f_of_type_Boolean = true;
          this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_j_of_type_AndroidWidgetTextView.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject1).topMargin = 0;
          this.jdField_j_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
          localObject1 = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).height -= 42;
          this.o.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if ((((TroopInfo)localObject3).cGroupOption != 3) || ((TroopInfo.hasPayPrivilege(((TroopInfo)localObject3).troopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(((TroopInfo)localObject3).troopPrivilegeFlag, 512)))) {
          break label928;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not allow join mask");
        }
        this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_l_of_type_AndroidWidgetTextView.setText(getString(2131696463));
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      }
    }
    for (;;)
    {
      int i1 = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131298066) * 3) / 8;
      localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
      if (localObject1 != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i1;
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = i1;
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$MyViewAlphaOnTouchListener = new QRDisplayActivity.MyViewAlphaOnTouchListener(this, null);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$MyViewAlphaOnTouchListener);
      this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_i_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$MyViewAlphaOnTouchListener);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839549);
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374770));
      this.jdField_b_of_type_JavaLangString = getString(2131717024);
      this.leftView.setContentDescription(getString(2131697702));
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean = QrCodeDisplayConfProcessor.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.size() <= 0) || (TextUtils.isEmpty(((QrCodeConfBean.QrCodeList)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString))) {
        this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_h_of_type_Int = QRUtils.b(this.app);
      if ((this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.size())) {
        break;
      }
      this.m.setBackgroundResource(2130847311);
      localObject1 = getResources().getDrawable(2130851150);
      ((Drawable)localObject1).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject1);
      this.centerView.setTextColor(-16777216);
      return;
      label928:
      if (((((TroopInfo)localObject3).dwGroupFlagExt & 0x80) != 0L) && (!((TroopInfo)localObject3).isAdmin()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not invite join mask");
        }
        this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_l_of_type_AndroidWidgetTextView.setText(getString(2131696464));
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      }
    }
    b((QrCodeConfBean.QrCodeList)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.get(this.jdField_h_of_type_Int), false);
  }
  
  public void c(int paramInt)
  {
    if ((QLog.isColorLevel()) && (paramInt != 0)) {
      QLog.d("QRDisplayActivity", 2, "onPlayStop, " + paramInt);
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1001);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1003, 500L);
      return;
    } while (this.jdField_b_of_type_AndroidOsHandler.hasMessages(1001));
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, 1000L);
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(2131717010, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(2131717012, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(2131717009, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new QRDisplayActivity.11(this));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new QRDisplayActivity.12(this));
    }
    if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_h_of_type_Boolean = false;
      this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    if (this.jdField_c_of_type_Int == 2) {
      localObject1 = "";
    }
    Object localObject2;
    label58:
    boolean bool;
    switch (paramInt1)
    {
    default: 
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (paramInt2 == -1)
        {
          localObject2 = "0";
          TroopReportor.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), localObject2 });
        }
      }
      else
      {
        if (paramInt2 != -1) {
          break label243;
        }
        bool = true;
        label105:
        a(bool);
        if (paramInt2 == -1)
        {
          if (paramInt1 != 1) {
            break label249;
          }
          a(0, getString(2131717011));
          if (QLog.isColorLevel()) {
            QLog.i("QRDisplayActivity", 2, "shareQRCode success");
          }
          if ((this.jdField_g_of_type_Int & 0x1) != 0) {
            ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416F", "0X800416F", 0, 0, "", "", "", "");
          }
        }
      }
      break;
    }
    for (;;)
    {
      if ((this.jdField_c_of_type_Int == 1) && (paramInt1 == 1)) {
        B();
      }
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      localObject1 = "qr_qzone";
      break;
      localObject1 = "qr_qq";
      break;
      localObject2 = "1";
      break label58;
      label243:
      bool = false;
      break label105;
      label249:
      if (paramInt1 == 2)
      {
        localObject1 = new Intent(this, SplashActivity.class);
        ((Intent)localObject1).putExtras(paramIntent);
        localObject2 = ForwardUtils.a((Intent)localObject1);
        ForwardUtils.a(this.app, this, (SessionInfo)localObject2, (Intent)localObject1);
      }
      else if (paramInt1 == 21)
      {
        localObject1 = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject1).putExtras(new Bundle(paramIntent.getExtras()));
        startActivity((Intent)localObject1);
        finish();
      }
      else if (paramInt1 != 3) {}
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if ((1 == super.getIntent().getIntExtra("type", 1)) || (2 == super.getIntent().getIntExtra("type", 2))) {
      this.mActNeedImmersive = false;
    }
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    super.setContentView(2131560545);
    paramBundle = super.getIntent();
    this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("from");
    this.jdField_g_of_type_Int = paramBundle.getIntExtra("reportFlag", 0);
    super.setTitle(paramBundle.getStringExtra("title"));
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("nick");
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)paramBundle.getParcelableExtra("face"));
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("type", 1);
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("adminLevel", 2);
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("GroupFlagExt", 0L);
    this.jdField_b_of_type_Int = ((int)paramBundle.getLongExtra("AuthGroupType", 0L));
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("isQidianPrivateTroop", false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131375163));
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131375193);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131375182);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131375204);
    if (this.jdField_c_of_type_Int == 1)
    {
      q();
      z();
    }
    Object localObject1;
    int i1;
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131375179);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131374193);
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131696451));
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "display qrcode, type: " + this.jdField_c_of_type_Int);
      }
      if (this.jdField_c_of_type_Int != 5) {
        break label1208;
      }
      getIntent().getStringExtra("discussion_shorturl");
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      if (this.app != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
        this.app.registObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver);
      }
      this.leftView.setContentDescription(getString(2131696080));
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131696081));
      setResult(-1, getIntent());
      paramBundle = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject2 = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      localObject1 = ((DiscussionManager)localObject2).a(this.jdField_c_of_type_JavaLangString);
      if (localObject1 != null) {
        break;
      }
      i();
      i1 = 1;
      this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager = new CodeMaskManager(this, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_d_of_type_JavaLangRunnable, 60000L);
      if (i1 != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_JavaLangString + "," + this.jdField_b_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidViewView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.jdField_g_of_type_Int & 0x1) != 0) {
        ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416D", "0X800416D", 0, 0, "", "", "", "");
      }
      this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 1, 0).sendToTarget();
      return true;
      if (this.jdField_c_of_type_Int == 2)
      {
        c();
        this.jdField_c_of_type_AndroidViewView.post(this.jdField_c_of_type_JavaLangRunnable);
      }
      else if (this.jdField_c_of_type_Int == 5)
      {
        findViewById(2131374192).setVisibility(0);
        findViewById(2131368114).setVisibility(0);
        findViewById(2131375170).setOnClickListener(this);
        findViewById(2131375171).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131717020);
      }
      else if (this.jdField_c_of_type_Int == 11)
      {
        findViewById(2131374192).setVisibility(0);
        findViewById(2131368114).setVisibility(0);
        findViewById(2131375170).setOnClickListener(this);
        findViewById(2131375171).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131717049);
      }
    }
    Object localObject2 = ((DiscussionManager)localObject2).a(this.jdField_c_of_type_JavaLangString);
    if (localObject2 != null)
    {
      this.jdField_f_of_type_Int = ((List)localObject2).size();
      if (!((DiscussionInfo)localObject1).hasRenamed())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QRDisplayActivity", 4, "title not defined, join by nicks");
        }
        if (localObject2 != null) {
          localObject1 = ((List)localObject2).iterator();
        }
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1036;
        }
        localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
        if (this.app.getAccount().equals(((DiscussionMemberInfo)localObject2).memberUin))
        {
          this.jdField_b_of_type_JavaUtilList.add(ContactUtils.h(this.app, ((DiscussionMemberInfo)localObject2).memberUin));
          continue;
          this.jdField_f_of_type_Int = 0;
          break;
        }
        Friends localFriends = paramBundle.e(((DiscussionMemberInfo)localObject2).memberUin);
        if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name))) {
          this.jdField_b_of_type_JavaUtilList.add(localFriends.name);
        } else if (a(((DiscussionMemberInfo)localObject2).memberUin) != null) {
          this.jdField_b_of_type_JavaUtilList.add(a(((DiscussionMemberInfo)localObject2).memberUin));
        } else {
          this.jdField_a_of_type_JavaUtilList.add(((DiscussionMemberInfo)localObject2).memberUin);
        }
      }
      label1036:
      if ((this.jdField_b_of_type_JavaUtilList.size() >= 5) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label1315;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "fetch nicks from server");
      }
      paramBundle = new String[this.jdField_a_of_type_JavaUtilList.size()];
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      i1 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramBundle[i1] = ((String)((Iterator)localObject1).next());
        i1 += 1;
      }
      ((DiscussionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(new String[] { "20002" }, paramBundle);
    }
    label1315:
    for (int i2 = 0;; i2 = 1)
    {
      i1 = i2;
      if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
        break;
      }
      Collections.sort(this.jdField_b_of_type_JavaUtilList, new QRDisplayActivity.DiscussionMemberComparator(this));
      this.jdField_a_of_type_JavaLangString = a(this.jdField_b_of_type_JavaUtilList);
      i1 = i2;
      break;
      label1208:
      if (this.jdField_c_of_type_Int == 2)
      {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131717022, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
        addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
        i1 = 1;
        break;
      }
      if (this.jdField_c_of_type_Int == 11) {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131717022, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
      }
      i1 = 1;
      break;
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager.a();
    if (this.jdField_c_of_type_Int == 5)
    {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
      {
        WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.b(this);
      }
      super.doOnDestroy();
      return;
      if (this.jdField_c_of_type_Int == 2)
      {
        removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    }
    c(false);
    y();
    ApngImage.pauseByTag(35);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 2, 0).sendToTarget();
    c(true);
    ApngImage.playByTag(35);
    n();
  }
  
  protected void e()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new QRDisplayActivity.13(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      f();
      return;
    }
    f();
  }
  
  protected void f()
  {
    ThreadManager.executeOnFileThread(new QRDisplayActivity.14(this));
    String str = null;
    if (this.jdField_c_of_type_Int == 1) {
      str = "saveConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).reportButtonClick(this.app, "", str, 1);
      return;
      if (this.jdField_c_of_type_Int == 2) {
        str = "saveGroupQRcard";
      }
    }
  }
  
  public void finish()
  {
    ForwardRecentActivity.a(getIntent(), this);
    super.finish();
  }
  
  protected void g()
  {
    ThreadManager.executeOnFileThread(new QRDisplayActivity.15(this));
    String str = null;
    if (this.jdField_c_of_type_Int == 1) {
      str = "shareConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).reportButtonClick(this.app, "", str, 1);
      return;
      if (this.jdField_c_of_type_Int == 2) {
        str = "shareGroupQRcard";
      }
    }
  }
  
  protected void h()
  {
    if ((this.jdField_b_of_type_Boolean) || (super.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "get code template");
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager;
    boolean bool3 = this.jdField_d_of_type_Boolean;
    boolean bool1;
    int i1;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L)
    {
      bool1 = true;
      i1 = this.jdField_b_of_type_Int;
      if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 2)) {
        break label123;
      }
    }
    label123:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((CodeMaskManager)localObject).a(this, bool3, bool1, i1, bool2);
      if (!this.jdField_d_of_type_Boolean) {
        break label128;
      }
      this.jdField_d_of_type_Boolean = false;
      return;
      bool1 = false;
      break;
    }
    label128:
    if (this.jdField_c_of_type_Int == 1) {}
    for (localObject = "changeConsumerQRcard";; localObject = "changeGroupQRcard")
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).reportButtonClick(this.app, "", (String)localObject, 1);
      return;
    }
  }
  
  @TargetApi(14)
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool1;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1004: 
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.app.setTalkbackSwitch();
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "talkback value " + AppSetting.jdField_d_of_type_Boolean);
        }
        if ((AppSetting.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Int == 1))
        {
          bool1 = ChirpWrapper.a();
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "isSoLoaded " + bool1);
          }
          if (!bool1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler == null) {
              this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler = ((ChirpSoHandler)((EarlyDownloadManager)this.app.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a("qq.android.system.chirp"));
            }
            if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler == null) {
              break label699;
            }
            this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.a(this);
            this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.a(true);
            bool1 = false;
          }
        }
      }
      break;
    }
    for (;;)
    {
      BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.26(this, bool1));
      break;
      boolean bool2 = true;
      bool1 = bool2;
      if (!this.jdField_k_of_type_Boolean)
      {
        BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.25(this));
        this.jdField_k_of_type_Boolean = true;
        bool1 = bool2;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.jdField_j_of_type_Boolean);
        }
        if (this.jdField_j_of_type_Boolean) {
          break;
        }
        String str = getFilesDir() + this.app.getCurrentAccountUin() + "_vqr.dat";
        File localFile = new File(str);
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "voiceFile.exists = " + localFile.exists());
        }
        if (!localFile.exists()) {
          if (a(str)) {
            break label538;
          }
        }
        label538:
        for (bool1 = true;; bool1 = false)
        {
          this.jdField_j_of_type_Boolean = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.jdField_j_of_type_Boolean);
          }
          if (this.jdField_j_of_type_Boolean) {
            break label543;
          }
          if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null)
          {
            this.jdField_a_of_type_ComTencentChirpPcmPlayer = new PcmPlayer(this, this, 44100, str);
            this.jdField_a_of_type_ComTencentChirpPcmPlayer.a();
            QQAudioUtils.a(this, true);
          }
          if (paramMessage.arg1 != 5) {
            break;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 0, 0, "", "", "", "");
          break;
        }
        label543:
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1003);
        break;
        if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentChirpPcmPlayer.b();
        this.jdField_a_of_type_ComTencentChirpPcmPlayer = null;
        if (paramMessage.arg1 == 5) {
          ReportController.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        if (paramMessage.arg1 == 3) {
          ReportController.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        QQAudioUtils.a(this, false);
        break;
        if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentChirpPcmPlayer.a();
        break;
        QQAppInterface.speak(jdField_j_of_type_JavaLangString);
        break;
        label699:
        bool1 = false;
      }
    }
  }
  
  protected void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if (super.isResume())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setMessage(2131718701);
      localQQCustomDialog.setPositiveButton(2131694615, new QRDisplayActivity.17(this));
      localQQCustomDialog.show();
      return;
    }
    finish();
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      QRDisplayActivity.19 local19 = new QRDisplayActivity.19(this);
      QRDisplayActivity.20 local20 = new QRDisplayActivity.20(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(getString(2131719311));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(local20);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new QRDisplayActivity.21(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(local19);
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()))
      {
        this.jdField_h_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  public void k()
  {
    if (this.jdField_c_of_type_Int == 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800AEAF", "0X800AEAF", 0, 0, "", "", "", "");
      if (QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString) == 2) {
        QidCardManager.QidCardReport.b("0X800B9A9");
      }
    }
    ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "scan_QR_code", "code_click", 0, 0, "", "", "", "");
    if ("ScannerActivity".equals(this.jdField_f_of_type_JavaLangString))
    {
      if (isInMultiWindow()) {
        QQToast.a(this, HardCodeUtil.a(2131711167), 0).a();
      }
      setResult(-1);
      finish();
      return;
    }
    if (isInMultiWindow())
    {
      QQToast.a(this, HardCodeUtil.a(2131711169), 0).a();
      return;
    }
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("from", "QRDisplayActivity");
    startActivityForResult(localIntent, 3);
  }
  
  public void l() {}
  
  public void m()
  {
    if (isResume()) {
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 4, 0).sendToTarget();
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("101600.101601");
      if (localAppInfo != null) {
        localRedTouchManager.a("101600.101601", 30);
      }
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
    }
  }
  
  public void o()
  {
    this.jdField_j_of_type_AndroidViewView.setBackgroundResource(2130847311);
    Drawable localDrawable = getResources().getDrawable(2130843941);
    localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.jdField_f_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    localDrawable = getResources().getDrawable(2130851150);
    localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.leftView.setBackgroundDrawable(localDrawable);
    this.centerView.setTextColor(-16777216);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    if (Math.abs(l1 - this.jdField_c_of_type_Long) <= 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_c_of_type_Long = l1;
      if (paramView.getId() == 2131375182)
      {
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        if (this.jdField_c_of_type_Int == 2)
        {
          h();
          if ((this.jdField_g_of_type_Int & 0x1) == 0) {
            continue;
          }
          ReportController.b(this.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
          continue;
        }
        if ((this.jdField_c_of_type_Int == 5) || (this.jdField_c_of_type_Int == 11))
        {
          h();
          ReportController.b(this.app, "CliOper", "", "", "0X8006671", "0X8006671", 0, 0, "", "", "", "");
          continue;
        }
        d();
        continue;
      }
      if (paramView.getId() == 2131375165) {
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet = new LinkShareActionSheetBuilder(this).a(this);
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        label217:
        ReportController.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
        continue;
        if (paramView.getId() == 2131375170)
        {
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          e();
          if ((this.jdField_g_of_type_Int & 0x1) != 0) {
            ReportController.b(this.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int == 5) {
            ReportController.b(this.app, "CliOper", "", "", "0X8006672", "0X8006672", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int != 2) {
            continue;
          }
          new ReportTask(this.app).a("P_CliOper").b("Grp_set").c("Grp_data").d("qr_save").a(new String[] { this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int) }).a();
          continue;
        }
        if (paramView.getId() == 2131375171)
        {
          j();
          if (this.jdField_c_of_type_Int != 5) {
            continue;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8006673", "0X8006673", 0, 0, "", "", "", "");
          continue;
        }
        if ((paramView.getId() == 2131375189) || (paramView.getId() == 2131375191))
        {
          k();
          continue;
        }
        if (paramView.getId() == 2131375173)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X800AEAD", "0X800AEAD", 0, 0, "", "", "", "");
          if (QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString) == 1) {
            this.jdField_b_of_type_AndroidGraphicsBitmap = this.jdField_c_of_type_AndroidGraphicsBitmap;
          }
          for (;;)
          {
            u();
            break;
            this.jdField_b_of_type_AndroidGraphicsBitmap = a();
            QidCardManager.QidCardReport.b("0X800B9A7");
          }
        }
        if (paramView.getId() == 2131375176)
        {
          v();
          continue;
        }
        if (paramView.getId() == 2131375202)
        {
          e();
          continue;
        }
        if (paramView.getId() == 2131375190)
        {
          k();
          continue;
        }
        if (paramView.getId() == 2131375197)
        {
          if (this.jdField_j_of_type_Int == 0) {
            A();
          }
          for (;;)
          {
            p();
            break;
            if (this.jdField_j_of_type_Int == 1) {
              if (QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString) == 1)
              {
                a(2, true);
                QidCardManager.QidCardReport.b("0X800B96F");
              }
              else
              {
                a(1, true);
                QidCardManager.QidCardReport.b("0X800B9AB");
              }
            }
          }
        }
        if (paramView.getId() == 2131369501)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X800AEB5", "0X800AEB5", 0, 0, "", "", "", "");
          if (QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString) == 2) {}
          for (boolean bool = true;; bool = false)
          {
            d(bool);
            break;
          }
        }
        if (paramView.getId() == 2131375139)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "onClick qr_code_white_bg isLoading =" + this.jdField_a_of_type_Boolean);
          }
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X800AEB4", "0X800AEB4", 0, 0, "", "", "", "");
          a(QRUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean, this.jdField_h_of_type_Int), true);
          continue;
        }
        if (paramView.getId() != 2131375138) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "onClick qr_code_troop_white_bg isLoading =" + this.jdField_a_of_type_Boolean);
        }
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        b(QRUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean, this.jdField_h_of_type_Int), true);
      }
      catch (Exception localException)
      {
        break label217;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      int i1 = -1;
      if (!WXShareHelper.a().a()) {
        i1 = 2131720753;
      }
      for (;;)
      {
        if (i1 == -1) {
          break label104;
        }
        QRUtils.a(1, i1);
        break;
        if (!WXShareHelper.a().b()) {
          i1 = 2131720754;
        }
      }
      label104:
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new QRDisplayActivity.18(this);
        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      }
      Object localObject = this.app;
      String str1;
      label149:
      String str2;
      Bitmap localBitmap;
      String str3;
      if (paramInt == 2)
      {
        str1 = "1";
        ReportController.b((AppRuntime)localObject, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, str1, "", "", "");
        this.jdField_g_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
        str1 = String.format(getString(2131691847), new Object[] { this.jdField_a_of_type_JavaLangString });
        if (this.jdField_c_of_type_Int == 11) {
          str1 = getString(2131693151);
        }
        localObject = WXShareHelper.a();
        str2 = this.jdField_g_of_type_JavaLangString;
        localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
        str3 = this.jdField_d_of_type_JavaLangString;
        if (paramInt != 2) {
          break label293;
        }
      }
      label293:
      for (i1 = 0;; i1 = 1)
      {
        ((WXShareHelper)localObject).b(str2, str1, localBitmap, "", str3, i1);
        break;
        str1 = "0";
        break label149;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694694);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      DiscussionInfoCardActivity.a(this.app, this, 2, this.jdField_e_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
      continue;
      DiscussionInfoCardActivity.a(this.app, this, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      continue;
      DiscussionInfoCardActivity.a(this.app, this.jdField_b_of_type_Long, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void p()
  {
    ((RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("101600.101601");
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity
 * JD-Core Version:    0.7.0.1
 */