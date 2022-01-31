package com.tencent.mobileqq.activity.chathistory;

import acip;
import aciq;
import agdf;
import agdh;
import agzn;
import agzq;
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
import apwd;
import armz;
import bdee;
import bhpy;
import bhql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopAIOEmotionFragment
  extends IphoneTitleBarFragment
  implements aciq, agdh, View.OnClickListener
{
  private acip jdField_a_of_type_Acip;
  private agzn jdField_a_of_type_Agzn;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private List<apwd> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    setRightButton(2131690047, this);
    this.jdField_a_of_type_Acip.f();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((apwd)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a() {}
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Acip != null) {
      this.jdField_a_of_type_Acip.a(paramLong);
    }
  }
  
  public void a(apwd paramapwd)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramapwd);
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
        armz.a(2131692639);
      }
      return bool;
    }
  }
  
  public void b()
  {
    ThreadManager.excute(new TroopAIOEmotionFragment.2(this), 32, null, true);
  }
  
  public void b(apwd paramapwd)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.remove(paramapwd);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839190);
    this.b.setImageResource(2130839164);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.mContentView.getContext().getResources().getString(2131692122));
    setRightButton(2131690047, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131369998));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131366752));
    this.b = ((ImageView)this.mContentView.findViewById(2131365063));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131367665);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    paramLayoutInflater = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Acip = new acip();
    this.jdField_a_of_type_Acip.a(getActivity().getIntent(), paramLayoutInflater, getActivity());
    this.jdField_a_of_type_Acip.a = this;
    paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Acip.a(), 0, paramLayoutInflater);
    this.jdField_a_of_type_Agzn = new agzn(getActivity(), 1);
    this.jdField_a_of_type_Agzn.a();
    agdf.a().a(this);
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
    return 2131558756;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      this.jdField_a_of_type_Agzn.a(paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368644: 
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
        this.b.setEnabled(false);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        setRightButton(2131690648, this);
        this.jdField_a_of_type_Acip.e();
        return;
      }
      c();
      return;
    case 2131366752: 
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        armz.c(2131692636);
        return;
      }
      if (!bdee.d(BaseApplication.getContext()))
      {
        QQToast.a(getActivity(), 2131694829, 1).b(getResources().getDimensionPixelSize(2131298914));
        return;
      }
      paramView = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        paramView.add((ChatMessage)((apwd)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      this.jdField_a_of_type_Agzn.a(paramView);
      c();
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      armz.c(2131692636);
      return;
    }
    paramView = (bhpy)bhql.a(getActivity(), null);
    paramView.a(2131696568);
    paramView.a(getActivity().getString(2131692485), 3);
    paramView.c(2131690648);
    paramView.a(new agzq(this, paramView));
    paramView.show();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Acip.d();
    this.jdField_a_of_type_Agzn.b();
    agdf.a().b(this);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Acip.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Acip.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */