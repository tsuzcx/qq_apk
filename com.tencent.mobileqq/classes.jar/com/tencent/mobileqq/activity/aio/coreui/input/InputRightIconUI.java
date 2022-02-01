package com.tencent.mobileqq.activity.aio.coreui.input;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.helper.AIOZhituHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import java.util.Iterator;
import java.util.List;

public class InputRightIconUI
  implements View.OnTouchListener
{
  private final AIOContext a;
  private final QQAppInterface b;
  private View c;
  private ImageButton d;
  
  public InputRightIconUI(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
    this.b = paramAIOContext.a();
  }
  
  private void onClick(View paramView)
  {
    this.a.onClick(paramView);
    Object localObject = this.a.p().c().b();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext()) {
      if (((IOnRightIconClickListener)localIterator.next()).a(this.a, paramView)) {
        return;
      }
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IOnRightIconClickListener)((Iterator)localObject).next()).b(this.a, paramView);
    }
  }
  
  public View a()
  {
    return this.c;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    ImageButton localImageButton = this.d;
    if (localImageButton == null) {
      return false;
    }
    if (localImageButton.getLeft() <= paramFloat1)
    {
      if (this.d.getRight() < paramFloat1) {
        return true;
      }
      if (this.d.getTop() <= paramFloat2) {
        return this.d.getBottom() < paramFloat2;
      }
    }
    return true;
  }
  
  public ImageButton b()
  {
    return this.d;
  }
  
  public void c()
  {
    this.c = this.a.d(2131427979);
    this.d = ((ImageButton)this.a.d(2131427978));
    this.d.setOnTouchListener(this);
    AccessibilityUtil.a(this.d, new InputRightIconUI.1(this));
    AIOZhituHelper.a(this.b, this.d);
  }
  
  public boolean d()
  {
    View localView = this.c;
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.a(paramView, paramMotionEvent);
    Object localObject = this.a.p().c().c();
    if ((this.a.k() != 28) && (paramMotionEvent.getAction() == 0)) {
      ReportController.b(this.a.a(), "CliOper", "", "", "0X80094D1", "0X80094D1", 0, 0, "", "", "", "");
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((IOnRightIconTouchListener)((Iterator)localObject).next()).a(this.a, paramView, paramMotionEvent)) {
        return true;
      }
    }
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      onClick(this.d);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI
 * JD-Core Version:    0.7.0.1
 */