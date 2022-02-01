package com.tencent.biz.pubaccount.readinjoy.comment.topic;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule.UserLevelInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;

public class RIJCommentTopicUi
  implements TextWatcher, View.OnClickListener
{
  private static String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131718162);
  private final View jdField_a_of_type_AndroidViewView;
  private final EditText jdField_a_of_type_AndroidWidgetEditText;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  
  public RIJCommentTopicUi(View paramView, EditText paramEditText, Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    if (a())
    {
      b();
      QLog.d("RIJCommentTopicUi", 1, "init topic switch on");
      return;
    }
    paramView.setVisibility(8);
    QLog.d("RIJCommentTopicUi", 1, "init topic switch off");
  }
  
  private void a(CharSequence paramCharSequence)
  {
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    if ((a(paramCharSequence) | RIJCommentTopicUtil.a(paramCharSequence)))
    {
      this.jdField_a_of_type_Boolean = true;
      int i = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i);
    }
  }
  
  private static boolean a()
  {
    boolean bool1 = ReadInJoyHelper.g();
    boolean bool2 = RIJUserLevelModule.a().a(11).isInLevelGrayList;
    QLog.d("RIJCommentTopicUi", 1, "isCommentTopicPublishSwitchOn: topicSwitchOn=" + bool1 + ", isInLevelGrayList=" + bool2);
    return (bool1) && (bool2);
  }
  
  private static boolean a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = 0;
    RIJCommentTopicSpanForPublisher[] arrayOfRIJCommentTopicSpanForPublisher = (RIJCommentTopicSpanForPublisher[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), RIJCommentTopicSpanForPublisher.class);
    if ((arrayOfRIJCommentTopicSpanForPublisher != null) && (arrayOfRIJCommentTopicSpanForPublisher.length > 0))
    {
      int j = arrayOfRIJCommentTopicSpanForPublisher.length;
      while (i < j)
      {
        paramSpannableStringBuilder.removeSpan(arrayOfRIJCommentTopicSpanForPublisher[i]);
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (b()) {
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    }
    RIJUserLevelModule.a().a(11, new RIJCommentTopicUi.1(this));
  }
  
  private static boolean b()
  {
    boolean bool = RIJUserLevelModule.a().a(11, false);
    QLog.d("RIJCommentTopicUi", 1, "hasTopicPrivilege: hasPrivilege=" + bool);
    return bool;
  }
  
  private void c()
  {
    if (!b())
    {
      QQToast.a(this.jdField_a_of_type_AndroidWidgetEditText.getContext(), 0, jdField_a_of_type_JavaLangString, 0).a();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.getText().replace(this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart(), this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd(), "#");
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    while (TextUtils.isEmpty(paramEditable)) {
      return;
    }
    a(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    c();
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUi
 * JD-Core Version:    0.7.0.1
 */