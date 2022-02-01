package com.tencent.mobileqq.activity.selectable;

import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.core.helper.TopGestureTouchEventListener;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelListener;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public final class ChatPieSelectableHelper
  implements OnFinishListener, TopGestureTouchEventListener, ILifeCycleHelper, PanelListener, OnSelectListener
{
  private static final int a = ViewUtils.dpToPx(50.0F);
  private static int b = -1;
  private final BaseChatPie c;
  private boolean d;
  private long e = -1L;
  private int f;
  private int g = -1;
  private int h = -1;
  private boolean i;
  private final int[] j = new int[2];
  
  public ChatPieSelectableHelper(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    if (b == -1)
    {
      int k = ViewConfiguration.get(paramBaseChatPie.e).getScaledTouchSlop();
      b = k * k;
    }
    paramBaseChatPie.bv().d().a(this);
    paramBaseChatPie.bv().d().a(this);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    c(paramMotionEvent);
  }
  
  public void a(@NonNull SelectableDelegate paramSelectableDelegate)
  {
    boolean bool = paramSelectableDelegate.l();
    paramSelectableDelegate = this.c;
    if ((paramSelectableDelegate instanceof MultiForwardChatPie)) {
      paramSelectableDelegate = ((MultiForwardChatPie)paramSelectableDelegate).bB();
    } else {
      paramSelectableDelegate = paramSelectableDelegate.U;
    }
    if (paramSelectableDelegate != null) {
      paramSelectableDelegate.requestDisallowInterceptTouchEvent(bool);
    }
  }
  
  public boolean a()
  {
    if (AIOSelectableDelegateImpl.a().l())
    {
      AIOSelectableDelegateImpl.a().n();
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public int b(MotionEvent paramMotionEvent)
  {
    if (d()) {
      return 2;
    }
    return 0;
  }
  
  public void b()
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (localAIOSelectableDelegateImpl.l()) {
      localAIOSelectableDelegateImpl.n();
    }
  }
  
  public int bM_()
  {
    return 0;
  }
  
  public void c(MotionEvent paramMotionEvent)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (localAIOSelectableDelegateImpl.l())
    {
      if (!this.i) {
        return;
      }
      int k = paramMotionEvent.getAction();
      int m = (int)paramMotionEvent.getRawX();
      int n = (int)paramMotionEvent.getRawY();
      if (k == 0)
      {
        this.d = (localAIOSelectableDelegateImpl.d(m, n) ^ true);
        this.e = localAIOSelectableDelegateImpl.b;
        if (this.d)
        {
          this.g = m;
          this.h = n;
        }
        else
        {
          this.g = -1;
          this.h = -1;
        }
        this.f = 0;
        return;
      }
      if (k == 2)
      {
        if ((this.d) && (Math.pow(this.g - m, 2.0D) + Math.pow(this.h - n, 2.0D) > b))
        {
          this.f = 2;
          if (QLog.isColorLevel()) {
            QLog.d("ChatPieSelectableHelper", 0, "detect scrolling.");
          }
        }
      }
      else if (((k == 1) || (k == 3)) && (this.d))
      {
        if (this.f == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatPieSelectableHelper", 0, "detect taping.");
          }
          long l1 = localAIOSelectableDelegateImpl.b;
          long l2 = this.e;
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
        this.f = 1;
        this.d = false;
        this.e = -1L;
      }
    }
  }
  
  public boolean d()
  {
    return AIOSelectableDelegateImpl.a().l();
  }
  
  public boolean d(int paramInt)
  {
    return (paramInt == 0) && (a());
  }
  
  public void e()
  {
    if (this.c.V != null)
    {
      if (ThemeUtil.isNowThemeIsNight(this.c.d, false, null))
      {
        this.c.V.o.b = 1;
        return;
      }
      if ("2101".equals(ThemeUtil.getCurrentThemeId()))
      {
        this.c.V.o.b = 2;
        return;
      }
      this.c.V.o.b = 0;
    }
  }
  
  public void e(int paramInt) {}
  
  public String getTag()
  {
    return "ChatPieSelectableHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7, 11, 14, 18, 16, 17, 22, 0 };
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 0)
    {
      AIOSelectableDelegateImpl localAIOSelectableDelegateImpl;
      if (paramInt != 7)
      {
        if (paramInt != 11)
        {
          if (paramInt != 14)
          {
            if (paramInt != 22) {
              switch (paramInt)
              {
              default: 
                return;
              case 18: 
                localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
                if ((!localAIOSelectableDelegateImpl.l()) || (localAIOSelectableDelegateImpl.i())) {
                  break;
                }
                View localView = localAIOSelectableDelegateImpl.t();
                if (localView == null) {
                  break;
                }
                localView.getLocationInWindow(this.j);
                if (this.j[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() < a + ImmersiveUtils.statusHeight)
                {
                  localAIOSelectableDelegateImpl.n();
                  return;
                }
                if ((this.c.X != null) && (this.c.X.getVisibility() == 0))
                {
                  paramInt = this.j[1];
                  this.c.X.getLocationInWindow(this.j);
                  if (paramInt > this.j[1])
                  {
                    localAIOSelectableDelegateImpl.n();
                    return;
                  }
                  localAIOSelectableDelegateImpl.a(this.c);
                  return;
                }
                localAIOSelectableDelegateImpl.a(this.c);
                return;
              case 16: 
              case 17: 
                localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
                if ((!localAIOSelectableDelegateImpl.l()) || (!localAIOSelectableDelegateImpl.i())) {
                  break;
                }
                localAIOSelectableDelegateImpl.j();
                return;
              }
            }
          }
          else
          {
            localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
            if (!localAIOSelectableDelegateImpl.l()) {
              return;
            }
            localAIOSelectableDelegateImpl.n();
          }
        }
        else
        {
          AIOSelectableDelegateImpl.a().b(this);
          this.i = false;
        }
      }
      else
      {
        localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
        localAIOSelectableDelegateImpl.a(this);
        this.i = true;
        if ((!localAIOSelectableDelegateImpl.l()) || (localAIOSelectableDelegateImpl.i())) {
          return;
        }
        localAIOSelectableDelegateImpl.a(this.c);
        return;
      }
    }
    e();
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    b();
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper
 * JD-Core Version:    0.7.0.1
 */