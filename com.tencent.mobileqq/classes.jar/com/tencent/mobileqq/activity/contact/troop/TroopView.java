package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.OnTroopListClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
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
import wlt;

public class TroopView
  extends BaseTroopView
  implements View.OnClickListener, TroopListAdapter2.OnTroopListClickListener, SlideDetectListView.OnSlideListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  TextView a;
  protected ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack a;
  protected TroopView.MyFriendListObserver a;
  protected TroopView.MyMessageObserver a;
  protected TroopView.MyTroopObserver a;
  protected TroopListAdapter2 a;
  protected BizTroopObserver a;
  protected PullRefreshHeader a;
  protected SlideDetectListView a;
  int b;
  boolean c = false;
  protected boolean d;
  protected View e;
  
  public TroopView(Context paramContext, boolean paramBoolean, ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack paramIShowExternalTroopDataChangedCallBack)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyFriendListObserver = new TroopView.MyFriendListObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopObserver = new TroopView.MyTroopObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyMessageObserver = new TroopView.MyMessageObserver(this);
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new wlt(this);
    this.d = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack = paramIShowExternalTroopDataChangedCallBack;
  }
  
  private long a()
  {
    return a().getSharedPreferences("rec_last_troop_list_refresh_time", 0).getLong("rec_last_troop_list_refresh_time", 0L);
  }
  
  private void b(String paramString1, String paramString2)
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
    Object localObject2 = a();
    if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 == null)) {}
    do
    {
      int i;
      do
      {
        return;
        if (paramInt == 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          return;
        }
        i = paramInt - 1;
      } while ((i < 0) || (i >= this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getCount()));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getItem(i);
    } while (!(localObject1 instanceof TroopListAdapter2.TroopListItem));
    TroopListAdapter2.TroopListItem localTroopListItem = (TroopListAdapter2.TroopListItem)localObject1;
    Object localObject1 = null;
    switch (localTroopListItem.jdField_a_of_type_Int)
    {
    default: 
      label136:
      if (paramInt < this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getCount())
      {
        localObject2 = (TroopListAdapter2.TroopListItem)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getItem(paramInt);
        if ((((TroopListAdapter2.TroopListItem)localObject2).jdField_a_of_type_Int != 6) && (((TroopListAdapter2.TroopListItem)localObject2).jdField_a_of_type_Int != 4) && (((TroopListAdapter2.TroopListItem)localObject2).jdField_a_of_type_Int != 2) && (((TroopListAdapter2.TroopListItem)localObject2).jdField_a_of_type_Int != 8)) {
          break label439;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
        if (localObject2 != null)
        {
          paramInt = ((View)localObject2).getBottom();
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          if (paramInt >= this.b) {
            break label430;
          }
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - this.b);
          label250:
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        }
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
      localObject1 = ((Activity)localObject2).getString(2131429838, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.e) });
      break label136;
      localObject1 = ((Activity)localObject2).getString(2131429832, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.d) });
      break label136;
      localObject1 = ((Activity)localObject2).getString(2131429830, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.b) });
      break label136;
      localObject1 = ((Activity)localObject2).getString(2131429831, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.c) });
      break label136;
      localObject1 = ((Activity)localObject2).getString(2131429833, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.c) });
      break label136;
      label430:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      break label250;
      label439:
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131362390));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setNeedCheckSpringback(true);
    LayoutInflater localLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366492));
    Object localObject;
    if (this.d)
    {
      localObject = localLayoutInflater.inflate(2130969961, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      ((TextView)((View)localObject).findViewById(2131368593)).setText(a().getString(2131430389));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView((View)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130969239, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130838214);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this);
      }
      return;
      this.e = localLayoutInflater.inflate(2130971517, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      this.e.findViewById(2131368321).setVisibility(8);
      localObject = (EditText)this.e.findViewById(2131368322);
      ((EditText)localObject).setFocusableInTouchMode(false);
      ((EditText)localObject).setOnClickListener(this);
      ((EditText)localObject).setCursorVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView(this.e);
    }
  }
  
  private void l()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("rec_last_troop_list_refresh_time", 0).edit().putLong("rec_last_troop_list_refresh_time", l).commit();
  }
  
  public void a()
  {
    super.a();
    i();
    this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.notifyDataSetChanged();
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
    a(2130969937);
    k();
    this.b = getResources().getDimensionPixelSize(2131558938);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyMessageObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      this.jdField_a_of_type_Int = 6;
      return;
    }
    this.jdField_a_of_type_Int = 1;
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
    b(paramDiscussionInfo.uin, paramDiscussionInfo.discussionName);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramDiscussionInfo.hasCollect) {}
    for (;;)
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8006666", "0X8006666", i, 0, "", "", "", "");
      return;
      i = 2;
    }
  }
  
  public void a(TroopInfo paramTroopInfo, int paramInt)
  {
    if (this.d) {}
    while (paramTroopInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      ForwardBaseOption localForwardBaseOption = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a();
      if (localForwardBaseOption != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", paramTroopInfo.troopuin);
        localBundle.putInt("uintype", 1);
        localBundle.putString("troop_uin", paramTroopInfo.troopuin);
        localBundle.putString("uinname", paramTroopInfo.getTroopName());
        localBundle.putBoolean("forward_report_confirm", true);
        localBundle.putString("forward_report_confirm_action_name", "0X8005A11");
        localForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c.intValue(), localBundle);
      }
      switch (paramInt)
      {
      case 2: 
      case 4: 
      case 6: 
      default: 
        paramInt = 0;
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "turn", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), "", "");
        paramTroopInfo = "";
        try
        {
          long l = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().getIntent().getLongExtra("req_share_id", 0L);
          if (l > 0L) {
            paramTroopInfo = String.valueOf(l);
          }
        }
        catch (Exception paramTroopInfo)
        {
          for (;;)
          {
            paramTroopInfo = "";
          }
        }
        ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", paramTroopInfo, "1000", "31", "0", false);
        return;
        paramInt = 0;
        continue;
        paramInt = 1;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
      }
    }
    int i;
    switch (paramInt)
    {
    case 2: 
    case 4: 
    case 6: 
    default: 
      paramInt = 0;
      switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramTroopInfo.troopuin))
      {
      default: 
        i = 0;
      }
      break;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), i + "", "");
      a(paramTroopInfo.troopuin, paramTroopInfo.getTroopName());
      return;
      paramInt = 0;
      break;
      paramInt = 1;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      i = 0;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 1;
    }
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.d) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
          localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.a(paramInt);
        } while (localTroopInfo == null);
        paramView = (ShaderAnimLayout)paramView.findViewById(2131366542);
      } while (paramView == null);
      localButton = (Button)paramView.findViewById(2131366543);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramSlideDetectListView = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Activity localActivity = a();
    if (paramSlideDetectListView.b(localTroopInfo.troopuin)) {}
    for (paramInt = 2131435389;; paramInt = 2131435388)
    {
      paramSlideDetectListView = localActivity.getString(paramInt);
      localButton.setText(paramSlideDetectListView);
      localButton.setVisibility(0);
      localButton.setTag(localTroopInfo);
      if (ChatActivityConstants.N) {
        localButton.setContentDescription(paramSlideDetectListView);
      }
      paramView.a();
      return;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 != null) {
      c(paramInt1);
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = AIOUtils.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    paramString1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramString1);
    if ((paramString1 != null) && (paramString1.troopcode != null)) {
      localIntent.putExtra("troop_uin", paramString1.troopcode);
    }
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", paramString2);
    a(localIntent);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if (!c()) {
      a(103, 1000L);
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
      b(2131434349);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.a(paramInt) == null) {}
    do
    {
      do
      {
        return;
        paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131366542);
      } while (paramSlideDetectListView == null);
      paramSlideDetectListView.e();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131366543);
    } while (paramSlideDetectListView == null);
    paramSlideDetectListView.setTag(null);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected boolean c()
  {
    if (NetworkUtil.g(a()))
    {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b();
      this.c = true;
      return true;
    }
    return false;
  }
  
  public void g()
  {
    super.g();
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyMessageObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.X_();
    }
  }
  
  public void h()
  {
    ContactSearchComponentActivity.a(a(), null, 8, 2097176, 561250);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 == null) {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {
        break label74;
      }
    }
    label74:
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 = new TroopListAdapter2(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, i, this.d, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(this);
      return;
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      h();
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006622", "0X8006622", 0, 0, "", "", "", "");
      paramView = (TroopCreateLogic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31);
    } while (paramView == null);
    paramView.a((BaseActivity)a(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView
 * JD-Core Version:    0.7.0.1
 */