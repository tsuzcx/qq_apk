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
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
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
  AlphaAnimation A = new AlphaAnimation(0.0F, 1.0F);
  AlphaAnimation B = new AlphaAnimation(1.0F, 0.0F);
  Runnable C = new FriendProfileImageActivity.11(this);
  boolean D = false;
  private boolean E;
  private TextView F;
  private int G = 0;
  private CustomHandler H = null;
  private PreloadProcHitSession I = new PreloadProcHitSession("profile_image", "com.tencent.mobileqq:tool");
  private long J = 350L;
  private Rect K;
  private boolean L = false;
  private View.OnClickListener M = new FriendProfileImageActivity.15(this);
  private QQToastNotifier N;
  Gallery a;
  FriendProfileImageAdapter b;
  FriendProfileImageModel c;
  View d;
  TextView e;
  ImageButton f;
  RelativeLayout g;
  View h;
  int i;
  AsyncTask<Void, Void, Void> j;
  int k;
  boolean l;
  boolean m;
  FrameLayout n;
  RelativeLayout o;
  RelativeLayout p;
  ImageView q;
  ImageView r;
  long s;
  int t;
  ImageView u;
  boolean v;
  boolean w;
  boolean x;
  AllInOne y;
  QQProgressDialog z;
  
  private void a(Rect paramRect1, Rect paramRect2)
  {
    this.D = true;
    View localView = getActivity().findViewById(16908290);
    this.n.setVisibility(0);
    if ((paramRect2 != null) && (paramRect1 != null))
    {
      this.K = paramRect1;
      int i5 = paramRect1.width();
      int i6 = paramRect1.height();
      int i2 = paramRect2.width();
      int i1 = paramRect2.height();
      int i3 = localView.getWidth();
      int i4 = localView.getHeight();
      if ((i2 <= i3) && (i1 <= i4)) {
        break label165;
      }
      float f2 = i3;
      float f1 = i2;
      f2 /= f1;
      float f4 = i4;
      float f3 = i1;
      f4 /= f3;
      if (f2 < f4)
      {
        i1 = Math.round(f2 * f3);
        i2 = i3;
      }
      else
      {
        i2 = Math.round(f4 * f1);
        i1 = i4;
      }
      label165:
      f2 = AnimationUtils.a(i2, i1, i3, i4);
      i3 = i2;
      if (i2 == 0) {
        i3 = 1;
      }
      i2 = i1;
      if (i1 == 0) {
        i2 = 1;
      }
      if ((i3 != i5) || (i6 != i2))
      {
        f1 = i5 / i3 / f2;
        f2 = i6 / i2 / f2;
        if (f1 > f2) {
          f1 = f2;
        }
        paramRect1 = new ScaleAnimation(f1, 1.0F, f1, 1.0F, 1, 0.5F, 1, 0.5F);
        paramRect1.setDuration(this.J);
        paramRect1.setInterpolator(new AccelerateDecelerateInterpolator());
        this.a.startAnimation(paramRect1);
      }
      paramRect1 = new Rect(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getHeight() - localView.getPaddingBottom());
      AnimationUtils.a(localView, paramRect1);
      i1 = paramRect1.centerX();
      i2 = paramRect1.centerY();
      i3 = this.K.centerX();
      i4 = this.K.centerY();
      paramRect1 = new TranslateAnimation(-(i1 - i3), 0.0F, -(i2 - i4), 0.0F);
      paramRect1.setDuration(this.J);
      paramRect1.setInterpolator(new AccelerateDecelerateInterpolator());
      paramRect1.setAnimationListener(new FriendProfileImageActivity.12(this));
      this.g.startAnimation(paramRect1);
      if (!this.x) {
        this.n.postDelayed(new FriendProfileImageActivity.13(this), this.J);
      }
      paramRect1 = new AlphaAnimation(0.0F, 1.0F);
      paramRect1.setInterpolator(new DecelerateInterpolator());
      paramRect1.setDuration(350L);
      paramRect1.setFillAfter(true);
      this.h.startAnimation(paramRect1);
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
    this.A.setDuration(300L);
    this.B.setDuration(300L);
    this.A.setAnimationListener(new FriendProfileImageActivity.9(this, paramTextView));
    this.B.setAnimationListener(new FriendProfileImageActivity.10(this, paramTextView));
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
    if (isFinishing()) {
      return;
    }
    Object localObject1 = this.c.c();
    if (localObject1 != null)
    {
      if (((FriendProfileImageModel.ProfileImageInfo)localObject1).d != 6) {
        return;
      }
      Object localObject2 = (ActionSheet)ActionSheetHelper.b(this, null);
      boolean bool = true;
      ((ActionSheet)localObject2).addButton(2131890804, 1);
      ((ActionSheet)localObject2).addButton(2131889841, 1);
      ((ActionSheet)localObject2).addButton(2131890810, 1);
      ((ActionSheet)localObject2).addButton(2131889837, 1);
      if ((!this.m) && (this.l)) {
        ((ActionSheet)localObject2).addButton(2131890801, 3);
      }
      ((ActionSheet)localObject2).addCancelButton(2131887648);
      if ((TextUtils.isEmpty(this.c.h)) || (!TextUtils.equals(this.c.h, this.app.getCurrentAccountUin()))) {
        bool = false;
      }
      ((ActionSheet)localObject2).setOnButtonClickListener(new FriendProfileImageActivity.7(this, (FriendProfileImageModel.ProfileImageInfo)localObject1, bool, (ActionSheet)localObject2));
      ((ActionSheet)localObject2).show();
      localObject2 = this.app;
      if (bool) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X800A8C9", "0X800A8C9", 0, 0, (String)localObject1, "", "", "");
    }
  }
  
  void a()
  {
    if (this.z == null)
    {
      this.z = new QQProgressDialog(this, getTitleBarHeight());
      this.z.c(2131888463);
    }
    this.z.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.N == null) {
      this.N = new QQToastNotifier(this);
    }
    this.N.notifyUser(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    c(paramProfileImageInfo);
  }
  
  void a(AdapterView paramAdapterView, int paramInt)
  {
    if (!this.D)
    {
      if (paramAdapterView.getCount() > 1)
      {
        TextView localTextView = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt + 1);
        localStringBuilder.append("/");
        localStringBuilder.append(paramAdapterView.getCount());
        localTextView.setText(localStringBuilder.toString());
        if (this.e.getVisibility() == 4)
        {
          this.e.setVisibility(0);
          this.e.startAnimation(this.A);
          if (this.E)
          {
            this.e.postDelayed(this.C, 3000L);
            this.E = false;
            return;
          }
          this.e.postDelayed(this.C, 2000L);
          return;
        }
        this.e.removeCallbacks(this.C);
        this.e.clearAnimation();
        this.e.postDelayed(this.C, 2000L);
        return;
      }
      this.e.setVisibility(4);
    }
  }
  
  void b()
  {
    if ((!this.D) && (!this.a.resetScale(false)))
    {
      c();
      View localView = this.d;
      if (localView != null) {
        this.b.a(localView);
      }
    }
  }
  
  void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this, getString(2131888445), 0).show();
      return;
    }
    Card localCard = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.c.h);
    if (localCard != null)
    {
      ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.c.h, localCard.uFaceTimeStamp, HexUtil.hexStr2Bytes(paramProfileImageInfo.a));
      a();
    }
  }
  
  public void c()
  {
    this.D = true;
    this.f.setVisibility(4);
    this.e.setVisibility(4);
    if (this.o.getVisibility() == 0) {
      this.o.setVisibility(8);
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
    this.a.startAnimation(localAnimationSet);
    this.h.startAnimation(localAlphaAnimation);
  }
  
  public void c(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if ((this.G != 1) && (this.d != null))
    {
      if (paramProfileImageInfo == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateCurrentImage uin=");
        ((StringBuilder)localObject).append(paramProfileImageInfo.g);
        ((StringBuilder)localObject).append(", state=");
        ((StringBuilder)localObject).append(paramProfileImageInfo.d);
        QLog.d("Q.profilecard.PhotoWall", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (String)this.d.getTag();
      if (paramProfileImageInfo.d == 6)
      {
        if ((localObject == null) || (!((String)localObject).equals(paramProfileImageInfo.c))) {
          this.b.c(paramProfileImageInfo, this.d);
        }
      }
      else if ((paramProfileImageInfo.d != 3) && (paramProfileImageInfo.d != 4))
      {
        if ((paramProfileImageInfo.d == 5) || (paramProfileImageInfo.d == 2)) {
          this.b.a(paramProfileImageInfo, this.d);
        }
      }
      else
      {
        if ((localObject == null) || (!((String)localObject).equals(paramProfileImageInfo.b))) {
          this.b.b(paramProfileImageInfo, this.d);
        }
        if ((paramProfileImageInfo.f) && (paramProfileImageInfo.d == 4))
        {
          localObject = (ImageProgressCircle)this.d.findViewById(2131435466);
          if (localObject != null)
          {
            ((ImageProgressCircle)localObject).setProgress(paramProfileImageInfo.e);
            if (((ImageProgressCircle)localObject).getVisibility() != 0) {
              this.b.a((ImageProgressCircle)localObject);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("progressCircle = ");
            ((StringBuilder)localObject).append(paramProfileImageInfo.e);
            QLog.d("Q.profilecard.PhotoWall", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void doOnBackPressed()
  {
    b();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131168376);
    super.setContentView(2131625166);
    this.H = new CustomHandler(getMainLooper(), this);
    paramBundle = getIntent().getExtras();
    this.v = paramBundle.getBoolean("is_from_face2face_add_friend", false);
    this.w = paramBundle.getBoolean("is_hide_actionsheet", false);
    this.x = paramBundle.getBoolean("is_hide_footbar", false);
    this.G = paramBundle.getInt("curType", 0);
    this.y = ((AllInOne)getIntent().getParcelableExtra("AllInOne"));
    this.a = ((Gallery)findViewById(2131433934));
    this.a.setVisibility(0);
    this.e = ((TextView)findViewById(2131447062));
    this.g = ((RelativeLayout)findViewById(2131445137));
    this.h = findViewById(2131429234);
    this.h.setBackgroundColor(-16777216);
    this.n = ((FrameLayout)findViewById(2131445141));
    Object localObject1 = ((ViewStub)findViewById(2131446481)).inflate();
    this.o = ((RelativeLayout)((View)localObject1).findViewById(2131431311));
    this.p = ((RelativeLayout)((View)localObject1).findViewById(2131431312));
    this.f = ((ImageButton)findViewById(2131431689));
    this.u = ((ImageView)findViewById(2131427966));
    this.u.setVisibility(4);
    this.F = ((TextView)((View)localObject1).findViewById(2131447194));
    this.f.setVisibility(4);
    this.f.setOnClickListener(this.M);
    this.u.setOnClickListener(new FriendProfileImageActivity.1(this));
    this.b = new FriendProfileImageAdapter(this);
    Object localObject2 = this.y;
    int i1;
    if (localObject2 != null) {
      i1 = ((AllInOne)localObject2).pa;
    } else {
      i1 = -1;
    }
    this.c = new FriendProfileImageAvatar(this.app, ProfilePAUtils.isFromGuild(i1));
    this.m = true;
    if (this.G == 1) {
      this.b.a(true);
    }
    this.c.h = paramBundle.getString("friendUin");
    this.s = paramBundle.getLong("extra_pendant_id", 0L);
    if (this.s == 0L)
    {
      this.F.setText(2131914352);
      this.s = 5L;
    }
    this.t = paramBundle.getInt("extra_action_source", 0);
    if (this.c.h != null)
    {
      localObject2 = (FrameLayout.LayoutParams)this.g.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject2).bottomMargin = getResources().getDimensionPixelSize(2131298273);
      this.g.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.p.setOnClickListener(this);
      this.q = ((ImageView)((View)localObject1).findViewById(2131435552));
      ThreadManager.getSubThreadHandler().post(this);
      this.r = ((ImageView)((View)localObject1).findViewById(2131435529));
      ThreadManager.post(new FriendProfileImageActivity.2(this), 8, null, true);
    }
    if (this.app.getCurrentAccountUin().equals(this.c.h)) {
      this.l = true;
    } else {
      this.l = false;
    }
    this.k = paramBundle.getInt("index", -1);
    localObject1 = new FriendProfileImageModel.ProfileImageInfo();
    ((FriendProfileImageModel.ProfileImageInfo)localObject1).g = this.c.h;
    ((FriendProfileImageModel.ProfileImageInfo)localObject1).a = paramBundle.getString("filekey");
    this.c.a(this, (FriendProfileImageModel.ProfileImageInfo)localObject1);
    this.i = this.c.d();
    this.c.a(this);
    this.c.b(this);
    this.b.a(this.c);
    this.a.setAdapter(this.b);
    this.a.setSelection(this.c.d());
    this.a.setSpacing(getResources().getDimensionPixelSize(2131297535));
    this.a.setOnItemClickListener(new FriendProfileImageActivity.3(this));
    this.a.setOnItemSelectedListener(new FriendProfileImageActivity.4(this));
    a(this.e);
    this.a.setOnItemLongClickListener(new FriendProfileImageActivity.5(this));
    this.j = new FriendProfileImageActivity.6(this, (FriendProfileImageModel.ProfileImageInfo)localObject1);
    return true;
  }
  
  protected void doOnDestroy()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this);
    this.H.removeCallbacksAndMessages(null);
    this.c.a(null);
    this.c.a(this);
    this.b.a();
    super.doOnDestroy();
    this.j.cancel(true);
    this.d = null;
    Object localObject = this.A;
    if (localObject != null) {
      ((AlphaAnimation)localObject).setAnimationListener(null);
    }
    localObject = this.B;
    if (localObject != null) {
      ((AlphaAnimation)localObject).setAnimationListener(null);
    }
    localObject = this.a;
    if (localObject != null) {
      try
      {
        int i2 = ((Gallery)localObject).getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          localObject = this.a.getChildAt(i1);
          if (localObject != null)
          {
            localObject = ((View)localObject).findViewById(2131435357);
            if ((localObject instanceof URLImageView))
            {
              ((URLImageView)localObject).setImageDrawable(null);
              ((URLImageView)localObject).setBackgroundDrawable(null);
            }
          }
          i1 += 1;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
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
  
  protected void doOnPause()
  {
    super.doOnPause();
    AbstractVideoImage.pauseAll();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    this.I.e();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    AbstractVideoImage.resumeAll();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    AvatarPendantUtil.a(this.app, this, "sp_key_entrance_card_face_preview", this.app.getCurrentAccountUin(), this.I);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.L))
    {
      float f1 = getResources().getDisplayMetrics().density;
      int i1 = getResources().getDisplayMetrics().densityDpi;
      Object localObject = this.c.c();
      this.L = true;
      Rect localRect3 = (Rect)getIntent().getExtras().getParcelable("KEY_THUMBNAL_BOUND");
      int i2;
      if (localObject != null)
      {
        if (((FriendProfileImageModel.ProfileImageInfo)localObject).d == 6) {
          i1 = ImageUtil.a(640, 160, i1);
        } else {
          i1 = ImageUtil.a(100, 160, i1);
        }
        i2 = i1;
      }
      else
      {
        i1 = 0;
        i2 = 0;
      }
      Rect localRect1 = new Rect(0, 0, i1, i2);
      Rect localRect2 = ImageUtil.a(localRect1, (int)getResources().getDimension(2131298203), f1);
      localObject = localRect2;
      if (localRect2 == null) {
        localObject = localRect1;
      }
      a(localRect3, (Rect)localObject);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if (i1 != 1) {
        return true;
      }
      if (!isFinishing())
      {
        a(2131888445, 1);
        return true;
      }
    }
    else
    {
      this.q.setImageDrawable((Drawable)paramMessage.obj);
    }
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131431312) && (this.c != null)) {
      if (!com.tencent.mobileqq.util.Utils.b())
      {
        Toast.makeText(super.getApplicationContext(), getString(2131916075), 0).show();
      }
      else
      {
        if (this.c.h != null) {
          this.c.h.equals(this.app.getCurrentAccountUin());
        }
        this.I.b();
        if (AvatarPendantUtil.b(this.s)) {
          str = "FriendToDIYPendant";
        } else {
          str = "FriendToPendant";
        }
        String str = IndividuationUrlHelper.a(str);
        if (!TextUtils.isEmpty(str))
        {
          str = VasWebviewUtil.b(str.replace("[sharefri]", this.c.h), 44);
          Intent localIntent = new Intent(this, QQBrowserActivity.class);
          localIntent.putExtra("hide_left_button", false);
          localIntent.putExtra("show_right_close_button", false);
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("url", str);
          localIntent.putExtra("business", 512L);
          VasWebviewUtil.a(512L, localIntent);
          localIntent.putExtra("isShowAd", false);
          startActivity(localIntent);
          ReportController.b(this.app, "CliOper", "", "", "PendantMarket", "OtherEntrance", 0, 0, "", "", "", "");
        }
        else
        {
          QLog.e("Q.profilecard.PhotoWall", 1, "click container_pendant_footer ret null url");
        }
        if (this.c.h != null) {
          if (this.c.h.equals(this.app.getCurrentAccountUin())) {
            ReportController.b(this.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoBigheadClick", 0, 0, "", "", "", "");
          } else {
            ReportController.b(this.app, "CliOper", "", "", "AvatarClick", "KerenInfoButtonClick", this.t, 0, "", "", "", "");
          }
        }
        AvatarPendantUtil.a(this, "sp_key_entrance_card_face_preview", this.app.getCurrentAccountUin(), System.currentTimeMillis());
        finish();
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
  
  public void run()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((FriendProfileImageModel)localObject).h == null) {
        return;
      }
      localObject = this.y;
      int i1;
      if (localObject != null) {
        i1 = ((AllInOne)localObject).pa;
      } else {
        i1 = -1;
      }
      if (ProfilePAUtils.isFromGuild(i1)) {
        localObject = ((IQQGuildAvatarApi)this.app.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(this.app, this.c.h);
      } else {
        localObject = FaceDrawable.getFaceDrawable(this.app, 1, this.c.h);
      }
      Message localMessage = Message.obtain();
      localMessage.what = 0;
      localMessage.obj = localObject;
      this.H.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity
 * JD-Core Version:    0.7.0.1
 */