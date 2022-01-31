package com.tencent.biz.qqstory.shareGroup.widget;

import alud;
import android.app.Activity;
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
import bdgm;
import bdjz;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Subscriber;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import ulg;
import wfy;
import wfz;
import wga;
import wgb;
import wgc;
import wgd;
import wge;
import wgf;
import wgg;
import wgl;
import wgm;
import wgo;
import wmf;
import wnd;
import wxj;
import xwc;

public class StoryPickerFragment
  extends QQStoryBaseFragment
  implements View.OnClickListener, wgl, wgm
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public View a;
  public QQStoryPullToRefreshListView a;
  public String a;
  public LinkedHashSet<String> a;
  public wgo a;
  public wmf a;
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
    this.leftView.setText(getString(2131690623));
    super.setTitle(alud.a(2131714929) + ulg.jdField_a_of_type_JavaLangString);
    super.a(String.format(alud.a(2131714931), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1) {}
    for (;;)
    {
      super.setRightViewTextDisable(i);
      this.jdField_a_of_type_AndroidViewView = super.a(2131365761);
      this.jdField_a_of_type_Wgo = new wgo(getActivity());
      this.jdField_a_of_type_Wgo.a(new wfy(this));
      this.jdField_a_of_type_Wgo.a(this);
      this.jdField_a_of_type_Wgo.a(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)super.a(2131369559));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Wgo);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new wfz(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a.a(new wga(this));
      return;
      i = 1;
    }
  }
  
  public void a(View paramView, wnd paramwnd)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) && (!paramwnd.b))
    {
      paramView = bdgm.a(getActivity(), 230);
      paramView.setMessage(String.format(alud.a(2131714933), new Object[] { Integer.valueOf(20), ulg.jdField_a_of_type_JavaLangString }));
      paramView.setPositiveButton(alud.a(2131714932), new wgb(this));
      paramView.show();
      return;
    }
    int i;
    if (!paramwnd.jdField_a_of_type_Boolean)
    {
      paramwnd.jdField_a_of_type_Boolean = bool;
      paramView = (ImageView)paramView;
      if (!paramwnd.jdField_a_of_type_Boolean) {
        break label150;
      }
      i = 2130840306;
      label115:
      paramView.setImageResource(i);
      if (!paramwnd.jdField_a_of_type_Boolean) {
        break label156;
      }
      this.jdField_a_of_type_JavaUtilLinkedHashSet.add(paramwnd.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      c();
      return;
      bool = false;
      break;
      label150:
      i = 2130840302;
      break label115;
      label156:
      this.jdField_a_of_type_JavaUtilLinkedHashSet.remove(paramwnd.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString, int paramInt, View paramView, wnd paramwnd)
  {
    if (paramwnd.b) {
      Bosses.get().postJob(new wgd(this, "StoryPickerFragment", paramString, paramwnd, paramInt, paramView));
    }
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    super.a(paramMap);
    paramMap.put(new wgf(this), "");
    paramMap.put(new wgg(this), "");
    paramMap.put(new wge(this), "");
  }
  
  void b()
  {
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    this.jdField_a_of_type_Wmf = new wmf(QQStoryContext.a().b(), this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Wmf.a();
    super.startTitleProgress();
    this.jdField_a_of_type_Wmf.c();
  }
  
  public void c()
  {
    super.a(String.format(alud.a(2131714930), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    int i;
    List localList;
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1)
    {
      i = 0;
      setRightViewTextDisable(i);
      if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20)
      {
        localList = this.jdField_a_of_type_Wgo.a();
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
          wnd localwnd = (wnd)localIterator.next();
          if (localwnd.jdField_a_of_type_Boolean)
          {
            localwnd.b = true;
            continue;
            i = 1;
            break;
          }
          localwnd.b = false;
        }
        label151:
        i += 1;
      }
    }
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 20) {
      d();
    }
    label174:
    this.jdField_a_of_type_Wgo.notifyDataSetChanged();
  }
  
  void d()
  {
    List localList = this.jdField_a_of_type_Wgo.a();
    int i = 0;
    while (i < localList.size())
    {
      Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
      while (localIterator.hasNext())
      {
        wnd localwnd = (wnd)localIterator.next();
        if (!localwnd.b) {
          localwnd.b = true;
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
    return 2131561575;
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
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() > 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = new wgc(this);
        bdjz localbdjz = bdgm.a(getActivity(), 230);
        localbdjz.setMessage(getString(2131700087, new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()), this.b }));
        localbdjz.setNegativeButton(2131690648, paramView);
        localbdjz.setPositiveButton(alud.a(2131689628), paramView);
        localbdjz.show();
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
    if (this.jdField_a_of_type_Wmf != null) {
      this.jdField_a_of_type_Wmf.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    wxj.a(18, this.jdField_a_of_type_Long);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    wxj.a("share_story", "exp_all_story", this.jdField_a_of_type_Int, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment
 * JD-Core Version:    0.7.0.1
 */