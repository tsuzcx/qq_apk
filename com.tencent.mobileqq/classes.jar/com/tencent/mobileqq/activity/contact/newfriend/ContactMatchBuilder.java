package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mobileqq.activity.contact.newfriend.msg.ContactMatchMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class ContactMatchBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  
  public ContactMatchBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager = ((NewFriendManager)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297494);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ContactMatchBuilder.ContactMatchHolder localContactMatchHolder;
    Object localObject;
    boolean bool;
    label213:
    StringBuilder localStringBuilder;
    if ((paramView == null) || (!(paramView.getTag() instanceof ContactMatchBuilder.ContactMatchHolder)))
    {
      localContactMatchHolder = new ContactMatchBuilder.ContactMatchHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561658, localContactMatchHolder);
      a(paramView, this.b);
      localContactMatchHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localContactMatchHolder.h = ((TextView)paramView.findViewById(2131372288));
      localContactMatchHolder.i = ((TextView)paramView.findViewById(2131377005));
      localContactMatchHolder.l = ((TextView)paramView.findViewById(2131362338));
      localContactMatchHolder.j = ((TextView)paramView.findViewById(2131378318));
      localContactMatchHolder.k = ((TextView)paramView.findViewById(2131377001));
      localContactMatchHolder.a = ((Button)paramView.findViewById(2131376990));
      b(localContactMatchHolder.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localContactMatchHolder);
      localContactMatchHolder.g.setTag(localContactMatchHolder);
      localContactMatchHolder.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage, localContactMatchHolder, this);
      localObject = localContactMatchHolder.g;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage.a()) {
        break label495;
      }
      bool = true;
      a((View)localObject, bool);
      localObject = ((ContactMatchMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a;
      localStringBuilder = new StringBuilder(256);
      if (TextUtils.isEmpty(((ContactMatch)localObject).name)) {
        break label500;
      }
      localContactMatchHolder.h.setVisibility(0);
      localContactMatchHolder.h.setText(((ContactMatch)localObject).name);
      if (AppSetting.d) {
        localStringBuilder.append(((ContactMatch)localObject).name);
      }
      label293:
      a(localContactMatchHolder.l, ((ContactMatch)localObject).gender, ((ContactMatch)localObject).age, localStringBuilder);
      localContactMatchHolder.i.setVisibility(8);
      localContactMatchHolder.j.setText(HardCodeUtil.a(2131702551));
      localContactMatchHolder.j.setVisibility(0);
      if (AppSetting.d) {
        localStringBuilder.append(",来自手机通讯录");
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(((ContactMatch)localObject).unifiedCode, true)) {
        break label513;
      }
      localContactMatchHolder.a.setVisibility(8);
      localContactMatchHolder.k.setVisibility(0);
      localContactMatchHolder.k.setText(HardCodeUtil.a(2131702548));
      if (AppSetting.d)
      {
        localStringBuilder.append(",等待验证");
        localContactMatchHolder.k.setContentDescription(HardCodeUtil.a(2131702552));
      }
    }
    for (;;)
    {
      if (AppSetting.d) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localContactMatchHolder.jdField_f_of_type_JavaLangString = ((ContactMatch)localObject).unifiedCode;
      localContactMatchHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, ((ContactMatch)localObject).unifiedCode));
      return paramView;
      localContactMatchHolder = (ContactMatchBuilder.ContactMatchHolder)paramView.getTag();
      break;
      label495:
      bool = false;
      break label213;
      label500:
      localContactMatchHolder.h.setVisibility(8);
      break label293;
      label513:
      localContactMatchHolder.a.setVisibility(0);
      localContactMatchHolder.a.setText(HardCodeUtil.a(2131689557));
      localContactMatchHolder.a.setTag(localObject);
      localContactMatchHolder.a.setOnClickListener(this);
      localContactMatchHolder.k.setVisibility(8);
      if (AppSetting.d)
      {
        localStringBuilder.append(",添加");
        localContactMatchHolder.a.setContentDescription(HardCodeUtil.a(2131702549));
      }
    }
  }
  
  protected void a()
  {
    ThreadManager.getSubThreadHandler().post(new ContactMatchBuilder.1(this));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof ContactMatchBuilder.ContactMatchHolder)))
      {
        Object localObject2 = ((ContactMatchMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a;
        if (localObject2 != null)
        {
          if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).i()) {}
          for (localObject1 = new ProfileActivity.AllInOne(((ContactMatch)localObject2).unifiedCode, 34);; localObject1 = new ProfileActivity.AllInOne(((ContactMatch)localObject2).unifiedCode, 29))
          {
            ((ProfileActivity.AllInOne)localObject1).h = ((ContactMatch)localObject2).name;
            ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1, 229);
            this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.h();
            break;
          }
          localObject1 = paramView.getTag();
          if ((localObject1 != null) && ((localObject1 instanceof ContactMatch))) {
            if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692257), 0).b(c());
            }
            else
            {
              localObject1 = (ContactMatch)localObject1;
              if (localObject1 != null)
              {
                localObject2 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
                int i = 3006;
                int j = 3;
                if (!((PhoneContactManagerImp)localObject2).i())
                {
                  i = 3075;
                  j = 1;
                }
                localObject1 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, ((ContactMatch)localObject1).unifiedCode, "ContactMatchBuilder", i, j, ((ContactMatch)localObject1).name, null, null, HardCodeUtil.a(2131702550), null);
                ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject1, 229);
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.h();
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder
 * JD-Core Version:    0.7.0.1
 */