package com.tencent.biz.qqstory.shareGroup.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import nsr;
import nss;
import nst;
import nsu;
import nsv;
import nsw;
import nsy;
import nsz;
import nta;

public class StoryPickerFragment
  extends QQStoryBaseFragment
  implements View.OnClickListener, StoryPickerHorizontalListView.OnCheckBoxClickListener, StoryPickerHorizontalListView.OnHorizontalItemClickListener
{
  int jdField_a_of_type_Int;
  public View a;
  public StoryPickerListAdapter a;
  public MemoryDataPuller a;
  public QQStoryPullToRefreshListView a;
  public String a;
  public LinkedHashSet a;
  boolean jdField_a_of_type_Boolean = false;
  String b;
  
  public StoryPickerFragment()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashSet = new LinkedHashSet();
  }
  
  static Intent a(Activity paramActivity, LinkedHashSet paramLinkedHashSet, String paramString, boolean paramBoolean, int paramInt)
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
  
  public static void a(Activity paramActivity, LinkedHashSet paramLinkedHashSet, String paramString, int paramInt1, int paramInt2)
  {
    PublicFragmentActivity.a(paramActivity, a(paramActivity, paramLinkedHashSet, paramString, true, paramInt2), StoryPickerFragment.class, paramInt1);
  }
  
  protected int a()
  {
    return 2130970840;
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("extra_alert_for_result", false);
    this.b = paramBundle.getString("extra_sharegroup_name");
    this.jdField_a_of_type_Int = paramBundle.getInt("extra_from");
    paramBundle = (LinkedHashSet)paramBundle.getSerializable("extra_checked_vidset");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.jdField_a_of_type_JavaUtilLinkedHashSet.addAll(paramBundle);
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    c();
  }
  
  public void a(View paramView, VideoCollectionItem.FakeVideoUIItem paramFakeVideoUIItem)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) && (!paramFakeVideoUIItem.b))
    {
      paramView = DialogUtil.a(getActivity(), 230);
      paramView.setMessage(String.format("最多只能选择%d个%s小视频", new Object[] { Integer.valueOf(20), "日迹" }));
      paramView.setPositiveButton("我知道了", new nsu(this));
      paramView.show();
      return;
    }
    int i;
    if (!paramFakeVideoUIItem.jdField_a_of_type_Boolean)
    {
      paramFakeVideoUIItem.jdField_a_of_type_Boolean = bool;
      paramView = (ImageView)paramView;
      if (!paramFakeVideoUIItem.jdField_a_of_type_Boolean) {
        break label143;
      }
      i = 2130839274;
      label108:
      paramView.setImageResource(i);
      if (!paramFakeVideoUIItem.jdField_a_of_type_Boolean) {
        break label149;
      }
      this.jdField_a_of_type_JavaUtilLinkedHashSet.add(paramFakeVideoUIItem.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      d();
      return;
      bool = false;
      break;
      label143:
      i = 2130839272;
      break label108;
      label149:
      this.jdField_a_of_type_JavaUtilLinkedHashSet.remove(paramFakeVideoUIItem.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString, int paramInt, View paramView, VideoCollectionItem.FakeVideoUIItem paramFakeVideoUIItem)
  {
    if (paramFakeVideoUIItem.b) {
      Bosses.get().postJob(new nsw(this, paramString, paramInt, paramView, paramFakeVideoUIItem));
    }
  }
  
  protected void a(@NonNull Map paramMap)
  {
    super.a(paramMap);
    paramMap.put(new nsz(this), "");
    paramMap.put(new nta(this), "");
    paramMap.put(new nsy(this), "");
  }
  
  void b()
  {
    int i = 0;
    this.b.setText(getString(2131433698));
    super.a("全部日迹");
    super.a(String.format("完成(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1) {}
    for (;;)
    {
      super.f(i);
      this.jdField_a_of_type_AndroidViewView = super.a(2131363116);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter = new StoryPickerListAdapter(getActivity());
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.a(new nsr(this));
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.a(this);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.a(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)super.a(2131364184));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new nss(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a.a(new nst(this));
      return;
      i = 1;
    }
  }
  
  void c()
  {
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller = new MemoryDataPuller(QQStoryContext.a().b(), this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a();
    super.g();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.c();
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    super.a(String.format("完成(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    int i;
    List localList;
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1)
    {
      i = 0;
      f(i);
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
          break label170;
        }
        Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label147;
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
        label147:
        i += 1;
      }
    }
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 20) {
      e();
    }
    label170:
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.notifyDataSetChanged();
  }
  
  void e()
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
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() > 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = new nsv(this);
        QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230);
        localQQCustomDialog.setMessage(getString(2131432111, new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()), this.b }));
        localQQCustomDialog.setNegativeButton(2131433015, paramView);
        localQQCustomDialog.setPositiveButton("添加", paramView);
        localQQCustomDialog.show();
      }
    }
    else {
      return;
    }
    paramView = new Intent();
    paramView.putExtra("extra_checked_vidset", this.jdField_a_of_type_JavaUtilLinkedHashSet);
    getActivity().setResult(-1, paramView);
    getActivity().finish();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    StoryReportor.a("share_story", "exp_all_story", this.jdField_a_of_type_Int, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment
 * JD-Core Version:    0.7.0.1
 */