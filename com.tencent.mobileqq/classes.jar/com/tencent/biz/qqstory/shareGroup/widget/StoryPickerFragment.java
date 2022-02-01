package com.tencent.biz.qqstory.shareGroup.widget;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.tencent.mobileqq.app.BaseActivity;
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
  QQStoryPullToRefreshListView a;
  StoryPickerListAdapter b;
  View c;
  String d;
  MemoryDataPuller e;
  LinkedHashSet<String> f = new LinkedHashSet();
  boolean g = false;
  String h;
  int i;
  private long q;
  
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
    this.leftView.setText(getString(2131887625));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131911849));
    ((StringBuilder)localObject).append(QQStoryConstant.a);
    super.setTitle(((StringBuilder)localObject).toString());
    localObject = HardCodeUtil.a(2131911851);
    int j = 1;
    super.a(String.format((String)localObject, new Object[] { Integer.valueOf(this.f.size()) }), this);
    if (this.f.size() < 1) {
      j = 0;
    }
    super.setRightViewTextDisable(j);
    this.c = super.a(2131432530);
    this.b = new StoryPickerListAdapter(getBaseActivity());
    this.b.a(new StoryPickerFragment.1(this));
    this.b.a(this);
    this.b.a(this);
    this.a = ((QQStoryPullToRefreshListView)super.a(2131437317));
    this.a.setAdapter(this.b);
    this.a.setPullToRefreshListener(new StoryPickerFragment.2(this));
    this.a.j.a(new StoryPickerFragment.3(this));
  }
  
  public void a(View paramView, VideoCollectionItem.FakeVideoUIItem paramFakeVideoUIItem)
  {
    if ((this.f.size() >= 20) && (!paramFakeVideoUIItem.d))
    {
      paramView = DialogUtil.a(getBaseActivity(), 230);
      paramView.setMessage(String.format(HardCodeUtil.a(2131911853), new Object[] { Integer.valueOf(20), QQStoryConstant.a }));
      paramView.setPositiveButton(HardCodeUtil.a(2131911852), new StoryPickerFragment.4(this));
      paramView.show();
      return;
    }
    paramFakeVideoUIItem.c ^= true;
    paramView = (ImageView)paramView;
    int j;
    if (paramFakeVideoUIItem.c) {
      j = 2130841341;
    } else {
      j = 2130841337;
    }
    paramView.setImageResource(j);
    if (paramFakeVideoUIItem.c) {
      this.f.add(paramFakeVideoUIItem.a);
    } else {
      this.f.remove(paramFakeVideoUIItem.a);
    }
    c();
  }
  
  public void a(String paramString, int paramInt, View paramView, VideoCollectionItem.FakeVideoUIItem paramFakeVideoUIItem)
  {
    if (paramFakeVideoUIItem.d) {
      Bosses.get().postJob(new StoryPickerFragment.6(this, "StoryPickerFragment", paramString, paramFakeVideoUIItem, paramInt, paramView));
    }
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    super.a(paramMap);
    paramMap.put(new StoryPickerFragment.GetCollectListEventReceiver(this), "");
    paramMap.put(new StoryPickerFragment.GetSimpleInfoListEventReceiver(this), "");
    paramMap.put(new StoryPickerFragment.CheckedVideosEventReceiver(this), "");
  }
  
  void b()
  {
    this.d = String.valueOf(System.currentTimeMillis());
    this.e = new MemoryDataPuller(QQStoryContext.a().i(), this.d);
    this.e.b();
    super.startTitleProgress();
    this.e.e();
  }
  
  void c()
  {
    super.a(String.format(HardCodeUtil.a(2131911850), new Object[] { Integer.valueOf(this.f.size()) }), this);
    int j;
    if (this.f.size() < 1) {
      j = 0;
    } else {
      j = 1;
    }
    setRightViewTextDisable(j);
    if (this.f.size() >= 20)
    {
      List localList = this.b.a();
      j = 0;
      while (j < localList.size())
      {
        Iterator localIterator = ((VideoCollectionItem)localList.get(j)).collectionVideoUIItemList.iterator();
        while (localIterator.hasNext())
        {
          VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = (VideoCollectionItem.FakeVideoUIItem)localIterator.next();
          if (localFakeVideoUIItem.c) {
            localFakeVideoUIItem.d = true;
          } else {
            localFakeVideoUIItem.d = false;
          }
        }
        j += 1;
      }
    }
    if (this.f.size() < 20) {
      d();
    }
    this.b.notifyDataSetChanged();
  }
  
  void d()
  {
    List localList = this.b.a();
    int j = 0;
    while (j < localList.size())
    {
      Iterator localIterator = ((VideoCollectionItem)localList.get(j)).collectionVideoUIItemList.iterator();
      while (localIterator.hasNext())
      {
        VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = (VideoCollectionItem.FakeVideoUIItem)localIterator.next();
        if (!localFakeVideoUIItem.d) {
          localFakeVideoUIItem.d = true;
        }
      }
      j += 1;
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
    b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131628155;
  }
  
  protected void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.g = paramBundle.getBoolean("extra_alert_for_result", false);
    this.h = paramBundle.getString("extra_sharegroup_name");
    this.i = paramBundle.getInt("extra_from");
    paramBundle = (LinkedHashSet)paramBundle.getSerializable("extra_checked_vidset");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.f.addAll(paramBundle);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (this.f.size() > 0)
    {
      Object localObject;
      if (this.g)
      {
        localObject = new StoryPickerFragment.5(this);
        QQCustomDialog localQQCustomDialog = DialogUtil.a(getBaseActivity(), 230);
        localQQCustomDialog.setMessage(getString(2131897978, new Object[] { Integer.valueOf(this.f.size()), this.h }));
        localQQCustomDialog.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
        localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131886199), (DialogInterface.OnClickListener)localObject);
        localQQCustomDialog.show();
      }
      else
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("extra_checked_vidset", this.f);
        getBaseActivity().setResult(-1, (Intent)localObject);
        getBaseActivity().finish();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    MemoryDataPuller localMemoryDataPuller = this.e;
    if (localMemoryDataPuller != null) {
      localMemoryDataPuller.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    StoryReportor.a(18, this.q);
  }
  
  public void onResume()
  {
    super.onResume();
    this.q = SystemClock.uptimeMillis();
    StoryReportor.a("share_story", "exp_all_story", this.i, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment
 * JD-Core Version:    0.7.0.1
 */