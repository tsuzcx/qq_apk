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
  protected static final HashMap<String, String> a = new HashMap();
  protected EditText b;
  protected String c;
  protected boolean d;
  protected QQStoryCommentDialog.OnSendListener e;
  
  public int a(CharSequence paramCharSequence)
  {
    boolean bool = TextUtils.isEmpty(paramCharSequence);
    int j = 0;
    if (bool) {
      return 0;
    }
    int k = paramCharSequence.length();
    int i = 0;
    while (j < k)
    {
      if (StringUtil.isChinese(paramCharSequence.charAt(j))) {
        i += 3;
      } else {
        i += 1;
      }
      j += 1;
    }
    return i;
  }
  
  public void dismiss()
  {
    if (!this.d)
    {
      String str = this.b.getEditableText().toString();
      if (!TextUtils.isEmpty(str)) {
        a.put(this.c, str);
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
    boolean bool = true;
    if (4 == paramInt)
    {
      QQStoryCommentDialog.OnSendListener localOnSendListener = this.e;
      if (localOnSendListener != null)
      {
        this.d = true;
        localOnSendListener.a(this, paramTextView.getText().toString());
        break label47;
      }
    }
    bool = false;
    label47:
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
  
  public void onSizeChange(boolean paramBoolean)
  {
    if (!paramBoolean) {
      dismiss();
    }
  }
  
  public void show()
  {
    String str = (String)a.get(this.c);
    a.clear();
    if (!TextUtils.isEmpty(str))
    {
      this.b.setText(str);
      this.b.setSelection(str.length());
    }
    this.d = false;
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryCommentDialog
 * JD-Core Version:    0.7.0.1
 */