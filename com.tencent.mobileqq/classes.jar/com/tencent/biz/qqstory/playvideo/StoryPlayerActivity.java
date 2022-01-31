package com.tencent.biz.qqstory.playvideo;

import ajya;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import bcql;
import bkvi;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import stb;
import tuk;
import tum;
import tuo;
import tut;
import tvb;
import tyy;
import uvx;
import ved;
import vei;

public class StoryPlayerActivity
  extends FragmentActivity
  implements IEventReceiver, tvb
{
  public static int a;
  private static int b;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  public AnimationParam a;
  private tuo jdField_a_of_type_Tuo = new tuo(this);
  protected tut a;
  public boolean a;
  public AnimationParam b;
  
  public StoryPlayerActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  @NonNull
  public Context a()
  {
    return this;
  }
  
  @NonNull
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    this.jdField_a_of_type_Tut = new tut();
    this.jdField_a_of_type_Tut.a(this);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Tut.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    jdField_b_of_type_Int += 1;
    ved.a("Q.qqstory.playernew.StoryPlayerActivity", "doOnCreate, instance count = %d", Integer.valueOf(jdField_b_of_type_Int));
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    bkvi.a(this);
    if (bkvi.c())
    {
      getWindow().clearFlags(1024);
      getWindow().addFlags(2048);
    }
    this.isClearCoverLayer = true;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    if (isInMultiWindow())
    {
      bcql.a(this, ajya.a(2131714556), 0).a();
      finish();
      return false;
    }
    super.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam = ((AnimationParam)getIntent().getParcelableExtra("AnimationParam"));
    ved.b("Q.qqstory.playernew.StoryPlayerActivity", "doOnCreate = > StoryPlayerActivity doOnCreate");
    setContentView(2131561325);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    this.jdField_a_of_type_Tut.a(paramBundle, getIntent().getExtras());
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      paramBundle = findViewById(16908290);
      paramBundle.getViewTreeObserver().addOnPreDrawListener(new tuk(this, paramBundle));
    }
    stb.a().registerSubscriber(this.jdField_a_of_type_Tuo);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_b_of_type_Int -= 1;
    ved.a("Q.qqstory.playernew.StoryPlayerActivity", "doOnDestroy, instance count = %d", Integer.valueOf(jdField_b_of_type_Int));
    this.jdField_a_of_type_Tut.g();
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Tuo);
    uvx.d();
    if (jdField_b_of_type_Int == 0) {
      this.jdField_a_of_type_AndroidOsHandler.post(new StoryPlayerActivity.2(this));
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Tut.e();
    vei.a(2, this.currentActivityStayTime);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Tut.d();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_Tut.c();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_Tut.f();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public void finish()
  {
    boolean bool;
    ViewGroup localViewGroup;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam != null)
    {
      bool = true;
      ved.a("Q.qqstory.playernew.StoryPlayerActivity", "finish with animation = %s", Boolean.valueOf(bool));
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam == null) {
        break label94;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Tut.b();
        localViewGroup = (ViewGroup)a();
        if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam == null) {
          break label86;
        }
      }
    }
    label86:
    for (AnimationParam localAnimationParam = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam;; localAnimationParam = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam)
    {
      tyy.a(localViewGroup, localAnimationParam, new tum(this));
      return;
      bool = false;
      break;
    }
    label94:
    this.jdField_a_of_type_Tut.b();
    super.finish();
    overridePendingTransition(2130771988, 2130771989);
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Tut.a()) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void setImmersiveStatus()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      int i = getResources().getColor(2131167087);
      if (this.mSystemBarComp == null)
      {
        this.mSystemBarComp = new SystemBarCompact(this, true, i);
        this.mSystemBarComp.setStatusDrawable(null);
      }
      if (!isInMultiWindow()) {
        ImmersiveUtils.a(getWindow(), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerActivity
 * JD-Core Version:    0.7.0.1
 */