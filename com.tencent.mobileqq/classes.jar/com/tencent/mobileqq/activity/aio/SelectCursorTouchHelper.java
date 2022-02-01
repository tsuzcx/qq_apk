package com.tencent.mobileqq.activity.aio;

import android.os.SystemClock;
import android.text.Layout;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.activity.selectable.SelectableDelegate;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class SelectCursorTouchHelper
{
  private SelectCursorTouchHelper.SelectCursorTouchHelperListener a;
  private SelectableDelegate b;
  
  public SelectCursorTouchHelper(@NonNull SelectCursorTouchHelper.SelectCursorTouchHelperListener paramSelectCursorTouchHelperListener, @NonNull SelectableDelegate paramSelectableDelegate)
  {
    this.a = paramSelectCursorTouchHelperListener;
    this.b = paramSelectableDelegate;
  }
  
  private int a()
  {
    Object localObject = AIOSelectableDelegateImpl.a().t();
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatItemLayout", 2, "getOneCharWidth");
      }
      return (int)Layout.getDesiredWidth("大", ((TextView)localObject).getPaint());
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatItemLayout", 2, "getOneCharWidth default");
    }
    return BaseChatItemLayout.a * 3;
  }
  
  public static MotionEvent a(int paramInt, float paramFloat1, float paramFloat2)
  {
    return MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), paramInt, paramFloat1, paramFloat2, 0);
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = this.b.b((int)paramFloat1, (int)paramFloat2);
    this.b.a(false);
    Object localObject = a(0, this.a.b(paramInt1), this.a.c(paramInt1));
    ((MotionEvent)localObject).setSource(-1);
    this.a.onTouchEvent((MotionEvent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatItemLayout", 2, new Object[] { "touchIndex=", Integer.valueOf(i), " cursorType=", Integer.valueOf(paramInt1) });
    }
    if (i == -1)
    {
      localObject = a(3, paramFloat1, paramFloat2);
      ((MotionEvent)localObject).setSource(-1);
      this.a.onTouchEvent((MotionEvent)localObject);
      this.b.a(true);
      return i;
    }
    if (paramInt1 == 1) {
      localObject = TextUtils.getNeoTextAfter(this.b.b(), i, paramInt2, true);
    } else {
      localObject = TextUtils.getNeoTextBefore(this.b.b(), i, paramInt2);
    }
    if (((String)localObject).length() < paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatItemLayout", 2, new Object[] { "cutString is small than request cutString=", localObject });
      }
      localObject = a(3, paramFloat1, paramFloat2);
      ((MotionEvent)localObject).setSource(-1);
      this.a.onTouchEvent((MotionEvent)localObject);
      this.b.a(true);
      if (paramInt1 == 1) {
        return a(paramFloat1 + a(), paramFloat2, 2, paramInt2);
      }
      return -1;
    }
    this.a.a(i, ((String)localObject).length(), paramInt1);
    localObject = a(2, paramFloat1, paramFloat2);
    ((MotionEvent)localObject).setSource(-1);
    this.a.onTouchEvent((MotionEvent)localObject);
    localObject = a(1, paramFloat1, paramFloat2);
    ((MotionEvent)localObject).setSource(-1);
    this.a.onTouchEvent((MotionEvent)localObject);
    this.b.a(true);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.SelectCursorTouchHelper
 * JD-Core Version:    0.7.0.1
 */