package com.tencent.biz.qqstory.playvideo;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.InputMethodLinearLayout.onSizeChangeListenner;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.HashMap;

public class QQStoryCommentDialog
  extends ReportDialog
  implements View.OnClickListener, TextView.OnEditorActionListener, InputMethodLinearLayout.onSizeChangeListenner
{
  protected static final HashMap<String, String> a;
  protected EditText a;
  protected QQStoryCommentDialog.OnSendListener a;
  protected String a;
  protected boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public int a(CharSequence paramCharSequence)
  {
    int i = 0;
    int k = 0;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    int m;
    int j;
    do
    {
      return k;
      m = paramCharSequence.length();
      j = 0;
      k = i;
    } while (j >= m);
    if (StringUtil.c(paramCharSequence.charAt(j))) {
      i += 3;
    }
    for (;;)
    {
      j += 1;
      break;
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      dismiss();
    }
  }
  
  public void dismiss()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
      if (!TextUtils.isEmpty(str)) {
        jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, str);
      }
    }
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryCommentDialog$OnSendListener != null))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryCommentDialog$OnSendListener.a(this, paramTextView.getText().toString());
      return true;
    }
    return false;
  }
  
  public void show()
  {
    String str = (String)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaLangString);
    jdField_a_of_type_JavaUtilHashMap.clear();
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
    }
    this.jdField_a_of_type_Boolean = false;
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryCommentDialog
 * JD-Core Version:    0.7.0.1
 */