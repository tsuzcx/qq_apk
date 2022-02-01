package com.tencent.avgame.gameroom.video;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import bcef;
import biin;
import biiw;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.qav.AVGameCameraAssistant;
import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mxh;
import myh;
import mzl;
import naf;
import ncq;
import ncs;
import nff;
import nfj;
import nfk;
import nfl;
import nfm;
import nfy;
import nga;
import ngu;
import nhb;
import nhe;
import nhm;
import nhn;
import nht;
import njf;
import njh;

public class AVGameControlUIImpl
  extends nff
{
  protected long a;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  protected Drawable a;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  protected View a;
  protected ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AVGameControlUIImpl.CheckCameraTask jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask;
  protected AVGameNetWorkQualityManager a;
  protected AutoBgImageView a;
  public Integer a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVGameControlUIImpl.1(this);
  private myh jdField_a_of_type_Myh = new nfj(this);
  public nga a;
  private nhb jdField_a_of_type_Nhb = new nfk(this);
  private final nhm jdField_a_of_type_Nhm = new nfm(this);
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  protected AutoBgImageView b;
  public Integer b;
  private volatile boolean jdField_b_of_type_Boolean;
  protected AutoBgImageView c;
  public Integer c;
  
  public AVGameControlUIImpl(AVGameAppInterface paramAVGameAppInterface, BaseActivity paramBaseActivity, ViewGroup paramViewGroup)
  {
    super(paramAVGameAppInterface, paramBaseActivity, paramViewGroup);
    ngu.b().a(this.jdField_a_of_type_Myh);
    this.jdField_a_of_type_AndroidOsHandler = nht.a().b();
    SecurityPolicyChecker.a().a(this.jdField_a_of_type_Nhm);
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView == null) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.isShown()))) {}
    int i;
    do
    {
      return;
      i = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = paramInt;
    } while (this.jdField_b_of_type_Int == i);
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      paramInt = ((Integer)this.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedValue()).intValue();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      i = paramInt;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new nfl(this));
      }
      int j;
      ValueAnimator localValueAnimator;
      long l;
      if (this.jdField_b_of_type_Int > i)
      {
        j = 1;
        localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        if (j == 0) {
          break label192;
        }
        l = 100L;
        label141:
        localValueAnimator.setDuration(l);
        localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        if (paramInt != -1) {
          break label200;
        }
      }
      for (;;)
      {
        localValueAnimator.setIntValues(new int[] { i, this.jdField_b_of_type_Int });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        return;
        j = 0;
        break;
        label192:
        l = 200L;
        break label141;
        label200:
        i = paramInt;
      }
      paramInt = -1;
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showTransientTip msgType:=" + paramInt);
    }
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Ncq.a(str);
      return;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690185);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690172);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690254);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690173);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690253);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690179);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690244);
    }
  }
  
  private void b(String paramString)
  {
    int j = 0;
    if (a()) {}
    ngu localngu;
    nhn localnhn;
    do
    {
      do
      {
        return;
        localngu = ngu.b();
      } while (localngu == null);
      localnhn = localngu.a();
    } while (localnhn == null);
    boolean bool = SecurityPolicyChecker.a().b();
    int i = j;
    AVGameUserInfo localAVGameUserInfo;
    if (bool)
    {
      localAVGameUserInfo = localnhn.a();
      if ((localAVGameUserInfo == null) || (!localAVGameUserInfo.hasVideo()) || (!localAVGameUserInfo.mBigVideo)) {
        break label170;
      }
      localnhn.g = true;
      i = j;
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.getVisibility() != i)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(i);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("AVGameControlUIImpl", 4, "updateCameraBtn, [" + bool + "], visibility[" + i + "], from[" + paramString + "]");
      return;
      label170:
      if ((localAVGameUserInfo != null) && (localAVGameUserInfo.hasVideo()) && (!localAVGameUserInfo.mBigVideo))
      {
        localngu.f();
        i = 8;
      }
      else
      {
        i = 8;
      }
    }
  }
  
  private boolean b()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_b_of_type_Long > 500L)
    {
      this.jdField_b_of_type_Long = l;
      return true;
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    naf localnaf;
    if (paramInt == 1)
    {
      localnaf = mzl.a().a();
      if (localnaf.c() == 1)
      {
        Player localPlayer1 = localnaf.a();
        Player localPlayer2 = localnaf.b();
        if ((localPlayer1 == null) || (localPlayer2 == null) || (!TextUtils.equals(localPlayer1.uin, localPlayer2.uin))) {
          break label97;
        }
      }
    }
    label97:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        if (localnaf.a() != 1) {
          break;
        }
        bcef.b(null, "dc00898", "", "", "0X800B06E", "0X800B06E", 0, 0, "", "", "", "");
      }
      return;
    }
    bcef.b(null, "dc00898", "", "", "0X800B073", "0X800B073", 0, 0, "", "", "", "");
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(7);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AVGameControlUIImpl.6(this), 3000L);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDrawable(2130838743);
    this.jdField_a_of_type_Nga = new nga((Activity)this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager = new AVGameNetWorkQualityManager(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363168));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363176));
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363175));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365116);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367388));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363251));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(this.jdField_a_of_type_Nga.a());
    if (ngu.b().a() != null)
    {
      k();
      j();
      l();
    }
  }
  
  private void g()
  {
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  private void h()
  {
    if (!b()) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick_Speak fast-click");
      }
    }
    ngu localngu;
    do
    {
      do
      {
        return;
        localngu = ngu.b();
      } while (localngu == null);
      i = localngu.a();
      if (i != 2) {
        break;
      }
      b(3);
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick_Speak in AUDIO_ROUTE_BLUETOOTH status, not support close bluetooth");
    return;
    if (i == 0) {}
    for (int i = 1;; i = 0)
    {
      nht.a().a().post(new AVGameControlUIImpl.7(this, localngu, i));
      return;
    }
  }
  
  private void i()
  {
    int j = 1;
    Object localObject1 = ngu.b().a();
    if (localObject1 != null)
    {
      boolean bool = ((nhn)localObject1).e;
      ngu.b().b(bool);
      k();
      if (!bool) {
        break label160;
      }
      i = 1;
      bcef.b(null, "dc00898", "", "", "0X800B03A", "0X800B03A", i, 0, "", "", "", "");
      if (!bool)
      {
        Object localObject2 = mzl.a().a();
        if (((naf)localObject2).c() == 1)
        {
          localObject1 = ((naf)localObject2).a();
          localObject2 = ((naf)localObject2).b();
          if ((localObject1 == null) || (localObject2 == null) || (!TextUtils.equals(((Player)localObject1).uin, ((Player)localObject2).uin))) {
            break label165;
          }
        }
      }
    }
    label160:
    label165:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        bcef.b(null, "dc00898", "", "", "0X800B074", "0X800B074", 0, 0, "", "", "", "");
      }
      return;
      i = 2;
      break;
    }
  }
  
  private void j()
  {
    nhn localnhn = ngu.b().a();
    if ((localnhn != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null)) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(localnhn.a(1));
    }
  }
  
  private void k()
  {
    boolean bool2 = true;
    nhn localnhn = ngu.b().a();
    Object localObject;
    if (localnhn != null)
    {
      if (localnhn.e) {
        break label109;
      }
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      if (!this.jdField_b_of_type_Boolean) {
        g();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
      if (localnhn.e) {
        break label114;
      }
      bool1 = true;
      label56:
      ((AutoBgImageView)localObject).setSelected(bool1);
      AutoBgImageView localAutoBgImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
      if (!localnhn.e) {
        break label119;
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label80:
      localAutoBgImageView.setImageDrawable((Drawable)localObject);
      localObject = this.jdField_a_of_type_Ncq;
      if (localnhn.e) {
        break label130;
      }
    }
    label130:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((ncq)localObject).c(bool1);
      return;
      label109:
      bool1 = false;
      break;
      label114:
      bool1 = false;
      break label56;
      label119:
      localObject = this.jdField_a_of_type_Nga.a();
      break label80;
    }
  }
  
  private void l()
  {
    nhn localnhn = ngu.b().a();
    if (localnhn != null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(localnhn.d);
    }
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public void a()
  {
    super.a();
    d();
    this.jdField_a_of_type_Nfy.l();
    nhe localnhe = ngu.b().a();
    if (localnhe != null) {
      localnhe.a(this.jdField_a_of_type_Nfy);
    }
  }
  
  public void a(long paramLong, int paramInt, View paramView)
  {
    nhn localnhn = ngu.b().a();
    if (localnhn == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("AVGameControlUIImpl", 2, "onClick_Camera, seq[" + paramLong + "], from[" + paramInt + "], session[" + localnhn + "]");
      }
    } while (!a(paramLong, "android.permission.CAMERA", paramView, paramInt));
    boolean bool3 = SecurityPolicyChecker.a().b();
    boolean bool2 = localnhn.a(1);
    boolean bool1;
    boolean bool4;
    if (paramInt == 2)
    {
      bool1 = false;
      bool4 = SecurityPolicyChecker.a().a(localnhn.jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("AVGameControlUIImpl", 2, "onClick_Camera, seq[" + paramLong + "], from[" + paramInt + "], goOffStage" + bool1 + "], hasLocalVideo[" + bool2 + "], disableSmallPic[" + bool3 + "], canOpenCamera[" + bool4 + "], session[" + localnhn + "]");
      }
      if (!bool1) {
        break label316;
      }
      if ((!bool4) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
      ngu.b().f();
      c(paramInt);
      bcef.b(null, "dc00898", "", "", "0X800B039", "0X800B039", 2, 0, "", "", "", "");
    }
    for (;;)
    {
      j();
      return;
      if (paramInt == 3)
      {
        bool1 = true;
        break;
      }
      bool1 = bool2;
      break;
      label316:
      if (paramInt == 1)
      {
        njf.a(1);
        bcef.b(null, "dc00898", "", "", "0X800B039", "0X800B039", 1, 0, "", "", "", "");
      }
      for (;;)
      {
        if (!bool4) {
          break label416;
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.getVisibility() != 0)) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
        }
        ngu.b().b(paramInt);
        break;
        if (paramInt == 2) {
          njf.a(2);
        } else if (paramInt == 4) {
          njf.a(3);
        }
      }
      label416:
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
      QQToast.a(BaseApplicationImpl.getApplication(), 0, 2131690286, 1).a();
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    nht.a().b().post(new AVGameControlUIImpl.5(this, paramInt, paramString2));
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363168: 
      b(paramLong, paramView);
      return;
    case 2131363176: 
      a(paramLong, 1, paramView);
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE ");
    h();
  }
  
  public void a(String paramString)
  {
    if (ngu.b() == null) {}
    label175:
    label365:
    label371:
    for (;;)
    {
      return;
      nhn localnhn = ngu.b().a();
      if (localnhn == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged player[" + paramString + "], session is null.");
        }
      }
      else
      {
        this.jdField_a_of_type_Long = 0L;
        long l = njh.a(paramString);
        SecurityPolicyChecker.a().a(paramString);
        localnhn.a();
        boolean bool1;
        boolean bool2;
        if (l != 0L)
        {
          bool1 = localnhn.a(l, true);
          if (!TextUtils.equals(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), paramString)) {
            break label284;
          }
          if (!localnhn.a(1))
          {
            if (QLog.isColorLevel()) {
              QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged, go on state, session[" + localnhn + "]");
            }
            a(AudioHelper.b(), 2, this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView);
          }
          bool2 = true;
          if (!bool2) {
            break label365;
          }
          c();
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label371;
          }
          QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged, uin[" + this.jdField_a_of_type_Long + "], ret[" + bool2 + "], player[" + paramString + "], self[" + this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount() + "], auto[" + localnhn.g + "]");
          return;
          bool1 = true;
          break;
          if ((localnhn.g) && (localnhn.a(1)))
          {
            a(AudioHelper.b(), 3, this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView);
            bool2 = bool1;
            break label175;
          }
          bool2 = bool1;
          if (SecurityPolicyChecker.a().a(localnhn.jdField_b_of_type_Long)) {
            break label175;
          }
          bool2 = bool1;
          if (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView == null) {
            break label175;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
          bool2 = bool1;
          break label175;
          this.jdField_a_of_type_Long = l;
        }
      }
    }
  }
  
  public void a(List<ncs> paramList)
  {
    if (paramList.isEmpty()) {}
    while (this.jdField_a_of_type_Nfy == null) {
      return;
    }
    this.jdField_a_of_type_Nfy.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Nfy != null) {
      this.jdField_a_of_type_Nfy.c(paramBoolean);
    }
  }
  
  @RequiresApi(api=16)
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    try
    {
      if ((mxh.a()) && (mxh.a().b()))
      {
        if (paramInt == 25) {}
        for (paramInt = -1;; paramInt = 1)
        {
          paramKeyEvent = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
          int i = paramKeyEvent.getStreamVolume(0);
          if (this.jdField_a_of_type_JavaLangInteger == null) {
            this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(i);
          }
          int j = paramKeyEvent.getStreamMaxVolume(0);
          if (this.jdField_c_of_type_JavaLangInteger == null) {
            this.jdField_c_of_type_JavaLangInteger = Integer.valueOf(j);
          }
          paramKeyEvent.adjustStreamVolume(0, paramInt, 1);
          paramInt = paramKeyEvent.getStreamVolume(0);
          this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt);
          paramKeyEvent = ngu.b().a();
          if (paramKeyEvent != null) {
            paramKeyEvent.a(this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_c_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue());
          }
          if (QLog.isColorLevel()) {
            QLog.d("AVGameControlUIImpl", 2, "adjustStreamVolume. streamType = " + 0 + ", maxVolume = " + j + ", oldVolume = " + i + ", newVolume = " + paramInt);
          }
          return true;
        }
      }
      return false;
    }
    catch (Exception paramKeyEvent)
    {
      QLog.e("AVGameControlUIImpl", 1, "adjustStreamVolume fail.", paramKeyEvent);
    }
  }
  
  public void b(long paramLong)
  {
    super.b(paramLong);
    this.jdField_a_of_type_Nfy.m();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask == null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask = new AVGameControlUIImpl.CheckCameraTask();
    }
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager.b();
    }
    nhe localnhe = ngu.b().a();
    if (localnhe != null) {
      localnhe.e();
    }
    if (SecurityPolicyChecker.a().a()) {
      b("onResume");
    }
  }
  
  public void b(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.RECORD_AUDIO", paramView, 0)) {
      i();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "start control animation");
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        int i = ViewUtils.dip2px(120.0F);
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationX", new float[] { 0.0F, i });
        localObjectAnimator.setDuration(250L);
        localObjectAnimator.start();
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "show begin btn");
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewView.setTranslationX(0.0F);
  }
  
  public void c()
  {
    nht.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    nht.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  public void c(long paramLong)
  {
    super.c(paramLong);
    this.jdField_a_of_type_Nfy.n();
    e();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask);
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask = null;
    }
    nhe localnhe = ngu.b().a();
    if (localnhe != null) {
      localnhe.f();
    }
  }
  
  protected void d()
  {
    if (a() == null) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "initUI-->can not get AVGameActivity");
      }
    }
    AVGameCameraAssistant localAVGameCameraAssistant;
    do
    {
      return;
      f();
      localAVGameCameraAssistant = ngu.b().a();
    } while (localAVGameCameraAssistant == null);
    localAVGameCameraAssistant.a(this.jdField_a_of_type_Nhb);
  }
  
  public void d(long paramLong)
  {
    super.d(paramLong);
    this.jdField_a_of_type_Nfy.o();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager != null)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager.c();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager = null;
    }
    Object localObject = ngu.b();
    if (localObject != null)
    {
      AVGameCameraAssistant localAVGameCameraAssistant = ((ngu)localObject).a();
      if (localAVGameCameraAssistant != null) {
        localAVGameCameraAssistant.b(this.jdField_a_of_type_Nhb);
      }
      ((ngu)localObject).b(this.jdField_a_of_type_Myh);
    }
    localObject = ngu.b().a();
    if (localObject != null) {
      ((nhe)localObject).b(this.jdField_a_of_type_Nfy);
    }
  }
  
  public void e()
  {
    nht.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    biin.a().a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl
 * JD-Core Version:    0.7.0.1
 */