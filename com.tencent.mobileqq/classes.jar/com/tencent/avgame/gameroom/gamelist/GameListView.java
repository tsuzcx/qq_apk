package com.tencent.avgame.gameroom.gamelist;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bgtn;
import com.tencent.qphone.base.util.QLog;
import mxl;
import myc;
import myg;
import nak;
import nal;
import nar;
import nas;
import nat;
import nau;

public class GameListView
  extends RelativeLayout
  implements Handler.Callback, ViewPager.OnPageChangeListener, nar, nau
{
  protected long a;
  protected Handler a;
  protected CanDisableTouchViewPager a;
  protected GameListPagerAdapter a;
  protected nat a;
  
  public GameListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GameListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Nat = new nas(this);
  }
  
  public Context a()
  {
    return getContext();
  }
  
  public nat a()
  {
    return this.jdField_a_of_type_Nat;
  }
  
  public void a()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Nat.b();
  }
  
  public void a(myc parammyc)
  {
    int i = parammyc.a();
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "refreshUI  gameStatus:" + i + " currentItem:" + this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.getCurrentItem() + " currentGameIndex:" + this.jdField_a_of_type_Nat.a());
    }
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.setCanScrollable(this.jdField_a_of_type_Nat.a());
      i = this.jdField_a_of_type_Nat.a();
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListPagerAdapter.a(this.jdField_a_of_type_Nat.a(), this.jdField_a_of_type_Nat.a(), this.jdField_a_of_type_Nat.a());
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListPagerAdapter.getCount() > 0) && (this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.getCurrentItem() != i)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.setCurrentItem(i, true);
      }
      if (getVisibility() == 8) {
        c();
      }
    }
    while (getVisibility() != 0) {
      return;
    }
    d();
  }
  
  public void a(myg parammyg, int paramInt)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int i = 0;
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = parammyg;
      localMessage.arg1 = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      i = 128;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 2;
    localMessage.obj = parammyg;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, i);
  }
  
  public void a(nal paramnal)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Nat.a(paramnal);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager = ((CanDisableTouchViewPager)findViewById(2131380863));
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListPagerAdapter = new GameListPagerAdapter(getContext(), this, paramnal);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.setPageTransformer(true, new GameListPageTransformer(true));
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.setAdapter(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListPagerAdapter);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.setOffscreenPageLimit(3);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.setPageMargin(bgtn.a(5.0F));
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.setClipChildren(false);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.setCurrentItem(0);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.setOnPageChangeListener(this);
    paramnal = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.getLayoutParams();
    paramnal.height = nak.h;
    paramnal.leftMargin = nak.d;
    paramnal.rightMargin = nak.d;
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.setLayoutParams(paramnal);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.setCanScrollable(false);
    a(mxl.a().a());
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistCanDisableTouchViewPager.getLocationOnScreen(paramArrayOfInt);
  }
  
  public void b()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Nat.a();
  }
  
  public void c()
  {
    setVisibility(0);
  }
  
  public void d()
  {
    setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Nat.a((myg)paramMessage.obj, paramMessage.arg1);
      continue;
      this.jdField_a_of_type_Nat.b((myg)paramMessage.obj, paramMessage.arg1);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    while (mxl.a().a().a() != 0) {
      return;
    }
    mxl.a().a().a = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListPagerAdapter.a(paramInt);
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView
 * JD-Core Version:    0.7.0.1
 */