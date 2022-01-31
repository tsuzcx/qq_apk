package com.tencent.mobileqq.activity;

import abft;
import abfu;
import abfv;
import abfw;
import abfx;
import abfy;
import abfz;
import abgb;
import abgc;
import abgd;
import abge;
import abgf;
import abgg;
import abgh;
import abgi;
import abgk;
import abgl;
import abgm;
import actn;
import ainh;
import ajsf;
import ajtk;
import ajxn;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
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
import aqyd;
import axqw;
import baxt;
import bbbd;
import bbby;
import bbco;
import bbcv;
import bbdj;
import bbdm;
import bbdr;
import bbev;
import bbgg;
import bbpp;
import bcpq;
import bcpw;
import bcqc;
import bfol;
import bfoy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import java.io.File;
import lzj;
import mqq.os.MqqHandler;
import xpx;

public class FriendProfileImageActivity
  extends BaseActivity
  implements abgl, Handler.Callback, View.OnClickListener, Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public abgk a;
  public ainh a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  public AsyncTask<Void, Void, Void> a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new abfz(this);
  public View a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageButton a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqyd jdField_a_of_type_Aqyd = new aqyd("profile_image", "com.tencent.mobileqq:tool");
  private bbco jdField_a_of_type_Bbco;
  bcpq jdField_a_of_type_Bcpq;
  private bcqc jdField_a_of_type_Bcqc;
  ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  public Gallery a;
  Runnable jdField_a_of_type_JavaLangRunnable = new FriendProfileImageActivity.13(this);
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
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString2 != null)
    {
      int i = paramString2.lastIndexOf("/");
      str1 = str2;
      if (i >= 0)
      {
        str1 = str2;
        if (i < paramString2.length() - 1) {
          str1 = paramString1 + paramString3 + paramString2.substring(i + 1);
        }
      }
    }
    return str1;
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
      f2 = xpx.a(j, i, k, m);
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
        xpx.a(localView, paramRect1);
        i = paramRect1.centerX();
        j = paramRect1.centerY();
        k = this.jdField_a_of_type_AndroidGraphicsRect.centerX();
        m = this.jdField_a_of_type_AndroidGraphicsRect.centerY();
        paramRect1 = new TranslateAnimation(-(i - k), 0.0F, -(j - m), 0.0F);
        paramRect1.setDuration(this.jdField_b_of_type_Long);
        paramRect1.setInterpolator(new AccelerateDecelerateInterpolator());
        paramRect1.setAnimationListener(new abfx(this));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramRect1);
        if (!this.e) {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new FriendProfileImageActivity.15(this), this.jdField_b_of_type_Long);
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
    Intent localIntent = actn.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new abfv(this, paramTextView));
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new abfw(this, paramTextView));
  }
  
  private void b(String paramString1, String paramString2)
  {
    c(paramString1, paramString2);
  }
  
  private void c(String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new abgg(this, paramString1, paramString2), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      d(paramString1, paramString2);
      return;
    }
    d(paramString1, paramString2);
  }
  
  private void d()
  {
    if (isFinishing()) {}
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_Abgk.a();
    } while ((localObject1 == null) || (((abgm)localObject1).jdField_a_of_type_Int != 6));
    Object localObject2 = (bfol)bfoy.a(this, null);
    ((bfol)localObject2).a(2131693383, 1);
    ((bfol)localObject2).a(2131692909, 1);
    ((bfol)localObject2).a(2131693393, 1);
    ((bfol)localObject2).a(2131692905, 1);
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
      ((bfol)localObject2).a(2131693380, 3);
    }
    ((bfol)localObject2).c(2131690596);
    boolean bool;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString, this.app.getCurrentAccountUin())))
    {
      bool = true;
      ((bfol)localObject2).a(new abgf(this, (abgm)localObject1, bool, (bfol)localObject2));
      ((bfol)localObject2).show();
      localObject2 = this.app;
      if (!bool) {
        break label198;
      }
    }
    label198:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      axqw.b((QQAppInterface)localObject2, "dc00898", "", "", "0X800A8C9", "0X800A8C9", 0, 0, (String)localObject1, "", "", "");
      return;
      bool = false;
      break;
    }
  }
  
  private void d(String paramString1, String paramString2)
  {
    String str = ajsf.bc;
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString2 = a(str, paramString1, paramString2);
    if (!new File(paramString2).exists()) {
      a(paramString1, paramString2);
    }
    for (;;)
    {
      sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + paramString2)));
      return;
      bbcv.a(this, 230).setTitle(getString(2131718837)).setMessage(getString(2131695182)).setPositiveButton(getString(2131718713), new abfu(this, paramString1, paramString2)).setNegativeButton(getString(2131694647), new abgh(this)).show();
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Bcpq == null)
    {
      this.jdField_a_of_type_Bcpq = new bcpq(this, getTitleBarHeight());
      this.jdField_a_of_type_Bcpq.c(2131691535);
    }
    this.jdField_a_of_type_Bcpq.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bcqc == null) {
      this.jdField_a_of_type_Bcqc = new bcqc(this);
    }
    this.jdField_a_of_type_Bcqc.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(abgm paramabgm)
  {
    c(paramabgm);
  }
  
  public void a(AdapterView paramAdapterView, int paramInt)
  {
    if (!this.f)
    {
      if (paramAdapterView.getCount() <= 1) {
        break label159;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + 1 + "/" + paramAdapterView.getCount());
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 4) {
        break label124;
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
    label124:
    this.jdField_a_of_type_AndroidWidgetTextView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    return;
    label159:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (bbdj.d(paramString1, paramString2))
    {
      bcpw.a(this, getString(2131695190) + " " + ajsf.bc, 0).a();
      return;
    }
    bcpw.a(this, getString(2131695189), 0).a();
  }
  
  public void b()
  {
    if ((!this.f) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false)))
    {
      c();
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Ainh.a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void b(abgm paramabgm)
  {
    if (!bbev.d(this)) {
      bcpw.a(this, getString(2131691513), 0).a();
    }
    Card localCard;
    do
    {
      return;
      localCard = ((ajxn)this.app.getManager(51)).b(this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString);
    } while (localCard == null);
    ((ajtk)this.app.a(2)).a(this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString, localCard.uFaceTimeStamp, bbdm.a(paramabgm.jdField_a_of_type_JavaLangString));
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
    localAnimationSet.setAnimationListener(new abfy(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void c(abgm paramabgm)
  {
    if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_AndroidViewView == null) || (paramabgm == null)) {}
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
              QLog.d("Q.profilecard.PhotoWall", 2, "updateCurrentImage uin=" + paramabgm.d + ", state=" + paramabgm.jdField_a_of_type_Int);
            }
            localObject = (String)this.jdField_a_of_type_AndroidViewView.getTag();
            if (paramabgm.jdField_a_of_type_Int != 6) {
              break;
            }
          } while ((localObject != null) && (((String)localObject).equals(paramabgm.c)));
          this.jdField_a_of_type_Ainh.c(paramabgm, this.jdField_a_of_type_AndroidViewView);
          return;
          if ((paramabgm.jdField_a_of_type_Int != 3) && (paramabgm.jdField_a_of_type_Int != 4)) {
            break;
          }
          if ((localObject == null) || (!((String)localObject).equals(paramabgm.jdField_b_of_type_JavaLangString))) {
            this.jdField_a_of_type_Ainh.b(paramabgm, this.jdField_a_of_type_AndroidViewView);
          }
        } while ((!paramabgm.jdField_a_of_type_Boolean) || (paramabgm.jdField_a_of_type_Int != 4));
        Object localObject = (ImageProgressCircle)this.jdField_a_of_type_AndroidViewView.findViewById(2131367875);
        if (localObject != null)
        {
          ((ImageProgressCircle)localObject).setProgress(paramabgm.jdField_b_of_type_Int);
          if (((ImageProgressCircle)localObject).getVisibility() != 0) {
            this.jdField_a_of_type_Ainh.a((ImageProgressCircle)localObject);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.PhotoWall", 2, "progressCircle = " + paramabgm.jdField_b_of_type_Int);
      return;
    } while ((paramabgm.jdField_a_of_type_Int != 5) && (paramabgm.jdField_a_of_type_Int != 2));
    this.jdField_a_of_type_Ainh.a(paramabgm, this.jdField_a_of_type_AndroidViewView);
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
    getWindow().setBackgroundDrawableResource(2131167087);
    super.setContentView(2131559139);
    this.jdField_a_of_type_Bbco = new bbco(getMainLooper(), this);
    paramBundle = getIntent().getExtras();
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("is_from_face2face_add_friend", false);
    this.jdField_d_of_type_Boolean = paramBundle.getBoolean("is_hide_actionsheet", false);
    this.e = paramBundle.getBoolean("is_hide_footbar", false);
    this.jdField_d_of_type_Int = paramBundle.getInt("curType", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131366897));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377030));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375491));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131362999);
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131375494));
    Object localObject = ((ViewStub)findViewById(2131376604)).inflate();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131364681));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131364682));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131364979));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362259));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131377142));
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new abft(this));
    this.jdField_a_of_type_Ainh = new ainh(this);
    this.jdField_a_of_type_Abgk = new abgi(this.app);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_d_of_type_Int == 1) {
      this.jdField_a_of_type_Ainh.a(true);
    }
    this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString = paramBundle.getString("friendUin");
    this.jdField_a_of_type_Long = paramBundle.getLong("extra_pendant_id", 0L);
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717413);
      this.jdField_a_of_type_Long = 5L;
    }
    this.jdField_c_of_type_Int = paramBundle.getInt("extra_action_source", 0);
    if (this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131297385);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367954));
      ThreadManager.getSubThreadHandler().post(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367931));
      ThreadManager.post(new FriendProfileImageActivity.2(this), 8, null, true);
    }
    if (this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString)) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      this.jdField_b_of_type_Int = paramBundle.getInt("index", -1);
      localObject = new abgm();
      ((abgm)localObject).d = this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString;
      ((abgm)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString("filekey");
      this.jdField_a_of_type_Abgk.a(this, (abgm)localObject);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Abgk.b();
      this.jdField_a_of_type_Abgk.a(this);
      this.jdField_a_of_type_Abgk.b(this);
      this.jdField_a_of_type_Ainh.a(this.jdField_a_of_type_Abgk);
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Ainh);
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Abgk.b());
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297009));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new abgb(this));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new abgc(this));
      a(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new abgd(this));
      this.jdField_a_of_type_AndroidOsAsyncTask = new abge(this, (abgm)localObject);
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this);
    this.jdField_a_of_type_Bbco.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Abgk.a(null);
    this.jdField_a_of_type_Abgk.a(this);
    this.jdField_a_of_type_Ainh.a();
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
          localView = localView.findViewById(2131367776);
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
    lzj.a(BaseApplicationImpl.getContext(), false);
    this.jdField_a_of_type_Aqyd.d();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    AbstractVideoImage.resumeAll();
    lzj.a(BaseApplicationImpl.getContext(), true);
    bbby.a(this.app, this, "sp_key_entrance_card_face_preview", this.app.getCurrentAccountUin(), this.jdField_a_of_type_Aqyd);
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
      localObject = this.jdField_a_of_type_Abgk.a();
      this.h = true;
      localRect3 = (Rect)getIntent().getExtras().getParcelable("KEY_THUMBNAL_BOUND");
      if (localObject == null) {
        break label170;
      }
      if (((abgm)localObject).jdField_a_of_type_Int != 6) {
        break label154;
      }
      i = bbdr.a(640, 160, i);
      j = i;
    }
    for (;;)
    {
      Rect localRect1 = new Rect(0, 0, j, i);
      Rect localRect2 = bbdr.a(localRect1, (int)getResources().getDimension(2131297326), f1);
      localObject = localRect2;
      if (localRect2 == null) {
        localObject = localRect1;
      }
      a(localRect3, (Rect)localObject);
      return;
      label154:
      i = bbdr.a(100, 160, i);
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
    a(2131691513, 1);
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
    do
    {
      return;
    } while (this.jdField_a_of_type_Abgk == null);
    if (!bbbd.a())
    {
      Toast.makeText(super.getApplicationContext(), getString(2131719044), 0).show();
      return;
    }
    if ((this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString != null) && (!this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {}
    this.jdField_a_of_type_Aqyd.b();
    if (bbby.b(this.jdField_a_of_type_Long))
    {
      paramView = "FriendToDIYPendant";
      paramView = bbpp.a(paramView);
      if (TextUtils.isEmpty(paramView)) {
        break label337;
      }
      paramView = paramView.replace("[sharefri]", this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString);
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("url", paramView);
      localIntent.putExtra("business", 512L);
      VasWebviewUtil.insertVasWbPluginToIntent(512L, localIntent);
      localIntent.putExtra("isShowAd", false);
      startActivity(localIntent);
      axqw.b(this.app, "CliOper", "", "", "PendantMarket", "OtherEntrance", 0, 0, "", "", "", "");
      label248:
      if (this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString != null)
      {
        if (!this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())) {
          break label350;
        }
        axqw.b(this.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoBigheadClick", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      bbby.a(this, "sp_key_entrance_card_face_preview", this.app.getCurrentAccountUin(), System.currentTimeMillis());
      finish();
      return;
      paramView = "FriendToPendant";
      break;
      label337:
      QLog.e("Q.profilecard.PhotoWall", 1, "click container_pendant_footer ret null url");
      break label248;
      label350:
      axqw.b(this.app, "CliOper", "", "", "AvatarClick", "KerenInfoButtonClick", this.jdField_c_of_type_Int, 0, "", "", "", "");
    }
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_Abgk == null) || (this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString == null)) {
      return;
    }
    baxt localbaxt = baxt.a(this.app, 1, this.jdField_a_of_type_Abgk.jdField_b_of_type_JavaLangString);
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = localbaxt;
    this.jdField_a_of_type_Bbco.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity
 * JD-Core Version:    0.7.0.1
 */