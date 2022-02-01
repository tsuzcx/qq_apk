package com.tencent.mobileqq.activity.aio;

import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.qphone.base.util.QLog;

public class AIOCheckBoxUtil
{
  public static void a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "BaseChatItemLayout onTouchEvent...down ");
      }
    }
    else
    {
      if (paramMotionEvent.getAction() == 2) {
        return;
      }
      if (paramMotionEvent.getAction() == 1)
      {
        paramView = paramView.findViewById(2131364547);
        int i;
        if ((paramView != null) && ((paramView instanceof CheckBox)) && (paramView.getVisibility() == 0)) {
          i = 1;
        } else {
          i = 0;
        }
        paramMotionEvent = AIOLongShotHelper.a();
        int j = i;
        if (paramMotionEvent != null)
        {
          j = i;
          if (paramMotionEvent.a()) {
            if ((paramView != null) && ((paramView instanceof CheckBox))) {
              j = 1;
            } else {
              j = 0;
            }
          }
        }
        if (j != 0)
        {
          paramView = (CheckBox)paramView;
          paramView.setChecked(paramView.isChecked() ^ true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOCheckBoxUtil
 * JD-Core Version:    0.7.0.1
 */