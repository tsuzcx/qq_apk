package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadInJoyInterestLabelViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-3355444);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130840689);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842049);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Map paramMap) {}
  
  public void a(Map paramMap, boolean paramBoolean) {}
  
  public void a(Set paramSet, Map paramMap) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b(Map paramMap) {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void g() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject1;
    do
    {
      return;
      ReadInJoyHelper.b(((BaseActivity)a()).app);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067DB", "0X80067DB", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
      if (!NetworkUtil.a(a().getApplication().getApplicationContext()))
      {
        QQToast.a(a(), a().getResources().getString(2131428454), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131558448));
        return;
      }
      paramView = new ArrayList();
      localObject1 = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Integer)localIterator.next();
        localObject2 = (InterestLabelInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
        paramView.add(Integer.valueOf(((InterestLabelInfo)localObject2).mInterestLabelID));
        ((List)localObject1).add(localObject2);
      }
      ReadInJoyLogicEngine.a().b((List)localObject1);
      ReadInJoyLogicEngine.a().c(paramView);
      return;
      localObject1 = (InterestLabelInfo)paramView.getTag(2131428431);
    } while (localObject1 == null);
    if ((paramView instanceof Button))
    {
      paramView = (Button)paramView;
      if ((InterestLabelInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(((InterestLabelInfo)localObject1).mInterestLabelID)) == null) {
        break label339;
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(((InterestLabelInfo)localObject1).mInterestLabelID));
      paramView.setTextColor(-15550475);
      paramView.setBackgroundResource(2130840777);
    }
    for (;;)
    {
      a();
      return;
      label339:
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((InterestLabelInfo)localObject1).mInterestLabelID), localObject1);
      paramView.setTextColor(-1);
      paramView.setBackgroundResource(2130840778);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyInterestLabelViewGroup
 * JD-Core Version:    0.7.0.1
 */