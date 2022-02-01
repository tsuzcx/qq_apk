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
import bdll;
import bkdd;
import bkdl;
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
import mwx;
import mxw;
import myk;
import mze;
import nbp;
import nbr;
import ndy;
import nec;
import ned;
import nee;
import nef;
import ner;
import net;
import nfm;
import nft;
import nfw;
import nge;
import ngk;
import nhq;
import nhs;

public class AVGameControlUIImpl
  extends ndy
{
  protected long a;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  protected Drawable a;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AVGameControlUIImpl.CheckCameraTask jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask;
  protected AVGameNetWorkQualityManager a;
  protected AutoBgImageView a;
  public Integer a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVGameControlUIImpl.1(this);
  private mxw jdField_a_of_type_Mxw = new nec(this);
  public net a;
  private nft jdField_a_of_type_Nft = new ned(this);
  private final nge jdField_a_of_type_Nge = new nef(this);
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
    nfm.b().a(this.jdField_a_of_type_Mxw);
    this.jdField_a_of_type_AndroidOsHandler = ngk.a().b();
    SecurityPolicyChecker.a().a(this.jdField_a_of_type_Nge);
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
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new nee(this));
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
      this.jdField_a_of_type_Nbp.a(str);
      return;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690160);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690149);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690229);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690150);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690228);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690154);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690219);
    }
  }
  
  private void b(String paramString)
  {
    int j = 0;
    if (a()) {}
    nfm localnfm;
    AVGameSession localAVGameSession;
    do
    {
      do
      {
        return;
        localnfm = nfm.b();
      } while (localnfm == null);
      localAVGameSession = localnfm.a();
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
        localnfm.f();
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
    mze localmze;
    if (paramInt == 1)
    {
      localmze = myk.a().a();
      if (localmze.c() == 1)
      {
        Player localPlayer1 = localmze.a();
        Player localPlayer2 = localmze.b();
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
        if (localmze.a() != 1) {
          break;
        }
        bdll.b(null, "dc00898", "", "", "0X800B06E", "0X800B06E", 0, 0, "", "", "", "");
      }
      return;
    }
    bdll.b(null, "dc00898", "", "", "0X800B073", "0X800B073", 0, 0, "", "", "", "");
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDrawable(2130838713);
    this.jdField_a_of_type_Net = new net((Activity)this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager = new AVGameNetWorkQualityManager(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363152));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363160));
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363159));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363220));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(this.jdField_a_of_type_Net.a());
    if (nfm.b().a() != null)
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
    nfm localnfm;
    do
    {
      do
      {
        return;
        localnfm = nfm.b();
      } while (localnfm == null);
      i = localnfm.a();
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
      ngk.a().a().post(new AVGameControlUIImpl.7(this, localnfm, i));
      return;
    }
  }
  
  private void i()
  {
    int j = 1;
    Object localObject1 = nfm.b().a();
    if (localObject1 != null)
    {
      boolean bool = ((AVGameSession)localObject1).e;
      nfm.b().b(bool);
      k();
      if (!bool) {
        break label160;
      }
      i = 1;
      bdll.b(null, "dc00898", "", "", "0X800B03A", "0X800B03A", i, 0, "", "", "", "");
      if (!bool)
      {
        Object localObject2 = myk.a().a();
        if (((mze)localObject2).c() == 1)
        {
          localObject1 = ((mze)localObject2).a();
          localObject2 = ((mze)localObject2).b();
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
        bdll.b(null, "dc00898", "", "", "0X800B074", "0X800B074", 0, 0, "", "", "", "");
      }
      return;
      i = 2;
      break;
    }
  }
  
  private void j()
  {
    AVGameSession localAVGameSession = nfm.b().a();
    if (localAVGameSession != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(localAVGameSession.a(1));
    }
  }
  
  private void k()
  {
    boolean bool2 = true;
    AVGameSession localAVGameSession = nfm.b().a();
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
      localObject = this.jdField_a_of_type_Nbp;
      if (localAVGameSession.e) {
        break label130;
      }
    }
    label130:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((nbp)localObject).c(bool1);
      return;
      label109:
      bool1 = false;
      break;
      label114:
      bool1 = false;
      break label56;
      label119:
      localObject = this.jdField_a_of_type_Net.a();
      break label80;
    }
  }
  
  private void l()
  {
    AVGameSession localAVGameSession = nfm.b().a();
    if (localAVGameSession != null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(localAVGameSession.d);
    }
  }
  
  public void a()
  {
    super.a();
    d();
    this.jdField_a_of_type_Ner.l();
    nfw localnfw = nfm.b().a();
    if (localnfw != null) {
      localnfw.a(this.jdField_a_of_type_Ner);
    }
  }
  
  public void a(long paramLong, int paramInt, View paramView)
  {
    AVGameSession localAVGameSession = nfm.b().a();
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
      nfm.b().f();
      c(paramInt);
      bdll.b(null, "dc00898", "", "", "0X800B039", "0X800B039", 2, 0, "", "", "", "");
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
        nhq.a(1);
        bdll.b(null, "dc00898", "", "", "0X800B039", "0X800B039", 1, 0, "", "", "", "");
      }
      for (;;)
      {
        if (!bool4) {
          break label416;
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.getVisibility() != 0)) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
        }
        nfm.b().b(paramInt);
        break;
        if (paramInt == 2) {
          nhq.a(2);
        } else if (paramInt == 4) {
          nhq.a(3);
        }
      }
      label416:
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
      QQToast.a(BaseApplicationImpl.getApplication(), 0, 2131690261, 1).a();
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    ngk.a().b().post(new AVGameControlUIImpl.5(this, paramInt, paramString2));
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
    case 2131363152: 
      b(paramLong, paramView);
      return;
    case 2131363160: 
      a(paramLong, 1, paramView);
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE ");
    h();
  }
  
  public void a(String paramString)
  {
    if (nfm.b() == null) {}
    label175:
    label365:
    label371:
    for (;;)
    {
      return;
      AVGameSession localAVGameSession = nfm.b().a();
      if (localAVGameSession == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged player[" + paramString + "], session is null.");
        }
      }
      else
      {
        this.jdField_a_of_type_Long = 0L;
        long l = nhs.a(paramString);
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
  
  public void a(List<nbr> paramList)
  {
    if (paramList.isEmpty()) {}
    while (this.jdField_a_of_type_Ner == null) {
      return;
    }
    this.jdField_a_of_type_Ner.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ner != null) {
      this.jdField_a_of_type_Ner.c(paramBoolean);
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
      if ((mwx.a()) && (mwx.a().b()))
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
          paramKeyEvent = nfm.b().a();
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
    this.jdField_a_of_type_Ner.m();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask == null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask = new AVGameControlUIImpl.CheckCameraTask();
    }
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager.b();
    }
    nfw localnfw = nfm.b().a();
    if (localnfw != null) {
      localnfw.e();
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
    ngk.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ngk.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  public void c(long paramLong)
  {
    super.c(paramLong);
    this.jdField_a_of_type_Ner.n();
    e();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask);
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask = null;
    }
    nfw localnfw = nfm.b().a();
    if (localnfw != null) {
      localnfw.f();
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
      localAVGameCameraAssistant = nfm.b().a();
    } while (localAVGameCameraAssistant == null);
    localAVGameCameraAssistant.a(this.jdField_a_of_type_Nft);
  }
  
  public void d(long paramLong)
  {
    super.d(paramLong);
    this.jdField_a_of_type_Ner.o();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager != null)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager.c();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager = null;
    }
    Object localObject = nfm.b();
    if (localObject != null)
    {
      AVGameCameraAssistant localAVGameCameraAssistant = ((nfm)localObject).a();
      if (localAVGameCameraAssistant != null) {
        localAVGameCameraAssistant.b(this.jdField_a_of_type_Nft);
      }
      ((nfm)localObject).b(this.jdField_a_of_type_Mxw);
    }
    localObject = nfm.b().a();
    if (localObject != null) {
      ((nfw)localObject).b(this.jdField_a_of_type_Ner);
    }
  }
  
  public void e()
  {
    ngk.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    bkdd.a().a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl
 * JD-Core Version:    0.7.0.1
 */