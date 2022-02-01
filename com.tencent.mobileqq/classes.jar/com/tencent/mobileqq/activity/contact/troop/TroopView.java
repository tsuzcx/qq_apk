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
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  protected ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack a;
  protected TroopView.MyAvatarObserver a;
  protected TroopView.MyMessageObserver a;
  protected TroopView.MyRoamSettingObserver a;
  protected TroopView.MyTroopMngObserver a;
  protected TroopView.MyTroopModifyObserver a;
  protected TroopView.MyTroopObserver a;
  protected TroopListAdapter2 a;
  protected TroopCommonlyUsedObserver a;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyRoamSettingObserver = new TroopView.MyRoamSettingObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopObserver = new TroopView.MyTroopObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopModifyObserver = new TroopView.MyTroopModifyObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopMngObserver = new TroopView.MyTroopMngObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyAvatarObserver = new TroopView.MyAvatarObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyMessageObserver = new TroopView.MyMessageObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver = new TroopView.1(this);
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
    if (a() != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2;
      if (localObject1 == null) {
        return;
      }
      int i = paramInt - 2;
      if ((i >= 0) && (i < ((TroopListAdapter2)localObject1).getCount()))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getItem(i);
        if (!(localObject1 instanceof TroopListItem)) {
          return;
        }
        i = ((TroopListItem)localObject1).jdField_a_of_type_Int;
        String str = null;
        switch (i)
        {
        default: 
          localObject1 = null;
          break;
        case 8: 
        case 9: 
          str = HardCodeUtil.a(2131715602);
          localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.f);
          break;
        case 6: 
        case 7: 
          str = HardCodeUtil.a(2131715604);
          localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_c_of_type_Int);
          break;
        case 4: 
        case 5: 
          str = HardCodeUtil.a(2131715601);
          localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_b_of_type_Int);
          break;
        case 2: 
        case 3: 
          str = HardCodeUtil.a(2131715597);
          localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.d);
          break;
        case 0: 
        case 1: 
          str = HardCodeUtil.a(2131715600);
          localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.e);
        }
        Object localObject2 = (TroopListItem)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getItem(paramInt - 1);
        if ((((TroopListItem)localObject2).jdField_a_of_type_Int != 6) && (((TroopListItem)localObject2).jdField_a_of_type_Int != 4) && (((TroopListItem)localObject2).jdField_a_of_type_Int != 2) && (((TroopListItem)localObject2).jdField_a_of_type_Int != 8))
        {
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
          {
            ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
          }
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
          if (localObject2 != null)
          {
            paramInt = ((View)localObject2).getBottom();
            localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
            i = this.jdField_b_of_type_Int;
            if (paramInt < i) {
              ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - i);
            } else {
              ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
            }
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
          }
        }
        if (!TextUtils.isEmpty(str))
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        }
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131373873));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setNeedCheckSpringback(true);
    LayoutInflater localLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376771));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379364));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379363));
    if (this.d)
    {
      localObject = localLayoutInflater.inflate(2131560704, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      ((TextView)((View)localObject).findViewById(2131373840)).setText(a().getString(2131696214));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView((View)localObject);
    }
    else
    {
      this.e = localLayoutInflater.inflate(2131562770, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      this.e.findViewById(2131363868).setVisibility(8);
      localObject = (EditText)this.e.findViewById(2131366333);
      ((EditText)localObject).setFocusableInTouchMode(false);
      ((EditText)localObject).setOnClickListener(this);
      ((EditText)localObject).setCursorVisible(false);
      if (this.jdField_c_of_type_Int != 3) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView(this.e);
      }
    }
    Object localObject = new View(getContext());
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(12.0F, getResources())));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559642, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this);
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
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21008) {
        return;
      }
      if (paramIntent != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
        {
          SearchUtil.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a());
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
    }
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    a(2131560681);
    this.jdField_c_of_type_Int = ((Activity)getContext()).getIntent().getIntExtra("key_from", 0);
    k();
    this.jdField_b_of_type_Int = AIOUtils.b(44.0F, getResources());
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyRoamSettingObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyAvatarObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyMessageObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopModifyObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopMngObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      this.jdField_a_of_type_Int = 6;
      return;
    }
    this.jdField_a_of_type_Int = 1;
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
    b(paramDiscussionInfo.uin, paramDiscussionInfo.discussionName);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramDiscussionInfo.hasCollect) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8006666", "0X8006666", i, 0, "", "", "", "");
  }
  
  public void a(TroopInfo paramTroopInfo, int paramInt)
  {
    if (this.d) {
      return;
    }
    if (paramTroopInfo != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a();
      localObject1 = "";
      i = 1;
      if (bool)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a();
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
          ((ForwardBaseOption)localObject2).a(ForwardAbility.ForwardAbilityType.c.intValue(), (Bundle)localObject3);
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
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramTroopInfo.troopuin);
        ((StringBuilder)localObject3).append("");
        ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_contacts", "", "choose_grp", "turn", 0, 0, ((StringBuilder)localObject3).toString(), String.valueOf(paramInt), "", "");
      }
    }
    try
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().getIntent().getLongExtra("req_share_id", 0L);
      paramTroopInfo = (TroopInfo)localObject1;
      if (l > 0L) {
        paramTroopInfo = String.valueOf(l);
      }
    }
    catch (Exception paramTroopInfo)
    {
      for (;;)
      {
        int j;
        paramTroopInfo = (TroopInfo)localObject1;
      }
    }
    ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", paramTroopInfo, "1000", "31", "0", false);
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.b())
    {
      localObject1 = new Intent();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("uin", paramTroopInfo.troopuin);
      ((Bundle)localObject2).putInt("uintype", 1);
      ((Bundle)localObject2).putString("troop_uin", paramTroopInfo.troopuin);
      ((Bundle)localObject2).putString("uinname", paramTroopInfo.getTroopDisplayName());
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      a().setResult(-1, (Intent)localObject1);
      a().finish();
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
    j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramTroopInfo.troopuin);
    if (j != 1)
    {
      if (j == 2) {
        break label514;
      }
      if (j != 3) {
        if (j == 4) {
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
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    if (this.d) {
      return;
    }
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.a(paramInt);
    if (localTroopInfo == null) {
      return;
    }
    paramView = (ShaderAnimLayout)paramView.findViewById(2131379183);
    if (paramView == null) {
      return;
    }
    Button localButton = (Button)paramView.findViewById(2131379182);
    if (localButton == null) {
      return;
    }
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramSlideDetectListView = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Activity localActivity = a();
    if (paramSlideDetectListView.a(localTroopInfo.troopuin)) {
      paramInt = 2131693067;
    } else {
      paramInt = 2131693069;
    }
    paramSlideDetectListView = localActivity.getString(paramInt);
    localButton.setText(paramSlideDetectListView);
    localButton.setVisibility(0);
    localButton.setTag(localTroopInfo);
    if (ChatActivityConstants.a) {
      localButton.setContentDescription(paramSlideDetectListView);
    }
    paramView.a();
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
    int i = paramMessage.what;
    if (i != 101)
    {
      if (i == 103)
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
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.a(paramInt) == null) {
      return;
    }
    paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131379183);
    if (paramSlideDetectListView != null)
    {
      paramSlideDetectListView.e();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131379182);
      if (paramSlideDetectListView != null) {
        paramSlideDetectListView.setTag(null);
      }
    }
  }
  
  protected boolean b()
  {
    if (NetworkUtil.isNetworkAvailable(a()))
    {
      ((ITroopListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).a();
      this.jdField_c_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  public void g()
  {
    super.g();
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyRoamSettingObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyAvatarObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyMessageObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopModifyObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$MyTroopMngObserver);
    TroopListAdapter2 localTroopListAdapter2 = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2;
    if (localTroopListAdapter2 != null) {
      localTroopListAdapter2.c();
    }
  }
  
  public void h()
  {
    Intent localIntent = a().getIntent();
    int j = 1;
    int i = j;
    if (localIntent != null)
    {
      i = j;
      if (localIntent.getIntExtra("_key_mode", 0) == 0) {
        i = 0;
      }
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.b()) && (i != 0)) {
      i = 24;
    } else {
      i = 16;
    }
    ContactSearchComponentActivity.a(a(), null, 8, i | 0x200000, 21008);
  }
  
  public void i()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void j()
  {
    TroopListAdapter2 localTroopListAdapter2 = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2;
    if (localTroopListAdapter2 != null) {
      localTroopListAdapter2.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366333) {
      h();
    }
    EventCollector.getInstance().onViewClicked(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView
 * JD-Core Version:    0.7.0.1
 */