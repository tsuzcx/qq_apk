package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2.DiscussionListListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import mqq.app.AppRuntime;

public class DiscussionView
  extends BaseTroopView
  implements View.OnClickListener, DiscussionListAdapter2.DiscussionListListener, SlideDetectListView.OnSlideListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  View j;
  Button k;
  protected SlideDetectListView l;
  protected DiscussionListAdapter2 m;
  boolean n = false;
  int o;
  private PullRefreshHeader p;
  private DiscussionView.MyDiscussionObserver q = new DiscussionView.MyDiscussionObserver(this, null);
  private TextView r;
  
  public DiscussionView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(String paramString1, String paramString2)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = AIOUtils.a(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramString2);
    a(localIntent);
  }
  
  private long getDiscussionLastRefreshTime()
  {
    return getActivity().getSharedPreferences("rec_last_discussion_list_refresh_time", 0).getLong("rec_last_discussion_list_refresh_time", 0L);
  }
  
  private void m()
  {
    this.j = findViewById(2131432518);
    this.k = ((Button)this.j.findViewById(2131431497));
    this.j.setVisibility(8);
    this.r = ((TextView)findViewById(2131448101));
    this.o = getResources().getDimensionPixelSize(2131299976);
    this.l = ((SlideDetectListView)findViewById(2131437778));
    this.l.setNeedCheckSpringback(true);
    LayoutInflater localLayoutInflater = LayoutInflater.from(getActivity());
    View localView = localLayoutInflater.inflate(2131629215, this.l, false);
    localView.findViewById(2131429816).setVisibility(8);
    EditText localEditText = (EditText)localView.findViewById(2131432634);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setOnClickListener(this);
    localEditText.setCursorVisible(false);
    this.l.addHeaderView(localView);
    this.l.setContentBackground(2130838958);
    this.l.setEmptyView(this.j);
    this.l.setVisibility(8);
    this.p = ((PullRefreshHeader)localLayoutInflater.inflate(2131625671, this.l, false));
    this.l.setOverScrollHeader(this.p);
    this.l.setOverScrollListener(this);
    this.l.setOnScrollGroupFloatingListener(this);
    this.k.setOnClickListener(this);
    if (!this.a.i()) {
      this.l.setOnSlideListener(this);
    }
  }
  
  private void n()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_min", 2);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("multi_chat", true);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this.a.b(), localIntent, 1300);
    ReportController.b(this.b, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
  }
  
  private void setFloatingView(int paramInt)
  {
    if (getActivity() != null)
    {
      Object localObject = this.m;
      if (localObject == null) {
        return;
      }
      if (paramInt == 0)
      {
        this.r.setVisibility(4);
        return;
      }
      if ((paramInt >= 0) && (paramInt < ((DiscussionListAdapter2)localObject).getCount()))
      {
        localObject = this.m.getItem(0);
        int i;
        if ((localObject instanceof Integer)) {
          i = ((Integer)localObject).intValue();
        } else {
          i = 0;
        }
        int i1 = 2131892010;
        if ((i != 0) && (paramInt <= i + 1)) {
          i1 = 2131892017;
        }
        this.r.setVisibility(0);
        this.r.setText(i1);
        if ((this.m.getItem(paramInt) instanceof Integer))
        {
          if (paramInt < this.m.getCount())
          {
            localObject = this.l.getChildAt(0);
            if (localObject != null)
            {
              paramInt = ((View)localObject).getBottom();
              localObject = (RelativeLayout.LayoutParams)this.r.getLayoutParams();
              i = this.o;
              if (paramInt < i) {
                ((RelativeLayout.LayoutParams)localObject).topMargin = (paramInt - i);
              } else {
                ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
              }
              this.r.setLayoutParams((ViewGroup.LayoutParams)localObject);
              this.r.requestLayout();
            }
          }
        }
        else if (paramInt < this.m.getCount())
        {
          localObject = (RelativeLayout.LayoutParams)this.r.getLayoutParams();
          if (((RelativeLayout.LayoutParams)localObject).topMargin != 0)
          {
            ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
            this.r.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.r.requestLayout();
          }
        }
        return;
      }
      this.r.setVisibility(4);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21007) {
        return;
      }
      if (paramIntent != null)
      {
        if (this.a.i())
        {
          SearchUtil.a(paramIntent, this.a.c());
          return;
        }
        a(paramIntent.getStringExtra("contactSearchResultTroopUin"), paramIntent.getStringExtra("contactSearchResultName"));
      }
    }
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    setContentView(2131625916);
    m();
    l();
    if (this.a.i())
    {
      this.i = 7;
      return;
    }
    this.i = 2;
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
    a(paramDiscussionInfo.uin, paramDiscussionInfo.discussionName);
    localObject = this.b;
    if (paramDiscussionInfo.hasCollect) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8006666", "0X8006666", i, 0, "", "", "", "");
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    DiscussionInfo localDiscussionInfo = this.m.a(paramInt);
    if (localDiscussionInfo == null) {
      return;
    }
    paramView = (ShaderAnimLayout)paramView.findViewById(2131431960);
    if (paramView == null) {
      return;
    }
    Button localButton = (Button)paramView.findViewById(2131431959);
    if (localButton == null) {
      return;
    }
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramSlideDetectListView = getActivity();
    if (!localDiscussionInfo.hasCollect) {
      paramInt = 2131893958;
    } else {
      paramInt = 2131893954;
    }
    paramSlideDetectListView = paramSlideDetectListView.getString(paramInt);
    localButton.setText(paramSlideDetectListView);
    localButton.setVisibility(0);
    localButton.setTag(localDiscussionInfo);
    if (AppSetting.e) {
      localButton.setContentDescription(paramSlideDetectListView);
    }
    paramView.a();
  }
  
  public boolean a(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 100)
    {
      if (i == 102)
      {
        this.l.springBackOverScrollHeaderView();
        a(2131916799);
      }
    }
    else {
      this.l.springBackOverScrollHeaderView();
    }
    return true;
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.m.a(paramInt) == null) {
      return;
    }
    paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131431960);
    if (paramSlideDetectListView != null)
    {
      paramSlideDetectListView.e();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131431959);
      if (paramSlideDetectListView != null) {
        paramSlideDetectListView.setTag(null);
      }
    }
  }
  
  public void d()
  {
    DiscussionListAdapter2 localDiscussionListAdapter2 = this.m;
    if (localDiscussionListAdapter2 != null)
    {
      localDiscussionListAdapter2.d = true;
      localDiscussionListAdapter2.notifyDataSetChanged();
    }
  }
  
  public void e()
  {
    super.e();
    DiscussionListAdapter2 localDiscussionListAdapter2 = this.m;
    if (localDiscussionListAdapter2 != null) {
      localDiscussionListAdapter2.d = false;
    }
  }
  
  protected void g()
  {
    super.g();
    b(this.q);
    DiscussionListAdapter2 localDiscussionListAdapter2 = this.m;
    if (localDiscussionListAdapter2 != null) {
      localDiscussionListAdapter2.a();
    }
  }
  
  public void i()
  {
    ContactSearchComponentActivity.a(getActivity(), null, 5, 8, 21007);
  }
  
  void j()
  {
    long l1 = System.currentTimeMillis();
    getActivity().getSharedPreferences("rec_last_discussion_list_refresh_time", 0).edit().putLong("rec_last_discussion_list_refresh_time", l1).commit();
  }
  
  protected boolean k()
  {
    if (NetworkUtil.isNetworkAvailable(getActivity()))
    {
      this.n = true;
      ((DiscussionHandler)this.b.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).f(Long.valueOf(this.b.getCurrentAccountUin()).longValue());
      return true;
    }
    return false;
  }
  
  protected void l()
  {
    this.m = new DiscussionListAdapter2(getActivity(), this, this.l, this.b, false);
    this.l.setAdapter(this.m);
    a(this.q);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131431497)
    {
      if (i == 2131432634)
      {
        i();
        ReportController.b(this.b, "CliOper", "", "", "0X8006665", "0X8006665", 0, 0, "", "", "", "");
      }
    }
    else {
      n();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.p.c(getDiscussionLastRefreshTime());
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.m != null) {
      setFloatingView(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.p.b(getDiscussionLastRefreshTime());
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.p.a(getDiscussionLastRefreshTime());
    if (!k()) {
      a(102, 1000L);
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.DiscussionView
 * JD-Core Version:    0.7.0.1
 */