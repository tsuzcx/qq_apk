package com.tencent.mobileqq.activity.contact.troop;

import aaek;
import aciy;
import afaw;
import afbu;
import afdb;
import afdc;
import afdd;
import afde;
import aida;
import aidf;
import aidh;
import ajey;
import ajjy;
import ajtg;
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
import aphf;
import aphp;
import avwf;
import awqx;
import aynk;
import azzv;
import badq;
import bbob;
import bcad;
import begh;
import belq;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;

public class TroopView
  extends BaseTroopView
  implements aidf, View.OnClickListener, bbob, begh, belq
{
  protected afbu a;
  protected afdc a;
  protected afdd a;
  protected afde a;
  protected aida a;
  protected ajey a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public PullRefreshHeader a;
  public SlideDetectListView a;
  int jdField_b_of_type_Int;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  public boolean c = false;
  protected boolean d;
  protected View e;
  
  public TroopView(Context paramContext, boolean paramBoolean, afbu paramafbu)
  {
    super(paramContext);
    this.jdField_a_of_type_Afdc = new afdc(this);
    this.jdField_a_of_type_Afde = new afde(this);
    this.jdField_a_of_type_Afdd = new afdd(this);
    this.jdField_a_of_type_Ajey = new afdb(this);
    this.d = paramBoolean;
    this.jdField_a_of_type_Afbu = paramafbu;
  }
  
  private long a()
  {
    return a().getSharedPreferences("rec_last_troop_list_refresh_time", 0).getLong("rec_last_troop_list_refresh_time", 0L);
  }
  
  private void b(String paramString1, String paramString2)
  {
    azzv.a(true);
    Intent localIntent = aciy.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramString2);
    a(localIntent);
  }
  
  private void c(int paramInt)
  {
    Object localObject1 = null;
    if ((a() == null) || (this.jdField_a_of_type_Aida == null)) {}
    int i;
    Object localObject2;
    do
    {
      return;
      i = paramInt - 2;
      if ((i < 0) || (i >= this.jdField_a_of_type_Aida.getCount()))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        return;
      }
      localObject2 = this.jdField_a_of_type_Aida.getItem(i);
    } while (!(localObject2 instanceof aidh));
    label127:
    Object localObject3;
    switch (((aidh)localObject2).jdField_a_of_type_Int)
    {
    default: 
      localObject2 = null;
      localObject3 = (aidh)this.jdField_a_of_type_Aida.getItem(paramInt - 1);
      if ((((aidh)localObject3).jdField_a_of_type_Int == 6) || (((aidh)localObject3).jdField_a_of_type_Int == 4) || (((aidh)localObject3).jdField_a_of_type_Int == 2) || (((aidh)localObject3).jdField_a_of_type_Int == 8))
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
      localObject2 = ajjy.a(2131650026);
      i = this.jdField_a_of_type_Aida.e;
      localObject1 = String.valueOf(i);
      break label127;
      localObject2 = ajjy.a(2131650023);
      i = this.jdField_a_of_type_Aida.d;
      localObject1 = String.valueOf(i);
      break label127;
      localObject2 = ajjy.a(2131650027);
      i = this.jdField_a_of_type_Aida.jdField_b_of_type_Int;
      localObject1 = String.valueOf(i);
      break label127;
      localObject2 = ajjy.a(2131650030);
      i = this.jdField_a_of_type_Aida.c;
      localObject1 = String.valueOf(i);
      break label127;
      localObject2 = ajjy.a(2131650028);
      i = this.jdField_a_of_type_Aida.f;
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131307022));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setNeedCheckSpringback(true);
    LayoutInflater localLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131309710));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312075));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312074));
    Object localObject;
    if (this.d)
    {
      localObject = localLayoutInflater.inflate(2131494830, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      ((TextView)((View)localObject).findViewById(2131306990)).setText(a().getString(2131630798));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView((View)localObject);
    }
    for (;;)
    {
      localObject = new View(getContext());
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, aciy.a(12.0F, getResources())));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131493891, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
      if (!this.jdField_a_of_type_Afaw.a()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this);
      }
      return;
      this.e = localLayoutInflater.inflate(2131496760, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      this.e.findViewById(2131297934).setVisibility(8);
      localObject = (EditText)this.e.findViewById(2131300167);
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
    this.jdField_a_of_type_Aida.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Afaw.a())
    {
      avwf.a(paramIntent, this.jdField_a_of_type_Afaw.a());
      return;
    }
    if (this.jdField_a_of_type_Afaw.b())
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
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  protected void a(Intent paramIntent, afaw paramafaw)
  {
    super.a(paramIntent, paramafaw);
    a(2131494807);
    k();
    this.jdField_b_of_type_Int = aciy.a(44.0F, getResources());
    a(this.jdField_a_of_type_Afdc);
    a(this.jdField_a_of_type_Afdd);
    a(this.jdField_a_of_type_Ajey);
    a(this.jdField_a_of_type_Afde);
    if (this.jdField_a_of_type_Afaw.a())
    {
      this.jdField_a_of_type_Int = 6;
      return;
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    int i = 1;
    if (this.jdField_a_of_type_Afaw.a())
    {
      localObject = this.jdField_a_of_type_Afaw.a();
      if (localObject != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", paramDiscussionInfo.uin);
        localBundle.putInt("uintype", 3000);
        localBundle.putString("uinname", ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDiscussionInfo.discussionName, paramDiscussionInfo.uin));
        localBundle.putBoolean("forward_report_confirm", true);
        localBundle.putString("forward_report_confirm_action_name", "0X8005A12");
        ((aphp)localObject).a(aphf.d.intValue(), localBundle);
      }
      paramDiscussionInfo = "";
      try
      {
        long l = this.jdField_a_of_type_Afaw.a().getIntent().getLongExtra("req_share_id", 0L);
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
      bcad.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", paramDiscussionInfo, "1000", "32", "0", false);
      return;
    }
    b(paramDiscussionInfo.uin, paramDiscussionInfo.discussionName);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramDiscussionInfo.hasCollect) {}
    for (;;)
    {
      awqx.b((QQAppInterface)localObject, "CliOper", "", "", "0X8006666", "0X8006666", i, 0, "", "", "", "");
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
    if (this.jdField_a_of_type_Afaw.a())
    {
      localObject = this.jdField_a_of_type_Afaw.a();
      if (localObject != null)
      {
        localBundle = new Bundle();
        localBundle.putString("uin", paramTroopInfo.troopuin);
        localBundle.putInt("uintype", 1);
        localBundle.putString("troop_uin", paramTroopInfo.troopuin);
        localBundle.putString("uinname", paramTroopInfo.getTroopName());
        localBundle.putBoolean("forward_report_confirm", true);
        localBundle.putString("forward_report_confirm_action_name", "0X8005A11");
        ((aphp)localObject).a(aphf.c.intValue(), localBundle);
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
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "turn", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), "", "");
        paramTroopInfo = "";
        try
        {
          long l = this.jdField_a_of_type_Afaw.a().getIntent().getLongExtra("req_share_id", 0L);
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
        bcad.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", paramTroopInfo, "1000", "31", "0", false);
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
    if (this.jdField_a_of_type_Afaw.b())
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
      switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramTroopInfo.troopuin))
      {
      default: 
        i = 0;
      }
      break;
    }
    for (;;)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), i + "", "");
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
          localTroopInfo = this.jdField_a_of_type_Aida.a(paramInt);
        } while (localTroopInfo == null);
        paramView = (ShaderAnimLayout)paramView.findViewById(2131311931);
      } while (paramView == null);
      localButton = (Button)paramView.findViewById(2131311930);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramSlideDetectListView = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Activity localActivity = a();
    if (paramSlideDetectListView.b(localTroopInfo.troopuin)) {}
    for (paramInt = 2131627558;; paramInt = 2131627560)
    {
      paramSlideDetectListView = localActivity.getString(paramInt);
      localButton.setText(paramSlideDetectListView);
      localButton.setVisibility(0);
      localButton.setTag(localTroopInfo);
      if (aaek.S) {
        localButton.setContentDescription(paramSlideDetectListView);
      }
      paramView.a();
      return;
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    azzv.a(true);
    Intent localIntent = aciy.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    paramString1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramString1);
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
    if (!b()) {
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
      b(2131653904);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Aida.a(paramInt) == null) {}
    do
    {
      do
      {
        return;
        paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131311931);
      } while (paramSlideDetectListView == null);
      paramSlideDetectListView.e();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131311930);
    } while (paramSlideDetectListView == null);
    paramSlideDetectListView.setTag(null);
  }
  
  protected boolean b()
  {
    if (badq.g(a()))
    {
      ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b();
      this.c = true;
      return true;
    }
    return false;
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void g()
  {
    super.g();
    b(this.jdField_a_of_type_Afdc);
    b(this.jdField_a_of_type_Afdd);
    b(this.jdField_a_of_type_Ajey);
    b(this.jdField_a_of_type_Afde);
    if (this.jdField_a_of_type_Aida != null) {
      this.jdField_a_of_type_Aida.c();
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
      if ((!this.jdField_a_of_type_Afaw.b()) && (i != 0)) {}
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
    int i;
    if (this.jdField_a_of_type_Aida == null)
    {
      if (!this.jdField_a_of_type_Afaw.a()) {
        break label89;
      }
      i = 1;
      if (this.jdField_a_of_type_Afaw.b()) {
        break label94;
      }
    }
    label89:
    label94:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Aida = new aida(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, i, this.d, bool, this.jdField_a_of_type_Afbu);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Aida);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(this);
      return;
      i = 0;
      break;
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Aida != null) {
      this.jdField_a_of_type_Aida.notifyDataSetChanged();
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006622", "0X8006622", 0, 0, "", "", "", "");
      paramView = (aynk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    } while (paramView == null);
    paramView.a((BaseActivity)a(), 0);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Aida != null) {
      c(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView
 * JD-Core Version:    0.7.0.1
 */