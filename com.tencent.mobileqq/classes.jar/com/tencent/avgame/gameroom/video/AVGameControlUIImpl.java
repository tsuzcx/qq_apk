package com.tencent.avgame.gameroom.video;

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
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import bcst;
import bjce;
import bjcm;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.qav.AVGameCameraAssistant;
import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mvy;
import mwx;
import mxl;
import myc;
import nal;
import nan;
import ncl;
import ncp;
import ncq;
import ncr;
import ncs;
import ncz;
import ndb;
import ndt;
import nea;
import ned;
import nel;
import neq;
import nfv;
import nfx;

public class AVGameControlUIImpl
  extends ncl
{
  protected long a;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  protected Drawable a;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AVGameControlUIImpl.CheckCameraTask jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask;
  protected AutoBgImageView a;
  public Integer a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVGameControlUIImpl.1(this);
  private mwx jdField_a_of_type_Mwx = new ncp(this);
  public ndb a;
  private nea jdField_a_of_type_Nea = new ncq(this);
  private final nel jdField_a_of_type_Nel = new ncs(this);
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  protected AutoBgImageView b;
  public Integer b;
  private volatile boolean jdField_b_of_type_Boolean;
  protected AutoBgImageView c;
  public Integer c;
  protected AutoBgImageView d;
  
  public AVGameControlUIImpl(AVGameAppInterface paramAVGameAppInterface, BaseActivity paramBaseActivity, ViewGroup paramViewGroup)
  {
    super(paramAVGameAppInterface, paramBaseActivity, paramViewGroup);
    ndt.b().a(this.jdField_a_of_type_Mwx);
    this.jdField_a_of_type_AndroidOsHandler = neq.a().b();
    SecurityPolicyChecker.a().a(this.jdField_a_of_type_Nel);
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
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ncr(this));
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
      this.jdField_a_of_type_Nal.a(str);
      return;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690150);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690139);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690222);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690140);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690221);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690144);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690209);
    }
  }
  
  private void b(String paramString)
  {
    int j = 0;
    if (a()) {}
    ndt localndt;
    AVGameSession localAVGameSession;
    do
    {
      do
      {
        return;
        localndt = ndt.b();
      } while (localndt == null);
      localAVGameSession = localndt.a();
    } while (localAVGameSession == null);
    boolean bool = SecurityPolicyChecker.a().b();
    int i = j;
    AVGameUserInfo localAVGameUserInfo;
    if (bool)
    {
      localAVGameUserInfo = localAVGameSession.a();
      if ((localAVGameUserInfo == null) || (!localAVGameUserInfo.hasVideo()) || (!localAVGameUserInfo.mBigVideo)) {
        break label170;
      }
      localAVGameSession.g = true;
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
        localndt.f();
        i = 8;
      }
      else
      {
        i = 8;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(7);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AVGameControlUIImpl.6(this), 3000L);
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
    myc localmyc;
    if (paramInt == 1)
    {
      localmyc = mxl.a().a();
      if (localmyc.c() == 1)
      {
        Player localPlayer1 = localmyc.a();
        Player localPlayer2 = localmyc.b();
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
        if (localmyc.a() != 1) {
          break;
        }
        bcst.b(null, "dc00898", "", "", "0X800B06E", "0X800B06E", 0, 0, "", "", "", "");
      }
      return;
    }
    bcst.b(null, "dc00898", "", "", "0X800B073", "0X800B073", 0, 0, "", "", "", "");
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDrawable(2130838692);
    this.jdField_a_of_type_Ndb = new ndb((Activity)this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363131));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363137));
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363136));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363196));
    this.d = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363135));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(this.jdField_a_of_type_Ndb.a());
    if (ndt.b().a() != null)
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
    ndt localndt;
    do
    {
      do
      {
        return;
        localndt = ndt.b();
      } while (localndt == null);
      i = localndt.a();
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
      neq.a().a().post(new AVGameControlUIImpl.7(this, localndt, i));
      return;
    }
  }
  
  private void i()
  {
    int j = 1;
    Object localObject1 = ndt.b().a();
    if (localObject1 != null)
    {
      boolean bool = ((AVGameSession)localObject1).e;
      ndt.b().b(bool);
      k();
      if (!bool) {
        break label160;
      }
      i = 1;
      bcst.b(null, "dc00898", "", "", "0X800B03A", "0X800B03A", i, 0, "", "", "", "");
      if (!bool)
      {
        Object localObject2 = mxl.a().a();
        if (((myc)localObject2).c() == 1)
        {
          localObject1 = ((myc)localObject2).a();
          localObject2 = ((myc)localObject2).b();
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
        bcst.b(null, "dc00898", "", "", "0X800B074", "0X800B074", 0, 0, "", "", "", "");
      }
      return;
      i = 2;
      break;
    }
  }
  
  private void j()
  {
    AVGameSession localAVGameSession = ndt.b().a();
    if (localAVGameSession != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(localAVGameSession.a(1));
    }
  }
  
  private void k()
  {
    boolean bool2 = true;
    AVGameSession localAVGameSession = ndt.b().a();
    Object localObject;
    if (localAVGameSession != null)
    {
      if (localAVGameSession.e) {
        break label109;
      }
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      if (!this.jdField_b_of_type_Boolean) {
        g();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
      if (localAVGameSession.e) {
        break label114;
      }
      bool1 = true;
      label56:
      ((AutoBgImageView)localObject).setSelected(bool1);
      AutoBgImageView localAutoBgImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
      if (!localAVGameSession.e) {
        break label119;
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label80:
      localAutoBgImageView.setImageDrawable((Drawable)localObject);
      localObject = this.jdField_a_of_type_Nal;
      if (localAVGameSession.e) {
        break label130;
      }
    }
    label130:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((nal)localObject).c(bool1);
      return;
      label109:
      bool1 = false;
      break;
      label114:
      bool1 = false;
      break label56;
      label119:
      localObject = this.jdField_a_of_type_Ndb.a();
      break label80;
    }
  }
  
  private void l()
  {
    AVGameSession localAVGameSession = ndt.b().a();
    if (localAVGameSession != null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(localAVGameSession.d);
    }
  }
  
  public void a()
  {
    super.a();
    d();
    this.jdField_a_of_type_Ncz.l();
    ned localned = ndt.b().a();
    if (localned != null) {
      localned.a(this.jdField_a_of_type_Ncz);
    }
  }
  
  public void a(long paramLong, int paramInt, View paramView)
  {
    AVGameSession localAVGameSession = ndt.b().a();
    if (localAVGameSession == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("AVGameControlUIImpl", 2, "onClick_Camera, seq[" + paramLong + "], from[" + paramInt + "], session[" + localAVGameSession + "]");
      }
    } while (!a(paramLong, "android.permission.CAMERA", paramView, paramInt));
    boolean bool3 = SecurityPolicyChecker.a().b();
    boolean bool2 = localAVGameSession.a(1);
    boolean bool1;
    boolean bool4;
    if (paramInt == 2)
    {
      bool1 = false;
      bool4 = SecurityPolicyChecker.a().a(localAVGameSession.jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("AVGameControlUIImpl", 2, "onClick_Camera, seq[" + paramLong + "], from[" + paramInt + "], goOffStage" + bool1 + "], hasLocalVideo[" + bool2 + "], disableSmallPic[" + bool3 + "], canOpenCamera[" + bool4 + "], session[" + localAVGameSession + "]");
      }
      if (!bool1) {
        break label316;
      }
      if ((!bool4) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
      ndt.b().f();
      c(paramInt);
      bcst.b(null, "dc00898", "", "", "0X800B039", "0X800B039", 2, 0, "", "", "", "");
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
        nfv.a(1);
        bcst.b(null, "dc00898", "", "", "0X800B039", "0X800B039", 1, 0, "", "", "", "");
      }
      for (;;)
      {
        if (!bool4) {
          break label416;
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.getVisibility() != 0)) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
        }
        ndt.b().b(paramInt);
        break;
        if (paramInt == 2) {
          nfv.a(2);
        } else if (paramInt == 4) {
          nfv.a(3);
        }
      }
      label416:
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
      QQToast.a(BaseApplicationImpl.getApplication(), 0, 2131690253, 1).a();
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    neq.a().b().post(new AVGameControlUIImpl.5(this, paramInt, paramString2));
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    switch (paramView.getId())
    {
    case 2131363196: 
    default: 
      return;
    case 2131363131: 
      b(paramLong, paramView);
      return;
    case 2131363137: 
      a(paramLong, 1, paramView);
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE ");
    h();
  }
  
  public void a(String paramString)
  {
    if (ndt.b() == null) {}
    label175:
    label365:
    label371:
    for (;;)
    {
      return;
      AVGameSession localAVGameSession = ndt.b().a();
      if (localAVGameSession == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged player[" + paramString + "], session is null.");
        }
      }
      else
      {
        this.jdField_a_of_type_Long = 0L;
        long l = nfx.a(paramString);
        SecurityPolicyChecker.a().a(paramString);
        localAVGameSession.a();
        boolean bool1;
        boolean bool2;
        if (l != 0L)
        {
          bool1 = localAVGameSession.a(l, true);
          if (!TextUtils.equals(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), paramString)) {
            break label284;
          }
          if (!localAVGameSession.a(1))
          {
            if (QLog.isColorLevel()) {
              QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged, go on state, session[" + localAVGameSession + "]");
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
          QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged, uin[" + this.jdField_a_of_type_Long + "], ret[" + bool2 + "], player[" + paramString + "], self[" + this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount() + "], auto[" + localAVGameSession.g + "]");
          return;
          bool1 = true;
          break;
          if ((localAVGameSession.g) && (localAVGameSession.a(1)))
          {
            a(AudioHelper.b(), 3, this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView);
            bool2 = bool1;
            break label175;
          }
          bool2 = bool1;
          if (SecurityPolicyChecker.a().a(localAVGameSession.jdField_b_of_type_Long)) {
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
  
  public void a(List<nan> paramList)
  {
    if (paramList.isEmpty()) {}
    while (this.jdField_a_of_type_Ncz == null) {
      return;
    }
    this.jdField_a_of_type_Ncz.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ncz != null) {
      this.jdField_a_of_type_Ncz.c(paramBoolean);
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
      if ((mvy.a()) && (mvy.a().b()))
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
          paramKeyEvent = ndt.b().a();
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
    this.jdField_a_of_type_Ncz.m();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask == null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask = new AVGameControlUIImpl.CheckCameraTask();
    }
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask);
    ned localned = ndt.b().a();
    if (localned != null) {
      localned.e();
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
  
  public void c()
  {
    neq.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    neq.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  public void c(long paramLong)
  {
    super.c(paramLong);
    this.jdField_a_of_type_Ncz.n();
    e();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask);
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask = null;
    }
    ned localned = ndt.b().a();
    if (localned != null) {
      localned.f();
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
      localAVGameCameraAssistant = ndt.b().a();
    } while (localAVGameCameraAssistant == null);
    localAVGameCameraAssistant.a(this.jdField_a_of_type_Nea);
  }
  
  public void d(long paramLong)
  {
    super.d(paramLong);
    this.jdField_a_of_type_Ncz.o();
    Object localObject = ndt.b();
    if (localObject != null)
    {
      AVGameCameraAssistant localAVGameCameraAssistant = ((ndt)localObject).a();
      if (localAVGameCameraAssistant != null) {
        localAVGameCameraAssistant.b(this.jdField_a_of_type_Nea);
      }
      ((ndt)localObject).b(this.jdField_a_of_type_Mwx);
    }
    localObject = ndt.b().a();
    if (localObject != null) {
      ((ned)localObject).b(this.jdField_a_of_type_Ncz);
    }
  }
  
  public void e()
  {
    neq.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    bjce.a().a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl
 * JD-Core Version:    0.7.0.1
 */