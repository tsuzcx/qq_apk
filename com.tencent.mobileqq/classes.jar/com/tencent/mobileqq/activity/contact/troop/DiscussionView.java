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
  Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DiscussionView.MyDiscussionObserver jdField_a_of_type_ComTencentMobileqqActivityContactTroopDiscussionView$MyDiscussionObserver = new DiscussionView.MyDiscussionObserver(this, null);
  protected DiscussionListAdapter2 a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  protected SlideDetectListView a;
  int b;
  boolean c = false;
  View e;
  
  public DiscussionView(Context paramContext)
  {
    super(paramContext);
  }
  
  private long a()
  {
    return a().getSharedPreferences("rec_last_discussion_list_refresh_time", 0).getLong("rec_last_discussion_list_refresh_time", 0L);
  }
  
  private void a(String paramString1, String paramString2)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = AIOUtils.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramString2);
    a(localIntent);
  }
  
  private void c(int paramInt)
  {
    if (a() != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2;
      if (localObject == null) {
        return;
      }
      if (paramInt == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
      if ((paramInt >= 0) && (paramInt < ((DiscussionListAdapter2)localObject).getCount()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.getItem(0);
        int i;
        if ((localObject instanceof Integer)) {
          i = ((Integer)localObject).intValue();
        } else {
          i = 0;
        }
        int j = 2131694337;
        if ((i != 0) && (paramInt <= i + 1)) {
          j = 2131694344;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(j);
        if ((this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.getItem(paramInt) instanceof Integer))
        {
          if (paramInt < this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.getCount())
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
            if (localObject != null)
            {
              paramInt = ((View)localObject).getBottom();
              localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
              i = this.b;
              if (paramInt < i) {
                ((RelativeLayout.LayoutParams)localObject).topMargin = (paramInt - i);
              } else {
                ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
              }
              this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
            }
          }
        }
        else if (paramInt < this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.getCount())
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          if (((RelativeLayout.LayoutParams)localObject).topMargin != 0)
          {
            ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
            this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
          }
        }
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  private void k()
  {
    this.e = findViewById(2131366230);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.e.findViewById(2131365314));
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379364));
    this.b = getResources().getDimensionPixelSize(2131299223);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131370506));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setNeedCheckSpringback(true);
    LayoutInflater localLayoutInflater = LayoutInflater.from(a());
    View localView = localLayoutInflater.inflate(2131562770, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
    localView.findViewById(2131363868).setVisibility(8);
    EditText localEditText = (EditText)localView.findViewById(2131366333);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setOnClickListener(this);
    localEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView(localView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130838739);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.e);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559642, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this);
    }
  }
  
  private void l()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_min", 2);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("multi_chat", true);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(), localIntent, 1300);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
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
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
        {
          SearchUtil.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a());
          return;
        }
        a(paramIntent.getStringExtra("contactSearchResultTroopUin"), paramIntent.getStringExtra("contactSearchResultName"));
      }
    }
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    a(2131559873);
    k();
    j();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      this.jdField_a_of_type_Int = 7;
      return;
    }
    this.jdField_a_of_type_Int = 2;
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a();
      if (localObject != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", paramDiscussionInfo.uin);
        localBundle.putInt("uintype", 3000);
        localBundle.putString("uinname", ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDiscussionInfo.discussionName, paramDiscussionInfo.uin));
        localBundle.putBoolean("forward_report_confirm", true);
        localBundle.putString("forward_report_confirm_action_name", "0X8005A12");
        ((ForwardBaseOption)localObject).a(ForwardAbility.ForwardAbilityType.d.intValue(), localBundle);
      }
      localObject = "";
    }
    try
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().getIntent().getLongExtra("req_share_id", 0L);
      paramDiscussionInfo = (DiscussionInfo)localObject;
      if (l > 0L) {
        paramDiscussionInfo = String.valueOf(l);
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
    ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", paramDiscussionInfo, "1000", "32", "0", false);
    return;
    a(paramDiscussionInfo.uin, paramDiscussionInfo.discussionName);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramDiscussionInfo.hasCollect) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8006666", "0X8006666", i, 0, "", "", "", "");
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    DiscussionInfo localDiscussionInfo = this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.a(paramInt);
    if (localDiscussionInfo == null) {
      return;
    }
    paramView = (ShaderAnimLayout)paramView.findViewById(2131365718);
    if (paramView == null) {
      return;
    }
    Button localButton = (Button)paramView.findViewById(2131365717);
    if (localButton == null) {
      return;
    }
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramSlideDetectListView = a();
    if (!localDiscussionInfo.hasCollect) {
      paramInt = 2131696192;
    } else {
      paramInt = 2131696188;
    }
    paramSlideDetectListView = paramSlideDetectListView.getString(paramInt);
    localButton.setText(paramSlideDetectListView);
    localButton.setVisibility(0);
    localButton.setTag(localDiscussionInfo);
    if (AppSetting.d) {
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.springBackOverScrollHeaderView();
        b(2131719247);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.springBackOverScrollHeaderView();
    }
    return true;
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.a(paramInt) == null) {
      return;
    }
    paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131365718);
    if (paramSlideDetectListView != null)
    {
      paramSlideDetectListView.e();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131365717);
      if (paramSlideDetectListView != null) {
        paramSlideDetectListView.setTag(null);
      }
    }
  }
  
  protected boolean b()
  {
    if (NetworkUtil.isNetworkAvailable(a()))
    {
      this.c = true;
      ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).f(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
      return true;
    }
    return false;
  }
  
  public void d()
  {
    DiscussionListAdapter2 localDiscussionListAdapter2 = this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2;
    if (localDiscussionListAdapter2 != null)
    {
      localDiscussionListAdapter2.b = true;
      localDiscussionListAdapter2.notifyDataSetChanged();
    }
  }
  
  public void e()
  {
    super.e();
    DiscussionListAdapter2 localDiscussionListAdapter2 = this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2;
    if (localDiscussionListAdapter2 != null) {
      localDiscussionListAdapter2.b = false;
    }
  }
  
  protected void g()
  {
    super.g();
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopDiscussionView$MyDiscussionObserver);
    DiscussionListAdapter2 localDiscussionListAdapter2 = this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2;
    if (localDiscussionListAdapter2 != null) {
      localDiscussionListAdapter2.a();
    }
  }
  
  public void h()
  {
    ContactSearchComponentActivity.a(a(), null, 5, 8, 21007);
  }
  
  void i()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("rec_last_discussion_list_refresh_time", 0).edit().putLong("rec_last_discussion_list_refresh_time", l).commit();
  }
  
  protected void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2 = new DiscussionListAdapter2(a(), this, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopDiscussionView$MyDiscussionObserver);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131365314)
    {
      if (i == 2131366333)
      {
        h();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006665", "0X8006665", 0, 0, "", "", "", "");
      }
    }
    else {
      l();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2 != null) {
      c(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if (!b()) {
      a(102, 1000L);
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.DiscussionView
 * JD-Core Version:    0.7.0.1
 */