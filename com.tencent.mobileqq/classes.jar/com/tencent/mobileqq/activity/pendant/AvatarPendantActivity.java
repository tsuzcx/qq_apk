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
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter.FaceGridAdapter.GridFaceItemHolder;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter.PendantGridAdapter.GridItemHolder;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter.ViewHolder;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.api.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.api.ui.impl.CmshowFaceGridAdapter.CmshowFaceItemHolder;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager;
import com.tencent.mobileqq.apollo.player.IGetGifFrameCallback;
import com.tencent.mobileqq.apollo.screenshot.ApolloAvatarVideoProcessor;
import com.tencent.mobileqq.apollo.screenshot.ApolloAvatarVideoProcessor.OnProcessFinishListener;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
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
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarInPendantHeadportraitInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.AvatarPendantShopItemInfo;
import com.tencent.mobileqq.vas.AvatarPendantShopSeriesInfo;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloaderFactory;
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
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AvatarPendantActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, View.OnLayoutChangeListener, AdapterView.OnItemClickListener
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
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
  ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  AvatarPendantAdapter jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter;
  IApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver = new AvatarPendantActivity.18(this);
  private ApolloExtensionObserverImpl jdField_a_of_type_ComTencentMobileqqApolloApiHandlerImplApolloExtensionObserverImpl = new AvatarPendantActivity.30(this);
  private CmAvatarFaceInfo jdField_a_of_type_ComTencentMobileqqApolloApiModelCmAvatarFaceInfo;
  public IGetGifFrameCallback a;
  private ApolloAvatarVideoProcessor jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloAvatarVideoProcessor;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new AvatarPendantActivity.1(this);
  SVIPHandler jdField_a_of_type_ComTencentMobileqqAppSVIPHandler;
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new AvatarPendantActivity.3(this);
  UniPayHandler.UniPayUpdateListener jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener = new AvatarPendantActivity.10(this);
  UniPayHandler jdField_a_of_type_ComTencentMobileqqAppUniPayHandler;
  DynamicAvatarView jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new AvatarPendantActivity.24(this);
  TipsBar jdField_a_of_type_ComTencentMobileqqBannerTipsBar;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new AvatarPendantActivity.5(this);
  BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  AvatarInPendantHeadportraitInfo jdField_a_of_type_ComTencentMobileqqVasAvatarInPendantHeadportraitInfo;
  AvatarPendantShopItemInfo jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo;
  AvatarPendantShopSeriesInfo jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo;
  AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new AvatarPendantActivity.23(this);
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
  int q;
  int r = 0;
  public int s = -1;
  public int t = -1;
  int u;
  private int v;
  private int w;
  private int x;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
  }
  
  public AvatarPendantActivity()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerIGetGifFrameCallback = new AvatarPendantActivity.31(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ApolloAvatarFileManager.a().a(paramInt1, paramInt2, this.app.getCurrentUin(), new AvatarPendantActivity.27(this));
  }
  
  private void a(int paramInt1, int paramInt2, ApolloAvatarVideoProcessor.OnProcessFinishListener paramOnProcessFinishListener)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloAvatarVideoProcessor != null) && (Build.VERSION.SDK_INT >= 21))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloAvatarVideoProcessor.a(paramOnProcessFinishListener);
      this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloAvatarVideoProcessor.a(paramInt1, paramInt2);
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
      }
    }
    else
    {
      switch (paramIntent.getIntExtra("fromWhereClick", -1))
      {
      default: 
        return;
      case 10: 
        ReportController.b(this.app, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 1, 0, "1", "", "", "");
        return;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 0, 0, "0", "", "", "");
      return;
    }
    QQToast.a(this, 1, 2131719065, 0).b(getTitleBarHeight());
  }
  
  private void a(@NonNull CmAvatarFaceInfo paramCmAvatarFaceInfo)
  {
    int i1 = paramCmAvatarFaceInfo.getActionId();
    int i2 = paramCmAvatarFaceInfo.getActionType();
    if (paramCmAvatarFaceInfo.isDynamic())
    {
      a(i1, i2, new AvatarPendantActivity.28(this, paramCmAvatarFaceInfo));
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
    int i1 = 0;
    ExtensionInfo localExtensionInfo = this.app.getExtensionInfo(this.app.getCurrentAccountUin(), false);
    if (paramBoolean) {}
    for (;;)
    {
      if ((localExtensionInfo != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (i1 != this.s))
      {
        this.s = i1;
        this.t = this.s;
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("ChooseFaceId", -1);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("mSelectFaceId", this.s);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      }
      return;
      if (localExtensionInfo != null) {
        i1 = localExtensionInfo.faceId;
      }
    }
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "initHDHeadUrl: uin=" + paramString);
    }
    Setting localSetting = this.app.getQQHeadSettingFromDB(paramString);
    if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.url)))
    {
      String str = AvatarDownloadUtil.get1080QQHeadDownLoadUrl(localSetting.url, localSetting.bFaceFlags);
      paramString = str;
      if (!TextUtils.isEmpty(str)) {
        paramString = MsfSdkUtils.insertMtype("QQHeadIcon", str);
      }
      this.jdField_d_of_type_Long = localSetting.headImgTimestamp;
      ThreadManager.getUIHandler().post(new AvatarPendantActivity.25(this, paramString));
      return;
    }
    this.app.refreshFace(paramString);
  }
  
  private void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "onGetHDHeadUrl: url=" + paramString);
    }
    this.jdField_c_of_type_JavaLangString = paramString;
    if (f())
    {
      paramString = FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getWidth();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getHeight();
      localURLDrawableOptions.mFailedDrawable = paramString;
      localURLDrawableOptions.mLoadingDrawable = paramString;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getDrawable() instanceof BitmapDrawable)) {
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getDrawable();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      this.jdField_c_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + "?" + this.jdField_d_of_type_Long);
      URLDrawable.removeMemoryCacheByUrl(this.jdField_c_of_type_JavaLangString, localURLDrawableOptions);
      paramString = URLDrawable.getDrawable(this.jdField_c_of_type_JavaLangString, localURLDrawableOptions);
      if (SimpleUIUtil.a())
      {
        paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
        paramString.setTag(new int[] { 640, 640, 45 });
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantActivity", 2, "onGetHDHeadUrl: newDisplayHDHead");
        }
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, paramString, 1, 200, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 640, true, null, false, true, false, true, 7);
        return;
        paramString.setDecodeHandler(URLDrawableDecodeHandler.a);
        paramString.setTag(new int[] { 640, 640 });
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "onGetHDHeadUrl: oldDisplayHead");
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 640, true, true, true, false, 7);
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
    boolean bool = false;
    int i1;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      i1 = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvatarPendantActivity", 2, "isNeedShowHDHead, result=" + bool + ", hdHeadUrl=" + this.jdField_c_of_type_JavaLangString + ",openflag=" + i1);
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(bool);
      return bool;
      String[] arrayOfString = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.headCfg.name(), "24|3500|1|0").split("\\|");
      if (arrayOfString.length > 3)
      {
        int i2 = Integer.parseInt(arrayOfString[3]);
        i1 = i2;
        if (i2 != 0)
        {
          bool = true;
          i1 = i2;
        }
      }
      else
      {
        i1 = 0;
      }
    }
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
    Object localObject = ((DownloaderFactory)this.app.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    File localFile1 = new File(AvatarPendantUtil.jdField_b_of_type_JavaLangString);
    if (!localFile1.exists()) {
      localFile1.mkdir();
    }
    File localFile2 = new File(AvatarPendantUtil.jdField_b_of_type_JavaLangString + "/icon.zip");
    if ((localFile1.exists()) && (!localFile2.exists()) && (localObject != null)) {
      ThreadManager.getSubThreadHandler().post(new AvatarPendantActivity.IconRunnable(this, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, this.app));
    }
    localObject = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
    this.app.getApp().getSharedPreferences(ClubContentJsonTask.jdField_a_of_type_JavaLangString, 0);
    if (((List)localObject).size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      return;
    }
    if (new File(this.jdField_a_of_type_JavaLangString).exists())
    {
      ((List)localObject).clear();
      e();
      return;
    }
    localIVasQuickUpdateService.downloadItem(1000L, "pendant_market_json.android.v2", "pendant_market");
  }
  
  private void k()
  {
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131379487);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131363785);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131380877);
    View localView = super.findViewById(2131374762);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131380878));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131372842));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)findViewById(2131380876));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)super.findViewById(2131363511));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131380882));
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131380881);
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar = ((TipsBar)super.findViewById(2131379395));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131377444));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131377445));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372857));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366573));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363512));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131377441));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131377439));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131370723));
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131370745);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
    this.jdField_c_of_type_AndroidViewView.addOnLayoutChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    findViewById(2131369495).setOnClickListener(this);
    Object localObject1 = (TextView)findViewById(2131366572);
    ((TextView)localObject1).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, (View)localObject1).b(53).a();
    m();
    localObject1 = (TextView)super.findViewById(2131369487);
    ((TextView)localObject1).setText("");
    ((TextView)localObject1).setOnClickListener(this);
    localObject1 = (TextView)super.findViewById(2131369534);
    ((TextView)localObject1).setText(" ");
    ((TextView)localObject1).setFocusable(true);
    ((TextView)localObject1).setFocusableInTouchMode(true);
    ((TextView)localObject1).setClickable(true);
    ((TextView)localObject1).setContentDescription(" ");
    localObject1 = (RelativeLayout)super.findViewById(2131379487);
    localObject1 = getWindowManager().getDefaultDisplay();
    int i1 = ((Display)localObject1).getHeight();
    int i2 = ((Display)localObject1).getWidth();
    double d3 = i1 / i2;
    if ((Build.VERSION.SDK_INT >= 24) && (!isInMultiWindowMode()) && (!isInPictureInPictureMode()) && (d3 < 1.5D)) {
      d3 = 1.5D;
    }
    for (;;)
    {
      double d1 = d3 - 1.78D;
      this.jdField_f_of_type_Int = (i1 - a());
      this.jdField_e_of_type_Int = jdField_a_of_type_Int;
      double d2 = 0.58D * (d3 - 2.0D * d1) / 1.8D;
      d1 = (1.85D - d1 * 2.0D) * 0.38D / d3;
      Object localObject2;
      RelativeLayout.LayoutParams localLayoutParams;
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        d1 = d3 - 1.67D;
        a();
        i2 = super.getResources().getDimensionPixelSize(2131299166);
        localObject2 = (RelativeLayout)super.findViewById(2131380865);
        localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
        localLayoutParams.topMargin = (i2 / 2 + 14 - (int)(Math.abs(d1) * 24.0D));
        ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams);
        d2 = 0.58D * (1.8D + 2.0D * d1) / d3;
        d1 = 0.38D * (d1 * 2.0D + 1.95D) / d3;
      }
      for (;;)
      {
        if (d3 < 1.2D)
        {
          this.jdField_f_of_type_Int = i1;
          d2 = 1.0D;
          d1 = 1.0D;
        }
        for (;;)
        {
          this.g = ((int)(this.jdField_f_of_type_Int * d2));
          this.h = ((int)(this.jdField_f_of_type_Int * d1));
          if (!this.jdField_b_of_type_Boolean)
          {
            super.findViewById(2131380869).setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTipsText("没有SD卡无法使用头像挂件");
            this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.a(false);
            this.g = ((int)((d2 + 0.06D) * this.jdField_f_of_type_Int));
            this.h = ((int)(d1 * this.jdField_f_of_type_Int));
            this.jdField_a_of_type_Boolean = true;
            this.i = ((int)(this.g * 0.383D));
            this.k = ((int)(186.05F * this.i / 150.0F));
            this.m = ((int)(222.05F * this.k / 186.0F));
            this.o = ((this.k - this.i) / 2);
            this.jdField_a_of_type_Double = ((this.h + 0.05F) / this.g);
            this.jdField_a_of_type_Double -= 0.24D;
            this.j = ((int)(this.i * this.jdField_a_of_type_Double));
            this.l = ((int)(this.k * this.jdField_a_of_type_Double));
            this.n = ((int)(this.m * this.jdField_a_of_type_Double));
            this.p = ((int)(this.o * this.jdField_a_of_type_Double));
            this.jdField_b_of_type_Double = ((this.i - this.j + 0.05F) / (this.g - this.h));
            localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
            localObject2 = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
            ((FrameLayout.LayoutParams)localObject1).topMargin = this.h;
            ((FrameLayout.LayoutParams)localObject2).height = this.g;
            this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLayoutParams();
            localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).width = this.i;
            ((RelativeLayout.LayoutParams)localObject1).height = this.i;
            ((RelativeLayout.LayoutParams)localObject2).width = this.k;
            ((RelativeLayout.LayoutParams)localObject2).height = this.m;
            localLayoutParams.height = this.o;
            this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
            this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            ThreadManager.excute(new AvatarPendantActivity.4(this), 32, null, false);
            q();
            if (!ThemeUtil.isInNightMode(this.app)) {
              break label1367;
            }
            if (localView != null) {
              localView.setVisibility(0);
            }
          }
          label1367:
          while (localView == null)
          {
            return;
            if (this.jdField_c_of_type_Boolean)
            {
              super.findViewById(2131380869).setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(0);
              this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTipsText(HardCodeUtil.a(2131700961));
              this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.a(false);
              this.g = ((int)((d2 + 0.06D) * this.jdField_f_of_type_Int));
              this.h = ((int)(d1 * this.jdField_f_of_type_Int));
              this.jdField_a_of_type_Boolean = true;
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter = new AvatarPendantAdapter(this, this, this, ((Display)localObject1).getWidth(), this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.g - this.h);
            this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter);
            break;
          }
          localView.setVisibility(8);
          return;
        }
      }
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
    if ((this.jdField_e_of_type_Int == jdField_a_of_type_Int) || (this.jdField_e_of_type_Int == jdField_d_of_type_Int)) {}
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = this.o;
    this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new AvatarPendantActivity.AnimRect();
    AvatarPendantActivity.AnimRect localAnimRect1 = new AvatarPendantActivity.AnimRect();
    AvatarPendantActivity.AnimRect localAnimRect2 = new AvatarPendantActivity.AnimRect();
    new AvatarPendantActivity.AnimRect();
    ((AvatarPendantActivity.AnimRect)localObject).jdField_c_of_type_Int = localLayoutParams.height;
    ((AvatarPendantActivity.AnimRect)localObject).jdField_d_of_type_Int = this.g;
    int i1 = localLayoutParams.topMargin;
    ((AvatarPendantActivity.AnimRect)localObject).jdField_b_of_type_Int = i1;
    ((AvatarPendantActivity.AnimRect)localObject).jdField_a_of_type_Int = i1;
    ((AvatarPendantActivity.AnimRect)localObject).g = ((int)(Math.abs(this.g - localLayoutParams.height) * 1.0D / this.g * ((AvatarPendantActivity.AnimRect)localObject).g));
    i1 = localLayoutParams1.topMargin;
    localAnimRect1.jdField_b_of_type_Int = i1;
    localAnimRect1.jdField_a_of_type_Int = i1;
    localAnimRect1.jdField_e_of_type_Int = localLayoutParams1.width;
    localAnimRect1.jdField_f_of_type_Int = this.i;
    localAnimRect1.jdField_c_of_type_Int = localLayoutParams1.height;
    localAnimRect1.jdField_d_of_type_Int = this.i;
    localAnimRect1.g = ((AvatarPendantActivity.AnimRect)localObject).g;
    i1 = localLayoutParams2.topMargin;
    localAnimRect2.jdField_b_of_type_Int = i1;
    localAnimRect2.jdField_a_of_type_Int = i1;
    localAnimRect2.jdField_e_of_type_Int = localLayoutParams2.width;
    localAnimRect2.jdField_f_of_type_Int = this.k;
    localAnimRect2.jdField_c_of_type_Int = localLayoutParams2.height;
    localAnimRect2.jdField_d_of_type_Int = this.m;
    localAnimRect2.g = ((AvatarPendantActivity.AnimRect)localObject).g;
    localArrayList2.add(this.jdField_c_of_type_AndroidViewView);
    localArrayList2.add(this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
    localArrayList2.add(this.jdField_b_of_type_AndroidWidgetImageView);
    localArrayList1.add(localObject);
    localArrayList1.add(localAnimRect1);
    localArrayList1.add(localAnimRect2);
    if (((AvatarPendantActivity.AnimRect)localObject).g <= 0)
    {
      QLog.e("AvatarPendantActivity", 2, "heigth: " + this.g + " palytime: " + ((AvatarPendantActivity.AnimRect)localObject).g);
      return;
    }
    a(localArrayList2, localArrayList1, ((AvatarPendantActivity.AnimRect)localObject).g);
  }
  
  private void o()
  {
    ThreadManager.getFileThreadHandler().post(new AvatarPendantActivity.11(this));
  }
  
  private void p()
  {
    if (!ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    Object localObject = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    long l1;
    long l2;
    if (localObject != null)
    {
      l1 = ((ExtensionInfo)localObject).pendantId;
      if (localObject == null) {
        break label183;
      }
      l2 = ((ExtensionInfo)localObject).pendantDiyId;
      label68:
      if ((this.jdField_a_of_type_Long == -1L) || (this.jdField_b_of_type_Long != l1) || (this.jdField_c_of_type_Long != l2)) {
        break label216;
      }
      localObject = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!AvatarPendantUtil.a(this.jdField_a_of_type_Long)) {
        break label192;
      }
      ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.i);
      label152:
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!d()) {
        break label466;
      }
    }
    label183:
    label192:
    label466:
    for (int i1 = 8;; i1 = 0)
    {
      ((TextView)localObject).setVisibility(i1);
      return;
      l1 = this.jdField_b_of_type_Long;
      break;
      l2 = this.jdField_c_of_type_Long;
      break label68;
      ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 5, PendantInfo.i);
      break label152;
      label216:
      if ((localObject != null) && (((ExtensionInfo)localObject).isPendantValid()))
      {
        this.jdField_b_of_type_Long = ((ExtensionInfo)localObject).pendantId;
        this.jdField_c_of_type_Long = ((ExtensionInfo)localObject).pendantDiyId;
        AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (AvatarPendantUtil.a(((ExtensionInfo)localObject).pendantId)) {
          localAvatarPendantManager.a(((ExtensionInfo)localObject).pendantId).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.i, this.app.getCurrentAccountUin(), ((ExtensionInfo)localObject).pendantDiyId);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131719100);
          ReportController.b(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "1", "", "", "");
          break;
          localAvatarPendantManager.a(((ExtensionInfo)localObject).pendantId).a(this.jdField_b_of_type_AndroidWidgetImageView, 5, PendantInfo.i, this.app.getCurrentAccountUin(), ((ExtensionInfo)localObject).pendantDiyId);
        }
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      ReportController.b(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "0", "", "", "");
      break label152;
    }
  }
  
  private void q()
  {
    Object localObject = new File(AvatarPendantUtil.jdField_c_of_type_JavaLangString + "/widget_display_bg.jpg");
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
    if ((this.t != -1) && (this.s != -1))
    {
      if (this.t == this.s)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131700951));
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131700950));
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  private void s()
  {
    if ((this.t != -1) && (this.s != -1))
    {
      if (this.t == this.s)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131700951));
        this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
    else {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131718541));
    this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  private void t()
  {
    Intent localIntent = new Intent();
    int i1 = ProfileCardUtil.b(this);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("Business_Origin", 100);
    localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    localIntent.putExtra("fromWhereClick", 11);
    PhotoUtils.startPhotoListEdit(localIntent, this, AvatarPendantActivity.class.getName(), i1, i1, 1080, 1080, FaceUtil.a());
    ReportController.b(this.app, "CliOper", "", "", "0X8004177", "0X8004177", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
  }
  
  private void u()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {}
      for (int i1 = 1; i1 != 0; i1 = 0)
      {
        requestPermissions(new AvatarPendantActivity.26(this), 0, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      t();
      return;
    }
    t();
  }
  
  private void v()
  {
    this.w = ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus(this.app);
  }
  
  private void w()
  {
    QLog.d("AvatarPendantActivity", 1, "getCmshowFaceDataFormNetwork start");
    ThreadManagerV2.executeOnSubThread(new AvatarPendantActivity.29(this));
  }
  
  public int a()
  {
    Object localObject1 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int i2 = ((Rect)localObject1).top;
    int i1 = i2;
    if (i2 == 0) {}
    try
    {
      localObject1 = Class.forName("com.android.internal.R$dimen");
      Object localObject2 = ((Class)localObject1).newInstance();
      i1 = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
      i1 = super.getResources().getDimensionPixelSize(i1);
      return i1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return i2;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return i2;
    }
    catch (InstantiationException localInstantiationException)
    {
      localInstantiationException.printStackTrace();
      return i2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return i2;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return i2;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return i2;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
    return i2;
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
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantActivity", 2, "verifyAuth, tipsInfo = " + paramPendantTipsInfo + "result = " + paramInt);
    }
    int i1 = paramPendantTipsInfo.type;
    boolean bool = NetworkUtil.d(this);
    if (bool) {}
    for (Object localObject = "4";; localObject = "3") {
      switch (i1)
      {
      default: 
        paramPendantTipsInfo = (PendantTipsInfo)localObject;
        if (paramLong == 0L) {
          break label491;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005FD7", "0X8005FD7", 0, 0, paramPendantTipsInfo, "", "", "");
        return;
      }
    }
    if (TextUtils.isEmpty(paramPendantTipsInfo.wording))
    {
      QLog.e("AvatarPendantActivity", 1, "verifyAuth, tipsInfo.wording is empty! type = PAYMENT");
      QQToast.a(this, 1, HardCodeUtil.a(2131700952), 0).b(getTitleBarHeight());
      return;
    }
    if (paramPendantTipsInfo.vipType.equals("LTMCLUB")) {
      localObject = "0";
    }
    for (;;)
    {
      if (!isFinishing()) {
        DialogUtil.a(this, 230).setTitle(paramPendantTipsInfo.titleWording).setMessage(paramPendantTipsInfo.wording).setPositiveButton(paramPendantTipsInfo.rightBtnWording, new AvatarPendantActivity.20(this, paramPendantTipsInfo, paramInt)).setNegativeButton(paramPendantTipsInfo.leftBtnWording, new AvatarPendantActivity.19(this)).show();
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8005FD8", "0X8005FD8", 0, 0, "", "", "", "");
      paramPendantTipsInfo = (PendantTipsInfo)localObject;
      break;
      if (paramPendantTipsInfo.equals("CJCLUBT"))
      {
        localObject = "1";
        continue;
        if (TextUtils.isEmpty(paramPendantTipsInfo.wording))
        {
          QLog.e("AvatarPendantActivity", 1, "verifyAuth, tipsInfo.wording is empty! type = JUMP_URL");
          QQToast.a(this, 1, HardCodeUtil.a(2131700947), 0).b(getTitleBarHeight());
          return;
        }
        paramPendantTipsInfo = DialogUtil.a(this, 230).setTitle(paramPendantTipsInfo.titleWording).setMessage(paramPendantTipsInfo.wording).setPositiveButton(paramPendantTipsInfo.rightBtnWording, new AvatarPendantActivity.22(this, paramPendantTipsInfo, paramInt)).setNegativeButton(paramPendantTipsInfo.leftBtnWording, new AvatarPendantActivity.21(this));
        localObject = paramPendantTipsInfo.getMessageTextView();
        ViewGroup.LayoutParams localLayoutParams = ((TextView)localObject).getLayoutParams();
        localLayoutParams.width = -1;
        ((TextView)localObject).setLayoutParams(localLayoutParams);
        ((TextView)localObject).setGravity(17);
        paramPendantTipsInfo.setMessageCount(null);
        paramPendantTipsInfo.show();
        paramPendantTipsInfo = "2";
        break;
        a(paramPendantTipsInfo, false, paramInt);
        paramPendantTipsInfo = (PendantTipsInfo)localObject;
        break;
        label491:
        localObject = this.app;
        if (bool) {}
        for (paramPendantTipsInfo = "2";; paramPendantTipsInfo = "1")
        {
          ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8006896", "0X8006896", 0, 0, paramPendantTipsInfo, "", "", "");
          return;
        }
      }
    }
  }
  
  public void a(PendantTipsInfo paramPendantTipsInfo, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantActivity", 2, "openVIP, tipsInfo = " + paramPendantTipsInfo);
    }
    String str1;
    String str2;
    Object localObject;
    if (paramPendantTipsInfo.type == 1)
    {
      if (paramBoolean)
      {
        str1 = "mvip.gxh.android.faceaddon_nati_dft";
        str2 = paramPendantTipsInfo.vipType;
        if (!str2.equals("LTMCLUB")) {
          break label155;
        }
        localObject = getString(2131695088);
      }
      for (;;)
      {
        if ((paramPendantTipsInfo.vipMonth < 1) || (paramPendantTipsInfo.vipMonth > 12))
        {
          QLog.e("AvatarPendantActivity", 1, "openVIP, vipMonth invalid = " + paramPendantTipsInfo.vipMonth);
          return;
          str1 = "mvip.gxh.android.faceaddon_nati_" + this.jdField_a_of_type_Long;
          break;
          label155:
          if (str2.equals("CJCLUBT"))
          {
            localObject = getString(2131719674);
          }
          else if (str2.equals("SVHHZLH"))
          {
            localObject = getString(2131690708);
          }
          else
          {
            QLog.e("AvatarPendantActivity", 2, "openVIP, unknown vipType = " + paramPendantTipsInfo.vipType);
            return;
          }
        }
      }
      if (((paramInt != 9002) && (paramInt != 9003)) || (paramPendantTipsInfo.vipMonth != 12)) {
        break label408;
      }
      if (paramInt != 9003) {
        break label403;
      }
      bool = true;
      paramBoolean = true;
    }
    for (;;)
    {
      VasH5PayUtil.a(null, this, str1, paramPendantTipsInfo.vipMonth, "1450000515", str2, (String)localObject, "", paramBoolean, bool);
      return;
      if ((paramPendantTipsInfo.type == 2) || (paramPendantTipsInfo.type == 3))
      {
        if (!TextUtils.isEmpty(paramPendantTipsInfo.url))
        {
          localObject = new Intent(this, QQBrowserActivity.class);
          VasWebviewUtil.openQQBrowserWithoutAD(this, paramPendantTipsInfo.url, -1L, (Intent)localObject, true, -1);
          return;
        }
        QLog.e("AvatarPendantActivity", 1, "openVIP, type = jump_url, but url == nul. tipsInfo = " + paramPendantTipsInfo);
        return;
      }
      QLog.e("AvatarPendantActivity", 1, "openVIP, action type is incorrect! tipsInfo = " + paramPendantTipsInfo);
      return;
      label403:
      paramBoolean = true;
      continue;
      label408:
      paramBoolean = false;
    }
  }
  
  public void a(String paramString)
  {
    int i2 = 0;
    SystemClock.uptimeMillis();
    paramString = new File(paramString);
    AvatarPendantUtil.a();
    if (paramString.exists()) {}
    for (;;)
    {
      int i3;
      try
      {
        Object localObject1 = FileUtils.b(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = new ArrayList();
        }
        JSONArray localJSONArray;
        int i1;
        AvatarInPendantHeadportraitInfo localAvatarInPendantHeadportraitInfo;
        Object localObject2;
        String str;
        Object localObject3;
        i1 += 1;
      }
      catch (OutOfMemoryError paramString)
      {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          localJSONArray = ((JSONObject)localObject1).optJSONArray("avatarInPendantTable");
          i1 = 0;
          if (i1 < localJSONArray.length())
          {
            localAvatarInPendantHeadportraitInfo = new AvatarInPendantHeadportraitInfo();
            localObject2 = localJSONArray.optJSONObject(i1);
            i3 = ((JSONObject)localObject2).optInt("id");
            str = ((JSONObject)localObject2).optString("type");
            localObject3 = ((JSONObject)localObject2).optJSONArray("baseInfo").optJSONObject(0);
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
              break label354;
            }
            localAvatarInPendantHeadportraitInfo.jdField_a_of_type_Boolean = true;
            break label354;
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("avatarInPendantCount");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
            AvatarPendantManager.jdField_a_of_type_Int = ((JSONArray)localObject1).optJSONObject(0).optInt("count");
          }
          localObject1 = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
          if (localObject1 != null)
          {
            ((AvatarPendantManager)localObject1).a(paramString);
            this.jdField_a_of_type_JavaUtilList = paramString;
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
          }
          return;
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("AvatarPendantActivity", 2, "parse facedata shop config fail", paramString);
          return;
        }
        paramString = paramString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AvatarPendantActivity", 2, "read config fail", paramString);
        return;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label354:
      while (i3 != 8)
      {
        i2 = i3;
        break;
      }
    }
  }
  
  public boolean a()
  {
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((localExtensionInfo != null) && (localExtensionInfo.pendantId == this.jdField_a_of_type_Long)) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    int i1 = 0;
    View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    int i2 = -localView.getTop();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition(), localView.getHeight());
    if (i1 < this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition())
    {
      if (this.jdField_a_of_type_AndroidUtilSparseIntArray.get(i1) == 0) {
        this.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        i1 += 1;
        break;
        i2 += this.jdField_a_of_type_AndroidUtilSparseIntArray.get(i1);
      }
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
    if ((i2 >= 0) || ((i2 <= 0) && (this.q <= this.g - this.h))) {
      localLayoutParams.height -= i2;
    }
    if (localLayoutParams.height <= this.h)
    {
      localLayoutParams.height = this.h;
      i1 = this.j;
      localLayoutParams1.height = i1;
      localLayoutParams1.width = i1;
      localLayoutParams2.width = this.l;
      localLayoutParams2.height = this.n;
      localLayoutParams3.height = this.p;
      this.jdField_e_of_type_Int = jdField_b_of_type_Int;
      if ((this.jdField_e_of_type_Int == jdField_c_of_type_Int) && ((i2 >= 0) || ((i2 <= 0) && (this.q <= this.g - this.h))))
      {
        i1 = i2;
        if (i2 != 0)
        {
          i1 = i2;
          if (i2 != 1) {
            if (i2 != -1) {
              break label423;
            }
          }
        }
      }
    }
    label423:
    for (i1 = i2;; i1 = (int)(i2 * this.jdField_b_of_type_Double))
    {
      localLayoutParams1.width -= i1;
      localLayoutParams1.height = localLayoutParams1.width;
      localLayoutParams2.width -= (int)(i1 * 186.05F / 150.0F);
      localLayoutParams2.height = ((int)(222.05F * localLayoutParams2.width / 186.0F));
      localLayoutParams3.height = ((localLayoutParams2.width - localLayoutParams1.width) / 2);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setLayoutParams(localLayoutParams1);
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
      this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams3);
      return;
      if (localLayoutParams.height >= this.g)
      {
        localLayoutParams.height = this.g;
        i1 = this.i;
        localLayoutParams1.height = i1;
        localLayoutParams1.width = i1;
        localLayoutParams2.width = this.k;
        localLayoutParams2.height = this.m;
        localLayoutParams3.height = this.o;
        this.jdField_e_of_type_Int = jdField_a_of_type_Int;
        break;
      }
      this.jdField_e_of_type_Int = jdField_c_of_type_Int;
      break;
    }
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 1546	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: new 722	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 728	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: invokestatic 1548	com/tencent/mobileqq/utils/AvatarPendantUtil:a	()V
    //   17: aload_1
    //   18: invokevirtual 731	java/io/File:exists	()Z
    //   21: ifeq +248 -> 269
    //   24: aload_1
    //   25: invokestatic 1553	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;)Ljava/lang/String;
    //   28: astore 12
    //   30: aload 12
    //   32: invokestatic 446	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne +234 -> 269
    //   38: aload_0
    //   39: getfield 208	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: getstatic 681	com/tencent/mobileqq/app/QQManagerFactory:CHAT_AVATAR_PENDANT_MANAGER	I
    //   45: invokevirtual 685	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   48: checkcast 687	com/tencent/mobileqq/vas/AvatarPendantManager
    //   51: invokevirtual 746	com/tencent/mobileqq/vas/AvatarPendantManager:a	()Ljava/util/List;
    //   54: astore 11
    //   56: new 1555	org/json/JSONObject
    //   59: dup
    //   60: aload 12
    //   62: invokespecial 1556	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   65: astore 12
    //   67: aload 12
    //   69: ldc_w 1648
    //   72: invokevirtual 1652	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   75: ifeq +155 -> 230
    //   78: aload 12
    //   80: ldc_w 1648
    //   83: invokevirtual 1655	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   86: iconst_1
    //   87: if_icmpne +137 -> 224
    //   90: iconst_1
    //   91: istore 10
    //   93: iload 10
    //   95: putstatic 1656	com/tencent/mobileqq/vas/AvatarPendantManager:jdField_c_of_type_Boolean	Z
    //   98: aload 12
    //   100: ldc_w 1658
    //   103: invokevirtual 1661	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   106: astore 15
    //   108: new 1663	java/util/HashSet
    //   111: dup
    //   112: invokespecial 1664	java/util/HashSet:<init>	()V
    //   115: astore 13
    //   117: aload 15
    //   119: ldc_w 1666
    //   122: invokevirtual 1652	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   125: ifeq +200 -> 325
    //   128: aload 15
    //   130: ldc_w 1666
    //   133: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore 14
    //   138: aload 14
    //   140: invokestatic 446	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifne +182 -> 325
    //   146: aload 14
    //   148: ldc_w 1668
    //   151: invokevirtual 670	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   154: astore 14
    //   156: aload 14
    //   158: arraylength
    //   159: istore_3
    //   160: iconst_0
    //   161: istore_2
    //   162: iload_2
    //   163: iload_3
    //   164: if_icmpge +161 -> 325
    //   167: aload 14
    //   169: iload_2
    //   170: aaload
    //   171: astore 16
    //   173: aload 16
    //   175: invokestatic 446	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   178: ifne +14 -> 192
    //   181: aload 13
    //   183: aload 16
    //   185: invokestatic 1672	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   188: invokevirtual 1673	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   191: pop
    //   192: iload_2
    //   193: iconst_1
    //   194: iadd
    //   195: istore_2
    //   196: goto -34 -> 162
    //   199: astore_1
    //   200: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +14 -> 217
    //   206: ldc_w 416
    //   209: iconst_2
    //   210: ldc_w 1622
    //   213: aload_1
    //   214: invokestatic 1625	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: return
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual 1626	java/io/IOException:printStackTrace	()V
    //   223: return
    //   224: iconst_0
    //   225: istore 10
    //   227: goto -134 -> 93
    //   230: iconst_0
    //   231: putstatic 1656	com/tencent/mobileqq/vas/AvatarPendantManager:jdField_c_of_type_Boolean	Z
    //   234: goto -136 -> 98
    //   237: astore 12
    //   239: aload 11
    //   241: invokeinterface 760 1 0
    //   246: aload_1
    //   247: invokevirtual 1676	java/io/File:delete	()Z
    //   250: pop
    //   251: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +15 -> 269
    //   257: ldc_w 416
    //   260: iconst_2
    //   261: ldc_w 1678
    //   264: aload 12
    //   266: invokestatic 1625	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   269: invokestatic 1546	android/os/SystemClock:uptimeMillis	()J
    //   272: lstore 8
    //   274: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq -60 -> 217
    //   280: ldc_w 416
    //   283: iconst_2
    //   284: new 418	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 419	java/lang/StringBuilder:<init>	()V
    //   291: ldc_w 1680
    //   294: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: lload 8
    //   299: lload 6
    //   301: lsub
    //   302: invokevirtual 554	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: ldc_w 1682
    //   308: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_1
    //   312: invokevirtual 1684	java/io/File:length	()J
    //   315: invokevirtual 554	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   318: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 431	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: return
    //   325: new 1663	java/util/HashSet
    //   328: dup
    //   329: invokespecial 1664	java/util/HashSet:<init>	()V
    //   332: astore 14
    //   334: aload 15
    //   336: ldc_w 1686
    //   339: invokevirtual 1652	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   342: ifeq +70 -> 412
    //   345: aload 15
    //   347: ldc_w 1686
    //   350: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   353: astore 16
    //   355: aload 16
    //   357: invokestatic 446	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   360: ifne +52 -> 412
    //   363: aload 16
    //   365: ldc_w 1668
    //   368: invokevirtual 670	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   371: astore 16
    //   373: aload 16
    //   375: arraylength
    //   376: istore_3
    //   377: iconst_0
    //   378: istore_2
    //   379: iload_2
    //   380: iload_3
    //   381: if_icmpge +31 -> 412
    //   384: aload 16
    //   386: iload_2
    //   387: aaload
    //   388: astore 17
    //   390: aload 17
    //   392: invokestatic 446	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   395: ifne +933 -> 1328
    //   398: aload 14
    //   400: aload 17
    //   402: invokestatic 1672	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   405: invokevirtual 1673	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   408: pop
    //   409: goto +919 -> 1328
    //   412: new 1663	java/util/HashSet
    //   415: dup
    //   416: invokespecial 1664	java/util/HashSet:<init>	()V
    //   419: astore 16
    //   421: aload 15
    //   423: ldc_w 1688
    //   426: invokevirtual 1652	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   429: ifeq +70 -> 499
    //   432: aload 15
    //   434: ldc_w 1688
    //   437: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   440: astore 15
    //   442: aload 15
    //   444: invokestatic 446	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   447: ifne +52 -> 499
    //   450: aload 15
    //   452: ldc_w 1668
    //   455: invokevirtual 670	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   458: astore 15
    //   460: aload 15
    //   462: arraylength
    //   463: istore_3
    //   464: iconst_0
    //   465: istore_2
    //   466: iload_2
    //   467: iload_3
    //   468: if_icmpge +31 -> 499
    //   471: aload 15
    //   473: iload_2
    //   474: aaload
    //   475: astore 17
    //   477: aload 17
    //   479: invokestatic 446	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   482: ifne +853 -> 1335
    //   485: aload 16
    //   487: aload 17
    //   489: invokestatic 1672	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   492: invokevirtual 1673	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   495: pop
    //   496: goto +839 -> 1335
    //   499: new 1690	android/util/SparseArray
    //   502: dup
    //   503: invokespecial 1691	android/util/SparseArray:<init>	()V
    //   506: astore 15
    //   508: aload 12
    //   510: ldc_w 1693
    //   513: invokevirtual 1661	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   516: astore 17
    //   518: aload 17
    //   520: invokevirtual 1697	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   523: astore 18
    //   525: aload 18
    //   527: invokeinterface 1702 1 0
    //   532: ifeq +378 -> 910
    //   535: aload 18
    //   537: invokeinterface 1705 1 0
    //   542: invokevirtual 1310	java/lang/Object:toString	()Ljava/lang/String;
    //   545: astore 19
    //   547: aload 19
    //   549: ifnull -24 -> 525
    //   552: aload 17
    //   554: aload 19
    //   556: invokevirtual 1661	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   559: astore 20
    //   561: aload 20
    //   563: ldc_w 1707
    //   566: invokevirtual 1661	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   569: astore 21
    //   571: aload 21
    //   573: ldc_w 1709
    //   576: invokevirtual 1655	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   579: ifeq -54 -> 525
    //   582: aload 21
    //   584: ldc_w 1711
    //   587: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   590: invokestatic 1715	com/tencent/common/config/AppSetting:a	(Ljava/lang/String;)I
    //   593: iflt -68 -> 525
    //   596: new 1717	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo
    //   599: dup
    //   600: invokespecial 1718	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:<init>	()V
    //   603: astore 19
    //   605: aload 19
    //   607: aload 21
    //   609: ldc_w 1720
    //   612: invokevirtual 1655	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   615: putfield 1721	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_c_of_type_Int	I
    //   618: aload 19
    //   620: aload 21
    //   622: ldc_w 1723
    //   625: invokevirtual 1655	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   628: putfield 1724	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_d_of_type_Int	I
    //   631: aload 19
    //   633: aload 21
    //   635: ldc_w 1726
    //   638: invokevirtual 1730	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   641: putfield 1731	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Long	J
    //   644: aload 19
    //   646: aload 21
    //   648: ldc_w 1733
    //   651: invokevirtual 1730	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   654: putfield 1734	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_b_of_type_Long	J
    //   657: aload 20
    //   659: ldc_w 1585
    //   662: invokevirtual 1661	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   665: astore 20
    //   667: aload 19
    //   669: aload 20
    //   671: ldc_w 1580
    //   674: invokevirtual 1655	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   677: putfield 1735	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_b_of_type_Int	I
    //   680: aload 19
    //   682: aload 20
    //   684: ldc_w 1586
    //   687: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   690: putfield 1736	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   693: aload 19
    //   695: aload 20
    //   697: ldc_w 1738
    //   700: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   703: putfield 1739	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   706: aload 19
    //   708: aload 20
    //   710: ldc_w 1576
    //   713: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   716: invokestatic 1672	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   719: invokevirtual 1742	java/lang/Integer:intValue	()I
    //   722: putfield 1743	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Int	I
    //   725: aload 20
    //   727: ldc_w 1745
    //   730: invokevirtual 1655	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   733: iconst_1
    //   734: if_icmpne +608 -> 1342
    //   737: iconst_1
    //   738: istore 10
    //   740: aload 19
    //   742: iload 10
    //   744: putfield 1746	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Boolean	Z
    //   747: aload 19
    //   749: aload 20
    //   751: ldc_w 1748
    //   754: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   757: putfield 1749	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   760: aload 13
    //   762: aload 19
    //   764: getfield 1743	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Int	I
    //   767: invokestatic 1752	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   770: invokevirtual 1755	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   773: ifeq +91 -> 864
    //   776: aload 19
    //   778: bipush 7
    //   780: putfield 1756	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_e_of_type_Int	I
    //   783: invokestatic 1761	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   786: lstore 8
    //   788: aload 19
    //   790: getfield 1721	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_c_of_type_Int	I
    //   793: iconst_1
    //   794: if_icmpne +96 -> 890
    //   797: aload 19
    //   799: getfield 1731	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Long	J
    //   802: lload 8
    //   804: lcmp
    //   805: ifgt +85 -> 890
    //   808: lload 8
    //   810: aload 19
    //   812: getfield 1734	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_b_of_type_Long	J
    //   815: lcmp
    //   816: ifgt +74 -> 890
    //   819: aload 19
    //   821: bipush 10
    //   823: putfield 1762	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_f_of_type_Int	I
    //   826: aload 16
    //   828: aload 19
    //   830: getfield 1743	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Int	I
    //   833: invokestatic 1752	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   836: invokevirtual 1755	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   839: ifeq +10 -> 849
    //   842: aload 19
    //   844: bipush 9
    //   846: putfield 1762	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_f_of_type_Int	I
    //   849: aload 15
    //   851: aload 19
    //   853: getfield 1743	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Int	I
    //   856: aload 19
    //   858: invokevirtual 1765	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   861: goto -336 -> 525
    //   864: aload 14
    //   866: aload 19
    //   868: getfield 1743	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Int	I
    //   871: invokestatic 1752	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   874: invokevirtual 1755	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   877: ifeq -94 -> 783
    //   880: aload 19
    //   882: bipush 8
    //   884: putfield 1756	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_e_of_type_Int	I
    //   887: goto -104 -> 783
    //   890: aload 19
    //   892: getfield 1721	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_c_of_type_Int	I
    //   895: bipush 6
    //   897: if_icmpne -71 -> 826
    //   900: aload 19
    //   902: bipush 6
    //   904: putfield 1762	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_f_of_type_Int	I
    //   907: goto -81 -> 826
    //   910: aload 11
    //   912: invokeinterface 760 1 0
    //   917: aload 12
    //   919: ldc_w 1767
    //   922: invokevirtual 1770	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   925: astore 13
    //   927: aload 13
    //   929: invokevirtual 1567	org/json/JSONArray:length	()I
    //   932: istore 4
    //   934: iconst_0
    //   935: istore_2
    //   936: iload_2
    //   937: iload 4
    //   939: if_icmpge +336 -> 1275
    //   942: aload 13
    //   944: iload_2
    //   945: invokevirtual 1773	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   948: checkcast 1555	org/json/JSONObject
    //   951: astore 14
    //   953: aload 14
    //   955: ldc_w 1709
    //   958: invokevirtual 1655	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   961: ifne +6 -> 967
    //   964: goto +384 -> 1348
    //   967: aload 14
    //   969: ldc_w 1775
    //   972: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   975: astore 17
    //   977: aload 17
    //   979: invokestatic 446	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   982: ifne +366 -> 1348
    //   985: aload 14
    //   987: ldc_w 1777
    //   990: invokevirtual 1655	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   993: bipush 100
    //   995: if_icmpge +353 -> 1348
    //   998: new 1779	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo
    //   1001: dup
    //   1002: invokespecial 1780	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:<init>	()V
    //   1005: astore 16
    //   1007: aload 16
    //   1009: new 1081	java/util/ArrayList
    //   1012: dup
    //   1013: invokespecial 1082	java/util/ArrayList:<init>	()V
    //   1016: putfield 1781	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1019: aload 17
    //   1021: ldc_w 1668
    //   1024: invokevirtual 670	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1027: astore 17
    //   1029: aload 17
    //   1031: arraylength
    //   1032: istore 5
    //   1034: iconst_0
    //   1035: istore_3
    //   1036: iload_3
    //   1037: iload 5
    //   1039: if_icmpge +56 -> 1095
    //   1042: aload 17
    //   1044: iload_3
    //   1045: aaload
    //   1046: astore 18
    //   1048: aload 18
    //   1050: invokestatic 446	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1053: ifne +302 -> 1355
    //   1056: aload 15
    //   1058: aload 18
    //   1060: invokestatic 1672	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1063: invokevirtual 1742	java/lang/Integer:intValue	()I
    //   1066: invokevirtual 1782	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1069: checkcast 1717	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo
    //   1072: astore 18
    //   1074: aload 18
    //   1076: ifnull +279 -> 1355
    //   1079: aload 16
    //   1081: getfield 1781	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1084: aload 18
    //   1086: invokeinterface 1098 2 0
    //   1091: pop
    //   1092: goto +263 -> 1355
    //   1095: aload 16
    //   1097: getfield 1781	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1100: invokeinterface 379 1 0
    //   1105: ifle +243 -> 1348
    //   1108: aload 16
    //   1110: aload 14
    //   1112: ldc_w 1777
    //   1115: invokevirtual 1655	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1118: putfield 1783	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_a_of_type_Int	I
    //   1121: aload 16
    //   1123: aload 14
    //   1125: ldc_w 1785
    //   1128: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1131: putfield 1786	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1134: aload 14
    //   1136: ldc_w 1788
    //   1139: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1142: invokestatic 446	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1145: ifne +121 -> 1266
    //   1148: aload 16
    //   1150: aload 14
    //   1152: ldc_w 1788
    //   1155: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1158: invokestatic 1672	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1161: invokevirtual 1742	java/lang/Integer:intValue	()I
    //   1164: putfield 1789	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_b_of_type_Int	I
    //   1167: aload 16
    //   1169: aload 14
    //   1171: ldc_w 1748
    //   1174: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1177: putfield 1791	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1180: aload 16
    //   1182: aload 14
    //   1184: ldc_w 1793
    //   1187: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1190: putfield 1794	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1193: aload 16
    //   1195: aload 14
    //   1197: ldc_w 1796
    //   1200: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1203: putfield 1797	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1206: aload 16
    //   1208: aload 14
    //   1210: ldc_w 1586
    //   1213: invokevirtual 1588	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1216: putfield 1798	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1219: aload 16
    //   1221: iconst_m1
    //   1222: putfield 1799	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_c_of_type_Int	I
    //   1225: aload 16
    //   1227: getfield 1794	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1230: ifnull +23 -> 1253
    //   1233: aload 16
    //   1235: getfield 1794	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1238: ldc_w 265
    //   1241: invokevirtual 1409	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1244: ifne +9 -> 1253
    //   1247: aload 16
    //   1249: iconst_1
    //   1250: putfield 1800	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_a_of_type_Boolean	Z
    //   1253: aload 11
    //   1255: aload 16
    //   1257: invokeinterface 1098 2 0
    //   1262: pop
    //   1263: goto +85 -> 1348
    //   1266: aload 16
    //   1268: iconst_0
    //   1269: putfield 1789	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_b_of_type_Int	I
    //   1272: goto -105 -> 1167
    //   1275: aload 12
    //   1277: invokestatic 1805	com/tencent/mobileqq/activity/pendant/PendantMarketConfig:a	(Lorg/json/JSONObject;)V
    //   1280: aload_0
    //   1281: getfield 1614	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1284: sipush 1000
    //   1287: invokevirtual 1620	android/os/Handler:sendEmptyMessage	(I)Z
    //   1290: pop
    //   1291: aload_0
    //   1292: getfield 208	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1295: invokevirtual 597	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1298: getstatic 749	com/tencent/mobileqq/vas/ClubContentJsonTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1301: iconst_0
    //   1302: invokevirtual 603	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1305: invokeinterface 615 1 0
    //   1310: getstatic 749	com/tencent/mobileqq/vas/ClubContentJsonTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1313: iconst_0
    //   1314: invokeinterface 619 3 0
    //   1319: invokeinterface 622 1 0
    //   1324: pop
    //   1325: goto -1056 -> 269
    //   1328: iload_2
    //   1329: iconst_1
    //   1330: iadd
    //   1331: istore_2
    //   1332: goto -953 -> 379
    //   1335: iload_2
    //   1336: iconst_1
    //   1337: iadd
    //   1338: istore_2
    //   1339: goto -873 -> 466
    //   1342: iconst_0
    //   1343: istore 10
    //   1345: goto -605 -> 740
    //   1348: iload_2
    //   1349: iconst_1
    //   1350: iadd
    //   1351: istore_2
    //   1352: goto -416 -> 936
    //   1355: iload_3
    //   1356: iconst_1
    //   1357: iadd
    //   1358: istore_3
    //   1359: goto -323 -> 1036
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1362	0	this	AvatarPendantActivity
    //   0	1362	1	paramString	String
    //   161	1191	2	i1	int
    //   159	1200	3	i2	int
    //   932	8	4	i3	int
    //   1032	8	5	i4	int
    //   3	297	6	l1	long
    //   272	537	8	l2	long
    //   91	1253	10	bool	boolean
    //   54	1200	11	localList	List
    //   28	71	12	localObject1	Object
    //   237	1039	12	localException	Exception
    //   115	828	13	localObject2	Object
    //   136	1073	14	localObject3	Object
    //   106	951	15	localObject4	Object
    //   171	1096	16	localObject5	Object
    //   388	655	17	localObject6	Object
    //   523	562	18	localObject7	Object
    //   545	356	19	localObject8	Object
    //   559	191	20	localJSONObject1	JSONObject
    //   569	78	21	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   24	30	199	java/lang/OutOfMemoryError
    //   24	30	218	java/io/IOException
    //   56	90	237	java/lang/Exception
    //   93	98	237	java/lang/Exception
    //   98	160	237	java/lang/Exception
    //   173	192	237	java/lang/Exception
    //   230	234	237	java/lang/Exception
    //   325	377	237	java/lang/Exception
    //   390	409	237	java/lang/Exception
    //   412	464	237	java/lang/Exception
    //   477	496	237	java/lang/Exception
    //   499	525	237	java/lang/Exception
    //   525	547	237	java/lang/Exception
    //   552	737	237	java/lang/Exception
    //   740	783	237	java/lang/Exception
    //   783	826	237	java/lang/Exception
    //   826	849	237	java/lang/Exception
    //   849	861	237	java/lang/Exception
    //   864	887	237	java/lang/Exception
    //   890	907	237	java/lang/Exception
    //   910	934	237	java/lang/Exception
    //   942	964	237	java/lang/Exception
    //   967	1034	237	java/lang/Exception
    //   1048	1074	237	java/lang/Exception
    //   1079	1092	237	java/lang/Exception
    //   1095	1167	237	java/lang/Exception
    //   1167	1253	237	java/lang/Exception
    //   1253	1263	237	java/lang/Exception
    //   1266	1272	237	java/lang/Exception
    //   1275	1325	237	java/lang/Exception
  }
  
  public boolean b()
  {
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
    ImageView localImageView = (ImageView)super.findViewById(2131380870);
    TextView localTextView = (TextView)super.findViewById(2131380871);
    Button localButton = (Button)super.findViewById(2131380868);
    String str2 = this.app.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("uniPaySp_" + str2, 0);
    String str3 = localSharedPreferences.getString("sUin", "");
    int i1 = localSharedPreferences.getInt("isShowOpen", 0);
    int i2 = localSharedPreferences.getInt("iUinpPayType", 0);
    Object localObject3 = "LTMCLUB";
    String str1 = "QQ会员";
    String str4 = super.getString(2131717221);
    Object localObject2 = str1;
    Object localObject1 = localObject3;
    if (str3 != null)
    {
      localObject2 = str1;
      localObject1 = localObject3;
      if (str2 != null)
      {
        localObject2 = str1;
        localObject1 = localObject3;
        if (str3.equals(str2))
        {
          if (1 == i1)
          {
            localImageView.setVisibility(0);
            localTextView.setVisibility(0);
            localButton.setVisibility(0);
          }
          switch (i2)
          {
          default: 
            localObject1 = "QQ会员";
            localObject2 = "LTMCLUB";
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "UniPayUpdateListener back showTitleBtn isShowOpen:" + i1);
      }
      a(localTextView, localButton);
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localButton.setOnClickListener(new AvatarPendantActivity.12(this, Integer.valueOf(localSharedPreferences.getString("open_month", "3")).intValue(), (String)localObject1, (String)localObject2));
      return;
      localButton.setText(2131693317);
      localTextView.setText(super.getString(2131690693, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130842785));
      localObject1 = "QQ会员";
      localObject2 = "LTMCLUB";
      continue;
      localButton.setText(2131693318);
      localTextView.setText(super.getString(2131690694, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844164));
      localObject1 = "QQ会员";
      localObject2 = "LTMCLUB";
      continue;
      localButton.setText(2131693317);
      localTextView.setText(super.getString(2131690690, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130842785));
      localObject2 = "CJCLUBT";
      localObject1 = HardCodeUtil.a(2131700959);
      continue;
      localButton.setText(2131693318);
      localTextView.setText(super.getString(2131690691, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843532));
      localObject2 = "CJCLUBT";
      localObject1 = HardCodeUtil.a(2131700946);
      continue;
      localButton.setText(2131693318);
      localTextView.setText(super.getString(2131690695, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844165));
      localObject2 = "CJCLUBT";
      localObject1 = HardCodeUtil.a(2131700964);
      continue;
      localButton.setText(2131693319);
      localTextView.setText(super.getString(2131690696, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844165));
      localObject2 = "CJCLUBT";
      localObject1 = HardCodeUtil.a(2131700956);
      continue;
      localButton.setText(2131693319);
      localTextView.setText(super.getString(2131690692, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843532));
      localObject2 = "CJCLUBT";
      localObject1 = HardCodeUtil.a(2131700944);
      continue;
      localButton.setText(2131693318);
      localTextView.setText(super.getString(2131690697, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844166));
      localObject2 = "LTMCLUB";
      localObject1 = "QQ会员";
      continue;
      localButton.setText(2131693319);
      localTextView.setText(super.getString(2131690698, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844166));
      localObject2 = "LTMCLUB";
      localObject1 = "QQ会员";
    }
  }
  
  public boolean c()
  {
    return this.w != 0;
  }
  
  public void d()
  {
    int i2 = SharedPreUtils.ag(this, this.app.getCurrentAccountUin());
    int i1;
    Object localObject;
    String[] arrayOfString;
    ArrayList localArrayList;
    if ((i2 == -1) || (i2 == 2))
    {
      i1 = 1;
      localObject = (ActionSheet)ActionSheetHelper.a(this, null);
      arrayOfString = super.getResources().getStringArray(2130968636);
      localArrayList = new ArrayList();
      if (i1 == 0) {
        break label287;
      }
      ((ActionSheet)localObject).addButton(arrayOfString[27]);
      localArrayList.add(Integer.valueOf(27));
    }
    for (;;)
    {
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
            ((View)localObject).setContentDescription(HardCodeUtil.a(2131700954));
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label287:
          localException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "showActionSheet, historyHeadNumFlag=" + i2);
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800A8C8", "0X800A8C8", 0, 0, "", "", "", "");
      return;
      i1 = 0;
      break;
      ((ActionSheet)localObject).addButton(arrayOfString[23]);
      localArrayList.add(Integer.valueOf(23));
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
    String str;
    if (paramInt1 == 4) {
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("callbackSn");
        if ((str != null) && (str.startsWith("pendantNativeVip"))) {
          break label35;
        }
      }
    }
    label35:
    label212:
    label226:
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getStringExtra("result");
        paramInt2 = -1;
        int i2 = -1;
        for (;;)
        {
          try
          {
            paramIntent = new JSONObject(paramIntent);
            paramInt1 = i2;
          }
          catch (JSONException localJSONException1)
          {
            try
            {
              i1 = Integer.parseInt(paramIntent.getString("resultCode"));
              paramInt1 = i2;
              paramInt2 = i1;
              i2 = Integer.parseInt(paramIntent.getString("payState"));
              paramInt1 = i2;
              paramInt2 = i1;
              int i3 = Integer.parseInt(paramIntent.getString("provideState"));
              paramInt1 = i3;
              paramInt2 = i1;
              i1 = paramInt1;
              if ((paramIntent == null) || (paramInt2 != 0) || (i2 != 0) || (i1 != 0)) {
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler != null) {
                this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a("");
              }
              if (!str.equals("pendantNativeVipDefault")) {
                break label226;
              }
              ReportController.b(this.app, "CliOper", "", "", "0X8005FDF", "0X8005FDF", 0, 0, "", "", "", "");
              this.jdField_d_of_type_Boolean = true;
              return;
            }
            catch (JSONException localJSONException2)
            {
              int i1;
              Intent localIntent;
              break label212;
            }
            localJSONException1 = localJSONException1;
            paramIntent = null;
            paramInt1 = i2;
          }
          localJSONException1.printStackTrace();
          i1 = -1;
          i2 = paramInt1;
          continue;
          ReportController.b(this.app, "CliOper", "", "", "0X8005FDF", "0X8005FDF", 0, 0, str.substring(16, str.length()), "", "", "");
        }
        if (paramInt1 != 1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicAvatar", 2, "record dynamic avatar! resultCode:" + paramInt2);
        }
      } while (paramInt2 != -1);
      o();
      return;
    } while (paramInt2 != -1);
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramIntent = ImageUtil.b(this, this.jdField_a_of_type_AndroidNetUri);
    paramInt1 = ProfileCardUtil.b(this);
    localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 100);
    localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
    localIntent.putExtra("fromWhereClick", 10);
    localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
    PhotoUtils.startPhotoEdit(localIntent, this, AvatarPendantActivity.class.getName(), paramInt1, paramInt1, 1080, 1080, paramIntent, FaceUtil.a());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131562038);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler = ((SVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER));
    paramBundle = super.getIntent();
    boolean bool2;
    boolean bool1;
    if (paramBundle.getParcelableExtra("AllInOne") != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)paramBundle.getParcelableExtra("AllInOne"));
      bool2 = paramBundle.getBooleanExtra("showActionSheet", false);
      c();
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler = ((UniPayHandler)this.app.getBusinessHandler(BusinessHandlerFactory.UNI_PAY_HANDLER));
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
      super.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a("");
      if ((!NetworkUtil.d(this)) && (QLog.isColorLevel())) {
        QLog.d("AvatarPendantActivity", 2, "net is not connected");
      }
      this.jdField_b_of_type_Boolean = SystemUtil.a();
      if (SystemUtil.a() >= 1024L) {
        break label517;
      }
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_a_of_type_JavaLangString = (this.app.getApplication().getApplicationContext().getFilesDir() + File.separator + "pendant_market.json");
      this.jdField_b_of_type_JavaLangString = (this.app.getApplication().getApplicationContext().getFilesDir() + File.separator + "avatarInPendant.json");
      k();
      if ((CmShowWnsUtils.q()) && (ApolloEngine.a()))
      {
        v();
        h();
        w();
        if (Build.VERSION.SDK_INT < 21) {
          break label522;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloAvatarVideoProcessor = new ApolloAvatarVideoProcessor(this.app);
      }
      label328:
      i();
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
        break label535;
      }
      a();
      j();
    }
    for (;;)
    {
      if (bool2) {
        d();
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = getSharedPreferences("facechoosedata", 0).edit();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("ChooseFaceId", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerImplApolloExtensionObserverImpl);
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      this.jdField_d_of_type_JavaLangString = IndividuationUrlHelper.a("vasClassProfileStoryUrl");
      if (paramBundle.getBooleanExtra("fromThirdApp", false)) {
        ThreadManager.getUIHandler().postDelayed(new AvatarPendantActivity.2(this), 500L);
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "AllinOne info is null");
      }
      finish();
      return true;
      label517:
      bool1 = false;
      break;
      label522:
      QLog.e("AvatarPendantActivity", 1, "new ApolloAvatarVideoProcessor failed due to sdk < 21");
      break label328;
      label535:
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "sdcard exist:" + this.jdField_b_of_type_Boolean + " sdcard full:" + this.jdField_c_of_type_Boolean);
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.b(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
    }
    if (this.app != null) {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    }
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_c_of_type_Int = -1;
    }
    if ((this.app != null) && (this.jdField_a_of_type_Long != 0L)) {
      ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.jdField_a_of_type_Long).b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a();
      URLDrawable.resume();
    }
    if (this.app != null)
    {
      ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerImplApolloExtensionObserverImpl);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
    p();
  }
  
  public void doOnPause()
  {
    ApngImage.pauseAll();
    AbstractVideoImage.pauseAll();
    ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).c();
  }
  
  public void doOnResume()
  {
    int i1 = 0;
    super.doOnResume();
    ApngImage.playByTag(10);
    AbstractVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
    v();
    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "widget", "head_show", "", 1, 0, 0, "", "", "");
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
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
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
    switch (this.w)
    {
    default: 
      return;
    case 0: 
      this.x = 0;
      return;
    case 1: 
      this.x = 1;
      return;
    }
    this.x = 2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (isFinishing()) {}
    do
    {
      return true;
      if (paramMessage.what == 1000)
      {
        runOnUiThread(new AvatarPendantActivity.15(this, ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a()));
        return true;
      }
    } while (paramMessage.what != 1001);
    runOnUiThread(new AvatarPendantActivity.16(this));
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i1;
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364905: 
      case 2131364907: 
        if (c())
        {
          i1 = ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.app.getCurrentUin());
          ApolloDtReportUtil.a("avatarQQPage", "showMore", "click", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.app)).f(i1).a());
          localObject = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", this.jdField_e_of_type_JavaLangString);
          startActivity((Intent)localObject);
        }
      case 2131369487: 
      case 2131366572: 
      case 2131369495: 
      case 2131377445: 
      case 2131377441: 
      case 2131377439: 
      case 2131380876: 
      case 2131372845: 
      case 2131372846: 
      case 2131366547: 
      case 2131366548: 
        for (;;)
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("cmshow_avatar_used", true).apply();
          break;
          finish();
          break;
          ((RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("100100.100125.100127");
          localObject = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("individuation_url_type", 40100);
          ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
          ((Intent)localObject).putExtra("hide_left_button", false);
          ((Intent)localObject).putExtra("show_right_close_button", false);
          ((Intent)localObject).putExtra("url", IndividuationUrlHelper.a(this, "faceEntryUrl", ""));
          ((Intent)localObject).putExtra("business", 512L);
          ((Intent)localObject).putExtra("isShowAd", false);
          startActivity((Intent)localObject);
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "face", "0X80088EC", "", 1, 0, 0, null, "", "");
          l();
          break;
          localObject = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("individuation_url_type", 40100);
          ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
          ((Intent)localObject).putExtra("hide_left_button", false);
          ((Intent)localObject).putExtra("show_right_close_button", false);
          ((Intent)localObject).putExtra("url", IndividuationUrlHelper.a(this, "myPendantUrl", ""));
          ((Intent)localObject).putExtra("business", 512L);
          ((Intent)localObject).putExtra("isShowAd", false);
          startActivity((Intent)localObject);
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "faceAddon", "0X8008A05", "", 1, 0, 0, null, "", "");
          break;
          if (!NetworkUtil.d(this))
          {
            QQToast.a(this, 2131718560, 0).b(getTitleBarHeight());
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo == null) {
            break;
          }
          if (SimpleUIUtil.a())
          {
            localObject = DialogUtil.a(this, 0, null, HardCodeUtil.a(2131700963), null, HardCodeUtil.a(2131700948), new AvatarPendantActivity.13(this), null);
            if (((QQCustomDialog)localObject).isShowing()) {
              break;
            }
            ((QQCustomDialog)localObject).show();
            break;
          }
          if (!a()) {
            ((IApolloExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_Int, -1);
          }
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "faceAddon", "0X80088EE", "", 1, 0, 0, null, "", "");
          ReportController.b(this.app, "CliOper", "", "", "0X8005FDB", "0X8005FDB", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
          break;
          if (!NetworkUtil.d(this))
          {
            QQToast.a(this, 2131718560, 0).b(getTitleBarHeight());
            break;
          }
          if (b()) {
            break;
          }
          this.jdField_f_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.i(this.s);
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "widget", "head_setresult", "", 1, this.r, 0, "", this.s + "", "");
          this.t = this.s;
          this.jdField_b_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131700957));
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("mSelectFaceId", this.s);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
          localObject = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
          this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
          break;
          if (!NetworkUtil.d(this))
          {
            QQToast.a(this, 2131718560, 0).b(getTitleBarHeight());
            break;
          }
          i1 = ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.app.getCurrentUin());
          if (!c())
          {
            ApolloDtReportUtil.a("avatarQQPage", "openBtn", "click", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.app)).c(String.valueOf(this.s)).f(i1).a());
            localObject = new Intent(this, ApolloStoreActivity.class);
            ((Intent)localObject).putExtra("url", this.jdField_f_of_type_JavaLangString);
            startActivity((Intent)localObject);
            break;
          }
          if (b()) {
            break;
          }
          ApolloDtReportUtil.a("avatarQQPage", "setBtn", "click", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.app)).c(String.valueOf(this.s)).f(i1).a());
          this.jdField_f_of_type_Boolean = false;
          i1 = this.s;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelCmAvatarFaceInfo == null) {
            break;
          }
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
          a(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelCmAvatarFaceInfo);
          this.t = this.s;
          this.jdField_b_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131700957));
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("mSelectFaceId", this.s).apply();
          localObject = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
          if (localObject == null) {
            break;
          }
          localObject = ((AvatarPendantManager)localObject).a();
          this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
          break;
          if (FaceUtil.a()) {
            QQToast.a(this, 1, 2131720417, 0).b(getTitleBarHeight());
          }
          for (;;)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X8004174", "0X8004174", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
            break;
            d();
          }
          if (paramView.getTag() == null) {
            break;
          }
          long l1 = ((Integer)paramView.getTag()).intValue();
          localObject = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
          i1 = 0;
          if (i1 < ((List)localObject).size())
          {
            AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo = (AvatarPendantShopSeriesInfo)((List)localObject).get(i1);
            if ((localAvatarPendantShopSeriesInfo != null) && (localAvatarPendantShopSeriesInfo.jdField_a_of_type_Int == l1)) {
              if (localAvatarPendantShopSeriesInfo.jdField_a_of_type_Boolean) {
                break label1473;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              localAvatarPendantShopSeriesInfo.jdField_a_of_type_Boolean = bool;
              i1 += 1;
              break;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
          break;
          localObject = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", this.jdField_d_of_type_JavaLangString);
          startActivity((Intent)localObject);
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "widget", "head_more", "", 1, 0, 0, "", "", "");
          break;
          localObject = new Intent(this, ApolloStoreActivity.class);
          ((Intent)localObject).putExtra("url", this.jdField_f_of_type_JavaLangString);
          startActivity((Intent)localObject);
        }
      case 2131380878: 
        label1473:
        i1 = ((FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).height;
        if ((this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter != null) && (i1 != this.g)) {
          n();
        }
        break;
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
    Object localObject;
    int i1;
    label255:
    int i2;
    label453:
    int i3;
    label657:
    label669:
    label693:
    int i4;
    int i5;
    if (paramAdapterView.getId() == 2131372841)
    {
      if (((paramAdapterView instanceof GridView)) && (paramAdapterView.getTag() != null) && (paramView != null) && (paramView.getTag() != null))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 640, true, true, true, false, 7);
        g();
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo = ((AvatarPendantShopItemInfo)((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)paramView.getTag()).a.getTag());
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_a_of_type_Int;
        localObject = (AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
        List localList = ((AvatarPendantManager)localObject).a();
        AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo1 = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo;
        AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo2 = (AvatarPendantShopSeriesInfo)paramAdapterView.getTag();
        i1 = 0;
        if (i1 < localList.size())
        {
          AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo3 = (AvatarPendantShopSeriesInfo)localList.get(i1);
          if (localAvatarPendantShopSeriesInfo3 != null)
          {
            if (localAvatarPendantShopSeriesInfo3.jdField_a_of_type_Int != localAvatarPendantShopSeriesInfo2.jdField_a_of_type_Int) {
              break label255;
            }
            localAvatarPendantShopSeriesInfo3.jdField_c_of_type_Int = paramInt;
            this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo = localAvatarPendantShopSeriesInfo2;
          }
          for (;;)
          {
            i1 += 1;
            break;
            if ((localAvatarPendantShopSeriesInfo1 != null) && (localAvatarPendantShopSeriesInfo3.jdField_a_of_type_Int == localAvatarPendantShopSeriesInfo1.jdField_a_of_type_Int)) {
              localAvatarPendantShopSeriesInfo3.jdField_c_of_type_Int = -1;
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a(localList, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
        i1 = 3;
        if (!a()) {
          break label453;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131719100);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        i1 = 4;
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "faceAddon", "0X80088ED", "", 1, 0, 0, null, String.valueOf(i1), String.valueOf(this.jdField_a_of_type_Long));
        ReportController.b(this.app, "CliOper", "", "", "0X8005FD5", "0X8005FD5", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Long), "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_b_of_type_Int != 1) {
          break label669;
        }
        ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.i);
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 14) {
          break label693;
        }
        return;
        i2 = 0;
        int i6;
        switch (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_c_of_type_Int)
        {
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        default: 
          i6 = 1;
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          if (i6 == 0) {
            break label657;
          }
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131718541);
          i1 = 3;
          break;
          boolean bool = VipUtils.c(this.app);
          i6 = bool;
          if (!bool)
          {
            i2 = 2131720586;
            i1 = 0;
            i6 = bool;
            continue;
            bool = VipUtils.b(this.app);
            i6 = bool;
            if (!bool)
            {
              i2 = 2131719677;
              i1 = 1;
              i6 = bool;
              continue;
              i6 = 0;
              i2 = 2131689544;
              i1 = 2;
              continue;
              bool = VipUtils.a(this.app);
              i6 = bool;
              if (!bool)
              {
                i2 = 2131690721;
                i1 = 5;
                i6 = bool;
              }
            }
          }
        }
        this.jdField_a_of_type_AndroidWidgetButton.setText(i2);
        break;
        ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 5, PendantInfo.i);
      }
      if ((this.jdField_e_of_type_Int == jdField_b_of_type_Int) || (this.jdField_e_of_type_Int == jdField_c_of_type_Int))
      {
        paramAdapterView = (ViewGroup)paramAdapterView.getParent();
        localObject = (ViewGroup)paramAdapterView.getParent();
        i1 = paramAdapterView.getHeight();
        i2 = paramView.getHeight();
        i3 = DisplayUtil.a(this, 7.0F);
        if (!this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_Boolean) {
          break label1829;
        }
        i4 = (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList.size() - 1) / 4;
        if (paramInt != 0) {
          break label891;
        }
        paramInt = 0;
        i5 = DisplayUtil.a(this, 4.0F);
      }
    }
    label898:
    label1801:
    label1804:
    label1829:
    for (paramInt = i1 - (i4 + 1 - paramInt) * (i2 + i5) + i5 - i3;; paramInt = i1 - i2 - i3)
    {
      i2 = this.g - this.h;
      i1 = ((ViewGroup)localObject).getTop();
      if (((ViewGroup)localObject).getTag() != null)
      {
        i3 = ((AvatarPendantAdapter.ViewHolder)((ViewGroup)localObject).getTag()).jdField_a_of_type_Int;
        if (i1 >= 0) {
          break label898;
        }
        i1 = paramInt;
        if (paramInt < 0) {
          i1 = 0 - paramInt;
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i3, i2 - i1);
      }
      for (;;)
      {
        n();
        return;
        label891:
        paramInt /= 4;
        break;
        if (paramInt + i1 < i2) {
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i3, i2 - paramInt);
        }
      }
      if (paramAdapterView.getId() == 2131375253)
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
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "widget", "head_click", "", 1, 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqVasAvatarInPendantHeadportraitInfo.jdField_a_of_type_Int + "", "");
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("ChooseFaceId", this.jdField_a_of_type_ComTencentMobileqqVasAvatarInPendantHeadportraitInfo.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
        paramView = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
        if (paramView.size() > 0) {
          this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a(paramView, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
        }
        paramAdapterView = (ViewGroup)((ViewGroup)paramAdapterView.getParent()).getParent();
        if ((paramAdapterView.getTag() == null) || (!(paramAdapterView.getTag() instanceof AvatarPendantAdapter.ViewHolder))) {
          break;
        }
        paramAdapterView = (AvatarPendantAdapter.ViewHolder)paramAdapterView.getTag();
        paramInt = DisplayUtil.a(this, 100.0F);
        i1 = DisplayUtil.a(this, 20.0F);
        i2 = paramAdapterView.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarInPendantHeadportraitInfo.a()) {
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i2, paramInt);
        }
        for (;;)
        {
          n();
          return;
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i2, i1);
        }
      }
      if (paramAdapterView.getId() != 2131364904) {
        break;
      }
      this.jdField_a_of_type_Long = -1L;
      p();
      this.jdField_a_of_type_ComTencentMobileqqApolloApiModelCmAvatarFaceInfo = ((CmAvatarFaceInfo)((CmshowFaceGridAdapter.CmshowFaceItemHolder)paramView.getTag()).a.getTag());
      this.s = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelCmAvatarFaceInfo.getActionId();
      paramInt = ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.app.getCurrentUin());
      ApolloDtReportUtil.a("avatarQQPage", "cmshowavatar", "click", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.app)).c(String.valueOf(this.s)).f(paramInt).a());
      if (!c())
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(2131690130);
        ApolloDtReportUtil.a("avatarQQPage", "openBtn", "expose", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.app)).c(String.valueOf(this.s)).f(paramInt).a());
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        ApolloDtReportUtil.a("avatarQQPage", "setBtn", "expose", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.app)).c(String.valueOf(this.s)).f(paramInt).a());
        s();
        localObject = ApolloAvatarFileManager.a();
        if (!((ApolloAvatarFileManager)localObject).a(this.s)) {
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        }
        ((ApolloAvatarFileManager)localObject).a(this.s);
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(this.app.getCurrentUin(), 7, "large", ImageView.ScaleType.FIT_XY, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelCmAvatarFaceInfo.getActionId());
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("ChooseFaceId", this.jdField_a_of_type_ComTencentMobileqqApolloApiModelCmAvatarFaceInfo.getActionId()).apply();
        localObject = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
        if (((List)localObject).size() > 0) {
          this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
        }
        paramAdapterView = (ViewGroup)paramAdapterView.getParent();
        localObject = (ViewGroup)paramAdapterView.getParent();
        paramInt = paramAdapterView.getHeight() - paramView.getHeight() - DisplayUtil.a(this, 7.0F);
        i1 = this.g - this.h;
        i3 = ((ViewGroup)localObject).getTop();
        if (((ViewGroup)localObject).getTag() != null)
        {
          i2 = ((AvatarPendantAdapter.ViewHolder)((ViewGroup)localObject).getTag()).jdField_a_of_type_Int;
          if (i3 >= 0) {
            break label1804;
          }
          if (paramInt >= 0) {
            break label1801;
          }
          paramInt = 0 - paramInt;
          label1770:
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i2, i1 - paramInt);
        }
      }
      for (;;)
      {
        n();
        return;
        this.jdField_c_of_type_AndroidWidgetButton.setText(2131718541);
        break;
        break label1770;
        if (paramInt + i3 < i1) {
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i2, i1 - paramInt);
        }
      }
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    boolean bool3 = false;
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      paramView = findViewById(2131380865);
      View localView = findViewById(2131379406);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getRight() > this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.getLeft())
      {
        paramInt1 = 1;
        paramInt2 = paramView.getTop();
        paramInt3 = this.jdField_b_of_type_AndroidWidgetImageView.getBottom();
        paramInt4 = this.jdField_a_of_type_AndroidViewView.getTop();
        if (paramInt2 + paramInt3 <= localView.getTop() + paramInt4) {
          break label227;
        }
        paramInt2 = 1;
        label89:
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break label232;
        }
      }
    }
    label227:
    label232:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool3;
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        bool2 = bool3;
        if (this.jdField_b_of_type_AndroidViewView.getBottom() > this.jdField_c_of_type_AndroidViewView.getTop() + this.jdField_a_of_type_AndroidViewView.getTop()) {
          bool2 = true;
        }
      }
      if ((bool1) || (bool2)) {
        ThreadManager.getUIHandler().post(new AvatarPendantActivity.RemoveTips(this, bool1, bool2));
      }
      paramView = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      paramInt1 = (int)(this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams().width * 0.18D);
      paramView.width = paramInt1;
      paramView.height = paramInt1;
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
      return;
      paramInt1 = 0;
      break;
      paramInt2 = 0;
      break label89;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity
 * JD-Core Version:    0.7.0.1
 */