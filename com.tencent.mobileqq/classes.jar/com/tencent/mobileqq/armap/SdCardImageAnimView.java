package com.tencent.mobileqq.armap;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class SdCardImageAnimView
  extends ImageView
  implements FrameBmpCache.EndListener
{
  public boolean a = false;
  FrameBmpCache.EndListener b = null;
  private FrameBmpCache c;
  private boolean d = false;
  private Runnable e = new SdCardImageAnimView.1(this);
  private boolean f = false;
  private Bitmap g;
  private boolean h = false;
  private Runnable i = new SdCardImageAnimView.2(this);
  
  public SdCardImageAnimView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public SdCardImageAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public SdCardImageAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    this.c = new FrameBmpCache(getResources());
    this.c.a(this);
    new HandlerThread("sub_thread").start();
  }
  
  private void d()
  {
    Object localObject = this.c;
    if ((localObject != null) && (this.f))
    {
      localObject = ((FrameBmpCache)localObject).c();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("bgUpdate cb=");
        localStringBuilder.append(localObject);
        localStringBuilder.append(", cbm=");
        localStringBuilder.append(this.g);
        QLog.i("SdCardImageAnimView", 2, localStringBuilder.toString());
      }
      if (this.g != localObject)
      {
        this.g = ((Bitmap)localObject);
        setImageBitmap(this.g);
      }
      int j = 32;
      if (this.c.b > 0) {
        j = 1000 / this.c.b;
      }
      this.a = true;
      postDelayed(this.e, j);
    }
  }
  
  private void e()
  {
    this.c.b();
    this.c.d();
    this.f = true;
  }
  
  private void f()
  {
    FrameBmpCache localFrameBmpCache = this.c;
    if (localFrameBmpCache != null) {
      localFrameBmpCache.e();
    }
    this.f = false;
    this.a = false;
    this.g = null;
  }
  
  public void a()
  {
    if (!this.d)
    {
      QLog.i("SdCardImageAnimView", 1, "startAnim has no data, return ");
      return;
    }
    if (this.f)
    {
      QLog.i("SdCardImageAnimView", 1, "startAnim isAnimStarted, return");
      return;
    }
    ThreadManager.getSubThreadHandler().post(this.i);
    removeCallbacks(this.e);
    e();
    post(this.e);
  }
  
  public void a(SdCardImageAnimView paramSdCardImageAnimView)
  {
    paramSdCardImageAnimView = this.b;
    if (paramSdCardImageAnimView != null) {
      paramSdCardImageAnimView.a(this);
    }
  }
  
  public boolean b()
  {
    if (!this.d) {
      return false;
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.i);
    removeCallbacks(this.e);
    f();
    return true;
  }
  
  public FrameBmpCache getFrameBmpCache()
  {
    return this.c;
  }
  
  public void setAnimationData(ArrayList<String> paramArrayList)
  {
    setAnimationData(paramArrayList, false);
  }
  
  public void setAnimationData(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    setAnimationData(paramArrayList, paramBoolean, false);
  }
  
  public void setAnimationData(ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.d = true;
    } else {
      this.d = false;
    }
    this.c.a(paramBoolean1);
    this.c.b(paramBoolean2);
    this.c.a(paramArrayList);
  }
  
  public void setDefaultImg()
  {
    ThreadManager.getSubThreadHandler().post(this.i);
  }
  
  public void setEndListener(FrameBmpCache.EndListener paramEndListener)
  {
    this.b = paramEndListener;
  }
  
  public void setFPS(int paramInt)
  {
    this.c.a(paramInt);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0)
    {
      this.h = b();
      return;
    }
    if (this.h) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SdCardImageAnimView
 * JD-Core Version:    0.7.0.1
 */