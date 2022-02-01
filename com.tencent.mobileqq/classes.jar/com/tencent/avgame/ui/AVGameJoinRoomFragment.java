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
import com.tencent.avgame.adapter.DigitsProviderAdapter;
import com.tencent.avgame.business.AvGameManager;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.data.DigitInfo;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class AVGameJoinRoomFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int = 9;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  protected View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TableLayout jdField_a_of_type_AndroidWidgetTableLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  DigitsProviderAdapter jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter;
  private AvGameRoomListObserver jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver = new AVGameJoinRoomFragment.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  ArrayList<DigitInfo> jdField_a_of_type_JavaUtilArrayList;
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
  
  public AVGameJoinRoomFragment()
  {
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  private void a()
  {
    int m = 0;
    ReportController.b(null, "dc00898", "", "", "0X800B024", "0X800B024", 0, 0, "", "", "", "");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangString.length() != 9)) {
      return;
    }
    char[] arrayOfChar = new char[9];
    this.jdField_a_of_type_JavaLangString.getChars(0, this.jdField_a_of_type_JavaLangString.length(), arrayOfChar, 0);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    while (m < arrayOfChar.length - 1)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(new DigitInfo(Integer.parseInt(String.valueOf(arrayOfChar[m]))));
      m += 1;
    }
    a(Integer.parseInt(String.valueOf(arrayOfChar[(arrayOfChar.length - 1)])));
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 9)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(new DigitInfo(paramInt));
      this.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter.notifyDataSetChanged();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 9)
      {
        Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        DigitInfo localDigitInfo;
        for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localDigitInfo.a()) {
          localDigitInfo = (DigitInfo)((Iterator)localObject).next();
        }
        localObject = (AvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
        if (localObject != null)
        {
          ReportController.b(null, "dc00898", "", "", "0X800B025", "0X800B025", 0, 0, "", "", "", "");
          ((AvGameManager)localObject).a(getActivity(), 4, str, null);
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
    paramView.findViewById(2131377297).setBackgroundColor(getActivity().getResources().getColor(2131167310));
    ((TextView)paramView.findViewById(2131369487)).setVisibility(8);
    TextView localTextView = (TextView)paramView.findViewById(2131369518);
    localTextView.setText(getString(2131690800));
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(new AVGameJoinRoomFragment.2(this));
    localTextView.setTextColor(-1);
    localTextView = (TextView)paramView.findViewById(2131369534);
    localTextView.setText(getString(2131690436));
    localTextView.setTextColor(-1);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376815));
    paramView = new LinearLayoutManager(getActivity(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter = new DigitsProviderAdapter(getActivity(), 9);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter);
    this.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      this.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter.notifyDataSetChanged();
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)paramView.findViewById(2131365848));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372508));
    this.b = ((TextView)paramView.findViewById(2131380717));
    this.c = ((TextView)paramView.findViewById(2131379305));
    this.d = ((TextView)paramView.findViewById(2131367427));
    this.e = ((TextView)paramView.findViewById(2131367043));
    this.f = ((TextView)paramView.findViewById(2131378224));
    this.g = ((TextView)paramView.findViewById(2131377923));
    this.h = ((TextView)paramView.findViewById(2131366218));
    this.i = ((TextView)paramView.findViewById(2131372306));
    this.j = ((TextView)paramView.findViewById(2131382135));
    this.k = ((TextView)paramView.findViewById(2131365650));
    this.l = ((TextView)paramView.findViewById(2131380260));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369610));
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
    if (ImmersiveUtils.couldSetStatusTextColor()) {
      ImmersiveUtils.setStatusTextColor(false, getActivity().getWindow());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameJoinRoomFragment", 2, "onCreateView");
    }
    paramViewGroup = paramLayoutInflater.inflate(2131558778, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    b(paramViewGroup);
    a(paramViewGroup);
    ReportController.b(null, "dc00898", "", "", "0X800B022", "0X800B022", 0, 0, "", "", "", "");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AVGameJoinRoomFragment", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameJoinRoomFragment
 * JD-Core Version:    0.7.0.1
 */