package com.tencent.mobileqq.activity;

import QC.GetConciseThemeReq;
import QC.GetConciseThemeRsp;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IJce.Util;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.List;

public class SimpleUIChoiceView
{
  private static List<SimpleUIChoiceView.ColorItemInfo> jdField_a_of_type_JavaUtilList;
  public static final String[] a;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private GeneralSettingActivity jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity;
  private SimpleUIChoiceView.ColorListAdapter jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView$ColorListAdapter;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "素雅灰", "极简白", "浅葱绿", "盛夏黄", "桃桃粉", "星辰紫", "经典蓝", "元气红", "极致黑" };
  }
  
  private void a(URLImageView paramURLImageView, SimpleUIChoiceView.ColorItemInfo paramColorItemInfo)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    localObject = URLDrawable.getDrawable(paramColorItemInfo.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
    boolean bool = a((URLDrawable)localObject);
    if (paramURLImageView != null)
    {
      paramURLImageView.setImageDrawable(null);
      paramURLImageView.setImageDrawable((Drawable)localObject);
    }
    if (QLog.isColorLevel())
    {
      paramURLImageView = new StringBuilder();
      paramURLImageView.append("onBindViewHolder loadPic colorDrawable=");
      paramURLImageView.append(localObject);
      paramURLImageView.append(" bReady=");
      paramURLImageView.append(bool);
      paramURLImageView.append(" checked=");
      paramURLImageView.append(paramColorItemInfo.jdField_a_of_type_Boolean);
      QLog.d("SimpleUIChoiceView", 2, paramURLImageView.toString());
    }
    paramColorItemInfo.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
    if (!bool)
    {
      ((URLDrawable)localObject).setURLDrawableListener(this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity);
      ((URLDrawable)localObject).startDownload();
    }
  }
  
  private boolean a(URLDrawable paramURLDrawable)
  {
    return (paramURLDrawable != null) && ((paramURLDrawable.getStatus() == 1) || (paramURLDrawable.getStatus() == 4));
  }
  
  public void a()
  {
    ((IJce)QRoute.api(IJce.class)).build("QC.HomepageLogicServer.HomepageLogicObj", "QcHomePageLogic.GetConciseThemeReq", "stReq", "stRsp").request("GetConciseTheme", new GetConciseThemeReq(IJce.Util.a()), new GetConciseThemeRsp(), new SimpleUIChoiceView.1(this), false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateSimpleUIChoice bpref=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" needChangeTheme=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("SimpleUIChoiceView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt >= 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView$ColorListAdapter;
      if (localObject != null)
      {
        localObject = ((SimpleUIChoiceView.ColorListAdapter)localObject).a(paramInt);
        if (localObject != null)
        {
          ((SimpleUIChoiceView.ColorItemInfo)localObject).jdField_b_of_type_Boolean = paramBoolean;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView$ColorListAdapter.a((SimpleUIChoiceView.ColorItemInfo)localObject, paramInt, true)) && (paramBoolean)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity.c(((SimpleUIChoiceView.ColorItemInfo)localObject).jdField_a_of_type_Int);
          }
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
        }
      }
    }
  }
  
  public void a(View paramView, GeneralSettingActivity paramGeneralSettingActivity)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131364814));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemViewCacheSize(7);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramGeneralSettingActivity);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity = paramGeneralSettingActivity;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new SimpleUIChoiceView.SpacesItemDecoration(this, 8));
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (jdField_a_of_type_JavaUtilList == null) {
      jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView$ColorListAdapter = new SimpleUIChoiceView.ColorListAdapter(this, jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView$ColorListAdapter);
    int j = SimpleUIUtil.f();
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilList.size())
    {
      MobileReportManager.getInstance().reportAction(((SimpleUIChoiceView.ColorItemInfo)jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString, "4", "platform898", "4", "1", 101, 1, System.currentTimeMillis());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity.app, "dc00898", "", "", "qq_vip", "0X800B15B", Integer.decode(((SimpleUIChoiceView.ColorItemInfo)jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString).intValue(), 0, "", "", "", "");
      ((SimpleUIChoiceView.ColorItemInfo)jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Boolean = false;
      i += 1;
    }
    if ((jdField_a_of_type_JavaUtilList.size() > j) && (j >= 0)) {
      ((SimpleUIChoiceView.ColorItemInfo)jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Boolean = true;
    }
    if (jdField_a_of_type_JavaUtilList.size() == 0) {
      a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    RecyclerView localRecyclerView = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
    boolean bool = true;
    if (localRecyclerView == null) {
      return true;
    }
    float f = paramMotionEvent.getY();
    paramMotionEvent = new int[2];
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLocationOnScreen(paramMotionEvent);
    if (f > paramMotionEvent[1])
    {
      if (f >= paramMotionEvent[1] + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight()) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void b()
  {
    Object localObject1 = jdField_a_of_type_JavaUtilList;
    if (localObject1 != null) {
      try
      {
        jdField_a_of_type_JavaUtilList.clear();
        jdField_a_of_type_JavaUtilList = null;
      }
      finally {}
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView$ColorListAdapter;
    if (localObject1 != null) {
      ((SimpleUIChoiceView.ColorListAdapter)localObject1).a();
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("selectSimpleUIChoice bpref=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" isLoading=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("SimpleUIChoiceView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt >= 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView$ColorListAdapter;
      if (localObject != null)
      {
        localObject = ((SimpleUIChoiceView.ColorListAdapter)localObject).a(paramInt);
        if (localObject != null)
        {
          ((SimpleUIChoiceView.ColorItemInfo)localObject).jdField_b_of_type_Boolean = paramBoolean;
          this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView$ColorListAdapter.a((SimpleUIChoiceView.ColorItemInfo)localObject, paramInt, true);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView
 * JD-Core Version:    0.7.0.1
 */