package com.tencent.mobileqq.activity.contact.troop;

import admg;
import ajdx;
import ajfa;
import ajhi;
import ajhj;
import ajhk;
import ajhl;
import amjz;
import amke;
import amkg;
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
import anrc;
import anvx;
import aoep;
import aupp;
import aupt;
import bcnc;
import bdla;
import bhbr;
import bjgx;
import bldp;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;

public class TroopView
  extends BaseTroopView
  implements amke, View.OnClickListener, bldp, SlideDetectListView.OnSlideListener, AbsListView.OnScrollListener
{
  protected ajfa a;
  protected ajhj a;
  protected ajhk a;
  protected ajhl a;
  protected amjz a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  protected anrc a;
  public PullRefreshHeader a;
  public SlideDetectListView a;
  int jdField_b_of_type_Int;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  protected int c;
  public boolean c;
  protected boolean d;
  protected View e;
  
  public TroopView(Context paramContext, boolean paramBoolean, ajfa paramajfa)
  {
    super(paramContext);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Ajhj = new ajhj(this);
    this.jdField_a_of_type_Ajhl = new ajhl(this);
    this.jdField_a_of_type_Ajhk = new ajhk(this);
    this.jdField_a_of_type_Anrc = new ajhi(this);
    this.d = paramBoolean;
    this.jdField_a_of_type_Ajfa = paramajfa;
  }
  
  private long a()
  {
    return a().getSharedPreferences("rec_last_troop_list_refresh_time", 0).getLong("rec_last_troop_list_refresh_time", 0L);
  }
  
  private void b(String paramString1, String paramString2)
  {
    bhbr.a(true);
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramString2);
    a(localIntent);
  }
  
  private void c(int paramInt)
  {
    Object localObject1 = null;
    if ((a() == null) || (this.jdField_a_of_type_Amjz == null)) {}
    int i;
    Object localObject2;
    do
    {
      return;
      i = paramInt - 2;
      if ((i < 0) || (i >= this.jdField_a_of_type_Amjz.getCount()))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        return;
      }
      localObject2 = this.jdField_a_of_type_Amjz.getItem(i);
    } while (!(localObject2 instanceof amkg));
    label127:
    Object localObject3;
    switch (((amkg)localObject2).jdField_a_of_type_Int)
    {
    default: 
      localObject2 = null;
      localObject3 = (amkg)this.jdField_a_of_type_Amjz.getItem(paramInt - 1);
      if ((((amkg)localObject3).jdField_a_of_type_Int == 6) || (((amkg)localObject3).jdField_a_of_type_Int == 4) || (((amkg)localObject3).jdField_a_of_type_Int == 2) || (((amkg)localObject3).jdField_a_of_type_Int == 8))
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
      localObject2 = anvx.a(2131715182);
      i = this.jdField_a_of_type_Amjz.e;
      localObject1 = String.valueOf(i);
      break label127;
      localObject2 = anvx.a(2131715179);
      i = this.jdField_a_of_type_Amjz.d;
      localObject1 = String.valueOf(i);
      break label127;
      localObject2 = anvx.a(2131715183);
      i = this.jdField_a_of_type_Amjz.jdField_b_of_type_Int;
      localObject1 = String.valueOf(i);
      break label127;
      localObject2 = anvx.a(2131715186);
      i = this.jdField_a_of_type_Amjz.jdField_c_of_type_Int;
      localObject1 = String.valueOf(i);
      break label127;
      localObject2 = anvx.a(2131715184);
      i = this.jdField_a_of_type_Amjz.f;
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131374003));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setNeedCheckSpringback(true);
    LayoutInflater localLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376910));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379609));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379608));
    Object localObject;
    if (this.d)
    {
      localObject = localLayoutInflater.inflate(2131560741, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      ((TextView)((View)localObject).findViewById(2131373970)).setText(a().getString(2131695947));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView((View)localObject);
    }
    for (;;)
    {
      localObject = new View(getContext());
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.dp2px(12.0F, getResources())));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559689, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
      if (!this.jdField_a_of_type_Ajdx.a()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this);
      }
      return;
      this.e = localLayoutInflater.inflate(2131562804, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      this.e.findViewById(2131363845).setVisibility(8);
      localObject = (EditText)this.e.findViewById(2131366280);
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
    this.jdField_a_of_type_Amjz.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Ajdx.a())
    {
      bcnc.a(paramIntent, this.jdField_a_of_type_Ajdx.a());
      return;
    }
    if (this.jdField_a_of_type_Ajdx.b())
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
  
  protected void a(Intent paramIntent, ajdx paramajdx)
  {
    super.a(paramIntent, paramajdx);
    a(2131560718);
    this.jdField_c_of_type_Int = ((Activity)getContext()).getIntent().getIntExtra("key_from", 0);
    k();
    this.jdField_b_of_type_Int = AIOUtils.dp2px(44.0F, getResources());
    a(this.jdField_a_of_type_Ajhj);
    a(this.jdField_a_of_type_Ajhk);
    a(this.jdField_a_of_type_Anrc);
    a(this.jdField_a_of_type_Ajhl);
    if (this.jdField_a_of_type_Ajdx.a())
    {
      this.jdField_a_of_type_Int = 6;
      return;
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    int i = 1;
    if (this.jdField_a_of_type_Ajdx.a())
    {
      localObject = this.jdField_a_of_type_Ajdx.a();
      if (localObject != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", paramDiscussionInfo.uin);
        localBundle.putInt("uintype", 3000);
        localBundle.putString("uinname", ForwardUtils.handleFordwardDiscName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDiscussionInfo.discussionName, paramDiscussionInfo.uin));
        localBundle.putBoolean("forward_report_confirm", true);
        localBundle.putString("forward_report_confirm_action_name", "0X8005A12");
        ((aupt)localObject).a(aupp.d.intValue(), localBundle);
      }
      paramDiscussionInfo = "";
      try
      {
        long l = this.jdField_a_of_type_Ajdx.a().getIntent().getLongExtra("req_share_id", 0L);
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
      bjgx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", paramDiscussionInfo, "1000", "32", "0", false);
      return;
    }
    b(paramDiscussionInfo.uin, paramDiscussionInfo.discussionName);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramDiscussionInfo.hasCollect) {}
    for (;;)
    {
      bdla.b((QQAppInterface)localObject, "CliOper", "", "", "0X8006666", "0X8006666", i, 0, "", "", "", "");
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
    if (this.jdField_a_of_type_Ajdx.a())
    {
      localObject = this.jdField_a_of_type_Ajdx.a();
      if (localObject != null)
      {
        localBundle = new Bundle();
        localBundle.putString("uin", paramTroopInfo.troopuin);
        localBundle.putInt("uintype", 1);
        localBundle.putString("troop_uin", paramTroopInfo.troopuin);
        localBundle.putString("uinname", paramTroopInfo.getTroopName());
        localBundle.putBoolean("forward_report_confirm", true);
        localBundle.putString("forward_report_confirm_action_name", "0X8005A11");
        ((aupt)localObject).a(aupp.c.intValue(), localBundle);
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
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "turn", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), "", "");
        paramTroopInfo = "";
        try
        {
          long l = this.jdField_a_of_type_Ajdx.a().getIntent().getLongExtra("req_share_id", 0L);
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
        bjgx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", paramTroopInfo, "1000", "31", "0", false);
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
    if (this.jdField_a_of_type_Ajdx.b())
    {
      localObject = new Intent();
      localBundle = new Bundle();
      localBundle.putString("uin", paramTroopInfo.troopuin);
      localBundle.putInt("uintype", 1);
      localBundle.putString("troop_uin", paramTroopInfo.troopuin);
      localBundle.putString("uinname", paramTroopInfo.getTroopName());
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
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), i + "", "");
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
  
  void a(String paramString1, String paramString2)
  {
    bhbr.a(true);
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(a(), SplashActivity.class), null);
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
      b(2131718993);
    }
  }
  
  protected boolean b()
  {
    if (NetworkUtil.isNetworkAvailable(a()))
    {
      ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b();
      this.jdField_c_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  public void g()
  {
    super.g();
    b(this.jdField_a_of_type_Ajhj);
    b(this.jdField_a_of_type_Ajhk);
    b(this.jdField_a_of_type_Anrc);
    b(this.jdField_a_of_type_Ajhl);
    if (this.jdField_a_of_type_Amjz != null) {
      this.jdField_a_of_type_Amjz.c();
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
      if ((!this.jdField_a_of_type_Ajdx.b()) && (i != 0)) {}
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
    if (this.jdField_a_of_type_Amjz == null) {
      if (!this.jdField_a_of_type_Ajdx.a()) {
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
        if (!this.jdField_a_of_type_Ajdx.b()) {}
        for (boolean bool = true;; bool = false)
        {
          this.jdField_a_of_type_Amjz = new amjz(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, i, this.d, bool, this.jdField_a_of_type_Ajfa);
          this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Amjz);
          this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(this);
          return;
        }
      }
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Amjz != null) {
      this.jdField_a_of_type_Amjz.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Amjz != null) {
      c(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onSlideCancelled(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Amjz.a(paramInt) == null) {}
    do
    {
      do
      {
        return;
        paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131379431);
      } while (paramSlideDetectListView == null);
      paramSlideDetectListView.hide();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131379430);
    } while (paramSlideDetectListView == null);
    paramSlideDetectListView.setTag(null);
  }
  
  public void onSlideStarted(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
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
          localTroopInfo = this.jdField_a_of_type_Amjz.a(paramInt);
        } while (localTroopInfo == null);
        paramView = (ShaderAnimLayout)paramView.findViewById(2131379431);
      } while (paramView == null);
      localButton = (Button)paramView.findViewById(2131379430);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramSlideDetectListView = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Activity localActivity = a();
    if (paramSlideDetectListView.b(localTroopInfo.troopuin)) {}
    for (paramInt = 2131692962;; paramInt = 2131692964)
    {
      paramSlideDetectListView = localActivity.getString(paramInt);
      localButton.setText(paramSlideDetectListView);
      localButton.setVisibility(0);
      localButton.setTag(localTroopInfo);
      if (admg.a) {
        localButton.setContentDescription(paramSlideDetectListView);
      }
      paramView.show();
      return;
    }
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView
 * JD-Core Version:    0.7.0.1
 */