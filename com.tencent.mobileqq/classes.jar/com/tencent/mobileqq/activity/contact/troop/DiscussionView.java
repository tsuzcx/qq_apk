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
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2.DiscussionListListener;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import whc;

public class DiscussionView
  extends BaseTroopView
  implements View.OnClickListener, DiscussionListAdapter2.DiscussionListListener, SlideDetectListView.OnSlideListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public DiscussionListAdapter2 a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public SlideDetectListView a;
  private whc jdField_a_of_type_Whc = new whc(this, null);
  int b;
  public boolean c = false;
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
    if ((a() == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2 == null)) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
    }
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.getCount()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.getItem(0);
    if ((localObject instanceof Integer)) {}
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      if (i == 0)
      {
        i = 2131435930;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(i);
        if (!(this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.getItem(paramInt) instanceof Integer)) {
          break label214;
        }
        if (paramInt >= this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.getCount()) {
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
        if (localObject == null) {
          break;
        }
        paramInt = ((View)localObject).getBottom();
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (paramInt >= this.b) {
          break label206;
        }
      }
      label206:
      for (((RelativeLayout.LayoutParams)localObject).topMargin = (paramInt - this.b);; ((RelativeLayout.LayoutParams)localObject).topMargin = 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        return;
        if (paramInt <= i + 1)
        {
          i = 2131435929;
          break;
        }
        i = 2131435930;
        break;
      }
      label214:
      if (paramInt >= this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.getCount()) {
        break;
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject).topMargin == 0) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      return;
    }
  }
  
  private void k()
  {
    this.e = findViewById(2131366462);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.e.findViewById(2131366464));
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366465));
    this.b = getResources().getDimensionPixelSize(2131558938);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131362391));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setNeedCheckSpringback(true);
    LayoutInflater localLayoutInflater = LayoutInflater.from(a());
    View localView = localLayoutInflater.inflate(2130971469, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
    localView.findViewById(2131368254).setVisibility(8);
    EditText localEditText = (EditText)localView.findViewById(2131368255);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setOnClickListener(this);
    localEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView(localView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130838210);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.e);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130969238, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
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
    Intent localIntent = new Intent(a(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_min", 2);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("multi_chat", true);
    a(localIntent, 1300);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
    } while (paramIntent == null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      SearchUtils.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a());
      return;
    }
    a(paramIntent.getStringExtra("contactSearchResultTroopUin"), paramIntent.getStringExtra("contactSearchResultName"));
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    a(2130969437);
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
    int i = 1;
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
      paramDiscussionInfo = "";
      try
      {
        long l = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().getIntent().getLongExtra("req_share_id", 0L);
        if (l > 0L) {
          paramDiscussionInfo = String.valueOf(l);
        }
      }
      catch (Exception paramDiscussionInfo)
      {
        for (;;)
        {
          paramDiscussionInfo = "";
        }
      }
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", paramDiscussionInfo, "1000", "32", "0", false);
      return;
    }
    a(paramDiscussionInfo.uin, paramDiscussionInfo.discussionName);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramDiscussionInfo.hasCollect) {}
    for (;;)
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8006666", "0X8006666", i, 0, "", "", "", "");
      return;
      i = 2;
    }
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    DiscussionInfo localDiscussionInfo = this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.a(paramInt);
    if (localDiscussionInfo == null) {}
    Button localButton;
    do
    {
      do
      {
        return;
        paramView = (ShaderAnimLayout)paramView.findViewById(2131364314);
      } while (paramView == null);
      localButton = (Button)paramView.findViewById(2131364315);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramSlideDetectListView = a();
    if (!localDiscussionInfo.hasCollect) {}
    for (paramInt = 2131429830;; paramInt = 2131429831)
    {
      paramSlideDetectListView = paramSlideDetectListView.getString(paramInt);
      localButton.setText(paramSlideDetectListView);
      localButton.setVisibility(0);
      localButton.setTag(localDiscussionInfo);
      if (AppSetting.b) {
        localButton.setContentDescription(paramSlideDetectListView);
      }
      paramView.a();
      return;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2 != null) {
      c(paramInt1);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if (!c()) {
      a(102, 1000L);
    }
    return true;
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.springBackOverScrollHeaderView();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.springBackOverScrollHeaderView();
      b(2131434332);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.a(paramInt) == null) {}
    do
    {
      do
      {
        return;
        paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131364314);
      } while (paramSlideDetectListView == null);
      paramSlideDetectListView.e();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131364315);
    } while (paramSlideDetectListView == null);
    paramSlideDetectListView.setTag(null);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected boolean c()
  {
    if (NetworkUtil.g(a()))
    {
      this.c = true;
      ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).f(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
      return true;
    }
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.b = true;
      this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.b = false;
    }
  }
  
  protected void g()
  {
    super.g();
    b(this.jdField_a_of_type_Whc);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.a();
    }
  }
  
  public void h()
  {
    ContactSearchComponentActivity.a(a(), null, 5, 8, 561249);
  }
  
  public void i()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("rec_last_discussion_list_refresh_time", 0).edit().putLong("rec_last_discussion_list_refresh_time", l).commit();
  }
  
  protected void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2 = new DiscussionListAdapter2(a(), this, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2);
    a(this.jdField_a_of_type_Whc);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368255: 
      h();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006665", "0X8006665", 0, 0, "", "", "", "");
      return;
    case 2131366464: 
      l();
      return;
    }
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.DiscussionView
 * JD-Core Version:    0.7.0.1
 */