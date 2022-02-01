package com.tencent.mobileqq.activity.miniaio;

import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class MiniPie$EnterForSend
  implements View.OnKeyListener, TextView.OnEditorActionListener
{
  private MiniPie$EnterForSend(MiniPie paramMiniPie) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 0))
    {
      if (QLog.isColorLevel())
      {
        paramKeyEvent = this.a.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("on delete, start: ");
        localStringBuilder.append(this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart());
        localStringBuilder.append(", end: ");
        localStringBuilder.append(this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionEnd());
        localStringBuilder.append(", span: ");
        localStringBuilder.append(this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131373876));
        QLog.i(paramKeyEvent, 2, localStringBuilder.toString());
      }
      if ((this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart() == 0) && (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionEnd() == 0))
      {
        if (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131373876) != null)
        {
          paramKeyEvent = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getCompoundDrawables();
          this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(paramKeyEvent[0], null, paramKeyEvent[2], paramKeyEvent[3]);
          this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131373876, null);
          this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
          this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMinHeight(AIOUtils.b(36.0F, paramView.getResources()));
          this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
          return true;
        }
      }
      else if ((this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131373876) != null) && (Build.VERSION.SDK_INT >= 21) && (AIOUtils.b(36.0F, paramView.getResources()) == this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMinHeight()))
      {
        paramInt = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMeasuredHeight();
        this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMinHeight(paramInt);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie.EnterForSend
 * JD-Core Version:    0.7.0.1
 */