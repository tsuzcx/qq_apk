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
import bdla;
import bjtp;
import bjty;
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
import lfm;
import ndt;
import nfc;
import nfv;
import nio;
import niq;
import nlx;
import nmb;
import nmc;
import nmd;
import nme;
import nmq;
import nms;
import nnm;
import nnt;
import nnw;
import noe;
import nof;
import nom;
import nqd;
import nqf;

public class AVGameControlUIImpl
  extends nlx
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
  private ndt jdField_a_of_type_Ndt = new nmb(this);
  public nms a;
  private nnt jdField_a_of_type_Nnt = new nmc(this);
  private final noe jdField_a_of_type_Noe = new nme(this);
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
    nnm.b().a(this.jdField_a_of_type_Ndt);
    this.jdField_a_of_type_AndroidOsHandler = nom.a().b();
    SecurityPolicyChecker.a().a(this.jdField_a_of_type_Noe);
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
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new nmd(this));
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
      this.jdField_a_of_type_Nio.a(str);
      return;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690223);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690210);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690292);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690211);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690291);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690217);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690282);
    }
  }
  
  private void b(String paramString)
  {
    int j = 0;
    if (a()) {}
    nnm localnnm;
    nof localnof;
    do
    {
      do
      {
        return;
        localnnm = nnm.b();
      } while (localnnm == null);
      localnof = localnnm.a();
    } while (localnof == null);
    boolean bool = SecurityPolicyChecker.a().b();
    int i = j;
    AVGameUserInfo localAVGameUserInfo;
    if (bool)
    {
      localAVGameUserInfo = localnof.a();
      if ((localAVGameUserInfo == null) || (!localAVGameUserInfo.hasVideo()) || (!localAVGameUserInfo.mBigVideo)) {
        break label170;
      }
      localnof.g = true;
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
        localnnm.f();
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
    nfv localnfv;
    if (paramInt == 1)
    {
      localnfv = nfc.a().a();
      if (localnfv.c() == 1)
      {
        Player localPlayer1 = localnfv.a();
        Player localPlayer2 = localnfv.b();
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
        if (localnfv.a() != 1) {
          break;
        }
        bdla.b(null, "dc00898", "", "", "0X800B06E", "0X800B06E", 0, 0, "", "", "", "");
      }
      return;
    }
    bdla.b(null, "dc00898", "", "", "0X800B073", "0X800B073", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDrawable(2130838759);
    this.jdField_a_of_type_Nms = new nms((Activity)this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager = new AVGameNetWorkQualityManager(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363187));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363195));
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363194));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365201);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367512));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363314));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(this.jdField_a_of_type_Nms.a());
    if (nnm.b().a() != null)
    {
      k();
      j();
      l();
    }
    if (nfc.a().f())
    {
      int i = ViewUtils.dip2px(120.0F);
      this.jdField_a_of_type_AndroidViewView.setTranslationX(i);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (nfc.a().a().a() == 0)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      if (SecurityPolicyChecker.a().b()) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
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
    nnm localnnm;
    do
    {
      do
      {
        return;
        localnnm = nnm.b();
      } while (localnnm == null);
      i = localnnm.a();
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
      nom.a().a().post(new AVGameControlUIImpl.7(this, localnnm, i));
      return;
    }
  }
  
  private void i()
  {
    int j = 1;
    Object localObject1 = nnm.b().a();
    if (localObject1 != null)
    {
      boolean bool = ((nof)localObject1).e;
      nnm.b().b(bool);
      k();
      if (!bool) {
        break label160;
      }
      i = 1;
      bdla.b(null, "dc00898", "", "", "0X800B03A", "0X800B03A", i, 0, "", "", "", "");
      if (!bool)
      {
        Object localObject2 = nfc.a().a();
        if (((nfv)localObject2).c() == 1)
        {
          localObject1 = ((nfv)localObject2).a();
          localObject2 = ((nfv)localObject2).b();
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
        bdla.b(null, "dc00898", "", "", "0X800B074", "0X800B074", 0, 0, "", "", "", "");
      }
      return;
      i = 2;
      break;
    }
  }
  
  private void j()
  {
    nof localnof = nnm.b().a();
    if ((localnof != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null)) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(localnof.a(1));
    }
  }
  
  private void k()
  {
    boolean bool2 = true;
    nof localnof = nnm.b().a();
    Object localObject;
    if (localnof != null)
    {
      if (localnof.e) {
        break label109;
      }
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      if (!this.jdField_b_of_type_Boolean) {
        g();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
      if (localnof.e) {
        break label114;
      }
      bool1 = true;
      label56:
      ((AutoBgImageView)localObject).setSelected(bool1);
      AutoBgImageView localAutoBgImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
      if (!localnof.e) {
        break label119;
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label80:
      localAutoBgImageView.setImageDrawable((Drawable)localObject);
      localObject = this.jdField_a_of_type_Nio;
      if (localnof.e) {
        break label130;
      }
    }
    label130:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((nio)localObject).d(bool1);
      return;
      label109:
      bool1 = false;
      break;
      label114:
      bool1 = false;
      break label56;
      label119:
      localObject = this.jdField_a_of_type_Nms.a();
      break label80;
    }
  }
  
  private void l()
  {
    nof localnof = nnm.b().a();
    if (localnof != null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(localnof.d);
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
    this.jdField_a_of_type_Nmq.l();
    nnw localnnw = nnm.b().a();
    if (localnnw != null) {
      localnnw.a(this.jdField_a_of_type_Nmq);
    }
  }
  
  public void a(long paramLong, int paramInt, View paramView)
  {
    nof localnof = nnm.b().a();
    if (localnof == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("AVGameControlUIImpl", 2, "onClick_Camera, seq[" + paramLong + "], from[" + paramInt + "], session[" + localnof + "]");
      }
    } while (!a(paramLong, "android.permission.CAMERA", paramView, paramInt));
    boolean bool3 = SecurityPolicyChecker.a().b();
    boolean bool2 = localnof.a(1);
    boolean bool1;
    boolean bool4;
    if (paramInt == 2)
    {
      bool1 = false;
      bool4 = SecurityPolicyChecker.a().a(localnof.jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("AVGameControlUIImpl", 2, "onClick_Camera, seq[" + paramLong + "], from[" + paramInt + "], goOffStage" + bool1 + "], hasLocalVideo[" + bool2 + "], disableSmallPic[" + bool3 + "], canOpenCamera[" + bool4 + "], session[" + localnof + "]");
      }
      if (!bool1) {
        break label316;
      }
      if ((!bool4) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
      nnm.b().f();
      c(paramInt);
      bdla.b(null, "dc00898", "", "", "0X800B039", "0X800B039", 2, 0, "", "", "", "");
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
        nqd.a(1);
        bdla.b(null, "dc00898", "", "", "0X800B039", "0X800B039", 1, 0, "", "", "", "");
      }
      for (;;)
      {
        if (!bool4) {
          break label416;
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.getVisibility() != 0)) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
        }
        nnm.b().b(paramInt);
        break;
        if (paramInt == 2) {
          nqd.a(2);
        } else if (paramInt == 4) {
          nqd.a(3);
        }
      }
      label416:
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
      QQToast.a(BaseApplicationImpl.getApplication(), 0, 2131690324, 1).a();
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    nom.a().b().post(new AVGameControlUIImpl.5(this, paramInt, paramString2));
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    while ((nfc.a().a().e()) && (nfc.a().a() <= 1)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363187: 
      b(paramLong, paramView);
      return;
    case 2131363195: 
      a(paramLong, 1, paramView);
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE ");
    h();
  }
  
  public void a(String paramString)
  {
    if (nnm.b() == null) {}
    label175:
    label365:
    label371:
    for (;;)
    {
      return;
      nof localnof = nnm.b().a();
      if (localnof == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged player[" + paramString + "], session is null.");
        }
      }
      else
      {
        this.jdField_a_of_type_Long = 0L;
        long l = nqf.a(paramString);
        SecurityPolicyChecker.a().a(paramString);
        localnof.a();
        boolean bool1;
        boolean bool2;
        if (l != 0L)
        {
          bool1 = localnof.a(l, true);
          if (!TextUtils.equals(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), paramString)) {
            break label284;
          }
          if (!localnof.a(1))
          {
            if (QLog.isColorLevel()) {
              QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged, go on state, session[" + localnof + "]");
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
          QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged, uin[" + this.jdField_a_of_type_Long + "], ret[" + bool2 + "], player[" + paramString + "], self[" + this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount() + "], auto[" + localnof.g + "]");
          return;
          bool1 = true;
          break;
          if ((localnof.g) && (localnof.a(1)))
          {
            a(AudioHelper.b(), 3, this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView);
            bool2 = bool1;
            break label175;
          }
          bool2 = bool1;
          if (SecurityPolicyChecker.a().a(localnof.jdField_b_of_type_Long)) {
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
  
  public void a(List<niq> paramList)
  {
    if (paramList.isEmpty()) {}
    while (this.jdField_a_of_type_Nmq == null) {
      return;
    }
    this.jdField_a_of_type_Nmq.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Nmq != null) {
      this.jdField_a_of_type_Nmq.c(paramBoolean);
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
      if ((lfm.a()) && (lfm.a().b()))
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
          paramKeyEvent = nnm.b().a();
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
    this.jdField_a_of_type_Nmq.m();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask == null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask = new AVGameControlUIImpl.CheckCameraTask();
    }
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager.b();
    }
    nnw localnnw = nnm.b().a();
    if (localnnw != null) {
      localnnw.e();
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
    if (nfc.a().f()) {
      if (!paramBoolean)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
    do
    {
      return;
      k();
      l();
      j();
      return;
      if (!paramBoolean) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "start control animation");
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    int i = ViewUtils.dip2px(120.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationX", new float[] { 0.0F, i });
    localObjectAnimator.setDuration(250L);
    localObjectAnimator.start();
    return;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "show begin btn");
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewView.setTranslationX(0.0F);
  }
  
  public void c()
  {
    nom.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    nom.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  public void c(long paramLong)
  {
    super.c(paramLong);
    this.jdField_a_of_type_Nmq.n();
    e();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask);
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask = null;
    }
    nnw localnnw = nnm.b().a();
    if (localnnw != null) {
      localnnw.f();
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
      localAVGameCameraAssistant = nnm.b().a();
    } while (localAVGameCameraAssistant == null);
    localAVGameCameraAssistant.a(this.jdField_a_of_type_Nnt);
  }
  
  public void d(long paramLong)
  {
    super.d(paramLong);
    this.jdField_a_of_type_Nmq.o();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager != null)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager.c();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager = null;
    }
    Object localObject = nnm.b();
    if (localObject != null)
    {
      AVGameCameraAssistant localAVGameCameraAssistant = ((nnm)localObject).a();
      if (localAVGameCameraAssistant != null) {
        localAVGameCameraAssistant.b(this.jdField_a_of_type_Nnt);
      }
      ((nnm)localObject).b(this.jdField_a_of_type_Ndt);
    }
    localObject = nnm.b().a();
    if (localObject != null) {
      ((nnw)localObject).b(this.jdField_a_of_type_Nmq);
    }
  }
  
  public void e()
  {
    nom.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    bjtp.a().a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl
 * JD-Core Version:    0.7.0.1
 */