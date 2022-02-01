package com.tencent.biz.qqstory.shareGroup.widget;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Subscriber;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class StoryPickerFragment
  extends QQStoryBaseFragment
  implements View.OnClickListener, StoryPickerHorizontalListView.OnCheckBoxClickListener, StoryPickerHorizontalListView.OnHorizontalItemClickListener
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  View jdField_a_of_type_AndroidViewView;
  StoryPickerListAdapter jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter;
  MemoryDataPuller jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller;
  QQStoryPullToRefreshListView jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView;
  String jdField_a_of_type_JavaLangString;
  LinkedHashSet<String> jdField_a_of_type_JavaUtilLinkedHashSet = new LinkedHashSet();
  boolean jdField_a_of_type_Boolean = false;
  String b;
  
  static Intent a(Activity paramActivity, LinkedHashSet<String> paramLinkedHashSet, String paramString, boolean paramBoolean, int paramInt)
  {
    paramActivity = new Intent(paramActivity, StoryPickerFragment.class);
    paramActivity.putExtra("extra_alert_for_result", paramBoolean);
    if (!TextUtils.isEmpty(paramString)) {
      paramActivity.putExtra("extra_sharegroup_name", paramString);
    }
    if ((paramLinkedHashSet != null) && (!paramLinkedHashSet.isEmpty())) {
      paramActivity.putExtra("extra_checked_vidset", paramLinkedHashSet);
    }
    paramActivity.putExtra("extra_from", paramInt);
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, LinkedHashSet<String> paramLinkedHashSet, String paramString, int paramInt1, int paramInt2)
  {
    PublicFragmentActivity.a(paramActivity, a(paramActivity, paramLinkedHashSet, paramString, true, paramInt2), StoryPickerFragment.class, paramInt1);
  }
  
  void a()
  {
    int i = 0;
    this.leftView.setText(getString(2131690778));
    super.setTitle(HardCodeUtil.a(2131714414) + QQStoryConstant.jdField_a_of_type_JavaLangString);
    super.a(String.format(HardCodeUtil.a(2131714416), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1) {}
    for (;;)
    {
      super.setRightViewTextDisable(i);
      this.jdField_a_of_type_AndroidViewView = super.a(2131366350);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter = new StoryPickerListAdapter(getActivity());
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.a(new StoryPickerFragment.1(this));
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.a(this);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.a(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)super.a(2131370493));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new StoryPickerFragment.2(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a.a(new StoryPickerFragment.3(this));
      return;
      i = 1;
    }
  }
  
  public void a(View paramView, VideoCollectionItem.FakeVideoUIItem paramFakeVideoUIItem)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) && (!paramFakeVideoUIItem.b))
    {
      paramView = DialogUtil.a(getActivity(), 230);
      paramView.setMessage(String.format(HardCodeUtil.a(2131714418), new Object[] { Integer.valueOf(20), QQStoryConstant.jdField_a_of_type_JavaLangString }));
      paramView.setPositiveButton(HardCodeUtil.a(2131714417), new StoryPickerFragment.4(this));
      paramView.show();
      return;
    }
    int i;
    if (!paramFakeVideoUIItem.jdField_a_of_type_Boolean)
    {
      paramFakeVideoUIItem.jdField_a_of_type_Boolean = bool;
      paramView = (ImageView)paramView;
      if (!paramFakeVideoUIItem.jdField_a_of_type_Boolean) {
        break label150;
      }
      i = 2130840700;
      label115:
      paramView.setImageResource(i);
      if (!paramFakeVideoUIItem.jdField_a_of_type_Boolean) {
        break label156;
      }
      this.jdField_a_of_type_JavaUtilLinkedHashSet.add(paramFakeVideoUIItem.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      c();
      return;
      bool = false;
      break;
      label150:
      i = 2130840696;
      break label115;
      label156:
      this.jdField_a_of_type_JavaUtilLinkedHashSet.remove(paramFakeVideoUIItem.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString, int paramInt, View paramView, VideoCollectionItem.FakeVideoUIItem paramFakeVideoUIItem)
  {
    if (paramFakeVideoUIItem.b) {
      Bosses.get().postJob(new StoryPickerFragment.6(this, "StoryPickerFragment", paramString, paramFakeVideoUIItem, paramInt, paramView));
    }
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    super.a(paramMap);
    paramMap.put(new StoryPickerFragment.GetCollectListEventReceiver(this), "");
    paramMap.put(new StoryPickerFragment.GetSimpleInfoListEventReceiver(this), "");
    paramMap.put(new StoryPickerFragment.CheckedVideosEventReceiver(this), "");
  }
  
  void b()
  {
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller = new MemoryDataPuller(QQStoryContext.a().b(), this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a();
    super.startTitleProgress();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.c();
  }
  
  void c()
  {
    super.a(String.format(HardCodeUtil.a(2131714415), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    int i;
    List localList;
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1)
    {
      i = 0;
      setRightViewTextDisable(i);
      if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20)
      {
        localList = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.a();
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (i >= localList.size()) {
          break label174;
        }
        Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label151;
          }
          VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = (VideoCollectionItem.FakeVideoUIItem)localIterator.next();
          if (localFakeVideoUIItem.jdField_a_of_type_Boolean)
          {
            localFakeVideoUIItem.b = true;
            continue;
            i = 1;
            break;
          }
          localFakeVideoUIItem.b = false;
        }
        label151:
        i += 1;
      }
    }
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 20) {
      d();
    }
    label174:
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.notifyDataSetChanged();
  }
  
  void d()
  {
    List localList = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.a();
    int i = 0;
    while (i < localList.size())
    {
      Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
      while (localIterator.hasNext())
      {
        VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = (VideoCollectionItem.FakeVideoUIItem)localIterator.next();
        if (!localFakeVideoUIItem.b) {
          localFakeVideoUIItem.b = true;
        }
      }
      i += 1;
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
    b();
  }
  
  public int getContentLayoutId()
  {
    return 2131561929;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("extra_alert_for_result", false);
    this.b = paramBundle.getString("extra_sharegroup_name");
    this.jdField_a_of_type_Int = paramBundle.getInt("extra_from");
    paramBundle = (LinkedHashSet)paramBundle.getSerializable("extra_checked_vidset");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.jdField_a_of_type_JavaUtilLinkedHashSet.addAll(paramBundle);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() > 0)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label106;
      }
      localObject = new StoryPickerFragment.5(this);
      QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230);
      localQQCustomDialog.setMessage(getString(2131699784, new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()), this.b }));
      localQQCustomDialog.setNegativeButton(2131690800, (DialogInterface.OnClickListener)localObject);
      localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131689557), (DialogInterface.OnClickListener)localObject);
      localQQCustomDialog.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label106:
      localObject = new Intent();
      ((Intent)localObject).putExtra("extra_checked_vidset", this.jdField_a_of_type_JavaUtilLinkedHashSet);
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    StoryReportor.a(18, this.jdField_a_of_type_Long);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    StoryReportor.a("share_story", "exp_all_story", this.jdField_a_of_type_Int, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment
 * JD-Core Version:    0.7.0.1
 */