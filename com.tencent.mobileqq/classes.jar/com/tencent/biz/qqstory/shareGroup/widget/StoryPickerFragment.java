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
import anvx;
import bhdj;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Subscriber;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import vzh;
import xtk;
import xtl;
import xtm;
import xtn;
import xto;
import xtp;
import xtq;
import xtr;
import xts;
import xtx;
import xty;
import xua;
import xzr;
import yap;
import ykv;
import zhm;

public class StoryPickerFragment
  extends QQStoryBaseFragment
  implements View.OnClickListener, xtx, xty
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public View a;
  public QQStoryPullToRefreshListView a;
  public String a;
  public LinkedHashSet<String> a;
  public xua a;
  public xzr a;
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
    this.leftView.setText(getString(2131690676));
    super.setTitle(anvx.a(2131713918) + vzh.jdField_a_of_type_JavaLangString);
    super.a(String.format(anvx.a(2131713920), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1) {}
    for (;;)
    {
      super.setRightViewTextDisable(i);
      this.jdField_a_of_type_AndroidViewView = super.a(2131366179);
      this.jdField_a_of_type_Xua = new xua(getActivity());
      this.jdField_a_of_type_Xua.a(new xtk(this));
      this.jdField_a_of_type_Xua.a(this);
      this.jdField_a_of_type_Xua.a(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)super.a(2131370221));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Xua);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new xtl(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a.a(new xtm(this));
      return;
      i = 1;
    }
  }
  
  public void a(View paramView, yap paramyap)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) && (!paramyap.b))
    {
      paramView = bhdj.a(getActivity(), 230);
      paramView.setMessage(String.format(anvx.a(2131713922), new Object[] { Integer.valueOf(20), vzh.jdField_a_of_type_JavaLangString }));
      paramView.setPositiveButton(anvx.a(2131713921), new xtn(this));
      paramView.show();
      return;
    }
    int i;
    if (!paramyap.jdField_a_of_type_Boolean)
    {
      paramyap.jdField_a_of_type_Boolean = bool;
      paramView = (ImageView)paramView;
      if (!paramyap.jdField_a_of_type_Boolean) {
        break label150;
      }
      i = 2130840569;
      label115:
      paramView.setImageResource(i);
      if (!paramyap.jdField_a_of_type_Boolean) {
        break label156;
      }
      this.jdField_a_of_type_JavaUtilLinkedHashSet.add(paramyap.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      c();
      return;
      bool = false;
      break;
      label150:
      i = 2130840565;
      break label115;
      label156:
      this.jdField_a_of_type_JavaUtilLinkedHashSet.remove(paramyap.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString, int paramInt, View paramView, yap paramyap)
  {
    if (paramyap.b) {
      Bosses.get().postJob(new xtp(this, "StoryPickerFragment", paramString, paramyap, paramInt, paramView));
    }
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    super.a(paramMap);
    paramMap.put(new xtr(this), "");
    paramMap.put(new xts(this), "");
    paramMap.put(new xtq(this), "");
  }
  
  void b()
  {
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    this.jdField_a_of_type_Xzr = new xzr(QQStoryContext.a().b(), this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Xzr.a();
    super.startTitleProgress();
    this.jdField_a_of_type_Xzr.c();
  }
  
  public void c()
  {
    super.a(String.format(anvx.a(2131713919), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    int i;
    List localList;
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1)
    {
      i = 0;
      setRightViewTextDisable(i);
      if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20)
      {
        localList = this.jdField_a_of_type_Xua.a();
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
          yap localyap = (yap)localIterator.next();
          if (localyap.jdField_a_of_type_Boolean)
          {
            localyap.b = true;
            continue;
            i = 1;
            break;
          }
          localyap.b = false;
        }
        label151:
        i += 1;
      }
    }
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 20) {
      d();
    }
    label174:
    this.jdField_a_of_type_Xua.notifyDataSetChanged();
  }
  
  void d()
  {
    List localList = this.jdField_a_of_type_Xua.a();
    int i = 0;
    while (i < localList.size())
    {
      Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
      while (localIterator.hasNext())
      {
        yap localyap = (yap)localIterator.next();
        if (!localyap.b) {
          localyap.b = true;
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
    return 2131561797;
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
      localObject = new xto(this);
      QQCustomDialog localQQCustomDialog = bhdj.a(getActivity(), 230);
      localQQCustomDialog.setMessage(getString(2131699206, new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()), this.b }));
      localQQCustomDialog.setNegativeButton(2131690697, (DialogInterface.OnClickListener)localObject);
      localQQCustomDialog.setPositiveButton(anvx.a(2131689550), (DialogInterface.OnClickListener)localObject);
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
    if (this.jdField_a_of_type_Xzr != null) {
      this.jdField_a_of_type_Xzr.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ykv.a(18, this.jdField_a_of_type_Long);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    ykv.a("share_story", "exp_all_story", this.jdField_a_of_type_Int, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment
 * JD-Core Version:    0.7.0.1
 */