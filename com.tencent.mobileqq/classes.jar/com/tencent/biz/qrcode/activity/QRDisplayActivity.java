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
  public static final String aB = HardCodeUtil.a(2131908813);
  List<String> A = new ArrayList();
  List<String> B = new ArrayList();
  DiscussionHandler C;
  ActionSheet D;
  WXShareHelper.WXShareListener E;
  String F;
  long G;
  QQProgressDialog H;
  View I;
  View J;
  int K;
  int L;
  protected View M;
  protected ImageView N;
  protected TextView O;
  protected View P;
  protected ImageView Q;
  protected TextView R;
  protected long S;
  protected View T;
  protected ImageView U;
  protected TextView V;
  protected LinearLayout W;
  protected View X;
  protected ImageView Y;
  protected TextView Z;
  protected View a;
  protected boolean aA = false;
  public boolean aC = true;
  QRDisplayActivity.GetNicknameObserver aD = new QRDisplayActivity.1(this);
  TroopModifyObserver aE = new QRDisplayActivity.2(this);
  DiscussionObserver aF = new QRDisplayActivity.5(this);
  protected Runnable aG = new QRDisplayActivity.6(this);
  protected Runnable aH = new QRDisplayActivity.7(this);
  protected Runnable aI = new QRDisplayActivity.8(this);
  QidianBusinessObserver aJ = new QRDisplayActivity.9(this);
  protected Runnable aK = new QRDisplayActivity.10(this);
  protected ActionSheet aL = null;
  protected boolean aM = false;
  protected int aN = -1;
  int aO = -1;
  protected LinearLayout aP;
  protected QidPagView aQ;
  protected RedTouch aR;
  int aS;
  int aT = this.aS;
  Bitmap aU;
  Bitmap aV;
  private URLDrawable aW;
  private QRDisplayActivity.MyViewAlphaOnTouchListener aX;
  private Handler aY;
  private PcmPlayer aZ;
  protected View aa;
  protected ImageView ab;
  protected View ac;
  protected View ad;
  protected ImageView ae;
  protected ImageView af;
  protected TextView ag;
  protected TextView ah;
  protected TextView ai;
  protected QrCodeConfBean aj;
  protected String ak;
  protected boolean al = true;
  protected int am = -1;
  protected String an;
  protected TextView ao;
  protected Drawable ap;
  protected View aq;
  protected View ar;
  protected View as;
  protected ImageView at;
  protected ImageView au;
  protected TextView av;
  protected TextView aw;
  protected TextView ax;
  protected TextView ay;
  protected ImageView az;
  protected View b;
  private boolean ba = false;
  private volatile boolean bb = false;
  private boolean bc = false;
  private EarlyHandler bd;
  private ShareActionSheetBuilder be = null;
  private CountDownTimer bf = new QRDisplayActivity.27(this, 1000L, 200L);
  protected View c;
  protected ImageView d;
  protected BitMatrix e;
  protected CodeMaskManager f;
  protected boolean g = true;
  protected boolean h = false;
  protected boolean i = false;
  protected Bitmap j;
  protected volatile Bitmap k;
  protected String l;
  protected String m;
  protected String n;
  protected String o;
  protected String p;
  protected int q;
  protected long r = 0L;
  protected int s = 0;
  protected int t;
  protected Bundle u;
  protected int v;
  protected int w;
  protected boolean x = true;
  protected String y;
  protected Handler z;
  
  private void A()
  {
    Object localObject1 = String.format(getString(2131886235), new Object[] { j() });
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
    QQToast.makeText(this, 2, getString(2131886635), 0).show(getTitleBarHeight());
    this.aN = -1;
  }
  
  private void B()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showURLProgressView() mTvProgress =");
      ((StringBuilder)localObject).append(this.ao);
      QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.ao;
    if ((localObject != null) && (this.ap != null))
    {
      ((TextView)localObject).setVisibility(0);
      this.ao.setBackgroundDrawable(this.ap);
      ((Animatable)this.ap).start();
    }
  }
  
  private void C()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideURLProgressView() mTvProgress =");
      ((StringBuilder)localObject).append(this.ao);
      QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.ao != null)
    {
      localObject = this.ap;
      if (localObject != null)
      {
        ((Animatable)localObject).stop();
        this.ao.setBackgroundDrawable(null);
        this.ao.setVisibility(8);
      }
    }
  }
  
  private void D()
  {
    this.aP = ((LinearLayout)findViewById(2131442885));
    this.aQ = ((QidPagView)findViewById(2131442039));
    this.aR = new RedTouch(this, this.T).c(53).b(20).c(20.0F).b(20.0F).a();
    this.aS = getResources().getColor(2131168235);
    int i1 = QRUtils.a(this.app, this.n);
    if (i1 == 2) {
      a(i1, false);
    }
    if (!QVipQidProcessor.e().b)
    {
      this.T.setVisibility(8);
      findViewById(2131442896).setVisibility(8);
      this.aR.setVisibility(8);
    }
  }
  
  private void E()
  {
    DialogUtil.a(this, 232, null, getString(2131897191), getString(2131887648), getString(2131897493), new QRDisplayActivity.34(this), new QRDisplayActivity.35(this)).show();
    QidCardManager.QidCardReport.b("0X800B970");
  }
  
  private void F()
  {
    if (!QVipQidProcessor.e().b) {
      return;
    }
    PbProtocol.a("vapfService.qidService.GetProfileSSO", new QidProfile.GetProfileSSOReq(), QidProfile.GetProfileSSORsp.class, new QRDisplayActivity.36(this));
  }
  
  private void a(Bundle paramBundle, ArrayList<Rect> paramArrayList, Bitmap paramBitmap)
  {
    if (QRUtils.a(this.app, this.n) == 2)
    {
      if (p()) {
        localObject = ((QrCodeConfBean.QrCodeList)this.aj.a.get(this.am)).a;
      } else {
        localObject = null;
      }
      this.an = ((String)localObject);
    }
    if (TextUtils.isEmpty(this.an)) {}
    for (Object localObject = BitmapFactory.decodeResource(getResources(), 2130848760);; localObject = BitmapFactory.decodeResource(getResources(), 2130848760)) {
      for (;;)
      {
        try
        {
          localObject = ImageUtil.b(URLDrawable.getDrawable(this.an).getCurrDrawable().mutate());
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
    paramBundle = QRUtils.a(this, (Bitmap)localObject, this.j, paramBitmap, paramArrayList, paramBundle.getInt("nameClr"), this.l, String.format(getString(2131897184), new Object[] { this.n }), paramBundle.getInt("tipsClr"), this.m, this.al, this.ak, true);
    if (this.k == null)
    {
      this.af.setImageBitmap(paramBundle[0]);
      this.ag.setText(this.l);
      i1 = PrettyAccountUtil.b();
      i2 = PrettyAccountUtil.c();
      paramArrayList = PrettyAccountUtil.a(i1, i2, String.format(getString(2131897184), new Object[] { this.n }), this.n);
      this.ah.setText(paramArrayList);
      PrettyAccountUtil.a(this.ah, i1, i2);
      PrettyAccountUtil.a("0X800B239", i1, i2);
      this.ai.setText(getString(2131897196));
      this.ae.setImageBitmap(this.j);
      C();
      F();
    }
    this.k = paramBundle[1];
    this.aU = paramBundle[1];
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onMaskReady: qrcodeCardCache = ");
      paramBundle.append(this.k);
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
    if ("default_bg".equals(paramQrCodeList.a))
    {
      b(paramQrCodeList, paramInt, paramBoolean);
      this.aq.setBackgroundResource(2130848760);
      return;
    }
    int i1;
    if (this.aq.getBackground() == null) {
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
          localObject = getResources().getDrawable(2130848760);
        } else {
          localObject = this.aq.getBackground();
        }
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        this.aW = URLDrawable.getDrawable(paramQrCodeList.a, localURLDrawableOptions);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setTroopURLDrawable: urlDrawable = ");
          ((StringBuilder)localObject).append(this.aW);
          ((StringBuilder)localObject).append(" status = ");
          ((StringBuilder)localObject).append(this.aW);
          if (((StringBuilder)localObject).toString() != null)
          {
            localObject = Integer.valueOf(this.aW.getStatus());
            QLog.d("QRDisplayActivity", 2, new Object[] { localObject });
          }
        }
        else
        {
          if (this.aW.getStatus() == 1)
          {
            b(paramQrCodeList, paramInt, paramBoolean);
            this.aq.setBackgroundDrawable(this.aW.getCurrDrawable());
            return;
          }
          if (i1 != 0) {
            this.aq.setBackgroundResource(2130848760);
          }
          a(paramQrCodeList, paramInt, paramBoolean, this.aW);
          B();
          this.aW.startDownload();
          this.aW.setAutoDownload(true);
          return;
        }
      }
      catch (IllegalArgumentException paramQrCodeList)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setTroopURLDrawable bkgURL is illegal please check manage info e =");
        ((StringBuilder)localObject).append(paramQrCodeList);
        QLog.d("QRDisplayActivity", 1, ((StringBuilder)localObject).toString());
        QQToast.makeText(this, getString(2131894236), 0).show();
        C();
        if (i1 != 0) {
          this.aq.setBackgroundResource(2130848760);
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
      localStringBuilder.append(paramQrCodeList.a);
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
      localStringBuilder.append(paramQrCodeList.a);
      QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
    }
    paramURLDrawable.setURLDrawableListener(new QRDisplayActivity.32(this, paramQrCodeList, paramInt, paramBoolean1, paramBoolean2));
  }
  
  private void a(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ("default_bg".equals(paramQrCodeList.a))
    {
      b(paramQrCodeList, paramInt, paramBoolean1, paramBoolean2);
      this.aa.setBackgroundResource(2130848760);
      return;
    }
    int i1;
    if (this.aa.getBackground() == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if (i1 != 0) {
        localObject = getResources().getDrawable(2130848760);
      } else {
        localObject = this.aa.getBackground();
      }
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      this.aW = URLDrawable.getDrawable(paramQrCodeList.a, localURLDrawableOptions);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setURLDrawable: urlDrawable = ");
        ((StringBuilder)localObject).append(this.aW);
        ((StringBuilder)localObject).append(" status = ");
        ((StringBuilder)localObject).append(this.aW.getStatus());
        QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (this.aW.getStatus() == 1)
      {
        b(paramQrCodeList, paramInt, paramBoolean1, paramBoolean2);
        this.aa.setBackgroundDrawable(this.aW.getCurrDrawable());
        return;
      }
      if (i1 != 0) {
        this.aa.setBackgroundResource(2130848760);
      }
      a(paramQrCodeList, paramInt, paramBoolean1, this.aW, paramBoolean2);
      B();
      this.aW.startDownload();
      this.aW.setAutoDownload(true);
      return;
    }
    catch (IllegalArgumentException paramQrCodeList)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bkgURL is illegal please check manage info e =");
      ((StringBuilder)localObject).append(paramQrCodeList);
      QLog.d("QRDisplayActivity", 1, ((StringBuilder)localObject).toString());
      QQToast.makeText(this, getString(2131894236), 0).show();
      C();
      if (i1 != 0) {
        this.aa.setBackgroundResource(2130848760);
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
      this.am = this.aj.a.indexOf(paramQrCodeList);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchMyQrTheme().qrCodeList:");
      localStringBuilder.append(paramQrCodeList.toString());
      QLog.i("QRDisplayActivity", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramQrCodeList.a))
    {
      this.ak = paramQrCodeList.d;
      this.al = paramQrCodeList.c();
      this.an = paramQrCodeList.a;
      a(paramQrCodeList, this.am, paramBoolean1, paramBoolean2);
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
    Object localObject = (TextView)findViewById(2131434449);
    ((TextView)localObject).setVisibility(0);
    TroopReportor.a("Grp_QR", "search_upgrade", "search_upgrade_exp", 0, 0, new String[] { paramTroopInfo.troopuin });
    int i1;
    if (bool) {
      i1 = 2131914183;
    } else {
      i1 = 2131914182;
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
        this.aO = 0;
        QRUtils.a(this.app, this.n, 1);
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
        if (this.aO == 0) {
          QRUtils.a(this.app, this.n, 2);
        }
        this.aO = 1;
        try
        {
          this.aT = Color.parseColor(localGetProfileSSORsp.btn_color.get());
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
          QidCardManager.a(this.n, paramObject);
        }
        if (QRUtils.a(this.app, this.n) == 2)
        {
          a(2, false);
          QidCardManager.QidCardReport.b("0X800B9A6");
          QidCardManager.QidCardReport.b("0X800B9A8");
          QidCardManager.QidCardReport.b("0X800B9AA");
          QidCardManager.QidCardReport.b("0X800B972");
        }
        else
        {
          this.aQ.a = true;
        }
        paramObject = new QidPagView.QidData();
        paramObject.h = this.l;
        paramObject.i = this.n;
        paramObject.e = this.j;
        paramObject.j = this.aT;
        paramObject.f = this.af.getDrawable();
        if ((localGetProfileSSORsp.is_lm_show.has()) && (localGetProfileSSORsp.is_lm_show.get() == 1)) {
          paramObject.d = QidCardManager.c(this.n);
        }
        if (localGetProfileSSORsp.qid.has()) {
          paramObject.g = localGetProfileSSORsp.qid.get();
        }
        if (localGetProfileSSORsp.pag_url.has())
        {
          paramObject.a = localGetProfileSSORsp.pag_url.get();
          paramObject.b = QidCardManager.a(paramObject.a);
        }
        if (localGetProfileSSORsp.bg_url.has()) {
          paramObject.c = localGetProfileSSORsp.bg_url.get();
        }
        if (QidCardManager.b(paramObject.a) != null)
        {
          this.aQ.a(paramObject);
          return;
        }
        QidCardManager.a(this, this.aQ, paramObject);
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
  
  public static List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894171);
    localActionSheetItem.icon = 2130839221;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 0;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894185);
    localActionSheetItem.icon = 2130839222;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894192);
    localActionSheetItem.icon = 2130839225;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894174);
    localActionSheetItem.icon = 2130839219;
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
    QRUtils.a(1, 2131894252);
  }
  
  private void b(Bundle paramBundle, ArrayList<Rect> paramArrayList, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(this.an)) {}
    for (Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130848760);; localBitmap = BitmapFactory.decodeResource(getResources(), 2130848760)) {
      for (;;)
      {
        try
        {
          localBitmap = ImageUtil.b(URLDrawable.getDrawable(this.an).getCurrDrawable().mutate());
        }
        catch (Exception localException)
        {
          label46:
          break label46;
        }
      }
    }
    paramBundle = QRUtils.a(this, localBitmap, this.j, paramBitmap, paramArrayList, paramBundle.getInt("nameClr"), this.l, String.format(getString(2131897566), new Object[] { this.n }), paramBundle.getInt("tipsClr"), this.m, this.al, this.ak, this.aA ^ true);
    if (this.k == null)
    {
      this.au.setImageBitmap(paramBundle[0]);
      this.av.setText(this.l);
      this.aw.setText(String.format(getString(2131897566), new Object[] { this.n }));
      this.ax.setText(getString(2131897196));
      this.at.setImageBitmap(this.j);
    }
    this.k = paramBundle[1];
    if (localBitmap != null) {
      localBitmap.recycle();
    }
  }
  
  private void b(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      h();
    }
    C();
    QRUtils.b(this.app, paramInt);
    ImmersiveUtils.setStatusTextColor(paramQrCodeList.a() ^ true, getWindow());
    Object localObject = getResources().getDrawable(2130853297);
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
    this.M.setBackgroundResource(2130846338);
    this.X.setBackgroundResource(2130846338);
  }
  
  private void b(QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!paramBoolean2)) {
      h();
    }
    C();
    QRUtils.a(this.app, paramInt);
    ImmersiveUtils.setStatusTextColor(paramQrCodeList.a() ^ true, getWindow());
    Object localObject = getResources().getDrawable(2130844816);
    paramBoolean1 = paramQrCodeList.b();
    int i1 = -1;
    if (paramBoolean1) {
      paramInt = -1;
    } else {
      paramInt = -16777216;
    }
    ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.ab.setBackgroundDrawable(null);
    this.ab.setImageDrawable((Drawable)localObject);
    localObject = getResources().getDrawable(2130853297);
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
      this.M.setBackgroundResource(2130846338);
      this.P.setBackgroundResource(2130846338);
      this.T.setBackgroundResource(2130846338);
    }
  }
  
  private void b(QrCodeConfBean.QrCodeList paramQrCodeList, boolean paramBoolean)
  {
    if (paramQrCodeList == null)
    {
      QLog.i("QRDisplayActivity", 2, "switchMyQrTheme() qrCodeList is null just return");
      return;
    }
    this.am = this.aj.a.indexOf(paramQrCodeList);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchMyQrTheme().qrCodeList:");
      localStringBuilder.append(paramQrCodeList.toString());
      QLog.i("QRDisplayActivity", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramQrCodeList.a))
    {
      this.ak = paramQrCodeList.d;
      this.al = paramQrCodeList.c();
      this.an = paramQrCodeList.a;
      a(paramQrCodeList, this.am, paramBoolean);
    }
  }
  
  /* Error */
  private boolean b(String paramString)
  {
    // Byte code:
    //   0: new 1086	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 1088	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 1091	java/io/File:exists	()Z
    //   13: ifne +430 -> 443
    //   16: ldc_w 1093
    //   19: invokestatic 1099	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   22: checkcast 1093	com/tencent/mobileqq/qrscan/api/IChirpApi
    //   25: invokeinterface 1102 1 0
    //   30: ifne +319 -> 349
    //   33: aload_0
    //   34: getfield 447	com/tencent/biz/qrcode/activity/QRDisplayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 1105	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   40: astore 4
    //   42: new 286	java/lang/String
    //   45: dup
    //   46: ldc_w 1107
    //   49: invokespecial 1108	java/lang/String:<init>	(Ljava/lang/String;)V
    //   52: astore 5
    //   54: new 298	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   61: astore 6
    //   63: aload 6
    //   65: ldc_w 1110
    //   68: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 6
    //   74: aload 5
    //   76: iconst_0
    //   77: bipush 14
    //   79: aload 4
    //   81: invokevirtual 830	java/lang/String:length	()I
    //   84: isub
    //   85: invokevirtual 1114	java/lang/String:substring	(II)Ljava/lang/String;
    //   88: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 6
    //   94: aload 4
    //   96: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 6
    //   102: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore 4
    //   107: invokestatic 296	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: istore_3
    //   111: iload_3
    //   112: ifeq +41 -> 153
    //   115: new 298	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   122: astore 5
    //   124: aload 5
    //   126: ldc_w 1116
    //   129: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: aload 4
    //   137: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc_w 307
    //   144: iconst_2
    //   145: aload 5
    //   147: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 373	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: ldc_w 1093
    //   156: invokestatic 1099	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   159: checkcast 1093	com/tencent/mobileqq/qrscan/api/IChirpApi
    //   162: aload 4
    //   164: invokeinterface 1120 2 0
    //   169: astore 4
    //   171: aload 4
    //   173: getfield 1126	android/util/Pair:first	Ljava/lang/Object;
    //   176: checkcast 705	java/lang/Integer
    //   179: invokevirtual 1129	java/lang/Integer:intValue	()I
    //   182: istore_2
    //   183: aload 4
    //   185: getfield 1132	android/util/Pair:second	Ljava/lang/Object;
    //   188: checkcast 1134	[S
    //   191: astore 5
    //   193: iload_2
    //   194: ifne +190 -> 384
    //   197: aload 5
    //   199: ifnull +185 -> 384
    //   202: aconst_null
    //   203: astore 6
    //   205: new 1136	java/io/FileOutputStream
    //   208: dup
    //   209: aload_1
    //   210: invokespecial 1139	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
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
    //   233: invokestatic 1141	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	([S[B)V
    //   236: aload_1
    //   237: astore 4
    //   239: aload_1
    //   240: aload 7
    //   242: invokevirtual 1145	java/io/FileOutputStream:write	([B)V
    //   245: aload_1
    //   246: invokevirtual 1148	java/io/FileOutputStream:close	()V
    //   249: goto +6 -> 255
    //   252: astore_1
    //   253: aload_1
    //   254: athrow
    //   255: ldc_w 1093
    //   258: invokestatic 1099	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   261: checkcast 1093	com/tencent/mobileqq/qrscan/api/IChirpApi
    //   264: invokeinterface 1151 1 0
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
    //   291: invokestatic 296	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +18 -> 312
    //   297: aload_1
    //   298: astore 4
    //   300: ldc_w 307
    //   303: iconst_2
    //   304: ldc_w 871
    //   307: aload 5
    //   309: invokestatic 1154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   312: aload_1
    //   313: ifnull +22 -> 335
    //   316: aload_1
    //   317: invokevirtual 1148	java/io/FileOutputStream:close	()V
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
    //   340: invokevirtual 1148	java/io/FileOutputStream:close	()V
    //   343: goto +6 -> 349
    //   346: astore_1
    //   347: aload_1
    //   348: athrow
    //   349: ldc_w 1093
    //   352: invokestatic 1099	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   355: checkcast 1093	com/tencent/mobileqq/qrscan/api/IChirpApi
    //   358: invokeinterface 1151 1 0
    //   363: iconst_0
    //   364: ireturn
    //   365: astore_1
    //   366: aload 4
    //   368: ifnull +14 -> 382
    //   371: aload 4
    //   373: invokevirtual 1148	java/io/FileOutputStream:close	()V
    //   376: goto +6 -> 382
    //   379: astore_1
    //   380: aload_1
    //   381: athrow
    //   382: aload_1
    //   383: athrow
    //   384: invokestatic 296	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq -38 -> 349
    //   390: new 298	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   397: astore_1
    //   398: aload_1
    //   399: ldc_w 1156
    //   402: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_1
    //   407: iload_2
    //   408: invokevirtual 762	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: ldc_w 307
    //   415: iconst_4
    //   416: aload_1
    //   417: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 373	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: goto -74 -> 349
    //   426: astore_1
    //   427: ldc_w 1093
    //   430: invokestatic 1099	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   433: checkcast 1093	com/tencent/mobileqq/qrscan/api/IChirpApi
    //   436: invokeinterface 1151 1 0
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
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendIsResumeBroadcast isNeedSend = ");
      localStringBuilder.append(this.aC);
      localStringBuilder.append(" ,isResume = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
    }
    if (this.aC) {
      SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    if (paramBoolean)
    {
      localActionSheet.addButton(2131894244, 1, 10);
      QidCardManager.QidCardReport.b("0X800B973");
    }
    localActionSheet.addButton(2131894237, 1, 7);
    localActionSheet.addButton(2131894243, 1, 8);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new QRDisplayActivity.28(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void u()
  {
    Object localObject = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.setBackgroundDrawable(null);
    getTitleBarView().setBackgroundColor(0);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    this.d.setVisibility(8);
    findViewById(2131442858).setBackgroundDrawable(null);
    this.I.setVisibility(8);
    this.aa = findViewById(16908290);
    this.ab = ((ImageView)findViewById(2131436194));
    this.ab.setVisibility(0);
    this.ab.setContentDescription(getString(2131895296));
    this.ab.setOnClickListener(this);
    this.leftView.setContentDescription(getString(2131916399));
    this.ac = findViewById(2131442881);
    this.ac.setVisibility(0);
    this.ad = this.ac.findViewById(2131442831);
    this.ad.setOnClickListener(this);
    this.ad.setContentDescription(getString(2131897196));
    this.ae = ((ImageView)this.ac.findViewById(2131436470));
    this.ae.setOnClickListener(this);
    this.af = ((ImageView)this.ac.findViewById(2131436517));
    this.ag = ((TextView)this.ac.findViewById(2131448604));
    this.ah = ((TextView)this.ac.findViewById(2131448845));
    localObject = HardCodeUtil.a(2131894238);
    String str = this.n;
    localObject = LongClickCopyAction.attachCopyAction(this.ah, (String)localObject, str);
    if (localObject != null) {
      ((LongClickCopyAction)localObject).setCopyListener(new QRDisplayActivity.3(this));
    }
    this.ai = ((TextView)this.ac.findViewById(2131448810));
    this.ah.setContentDescription(getString(2131914025));
    this.m = getString(2131914185);
    this.W = ((LinearLayout)findViewById(2131434448));
    this.W.setVisibility(0);
    this.M = findViewById(2131442870);
    this.N = ((ImageView)findViewById(2131442869));
    this.O = ((TextView)findViewById(2131442871));
    this.P = findViewById(2131442887);
    this.Q = ((ImageView)findViewById(2131442886));
    this.R = ((TextView)findViewById(2131442888));
    this.T = findViewById(2131442894);
    this.U = ((ImageView)findViewById(2131442893));
    this.V = ((TextView)findViewById(2131442895));
    int i1 = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131298736) * 3) / 8;
    localObject = (ViewGroup.MarginLayoutParams)this.W.getLayoutParams();
    if (localObject != null)
    {
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = i1;
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = i1;
      this.W.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.aX = new QRDisplayActivity.MyViewAlphaOnTouchListener(this, null);
    this.M.setOnClickListener(this);
    this.M.setOnTouchListener(this.aX);
    this.P.setOnClickListener(this);
    this.P.setOnTouchListener(this.aX);
    this.T.setOnClickListener(this);
    this.T.setOnTouchListener(this.aX);
    this.ap = getResources().getDrawable(2130839590);
    this.ao = ((TextView)findViewById(2131442469));
    this.aj = QrCodeDisplayConfProcessor.a();
    if ((this.aj.a.size() <= 0) || (TextUtils.isEmpty(((QrCodeConfBean.QrCodeList)this.aj.a.get(0)).a))) {
      this.ai.setVisibility(8);
    }
    this.am = QRUtils.a(this.app);
    i1 = this.am;
    if ((i1 >= 0) && (i1 < this.aj.a.size()))
    {
      if (QRUtils.a(this.app, this.n) == 1) {
        a((QrCodeConfBean.QrCodeList)this.aj.a.get(this.am), false);
      }
    }
    else {
      s();
    }
    ReportController.b(this.app, "CliOper", "", "", "0X800AEAB", "0X800AEAB", 0, 0, "", "", "", "");
    QidCardManager.QidCardReport.b("0X800B96E");
  }
  
  private void v()
  {
    boolean bool = NetworkUtil.isNetSupport(BaseApplication.getContext());
    Object localObject1 = "qr_circle";
    if (!bool)
    {
      QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "tryToGetShareLink: net is not supported");
      }
      if (this.t == 2)
      {
        i1 = this.aN;
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
        TroopReportor.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.n, String.valueOf(this.q), "1" });
      }
      this.aN = -1;
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("temp_qrcode_share_");
    ((StringBuilder)localObject1).append(this.n);
    ((StringBuilder)localObject1).append(".png");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("temp_qrcode_share_qid_");
    ((StringBuilder)localObject3).append(this.n);
    ((StringBuilder)localObject3).append(".png");
    localObject3 = ((StringBuilder)localObject3).toString();
    i1 = this.aN;
    if (i1 != 0) {
      if (i1 != 1) {
        if ((i1 != 2) && (i1 != 3)) {
          return;
        }
      }
    }
    try
    {
      if (!WXShareHelper.a().b())
      {
        i1 = 2131918154;
      }
      else
      {
        if (WXShareHelper.a().c()) {
          break label852;
        }
        i1 = 2131918155;
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
      QQToast.makeText(this, getString(i1), 0).show(getTitleBarHeight());
      if (this.t == 2)
      {
        if (this.aN == 2)
        {
          localObject1 = "qr_wechat";
          TroopReportor.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.n, String.valueOf(this.q), "1" });
        }
      }
      else {
        this.aN = -1;
      }
    }
    else
    {
      if (this.E == null)
      {
        this.E = new QRDisplayActivity.22(this);
        WXShareHelper.a().a(this.E);
      }
      ThreadManager.post(new QRDisplayActivity.23(this, (String)localObject1, (String)localObject3), 8, null, true);
      return;
      QRUtils.a(1, 2131894252);
      if (this.t == 2)
      {
        if (this.aN == 2) {
          localObject1 = "qr_wechat";
        } else {
          localObject1 = "qr_circle";
        }
        TroopReportor.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.n, String.valueOf(this.q), "1" });
      }
      return;
      g();
      if ((this.L & 0x1) != 0) {
        ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
      }
      i1 = this.t;
      if (i1 == 2)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qzone", 0, 0, this.n, "", String.valueOf(this.q), "");
        return;
      }
      if (i1 == 5)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8006675", "0X8006675", 0, 0, "", "", "", "");
        return;
      }
      try
      {
        if (QRUtils.a(this.app, this.n) != 1) {
          break label864;
        }
        ThreadManager.post(new QRDisplayActivity.24(this, (String)localObject1), 8, null, true);
        i1 = this.t;
        if (i1 == 2)
        {
          ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qq", 0, 0, this.n, "", String.valueOf(this.q), "");
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
      QRUtils.a(1, 2131894252);
      if (this.t == 2) {
        TroopReportor.a("Grp_share", "grpData_admin", "qr_qq", 0, 0, new String[] { this.n, String.valueOf(this.q), "1" });
      }
      return;
    }
  }
  
  private void w()
  {
    if (!this.app.isVideoChatting())
    {
      if (!AppSetting.e) {
        return;
      }
      Message localMessage = this.aY.obtainMessage(1000, 5, 0);
      this.aY.sendMessage(localMessage);
    }
  }
  
  private void x()
  {
    if (!this.app.isVideoChatting())
    {
      if (!AppSetting.e) {
        return;
      }
      this.aY.removeCallbacksAndMessages(null);
      this.aY.obtainMessage(1001, 5, 0).sendToTarget();
    }
  }
  
  private void y()
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
    boolean bool1 = WXShareHelper.a().b();
    boolean bool2 = WXShareHelper.a().c();
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
  
  private void z()
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
    boolean bool1 = WXShareHelper.a().b();
    boolean bool2 = WXShareHelper.a().c();
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
  
  protected BitMatrix a(String paramString, int paramInt1, int paramInt2)
  {
    String str = k();
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
    this.z.removeCallbacks(this.aK);
    String str;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        str = HardCodeUtil.a(2131908811);
      } else {
        str = HardCodeUtil.a(2131908809);
      }
    }
    else {
      str = HardCodeUtil.a(2131908812);
    }
    a(2130839791, str);
    finish();
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.makeText(this, paramInt, paramString, 0).show(getTitleBarHeight());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (!QVipQidProcessor.e().b) {
      return;
    }
    QrCodeConfBean.QrCodeList localQrCodeList = null;
    if (p()) {
      localQrCodeList = (QrCodeConfBean.QrCodeList)this.aj.a.get(this.am);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.W.getLayoutParams();
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        localLayoutParams.addRule(3, 2131442885);
        this.aP.setVisibility(0);
        this.ac.setVisibility(8);
        a(new QrCodeConfBean.QrCodeList(localQrCodeList, QidCardManager.d(this.n), QQTheme.isColorDark(this.aT) ^ true), false, true);
        b(true);
      }
    }
    else
    {
      localLayoutParams.addRule(3, 2131442881);
      this.aP.setVisibility(8);
      this.ac.setVisibility(0);
      if (p()) {
        a(localQrCodeList, false);
      } else {
        s();
      }
      b(false);
    }
    if (paramBoolean) {
      QRUtils.a(this.app, this.n, paramInt);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "template ready, draw qrcode");
    }
    if (!this.h)
    {
      if (super.isFinishing()) {
        return;
      }
      this.z.removeCallbacks(this.aK);
      Bitmap localBitmap1 = (Bitmap)paramBundle.getParcelable("bkg");
      Bitmap localBitmap2 = (Bitmap)paramBundle.getParcelable("qrbkg");
      int i4 = paramBundle.getInt("B");
      int i5 = paramBundle.getInt("W");
      Rect localRect = (Rect)paramBundle.getParcelable("qrloc");
      ArrayList localArrayList = paramBundle.getParcelableArrayList("clip");
      if (paramBundle.containsKey("qrsz"))
      {
        i1 = paramBundle.getInt("qrsz");
        localObject = j();
        if (localObject != null) {
          this.e = QRUtils.a((String)localObject, i1);
        }
      }
      int i6 = this.e.a();
      Object localObject = new int[i6 * i6];
      int i1 = 0;
      while (i1 < i6)
      {
        i2 = 0;
        while (i2 < i6)
        {
          int i3;
          if (this.e.a(i2, i1)) {
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
      if ((this.r & 0x800) != 0L)
      {
        i1 = this.s;
        if (i1 == 2) {}
        while (i1 == 1)
        {
          i1 = 2130844940;
          break;
        }
      }
      i1 = 0;
      this.a.setVisibility(4);
      if ((this.k != null) && (!this.k.isRecycled())) {
        this.k.recycle();
      }
      int i2 = this.t;
      if (i2 == 1) {
        a(paramBundle, localArrayList, localBitmap3);
      }
      for (;;)
      {
        break;
        if (i2 == 2) {
          b(paramBundle, localArrayList, localBitmap3);
        } else {
          this.k = QRUtils.a(this, localBitmap1, this.j, paramBundle.getInt("nameClr"), this.l, localBitmap2, localBitmap3, paramBundle.getInt("head"), paramBundle.getInt("tipsClr"), this.m, localRect, localArrayList, i1);
        }
      }
      localBitmap3.recycle();
      if (this.k != null) {
        this.d.setImageBitmap(this.k);
      }
      for (;;)
      {
        break;
        if (super.isResume())
        {
          paramBundle = DialogUtil.a(this, 230);
          paramBundle.setMessage(2131915920);
          paramBundle.setPositiveButton(2131892267, new QRDisplayActivity.16(this));
          paramBundle.show();
        }
        else
        {
          super.finish();
        }
      }
      this.g = false;
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    String str = k();
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
    if (this.t == 11)
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
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "enter focus_clear");
    }
    this.aY.removeCallbacksAndMessages(null);
    Message.obtain(this.aY, 1001, 3, 0).sendToTarget();
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
      i2 = this.aT;
      this.N.setColorFilter(i2);
      this.Q.setColorFilter(this.aT);
      this.U.setColorFilter(this.aT);
    }
    else
    {
      if (p()) {
        i1 = 2130846338;
      }
      i2 = this.aS;
      this.N.clearColorFilter();
      this.Q.clearColorFilter();
      this.U.clearColorFilter();
    }
    this.M.setBackgroundResource(i1);
    this.P.setBackgroundResource(i1);
    this.T.setBackgroundResource(i1);
    this.O.setTextColor(i2);
    this.R.setTextColor(i2);
    this.V.setTextColor(i2);
    QidPagView localQidPagView = this.aQ;
    if (localQidPagView != null)
    {
      if (paramBoolean)
      {
        localQidPagView.a(this.aT);
        return;
      }
      localQidPagView.a();
    }
  }
  
  protected void c()
  {
    Object localObject1 = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    this.c.setBackgroundDrawable(null);
    getTitleBarView().setBackgroundColor(0);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    this.d.setVisibility(8);
    findViewById(2131442858).setBackgroundDrawable(null);
    this.I.setVisibility(8);
    this.aq = findViewById(16908290);
    this.ar = findViewById(2131442897);
    this.ar.setVisibility(0);
    this.as = this.ar.findViewById(2131442830);
    this.as.setOnClickListener(this);
    this.as.setContentDescription(getString(2131897196));
    this.at = ((ImageView)this.ar.findViewById(2131442822));
    this.at.setOnClickListener(this);
    this.au = ((ImageView)this.ar.findViewById(2131442823));
    this.av = ((TextView)this.ar.findViewById(2131442827));
    this.av.setEllipsize(TextUtils.TruncateAt.END);
    this.av.setSingleLine();
    this.aw = ((TextView)this.ar.findViewById(2131442829));
    this.az = ((ImageView)this.ar.findViewById(2131442824));
    this.ay = ((TextView)this.ar.findViewById(2131442826));
    Object localObject2 = HardCodeUtil.a(2131894239);
    Object localObject3 = this.n;
    LongClickCopyAction.attachCopyAction(this.aw, (String)localObject2, (String)localObject3);
    this.ax = ((TextView)this.ar.findViewById(2131442828));
    this.aw.setContentDescription(getString(2131914024));
    localObject2 = findViewById(2131434450);
    ((View)localObject2).setVisibility(0);
    this.M = findViewById(2131442873);
    this.N = ((ImageView)findViewById(2131442872));
    this.O = ((TextView)findViewById(2131442874));
    this.X = findViewById(2131442899);
    this.Y = ((ImageView)findViewById(2131442898));
    this.Z = ((TextView)findViewById(2131442900));
    localObject3 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject3 != null)
    {
      localObject3 = ((TroopManager)localObject3).f(this.n);
      if (localObject3 != null)
      {
        if (((TroopInfo)localObject3).isNewTroop)
        {
          a((TroopInfo)localObject3);
          this.aA = true;
          this.aw.setVisibility(8);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.aw.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject1).topMargin = 0;
          this.aw.setLayoutParams(localLayoutParams);
          localObject1 = (RelativeLayout.LayoutParams)this.as.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).height -= 42;
          this.as.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if ((((TroopInfo)localObject3).cGroupOption == 3) && ((!TroopInfo.hasPayPrivilege(((TroopInfo)localObject3).troopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(((TroopInfo)localObject3).troopPrivilegeFlag, 512))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not allow join mask");
          }
          this.az.setVisibility(0);
          this.ay.setVisibility(0);
          this.ay.setText(getString(2131894256));
          this.M.setVisibility(8);
          this.X.setVisibility(8);
        }
        else if (((((TroopInfo)localObject3).dwGroupFlagExt & 0x80) != 0L) && (!((TroopInfo)localObject3).isAdmin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not invite join mask");
          }
          this.az.setVisibility(0);
          this.ay.setVisibility(0);
          this.ay.setText(getString(2131894257));
          this.M.setVisibility(8);
          this.X.setVisibility(8);
        }
      }
    }
    int i1 = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131298736) * 3) / 8;
    localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
    if (localObject1 != null)
    {
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i1;
      ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = i1;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    this.aX = new QRDisplayActivity.MyViewAlphaOnTouchListener(this, null);
    this.M.setOnClickListener(this);
    this.M.setOnTouchListener(this.aX);
    this.X.setOnClickListener(this);
    this.X.setOnTouchListener(this.aX);
    this.ap = getResources().getDrawable(2130839590);
    this.ao = ((TextView)findViewById(2131442469));
    this.m = getString(2131914141);
    this.leftView.setContentDescription(getString(2131895481));
    this.aj = QrCodeDisplayConfProcessor.a();
    if ((this.aj.a.size() <= 0) || (TextUtils.isEmpty(((QrCodeConfBean.QrCodeList)this.aj.a.get(0)).a))) {
      this.ax.setVisibility(8);
    }
    this.am = QRUtils.b(this.app);
    i1 = this.am;
    if ((i1 >= 0) && (i1 < this.aj.a.size()))
    {
      b((QrCodeConfBean.QrCodeList)this.aj.a.get(this.am), false);
      return;
    }
    this.aq.setBackgroundResource(2130848760);
    localObject1 = getResources().getDrawable(2130853297);
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
      this.aY.sendEmptyMessage(1001);
      this.aY.sendEmptyMessageDelayed(1003, 500L);
      return;
    }
    if (!this.aY.hasMessages(1001)) {
      this.aY.sendEmptyMessageDelayed(1002, 1000L);
    }
  }
  
  protected void d()
  {
    if (this.aL == null)
    {
      this.aL = ((ActionSheet)ActionSheetHelper.b(this, null));
      this.aL.addButton(2131914126, 1);
      this.aL.addButton(2131914128, 1);
      this.aL.addButton(2131914125, 1);
      this.aL.addCancelButton(2131887648);
      this.aL.setOnDismissListener(new QRDisplayActivity.11(this));
      this.aL.setOnButtonClickListener(new QRDisplayActivity.12(this));
    }
    if (!this.aL.isShowing())
    {
      this.aM = false;
      this.aL.show();
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
    if (this.t == 2)
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
        TroopReportor.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.n, String.valueOf(this.q), localObject2 });
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
        a(0, getString(2131914127));
        if (QLog.isColorLevel()) {
          QLog.i("QRDisplayActivity", 2, "shareQRCode success");
        }
        if ((this.L & 0x1) != 0) {
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
    if ((this.t == 1) && (paramInt1 == 1)) {
      F();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if ((1 == super.getIntent().getIntExtra("type", 1)) || (2 == super.getIntent().getIntExtra("type", 2))) {
      this.mActNeedImmersive = false;
    }
    super.doOnCreate(paramBundle);
    this.z = new Handler();
    super.setContentView(2131626480);
    paramBundle = super.getIntent();
    this.y = paramBundle.getStringExtra("from");
    this.L = paramBundle.getIntExtra("reportFlag", 0);
    super.setTitle(paramBundle.getStringExtra("title"));
    this.l = paramBundle.getStringExtra("nick");
    this.j = ((Bitmap)paramBundle.getParcelableExtra("face"));
    this.t = paramBundle.getIntExtra("type", 1);
    this.n = paramBundle.getStringExtra("uin");
    this.q = paramBundle.getIntExtra("adminLevel", 2);
    this.r = paramBundle.getLongExtra("GroupFlagExt", 0L);
    this.s = ((int)paramBundle.getLongExtra("AuthGroupType", 0L));
    this.i = paramBundle.getBooleanExtra("isQidianPrivateTroop", false);
    this.d = ((ImageView)super.findViewById(2131442859));
    this.c = super.findViewById(2131442890);
    this.I = findViewById(2131442879);
    this.b = super.findViewById(2131442901);
    int i1 = this.t;
    if (i1 == 1)
    {
      u();
      D();
    }
    else if (i1 == 2)
    {
      c();
      this.c.post(this.aI);
    }
    else if (i1 == 5)
    {
      findViewById(2131441422).setVisibility(0);
      findViewById(2131434447).setVisibility(0);
      findViewById(2131442867).setOnClickListener(this);
      findViewById(2131442868).setOnClickListener(this);
      this.m = getString(2131914137);
    }
    else if (i1 == 11)
    {
      findViewById(2131441422).setVisibility(0);
      findViewById(2131434447).setVisibility(0);
      findViewById(2131442867).setOnClickListener(this);
      findViewById(2131442868).setOnClickListener(this);
      this.m = getString(2131914166);
    }
    this.a = super.findViewById(2131442876);
    this.J = findViewById(2131441423);
    this.I.setContentDescription(getString(2131894242));
    if (QLog.isDevelopLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("display qrcode, type: ");
      paramBundle.append(this.t);
      QLog.d("QRDisplayActivity", 4, paramBundle.toString());
    }
    i1 = this.t;
    Object localObject1;
    if (i1 == 5)
    {
      getIntent().getStringExtra("discussion_shorturl");
      addObserver(this.aF);
      if (this.app != null)
      {
        this.C = ((DiscussionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
        this.app.registObserver(this.aD);
      }
      this.leftView.setContentDescription(getString(2131893860));
      this.I.setContentDescription(getString(2131893861));
      setResult(-1, getIntent());
      paramBundle = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject2 = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      localObject1 = ((DiscussionManager)localObject2).d(this.n);
      if (localObject1 == null)
      {
        i();
      }
      else
      {
        localObject2 = ((DiscussionManager)localObject2).a(this.n);
        if (localObject2 != null) {
          this.K = ((List)localObject2).size();
        } else {
          this.K = 0;
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
                this.B.add(ContactUtils.f(this.app, ((DiscussionMemberInfo)localObject2).memberUin));
              }
              else
              {
                Friends localFriends = paramBundle.m(((DiscussionMemberInfo)localObject2).memberUin);
                if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name))) {
                  this.B.add(localFriends.name);
                } else if (a(((DiscussionMemberInfo)localObject2).memberUin) != null) {
                  this.B.add(a(((DiscussionMemberInfo)localObject2).memberUin));
                } else {
                  this.A.add(((DiscussionMemberInfo)localObject2).memberUin);
                }
              }
            }
            if ((this.B.size() < 5) && (this.A.size() > 0))
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("QRDisplayActivity", 4, "fetch nicks from server");
              }
              paramBundle = new String[this.A.size()];
              localObject1 = this.A.iterator();
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
            if (this.B.size() <= 0) {
              break label1150;
            }
            Collections.sort(this.B, new QRDisplayActivity.DiscussionMemberComparator(this));
            this.l = a(this.B);
            i2 = i1;
            break label1150;
          }
        }
      }
    }
    else if (i1 == 2)
    {
      this.I.setContentDescription(getString(2131914139, new Object[] { this.l, this.m }));
      addObserver(this.aJ);
      addObserver(this.aE);
    }
    else if (i1 == 11)
    {
      this.I.setContentDescription(getString(2131914139, new Object[] { this.l, this.m }));
    }
    int i2 = 1;
    label1150:
    this.f = new CodeMaskManager(this, this.t);
    this.z.postDelayed(this.aK, 60000L);
    if (i2 != 0)
    {
      paramBundle = this.d;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.l);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(this.m);
      paramBundle.setContentDescription(((StringBuilder)localObject1).toString());
      this.c.post(this.aG);
    }
    if ((this.L & 0x1) != 0) {
      ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416D", "0X800416D", 0, 0, "", "", "", "");
    }
    this.aY = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.aY.obtainMessage(1004, 1, 0).sendToTarget();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.z.removeCallbacks(this.aK);
    if ((this.k != null) && (!this.k.isRecycled()))
    {
      this.k.recycle();
      this.k = null;
    }
    this.d.setImageDrawable(null);
    this.f.a();
    int i1 = this.t;
    if (i1 == 5)
    {
      removeObserver(this.aF);
      this.app.unRegistObserver(this.aD);
    }
    else if (i1 == 2)
    {
      removeObserver(this.aJ);
      removeObserver(this.aE);
    }
    if (this.E != null)
    {
      WXShareHelper.a().b(this.E);
      this.E = null;
    }
    EarlyHandler localEarlyHandler = this.bd;
    if (localEarlyHandler != null) {
      ((IChirpSoDownload)localEarlyHandler).b(this);
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Handler localHandler = this.aY;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.aY.sendEmptyMessage(1001);
    }
    c(false);
    C();
    ApngImage.pauseByTag(35);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.aY.obtainMessage(1004, 2, 0).sendToTarget();
    c(true);
    ApngImage.playByTag(35);
    r();
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
    int i1 = this.t;
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
    int i1 = this.t;
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
    if (!this.h)
    {
      if (super.isFinishing()) {
        return;
      }
      this.a.setVisibility(0);
      this.g = true;
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 2, "get code template");
      }
      Object localObject = this.f;
      boolean bool3 = this.x;
      boolean bool1;
      if ((this.r & 0x800) != 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int i1 = this.s;
      int i2 = this.t;
      boolean bool2;
      if ((i2 != 1) && (i2 != 2)) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      ((CodeMaskManager)localObject).a(this, bool3, bool1, i1, bool2);
      if (this.x)
      {
        this.x = false;
        return;
      }
      if (this.t == 1) {
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
          paramMessage.append(AppSetting.e);
          QLog.d("QRDisplayActivity", 2, paramMessage.toString());
        }
        if ((AppSetting.e) && (this.t == 1))
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
            if (this.bd == null) {
              this.bd = ((IEarlyDownloadService)this.app.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler(((IQRScanEarlyHandlerApi)QRoute.api(IQRScanEarlyHandlerApi.class)).getResName(4));
            }
            paramMessage = this.bd;
            if (paramMessage != null)
            {
              ((IChirpSoDownload)paramMessage).a(this);
              this.bd.a(true);
            }
          }
          else
          {
            bool1 = bool2;
            if (this.bc) {
              break label289;
            }
            BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.25(this));
            this.bc = true;
            bool1 = bool2;
            break label289;
          }
        }
      }
      boolean bool1 = false;
      BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.26(this, bool1));
      return false;
    case 1003: 
      QQAppInterface.speak(aB);
      return false;
    case 1002: 
      paramMessage = this.aZ;
      if (paramMessage != null)
      {
        paramMessage.a();
        return false;
      }
      break;
    case 1001: 
      localObject1 = this.aZ;
      if (localObject1 != null)
      {
        ((PcmPlayer)localObject1).b();
        this.aZ = null;
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
        ((StringBuilder)localObject1).append(this.bb);
        QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if (!this.bb)
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
          this.bb = (b((String)localObject1) ^ true);
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("playQRCodeFailed = ");
          ((StringBuilder)localObject2).append(this.bb);
          QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject2).toString());
        }
        if (!this.bb)
        {
          if (this.aZ == null)
          {
            this.aZ = new PcmPlayer(this, this, 44100, (String)localObject1);
            this.aZ.a();
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
          this.aY.sendEmptyMessage(1003);
        }
      }
      break;
    }
    return false;
  }
  
  protected void i()
  {
    this.z.removeCallbacks(this.aK);
    if (super.isResume())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setMessage(2131915918);
      localQQCustomDialog.setPositiveButton(2131892267, new QRDisplayActivity.17(this));
      localQQCustomDialog.show();
      return;
    }
    finish();
  }
  
  public String j()
  {
    String str = k();
    if (str == null) {
      return null;
    }
    return getSharedPreferences("qrcode", 0).getString(str, null);
  }
  
  public String k()
  {
    int i1 = this.t;
    StringBuilder localStringBuilder;
    if (i1 == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("user");
      localStringBuilder.append(this.n);
      return localStringBuilder.toString();
    }
    if (i1 == 2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("group");
      localStringBuilder.append(this.n);
      return localStringBuilder.toString();
    }
    if (i1 == 5)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("discussion");
      localStringBuilder.append(this.n);
      return localStringBuilder.toString();
    }
    if (i1 == 11)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("groupqav");
      localStringBuilder.append(this.n);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  protected void l()
  {
    Object localObject;
    if (this.be == null)
    {
      QRDisplayActivity.19 local19 = new QRDisplayActivity.19(this);
      localObject = new QRDisplayActivity.20(this);
      this.be = new ShareActionSheetBuilder(this);
      this.be.setActionSheetTitle(getString(2131916565));
      this.be.setActionSheetItems(a(this));
      this.be.setOnDismissListener((DialogInterface.OnDismissListener)localObject);
      this.be.setCancelListener(new QRDisplayActivity.21(this));
      this.be.setItemClickListener(local19);
    }
    try
    {
      if ((this.be != null) && (!this.be.isShowing()))
      {
        this.aM = false;
        this.be.show();
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
  
  public void m()
  {
    if (this.t == 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800AEAF", "0X800AEAF", 0, 0, "", "", "", "");
      if (QRUtils.a(this.app, this.n) == 2) {
        QidCardManager.QidCardReport.b("0X800B9A9");
      }
    }
    ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "scan_QR_code", "code_click", 0, 0, "", "", "", "");
    if ("ScannerActivity".equals(this.y))
    {
      if (isInMultiWindow()) {
        QQToast.makeText(this, HardCodeUtil.a(2131908808), 0).show();
      }
      setResult(-1);
      finish();
      return;
    }
    if (isInMultiWindow())
    {
      QQToast.makeText(this, HardCodeUtil.a(2131908810), 0).show();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("from", "QRDisplayActivity");
    RouteUtils.a(this, localIntent, "/qrscan/scanner", 3);
  }
  
  public void n() {}
  
  public void o()
  {
    if (isResume()) {
      this.aY.obtainMessage(1004, 4, 0).sendToTarget();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    int i1;
    boolean bool;
    if (Math.abs(l1 - this.S) > 1000L)
    {
      this.S = l1;
      i1 = paramView.getId();
      bool = true;
      if (i1 == 2131442879)
      {
        if (!this.g)
        {
          i1 = this.t;
          if (i1 == 2)
          {
            h();
            if ((this.L & 0x1) != 0) {
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
      else if (paramView.getId() == 2131442861) {
        if (this.D == null) {
          this.D = new LinkShareActionSheetBuilder(this).a(this);
        }
      }
    }
    try
    {
      this.D.show();
      label216:
      ReportController.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
      break label1046;
      if (paramView.getId() == 2131442867)
      {
        if (!this.g)
        {
          e();
          if ((this.L & 0x1) != 0) {
            ReportController.b(this.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
          }
          if (this.t == 5) {
            ReportController.b(this.app, "CliOper", "", "", "0X8006672", "0X8006672", 0, 0, "", "", "", "");
          }
          if (this.t == 2) {
            new ReportTask(this.app).a("P_CliOper").b("Grp_set").c("Grp_data").d("qr_save").a(new String[] { this.n, "", String.valueOf(this.q) }).a();
          }
        }
      }
      else if (paramView.getId() == 2131442868)
      {
        l();
        if (this.t == 5) {
          ReportController.b(this.app, "CliOper", "", "", "0X8006673", "0X8006673", 0, 0, "", "", "", "");
        }
      }
      else if ((paramView.getId() != 2131442886) && (paramView.getId() != 2131442888))
      {
        if (paramView.getId() == 2131442870)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X800AEAD", "0X800AEAD", 0, 0, "", "", "", "");
          if (QRUtils.a(this.app, this.n) == 1)
          {
            this.k = this.aU;
          }
          else
          {
            this.k = q();
            QidCardManager.QidCardReport.b("0X800B9A7");
          }
          y();
        }
        else if (paramView.getId() == 2131442873)
        {
          z();
        }
        else if (paramView.getId() == 2131442899)
        {
          e();
        }
        else if (paramView.getId() == 2131442887)
        {
          m();
        }
        else if (paramView.getId() == 2131442894)
        {
          i1 = this.aO;
          if (i1 == 0) {
            E();
          } else if (i1 == 1) {
            if (QRUtils.a(this.app, this.n) == 1)
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
          t();
        }
        else if (paramView.getId() == 2131436194)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X800AEB5", "0X800AEB5", 0, 0, "", "", "", "");
          if (QRUtils.a(this.app, this.n) != 2) {
            bool = false;
          }
          d(bool);
        }
        else
        {
          StringBuilder localStringBuilder;
          if (paramView.getId() == 2131442831)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onClick qr_code_white_bg isLoading =");
              localStringBuilder.append(this.g);
              QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
            }
            if (!this.g)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X800AEB4", "0X800AEB4", 0, 0, "", "", "", "");
              a(QRUtils.a(this.app, this.aj, this.am), true);
            }
          }
          else if (paramView.getId() == 2131442830)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onClick qr_code_troop_white_bg isLoading =");
              localStringBuilder.append(this.g);
              QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
            }
            if (!this.g) {
              b(QRUtils.a(this.app, this.aj, this.am), true);
            }
          }
        }
      }
      else
      {
        m();
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
            DiscussionInfoCardActivity.a(this.app, this.G, this.o, this.l);
          }
        }
        else
        {
          int i1;
          if (!WXShareHelper.a().b()) {
            i1 = 2131918154;
          } else if (!WXShareHelper.a().c()) {
            i1 = 2131918155;
          } else {
            i1 = -1;
          }
          if (i1 != -1)
          {
            QRUtils.a(1, i1);
          }
          else
          {
            if (this.E == null)
            {
              this.E = new QRDisplayActivity.18(this);
              WXShareHelper.a().a(this.E);
            }
            Object localObject = this.app;
            if (paramInt == 2) {
              str1 = "1";
            } else {
              str1 = "0";
            }
            ReportController.b((AppRuntime)localObject, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, str1, "", "", "");
            this.F = String.valueOf(System.currentTimeMillis());
            String str1 = String.format(getString(2131888731), new Object[] { this.l });
            if (this.t == 11) {
              str1 = getString(2131890650);
            }
            localObject = WXShareHelper.a();
            String str2 = this.F;
            Bitmap localBitmap = this.j;
            String str3 = this.o;
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
        DiscussionInfoCardActivity.a(this.app, this, this.o, this.n, this.l);
      }
    }
    else
    {
      if (this.H == null)
      {
        this.H = new QQProgressDialog(this, getTitleBarHeight());
        this.H.c(2131892360);
        this.H.c(false);
      }
      DiscussionInfoCardActivity.a(this.app, this, 2, this.p, this.n, this.l, this.K, this.H);
    }
    this.D.dismiss();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public boolean p()
  {
    int i1 = this.am;
    return (i1 >= 0) && (i1 < this.aj.a.size());
  }
  
  public Bitmap q()
  {
    Bitmap localBitmap2 = this.aV;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      this.W.setVisibility(8);
      getTitleBarView().setVisibility(8);
      localBitmap1 = QRUtils.a(this, QRUtils.a(this.aa), this.aQ.getBitmap());
      this.W.setVisibility(0);
      getTitleBarView().setVisibility(0);
    }
    return localBitmap1;
  }
  
  public void r()
  {
    if (this.aR != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("101600.101601");
      if (localAppInfo != null) {
        localIRedTouchManager.reportLevelOneRedInfo("101600.101601", 30);
      }
      this.aR.a(localAppInfo);
    }
  }
  
  public void s()
  {
    this.aa.setBackgroundResource(2130848760);
    Drawable localDrawable = getResources().getDrawable(2130844816);
    localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.ab.setBackgroundDrawable(null);
    this.ab.setImageDrawable(localDrawable);
    localDrawable = getResources().getDrawable(2130853297);
    localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.leftView.setBackgroundDrawable(localDrawable);
    this.centerView.setTextColor(-16777216);
  }
  
  public void t()
  {
    ((IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("101600.101601");
    this.aR.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity
 * JD-Core Version:    0.7.0.1
 */