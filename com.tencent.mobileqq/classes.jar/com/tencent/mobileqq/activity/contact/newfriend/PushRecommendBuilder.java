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
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.newfriend.MayKnowMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class PushRecommendBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager;
  
  public PushRecommendBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(158));
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)paramQQAppInterface.getManager(33));
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    PushRecommendBuilder.PushRecommendHolder localPushRecommendHolder;
    View localView;
    PushRecommend localPushRecommend;
    label231:
    label363:
    StringBuilder localStringBuilder;
    label407:
    label484:
    int i;
    label561:
    label605:
    int j;
    if ((paramView == null) || (!(paramView.getTag() instanceof PushRecommendBuilder.PushRecommendHolder)))
    {
      localPushRecommendHolder = new PushRecommendBuilder.PushRecommendHolder();
      localView = a(this.jdField_a_of_type_AndroidContentContext, 2130970593, localPushRecommendHolder);
      localPushRecommendHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366518));
      localPushRecommendHolder.h = ((TextView)localView.findViewById(2131362876));
      localPushRecommendHolder.i = ((TextView)localView.findViewById(2131369905));
      localPushRecommendHolder.l = ((TextView)localView.findViewById(2131371369));
      localPushRecommendHolder.j = ((TextView)localView.findViewById(2131369907));
      localPushRecommendHolder.k = ((TextView)localView.findViewById(2131368908));
      localPushRecommendHolder.a = ((Button)localView.findViewById(2131368907));
      localView.setTag(localPushRecommendHolder);
      localPushRecommendHolder.jdField_f_of_type_AndroidViewView.setTag(localPushRecommendHolder);
      localPushRecommendHolder.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, localView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage, localPushRecommendHolder, this);
      localPushRecommend = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
      if (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage.a()) {
        break label961;
      }
      localPushRecommendHolder.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838585);
      if (localPushRecommend.fromSource <= 20) {
        break label954;
      }
      paramView = "0X8007790";
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
      if (Utils.b(String.valueOf(localPushRecommend.uin))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
      }
      if ((localPushRecommend.sourceId == 3045) && (!localPushRecommend.isReported))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C2", "0X80085C2", 0, 0, String.valueOf(((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a.subSourceId), "", "", "");
        localPushRecommend.isReported = true;
      }
      b();
      localStringBuilder = new StringBuilder(256);
      if (!TextUtils.isEmpty(localPushRecommend.remark)) {
        break label984;
      }
      if (!TextUtils.isEmpty(localPushRecommend.nick)) {
        break label975;
      }
      paramView = localPushRecommend.uin;
      Object localObject = paramView;
      if (localPushRecommend.wzrySourceId > 0)
      {
        localObject = paramView;
        if (!TextUtils.isEmpty(localPushRecommend.wzryGameNick)) {
          localObject = KplRoleInfo.WZRYUIinfo.buildNickName(paramView, localPushRecommend.wzryGameNick);
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label993;
      }
      localPushRecommendHolder.h.setVisibility(0);
      localPushRecommendHolder.h.setText((CharSequence)localObject);
      if (AppSetting.b) {
        localStringBuilder.append((String)localObject);
      }
      if ((TextUtils.isEmpty(localPushRecommend.uin)) || (!Utils.b(localPushRecommend.uin))) {
        break label1006;
      }
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839745);
      paramView.setBounds(0, 0, AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localPushRecommendHolder.h.setCompoundDrawables(null, null, paramView, null);
      paramInt = 0;
      switch (localPushRecommend.gender)
      {
      default: 
        i = 0;
        localPushRecommendHolder.l.setBackgroundResource(2130843021);
        if (localPushRecommend.age > 0)
        {
          localPushRecommendHolder.l.setText(String.valueOf(localPushRecommend.age));
          j = 1;
          paramInt = j;
          if (AppSetting.b)
          {
            localStringBuilder.append(",").append(String.valueOf(localPushRecommend.age));
            paramInt = j;
          }
          label664:
          localPushRecommendHolder.l.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
          if (paramInt == 0) {
            break label1132;
          }
          localPushRecommendHolder.l.setVisibility(0);
          localPushRecommendHolder.l.setPadding(8, 4, 8, 4);
          label703:
          if (!TextUtils.isEmpty(localPushRecommend.recommendReason)) {
            break label1145;
          }
          localPushRecommendHolder.i.setVisibility(8);
          label724:
          if (!TextUtils.isEmpty(localPushRecommend.sourceReason)) {
            break label1193;
          }
          localPushRecommendHolder.j.setVisibility(8);
          label745:
          if (localPushRecommend.friendStatus != 0) {
            break label1335;
          }
          localPushRecommendHolder.a.setOnClickListener(this);
          localPushRecommendHolder.a.setVisibility(0);
          localPushRecommendHolder.a.setText("添加");
          localPushRecommendHolder.a.setTag(localPushRecommend);
          paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494231);
          if (paramView != null) {
            localPushRecommendHolder.a.setTextColor(paramView);
          }
          localPushRecommendHolder.a.setBackgroundResource(2130838516);
          localPushRecommendHolder.k.setVisibility(8);
          if (AppSetting.b)
          {
            localStringBuilder.append(",点击添加");
            localPushRecommendHolder.a.setContentDescription("添加");
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localPushRecommend.wzryVerifyStr)) {
        KplRoleInfo.saveKplVerifyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPushRecommend.wzryVerifyStr);
      }
      if (AppSetting.b) {
        localView.setContentDescription(localStringBuilder.toString());
      }
      localPushRecommendHolder.jdField_f_of_type_JavaLangString = localPushRecommend.uin;
      localPushRecommendHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(1, localPushRecommend.uin));
      return localView;
      localPushRecommendHolder = (PushRecommendBuilder.PushRecommendHolder)paramView.getTag();
      localView = paramView;
      break;
      label954:
      paramView = "0X8007793";
      break label231;
      label961:
      localPushRecommendHolder.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838581);
      break label363;
      label975:
      paramView = localPushRecommend.nick;
      break label407;
      label984:
      paramView = localPushRecommend.remark;
      break label407;
      label993:
      localPushRecommendHolder.h.setVisibility(8);
      break label484;
      label1006:
      localPushRecommendHolder.h.setCompoundDrawables(null, null, null, null);
      break label561;
      j = 1;
      int k = 2130843020;
      localPushRecommendHolder.l.setBackgroundResource(2130843021);
      i = k;
      paramInt = j;
      if (!AppSetting.b) {
        break label605;
      }
      localStringBuilder.append(",男");
      i = k;
      paramInt = j;
      break label605;
      j = 1;
      k = 2130843018;
      localPushRecommendHolder.l.setBackgroundResource(2130843019);
      i = k;
      paramInt = j;
      if (!AppSetting.b) {
        break label605;
      }
      localStringBuilder.append(",女");
      i = k;
      paramInt = j;
      break label605;
      localPushRecommendHolder.l.setText("");
      break label664;
      label1132:
      localPushRecommendHolder.l.setVisibility(8);
      break label703;
      label1145:
      localPushRecommendHolder.i.setVisibility(0);
      localPushRecommendHolder.i.setText(localPushRecommend.recommendReason);
      if (!AppSetting.b) {
        break label724;
      }
      localStringBuilder.append(",").append(localPushRecommend.recommendReason);
      break label724;
      label1193:
      localPushRecommendHolder.j.setText(localPushRecommend.sourceReason);
      if (localPushRecommend.fromSource == 1)
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838230);
        paramView.setBounds(0, 0, AIOUtils.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localPushRecommendHolder.j.setCompoundDrawables(paramView, null, null, null);
        localPushRecommendHolder.j.setCompoundDrawablePadding(AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
      for (;;)
      {
        if (!AppSetting.b) {
          break label1333;
        }
        localStringBuilder.append(",").append(localPushRecommend.sourceReason);
        break;
        localPushRecommendHolder.j.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      label1333:
      break label745;
      label1335:
      if (localPushRecommend.friendStatus == 1)
      {
        localPushRecommendHolder.a.setVisibility(8);
        localPushRecommendHolder.k.setVisibility(0);
        localPushRecommendHolder.k.setText(2131433031);
        if (AppSetting.b)
        {
          localStringBuilder.append(",等待验证");
          localPushRecommendHolder.k.setContentDescription("等待验证");
        }
      }
      else
      {
        localPushRecommendHolder.a.setVisibility(8);
        localPushRecommendHolder.k.setVisibility(0);
        localPushRecommendHolder.k.setText(2131433017);
        if (AppSetting.b)
        {
          localStringBuilder.append(",已添加");
          localPushRecommendHolder.k.setContentDescription("已添加");
        }
      }
    }
  }
  
  protected void a()
  {
    String str = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a.uin;
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f(str);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a, 2, this.jdField_a_of_type_Int, 1);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a, 2, this.jdField_a_of_type_Int, 1);
  }
  
  public void onClick(View paramView)
  {
    PushRecommend localPushRecommend;
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131366517: 
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof PushRecommendBuilder.PushRecommendHolder)));
        localPushRecommend = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
      } while (localPushRecommend == null);
      paramView = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((paramView == null) || (!paramView.b(localPushRecommend.uin))) {
        break;
      }
    }
    for (int i = 1;; i = 81)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PushRecommendBuilder", 2, "onClick rlSystemMsg， friendtype=" + i + ",gameSourceId=" + localPushRecommend.wzrySourceId);
      }
      Object localObject = new ProfileActivity.AllInOne(localPushRecommend.uin, i);
      if (TextUtils.isEmpty(localPushRecommend.remark)) {
        if (TextUtils.isEmpty(localPushRecommend.nick))
        {
          paramView = localPushRecommend.uin;
          if (!TextUtils.isEmpty(localPushRecommend.remark)) {
            ((ProfileActivity.AllInOne)localObject).l = localPushRecommend.remark;
          }
          if (!TextUtils.isEmpty(localPushRecommend.nick)) {
            ((ProfileActivity.AllInOne)localObject).l = localPushRecommend.nick;
          }
          ((ProfileActivity.AllInOne)localObject).h = 88;
          if ((localPushRecommend.wzrySourceId > 0) && (i != 1))
          {
            paramView = KplRoleInfo.WZRYUIinfo.createInfo(localPushRecommend.uin, paramView, localPushRecommend.wzryVerifyStr, localPushRecommend.sourceId, localPushRecommend.subSourceId);
            ((ProfileActivity.AllInOne)localObject).a.putSerializable("param_wzry_data", paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008434", "0X8008434", 0, 0, "", "", "", "");
          }
          ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject, 228);
          this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.f();
          this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localPushRecommend, 2, this.jdField_a_of_type_Int, 2);
          if (localPushRecommend.fromSource <= 20) {
            break label415;
          }
        }
      }
      label415:
      for (paramView = "0X8007791";; paramView = "0X8007794")
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
        return;
        paramView = localPushRecommend.nick;
        break;
        paramView = localPushRecommend.remark;
        break;
      }
      paramView = paramView.getTag();
      if ((paramView == null) || (!(paramView instanceof PushRecommend))) {
        break;
      }
      if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131432992), 0).b(b());
        return;
      }
      localPushRecommend = (PushRecommend)paramView;
      paramView = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      label561:
      int j;
      if ((!paramView.b(localPushRecommend.uin)) && (!paramView.c(localPushRecommend.uin))) {
        if (TextUtils.isEmpty(localPushRecommend.remark)) {
          if (TextUtils.isEmpty(localPushRecommend.nick))
          {
            paramView = localPushRecommend.uin;
            if (localPushRecommend.sourceId != 0) {
              break label860;
            }
            i = 3045;
            if (localPushRecommend.subSourceId != 0) {
              break label869;
            }
            j = 2;
            label571:
            if (TextUtils.isEmpty(localPushRecommend.wzryGameNick)) {
              break label922;
            }
            paramView = KplRoleInfo.WZRYUIinfo.buildNickName(paramView, localPushRecommend.wzryGameNick);
          }
        }
      }
      label922:
      for (;;)
      {
        localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localPushRecommend.uin, null, i, j, paramView, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131435209), null);
        if (localPushRecommend.wzrySourceId > 0)
        {
          ((Intent)localObject).putExtra("param_wzry_data", KplRoleInfo.WZRYUIinfo.createInfo(localPushRecommend.uin, paramView, localPushRecommend.wzryVerifyStr, localPushRecommend.sourceId, localPushRecommend.subSourceId));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008435", "0X8008435", 0, 0, "", "", "", "");
        }
        if (i == 3045) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(j), "", "", "");
        }
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 228);
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.f();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
          if (Utils.b(String.valueOf(localPushRecommend.uin))) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localPushRecommend, 2, this.jdField_a_of_type_Int, 3);
          return;
          paramView = localPushRecommend.nick;
          break;
          paramView = localPushRecommend.remark;
          break;
          label860:
          i = localPushRecommend.sourceId;
          break label561;
          label869:
          j = localPushRecommend.subSourceId;
          break label571;
          if (paramView.b(localPushRecommend.uin))
          {
            localPushRecommend.friendStatus = 2;
            this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.notifyDataSetChanged();
          }
          else
          {
            localPushRecommend.friendStatus = 1;
            this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.notifyDataSetChanged();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.PushRecommendBuilder
 * JD-Core Version:    0.7.0.1
 */