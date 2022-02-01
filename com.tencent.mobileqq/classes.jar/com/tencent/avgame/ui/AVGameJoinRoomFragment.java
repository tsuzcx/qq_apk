package com.tencent.avgame.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import bdll;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;
import mws;
import mxc;
import mxp;
import mxx;
import ngl;
import ngm;

public class AVGameJoinRoomFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int = 9;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TableLayout jdField_a_of_type_AndroidWidgetTableLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  ArrayList<mxx> jdField_a_of_type_JavaUtilArrayList;
  mws jdField_a_of_type_Mws;
  private mxp jdField_a_of_type_Mxp = new ngl(this);
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  TextView g;
  TextView h;
  TextView i;
  TextView j;
  TextView k;
  TextView l;
  
  private void a()
  {
    int m = 0;
    bdll.b(null, "dc00898", "", "", "0X800B024", "0X800B024", 0, 0, "", "", "", "");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangString.length() != 9)) {
      return;
    }
    char[] arrayOfChar = new char[9];
    this.jdField_a_of_type_JavaLangString.getChars(0, this.jdField_a_of_type_JavaLangString.length(), arrayOfChar, 0);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    while (m < arrayOfChar.length - 1)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(new mxx(Integer.parseInt(String.valueOf(arrayOfChar[m]))));
      m += 1;
    }
    a(Integer.parseInt(String.valueOf(arrayOfChar[(arrayOfChar.length - 1)])));
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 9)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(new mxx(paramInt));
      this.jdField_a_of_type_Mws.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Mws.notifyDataSetChanged();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 9)
      {
        Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        mxx localmxx;
        for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localmxx.a()) {
          localmxx = (mxx)((Iterator)localObject).next();
        }
        localObject = (mxc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(373);
        if (localObject != null)
        {
          bdll.b(null, "dc00898", "", "", "0X800B025", "0X800B025", 0, 0, "", "", "", "");
          ((mxc)localObject).a(getActivity(), 4, str, null);
        }
        ThreadManager.getUIHandler().postDelayed(new AVGameJoinRoomFragment.3(this), 1000L);
      }
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.addFlags(268435456);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicTransFragmentActivity.b(paramContext, localIntent, AVGameJoinRoomFragment.class);
  }
  
  private void a(View paramView)
  {
    paramView.findViewById(2131376869).setBackgroundColor(getActivity().getResources().getColor(2131167252));
    ((TextView)paramView.findViewById(2131369042)).setVisibility(8);
    TextView localTextView = (TextView)paramView.findViewById(2131369073);
    localTextView.setText(getString(2131690580));
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(new ngm(this));
    ((TextView)paramView.findViewById(2131369088)).setText(getString(2131690292));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376406));
    paramView = new LinearLayoutManager(getActivity(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_Mws = new mws(getActivity(), 9);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Mws);
    this.jdField_a_of_type_Mws.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      this.jdField_a_of_type_Mws.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Mws.notifyDataSetChanged();
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)paramView.findViewById(2131365559));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372049));
    this.b = ((TextView)paramView.findViewById(2131380207));
    this.c = ((TextView)paramView.findViewById(2131378817));
    this.d = ((TextView)paramView.findViewById(2131367107));
    this.e = ((TextView)paramView.findViewById(2131366707));
    this.f = ((TextView)paramView.findViewById(2131377772));
    this.g = ((TextView)paramView.findViewById(2131377476));
    this.h = ((TextView)paramView.findViewById(2131365916));
    this.i = ((TextView)paramView.findViewById(2131371842));
    this.j = ((TextView)paramView.findViewById(2131381590));
    this.k = ((TextView)paramView.findViewById(2131365363));
    this.l = ((TextView)paramView.findViewById(2131379738));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369170));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
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
      onBackEvent();
      continue;
      a(1);
      continue;
      a(2);
      continue;
      a(3);
      continue;
      a(4);
      continue;
      a(5);
      continue;
      a(6);
      continue;
      a(7);
      continue;
      a(8);
      continue;
      a(9);
      continue;
      a(0);
      continue;
      b();
      continue;
      this.l.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      a();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameJoinRoomFragment", 2, "onCreateView");
    }
    paramViewGroup = paramLayoutInflater.inflate(2131558722, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    b(paramViewGroup);
    a(paramViewGroup);
    bdll.b(null, "dc00898", "", "", "0X800B022", "0X800B022", 0, 0, "", "", "", "");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AVGameJoinRoomFragment", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Mxp);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Mxp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameJoinRoomFragment
 * JD-Core Version:    0.7.0.1
 */