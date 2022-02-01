package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.SeqUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VideoInviteFloatBar
  implements View.OnClickListener, View.OnTouchListener
{
  String a = null;
  public boolean b = false;
  boolean c = false;
  boolean d = true;
  boolean e = false;
  Intent f = null;
  TextView g;
  TextView h;
  WindowManager i;
  private Context j;
  private int k = 0;
  private int l = 2131953352;
  private boolean m = false;
  private WindowManager.LayoutParams n;
  private View o;
  private float p;
  private float q;
  private float r;
  private float s;
  private Handler t = new Handler();
  private Runnable u = new VideoInviteFloatBar.1(this);
  
  public VideoInviteFloatBar(Context paramContext)
  {
    this.j = paramContext;
    this.i = ((WindowManager)paramContext.getSystemService("window"));
    this.o = ((LayoutInflater)this.j.getSystemService("layout_inflater")).inflate(2131625820, null);
    this.o.setOnTouchListener(this);
  }
  
  public void a()
  {
    Log.i("VideoInviteFloatBar", "hide");
    if (!this.m) {
      return;
    }
    this.m = false;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFloatBar", 2, "hide removeView start");
      }
      if (this.i != null) {
        this.i.removeView(this.o);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("VideoInviteFloatBar", 2, "hide removeView end");
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hide error : ");
        localStringBuilder.append(localException);
        QLog.d("VideoInviteFloatBar", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    ((ImageView)this.o.findViewById(2131432714)).setImageBitmap(paramBitmap);
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    ((ImageView)this.o.findViewById(2131432714)).setImageBitmap(paramBitmap);
    ((TextView)this.o.findViewById(2131439121)).setText(paramString);
  }
  
  public void a(String paramString)
  {
    this.g = ((TextView)this.o.findViewById(2131438149));
    this.g.setText(paramString);
    this.o.invalidate();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.c = paramBoolean3;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("show, mIsAudioMode[");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("], misMultiCall[");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append("], mIsMultiIncomingCall[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("]");
    QLog.w("VideoInviteFloatBar", 1, ((StringBuilder)localObject).toString());
    if (this.m) {
      return;
    }
    localObject = (TextView)this.o.findViewById(2131438149);
    Button localButton1 = (Button)this.o.findViewById(2131427374);
    Button localButton2 = (Button)this.o.findViewById(2131444596);
    localButton1.setClickable(true);
    localButton2.setClickable(true);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    if (paramBoolean3)
    {
      if (this.d) {
        ((TextView)localObject).setText(((TextView)localObject).getResources().getString(2131893091));
      } else {
        ((TextView)localObject).setText(((TextView)localObject).getResources().getString(2131893092));
      }
    }
    else if (this.d) {
      ((TextView)localObject).setText(((TextView)localObject).getResources().getString(2131893090));
    } else {
      ((TextView)localObject).setText(((TextView)localObject).getResources().getString(2131893093));
    }
    b();
    int i1 = this.k;
    if (i1 > 0) {
      this.t.postDelayed(this.u, i1 * 1000);
    }
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBar", 2, "initTN");
    }
    try
    {
      this.n = new WindowManager.LayoutParams();
      this.n.height = -2;
      this.n.width = -1;
      this.n.flags = 2098088;
      if (Build.VERSION.SDK_INT >= 26) {
        this.n.type = 2038;
      } else {
        this.n.type = 2010;
      }
      this.n.format = -3;
      if (Build.VERSION.SDK_INT >= 19)
      {
        WindowManager.LayoutParams localLayoutParams = this.n;
        localLayoutParams.flags |= 0x4000000;
      }
      this.n.gravity = 49;
      if (this.l != -1) {
        this.n.windowAnimations = this.l;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFloatBar", 2, "startHandler addView start");
      }
      this.i.addView(this.o, this.n);
      this.m = true;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoInviteFloatBar", 2, "startHandler addView end");
        return;
      }
    }
    catch (Exception localException2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startHandler error : ");
      localStringBuilder.append(localException2);
      AVLog.printErrorLog("VideoInviteFloatBar", localStringBuilder.toString());
      return;
    }
    catch (SecurityException localSecurityException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startHandler error : ");
        localStringBuilder.append(localSecurityException);
        QLog.d("VideoInviteFloatBar", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startHandler error : ");
        localStringBuilder.append(localBadTokenException);
        QLog.d("VideoInviteFloatBar", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      StringBuilder localStringBuilder;
      this.i.updateViewLayout(this.o, this.n);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startHandler error : ");
        localStringBuilder.append(localIllegalStateException);
        QLog.d("VideoInviteFloatBar", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void b(String paramString)
  {
    this.h = ((TextView)this.o.findViewById(2131447402));
    this.h.setText(paramString);
    this.o.invalidate();
  }
  
  public void c()
  {
    Object localObject = (Button)this.o.findViewById(2131427374);
    Button localButton = (Button)this.o.findViewById(2131444596);
    ((Button)localObject).setVisibility(4);
    localButton.setVisibility(4);
    this.h.setVisibility(4);
    localObject = (TextView)this.o.findViewById(2131438149);
    this.o.invalidate();
  }
  
  public void c(String paramString)
  {
    this.g = ((TextView)this.o.findViewById(2131438149));
    this.g.setText(paramString);
    this.o.invalidate();
  }
  
  public TextView d()
  {
    return (TextView)this.o.findViewById(2131439121);
  }
  
  public void d(String paramString)
  {
    ((TextView)this.o.findViewById(2131439121)).setText(paramString);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    long l1;
    Object localObject;
    if (i1 != 2131427374)
    {
      if (i1 == 2131444596)
      {
        l1 = AudioHelper.c();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick reject, mIsMultiIncomingCall[");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append("], misMultiCall[");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append("], seq[");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append("]");
        QLog.w("VideoInviteFloatBar", 1, ((StringBuilder)localObject).toString());
        localObject = new Intent();
        SeqUtil.a((Intent)localObject, l1);
        if (this.c) {
          ((Intent)localObject).setAction("tencent.video.invite.multirefuse");
        } else if (this.e) {
          ((Intent)localObject).setAction("tencent.video.invite.gaignore");
        } else {
          ((Intent)localObject).setAction("tencent.video.invite.refuse");
        }
        ((Intent)localObject).setPackage(this.j.getPackageName());
        this.j.sendBroadcast((Intent)localObject);
        a();
      }
    }
    else
    {
      l1 = AudioHelper.c();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick accept, mIsMultiIncomingCall[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("], misMultiCall[");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("]");
      QLog.w("VideoInviteFloatBar", 1, ((StringBuilder)localObject).toString());
      localObject = new Intent();
      SeqUtil.a((Intent)localObject, l1);
      if (this.c) {
        ((Intent)localObject).setAction("tencent.video.invite.multiaccept");
      } else if (this.e) {
        ((Intent)localObject).setAction("tencent.video.invite.gaaccept");
      } else {
        ((Intent)localObject).setAction("tencent.video.invite.accept");
      }
      ((Button)this.o.findViewById(2131427374)).setClickable(false);
      ((Button)this.o.findViewById(2131444596)).setClickable(false);
      ((Intent)localObject).setPackage(this.j.getPackageName());
      this.j.sendBroadcast((Intent)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.r = paramMotionEvent.getRawX();
    this.s = paramMotionEvent.getRawY();
    paramView = new StringBuilder();
    paramView.append("currX");
    paramView.append(this.r);
    paramView.append("====currY");
    paramView.append(this.s);
    Log.i("currP", paramView.toString());
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1) {
        return true;
      }
      if (paramMotionEvent.getY() - this.q < 0.0F)
      {
        a();
        return true;
      }
    }
    else
    {
      this.p = paramMotionEvent.getX();
      this.q = paramMotionEvent.getY();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBar
 * JD-Core Version:    0.7.0.1
 */