package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.adapter.FriendProfileImageAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class FriendProfileImageActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, FriendProfileImageModel.InfoUpdateListener, Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  AsyncTask<Void, Void, Void> jdField_a_of_type_AndroidOsAsyncTask;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new FriendProfileImageActivity.15(this);
  View jdField_a_of_type_AndroidViewView;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendProfileImageModel jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel;
  ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  FriendProfileImageAdapter jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter;
  private PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("profile_image", "com.tencent.mobileqq:tool");
  private CustomHandler jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler = null;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  Gallery jdField_a_of_type_ComTencentWidgetGallery;
  Runnable jdField_a_of_type_JavaLangRunnable = new FriendProfileImageActivity.11(this);
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 350L;
  View jdField_b_of_type_AndroidViewView;
  AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean;
  boolean e;
  boolean f = false;
  private boolean g;
  private boolean h = false;
  
  private void a(Rect paramRect1, Rect paramRect2)
  {
    this.f = true;
    View localView = getActivity().findViewById(16908290);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    int i2;
    int i3;
    int n;
    int k;
    int m;
    int i;
    int j;
    float f1;
    float f2;
    if ((paramRect2 != null) && (paramRect1 != null))
    {
      this.jdField_a_of_type_AndroidGraphicsRect = paramRect1;
      i2 = paramRect1.width();
      i3 = paramRect1.height();
      n = paramRect2.width();
      int i1 = paramRect2.height();
      k = localView.getWidth();
      m = localView.getHeight();
      if (n <= k)
      {
        i = i1;
        j = n;
        if (i1 <= m) {}
      }
      else
      {
        f1 = k / n;
        f2 = m / i1;
        if (f1 >= f2) {
          break label469;
        }
        i = Math.round(i1 * f1);
        j = k;
      }
      f2 = AnimationUtils.a(j, i, k, m);
      k = j;
      if (j == 0) {
        k = 1;
      }
      if (i != 0) {
        break label490;
      }
      i = 1;
    }
    label469:
    label487:
    label490:
    for (;;)
    {
      if ((k != i2) || (i3 != i))
      {
        f1 = i2 / k / f2;
        f2 = i3 / i / f2;
        if (f1 <= f2) {
          break label487;
        }
        f1 = f2;
      }
      for (;;)
      {
        paramRect1 = new ScaleAnimation(f1, 1.0F, f1, 1.0F, 1, 0.5F, 1, 0.5F);
        paramRect1.setDuration(this.jdField_b_of_type_Long);
        paramRect1.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(paramRect1);
        paramRect1 = new Rect(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getHeight() - localView.getPaddingBottom());
        AnimationUtils.a(localView, paramRect1);
        i = paramRect1.centerX();
        j = paramRect1.centerY();
        k = this.jdField_a_of_type_AndroidGraphicsRect.centerX();
        m = this.jdField_a_of_type_AndroidGraphicsRect.centerY();
        paramRect1 = new TranslateAnimation(-(i - k), 0.0F, -(j - m), 0.0F);
        paramRect1.setDuration(this.jdField_b_of_type_Long);
        paramRect1.setInterpolator(new AccelerateDecelerateInterpolator());
        paramRect1.setAnimationListener(new FriendProfileImageActivity.12(this));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramRect1);
        if (!this.e) {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new FriendProfileImageActivity.13(this), this.jdField_b_of_type_Long);
        }
        paramRect1 = new AlphaAnimation(0.0F, 1.0F);
        paramRect1.setInterpolator(new DecelerateInterpolator());
        paramRect1.setDuration(350L);
        paramRect1.setFillAfter(true);
        this.jdField_b_of_type_AndroidViewView.startAnimation(paramRect1);
        return;
        j = Math.round(n * f2);
        i = m;
        break;
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new FriendProfileImageActivity.9(this, paramTextView));
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new FriendProfileImageActivity.10(this, paramTextView));
  }
  
  private void a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new FriendProfileImageActivity.8(this, paramString), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      b(paramString);
      return;
    }
    b(paramString);
  }
  
  private void b(String paramString)
  {
    AIOGalleryUtils.a(this, new File(paramString), com.tencent.image.Utils.Crc64String(paramString));
  }
  
  private void d()
  {
    if (isFinishing()) {}
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
    } while ((localObject1 == null) || (((FriendProfileImageModel.ProfileImageInfo)localObject1).jdField_a_of_type_Int != 6));
    Object localObject2 = (ActionSheet)ActionSheetHelper.a(this, null);
    ((ActionSheet)localObject2).addButton(2131693302, 1);
    ((ActionSheet)localObject2).addButton(2131692815, 1);
    ((ActionSheet)localObject2).addButton(2131693308, 1);
    ((ActionSheet)localObject2).addButton(2131692811, 1);
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
      ((ActionSheet)localObject2).addButton(2131693299, 3);
    }
    ((ActionSheet)localObject2).addCancelButton(2131690800);
    boolean bool;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString, this.app.getCurrentAccountUin())))
    {
      bool = true;
      ((ActionSheet)localObject2).setOnButtonClickListener(new FriendProfileImageActivity.7(this, (FriendProfileImageModel.ProfileImageInfo)localObject1, bool, (ActionSheet)localObject2));
      ((ActionSheet)localObject2).show();
      localObject2 = this.app;
      if (!bool) {
        break label203;
      }
    }
    label203:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X800A8C9", "0X800A8C9", 0, 0, (String)localObject1, "", "", "");
      return;
      bool = false;
      break;
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131691583);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    c(paramProfileImageInfo);
  }
  
  void a(AdapterView paramAdapterView, int paramInt)
  {
    if (!this.f)
    {
      if (paramAdapterView.getCount() <= 1) {
        break label160;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + 1 + "/" + paramAdapterView.getCount());
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 4) {
        break label125;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      if (this.g)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        this.g = false;
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    return;
    label125:
    this.jdField_a_of_type_AndroidWidgetTextView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    return;
    label160:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  void b()
  {
    if ((!this.f) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false)))
    {
      c();
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (!NetworkUtil.d(this)) {
      QQToast.a(this, getString(2131691565), 0).a();
    }
    Card localCard;
    do
    {
      return;
      localCard = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString);
    } while (localCard == null);
    ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString, localCard.uFaceTimeStamp, HexUtil.hexStr2Bytes(paramProfileImageInfo.jdField_a_of_type_JavaLangString));
    a();
  }
  
  public void c()
  {
    this.f = true;
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(350L);
    localAlphaAnimation.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 2.0F, 1.0F, 2.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setDuration(350L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new FriendProfileImageActivity.14(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void c(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_AndroidViewView == null) || (paramProfileImageInfo == null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.PhotoWall", 2, "updateCurrentImage uin=" + paramProfileImageInfo.d + ", state=" + paramProfileImageInfo.jdField_a_of_type_Int);
            }
            localObject = (String)this.jdField_a_of_type_AndroidViewView.getTag();
            if (paramProfileImageInfo.jdField_a_of_type_Int != 6) {
              break;
            }
          } while ((localObject != null) && (((String)localObject).equals(paramProfileImageInfo.c)));
          this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.c(paramProfileImageInfo, this.jdField_a_of_type_AndroidViewView);
          return;
          if ((paramProfileImageInfo.jdField_a_of_type_Int != 3) && (paramProfileImageInfo.jdField_a_of_type_Int != 4)) {
            break;
          }
          if ((localObject == null) || (!((String)localObject).equals(paramProfileImageInfo.jdField_b_of_type_JavaLangString))) {
            this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.b(paramProfileImageInfo, this.jdField_a_of_type_AndroidViewView);
          }
        } while ((!paramProfileImageInfo.jdField_a_of_type_Boolean) || (paramProfileImageInfo.jdField_a_of_type_Int != 4));
        Object localObject = (ImageProgressCircle)this.jdField_a_of_type_AndroidViewView.findViewById(2131368832);
        if (localObject != null)
        {
          ((ImageProgressCircle)localObject).setProgress(paramProfileImageInfo.jdField_b_of_type_Int);
          if (((ImageProgressCircle)localObject).getVisibility() != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a((ImageProgressCircle)localObject);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.PhotoWall", 2, "progressCircle = " + paramProfileImageInfo.jdField_b_of_type_Int);
      return;
    } while ((paramProfileImageInfo.jdField_a_of_type_Int != 5) && (paramProfileImageInfo.jdField_a_of_type_Int != 2));
    this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(paramProfileImageInfo, this.jdField_a_of_type_AndroidViewView);
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void doOnBackPressed()
  {
    b();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167305);
    super.setContentView(2131559371);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler = new CustomHandler(getMainLooper(), this);
    paramBundle = getIntent().getExtras();
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("is_from_face2face_add_friend", false);
    this.jdField_d_of_type_Boolean = paramBundle.getBoolean("is_hide_actionsheet", false);
    this.e = paramBundle.getBoolean("is_hide_footbar", false);
    this.jdField_d_of_type_Int = paramBundle.getInt("curType", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131367677));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379091));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377356));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131363419);
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131377359));
    Object localObject = ((ViewStub)findViewById(2131378602)).inflate();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131365283));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131365284));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131365630));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362410));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379206));
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new FriendProfileImageActivity.1(this));
    this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter = new FriendProfileImageAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel = new FriendProfileImageAvatar(this.app);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_d_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString = paramBundle.getString("friendUin");
    this.jdField_a_of_type_Long = paramBundle.getLong("extra_pendant_id", 0L);
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717220);
      this.jdField_a_of_type_Long = 5L;
    }
    this.jdField_c_of_type_Int = paramBundle.getInt("extra_action_source", 0);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131297618);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368914));
      ThreadManager.getSubThreadHandler().post(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368891));
      ThreadManager.post(new FriendProfileImageActivity.2(this), 8, null, true);
    }
    if (this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString)) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      this.jdField_b_of_type_Int = paramBundle.getInt("index", -1);
      localObject = new FriendProfileImageModel.ProfileImageInfo();
      ((FriendProfileImageModel.ProfileImageInfo)localObject).d = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString;
      ((FriendProfileImageModel.ProfileImageInfo)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString("filekey");
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this, (FriendProfileImageModel.ProfileImageInfo)localObject);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b(this);
      this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel);
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter);
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b());
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297168));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new FriendProfileImageActivity.3(this));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new FriendProfileImageActivity.4(this));
      a(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new FriendProfileImageActivity.5(this));
      this.jdField_a_of_type_AndroidOsAsyncTask = new FriendProfileImageActivity.6(this, (FriendProfileImageModel.ProfileImageInfo)localObject);
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a();
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    this.jdField_a_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(null);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation != null) {
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetGallery != null) {}
    for (;;)
    {
      int i;
      try
      {
        int j = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
        i = 0;
        if (i < j)
        {
          View localView = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i);
          if (localView == null) {
            break label164;
          }
          localView = localView.findViewById(2131368729);
          if (!(localView instanceof URLImageView)) {
            break label164;
          }
          ((URLImageView)localView).setImageDrawable(null);
          ((URLImageView)localView).setBackgroundDrawable(null);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label164:
      i += 1;
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      d();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    AbstractVideoImage.pauseAll();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    AbstractVideoImage.resumeAll();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    AvatarPendantUtil.a(this.app, this, "sp_key_entrance_card_face_preview", this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    float f1;
    int i;
    Object localObject;
    Rect localRect3;
    int j;
    if ((paramBoolean) && (!this.h))
    {
      f1 = getResources().getDisplayMetrics().density;
      i = getResources().getDisplayMetrics().densityDpi;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
      this.h = true;
      localRect3 = (Rect)getIntent().getExtras().getParcelable("KEY_THUMBNAL_BOUND");
      if (localObject == null) {
        break label170;
      }
      if (((FriendProfileImageModel.ProfileImageInfo)localObject).jdField_a_of_type_Int != 6) {
        break label154;
      }
      i = ImageUtil.a(640, 160, i);
      j = i;
    }
    for (;;)
    {
      Rect localRect1 = new Rect(0, 0, j, i);
      Rect localRect2 = ImageUtil.a(localRect1, (int)getResources().getDimension(2131297559), f1);
      localObject = localRect2;
      if (localRect2 == null) {
        localObject = localRect1;
      }
      a(localRect3, (Rect)localObject);
      return;
      label154:
      i = ImageUtil.a(100, 160, i);
      j = i;
      continue;
      label170:
      i = 0;
      j = 0;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)paramMessage.obj);
      return true;
    } while ((this == null) || (isFinishing()));
    a(2131691565, 1);
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel != null)
      {
        if (com.tencent.mobileqq.util.Utils.a()) {
          break;
        }
        Toast.makeText(super.getApplicationContext(), getString(2131718859), 0).show();
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {}
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
    String str;
    if (AvatarPendantUtil.b(this.jdField_a_of_type_Long))
    {
      str = "FriendToDIYPendant";
      label117:
      str = IndividuationUrlHelper.a(str);
      if (TextUtils.isEmpty(str)) {
        break label360;
      }
      str = str.replace("[sharefri]", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString);
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("url", str);
      localIntent.putExtra("business", 512L);
      VasWebviewUtil.insertVasWbPluginToIntent(512L, localIntent);
      localIntent.putExtra("isShowAd", false);
      startActivity(localIntent);
      ReportController.b(this.app, "CliOper", "", "", "PendantMarket", "OtherEntrance", 0, 0, "", "", "", "");
      label263:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString != null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())) {
          break label373;
        }
        ReportController.b(this.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoBigheadClick", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      AvatarPendantUtil.a(this, "sp_key_entrance_card_face_preview", this.app.getCurrentAccountUin(), System.currentTimeMillis());
      finish();
      break;
      str = "FriendToPendant";
      break label117;
      label360:
      QLog.e("Q.profilecard.PhotoWall", 1, "click container_pendant_footer ret null url");
      break label263;
      label373:
      ReportController.b(this.app, "CliOper", "", "", "AvatarClick", "KerenInfoButtonClick", this.jdField_c_of_type_Int, 0, "", "", "", "");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString == null)) {
      return;
    }
    FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.jdField_b_of_type_JavaLangString);
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = localFaceDrawable;
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity
 * JD-Core Version:    0.7.0.1
 */