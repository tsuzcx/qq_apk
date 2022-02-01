package com.tencent.biz.qqstory.takevideo.slideshow;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;

public class SlideProgressNotifier
  extends QQProgressNotifier
  implements DialogInterface.OnKeyListener, RefreshUICallBack
{
  Activity a;
  SlideProgressNotifier.RefreshProgressThread b;
  Handler c;
  private SlideProgressNotifier.OnCancelListener i;
  
  public SlideProgressNotifier(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    this.a = paramActivity;
    this.c = new Handler(Looper.getMainLooper());
  }
  
  public void a()
  {
    SlideProgressNotifier.RefreshProgressThread localRefreshProgressThread = this.b;
    if (localRefreshProgressThread != null) {
      localRefreshProgressThread.a();
    }
  }
  
  public void a(int paramInt)
  {
    Handler localHandler = this.c;
    if (localHandler != null) {
      localHandler.post(new SlideProgressNotifier.1(this, paramInt));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.b;
    if ((localObject != null) && (!((SlideProgressNotifier.RefreshProgressThread)localObject).b()))
    {
      this.b.a();
      this.b = null;
    }
    a(paramInt3);
    this.b = new SlideProgressNotifier.RefreshProgressThread(paramInt1, paramInt2, paramInt3, this);
    this.b.start();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("beginMerge totalDuration=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" totalProgress = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" startProgress=");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("SlideProgressNotifier", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.getString(2131897389));
    ((StringBuilder)localObject).append("0%");
    super.a(paramInt1, ((StringBuilder)localObject).toString(), 0);
    if (this.d != null) {
      this.d.setOnKeyListener(this);
    }
    localObject = this.b;
    if ((localObject != null) && (!((SlideProgressNotifier.RefreshProgressThread)localObject).b()))
    {
      this.b.a();
      this.b = null;
    }
    this.b = new SlideProgressNotifier.RefreshProgressThread(paramInt2, paramInt3, paramInt4, this);
    this.b.start();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" beginTask totalDuration=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" totalProgress = ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" startProgress=");
      ((StringBuilder)localObject).append(paramInt4);
      QLog.d("SlideProgressNotifier", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      SlideShowPhotoListManager.a().k();
      paramDialogInterface = this.i;
      if (paramDialogInterface != null) {
        paramDialogInterface.a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier
 * JD-Core Version:    0.7.0.1
 */