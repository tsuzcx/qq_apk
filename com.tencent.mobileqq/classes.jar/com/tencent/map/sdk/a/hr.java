package com.tencent.map.sdk.a;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

public final class hr
  extends ExploreByTouchHelper
  implements he
{
  public List<hq> a = new ArrayList();
  public List<hq> b = new ArrayList();
  public List<hq> c = new ArrayList();
  public pn d;
  private Handler e = new Handler();
  
  public hr(View paramView, pn parampn)
  {
    super(paramView);
    this.d = parampn;
    this.d.az.a(this);
  }
  
  public final void a()
  {
    this.e.post(new hr.1(this));
  }
  
  public final void b()
  {
    this.d.az.a(this);
    a();
  }
  
  protected final int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.a;
    int i;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.a;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        i = this.a.size() - 1;
        localObject = (hq)this.a.get(i);
        if (((localObject instanceof hs)) && (((hq)localObject).a().contains((int)paramFloat1, (int)paramFloat2))) {}
      }
      else
      {
        i = -1;
      }
      if (i == -1)
      {
        i = 0;
        while (i < this.a.size())
        {
          if (((hq)this.a.get(i)).a().contains((int)paramFloat1, (int)paramFloat2)) {
            break label158;
          }
          i += 1;
        }
      }
    }
    else
    {
      i = -1;
    }
    label158:
    if (i == -1) {
      return -2147483648;
    }
    return i;
  }
  
  protected final void getVisibleVirtualViews(List<Integer> paramList)
  {
    int i = 0;
    while (i < this.a.size())
    {
      paramList.add(Integer.valueOf(i));
      i += 1;
    }
  }
  
  protected final boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool = false;
    if (paramInt2 == 16)
    {
      if (paramInt1 >= this.a.size()) {
        return false;
      }
      paramBundle = (hq)this.a.get(paramInt1);
      if (paramBundle == null) {
        return false;
      }
      invalidateVirtualView(paramInt1);
      bool = true;
      sendEventForVirtualView(paramInt1, 1);
      paramBundle.c();
    }
    return bool;
  }
  
  protected final void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramInt >= this.a.size())
    {
      paramAccessibilityEvent.getText().add("");
      return;
    }
    hq localhq = (hq)this.a.get(paramInt);
    if (localhq != null)
    {
      paramAccessibilityEvent.getText().add(localhq.b());
      return;
    }
    throw new IllegalArgumentException("Invalid virtual view id");
  }
  
  protected final void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if (paramInt >= this.a.size())
    {
      paramAccessibilityNodeInfoCompat.setText("");
      paramAccessibilityNodeInfoCompat.setBoundsInParent(new Rect());
      return;
    }
    hq localhq = (hq)this.a.get(paramInt);
    if (localhq != null)
    {
      paramAccessibilityNodeInfoCompat.setText(localhq.b());
      paramAccessibilityNodeInfoCompat.setBoundsInParent(localhq.a());
      paramAccessibilityNodeInfoCompat.addAction(16);
      return;
    }
    throw new IllegalArgumentException("Invalid virtual view id");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.hr
 * JD-Core Version:    0.7.0.1
 */