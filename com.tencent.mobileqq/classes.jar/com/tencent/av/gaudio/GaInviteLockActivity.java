package com.tencent.av.gaudio;

import ajjy;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import awqx;
import babr;
import badq;
import bbmy;
import bbqo;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MutiMemberThumbList;
import com.tencent.av.ui.QavPanel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kth;
import kur;
import kvg;
import kvq;
import lak;
import lal;
import ldm;
import ldn;
import ldo;
import ldp;
import ldq;
import ldr;
import lds;
import ldt;
import ldu;
import ldv;
import lor;
import lwx;
import mfs;
import mfx;
import mga;
import mht;
import mhx;
import miu;
import mqq.os.MqqHandler;

public class GaInviteLockActivity
  extends GaInviteActivity
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private final GaInviteLockActivity.MainThreadRunnableTask jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$MainThreadRunnableTask = new GaInviteLockActivity.MainThreadRunnableTask(this);
  MutiMemberThumbList jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = null;
  public QavPanel a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GaInviteLockActivity.2(this);
  private ArrayList<ldv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private kvg jdField_a_of_type_Kvg = new ldm(this);
  private lal jdField_a_of_type_Lal = new lal();
  lwx jdField_a_of_type_Lwx = null;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new ldp(this);
  private final Runnable jdField_b_of_type_JavaLangRunnable = new GaInviteLockActivity.11(this);
  private kur jdField_b_of_type_Kur = new ldo(this);
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  TextView c = null;
  private long d;
  private boolean h;
  
  public GaInviteLockActivity()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
  }
  
  private void a(long paramLong, ArrayList<kth> paramArrayList, int paramInt)
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
      bbmy.a(this, ajjy.a(2131639207), 1).b(getResources().getDimensionPixelSize(2131167766));
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
      localObject2 = (kth)((Iterator)localObject1).next();
      if (((kth)localObject2).jdField_a_of_type_Long != this.jdField_b_of_type_Long) {
        paramString.add(localObject2);
      }
      localHashSet.add(Long.valueOf(((kth)localObject2).jdField_a_of_type_Long));
    }
    int i = paramString.size();
    localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ldv)((Iterator)localObject1).next();
      kth localkth;
      if (!localHashSet.contains(Long.valueOf(((ldv)localObject2).jdField_a_of_type_Long)))
      {
        localkth = new kth();
        localkth.jdField_a_of_type_Long = ((ldv)localObject2).jdField_a_of_type_Long;
        localkth.jdField_d_of_type_Long = ((ldv)localObject2).jdField_b_of_type_Long;
        if (((ldv)localObject2).jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin())
        {
          paramString.add(0, localkth);
          i += 1;
        }
      }
      for (;;)
      {
        break;
        paramString.add(localkth);
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
      if (mhx.a(paramIntent)) {
        awqx.b(null, "dc00898", "", "", "0X800A2C5", "0X800A2C5", 0, 0, "", "", "", "");
      }
      long l = AudioHelper.b();
      String str1 = paramIntent.getAction();
      String str2;
      if ("com.tencent.qav.notify.accept".equals(str1))
      {
        str2 = paramIntent.getStringExtra("session_id");
        if (this.jdField_a_of_type_Kvq == null)
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
          awqx.b(null, "dc00898", "", "", "0X800A2C6", "0X800A2C6", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label321;
        }
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "checkParamAndDoAction action[" + str1 + "], seq[" + l + "], silent[" + this.jdField_d_of_type_Boolean + "]");
        return;
        paramIntent = this.jdField_a_of_type_Kvq.c;
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
          miu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
      mga.e(false, true);
      babr.b(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131630070), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131630068), null, new ldr(this), null);
      bool = true;
    }
    return bool;
  }
  
  private boolean e()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())
    {
      mga.e(false, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "startVideo phone is calling!");
      }
      String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131630068);
      babr.b(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131630070), str, null, new ldt(this), null);
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839053);
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
      awqx.b(null, "CliOper", "", "", "0X8009E93", "0X8009E93", 0, 0, str, "", "", "");
      c(-1037L);
      return;
    } while (e());
    awqx.b(null, "CliOper", "", "", "0X8009E94", "0X8009E94", 0, 0, str, "", "", "");
    d();
  }
  
  protected void c()
  {
    h();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131306578));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131306565));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131306581));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = mfx.a(super.getApplicationContext(), 2130841514);
    View localView = super.findViewById(2131306582);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.c = ((TextView)super.findViewById(2131306590));
      if ((!badq.h(super.getApplicationContext())) && ((badq.c(super.getApplicationContext())) || (badq.b(super.getApplicationContext()))))
      {
        this.c.setVisibility(0);
        this.c.setText(2131630534);
      }
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = ((MutiMemberThumbList)findViewById(2131306699));
      if (this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList != null)
      {
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setRelationShipInfo(this.jdField_a_of_type_Long, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setBitMapFetcher(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setMoreInfoDrawableColor("#4C000000");
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setDisPlayList(null);
        if (this.jdField_b_of_type_Int != 1) {
          break label335;
        }
      }
    }
    label335:
    for (int i = 10;; i = 1)
    {
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, i, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, true);
      b(i);
      localView = findViewById(2131297011);
      super.c();
      this.jdField_a_of_type_Lwx = new lwx(this, this.jdField_a_of_type_ComTencentAvVideoController, 1, this.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetTextView, localView, null);
      if (this.jdField_a_of_type_Lwx != null) {
        this.jdField_a_of_type_Lwx.a();
      }
      return;
      localView.setBackgroundResource(2130841514);
      break;
    }
  }
  
  public void c(long paramLong)
  {
    if ((lor.f(this)) && (this.jdField_a_of_type_Lwx != null))
    {
      this.jdField_a_of_type_Lwx.a(new lds(this, paramLong));
      return;
    }
    super.a(paramLong);
  }
  
  void f()
  {
    boolean bool = VideoController.a(this);
    if ((!lor.f(this)) || (bool) || (this.jdField_a_of_type_Lwx == null))
    {
      super.f();
      return;
    }
    this.jdField_a_of_type_Lwx.a(new ldn(this));
  }
  
  void h()
  {
    int j = 8;
    boolean bool = VideoController.a(this);
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)super.findViewById(2131306713));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131493991);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new ldq(this));
    }
    View localView1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.findViewById(2131306585);
    View localView2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.findViewById(2131306583);
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
        super.findViewById(2131306710).setVisibility(0);
      }
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onCreate");
    }
    AVActivity.a(getWindow(), true);
    ImmersiveUtils.a(true, getWindow());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
    this.jdField_b_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
    super.setContentView(2131493944);
    super.onCreate(paramBundle);
    j();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Kvg);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Kur);
    registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ldu(this);
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(2097152);
    paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramBundle != null) {
      paramBundle.a(getClass().getName(), getIntent());
    }
    c(getIntent());
    if (mfs.a())
    {
      if (this.jdField_a_of_type_Mht == null) {
        this.jdField_a_of_type_Mht = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      this.jdField_a_of_type_Mht.a(this.jdField_a_of_type_Kvq.c);
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Kvg);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_b_of_type_Kur);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(-1044L);
      this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    }
    if (this.jdField_a_of_type_Lwx != null)
    {
      this.jdField_a_of_type_Lwx.b();
      this.jdField_a_of_type_Lwx = null;
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
      awqx.b(null, "CliOper", "", "", "0X800420F", "0X800420F", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_Lal.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
    if (!this.f) {
      bbqo.a(BaseApplicationImpl.getContext(), true, 50, 1);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    bbqo.a(BaseApplicationImpl.getContext(), 50, 0);
    bbqo.a(BaseApplicationImpl.getContext(), false, 50, 1);
    h();
    if (this.jdField_a_of_type_Kvq != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(GaInviteLockActivity.class);
    }
    this.jdField_a_of_type_Lal.a(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity
 * JD-Core Version:    0.7.0.1
 */