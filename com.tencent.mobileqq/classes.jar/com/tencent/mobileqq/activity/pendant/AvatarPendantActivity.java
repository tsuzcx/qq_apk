package com.tencent.mobileqq.activity.pendant;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractGifImage.DoAccumulativeRunnable;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter.FaceGridAdapter.GridFaceItemHolder;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter.PendantGridAdapter.GridItemHolder;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter.ViewHolder;
import com.tencent.mobileqq.adapter.CmshowFaceGridAdapter.CmshowFaceItemHolder;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.apollo.meme.IGetGifFrameCallback;
import com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.screenshot.api.IApolloAvatarVideoProcessor;
import com.tencent.mobileqq.apollo.screenshot.api.IApolloAvatarVideoProcessor.OnProcessFinishListener;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.apollo.utils.api.IApolloClassFactory;
import com.tencent.mobileqq.apollo.utils.api.IApolloEngineHelper;
import com.tencent.mobileqq.apollo.utils.api.ICMShowWnsHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.UniPayHandler;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.AvatarInPendantHeadportraitInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.AvatarPendantShopItemInfo;
import com.tencent.mobileqq.vas.AvatarPendantShopSeriesInfo;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.tianshu.TianShuManager;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class AvatarPendantActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, View.OnLayoutChangeListener, AdapterView.OnItemClickListener
{
  public static int a = 0;
  private static final int av = ViewUtils.dpToPx(60.0F);
  private static final int aw = ViewUtils.dpToPx(0.0F);
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  XListView A;
  AvatarPendantAdapter B;
  ImageView C;
  AvatarLayout D;
  DynamicAvatarView E;
  ImageView F;
  View G;
  TipsBar H;
  ImageView I;
  UniPayHandler J;
  Uri K;
  AllInOne L;
  Handler M;
  public long N = -1L;
  public int O = -1;
  public int P = -1;
  long Q = -1L;
  long R = -1L;
  AvatarPendantShopItemInfo S;
  AvatarPendantShopSeriesInfo T;
  String U;
  String V;
  int W;
  LinearLayout X;
  Button Y;
  TextView Z;
  private String aA;
  private String aB;
  private int aC;
  private View aD;
  private Button aE;
  private ProgressBar aF;
  private int aG;
  private int aH;
  private int aI = AbstractGifImage.DoAccumulativeRunnable.DELAY;
  private IApolloAvatarVideoProcessor aJ;
  private int aK;
  private String aL;
  private CardObserver aM = new AvatarPendantActivity.1(this);
  private SVIPObserver aN = new AvatarPendantActivity.3(this);
  private GameCenterObserver aO = new AvatarPendantActivity.5(this);
  private IApolloExtensionObserver aP = new AvatarPendantActivity.19(this);
  private AvatarObserver aQ = new AvatarPendantActivity.25(this);
  TextView aa;
  RedTouch ab;
  BusinessInfoCheckUpdate.AppInfo ac;
  boolean ad = false;
  volatile boolean ae = false;
  String af;
  long ag = 0L;
  AtomicBoolean ah = new AtomicBoolean(false);
  AtomicBoolean ai = new AtomicBoolean(false);
  List<AvatarInPendantHeadportraitInfo> aj;
  AvatarInPendantHeadportraitInfo ak;
  ISVIPHandler al;
  Button am;
  String an;
  SharedPreferences.Editor ao;
  SparseIntArray ap = new SparseIntArray();
  UniPayHandler.UniPayUpdateListener aq = new AvatarPendantActivity.10(this);
  DownloadListener ar = new AvatarPendantActivity.17(this);
  IApolloExtensionObserver as = new AvatarPendantActivity.18(this);
  CallBacker at = new AvatarPendantActivity.24(this);
  public IGetGifFrameCallback au = new AvatarPendantActivity.32(this);
  private boolean ax = true;
  private List<CmAvatarFaceInfo> ay;
  private CmAvatarFaceInfo az;
  int e;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  int l;
  int m;
  int n;
  int o;
  int p;
  double q;
  double r;
  int s;
  boolean t;
  boolean u;
  boolean v;
  int w = 0;
  View x;
  View y;
  View z;
  
  private void A()
  {
    Object localObject = this.A;
    if (localObject == null) {
      return;
    }
    localObject = (ViewGroup.MarginLayoutParams)((XListView)localObject).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = aw;
    this.A.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void B()
  {
    int i1 = this.P;
    if (i1 != -1)
    {
      int i2 = this.O;
      if (i2 != -1)
      {
        if (i1 == i2)
        {
          this.am.setText(HardCodeUtil.a(2131899112));
          this.am.setEnabled(false);
          return;
        }
        this.am.setText(HardCodeUtil.a(2131899111));
        this.am.setEnabled(true);
      }
    }
  }
  
  private void C()
  {
    int i1 = this.P;
    if (i1 != -1)
    {
      int i2 = this.O;
      if (i2 != -1)
      {
        if (i1 == i2)
        {
          this.aE.setText(HardCodeUtil.a(2131899112));
          this.aE.setEnabled(false);
          return;
        }
        this.aE.setText(HardCodeUtil.a(2131915688));
        this.aE.setEnabled(true);
      }
    }
  }
  
  private boolean D()
  {
    boolean bool2 = TextUtils.isEmpty(this.af);
    boolean bool1 = false;
    if (bool2) {}
    Object localObject;
    do
    {
      i1 = 0;
      break;
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.headCfg.name(), "24|3500|1|0").split("\\|");
    } while (localObject.length <= 3);
    int i1 = Integer.parseInt(localObject[3]);
    if (i1 != 0) {
      bool1 = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedShowHDHead, result=");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", hdHeadUrl=");
      ((StringBuilder)localObject).append(this.af);
      ((StringBuilder)localObject).append(",openflag=");
      ((StringBuilder)localObject).append(i1);
      QLog.i("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.ai.set(bool1);
    return bool1;
  }
  
  private void E()
  {
    Intent localIntent = new Intent();
    int i1 = ProfileCardUtil.b(this);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("Business_Origin", 100);
    localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    localIntent.putExtra("fromWhereClick", 11);
    PhotoUtils.startPhotoListEdit(localIntent, this, AvatarPendantActivity.class.getName(), i1, i1, 1080, 1080, FaceUtil.a());
    ReportController.b(this.app, "CliOper", "", "", "0X8004177", "0X8004177", this.L.profileEntryType, 0, "", "", "", "");
  }
  
  private void F()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      int i1;
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        requestPermissions(new AvatarPendantActivity.27(this), 0, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      E();
      return;
    }
    E();
  }
  
  private void G()
  {
    this.aG = ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus();
  }
  
  private void H()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCmshowFaceDataFormNetwork faceType:");
    localStringBuilder.append(this.aH);
    QLog.d("AvatarPendantActivity", 1, localStringBuilder.toString());
    ThreadManagerV2.executeOnSubThread(new AvatarPendantActivity.30(this));
  }
  
  private void I()
  {
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 749;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(localArrayList, new AvatarPendantActivity.31(this));
  }
  
  private void J()
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    String str = this.app.getCurrentUin();
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(l1);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.c = 1;
    localTianShuReportData.f = "tianshu.75";
    localTianShuReportData.g = "tianshu.75";
    localTianShuReportData.h = String.valueOf(this.aK);
    localTianShuReportData.i = "";
    localTianShuReportData.o = l1;
    localTianShuReportData.p = 102;
    localTianShuReportData.q = 1;
    localTianShuReportData.r = 1;
    localTianShuReportData.s = this.aL;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).getSingleFrameFile(paramInt1, paramInt2, this.app.getCurrentUin(), new AvatarPendantActivity.28(this));
  }
  
  private void a(int paramInt1, int paramInt2, IApolloAvatarVideoProcessor.OnProcessFinishListener paramOnProcessFinishListener)
  {
    if ((this.aJ != null) && (Build.VERSION.SDK_INT >= 21))
    {
      this.aJ.setProcessFinishListener(paramOnProcessFinishListener);
      this.aJ.process(paramInt1, paramInt2);
    }
  }
  
  private void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (str != null)
    {
      if (ProfileCardUtil.a(this.app, str, paramIntent))
      {
        B();
        this.ax = true;
        w();
        a(true);
        int i1 = paramIntent.getIntExtra("fromWhereClick", -1);
        if (i1 != 10)
        {
          if (i1 != 11) {
            return;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 0, 0, "0", "", "", "");
          return;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 1, 0, "1", "", "", "");
        return;
      }
      QQToast.makeText(this, 1, 2131916287, 0).show(getTitleBarHeight());
    }
  }
  
  private void a(@NonNull CmAvatarFaceInfo paramCmAvatarFaceInfo)
  {
    int i1 = paramCmAvatarFaceInfo.getActionId();
    int i2 = paramCmAvatarFaceInfo.getActionType();
    if (paramCmAvatarFaceInfo.isDynamic())
    {
      a(i1, i2, new AvatarPendantActivity.29(this, paramCmAvatarFaceInfo));
      return;
    }
    a(i1, i2);
  }
  
  @TargetApi(14)
  private void a(List<View> paramList, List<AvatarPendantActivity.AnimRect> paramList1, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 14) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, 100 });
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(new AvatarPendantActivity.8(this, paramList, paramList1));
    localValueAnimator.addListener(new AvatarPendantActivity.9(this));
    localValueAnimator.setDuration(paramInt).start();
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.app;
    String str = this.app.getCurrentAccountUin();
    int i1 = 0;
    localObject = ((QQAppInterface)localObject).getExtensionInfo(str, false);
    if ((!paramBoolean) && (localObject != null)) {
      i1 = ((ExtensionInfo)localObject).faceId;
    }
    if (localObject != null)
    {
      localObject = this.aj;
      if ((localObject != null) && (((List)localObject).size() > 0) && (i1 != this.O))
      {
        this.O = i1;
        this.P = this.O;
        this.ao.putInt("ChooseFaceId", -1);
        this.ao.putInt("mSelectFaceId", this.O);
        this.ao.apply();
      }
    }
  }
  
  private void c(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initHDHeadUrl: uin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
    }
    Setting localSetting = this.app.getQQHeadSettingFromDB(paramString);
    if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.url)))
    {
      localObject = AvatarDownloadUtil.get1080QQHeadDownLoadUrl(localSetting.url, localSetting.bFaceFlags);
      paramString = (String)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramString = MsfSdkUtils.insertMtype("QQHeadIcon", (String)localObject);
      }
      this.ag = localSetting.headImgTimestamp;
      ThreadManager.getUIHandler().post(new AvatarPendantActivity.26(this, paramString));
      return;
    }
    this.app.refreshFace(paramString);
  }
  
  private void d(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetHDHeadUrl: url=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.af = paramString;
    if (D())
    {
      localObject = FaceDrawable.getFaceDrawable(this.app, 1, this.L.uin);
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mRequestWidth = this.D.getWidth();
      paramString.mRequestHeight = this.D.getHeight();
      paramString.mFailedDrawable = ((Drawable)localObject);
      paramString.mLoadingDrawable = ((Drawable)localObject);
      if (this.ah.get())
      {
        if ((this.E.getDrawable() instanceof BitmapDrawable)) {
          paramString.mLoadingDrawable = this.E.getDrawable();
        }
        this.ah.set(false);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.af);
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append(this.ag);
      this.af = ((StringBuilder)localObject).toString();
      URLDrawable.removeMemoryCacheByUrl(this.af, paramString);
      paramString = URLDrawable.getDrawable(this.af, paramString);
      if (SimpleUIUtil.e())
      {
        paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
        paramString.setTag(new int[] { 640, 640, 45 });
      }
      else
      {
        paramString.setDecodeHandler(URLDrawableDecodeHandler.b);
        paramString.setTag(new int[] { 640, 640 });
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "onGetHDHeadUrl: newDisplayHDHead");
      }
      this.D.setFaceDrawable(this.app, paramString, 1, 200, this.L.uin, 640, true, null, false, true, false, true, 7);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "onGetHDHeadUrl: oldDisplayHead");
    }
    this.D.setFaceDrawable(this.app, 1, this.L.uin, 640, true, true, true, false, 7);
  }
  
  private void o()
  {
    this.aj = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).g();
    if (this.aj == null)
    {
      IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "");
      localIVasQuickUpdateService.addCallBacker(this.at);
      localIVasQuickUpdateService.downloadItem(23L, "avatarInPendant_json", "pendant_market");
      h();
    }
  }
  
  private void p()
  {
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "");
    localIVasQuickUpdateService.addCallBacker(this.at);
    Object localObject1 = ((DownloaderFactory)this.app.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    File localFile = new File(AvatarPendantUtil.d);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(AvatarPendantUtil.d);
    ((StringBuilder)localObject2).append("/icon.zip");
    localObject2 = new File(((StringBuilder)localObject2).toString());
    if ((localFile.exists()) && (!((File)localObject2).exists()) && (localObject1 != null)) {
      ThreadManager.getSubThreadHandler().post(new AvatarPendantActivity.IconRunnable(this, this.ar, this.app));
    }
    localObject1 = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).f();
    this.app.getApp().getSharedPreferences(ClubContentJsonTask.i, 0);
    if (((List)localObject1).size() > 0)
    {
      this.B.a((List)localObject1, this.aj, this.ay);
      return;
    }
    if (new File(this.U).exists())
    {
      ((List)localObject1).clear();
      g();
      return;
    }
    localIVasQuickUpdateService.downloadItem(1000L, "pendant_market_json.android.v2", "pendant_market");
  }
  
  private void q()
  {
    this.y = super.findViewById(2131447534);
    this.x = super.findViewById(2131429638);
    this.z = super.findViewById(2131449055);
    View localView = super.findViewById(2131442461);
    this.C = ((ImageView)super.findViewById(2131449056));
    this.A = ((XListView)super.findViewById(2131439943));
    this.D = ((AvatarLayout)findViewById(2131449054));
    this.E = ((DynamicAvatarView)super.findViewById(2131429335));
    this.F = ((ImageView)super.findViewById(2131449060));
    this.G = super.findViewById(2131449059);
    this.H = ((TipsBar)super.findViewById(2131447420));
    this.X = ((LinearLayout)super.findViewById(2131445239));
    this.Y = ((Button)super.findViewById(2131445240));
    this.Z = ((TextView)super.findViewById(2131439958));
    this.aa = ((TextView)findViewById(2131432765));
    this.I = ((ImageView)super.findViewById(2131429336));
    this.am = ((Button)super.findViewById(2131445234));
    this.aE = ((Button)super.findViewById(2131445232));
    this.aF = ((ProgressBar)super.findViewById(2131437622));
    this.aD = super.findViewById(2131437648);
    this.D.a(0, this.E, false);
    this.z.addOnLayoutChangeListener(this);
    this.D.setOnClickListener(this);
    this.Y.setOnClickListener(this);
    this.am.setOnClickListener(this);
    this.aE.setOnClickListener(this);
    findViewById(2131436188).setOnClickListener(this);
    Object localObject1 = (TextView)findViewById(2131432764);
    ((TextView)localObject1).setOnClickListener(this);
    this.ab = new RedTouch(this, (View)localObject1).c(53).a();
    u();
    localObject1 = (TextView)super.findViewById(2131436180);
    ((TextView)localObject1).setText("");
    ((TextView)localObject1).setOnClickListener(this);
    localObject1 = (TextView)super.findViewById(2131436227);
    ((TextView)localObject1).setText(" ");
    ((TextView)localObject1).setFocusable(true);
    ((TextView)localObject1).setFocusableInTouchMode(true);
    ((TextView)localObject1).setClickable(true);
    ((TextView)localObject1).setContentDescription(" ");
    localObject1 = (RelativeLayout)super.findViewById(2131447534);
    localObject1 = getWindowManager().getDefaultDisplay();
    int i1 = ((Display)localObject1).getHeight();
    int i2 = ((Display)localObject1).getWidth();
    double d1 = i1;
    double d2 = i2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    double d3 = d1;
    if (Build.VERSION.SDK_INT >= 24)
    {
      d3 = d1;
      if (!isInMultiWindowMode())
      {
        d3 = d1;
        if (!isInPictureInPictureMode())
        {
          d3 = d1;
          if (d1 < 1.5D) {
            d3 = 1.5D;
          }
        }
      }
    }
    this.f = (i1 - a());
    this.e = a;
    d1 = (d3 - 1.78D) * 2.0D;
    d2 = (d3 - d1) * 0.58D / 1.8D;
    d1 = (1.85D - d1) * 0.38D / d3;
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      d1 = d3 - 1.67D;
      a();
      i2 = super.getResources().getDimensionPixelSize(2131299920);
      localObject2 = (RelativeLayout)super.findViewById(2131449043);
      localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      localLayoutParams.topMargin = (i2 / 2 + 14 - (int)(Math.abs(d1) * 24.0D));
      ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams);
      d1 *= 2.0D;
      d2 = (d1 + 1.8D) * 0.58D / d3;
      d1 = (d1 + 1.95D) * 0.38D / d3;
    }
    if (d3 < 1.2D)
    {
      this.f = i1;
      d2 = 1.0D;
      d1 = d2;
    }
    i1 = this.f;
    d3 = i1;
    Double.isNaN(d3);
    this.g = ((int)(d3 * d2));
    d3 = i1;
    Double.isNaN(d3);
    this.h = ((int)(d3 * d1));
    if (!this.u)
    {
      super.findViewById(2131449047).setVisibility(8);
      this.H.setVisibility(0);
      this.H.setTipsText("没有SD卡无法使用头像挂件");
      this.H.a(false);
      i1 = this.f;
      d3 = i1;
      Double.isNaN(d3);
      this.g = ((int)(d3 * (d2 + 0.06D)));
      d2 = i1;
      Double.isNaN(d2);
      this.h = ((int)(d2 * d1));
      this.t = true;
    }
    else if (this.v)
    {
      super.findViewById(2131449047).setVisibility(8);
      this.H.setVisibility(0);
      this.H.setTipsText(HardCodeUtil.a(2131899122));
      this.H.a(false);
      i1 = this.f;
      d3 = i1;
      Double.isNaN(d3);
      this.g = ((int)(d3 * (d2 + 0.06D)));
      d2 = i1;
      Double.isNaN(d2);
      this.h = ((int)(d2 * d1));
      this.t = true;
    }
    else
    {
      this.H.setVisibility(8);
      this.B = new AvatarPendantAdapter(this, this, this, ((Display)localObject1).getWidth(), this.app, this.L.uin, this.g - this.h);
      this.A.setAdapter(this.B);
    }
    i1 = this.g;
    d1 = i1;
    Double.isNaN(d1);
    this.i = ((int)(d1 * 0.383D));
    i2 = this.i;
    this.k = ((int)(i2 * 186.05F / 150.0F));
    int i3 = this.k;
    this.m = ((int)(i3 * 222.05F / 186.0F));
    this.o = ((i3 - i2) / 2);
    int i4 = this.h;
    this.q = ((i4 + 0.05F) / i1);
    this.q -= 0.24D;
    d2 = i2;
    d1 = this.q;
    Double.isNaN(d2);
    this.j = ((int)(d2 * d1));
    d2 = i3;
    Double.isNaN(d2);
    this.l = ((int)(d2 * d1));
    d2 = this.m;
    Double.isNaN(d2);
    this.n = ((int)(d2 * d1));
    d2 = this.o;
    Double.isNaN(d2);
    this.p = ((int)(d2 * d1));
    this.r = ((i2 - this.j + 0.05F) / (i1 - i4));
    localObject1 = (FrameLayout.LayoutParams)this.A.getLayoutParams();
    Object localObject2 = (FrameLayout.LayoutParams)this.z.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject1).topMargin = this.h;
    ((FrameLayout.LayoutParams)localObject2).height = this.g;
    this.A.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.z.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (RelativeLayout.LayoutParams)this.D.getLayoutParams();
    localObject2 = (RelativeLayout.LayoutParams)this.F.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.G.getLayoutParams();
    i1 = this.i;
    ((RelativeLayout.LayoutParams)localObject1).width = i1;
    ((RelativeLayout.LayoutParams)localObject1).height = i1;
    ((RelativeLayout.LayoutParams)localObject2).width = this.k;
    ((RelativeLayout.LayoutParams)localObject2).height = this.m;
    localLayoutParams.height = this.o;
    this.D.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.G.setLayoutParams(localLayoutParams);
    this.F.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ThreadManager.excute(new AvatarPendantActivity.4(this), 32, null, false);
    y();
    if (ThemeUtil.isInNightMode(this.app))
    {
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  private boolean r()
  {
    Object localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    boolean bool = ((SharedPreferences)localObject).getBoolean("had_show_pendant_tips", false);
    if (!bool)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("had_show_pendant_tips", true);
      ((SharedPreferences.Editor)localObject).commit();
    }
    return bool;
  }
  
  private boolean s()
  {
    return this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("had_entered_store_face", false);
  }
  
  private void t()
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("had_entered_store_face", true);
    localEditor.commit();
  }
  
  private void u()
  {
    ThreadManager.post(new AvatarPendantActivity.6(this), 5, null, true);
  }
  
  private void v()
  {
    int i1 = this.e;
    if (i1 != a)
    {
      if (i1 == d) {
        return;
      }
      if (Build.VERSION.SDK_INT < 14) {
        return;
      }
      Object localObject1 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.z.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.D.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.F.getLayoutParams();
      Object localObject2 = (RelativeLayout.LayoutParams)this.G.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height = this.o;
      this.G.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new AvatarPendantActivity.AnimRect();
      AvatarPendantActivity.AnimRect localAnimRect1 = new AvatarPendantActivity.AnimRect();
      AvatarPendantActivity.AnimRect localAnimRect2 = new AvatarPendantActivity.AnimRect();
      new AvatarPendantActivity.AnimRect();
      ((AvatarPendantActivity.AnimRect)localObject2).c = localLayoutParams.height;
      ((AvatarPendantActivity.AnimRect)localObject2).d = this.g;
      i1 = localLayoutParams.topMargin;
      ((AvatarPendantActivity.AnimRect)localObject2).b = i1;
      ((AvatarPendantActivity.AnimRect)localObject2).a = i1;
      double d1 = Math.abs(this.g - localLayoutParams.height);
      Double.isNaN(d1);
      double d2 = this.g;
      Double.isNaN(d2);
      d1 = d1 * 1.0D / d2;
      d2 = ((AvatarPendantActivity.AnimRect)localObject2).g;
      Double.isNaN(d2);
      ((AvatarPendantActivity.AnimRect)localObject2).g = ((int)(d1 * d2));
      i1 = localLayoutParams1.topMargin;
      localAnimRect1.b = i1;
      localAnimRect1.a = i1;
      localAnimRect1.e = localLayoutParams1.width;
      localAnimRect1.f = this.i;
      localAnimRect1.c = localLayoutParams1.height;
      localAnimRect1.d = this.i;
      localAnimRect1.g = ((AvatarPendantActivity.AnimRect)localObject2).g;
      i1 = localLayoutParams2.topMargin;
      localAnimRect2.b = i1;
      localAnimRect2.a = i1;
      localAnimRect2.e = localLayoutParams2.width;
      localAnimRect2.f = this.k;
      localAnimRect2.c = localLayoutParams2.height;
      localAnimRect2.d = this.m;
      localAnimRect2.g = ((AvatarPendantActivity.AnimRect)localObject2).g;
      localArrayList.add(this.z);
      localArrayList.add(this.D);
      localArrayList.add(this.F);
      ((List)localObject1).add(localObject2);
      ((List)localObject1).add(localAnimRect1);
      ((List)localObject1).add(localAnimRect2);
      if (((AvatarPendantActivity.AnimRect)localObject2).g <= 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("heigth: ");
        ((StringBuilder)localObject1).append(this.g);
        ((StringBuilder)localObject1).append(" palytime: ");
        ((StringBuilder)localObject1).append(((AvatarPendantActivity.AnimRect)localObject2).g);
        QLog.e("AvatarPendantActivity", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      a(localArrayList, (List)localObject1, ((AvatarPendantActivity.AnimRect)localObject2).g);
    }
  }
  
  private void w()
  {
    ThreadManager.getFileThreadHandler().post(new AvatarPendantActivity.11(this));
  }
  
  private void x()
  {
    if (!ProfilePAUtils.isPaTypeHasUin(this.L))
    {
      this.F.setVisibility(4);
      return;
    }
    Object localObject = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(this.L.uin);
    long l1;
    if (localObject != null) {
      l1 = ((ExtensionInfo)localObject).pendantId;
    } else {
      l1 = this.Q;
    }
    long l2;
    if (localObject != null) {
      l2 = ((ExtensionInfo)localObject).pendantDiyId;
    } else {
      l2 = this.R;
    }
    long l3 = this.N;
    int i1 = 8;
    if ((l3 != -1L) && (this.Q == l1) && (this.R == l2))
    {
      localObject = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      this.F.setVisibility(0);
      if (AvatarPendantUtil.a(this.N)) {
        ((AvatarPendantManager)localObject).a(this.N).a(this.F, 2, PendantInfo.j);
      } else {
        ((AvatarPendantManager)localObject).a(this.N).a(this.F, 5, PendantInfo.j);
      }
    }
    else if ((localObject != null) && (((ExtensionInfo)localObject).isPendantValid()))
    {
      this.Q = ((ExtensionInfo)localObject).pendantId;
      this.R = ((ExtensionInfo)localObject).pendantDiyId;
      AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      this.F.setVisibility(0);
      if (AvatarPendantUtil.a(((ExtensionInfo)localObject).pendantId)) {
        localAvatarPendantManager.a(((ExtensionInfo)localObject).pendantId).a(this.F, 2, PendantInfo.j, this.app.getCurrentAccountUin(), ((ExtensionInfo)localObject).pendantDiyId);
      } else {
        localAvatarPendantManager.a(((ExtensionInfo)localObject).pendantId).a(this.F, 5, PendantInfo.j, this.app.getCurrentAccountUin(), ((ExtensionInfo)localObject).pendantDiyId);
      }
      this.Y.setEnabled(false);
      this.Y.setText(2131916326);
      ReportController.b(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "1", "", "", "");
    }
    else
    {
      this.F.setVisibility(4);
      this.X.setVisibility(8);
      A();
      ReportController.b(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "0", "", "", "");
    }
    localObject = this.Z;
    if (!r()) {
      i1 = 0;
    }
    ((TextView)localObject).setVisibility(i1);
  }
  
  private void y()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AvatarPendantUtil.e);
    ((StringBuilder)localObject).append("/widget_display_bg.jpg");
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists())
    {
      ColorDrawable localColorDrawable = new ColorDrawable(-16741938);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.z.getWidth();
      localURLDrawableOptions.mRequestHeight = this.z.getHeight();
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localObject = URLDrawable.getDrawable((File)localObject, localURLDrawableOptions);
      this.C.setImageDrawable((Drawable)localObject);
    }
    this.C.setOnClickListener(this);
  }
  
  private void z()
  {
    Object localObject = this.A;
    if (localObject == null) {
      return;
    }
    localObject = (ViewGroup.MarginLayoutParams)((XListView)localObject).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = av;
    this.A.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public int a()
  {
    Object localObject1 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int i1 = ((Rect)localObject1).top;
    if (i1 == 0) {
      try
      {
        localObject1 = Class.forName("com.android.internal.R$dimen");
        Object localObject2 = ((Class)localObject1).newInstance();
        int i2 = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
        i2 = super.getResources().getDimensionPixelSize(i2);
        return i2;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
        return i1;
      }
      catch (SecurityException localSecurityException)
      {
        localSecurityException.printStackTrace();
        return i1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        return i1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return i1;
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
        return i1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        return i1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
      }
    }
    return i1;
  }
  
  public void a(TextView paramTextView, View paramView)
  {
    int i2 = getWindowManager().getDefaultDisplay().getWidth();
    int i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i4 = View.MeasureSpec.makeMeasureSpec(0, 0);
    paramTextView.measure(i3, i4);
    int i1 = paramTextView.getMeasuredWidth();
    paramView.measure(i3, i4);
    i3 = paramView.getMeasuredWidth();
    float f1 = super.getResources().getDisplayMetrics().density;
    i2 = i2 - i3 - (int)(55 * f1 + 0.5F);
    if (i1 > i2)
    {
      paramTextView.setMaxWidth(i2 - 10);
      paramTextView.setSingleLine(true);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
  }
  
  public void a(PendantTipsInfo paramPendantTipsInfo, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verifyAuth, tipsInfo = ");
      ((StringBuilder)localObject).append(paramPendantTipsInfo);
      ((StringBuilder)localObject).append("result = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
    }
    int i1 = paramPendantTipsInfo.type;
    boolean bool = NetworkUtil.isNetSupport(this);
    if (bool) {
      localObject = "4";
    } else {
      localObject = "3";
    }
    String str = "2";
    if (i1 != 1) {
      if (i1 != 2) {
        if (i1 == 3) {
          a(paramPendantTipsInfo, false, paramInt);
        }
      }
    }
    for (;;)
    {
      break;
      if (TextUtils.isEmpty(paramPendantTipsInfo.wording))
      {
        QLog.e("AvatarPendantActivity", 1, "verifyAuth, tipsInfo.wording is empty! type = JUMP_URL");
        QQToast.makeText(this, 1, HardCodeUtil.a(2131899109), 0).show(getTitleBarHeight());
        return;
      }
      paramPendantTipsInfo = DialogUtil.a(this, 230).setTitle(paramPendantTipsInfo.titleWording).setMessage(paramPendantTipsInfo.wording).setPositiveButton(paramPendantTipsInfo.rightBtnWording, new AvatarPendantActivity.23(this, paramPendantTipsInfo, paramInt)).setNegativeButton(paramPendantTipsInfo.leftBtnWording, new AvatarPendantActivity.22(this));
      localObject = paramPendantTipsInfo.getMessageTextView();
      ViewGroup.LayoutParams localLayoutParams = ((TextView)localObject).getLayoutParams();
      localLayoutParams.width = -1;
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      ((TextView)localObject).setGravity(17);
      paramPendantTipsInfo.setMessageCount(null);
      paramPendantTipsInfo.show();
      localObject = "2";
      break;
      if (TextUtils.isEmpty(paramPendantTipsInfo.wording))
      {
        QLog.e("AvatarPendantActivity", 1, "verifyAuth, tipsInfo.wording is empty! type = PAYMENT");
        QQToast.makeText(this, 1, HardCodeUtil.a(2131899113), 0).show(getTitleBarHeight());
        return;
      }
      if (paramPendantTipsInfo.vipType.equals("LTMCLUB")) {
        localObject = "0";
      } else if (paramPendantTipsInfo.equals("CJCLUBT")) {
        localObject = "1";
      }
      if (!isFinishing()) {
        DialogUtil.a(this, 230).setTitle(paramPendantTipsInfo.titleWording).setMessage(paramPendantTipsInfo.wording).setPositiveButton(paramPendantTipsInfo.rightBtnWording, new AvatarPendantActivity.21(this, paramPendantTipsInfo, paramInt)).setNegativeButton(paramPendantTipsInfo.leftBtnWording, new AvatarPendantActivity.20(this)).show();
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8005FD8", "0X8005FD8", 0, 0, "", "", "", "");
    }
    if (paramLong != 0L)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8005FD7", "0X8005FD7", 0, 0, (String)localObject, "", "", "");
      return;
    }
    Object localObject = this.app;
    if (bool) {
      paramPendantTipsInfo = str;
    } else {
      paramPendantTipsInfo = "1";
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8006896", "0X8006896", 0, 0, paramPendantTipsInfo, "", "", "");
  }
  
  public void a(PendantTipsInfo paramPendantTipsInfo, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openVIP, tipsInfo = ");
      ((StringBuilder)localObject).append(paramPendantTipsInfo);
      QLog.i("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramPendantTipsInfo.type == 1)
    {
      String str1;
      if (paramBoolean)
      {
        str1 = "mvip.gxh.android.faceaddon_nati_dft";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mvip.gxh.android.faceaddon_nati_");
        ((StringBuilder)localObject).append(this.N);
        str1 = ((StringBuilder)localObject).toString();
      }
      String str2 = paramPendantTipsInfo.vipType;
      if (str2.equals("LTMCLUB")) {
        localObject = getString(2131892806);
      }
      for (;;)
      {
        break;
        if (str2.equals("CJCLUBT"))
        {
          localObject = getString(2131916948);
        }
        else
        {
          if (!str2.equals("SVHHZLH")) {
            break label306;
          }
          localObject = getString(2131887547);
        }
      }
      if ((paramPendantTipsInfo.vipMonth >= 1) && (paramPendantTipsInfo.vipMonth <= 12))
      {
        boolean bool = false;
        if (((paramInt == 9002) || (paramInt == 9003)) && (paramPendantTipsInfo.vipMonth == 12))
        {
          if (paramInt == 9003) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          bool = true;
        }
        else
        {
          paramBoolean = false;
        }
        VasH5PayUtil.a(this, str1, paramPendantTipsInfo.vipMonth, "1450000515", str2, (String)localObject, "", bool, paramBoolean);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openVIP, vipMonth invalid = ");
      ((StringBuilder)localObject).append(paramPendantTipsInfo.vipMonth);
      QLog.e("AvatarPendantActivity", 1, ((StringBuilder)localObject).toString());
      return;
      label306:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openVIP, unknown vipType = ");
      ((StringBuilder)localObject).append(paramPendantTipsInfo.vipType);
      QLog.e("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if ((paramPendantTipsInfo.type != 2) && (paramPendantTipsInfo.type != 3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openVIP, action type is incorrect! tipsInfo = ");
      ((StringBuilder)localObject).append(paramPendantTipsInfo);
      QLog.e("AvatarPendantActivity", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (!TextUtils.isEmpty(paramPendantTipsInfo.url))
    {
      localObject = new Intent(this, QQBrowserActivity.class);
      VasWebviewUtil.b(this, paramPendantTipsInfo.url, -1L, (Intent)localObject, true, -1);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openVIP, type = jump_url, but url == nul. tipsInfo = ");
    ((StringBuilder)localObject).append(paramPendantTipsInfo);
    QLog.e("AvatarPendantActivity", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(String paramString)
  {
    SystemClock.uptimeMillis();
    paramString = new File(paramString);
    AvatarPendantUtil.a();
    if (paramString.exists()) {}
    for (;;)
    {
      int i1;
      int i2;
      int i3;
      try
      {
        Object localObject1 = FileUtils.readFileToString(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramString = new ArrayList();
          try
          {
            localObject1 = new JSONObject((String)localObject1);
            JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("avatarInPendantTable");
            i1 = 0;
            i2 = 0;
            if (i1 < localJSONArray.length())
            {
              AvatarInPendantHeadportraitInfo localAvatarInPendantHeadportraitInfo = new AvatarInPendantHeadportraitInfo();
              Object localObject2 = localJSONArray.optJSONObject(i1);
              i3 = ((JSONObject)localObject2).optInt("id");
              String str = ((JSONObject)localObject2).optString("type");
              Object localObject3 = ((JSONObject)localObject2).optJSONArray("baseInfo").optJSONObject(0);
              localObject2 = ((JSONObject)localObject3).getString("name");
              localObject3 = ((JSONObject)localObject3).optJSONObject("smallImg").optString("src");
              localAvatarInPendantHeadportraitInfo.a(i3);
              localAvatarInPendantHeadportraitInfo.b((String)localObject2);
              localAvatarInPendantHeadportraitInfo.a(str);
              localAvatarInPendantHeadportraitInfo.c((String)localObject3);
              i3 = i2;
              if (i2 < 8)
              {
                paramString.add(localAvatarInPendantHeadportraitInfo);
                i3 = i2 + 1;
              }
              if (i1 >= 4) {
                break label344;
              }
              localAvatarInPendantHeadportraitInfo.e = true;
              break label344;
            }
            localObject1 = ((JSONObject)localObject1).optJSONArray("avatarInPendantCount");
            if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
              AvatarPendantManager.i = ((JSONArray)localObject1).optJSONObject(0).optInt("count");
            }
            localObject1 = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
            if (localObject1 == null) {
              break label343;
            }
            ((AvatarPendantManager)localObject1).a(paramString);
            this.aj = paramString;
            this.M.sendEmptyMessage(1000);
            return;
          }
          catch (Exception paramString)
          {
            if (!QLog.isColorLevel()) {
              break label343;
            }
          }
          QLog.e("AvatarPendantActivity", 2, "parse facedata shop config fail", paramString);
          return;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AvatarPendantActivity", 2, "read config fail", paramString);
        }
      }
      label343:
      return;
      label344:
      if (i3 != 8)
      {
        i1 += 1;
        i2 = i3;
      }
    }
  }
  
  public void b()
  {
    this.A.setOnScrollListener(new AvatarPendantActivity.7(this));
  }
  
  public void b(String paramString)
  {
    String str = "tag";
    long l1 = SystemClock.uptimeMillis();
    paramString = new File(paramString);
    AvatarPendantUtil.a();
    boolean bool = paramString.exists();
    Object localObject1 = "AvatarPendantActivity";
    if (bool) {}
    for (;;)
    {
      Object localObject2;
      int i2;
      int i1;
      int i3;
      try
      {
        localObject2 = FileUtils.readFileToString(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          List localList = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).f();
          try
          {
            JSONObject localJSONObject1 = new JSONObject((String)localObject2);
            if (localJSONObject1.has("rareAct"))
            {
              if (localJSONObject1.getInt("rareAct") != 1) {
                break label1589;
              }
              bool = true;
              AvatarPendantManager.h = bool;
            }
            else
            {
              AvatarPendantManager.h = false;
            }
            Object localObject4 = localJSONObject1.getJSONObject("hotTagInfo");
            Object localObject7 = new HashSet();
            bool = ((JSONObject)localObject4).has("newIdList");
            if (!bool) {
              break label1602;
            }
            localObject2 = ((JSONObject)localObject4).getString("newIdList");
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1602;
            }
            Object localObject5 = ((String)localObject2).split(",");
            i2 = localObject5.length;
            i1 = 0;
            if (i1 < i2)
            {
              localObject6 = localObject5[i1];
              localObject3 = paramString;
              localObject2 = localObject1;
            }
            try
            {
              if (TextUtils.isEmpty((CharSequence)localObject6)) {
                break label1595;
              }
              localObject3 = paramString;
              localObject2 = localObject1;
              ((HashSet)localObject7).add(Integer.valueOf((String)localObject6));
            }
            catch (Exception localException3)
            {
              HashSet localHashSet1;
              HashSet localHashSet2;
              paramString = (String)localObject3;
              localObject1 = localObject2;
              continue;
            }
            localObject3 = paramString;
            localObject2 = localObject1;
            localHashSet1 = new HashSet();
            localObject3 = paramString;
            localObject2 = localObject1;
            if (((JSONObject)localObject4).has("hotIdList"))
            {
              localObject3 = paramString;
              localObject2 = localObject1;
              localObject5 = ((JSONObject)localObject4).getString("hotIdList");
              localObject3 = paramString;
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject5))
              {
                localObject3 = paramString;
                localObject2 = localObject1;
                localObject5 = ((String)localObject5).split(",");
                localObject3 = paramString;
                localObject2 = localObject1;
                i2 = localObject5.length;
                i1 = 0;
                if (i1 < i2)
                {
                  localObject6 = localObject5[i1];
                  localObject3 = paramString;
                  localObject2 = localObject1;
                  if (TextUtils.isEmpty((CharSequence)localObject6)) {
                    break label1605;
                  }
                  localObject3 = paramString;
                  localObject2 = localObject1;
                  localHashSet1.add(Integer.valueOf((String)localObject6));
                  break label1605;
                }
              }
            }
            localObject3 = paramString;
            localObject2 = localObject1;
            localHashSet2 = new HashSet();
            localObject3 = paramString;
            localObject2 = localObject1;
            if (((JSONObject)localObject4).has("finalIdList"))
            {
              localObject3 = paramString;
              localObject2 = localObject1;
              localObject4 = ((JSONObject)localObject4).getString("finalIdList");
              localObject3 = paramString;
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject4))
              {
                localObject3 = paramString;
                localObject2 = localObject1;
                localObject4 = ((String)localObject4).split(",");
                localObject3 = paramString;
                localObject2 = localObject1;
                i2 = localObject4.length;
                i1 = 0;
                if (i1 < i2)
                {
                  localObject5 = localObject4[i1];
                  localObject3 = paramString;
                  localObject2 = localObject1;
                  if (TextUtils.isEmpty((CharSequence)localObject5)) {
                    break label1612;
                  }
                  localObject3 = paramString;
                  localObject2 = localObject1;
                  localHashSet2.add(Integer.valueOf((String)localObject5));
                  break label1612;
                }
              }
            }
            localObject3 = paramString;
            localObject2 = localObject1;
            Object localObject6 = new SparseArray();
            localObject3 = paramString;
            localObject2 = localObject1;
            localObject4 = localJSONObject1.getJSONObject("detailList");
            localObject3 = paramString;
            localObject2 = localObject1;
            localObject5 = ((JSONObject)localObject4).keys();
            localObject3 = paramString;
            localObject2 = localObject1;
            bool = ((Iterator)localObject5).hasNext();
            if (bool) {}
            try
            {
              localObject2 = ((Iterator)localObject5).next().toString();
              if (localObject2 == null) {
                break label1628;
              }
              localObject3 = ((JSONObject)localObject4).getJSONObject((String)localObject2);
              JSONObject localJSONObject2 = ((JSONObject)localObject3).getJSONObject("operationInfo");
              if ((localJSONObject2.getInt("isShow") == 0) || (AppSetting.b(localJSONObject2.getString("minVersion")) < 0)) {
                break label1619;
              }
              localObject2 = new AvatarPendantShopItemInfo();
              ((AvatarPendantShopItemInfo)localObject2).g = localJSONObject2.getInt("feeType");
              ((AvatarPendantShopItemInfo)localObject2).h = localJSONObject2.getInt("limitFree");
              ((AvatarPendantShopItemInfo)localObject2).i = localJSONObject2.getLong("limitFreeBegin");
              ((AvatarPendantShopItemInfo)localObject2).j = localJSONObject2.getLong("limitFreeEnd");
              localObject3 = ((JSONObject)localObject3).getJSONObject("baseInfo");
              ((AvatarPendantShopItemInfo)localObject2).b = ((JSONObject)localObject3).getInt("type");
              ((AvatarPendantShopItemInfo)localObject2).c = ((JSONObject)localObject3).getString("name");
              ((AvatarPendantShopItemInfo)localObject2).f = ((JSONObject)localObject3).getString("listPng");
              ((AvatarPendantShopItemInfo)localObject2).a = Integer.valueOf(((JSONObject)localObject3).getString("id")).intValue();
              if (((JSONObject)localObject3).getInt("isLink") != 1) {
                break label1622;
              }
              bool = true;
              ((AvatarPendantShopItemInfo)localObject2).d = bool;
              ((AvatarPendantShopItemInfo)localObject2).e = ((JSONObject)localObject3).getString("defaultHead");
              if (((HashSet)localObject7).contains(Integer.valueOf(((AvatarPendantShopItemInfo)localObject2).a))) {
                ((AvatarPendantShopItemInfo)localObject2).k = 7;
              } else if (localHashSet1.contains(Integer.valueOf(((AvatarPendantShopItemInfo)localObject2).a))) {
                ((AvatarPendantShopItemInfo)localObject2).k = 8;
              }
              l2 = NetConnInfoCenter.getServerTimeMillis();
              if ((((AvatarPendantShopItemInfo)localObject2).g == 1) && (((AvatarPendantShopItemInfo)localObject2).i <= l2) && (l2 <= ((AvatarPendantShopItemInfo)localObject2).j)) {
                ((AvatarPendantShopItemInfo)localObject2).l = 10;
              } else if (((AvatarPendantShopItemInfo)localObject2).g == 6) {
                ((AvatarPendantShopItemInfo)localObject2).l = 6;
              }
              if (localHashSet2.contains(Integer.valueOf(((AvatarPendantShopItemInfo)localObject2).a))) {
                ((AvatarPendantShopItemInfo)localObject2).l = 9;
              }
              ((SparseArray)localObject6).put(((AvatarPendantShopItemInfo)localObject2).a, localObject2);
            }
            catch (Exception localException2)
            {
              int i4;
              continue;
            }
            localList.clear();
            localObject2 = localJSONObject1.getJSONArray("recommendList");
            i1 = ((JSONArray)localObject2).length();
            i2 = 0;
            if (i2 < i1)
            {
              localObject4 = (JSONObject)((JSONArray)localObject2).get(i2);
              if (((JSONObject)localObject4).getInt("isShow") == 0) {
                break label1631;
              }
              localObject3 = ((JSONObject)localObject4).getString("idList");
              if ((TextUtils.isEmpty((CharSequence)localObject3)) || (((JSONObject)localObject4).getInt("seriesID") >= 100)) {
                break label1631;
              }
              localObject5 = new AvatarPendantShopSeriesInfo();
              ((AvatarPendantShopSeriesInfo)localObject5).h = new ArrayList();
              localObject3 = ((String)localObject3).split(",");
              i4 = localObject3.length;
              i3 = 0;
              if (i3 < i4)
              {
                localObject7 = localObject3[i3];
                if (TextUtils.isEmpty((CharSequence)localObject7)) {
                  break label1634;
                }
                localObject7 = (AvatarPendantShopItemInfo)((SparseArray)localObject6).get(Integer.valueOf((String)localObject7).intValue());
                if (localObject7 == null) {
                  break label1634;
                }
                ((AvatarPendantShopSeriesInfo)localObject5).h.add(localObject7);
                break label1634;
              }
              if (((AvatarPendantShopSeriesInfo)localObject5).h.size() <= 0) {
                break label1631;
              }
              ((AvatarPendantShopSeriesInfo)localObject5).a = ((JSONObject)localObject4).getInt("seriesID");
              ((AvatarPendantShopSeriesInfo)localObject5).d = ((JSONObject)localObject4).getString("cornerMark");
              localObject3 = str;
              if (!TextUtils.isEmpty(((JSONObject)localObject4).getString((String)localObject3))) {
                ((AvatarPendantShopSeriesInfo)localObject5).e = Integer.valueOf(((JSONObject)localObject4).getString((String)localObject3)).intValue();
              } else {
                ((AvatarPendantShopSeriesInfo)localObject5).e = 0;
              }
              ((AvatarPendantShopSeriesInfo)localObject5).f = ((JSONObject)localObject4).getString("defaultHead");
              ((AvatarPendantShopSeriesInfo)localObject5).g = ((JSONObject)localObject4).getString("tpl");
              ((AvatarPendantShopSeriesInfo)localObject5).c = ((JSONObject)localObject4).getString("subtitle");
              ((AvatarPendantShopSeriesInfo)localObject5).b = ((JSONObject)localObject4).getString("name");
              ((AvatarPendantShopSeriesInfo)localObject5).j = -1;
              if ((((AvatarPendantShopSeriesInfo)localObject5).g == null) || (((AvatarPendantShopSeriesInfo)localObject5).g.equals(""))) {
                break label1643;
              }
              ((AvatarPendantShopSeriesInfo)localObject5).i = true;
              localList.add(localObject5);
              break label1646;
            }
            PendantMarketConfig.a(localJSONObject1);
            try
            {
              this.M.sendEmptyMessage(1000);
              this.app.getApp().getSharedPreferences(ClubContentJsonTask.i, 0).edit().putBoolean(ClubContentJsonTask.i, false).commit();
              localObject3 = localObject1;
              localObject2 = paramString;
            }
            catch (Exception localException1) {}
            localList.clear();
          }
          catch (Exception localException4) {}
          paramString.delete();
          Object localObject3 = localObject1;
          localObject2 = paramString;
          if (QLog.isColorLevel())
          {
            QLog.e((String)localObject1, 2, "parse pendant shop config fail", localException4);
          }
          else
          {
            localObject1 = localObject3;
            paramString = (String)localObject2;
          }
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AvatarPendantActivity", 2, "read config fail", paramString);
        }
        return;
      }
      localObject1 = "AvatarPendantActivity";
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parse pendant shop config cost time:");
        ((StringBuilder)localObject2).append(l2 - l1);
        ((StringBuilder)localObject2).append(",file size:");
        ((StringBuilder)localObject2).append(paramString.length());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
      label1589:
      bool = false;
      continue;
      label1595:
      i1 += 1;
      continue;
      label1602:
      continue;
      label1605:
      i1 += 1;
      continue;
      label1612:
      i1 += 1;
      continue;
      label1619:
      continue;
      label1622:
      bool = false;
      continue;
      label1628:
      continue;
      label1631:
      break label1646;
      label1634:
      i3 += 1;
      continue;
      label1643:
      continue;
      label1646:
      i2 += 1;
    }
  }
  
  public int c()
  {
    Object localObject = this.A;
    int i1 = 0;
    localObject = ((XListView)localObject).getChildAt(0);
    if (localObject == null) {
      return 0;
    }
    int i2 = -((View)localObject).getTop();
    this.ap.put(this.A.getFirstVisiblePosition(), ((View)localObject).getHeight());
    while (i1 < this.A.getFirstVisiblePosition())
    {
      if (this.ap.get(i1) == 0) {
        this.t = true;
      } else {
        i2 += this.ap.get(i1);
      }
      i1 += 1;
    }
    return i2;
  }
  
  public void d()
  {
    int i1 = c();
    int i2 = i1 - this.s;
    this.s = i1;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.z.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.D.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.F.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.G.getLayoutParams();
    if ((i2 >= 0) || ((i2 <= 0) && (this.s <= this.g - this.h))) {
      localLayoutParams.height -= i2;
    }
    i1 = localLayoutParams.height;
    int i3 = this.h;
    if (i1 <= i3)
    {
      localLayoutParams.height = i3;
      i1 = this.j;
      localLayoutParams1.height = i1;
      localLayoutParams1.width = i1;
      localLayoutParams2.width = this.l;
      localLayoutParams2.height = this.n;
      localLayoutParams3.height = this.p;
      this.e = b;
    }
    else
    {
      i1 = localLayoutParams.height;
      i3 = this.g;
      if (i1 >= i3)
      {
        localLayoutParams.height = i3;
        i1 = this.i;
        localLayoutParams1.height = i1;
        localLayoutParams1.width = i1;
        localLayoutParams2.width = this.k;
        localLayoutParams2.height = this.m;
        localLayoutParams3.height = this.o;
        this.e = a;
      }
      else
      {
        this.e = c;
      }
    }
    if ((this.e == c) && ((i2 >= 0) || ((i2 <= 0) && (this.s <= this.g - this.h))))
    {
      i1 = i2;
      if (i2 != 0)
      {
        i1 = i2;
        if (i2 != 1) {
          if (i2 == -1)
          {
            i1 = i2;
          }
          else
          {
            double d1 = i2;
            double d2 = this.r;
            Double.isNaN(d1);
            i1 = (int)(d1 * d2);
          }
        }
      }
      localLayoutParams1.width -= i1;
      localLayoutParams1.height = localLayoutParams1.width;
      localLayoutParams2.width -= (int)(i1 * 186.05F / 150.0F);
      localLayoutParams2.height = ((int)(localLayoutParams2.width * 222.05F / 186.0F));
      localLayoutParams3.height = ((localLayoutParams2.width - localLayoutParams1.width) / 2);
    }
    this.z.setLayoutParams(localLayoutParams);
    this.D.setLayoutParams(localLayoutParams1);
    this.F.setLayoutParams(localLayoutParams2);
    this.G.setLayoutParams(localLayoutParams3);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  /* Error */
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 4
    //   3: iload_1
    //   4: iconst_4
    //   5: if_icmpne +254 -> 259
    //   8: aload_3
    //   9: ifnull +406 -> 415
    //   12: aload_3
    //   13: ldc_w 2000
    //   16: invokevirtual 615	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 7
    //   21: aload 7
    //   23: ifnull +235 -> 258
    //   26: aload 7
    //   28: ldc_w 2002
    //   31: invokevirtual 2005	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   34: ifne +4 -> 38
    //   37: return
    //   38: aload_3
    //   39: ldc_w 2007
    //   42: invokevirtual 615	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_3
    //   46: new 1721	org/json/JSONObject
    //   49: dup
    //   50: aload_3
    //   51: invokespecial 1722	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_3
    //   56: ldc_w 2009
    //   59: invokevirtual 1754	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: invokestatic 351	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   65: istore_1
    //   66: aload_3
    //   67: ldc_w 2011
    //   70: invokevirtual 1754	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   73: invokestatic 351	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   76: istore_2
    //   77: aload_3
    //   78: ldc_w 2013
    //   81: invokevirtual 1754	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic 351	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   87: istore 5
    //   89: iload 5
    //   91: istore 4
    //   93: goto +31 -> 124
    //   96: astore 6
    //   98: goto +21 -> 119
    //   101: astore 6
    //   103: goto +14 -> 117
    //   106: astore 6
    //   108: goto +7 -> 115
    //   111: astore 6
    //   113: aconst_null
    //   114: astore_3
    //   115: iconst_m1
    //   116: istore_1
    //   117: iconst_m1
    //   118: istore_2
    //   119: aload 6
    //   121: invokevirtual 2014	org/json/JSONException:printStackTrace	()V
    //   124: aload_3
    //   125: ifnull +290 -> 415
    //   128: iload_1
    //   129: ifne +286 -> 415
    //   132: iload_2
    //   133: ifne +282 -> 415
    //   136: iload 4
    //   138: ifne +277 -> 415
    //   141: aload_0
    //   142: getfield 2016	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:J	Lcom/tencent/mobileqq/app/UniPayHandler;
    //   145: astore_3
    //   146: aload_3
    //   147: ifnull +10 -> 157
    //   150: aload_3
    //   151: ldc_w 436
    //   154: invokevirtual 2019	com/tencent/mobileqq/app/UniPayHandler:a	(Ljava/lang/String;)V
    //   157: aload 7
    //   159: ldc_w 2021
    //   162: invokevirtual 1639	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq +42 -> 207
    //   168: aload_0
    //   169: getfield 432	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   172: ldc_w 434
    //   175: ldc_w 436
    //   178: ldc_w 436
    //   181: ldc_w 2023
    //   184: ldc_w 2023
    //   187: iconst_0
    //   188: iconst_0
    //   189: ldc_w 436
    //   192: ldc_w 436
    //   195: ldc_w 436
    //   198: ldc_w 436
    //   201: invokestatic 450	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   204: goto +48 -> 252
    //   207: aload_0
    //   208: getfield 432	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   211: ldc_w 434
    //   214: ldc_w 436
    //   217: ldc_w 436
    //   220: ldc_w 2023
    //   223: ldc_w 2023
    //   226: iconst_0
    //   227: iconst_0
    //   228: aload 7
    //   230: bipush 16
    //   232: aload 7
    //   234: invokevirtual 2024	java/lang/String:length	()I
    //   237: invokevirtual 2028	java/lang/String:substring	(II)Ljava/lang/String;
    //   240: ldc_w 436
    //   243: ldc_w 436
    //   246: ldc_w 436
    //   249: invokestatic 450	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload_0
    //   253: iconst_1
    //   254: putfield 189	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:ad	Z
    //   257: return
    //   258: return
    //   259: iload_1
    //   260: iconst_1
    //   261: if_icmpne +52 -> 313
    //   264: invokestatic 356	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +36 -> 303
    //   270: new 358	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 359	java/lang/StringBuilder:<init>	()V
    //   277: astore_3
    //   278: aload_3
    //   279: ldc_w 2030
    //   282: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_3
    //   287: iload_2
    //   288: invokevirtual 375	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: ldc_w 2032
    //   295: iconst_2
    //   296: aload_3
    //   297: invokevirtual 380	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 491	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: iload_2
    //   304: iconst_m1
    //   305: if_icmpne +110 -> 415
    //   308: aload_0
    //   309: invokespecial 622	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:w	()V
    //   312: return
    //   313: iload_2
    //   314: iconst_m1
    //   315: if_icmpne +100 -> 415
    //   318: iload_1
    //   319: iconst_5
    //   320: if_icmpeq +4 -> 324
    //   323: return
    //   324: aload_0
    //   325: aload_0
    //   326: getfield 2034	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:K	Landroid/net/Uri;
    //   329: invokestatic 2039	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   332: astore_3
    //   333: aload_0
    //   334: invokestatic 394	com/tencent/mobileqq/util/ProfileCardUtil:b	(Landroid/app/Activity;)I
    //   337: istore_1
    //   338: new 388	android/content/Intent
    //   341: dup
    //   342: invokespecial 389	android/content/Intent:<init>	()V
    //   345: astore 6
    //   347: aload 6
    //   349: ldc_w 402
    //   352: bipush 100
    //   354: invokevirtual 405	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   357: pop
    //   358: aload 6
    //   360: ldc_w 407
    //   363: bipush 100
    //   365: invokevirtual 405	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   368: pop
    //   369: aload 6
    //   371: ldc_w 413
    //   374: bipush 10
    //   376: invokevirtual 405	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   379: pop
    //   380: aload 6
    //   382: ldc_w 2041
    //   385: ldc_w 2043
    //   388: invokevirtual 2046	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   391: pop
    //   392: aload 6
    //   394: aload_0
    //   395: ldc 2
    //   397: invokevirtual 418	java/lang/Class:getName	()Ljava/lang/String;
    //   400: iload_1
    //   401: iload_1
    //   402: sipush 1080
    //   405: sipush 1080
    //   408: aload_3
    //   409: invokestatic 422	com/tencent/mobileqq/app/face/util/FaceUtil:a	()Ljava/lang/String;
    //   412: invokestatic 2050	com/tencent/mobileqq/activity/photo/PhotoUtils:startPhotoEdit	(Landroid/content/Intent;Landroid/app/Activity;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;)V
    //   415: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	AvatarPendantActivity
    //   0	416	1	paramInt1	int
    //   0	416	2	paramInt2	int
    //   0	416	3	paramIntent	Intent
    //   1	136	4	i1	int
    //   87	3	5	i2	int
    //   96	1	6	localJSONException1	org.json.JSONException
    //   101	1	6	localJSONException2	org.json.JSONException
    //   106	1	6	localJSONException3	org.json.JSONException
    //   111	9	6	localJSONException4	org.json.JSONException
    //   345	48	6	localIntent	Intent
    //   19	214	7	str	String
    // Exception table:
    //   from	to	target	type
    //   77	89	96	org/json/JSONException
    //   66	77	101	org/json/JSONException
    //   55	66	106	org/json/JSONException
    //   46	55	111	org/json/JSONException
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131628289);
    getWindow().setBackgroundDrawable(null);
    this.M = new Handler(ThreadManager.getFileThreadLooper(), this);
    this.al = ((ISVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER));
    paramBundle = super.getIntent();
    if (paramBundle.getParcelableExtra("AllInOne") != null)
    {
      this.L = ((AllInOne)paramBundle.getParcelableExtra("AllInOne"));
      boolean bool2 = paramBundle.getBooleanExtra("showActionSheet", false);
      e();
      this.J = ((UniPayHandler)this.app.getBusinessHandler(BusinessHandlerFactory.UNI_PAY_HANDLER));
      this.J.a(this.aq);
      super.addObserver(this.as);
      this.J.a("");
      if ((!NetworkUtil.isNetSupport(this)) && (QLog.isColorLevel())) {
        QLog.d("AvatarPendantActivity", 2, "net is not connected");
      }
      this.u = SystemUtil.a();
      if (SystemUtil.b() < 1024L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.v = bool1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.app.getApplication().getApplicationContext().getFilesDir());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("pendant_market.json");
      this.U = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.app.getApplication().getApplicationContext().getFilesDir());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("avatarInPendant.json");
      this.V = localStringBuilder.toString();
      q();
      boolean bool1 = ((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).enableCmshowAvatar();
      boolean bool3 = ((IApolloEngineHelper)QRoute.api(IApolloEngineHelper.class)).isEngineReady();
      ((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).runOnCrossEngineForMemePlayer();
      ((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).getCmshowAvatar3DSwitch();
      if ((bool1) && (bool3))
      {
        G();
        m();
        H();
        I();
        if (Build.VERSION.SDK_INT >= 21)
        {
          this.aJ = ((IApolloAvatarVideoProcessor)QRoute.api(IApolloAvatarVideoProcessor.class));
          this.aJ.init(this.app);
        }
        else
        {
          QLog.e("AvatarPendantActivity", 1, "new ApolloAvatarVideoProcessor failed due to sdk < 21");
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("new CmshowFace fail, enableCmshowAvatar: ");
        localStringBuilder.append(bool1);
        localStringBuilder.append(", isApolloEngineReady: ");
        localStringBuilder.append(bool3);
        QLog.e("AvatarPendantActivity", 1, localStringBuilder.toString());
      }
      o();
      if ((this.u) && (!this.v))
      {
        b();
        p();
      }
      else if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sdcard exist:");
        localStringBuilder.append(this.u);
        localStringBuilder.append(" sdcard full:");
        localStringBuilder.append(this.v);
        QLog.d("AvatarPendantActivity", 2, localStringBuilder.toString());
      }
      if (bool2) {
        f();
      }
      this.ao = getSharedPreferences("facechoosedata", 0).edit();
      this.ao.putInt("ChooseFaceId", 0);
      this.ao.apply();
      this.app.addObserver(this.aP);
      this.app.addObserver(this.aQ);
      this.app.registObserver(this.aO);
      this.app.addObserver(this.aN);
      this.an = IndividuationUrlHelper.a("vasClassProfileStoryUrl");
      if (paramBundle.getBooleanExtra("fromThirdApp", false)) {
        ThreadManager.getUIHandler().postDelayed(new AvatarPendantActivity.2(this), 500L);
      }
      addObserver(this.aM);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "AllinOne info is null");
    }
    finish();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.J;
    if (localObject != null) {
      ((UniPayHandler)localObject).b(this.aq);
    }
    if (this.app != null) {
      this.app.unRegistObserver(this.aO);
    }
    super.removeObserver(this.as);
    localObject = this.T;
    if (localObject != null) {
      ((AvatarPendantShopSeriesInfo)localObject).j = -1;
    }
    if ((this.app != null) && (this.N != 0L)) {
      ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.N).c();
    }
    localObject = this.B;
    if (localObject != null)
    {
      ((AvatarPendantAdapter)localObject).a();
      URLDrawable.resume();
    }
    if (this.app != null)
    {
      ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.at);
      this.app.removeObserver(this.aQ);
      this.app.removeObserver(this.aN);
      this.app.removeObserver(this.aP);
    }
    removeObserver(this.aM);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
    x();
  }
  
  protected void doOnPause()
  {
    AbstractGifImage.DoAccumulativeRunnable.DELAY = this.aI;
    ApngImage.pauseAll();
    AbstractVideoImage.pauseAll();
    ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).c();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ApngImage.playByTag(10);
    AbstractVideoImage.resumeAll();
    int i1 = 0;
    AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    G();
    VasWebviewUtil.a(this.app.getCurrentUin(), "widget", "head_show", "", 1, 0, 0, "", "", "");
    Object localObject = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
    if (localObject != null)
    {
      List localList = ((AvatarPendantManager)localObject).f();
      this.aj = ((AvatarPendantManager)localObject).g();
      if ((this.B != null) && (localList != null) && (localList.size() > 0)) {
        this.B.a(localList, this.aj, this.ay);
      }
    }
    localObject = this.aa;
    if (s()) {
      i1 = 8;
    }
    ((TextView)localObject).setVisibility(i1);
    x();
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public void e()
  {
    ImageView localImageView = (ImageView)super.findViewById(2131449048);
    TextView localTextView = (TextView)super.findViewById(2131449049);
    Button localButton = (Button)super.findViewById(2131449046);
    String str2 = this.app.getCurrentAccountUin();
    Object localObject1 = this.app.getApp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("uniPaySp_");
    ((StringBuilder)localObject2).append(str2);
    SharedPreferences localSharedPreferences = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    String str4 = localSharedPreferences.getString("sUin", "");
    int i1 = localSharedPreferences.getInt("isShowOpen", 0);
    int i2 = localSharedPreferences.getInt("iUinpPayType", 0);
    String str3 = super.getString(2131914353);
    Object localObject3 = "QQ会员";
    String str1 = "LTMCLUB";
    localObject1 = localObject3;
    localObject2 = str1;
    if (str4 != null)
    {
      localObject1 = localObject3;
      localObject2 = str1;
      if (str2 != null)
      {
        localObject1 = localObject3;
        localObject2 = str1;
        if (str4.equals(str2))
        {
          localObject1 = localObject3;
          localObject2 = str1;
          if (1 == i1)
          {
            localImageView.setVisibility(0);
            localTextView.setVisibility(0);
            localButton.setVisibility(0);
            switch (i2)
            {
            default: 
              localObject1 = localObject3;
              localObject2 = str1;
              break;
            case 9: 
              localButton.setText(2131890822);
              localTextView.setText(super.getString(2131887537, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130845024));
              localObject1 = localObject3;
              localObject2 = str1;
              break;
            case 8: 
              localButton.setText(2131890821);
              localTextView.setText(super.getString(2131887536, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130845024));
              localObject1 = localObject3;
              localObject2 = str1;
              break;
            case 7: 
              localButton.setText(2131890822);
              localTextView.setText(super.getString(2131887531, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844400));
              localObject1 = HardCodeUtil.a(2131899106);
              break;
            case 6: 
              localButton.setText(2131890822);
              localTextView.setText(super.getString(2131887535, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130845023));
              localObject1 = HardCodeUtil.a(2131899117);
              break;
            case 5: 
              localButton.setText(2131890821);
              localTextView.setText(super.getString(2131887534, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130845023));
              localObject1 = HardCodeUtil.a(2131899125);
              break;
            case 4: 
              localButton.setText(2131890821);
              localTextView.setText(super.getString(2131887530, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844400));
              localObject1 = HardCodeUtil.a(2131899108);
              break;
            case 3: 
              localButton.setText(2131890820);
              localTextView.setText(super.getString(2131887529, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843637));
              localObject1 = HardCodeUtil.a(2131899120);
              localObject2 = "CJCLUBT";
              break;
            case 2: 
              localButton.setText(2131890821);
              localTextView.setText(super.getString(2131887533, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130845022));
              localObject1 = localObject3;
              localObject2 = str1;
              break;
            }
            localButton.setText(2131890820);
            localTextView.setText(super.getString(2131887532, new Object[] { str3 }));
            localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843637));
            localObject2 = str1;
            localObject1 = localObject3;
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("UniPayUpdateListener back showTitleBtn isShowOpen:");
            ((StringBuilder)localObject3).append(i1);
            QLog.d("AvatarPendantActivity", 2, ((StringBuilder)localObject3).toString());
          }
          a(localTextView, localButton);
        }
      }
    }
    localButton.setOnClickListener(new AvatarPendantActivity.12(this, Integer.valueOf(localSharedPreferences.getString("open_month", "3")).intValue(), (String)localObject2, (String)localObject1));
  }
  
  public void f()
  {
    int i2 = SharedPreUtils.aG(this, this.app.getCurrentAccountUin());
    int i1;
    if ((i2 != -1) && (i2 != 2)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    Object localObject = (ActionSheet)ActionSheetHelper.b(this, null);
    String[] arrayOfString = super.getResources().getStringArray(2130968636);
    ArrayList localArrayList = new ArrayList();
    if (i1 != 0)
    {
      ((ActionSheet)localObject).addButton(arrayOfString[27]);
      localArrayList.add(Integer.valueOf(27));
    }
    else
    {
      ((ActionSheet)localObject).addButton(arrayOfString[23]);
      localArrayList.add(Integer.valueOf(23));
    }
    if (((DynamicAvatarManager)this.app.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).c())
    {
      ((ActionSheet)localObject).addButton(arrayOfString[22]);
      localArrayList.add(Integer.valueOf(22));
    }
    ((ActionSheet)localObject).addButton(arrayOfString[24]);
    localArrayList.add(Integer.valueOf(24));
    ((ActionSheet)localObject).addButton(arrayOfString[13]);
    localArrayList.add(Integer.valueOf(13));
    ((ActionSheet)localObject).addCancelButton(arrayOfString[16]);
    ((ActionSheet)localObject).setOnButtonClickListener(new AvatarPendantActivity.14(this, localArrayList, (ActionSheet)localObject));
    try
    {
      if (!isFinishing())
      {
        ((ActionSheet)localObject).show();
        localObject = ((ActionSheet)localObject).findViewById(0);
        if (localObject != null) {
          ((View)localObject).setContentDescription(HardCodeUtil.a(2131899115));
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showActionSheet, historyHeadNumFlag=");
      localStringBuilder.append(i2);
      QLog.d("AvatarPendantActivity", 2, localStringBuilder.toString());
    }
    ReportController.b(this.app, "dc00898", "", "", "0X800A8C8", "0X800A8C8", 0, 0, "", "", "", "");
  }
  
  public void g()
  {
    ThreadManager.getFileThreadHandler().post(new AvatarPendantActivity.ConfigParser(this.U, this));
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    DynamicAvatarRecordActivity.a(this, 1, 1);
    ReportController.b(this.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
  }
  
  public void h()
  {
    ThreadManager.getFileThreadHandler().post(new AvatarPendantActivity.ConfacefigParser(this.V, this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (isFinishing()) {
      return true;
    }
    if (paramMessage.what == 1000)
    {
      runOnUiThread(new AvatarPendantActivity.15(this, ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).f()));
      return true;
    }
    if (paramMessage.what == 1001) {
      runOnUiThread(new AvatarPendantActivity.16(this));
    }
    return true;
  }
  
  public boolean i()
  {
    if ((this.app != null) && (this.L != null))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(this.L.uin);
      if ((localExtensionInfo != null) && (localExtensionInfo.pendantId == this.N)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean j()
  {
    if ((this.app != null) && (this.L != null))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(this.L.uin);
      if ((localExtensionInfo != null) && (localExtensionInfo.faceId == this.O)) {
        return true;
      }
    }
    return false;
  }
  
  public void k()
  {
    if (this.N != 0L) {
      ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.N).c();
    }
  }
  
  public boolean l()
  {
    return this.aG != 0;
  }
  
  public void m()
  {
    int i1 = this.aG;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        this.aH = 2;
        return;
      }
      this.aH = 1;
      return;
    }
    this.aH = 0;
  }
  
  public int n()
  {
    return this.aC;
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      int i2 = paramView.getId();
      int i1 = 0;
      Object localObject1;
      Object localObject2;
      switch (i2)
      {
      default: 
        break;
      case 2131449056: 
        i1 = ((FrameLayout.LayoutParams)this.z.getLayoutParams()).height;
        if ((this.B != null) && (i1 != this.g)) {
          v();
        }
        break;
      case 2131449054: 
        if (FaceUtil.b()) {
          QQToast.makeText(this, 1, 2131917786, 0).show(getTitleBarHeight());
        } else {
          f();
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8004174", "0X8004174", this.L.profileEntryType, 0, "", "", "", "");
        break;
      case 2131445240: 
        if (!NetworkUtil.isNetSupport(this)) {
          QQToast.makeText(this, 2131915720, 0).show(getTitleBarHeight());
        } else if (this.T != null) {
          if (SimpleUIUtil.e())
          {
            localObject1 = DialogUtil.a(this, 0, null, HardCodeUtil.a(2131899124), null, HardCodeUtil.a(2131899883), new AvatarPendantActivity.13(this), null);
            if (!((QQCustomDialog)localObject1).isShowing()) {
              ((QQCustomDialog)localObject1).show();
            }
          }
          else
          {
            if (!i()) {
              ((IApolloExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.N, this.T.a, -1);
            }
            VasWebviewUtil.a(this.app.getCurrentAccountUin(), "faceAddon", "0X80088EE", "", 1, 0, 0, null, "", "");
            ReportController.b(this.app, "CliOper", "", "", "0X8005FDB", "0X8005FDB", 0, 0, String.valueOf(this.N), "", "", "");
          }
        }
        break;
      case 2131445234: 
        if (!NetworkUtil.isNetSupport(this))
        {
          QQToast.makeText(this, 2131915720, 0).show(getTitleBarHeight());
        }
        else if (!j())
        {
          this.ax = false;
          this.al.i(this.O);
          localObject1 = this.app.getCurrentUin();
          i1 = this.w;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.O);
          ((StringBuilder)localObject2).append("");
          VasWebviewUtil.a((String)localObject1, "widget", "head_setresult", "", 1, i1, 0, "", ((StringBuilder)localObject2).toString(), "");
          this.P = this.O;
          this.am.setText(HardCodeUtil.a(2131899118));
          this.am.setEnabled(false);
          this.ao.putInt("mSelectFaceId", this.O);
          this.ao.apply();
          localObject1 = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).f();
          this.B.a((List)localObject1, this.aj, this.ay, this.P);
        }
        break;
      case 2131445232: 
        if (!NetworkUtil.isNetSupport(this))
        {
          QQToast.makeText(this, 2131915720, 0).show(getTitleBarHeight());
        }
        else if (l())
        {
          i1 = ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.app.getCurrentUin());
          ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "setBtn", "click", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.app)).f(String.valueOf(this.O)).f(i1).a());
          this.ax = false;
          if (this.az != null)
          {
            this.aE.setEnabled(false);
            this.aD.setVisibility(0);
            a(this.az);
            i1 = this.O;
            this.P = i1;
            this.ao.putInt("mSelectFaceId", i1).apply();
            localObject1 = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
            if (localObject1 != null)
            {
              localObject1 = ((AvatarPendantManager)localObject1).f();
              this.B.a((List)localObject1, this.aj, this.ay);
            }
          }
        }
        else
        {
          localObject1 = new Intent(this, ((IApolloClassFactory)QRoute.api(IApolloClassFactory.class)).getApolloStoreActivityClass());
          ((Intent)localObject1).putExtra("url", this.aB);
          startActivity((Intent)localObject1);
        }
        break;
      case 2131439946: 
      case 2131439947: 
        if (paramView.getTag() != null)
        {
          long l1 = ((Integer)paramView.getTag()).intValue();
          localObject1 = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).f();
          while (i1 < ((List)localObject1).size())
          {
            localObject2 = (AvatarPendantShopSeriesInfo)((List)localObject1).get(i1);
            if ((localObject2 != null) && (((AvatarPendantShopSeriesInfo)localObject2).a == l1)) {
              ((AvatarPendantShopSeriesInfo)localObject2).i ^= true;
            }
            i1 += 1;
          }
          this.B.a((List)localObject1, this.aj, this.ay);
        }
        break;
      case 2131436188: 
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("individuation_url_type", 40100);
        ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject1).putExtra("hide_left_button", false);
        ((Intent)localObject1).putExtra("show_right_close_button", false);
        ((Intent)localObject1).putExtra("url", IndividuationUrlHelper.a(this, "myPendantUrl", ""));
        ((Intent)localObject1).putExtra("business", 512L);
        ((Intent)localObject1).putExtra("isShowAd", false);
        startActivity((Intent)localObject1);
        VasWebviewUtil.a(this.app.getCurrentAccountUin(), "faceAddon", "0X8008A05", "", 1, 0, 0, null, "", "");
        break;
      case 2131436180: 
        finish();
        break;
      case 2131432764: 
        ((IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("100100.100125.100127");
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("individuation_url_type", 40100);
        ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject1).putExtra("hide_left_button", false);
        ((Intent)localObject1).putExtra("show_right_close_button", false);
        ((Intent)localObject1).putExtra("url", VasWebviewUtil.b(IndividuationUrlHelper.a(this, "faceEntryUrl", ""), 45));
        ((Intent)localObject1).putExtra("business", 512L);
        ((Intent)localObject1).putExtra("isShowAd", false);
        startActivity((Intent)localObject1);
        VasWebviewUtil.a(this.app.getCurrentAccountUin(), "face", "0X80088EC", "", 1, 0, 0, null, "", "");
        t();
        break;
      case 2131432740: 
      case 2131432741: 
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", this.an);
        startActivity((Intent)localObject1);
        VasWebviewUtil.a(this.app.getCurrentUin(), "widget", "head_more", "", 1, 0, 0, "", "", "");
        break;
      case 2131430899: 
      case 2131430901: 
        i1 = ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.app.getCurrentUin());
        if (l())
        {
          ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "showMore", "click", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.app)).f(i1).a());
          localObject1 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", this.aA);
          startActivity((Intent)localObject1);
        }
        else
        {
          ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "openmore", "click", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.app)).f(i1).a());
          localObject1 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", this.aB);
          startActivity((Intent)localObject1);
        }
        if (getSharedPreferences("facechoosedata", 0).getBoolean("cmshow_avatar_red_dot", false))
        {
          this.ao.putBoolean("cmshow_avatar_red_dot", false);
          this.ao.apply();
          J();
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1;
    Object localObject2;
    int i1;
    int i2;
    int i3;
    if (paramAdapterView.getId() == 2131439942)
    {
      if (((paramAdapterView instanceof GridView)) && (paramAdapterView.getTag() != null) && (paramView != null) && (paramView.getTag() != null))
      {
        this.F.setVisibility(0);
        this.Z.setVisibility(8);
        this.X.setVisibility(0);
        this.am.setVisibility(8);
        this.aE.setVisibility(8);
        z();
        this.Y.setVisibility(0);
        this.D.setFaceDrawable(this.app, 1, this.L.uin, 640, true, true, true, false, 7);
        k();
        this.S = ((AvatarPendantShopItemInfo)((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)paramView.getTag()).g.getTag());
        this.N = this.S.a;
        localObject1 = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
        localObject2 = ((AvatarPendantManager)localObject1).f();
        AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo1 = this.T;
        AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo2 = (AvatarPendantShopSeriesInfo)paramAdapterView.getTag();
        i1 = 0;
        while (i1 < ((List)localObject2).size())
        {
          AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo3 = (AvatarPendantShopSeriesInfo)((List)localObject2).get(i1);
          if (localAvatarPendantShopSeriesInfo3 != null) {
            if (localAvatarPendantShopSeriesInfo3.a == localAvatarPendantShopSeriesInfo2.a)
            {
              localAvatarPendantShopSeriesInfo3.j = paramInt;
              this.T = localAvatarPendantShopSeriesInfo2;
            }
            else if ((localAvatarPendantShopSeriesInfo1 != null) && (localAvatarPendantShopSeriesInfo3.a == localAvatarPendantShopSeriesInfo1.a))
            {
              localAvatarPendantShopSeriesInfo3.j = -1;
            }
          }
          i1 += 1;
        }
        this.B.a((List)localObject2, this.aj, this.ay);
        if (i())
        {
          this.Y.setText(2131916326);
          this.Y.setEnabled(false);
          i1 = 4;
        }
        else
        {
          i1 = this.S.g;
          if (i1 != 4) {
            if (i1 != 5) {
              if (i1 != 6) {
                if (i1 != 12) {
                  i6 = 1;
                }
              }
            }
          }
          boolean bool;
          do
          {
            do
            {
              do
              {
                i2 = 0;
                i1 = 3;
                break;
                bool = VasUtil.b(this.app).getVipStatus().isBigClub();
                i6 = bool;
              } while (bool);
              i2 = 2131887560;
              i1 = 5;
              i6 = bool;
              break;
              i6 = 0;
              i2 = 2131886181;
              i1 = 2;
              break;
              bool = VasUtil.b(this.app).getVipStatus().isSVip();
              i6 = bool;
            } while (bool);
            i2 = 2131916952;
            i1 = 1;
            i6 = bool;
            break;
            bool = VasUtil.b(this.app).getVipStatus().isVip();
            i6 = bool;
          } while (bool);
          i2 = 2131917936;
          i1 = 0;
          int i6 = bool;
          this.Y.setEnabled(true);
          if (i6 != 0)
          {
            this.Y.setText(2131915688);
            i1 = 3;
          }
          else
          {
            this.Y.setText(i2);
          }
        }
        VasWebviewUtil.a(this.app.getCurrentAccountUin(), "faceAddon", "0X80088ED", "", 1, 0, 0, null, String.valueOf(i1), String.valueOf(this.N));
        ReportController.b(this.app, "CliOper", "", "", "0X8005FD5", "0X8005FD5", 0, 0, String.valueOf(this.T.a), String.valueOf(this.N), "", "");
        if (this.S.b == 1) {
          ((AvatarPendantManager)localObject1).a(this.N).a(this.F, 2, PendantInfo.j);
        } else {
          ((AvatarPendantManager)localObject1).a(this.N).a(this.F, 5, PendantInfo.j);
        }
        if (Build.VERSION.SDK_INT < 14) {
          return;
        }
        i1 = this.e;
        if ((i1 == b) || (i1 == c))
        {
          paramAdapterView = (ViewGroup)paramAdapterView.getParent();
          localObject1 = (ViewGroup)paramAdapterView.getParent();
          i2 = paramAdapterView.getHeight();
          i3 = paramView.getHeight();
          int i4 = DisplayUtil.a(this, 7.0F);
          i1 = i2 - i3 - i4;
          if (this.T.i)
          {
            i1 = (this.T.h.size() - 1) / 4;
            if (paramInt == 0) {
              paramInt = 0;
            } else {
              paramInt /= 4;
            }
            int i5 = DisplayUtil.a(this, 4.0F);
            i1 = i2 - (i1 + 1 - paramInt) * (i3 + i5) + i5 - i4;
          }
          i2 = this.g - this.h;
          paramInt = ((ViewGroup)localObject1).getTop();
          if (((ViewGroup)localObject1).getTag() != null)
          {
            i3 = ((AvatarPendantAdapter.ViewHolder)((ViewGroup)localObject1).getTag()).l;
            if (paramInt < 0)
            {
              paramInt = i1;
              if (i1 < 0) {
                paramInt = 0 - i1;
              }
              this.A.setSelectionFromTop(i3, i2 - paramInt);
            }
            else if (paramInt + i1 < i2)
            {
              this.A.setSelectionFromTop(i3, i2 - i1);
            }
          }
        }
        v();
      }
    }
    else if (paramAdapterView.getId() == 2131442957)
    {
      this.N = -1L;
      x();
      this.ak = ((AvatarInPendantHeadportraitInfo)((AvatarPendantAdapter.FaceGridAdapter.GridFaceItemHolder)paramView.getTag()).e.getTag());
      this.O = this.ak.a;
      this.am.setVisibility(0);
      this.Z.setVisibility(8);
      this.X.setVisibility(0);
      this.Y.setVisibility(8);
      this.aE.setVisibility(8);
      B();
      this.D.a(this.O, 7, "large", ImageView.ScaleType.FIT_XY);
      paramView = this.app.getCurrentUin();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.ak.a);
      ((StringBuilder)localObject1).append("");
      VasWebviewUtil.a(paramView, "widget", "head_click", "", 1, 0, 0, "", ((StringBuilder)localObject1).toString(), "");
      this.ao.putInt("ChooseFaceId", this.ak.a);
      this.ao.apply();
      paramView = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).f();
      if (paramView.size() > 0) {
        this.B.a(paramView, this.aj, this.ay);
      }
      paramAdapterView = (ViewGroup)((ViewGroup)paramAdapterView.getParent()).getParent();
      if ((paramAdapterView.getTag() != null) && ((paramAdapterView.getTag() instanceof AvatarPendantAdapter.ViewHolder)))
      {
        paramAdapterView = (AvatarPendantAdapter.ViewHolder)paramAdapterView.getTag();
        paramInt = DisplayUtil.a(this, 100.0F);
        i1 = DisplayUtil.a(this, 20.0F);
        i2 = paramAdapterView.l;
        if (this.ak.a()) {
          this.A.setSelectionFromTop(i2, paramInt);
        } else {
          this.A.setSelectionFromTop(i2, i1);
        }
        v();
      }
    }
    else if (paramAdapterView.getId() == 2131430898)
    {
      this.N = -1L;
      x();
      this.az = ((CmAvatarFaceInfo)((CmshowFaceGridAdapter.CmshowFaceItemHolder)paramView.getTag()).c.getTag());
      this.O = this.az.getActionId();
      paramInt = ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.app.getCurrentUin());
      ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "cmshowavatar", "click", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.app)).f(String.valueOf(this.O)).f(paramInt).a());
      if (!l())
      {
        this.aE.setText(2131886697);
        ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "openBtn", "expose", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.app)).f(String.valueOf(this.O)).f(paramInt).a());
      }
      else
      {
        this.aE.setText(2131915688);
      }
      this.aE.setVisibility(0);
      this.Z.setVisibility(8);
      this.X.setVisibility(0);
      this.Y.setVisibility(8);
      this.am.setVisibility(8);
      ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "setBtn", "expose", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.app)).f(String.valueOf(this.O)).f(paramInt).a());
      C();
      localObject1 = (IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onItemClick isHasGif actionId: ");
      ((StringBuilder)localObject2).append(this.O);
      QLog.i("AvatarPendantActivity", 2, ((StringBuilder)localObject2).toString());
      if (!((IApolloAvatarFileManager)localObject1).isHasGif(this.O, this.az.getActionType(), this.app.getCurrentUin())) {
        this.aD.setVisibility(0);
      }
      this.D.a(this.app.getCurrentUin(), 7, "large", ImageView.ScaleType.FIT_XY, this.az.getActionId(), this.az.getActionType());
      this.ao.putInt("ChooseFaceId", this.az.getActionId()).apply();
      localObject1 = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).f();
      if (((List)localObject1).size() > 0) {
        this.B.a((List)localObject1, this.aj, this.ay);
      }
      paramAdapterView = (ViewGroup)paramAdapterView.getParent();
      localObject1 = (ViewGroup)paramAdapterView.getParent();
      i1 = paramAdapterView.getHeight() - paramView.getHeight() - DisplayUtil.a(this, 7.0F);
      i2 = this.g - this.h;
      paramInt = ((ViewGroup)localObject1).getTop();
      if (((ViewGroup)localObject1).getTag() != null)
      {
        i3 = ((AvatarPendantAdapter.ViewHolder)((ViewGroup)localObject1).getTag()).l;
        if (paramInt < 0)
        {
          paramInt = i1;
          if (i1 < 0) {
            paramInt = 0 - i1;
          }
          this.A.setSelectionFromTop(i3, i2 - paramInt);
        }
        else if (paramInt + i1 < i2)
        {
          this.A.setSelectionFromTop(i3, i2 - i1);
        }
      }
      v();
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = this.Z.getVisibility();
    boolean bool2 = true;
    if (paramInt1 == 0)
    {
      paramView = findViewById(2131449043);
      View localView = findViewById(2131447431);
      if (this.Z.getRight() > this.ab.getLeft()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramView.getTop() + this.F.getBottom() > this.x.getTop() + localView.getTop()) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        bool1 = true;
        break label108;
      }
    }
    boolean bool1 = false;
    label108:
    if ((this.aa.getVisibility() != 0) || (this.y.getBottom() <= this.z.getTop() + this.x.getTop())) {
      bool2 = false;
    }
    if ((bool1) || (bool2)) {
      ThreadManager.getUIHandler().post(new AvatarPendantActivity.RemoveTips(this, bool1, bool2));
    }
    paramView = (RelativeLayout.LayoutParams)this.I.getLayoutParams();
    double d1 = this.F.getLayoutParams().width;
    Double.isNaN(d1);
    paramInt1 = (int)(d1 * 0.18D);
    paramView.width = paramInt1;
    paramView.height = paramInt1;
    this.I.setLayoutParams(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity
 * JD-Core Version:    0.7.0.1
 */