package com.tencent.mobileqq.activity.contacts.base;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class SearchBarAssistant
  implements View.OnClickListener
{
  public static final String a = "SearchBarAssistant";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public SearchBarAssistant(BaseActivity paramBaseActivity, int paramInt, View paramView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_Int = paramInt;
    paramBaseActivity = paramView.findViewById(2131377050);
    IphoneTitleBarActivity.setLayerType(paramBaseActivity);
    paramView = paramBaseActivity.findViewById(2131363868);
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramBaseActivity.findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBaseActivity.findViewById(2131379866));
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
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!paramQQAppInterface.equals(SearchConfigManager.curUin))) {
      SearchConfigManager.isConfigLoaded = false;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1) {
      ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).resetAttribute();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366333)
    {
      long l = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick() time stamp = ");
        localStringBuilder.append(l - this.jdField_a_of_type_Long);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (Math.abs(l - this.jdField_a_of_type_Long) >= 1500L)
      {
        int j = this.jdField_a_of_type_Int;
        int i = 1;
        if (j == 2) {
          i = 2;
        }
        this.jdField_a_of_type_Long = l;
        FrameHelperActivity.b(false);
        localObject = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          UniteSearchReportController.a(null, i, 0, "0X8009D15", 0, 0, null, null);
          UniteSearchActivity.a((Activity)localObject, null, this.jdField_a_of_type_Int, i);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.SearchBarAssistant
 * JD-Core Version:    0.7.0.1
 */