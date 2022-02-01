package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GameMsgTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public GameMsgTipsBar(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseActivity;
  }
  
  public int a()
  {
    return 40;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559139, null);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367485)).setOnClickListener(this);
      paramVarArgs = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379697);
      if ((paramVarArgs != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        paramVarArgs.setText(this.jdField_a_of_type_JavaLangString);
      }
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    QLog.i("GameMsgTipsBar", 1, "[onDestory]");
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateTips], tips:");
      localStringBuilder.append(paramString);
      QLog.d("GameMsgTipsBar", 0, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 2003;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131367485)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.GameMsgTipsBar
 * JD-Core Version:    0.7.0.1
 */