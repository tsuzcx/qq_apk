package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.robotchat.RobotChatUtil;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;

public class MiniPieForC2C
  extends MiniPie
{
  private QidianManager a;
  
  public MiniPieForC2C(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
    if (paramQQAppInterface.isCreateManager(QQManagerFactory.QIDIAN_MANAGER)) {
      this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
    this.c = true;
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {}
    label176:
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView.getParent();
      if ((localObject1 instanceof ViewGroup)) {}
      for (localObject1 = (ViewGroup)localObject1;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label176;
        }
        if (RobotUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          int i = ((ViewGroup)localObject1).indexOfChild(this.jdField_a_of_type_AndroidWidgetTextView);
          localObject2 = RobotChatUtil.a(this.jdField_a_of_type_AndroidContentContext);
          if (localObject2 == null) {
            break;
          }
          ((View)localObject2).setId(2131377336);
          ((View)localObject2).setPadding(AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidWidgetTextView.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidWidgetTextView.getResources()), 0, 0);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(1, 2131379432);
          localLayoutParams.addRule(6, 2131379432);
          ((View)localObject2).setLayoutParams(localLayoutParams);
          ((ViewGroup)localObject1).addView((View)localObject2, i);
          return;
        }
        Object localObject2 = ((ViewGroup)localObject1).findViewById(2131377336);
        if (localObject2 == null) {
          break;
        }
        ((ViewGroup)localObject1).removeView((View)localObject2);
        return;
      }
    }
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected void f()
  {
    if (!this.d) {}
    label595:
    do
    {
      Object localObject;
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
                this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean = false;
                this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = false;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
                {
                  QIMUserManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                  TIMUserManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                }
                if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f)) {
                  break;
                }
                this.b.setTextColor(-1);
                this.b.setAlpha(0.8F);
                localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                if ((localObject != null) && ((ContactUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0) || (!TextUtils.isEmpty(((Friends)localObject).strTermDesc))))
                {
                  localObject = ContactUtils.b((Friends)localObject);
                  this.b.setCompoundDrawablePadding(AIOUtils.a(2.0F, BaseApplicationImpl.getContext().getResources()));
                  this.b.setCompoundDrawables(QIMUserManager.a().b(5), null, null, null);
                  this.b.setOnClickListener(null);
                  this.b.setText((CharSequence)localObject);
                  e(true);
                  return;
                }
              } while (this.b.getVisibility() != 0);
              e(false);
              return;
              if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)) {
                break;
              }
              this.b.setTextColor(-1);
              this.b.setAlpha(0.8F);
              localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              if ((localObject != null) && ((ContactUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0) || (!TextUtils.isEmpty(((Friends)localObject).strTermDesc))))
              {
                localObject = ContactUtils.b((Friends)localObject);
                this.b.setCompoundDrawablePadding(AIOUtils.a(2.0F, BaseApplicationImpl.getContext().getResources()));
                this.b.setCompoundDrawables(TIMUserManager.a().b(5), null, null, null);
                this.b.setText((CharSequence)localObject);
                e(true);
                return;
              }
            } while (this.b.getVisibility() != 0);
            e(false);
            return;
            this.b.setTextColor(-1);
            this.b.setAlpha(0.8F);
            this.b.setCompoundDrawables(null, null, null, null);
            this.b.setOnClickListener(null);
            System.currentTimeMillis();
          } while ((!this.c) || ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))));
          localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008);
        localObject = ((FriendsManager)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject == null) || ((ContactUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) == 0) && ((TextUtils.isEmpty(((Friends)localObject).strTermDesc)) || (!((Friends)localObject).strTermDesc.contains("TIM"))))) {
          break label595;
        }
        localObject = ContactUtils.b((Friends)localObject);
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        this.b.setText((CharSequence)localObject);
        e(true);
      } while (!AppSetting.d);
      this.b.setContentDescription((CharSequence)localObject);
      return;
      e(false);
      return;
    } while (this.b.getVisibility() != 0);
    e(false);
  }
  
  protected void g()
  {
    this.e = true;
    super.g();
    if (this.d)
    {
      f();
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
        ViewUtils.b(this.jdField_a_of_type_AndroidWidgetImageView, 0);
      }
    }
    A();
  }
  
  protected void u()
  {
    super.u();
  }
  
  protected void v()
  {
    super.v();
  }
  
  protected void y()
  {
    this.jdField_a_of_type_JavaLangString = "MiniPieForC2C";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieForC2C
 * JD-Core Version:    0.7.0.1
 */