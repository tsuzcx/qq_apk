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
import anzj;
import bhlq;
import bhpc;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Subscriber;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import win;
import yde;
import ydf;
import ydg;
import ydh;
import ydi;
import ydj;
import ydk;
import ydl;
import ydm;
import ydr;
import yds;
import ydu;
import yjl;
import ykj;
import yup;
import zti;

public class StoryPickerFragment
  extends QQStoryBaseFragment
  implements View.OnClickListener, ydr, yds
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public View a;
  public QQStoryPullToRefreshListView a;
  public String a;
  public LinkedHashSet<String> a;
  public ydu a;
  public yjl a;
  boolean jdField_a_of_type_Boolean = false;
  String b;
  
  public StoryPickerFragment()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashSet = new LinkedHashSet();
  }
  
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
    this.leftView.setText(getString(2131690559));
    super.setTitle(anzj.a(2131713339) + win.jdField_a_of_type_JavaLangString);
    super.a(String.format(anzj.a(2131713341), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1) {}
    for (;;)
    {
      super.setRightViewTextDisable(i);
      this.jdField_a_of_type_AndroidViewView = super.a(2131366048);
      this.jdField_a_of_type_Ydu = new ydu(getActivity());
      this.jdField_a_of_type_Ydu.a(new yde(this));
      this.jdField_a_of_type_Ydu.a(this);
      this.jdField_a_of_type_Ydu.a(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)super.a(2131370052));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Ydu);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new ydf(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a.a(new ydg(this));
      return;
      i = 1;
    }
  }
  
  public void a(View paramView, ykj paramykj)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) && (!paramykj.b))
    {
      paramView = bhlq.a(getActivity(), 230);
      paramView.setMessage(String.format(anzj.a(2131713343), new Object[] { Integer.valueOf(20), win.jdField_a_of_type_JavaLangString }));
      paramView.setPositiveButton(anzj.a(2131713342), new ydh(this));
      paramView.show();
      return;
    }
    int i;
    if (!paramykj.jdField_a_of_type_Boolean)
    {
      paramykj.jdField_a_of_type_Boolean = bool;
      paramView = (ImageView)paramView;
      if (!paramykj.jdField_a_of_type_Boolean) {
        break label150;
      }
      i = 2130840495;
      label115:
      paramView.setImageResource(i);
      if (!paramykj.jdField_a_of_type_Boolean) {
        break label156;
      }
      this.jdField_a_of_type_JavaUtilLinkedHashSet.add(paramykj.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      c();
      return;
      bool = false;
      break;
      label150:
      i = 2130840491;
      break label115;
      label156:
      this.jdField_a_of_type_JavaUtilLinkedHashSet.remove(paramykj.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString, int paramInt, View paramView, ykj paramykj)
  {
    if (paramykj.b) {
      Bosses.get().postJob(new ydj(this, "StoryPickerFragment", paramString, paramykj, paramInt, paramView));
    }
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    super.a(paramMap);
    paramMap.put(new ydl(this), "");
    paramMap.put(new ydm(this), "");
    paramMap.put(new ydk(this), "");
  }
  
  void b()
  {
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    this.jdField_a_of_type_Yjl = new yjl(QQStoryContext.a().b(), this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Yjl.a();
    super.startTitleProgress();
    this.jdField_a_of_type_Yjl.c();
  }
  
  public void c()
  {
    super.a(String.format(anzj.a(2131713340), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    int i;
    List localList;
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1)
    {
      i = 0;
      setRightViewTextDisable(i);
      if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20)
      {
        localList = this.jdField_a_of_type_Ydu.a();
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
          ykj localykj = (ykj)localIterator.next();
          if (localykj.jdField_a_of_type_Boolean)
          {
            localykj.b = true;
            continue;
            i = 1;
            break;
          }
          localykj.b = false;
        }
        label151:
        i += 1;
      }
    }
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 20) {
      d();
    }
    label174:
    this.jdField_a_of_type_Ydu.notifyDataSetChanged();
  }
  
  void d()
  {
    List localList = this.jdField_a_of_type_Ydu.a();
    int i = 0;
    while (i < localList.size())
    {
      Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
      while (localIterator.hasNext())
      {
        ykj localykj = (ykj)localIterator.next();
        if (!localykj.b) {
          localykj.b = true;
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
    return 2131561851;
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
      localObject = new ydi(this);
      bhpc localbhpc = bhlq.a(getActivity(), 230);
      localbhpc.setMessage(getString(2131698620, new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()), this.b }));
      localbhpc.setNegativeButton(2131690580, (DialogInterface.OnClickListener)localObject);
      localbhpc.setPositiveButton(anzj.a(2131689551), (DialogInterface.OnClickListener)localObject);
      localbhpc.show();
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
    if (this.jdField_a_of_type_Yjl != null) {
      this.jdField_a_of_type_Yjl.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    yup.a(18, this.jdField_a_of_type_Long);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    yup.a("share_story", "exp_all_story", this.jdField_a_of_type_Int, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment
 * JD-Core Version:    0.7.0.1
 */