package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.newfriend.ContactMatchMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;
import wgg;

public class ContactMatchBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager;
  
  public ContactMatchBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)paramQQAppInterface.getManager(33));
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ContactMatchBuilder.ContactMatchHolder localContactMatchHolder;
    label196:
    ContactMatch localContactMatch;
    StringBuilder localStringBuilder;
    label270:
    int i;
    if ((paramView == null) || (!(paramView.getTag() instanceof ContactMatchBuilder.ContactMatchHolder)))
    {
      localContactMatchHolder = new ContactMatchBuilder.ContactMatchHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2130970593, localContactMatchHolder);
      localContactMatchHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366518));
      localContactMatchHolder.h = ((TextView)paramView.findViewById(2131362876));
      localContactMatchHolder.i = ((TextView)paramView.findViewById(2131369905));
      localContactMatchHolder.l = ((TextView)paramView.findViewById(2131371369));
      localContactMatchHolder.j = ((TextView)paramView.findViewById(2131369907));
      localContactMatchHolder.k = ((TextView)paramView.findViewById(2131368908));
      localContactMatchHolder.a = ((Button)paramView.findViewById(2131368907));
      paramView.setTag(localContactMatchHolder);
      localContactMatchHolder.jdField_f_of_type_AndroidViewView.setTag(localContactMatchHolder);
      localContactMatchHolder.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage, localContactMatchHolder, this);
      if (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage.a()) {
        break label573;
      }
      localContactMatchHolder.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838585);
      localContactMatch = ((ContactMatchMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
      localStringBuilder = new StringBuilder(256);
      if (TextUtils.isEmpty(localContactMatch.name)) {
        break label586;
      }
      localContactMatchHolder.h.setVisibility(0);
      localContactMatchHolder.h.setText(localContactMatch.name);
      if (AppSetting.b) {
        localStringBuilder.append(localContactMatch.name);
      }
      switch (localContactMatch.gender)
      {
      default: 
        localContactMatchHolder.l.setBackgroundResource(2130843021);
        i = 0;
        paramInt = 0;
      }
    }
    for (;;)
    {
      label310:
      if (localContactMatch.age > 0)
      {
        localContactMatchHolder.l.setText(String.valueOf(localContactMatch.age));
        if (!AppSetting.b) {
          break label821;
        }
        localStringBuilder.append(",").append(String.valueOf(localContactMatch.age));
        paramInt = 1;
      }
      for (;;)
      {
        label361:
        localContactMatchHolder.l.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        if (paramInt != 0)
        {
          localContactMatchHolder.l.setVisibility(0);
          localContactMatchHolder.l.setPadding(8, 4, 8, 4);
          label400:
          localContactMatchHolder.i.setVisibility(8);
          localContactMatchHolder.j.setText("来自手机通讯录");
          localContactMatchHolder.j.setVisibility(0);
          if (AppSetting.b) {
            localStringBuilder.append(",来自手机通讯录");
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localContactMatch.unifiedCode, true)) {
            break label705;
          }
          localContactMatchHolder.a.setVisibility(8);
          localContactMatchHolder.k.setVisibility(0);
          localContactMatchHolder.k.setText("等待验证");
          if (AppSetting.b)
          {
            localStringBuilder.append(",等待验证");
            localContactMatchHolder.k.setContentDescription("等待验证");
          }
        }
        for (;;)
        {
          if (AppSetting.b) {
            paramView.setContentDescription(localStringBuilder.toString());
          }
          localContactMatchHolder.jdField_f_of_type_JavaLangString = localContactMatch.unifiedCode;
          localContactMatchHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(11, localContactMatch.unifiedCode));
          return paramView;
          localContactMatchHolder = (ContactMatchBuilder.ContactMatchHolder)paramView.getTag();
          break;
          label573:
          localContactMatchHolder.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838581);
          break label196;
          label586:
          localContactMatchHolder.h.setVisibility(8);
          break label270;
          paramInt = 2130843020;
          localContactMatchHolder.l.setBackgroundResource(2130843021);
          i = paramInt;
          if (!AppSetting.b) {
            break label826;
          }
          localStringBuilder.append(",男");
          int j = 1;
          i = paramInt;
          paramInt = j;
          break label310;
          paramInt = 2130843018;
          localContactMatchHolder.l.setBackgroundResource(2130843019);
          i = paramInt;
          if (!AppSetting.b) {
            break label826;
          }
          localStringBuilder.append(",女");
          j = 1;
          i = paramInt;
          paramInt = j;
          break label310;
          localContactMatchHolder.l.setText("");
          break label361;
          localContactMatchHolder.l.setVisibility(8);
          break label400;
          label705:
          localContactMatchHolder.a.setVisibility(0);
          localContactMatchHolder.a.setText("添加");
          localContactMatchHolder.a.setTag(localContactMatch);
          localContactMatchHolder.a.setOnClickListener(this);
          ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494231);
          if (localColorStateList != null) {
            localContactMatchHolder.a.setTextColor(localColorStateList);
          }
          localContactMatchHolder.a.setBackgroundResource(2130838516);
          localContactMatchHolder.k.setVisibility(8);
          if (AppSetting.b)
          {
            localStringBuilder.append(",添加");
            localContactMatchHolder.a.setContentDescription("点击添加");
          }
        }
        label821:
        paramInt = 1;
      }
      label826:
      paramInt = 1;
    }
  }
  
  protected void a()
  {
    ThreadManager.getSubThreadHandler().post(new wgg(this));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof ContactMatchBuilder.ContactMatchHolder)));
        localObject = ((ContactMatchMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
      } while (localObject == null);
      if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).g()) {}
      for (paramView = new ProfileActivity.AllInOne(((ContactMatch)localObject).unifiedCode, 34);; paramView = new ProfileActivity.AllInOne(((ContactMatch)localObject).unifiedCode, 29))
      {
        paramView.h = ((ContactMatch)localObject).name;
        ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, paramView, 229);
        this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.f();
        return;
      }
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof ContactMatch)));
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131432992), 0).b(b());
      return;
    }
    paramView = (ContactMatch)paramView;
    if (paramView != null)
    {
      localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      int i = 3006;
      int j = 3;
      if (!((PhoneContactManagerImp)localObject).g())
      {
        i = 3075;
        j = 1;
      }
      paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, paramView.unifiedCode, "ContactMatchBuilder", i, j, paramView.name, null, null, "手机联系人", null);
      ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 229);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.f();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder
 * JD-Core Version:    0.7.0.1
 */