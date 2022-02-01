package com.tencent.biz.qrcode.activity;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.QrCodeConfBean;
import com.tencent.mobileqq.config.business.QrCodeConfBean.QrCodeList;
import com.tencent.mobileqq.config.business.QrCodeDisplayConfProcessor;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IChirpApi;
import com.tencent.mobileqq.qrscan.api.IQRScanEarlyHandlerApi;
import com.tencent.mobileqq.qrscan.chirp.IChirpSoDownload;
import com.tencent.mobileqq.qrscan.chirp.IChirpSoDownload.Callback;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.vas.qid.QidCardManager;
import com.tencent.mobileqq.vas.qid.QidCardManager.QidCardReport;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.mobileqq.vas.qid.QidPagView.QidData;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
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
  implements Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener, CodeMaskManager.Callback, CustomAccessibilityDelegate.CallBack, PcmPlayer.QQPlayerListener, IChirpSoDownload.Callback
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
  DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  protected QrCodeConfBean a;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver = new QRDisplayActivity.5(this);
  private EarlyHandler jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerEarlyHandler;
  protected RedTouch a;
  TroopModifyObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver = new QRDisplayActivity.2(this);
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
    jdField_j_of_type_JavaLangString = HardCodeUtil.a(2131711148);
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
    DialogUtil.a(this, 232, null, getString(2131699175), getString(2131690728), getString(2131699462), new QRDisplayActivity.34(this), new QRDisplayActivity.35(this)).show();
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
    if (QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString) == 2)
    {
      if (a()) {
        localObject = ((QrCodeConfBean.QrCodeList)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.get(this.jdField_h_of_type_Int)).jdField_a_of_type_JavaLangString;
      } else {
        localObject = null;
      }
      this.jdField_i_of_type_JavaLangString = ((String)localObject);
    }
    if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {}
    for (Object localObject = BitmapFactory.decodeResource(getResources(), 2130847180);; localObject = BitmapFactory.decodeResource(getResources(), 2130847180)) {
      for (;;)
      {
        try
        {
          localObject = ImageUtil.b(URLDrawable.getDrawable(this.jdField_i_of_type_JavaLangString).getCurrDrawable().mutate());
        }
        catch (Exception localException)
        {
          label104:
          int i1;
          int i2;
          break label104;
        }
      }
    }
    paramBundle = QRUtils.a(this, (Bitmap)localObject, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBitmap, paramArrayList, paramBundle.getInt("nameClr"), this.jdField_a_of_type_JavaLangString, String.format(getString(2131699168), new Object[] { this.jdField_c_of_type_JavaLangString }), paramBundle.getInt("tipsClr"), this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_Boolean, this.jdField_h_of_type_JavaLangString, true);
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_h_of_type_AndroidWidgetImageView.setImageBitmap(paramBundle[0]);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      i1 = PrettyAccountUtil.a();
      i2 = PrettyAccountUtil.b();
      paramArrayList = PrettyAccountUtil.a(i1, i2, String.format(getString(2131699168), new Object[] { this.jdField_c_of_type_JavaLangString }), this.jdField_c_of_type_JavaLangString);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramArrayList);
      PrettyAccountUtil.a(this.jdField_f_of_type_AndroidWidgetTextView, i1, i2);
      PrettyAccountUtil.a("0X800B239", i1, i2);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(getString(2131699180));
      this.jdField_g_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      y();
      B();
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBundle[1];
    this.jdField_c_of_type_AndroidGraphicsBitmap = paramBundle[1];
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onMaskReady: qrcodeCardCache = ");
      paramBundle.append(this.jdField_b_of_type_AndroidGraphicsBitmap);
      QLog.d("QRDisplayActivity", 2, paramBundle.toString());
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
      this.m.setBackgroundResource(2130847180);
      return;
    }
    int i1;
    if (this.m.getBackground() == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (i1 != 0) {
          localObject = getResources().getDrawable(2130847180);
        } else {
          localObject = this.m.getBackground();
        }
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramQrCodeList.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setTroopURLDrawable: urlDrawable = ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentImageURLDrawable);
          ((StringBuilder)localObject).append(" status = ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentImageURLDrawable);
          if (((StringBuilder)localObject).toString() != null)
          {
            localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus());
            QLog.d("QRDisplayActivity", 2, new Object[] { localObject });
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
          {
            b(paramQrCodeList, paramInt, paramBoolean);
            this.m.setBackgroundDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
            return;
          }
          if (i1 != 0) {
            this.m.setBackgroundResource(2130847180);
          }
          a(paramQrCodeList, paramInt, paramBoolean, this.jdField_a_of_type_ComTencentImageURLDrawable);
          x();
          this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
          this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
          return;
        }
      }
      catch (IllegalArgumentException paramQrCodeList)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setTroopURLDrawable bkgURL is illegal please check manage info e =");
        ((StringBuilder)localObject).append(paramQrCodeList);
        QLog.d("QRDisplayActivity", 1, ((StringBuilder)localObject).toString());
        QQToast.a(this, getString(2131696464), 0).a();
        y();
        if (i1 != 0) {
          this.m.setBackgroundResource(2130847180);
        }
        return;
      }
      Object localObject = " is null";
    }
  }
  
  private void a(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTroopDrawableListener(): ud = ");
      localStringBuilder.append(paramURLDrawable);
      localStringBuilder.append(" bkgURL = ");
      localStringBuilder.append(paramQrCodeList.jdField_a_of_type_JavaLangString);
      QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
    }
    paramURLDrawable.setURLDrawableListener(new QRDisplayActivity.33(this, paramQrCodeList, paramInt, paramBoolean));
  }
  
  private void a(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean1, URLDrawable paramURLDrawable, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDrawableListener(): ud = ");
      localStringBuilder.append(paramURLDrawable);
      localStringBuilder.append(" bkgURL = ");
      localStringBuilder.append(paramQrCodeList.jdField_a_of_type_JavaLangString);
      QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
    }
    paramURLDrawable.setURLDrawableListener(new QRDisplayActivity.32(this, paramQrCodeList, paramInt, paramBoolean1, paramBoolean2));
  }
  
  private void a(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ("default_bg".equals(paramQrCodeList.jdField_a_of_type_JavaLangString))
    {
      b(paramQrCodeList, paramInt, paramBoolean1, paramBoolean2);
      this.jdField_j_of_type_AndroidViewView.setBackgroundResource(2130847180);
      return;
    }
    int i1;
    if (this.jdField_j_of_type_AndroidViewView.getBackground() == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if (i1 != 0) {
        localObject = getResources().getDrawable(2130847180);
      } else {
        localObject = this.jdField_j_of_type_AndroidViewView.getBackground();
      }
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramQrCodeList.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setURLDrawable: urlDrawable = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentImageURLDrawable);
        ((StringBuilder)localObject).append(" status = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus());
        QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
      {
        b(paramQrCodeList, paramInt, paramBoolean1, paramBoolean2);
        this.jdField_j_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
        return;
      }
      if (i1 != 0) {
        this.jdField_j_of_type_AndroidViewView.setBackgroundResource(2130847180);
      }
      a(paramQrCodeList, paramInt, paramBoolean1, this.jdField_a_of_type_ComTencentImageURLDrawable, paramBoolean2);
      x();
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
      return;
    }
    catch (IllegalArgumentException paramQrCodeList)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bkgURL is illegal please check manage info e =");
      ((StringBuilder)localObject).append(paramQrCodeList);
      QLog.d("QRDisplayActivity", 1, ((StringBuilder)localObject).toString());
      QQToast.a(this, getString(2131696464), 0).a();
      y();
      if (i1 != 0) {
        this.jdField_j_of_type_AndroidViewView.setBackgroundResource(2130847180);
      }
    }
  }
  
  private void a(QrCodeConfBean.QrCodeList paramQrCodeList, boolean paramBoolean)
  {
    a(paramQrCodeList, paramBoolean, false);
  }
  
  private void a(QrCodeConfBean.QrCodeList paramQrCodeList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramQrCodeList == null)
    {
      QLog.i("QRDisplayActivity", 2, "switchMyQrTheme() qrCodeList is null just return");
      return;
    }
    if (!paramBoolean2) {
      this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.indexOf(paramQrCodeList);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchMyQrTheme().qrCodeList:");
      localStringBuilder.append(paramQrCodeList.toString());
      QLog.i("QRDisplayActivity", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramQrCodeList.jdField_a_of_type_JavaLangString))
    {
      this.jdField_h_of_type_JavaLangString = paramQrCodeList.jdField_b_of_type_JavaLangString;
      this.jdField_e_of_type_Boolean = paramQrCodeList.c();
      this.jdField_i_of_type_JavaLangString = paramQrCodeList.jdField_a_of_type_JavaLangString;
      a(paramQrCodeList, this.jdField_h_of_type_Int, paramBoolean1, paramBoolean2);
    }
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    boolean bool = paramTroopInfo.isOwnerOrAdmin(getCurrentAccountUin());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateBottomTroopInfoAndTips isOwnerOrAdmin = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (TextView)findViewById(2131367869);
    ((TextView)localObject).setVisibility(0);
    TroopReportor.a("Grp_QR", "search_upgrade", "search_upgrade_exp", 0, 0, new String[] { paramTroopInfo.troopuin });
    int i1;
    if (bool) {
      i1 = 2131716713;
    } else {
      i1 = 2131716712;
    }
    String str = paramTroopInfo.troopuin;
    str = String.format(getResources().getString(i1), new Object[] { str });
    if (bool)
    {
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new QRDisplayActivity.4(this, paramTroopInfo), str.length() - 6, str.length(), 33);
      ((TextView)localObject).setText(localSpannableString);
      ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      ((TextView)localObject).setHighlightColor(0);
      return;
    }
    ((TextView)localObject).setText(str);
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof QidProfile.GetProfileSSORsp)))
    {
      QidProfile.GetProfileSSORsp localGetProfileSSORsp = (QidProfile.GetProfileSSORsp)paramObject;
      if (localGetProfileSSORsp.is_set.get() == 0)
      {
        this.jdField_j_of_type_Int = 0;
        QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString, 1);
        return;
      }
      if (localGetProfileSSORsp.is_set.get() == 1)
      {
        if (localGetProfileSSORsp.pag_url.has()) {
          paramObject = localGetProfileSSORsp.pag_url.get();
        } else {
          paramObject = "";
        }
        QidCardManager.QidCardReport.a(paramObject);
        if (this.jdField_j_of_type_Int == 0) {
          QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString, 2);
        }
        this.jdField_j_of_type_Int = 1;
        try
        {
          this.jdField_l_of_type_Int = Color.parseColor(localGetProfileSSORsp.btn_color.get());
        }
        catch (Exception paramObject)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("QID_QR,color,parse error:");
          localStringBuilder.append(paramObject.getMessage());
          QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
        }
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
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView.jdField_a_of_type_Boolean = true;
        }
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
        if (QidCardManager.a(paramObject.jdField_a_of_type_JavaLangString) != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView.a(paramObject);
          return;
        }
        QidCardManager.a(this, this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("QID_QR,pb request,error:");
      paramObject.append(paramBoolean);
      QLog.d("QRDisplayActivity", 2, paramObject.toString());
    }
  }
  
  private static void a(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    int i1 = 0;
    while (i1 < paramArrayOfShort.length)
    {
      int i2 = i1 * 2;
      paramArrayOfByte[i2] = ((byte)(paramArrayOfShort[i1] & 0xFF));
      paramArrayOfByte[(i2 + 1)] = ((byte)(paramArrayOfShort[i1] >> 8 & 0xFF));
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
    //   13: ifne +430 -> 443
    //   16: ldc_w 778
    //   19: invokestatic 784	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   22: checkcast 778	com/tencent/mobileqq/qrscan/api/IChirpApi
    //   25: invokeinterface 787 1 0
    //   30: ifne +319 -> 349
    //   33: aload_0
    //   34: getfield 254	com/tencent/biz/qrcode/activity/QRDisplayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 790	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   40: astore 4
    //   42: new 334	java/lang/String
    //   45: dup
    //   46: ldc_w 792
    //   49: invokespecial 793	java/lang/String:<init>	(Ljava/lang/String;)V
    //   52: astore 5
    //   54: new 409	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 410	java/lang/StringBuilder:<init>	()V
    //   61: astore 6
    //   63: aload 6
    //   65: ldc_w 795
    //   68: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 6
    //   74: aload 5
    //   76: iconst_0
    //   77: bipush 14
    //   79: aload 4
    //   81: invokevirtual 637	java/lang/String:length	()I
    //   84: isub
    //   85: invokevirtual 799	java/lang/String:substring	(II)Ljava/lang/String;
    //   88: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 6
    //   94: aload 4
    //   96: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 6
    //   102: invokevirtual 425	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore 4
    //   107: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: istore_3
    //   111: iload_3
    //   112: ifeq +41 -> 153
    //   115: new 409	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 410	java/lang/StringBuilder:<init>	()V
    //   122: astore 5
    //   124: aload 5
    //   126: ldc_w 801
    //   129: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: aload 4
    //   137: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc_w 421
    //   144: iconst_2
    //   145: aload 5
    //   147: invokevirtual 425	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 428	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: ldc_w 778
    //   156: invokestatic 784	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   159: checkcast 778	com/tencent/mobileqq/qrscan/api/IChirpApi
    //   162: aload 4
    //   164: invokeinterface 805 2 0
    //   169: astore 4
    //   171: aload 4
    //   173: getfield 811	android/util/Pair:first	Ljava/lang/Object;
    //   176: checkcast 500	java/lang/Integer
    //   179: invokevirtual 814	java/lang/Integer:intValue	()I
    //   182: istore_2
    //   183: aload 4
    //   185: getfield 817	android/util/Pair:second	Ljava/lang/Object;
    //   188: checkcast 819	[S
    //   191: astore 5
    //   193: iload_2
    //   194: ifne +190 -> 384
    //   197: aload 5
    //   199: ifnull +185 -> 384
    //   202: aconst_null
    //   203: astore 6
    //   205: new 821	java/io/FileOutputStream
    //   208: dup
    //   209: aload_1
    //   210: invokespecial 824	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   213: astore_1
    //   214: aload_1
    //   215: astore 4
    //   217: aload 5
    //   219: arraylength
    //   220: iconst_2
    //   221: imul
    //   222: newarray byte
    //   224: astore 7
    //   226: aload_1
    //   227: astore 4
    //   229: aload 5
    //   231: aload 7
    //   233: invokestatic 826	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	([S[B)V
    //   236: aload_1
    //   237: astore 4
    //   239: aload_1
    //   240: aload 7
    //   242: invokevirtual 830	java/io/FileOutputStream:write	([B)V
    //   245: aload_1
    //   246: invokevirtual 833	java/io/FileOutputStream:close	()V
    //   249: goto +6 -> 255
    //   252: astore_1
    //   253: aload_1
    //   254: athrow
    //   255: ldc_w 778
    //   258: invokestatic 784	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   261: checkcast 778	com/tencent/mobileqq/qrscan/api/IChirpApi
    //   264: invokeinterface 836 1 0
    //   269: goto +174 -> 443
    //   272: astore 5
    //   274: goto +14 -> 288
    //   277: astore_1
    //   278: aconst_null
    //   279: astore 4
    //   281: goto +85 -> 366
    //   284: astore 5
    //   286: aconst_null
    //   287: astore_1
    //   288: aload_1
    //   289: astore 4
    //   291: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +18 -> 312
    //   297: aload_1
    //   298: astore 4
    //   300: ldc_w 421
    //   303: iconst_2
    //   304: ldc_w 678
    //   307: aload 5
    //   309: invokestatic 839	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   312: aload_1
    //   313: ifnull +22 -> 335
    //   316: aload_1
    //   317: invokevirtual 833	java/io/FileOutputStream:close	()V
    //   320: aload 6
    //   322: astore_1
    //   323: goto +12 -> 335
    //   326: astore_1
    //   327: aload_1
    //   328: athrow
    //   329: aload 6
    //   331: astore_1
    //   332: goto +3 -> 335
    //   335: aload_1
    //   336: ifnull +13 -> 349
    //   339: aload_1
    //   340: invokevirtual 833	java/io/FileOutputStream:close	()V
    //   343: goto +6 -> 349
    //   346: astore_1
    //   347: aload_1
    //   348: athrow
    //   349: ldc_w 778
    //   352: invokestatic 784	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   355: checkcast 778	com/tencent/mobileqq/qrscan/api/IChirpApi
    //   358: invokeinterface 836 1 0
    //   363: iconst_0
    //   364: ireturn
    //   365: astore_1
    //   366: aload 4
    //   368: ifnull +14 -> 382
    //   371: aload 4
    //   373: invokevirtual 833	java/io/FileOutputStream:close	()V
    //   376: goto +6 -> 382
    //   379: astore_1
    //   380: aload_1
    //   381: athrow
    //   382: aload_1
    //   383: athrow
    //   384: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq -38 -> 349
    //   390: new 409	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 410	java/lang/StringBuilder:<init>	()V
    //   397: astore_1
    //   398: aload_1
    //   399: ldc_w 841
    //   402: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_1
    //   407: iload_2
    //   408: invokevirtual 563	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: ldc_w 421
    //   415: iconst_4
    //   416: aload_1
    //   417: invokevirtual 425	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 428	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: goto -74 -> 349
    //   426: astore_1
    //   427: ldc_w 778
    //   430: invokestatic 784	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   433: checkcast 778	com/tencent/mobileqq/qrscan/api/IChirpApi
    //   436: invokeinterface 836 1 0
    //   441: aload_1
    //   442: athrow
    //   443: iconst_1
    //   444: ireturn
    //   445: astore_1
    //   446: goto -191 -> 255
    //   449: astore_1
    //   450: goto -121 -> 329
    //   453: astore_1
    //   454: goto -105 -> 349
    //   457: astore 4
    //   459: goto -77 -> 382
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	QRDisplayActivity
    //   0	462	1	paramString	String
    //   182	226	2	i1	int
    //   110	2	3	bool	boolean
    //   40	332	4	localObject1	Object
    //   457	1	4	localIOException	java.io.IOException
    //   52	178	5	localObject2	Object
    //   272	1	5	localException1	Exception
    //   284	24	5	localException2	Exception
    //   61	269	6	localStringBuilder	StringBuilder
    //   224	17	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   245	249	252	finally
    //   217	226	272	java/lang/Exception
    //   229	236	272	java/lang/Exception
    //   239	245	272	java/lang/Exception
    //   205	214	277	finally
    //   327	329	277	finally
    //   205	214	284	java/lang/Exception
    //   316	320	326	finally
    //   339	343	346	finally
    //   217	226	365	finally
    //   229	236	365	finally
    //   239	245	365	finally
    //   291	297	365	finally
    //   300	312	365	finally
    //   371	376	379	finally
    //   33	111	426	finally
    //   115	153	426	finally
    //   153	193	426	finally
    //   253	255	426	finally
    //   347	349	426	finally
    //   380	382	426	finally
    //   382	384	426	finally
    //   384	423	426	finally
    //   245	249	445	java/io/IOException
    //   316	320	449	java/io/IOException
    //   339	343	453	java/io/IOException
    //   371	376	457	java/io/IOException
  }
  
  public static List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696399);
    localActionSheetItem.icon = 2130839067;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 0;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696413);
    localActionSheetItem.icon = 2130839068;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696420);
    localActionSheetItem.icon = 2130839071;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696402);
    localActionSheetItem.icon = 2130839065;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void b(int paramInt, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("temp_qrcode_share_");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".png");
      ThreadManager.post(new QRDisplayActivity.31(this, localStringBuilder.toString(), paramInt, paramString), 8, null, true);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      label52:
      break label52;
    }
    QRUtils.a(1, 2131696480);
  }
  
  private void b(Bundle paramBundle, ArrayList<Rect> paramArrayList, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {}
    for (Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130847180);; localBitmap = BitmapFactory.decodeResource(getResources(), 2130847180)) {
      for (;;)
      {
        try
        {
          localBitmap = ImageUtil.b(URLDrawable.getDrawable(this.jdField_i_of_type_JavaLangString).getCurrDrawable().mutate());
        }
        catch (Exception localException)
        {
          label46:
          break label46;
        }
      }
    }
    paramBundle = QRUtils.a(this, localBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBitmap, paramArrayList, paramBundle.getInt("nameClr"), this.jdField_a_of_type_JavaLangString, String.format(getString(2131699535), new Object[] { this.jdField_c_of_type_JavaLangString }), paramBundle.getInt("tipsClr"), this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_Boolean, this.jdField_h_of_type_JavaLangString, this.jdField_f_of_type_Boolean ^ true);
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_j_of_type_AndroidWidgetImageView.setImageBitmap(paramBundle[0]);
      this.jdField_i_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_j_of_type_AndroidWidgetTextView.setText(String.format(getString(2131699535), new Object[] { this.jdField_c_of_type_JavaLangString }));
      this.jdField_k_of_type_AndroidWidgetTextView.setText(getString(2131699180));
      this.jdField_i_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBundle[1];
    if (localBitmap != null) {
      localBitmap.recycle();
    }
  }
  
  private void b(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      h();
    }
    y();
    QRUtils.b(this.app, paramInt);
    ImmersiveUtils.setStatusTextColor(paramQrCodeList.a() ^ true, getWindow());
    Object localObject = getResources().getDrawable(2130851066);
    paramBoolean = paramQrCodeList.b();
    int i1 = -1;
    if (paramBoolean) {
      paramInt = -1;
    } else {
      paramInt = -16777216;
    }
    ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.leftView.setBackgroundDrawable((Drawable)localObject);
    localObject = this.centerView;
    if (paramQrCodeList.b()) {
      paramInt = i1;
    } else {
      paramInt = -16777216;
    }
    ((TextView)localObject).setTextColor(paramInt);
    this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130844904);
    this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130844904);
  }
  
  private void b(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!paramBoolean2)) {
      h();
    }
    y();
    QRUtils.a(this.app, paramInt);
    ImmersiveUtils.setStatusTextColor(paramQrCodeList.a() ^ true, getWindow());
    Object localObject = getResources().getDrawable(2130843861);
    paramBoolean1 = paramQrCodeList.b();
    int i1 = -1;
    if (paramBoolean1) {
      paramInt = -1;
    } else {
      paramInt = -16777216;
    }
    ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.jdField_f_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    localObject = getResources().getDrawable(2130851066);
    if (paramQrCodeList.b()) {
      paramInt = -1;
    } else {
      paramInt = -16777216;
    }
    ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.leftView.setBackgroundDrawable((Drawable)localObject);
    localObject = this.centerView;
    if (paramQrCodeList.b()) {
      paramInt = i1;
    } else {
      paramInt = -16777216;
    }
    ((TextView)localObject).setTextColor(paramInt);
    if (!paramBoolean2)
    {
      this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130844904);
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130844904);
      this.jdField_h_of_type_AndroidViewView.setBackgroundResource(2130844904);
    }
  }
  
  private void b(QrCodeConfBean.QrCodeList paramQrCodeList, boolean paramBoolean)
  {
    if (paramQrCodeList == null)
    {
      QLog.i("QRDisplayActivity", 2, "switchMyQrTheme() qrCodeList is null just return");
      return;
    }
    this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.indexOf(paramQrCodeList);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchMyQrTheme().qrCodeList:");
      localStringBuilder.append(paramQrCodeList.toString());
      QLog.i("QRDisplayActivity", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramQrCodeList.jdField_a_of_type_JavaLangString))
    {
      this.jdField_h_of_type_JavaLangString = paramQrCodeList.jdField_b_of_type_JavaLangString;
      this.jdField_e_of_type_Boolean = paramQrCodeList.c();
      this.jdField_i_of_type_JavaLangString = paramQrCodeList.jdField_a_of_type_JavaLangString;
      a(paramQrCodeList, this.jdField_h_of_type_Int, paramBoolean);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendIsResumeBroadcast isNeedSend = ");
      localStringBuilder.append(this.jdField_g_of_type_Boolean);
      localStringBuilder.append(" ,isResume = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
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
      localActionSheet.addButton(2131696472, 1, 10);
      QidCardManager.QidCardReport.b("0X800B973");
    }
    localActionSheet.addButton(2131696465, 1, 7);
    localActionSheet.addButton(2131696471, 1, 8);
    localActionSheet.addCancelButton(2131690728);
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
    findViewById(2131374677).setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_j_of_type_AndroidViewView = findViewById(16908290);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369216));
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697523));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.leftView.setContentDescription(getString(2131718866));
    this.jdField_k_of_type_AndroidViewView = findViewById(2131374699);
    this.jdField_k_of_type_AndroidViewView.setVisibility(0);
    this.jdField_l_of_type_AndroidViewView = this.jdField_k_of_type_AndroidViewView.findViewById(2131374654);
    this.jdField_l_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_l_of_type_AndroidViewView.setContentDescription(getString(2131699180));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_k_of_type_AndroidViewView.findViewById(2131369427));
    this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_k_of_type_AndroidViewView.findViewById(2131369454));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131379783));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131379957));
    localObject = HardCodeUtil.a(2131696466);
    String str = this.jdField_c_of_type_JavaLangString;
    localObject = LongClickCopyAction.attachCopyAction(this.jdField_f_of_type_AndroidWidgetTextView, (String)localObject, str);
    if (localObject != null) {
      ((LongClickCopyAction)localObject).setCopyListener(new QRDisplayActivity.3(this));
    }
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131379926));
    this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(getString(2131716562));
    this.jdField_b_of_type_JavaLangString = getString(2131716715);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367868));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131374688);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374687));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374689));
    this.jdField_g_of_type_AndroidViewView = findViewById(2131374705);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374704));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374706));
    this.jdField_h_of_type_AndroidViewView = findViewById(2131374712);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374711));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374713));
    int i1 = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131298060) * 3) / 8;
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839406);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374306));
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean = QrCodeDisplayConfProcessor.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.size() <= 0) || (TextUtils.isEmpty(((QrCodeConfBean.QrCodeList)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString))) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_h_of_type_Int = QRUtils.a(this.app);
    i1 = this.jdField_h_of_type_Int;
    if ((i1 >= 0) && (i1 < this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.size()))
    {
      if (QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString) == 1) {
        a((QrCodeConfBean.QrCodeList)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.get(this.jdField_h_of_type_Int), false);
      }
    }
    else {
      o();
    }
    ReportController.b(this.app, "CliOper", "", "", "0X800AEAB", "0X800AEAB", 0, 0, "", "", "", "");
    QidCardManager.QidCardReport.b("0X800B96E");
  }
  
  private void r()
  {
    boolean bool = NetworkUtil.isNetSupport(BaseApplication.getContext());
    Object localObject1 = "qr_circle";
    if (!bool)
    {
      QQToast.a(this, getString(2131692183), 0).b(getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "tryToGetShareLink: net is not supported");
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        i1 = this.jdField_i_of_type_Int;
        if (i1 != 0) {
          if (i1 != 1) {
            if (i1 != 2) {
              if (i1 != 3) {
                localObject1 = "";
              }
            }
          }
        }
        for (;;)
        {
          break;
          localObject1 = "qr_wechat";
          break;
          localObject1 = "qr_qzone";
          continue;
          localObject1 = "qr_qq";
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        TroopReportor.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
      }
      this.jdField_i_of_type_Int = -1;
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("temp_qrcode_share_");
    ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(".png");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("temp_qrcode_share_qid_");
    ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject3).append(".png");
    localObject3 = ((StringBuilder)localObject3).toString();
    i1 = this.jdField_i_of_type_Int;
    if (i1 != 0) {
      if (i1 != 1) {
        if ((i1 != 2) && (i1 != 3)) {
          return;
        }
      }
    }
    try
    {
      if (!WXShareHelper.a().a())
      {
        i1 = 2131720478;
      }
      else
      {
        if (WXShareHelper.a().b()) {
          break label852;
        }
        i1 = 2131720479;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        label787:
        continue;
        i1 = -1;
        continue;
        Object localObject2 = "qr_circle";
        continue;
        localObject2 = localObject3;
      }
    }
    if (i1 != -1)
    {
      QQToast.a(this, getString(i1), 0).b(getTitleBarHeight());
      if (this.jdField_c_of_type_Int == 2)
      {
        if (this.jdField_i_of_type_Int == 2)
        {
          localObject1 = "qr_wechat";
          TroopReportor.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
        }
      }
      else {
        this.jdField_i_of_type_Int = -1;
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new QRDisplayActivity.22(this);
        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      }
      ThreadManager.post(new QRDisplayActivity.23(this, (String)localObject1, (String)localObject3), 8, null, true);
      return;
      QRUtils.a(1, 2131696480);
      if (this.jdField_c_of_type_Int == 2)
      {
        if (this.jdField_i_of_type_Int == 2) {
          localObject1 = "qr_wechat";
        } else {
          localObject1 = "qr_circle";
        }
        TroopReportor.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
      }
      return;
      g();
      if ((this.jdField_g_of_type_Int & 0x1) != 0) {
        ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
      }
      i1 = this.jdField_c_of_type_Int;
      if (i1 == 2)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qzone", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
        return;
      }
      if (i1 == 5)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8006675", "0X8006675", 0, 0, "", "", "", "");
        return;
      }
      try
      {
        if (QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString) != 1) {
          break label864;
        }
        ThreadManager.post(new QRDisplayActivity.24(this, (String)localObject1), 8, null, true);
        i1 = this.jdField_c_of_type_Int;
        if (i1 == 2)
        {
          ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qq", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
          return;
        }
        if (i1 == 5) {
          ReportController.b(this.app, "CliOper", "", "", "0X8006674", "0X8006674", 0, 0, "", "", "", "");
        }
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        break label787;
      }
      QRUtils.a(1, 2131696480);
      if (this.jdField_c_of_type_Int == 2) {
        TroopReportor.a("Grp_share", "grpData_admin", "qr_qq", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
      }
      return;
    }
  }
  
  private void s()
  {
    if (!this.app.isVideoChatting())
    {
      if (!AppSetting.jdField_d_of_type_Boolean) {
        return;
      }
      Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1000, 5, 0);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  private void t()
  {
    if (!this.app.isVideoChatting())
    {
      if (!AppSetting.jdField_d_of_type_Boolean) {
        return;
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1001, 5, 0).sendToTarget();
    }
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
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(" showMyQrCodeActionSheet() isWxInstalled = ");
      ((StringBuilder)localObject3).append(bool1);
      ((StringBuilder)localObject3).append(" isWxSupportApi =");
      ((StringBuilder)localObject3).append(bool2);
      QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject3).toString());
    }
    if ((bool1) && (bool2))
    {
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    Object localObject3 = new ArrayList();
    ((List)localObject3).add(ShareActionSheetBuilder.ActionSheetItem.build(39));
    ((List)localObject3).add(ShareActionSheetBuilder.ActionSheetItem.build(1));
    ((ShareActionSheet)localObject1).setActionSheetItems((List)localObject2, (List)localObject3);
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
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(" showMyQrCodeActionSheet() isWxInstalled = ");
      ((StringBuilder)localObject3).append(bool1);
      ((StringBuilder)localObject3).append(" isWxSupportApi =");
      ((StringBuilder)localObject3).append(bool2);
      QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject3).toString());
    }
    if ((bool1) && (bool2))
    {
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    Object localObject3 = new ArrayList();
    ((List)localObject3).add(ShareActionSheetBuilder.ActionSheetItem.build(39));
    ((ShareActionSheet)localObject1).setActionSheetItems((List)localObject2, (List)localObject3);
    ((ShareActionSheet)localObject1).setItemClickListenerV2(new QRDisplayActivity.30(this));
    ((ShareActionSheet)localObject1).show();
  }
  
  private void w()
  {
    Object localObject1 = String.format(getString(2131689624), new Object[] { a() });
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("copyTroopLink.text:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("QRDisplayActivity", 2, ((StringBuilder)localObject2).toString());
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      ((android.text.ClipboardManager)getSystemService("clipboard")).setText((CharSequence)localObject1);
    }
    else
    {
      localObject2 = (android.content.ClipboardManager)getSystemService("clipboard");
      localObject1 = ClipData.newPlainText("my_qr_url", (CharSequence)localObject1);
      ClipboardMonitor.setPrimaryClip((android.content.ClipboardManager)localObject2, (ClipData)localObject1);
      ((android.content.ClipboardManager)localObject2).setPrimaryClip((ClipData)localObject1);
    }
    QQToast.a(this, 2, getString(2131689993), 0).b(getTitleBarHeight());
    this.jdField_i_of_type_Int = -1;
  }
  
  private void x()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showURLProgressView() mTvProgress =");
      ((StringBuilder)localObject).append(this.jdField_h_of_type_AndroidWidgetTextView);
      QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_h_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((TextView)localObject).setVisibility(0);
      this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  private void y()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideURLProgressView() mTvProgress =");
      ((StringBuilder)localObject).append(this.jdField_h_of_type_AndroidWidgetTextView);
      QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_h_of_type_AndroidWidgetTextView != null)
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject != null)
      {
        ((Animatable)localObject).stop();
        this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void z()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374703));
    this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView = ((QidPagView)findViewById(2131373973));
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, this.jdField_h_of_type_AndroidViewView).b(53).a(20).e(20).d(20).a();
    this.jdField_k_of_type_Int = getResources().getColor(2131167241);
    int i1 = QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
    if (i1 == 2) {
      a(i1, false);
    }
    if (!QVipQidProcessor.c().jdField_b_of_type_Boolean)
    {
      this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      findViewById(2131374714).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(8);
    }
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap2 = this.jdField_d_of_type_AndroidGraphicsBitmap;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      getTitleBarView().setVisibility(8);
      localBitmap1 = QRUtils.a(this, QRUtils.a(this.jdField_j_of_type_AndroidViewView), this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView.a());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      getTitleBarView().setVisibility(0);
    }
    return localBitmap1;
  }
  
  protected BitMatrix a(String paramString, int paramInt1, int paramInt2)
  {
    String str = b();
    if (str == null) {
      return null;
    }
    str = getSharedPreferences("qrcode", 0).getString(str, null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPrefMatrix uin: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" type: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" data: ");
      localStringBuilder.append(str);
      QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
    }
    if (str == null) {
      return null;
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("discussionnick_name");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    return getSharedPreferences("qrcode", 0).getString(paramString, null);
  }
  
  protected String a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
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
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enter focus, ");
      localStringBuilder.append(this.app.isVideoChatting());
      QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    String str;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        str = HardCodeUtil.a(2131711146);
      } else {
        str = HardCodeUtil.a(2131711144);
      }
    }
    else {
      str = HardCodeUtil.a(2131711147);
    }
    a(2130839573, str);
    finish();
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
    QrCodeConfBean.QrCodeList localQrCodeList = null;
    if (a()) {
      localQrCodeList = (QrCodeConfBean.QrCodeList)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.get(this.jdField_h_of_type_Int);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        localLayoutParams.addRule(3, 2131374703);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_k_of_type_AndroidViewView.setVisibility(8);
        a(new QrCodeConfBean.QrCodeList(localQrCodeList, QidCardManager.c(this.jdField_c_of_type_JavaLangString), QQTheme.a(this.jdField_l_of_type_Int) ^ true), false, true);
        b(true);
      }
    }
    else
    {
      localLayoutParams.addRule(3, 2131374699);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_k_of_type_AndroidViewView.setVisibility(0);
      if (a()) {
        a(localQrCodeList, false);
      } else {
        o();
      }
      b(false);
    }
    if (paramBoolean) {
      QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString, paramInt);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "template ready, draw qrcode");
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      if (super.isFinishing()) {
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
        while (i2 < i6)
        {
          int i3;
          if (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a(i2, i1)) {
            i3 = i4;
          } else {
            i3 = i5;
          }
          localObject[(i1 * i6 + i2)] = i3;
          i2 += 1;
        }
        i1 += 1;
      }
      Bitmap localBitmap3 = Bitmap.createBitmap(i6, i6, Bitmap.Config.ARGB_8888);
      localBitmap3.setPixels((int[])localObject, 0, i6, 0, 0, i6, i6);
      if ((this.jdField_a_of_type_Long & 0x800) != 0L)
      {
        i1 = this.jdField_b_of_type_Int;
        if (i1 == 2) {}
        while (i1 == 1)
        {
          i1 = 2130843985;
          break;
        }
      }
      i1 = 0;
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      int i2 = this.jdField_c_of_type_Int;
      if (i2 == 1) {
        a(paramBundle, localArrayList, localBitmap3);
      }
      for (;;)
      {
        break;
        if (i2 == 2) {
          b(paramBundle, localArrayList, localBitmap3);
        } else {
          this.jdField_b_of_type_AndroidGraphicsBitmap = QRUtils.a(this, localBitmap1, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBundle.getInt("nameClr"), this.jdField_a_of_type_JavaLangString, localBitmap2, localBitmap3, paramBundle.getInt("head"), paramBundle.getInt("tipsClr"), this.jdField_b_of_type_JavaLangString, localRect, localArrayList, i1);
        }
      }
      localBitmap3.recycle();
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
      }
      for (;;)
      {
        break;
        if (super.isResume())
        {
          paramBundle = DialogUtil.a(this, 230);
          paramBundle.setMessage(2131718421);
          paramBundle.setPositiveButton(2131694583, new QRDisplayActivity.16(this));
          paramBundle.show();
        }
        else
        {
          super.finish();
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    String str = b();
    if (str == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPrefMatrix uin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" type: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" data: ");
      localStringBuilder.append(paramString2);
      QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
    }
    paramString1 = getSharedPreferences("qrcode", 0).edit();
    paramString1.putString(str, paramString2);
    paramString1.commit();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("discussionnick_name");
    ((StringBuilder)localObject).append(paramString1);
    paramString1 = ((StringBuilder)localObject).toString();
    localObject = getSharedPreferences("qrcode", 0).edit();
    ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  void a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Int == 11)
    {
      Intent localIntent = getIntent();
      Object localObject = localIntent.getParcelableExtra("PARAM_QRForwardReceiver");
      if ((localObject instanceof ResultReceiver))
      {
        localObject = (ResultReceiver)localObject;
        int i1;
        if (paramBoolean) {
          i1 = -1;
        } else {
          i1 = 0;
        }
        ((ResultReceiver)localObject).send(i1, localIntent.getExtras());
      }
    }
  }
  
  public boolean a()
  {
    int i1 = this.jdField_h_of_type_Int;
    return (i1 >= 0) && (i1 < this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.size());
  }
  
  public String b()
  {
    int i1 = this.jdField_c_of_type_Int;
    StringBuilder localStringBuilder;
    if (i1 == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("user");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      return localStringBuilder.toString();
    }
    if (i1 == 2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("group");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      return localStringBuilder.toString();
    }
    if (i1 == 5)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("discussion");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      return localStringBuilder.toString();
    }
    if (i1 == 11)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("groupqav");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      return localStringBuilder.toString();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&entry=1&seq=");
    localStringBuilder.append(l1);
    localIntent.setData(Uri.parse(localStringBuilder.toString()));
    startActivityForResult(localIntent, -1);
  }
  
  public void b(boolean paramBoolean)
  {
    int i1 = 17170445;
    int i2;
    if (paramBoolean)
    {
      i2 = this.jdField_l_of_type_Int;
      this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(i2);
      this.jdField_c_of_type_AndroidWidgetImageView.setColorFilter(this.jdField_l_of_type_Int);
      this.jdField_d_of_type_AndroidWidgetImageView.setColorFilter(this.jdField_l_of_type_Int);
    }
    else
    {
      if (a()) {
        i1 = 2130844904;
      }
      i2 = this.jdField_k_of_type_Int;
      this.jdField_b_of_type_AndroidWidgetImageView.clearColorFilter();
      this.jdField_c_of_type_AndroidWidgetImageView.clearColorFilter();
      this.jdField_d_of_type_AndroidWidgetImageView.clearColorFilter();
    }
    this.jdField_f_of_type_AndroidViewView.setBackgroundResource(i1);
    this.jdField_g_of_type_AndroidViewView.setBackgroundResource(i1);
    this.jdField_h_of_type_AndroidViewView.setBackgroundResource(i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i2);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i2);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i2);
    QidPagView localQidPagView = this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView;
    if (localQidPagView != null)
    {
      if (paramBoolean)
      {
        localQidPagView.a(this.jdField_l_of_type_Int);
        return;
      }
      localQidPagView.a();
    }
  }
  
  protected void c()
  {
    Object localObject1 = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(null);
    getTitleBarView().setBackgroundColor(0);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    findViewById(2131374677).setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.m = findViewById(16908290);
    this.n = findViewById(2131374715);
    this.n.setVisibility(0);
    this.o = this.n.findViewById(2131374653);
    this.o.setOnClickListener(this);
    this.o.setContentDescription(getString(2131699180));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)this.n.findViewById(2131374645));
    this.jdField_i_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)this.n.findViewById(2131374646));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131374650));
    this.jdField_i_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_i_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131374652));
    this.jdField_k_of_type_AndroidWidgetImageView = ((ImageView)this.n.findViewById(2131374647));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131374649));
    Object localObject2 = HardCodeUtil.a(2131696467);
    Object localObject3 = this.jdField_c_of_type_JavaLangString;
    LongClickCopyAction.attachCopyAction(this.jdField_j_of_type_AndroidWidgetTextView, (String)localObject2, (String)localObject3);
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131374651));
    this.jdField_j_of_type_AndroidWidgetTextView.setContentDescription(getString(2131716561));
    localObject2 = findViewById(2131367870);
    ((View)localObject2).setVisibility(0);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131374691);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374690));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374692));
    this.jdField_i_of_type_AndroidViewView = findViewById(2131374717);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374716));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374718));
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
        if ((((TroopInfo)localObject3).cGroupOption == 3) && ((!TroopInfo.hasPayPrivilege(((TroopInfo)localObject3).troopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(((TroopInfo)localObject3).troopPrivilegeFlag, 512))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not allow join mask");
          }
          this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_l_of_type_AndroidWidgetTextView.setText(getString(2131696482));
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
          this.jdField_i_of_type_AndroidViewView.setVisibility(8);
        }
        else if (((((TroopInfo)localObject3).dwGroupFlagExt & 0x80) != 0L) && (!((TroopInfo)localObject3).isAdmin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not invite join mask");
          }
          this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_l_of_type_AndroidWidgetTextView.setText(getString(2131696483));
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
          this.jdField_i_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
    int i1 = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131298060) * 3) / 8;
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839406);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374306));
    this.jdField_b_of_type_JavaLangString = getString(2131716677);
    this.leftView.setContentDescription(getString(2131697708));
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean = QrCodeDisplayConfProcessor.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.size() <= 0) || (TextUtils.isEmpty(((QrCodeConfBean.QrCodeList)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString))) {
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_h_of_type_Int = QRUtils.b(this.app);
    i1 = this.jdField_h_of_type_Int;
    if ((i1 >= 0) && (i1 < this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.size()))
    {
      b((QrCodeConfBean.QrCodeList)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean.jdField_a_of_type_JavaUtilList.get(this.jdField_h_of_type_Int), false);
      return;
    }
    this.m.setBackgroundResource(2130847180);
    localObject1 = getResources().getDrawable(2130851066);
    ((Drawable)localObject1).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.leftView.setBackgroundDrawable((Drawable)localObject1);
    this.centerView.setTextColor(-16777216);
  }
  
  public void c(int paramInt)
  {
    if ((QLog.isColorLevel()) && (paramInt != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlayStop, ");
      localStringBuilder.append(paramInt);
      QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2)) {
        return;
      }
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1001);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1003, 500L);
      return;
    }
    if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(1001)) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, 1000L);
    }
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(2131716663, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(2131716665, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(2131716662, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_c_of_type_Int == 2)
    {
      if (paramInt1 != 1) {
        if (paramInt1 != 21) {
          localObject1 = "";
        }
      }
      for (;;)
      {
        break;
        localObject1 = "qr_qq";
        continue;
        localObject1 = "qr_qzone";
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (paramInt2 == -1) {
          localObject2 = "0";
        } else {
          localObject2 = "1";
        }
        TroopReportor.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), localObject2 });
      }
    }
    boolean bool;
    if (paramInt2 == -1) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
    if (paramInt2 == -1) {
      if (paramInt1 == 1)
      {
        a(0, getString(2131716664));
        if (QLog.isColorLevel()) {
          QLog.i("QRDisplayActivity", 2, "shareQRCode success");
        }
        if ((this.jdField_g_of_type_Int & 0x1) != 0) {
          ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416F", "0X800416F", 0, 0, "", "", "", "");
        }
      }
      else if (paramInt1 == 2)
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
    }
    if ((this.jdField_c_of_type_Int == 1) && (paramInt1 == 1)) {
      B();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if ((1 == super.getIntent().getIntExtra("type", 1)) || (2 == super.getIntent().getIntExtra("type", 2))) {
      this.mActNeedImmersive = false;
    }
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    super.setContentView(2131560435);
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131374678));
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131374708);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131374697);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131374719);
    int i1 = this.jdField_c_of_type_Int;
    if (i1 == 1)
    {
      q();
      z();
    }
    else if (i1 == 2)
    {
      c();
      this.jdField_c_of_type_AndroidViewView.post(this.jdField_c_of_type_JavaLangRunnable);
    }
    else if (i1 == 5)
    {
      findViewById(2131373748).setVisibility(0);
      findViewById(2131367867).setVisibility(0);
      findViewById(2131374685).setOnClickListener(this);
      findViewById(2131374686).setOnClickListener(this);
      this.jdField_b_of_type_JavaLangString = getString(2131716673);
    }
    else if (i1 == 11)
    {
      findViewById(2131373748).setVisibility(0);
      findViewById(2131367867).setVisibility(0);
      findViewById(2131374685).setOnClickListener(this);
      findViewById(2131374686).setOnClickListener(this);
      this.jdField_b_of_type_JavaLangString = getString(2131716702);
    }
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131374694);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131373749);
    this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131696470));
    if (QLog.isDevelopLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("display qrcode, type: ");
      paramBundle.append(this.jdField_c_of_type_Int);
      QLog.d("QRDisplayActivity", 4, paramBundle.toString());
    }
    i1 = this.jdField_c_of_type_Int;
    Object localObject1;
    if (i1 == 5)
    {
      getIntent().getStringExtra("discussion_shorturl");
      addObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
      if (this.app != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
        this.app.registObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver);
      }
      this.leftView.setContentDescription(getString(2131696095));
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131696096));
      setResult(-1, getIntent());
      paramBundle = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject2 = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      localObject1 = ((DiscussionManager)localObject2).a(this.jdField_c_of_type_JavaLangString);
      if (localObject1 == null)
      {
        i();
      }
      else
      {
        localObject2 = ((DiscussionManager)localObject2).a(this.jdField_c_of_type_JavaLangString);
        if (localObject2 != null) {
          this.jdField_f_of_type_Int = ((List)localObject2).size();
        } else {
          this.jdField_f_of_type_Int = 0;
        }
        if (!((DiscussionInfo)localObject1).hasRenamed())
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("QRDisplayActivity", 4, "title not defined, join by nicks");
          }
          if (localObject2 != null)
          {
            localObject1 = ((List)localObject2).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
              if (this.app.getAccount().equals(((DiscussionMemberInfo)localObject2).memberUin))
              {
                this.jdField_b_of_type_JavaUtilList.add(ContactUtils.e(this.app, ((DiscussionMemberInfo)localObject2).memberUin));
              }
              else
              {
                Friends localFriends = paramBundle.e(((DiscussionMemberInfo)localObject2).memberUin);
                if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name))) {
                  this.jdField_b_of_type_JavaUtilList.add(localFriends.name);
                } else if (a(((DiscussionMemberInfo)localObject2).memberUin) != null) {
                  this.jdField_b_of_type_JavaUtilList.add(a(((DiscussionMemberInfo)localObject2).memberUin));
                } else {
                  this.jdField_a_of_type_JavaUtilList.add(((DiscussionMemberInfo)localObject2).memberUin);
                }
              }
            }
            if ((this.jdField_b_of_type_JavaUtilList.size() < 5) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
            {
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
              i1 = 0;
            }
            else
            {
              i1 = 1;
            }
            i2 = i1;
            if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
              break label1150;
            }
            Collections.sort(this.jdField_b_of_type_JavaUtilList, new QRDisplayActivity.DiscussionMemberComparator(this));
            this.jdField_a_of_type_JavaLangString = a(this.jdField_b_of_type_JavaUtilList);
            i2 = i1;
            break label1150;
          }
        }
      }
    }
    else if (i1 == 2)
    {
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131716675, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
      addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
    }
    else if (i1 == 11)
    {
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131716675, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
    }
    int i2 = 1;
    label1150:
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager = new CodeMaskManager(this, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_d_of_type_JavaLangRunnable, 60000L);
    if (i2 != 0)
    {
      paramBundle = this.jdField_a_of_type_AndroidWidgetImageView;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      paramBundle.setContentDescription(((StringBuilder)localObject1).toString());
      this.jdField_c_of_type_AndroidViewView.post(this.jdField_a_of_type_JavaLangRunnable);
    }
    if ((this.jdField_g_of_type_Int & 0x1) != 0) {
      ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416D", "0X800416D", 0, 0, "", "", "", "");
    }
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 1, 0).sendToTarget();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager.a();
    int i1 = this.jdField_c_of_type_Int;
    if (i1 == 5)
    {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver);
    }
    else if (i1 == 2)
    {
      removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
    EarlyHandler localEarlyHandler = this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerEarlyHandler;
    if (localEarlyHandler != null) {
      ((IChirpSoDownload)localEarlyHandler).b(this);
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Handler localHandler = this.jdField_b_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    }
    c(false);
    y();
    ApngImage.pauseByTag(35);
  }
  
  protected void doOnResume()
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
    int i1 = this.jdField_c_of_type_Int;
    String str;
    if (i1 == 1) {
      str = "saveConsumerQRcard";
    } else if (i1 == 2) {
      str = "saveGroupQRcard";
    } else {
      str = null;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).reportButtonClick(this.app, "", str, 1);
  }
  
  public void finish()
  {
    ForwardRecentActivity.notifyResultReceiver(getIntent(), this);
    super.finish();
  }
  
  protected void g()
  {
    ThreadManager.executeOnFileThread(new QRDisplayActivity.15(this));
    int i1 = this.jdField_c_of_type_Int;
    String str;
    if (i1 == 1) {
      str = "shareConsumerQRcard";
    } else if (i1 == 2) {
      str = "shareGroupQRcard";
    } else {
      str = null;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).reportButtonClick(this.app, "", str, 1);
  }
  
  protected void h()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (super.isFinishing()) {
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
      if ((this.jdField_a_of_type_Long & 0x800) != 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int i1 = this.jdField_b_of_type_Int;
      int i2 = this.jdField_c_of_type_Int;
      boolean bool2;
      if ((i2 != 1) && (i2 != 2)) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      ((CodeMaskManager)localObject).a(this, bool3, bool1, i1, bool2);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        return;
      }
      if (this.jdField_c_of_type_Int == 1) {
        localObject = "changeConsumerQRcard";
      } else {
        localObject = "changeGroupQRcard";
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).reportButtonClick(this.app, "", (String)localObject, 1);
    }
  }
  
  @TargetApi(14)
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    boolean bool2 = true;
    label289:
    Object localObject1;
    switch (i1)
    {
    default: 
      return false;
    case 1004: 
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.app.setTalkbackSwitch();
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("talkback value ");
          paramMessage.append(AppSetting.jdField_d_of_type_Boolean);
          QLog.d("QRDisplayActivity", 2, paramMessage.toString());
        }
        if ((AppSetting.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Int == 1))
        {
          bool1 = ((IChirpApi)QRoute.api(IChirpApi.class)).loadLibrary();
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("isSoLoaded ");
            paramMessage.append(bool1);
            QLog.d("QRDisplayActivity", 2, paramMessage.toString());
          }
          if (!bool1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerEarlyHandler == null) {
              this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerEarlyHandler = ((IEarlyDownloadService)this.app.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler(((IQRScanEarlyHandlerApi)QRoute.api(IQRScanEarlyHandlerApi.class)).getResName(4));
            }
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerEarlyHandler;
            if (paramMessage != null)
            {
              ((IChirpSoDownload)paramMessage).a(this);
              this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerEarlyHandler.a(true);
            }
          }
          else
          {
            bool1 = bool2;
            if (this.jdField_k_of_type_Boolean) {
              break label289;
            }
            BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.25(this));
            this.jdField_k_of_type_Boolean = true;
            bool1 = bool2;
            break label289;
          }
        }
      }
      boolean bool1 = false;
      BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.26(this, bool1));
      return false;
    case 1003: 
      QQAppInterface.speak(jdField_j_of_type_JavaLangString);
      return false;
    case 1002: 
      paramMessage = this.jdField_a_of_type_ComTencentChirpPcmPlayer;
      if (paramMessage != null)
      {
        paramMessage.a();
        return false;
      }
      break;
    case 1001: 
      localObject1 = this.jdField_a_of_type_ComTencentChirpPcmPlayer;
      if (localObject1 != null)
      {
        ((PcmPlayer)localObject1).b();
        this.jdField_a_of_type_ComTencentChirpPcmPlayer = null;
        if (paramMessage.arg1 == 5) {
          ReportController.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        if (paramMessage.arg1 == 3) {
          ReportController.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        QQAudioUtils.a(this, false);
        return false;
      }
      break;
    case 1000: 
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("playQRCodeFailed = ");
        ((StringBuilder)localObject1).append(this.jdField_j_of_type_Boolean);
        QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if (!this.jdField_j_of_type_Boolean)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getFilesDir());
        ((StringBuilder)localObject1).append(this.app.getCurrentAccountUin());
        ((StringBuilder)localObject1).append("_vqr.dat");
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new File((String)localObject1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("voiceFile.exists = ");
          localStringBuilder.append(((File)localObject2).exists());
          QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
        }
        if (!((File)localObject2).exists()) {
          this.jdField_j_of_type_Boolean = (a((String)localObject1) ^ true);
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("playQRCodeFailed = ");
          ((StringBuilder)localObject2).append(this.jdField_j_of_type_Boolean);
          QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject2).toString());
        }
        if (!this.jdField_j_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null)
          {
            this.jdField_a_of_type_ComTencentChirpPcmPlayer = new PcmPlayer(this, this, 44100, (String)localObject1);
            this.jdField_a_of_type_ComTencentChirpPcmPlayer.a();
            QQAudioUtils.a(this, true);
          }
          if (paramMessage.arg1 == 5)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 0, 0, "", "", "", "");
            return false;
          }
        }
        else
        {
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1003);
        }
      }
      break;
    }
    return false;
  }
  
  protected void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if (super.isResume())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setMessage(2131718419);
      localQQCustomDialog.setPositiveButton(2131694583, new QRDisplayActivity.17(this));
      localQQCustomDialog.show();
      return;
    }
    finish();
  }
  
  protected void j()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      QRDisplayActivity.19 local19 = new QRDisplayActivity.19(this);
      localObject = new QRDisplayActivity.20(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(getString(2131719029));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener((DialogInterface.OnDismissListener)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new QRDisplayActivity.21(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(local19);
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()))
      {
        this.jdField_h_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("actionSheet.show exception=");
        ((StringBuilder)localObject).append(localException);
        QLog.d("ShareActionSheet", 2, ((StringBuilder)localObject).toString());
      }
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
        QQToast.a(this, HardCodeUtil.a(2131711143), 0).a();
      }
      setResult(-1);
      finish();
      return;
    }
    if (isInMultiWindow())
    {
      QQToast.a(this, HardCodeUtil.a(2131711145), 0).a();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("from", "QRDisplayActivity");
    RouteUtils.a(this, localIntent, "/qrscan/scanner", 3);
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
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("101600.101601");
      if (localAppInfo != null) {
        localIRedTouchManager.reportLevelOneRedInfo("101600.101601", 30);
      }
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
    }
  }
  
  public void o()
  {
    this.jdField_j_of_type_AndroidViewView.setBackgroundResource(2130847180);
    Drawable localDrawable = getResources().getDrawable(2130843861);
    localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.jdField_f_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    localDrawable = getResources().getDrawable(2130851066);
    localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.leftView.setBackgroundDrawable(localDrawable);
    this.centerView.setTextColor(-16777216);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    int i1;
    boolean bool;
    if (Math.abs(l1 - this.jdField_c_of_type_Long) > 1000L)
    {
      this.jdField_c_of_type_Long = l1;
      i1 = paramView.getId();
      bool = true;
      if (i1 == 2131374697)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          i1 = this.jdField_c_of_type_Int;
          if (i1 == 2)
          {
            h();
            if ((this.jdField_g_of_type_Int & 0x1) != 0) {
              ReportController.b(this.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
            }
          }
          else if ((i1 != 5) && (i1 != 11))
          {
            d();
          }
          else
          {
            h();
            ReportController.b(this.app, "CliOper", "", "", "0X8006671", "0X8006671", 0, 0, "", "", "", "");
          }
        }
      }
      else if (paramView.getId() == 2131374680) {
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet = new LinkShareActionSheetBuilder(this).a(this);
        }
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      label216:
      ReportController.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
      break label1046;
      if (paramView.getId() == 2131374685)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          e();
          if ((this.jdField_g_of_type_Int & 0x1) != 0) {
            ReportController.b(this.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int == 5) {
            ReportController.b(this.app, "CliOper", "", "", "0X8006672", "0X8006672", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int == 2) {
            new ReportTask(this.app).a("P_CliOper").b("Grp_set").c("Grp_data").d("qr_save").a(new String[] { this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int) }).a();
          }
        }
      }
      else if (paramView.getId() == 2131374686)
      {
        j();
        if (this.jdField_c_of_type_Int == 5) {
          ReportController.b(this.app, "CliOper", "", "", "0X8006673", "0X8006673", 0, 0, "", "", "", "");
        }
      }
      else if ((paramView.getId() != 2131374704) && (paramView.getId() != 2131374706))
      {
        if (paramView.getId() == 2131374688)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X800AEAD", "0X800AEAD", 0, 0, "", "", "", "");
          if (QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString) == 1)
          {
            this.jdField_b_of_type_AndroidGraphicsBitmap = this.jdField_c_of_type_AndroidGraphicsBitmap;
          }
          else
          {
            this.jdField_b_of_type_AndroidGraphicsBitmap = a();
            QidCardManager.QidCardReport.b("0X800B9A7");
          }
          u();
        }
        else if (paramView.getId() == 2131374691)
        {
          v();
        }
        else if (paramView.getId() == 2131374717)
        {
          e();
        }
        else if (paramView.getId() == 2131374705)
        {
          k();
        }
        else if (paramView.getId() == 2131374712)
        {
          i1 = this.jdField_j_of_type_Int;
          if (i1 == 0) {
            A();
          } else if (i1 == 1) {
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
          p();
        }
        else if (paramView.getId() == 2131369216)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X800AEB5", "0X800AEB5", 0, 0, "", "", "", "");
          if (QRUtils.a(this.app, this.jdField_c_of_type_JavaLangString) != 2) {
            bool = false;
          }
          d(bool);
        }
        else
        {
          StringBuilder localStringBuilder;
          if (paramView.getId() == 2131374654)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onClick qr_code_white_bg isLoading =");
              localStringBuilder.append(this.jdField_a_of_type_Boolean);
              QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
            }
            if (!this.jdField_a_of_type_Boolean)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X800AEB4", "0X800AEB4", 0, 0, "", "", "", "");
              a(QRUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean, this.jdField_h_of_type_Int), true);
            }
          }
          else if (paramView.getId() == 2131374653)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onClick qr_code_troop_white_bg isLoading =");
              localStringBuilder.append(this.jdField_a_of_type_Boolean);
              QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
            }
            if (!this.jdField_a_of_type_Boolean) {
              b(QRUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean, this.jdField_h_of_type_Int), true);
            }
          }
        }
      }
      else
      {
        k();
      }
      label1046:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label216;
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt != 2) && (paramInt != 3))
        {
          if (paramInt == 4) {
            DiscussionInfoCardActivity.a(this.app, this.jdField_b_of_type_Long, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
          }
        }
        else
        {
          int i1;
          if (!WXShareHelper.a().a()) {
            i1 = 2131720478;
          } else if (!WXShareHelper.a().b()) {
            i1 = 2131720479;
          } else {
            i1 = -1;
          }
          if (i1 != -1)
          {
            QRUtils.a(1, i1);
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
            {
              this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new QRDisplayActivity.18(this);
              WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
            }
            Object localObject = this.app;
            if (paramInt == 2) {
              str1 = "1";
            } else {
              str1 = "0";
            }
            ReportController.b((AppRuntime)localObject, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, str1, "", "", "");
            this.jdField_g_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
            String str1 = String.format(getString(2131691769), new Object[] { this.jdField_a_of_type_JavaLangString });
            if (this.jdField_c_of_type_Int == 11) {
              str1 = getString(2131693111);
            }
            localObject = WXShareHelper.a();
            String str2 = this.jdField_g_of_type_JavaLangString;
            Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
            String str3 = this.jdField_d_of_type_JavaLangString;
            if (paramInt == 2) {
              i1 = 0;
            } else {
              i1 = 1;
            }
            ((WXShareHelper)localObject).a(str2, str1, localBitmap, "", str3, i1);
          }
        }
      }
      else {
        DiscussionInfoCardActivity.a(this.app, this, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694668);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      DiscussionInfoCardActivity.a(this.app, this, 2, this.jdField_e_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void p()
  {
    ((IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("101600.101601");
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity
 * JD-Core Version:    0.7.0.1
 */