package com.tencent.biz.qqstory.shareGroup.widget;

import ajjy;
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
import babr;
import bafb;
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
import sfm;
import uae;
import uaf;
import uag;
import uah;
import uai;
import uaj;
import uak;
import ual;
import uam;
import uar;
import uas;
import uau;
import ugl;
import uhj;
import urp;
import vqi;

public class StoryPickerFragment
  extends QQStoryBaseFragment
  implements View.OnClickListener, uar, uas
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public View a;
  public QQStoryPullToRefreshListView a;
  public String a;
  public LinkedHashSet<String> a;
  public uau a;
  public ugl a;
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
    this.leftView.setText(getString(2131625011));
    super.setTitle(ajjy.a(2131648745) + sfm.jdField_a_of_type_JavaLangString);
    super.a(String.format(ajjy.a(2131648747), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1) {}
    for (;;)
    {
      super.setRightViewTextDisable(i);
      this.jdField_a_of_type_AndroidViewView = super.a(2131300079);
      this.jdField_a_of_type_Uau = new uau(getActivity());
      this.jdField_a_of_type_Uau.a(new uae(this));
      this.jdField_a_of_type_Uau.a(this);
      this.jdField_a_of_type_Uau.a(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)super.a(2131303636));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Uau);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new uaf(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a.a(new uag(this));
      return;
      i = 1;
    }
  }
  
  public void a(View paramView, uhj paramuhj)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) && (!paramuhj.b))
    {
      paramView = babr.a(getActivity(), 230);
      paramView.setMessage(String.format(ajjy.a(2131648749), new Object[] { Integer.valueOf(20), sfm.jdField_a_of_type_JavaLangString }));
      paramView.setPositiveButton(ajjy.a(2131648748), new uah(this));
      paramView.show();
      return;
    }
    int i;
    if (!paramuhj.jdField_a_of_type_Boolean)
    {
      paramuhj.jdField_a_of_type_Boolean = bool;
      paramView = (ImageView)paramView;
      if (!paramuhj.jdField_a_of_type_Boolean) {
        break label150;
      }
      i = 2130840158;
      label115:
      paramView.setImageResource(i);
      if (!paramuhj.jdField_a_of_type_Boolean) {
        break label156;
      }
      this.jdField_a_of_type_JavaUtilLinkedHashSet.add(paramuhj.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      c();
      return;
      bool = false;
      break;
      label150:
      i = 2130840154;
      break label115;
      label156:
      this.jdField_a_of_type_JavaUtilLinkedHashSet.remove(paramuhj.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString, int paramInt, View paramView, uhj paramuhj)
  {
    if (paramuhj.b) {
      Bosses.get().postJob(new uaj(this, "StoryPickerFragment", paramString, paramuhj, paramInt, paramView));
    }
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    super.a(paramMap);
    paramMap.put(new ual(this), "");
    paramMap.put(new uam(this), "");
    paramMap.put(new uak(this), "");
  }
  
  void b()
  {
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    this.jdField_a_of_type_Ugl = new ugl(QQStoryContext.a().b(), this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Ugl.a();
    super.startTitleProgress();
    this.jdField_a_of_type_Ugl.c();
  }
  
  public void c()
  {
    super.a(String.format(ajjy.a(2131648746), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    int i;
    List localList;
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1)
    {
      i = 0;
      setRightViewTextDisable(i);
      if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20)
      {
        localList = this.jdField_a_of_type_Uau.a();
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
          uhj localuhj = (uhj)localIterator.next();
          if (localuhj.jdField_a_of_type_Boolean)
          {
            localuhj.b = true;
            continue;
            i = 1;
            break;
          }
          localuhj.b = false;
        }
        label151:
        i += 1;
      }
    }
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 20) {
      d();
    }
    label174:
    this.jdField_a_of_type_Uau.notifyDataSetChanged();
  }
  
  void d()
  {
    List localList = this.jdField_a_of_type_Uau.a();
    int i = 0;
    while (i < localList.size())
    {
      Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
      while (localIterator.hasNext())
      {
        uhj localuhj = (uhj)localIterator.next();
        if (!localuhj.b) {
          localuhj.b = true;
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
    return 2131495777;
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
        paramView = new uai(this);
        bafb localbafb = babr.a(getActivity(), 230);
        localbafb.setMessage(getString(2131633907, new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()), this.b }));
        localbafb.setNegativeButton(2131625035, paramView);
        localbafb.setPositiveButton(ajjy.a(2131624088), paramView);
        localbafb.show();
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
    if (this.jdField_a_of_type_Ugl != null) {
      this.jdField_a_of_type_Ugl.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    urp.a(18, this.jdField_a_of_type_Long);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    urp.a("share_story", "exp_all_story", this.jdField_a_of_type_Int, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment
 * JD-Core Version:    0.7.0.1
 */