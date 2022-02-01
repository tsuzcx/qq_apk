package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.ShareUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionActivityManager;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionAdapter;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionCommentActivity;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionListView;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageView;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoItemInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.RecommendItemInfo;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qqfav.QfavBuilder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class PublicAccountImageCollectionMainActivityImpl
  extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, IPublicAccountImageCollectionMainActivity
{
  public static int C2C_SOURCE = 2;
  public static int DISCUSSION_SOURCE = 4;
  public static final int REQUEST_CODE_FAVORITE = 101;
  public static final int RESET_CENTER_VIEW = 1;
  public static final String SCHEMATITLE = "mqqapi://readinjoy/apenalbum?src_type=app&version=1&articleid=";
  public static int TROOP_SOURCE = 3;
  public static boolean doubleTapFlag = false;
  ActionSheet actionSheet;
  public String articleID = "";
  ViewGroup centerView;
  private int click_source;
  private int commentCount;
  TextView commentCountText;
  ImageView commentImage;
  TextView commentTextView;
  float[] currentValues = new float[9];
  private Drawable drawable;
  private boolean flag = false;
  private boolean hasReport;
  Matrix initMatrix;
  float[] initValues = new float[9];
  private boolean isFollowed;
  private boolean isLiked;
  private int likeCount;
  private PublicAccountImageCollectionAdapter mAdapter = null;
  private AnimatorSet mAlphaset;
  private AppInterface mApp;
  private String mCommentDraft = null;
  Context mContext;
  Matrix mCurrentMatrix = new Matrix();
  float mDensity;
  int mGridView1Length;
  int mGridView2Length;
  protected Handler mHandler = new PublicAccountImageCollectionMainActivityImpl.15(this);
  private boolean mIsAnonymous = false;
  private PublicAccountImageCollectionListView mListView = null;
  protected QQStoryLoadingView mProgressBar;
  private IPublicAccountArticleHandler mPublicAccountArticleHandler;
  private IPublicAccountArticleObserver mPublicAccountArticleObserver;
  ScaleGestureDetector mScaleGestureDetector;
  ElasticHorScrView mScrollView1;
  ElasticHorScrView mScrollView2;
  private TranslateAnimation mTranslateAnimationDown;
  private TranslateAnimation mTranslateAnimationUp;
  private Handler mUIHandler = null;
  LinearLayout mUserGuide;
  Matrix matrix = new Matrix();
  private boolean needFetchPhotoCollectionInfoFromServer = false;
  private IPublicAccountImageCollectionUtils.PhotoCollectionInfo photoCollectionInfo;
  private PublicAccountImageView publicAccountMainImageView;
  public String puin = "";
  private int readCount;
  private ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> recommendItemInfos;
  private int recommend_position;
  private String recommend_source = "";
  private RelativeLayout relativeLayout;
  private int report_source;
  float scale;
  Share share;
  ImageView shareImage;
  private long startTime;
  Bitmap thumbBitmap;
  ImageView titleLeft;
  ImageView titleRight;
  private String uin = "";
  ViewGroup viewGroup;
  private String webDes = "";
  private String webImg = "";
  private String webName = "";
  public String webUrl = "";
  int whereShow;
  ImageView writeCommentImage;
  TextView zanCountText;
  ImageView zanImage;
  int zoomEvent = 1;
  
  @TargetApi(9)
  private View createViewFlipper(int paramInt)
  {
    View localView = super.getLayoutInflater().inflate(2131559102, null);
    this.mScrollView1 = ((ElasticHorScrView)localView.findViewById(2131377008));
    this.mScrollView2 = ((ElasticHorScrView)localView.findViewById(2131377009));
    if (paramInt == 1) {
      this.mScrollView2.setVisibility(8);
    }
    GridView localGridView2 = (GridView)localView.findViewById(2131367811);
    GridView localGridView1 = (GridView)localView.findViewById(2131367812);
    Object localObject1 = (TextView)localView.findViewById(2131362003);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(this.mDensity * 13.0F));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131690728);
    ((TextView)localObject1).setOnClickListener(new PublicAccountImageCollectionMainActivityImpl.11(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.mScrollView1.setOverScrollMode(2);
      this.mScrollView2.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    localObject2 = getActionSheetItems();
    if (localObject2.length > 0) {
      localObject1 = localObject2[0];
    } else {
      localObject1 = new ArrayList(0);
    }
    if (localObject2.length > 1) {
      localObject2 = localObject2[1];
    } else {
      localObject2 = new ArrayList(0);
    }
    paramInt = ((List)localObject1).size();
    localGridView2.setNumColumns(paramInt);
    ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
    localLayoutParams.width = ((int)((paramInt * 75 + (paramInt - 1) * 10 + 3) * this.mDensity));
    localGridView2.setLayoutParams(localLayoutParams);
    localGridView2.setAdapter(new PublicAccountImageCollectionMainActivityImpl.ActionSheetItemAdapter(this, 0, (List)localObject1));
    localGridView2.setSelector(new ColorDrawable(0));
    localGridView2.setOnItemClickListener(this);
    paramInt = localLayoutParams.width;
    this.mGridView1Length = paramInt;
    int i = ((List)localObject2).size();
    localObject1 = localGridView1.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = ((int)((i * 75 + (i - 1) * 10 + 3) * this.mDensity));
    localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localGridView1.setNumColumns(i);
    localGridView1.setAdapter(new PublicAccountImageCollectionMainActivityImpl.ActionSheetItemAdapter(this, 0, (List)localObject2));
    localGridView1.setSelector(new ColorDrawable(0));
    localGridView1.setOnItemClickListener(this);
    i = ((ViewGroup.LayoutParams)localObject1).width;
    this.mGridView2Length = i;
    localView.post(new PublicAccountImageCollectionMainActivityImpl.12(this, paramInt, i));
    return localView;
  }
  
  @TargetApi(11)
  private void dismissGuideAnim()
  {
    if (this.mUserGuide.getAnimation() != null)
    {
      this.mUserGuide.getAnimation().setAnimationListener(null);
      this.mUserGuide.getAnimation().cancel();
      this.mUserGuide.clearAnimation();
    }
    Object localObject = this.mTranslateAnimationUp;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).setAnimationListener(null);
      this.mTranslateAnimationUp.cancel();
      this.mTranslateAnimationUp = null;
    }
    localObject = this.mTranslateAnimationDown;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).setAnimationListener(null);
      this.mTranslateAnimationDown.cancel();
      this.mTranslateAnimationDown = null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = this.mAlphaset;
      if (localObject != null)
      {
        localObject = ((AnimatorSet)localObject).getChildAnimations().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Animator localAnimator = (Animator)((Iterator)localObject).next();
          localAnimator.end();
          localAnimator.cancel();
        }
        this.mAlphaset.end();
        this.mAlphaset.cancel();
      }
      this.mAlphaset = null;
    }
  }
  
  private void doAfterGetPhotoCollectionInfo()
  {
    IPublicAccountImageCollectionUtils.PhotoCollectionInfo localPhotoCollectionInfo = this.photoCollectionInfo;
    if (localPhotoCollectionInfo == null) {
      return;
    }
    this.webUrl = localPhotoCollectionInfo.jdField_b_of_type_JavaLangString;
    this.webName = this.photoCollectionInfo.e;
    this.webImg = this.photoCollectionInfo.d;
    this.puin = this.photoCollectionInfo.c;
    if (TextUtils.isEmpty(this.webDes)) {
      this.webDes = "来自QQ看点的分享";
    }
    this.mUIHandler.postDelayed(new PublicAccountImageCollectionMainActivityImpl.5(this), 0L);
    updateFollowState();
    initData(this.webImg);
    this.mPublicAccountArticleHandler.getArticleCommentCount(this.webUrl);
  }
  
  private void fetchAllArticleInfo()
  {
    if (!TextUtils.isEmpty(this.articleID))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "fetchAllArticleInfo");
      }
      getPhotoCollectionInfo();
      ThreadManager.executeOnSubThread(new PublicAccountImageCollectionMainActivityImpl.4(this));
    }
  }
  
  private List<IPublicAccountBrowser.ActionSheetItem>[] getActionSheetItems()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696399);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839067;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 2;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696413);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839068;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 3;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696420);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839071;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 9;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696402);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839065;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 10;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131696396);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130842737;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 4;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    IPublicAccountBrowser.ActionSheetItem localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131696385);
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_a_of_type_Int = 2130844237;
    localActionSheetItem.jdField_b_of_type_Int = 6;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131696391);
    localActionSheetItem.jdField_a_of_type_Int = 2130839063;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 1;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131696397);
    localActionSheetItem.jdField_a_of_type_Int = 2130842727;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 11;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private void getPhotoCollectionInfo()
  {
    this.photoCollectionInfo = ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).getPhotoCollectionInfoFromCache(this.articleID);
    if (this.photoCollectionInfo != null)
    {
      ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForProtoHit(true);
      doAfterGetPhotoCollectionInfo();
      ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).setObserver(this.mPublicAccountArticleObserver);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD);
    localStringBuilder.append(this.articleID);
    if (FileUtils.fileExistsAndNotEmpty(localStringBuilder.toString()))
    {
      ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).getPhotoCollectionInfoFromFile(this.articleID, this.mPublicAccountArticleObserver);
      ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForProtoHit(true);
      return;
    }
    ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForProtoHit(false);
    this.needFetchPhotoCollectionInfoFromServer = true;
  }
  
  private int getSourceType(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000) {
          return 16;
        }
        return DISCUSSION_SOURCE;
      }
      return TROOP_SOURCE;
    }
    return C2C_SOURCE;
  }
  
  private void initData()
  {
    this.articleID = getIntent().getStringExtra("articleid");
    this.recommend_source = getIntent().getStringExtra("recommend_source");
    if (this.recommend_source == null) {
      this.recommend_source = "";
    }
    this.recommend_position = getIntent().getIntExtra("recommend_position", 0);
    this.click_source = getIntent().getIntExtra("click_source", 1);
    this.report_source = getIntent().getIntExtra("source_for_report", 16);
    this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.uin = this.mApp.getCurrentAccountUin();
    this.mAdapter.a(this.photoCollectionInfo);
    this.mAdapter.a(this.recommendItemInfos);
    this.mAdapter.a(this.articleID);
    this.mListView.setAdapter(this.mAdapter);
  }
  
  private void initData(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = URLDrawable.getDrawable(paramString, null, null);
      if ((paramString.getStatus() == 1) && ((paramString.getCurrDrawable() instanceof RegionDrawable)))
      {
        this.thumbBitmap = ((RegionDrawable)paramString.getCurrDrawable()).getBitmap();
        return;
      }
      paramString.setURLDrawableListener(new PublicAccountImageCollectionMainActivityImpl.14(this, paramString));
      paramString.startDownload();
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqBaseActivity", 2, "initData", paramString);
      }
    }
  }
  
  private void initHandlerAndObserver()
  {
    this.mPublicAccountArticleHandler = ((IPublicAccountArticleHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_HANDLER));
    this.mPublicAccountArticleObserver = ((IPublicAccountArticleObserver)QRoute.api(IPublicAccountArticleObserver.class));
    this.mPublicAccountArticleObserver.setOnCallback(new PublicAccountImageCollectionMainActivityImpl.3(this));
    this.mPublicAccountArticleHandler.setPublicAccountArticleObserver(this.mPublicAccountArticleObserver);
  }
  
  @TargetApi(11)
  private void initUI()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    setFullScreen();
    this.mUIHandler = new Handler();
    this.titleLeft = ((ImageView)super.findViewById(2131368525));
    this.titleLeft.setOnClickListener(this);
    this.titleRight = ((ImageView)super.findViewById(2131368526));
    this.titleRight.setOnClickListener(this);
    this.relativeLayout = ((RelativeLayout)super.findViewById(2131376819));
    this.mListView = ((PublicAccountImageCollectionListView)super.findViewById(2131368518));
    this.mListView.setVerticalScrollBarEnabled(false);
    this.mListView.setDividerHeight(0);
    this.viewGroup = ((ViewGroup)getWindow().getDecorView());
    this.mAdapter = new PublicAccountImageCollectionAdapter(this, this.mListView, (QQAppInterface)super.getAppInterface());
    this.mListView.setSmoothScrollbarEnabled(false);
    this.mListView.setOnTouchListener(new PublicAccountImageCollectionMainActivityImpl.1(this));
    this.mUserGuide = ((LinearLayout)super.findViewById(2131380311));
    this.writeCommentImage = ((ImageView)super.findViewById(2131368527));
    this.commentImage = ((ImageView)super.findViewById(2131368510));
    this.commentCountText = ((TextView)super.findViewById(2131368509));
    this.zanImage = ((ImageView)super.findViewById(2131368529));
    this.zanCountText = ((TextView)super.findViewById(2131368528));
    this.shareImage = ((ImageView)super.findViewById(2131368523));
    this.commentTextView = ((TextView)super.findViewById(2131368511));
    this.writeCommentImage.setOnClickListener(this);
    this.commentImage.setOnClickListener(this);
    this.zanImage.setOnClickListener(this);
    this.shareImage.setOnClickListener(this);
    this.commentTextView.setOnClickListener(this);
    this.zanCountText.setOnClickListener(this);
    this.commentCountText.setOnClickListener(this);
  }
  
  private void reSetCenterView()
  {
    this.viewGroup.removeView(this.publicAccountMainImageView);
    this.flag = false;
  }
  
  private void reportItemEvent(int paramInt)
  {
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str1 = this.puin;
    String str2 = this.articleID;
    String str3 = this.webUrl;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(getSourceType(this.report_source));
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str1, "0X8007A7A", "0X8007A7A", 0, 0, str2, str3, (String)localObject, localStringBuilder.toString(), false);
  }
  
  private void reportItemEventRightTitle(int paramInt)
  {
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str1 = this.puin;
    String str2 = this.articleID;
    String str3 = this.webUrl;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str1, "0X8007C18", "0X8007C18", 0, 0, str2, str3, localStringBuilder.toString(), "", false);
  }
  
  @TargetApi(11)
  private void runShowAnimation(View paramView1, View paramView2, long paramLong1, long paramLong2)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView1.setAlpha(0.0F);
      paramView1.setVisibility(0);
      paramView2.setAlpha(0.0F);
      paramView2.setVisibility(0);
      paramView1 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView2 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView1.setDuration(1800L);
      paramView1.setRepeatCount(-1);
      paramView1.setRepeatMode(1);
      paramView1.setStartDelay(paramLong1);
      paramView2.setDuration(1800L);
      paramView2.setRepeatCount(-1);
      paramView2.setRepeatMode(1);
      paramView2.setStartDelay(paramLong2);
      if (this.mAlphaset == null) {
        this.mAlphaset = new AnimatorSet();
      }
      this.mAlphaset.playTogether(new Animator[] { paramView1, paramView2 });
      this.mAlphaset.start();
      return;
    }
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
  }
  
  private void setCommentText(String paramString)
  {
    if (this.commentTextView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.commentTextView.setText(paramString);
    }
  }
  
  private void shareToMobileQQ()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("mqqapi://readinjoy/apenalbum?src_type=app&version=1&articleid=");
    ((StringBuilder)localObject1).append(this.articleID);
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(79).a("web", this.webUrl, (String)localObject1, "", "");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131708787));
    ((StringBuilder)localObject2).append(this.webName);
    localObject1 = ((AbsShareMsg.Builder)localObject1).a(((StringBuilder)localObject2).toString()).a();
    localObject2 = this.webImg;
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    localAbsStructMsgItem.a((String)localObject2, this.webName, this.webDes);
    ((AbsShareMsg)localObject1).addItem(localAbsStructMsgItem);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_thumb", this.webImg);
    ((Intent)localObject2).putExtra("forward_type", -3);
    ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    ForwardBaseOption.a(this, (Intent)localObject2, 21);
  }
  
  private void showCommentPanel()
  {
    Intent localIntent = new Intent(this, PublicAccountImageCollectionCommentActivity.class);
    if (!TextUtils.isEmpty(this.mCommentDraft)) {
      localIntent.putExtra("comment", this.mCommentDraft);
    }
    localIntent.putExtra("anonymous", this.mIsAnonymous);
    startActivityForResult(localIntent, 100);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007B9A", "0X8007B9A", 0, 0, this.articleID, this.webUrl, "", "", false);
  }
  
  private void showCommentResult(boolean paramBoolean, int paramInt)
  {
    Dialog localDialog = new Dialog(this, 2131755929);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localDialog.setContentView(2131559607);
    if (!paramBoolean)
    {
      if (paramInt == 6) {
        ((TextView)localDialog.findViewById(2131381175)).setText(2131695200);
      } else if (paramInt == 10) {
        ((TextView)localDialog.findViewById(2131381175)).setText(2131695199);
      } else {
        ((TextView)localDialog.findViewById(2131381175)).setText(2131695198);
      }
    }
    else {
      this.mIsAnonymous = false;
    }
    localDialog.show();
    this.mUIHandler.postDelayed(new PublicAccountImageCollectionMainActivityImpl.10(this, localDialog), 1000L);
  }
  
  protected void addToFavorite(String paramString, boolean paramBoolean)
  {
    Object localObject = this.mApp;
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).getCurrentAccountUin();
    QfavBuilder.a(paramString).c((String)localObject).b(this, (String)localObject, 101, null);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 21)
    {
      if (paramInt1 != 100)
      {
        if (paramInt1 != 101) {
          return;
        }
        QfavBuilder.a(this, paramIntent);
        return;
      }
      if (paramIntent != null)
      {
        this.mCommentDraft = paramIntent.getStringExtra("comment");
        this.mIsAnonymous = paramIntent.getBooleanExtra("anonymous", false);
        if (paramInt2 == 0)
        {
          setCommentText(this.mCommentDraft);
          return;
        }
        if (paramInt2 == -1)
        {
          setCommentText(getString(2131695196));
          ThreadManager.executeOnSubThread(new PublicAccountImageCollectionMainActivityImpl.13(this));
        }
      }
    }
    else
    {
      if (paramInt2 != -1) {
        return;
      }
      ForwardUtils.a((QQAppInterface)this.mApp, this, getApplicationContext(), paramIntent, null);
    }
  }
  
  public void doOnBackPressed()
  {
    reportOntime(1, 0, "");
    super.doOnBackPressed();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007B8F", "0X8007B8F", 0, 0, this.articleID, this.webUrl, "", "", false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.startTime = System.currentTimeMillis();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559610);
    initUI();
    initData();
    initHandlerAndObserver();
    fetchAllArticleInfo();
    this.mScaleGestureDetector = new ScaleGestureDetector(this, new PublicAccountImageCollectionMainActivityImpl.ScaleGestureListener(this, null));
    this.mContext = getBaseContext();
    if (VersionUtils.d()) {
      getWindow().setFlags(16777216, 16777216);
    }
    PublicAccountImageCollectionActivityManager.a().a(this);
    PublicAccountImageCollectionActivityManager.a().a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.mUIHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.mUIHandler = null;
    }
    localObject = this.mListView;
    if (localObject != null) {
      ((PublicAccountImageCollectionListView)localObject).c();
    }
    localObject = this.mAdapter;
    if (localObject != null) {
      ((PublicAccountImageCollectionAdapter)localObject).a();
    }
    if (this.mContext != null) {
      this.mContext = null;
    }
    localObject = this.mHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    if (this.mPublicAccountArticleHandler != null)
    {
      if (PublicAccountImageCollectionActivityManager.a().a() == 1) {
        this.mPublicAccountArticleHandler.removePublicAccountArticleObserver();
      }
      this.mPublicAccountArticleHandler = null;
    }
    dismissGuideAnim();
    ((IImageManager)QRoute.api(IImageManager.class)).clean();
    PublicAccountImageCollectionActivityManager.a().b(this);
    ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).removeObserver();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    updateFollowState();
    PublicAccountImageCollectionAdapter localPublicAccountImageCollectionAdapter = this.mAdapter;
    if (localPublicAccountImageCollectionAdapter != null) {
      localPublicAccountImageCollectionAdapter.b();
    }
  }
  
  @TargetApi(11)
  public void hideUserGuide()
  {
    if (this.mUserGuide.getVisibility() == 8) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "hide user guide");
    }
    dismissGuideAnim();
    this.mUIHandler.post(new PublicAccountImageCollectionMainActivityImpl.6(this));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131368523)
    {
      switch (i)
      {
      default: 
        switch (i)
        {
        default: 
          return;
        case 2131368529: 
          zan();
          return;
        case 2131368528: 
          zan();
          return;
        case 2131368527: 
          writeComment();
          return;
        case 2131368525: 
          doOnBackPressed();
        }
        showMoreView();
        return;
      case 2131368511: 
        writeComment();
        return;
      case 2131368510: 
        showComment();
        return;
      }
      showComment();
      return;
    }
    share();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    if (this.actionSheet.isShowing()) {
      this.actionSheet.dismiss();
    }
    paramInt = ((PublicAccountImageCollectionMainActivityImpl.ActionSheetItemViewHolder)paramAdapterView).a.jdField_b_of_type_Int;
    paramAdapterView = this.webUrl;
    if (paramInt == 1)
    {
      ((ClipboardManager)getSystemService("clipboard")).setText(paramAdapterView);
      QRUtils.a(2, 2131691296);
      reportItemEventRightTitle(1011);
      return;
    }
    if (paramInt == 11) {
      paramView = null;
    }
    try
    {
      paramAdapterView = URLEncoder.encode(paramAdapterView, "UTF-8");
    }
    catch (UnsupportedEncodingException paramAdapterView)
    {
      label96:
      Object localObject;
      StringBuilder localStringBuilder;
      break label96;
    }
    paramAdapterView = paramView;
    if (QLog.isColorLevel())
    {
      QLog.d("qqBaseActivity", 2, "encode url failed, because UTF-8 is unknown");
      paramAdapterView = paramView;
    }
    paramView = String.valueOf(NetConnInfoCenter.getServerTime());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramAdapterView);
    ((StringBuilder)localObject).append(200);
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append("jubao@article@123");
    localObject = MD5Utils.encodeHexStr(((StringBuilder)localObject).toString()).toLowerCase();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://jubao.mp.qq.com/mobile/report?qq=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append("&mp_uin=");
    localStringBuilder.append(this.puin);
    localStringBuilder.append("&scene=200&sub_appname=article_webview&timestamp=");
    localStringBuilder.append(paramView);
    localStringBuilder.append("&sign=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&article_url=");
    localStringBuilder.append(paramAdapterView);
    paramAdapterView = localStringBuilder.toString();
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("url", paramAdapterView);
    paramView.putExtra("hide_more_button", true);
    startActivity(paramView);
    reportItemEventRightTitle(1008);
    return;
    if (paramInt == 2)
    {
      shareToMobileQQ();
      reportItemEvent(1001);
      if (this.whereShow == 2) {
        reportItemEventRightTitle(1001);
      }
    }
    else if (paramInt == 4)
    {
      paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(paramAdapterView));
      paramAdapterView.putExtra("normal", true);
    }
    try
    {
      startActivity(paramAdapterView);
      reportItemEventRightTitle(1006);
      return;
    }
    catch (ActivityNotFoundException paramAdapterView)
    {
      label396:
      break label396;
    }
    QRUtils.a(1, 2131695222);
    return;
    if (paramInt == 3)
    {
      ShareUtils.a(this.mApp, this, this.webImg, this.webName, this.webDes, paramAdapterView);
      reportItemEvent(1002);
      if (this.whereShow == 2) {
        reportItemEventRightTitle(1002);
      }
    }
    else
    {
      if (paramInt == 6)
      {
        addToFavorite(paramAdapterView, true);
        reportItemEventRightTitle(1007);
        return;
      }
      if ((paramInt == 9) || (paramInt == 10))
      {
        if (paramInt == 9)
        {
          reportItemEvent(1003);
          if (this.whereShow == 2) {
            reportItemEventRightTitle(1003);
          }
        }
        else
        {
          reportItemEvent(1004);
          if (this.whereShow == 2) {
            reportItemEventRightTitle(1004);
          }
        }
        PublicAccountImageCollectionUtilsImpl.shareToWechatWithThumb(this, this.webName, this.webDes, paramAdapterView, this.thumbBitmap, paramInt);
      }
    }
  }
  
  public void reportOntime(int paramInt1, int paramInt2, String paramString)
  {
    if (!this.hasReport)
    {
      this.hasReport = true;
      if (this.photoCollectionInfo != null)
      {
        int i = (int)(System.currentTimeMillis() - this.startTime);
        this.mPublicAccountArticleHandler.reportReadPhotoCollection(this.articleID, this.puin, this.photoCollectionInfo.jdField_b_of_type_JavaLangString, paramInt1, paramInt2, paramString, i, this.recommendItemInfos);
        paramInt2 = 0;
        paramInt1 = 0;
        if (this.photoCollectionInfo.a != null)
        {
          paramString = this.photoCollectionInfo.a.iterator();
          for (;;)
          {
            paramInt2 = paramInt1;
            if (!paramString.hasNext()) {
              break;
            }
            if (((IPublicAccountImageCollectionUtils.PhotoItemInfo)paramString.next()).jdField_a_of_type_Boolean) {
              paramInt1 += 1;
            }
          }
        }
        paramString = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        String str1 = this.puin;
        String str2 = this.articleID;
        String str3 = this.webUrl;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i);
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramInt2);
        paramString.publicAccountReportClickEvent(null, str1, "0X8007B8B", "0X8007B8B", 0, 0, str2, str3, (String)localObject, localStringBuilder.toString(), false);
      }
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  void setFullScreen()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      super.getWindow().addFlags(67108864);
    }
    if (this.mSystemBarComp != null)
    {
      int i = getResources().getColor(2131167333);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
    if ((VersionUtils.g()) && (VersionUtils.e())) {
      getWindow().getDecorView().setSystemUiVisibility(4102);
    }
    if (VersionUtils.e()) {
      getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new PublicAccountImageCollectionMainActivityImpl.2(this));
    }
  }
  
  void share()
  {
    showActionSheet(1);
  }
  
  public void showActionSheet(int paramInt)
  {
    if (!isFinishing())
    {
      if (this.mAdapter == null) {
        return;
      }
      View localView;
      if (this.actionSheet == null)
      {
        this.actionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
        localView = createViewFlipper(paramInt);
        this.actionSheet.setActionContentView(localView, null);
      }
      else
      {
        localView = createViewFlipper(paramInt);
        this.actionSheet.setActionContentView(localView, null);
      }
    }
    try
    {
      if (!this.actionSheet.isShowing())
      {
        this.actionSheet.show();
        if (paramInt == 2)
        {
          this.whereShow = 2;
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007A79", "0X8007A79", 0, 0, this.articleID, this.webUrl, "", "", false);
          return;
        }
        this.whereShow = 1;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007A80", "0X8007A80", 0, 0, this.articleID, this.webUrl, "", "", false);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  void showComment()
  {
    Object localObject = this.photoCollectionInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((IPublicAccountImageCollectionUtils.PhotoCollectionInfo)localObject).jdField_b_of_type_JavaLangString)))
    {
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.photoCollectionInfo.f);
      ((Intent)localObject).putExtra("hide_more_button", true);
      startActivity((Intent)localObject);
    }
  }
  
  void showMoreView()
  {
    showActionSheet(2);
  }
  
  @TargetApi(11)
  public void showUserGuide()
  {
    if (this.mUserGuide.getVisibility() == 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "show user guide");
    }
    TranslateAnimation localTranslateAnimation = this.mTranslateAnimationUp;
    if (localTranslateAnimation != null) {
      localTranslateAnimation.cancel();
    }
    localTranslateAnimation = this.mTranslateAnimationDown;
    if (localTranslateAnimation != null) {
      localTranslateAnimation.cancel();
    }
    this.mTranslateAnimationUp = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
    this.mTranslateAnimationUp.setDuration(200L);
    this.mTranslateAnimationUp.setFillAfter(true);
    this.mTranslateAnimationDown = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
    this.mTranslateAnimationDown.setDuration(300L);
    this.mTranslateAnimationDown.setFillAfter(true);
    this.mTranslateAnimationUp.setAnimationListener(new PublicAccountImageCollectionMainActivityImpl.7(this));
    this.mTranslateAnimationDown.setAnimationListener(new PublicAccountImageCollectionMainActivityImpl.8(this));
    this.mUIHandler.postDelayed(new PublicAccountImageCollectionMainActivityImpl.9(this), 300L);
  }
  
  void updateFollowState()
  {
    ThreadManager.post(new PublicAccountImageCollectionMainActivityImpl.16(this), 5, null, true);
  }
  
  void writeComment()
  {
    showCommentPanel();
  }
  
  void zan()
  {
    this.isLiked ^= true;
    if (this.isLiked)
    {
      this.likeCount += 1;
      this.zanImage.setImageResource(2130841682);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007B95", "0X8007B95", 0, 0, this.articleID, this.webUrl, "", "", false);
    }
    else
    {
      this.likeCount -= 1;
      this.zanImage.setImageResource(2130841681);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007B96", "0X8007B96", 0, 0, this.articleID, this.webUrl, "", "", false);
    }
    TextView localTextView = this.zanCountText;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.likeCount);
    localTextView.setText(localStringBuilder.toString());
    this.mPublicAccountArticleHandler.sendArticleLikeReq(this.articleID, this.isLiked, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl
 * JD-Core Version:    0.7.0.1
 */