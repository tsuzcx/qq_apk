package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.mm.ui.f;

public class j
  extends PopupWindow
{
  private View.OnTouchListener a;
  private Context b = null;
  
  public j(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
    super.setBackgroundDrawable(null);
    setContentView(new j.a(this, this.b));
  }
  
  public j(View paramView)
  {
    super(paramView);
    super.setBackgroundDrawable(null);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dismiss exception, e = ");
      localStringBuilder.append(localException.getMessage());
      f.e("MicroMsg.MMPopupWindow", localStringBuilder.toString(), new Object[0]);
    }
  }
  
  public Drawable getBackground()
  {
    View localView = getContentView();
    if (localView == null) {
      return null;
    }
    if ((localView instanceof j.a)) {
      return localView.getBackground();
    }
    return null;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    View localView = getContentView();
    if (localView == null) {
      return;
    }
    Object localObject1 = localView.getContext();
    if ((localView instanceof j.a))
    {
      localView.setBackgroundDrawable(paramDrawable);
      return;
    }
    Object localObject2 = localView.getLayoutParams();
    int i = -2;
    if ((localObject2 == null) || (((ViewGroup.LayoutParams)localObject2).height != -2)) {
      i = -1;
    }
    localObject1 = new j.a(this, (Context)localObject1);
    localObject2 = new FrameLayout.LayoutParams(-1, i);
    ((j.a)localObject1).setBackgroundDrawable(paramDrawable);
    ((j.a)localObject1).addView(localView, (ViewGroup.LayoutParams)localObject2);
    super.setContentView((View)localObject1);
  }
  
  public void setContentView(View paramView)
  {
    Object localObject = getContentView();
    if (localObject == null)
    {
      super.setContentView(paramView);
    }
    else if ((localObject instanceof j.a))
    {
      localObject = (j.a)localObject;
      ((j.a)localObject).removeAllViews();
      if (paramView == null)
      {
        super.setContentView((View)localObject);
        return;
      }
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      int i = -2;
      if ((localLayoutParams == null) || (localLayoutParams.height != -2)) {
        i = -1;
      }
      ((j.a)localObject).addView(paramView, new FrameLayout.LayoutParams(-1, i));
      super.setContentView((View)localObject);
      return;
    }
    super.setContentView(paramView);
  }
  
  public void setTouchInterceptor(View.OnTouchListener paramOnTouchListener)
  {
    this.a = paramOnTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.j
 * JD-Core Version:    0.7.0.1
 */