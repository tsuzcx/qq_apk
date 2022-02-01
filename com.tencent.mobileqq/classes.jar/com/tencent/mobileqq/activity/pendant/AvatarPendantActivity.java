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
import com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.player.IGetGifFrameCallback;
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
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  double jdField_a_of_type_Double;
  public long a;
  SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  Uri jdField_a_of_type_AndroidNetUri;
  Handler jdField_a_of_type_AndroidOsHandler;
  SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AvatarPendantAdapter jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter;
  IApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver = new AvatarPendantActivity.18(this);
  private CmAvatarFaceInfo jdField_a_of_type_ComTencentMobileqqApolloModelCmAvatarFaceInfo;
  public IGetGifFrameCallback a;
  private IApolloAvatarVideoProcessor jdField_a_of_type_ComTencentMobileqqApolloScreenshotApiIApolloAvatarVideoProcessor;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new AvatarPendantActivity.1(this);
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new AvatarPendantActivity.3(this);
  UniPayHandler.UniPayUpdateListener jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener = new AvatarPendantActivity.10(this);
  UniPayHandler jdField_a_of_type_ComTencentMobileqqAppUniPayHandler;
  DynamicAvatarView jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new AvatarPendantActivity.25(this);
  TipsBar jdField_a_of_type_ComTencentMobileqqBannerTipsBar;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new AvatarPendantActivity.5(this);
  AllInOne jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne;
  BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  AvatarInPendantHeadportraitInfo jdField_a_of_type_ComTencentMobileqqVasAvatarInPendantHeadportraitInfo;
  AvatarPendantShopItemInfo jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo;
  AvatarPendantShopSeriesInfo jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo;
  AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  ISVIPHandler jdField_a_of_type_ComTencentMobileqqVasSvipApiISVIPHandler;
  CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new AvatarPendantActivity.24(this);
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new AvatarPendantActivity.17(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  List<AvatarInPendantHeadportraitInfo> jdField_a_of_type_JavaUtilList;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean;
  double jdField_b_of_type_Double;
  long jdField_b_of_type_Long = -1L;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private IApolloExtensionObserver jdField_b_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver = new AvatarPendantActivity.19(this);
  String jdField_b_of_type_JavaLangString;
  private List<CmAvatarFaceInfo> jdField_b_of_type_JavaUtilList;
  AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_b_of_type_Boolean;
  long jdField_c_of_type_Long = -1L;
  View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  long jdField_d_of_type_Long = 0L;
  View jdField_d_of_type_AndroidViewView;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private String jdField_e_of_type_JavaLangString;
  volatile boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean = true;
  int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  int h;
  int i;
  int j;
  int k;
  int l;
  int m;
  int n;
  int o;
  int p;
  int q;
  int r = 0;
  public int s = -1;
  public int t = -1;
  int u;
  private int v;
  private int w;
  private int x;
  private int y = AbstractGifImage.DoAccumulativeRunnable.DELAY;
  private int z;
  
  public AvatarPendantActivity()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerIGetGifFrameCallback = new AvatarPendantActivity.32(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).getSingleFrameFile(paramInt1, paramInt2, this.app.getCurrentUin(), new AvatarPendantActivity.28(this));
  }
  
  private void a(int paramInt1, int paramInt2, IApolloAvatarVideoProcessor.OnProcessFinishListener paramOnProcessFinishListener)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApiIApolloAvatarVideoProcessor != null) && (Build.VERSION.SDK_INT >= 21))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApiIApolloAvatarVideoProcessor.setProcessFinishListener(paramOnProcessFinishListener);
      this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApiIApolloAvatarVideoProcessor.process(paramInt1, paramInt2);
    }
  }
  
  private void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (str != null)
    {
      if (ProfileCardUtil.a(this.app, str, paramIntent))
      {
        r();
        this.jdField_f_of_type_Boolean = true;
        o();
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
      QQToast.a(this, 1, 2131718781, 0).b(getTitleBarHeight());
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
      localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() > 0) && (i1 != this.s))
      {
        this.s = i1;
        this.t = this.s;
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("ChooseFaceId", -1);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("mSelectFaceId", this.s);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
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
      this.jdField_d_of_type_Long = localSetting.headImgTimestamp;
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
    this.jdField_c_of_type_JavaLangString = paramString;
    if (f())
    {
      localObject = FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getWidth();
      paramString.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getHeight();
      paramString.mFailedDrawable = ((Drawable)localObject);
      paramString.mLoadingDrawable = ((Drawable)localObject);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getDrawable() instanceof BitmapDrawable)) {
          paramString.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getDrawable();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Long);
      this.jdField_c_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      URLDrawable.removeMemoryCacheByUrl(this.jdField_c_of_type_JavaLangString, paramString);
      paramString = URLDrawable.getDrawable(this.jdField_c_of_type_JavaLangString, paramString);
      if (SimpleUIUtil.a())
      {
        paramString.setDecodeHandler(URLDrawableDecodeHandler.i);
        paramString.setTag(new int[] { 640, 640, 45 });
      }
      else
      {
        paramString.setDecodeHandler(URLDrawableDecodeHandler.a);
        paramString.setTag(new int[] { 640, 640 });
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "onGetHDHeadUrl: newDisplayHDHead");
      }
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, paramString, 1, 200, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, 640, true, null, false, true, false, true, 7);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "onGetHDHeadUrl: oldDisplayHead");
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, 640, true, true, true, false, 7);
  }
  
  private boolean d()
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
  
  private boolean e()
  {
    return this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("had_entered_store_face", false);
  }
  
  private boolean f()
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString);
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
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append(",openflag=");
      ((StringBuilder)localObject).append(i1);
      QLog.i("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(bool1);
    return bool1;
  }
  
  private void i()
  {
    this.jdField_a_of_type_JavaUtilList = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).b();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "");
      localIVasQuickUpdateService.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
      localIVasQuickUpdateService.downloadItem(23L, "avatarInPendant_json", "pendant_market");
      f();
    }
  }
  
  private void j()
  {
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "");
    localIVasQuickUpdateService.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    Object localObject1 = ((DownloaderFactory)this.app.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    File localFile = new File(AvatarPendantUtil.jdField_b_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(AvatarPendantUtil.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("/icon.zip");
    localObject2 = new File(((StringBuilder)localObject2).toString());
    if ((localFile.exists()) && (!((File)localObject2).exists()) && (localObject1 != null)) {
      ThreadManager.getSubThreadHandler().post(new AvatarPendantActivity.IconRunnable(this, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, this.app));
    }
    localObject1 = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
    this.app.getApp().getSharedPreferences(ClubContentJsonTask.jdField_a_of_type_JavaLangString, 0);
    if (((List)localObject1).size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      return;
    }
    if (new File(this.jdField_a_of_type_JavaLangString).exists())
    {
      ((List)localObject1).clear();
      e();
      return;
    }
    localIVasQuickUpdateService.downloadItem(1000L, "pendant_market_json.android.v2", "pendant_market");
  }
  
  private void k()
  {
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131378837);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131363715);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131380141);
    View localView = super.findViewById(2131374298);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131380142));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131372421));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)findViewById(2131380140));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)super.findViewById(2131363438));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131380146));
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131380145);
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar = ((TipsBar)super.findViewById(2131378746));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131376891));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131376892));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372436));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366449));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363439));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131376888));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131376886));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131370360));
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131370381);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
    this.jdField_c_of_type_AndroidViewView.addOnLayoutChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    findViewById(2131369210).setOnClickListener(this);
    Object localObject1 = (TextView)findViewById(2131366448);
    ((TextView)localObject1).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, (View)localObject1).b(53).a();
    m();
    localObject1 = (TextView)super.findViewById(2131369202);
    ((TextView)localObject1).setText("");
    ((TextView)localObject1).setOnClickListener(this);
    localObject1 = (TextView)super.findViewById(2131369249);
    ((TextView)localObject1).setText(" ");
    ((TextView)localObject1).setFocusable(true);
    ((TextView)localObject1).setFocusableInTouchMode(true);
    ((TextView)localObject1).setClickable(true);
    ((TextView)localObject1).setContentDescription(" ");
    localObject1 = (RelativeLayout)super.findViewById(2131378837);
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
    this.jdField_f_of_type_Int = (i1 - a());
    this.jdField_e_of_type_Int = jdField_a_of_type_Int;
    d1 = (d3 - 1.78D) * 2.0D;
    d2 = (d3 - d1) * 0.58D / 1.8D;
    d1 = (1.85D - d1) * 0.38D / d3;
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      d1 = d3 - 1.67D;
      a();
      i2 = super.getResources().getDimensionPixelSize(2131299168);
      localObject2 = (RelativeLayout)super.findViewById(2131380129);
      localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      localLayoutParams.topMargin = (i2 / 2 + 14 - (int)(Math.abs(d1) * 24.0D));
      ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams);
      d1 *= 2.0D;
      d2 = (d1 + 1.8D) * 0.58D / d3;
      d1 = (d1 + 1.95D) * 0.38D / d3;
    }
    if (d3 < 1.2D)
    {
      this.jdField_f_of_type_Int = i1;
      d2 = 1.0D;
      d1 = d2;
    }
    i1 = this.jdField_f_of_type_Int;
    d3 = i1;
    Double.isNaN(d3);
    this.jdField_g_of_type_Int = ((int)(d3 * d2));
    d3 = i1;
    Double.isNaN(d3);
    this.h = ((int)(d3 * d1));
    if (!this.jdField_b_of_type_Boolean)
    {
      super.findViewById(2131380133).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTipsText("没有SD卡无法使用头像挂件");
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.a(false);
      i1 = this.jdField_f_of_type_Int;
      d3 = i1;
      Double.isNaN(d3);
      this.jdField_g_of_type_Int = ((int)(d3 * (d2 + 0.06D)));
      d2 = i1;
      Double.isNaN(d2);
      this.h = ((int)(d2 * d1));
      this.jdField_a_of_type_Boolean = true;
    }
    else if (this.jdField_c_of_type_Boolean)
    {
      super.findViewById(2131380133).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTipsText(HardCodeUtil.a(2131701104));
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.a(false);
      i1 = this.jdField_f_of_type_Int;
      d3 = i1;
      Double.isNaN(d3);
      this.jdField_g_of_type_Int = ((int)(d3 * (d2 + 0.06D)));
      d2 = i1;
      Double.isNaN(d2);
      this.h = ((int)(d2 * d1));
      this.jdField_a_of_type_Boolean = true;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter = new AvatarPendantAdapter(this, this, this, ((Display)localObject1).getWidth(), this.app, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, this.jdField_g_of_type_Int - this.h);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter);
    }
    i1 = this.jdField_g_of_type_Int;
    d1 = i1;
    Double.isNaN(d1);
    this.i = ((int)(d1 * 0.383D));
    i2 = this.i;
    this.k = ((int)(i2 * 186.05F / 150.0F));
    int i3 = this.k;
    this.m = ((int)(i3 * 222.05F / 186.0F));
    this.o = ((i3 - i2) / 2);
    int i4 = this.h;
    this.jdField_a_of_type_Double = ((i4 + 0.05F) / i1);
    this.jdField_a_of_type_Double -= 0.24D;
    d2 = i2;
    d1 = this.jdField_a_of_type_Double;
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
    this.jdField_b_of_type_Double = ((i2 - this.j + 0.05F) / (i1 - i4));
    localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    Object localObject2 = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject1).topMargin = this.h;
    ((FrameLayout.LayoutParams)localObject2).height = this.jdField_g_of_type_Int;
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLayoutParams();
    localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    i1 = this.i;
    ((RelativeLayout.LayoutParams)localObject1).width = i1;
    ((RelativeLayout.LayoutParams)localObject1).height = i1;
    ((RelativeLayout.LayoutParams)localObject2).width = this.k;
    ((RelativeLayout.LayoutParams)localObject2).height = this.m;
    localLayoutParams.height = this.o;
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ThreadManager.excute(new AvatarPendantActivity.4(this), 32, null, false);
    q();
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
  
  private void l()
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("had_entered_store_face", true);
    localEditor.commit();
  }
  
  private void m()
  {
    ThreadManager.post(new AvatarPendantActivity.6(this), 5, null, true);
  }
  
  private void n()
  {
    int i1 = this.jdField_e_of_type_Int;
    if (i1 != jdField_a_of_type_Int)
    {
      if (i1 == jdField_d_of_type_Int) {
        return;
      }
      if (Build.VERSION.SDK_INT < 14) {
        return;
      }
      Object localObject1 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height = this.o;
      this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new AvatarPendantActivity.AnimRect();
      AvatarPendantActivity.AnimRect localAnimRect1 = new AvatarPendantActivity.AnimRect();
      AvatarPendantActivity.AnimRect localAnimRect2 = new AvatarPendantActivity.AnimRect();
      new AvatarPendantActivity.AnimRect();
      ((AvatarPendantActivity.AnimRect)localObject2).jdField_c_of_type_Int = localLayoutParams.height;
      ((AvatarPendantActivity.AnimRect)localObject2).jdField_d_of_type_Int = this.jdField_g_of_type_Int;
      i1 = localLayoutParams.topMargin;
      ((AvatarPendantActivity.AnimRect)localObject2).jdField_b_of_type_Int = i1;
      ((AvatarPendantActivity.AnimRect)localObject2).jdField_a_of_type_Int = i1;
      double d1 = Math.abs(this.jdField_g_of_type_Int - localLayoutParams.height);
      Double.isNaN(d1);
      double d2 = this.jdField_g_of_type_Int;
      Double.isNaN(d2);
      d1 = d1 * 1.0D / d2;
      d2 = ((AvatarPendantActivity.AnimRect)localObject2).jdField_g_of_type_Int;
      Double.isNaN(d2);
      ((AvatarPendantActivity.AnimRect)localObject2).jdField_g_of_type_Int = ((int)(d1 * d2));
      i1 = localLayoutParams1.topMargin;
      localAnimRect1.jdField_b_of_type_Int = i1;
      localAnimRect1.jdField_a_of_type_Int = i1;
      localAnimRect1.jdField_e_of_type_Int = localLayoutParams1.width;
      localAnimRect1.jdField_f_of_type_Int = this.i;
      localAnimRect1.jdField_c_of_type_Int = localLayoutParams1.height;
      localAnimRect1.jdField_d_of_type_Int = this.i;
      localAnimRect1.jdField_g_of_type_Int = ((AvatarPendantActivity.AnimRect)localObject2).jdField_g_of_type_Int;
      i1 = localLayoutParams2.topMargin;
      localAnimRect2.jdField_b_of_type_Int = i1;
      localAnimRect2.jdField_a_of_type_Int = i1;
      localAnimRect2.jdField_e_of_type_Int = localLayoutParams2.width;
      localAnimRect2.jdField_f_of_type_Int = this.k;
      localAnimRect2.jdField_c_of_type_Int = localLayoutParams2.height;
      localAnimRect2.jdField_d_of_type_Int = this.m;
      localAnimRect2.jdField_g_of_type_Int = ((AvatarPendantActivity.AnimRect)localObject2).jdField_g_of_type_Int;
      localArrayList.add(this.jdField_c_of_type_AndroidViewView);
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      localArrayList.add(this.jdField_b_of_type_AndroidWidgetImageView);
      ((List)localObject1).add(localObject2);
      ((List)localObject1).add(localAnimRect1);
      ((List)localObject1).add(localAnimRect2);
      if (((AvatarPendantActivity.AnimRect)localObject2).jdField_g_of_type_Int <= 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("heigth: ");
        ((StringBuilder)localObject1).append(this.jdField_g_of_type_Int);
        ((StringBuilder)localObject1).append(" palytime: ");
        ((StringBuilder)localObject1).append(((AvatarPendantActivity.AnimRect)localObject2).jdField_g_of_type_Int);
        QLog.e("AvatarPendantActivity", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      a(localArrayList, (List)localObject1, ((AvatarPendantActivity.AnimRect)localObject2).jdField_g_of_type_Int);
    }
  }
  
  private void o()
  {
    ThreadManager.getFileThreadHandler().post(new AvatarPendantActivity.11(this));
  }
  
  private void p()
  {
    if (!ProfilePAUtils.isPaTypeHasUin(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    Object localObject = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
    long l1;
    if (localObject != null) {
      l1 = ((ExtensionInfo)localObject).pendantId;
    } else {
      l1 = this.jdField_b_of_type_Long;
    }
    long l2;
    if (localObject != null) {
      l2 = ((ExtensionInfo)localObject).pendantDiyId;
    } else {
      l2 = this.jdField_c_of_type_Long;
    }
    long l3 = this.jdField_a_of_type_Long;
    int i1 = 8;
    if ((l3 != -1L) && (this.jdField_b_of_type_Long == l1) && (this.jdField_c_of_type_Long == l2))
    {
      localObject = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (AvatarPendantUtil.a(this.jdField_a_of_type_Long)) {
        ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.i);
      } else {
        ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 5, PendantInfo.i);
      }
    }
    else if ((localObject != null) && (((ExtensionInfo)localObject).isPendantValid()))
    {
      this.jdField_b_of_type_Long = ((ExtensionInfo)localObject).pendantId;
      this.jdField_c_of_type_Long = ((ExtensionInfo)localObject).pendantDiyId;
      AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (AvatarPendantUtil.a(((ExtensionInfo)localObject).pendantId)) {
        localAvatarPendantManager.a(((ExtensionInfo)localObject).pendantId).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.i, this.app.getCurrentAccountUin(), ((ExtensionInfo)localObject).pendantDiyId);
      } else {
        localAvatarPendantManager.a(((ExtensionInfo)localObject).pendantId).a(this.jdField_b_of_type_AndroidWidgetImageView, 5, PendantInfo.i, this.app.getCurrentAccountUin(), ((ExtensionInfo)localObject).pendantDiyId);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131718818);
      ReportController.b(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "1", "", "", "");
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      ReportController.b(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "0", "", "", "");
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (!d()) {
      i1 = 0;
    }
    ((TextView)localObject).setVisibility(i1);
  }
  
  private void q()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AvatarPendantUtil.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append("/widget_display_bg.jpg");
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists())
    {
      ColorDrawable localColorDrawable = new ColorDrawable(-16741938);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_c_of_type_AndroidViewView.getWidth();
      localURLDrawableOptions.mRequestHeight = this.jdField_c_of_type_AndroidViewView.getHeight();
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localObject = URLDrawable.getDrawable((File)localObject, localURLDrawableOptions);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void r()
  {
    int i1 = this.t;
    if (i1 != -1)
    {
      int i2 = this.s;
      if (i2 != -1)
      {
        if (i1 == i2)
        {
          this.jdField_b_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131701094));
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131701093));
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
  }
  
  private void s()
  {
    int i1 = this.t;
    if (i1 != -1)
    {
      int i2 = this.s;
      if (i2 != -1)
      {
        if (i1 == i2)
        {
          this.jdField_c_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131701094));
          this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
          return;
        }
        this.jdField_c_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131718206));
        this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
  }
  
  private void t()
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
    ReportController.b(this.app, "CliOper", "", "", "0X8004177", "0X8004177", this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.profileEntryType, 0, "", "", "", "");
  }
  
  private void u()
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
      t();
      return;
    }
    t();
  }
  
  private void v()
  {
    this.w = ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus();
  }
  
  private void w()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCmshowFaceDataFormNetwork faceType:");
    localStringBuilder.append(this.x);
    QLog.d("AvatarPendantActivity", 1, localStringBuilder.toString());
    ThreadManagerV2.executeOnSubThread(new AvatarPendantActivity.30(this));
  }
  
  private void x()
  {
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.jdField_a_of_type_Int = 749;
    localTianShuAdPosItemData.jdField_b_of_type_Int = 1;
    localArrayList.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(localArrayList, new AvatarPendantActivity.31(this));
  }
  
  private void y()
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    String str = this.app.getCurrentUin();
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(l1);
    localTianShuReportData.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_e_of_type_JavaLangString = "tianshu.75";
    localTianShuReportData.jdField_f_of_type_JavaLangString = "tianshu.75";
    localTianShuReportData.jdField_g_of_type_JavaLangString = String.valueOf(this.z);
    localTianShuReportData.h = "";
    localTianShuReportData.jdField_a_of_type_Long = l1;
    localTianShuReportData.jdField_d_of_type_Int = 102;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.jdField_f_of_type_Int = 1;
    localTianShuReportData.l = this.jdField_g_of_type_JavaLangString;
    TianShuManager.getInstance().report(localTianShuReportData);
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
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new AvatarPendantActivity.7(this));
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
        QQToast.a(this, 1, HardCodeUtil.a(2131701090), 0).b(getTitleBarHeight());
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
        QQToast.a(this, 1, HardCodeUtil.a(2131701095), 0).b(getTitleBarHeight());
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
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        str1 = ((StringBuilder)localObject).toString();
      }
      String str2 = paramPendantTipsInfo.vipType;
      if (str2.equals("LTMCLUB")) {
        localObject = getString(2131695078);
      }
      for (;;)
      {
        break;
        if (str2.equals("CJCLUBT"))
        {
          localObject = getString(2131719393);
        }
        else
        {
          if (!str2.equals("SVHHZLH")) {
            break label306;
          }
          localObject = getString(2131690636);
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
              localAvatarInPendantHeadportraitInfo.jdField_a_of_type_Boolean = true;
              break label344;
            }
            localObject1 = ((JSONObject)localObject1).optJSONArray("avatarInPendantCount");
            if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
              AvatarPendantManager.jdField_a_of_type_Int = ((JSONArray)localObject1).optJSONObject(0).optInt("count");
            }
            localObject1 = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
            if (localObject1 == null) {
              break label343;
            }
            ((AvatarPendantManager)localObject1).a(paramString);
            this.jdField_a_of_type_JavaUtilList = paramString;
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
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
  
  public boolean a()
  {
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne != null))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
      if ((localExtensionInfo != null) && (localExtensionInfo.pendantId == this.jdField_a_of_type_Long)) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    int i1 = 0;
    localObject = ((XListView)localObject).getChildAt(0);
    if (localObject == null) {
      return 0;
    }
    int i2 = -((View)localObject).getTop();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition(), ((View)localObject).getHeight());
    while (i1 < this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition())
    {
      if (this.jdField_a_of_type_AndroidUtilSparseIntArray.get(i1) == 0) {
        this.jdField_a_of_type_Boolean = true;
      } else {
        i2 += this.jdField_a_of_type_AndroidUtilSparseIntArray.get(i1);
      }
      i1 += 1;
    }
    return i2;
  }
  
  public void b()
  {
    int i1 = b();
    int i2 = i1 - this.q;
    this.q = i1;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    if ((i2 >= 0) || ((i2 <= 0) && (this.q <= this.jdField_g_of_type_Int - this.h))) {
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
      this.jdField_e_of_type_Int = jdField_b_of_type_Int;
    }
    else
    {
      i1 = localLayoutParams.height;
      i3 = this.jdField_g_of_type_Int;
      if (i1 >= i3)
      {
        localLayoutParams.height = i3;
        i1 = this.i;
        localLayoutParams1.height = i1;
        localLayoutParams1.width = i1;
        localLayoutParams2.width = this.k;
        localLayoutParams2.height = this.m;
        localLayoutParams3.height = this.o;
        this.jdField_e_of_type_Int = jdField_a_of_type_Int;
      }
      else
      {
        this.jdField_e_of_type_Int = jdField_c_of_type_Int;
      }
    }
    if ((this.jdField_e_of_type_Int == jdField_c_of_type_Int) && ((i2 >= 0) || ((i2 <= 0) && (this.q <= this.jdField_g_of_type_Int - this.h))))
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
            double d2 = this.jdField_b_of_type_Double;
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
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setLayoutParams(localLayoutParams1);
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
    this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams3);
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
          List localList = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
          try
          {
            JSONObject localJSONObject1 = new JSONObject((String)localObject2);
            if (localJSONObject1.has("rareAct"))
            {
              if (localJSONObject1.getInt("rareAct") != 1) {
                break label1589;
              }
              bool = true;
              AvatarPendantManager.jdField_c_of_type_Boolean = bool;
            }
            else
            {
              AvatarPendantManager.jdField_c_of_type_Boolean = false;
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
              if ((localJSONObject2.getInt("isShow") == 0) || (AppSetting.a(localJSONObject2.getString("minVersion")) < 0)) {
                break label1619;
              }
              localObject2 = new AvatarPendantShopItemInfo();
              ((AvatarPendantShopItemInfo)localObject2).jdField_c_of_type_Int = localJSONObject2.getInt("feeType");
              ((AvatarPendantShopItemInfo)localObject2).jdField_d_of_type_Int = localJSONObject2.getInt("limitFree");
              ((AvatarPendantShopItemInfo)localObject2).jdField_a_of_type_Long = localJSONObject2.getLong("limitFreeBegin");
              ((AvatarPendantShopItemInfo)localObject2).jdField_b_of_type_Long = localJSONObject2.getLong("limitFreeEnd");
              localObject3 = ((JSONObject)localObject3).getJSONObject("baseInfo");
              ((AvatarPendantShopItemInfo)localObject2).jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("type");
              ((AvatarPendantShopItemInfo)localObject2).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).getString("name");
              ((AvatarPendantShopItemInfo)localObject2).jdField_c_of_type_JavaLangString = ((JSONObject)localObject3).getString("listPng");
              ((AvatarPendantShopItemInfo)localObject2).jdField_a_of_type_Int = Integer.valueOf(((JSONObject)localObject3).getString("id")).intValue();
              if (((JSONObject)localObject3).getInt("isLink") != 1) {
                break label1622;
              }
              bool = true;
              ((AvatarPendantShopItemInfo)localObject2).jdField_a_of_type_Boolean = bool;
              ((AvatarPendantShopItemInfo)localObject2).jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).getString("defaultHead");
              if (((HashSet)localObject7).contains(Integer.valueOf(((AvatarPendantShopItemInfo)localObject2).jdField_a_of_type_Int))) {
                ((AvatarPendantShopItemInfo)localObject2).jdField_e_of_type_Int = 7;
              } else if (localHashSet1.contains(Integer.valueOf(((AvatarPendantShopItemInfo)localObject2).jdField_a_of_type_Int))) {
                ((AvatarPendantShopItemInfo)localObject2).jdField_e_of_type_Int = 8;
              }
              l2 = NetConnInfoCenter.getServerTimeMillis();
              if ((((AvatarPendantShopItemInfo)localObject2).jdField_c_of_type_Int == 1) && (((AvatarPendantShopItemInfo)localObject2).jdField_a_of_type_Long <= l2) && (l2 <= ((AvatarPendantShopItemInfo)localObject2).jdField_b_of_type_Long)) {
                ((AvatarPendantShopItemInfo)localObject2).jdField_f_of_type_Int = 10;
              } else if (((AvatarPendantShopItemInfo)localObject2).jdField_c_of_type_Int == 6) {
                ((AvatarPendantShopItemInfo)localObject2).jdField_f_of_type_Int = 6;
              }
              if (localHashSet2.contains(Integer.valueOf(((AvatarPendantShopItemInfo)localObject2).jdField_a_of_type_Int))) {
                ((AvatarPendantShopItemInfo)localObject2).jdField_f_of_type_Int = 9;
              }
              ((SparseArray)localObject6).put(((AvatarPendantShopItemInfo)localObject2).jdField_a_of_type_Int, localObject2);
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
              ((AvatarPendantShopSeriesInfo)localObject5).jdField_a_of_type_JavaUtilList = new ArrayList();
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
                ((AvatarPendantShopSeriesInfo)localObject5).jdField_a_of_type_JavaUtilList.add(localObject7);
                break label1634;
              }
              if (((AvatarPendantShopSeriesInfo)localObject5).jdField_a_of_type_JavaUtilList.size() <= 0) {
                break label1631;
              }
              ((AvatarPendantShopSeriesInfo)localObject5).jdField_a_of_type_Int = ((JSONObject)localObject4).getInt("seriesID");
              ((AvatarPendantShopSeriesInfo)localObject5).jdField_c_of_type_JavaLangString = ((JSONObject)localObject4).getString("cornerMark");
              localObject3 = str;
              if (!TextUtils.isEmpty(((JSONObject)localObject4).getString((String)localObject3))) {
                ((AvatarPendantShopSeriesInfo)localObject5).jdField_b_of_type_Int = Integer.valueOf(((JSONObject)localObject4).getString((String)localObject3)).intValue();
              } else {
                ((AvatarPendantShopSeriesInfo)localObject5).jdField_b_of_type_Int = 0;
              }
              ((AvatarPendantShopSeriesInfo)localObject5).jdField_d_of_type_JavaLangString = ((JSONObject)localObject4).getString("defaultHead");
              ((AvatarPendantShopSeriesInfo)localObject5).jdField_e_of_type_JavaLangString = ((JSONObject)localObject4).getString("tpl");
              ((AvatarPendantShopSeriesInfo)localObject5).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).getString("subtitle");
              ((AvatarPendantShopSeriesInfo)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject4).getString("name");
              ((AvatarPendantShopSeriesInfo)localObject5).jdField_c_of_type_Int = -1;
              if ((((AvatarPendantShopSeriesInfo)localObject5).jdField_e_of_type_JavaLangString == null) || (((AvatarPendantShopSeriesInfo)localObject5).jdField_e_of_type_JavaLangString.equals(""))) {
                break label1643;
              }
              ((AvatarPendantShopSeriesInfo)localObject5).jdField_a_of_type_Boolean = true;
              localList.add(localObject5);
              break label1646;
            }
            PendantMarketConfig.a(localJSONObject1);
            try
            {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
              this.app.getApp().getSharedPreferences(ClubContentJsonTask.jdField_a_of_type_JavaLangString, 0).edit().putBoolean(ClubContentJsonTask.jdField_a_of_type_JavaLangString, false).commit();
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
  
  public boolean b()
  {
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne != null))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin);
      if ((localExtensionInfo != null) && (localExtensionInfo.faceId == this.s)) {
        return true;
      }
    }
    return false;
  }
  
  public int c()
  {
    return this.v;
  }
  
  public void c()
  {
    ImageView localImageView = (ImageView)super.findViewById(2131380134);
    TextView localTextView = (TextView)super.findViewById(2131380135);
    Button localButton = (Button)super.findViewById(2131380132);
    String str2 = this.app.getCurrentAccountUin();
    Object localObject1 = this.app.getApp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("uniPaySp_");
    ((StringBuilder)localObject2).append(str2);
    SharedPreferences localSharedPreferences = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    String str4 = localSharedPreferences.getString("sUin", "");
    int i1 = localSharedPreferences.getInt("isShowOpen", 0);
    int i2 = localSharedPreferences.getInt("iUinpPayType", 0);
    String str3 = super.getString(2131716880);
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
              localButton.setText(2131693274);
              localTextView.setText(super.getString(2131690626, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844069));
              localObject1 = localObject3;
              localObject2 = str1;
              break;
            case 8: 
              localButton.setText(2131693273);
              localTextView.setText(super.getString(2131690625, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844069));
              localObject1 = localObject3;
              localObject2 = str1;
              break;
            case 7: 
              localButton.setText(2131693274);
              localTextView.setText(super.getString(2131690620, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843446));
              localObject1 = HardCodeUtil.a(2131701087);
              break;
            case 6: 
              localButton.setText(2131693274);
              localTextView.setText(super.getString(2131690624, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844068));
              localObject1 = HardCodeUtil.a(2131701099);
              break;
            case 5: 
              localButton.setText(2131693273);
              localTextView.setText(super.getString(2131690623, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844068));
              localObject1 = HardCodeUtil.a(2131701107);
              break;
            case 4: 
              localButton.setText(2131693273);
              localTextView.setText(super.getString(2131690619, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843446));
              localObject1 = HardCodeUtil.a(2131701089);
              break;
            case 3: 
              localButton.setText(2131693272);
              localTextView.setText(super.getString(2131690618, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130842684));
              localObject1 = HardCodeUtil.a(2131701102);
              localObject2 = "CJCLUBT";
              break;
            case 2: 
              localButton.setText(2131693273);
              localTextView.setText(super.getString(2131690622, new Object[] { str3 }));
              localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844067));
              localObject1 = localObject3;
              localObject2 = str1;
              break;
            }
            localButton.setText(2131693272);
            localTextView.setText(super.getString(2131690621, new Object[] { str3 }));
            localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130842684));
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
  
  public boolean c()
  {
    return this.w != 0;
  }
  
  public void d()
  {
    int i2 = SharedPreUtils.ad(this, this.app.getCurrentAccountUin());
    int i1;
    if ((i2 != -1) && (i2 != 2)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    Object localObject = (ActionSheet)ActionSheetHelper.a(this, null);
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
    if (((DynamicAvatarManager)this.app.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).a())
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
          ((View)localObject).setContentDescription(HardCodeUtil.a(2131701097));
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
    //   13: ldc_w 2020
    //   16: invokevirtual 257	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 7
    //   21: aload 7
    //   23: ifnull +235 -> 258
    //   26: aload 7
    //   28: ldc_w 2022
    //   31: invokevirtual 2025	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   34: ifne +4 -> 38
    //   37: return
    //   38: aload_3
    //   39: ldc_w 2027
    //   42: invokevirtual 257	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_3
    //   46: new 1640	org/json/JSONObject
    //   49: dup
    //   50: aload_3
    //   51: invokespecial 1641	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_3
    //   56: ldc_w 2029
    //   59: invokevirtual 1673	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: invokestatic 679	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   65: istore_1
    //   66: aload_3
    //   67: ldc_w 2031
    //   70: invokevirtual 1673	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   73: invokestatic 679	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   76: istore_2
    //   77: aload_3
    //   78: ldc_w 2033
    //   81: invokevirtual 1673	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic 679	java/lang/Integer:parseInt	(Ljava/lang/String;)I
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
    //   121: invokevirtual 2034	org/json/JSONException:printStackTrace	()V
    //   124: aload_3
    //   125: ifnull +290 -> 415
    //   128: iload_1
    //   129: ifne +286 -> 415
    //   132: iload_2
    //   133: ifne +282 -> 415
    //   136: iload 4
    //   138: ifne +277 -> 415
    //   141: aload_0
    //   142: getfield 2036	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:jdField_a_of_type_ComTencentMobileqqAppUniPayHandler	Lcom/tencent/mobileqq/app/UniPayHandler;
    //   145: astore_3
    //   146: aload_3
    //   147: ifnull +10 -> 157
    //   150: aload_3
    //   151: ldc_w 278
    //   154: invokevirtual 2039	com/tencent/mobileqq/app/UniPayHandler:a	(Ljava/lang/String;)V
    //   157: aload 7
    //   159: ldc_w 2041
    //   162: invokevirtual 1558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq +42 -> 207
    //   168: aload_0
    //   169: getfield 218	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   172: ldc_w 276
    //   175: ldc_w 278
    //   178: ldc_w 278
    //   181: ldc_w 2043
    //   184: ldc_w 2043
    //   187: iconst_0
    //   188: iconst_0
    //   189: ldc_w 278
    //   192: ldc_w 278
    //   195: ldc_w 278
    //   198: ldc_w 278
    //   201: invokestatic 287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   204: goto +48 -> 252
    //   207: aload_0
    //   208: getfield 218	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   211: ldc_w 276
    //   214: ldc_w 278
    //   217: ldc_w 278
    //   220: ldc_w 2043
    //   223: ldc_w 2043
    //   226: iconst_0
    //   227: iconst_0
    //   228: aload 7
    //   230: bipush 16
    //   232: aload 7
    //   234: invokevirtual 2044	java/lang/String:length	()I
    //   237: invokevirtual 2048	java/lang/String:substring	(II)Ljava/lang/String;
    //   240: ldc_w 278
    //   243: ldc_w 278
    //   246: ldc_w 278
    //   249: invokestatic 287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload_0
    //   253: iconst_1
    //   254: putfield 109	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:jdField_d_of_type_Boolean	Z
    //   257: return
    //   258: return
    //   259: iload_1
    //   260: iconst_1
    //   261: if_icmpne +52 -> 313
    //   264: invokestatic 434	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +36 -> 303
    //   270: new 436	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   277: astore_3
    //   278: aload_3
    //   279: ldc_w 2050
    //   282: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_3
    //   287: iload_2
    //   288: invokevirtual 691	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: ldc_w 2052
    //   295: iconst_2
    //   296: aload_3
    //   297: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 451	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: iload_2
    //   304: iconst_m1
    //   305: if_icmpne +110 -> 415
    //   308: aload_0
    //   309: invokespecial 266	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:o	()V
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
    //   326: getfield 2054	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   329: invokestatic 2059	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   332: astore_3
    //   333: aload_0
    //   334: invokestatic 1219	com/tencent/mobileqq/util/ProfileCardUtil:b	(Landroid/app/Activity;)I
    //   337: istore_1
    //   338: new 253	android/content/Intent
    //   341: dup
    //   342: invokespecial 1216	android/content/Intent:<init>	()V
    //   345: astore 6
    //   347: aload 6
    //   349: ldc_w 1227
    //   352: bipush 100
    //   354: invokevirtual 1230	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   357: pop
    //   358: aload 6
    //   360: ldc_w 1232
    //   363: bipush 100
    //   365: invokevirtual 1230	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   368: pop
    //   369: aload 6
    //   371: ldc_w 270
    //   374: bipush 10
    //   376: invokevirtual 1230	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   379: pop
    //   380: aload 6
    //   382: ldc_w 2061
    //   385: ldc_w 2063
    //   388: invokevirtual 2066	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   391: pop
    //   392: aload 6
    //   394: aload_0
    //   395: ldc 2
    //   397: invokevirtual 1241	java/lang/Class:getName	()Ljava/lang/String;
    //   400: iload_1
    //   401: iload_1
    //   402: sipush 1080
    //   405: sipush 1080
    //   408: aload_3
    //   409: invokestatic 1245	com/tencent/mobileqq/app/face/util/FaceUtil:a	()Ljava/lang/String;
    //   412: invokestatic 2070	com/tencent/mobileqq/activity/photo/PhotoUtils:startPhotoEdit	(Landroid/content/Intent;Landroid/app/Activity;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;)V
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
    super.setContentView(2131561871);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqVasSvipApiISVIPHandler = ((ISVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER));
    paramBundle = super.getIntent();
    if (paramBundle.getParcelableExtra("AllInOne") != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne = ((AllInOne)paramBundle.getParcelableExtra("AllInOne"));
      boolean bool2 = paramBundle.getBooleanExtra("showActionSheet", false);
      c();
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler = ((UniPayHandler)this.app.getBusinessHandler(BusinessHandlerFactory.UNI_PAY_HANDLER));
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
      super.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a("");
      if ((!NetworkUtil.isNetSupport(this)) && (QLog.isColorLevel())) {
        QLog.d("AvatarPendantActivity", 2, "net is not connected");
      }
      this.jdField_b_of_type_Boolean = SystemUtil.a();
      if (SystemUtil.a() < 1024L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.jdField_c_of_type_Boolean = bool1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.app.getApplication().getApplicationContext().getFilesDir());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("pendant_market.json");
      this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.app.getApplication().getApplicationContext().getFilesDir());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("avatarInPendant.json");
      this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
      k();
      boolean bool1 = ((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).enableCmshowAvatar();
      boolean bool3 = ((IApolloEngineHelper)QRoute.api(IApolloEngineHelper.class)).isEngineReady();
      ((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).runOnCrossEngineForMemePlayer();
      ((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).getCmshowAvatar3DSwitch();
      if ((bool1) && (bool3))
      {
        v();
        h();
        w();
        x();
        if (Build.VERSION.SDK_INT >= 21)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApiIApolloAvatarVideoProcessor = ((IApolloAvatarVideoProcessor)QRoute.api(IApolloAvatarVideoProcessor.class));
          this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApiIApolloAvatarVideoProcessor.init(this.app);
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
      i();
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
      {
        a();
        j();
      }
      else if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sdcard exist:");
        localStringBuilder.append(this.jdField_b_of_type_Boolean);
        localStringBuilder.append(" sdcard full:");
        localStringBuilder.append(this.jdField_c_of_type_Boolean);
        QLog.d("AvatarPendantActivity", 2, localStringBuilder.toString());
      }
      if (bool2) {
        d();
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = getSharedPreferences("facechoosedata", 0).edit();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("ChooseFaceId", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      this.app.addObserver(this.jdField_b_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver);
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      this.jdField_d_of_type_JavaLangString = IndividuationUrlHelper.a("vasClassProfileStoryUrl");
      if (paramBundle.getBooleanExtra("fromThirdApp", false)) {
        ThreadManager.getUIHandler().postDelayed(new AvatarPendantActivity.2(this), 500L);
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler;
    if (localObject != null) {
      ((UniPayHandler)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
    }
    if (this.app != null) {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    }
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver);
    localObject = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo;
    if (localObject != null) {
      ((AvatarPendantShopSeriesInfo)localObject).jdField_c_of_type_Int = -1;
    }
    if ((this.app != null) && (this.jdField_a_of_type_Long != 0L)) {
      ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.jdField_a_of_type_Long).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter;
    if (localObject != null)
    {
      ((AvatarPendantAdapter)localObject).a();
      URLDrawable.resume();
    }
    if (this.app != null)
    {
      ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      this.app.removeObserver(this.jdField_b_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
    p();
  }
  
  protected void doOnPause()
  {
    AbstractGifImage.DoAccumulativeRunnable.DELAY = this.y;
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
    v();
    VasWebviewUtil.a(this.app.getCurrentUin(), "widget", "head_show", "", 1, 0, 0, "", "", "");
    Object localObject = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
    if (localObject != null)
    {
      List localList = ((AvatarPendantManager)localObject).a();
      this.jdField_a_of_type_JavaUtilList = ((AvatarPendantManager)localObject).b();
      if ((this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter != null) && (localList != null) && (localList.size() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a(localList, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      }
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (e()) {
      i1 = 8;
    }
    ((TextView)localObject).setVisibility(i1);
    p();
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public void e()
  {
    ThreadManager.getFileThreadHandler().post(new AvatarPendantActivity.ConfigParser(this.jdField_a_of_type_JavaLangString, this));
  }
  
  public void f()
  {
    ThreadManager.getFileThreadHandler().post(new AvatarPendantActivity.ConfacefigParser(this.jdField_b_of_type_JavaLangString, this));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.jdField_a_of_type_Long).b();
    }
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    DynamicAvatarRecordActivity.a(this, 1, 1);
    ReportController.b(this.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
  }
  
  public void h()
  {
    int i1 = this.w;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        this.x = 2;
        return;
      }
      this.x = 1;
      return;
    }
    this.x = 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (isFinishing()) {
      return true;
    }
    if (paramMessage.what == 1000)
    {
      runOnUiThread(new AvatarPendantActivity.15(this, ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a()));
      return true;
    }
    if (paramMessage.what == 1001) {
      runOnUiThread(new AvatarPendantActivity.16(this));
    }
    return true;
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
      case 2131380142: 
        i1 = ((FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).height;
        if ((this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter != null) && (i1 != this.jdField_g_of_type_Int)) {
          n();
        }
        break;
      case 2131380140: 
        if (FaceUtil.a()) {
          QQToast.a(this, 1, 2131720156, 0).b(getTitleBarHeight());
        } else {
          d();
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8004174", "0X8004174", this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.profileEntryType, 0, "", "", "", "");
        break;
      case 2131376892: 
        if (!NetworkUtil.isNetSupport(this)) {
          QQToast.a(this, 2131718228, 0).b(getTitleBarHeight());
        } else if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo != null) {
          if (SimpleUIUtil.a())
          {
            localObject1 = DialogUtil.a(this, 0, null, HardCodeUtil.a(2131701106), null, HardCodeUtil.a(2131701091), new AvatarPendantActivity.13(this), null);
            if (!((QQCustomDialog)localObject1).isShowing()) {
              ((QQCustomDialog)localObject1).show();
            }
          }
          else
          {
            if (!a()) {
              ((IApolloExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_Int, -1);
            }
            VasWebviewUtil.a(this.app.getCurrentAccountUin(), "faceAddon", "0X80088EE", "", 1, 0, 0, null, "", "");
            ReportController.b(this.app, "CliOper", "", "", "0X8005FDB", "0X8005FDB", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
          }
        }
        break;
      case 2131376888: 
        if (!NetworkUtil.isNetSupport(this))
        {
          QQToast.a(this, 2131718228, 0).b(getTitleBarHeight());
        }
        else if (!b())
        {
          this.jdField_f_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqVasSvipApiISVIPHandler.i(this.s);
          localObject1 = this.app.getCurrentUin();
          i1 = this.r;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.s);
          ((StringBuilder)localObject2).append("");
          VasWebviewUtil.a((String)localObject1, "widget", "head_setresult", "", 1, i1, 0, "", ((StringBuilder)localObject2).toString(), "");
          this.t = this.s;
          this.jdField_b_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131701100));
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("mSelectFaceId", this.s);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
          localObject1 = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
          this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
        }
        break;
      case 2131376886: 
        if (!NetworkUtil.isNetSupport(this))
        {
          QQToast.a(this, 2131718228, 0).b(getTitleBarHeight());
        }
        else if (c())
        {
          i1 = ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.app.getCurrentUin());
          ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "setBtn", "click", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.app)).c(String.valueOf(this.s)).f(i1).a());
          this.jdField_f_of_type_Boolean = false;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloModelCmAvatarFaceInfo != null)
          {
            this.jdField_e_of_type_AndroidViewView.setVisibility(0);
            a(this.jdField_a_of_type_ComTencentMobileqqApolloModelCmAvatarFaceInfo);
            i1 = this.s;
            this.t = i1;
            this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("mSelectFaceId", i1).apply();
            localObject1 = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
            if (localObject1 != null)
            {
              localObject1 = ((AvatarPendantManager)localObject1).a();
              this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
            }
          }
        }
        else
        {
          localObject1 = new Intent(this, ((IApolloClassFactory)QRoute.api(IApolloClassFactory.class)).getApolloStoreActivityClass());
          ((Intent)localObject1).putExtra("url", this.jdField_f_of_type_JavaLangString);
          startActivity((Intent)localObject1);
        }
        break;
      case 2131372424: 
      case 2131372425: 
        if (paramView.getTag() != null)
        {
          long l1 = ((Integer)paramView.getTag()).intValue();
          localObject1 = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
          while (i1 < ((List)localObject1).size())
          {
            localObject2 = (AvatarPendantShopSeriesInfo)((List)localObject1).get(i1);
            if ((localObject2 != null) && (((AvatarPendantShopSeriesInfo)localObject2).jdField_a_of_type_Int == l1)) {
              ((AvatarPendantShopSeriesInfo)localObject2).jdField_a_of_type_Boolean ^= true;
            }
            i1 += 1;
          }
          this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
        }
        break;
      case 2131369210: 
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
      case 2131369202: 
        finish();
        break;
      case 2131366448: 
        ((IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("100100.100125.100127");
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("individuation_url_type", 40100);
        ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject1).putExtra("hide_left_button", false);
        ((Intent)localObject1).putExtra("show_right_close_button", false);
        ((Intent)localObject1).putExtra("url", VasWebviewUtil.a(IndividuationUrlHelper.a(this, "faceEntryUrl", ""), 45));
        ((Intent)localObject1).putExtra("business", 512L);
        ((Intent)localObject1).putExtra("isShowAd", false);
        startActivity((Intent)localObject1);
        VasWebviewUtil.a(this.app.getCurrentAccountUin(), "face", "0X80088EC", "", 1, 0, 0, null, "", "");
        l();
        break;
      case 2131366424: 
      case 2131366425: 
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", this.jdField_d_of_type_JavaLangString);
        startActivity((Intent)localObject1);
        VasWebviewUtil.a(this.app.getCurrentUin(), "widget", "head_more", "", 1, 0, 0, "", "", "");
        break;
      case 2131364791: 
      case 2131364793: 
        i1 = ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.app.getCurrentUin());
        if (c())
        {
          ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "showMore", "click", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.app)).f(i1).a());
          localObject1 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", this.jdField_e_of_type_JavaLangString);
          startActivity((Intent)localObject1);
        }
        else
        {
          ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "openmore", "click", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.app)).f(i1).a());
          localObject1 = new Intent(this, ((IApolloClassFactory)QRoute.api(IApolloClassFactory.class)).getApolloStoreActivityClass());
          ((Intent)localObject1).putExtra("url", this.jdField_f_of_type_JavaLangString);
          startActivity((Intent)localObject1);
        }
        if (getSharedPreferences("facechoosedata", 0).getBoolean("cmshow_avatar_red_dot", false))
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("cmshow_avatar_red_dot", false);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
          y();
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
    if (paramAdapterView.getId() == 2131372420)
    {
      if (((paramAdapterView instanceof GridView)) && (paramAdapterView.getTag() != null) && (paramView != null) && (paramView.getTag() != null))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, 640, true, true, true, false, 7);
        g();
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo = ((AvatarPendantShopItemInfo)((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)paramView.getTag()).a.getTag());
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_a_of_type_Int;
        localObject1 = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
        localObject2 = ((AvatarPendantManager)localObject1).a();
        AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo1 = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo;
        AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo2 = (AvatarPendantShopSeriesInfo)paramAdapterView.getTag();
        i1 = 0;
        while (i1 < ((List)localObject2).size())
        {
          AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo3 = (AvatarPendantShopSeriesInfo)((List)localObject2).get(i1);
          if (localAvatarPendantShopSeriesInfo3 != null) {
            if (localAvatarPendantShopSeriesInfo3.jdField_a_of_type_Int == localAvatarPendantShopSeriesInfo2.jdField_a_of_type_Int)
            {
              localAvatarPendantShopSeriesInfo3.jdField_c_of_type_Int = paramInt;
              this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo = localAvatarPendantShopSeriesInfo2;
            }
            else if ((localAvatarPendantShopSeriesInfo1 != null) && (localAvatarPendantShopSeriesInfo3.jdField_a_of_type_Int == localAvatarPendantShopSeriesInfo1.jdField_a_of_type_Int))
            {
              localAvatarPendantShopSeriesInfo3.jdField_c_of_type_Int = -1;
            }
          }
          i1 += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject2, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
        if (a())
        {
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131718818);
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          i1 = 4;
        }
        else
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_c_of_type_Int;
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
                bool = VasUtil.a(this.app).getVipStatus().isBigClub();
                i6 = bool;
              } while (bool);
              i2 = 2131690649;
              i1 = 5;
              i6 = bool;
              break;
              i6 = 0;
              i2 = 2131689571;
              i1 = 2;
              break;
              bool = VasUtil.a(this.app).getVipStatus().isSVip();
              i6 = bool;
            } while (bool);
            i2 = 2131719396;
            i1 = 1;
            i6 = bool;
            break;
            bool = VasUtil.a(this.app).getVipStatus().isVip();
            i6 = bool;
          } while (bool);
          i2 = 2131720301;
          i1 = 0;
          int i6 = bool;
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          if (i6 != 0)
          {
            this.jdField_a_of_type_AndroidWidgetButton.setText(2131718206);
            i1 = 3;
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetButton.setText(i2);
          }
        }
        VasWebviewUtil.a(this.app.getCurrentAccountUin(), "faceAddon", "0X80088ED", "", 1, 0, 0, null, String.valueOf(i1), String.valueOf(this.jdField_a_of_type_Long));
        ReportController.b(this.app, "CliOper", "", "", "0X8005FD5", "0X8005FD5", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Long), "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_b_of_type_Int == 1) {
          ((AvatarPendantManager)localObject1).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.i);
        } else {
          ((AvatarPendantManager)localObject1).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 5, PendantInfo.i);
        }
        if (Build.VERSION.SDK_INT < 14) {
          return;
        }
        i1 = this.jdField_e_of_type_Int;
        if ((i1 == jdField_b_of_type_Int) || (i1 == jdField_c_of_type_Int))
        {
          paramAdapterView = (ViewGroup)paramAdapterView.getParent();
          localObject1 = (ViewGroup)paramAdapterView.getParent();
          i2 = paramAdapterView.getHeight();
          i3 = paramView.getHeight();
          int i4 = DisplayUtil.a(this, 7.0F);
          i1 = i2 - i3 - i4;
          if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_Boolean)
          {
            i1 = (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList.size() - 1) / 4;
            if (paramInt == 0) {
              paramInt = 0;
            } else {
              paramInt /= 4;
            }
            int i5 = DisplayUtil.a(this, 4.0F);
            i1 = i2 - (i1 + 1 - paramInt) * (i3 + i5) + i5 - i4;
          }
          i2 = this.jdField_g_of_type_Int - this.h;
          paramInt = ((ViewGroup)localObject1).getTop();
          if (((ViewGroup)localObject1).getTag() != null)
          {
            i3 = ((AvatarPendantAdapter.ViewHolder)((ViewGroup)localObject1).getTag()).jdField_a_of_type_Int;
            if (paramInt < 0)
            {
              paramInt = i1;
              if (i1 < 0) {
                paramInt = 0 - i1;
              }
              this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i3, i2 - paramInt);
            }
            else if (paramInt + i1 < i2)
            {
              this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i3, i2 - i1);
            }
          }
        }
        n();
      }
    }
    else if (paramAdapterView.getId() == 2131374767)
    {
      this.jdField_a_of_type_Long = -1L;
      p();
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarInPendantHeadportraitInfo = ((AvatarInPendantHeadportraitInfo)((AvatarPendantAdapter.FaceGridAdapter.GridFaceItemHolder)paramView.getTag()).a.getTag());
      this.s = this.jdField_a_of_type_ComTencentMobileqqVasAvatarInPendantHeadportraitInfo.jdField_a_of_type_Int;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      r();
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(this.s, 7, "large", ImageView.ScaleType.FIT_XY);
      paramView = this.app.getCurrentUin();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqVasAvatarInPendantHeadportraitInfo.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append("");
      VasWebviewUtil.a(paramView, "widget", "head_click", "", 1, 0, 0, "", ((StringBuilder)localObject1).toString(), "");
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("ChooseFaceId", this.jdField_a_of_type_ComTencentMobileqqVasAvatarInPendantHeadportraitInfo.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      paramView = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
      if (paramView.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a(paramView, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      }
      paramAdapterView = (ViewGroup)((ViewGroup)paramAdapterView.getParent()).getParent();
      if ((paramAdapterView.getTag() != null) && ((paramAdapterView.getTag() instanceof AvatarPendantAdapter.ViewHolder)))
      {
        paramAdapterView = (AvatarPendantAdapter.ViewHolder)paramAdapterView.getTag();
        paramInt = DisplayUtil.a(this, 100.0F);
        i1 = DisplayUtil.a(this, 20.0F);
        i2 = paramAdapterView.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarInPendantHeadportraitInfo.a()) {
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i2, paramInt);
        } else {
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i2, i1);
        }
        n();
      }
    }
    else if (paramAdapterView.getId() == 2131364790)
    {
      this.jdField_a_of_type_Long = -1L;
      p();
      this.jdField_a_of_type_ComTencentMobileqqApolloModelCmAvatarFaceInfo = ((CmAvatarFaceInfo)((CmshowFaceGridAdapter.CmshowFaceItemHolder)paramView.getTag()).a.getTag());
      this.s = this.jdField_a_of_type_ComTencentMobileqqApolloModelCmAvatarFaceInfo.getActionId();
      paramInt = ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.app.getCurrentUin());
      ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "cmshowavatar", "click", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.app)).c(String.valueOf(this.s)).f(paramInt).a());
      if (!c())
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(2131690047);
        ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "openBtn", "expose", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.app)).c(String.valueOf(this.s)).f(paramInt).a());
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(2131718206);
      }
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "setBtn", "expose", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.app)).c(String.valueOf(this.s)).f(paramInt).a());
      s();
      localObject1 = (IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onItemClick isHasGif actionId: ");
      ((StringBuilder)localObject2).append(this.s);
      QLog.i("AvatarPendantActivity", 2, ((StringBuilder)localObject2).toString());
      if (!((IApolloAvatarFileManager)localObject1).isHasGif(this.s, this.jdField_a_of_type_ComTencentMobileqqApolloModelCmAvatarFaceInfo.getActionType(), this.app.getCurrentUin())) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(this.app.getCurrentUin(), 7, "large", ImageView.ScaleType.FIT_XY, this.jdField_a_of_type_ComTencentMobileqqApolloModelCmAvatarFaceInfo.getActionId(), this.jdField_a_of_type_ComTencentMobileqqApolloModelCmAvatarFaceInfo.getActionType());
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("ChooseFaceId", this.jdField_a_of_type_ComTencentMobileqqApolloModelCmAvatarFaceInfo.getActionId()).apply();
      localObject1 = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
      if (((List)localObject1).size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      }
      paramAdapterView = (ViewGroup)paramAdapterView.getParent();
      localObject1 = (ViewGroup)paramAdapterView.getParent();
      i1 = paramAdapterView.getHeight() - paramView.getHeight() - DisplayUtil.a(this, 7.0F);
      i2 = this.jdField_g_of_type_Int - this.h;
      paramInt = ((ViewGroup)localObject1).getTop();
      if (((ViewGroup)localObject1).getTag() != null)
      {
        i3 = ((AvatarPendantAdapter.ViewHolder)((ViewGroup)localObject1).getTag()).jdField_a_of_type_Int;
        if (paramInt < 0)
        {
          paramInt = i1;
          if (i1 < 0) {
            paramInt = 0 - i1;
          }
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i3, i2 - paramInt);
        }
        else if (paramInt + i1 < i2)
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i3, i2 - i1);
        }
      }
      n();
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = this.jdField_a_of_type_AndroidWidgetTextView.getVisibility();
    boolean bool2 = true;
    if (paramInt1 == 0)
    {
      paramView = findViewById(2131380129);
      View localView = findViewById(2131378757);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getRight() > this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.getLeft()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramView.getTop() + this.jdField_b_of_type_AndroidWidgetImageView.getBottom() > this.jdField_a_of_type_AndroidViewView.getTop() + localView.getTop()) {
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
    if ((this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) || (this.jdField_b_of_type_AndroidViewView.getBottom() <= this.jdField_c_of_type_AndroidViewView.getTop() + this.jdField_a_of_type_AndroidViewView.getTop())) {
      bool2 = false;
    }
    if ((bool1) || (bool2)) {
      ThreadManager.getUIHandler().post(new AvatarPendantActivity.RemoveTips(this, bool1, bool2));
    }
    paramView = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    double d1 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams().width;
    Double.isNaN(d1);
    paramInt1 = (int)(d1 * 0.18D);
    paramView.width = paramInt1;
    paramView.height = paramInt1;
    this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity
 * JD-Core Version:    0.7.0.1
 */