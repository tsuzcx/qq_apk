package com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout.DispatchTouchEventListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVideoLayoutDispatchTouchListener;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/WSComboVerticalVideoProgressManager;", "", "()V", "mComboBottomProgressContainerRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/WSVerticalVideoRelativeLayout;", "mProgressBarRef", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/WSPlayerControlBar;", "mVideoPageProgressParentViewRef", "Landroid/view/ViewGroup;", "wsVideoLayoutDispatchTouchListener", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/WSVideoLayoutDispatchTouchListener;", "getWsVideoLayoutDispatchTouchListener", "()Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/WSVideoLayoutDispatchTouchListener;", "setWsVideoLayoutDispatchTouchListener", "(Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/WSVideoLayoutDispatchTouchListener;)V", "addProgressBarToBottomBar", "", "progressBar", "addToBottomBar", "clear", "initTouchEvent", "initVideoProgressContainer", "container", "isDragging", "", "recoverProgressToVideoPage", "removeFromVideoPage", "removeProgressBarFromComboBottomBar", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboVerticalVideoProgressManager
{
  public static final WSComboVerticalVideoProgressManager.Companion a = new WSComboVerticalVideoProgressManager.Companion(null);
  @NotNull
  private static final Lazy f = LazyKt.lazy((Function0)WSComboVerticalVideoProgressManager.Companion.Instance.2.INSTANCE);
  private WeakReference<WSVerticalVideoRelativeLayout> b;
  private WeakReference<WSPlayerControlBar> c;
  private WeakReference<ViewGroup> d;
  @Nullable
  private WSVideoLayoutDispatchTouchListener e;
  
  private final void b(WSPlayerControlBar paramWSPlayerControlBar)
  {
    if ((paramWSPlayerControlBar.getParent() instanceof FrameLayout))
    {
      Object localObject = paramWSPlayerControlBar.getParent();
      if (localObject != null)
      {
        localObject = (FrameLayout)localObject;
        ((FrameLayout)localObject).removeView((View)paramWSPlayerControlBar);
        this.d = new WeakReference(localObject);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
    }
  }
  
  private final void c(WSPlayerControlBar paramWSPlayerControlBar)
  {
    if (paramWSPlayerControlBar.getParent() != null) {
      return;
    }
    this.c = new WeakReference(paramWSPlayerControlBar);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSComboVerticalVideoProgressManager][replaceCurrProgress] mProgressBar: ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", mParent: ");
    ((StringBuilder)localObject).append(this.d);
    WSLog.a("WSComboVerticalVideoProgressManager", ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null)
    {
      localObject = (WSVerticalVideoRelativeLayout)((WeakReference)localObject).get();
      if (localObject != null) {
        ((WSVerticalVideoRelativeLayout)localObject).addView((View)paramWSPlayerControlBar);
      }
    }
  }
  
  private final void f()
  {
    Object localObject = this.b;
    if (localObject != null) {
      localObject = (WSVerticalVideoRelativeLayout)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    this.e = new WSVideoLayoutDispatchTouchListener((WSVerticalVideoRelativeLayout)localObject);
    localObject = this.b;
    if (localObject != null)
    {
      localObject = (WSVerticalVideoRelativeLayout)((WeakReference)localObject).get();
      if (localObject != null) {
        ((WSVerticalVideoRelativeLayout)localObject).setDispatchTouchEventListener((WSVerticalVideoRelativeLayout.DispatchTouchEventListener)this.e);
      }
    }
  }
  
  private final void g()
  {
    Object localObject1 = this.b;
    StringBuilder localStringBuilder = null;
    if (localObject1 != null) {
      localObject1 = (WSVerticalVideoRelativeLayout)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    int i;
    if (localObject1 != null) {
      i = ((WSVerticalVideoRelativeLayout)localObject1).getChildCount();
    } else {
      i = 0;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[WSComboVerticalVideoProgressManager][recoverLastProgress] mVerticalVideoContentContainer.childCount: ");
    ((StringBuilder)localObject2).append(i);
    WSLog.a("WSComboVerticalVideoProgressManager", ((StringBuilder)localObject2).toString());
    if (i > 0)
    {
      localObject2 = this.c;
      if (localObject2 != null)
      {
        localObject2 = (WSPlayerControlBar)((WeakReference)localObject2).get();
        if (localObject2 != null)
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "mProgressBarRef?.get() ?: return");
          if (localObject1 != null) {
            ((WSVerticalVideoRelativeLayout)localObject1).removeView((View)localObject2);
          }
          WeakReference localWeakReference = this.d;
          localObject1 = localStringBuilder;
          if (localWeakReference != null) {
            localObject1 = (ViewGroup)localWeakReference.get();
          }
          if (localObject1 != null)
          {
            i = ((ViewGroup)localObject1).getChildCount();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[WSComboVerticalVideoProgressManager][recoverLastProgress] mParent.childCount: ");
            localStringBuilder.append(i);
            WSLog.a("WSComboVerticalVideoProgressManager", localStringBuilder.toString());
            if (i > 0) {
              return;
            }
            ((ViewGroup)localObject1).addView((View)localObject2);
          }
        }
      }
    }
  }
  
  public final void a()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    localObject = this.c;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    localObject = this.d;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    localObject = this.e;
    if (localObject != null) {
      ((WSVideoLayoutDispatchTouchListener)localObject).a();
    }
  }
  
  public final void a(@NotNull WSPlayerControlBar paramWSPlayerControlBar)
  {
    Intrinsics.checkParameterIsNotNull(paramWSPlayerControlBar, "progressBar");
    WSLog.a("WSComboVerticalVideoProgressManager", "[WSComboVerticalVideoProgressManager][replaceProgressBar]");
    WSVideoLayoutDispatchTouchListener localWSVideoLayoutDispatchTouchListener = this.e;
    if (localWSVideoLayoutDispatchTouchListener != null) {
      localWSVideoLayoutDispatchTouchListener.a(paramWSPlayerControlBar);
    }
    b(paramWSPlayerControlBar);
    c(paramWSPlayerControlBar);
  }
  
  public final void a(@NotNull WSVerticalVideoRelativeLayout paramWSVerticalVideoRelativeLayout)
  {
    Intrinsics.checkParameterIsNotNull(paramWSVerticalVideoRelativeLayout, "container");
    this.b = new WeakReference(paramWSVerticalVideoRelativeLayout);
    f();
  }
  
  public final boolean b()
  {
    WSVideoLayoutDispatchTouchListener localWSVideoLayoutDispatchTouchListener = this.e;
    if (localWSVideoLayoutDispatchTouchListener != null) {
      return localWSVideoLayoutDispatchTouchListener.b();
    }
    return false;
  }
  
  public final void c()
  {
    WSLog.a("WSComboVerticalVideoProgressManager", "[WSComboVerticalVideoProgressManager][removeProgress]");
    g();
  }
  
  public final void d()
  {
    WSLog.a("WSComboVerticalVideoProgressManager", "[WSComboVerticalVideoProgressManager][replaceProgressBar]");
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (WSPlayerControlBar)((WeakReference)localObject).get();
      if (localObject != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject, "mProgressBarRef?.get() ?: return");
        a((WSPlayerControlBar)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboVerticalVideoProgressManager
 * JD-Core Version:    0.7.0.1
 */