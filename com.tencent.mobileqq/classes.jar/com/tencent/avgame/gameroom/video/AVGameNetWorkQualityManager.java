package com.tencent.avgame.gameroom.video;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;

public class AVGameNetWorkQualityManager
{
  private final Handler a;
  private final Handler b;
  private final int[] c = { 0, 150, 300 };
  private final AVGameNetWorkQualityManager.NetWorkQulityCheckRunnable d = new AVGameNetWorkQualityManager.NetWorkQulityCheckRunnable(this, null);
  private final AVGameNetWorkQualityManager.UpdateNetWorkStatusRunnable e;
  private View f;
  private TextView g;
  private boolean h = false;
  private int i;
  private String j;
  private int k;
  private int l;
  private long m;
  private long n;
  private AVGameNetWorkQualityManager.MyNetObserver o;
  private boolean p = true;
  
  public AVGameNetWorkQualityManager(View paramView)
  {
    this.f = paramView.findViewById(2131428955);
    this.g = ((TextView)paramView.findViewById(2131441223));
    this.f.setVisibility(8);
    this.b = new Handler();
    this.a = AVGameHandler.a().b();
    this.e = new AVGameNetWorkQualityManager.UpdateNetWorkStatusRunnable(this, null);
    f();
  }
  
  public static int a()
  {
    boolean bool = AppNetConnInfo.isWifiConn();
    int i1 = 4;
    if (bool) {
      return 1;
    }
    if (AppNetConnInfo.isMobileConn())
    {
      int i2 = AppNetConnInfo.getMobileInfo();
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 == 3) {
            return i1;
          }
          if (i2 == 4) {
            return 5;
          }
        }
        else
        {
          return 3;
        }
      }
      else {
        return 2;
      }
    }
    i1 = -1;
    return i1;
  }
  
  private Drawable a(int paramInt)
  {
    return this.f.getResources().getDrawable(paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      this.f.setBackgroundDrawable(a(2130838773));
    } else if (paramInt1 == 2) {
      this.f.setBackgroundDrawable(a(2130838772));
    } else if (paramInt1 == 3) {
      this.f.setBackgroundDrawable(a(2130838771));
    }
    TextView localTextView = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("ms");
    localTextView.setText(localStringBuilder.toString());
  }
  
  private boolean a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("verifyRTTInfo value:=");
      localStringBuilder.append(paramString);
      QLog.d("AVGameNetWorkQualityManager", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.split("\\|");
    if (paramString != null)
    {
      if (paramString.length < 2) {
        return false;
      }
      int i1 = this.l;
      this.k = i1;
      this.m = i1;
      try
      {
        this.l = Integer.valueOf(paramString[0]).intValue();
        this.n = Long.parseLong(paramString[1]);
        return true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return true;
      }
    }
    return false;
  }
  
  private int b(int paramInt)
  {
    int[] arrayOfInt = this.c;
    if ((paramInt >= arrayOfInt[0]) && (paramInt <= arrayOfInt[1])) {
      return 1;
    }
    arrayOfInt = this.c;
    if ((paramInt > arrayOfInt[1]) && (paramInt <= arrayOfInt[2])) {
      return 2;
    }
    return 3;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      this.f.setBackgroundDrawable(a(2130838776));
    } else if (paramInt1 == 2) {
      this.f.setBackgroundDrawable(a(2130838775));
    } else if (paramInt1 == 3) {
      this.f.setBackgroundDrawable(a(2130838774));
    }
    TextView localTextView = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("ms");
    localTextView.setText(localStringBuilder.toString());
  }
  
  private void f()
  {
    if (this.o == null)
    {
      this.o = new AVGameNetWorkQualityManager.MyNetObserver(this);
      ObserverCenter.a().a(this.o, true);
    }
  }
  
  private void g()
  {
    this.j = AVGameBusinessCtrl.b().h();
    if (!a(this.j)) {
      return;
    }
    this.b.removeCallbacks(this.e);
    this.b.post(this.e);
  }
  
  private void h()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mCurrentNetWorkStatus, [");
      localStringBuilder.append(this.i);
      localStringBuilder.append("<--mCurrentRTTValue>");
      localStringBuilder.append(this.l);
      localStringBuilder.append("]");
      QLog.d("AVGameNetWorkQualityManager", 2, localStringBuilder.toString());
    }
    if (this.h)
    {
      if (!this.p) {
        return;
      }
      int i4 = b(this.l);
      int i1 = this.l;
      if (i1 >= 0) {
        i1 = Math.min(i1, 999);
      } else {
        i1 = 999;
      }
      long l1 = this.m;
      int i3 = i4;
      int i2 = i1;
      if (l1 > 0L)
      {
        long l2 = this.n;
        i3 = i4;
        i2 = i1;
        if (l2 > 0L)
        {
          i3 = i4;
          i2 = i1;
          if (l2 - l1 < 1000L)
          {
            i3 = 3;
            i2 = 999;
          }
        }
      }
      this.i = a();
      i1 = this.i;
      if (i1 == -1) {
        i();
      } else if (i1 == 1) {
        b(i3, i2);
      } else if (i1 >= 2) {
        a(i3, i2);
      }
      this.f.setVisibility(0);
    }
  }
  
  private void i()
  {
    TextView localTextView = this.g;
    localTextView.setText(localTextView.getResources().getString(2131887313));
    this.f.setBackgroundDrawable(a(2130838770));
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
    if (!this.p)
    {
      this.f.setVisibility(8);
      this.a.removeCallbacks(this.d);
      this.b.removeCallbacks(this.e);
      return;
    }
    this.f.setVisibility(0);
  }
  
  public void b()
  {
    this.a.removeCallbacks(this.d);
    this.a.postDelayed(this.d, 500L);
  }
  
  public void c()
  {
    this.h = true;
    this.a.removeCallbacks(this.d);
    this.a.postDelayed(this.d, 0L);
  }
  
  public void d()
  {
    this.k = 0;
    this.m = 0L;
    this.l = 0;
    this.n = 0L;
    this.a.removeCallbacks(this.d);
    if (this.o != null)
    {
      ObserverCenter.a().b(this.o);
      this.o = null;
    }
    this.b.removeCallbacksAndMessages(null);
  }
  
  public void e()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    localLayoutParams.leftMargin = GameRoomViewLayoutParamsDef.f;
    localLayoutParams.bottomMargin = GameRoomViewLayoutParamsDef.f;
    localLayoutParams.width = GameRoomViewLayoutParamsDef.m;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.e;
    this.g.setTextSize(GameRoomViewLayoutParamsDef.l);
    this.g.getLayoutParams().height = GameRoomViewLayoutParamsDef.o;
    this.g.setPadding(0, GameRoomViewLayoutParamsDef.n, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameNetWorkQualityManager
 * JD-Core Version:    0.7.0.1
 */