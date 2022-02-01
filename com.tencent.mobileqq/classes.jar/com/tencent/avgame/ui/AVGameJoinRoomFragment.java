package com.tencent.avgame.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.avgame.adapter.DigitsProviderAdapter;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.data.DigitInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class AVGameJoinRoomFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int = 9;
  protected View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TableLayout jdField_a_of_type_AndroidWidgetTableLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  DigitsProviderAdapter jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter;
  private AvGameRoomListObserver jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver = new AVGameJoinRoomFragment.1(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
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
    ReportController.b(null, "dc00898", "", "", "0X800B024", "0X800B024", 0, 0, "", "", "", "");
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_JavaLangString.length() != 9) {
        return;
      }
      char[] arrayOfChar = new char[9];
      String str = this.jdField_a_of_type_JavaLangString;
      int n = str.length();
      int m = 0;
      str.getChars(0, n, arrayOfChar, 0);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      while (m < arrayOfChar.length - 1)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(new DigitInfo(Integer.parseInt(String.valueOf(arrayOfChar[m]))));
        m += 1;
      }
      a(Integer.parseInt(String.valueOf(arrayOfChar[(arrayOfChar.length - 1)])));
    }
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
        StringBuilder localStringBuilder;
        for (String str = ""; ((Iterator)localObject).hasNext(); str = localStringBuilder.toString())
        {
          DigitInfo localDigitInfo = (DigitInfo)((Iterator)localObject).next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(localDigitInfo.a());
        }
        localObject = (IAvGameManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IAvGameManager.class, "");
        if (localObject != null)
        {
          ReportController.b(null, "dc00898", "", "", "0X800B025", "0X800B025", 0, 0, "", "", "", "");
          ((IAvGameManager)localObject).joinAvGameRoom(getQBaseActivity(), 4, str, null);
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
    QPublicTransFragmentActivity.a(paramContext, localIntent, AVGameJoinRoomFragment.class);
  }
  
  private void a(View paramView)
  {
    paramView.findViewById(2131376752).setBackgroundColor(getQBaseActivity().getResources().getColor(2131167338));
    ((TextView)paramView.findViewById(2131369202)).setVisibility(8);
    TextView localTextView = (TextView)paramView.findViewById(2131369233);
    localTextView.setText(getString(2131690728));
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(new AVGameJoinRoomFragment.2(this));
    localTextView.setTextColor(-1);
    localTextView = (TextView)paramView.findViewById(2131369249);
    localTextView.setText(getString(2131690360));
    localTextView.setTextColor(-1);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376307));
    paramView = new LinearLayoutManager(getQBaseActivity(), 0, false);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter = new DigitsProviderAdapter(getQBaseActivity(), 9);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter);
    this.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      localArrayList.remove(localArrayList.size() - 1);
      this.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter.notifyDataSetChanged();
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)paramView.findViewById(2131365684));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372092));
    this.b = ((TextView)paramView.findViewById(2131379985));
    this.c = ((TextView)paramView.findViewById(2131378657));
    this.d = ((TextView)paramView.findViewById(2131367209));
    this.e = ((TextView)paramView.findViewById(2131366893));
    this.f = ((TextView)paramView.findViewById(2131377639));
    this.g = ((TextView)paramView.findViewById(2131377346));
    this.h = ((TextView)paramView.findViewById(2131366108));
    this.i = ((TextView)paramView.findViewById(2131371891));
    this.j = ((TextView)paramView.findViewById(2131381339));
    this.k = ((TextView)paramView.findViewById(2131365494));
    this.l = ((TextView)paramView.findViewById(2131379573));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369318));
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
    int m = paramView.getId();
    if (m == 2131369233)
    {
      onBackEvent();
    }
    else if (m == 2131372092)
    {
      a(1);
    }
    else if (m == 2131379985)
    {
      a(2);
    }
    else if (m == 2131378657)
    {
      a(3);
    }
    else if (m == 2131367209)
    {
      a(4);
    }
    else if (m == 2131366893)
    {
      a(5);
    }
    else if (m == 2131377639)
    {
      a(6);
    }
    else if (m == 2131377346)
    {
      a(7);
    }
    else if (m == 2131366108)
    {
      a(8);
    }
    else if (m == 2131371891)
    {
      a(9);
    }
    else if (m == 2131381339)
    {
      a(0);
    }
    else if (m == 2131365494)
    {
      b();
    }
    else if (m == 2131379573)
    {
      this.l.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (ImmersiveUtils.couldSetStatusTextColor()) {
      ImmersiveUtils.setStatusTextColor(false, getQBaseActivity().getWindow());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameJoinRoomFragment", 2, "onCreateView");
    }
    paramViewGroup = paramLayoutInflater.inflate(2131558677, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getQBaseActivity().getAppRuntime());
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    b(paramViewGroup);
    a(paramViewGroup);
    ReportController.b(null, "dc00898", "", "", "0X800B022", "0X800B022", 0, 0, "", "", "", "");
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AVGameJoinRoomFragment", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameJoinRoomFragment
 * JD-Core Version:    0.7.0.1
 */