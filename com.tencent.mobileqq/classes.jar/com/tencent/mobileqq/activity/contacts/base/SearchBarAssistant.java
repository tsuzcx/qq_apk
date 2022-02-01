package com.tencent.mobileqq.activity.contacts.base;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class SearchBarAssistant
  implements View.OnClickListener
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  static
  {
    jdField_a_of_type_JavaLangString = SearchBarAssistant.class.getSimpleName();
  }
  
  public SearchBarAssistant(BaseActivity paramBaseActivity, int paramInt, View paramView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_Int = paramInt;
    paramBaseActivity = paramView.findViewById(2131377607);
    IphoneTitleBarActivity.setLayerType(paramBaseActivity);
    paramView = paramBaseActivity.findViewById(2131363942);
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramBaseActivity.findViewById(2131366452));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBaseActivity.findViewById(2131380584));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(SearchEntryConfigManager.b());
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    } while ((TextUtils.isEmpty(paramQQAppInterface)) || (paramQQAppInterface.equals(SearchConfigManager.curUin)));
    SearchConfigManager.isConfigLoaded = false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1) {
      PADetailReportUtil.a().a();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 2;
    switch (paramView.getId())
    {
    }
    long l;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onClick() time stamp = " + (l - this.jdField_a_of_type_Long));
      }
    } while (Math.abs(l - this.jdField_a_of_type_Long) < 1500L);
    if (this.jdField_a_of_type_Int == 2) {}
    for (;;)
    {
      this.jdField_a_of_type_Long = l;
      FrameHelperActivity.c(false);
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localBaseActivity == null) {
        break;
      }
      UniteSearchReportController.a(null, i, 0, "0X8009D15", 0, 0, null, null);
      UniteSearchActivity.a(localBaseActivity, null, this.jdField_a_of_type_Int, i);
      break;
      if (this.jdField_a_of_type_Int == 1) {
        i = 1;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.SearchBarAssistant
 * JD-Core Version:    0.7.0.1
 */