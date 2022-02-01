package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.av.VideoController;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerProxy;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.gles.WatchTogetherVideoRenderHelper;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.view.SmallScreenGLContentView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class SmallScreenWatchTogether
  extends SmallScreenItemBase
  implements WatchTogetherUIProxy
{
  private static int a = 3;
  private SmallScreenGLContentView b;
  private ImageView c;
  private ImageView d;
  private boolean e;
  private boolean f = false;
  private WatchTogetherVideoRenderHelper g;
  private ActionSheet h;
  private Handler i;
  
  public SmallScreenWatchTogether(Context paramContext)
  {
    this.l = "SmallScreenWatchTogether";
    if (QLog.isDevelopLevel()) {
      QLog.w(this.l, 4, "SmallScreenWatchTogether construtc");
    }
    this.o = 2013396995;
    this.p = paramContext.getResources().getDimensionPixelSize(2131298646);
    this.q = paramContext.getResources().getDimensionPixelSize(2131298645);
    this.i = new Handler();
  }
  
  private ActionSheet b(boolean paramBoolean)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.c.getContext(), null);
    if (paramBoolean) {
      localActionSheet.addButton(this.m.getResources().getString(2131893756), 1);
    }
    localActionSheet.addButton(this.m.getResources().getString(2131893755), 3);
    localActionSheet.addCancelButton(this.m.getResources().getString(2131893754));
    localActionSheet.setOnButtonClickListener(new SmallScreenWatchTogether.2(this, paramBoolean));
    Window localWindow = localActionSheet.getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      if (localLayoutParams != null) {
        if (Build.VERSION.SDK_INT >= 26) {
          localLayoutParams.type = 2038;
        } else {
          localLayoutParams.type = 2002;
        }
      }
      localWindow.setAttributes(localLayoutParams);
    }
    return localActionSheet;
  }
  
  private void g()
  {
    if ((this.g != null) && (this.b != null)) {
      return;
    }
    this.g = new WatchTogetherVideoRenderHelper(true);
    this.b = ((SmallScreenGLContentView)this.m.findViewById(2013331456));
    this.b.setVideoRender(this.g);
  }
  
  private void h()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    if (QLog.isDevelopLevel()) {
      QLog.w(this.l, 4, "bindToVideoSink");
    }
    g();
    this.b.onResume();
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.f().aA();
    if ((localWatchTogetherMediaPlayCtrl != null) && (localWatchTogetherMediaPlayCtrl.h())) {
      this.c.setVisibility(0);
    }
    if (localWatchTogetherMediaPlayCtrl != null)
    {
      localWatchTogetherMediaPlayCtrl.a(this.g);
      localWatchTogetherMediaPlayCtrl.a(this);
      localWatchTogetherMediaPlayCtrl.x();
    }
  }
  
  private void i()
  {
    if (!this.e) {
      return;
    }
    this.e = false;
    if (QLog.isDevelopLevel()) {
      QLog.w(this.l, 4, "unBindToVideoSink");
    }
    this.b.onPause();
    c();
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.f().aA();
    if (localWatchTogetherMediaPlayCtrl != null)
    {
      localWatchTogetherMediaPlayCtrl.a("unBindToVideoSink", this.g);
      localWatchTogetherMediaPlayCtrl.b(this);
    }
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Context paramContext, LayoutInflater paramLayoutInflater, SmallScreenRelativeLayout.FloatListener paramFloatListener)
  {
    super.a(paramContext, paramLayoutInflater, paramFloatListener);
    paramContext = (SmallScreenRelativeLayout)this.m.findViewById(2013331474);
    int j = AIOUtils.b(22.0F, paramContext.getResources());
    paramContext.setIntercetRect(this.p - j, 0, this.p, j, new SmallScreenWatchTogether.1(this));
    this.c = ((ImageView)this.m.findViewById(2013331482));
    this.d = ((ImageView)this.m.findViewById(2013331483));
  }
  
  public void a(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.l, 4, "showActionSheet");
    }
    paramView = VideoController.f().aA();
    if (paramView == null) {
      return;
    }
    try
    {
      if (this.h == null) {
        this.h = b(paramView.r());
      }
      this.h.show();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      QLog.w(this.l, 1, "showActionSheet fail");
    }
  }
  
  public void a(String paramString)
  {
    this.i.post(new SmallScreenWatchTogether.3(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.i.post(new SmallScreenWatchTogether.4(this));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      h();
    } else {
      i();
    }
    super.a(paramBoolean, a);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.e)
    {
      if (this.f) {
        return false;
      }
      this.i.post(new SmallScreenWatchTogether.5(this));
    }
    return false;
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.l, 4, "onDestroy");
    }
    this.f = true;
    a = this.m.getCurPosition();
    c();
    super.b();
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void c()
  {
    ActionSheet localActionSheet = this.h;
    if (localActionSheet != null)
    {
      localActionSheet.dismiss();
      this.h.cancel();
      this.h = null;
    }
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void setImmersiveStatus(boolean paramBoolean) {}
  
  public void setOrientationParams(int paramInt) {}
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener) {}
  
  public void setWatchTogetherMediaPlayerProxy(WatchTogetherMediaPlayerProxy paramWatchTogetherMediaPlayerProxy) {}
  
  public void setWatchTogetherParams(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenWatchTogether
 * JD-Core Version:    0.7.0.1
 */