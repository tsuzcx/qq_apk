package com.tencent.mobileqq.activity.chathistory;

import adpd;
import adpe;
import ahrf;
import ahrh;
import airh;
import airk;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import asku;
import audr;
import bkzi;
import bkzz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopAIOEmotionFragment
  extends IphoneTitleBarFragment
  implements adpe, ahrh, View.OnClickListener
{
  private adpd jdField_a_of_type_Adpd;
  private airh jdField_a_of_type_Airh;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private List<asku> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    setRightButton(2131689980, this);
    this.jdField_a_of_type_Adpd.f();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((asku)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a() {}
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Adpd != null) {
      this.jdField_a_of_type_Adpd.a(paramLong);
    }
  }
  
  public void a(asku paramasku)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramasku);
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.b.setEnabled(true);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size() + 0;; i = 0)
    {
      if (i >= 20) {
        bool = true;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarFragment", 2, "isOverLimit");
        }
        audr.a(2131692370);
      }
      return bool;
    }
  }
  
  public void b()
  {
    ThreadManager.excute(new TroopAIOEmotionFragment.2(this), 32, null, true);
  }
  
  public void b(asku paramasku)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.remove(paramasku);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839431);
    this.b.setImageResource(2130839404);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.mContentView.getContext().getResources().getString(2131691900));
    setRightButton(2131689980, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131370712));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131367216));
    this.b = ((ImageView)this.mContentView.findViewById(2131365469));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131368231);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    paramLayoutInflater = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Adpd = new adpd();
    this.jdField_a_of_type_Adpd.a(getActivity().getIntent(), paramLayoutInflater, getActivity());
    this.jdField_a_of_type_Adpd.a = this;
    paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Adpd.a(), 0, paramLayoutInflater);
    this.jdField_a_of_type_Airh = new airh(getActivity(), 1);
    this.jdField_a_of_type_Airh.a();
    ahrf.a().a(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_Boolean))
    {
      c();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public int getContentLayoutId()
  {
    return 2131558852;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      this.jdField_a_of_type_Airh.a(paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
        this.b.setEnabled(false);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        setRightButton(2131690697, this);
        this.jdField_a_of_type_Adpd.e();
      }
      else
      {
        c();
        continue;
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
        {
          audr.c(2131692367);
        }
        else if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(getActivity(), 2131694305, 1).b(getResources().getDimensionPixelSize(2131299080));
        }
        else
        {
          Object localObject = new ArrayList();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            ((List)localObject).add((ChatMessage)((asku)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          }
          this.jdField_a_of_type_Airh.a((List)localObject);
          c();
          continue;
          if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            audr.c(2131692367);
          }
          else
          {
            localObject = (bkzi)bkzz.a(getActivity(), null);
            ((bkzi)localObject).a(2131695830);
            ((bkzi)localObject).a(getActivity().getString(2131692213), 3);
            ((bkzi)localObject).c(2131690697);
            ((bkzi)localObject).a(new airk(this, (bkzi)localObject));
            ((bkzi)localObject).show();
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Adpd.d();
    this.jdField_a_of_type_Airh.b();
    ahrf.a().b(this);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Adpd.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Adpd.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */