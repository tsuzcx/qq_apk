package com.tencent.biz.qqstory.playvideo;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListAdapter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyVideoVisiblePersonPageView
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = -1;
  Dialog jdField_a_of_type_AndroidAppDialog;
  Context jdField_a_of_type_AndroidContentContext;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new MyVideoVisiblePersonPageView.6(this));
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new MyVideoVisiblePersonPageView.4(this);
  QQStoryWatcherListAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter;
  protected ChildViewClickListener a;
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int = -1;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  
  public MyVideoVisiblePersonPageView(Dialog paramDialog, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener = new MyVideoVisiblePersonPageView.5(this);
    LayoutInflater.from(paramContext).inflate(2131561832, this, true);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)PlayModeUtils.a().getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = PlayModeUtils.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    a();
    paramDialog = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().b());
    if ((paramDialog != null) && (paramDialog.isVip))
    {
      h();
      return;
    }
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt == 1000)
    {
      h();
      return;
    }
    if (paramInt == 0)
    {
      g();
      return;
    }
    if (paramInt == 1)
    {
      f();
      return;
    }
    c();
  }
  
  public String a()
  {
    String str = HardCodeUtil.a(2131707095);
    int i = this.jdField_a_of_type_Int;
    if ((i != 1000) && (i != 0) && (i != 1) && (i != 2))
    {
      if (i == 3) {
        return HardCodeUtil.a(2131707096);
      }
    }
    else {
      str = HardCodeUtil.a(2131707097);
    }
    return str;
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370110));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374464);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374548));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376496));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131381180));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376778);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter = new QQStoryWatcherListAdapter(this.jdField_a_of_type_AndroidContentContext, null);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.a(2131561831);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new MyVideoVisiblePersonPageView.1(this));
    MyVideoVisiblePersonPageView.2 local2 = new MyVideoVisiblePersonPageView.2(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(local2);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(local2);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(local2);
  }
  
  void a(List<QQUserUIItem> paramList)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter != null) && (paramList != null))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)localIterator.next();
        Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e(String.valueOf(localQQUserUIItem.qq));
        if (localFriends != null)
        {
          localQQUserUIItem.mComparePartInt = localFriends.mComparePartInt;
          localQQUserUIItem.mCompareSpell = localFriends.mCompareSpell;
        }
      }
      Collections.sort(paramList, new MyVideoVisiblePersonPageView.3(this));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.a(paramList);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
  }
  
  void c()
  {
    if (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      d();
      ((QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).b(this.jdField_a_of_type_JavaLangString);
      return;
    }
    e();
  }
  
  void d()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  void f()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130847120), null, null);
    this.c.setText(HardCodeUtil.a(2131707094));
  }
  
  void g()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130847118), null, null);
    this.c.setText(StoryApi.a(2131699901));
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130847122), null, null);
    this.c.setText(HardCodeUtil.a(2131707098));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131376496) {
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView
 * JD-Core Version:    0.7.0.1
 */