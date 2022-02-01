package com.tencent.mobileqq.activity.chathistory;

import aedq;
import aedr;
import aibo;
import aibq;
import ajby;
import ajcb;
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
import asuo;
import auna;
import bhnv;
import blir;
import blji;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopAIOEmotionFragment
  extends IphoneTitleBarFragment
  implements aedr, aibq, View.OnClickListener
{
  private aedq jdField_a_of_type_Aedq;
  private ajby jdField_a_of_type_Ajby;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private List<asuo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    setRightButton(2131689937, this);
    this.jdField_a_of_type_Aedq.f();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((asuo)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a() {}
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Aedq != null) {
      this.jdField_a_of_type_Aedq.a(paramLong);
    }
  }
  
  public void a(asuo paramasuo)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramasuo);
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
        auna.a(2131692232);
      }
      return bool;
    }
  }
  
  public void b()
  {
    ThreadManager.excute(new TroopAIOEmotionFragment.2(this), 32, null, true);
  }
  
  public void b(asuo paramasuo)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.remove(paramasuo);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839375);
    this.b.setImageResource(2130839348);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.mContentView.getContext().getResources().getString(2131691766));
    setRightButton(2131689937, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131370561));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131367081));
    this.b = ((ImageView)this.mContentView.findViewById(2131365346));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131368060);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    paramLayoutInflater = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Aedq = new aedq();
    this.jdField_a_of_type_Aedq.a(getActivity().getIntent(), paramLayoutInflater, getActivity());
    this.jdField_a_of_type_Aedq.a = this;
    paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Aedq.a(), 0, paramLayoutInflater);
    this.jdField_a_of_type_Ajby = new ajby(getActivity(), 1);
    this.jdField_a_of_type_Ajby.a();
    aibo.a().a(this);
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
    return 2131558819;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      this.jdField_a_of_type_Ajby.a(paramIntent);
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
        setRightButton(2131690580, this);
        this.jdField_a_of_type_Aedq.e();
      }
      else
      {
        c();
        continue;
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
        {
          auna.c(2131692229);
        }
        else if (!bhnv.d(BaseApplication.getContext()))
        {
          QQToast.a(getActivity(), 2131694008, 1).b(getResources().getDimensionPixelSize(2131299011));
        }
        else
        {
          Object localObject = new ArrayList();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            ((List)localObject).add((ChatMessage)((asuo)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          }
          this.jdField_a_of_type_Ajby.a((List)localObject);
          c();
          continue;
          if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            auna.c(2131692229);
          }
          else
          {
            localObject = (blir)blji.a(getActivity(), null);
            ((blir)localObject).a(2131695439);
            ((blir)localObject).a(getActivity().getString(2131692075), 3);
            ((blir)localObject).c(2131690580);
            ((blir)localObject).a(new ajcb(this, (blir)localObject));
            ((blir)localObject).show();
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Aedq.d();
    this.jdField_a_of_type_Ajby.b();
    aibo.a().b(this);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Aedq.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Aedq.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */