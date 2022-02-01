package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;

public class GamePartyTipsBar
  implements TipsBarTask
{
  private QQAppInterface a;
  private TipsManager b;
  private Context c;
  private BaseSessionInfo d;
  private String e;
  private int f;
  private int g;
  private TextView h = null;
  
  public GamePartyTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    this.a = paramQQAppInterface;
    this.b = paramTipsManager;
    this.c = paramContext;
    this.d = paramBaseSessionInfo;
  }
  
  public int a()
  {
    return 40;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.c).inflate(2131624146, null);
    this.h = ((TextView)paramVarArgs.findViewById(2131428129));
    d();
    paramVarArgs.setOnClickListener(new GamePartyTipsBar.1(this));
    ReportCenter.a().a(this.a.getCurrentAccountUin(), "", "", "2000", "2015", "0", false);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (((GamePartyManager)this.a.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.d.a, this.d.b)) {
      this.b.a(this, new Object[0]);
    }
  }
  
  public int b()
  {
    return 14;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public void d()
  {
    Object localObject = (GamePartyManager)this.a.getManager(QQManagerFactory.GAME_PARTY_MANAGER);
    if (((GamePartyManager)localObject).a(this.d.a, this.d.b))
    {
      this.e = ((GamePartyManager)localObject).b;
      this.f = ((GamePartyManager)localObject).c;
      this.g = ((GamePartyManager)localObject).d;
    }
    if (this.h != null)
    {
      if (this.a.getCurrentAccountUin().equals(((GamePartyManager)localObject).h))
      {
        if (this.f < this.g) {
          localObject = String.format(this.a.getApp().getString(2131889909), new Object[] { Integer.valueOf(this.f), Integer.valueOf(this.g) });
        } else {
          localObject = this.a.getApp().getString(2131889907);
        }
      }
      else if ((((GamePartyManager)localObject).i != 3) && (((GamePartyManager)localObject).i != 4))
      {
        if (this.f < this.g) {
          localObject = this.a.getApp().getString(2131889910);
        } else {
          localObject = this.a.getApp().getString(2131889908);
        }
      }
      else {
        localObject = this.a.getApp().getString(2131889911);
      }
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() == localLooper.getThread())
      {
        this.h.setText((CharSequence)localObject);
        return;
      }
      new Handler(localLooper).post(new GamePartyTipsBar.2(this, (String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar
 * JD-Core Version:    0.7.0.1
 */