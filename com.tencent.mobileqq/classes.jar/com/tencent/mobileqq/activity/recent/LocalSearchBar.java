package com.tencent.mobileqq.activity.recent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.activity.VADActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import xgy;
import xgz;

public class LocalSearchBar
  implements DialogInterface.OnDismissListener, View.OnClickListener, Animation.AnimationListener
{
  private int jdField_a_of_type_Int = 4;
  private long jdField_a_of_type_Long = 0L;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private View d;
  
  public LocalSearchBar(ListView paramListView, View paramView1, View paramView2, BaseActivity paramBaseActivity, View paramView3, int paramInt)
  {
    View localView = null;
    this.jdField_b_of_type_Int = paramInt;
    if (paramView3 != null) {
      localView = paramView3;
    }
    if (localView == null) {}
    for (paramView3 = paramBaseActivity.getLayoutInflater().inflate(2130971470, paramListView, false);; paramView3 = localView)
    {
      localView = paramView3.findViewById(2131368254);
      if (localView != null) {
        localView.setVisibility(8);
      }
      paramListView.addHeaderView(paramView3, 0);
      IphoneTitleBarActivity.setLayerType(paramView3);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
      this.jdField_c_of_type_AndroidViewView = paramBaseActivity.findViewById(2131364912);
      this.jdField_a_of_type_AndroidViewView = paramView1;
      this.jdField_b_of_type_AndroidViewView = paramView2;
      paramListView = (EditText)paramView3.findViewById(2131368255);
      paramListView.setFocusableInTouchMode(false);
      paramListView.setCursorVisible(false);
      paramListView.setOnClickListener(this);
      paramView3.findViewById(2131371103).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView3.findViewById(2131368668));
      this.d = paramView3.findViewById(2131371103);
      this.d.setVisibility(8);
      a(this.d);
      return;
    }
  }
  
  public static void a(View paramView)
  {
    int i = 8;
    if (SearchConfigManager.isConfigLoaded)
    {
      if (SearchConfigManager.a()) {
        i = 0;
      }
      paramView.setVisibility(i);
      return;
    }
    ThreadManager.post(new xgz(new xgy(Looper.getMainLooper(), paramView)), 8, null, true);
  }
  
  private void e()
  {
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBaseActivity != null) {
      UniteSearchActivity.a(localBaseActivity, null, this.jdField_b_of_type_Int, 1);
    }
  }
  
  public void a()
  {
    PADetailReportUtil.a().a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.c();
    if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!paramQQAppInterface.equals(SearchConfigManager.curUin))) {
      SearchConfigManager.isConfigLoaded = false;
    }
    a(this.d);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(SearchEntryConfigManager.b());
  }
  
  public void d() {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onClick() time stamp = " + (l - this.jdField_a_of_type_Long));
    }
    if (l - this.jdField_a_of_type_Long > 1500L)
    {
      this.jdField_a_of_type_Long = l;
      FrameHelperActivity.b(false);
      if (paramView.getId() != 2131371103) {
        break label115;
      }
      paramView = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramView != null) {
        if (this.jdField_b_of_type_Int != 1) {
          break label102;
        }
      }
    }
    for (;;)
    {
      VADActivity.a(paramView, i);
      return;
      label102:
      if (this.jdField_b_of_type_Int == 2)
      {
        i = 2;
        continue;
        label115:
        e();
      }
      else
      {
        i = 3;
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.LocalSearchBar
 * JD-Core Version:    0.7.0.1
 */