package com.tencent.mobileqq.activity.selectmember;

import actj;
import aidk;
import aidl;
import aidm;
import aidn;
import aido;
import aies;
import ajxj;
import akhp;
import akil;
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
import auko;
import axqy;
import azjz;
import azlq;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class FriendTeamListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  private aies jdField_a_of_type_Aies;
  private ajxj jdField_a_of_type_Ajxj;
  akil jdField_a_of_type_Akil = new aido(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public azlq a;
  private PinnedFooterExpandableListView jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  private String jdField_a_of_type_JavaLangString;
  List<auko> jdField_a_of_type_JavaUtilList = new ArrayList();
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
    int j = 1;
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g)
    {
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f) {
        j = 5;
      }
      i = j;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Boolean) {
        i = j | 0x100;
      }
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e) {
        j = i | 0x400000;
      }
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
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)((Activity)localObject).getLayoutInflater().inflate(2131560143, null));
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("FriendTeamListInnerFrameNew", 2, "firstUserClicked is " + this.jdField_a_of_type_Boolean);
    }
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(true);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setListener(new aidk(this));
      paramBundle = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131560145, null);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(paramBundle);
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, actj.a(12.0F, getResources()));
      View localView = new View(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      localView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(localView);
      QLog.d("FriendTeamListInnerFrameNew", 2, "----->onCreate");
      bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("isExpandFirst", true);
      this.jdField_a_of_type_Aies = new aies((Context)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new aidl(this), bool);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_Aies);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167087);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130839212));
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_Aies);
      setContentView(this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView);
      this.jdField_a_of_type_Azlq = new azlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new aidm(this));
      this.jdField_a_of_type_Aies.a(this.jdField_a_of_type_Azlq);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramBundle.findViewById(2131363789));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131363507));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131377072));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramBundle.findViewById(2131363508));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131363549));
      this.c = ((Button)paramBundle.findViewById(2131363553));
      this.f = ((Button)paramBundle.findViewById(2131363548));
      localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (((localObject != null) && (!((PhoneContactManagerImp)localObject).c()) && (((PhoneContactManagerImp)localObject).d() == 8)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g)) {
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
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689745));
        this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689748));
      }
      this.d = ((Button)paramBundle.findViewById(2131363511));
      this.d.setOnClickListener(this);
      this.d.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689737));
      this.d.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689737));
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("multi_chat", false))
      {
        this.d.setVisibility(8);
        this.c.setVisibility(8);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f)) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_a_of_type_Ajxj = new aidn(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
      bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("param_face_to_face_invite", false);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getStringExtra("group_uin");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c;
      }
      if (bool)
      {
        this.e = ((Button)paramBundle.findViewById(2131363510));
        this.e.setVisibility(0);
        this.e.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689736));
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
    this.jdField_a_of_type_Azlq.a(paramResultRecord, paramInt);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719218), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_JavaLangString);
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_Akil);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 11) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_Int == 1))
    {
      paramBundle = (akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      String str = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getStringExtra("group_uin");
      paramBundle.a(true, str, ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(str).troopcode, true, 7, System.currentTimeMillis(), 0);
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_Akil);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Aies != null) {
      this.jdField_a_of_type_Aies.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
  }
  
  public void f()
  {
    System.out.println("----->notifyDataSetChanged");
    if (this.jdField_a_of_type_Aies != null) {
      this.jdField_a_of_type_Aies.a();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
      this.jdField_b_of_type_Boolean = false;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "1", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 11) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005525", "0X8005525", 0, 0, "", "", "", "");
      }
    }
    int i;
    label401:
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
                if (paramView != this.jdField_b_of_type_AndroidWidgetButton) {
                  break label401;
                }
                this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
                if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b != 0) {
                  break;
                }
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005441", "0X8005441", 1, 0, "", "", "", "");
                if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 12)
                {
                  axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A16", "0X8005A16", 0, 0, "", "", "", "");
                  axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006663", "0X8006663", 0, 0, "", "", "", "");
                }
              } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b != 1);
              paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_JavaLangString);
            } while (paramView == null);
            str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
            if (paramView.isTroopOwner(str)) {
              i = 0;
            }
            for (;;)
            {
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "invite_friend", "", "friend_list", "clk_fromgrp", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(i), "", "");
              return;
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005441", "0X8005441", 2, 0, "", "", "", "");
              break;
              if (paramView.isTroopAdmin(str)) {
                i = 1;
              } else {
                i = 2;
              }
            }
            if (paramView == this.c)
            {
              azjz.a(getContext());
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "msg_page", "clk_creategrp", 0, 0, "", "", "", "");
              return;
            }
            if (paramView != this.d) {
              break;
            }
            a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, CreateFaceToFaceDiscussionActivity.class));
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005440", "0X8005440", 0, 0, "", "", "", "");
          } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int != 12);
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006662", "0X8006662", 0, 0, "", "", "", "");
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
      } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b != 1);
      paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_JavaLangString);
    } while (paramView == null);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    if (paramView.isTroopOwner(str)) {
      i = 0;
    }
    for (;;)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "invite_friend", "", "friend_list", "clk_near_invite", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(i), "", "");
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