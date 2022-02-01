package com.tencent.aelight.camera.ae.flashshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.aelight.camera.ae.IQIMCameraLifeCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/flashshow/FlashShowCaptureViewManager$cameraLifeCallbackDelegate$2$1", "Lcom/tencent/aelight/camera/ae/IQIMCameraLifeCallback;", "finish", "", "onActivityPause", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onActivityResume", "onActivityStart", "onActivityStop", "onBackPressed", "", "onConfigurationChanged", "width", "height", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "onDestroy", "onDestroyView", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "b", "onNewIntent", "intent", "onSaveInstanceState", "outState", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "onWindowFocusChanged", "hasFocus", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class FlashShowCaptureViewManager$cameraLifeCallbackDelegate$2$1
  implements IQIMCameraLifeCallback
{
  public void a(int paramInt1, int paramInt2)
  {
    if (FlashShowCaptureViewManager.g(this.a.this$0)) {
      FlashShowCaptureViewManager.a(this.a.this$0).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    FlashShowCaptureViewManager.a(this.a.this$0).a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(@Nullable Intent paramIntent)
  {
    FlashShowCaptureViewManager.a(this.a.this$0).a(paramIntent);
  }
  
  public void a(@Nullable Bundle paramBundle)
  {
    FlashShowCaptureViewManager.a(this.a.this$0).a(paramBundle);
  }
  
  public boolean a(int paramInt, @Nullable KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if ((FlashShowCaptureViewManager.h(this.a.this$0)) && (FlashShowCaptureViewManager.c(this.a.this$0) != 2)) {
      return FlashShowCaptureViewManager.a(this.a.this$0).a(paramInt, paramKeyEvent, paramBoolean);
    }
    return false;
  }
  
  public boolean a(@Nullable MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if ((FlashShowCaptureViewManager.h(this.a.this$0)) && (FlashShowCaptureViewManager.c(this.a.this$0) != 2)) {
      return FlashShowCaptureViewManager.a(this.a.this$0).a(paramMotionEvent, paramBoolean);
    }
    return false;
  }
  
  public void ai()
  {
    if (FlashShowCaptureViewManager.h(this.a.this$0)) {
      FlashShowCaptureViewManager.a(this.a.this$0).ai();
    }
  }
  
  public void aj()
  {
    if (FlashShowCaptureViewManager.h(this.a.this$0)) {
      FlashShowCaptureViewManager.a(this.a.this$0).aj();
    }
  }
  
  public boolean ak()
  {
    if ((FlashShowCaptureViewManager.h(this.a.this$0)) && (FlashShowCaptureViewManager.c(this.a.this$0) != 2)) {
      return FlashShowCaptureViewManager.a(this.a.this$0).ak();
    }
    return false;
  }
  
  public void al()
  {
    FlashShowCaptureViewManager.a(this.a.this$0).al();
  }
  
  public void b(@Nullable Bundle paramBundle)
  {
    FlashShowCaptureViewManager.a(this.a.this$0).b(paramBundle);
  }
  
  public void e(boolean paramBoolean)
  {
    if (FlashShowCaptureViewManager.g(this.a.this$0)) {
      FlashShowCaptureViewManager.a(this.a.this$0).e(paramBoolean);
    }
  }
  
  @NotNull
  public View j()
  {
    FlashShowCaptureViewManager.a(this.a.this$0, true);
    View localView = FlashShowCaptureViewManager.a(this.a.this$0).j();
    Intrinsics.checkExpressionValueIsNotNull(localView, "cameraUnit.onCreateView()");
    return localView;
  }
  
  public void k()
  {
    if (FlashShowCaptureViewManager.h(this.a.this$0))
    {
      FlashShowCaptureViewManager.b(this.a.this$0, true);
      FlashShowCaptureViewManager.a(this.a.this$0).k();
    }
  }
  
  public void l()
  {
    if (FlashShowCaptureViewManager.i(this.a.this$0))
    {
      FlashShowCaptureViewManager.b(this.a.this$0, false);
      FlashShowCaptureViewManager.a(this.a.this$0).l();
    }
  }
  
  public void m()
  {
    FlashShowCaptureViewManager.a(this.a.this$0).m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.FlashShowCaptureViewManager.cameraLifeCallbackDelegate.2.1
 * JD-Core Version:    0.7.0.1
 */