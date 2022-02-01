package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.search.ReadInJoySearchTipsContainer;
import com.tencent.mobileqq.kandian.biz.search.api.OnTipClickListener;
import com.tencent.mobileqq.kandian.biz.search.entity.TipsInfo;
import com.tencent.mobileqq.kandian.biz.search.entity.WordItem;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClassificationSearchActivity
  extends SearchBaseActivity
  implements ReadInJoySearchHistoryAdapter.OnItemClickObserver
{
  private static SearchResult N;
  public static int k = 1;
  public static int l = 2;
  public static int m = 3;
  public static int n = 4;
  public static int o = 5;
  public static String p = "is_from";
  static String r = "";
  static String s = "";
  protected Handler A = new ClassificationSearchActivity.16(this);
  private View.OnClickListener O = new ClassificationSearchActivity.6(this);
  private TextView.OnEditorActionListener P = new ClassificationSearchActivity.7(this);
  private View.OnTouchListener Q = new ClassificationSearchActivity.12(this);
  XListView a;
  View b;
  View c;
  View d;
  ReadInJoySearchTipsContainer e;
  View f;
  View g;
  ReadInJoySearchTipsContainer h;
  boolean i = false;
  List<ReadInJoySearchHistoryEntity> j = new ArrayList();
  int q = 0;
  View t;
  List<WordItem> u = new ArrayList();
  List<ChannelInfo> v = new ArrayList();
  SearchProtocol.SearchObserver w = new ClassificationSearchActivity.8(this);
  protected ReadInJoyObserver x = new ClassificationSearchActivity.9(this);
  OnTipClickListener y = new ClassificationSearchActivity.10(this);
  OnTipClickListener z = new ClassificationSearchActivity.11(this);
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 80000003: 
      return HardCodeUtil.a(2131900130);
    case 80000002: 
      if (UniteSearchActivity.f == 12)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131900131));
        localStringBuilder.append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()));
        return localStringBuilder.toString();
      }
      return HardCodeUtil.a(2131900138);
    case 80000001: 
      return HardCodeUtil.a(2131900134);
    }
    return HardCodeUtil.a(2131900128);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, SearchResult paramSearchResult)
  {
    N = paramSearchResult;
    s = paramIntent.getStringExtra("last_hint");
    paramActivity.startActivityForResult(paramIntent, 1);
  }
  
  private void b(String paramString)
  {
    Object localObject = paramString.trim();
    try
    {
      paramString = URLEncoder.encode((String)localObject, "utf-8");
      localObject = paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label14:
      String str;
      break label14;
    }
    str = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadinjoySearchUrl();
    if (str != null)
    {
      paramString = str;
      if (str.contains("keyword")) {
        paramString = str.replace("keyword", (CharSequence)localObject);
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("https://so.mp.qq.com/search/index?key=");
      paramString.append((String)localObject);
      paramString.append("&_wv=3&_bid=2321");
      paramString = paramString.toString();
    }
    localObject = new ActivityURIRequest(this, "/pubaccount/browser");
    ((ActivityURIRequest)localObject).extra().putString("url", paramString);
    QRoute.startUri((URIRequest)localObject, null);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.v;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      this.h.setOnTipsClickListener(this.y);
      localObject = new ArrayList();
      Iterator localIterator = this.v.iterator();
      while (localIterator.hasNext())
      {
        ChannelInfo localChannelInfo = (ChannelInfo)localIterator.next();
        TipsInfo localTipsInfo = new TipsInfo();
        localTipsInfo.word = localChannelInfo.mChannelName;
        localTipsInfo.frameColor = localChannelInfo.mFrameColor;
        localTipsInfo.textColor = localChannelInfo.mFontColor;
        ((List)localObject).add(localTipsInfo);
      }
      this.h.a((List)localObject);
      if (paramBoolean) {
        h();
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.u == null) {
      return;
    }
    this.e.setOnTipsClickListener(this.z);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((WordItem)localIterator.next());
    }
    this.e.b(localArrayList);
    if (paramBoolean) {
      h();
    }
  }
  
  private void g()
  {
    this.f = LayoutInflater.from(this).inflate(2131626012, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.f.setLayoutParams(localLayoutParams);
    this.a = ((XListView)this.f.findViewById(2131445429));
    this.a.setOnTouchListener(this.Q);
    this.b = LayoutInflater.from(this).inflate(2131625632, null);
    this.b.setOnTouchListener(this.Q);
    this.e = ((ReadInJoySearchTipsContainer)this.b.findViewById(2131447419));
    int i1 = this.q;
    if ((i1 == k) || (i1 == n)) {
      this.e.setMaxLines(-1);
    }
    this.c = this.b.findViewById(2131445430);
    this.d = this.b.findViewById(2131447437);
    this.h = ((ReadInJoySearchTipsContainer)this.b.findViewById(2131430503));
    this.g = this.b.findViewById(2131430502);
    this.a.addHeaderView(this.b);
  }
  
  private void h()
  {
    List localList = this.u;
    if ((localList == null) || (localList.size() == 0))
    {
      localList = this.v;
      if ((localList == null) || (localList.isEmpty()))
      {
        localList = this.j;
        if ((localList == null) || (localList.size() == 0)) {
          break label205;
        }
      }
    }
    this.M.a(this.f);
    localList = this.v;
    if ((localList != null) && (!localList.isEmpty())) {
      this.g.setVisibility(0);
    } else {
      this.g.setVisibility(8);
    }
    localList = this.u;
    if ((localList != null) && (localList.size() != 0)) {
      this.d.setVisibility(0);
    } else {
      this.d.setVisibility(8);
    }
    localList = this.j;
    if ((localList != null) && (localList.size() != 0)) {
      this.c.setVisibility(0);
    } else {
      this.c.setVisibility(8);
    }
    this.a.setSelection(0);
    a(true);
    return;
    label205:
    if (this.M != null)
    {
      this.M.e();
      a(false);
    }
  }
  
  public void a()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    Object localObject = new ClassificationSearchActivity.15(this);
    localQQCustomDialog.setPositiveButton(2131893784, (DialogInterface.OnClickListener)localObject);
    localQQCustomDialog.setNegativeButton(2131893783, (DialogInterface.OnClickListener)localObject);
    localObject = getString(2131893785);
    localQQCustomDialog.setTitle(2131895038);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getResources().getColor(2131165794));
    localTextView.setText((CharSequence)localObject);
    localTextView.setGravity(1);
    localQQCustomDialog.addView(localTextView);
    localQQCustomDialog.show();
  }
  
  public void a(ReadInJoySearchHistoryEntity paramReadInJoySearchHistoryEntity)
  {
    if (this.q == k)
    {
      this.K.setText(paramReadInJoySearchHistoryEntity.keyWord);
      if (!TextUtils.isEmpty(paramReadInJoySearchHistoryEntity.keyWord)) {
        this.K.setSelection(this.K.getText().length());
      }
      b(paramReadInJoySearchHistoryEntity.keyWord);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006819", "0X8006819", 0, 0, paramReadInJoySearchHistoryEntity.keyWord, "", "", "");
      return;
    }
    this.M.a(paramReadInJoySearchHistoryEntity.keyWord, false);
  }
  
  public void a(String paramString)
  {
    ThreadManager.post(new ClassificationSearchActivity.13(this, paramString), 10, null, true);
  }
  
  protected void a(List<ReadInJoySearchHistoryEntity> paramList, boolean paramBoolean)
  {
    this.j = paramList;
    if (paramBoolean) {
      h();
    }
    if (this.a.getAdapter() == null)
    {
      paramList = new ReadInJoySearchHistoryAdapter(this, paramList, this);
      this.a.setAdapter(paramList);
      return;
    }
    if ((this.a.getAdapter() instanceof HeaderViewListAdapter))
    {
      ReadInJoySearchHistoryAdapter localReadInJoySearchHistoryAdapter = (ReadInJoySearchHistoryAdapter)((HeaderViewListAdapter)this.a.getAdapter()).getWrappedAdapter();
      if (localReadInJoySearchHistoryAdapter != null) {
        localReadInJoySearchHistoryAdapter.a(paramList);
      }
    }
    else
    {
      ((ReadInJoySearchHistoryAdapter)this.a.getAdapter()).a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (ThemeUtil.isInNightMode(this.app))
    {
      if (paramBoolean)
      {
        this.M.j.setBackgroundColor(-1);
        localView = this.t;
        if (localView != null) {
          ((ViewGroup)localView.getParent()).removeView(this.t);
        }
        this.t = new View(this);
        this.t.setBackgroundColor(1996488704);
        addContentView(this.t, new ViewGroup.LayoutParams(-1, -1));
        return;
      }
      if (this.M.j != null) {
        this.M.j.setBackgroundColor(0);
      }
      View localView = this.t;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  protected void b()
  {
    super.b();
    Intent localIntent = getIntent();
    if (localIntent.hasExtra(p)) {
      this.q = localIntent.getIntExtra(p, 0);
    }
  }
  
  protected void c()
  {
    super.c();
    Object localObject = N;
    if (localObject != null)
    {
      localObject = a(((SearchResult)localObject).a);
      this.K.setHint((CharSequence)localObject);
    }
    this.K.addTextChangedListener(new ClassificationSearchActivity.2(this));
    this.K.setOnEditorActionListener(this.P);
    this.L.setOnClickListener(new ClassificationSearchActivity.3(this));
    this.I.setOnClickListener(this.O);
    if (AppSetting.e)
    {
      localObject = this.K;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131900135));
      localStringBuilder.append(this.F);
      ((EditText)localObject).setContentDescription(localStringBuilder.toString());
    }
    this.J.setOnClickListener(new ClassificationSearchActivity.4(this));
    int i1 = this.q;
    if ((i1 == k) || (i1 == n))
    {
      g();
      Looper.myQueue().addIdleHandler(new ClassificationSearchActivity.5(this));
    }
  }
  
  protected SearchBaseFragment d()
  {
    if (N == null)
    {
      int i1 = this.q;
      if ((i1 == k) || (i1 == n) || (i1 == o) || (i1 == l) || (i1 == m)) {
        return ClassificationSearchFragment.a(this.q);
      }
    }
    return ClassificationSearchFragment.a(N);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    this.K.setText(this.F);
    if (!TextUtils.isEmpty(this.F))
    {
      this.K.requestFocus();
      this.K.setSelection(this.K.getText().length());
    }
    this.i = true;
    int i1 = this.q;
    if (i1 == k)
    {
      e();
      SearchProtocol.a(this.app, this, this.w);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.x);
      if (((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().G() == 0)
      {
        ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(1, 1);
        return bool;
      }
    }
    else if (i1 == n)
    {
      a(null, true);
      SearchProtocol.a(this.app, this, this.w);
    }
    return bool;
  }
  
  protected void doOnDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.x);
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    int i1 = this.q;
    if ((i1 == k) || (i1 == n) || (i1 == o)) {
      ((ClassificationSearchFragment)this.M).a(true);
    }
    if (((ClassificationSearchFragment)this.M).d())
    {
      Looper.myQueue().addIdleHandler(new ClassificationSearchActivity.1(this));
      ((ClassificationSearchFragment)this.M).a(false);
    }
    if (this.q == k)
    {
      if (!TextUtils.isEmpty(s))
      {
        this.K.setEllipsize(TextUtils.TruncateAt.END);
        this.K.setHint(s);
      }
      else if (!TextUtils.isEmpty(""))
      {
        this.K.setEllipsize(TextUtils.TruncateAt.END);
        this.K.setHint("");
      }
      else
      {
        this.K.setHint(HardCodeUtil.a(2131900142));
      }
      h();
    }
    if (this.q == n)
    {
      this.K.setHint(HardCodeUtil.a(2131900133));
      h();
    }
    if (this.q == l)
    {
      this.K.setHint(HardCodeUtil.a(2131900124));
      h();
      if ((!TextUtils.isEmpty(r)) && (this.i)) {
        this.M.a(r, false);
      }
    }
    if (this.q == m)
    {
      this.L.setVisibility(8);
      if (this.K.getText().toString().equals("")) {
        this.M.e();
      }
      this.K.setHint(HardCodeUtil.a(2131900125));
    }
    if (this.q == o)
    {
      if (this.K.getText().toString().equals("")) {
        this.M.e();
      }
      this.K.setHint(HardCodeUtil.a(2131900129));
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (((ClassificationSearchFragment)this.M).d()) {
      this.M.e();
    }
    this.i = false;
  }
  
  public void e()
  {
    ThreadManager.post(new ClassificationSearchActivity.14(this), 10, null, true);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity
 * JD-Core Version:    0.7.0.1
 */