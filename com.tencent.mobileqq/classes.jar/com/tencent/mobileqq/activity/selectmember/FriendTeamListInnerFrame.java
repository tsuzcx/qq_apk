package com.tencent.mobileqq.activity.selectmember;

import alxo;
import alxp;
import alxq;
import alxr;
import alxs;
import alyc;
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
import anvi;
import aoep;
import aofu;
import bdla;
import bfcz;
import bfeq;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
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
  private alyc jdField_a_of_type_Alyc;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anvi jdField_a_of_type_Anvi;
  aofu jdField_a_of_type_Aofu = new alxs(this);
  public bfeq a;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mInnerFrameManager.a() == 0)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mOnlyFriends)
    {
      i = j;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mDonotNeedDiscussion) {
        i = 5;
      }
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mDonotNeedContacts) {
        j = i | 0x100;
      }
      i = j;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mDonotNeedTroop) {
        i = j | 0x400000;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mEntrance != 42)
    {
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mEntrance != 41) {}
    }
    else
    {
      j = i | 0x800000;
    }
    return ContactSearchFragment.a(-1, j, null, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mUinsToHide, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
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
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
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
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)((Activity)localObject).getLayoutInflater().inflate(2131560480, null));
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("FriendTeamListInnerFrameNew", 2, "firstUserClicked is " + this.jdField_a_of_type_Boolean);
    }
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(true);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setListener(new alxo(this));
      paramBundle = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131560482, null);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(paramBundle);
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, AIOUtils.dp2px(12.0F, getResources()));
      View localView = new View(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      localView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(localView);
      QLog.d("FriendTeamListInnerFrameNew", 2, "----->onCreate");
      bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("isExpandFirst", true);
      this.jdField_a_of_type_Alyc = new alyc((Context)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new alxp(this), bool);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_Alyc);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167296);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130839546));
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_Alyc);
      setContentView(this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView);
      this.jdField_a_of_type_Bfeq = new bfeq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new alxq(this));
      this.jdField_a_of_type_Alyc.a(this.jdField_a_of_type_Bfeq);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramBundle.findViewById(2131364176));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131363873));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131378700));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramBundle.findViewById(2131363874));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131363917));
      this.c = ((Button)paramBundle.findViewById(2131363921));
      this.f = ((Button)paramBundle.findViewById(2131363916));
      localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (((localObject != null) && (!((PhoneContactManagerImp)localObject).d()) && (((PhoneContactManagerImp)localObject).d() == 8)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mOnlyFriends)) {
        break label804;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.isSupportSelectFriendGroup) {
        break label792;
      }
      this.f.setVisibility(0);
      this.f.setOnClickListener(this);
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689647));
        this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689648));
      }
      this.d = ((Button)paramBundle.findViewById(2131363877));
      this.d.setOnClickListener(this);
      this.d.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689643));
      this.d.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689643));
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("multi_chat", false))
      {
        this.d.setVisibility(8);
        this.c.setVisibility(8);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mDonotNeedTroop) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mDonotNeedDiscussion)) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_a_of_type_Anvi = new alxr(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
      bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("param_face_to_face_invite", false);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getStringExtra("group_uin");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mGroupCode;
      }
      if (bool)
      {
        this.e = ((Button)paramBundle.findViewById(2131363876));
        this.e.setVisibility(0);
        this.e.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689642));
        this.e.setOnClickListener(this);
      }
      return;
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
      break;
      label792:
      this.f.setVisibility(8);
    }
    label804:
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mDonotNeedContacts) {
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
    this.jdField_a_of_type_Bfeq.a(paramResultRecord, paramInt);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.setupTitleBar(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131718467), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mTitleString);
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_Aofu);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mEntrance == 11) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mType == 1))
    {
      paramBundle = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      String str = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getStringExtra("group_uin");
      paramBundle.a(true, str, ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(str).troopcode, true, 7, System.currentTimeMillis(), 0);
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_Aofu);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Alyc != null) {
      this.jdField_a_of_type_Alyc.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
  }
  
  public void f()
  {
    System.out.println("----->notifyDataSetChanged");
    if (this.jdField_a_of_type_Alyc != null) {
      this.jdField_a_of_type_Alyc.a();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
      this.jdField_b_of_type_Boolean = false;
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "1", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mEntrance == 11) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005525", "0X8005525", 0, 0, "", "", "", "");
      }
    }
    label175:
    Object localObject;
    int i;
    label395:
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
              if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mSubType == 0)
              {
                bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005441", "0X8005441", 1, 0, "", "", "", "");
                if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mEntrance == 12)
                {
                  bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A16", "0X8005A16", 0, 0, "", "", "", "");
                  bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006663", "0X8006663", 0, 0, "", "", "", "");
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mSubType != 1) {
                  continue;
                }
                localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
                if (localObject == null) {
                  continue;
                }
                str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
                if (!((TroopInfo)localObject).isTroopOwner(str)) {
                  break label395;
                }
                i = 0;
              }
              for (;;)
              {
                bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "invite_friend", "", "friend_list", "clk_fromgrp", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(i), "", "");
                break;
                bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005441", "0X8005441", 2, 0, "", "", "", "");
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
              bfcz.a(getContext());
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "msg_page", "clk_creategrp", 0, 0, "", "", "", "");
            }
            else if (paramView == this.d)
            {
              a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, CreateFaceToFaceDiscussionActivity.class));
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005440", "0X8005440", 0, 0, "", "", "", "");
              if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mEntrance == 12) {
                bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006662", "0X8006662", 0, 0, "", "", "", "");
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
      } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mSubType != 1);
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    if (((TroopInfo)localObject).isTroopOwner(str)) {
      i = 0;
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "invite_friend", "", "friend_list", "clk_near_invite", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(i), "", "");
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