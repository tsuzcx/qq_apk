package com.tencent.mobileqq.activity.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import xzb;
import xzc;
import xze;

public class FriendTeamListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SelectMemberBuddyListAdapter jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private PinnedFooterExpandableListView jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  private String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private Button jdField_b_of_type_AndroidWidgetButton;
  boolean jdField_b_of_type_Boolean = false;
  private Button jdField_c_of_type_AndroidWidgetButton;
  boolean jdField_c_of_type_Boolean = false;
  private Button jdField_d_of_type_AndroidWidgetButton;
  boolean jdField_d_of_type_Boolean = false;
  private Button e;
  private Button f;
  
  public FriendTeamListInnerFrame(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public FriendTeamListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public FriendTeamListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a()
  {
    return (this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean);
  }
  
  private void g()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D0C", "0X8005D0C", 0, 0, "", "", "", "");
    Object localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (!((PhoneContactManagerImp)localObject).f())
    {
      a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, GuideBindPhoneActivity.class));
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    switch (((PhoneContactManagerImp)localObject).c())
    {
    default: 
      if ((((PhoneContactManagerImp)localObject).a() != null) && (((PhoneContactManagerImp)localObject).a().isStopFindMatch))
      {
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, PhoneLaunchActivity.class);
        ((Intent)localObject).putExtra("needAlert", true);
        ((Intent)localObject).putExtra("fromStopAndMatch", true);
        ((Intent)localObject).putExtra("fromAVCallInvite", true);
        ((Intent)localObject).putExtra("leftViewText", "返回");
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.startActivity((Intent)localObject);
      }
      break;
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, BindNumberActivity.class);
      ((Intent)localObject).putExtra("key_is_from_qav_multi_call", true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.startActivity((Intent)localObject);
      this.jdField_b_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
      this.jdField_b_of_type_Boolean = false;
      return;
      localObject = new Intent(a(), PhoneFrameActivity.class);
      ((Intent)localObject).putExtra("key_req_type", 6);
      ((Intent)localObject).putExtra("kSrouce", 6);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.startActivity((Intent)localObject);
    }
  }
  
  public ContactSearchFragment a()
  {
    int j = 1;
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k)
    {
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.j) {
        j = 5;
      }
      i = j;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_h_of_type_Boolean) {
        i = j | 0x100;
      }
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i) {
        j = i | 0x400000;
      }
    }
    return ContactSearchFragment.a(-1, j, null, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_h_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return null;
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localPhoneContactManagerImp != null)
      {
        int i = localPhoneContactManagerImp.c();
        if ((i != 8) && (i != 9)) {}
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
      return;
    }
    finally
    {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Object localObject = a();
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)((Activity)localObject).getLayoutInflater().inflate(2130969721, null));
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("FriendTeamListInnerFrameNew", 2, "firstUserClicked is " + this.jdField_a_of_type_Boolean);
    }
    boolean bool;
    int i;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(true);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setListener(new xzb(this));
      paramBundle = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130969723, null);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(paramBundle);
      QLog.d("FriendTeamListInnerFrameNew", 2, "----->onCreate");
      bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("isExpandFirst", true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter = new SelectMemberBuddyListAdapter((Context)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new xzc(this), bool);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131492924);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130838660));
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter);
      setContentView(this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramBundle.findViewById(2131367593));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131367597));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131367598));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramBundle.findViewById(2131367596));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131367599));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131367600));
      this.f = ((Button)paramBundle.findViewById(2131367592));
      localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if ((localObject == null) || ((!((PhoneContactManagerImp)localObject).c()) && (((PhoneContactManagerImp)localObject).c() != 8))) {
        break label785;
      }
      i = 1;
      label372:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f != 10) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f != 11)) {
        break label790;
      }
      bool = true;
      label398:
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_d_of_type_Boolean = ConfigSystemImpl.b(getContext());
      if ((!this.jdField_d_of_type_Boolean) || (i == 0) || (!this.jdField_c_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k) {
        break label807;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.u) {
        break label795;
      }
      this.f.setVisibility(0);
      this.f.setOnClickListener(this);
    }
    for (;;)
    {
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435527));
        this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435518));
      }
      this.jdField_d_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131367595));
      this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435499));
      this.jdField_d_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435499));
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("multi_chat", false))
      {
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.j)) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new xze(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("param_face_to_face_invite", false);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getStringExtra("group_uin");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c;
      }
      if (bool)
      {
        this.e = ((Button)paramBundle.findViewById(2131367594));
        this.e.setVisibility(0);
        this.e.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435501));
        this.e.setOnClickListener(this);
      }
      return;
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
      break;
      label785:
      i = 0;
      break label372;
      label790:
      bool = false;
      break label398;
      label795:
      this.f.setVisibility(8);
    }
    label807:
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("select_member_contacts_flag", 0) == 1) {
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435990), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_JavaLangString);
    f();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter.b();
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void f()
  {
    System.out.println("----->notifyDataSetChanged");
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter.a();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (a())
      {
        g();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "1", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f != 11) {
          break label107;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005525", "0X8005525", 0, 0, "", "", "", "");
      }
    }
    label107:
    int i;
    label363:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
                  this.jdField_b_of_type_Boolean = false;
                  break;
                } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f != 10);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005520", "0X8005520", 0, 0, "", "", "", "");
                return;
                if (paramView != this.jdField_b_of_type_AndroidWidgetButton) {
                  break label413;
                }
                this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
                if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int != 0) {
                  break label363;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005441", "0X8005441", 1, 0, "", "", "", "");
                if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f == 12)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A16", "0X8005A16", 0, 0, "", "", "", "");
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006663", "0X8006663", 0, 0, "", "", "", "");
                }
              } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int != 1);
              paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_JavaLangString);
            } while (paramView == null);
            str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
            if (paramView.isTroopOwner(str)) {
              i = 0;
            }
            for (;;)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "invite_friend", "", "friend_list", "clk_fromgrp", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(i), "", "");
              return;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005441", "0X8005441", 2, 0, "", "", "", "");
              break;
              if (paramView.isTroopAdmin(str)) {
                i = 1;
              } else {
                i = 2;
              }
            }
            if (paramView == this.jdField_c_of_type_AndroidWidgetButton)
            {
              TroopQQBrowserHelper.a(getContext());
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "msg_page", "clk_creategrp", 0, 0, "", "", "", "");
              return;
            }
            if (paramView != this.jdField_d_of_type_AndroidWidgetButton) {
              break label557;
            }
            a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, CreateFaceToFaceDiscussionActivity.class));
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005440", "0X8005440", 0, 0, "", "", "", "");
          } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f != 12);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006662", "0X8006662", 0, 0, "", "", "", "");
          return;
          if (paramView == this.f)
          {
            this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(8);
            return;
          }
        } while (paramView != this.e);
        paramView = new Intent(getContext(), Face2FaceAddFriendActivity.class);
        paramView.putExtra("activity_from_type", 1);
        paramView.putExtra("activity_troop_uin", this.jdField_a_of_type_JavaLangString);
        a(paramView);
      } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int != 1);
      paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_JavaLangString);
    } while (paramView == null);
    label413:
    label557:
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    if (paramView.isTroopOwner(str)) {
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "invite_friend", "", "friend_list", "clk_near_invite", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(i), "", "");
      return;
      if (paramView.isTroopAdmin(str)) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame
 * JD-Core Version:    0.7.0.1
 */