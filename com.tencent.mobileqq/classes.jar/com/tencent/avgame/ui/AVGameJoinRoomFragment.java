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
  protected View a = null;
  ArrayList<DigitInfo> b;
  DigitsProviderAdapter c;
  TableLayout d;
  TextView e;
  TextView f;
  TextView g;
  TextView h;
  TextView i;
  TextView j;
  TextView k;
  TextView l;
  TextView m;
  TextView n;
  TextView o;
  TextView p;
  ImageView q;
  private final int r = 9;
  private AppInterface s;
  private RecyclerView t;
  private String u;
  private AvGameRoomListObserver v = new AVGameJoinRoomFragment.1(this);
  
  private void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B024", "0X800B024", 0, 0, "", "", "", "");
    if (!TextUtils.isEmpty(this.u))
    {
      if (this.u.length() != 9) {
        return;
      }
      char[] arrayOfChar = new char[9];
      String str = this.u;
      int i2 = str.length();
      int i1 = 0;
      str.getChars(0, i2, arrayOfChar, 0);
      this.b.clear();
      while (i1 < arrayOfChar.length - 1)
      {
        this.b.add(new DigitInfo(Integer.parseInt(String.valueOf(arrayOfChar[i1]))));
        i1 += 1;
      }
      a(Integer.parseInt(String.valueOf(arrayOfChar[(arrayOfChar.length - 1)])));
    }
  }
  
  private void a(int paramInt)
  {
    if (this.b.size() < 9)
    {
      this.b.add(new DigitInfo(paramInt));
      this.c.a(this.b);
      this.c.notifyDataSetChanged();
      if (this.b.size() == 9)
      {
        Object localObject = this.b.iterator();
        StringBuilder localStringBuilder;
        for (String str = ""; ((Iterator)localObject).hasNext(); str = localStringBuilder.toString())
        {
          DigitInfo localDigitInfo = (DigitInfo)((Iterator)localObject).next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(localDigitInfo.a());
        }
        localObject = (IAvGameManager)this.s.getRuntimeService(IAvGameManager.class, "");
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
    paramView.findViewById(2131445043).setBackgroundColor(getQBaseActivity().getResources().getColor(2131168381));
    ((TextView)paramView.findViewById(2131436180)).setVisibility(8);
    TextView localTextView = (TextView)paramView.findViewById(2131436211);
    localTextView.setText(getString(2131887648));
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(new AVGameJoinRoomFragment.2(this));
    localTextView.setTextColor(-1);
    localTextView = (TextView)paramView.findViewById(2131436227);
    localTextView.setText(getString(2131887271));
    localTextView.setTextColor(-1);
    this.b = new ArrayList();
    this.t = ((RecyclerView)paramView.findViewById(2131444518));
    paramView = new LinearLayoutManager(getQBaseActivity(), 0, false);
    this.t.setLayoutManager(paramView);
    this.c = new DigitsProviderAdapter(getQBaseActivity(), 9);
    this.t.setAdapter(this.c);
    this.c.a(this.b);
  }
  
  private void b()
  {
    if (this.b.size() > 0)
    {
      ArrayList localArrayList = this.b;
      localArrayList.remove(localArrayList.size() - 1);
      this.c.a(this.b);
      this.c.notifyDataSetChanged();
    }
  }
  
  private void b(View paramView)
  {
    this.d = ((TableLayout)paramView.findViewById(2131431921));
    this.e = ((TextView)paramView.findViewById(2131439559));
    this.f = ((TextView)paramView.findViewById(2131448888));
    this.g = ((TextView)paramView.findViewById(2131447313));
    this.h = ((TextView)paramView.findViewById(2131433665));
    this.i = ((TextView)paramView.findViewById(2131433223));
    this.j = ((TextView)paramView.findViewById(2131446050));
    this.k = ((TextView)paramView.findViewById(2131445735));
    this.l = ((TextView)paramView.findViewById(2131432393));
    this.m = ((TextView)paramView.findViewById(2131439334));
    this.n = ((TextView)paramView.findViewById(2131450391));
    this.o = ((TextView)paramView.findViewById(2131431708));
    this.p = ((TextView)paramView.findViewById(2131448329));
    this.q = ((ImageView)paramView.findViewById(2131436317));
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
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
    int i1 = paramView.getId();
    if (i1 == 2131436211)
    {
      onBackEvent();
    }
    else if (i1 == 2131439559)
    {
      a(1);
    }
    else if (i1 == 2131448888)
    {
      a(2);
    }
    else if (i1 == 2131447313)
    {
      a(3);
    }
    else if (i1 == 2131433665)
    {
      a(4);
    }
    else if (i1 == 2131433223)
    {
      a(5);
    }
    else if (i1 == 2131446050)
    {
      a(6);
    }
    else if (i1 == 2131445735)
    {
      a(7);
    }
    else if (i1 == 2131432393)
    {
      a(8);
    }
    else if (i1 == 2131439334)
    {
      a(9);
    }
    else if (i1 == 2131450391)
    {
      a(0);
    }
    else if (i1 == 2131431708)
    {
      b();
    }
    else if (i1 == 2131448329)
    {
      this.p.setVisibility(4);
      this.q.setVisibility(4);
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
    paramViewGroup = paramLayoutInflater.inflate(2131624294, paramViewGroup, false);
    this.s = ((AppInterface)getQBaseActivity().getAppRuntime());
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
    this.s.removeObserver(this.v);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.s.addObserver(this.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameJoinRoomFragment
 * JD-Core Version:    0.7.0.1
 */