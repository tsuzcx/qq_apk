package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.IntimateScoreCardView.Callback;
import com.tencent.mobileqq.activity.aio.intimate.MemoryDayView;
import com.tencent.mobileqq.activity.aio.intimate.OnDragTouchListener;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemClueView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemFriendInfoView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemGiftView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverAchievementView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverEntranceView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemMutualMarkView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemOldDnaView;
import com.tencent.mobileqq.activity.aio.intimate.view.LoveTreeView;
import com.tencent.mobileqq.activity.contact.troop.TroopList;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView;
import com.tencent.mobileqq.loverzone.LoverZoneUtils;
import com.tencent.mobileqq.multicard.CardContent;
import com.tencent.mobileqq.multicard.MultiCardCustomViewDelegate;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.FeedListView.LoadFeedCallback;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.vip.manager.LoverDisbandRequestManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class IntimateInfoView
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, BaseIntimateView, IntimateScoreCardView.Callback, FeedListView.LoadFeedCallback
{
  private int jdField_a_of_type_Int;
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private IntimateInfoShareHelper jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper;
  private MemoryDayView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateMemoryDayView;
  private IntimateContentItemClueView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemClueView;
  private IntimateContentItemFriendInfoView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemFriendInfoView;
  private IntimateContentItemGiftView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView;
  private IntimateContentItemLoverAchievementView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView;
  private IntimateContentItemLoverEntranceView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView;
  private IntimateContentItemMutualMarkView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView;
  private IntimateContentItemNewDnaView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView;
  private IntimateContentItemOldDnaView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemOldDnaView;
  private LoveTreeView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewLoveTreeView;
  public BaseActivity a;
  public QQAppInterface a;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = new IntimateInfoView.9(this);
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new IntimateInfoView.10(this);
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private IntimateInfoHandler jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler;
  IntimateInfoObserver jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver = new IntimateInfoView.13(this);
  MultiCardCustomViewDelegate jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  @Nullable
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  @Nullable
  private FeedListView jdField_a_of_type_CooperationQzoneApiFeedListView;
  private Long jdField_a_of_type_JavaLangLong;
  public String a;
  private ArrayList<IntimateContentItemBaseView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private final boolean g;
  private boolean h = false;
  private boolean i = false;
  
  public IntimateInfoView()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.g = false;
  }
  
  public IntimateInfoView(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
    }
    catch (NumberFormatException paramString)
    {
      long l;
      label124:
      StringBuilder localStringBuilder;
      boolean bool;
      Object localObject;
      Iterator localIterator;
      break label124;
    }
    l = 0L;
    if ((l > 0L) && (QZoneApiProxy.needLoadQZoneEnv()))
    {
      paramString = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("IntimateInfoView: start to load qzone plugin ");
      if (paramString != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.i("IntimateInfoView", 1, localStringBuilder.toString());
      if (paramString == null)
      {
        QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new IntimateInfoView.1(this, paramBaseActivity, paramQQAppInterface));
      }
      else
      {
        bool = QZoneApiProxy.needShowAioFeedList(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break label237;
      }
    }
    bool = false;
    label237:
    if (bool) {
      try
      {
        paramString = LayoutInflater.from(paramContext).inflate(2131559264, null);
        try
        {
          this.jdField_a_of_type_CooperationQzoneApiFeedListView = ((FeedListView)paramString.findViewById(2131368924));
        }
        catch (Throwable localThrowable1) {}
        QLog.w("IntimateInfoView", 1, "IntimateInfoView: failed to load qzone feed", localThrowable2);
      }
      catch (Throwable localThrowable2)
      {
        paramString = null;
      }
    } else {
      paramString = null;
    }
    if ((paramString != null) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null))
    {
      this.g = true;
    }
    else
    {
      paramString = LayoutInflater.from(paramContext).inflate(2131559250, null);
      this.g = false;
    }
    this.jdField_a_of_type_AndroidViewView = paramString.findViewById(2131376828);
    this.jdField_b_of_type_AndroidViewView = paramString.findViewById(2131378886);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramString.findViewById(2131363340));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramString.findViewById(2131378847));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramString.findViewById(2131370794));
    if (this.g) {
      localObject = LayoutInflater.from(paramContext).inflate(2131559251, null);
    } else {
      localObject = paramString;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemFriendInfoView = ((IntimateContentItemFriendInfoView)((View)localObject).findViewById(2131367330));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView = ((IntimateContentItemMutualMarkView)((View)localObject).findViewById(2131367343));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemOldDnaView = ((IntimateContentItemOldDnaView)((View)localObject).findViewById(2131367310));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView = ((IntimateContentItemGiftView)((View)localObject).findViewById(2131367319));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemClueView = ((IntimateContentItemClueView)((View)localObject).findViewById(2131367297));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView = ((IntimateContentItemLoverEntranceView)((View)localObject).findViewById(2131370491));
    a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView = ((IntimateContentItemNewDnaView)((View)localObject).findViewById(2131367302));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView = ((IntimateContentItemLoverAchievementView)((View)localObject).findViewById(2131365283));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemFriendInfoView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemOldDnaView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemClueView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView);
    localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IntimateContentItemBaseView)localIterator.next()).setIntimateInterface(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemFriendInfoView.g();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131370782));
    this.jdField_c_of_type_AndroidViewView = ((View)localObject).findViewById(2131367313);
    if (this.g)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.setEdgeEffectEnabled(false);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.addHeaderView((View)localObject);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.attach(paramQQAppInterface, paramBaseActivity, l);
      this.jdField_c_of_type_Boolean = false;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramString.findViewById(2131377006));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setEdgeEffectEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131705886));
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131705896));
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      paramQQAppInterface.setMargins(0, ImmersiveUtils.getStatusBarHeight(paramContext), 0, 0);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramQQAppInterface);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    String str;
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
      str = FriendIntimateRelationshipHelper.b(paramInt1, paramInt2);
    } else {
      str = FriendIntimateRelationshipHelper.a(paramInt1, paramInt2);
    }
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str.equals(this.jdField_c_of_type_JavaLangString))) {
      return;
    }
    Object localObject;
    if (paramInt1 == 3) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840523);
    } else if (paramInt1 == 2) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840521);
    } else if (paramInt1 == 1) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840525);
    } else if (paramInt1 == 26) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840538);
    } else {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840529);
    }
    QLog.i("intimate_relationship", 1, String.format("setBackgroundDrawable, intimateType: %s, level: %s, bgUrl: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str }));
    if (!TextUtils.isEmpty(str))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = ViewUtils.a();
      localURLDrawableOptions.mRequestHeight = ViewUtils.b();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(str, localURLDrawableOptions);
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.x);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
      this.jdField_c_of_type_JavaLangString = str;
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewLoveTreeView = ((LoveTreeView)paramView.findViewById(2131370495));
    int j = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
    int k = this.jdField_b_of_type_AndroidViewView.getHeight();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewLoveTreeView.setOnTouchListener(new OnDragTouchListener(j + k));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewLoveTreeView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewLoveTreeView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693399));
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    IntimateInfoShareHelper localIntimateInfoShareHelper = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper;
    if (localIntimateInfoShareHelper == null)
    {
      ThreadManager.getFileThreadHandler().post(new IntimateInfoView.8(this, paramURLDrawable));
      return;
    }
    localIntimateInfoShareHelper.a();
  }
  
  @RequiresApi(api=17)
  private void a(IntimateInfo paramIntimateInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateIntimateInfo: ");
    ((StringBuilder)localObject).append(paramIntimateInfo);
    QLog.i("intimate_relationship", 1, ((StringBuilder)localObject).toString());
    if (paramIntimateInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.jdField_a_of_type_Int = paramIntimateInfo.maskType;
    if (paramIntimateInfo.beFriendDays >= -1)
    {
      int j = this.jdField_a_of_type_Int;
      if (j == 3)
      {
        this.jdField_b_of_type_Int = 4;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(this.jdField_a_of_type_Int, paramIntimateInfo.maskLevel);
        this.e = true;
      }
      else if (j == 2)
      {
        this.jdField_b_of_type_Int = 3;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(this.jdField_a_of_type_Int, paramIntimateInfo.maskLevel);
        this.e = true;
      }
      else if (j == 1)
      {
        c(paramIntimateInfo);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewLoveTreeView.a(paramIntimateInfo.loveTreeInfo);
      }
      else if (j == 26)
      {
        this.jdField_b_of_type_Int = 5;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(this.jdField_a_of_type_Int, paramIntimateInfo.maskLevel);
        this.e = true;
      }
      else
      {
        this.jdField_b_of_type_Int = 1;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(0, paramIntimateInfo.maskLevel);
        this.e = false;
      }
    }
    else
    {
      this.jdField_a_of_type_Int = 0;
      a(0, paramIntimateInfo.maskLevel);
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).b(paramIntimateInfo, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView.setReportType(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView.setReportType(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView.n();
    }
    b(paramIntimateInfo);
    if (this.jdField_b_of_type_Boolean) {
      v();
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramIntimateInfo = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
      if (paramIntimateInfo != null)
      {
        String str = paramIntimateInfo.a();
        TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        paramIntimateInfo = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a();
        if (paramIntimateInfo != null) {
          paramIntimateInfo = paramIntimateInfo.b();
        } else {
          paramIntimateInfo = "";
        }
        localObject = paramIntimateInfo;
        if (TextUtils.isEmpty(paramIntimateInfo)) {
          localObject = localTroopManager.a(str, this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    IntimatePlayTogetherMiniGameCardView.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    if (this.jdField_b_of_type_Boolean)
    {
      ReportController.b(null, "dc00898", "", "", "0X8009F4D", "0X8009F4D", this.jdField_b_of_type_Int, 0, "", "", "", "");
      if (this.jdField_b_of_type_Int == 2) {
        ReportController.b(null, "dc00898", "", "", "0X800A05F", "0X800A05F", 0, 0, "", "", "", "");
      }
    }
    QLog.d("Intimatetest", 2, "ui ok");
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler = ((IntimateInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER));
        }
        this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType);
      }
      else
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        localMessage.what = 1;
        localMessage.obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719223);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        QLog.d("intimate_relationship", 1, String.format("disbandIntimateRelationship network is not available, uin: %s", new Object[] { paramString }));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("disbandIntimateRelationship, friendUin: %s, type: %s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
  }
  
  private void b(IntimateInfo paramIntimateInfo)
  {
    if (paramIntimateInfo.memoryDayInfoList != null)
    {
      AbstractGifImage.resumeAll();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateMemoryDayView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateMemoryDayView = new MemoryDayView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateMemoryDayView.a(new IntimateInfoView.3(this));
      }
      paramIntimateInfo = new ArrayList(paramIntimateInfo.memoryDayInfoList);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateMemoryDayView.a(this.jdField_a_of_type_AndroidContentContext, paramIntimateInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateMemoryDayView.a() != null)
      {
        paramIntimateInfo = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
        if (paramIntimateInfo != null)
        {
          paramIntimateInfo.removeAllViews();
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateMemoryDayView.a());
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
      }
    }
    else
    {
      paramIntimateInfo = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (paramIntimateInfo != null) {
        paramIntimateInfo.setVisibility(8);
      }
    }
  }
  
  private void b(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A11A", "0X800A11A", this.jdField_b_of_type_Int, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentImageURLDrawable == null)
    {
      d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693895));
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = 750;
      localURLDrawableOptions.mRequestHeight = 1272;
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    }
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 4))
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new IntimateInfoView.6(this));
      ThreadManager.getFileThreadHandler().post(new IntimateInfoView.7(this));
      return;
    }
    t();
    a(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  private void c(IntimateInfo paramIntimateInfo)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    LoverZoneUtils.a("6", "2", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    a(this.jdField_a_of_type_Int, paramIntimateInfo.maskLevel);
    if ((!this.d) && (this.jdField_a_of_type_Boolean))
    {
      this.d = true;
      s();
    }
    this.e = true;
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "disbandLoverRelationship sendRequest");
    }
    LoverDisbandRequestManager localLoverDisbandRequestManager = new LoverDisbandRequestManager();
    try
    {
      localLoverDisbandRequestManager.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()), Long.parseLong(paramString));
      return;
    }
    catch (Exception paramString)
    {
      label43:
      break label43;
    }
    paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    paramString.what = 5;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localBaseActivity, localBaseActivity.getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((paramString != null) && (!paramString.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isIntimate");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("intimate_relationship", 2, String.format(((StringBuilder)localObject).toString(), new Object[0]));
    }
    ReportController.b(null, "dc00898", "", "", "0X800A119", "0X800A119", this.jdField_b_of_type_Int, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createMenuSheet(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = FriendIntimateRelationshipHelper.c(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskLevel);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131693452, 0);
    }
    if (this.e) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131693421, 3);
    } else {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131693434, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new IntimateInfoView.5(this, (String)localObject));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void q()
  {
    ReportController.b(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
    String str = FriendIntimateRelationshipHelper.a(this.jdField_a_of_type_JavaLangString);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("click menu_bind_intimate url:");
      ((StringBuilder)localObject).append(str);
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(str))
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(((Intent)localObject).putExtra("url", str));
    }
  }
  
  private void r()
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131693424).setPositiveButton(2131693423, new IntimateInfoView.12(this)).setNegativeButton(2131693422, new IntimateInfoView.11(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    QLog.d("intimate_relationship", 1, "showDisbandDialog, mActivity == null or is finishing!");
  }
  
  private void s()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localObject != null) && (((BaseActivity)localObject).app != null))
    {
      localObject = (IWebProcessManagerService)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getRuntimeService(IWebProcessManagerService.class, "");
      if (localObject == null) {
        return;
      }
      if (((IWebProcessManagerService)localObject).isNeedPreloadWebProcess())
      {
        ((IWebProcessManagerService)localObject).startWebProcess(-1, null);
        if (QLog.isColorLevel()) {
          QLog.d("intimate_relationship", 2, "start preloadWebProcess");
        }
      }
    }
  }
  
  private void t()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void u()
  {
    String str = FriendIntimateRelationshipHelper.c(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskLevel);
    if (!TextUtils.isEmpty(str))
    {
      b(str);
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, HardCodeUtil.a(2131705887), 1).a();
  }
  
  private void v()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
    if (localObject != null)
    {
      if (((IntimateInfo)localObject).memoryDayInfoList != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.memoryDayInfoList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          IntimateInfo.MemoryDayInfo localMemoryDayInfo = (IntimateInfo.MemoryDayInfo)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(localMemoryDayInfo.linkWording))
          {
            ReportController.b(null, "dc00898", "", "", "0X800A207 ", "0X800A207 ", localMemoryDayInfo.dateType, 0, "", "", "", "");
            QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A207");
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)((Iterator)localObject).next()).linkWording))
          {
            ReportController.b(null, "dc00898", "", "", "0X800A209 ", "0X800A209 ", 0, 0, "", "", "", "");
            QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A209");
          }
        }
      }
    }
    else
    {
      QLog.d("intimate_relationship", 2, "DnaLinkReport info null");
    }
  }
  
  private void w()
  {
    if (this.g)
    {
      FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
      if (localFeedListView != null)
      {
        int j = this.jdField_c_of_type_Int;
        if ((j != 3) && (j != 4))
        {
          localFeedListView.loadMore(this);
          return;
        }
        this.i = true;
      }
    }
  }
  
  public Bitmap a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
    }
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString, 0, (byte)4);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public MultiCardCustomViewDelegate a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoView.2(this));
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setCurrentShowType: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("IntimateInfoView", 4, ((StringBuilder)localObject).toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurrentShowType showType: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("  old:");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_c_of_type_Int = paramInt;
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).setCurrentShowType(paramInt);
    }
    boolean bool2 = this.h;
    boolean bool1 = true;
    if (!bool2)
    {
      w();
      this.h = true;
    }
    localObject = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localObject != null)
    {
      if ((paramInt == 3) || (paramInt == 4)) {
        bool1 = false;
      }
      ((FeedListView)localObject).setLongClickValid(bool1);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.g)
    {
      FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
      if (localFeedListView != null) {
        localFeedListView.doActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void a(CardContent paramCardContent, String paramString)
  {
    if (paramCardContent == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramCardContent.a();
    this.jdField_b_of_type_JavaLangString = paramString;
    if (paramCardContent.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramString != null)
      {
        paramString.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramCardContent.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramString.what = 0;
      paramString.obj = paramCardContent.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      if (this.g)
      {
        paramCardContent = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
        if (paramCardContent != null) {
          paramCardContent.scrollTo(0, 0);
        }
      }
      else
      {
        paramCardContent = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
        if (paramCardContent != null) {
          paramCardContent.scrollTo(0, 0);
        }
      }
    }
  }
  
  public void a(MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if (localObject != null)
    {
      ((MultiCardCustomViewDelegate)localObject).k();
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate = null;
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject != null) {
        ((Handler)localObject).removeCallbacksAndMessages(null);
      }
    }
    a(3);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate = paramMultiCardCustomViewDelegate;
    this.f = true;
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScoreCardActionClick strUrl:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("IntimateInfoView", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://"))))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramString);
      ((Intent)localObject).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131706577));
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList<TroopList> paramArrayList)
  {
    if (paramBoolean)
    {
      paramArrayList = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramArrayList.what = 9;
      paramArrayList.obj = null;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramArrayList);
      return;
    }
    paramArrayList = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    paramArrayList.what = 10;
    paramArrayList.obj = null;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramArrayList);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onBandIntimateRelationship");
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) && (paramBoolean))
    {
      c();
      return;
    }
    QLog.d("intimate_relationship", 1, String.format("onBandIntimateRelationship return, friendUin: %s", new Object[] { paramString }));
  }
  
  protected void a(boolean paramBoolean, String paramString, IntimateInfo paramIntimateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetIntimateInfo");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if ((localObject != null) && (((MultiCardCustomViewDelegate)localObject).a() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, in card mode, return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetIntimateInfo, mViewDelegate == null:");
        ((StringBuilder)localObject).append(this.f);
        QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
      }
      if (!this.f) {}
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetIntimateInfo, mode: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a());
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)))
    {
      if (paramBoolean)
      {
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramString.what = 0;
        paramString.obj = paramIntimateInfo;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        return;
      }
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramString.what = 1;
      paramString.obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693432);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
    }
    QLog.d("intimate_relationship", 1, String.format("onGetIntimateInfo return, friendUin: %s", new Object[] { paramString }));
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDisbandIntimateRelationship");
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)))
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      if (!paramBoolean1)
      {
        localMessage.what = 5;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        return;
      }
      if (paramBoolean2)
      {
        c();
        return;
      }
      localMessage.what = 6;
      localMessage.obj = paramString;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
    QLog.d("intimate_relationship", 1, String.format("onDisbandIntimateRelationship return, friendUin: %s", new Object[] { paramString }));
  }
  
  protected void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos");
    }
    paramObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if ((paramObject != null) && (paramObject.a() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, in card mode, return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate == null)
    {
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("onGetGroupIntimateInfos, mViewDelegate == null : ");
        paramObject.append(this.f);
        QLog.d("intimate_relationship", 2, paramObject.toString());
      }
      if (!this.f) {}
    }
    else if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onGetGroupIntimateInfos, mode: ");
      paramObject.append(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a());
      QLog.d("intimate_relationship", 2, paramObject.toString());
    }
    paramObject = null;
    long l1;
    if ((paramBoolean) && (paramHashMap != null)) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
      l1 = l2;
    }
    catch (NumberFormatException paramObject)
    {
      label184:
      break label184;
    }
    QLog.e("intimate_relationship", 2, "valueOf string err ");
    paramHashMap = (IntimateInfo)paramHashMap.get(Long.valueOf(l1));
    break label222;
    QLog.e("intimate_relationship", 2, "onGetGroupIntimateInfos failed !");
    paramHashMap = paramObject;
    label222:
    if (paramHashMap != null)
    {
      paramObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramObject.what = 0;
      paramObject.obj = paramHashMap;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
      return;
    }
    paramHashMap = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    paramHashMap.what = 1;
    paramHashMap.obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693432);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramHashMap);
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHandleGetLoverIntimateInfo isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" data = ");
      ((StringBuilder)localObject).append(paramArrayOfObject);
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject).what = 7;
      ((Message)localObject).obj = paramArrayOfObject;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
    paramArrayOfObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    paramArrayOfObject.what = 8;
    paramArrayOfObject.obj = null;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramArrayOfObject);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemFriendInfoView.m();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView.setNeedReportPage(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemGiftView.setNeedReportPage(paramBoolean);
  }
  
  public void c()
  {
    long l2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler = ((IntimateInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate == null)
        {
          boolean bool = FriendIntimateRelationshipConfProcessor.a().d;
          this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler.a(this.jdField_a_of_type_JavaLangString, bool);
          break label219;
        }
        localObject = new ArrayList();
        l2 = 0L;
      }
    }
    try
    {
      l1 = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      long l1;
      long l3;
      label115:
      label117:
      break label115;
    }
    try
    {
      l3 = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
      l2 = l3;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label117;
    }
    l1 = 0L;
    QLog.e("intimate_relationship", 1, "valueOf string err");
    ((ArrayList)localObject).add(Long.valueOf(l1));
    this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler.a(l2, (ArrayList)localObject, null);
    break label219;
    Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    ((Message)localObject).what = 1;
    ((Message)localObject).obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719223);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    QLog.d("intimate_relationship", 1, String.format("requestIntimateInfo network is not available, uin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    label219:
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("requestIntimateInfo, friendUin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
  }
  
  public void d()
  {
    long l2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
        l2 = 0L;
      }
    }
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      label33:
      Message localMessage;
      break label33;
    }
    l1 = l2;
    if (QLog.isColorLevel())
    {
      QLog.d("intimate_relationship", 2, String.format("requestTroopListWithCommonFriends, friendUin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
      l1 = l2;
    }
    TroopWithCommonFriendsHelper.a(l1, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    break label147;
    localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719223);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    QLog.d("intimate_relationship", 1, String.format("requestTroopListWithCommonFriends network is not available, uin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    label147:
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("requestTroopListWithCommonFriends, friendUin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).i();
    }
    localObject = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localObject != null) {
      ((FeedListView)localObject).onPause();
    }
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).h();
    }
    localObject = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localObject != null)
    {
      ((FeedListView)localObject).onStart();
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onResume();
    }
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).k();
    }
    localObject = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localObject != null) {
      ((FeedListView)localObject).onStop();
    }
  }
  
  public void h()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).j();
    }
    localObject = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localObject != null) {
      ((FeedListView)localObject).onStart();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 9: 
    case 10: 
      a(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
      return true;
    case 8: 
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView.m();
      return true;
    case 7: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Object[])))
      {
        paramMessage = (Object[])paramMessage.obj;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView.a((String)paramMessage[0], (String)paramMessage[1], (String)paramMessage[2]);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView.m();
      return true;
    case 6: 
      c();
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, 2131693426, 1).a();
      return true;
    case 5: 
      t();
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, 2131693425, 1).a();
      return true;
    case 4: 
      t();
      return true;
    case 3: 
      d((String)paramMessage.obj);
      return true;
    case 2: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, paramMessage, 1).a();
      return true;
    case 1: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramMessage, 1).a();
      return true;
    }
    a((IntimateInfo)paramMessage.obj);
    return true;
  }
  
  public void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper;
    if (localObject != null) {
      ((IntimateInfoShareHelper)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateMemoryDayView;
    if (localObject != null)
    {
      ((MemoryDayView)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateMemoryDayView = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).l();
    }
    localObject = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localObject != null)
    {
      ((FeedListView)localObject).onDestroy();
      this.jdField_c_of_type_Boolean = true;
    }
    localObject = this.jdField_c_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  public void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if (localObject != null)
    {
      ((MultiCardCustomViewDelegate)localObject).a();
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localObject != null) {
      ((BaseActivity)localObject).finish();
    }
  }
  
  public void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
    if (localObject != null)
    {
      ((IntimateInfo)localObject).lastAnimAfterScore = ((IntimateInfo)localObject).currentScore;
      ThreadManager.postImmediately(new IntimateInfoView.4(this), null, true);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScoreUpdated: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void l()
  {
    m();
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverEntranceView.o();
  }
  
  public void n()
  {
    QLog.i("IntimateInfoView", 4, "onZoomIn: ");
    FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localFeedListView == null) {
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localFeedListView.attach(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, Long.parseLong(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.loadMore(this);
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (this.i)
    {
      localFeedListView.loadMore(this);
      this.i = false;
    }
  }
  
  public void o()
  {
    QLog.i("IntimateInfoView", 4, "onZoomOut: ");
    FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localFeedListView != null) {
      localFeedListView.scrollToHeadView();
    }
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    Long localLong = this.jdField_a_of_type_JavaLangLong;
    if ((localLong == null) || (l - localLong.longValue() >= 500L))
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(l);
      int j = paramView.getId();
      if (j != 2131363340)
      {
        if (j == 2131370794) {
          p();
        }
      }
      else {
        j();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoadOver: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("IntimateInfoView", 4, ((StringBuilder)localObject).toString());
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
      if (localObject == null) {
        return;
      }
      if (((FeedListView)localObject).getFeedCnt() > 0)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if (((j == 1) || (j == 3)) && (Build.VERSION.SDK_INT >= 11)) {
        paramView.setAlpha(1.0F);
      }
    }
    else if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView
 * JD-Core Version:    0.7.0.1
 */