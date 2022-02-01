package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.newfriend.msg.MayKnowMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class MayKnowRecommendBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  protected int a;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager;
  private MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  private int c;
  
  public MayKnowRecommendBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_Int = 0;
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager = ((NewFriendManager)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297494);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    MayKnowRecommendBuilder.MayKnowRecommendHolder localMayKnowRecommendHolder;
    MayKnowRecommend localMayKnowRecommend;
    label266:
    StringBuilder localStringBuilder;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof MayKnowRecommendBuilder.MayKnowRecommendHolder)))
    {
      localMayKnowRecommendHolder = new MayKnowRecommendBuilder.MayKnowRecommendHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561660, localMayKnowRecommendHolder);
      localMayKnowRecommendHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localMayKnowRecommendHolder.h = ((TextView)paramView.findViewById(2131372288));
      localMayKnowRecommendHolder.k = ((TextView)paramView.findViewById(2131377001));
      localMayKnowRecommendHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376990));
      localMayKnowRecommendHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131379944));
      localMayKnowRecommendHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      localMayKnowRecommendHolder.m = ((TextView)paramView.findViewById(2131371099));
      localMayKnowRecommendHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378673));
      b(localMayKnowRecommendHolder.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localMayKnowRecommendHolder);
      localMayKnowRecommendHolder.g.setTag(localMayKnowRecommendHolder);
      localMayKnowRecommendHolder.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage, localMayKnowRecommendHolder, this);
      localMayKnowRecommend = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage.a()) {
        break label633;
      }
      a(localMayKnowRecommendHolder.g, true);
      if (Utils.b(String.valueOf(localMayKnowRecommend.uin))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.b() == 23) {
        b();
      }
      localStringBuilder = new StringBuilder(256);
      bool = false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager != null) {
        bool = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a();
      }
      Object localObject = localMayKnowRecommend.getDisplayName(bool);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label645;
      }
      localMayKnowRecommendHolder.h.setVisibility(0);
      localMayKnowRecommendHolder.h.setText((CharSequence)localObject);
      if (AppSetting.d) {
        localStringBuilder.append((String)localObject);
      }
      label360:
      if ((TextUtils.isEmpty(localMayKnowRecommend.uin)) || (!Utils.b(localMayKnowRecommend.uin))) {
        break label658;
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841947);
      ((Drawable)localObject).setBounds(0, 0, AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localMayKnowRecommendHolder.h.setCompoundDrawables(null, null, (Drawable)localObject, null);
      label440:
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        break label673;
      }
      localMayKnowRecommendHolder.m.setVisibility(8);
      label461:
      localMayKnowRecommendHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
      if (localMayKnowRecommend.friendStatus != 0) {
        break label712;
      }
      localMayKnowRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localMayKnowRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localMayKnowRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131689557));
      localMayKnowRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localMayKnowRecommend);
      localMayKnowRecommendHolder.k.setVisibility(8);
      if (AppSetting.d)
      {
        localStringBuilder.append(",点击添加");
        localMayKnowRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131689557));
      }
    }
    for (;;)
    {
      if (AppSetting.d) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localMayKnowRecommendHolder.jdField_f_of_type_JavaLangString = localMayKnowRecommend.uin;
      localMayKnowRecommendHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(1, localMayKnowRecommend.uin));
      a(localMayKnowRecommendHolder.jdField_a_of_type_AndroidWidgetTextView, localMayKnowRecommend, bool);
      return paramView;
      localMayKnowRecommendHolder = (MayKnowRecommendBuilder.MayKnowRecommendHolder)paramView.getTag();
      break;
      label633:
      a(localMayKnowRecommendHolder.g, false);
      break label266;
      label645:
      localMayKnowRecommendHolder.h.setVisibility(8);
      break label360;
      label658:
      localMayKnowRecommendHolder.h.setCompoundDrawables(null, null, null, null);
      break label440;
      label673:
      localMayKnowRecommendHolder.m.setText(localMayKnowRecommend.recommendReason);
      if (!AppSetting.d) {
        break label461;
      }
      localStringBuilder.append(",").append(localMayKnowRecommend.recommendReason);
      break label461;
      label712:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        localMayKnowRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localMayKnowRecommendHolder.k.setVisibility(0);
        localMayKnowRecommendHolder.k.setText(2131718554);
        if (AppSetting.d)
        {
          localStringBuilder.append(",等待验证");
          localMayKnowRecommendHolder.k.setContentDescription(HardCodeUtil.a(2131706491));
        }
      }
      else
      {
        localMayKnowRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localMayKnowRecommendHolder.k.setVisibility(0);
        localMayKnowRecommendHolder.k.setText(2131690072);
        if (AppSetting.d)
        {
          localStringBuilder.append(",已添加");
          localMayKnowRecommendHolder.k.setContentDescription(HardCodeUtil.a(2131706493));
        }
      }
    }
  }
  
  public String a()
  {
    return ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a.recommendReason;
  }
  
  protected void a()
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692257), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      return;
    }
    String str = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a.uin;
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend(str);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(200L);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
    Object localObject = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a;
    if (localObject != null) {}
    for (localObject = ((MayKnowRecommend)localObject).msgLabel;; localObject = null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.b();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "frd_list_dlt", i, 0, ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a.recommendReason, this.jdField_a_of_type_Int, ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a.algBuffer, ContactReportUtils.a((List)localObject), 0, "3");
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(TextView paramTextView, MayKnowRecommend paramMayKnowRecommend, boolean paramBoolean)
  {
    if (paramMayKnowRecommend == null) {
      return;
    }
    String str = paramMayKnowRecommend.getDisplayName(paramBoolean);
    if ((!TextUtils.isEmpty(paramMayKnowRecommend.mobile_name)) && (!str.equals(paramMayKnowRecommend.mobile_name)))
    {
      paramTextView.setText("(" + paramMayKnowRecommend.mobile_name + ")");
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public byte[] a()
  {
    return ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a.algBuffer;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a.uin;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a, 23, this.c, 1);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a, 23, this.c, 1);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.b();
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131377174: 
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject1 = paramView.getTag();
        } while ((localObject1 == null) || (!(localObject1 instanceof MayKnowRecommendBuilder.MayKnowRecommendHolder)));
        localObject1 = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a;
      } while (localObject1 == null);
      localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject2 == null) || (!((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin))) {
        break;
      }
    }
    for (int i = 1;; i = 110)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowRecommendBuilder", 2, "onClick rlSystemMsg， friendtype=" + i + ", gameSourceId=" + ((MayKnowRecommend)localObject1).recommendReason);
      }
      localObject2 = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject1).uin, i);
      boolean bool = false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager != null) {
        bool = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a();
      }
      String str = ((MayKnowRecommend)localObject1).getRecommendName(bool);
      if (!TextUtils.isEmpty(str)) {
        ((ProfileActivity.AllInOne)localObject2).l = str;
      }
      if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((MayKnowRecommend)localObject1).nick;
      }
      str = ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel);
      ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 88;
      Bundle localBundle = new Bundle();
      localBundle.putString("recommend_entry_type", "3");
      localBundle.putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
      localBundle.putInt("recommend_pos", this.jdField_a_of_type_Int);
      localBundle.putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
      localBundle.putString("recommend_label", str);
      localBundle.putInt("tabID", j);
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject2, 228, localBundle);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.h();
      if ((j == 23) && (this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a((MayKnowRecommend)localObject1, 23, this.c, 2);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", j, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_Int, ((MayKnowRecommend)localObject1).algBuffer, str, 0, "3");
      break;
      localObject1 = paramView.getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof MayKnowRecommend))) {
        break;
      }
      if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692257), 0).b(c());
        break;
      }
      localObject1 = (MayKnowRecommend)localObject1;
      localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((!((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin)) && (!((FriendsManager)localObject2).d(((MayKnowRecommend)localObject1).uin)))
      {
        bool = false;
        if (this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager != null) {
          bool = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a();
        }
        localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
        i = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.b();
        localObject2 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, i, (String)localObject2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689557), null);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(i), "", "", "");
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject2, 228);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.h();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
        if (Utils.b(String.valueOf(((MayKnowRecommend)localObject1).uin))) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
        }
        if ((j == 23) && (this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager != null)) {
          this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a((MayKnowRecommend)localObject1, 23, this.c, 3);
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_add", j, 1, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_Int, ((MayKnowRecommend)localObject1).algBuffer, ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel), 0, "3");
        break;
        if (((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin))
        {
          ((MayKnowRecommend)localObject1).friendStatus = 2;
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.notifyDataSetChanged();
        }
        else
        {
          ((MayKnowRecommend)localObject1).friendStatus = 1;
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.notifyDataSetChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.MayKnowRecommendBuilder
 * JD-Core Version:    0.7.0.1
 */