package com.tencent.av.gaudio;

import Override;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import anvx;
import bdla;
import bhdj;
import biwn;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MutiMemberThumbList;
import com.tencent.av.ui.QavPanel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import lby;
import lcu;
import lee;
import let;
import lfe;
import lkm;
import lkn;
import lnp;
import lnq;
import lnr;
import lns;
import lnt;
import lnu;
import lnv;
import lnw;
import lnx;
import lny;
import lzr;
import mif;
import mqq.os.MqqHandler;
import mrr;
import mrx;
import msa;
import mtt;
import mtx;
import muy;

public class GaInviteLockActivity
  extends GaInviteActivity
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private final GaInviteLockActivity.MainThreadRunnableTask jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$MainThreadRunnableTask = new GaInviteLockActivity.MainThreadRunnableTask(this);
  MutiMemberThumbList jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = null;
  public QavPanel a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GaInviteLockActivity.2(this);
  private ArrayList<lny> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private let jdField_a_of_type_Let = new lnp(this);
  private lkn jdField_a_of_type_Lkn = new lkn();
  mif jdField_a_of_type_Mif = null;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new lns(this);
  private final Runnable jdField_b_of_type_JavaLangRunnable = new GaInviteLockActivity.11(this);
  private lee jdField_b_of_type_Lee = new lnr(this);
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  TextView c = null;
  private long d;
  private boolean h;
  
  public GaInviteLockActivity()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
  }
  
  private void a(long paramLong, ArrayList<lcu> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "handleMemberListUpdate");
    }
    if ((paramLong == this.jdField_a_of_type_Long) && ((paramInt == 10) || (paramInt == 1)))
    {
      this.h = true;
      b("handleMemberListUpdate");
    }
  }
  
  private void b(int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "getGAudioRoomMemList " + bool);
    }
    if (!bool)
    {
      QQToast.a(this, anvx.a(2131704470), 1).b(getResources().getDimensionPixelSize(2131299080));
      finish();
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "notifyDataChange mHasCallFromMemberList:=" + this.h + ":from=" + paramString);
    }
    i();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.e();
    paramString = new ArrayList();
    HashSet localHashSet = new HashSet();
    localObject1 = ((ArrayList)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (lcu)((Iterator)localObject1).next();
      if (((lcu)localObject2).jdField_a_of_type_Long != this.jdField_b_of_type_Long) {
        paramString.add(localObject2);
      }
      localHashSet.add(Long.valueOf(((lcu)localObject2).jdField_a_of_type_Long));
    }
    int i = paramString.size();
    localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (lny)((Iterator)localObject1).next();
      lcu locallcu;
      if (!localHashSet.contains(Long.valueOf(((lny)localObject2).jdField_a_of_type_Long)))
      {
        locallcu = new lcu();
        locallcu.jdField_a_of_type_Long = ((lny)localObject2).jdField_a_of_type_Long;
        locallcu.jdField_d_of_type_Long = ((lny)localObject2).jdField_b_of_type_Long;
        if (((lny)localObject2).jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin())
        {
          paramString.add(0, locallcu);
          i += 1;
        }
      }
      for (;;)
      {
        break;
        paramString.add(locallcu);
      }
    }
    ThreadManager.getSubThreadHandler().post(new GaInviteLockActivity.7(this, i, paramString));
  }
  
  private void c(Intent paramIntent)
  {
    if (paramIntent == null) {}
    label321:
    for (;;)
    {
      return;
      if (mtx.a(paramIntent)) {
        bdla.b(null, "dc00898", "", "", "0X800A2C5", "0X800A2C5", 0, 0, "", "", "", "");
      }
      long l = AudioHelper.b();
      String str1 = paramIntent.getAction();
      String str2;
      if ("com.tencent.qav.notify.accept".equals(str1))
      {
        str2 = paramIntent.getStringExtra("session_id");
        if (this.jdField_a_of_type_Lfe == null)
        {
          paramIntent = null;
          if (!TextUtils.equals(str2, paramIntent)) {
            break label238;
          }
          if (e()) {
            break label218;
          }
          d();
          this.jdField_d_of_type_Boolean = true;
          label109:
          bdla.b(null, "dc00898", "", "", "0X800A2C6", "0X800A2C6", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label321;
        }
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "checkParamAndDoAction action[" + str1 + "], seq[" + l + "], silent[" + this.jdField_d_of_type_Boolean + "]");
        return;
        paramIntent = this.jdField_a_of_type_Lfe.c;
        break;
        label218:
        if (!QLog.isColorLevel()) {
          break label109;
        }
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "checkParamAndDoAction onPhoneCalling");
        break label109;
        label238:
        if (!QLog.isColorLevel()) {
          break label109;
        }
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "checkParamAndDoAction not same , coming[" + str2 + "], cur[" + paramIntent + "]");
        break label109;
        if ("com.tencent.qav.notify.refuse".equals(str1))
        {
          muy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          super.a(l);
          this.jdField_d_of_type_Boolean = true;
        }
      }
    }
  }
  
  private boolean d()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())
    {
      msa.e(false, true);
      bhdj.b(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695194), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695192), null, new lnu(this), null);
      bool = true;
    }
    return bool;
  }
  
  private boolean e()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())
    {
      msa.e(false, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "startVideo phone is calling!");
      }
      String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695192);
      bhdj.b(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695194), str, null, new lnw(this), null);
      bool = true;
    }
    return bool;
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    }
  }
  
  private void j()
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "doAsyncGetHeadImgAndNickName");
    int i;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839402);
      i = 1;
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        break label104;
      }
      String str = Long.toString(this.jdField_b_of_type_Long);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (i != 0))
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_b_of_type_JavaLangRunnable);
      }
      return;
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "doAsyncGetHeadImgAndNickName[], mHeadImage为空");
      i = 0;
      break;
      label104:
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "doAsyncGetHeadImgAndNickName[], mCallersName为空");
      i = 0;
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    String str;
    if (VideoController.a(this))
    {
      str = "1";
      switch (paramView.getId())
      {
      }
    }
    do
    {
      return;
      str = "2";
      break;
      bdla.b(null, "CliOper", "", "", "0X8009E93", "0X8009E93", 0, 0, str, "", "", "");
      c(-1037L);
      return;
    } while (e());
    bdla.b(null, "CliOper", "", "", "0X8009E94", "0X8009E94", 0, 0, str, "", "", "");
    d();
  }
  
  protected void c()
  {
    h();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131373528));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131373515));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131373531));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = mrx.a(super.getApplicationContext(), 2130842142);
    View localView = super.findViewById(2131373532);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.c = ((TextView)super.findViewById(2131373540));
      if ((!NetworkUtil.isWifiConnected(super.getApplicationContext())) && ((NetworkUtil.is3Gor4G(super.getApplicationContext())) || (NetworkUtil.isMobileNetWork(super.getApplicationContext()))))
      {
        this.c.setVisibility(0);
        this.c.setText(2131695693);
      }
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = ((MutiMemberThumbList)findViewById(2131373653));
      if (this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList != null)
      {
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setRelationShipInfo(this.jdField_a_of_type_Long, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setBitMapFetcher(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setMoreInfoDrawableColor("#4C000000");
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setDisPlayList(null);
        if (this.jdField_b_of_type_Int != 1) {
          break label338;
        }
      }
    }
    label338:
    for (int i = 10;; i = 1)
    {
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, i, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, true);
      b(i);
      localView = findViewById(2131362715);
      super.c();
      this.jdField_a_of_type_Mif = new mif(this, this.jdField_a_of_type_ComTencentAvVideoController, 1, this.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetTextView, localView, null);
      if (this.jdField_a_of_type_Mif != null) {
        this.jdField_a_of_type_Mif.a();
      }
      return;
      localView.setBackgroundResource(2130842142);
      break;
    }
  }
  
  public void c(long paramLong)
  {
    if ((lzr.f(this)) && (this.jdField_a_of_type_Mif != null))
    {
      this.jdField_a_of_type_Mif.a(new lnv(this, paramLong));
      return;
    }
    super.a(paramLong);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  void f()
  {
    boolean bool = VideoController.a(this);
    if ((!lzr.f(this)) || (bool) || (this.jdField_a_of_type_Mif == null))
    {
      super.f();
      return;
    }
    this.jdField_a_of_type_Mif.a(new lnq(this));
  }
  
  void h()
  {
    int j = 8;
    boolean bool = VideoController.a(this);
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)super.findViewById(2131373668));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559794);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new lnt(this));
    }
    View localView1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.findViewById(2131373535);
    View localView2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.findViewById(2131373533);
    if (bool) {}
    for (int i = 8;; i = 0)
    {
      localView1.setVisibility(i);
      i = j;
      if (bool) {
        i = 0;
      }
      localView2.setVisibility(i);
      if ((ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) && (!bool)) {
        super.findViewById(2131373665).setVisibility(0);
      }
      return;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onCreate");
    }
    AVActivity.a(getWindow(), true);
    if ((Build.MODEL.equalsIgnoreCase("vivo X9i")) || (Build.MODEL.equalsIgnoreCase("vivo y55l"))) {
      ImmersiveUtils.a(false, getWindow());
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
      this.jdField_b_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
      super.setContentView(2131559744);
      super.onCreate(paramBundle);
      j();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Let);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Lee);
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new lnx(this);
      super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      super.getWindow().addFlags(524288);
      super.getWindow().addFlags(128);
      super.getWindow().addFlags(2097152);
      paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (paramBundle != null) {
        paramBundle.a(getClass().getName(), getIntent());
      }
      c(getIntent());
      if (mrr.b())
      {
        if (this.jdField_a_of_type_Mtt == null) {
          this.jdField_a_of_type_Mtt = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        }
        this.jdField_a_of_type_Mtt.a(this.jdField_a_of_type_Lfe.c);
      }
      return;
      ImmersiveUtils.a(true, getWindow());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    if (this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList != null)
    {
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.a();
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = null;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Let);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_b_of_type_Lee);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(-1044L);
      this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    }
    if (this.jdField_a_of_type_Mif != null)
    {
      this.jdField_a_of_type_Mif.b();
      this.jdField_a_of_type_Mif = null;
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$MainThreadRunnableTask);
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_b_of_type_MqqOsMqqHandler = null;
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      bdla.b(null, "CliOper", "", "", "0X800420F", "0X800420F", 0, 0, "", "", "", "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onNewIntent()");
    c(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Lkn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
    if (!this.f) {
      biwn.a(BaseApplicationImpl.getContext(), true, 50, 1);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    biwn.a(BaseApplicationImpl.getContext(), 50, 0);
    biwn.a(BaseApplicationImpl.getContext(), false, 50, 1);
    biwn.a(BaseApplicationImpl.getContext(), 50, 2);
    h();
    if (this.jdField_a_of_type_Lfe != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(GaInviteLockActivity.class);
    }
    this.jdField_a_of_type_Lkn.a(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity
 * JD-Core Version:    0.7.0.1
 */