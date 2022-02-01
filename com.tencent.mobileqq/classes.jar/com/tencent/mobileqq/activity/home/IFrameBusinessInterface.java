package com.tencent.mobileqq.activity.home;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import java.util.HashMap;
import mqq.app.AppRuntime;

public abstract interface IFrameBusinessInterface
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(FrameFragment paramFrameFragment);
  
  public abstract void a(FrameFragment paramFrameFragment, int paramInt1, int paramInt2);
  
  public abstract void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2);
  
  public abstract void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener);
  
  public abstract void a(FrameFragment paramFrameFragment, String paramString);
  
  public abstract void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager);
  
  public abstract void a(HashMap<String, View> paramHashMap, boolean paramBoolean);
  
  public abstract void a(AppRuntime paramAppRuntime, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt);
  
  public abstract boolean a(FrameFragment paramFrameFragment);
  
  public abstract boolean a(AppRuntime paramAppRuntime);
  
  public abstract void b();
  
  public abstract void b(FrameFragment paramFrameFragment);
  
  public abstract void b(FrameFragment paramFrameFragment, String paramString);
  
  public abstract void c(FrameFragment paramFrameFragment);
  
  public abstract void d(FrameFragment paramFrameFragment);
  
  public abstract void e(FrameFragment paramFrameFragment);
  
  public abstract void f(FrameFragment paramFrameFragment);
  
  public abstract void g(FrameFragment paramFrameFragment);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.IFrameBusinessInterface
 * JD-Core Version:    0.7.0.1
 */