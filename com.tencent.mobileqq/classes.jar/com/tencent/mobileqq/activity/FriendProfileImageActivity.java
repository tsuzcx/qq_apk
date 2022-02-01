package com.tencent.mobileqq.activity;

import Override;
import aavz;
import aeam;
import aean;
import aeao;
import aeap;
import aeaq;
import aeas;
import aeat;
import aeau;
import aeav;
import aeaw;
import aeax;
import aeay;
import aeaz;
import aebb;
import aebc;
import aebd;
import ahsl;
import amhl;
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
import anri;
import anvk;
import avli;
import bdla;
import bhbx;
import bhcs;
import bhde;
import bheg;
import bhnp;
import bisl;
import bisy;
import bkzi;
import bkzz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import java.io.File;
import lzr;
import mqq.os.MqqHandler;

public class FriendProfileImageActivity
  extends BaseActivity
  implements aebc, Handler.Callback, View.OnClickListener, Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public aebb a;
  public amhl a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  public AsyncTask<Void, Void, Void> a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aeaq(this);
  public View a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageButton a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private avli jdField_a_of_type_Avli = new avli("profile_image", "com.tencent.mobileqq:tool");
  private bhde jdField_a_of_type_Bhde;
  bisl jdField_a_of_type_Bisl;
  private bisy jdField_a_of_type_Bisy;
  ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  public Gallery a;
  Runnable jdField_a_of_type_JavaLangRunnable = new FriendProfileImageActivity.11(this);
  public boolean a;
  public int b;
  private long jdField_b_of_type_Long = 350L;
  View jdField_b_of_type_AndroidViewView;
  AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  int jdField_c_of_type_Int;
  public ImageView c;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  public boolean c;
  private int d;
  public boolean d;
  boolean e;
  public boolean f = false;
  private boolean g;
  private boolean h;
  
  public FriendProfileImageActivity()
  {
    this.jdField_d_of_type_Int = 0;
  }
  
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
      f2 = aavz.a(j, i, k, m);
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
        aavz.a(localView, paramRect1);
        i = paramRect1.centerX();
        j = paramRect1.centerY();
        k = this.jdField_a_of_type_AndroidGraphicsRect.centerX();
        m = this.jdField_a_of_type_AndroidGraphicsRect.centerY();
        paramRect1 = new TranslateAnimation(-(i - k), 0.0F, -(j - m), 0.0F);
        paramRect1.setDuration(this.jdField_b_of_type_Long);
        paramRect1.setInterpolator(new AccelerateDecelerateInterpolator());
        paramRect1.setAnimationListener(new aeao(this));
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
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new aeay(this, paramTextView));
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new aean(this, paramTextView));
  }
  
  private void a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new aeax(this, paramString), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      b(paramString);
      return;
    }
    b(paramString);
  }
  
  private void b(String paramString)
  {
    ahsl.a(this, new File(paramString), Utils.Crc64String(paramString));
  }
  
  private void d()
  {
    if (isFinishing()) {}
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_Aebb.a();
    } while ((localObject1 == null) || (((aebd)localObject1).jdField_a_of_type_Int != 6));
    Object localObject2 = (bkzi)bkzz.a(this, null);
    ((bkzi)localObject2).a(2131693153, 1);
    ((bkzi)localObject2).a(2131692677, 1);
    ((bkzi)localObject2).a(2131693159, 1);
    ((bkzi)localObject2).a(2131692673, 1);
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
      ((bkzi)localObject2).a(2131693150, 3);
    }
    ((bkzi)localObject2).c(2131690697);
    boolean bool;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString, this.app.getCurrentAccountUin())))
    {
      bool = true;
      ((bkzi)localObject2).a(new aeaw(this, (aebd)localObject1, bool, (bkzi)localObject2));
      ((bkzi)localObject2).show();
      localObject2 = this.app;
      if (!bool) {
        break label203;
      }
    }
    label203:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      bdla.b((QQAppInterface)localObject2, "dc00898", "", "", "0X800A8C9", "0X800A8C9", 0, 0, (String)localObject1, "", "", "");
      return;
      bool = false;
      break;
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Bisl == null)
    {
      this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
      this.jdField_a_of_type_Bisl.c(2131691473);
    }
    this.jdField_a_of_type_Bisl.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bisy == null) {
      this.jdField_a_of_type_Bisy = new bisy(this);
    }
    this.jdField_a_of_type_Bisy.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(aebd paramaebd)
  {
    c(paramaebd);
  }
  
  public void a(AdapterView paramAdapterView, int paramInt)
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
  
  public void b()
  {
    if ((!this.f) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false)))
    {
      c();
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Amhl.a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void b(aebd paramaebd)
  {
    if (!NetworkUtil.isNetSupport(this)) {
      QQToast.a(this, getString(2131691455), 0).a();
    }
    Card localCard;
    do
    {
      return;
      localCard = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString);
    } while (localCard == null);
    ((anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString, localCard.uFaceTimeStamp, HexUtil.hexStr2Bytes(paramaebd.jdField_a_of_type_JavaLangString));
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
    localAnimationSet.setAnimationListener(new aeap(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void c(aebd paramaebd)
  {
    if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_AndroidViewView == null) || (paramaebd == null)) {}
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
              QLog.d("Q.profilecard.PhotoWall", 2, "updateCurrentImage uin=" + paramaebd.d + ", state=" + paramaebd.jdField_a_of_type_Int);
            }
            localObject = (String)this.jdField_a_of_type_AndroidViewView.getTag();
            if (paramaebd.jdField_a_of_type_Int != 6) {
              break;
            }
          } while ((localObject != null) && (((String)localObject).equals(paramaebd.c)));
          this.jdField_a_of_type_Amhl.c(paramaebd, this.jdField_a_of_type_AndroidViewView);
          return;
          if ((paramaebd.jdField_a_of_type_Int != 3) && (paramaebd.jdField_a_of_type_Int != 4)) {
            break;
          }
          if ((localObject == null) || (!((String)localObject).equals(paramaebd.jdField_b_of_type_JavaLangString))) {
            this.jdField_a_of_type_Amhl.b(paramaebd, this.jdField_a_of_type_AndroidViewView);
          }
        } while ((!paramaebd.jdField_a_of_type_Boolean) || (paramaebd.jdField_a_of_type_Int != 4));
        Object localObject = (ImageProgressCircle)this.jdField_a_of_type_AndroidViewView.findViewById(2131368600);
        if (localObject != null)
        {
          ((ImageProgressCircle)localObject).setProgress(paramaebd.jdField_b_of_type_Int);
          if (((ImageProgressCircle)localObject).getVisibility() != 0) {
            this.jdField_a_of_type_Amhl.a((ImageProgressCircle)localObject);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.PhotoWall", 2, "progressCircle = " + paramaebd.jdField_b_of_type_Int);
      return;
    } while ((paramaebd.jdField_a_of_type_Int != 5) && (paramaebd.jdField_a_of_type_Int != 2));
    this.jdField_a_of_type_Amhl.a(paramaebd, this.jdField_a_of_type_AndroidViewView);
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
    getWindow().setBackgroundDrawableResource(2131167296);
    super.setContentView(2131559306);
    this.jdField_a_of_type_Bhde = new bhde(getMainLooper(), this);
    paramBundle = getIntent().getExtras();
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("is_from_face2face_add_friend", false);
    this.jdField_d_of_type_Boolean = paramBundle.getBoolean("is_hide_actionsheet", false);
    this.e = paramBundle.getBoolean("is_hide_footbar", false);
    this.jdField_d_of_type_Int = paramBundle.getInt("curType", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131367490));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378658));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376947));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131363339);
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131376950));
    Object localObject = ((ViewStub)findViewById(2131378180)).inflate();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131365146));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131365147));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131365469));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362380));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378774));
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new aeam(this));
    this.jdField_a_of_type_Amhl = new amhl(this);
    this.jdField_a_of_type_Aebb = new aeaz(this.app);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_d_of_type_Int == 1) {
      this.jdField_a_of_type_Amhl.a(true);
    }
    this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString = paramBundle.getString("friendUin");
    this.jdField_a_of_type_Long = paramBundle.getLong("extra_pendant_id", 0L);
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131716725);
      this.jdField_a_of_type_Long = 5L;
    }
    this.jdField_c_of_type_Int = paramBundle.getInt("extra_action_source", 0);
    if (this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131297551);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368683));
      ThreadManager.getSubThreadHandler().post(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368659));
      ThreadManager.post(new FriendProfileImageActivity.2(this), 8, null, true);
    }
    if (this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString)) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      this.jdField_b_of_type_Int = paramBundle.getInt("index", -1);
      localObject = new aebd();
      ((aebd)localObject).d = this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString;
      ((aebd)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString("filekey");
      this.jdField_a_of_type_Aebb.a(this, (aebd)localObject);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Aebb.b();
      this.jdField_a_of_type_Aebb.a(this);
      this.jdField_a_of_type_Aebb.b(this);
      this.jdField_a_of_type_Amhl.a(this.jdField_a_of_type_Aebb);
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Amhl);
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Aebb.b());
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297147));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new aeas(this));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new aeat(this));
      a(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new aeau(this));
      this.jdField_a_of_type_AndroidOsAsyncTask = new aeav(this, (aebd)localObject);
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this);
    this.jdField_a_of_type_Bhde.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Aebb.a(null);
    this.jdField_a_of_type_Aebb.a(this);
    this.jdField_a_of_type_Amhl.a();
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
          localView = localView.findViewById(2131368501);
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
    lzr.a(BaseApplicationImpl.getContext(), false);
    this.jdField_a_of_type_Avli.d();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    AbstractVideoImage.resumeAll();
    lzr.a(BaseApplicationImpl.getContext(), true);
    bhcs.a(this.app, this, "sp_key_entrance_card_face_preview", this.app.getCurrentAccountUin(), this.jdField_a_of_type_Avli);
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
      localObject = this.jdField_a_of_type_Aebb.a();
      this.h = true;
      localRect3 = (Rect)getIntent().getExtras().getParcelable("KEY_THUMBNAL_BOUND");
      if (localObject == null) {
        break label170;
      }
      if (((aebd)localObject).jdField_a_of_type_Int != 6) {
        break label154;
      }
      i = bheg.a(640, 160, i);
      j = i;
    }
    for (;;)
    {
      Rect localRect1 = new Rect(0, 0, j, i);
      Rect localRect2 = bheg.a(localRect1, (int)getResources().getDimension(2131297492), f1);
      localObject = localRect2;
      if (localRect2 == null) {
        localObject = localRect1;
      }
      a(localRect3, (Rect)localObject);
      return;
      label154:
      i = bheg.a(100, 160, i);
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
    a(2131691455, 1);
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
      if (this.jdField_a_of_type_Aebb != null)
      {
        if (bhbx.a()) {
          break;
        }
        Toast.makeText(super.getApplicationContext(), getString(2131718340), 0).show();
      }
    }
    if ((this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString != null) && (!this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {}
    this.jdField_a_of_type_Avli.b();
    String str;
    if (bhcs.b(this.jdField_a_of_type_Long))
    {
      str = "FriendToDIYPendant";
      label117:
      str = bhnp.a(str);
      if (TextUtils.isEmpty(str)) {
        break label360;
      }
      str = str.replace("[sharefri]", this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString);
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("url", str);
      localIntent.putExtra("business", 512L);
      VasWebviewUtil.insertVasWbPluginToIntent(512L, localIntent);
      localIntent.putExtra("isShowAd", false);
      startActivity(localIntent);
      bdla.b(this.app, "CliOper", "", "", "PendantMarket", "OtherEntrance", 0, 0, "", "", "", "");
      label263:
      if (this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString != null)
      {
        if (!this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())) {
          break label373;
        }
        bdla.b(this.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoBigheadClick", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      bhcs.a(this, "sp_key_entrance_card_face_preview", this.app.getCurrentAccountUin(), System.currentTimeMillis());
      finish();
      break;
      str = "FriendToPendant";
      break label117;
      label360:
      QLog.e("Q.profilecard.PhotoWall", 1, "click container_pendant_footer ret null url");
      break label263;
      label373:
      bdla.b(this.app, "CliOper", "", "", "AvatarClick", "KerenInfoButtonClick", this.jdField_c_of_type_Int, 0, "", "", "", "");
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
    if ((this.jdField_a_of_type_Aebb == null) || (this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString == null)) {
      return;
    }
    FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_a_of_type_Aebb.jdField_b_of_type_JavaLangString);
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = localFaceDrawable;
    this.jdField_a_of_type_Bhde.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity
 * JD-Core Version:    0.7.0.1
 */