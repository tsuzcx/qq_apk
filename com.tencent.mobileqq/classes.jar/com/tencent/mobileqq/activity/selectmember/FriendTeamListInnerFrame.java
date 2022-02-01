package com.tencent.mobileqq.activity.selectmember;

import agej;
import amdr;
import amds;
import amdt;
import amdu;
import amdv;
import amez;
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
import anyu;
import aoip;
import aojs;
import bdll;
import bfmm;
import bfod;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class FriendTeamListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  private amez jdField_a_of_type_Amez;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anyu jdField_a_of_type_Anyu;
  aojs jdField_a_of_type_Aojs = new amdv(this);
  public bfod a;
  private PinnedFooterExpandableListView jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  private String jdField_a_of_type_JavaLangString;
  List<Entity> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private Button jdField_b_of_type_AndroidWidgetButton;
  boolean jdField_b_of_type_Boolean = false;
  private Button c;
  private Button d;
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
  
  public ContactSearchFragment a()
  {
    int i = 1;
    int j = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g)
    {
      i = j;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f) {
        i = 5;
      }
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Boolean) {
        j = i | 0x100;
      }
      i = j;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e) {
        i = j | 0x400000;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int != 42)
    {
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int != 41) {}
    }
    else
    {
      j = i | 0x800000;
    }
    return ContactSearchFragment.a(-1, j, null, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
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
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (localPhoneContactManagerImp != null)
      {
        int i = localPhoneContactManagerImp.d();
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
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)((Activity)localObject).getLayoutInflater().inflate(2131560419, null));
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("FriendTeamListInnerFrameNew", 2, "firstUserClicked is " + this.jdField_a_of_type_Boolean);
    }
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(true);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setListener(new amdr(this));
      paramBundle = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131560421, null);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(paramBundle);
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, agej.a(12.0F, getResources()));
      View localView = new View(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      localView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(localView);
      QLog.d("FriendTeamListInnerFrameNew", 2, "----->onCreate");
      bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("isExpandFirst", true);
      this.jdField_a_of_type_Amez = new amez((Context)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new amds(this), bool);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_Amez);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167247);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130839490));
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_Amez);
      setContentView(this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView);
      this.jdField_a_of_type_Bfod = new bfod(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new amdt(this));
      this.jdField_a_of_type_Amez.a(this.jdField_a_of_type_Bfod);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramBundle.findViewById(2131364080));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131363772));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131378645));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramBundle.findViewById(2131363773));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131363818));
      this.c = ((Button)paramBundle.findViewById(2131363822));
      this.f = ((Button)paramBundle.findViewById(2131363817));
      localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (((localObject != null) && (!((PhoneContactManagerImp)localObject).d()) && (((PhoneContactManagerImp)localObject).d() == 8)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g)) {
        break label803;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.r) {
        break label791;
      }
      this.f.setVisibility(0);
      this.f.setOnClickListener(this);
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689648));
        this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689649));
      }
      this.d = ((Button)paramBundle.findViewById(2131363776));
      this.d.setOnClickListener(this);
      this.d.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689644));
      this.d.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689644));
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("multi_chat", false))
      {
        this.d.setVisibility(8);
        this.c.setVisibility(8);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f)) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_a_of_type_Anyu = new amdu(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
      bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("param_face_to_face_invite", false);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getStringExtra("group_uin");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c;
      }
      if (bool)
      {
        this.e = ((Button)paramBundle.findViewById(2131363775));
        this.e.setVisibility(0);
        this.e.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689643));
        this.e.setOnClickListener(this);
      }
      return;
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
      break;
      label791:
      this.f.setVisibility(8);
    }
    label803:
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.c.setOnClickListener(this);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("select_member_contacts_flag", 0) == 1) {
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
  
  public void a(ResultRecord paramResultRecord, int paramInt)
  {
    super.a(paramResultRecord, paramInt);
    this.jdField_a_of_type_Bfod.a(paramResultRecord, paramInt);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131717844), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_JavaLangString);
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_Aojs);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 11) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_Int == 1))
    {
      paramBundle = (aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      String str = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getStringExtra("group_uin");
      paramBundle.a(true, str, ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(str).troopcode, true, 7, System.currentTimeMillis(), 0);
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_Aojs);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Amez != null) {
      this.jdField_a_of_type_Amez.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
  }
  
  public void f()
  {
    System.out.println("----->notifyDataSetChanged");
    if (this.jdField_a_of_type_Amez != null) {
      this.jdField_a_of_type_Amez.a();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
      this.jdField_b_of_type_Boolean = false;
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "1", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 11) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005525", "0X8005525", 0, 0, "", "", "", "");
      }
    }
    label175:
    Object localObject;
    int i;
    label394:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
            {
              this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
              if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b == 0)
              {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005441", "0X8005441", 1, 0, "", "", "", "");
                if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 12)
                {
                  bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A16", "0X8005A16", 0, 0, "", "", "", "");
                  bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006663", "0X8006663", 0, 0, "", "", "", "");
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b != 1) {
                  continue;
                }
                localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_JavaLangString);
                if (localObject == null) {
                  continue;
                }
                str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
                if (!((TroopInfo)localObject).isTroopOwner(str)) {
                  break label394;
                }
                i = 0;
              }
              for (;;)
              {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "invite_friend", "", "friend_list", "clk_fromgrp", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(i), "", "");
                break;
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005441", "0X8005441", 2, 0, "", "", "", "");
                break label175;
                if (((TroopInfo)localObject).isTroopAdmin(str)) {
                  i = 1;
                } else {
                  i = 2;
                }
              }
            }
            else if (paramView == this.c)
            {
              bfmm.a(getContext());
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "msg_page", "clk_creategrp", 0, 0, "", "", "", "");
            }
            else if (paramView == this.d)
            {
              a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, CreateFaceToFaceDiscussionActivity.class));
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005440", "0X8005440", 0, 0, "", "", "", "");
              if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 12) {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006662", "0X8006662", 0, 0, "", "", "", "");
              }
            }
            else
            {
              if (paramView != this.f) {
                break;
              }
              this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(8);
            }
          }
        } while (paramView != this.e);
        localObject = new Intent(getContext(), Face2FaceAddFriendActivity.class);
        ((Intent)localObject).putExtra("activity_from_type", 1);
        ((Intent)localObject).putExtra("activity_troop_uin", this.jdField_a_of_type_JavaLangString);
        a((Intent)localObject);
      } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b != 1);
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    if (((TroopInfo)localObject).isTroopOwner(str)) {
      i = 0;
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "invite_friend", "", "friend_list", "clk_near_invite", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(i), "", "");
      break;
      if (((TroopInfo)localObject).isTroopAdmin(str)) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame
 * JD-Core Version:    0.7.0.1
 */