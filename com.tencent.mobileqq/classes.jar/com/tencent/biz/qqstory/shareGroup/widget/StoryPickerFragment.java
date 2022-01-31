package com.tencent.biz.qqstory.shareGroup.widget;

import ajya;
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
import bbdj;
import bbgu;
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
import ssf;
import umx;
import umy;
import umz;
import una;
import unb;
import unc;
import und;
import une;
import unf;
import unk;
import unl;
import unn;
import ute;
import uuc;
import vei;
import wdb;

public class StoryPickerFragment
  extends QQStoryBaseFragment
  implements View.OnClickListener, unk, unl
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public View a;
  public QQStoryPullToRefreshListView a;
  public String a;
  public LinkedHashSet<String> a;
  public unn a;
  public ute a;
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
    this.leftView.setText(getString(2131690572));
    super.setTitle(ajya.a(2131714545) + ssf.jdField_a_of_type_JavaLangString);
    super.a(String.format(ajya.a(2131714547), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1) {}
    for (;;)
    {
      super.setRightViewTextDisable(i);
      this.jdField_a_of_type_AndroidViewView = super.a(2131365675);
      this.jdField_a_of_type_Unn = new unn(getActivity());
      this.jdField_a_of_type_Unn.a(new umx(this));
      this.jdField_a_of_type_Unn.a(this);
      this.jdField_a_of_type_Unn.a(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)super.a(2131369306));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Unn);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new umy(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a.a(new umz(this));
      return;
      i = 1;
    }
  }
  
  public void a(View paramView, uuc paramuuc)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) && (!paramuuc.b))
    {
      paramView = bbdj.a(getActivity(), 230);
      paramView.setMessage(String.format(ajya.a(2131714549), new Object[] { Integer.valueOf(20), ssf.jdField_a_of_type_JavaLangString }));
      paramView.setPositiveButton(ajya.a(2131714548), new una(this));
      paramView.show();
      return;
    }
    int i;
    if (!paramuuc.jdField_a_of_type_Boolean)
    {
      paramuuc.jdField_a_of_type_Boolean = bool;
      paramView = (ImageView)paramView;
      if (!paramuuc.jdField_a_of_type_Boolean) {
        break label150;
      }
      i = 2130840202;
      label115:
      paramView.setImageResource(i);
      if (!paramuuc.jdField_a_of_type_Boolean) {
        break label156;
      }
      this.jdField_a_of_type_JavaUtilLinkedHashSet.add(paramuuc.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      c();
      return;
      bool = false;
      break;
      label150:
      i = 2130840198;
      break label115;
      label156:
      this.jdField_a_of_type_JavaUtilLinkedHashSet.remove(paramuuc.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString, int paramInt, View paramView, uuc paramuuc)
  {
    if (paramuuc.b) {
      Bosses.get().postJob(new unc(this, "StoryPickerFragment", paramString, paramuuc, paramInt, paramView));
    }
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    super.a(paramMap);
    paramMap.put(new une(this), "");
    paramMap.put(new unf(this), "");
    paramMap.put(new und(this), "");
  }
  
  void b()
  {
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    this.jdField_a_of_type_Ute = new ute(QQStoryContext.a().b(), this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Ute.a();
    super.startTitleProgress();
    this.jdField_a_of_type_Ute.c();
  }
  
  public void c()
  {
    super.a(String.format(ajya.a(2131714546), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    int i;
    List localList;
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1)
    {
      i = 0;
      setRightViewTextDisable(i);
      if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20)
      {
        localList = this.jdField_a_of_type_Unn.a();
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
          uuc localuuc = (uuc)localIterator.next();
          if (localuuc.jdField_a_of_type_Boolean)
          {
            localuuc.b = true;
            continue;
            i = 1;
            break;
          }
          localuuc.b = false;
        }
        label151:
        i += 1;
      }
    }
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 20) {
      d();
    }
    label174:
    this.jdField_a_of_type_Unn.notifyDataSetChanged();
  }
  
  void d()
  {
    List localList = this.jdField_a_of_type_Unn.a();
    int i = 0;
    while (i < localList.size())
    {
      Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
      while (localIterator.hasNext())
      {
        uuc localuuc = (uuc)localIterator.next();
        if (!localuuc.b) {
          localuuc.b = true;
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
    return 2131561367;
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
        paramView = new unb(this);
        bbgu localbbgu = bbdj.a(getActivity(), 230);
        localbbgu.setMessage(getString(2131699706, new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()), this.b }));
        localbbgu.setNegativeButton(2131690596, paramView);
        localbbgu.setPositiveButton(ajya.a(2131689628), paramView);
        localbbgu.show();
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
    if (this.jdField_a_of_type_Ute != null) {
      this.jdField_a_of_type_Ute.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    vei.a(18, this.jdField_a_of_type_Long);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    vei.a("share_story", "exp_all_story", this.jdField_a_of_type_Int, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment
 * JD-Core Version:    0.7.0.1
 */