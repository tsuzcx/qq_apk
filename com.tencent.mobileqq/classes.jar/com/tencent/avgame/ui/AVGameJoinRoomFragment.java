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
import bdla;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;
import ncs;
import ncz;
import ndm;
import ndu;
import non;
import noo;

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
  ArrayList<ndu> jdField_a_of_type_JavaUtilArrayList;
  ncs jdField_a_of_type_Ncs;
  private ndm jdField_a_of_type_Ndm = new non(this);
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
    bdla.b(null, "dc00898", "", "", "0X800B024", "0X800B024", 0, 0, "", "", "", "");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangString.length() != 9)) {
      return;
    }
    char[] arrayOfChar = new char[9];
    this.jdField_a_of_type_JavaLangString.getChars(0, this.jdField_a_of_type_JavaLangString.length(), arrayOfChar, 0);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    while (m < arrayOfChar.length - 1)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(new ndu(Integer.parseInt(String.valueOf(arrayOfChar[m]))));
      m += 1;
    }
    a(Integer.parseInt(String.valueOf(arrayOfChar[(arrayOfChar.length - 1)])));
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 9)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(new ndu(paramInt));
      this.jdField_a_of_type_Ncs.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Ncs.notifyDataSetChanged();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 9)
      {
        Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        ndu localndu;
        for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localndu.a()) {
          localndu = (ndu)((Iterator)localObject).next();
        }
        localObject = (ncz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
        if (localObject != null)
        {
          bdla.b(null, "dc00898", "", "", "0X800B025", "0X800B025", 0, 0, "", "", "", "");
          ((ncz)localObject).a(getActivity(), 4, str, null);
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
    paramView.findViewById(2131376890).setBackgroundColor(getActivity().getResources().getColor(2131167301));
    ((TextView)paramView.findViewById(2131369231)).setVisibility(8);
    TextView localTextView = (TextView)paramView.findViewById(2131369262);
    localTextView.setText(getString(2131690697));
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(new noo(this));
    localTextView.setTextColor(-1);
    localTextView = (TextView)paramView.findViewById(2131369278);
    localTextView.setText(getString(2131690356));
    localTextView.setTextColor(-1);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376422));
    paramView = new LinearLayoutManager(getActivity(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_Ncs = new ncs(getActivity(), 9);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ncs);
    this.jdField_a_of_type_Ncs.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      this.jdField_a_of_type_Ncs.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Ncs.notifyDataSetChanged();
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)paramView.findViewById(2131365685));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372206));
    this.b = ((TextView)paramView.findViewById(2131380274));
    this.c = ((TextView)paramView.findViewById(2131378874));
    this.d = ((TextView)paramView.findViewById(2131367242));
    this.e = ((TextView)paramView.findViewById(2131366853));
    this.f = ((TextView)paramView.findViewById(2131377812));
    this.g = ((TextView)paramView.findViewById(2131377512));
    this.h = ((TextView)paramView.findViewById(2131366047));
    this.i = ((TextView)paramView.findViewById(2131371998));
    this.j = ((TextView)paramView.findViewById(2131381670));
    this.k = ((TextView)paramView.findViewById(2131365489));
    this.l = ((TextView)paramView.findViewById(2131379832));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369355));
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
    if (ImmersiveUtils.c()) {
      ImmersiveUtils.a(false, getActivity().getWindow());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameJoinRoomFragment", 2, "onCreateView");
    }
    paramViewGroup = paramLayoutInflater.inflate(2131558742, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    b(paramViewGroup);
    a(paramViewGroup);
    bdla.b(null, "dc00898", "", "", "0X800B022", "0X800B022", 0, 0, "", "", "", "");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AVGameJoinRoomFragment", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ndm);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ndm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameJoinRoomFragment
 * JD-Core Version:    0.7.0.1
 */