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
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItem;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
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
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import mqq.app.AppRuntime;

public class TroopView
  extends BaseTroopView
  implements View.OnClickListener, TroopListAdapter2.OnTroopListClickListener, SlideDetectListView.OnSlideListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  protected ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack a;
  protected TroopView.MyAvatarObserver a;
  protected TroopView.MyFriendListObserver a;
  protected TroopView.MyMessageObserver a;
  protected TroopView.MyTroopBusinessObserver a;
  protected TroopView.MyTroopObserver a;
  protected TroopListAdapter2 a;
  protected BizTroopObserver a;
  protected PullRefreshHeader a;
  protected SlideDetectListView a;
  int jdField_b_of_type_Int;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  protected int c;
  boolean c;
  protected boolean d = false;
  protected View e = null;
  
  public TroopView(Context paramContext, boolean paramBoolean, ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack paramIShowExternalTroopDataChangedCallBack)
  {
    super(paramContext);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyFriendListObserver = new TroopView.MyFriendListObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopObserver = new TroopView.MyTroopObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopBusinessObserver = new TroopView.MyTroopBusinessObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyAvatarObserver = new TroopView.MyAvatarObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyMessageObserver = new TroopView.MyMessageObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopView.1(this);
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
    Object localObject1 = null;
    if ((a() == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 == null)) {}
    int i;
    Object localObject2;
    do
    {
      return;
      i = paramInt - 2;
      if ((i < 0) || (i >= this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getCount()))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        return;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getItem(i);
    } while (!(localObject2 instanceof TroopListAdapter2.TroopListItem));
    label127:
    Object localObject3;
    switch (((TroopListAdapter2.TroopListItem)localObject2).jdField_a_of_type_Int)
    {
    default: 
      localObject2 = null;
      localObject3 = (TroopListAdapter2.TroopListItem)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getItem(paramInt - 1);
      if ((((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_Int == 6) || (((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_Int == 4) || (((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_Int == 2) || (((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_Int == 8))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
        if (localObject3 != null)
        {
          paramInt = ((View)localObject3).getBottom();
          localObject3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          if (paramInt >= this.jdField_b_of_type_Int) {
            break label397;
          }
          ((RelativeLayout.LayoutParams)localObject3).topMargin = (paramInt - this.jdField_b_of_type_Int);
          label232:
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
        }
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
      localObject2 = HardCodeUtil.a(2131715676);
      i = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.e;
      localObject1 = String.valueOf(i);
      break label127;
      localObject2 = HardCodeUtil.a(2131715673);
      i = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.d;
      localObject1 = String.valueOf(i);
      break label127;
      localObject2 = HardCodeUtil.a(2131715677);
      i = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_b_of_type_Int;
      localObject1 = String.valueOf(i);
      break label127;
      localObject2 = HardCodeUtil.a(2131715680);
      i = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_c_of_type_Int;
      localObject1 = String.valueOf(i);
      break label127;
      localObject2 = HardCodeUtil.a(2131715678);
      i = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.f;
      localObject1 = String.valueOf(i);
      break label127;
      label397:
      ((RelativeLayout.LayoutParams)localObject3).topMargin = 0;
      break label232;
      localObject3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject3).topMargin != 0)
      {
        ((RelativeLayout.LayoutParams)localObject3).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      }
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131374317));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setNeedCheckSpringback(true);
    LayoutInflater localLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377317));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380035));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380034));
    Object localObject;
    if (this.d)
    {
      localObject = localLayoutInflater.inflate(2131560831, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      ((TextView)((View)localObject).findViewById(2131374284)).setText(a().getString(2131696195));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView((View)localObject);
    }
    for (;;)
    {
      localObject = new View(getContext());
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.a(12.0F, getResources())));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559765, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this);
      }
      return;
      this.e = localLayoutInflater.inflate(2131562951, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      this.e.findViewById(2131363942).setVisibility(8);
      localObject = (EditText)this.e.findViewById(2131366452);
      ((EditText)localObject).setFocusableInTouchMode(false);
      ((EditText)localObject).setOnClickListener(this);
      ((EditText)localObject).setCursorVisible(false);
      if (this.jdField_c_of_type_Int != 3) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView(this.e);
      }
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.b())
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
      a().setResult(-1, localIntent);
      a().finish();
      return;
    }
    a(paramIntent.getStringExtra("contactSearchResultTroopUin"), paramIntent.getStringExtra("contactSearchResultName"));
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    a(2131560808);
    this.jdField_c_of_type_Int = ((Activity)getContext()).getIntent().getIntExtra("key_from", 0);
    k();
    this.jdField_b_of_type_Int = AIOUtils.a(44.0F, getResources());
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyAvatarObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyMessageObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopBusinessObserver);
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
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8006666", "0X8006666", i, 0, "", "", "", "");
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
    Object localObject;
    Bundle localBundle;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a();
      if (localObject != null)
      {
        localBundle = new Bundle();
        localBundle.putString("uin", paramTroopInfo.troopuin);
        localBundle.putInt("uintype", 1);
        localBundle.putString("troop_uin", paramTroopInfo.troopuin);
        if ((localObject instanceof ForwardShareCardOption))
        {
          localBundle.putString("uinname", paramTroopInfo.getNewTroopNameOrTroopName());
          localBundle.putBoolean("forward_report_confirm", true);
          localBundle.putString("forward_report_confirm_action_name", "0X8005A11");
          ((ForwardBaseOption)localObject).a(ForwardAbility.ForwardAbilityType.c.intValue(), localBundle);
        }
      }
      else
      {
        switch (paramInt)
        {
        case 2: 
        case 4: 
        case 6: 
        default: 
          paramInt = 0;
        }
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
        localBundle.putString("uinname", paramTroopInfo.getTroopDisplayName());
        break;
        paramInt = 0;
        continue;
        paramInt = 1;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.b())
    {
      localObject = new Intent();
      localBundle = new Bundle();
      localBundle.putString("uin", paramTroopInfo.troopuin);
      localBundle.putInt("uintype", 1);
      localBundle.putString("troop_uin", paramTroopInfo.troopuin);
      localBundle.putString("uinname", paramTroopInfo.getTroopDisplayName());
      ((Intent)localObject).putExtras(localBundle);
      a().setResult(-1, (Intent)localObject);
      a().finish();
      return;
    }
    int i;
    switch (paramInt)
    {
    case 2: 
    case 4: 
    case 6: 
    default: 
      paramInt = 0;
      switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramTroopInfo.troopuin))
      {
      default: 
        i = 0;
      }
      break;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), i + "", "");
      a(paramTroopInfo.troopuin, paramTroopInfo.getTroopDisplayName());
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
        paramView = (ShaderAnimLayout)paramView.findViewById(2131379854);
      } while (paramView == null);
      localButton = (Button)paramView.findViewById(2131379853);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramSlideDetectListView = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Activity localActivity = a();
    if (paramSlideDetectListView.b(localTroopInfo.troopuin)) {}
    for (paramInt = 2131693107;; paramInt = 2131693109)
    {
      paramSlideDetectListView = localActivity.getString(paramInt);
      localButton.setText(paramSlideDetectListView);
      localButton.setVisibility(0);
      localButton.setTag(localTroopInfo);
      if (ChatActivityConstants.a) {
        localButton.setContentDescription(paramSlideDetectListView);
      }
      paramView.a();
      return;
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = AIOUtils.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    paramString1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1);
    if ((paramString1 != null) && (paramString1.troopcode != null)) {
      localIntent.putExtra("troop_uin", paramString1.troopcode);
    }
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", paramString2);
    a(localIntent);
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
      b(2131719529);
    }
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.a(paramInt) == null) {}
    do
    {
      do
      {
        return;
        paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131379854);
      } while (paramSlideDetectListView == null);
      paramSlideDetectListView.e();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131379853);
    } while (paramSlideDetectListView == null);
    paramSlideDetectListView.setTag(null);
  }
  
  protected boolean b()
  {
    if (NetworkUtil.g(a()))
    {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b();
      this.jdField_c_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  public void g()
  {
    super.g();
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyAvatarObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyMessageObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopBusinessObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.c();
    }
  }
  
  public void h()
  {
    int i = 0;
    Intent localIntent = a().getIntent();
    int j;
    if (localIntent != null)
    {
      j = localIntent.getIntExtra("_key_mode", 0);
      if (j != 0) {}
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.b()) && (i != 0)) {}
      for (i = 24;; i = 16)
      {
        ContactSearchComponentActivity.a(a(), null, 8, i | 0x200000, 561250);
        return;
        if (j != 1) {
          break label81;
        }
        i = 1;
        break;
      }
      label81:
      i = 1;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 == null) {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {
        break label107;
      }
    }
    label107:
    for (int i = 1;; i = 0)
    {
      if (this.jdField_c_of_type_Int == 3) {
        i = 2;
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.b()) {}
        for (boolean bool = true;; bool = false)
        {
          this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 = new TroopListAdapter2(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, i, this.d, bool, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack);
          this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2);
          this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(this);
          return;
        }
      }
    }
  }
  
  void j()
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      h();
    }
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 != null) {
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
      a(103, 1000L);
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView
 * JD-Core Version:    0.7.0.1
 */