package com.tencent.biz;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;

public class JoinGroupHandler
{
  protected QQProgressDialog a;
  protected Context b;
  protected QQAppInterface c;
  protected long d;
  protected String e;
  protected JoinGroupHandler.IJoinGroupCB f;
  protected int g;
  protected long h = 0L;
  protected Runnable i = new JoinGroupHandler.2(this);
  protected TroopMngObserver j = new JoinGroupHandler.3(this);
  
  public JoinGroupHandler(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, JoinGroupHandler.IJoinGroupCB paramIJoinGroupCB)
  {
    this.b = paramContext;
    this.c = paramQQAppInterface;
    this.g = paramInt;
    this.e = paramString;
    this.f = paramIJoinGroupCB;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this.b).notifyUser(paramInt1, this.b.getResources().getDimensionPixelSize(2131299920), 0, paramInt2);
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      paramTroopInfo = AddFriendLogicActivity.a(this.b, paramTroopInfo.troopuin, paramTroopInfo.troopname, paramTroopInfo.cGroupOption, this.g, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.e, null);
      this.b.startActivity(paramTroopInfo);
      this.f.b();
      return;
    }
    a(2131917537, 1);
    this.f.a();
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      if ((this.a != null) && (this.a.isShowing()))
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.h;
        if ((!paramBoolean) && (l1 - l2 < 1000L))
        {
          ThreadManager.getUIHandlerV2().postDelayed(this.i, 500L);
          return;
        }
        this.a.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void b(long paramLong)
  {
    try
    {
      ITroopMngHandler localITroopMngHandler = (ITroopMngHandler)this.c.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
      this.d = paramLong;
      localITroopMngHandler.a(paramLong, 8390784);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(2131916977, 0);
      this.f.a();
    }
  }
  
  private void c()
  {
    try
    {
      if (this.a == null)
      {
        this.a = new QQProgressDialog(this.b, this.b.getResources().getDimensionPixelSize(2131299920));
        this.a.c(2131892360);
        this.a.c(false);
        this.a.setOnDismissListener(new JoinGroupHandler.1(this));
      }
      this.a.show();
      this.h = System.currentTimeMillis();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    this.c.addObserver(this.j);
  }
  
  public void a(long paramLong)
  {
    if (!NetworkUtil.isNetSupport(this.b))
    {
      a(2131892102, 0);
      this.f.a();
      return;
    }
    if (0L == paramLong)
    {
      this.f.a();
      return;
    }
    this.d = paramLong;
    c();
    b(paramLong);
  }
  
  public void b()
  {
    this.c.removeObserver(this.j);
    ThreadManager.getUIHandlerV2().removeCallbacks(this.i);
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.JoinGroupHandler
 * JD-Core Version:    0.7.0.1
 */