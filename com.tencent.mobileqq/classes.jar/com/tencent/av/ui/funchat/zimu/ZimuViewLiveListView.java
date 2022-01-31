package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;

public class ZimuViewLiveListView
  extends ListView
{
  public ZimuViewLiveListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ZimuViewLiveListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ZimuViewLiveListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    Object localObject;
    if (bool)
    {
      localObject = (View)getParent();
      EditText localEditText = (EditText)((View)localObject).findViewById(2131365947);
      if (!((ZimuViewLive)((View)localObject).getParent()).a()) {
        break label71;
      }
      localEditText.clearFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(localEditText.getWindowToken(), 0);
    }
    label71:
    do
    {
      return bool;
      localObject = (AVActivity)getContext();
    } while (((AVActivity)localObject).a.a == null);
    ((AVActivity)localObject).a.e = -1;
    ((AVActivity)localObject).a.a.onTouchEvent(paramMotionEvent);
    return bool;
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewLiveListView
 * JD-Core Version:    0.7.0.1
 */