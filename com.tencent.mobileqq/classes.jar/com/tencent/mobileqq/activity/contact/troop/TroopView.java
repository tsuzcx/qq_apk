package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.OnTroopListClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItem;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import mqq.app.AppRuntime;

public class TroopView
  extends BaseTroopView
  implements View.OnClickListener, TroopListAdapter2.OnTroopListClickListener, SlideDetectListView.OnSlideListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  protected ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack A;
  protected TroopCommonlyUsedObserver B = new TroopView.1(this);
  protected SlideDetectListView j;
  protected TroopListAdapter2 k;
  boolean l = false;
  protected PullRefreshHeader m;
  protected TroopView.MyRoamSettingObserver n = new TroopView.MyRoamSettingObserver(this);
  protected TroopView.MyTroopObserver o = new TroopView.MyTroopObserver(this);
  protected TroopView.MyTroopModifyObserver p = new TroopView.MyTroopModifyObserver(this);
  protected TroopView.MyTroopMngObserver q = new TroopView.MyTroopMngObserver(this);
  protected TroopView.MyAvatarObserver r = new TroopView.MyAvatarObserver(this);
  protected TroopView.MyMessageObserver s = new TroopView.MyMessageObserver(this);
  protected View t = null;
  RelativeLayout u;
  TextView v = null;
  TextView w = null;
  int x;
  protected boolean y = false;
  protected int z;
  
  public TroopView(Context paramContext, boolean paramBoolean, ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack paramIShowExternalTroopDataChangedCallBack)
  {
    super(paramContext);
    this.y = paramBoolean;
    this.A = paramIShowExternalTroopDataChangedCallBack;
  }
  
  private void b(String paramString1, String paramString2)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = AIOUtils.a(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramString2);
    a(localIntent);
  }
  
  private long getTroopLastRefreshTime()
  {
    return getActivity().getSharedPreferences("rec_last_troop_list_refresh_time", 0).getLong("rec_last_troop_list_refresh_time", 0L);
  }
  
  private void m()
  {
    this.j = ((SlideDetectListView)findViewById(2131441547));
    this.j.setNeedCheckSpringback(true);
    LayoutInflater localLayoutInflater = LayoutInflater.from(getActivity());
    this.u = ((RelativeLayout)findViewById(2131445064));
    this.v = ((TextView)findViewById(2131448101));
    this.w = ((TextView)findViewById(2131448100));
    if (this.y)
    {
      localObject = localLayoutInflater.inflate(2131626749, this.j, false);
      ((TextView)((View)localObject).findViewById(2131441514)).setText(getActivity().getString(2131893980));
      this.j.addHeaderView((View)localObject);
    }
    else
    {
      this.t = localLayoutInflater.inflate(2131629215, this.j, false);
      this.t.findViewById(2131429816).setVisibility(8);
      localObject = (EditText)this.t.findViewById(2131432634);
      ((EditText)localObject).setFocusableInTouchMode(false);
      ((EditText)localObject).setOnClickListener(this);
      ((EditText)localObject).setCursorVisible(false);
      if (this.z != 3) {
        this.j.addHeaderView(this.t);
      }
    }
    Object localObject = new View(getContext());
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(12.0F, getResources())));
    this.j.addHeaderView((View)localObject);
    this.m = ((PullRefreshHeader)localLayoutInflater.inflate(2131625671, this.j, false));
    this.j.setTranscriptMode(0);
    this.j.setOverScrollHeader(this.m);
    this.j.setOverScrollListener(this);
    if (!this.a.i()) {
      this.j.setOnSlideListener(this);
    }
  }
  
  private void n()
  {
    long l1 = System.currentTimeMillis();
    getActivity().getSharedPreferences("rec_last_troop_list_refresh_time", 0).edit().putLong("rec_last_troop_list_refresh_time", l1).commit();
  }
  
  private void setFloatingView(int paramInt)
  {
    if (getActivity() != null)
    {
      Object localObject1 = this.k;
      if (localObject1 == null) {
        return;
      }
      int i = paramInt - 2;
      if ((i >= 0) && (i < ((TroopListAdapter2)localObject1).getCount()))
      {
        localObject1 = this.k.getItem(i);
        if (!(localObject1 instanceof TroopListItem)) {
          return;
        }
        i = ((TroopListItem)localObject1).a;
        String str = null;
        switch (i)
        {
        default: 
          localObject1 = null;
          break;
        case 8: 
        case 9: 
          str = HardCodeUtil.a(2131913074);
          localObject1 = String.valueOf(this.k.m);
          break;
        case 6: 
        case 7: 
          str = HardCodeUtil.a(2131913076);
          localObject1 = String.valueOf(this.k.j);
          break;
        case 4: 
        case 5: 
          str = HardCodeUtil.a(2131913073);
          localObject1 = String.valueOf(this.k.h);
          break;
        case 2: 
        case 3: 
          str = HardCodeUtil.a(2131913069);
          localObject1 = String.valueOf(this.k.k);
          break;
        case 0: 
        case 1: 
          str = HardCodeUtil.a(2131913072);
          localObject1 = String.valueOf(this.k.l);
        }
        Object localObject2 = (TroopListItem)this.k.getItem(paramInt - 1);
        if ((((TroopListItem)localObject2).a != 6) && (((TroopListItem)localObject2).a != 4) && (((TroopListItem)localObject2).a != 2) && (((TroopListItem)localObject2).a != 8))
        {
          localObject2 = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
          if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
          {
            ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
            this.u.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.u.requestLayout();
          }
        }
        else
        {
          localObject2 = this.j.getChildAt(0);
          if (localObject2 != null)
          {
            paramInt = ((View)localObject2).getBottom();
            localObject2 = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
            i = this.x;
            if (paramInt < i) {
              ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - i);
            } else {
              ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
            }
            this.u.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.u.requestLayout();
          }
        }
        if (!TextUtils.isEmpty(str))
        {
          this.u.setVisibility(0);
          this.v.setText(str);
          this.w.setText((CharSequence)localObject1);
        }
        return;
      }
      this.u.setVisibility(4);
    }
  }
  
  public void a()
  {
    super.a();
    j();
    this.k.notifyDataSetChanged();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21008) {
        return;
      }
      if (paramIntent != null)
      {
        if (this.a.i())
        {
          SearchUtil.a(paramIntent, this.a.c());
          return;
        }
        if (this.a.j())
        {
          String str = paramIntent.getStringExtra("contactSearchResultTroopUin");
          paramIntent = paramIntent.getStringExtra("contactSearchResultName");
          Intent localIntent = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("uin", str);
          localBundle.putInt("uintype", 1);
          localBundle.putString("troop_uin", str);
          localBundle.putString("uinname", paramIntent);
          localIntent.putExtras(localBundle);
          getActivity().setResult(-1, localIntent);
          getActivity().finish();
          return;
        }
        a(paramIntent.getStringExtra("contactSearchResultTroopUin"), paramIntent.getStringExtra("contactSearchResultName"));
      }
    }
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    setContentView(2131626726);
    this.z = ((Activity)getContext()).getIntent().getIntExtra("key_from", 0);
    m();
    this.x = AIOUtils.b(44.0F, getResources());
    a(this.n);
    a(this.r);
    a(this.s);
    a(this.B);
    a(this.o);
    a(this.p);
    a(this.q);
    if (this.a.i())
    {
      this.i = 6;
      return;
    }
    this.i = 1;
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    if (this.a.i())
    {
      localObject = this.a.c();
      if (localObject != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", paramDiscussionInfo.uin);
        localBundle.putInt("uintype", 3000);
        localBundle.putString("uinname", ForwardUtils.a(this.b, paramDiscussionInfo.discussionName, paramDiscussionInfo.uin));
        localBundle.putBoolean("forward_report_confirm", true);
        localBundle.putString("forward_report_confirm_action_name", "0X8005A12");
        ((ForwardBaseOption)localObject).a(ForwardAbility.ForwardAbilityType.e.intValue(), localBundle);
      }
      localObject = "";
    }
    try
    {
      long l1 = this.a.b().getIntent().getLongExtra("req_share_id", 0L);
      paramDiscussionInfo = (DiscussionInfo)localObject;
      if (l1 > 0L) {
        paramDiscussionInfo = String.valueOf(l1);
      }
    }
    catch (Exception paramDiscussionInfo)
    {
      for (;;)
      {
        int i;
        paramDiscussionInfo = (DiscussionInfo)localObject;
      }
    }
    ReportCenter.a().a(this.b.getAccount(), "", paramDiscussionInfo, "1000", "32", "0", false);
    return;
    b(paramDiscussionInfo.uin, paramDiscussionInfo.discussionName);
    localObject = this.b;
    if (paramDiscussionInfo.hasCollect) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8006666", "0X8006666", i, 0, "", "", "", "");
  }
  
  public void a(TroopInfo paramTroopInfo, int paramInt)
  {
    if (this.y) {
      return;
    }
    if (paramTroopInfo != null)
    {
      boolean bool = this.a.i();
      localObject1 = "";
      i = 1;
      if (bool)
      {
        localObject2 = this.a.c();
        if (localObject2 != null)
        {
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("uin", paramTroopInfo.troopuin);
          ((Bundle)localObject3).putInt("uintype", 1);
          ((Bundle)localObject3).putString("troop_uin", paramTroopInfo.troopuin);
          if ((localObject2 instanceof ForwardShareCardOption)) {
            ((Bundle)localObject3).putString("uinname", paramTroopInfo.getNewTroopNameOrTroopName());
          } else {
            ((Bundle)localObject3).putString("uinname", paramTroopInfo.getTroopDisplayName());
          }
          ((Bundle)localObject3).putBoolean("forward_report_confirm", true);
          ((Bundle)localObject3).putString("forward_report_confirm_action_name", "0X8005A11");
          ((ForwardBaseOption)localObject2).a(ForwardAbility.ForwardAbilityType.d.intValue(), (Bundle)localObject3);
        }
        if (paramInt != 1)
        {
          if (paramInt == 3) {
            break label193;
          }
          if (paramInt == 5) {
            break label188;
          }
          if (paramInt == 7) {}
        }
        else
        {
          paramInt = 0;
          break label195;
        }
        paramInt = 2;
        break label195;
        label188:
        paramInt = 1;
        break label195;
        label193:
        paramInt = 3;
        label195:
        localObject2 = this.b;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramTroopInfo.troopuin);
        ((StringBuilder)localObject3).append("");
        ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_contacts", "", "choose_grp", "turn", 0, 0, ((StringBuilder)localObject3).toString(), String.valueOf(paramInt), "", "");
      }
    }
    try
    {
      long l1 = this.a.b().getIntent().getLongExtra("req_share_id", 0L);
      paramTroopInfo = (TroopInfo)localObject1;
      if (l1 > 0L) {
        paramTroopInfo = String.valueOf(l1);
      }
    }
    catch (Exception paramTroopInfo)
    {
      for (;;)
      {
        int i1;
        paramTroopInfo = (TroopInfo)localObject1;
      }
    }
    ReportCenter.a().a(this.b.getAccount(), "", paramTroopInfo, "1000", "31", "0", false);
    return;
    if (this.a.j())
    {
      localObject1 = new Intent();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("uin", paramTroopInfo.troopuin);
      ((Bundle)localObject2).putInt("uintype", 1);
      ((Bundle)localObject2).putString("troop_uin", paramTroopInfo.troopuin);
      ((Bundle)localObject2).putString("uinname", paramTroopInfo.getTroopDisplayName());
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      getActivity().setResult(-1, (Intent)localObject1);
      getActivity().finish();
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt == 3) {
        break label465;
      }
      if (paramInt == 5) {
        break label460;
      }
      if (paramInt == 7) {}
    }
    else
    {
      paramInt = 0;
      break label467;
    }
    paramInt = 2;
    break label467;
    label460:
    paramInt = 1;
    break label467;
    label465:
    paramInt = 3;
    label467:
    i1 = this.b.getTroopMask(paramTroopInfo.troopuin);
    if (i1 != 1)
    {
      if (i1 == 2) {
        break label514;
      }
      if (i1 != 3) {
        if (i1 == 4) {
          break label516;
        }
      }
    }
    else
    {
      i = 0;
      break label516;
    }
    int i = 3;
    break label516;
    label514:
    i = 2;
    label516:
    localObject1 = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramTroopInfo.troopuin);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(i);
    ((StringBuilder)localObject3).append("");
    ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, (String)localObject2, String.valueOf(paramInt), ((StringBuilder)localObject3).toString(), "");
    a(paramTroopInfo.troopuin, paramTroopInfo.getTroopDisplayName());
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.y) {
      return;
    }
    TroopInfo localTroopInfo = this.k.a(paramInt);
    if (localTroopInfo == null) {
      return;
    }
    paramView = (ShaderAnimLayout)paramView.findViewById(2131447919);
    if (paramView == null) {
      return;
    }
    Button localButton = (Button)paramView.findViewById(2131447918);
    if (localButton == null) {
      return;
    }
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramSlideDetectListView = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
    Activity localActivity = getActivity();
    if (paramSlideDetectListView.o(localTroopInfo.troopuin)) {
      paramInt = 2131890181;
    } else {
      paramInt = 2131890183;
    }
    paramSlideDetectListView = localActivity.getString(paramInt);
    localButton.setText(paramSlideDetectListView);
    localButton.setVisibility(0);
    localButton.setTag(localTroopInfo);
    if (ChatActivityConstants.b) {
      localButton.setContentDescription(paramSlideDetectListView);
    }
    paramView.a();
  }
  
  void a(String paramString1, String paramString2)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = AIOUtils.a(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    paramString1 = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).f(paramString1);
    if ((paramString1 != null) && (paramString1.troopcode != null)) {
      localIntent.putExtra("troop_uin", paramString1.troopcode);
    }
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", paramString2);
    a(localIntent);
  }
  
  public boolean a(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 101)
    {
      if (i == 103)
      {
        this.j.springBackOverScrollHeaderView();
        a(2131916799);
      }
    }
    else {
      this.j.springBackOverScrollHeaderView();
    }
    return true;
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.k.a(paramInt) == null) {
      return;
    }
    paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131447919);
    if (paramSlideDetectListView != null)
    {
      paramSlideDetectListView.e();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131447918);
      if (paramSlideDetectListView != null) {
        paramSlideDetectListView.setTag(null);
      }
    }
  }
  
  public void g()
  {
    super.g();
    b(this.n);
    b(this.r);
    b(this.s);
    b(this.B);
    b(this.o);
    b(this.p);
    b(this.q);
    TroopListAdapter2 localTroopListAdapter2 = this.k;
    if (localTroopListAdapter2 != null) {
      localTroopListAdapter2.c();
    }
  }
  
  public void i()
  {
    Intent localIntent = getActivity().getIntent();
    int i1 = 1;
    int i = i1;
    if (localIntent != null)
    {
      i = i1;
      if (localIntent.getIntExtra("_key_mode", 0) == 0) {
        i = 0;
      }
    }
    if ((!this.a.j()) && (i != 0)) {
      i = 24;
    } else {
      i = 16;
    }
    ContactSearchComponentActivity.a(getActivity(), null, 8, i | 0x200000, 21008);
  }
  
  public void j()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected boolean k()
  {
    if (NetworkUtil.isNetworkAvailable(getActivity()))
    {
      ((ITroopListHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).b();
      this.l = true;
      return true;
    }
    return false;
  }
  
  void l()
  {
    TroopListAdapter2 localTroopListAdapter2 = this.k;
    if (localTroopListAdapter2 != null) {
      localTroopListAdapter2.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131432634) {
      i();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.m.c(getTroopLastRefreshTime());
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.k != null) {
      setFloatingView(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.m.b(getTroopLastRefreshTime());
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.m.a(getTroopLastRefreshTime());
    if (!k()) {
      a(103, 1000L);
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView
 * JD-Core Version:    0.7.0.1
 */