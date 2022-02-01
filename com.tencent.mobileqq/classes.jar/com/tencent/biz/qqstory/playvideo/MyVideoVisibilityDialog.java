package com.tencent.biz.qqstory.playvideo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.LeftTabBarView;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyVideoVisibilityDialog
  extends ReportDialog
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  VideoSpreadGroupList jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList;
  MyVideoVisiblePersonPageView jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView;
  MyVideoVisibleTroopPageView jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView;
  LeftTabBarView jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  public MyVideoVisibilityDialog(@NonNull Context paramContext, String paramString, int paramInt, VideoSpreadGroupList paramVideoSpreadGroupList, boolean paramBoolean)
  {
    super(paramContext, 16973841);
    super.requestWindowFeature(1);
    super.setContentView(LayoutInflater.from(paramContext).inflate(2131561830, null));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = PlayModeUtils.a();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList = paramVideoSpreadGroupList;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)PlayModeUtils.a().getManager(QQManagerFactory.TROOP_MANAGER));
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = ((ViewPager)findViewById(2131380851));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView = ((LeftTabBarView)findViewById(2131378215));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setUnselectColor(-1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setSelectColor(-1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setBackgroundDrawable(null);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList;
    if ((localObject1 != null) && (this.jdField_a_of_type_Boolean))
    {
      if ((((VideoSpreadGroupList)localObject1).a != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList.a.isEmpty()))
      {
        localObject1 = new ArrayList(this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList.a.size());
        Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList.a.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (String)localIterator.next();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b((String)localObject2);
          if (localObject2 != null) {
            ((List)localObject1).add(localObject2);
          }
        }
        Collections.sort((List)localObject1, ContactSorter.a);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView = new MyVideoVisibleTroopPageView(this, this.jdField_a_of_type_AndroidContentContext, (List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppTroopManager);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView = new MyVideoVisiblePersonPageView(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView = new MyVideoVisiblePersonPageView(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView;
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.a(((MyVideoVisiblePersonPageView)localObject1).a());
      localArrayList.add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView);
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView;
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.a(((MyVideoVisibleTroopPageView)localObject1).a());
      localArrayList.add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setSelectedTab(0, false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setOnTabChangeListener(new MyVideoVisibilityDialog.1(this));
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setAdapter(new MyVideoVisibilityDialog.MyPagerAdapter(this, localArrayList));
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOnPageChangeListener(new MyVideoVisibilityDialog.2(this));
    int i = this.jdField_a_of_type_Int;
    if (i == 2) {
      i = 1;
    } else if (i == 3) {
      i = 2;
    } else if (i == 1) {
      i = 3;
    } else {
      i = 0;
    }
    StoryReportor.a("pub_control", "exp_list", 0, 0, new String[] { String.valueOf(i), "", "", this.jdField_a_of_type_JavaLangString });
  }
  
  public void dismiss()
  {
    super.dismiss();
    MyVideoVisiblePersonPageView localMyVideoVisiblePersonPageView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView;
    if (localMyVideoVisiblePersonPageView != null) {
      localMyVideoVisiblePersonPageView.b();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364719) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.getWindow();
    paramBundle.setGravity(80);
    paramBundle.setWindowAnimations(2131755334);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibilityDialog
 * JD-Core Version:    0.7.0.1
 */