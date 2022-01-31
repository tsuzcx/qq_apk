package com.tencent.biz.qqstory.playvideo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.biz.qqstory.view.widget.LeftTabBarView;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import nlt;
import nlu;
import nlv;

public class MyVideoVisibilityDialog
  extends Dialog
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public ViewPager a;
  VideoSpreadGroupList jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList;
  MyVideoVisiblePersonPageView jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView;
  MyVideoVisibleTroopPageView jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView;
  public LeftTabBarView a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  public MyVideoVisibilityDialog(@NonNull Context paramContext, String paramString, int paramInt, VideoSpreadGroupList paramVideoSpreadGroupList, boolean paramBoolean)
  {
    super(paramContext, 16973841);
    super.requestWindowFeature(1);
    super.setContentView(LayoutInflater.from(paramContext).inflate(2130970849, null));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = PlayModeUtils.a();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList = paramVideoSpreadGroupList;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)PlayModeUtils.a().getManager(51));
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  void a()
  {
    ((ElasticImageView)findViewById(2131370490)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131362786));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView = ((LeftTabBarView)findViewById(2131371984));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setUnselectColor(-1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setSelectColor(-1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setBackgroundDrawable(null);
    ArrayList localArrayList1 = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList != null) && (this.jdField_a_of_type_Boolean)) {
      if ((this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList.a != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList.a.isEmpty()))
      {
        ArrayList localArrayList2 = new ArrayList(this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList.a.size());
        Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList.a.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a((String)localObject);
          if (localObject != null) {
            localArrayList2.add(localObject);
          }
        }
        Collections.sort(localArrayList2, ContactSorter.a);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView = new MyVideoVisibleTroopPageView(this, this.jdField_a_of_type_AndroidContentContext, localArrayList2, this.jdField_a_of_type_ComTencentMobileqqAppTroopManager);
      }
    }
    for (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView = new MyVideoVisiblePersonPageView(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);; this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView = new MyVideoVisiblePersonPageView(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView.a());
        localArrayList1.add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView.a());
        localArrayList1.add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setSelectedTab(0, false);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setOnTabChangeListener(new nlt(this));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(new nlv(this, localArrayList1));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new nlu(this));
      return;
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView.b();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.getWindow();
    paramBundle.setGravity(80);
    paramBundle.setWindowAnimations(2131624587);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibilityDialog
 * JD-Core Version:    0.7.0.1
 */