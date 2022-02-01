package com.tencent.mobileqq.activity.selectable;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;

public final class CommonSelectableHelper
  implements ILifeCycleHelper, OnSelectListener
{
  private static final int a = ViewUtils.dpToPx(50.0F);
  private static int b = -1;
  private boolean c;
  private long d = -1L;
  private int e;
  private int f = -1;
  private int g = -1;
  private boolean h;
  private final int[] i = new int[2];
  private final WeakReference<BaseFragment> j;
  
  public CommonSelectableHelper(BaseFragment paramBaseFragment)
  {
    this.j = new WeakReference(paramBaseFragment);
    if (b == -1)
    {
      int k = ViewConfiguration.get(paramBaseFragment.getBaseActivity()).getScaledTouchSlop();
      b = k * k;
    }
  }
  
  private void a(View paramView, BaseFragment paramBaseFragment)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if ((localAIOSelectableDelegateImpl.l()) && (!localAIOSelectableDelegateImpl.i()))
    {
      View localView = localAIOSelectableDelegateImpl.t();
      if (localView != null)
      {
        localView.getLocationInWindow(this.i);
        if (this.i[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() < a + ImmersiveUtils.statusHeight)
        {
          localAIOSelectableDelegateImpl.n();
          return;
        }
        if (paramView != null)
        {
          paramBaseFragment = this.i;
          int k = paramBaseFragment[1];
          paramView.getLocationInWindow(paramBaseFragment);
          if (k > this.i[1])
          {
            localAIOSelectableDelegateImpl.n();
            return;
          }
          localAIOSelectableDelegateImpl.a(paramView);
          return;
        }
        if (Build.VERSION.SDK_INT >= 17)
        {
          paramView = new DisplayMetrics();
          paramBaseFragment.getBaseActivity().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
          localAIOSelectableDelegateImpl.d(paramView.heightPixels);
          return;
        }
        localAIOSelectableDelegateImpl.h();
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (localAIOSelectableDelegateImpl.l())
    {
      if (!this.h) {
        return;
      }
      int k = paramMotionEvent.getAction();
      int m = (int)paramMotionEvent.getRawX();
      int n = (int)paramMotionEvent.getRawY();
      if (k == 0)
      {
        this.c = (localAIOSelectableDelegateImpl.d(m, n) ^ true);
        this.d = localAIOSelectableDelegateImpl.b;
        if (this.c)
        {
          this.f = m;
          this.g = n;
        }
        else
        {
          this.f = -1;
          this.g = -1;
        }
        this.e = 0;
        return;
      }
      if (k == 2)
      {
        if ((this.c) && (Math.pow(this.f - m, 2.0D) + Math.pow(this.g - n, 2.0D) > b))
        {
          this.e = 2;
          if (QLog.isColorLevel()) {
            QLog.d("ChatPieSelectableHelper", 0, "detect scrolling.");
          }
        }
      }
      else if (((k == 1) || (k == 3)) && (this.c))
      {
        if (this.e == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatPieSelectableHelper", 0, "detect taping.");
          }
          long l1 = localAIOSelectableDelegateImpl.b;
          long l2 = this.d;
          if ((l2 != -1L) && (l1 != -1L))
          {
            if (l2 == l1) {
              localAIOSelectableDelegateImpl.n();
            }
          }
          else {
            localAIOSelectableDelegateImpl.n();
          }
        }
        this.e = 1;
        this.c = false;
        this.d = -1L;
      }
    }
  }
  
  public void a(@NonNull SelectableDelegate paramSelectableDelegate)
  {
    boolean bool = paramSelectableDelegate.l();
    paramSelectableDelegate = (BaseFragment)this.j.get();
    if ((paramSelectableDelegate instanceof ChatHistoryC2CAllFragment)) {
      paramSelectableDelegate = ((ChatHistoryC2CAllFragment)paramSelectableDelegate).s;
    } else if ((paramSelectableDelegate instanceof ChatHistoryTroopAllFragment)) {
      paramSelectableDelegate = ((ChatHistoryTroopAllFragment)paramSelectableDelegate).t;
    } else if ((paramSelectableDelegate instanceof ChatHistoryBubbleListForTroopFragment)) {
      paramSelectableDelegate = ((ChatHistoryBubbleListForTroopFragment)paramSelectableDelegate).b;
    } else {
      paramSelectableDelegate = null;
    }
    if (paramSelectableDelegate != null) {
      paramSelectableDelegate.requestDisallowInterceptTouchEvent(bool);
    }
  }
  
  public String getTag()
  {
    return "ChatPieSelectableHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7, 11, 14, 18, 16, 17 };
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject2 = (BaseFragment)this.j.get();
    Object localObject1;
    if ((localObject2 instanceof ChatHistoryC2CAllFragment)) {
      localObject1 = ((ChatHistoryC2CAllFragment)localObject2).X;
    } else {
      localObject1 = null;
    }
    if (paramInt != 7)
    {
      if (paramInt != 11)
      {
        if (paramInt != 14)
        {
          switch (paramInt)
          {
          default: 
            return;
          case 18: 
            a((View)localObject1, (BaseFragment)localObject2);
            return;
          }
          localObject1 = AIOSelectableDelegateImpl.a();
          if ((((AIOSelectableDelegateImpl)localObject1).t() != null) && (((AIOSelectableDelegateImpl)localObject1).l()) && (((AIOSelectableDelegateImpl)localObject1).i())) {
            ((AIOSelectableDelegateImpl)localObject1).j();
          }
        }
        else
        {
          localObject1 = AIOSelectableDelegateImpl.a();
          if (((SelectableDelegate)localObject1).l()) {
            ((SelectableDelegate)localObject1).n();
          }
        }
      }
      else
      {
        AIOSelectableDelegateImpl.a().b(this);
        this.h = false;
      }
    }
    else
    {
      localObject2 = AIOSelectableDelegateImpl.a();
      ((AIOSelectableDelegateImpl)localObject2).a(this);
      this.h = true;
      if ((((AIOSelectableDelegateImpl)localObject2).t() != null) && (((AIOSelectableDelegateImpl)localObject2).l()) && (!((AIOSelectableDelegateImpl)localObject2).i())) {
        ((AIOSelectableDelegateImpl)localObject2).a((View)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonSelectableHelper
 * JD-Core Version:    0.7.0.1
 */