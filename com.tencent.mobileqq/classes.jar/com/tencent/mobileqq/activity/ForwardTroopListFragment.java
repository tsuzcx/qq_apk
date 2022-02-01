package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.ResultRecord.DefaultComparator;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar.ISelectedAndSearchBarCallback;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ForwardTroopListFragment
  extends PublicBaseFragment
{
  private InputMethodManager A;
  private Dialog B;
  private ForwardBaseOption C;
  protected ForwardTroopListAdapter a;
  protected SwipPinnedHeaderExpandableListView b;
  protected ForwardTroopListFragment.MyAvatarObserver c;
  protected ForwardTroopListFragment.MyRoamSettingObserver d;
  protected ForwardTroopListFragment.MyTroopObserver e;
  protected ForwardTroopListFragment.MyTroopModifyObserver f;
  protected ForwardTroopListFragment.MyTroopMngObserver g;
  protected ForwardTroopListFragment.MyMessageObserver h;
  protected TroopCommonlyUsedObserver i = new ForwardTroopListFragment.4(this);
  private QQAppInterface j;
  private Context k;
  private View l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private FrameLayout q;
  private SelectedAndSearchBar r;
  private AutomatorObserver s = new ForwardTroopListFragment.5(this);
  private Map<String, ResultRecord> t = new LinkedHashMap();
  private IFaceDecoder u;
  private IQQGuildService v;
  private ForwardTroopListAdapter.IForwardTroopListAdapterCallback w = new ForwardTroopListFragment.6(this);
  private ContactSearchFragment x;
  private SelectedAndSearchBar.ISelectedAndSearchBarCallback y = new ForwardTroopListFragment.7(this);
  private ContactSearchResultPresenter.OnActionListener z = new ForwardTroopListFragment.8(this);
  
  private String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void a(View paramView)
  {
    paramView = ((ForwardRecentItemView)paramView).k;
    if (b(paramView.uin, paramView.getUinType())) {
      c(paramView.uin, paramView.getUinType());
    } else {
      a(paramView);
    }
    this.a.notifyDataSetChanged();
  }
  
  private void a(List<ResultRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((ResultRecord)paramList.next());
      }
    }
  }
  
  private boolean a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {
      return false;
    }
    String str = a(paramResultRecord.uin, paramResultRecord.getUinType());
    ResultRecord localResultRecord = (ResultRecord)this.t.get(str);
    if (localResultRecord != null)
    {
      localResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
      paramResultRecord = new ArrayList(this.t.values());
      this.r.a(paramResultRecord, false);
      return false;
    }
    if (this.t.size() == 9)
    {
      k();
      return false;
    }
    paramResultRecord = ResultRecord.copyResultRecord(paramResultRecord);
    paramResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
    this.t.put(str, paramResultRecord);
    h();
    paramResultRecord = new ArrayList(this.t.values());
    this.r.a(paramResultRecord, true);
    return true;
  }
  
  private void b()
  {
    this.b = ((SwipPinnedHeaderExpandableListView)this.l.findViewById(2131437330));
    this.b.setSelector(2131168376);
    this.b.setNeedCheckSpringback(true);
    this.b.setGroupIndicator(null);
    this.b.setDivider(null);
    this.b.setPadding(0, 0, 0, AIOUtils.b(54.0F, getResources()));
    this.b.setClipToPadding(false);
    this.b.setScrollBarStyle(33554432);
    this.q = ((FrameLayout)this.l.findViewById(2131444724));
    i();
    d();
  }
  
  private boolean b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.t.containsKey(a(paramString, paramInt));
  }
  
  private void c()
  {
    a(getArguments().getParcelableArrayList("selected_target_list"));
  }
  
  private void c(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = a(paramString, paramInt);
    this.t.remove(paramString);
    h();
    paramString = new ArrayList(this.t.values());
    this.r.a(paramString, true);
  }
  
  private void d()
  {
    this.m = ((TextView)this.l.findViewById(2131436211));
    this.n = ((TextView)this.l.findViewById(2131436182));
    this.o = ((TextView)this.l.findViewById(2131436180));
    this.p = ((TextView)this.l.findViewById(2131436227));
    this.l.findViewById(2131436180).setVisibility(8);
    this.o.setVisibility(0);
    this.o.setText("");
    this.p.setText(HardCodeUtil.a(2131902840));
    this.n.setVisibility(8);
    Object localObject = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(29.0F, getResources());
    if (Build.VERSION.SDK_INT <= 18) {
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(75.0F, getResources());
    }
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(10.0F, getResources());
    this.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.m.setPadding(AIOUtils.b(7.0F, getResources()), 0, AIOUtils.b(7.0F, getResources()), 0);
    this.m.setBackgroundResource(2130846654);
    this.m.setTextSize(1, 14.0F);
    this.m.setVisibility(0);
    h();
    this.o.setOnClickListener(new ForwardTroopListFragment.1(this));
    this.m.setOnClickListener(new ForwardTroopListFragment.2(this));
    this.m.setMaxWidth(AIOUtils.b(260.0F, getResources()));
    if (AppSetting.e)
    {
      localObject = this.p;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
      localObject = this.m;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
      this.o.setContentDescription(HardCodeUtil.a(2131901576));
    }
  }
  
  private void e()
  {
    if (this.b != null)
    {
      ForwardTroopListAdapter localForwardTroopListAdapter = this.a;
      if (localForwardTroopListAdapter != null) {
        localForwardTroopListAdapter.c();
      }
      this.a = new ForwardTroopListAdapter(getBaseActivity(), this.j, this.b, this.w);
      this.b.setAdapter(this.a);
      this.b.setOnGroupClickListener(this.a);
    }
  }
  
  private void f()
  {
    if (this.c == null) {
      this.c = new ForwardTroopListFragment.MyAvatarObserver(this);
    }
    if (this.d == null) {
      this.d = new ForwardTroopListFragment.MyRoamSettingObserver(this);
    }
    if (this.f == null) {
      this.f = new ForwardTroopListFragment.MyTroopModifyObserver(this);
    }
    if (this.g == null) {
      this.g = new ForwardTroopListFragment.MyTroopMngObserver(this);
    }
    if (this.e == null) {
      this.e = new ForwardTroopListFragment.MyTroopObserver(this);
    }
    if (this.h == null) {
      this.h = new ForwardTroopListFragment.MyMessageObserver(this);
    }
    this.j.addObserver(this.c);
    this.j.addObserver(this.d);
    this.j.addObserver(this.e);
    this.j.addObserver(this.g);
    this.j.addObserver(this.f);
    this.j.addObserver(this.h);
    this.j.addObserver(this.i);
    this.j.addObserver(this.s);
  }
  
  private void g()
  {
    this.j.removeObserver(this.c);
    this.j.removeObserver(this.d);
    this.j.removeObserver(this.e);
    this.j.removeObserver(this.g);
    this.j.removeObserver(this.f);
    this.j.removeObserver(this.h);
    this.j.removeObserver(this.i);
    this.j.removeObserver(this.s);
  }
  
  private void h()
  {
    if (this.t.isEmpty())
    {
      this.m.setText(HardCodeUtil.a(2131902845));
      this.m.setClickable(false);
      this.m.setTextColor(855836698);
    }
    else
    {
      this.m.setText(String.format(HardCodeUtil.a(2131902836), new Object[] { Integer.valueOf(this.t.size()) }));
      this.m.setClickable(true);
      this.m.setTextColor(getResources().getColor(2131168001));
    }
    Object localObject;
    if (AppSetting.e)
    {
      localObject = this.m;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("rightBtn width: ");
      ((StringBuilder)localObject).append(this.m.getMeasuredWidth());
      QLog.i("contacts.fragment.TroopFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void i()
  {
    this.A = ((InputMethodManager)this.k.getSystemService("input_method"));
    this.r = ((SelectedAndSearchBar)this.l.findViewById(2131445550));
    this.u = ((IQQAvatarService)this.j.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.j);
    this.v = ((IQQGuildService)this.j.getRuntimeService(IQQGuildService.class, ""));
    this.r.a(null, this.u, this.y, this.v);
  }
  
  private void j()
  {
    this.A.hideSoftInputFromWindow(getBaseActivity().getWindow().peekDecorView().getWindowToken(), 0);
    this.r.b();
    this.r.c();
    this.q.setVisibility(8);
  }
  
  private void k()
  {
    if (this.B == null) {
      this.B = DialogUtil.a(getBaseActivity(), getBaseActivity().getResources().getString(2131896914), 0, 2131892366, null, new ForwardTroopListFragment.9(this));
    }
    if (!getBaseActivity().isFinishing()) {
      this.B.show();
    }
  }
  
  private void l()
  {
    if (this.t.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("contacts.fragment.TroopFragment", 2, "forward2MultiTargets map is empty !");
      }
      return;
    }
    if (this.C == null) {
      this.C = ForwardOptionBuilder.a(getBaseActivity().getIntent(), this.j, getBaseActivity());
    }
    ArrayList localArrayList = new ArrayList(this.t.values());
    Collections.sort(localArrayList, new ResultRecord.DefaultComparator());
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    this.C.a(ForwardAbility.ForwardAbilityType.b.intValue(), localBundle);
    this.C.v();
  }
  
  void a()
  {
    ForwardTroopListAdapter localForwardTroopListAdapter = this.a;
    if (localForwardTroopListAdapter != null) {
      localForwardTroopListAdapter.notifyDataSetChanged();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771996, 2130771995);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.q.getVisibility() != 8)
    {
      j();
      return true;
    }
    if (this.r.a()) {
      j();
    }
    return super.onBackEvent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.j = getBaseActivity().app;
    this.k = getBaseActivity();
    this.l = paramLayoutInflater.inflate(2131624871, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.l.setFitsSystemWindows(true);
      this.l.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    b();
    c();
    paramLayoutInflater = this.l;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "doOnDestroy");
    }
    ForwardTroopListAdapter localForwardTroopListAdapter = this.a;
    if (localForwardTroopListAdapter != null) {
      localForwardTroopListAdapter.c();
    }
    this.u.destory();
    g();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ForwardBaseOption localForwardBaseOption = this.C;
    if (localForwardBaseOption != null) {
      localForwardBaseOption.ad();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    g();
  }
  
  public void onResume()
  {
    super.onResume();
    f();
    if (this.a == null) {
      e();
    }
    this.b.postDelayed(new ForwardTroopListFragment.3(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment
 * JD-Core Version:    0.7.0.1
 */