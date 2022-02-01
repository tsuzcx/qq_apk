package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageSearchDialog;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.ChatHistoryMenuItemView;
import com.tencent.mobileqq.widget.ChatHistoryMenuItemView.OnCategoryClickListener;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;

public class ChatHistoryMenuFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, ChatHistoryMenuItemView.OnCategoryClickListener
{
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseMessageSearchDialog jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageSearchDialog;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  private void a()
  {
    if ((!QQTheme.e()) && (!QQTheme.f()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838739);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850682);
  }
  
  private void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    QLog.d("Q.history.ChatHistoryMenuFragment", 1, "initViews start");
    paramViewGroup = paramLayoutInflater.inflate(2131558948, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131378893));
    a();
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setFitsSystemWindows(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
    }
    paramViewGroup = (NavBarCommon)paramViewGroup.findViewById(2131376636);
    paramViewGroup.setLeftBackVisible(0);
    paramViewGroup.setTitle(getString(2131696106));
    paramViewGroup.getLeftBackIcon().setOnClickListener(this);
    paramLayoutInflater = paramLayoutInflater.inflate(2131562770, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    paramLayoutInflater.findViewById(2131363868).setVisibility(8);
    paramLayoutInflater.setOnClickListener(this);
    paramViewGroup = (EditText)paramLayoutInflater.findViewById(2131366333);
    paramViewGroup.setFocusableInTouchMode(false);
    paramViewGroup.setCursorVisible(false);
    paramViewGroup.setOnClickListener(this);
    paramViewGroup = new RelativeLayout.LayoutParams(-1, AIOUtils.b(60.0F, getResources()));
    paramViewGroup.addRule(3, 2131376636);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater, paramViewGroup);
    paramLayoutInflater = new ChatHistoryMenuItemView(getContext(), 3, getString(2131696107), this.jdField_a_of_type_ArrayOfInt);
    paramLayoutInflater.a(this);
    paramViewGroup = new RelativeLayout.LayoutParams(-1, -2);
    paramViewGroup.addRule(3, 2131377050);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater, paramViewGroup);
  }
  
  private void a(String paramString)
  {
    a(paramString, "");
  }
  
  private void a(String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    String str;
    if (this.jdField_a_of_type_Int == 3011) {
      str = "1";
    } else {
      str = "2";
    }
    ReportController.a(localAppRuntime, "dc00898", "", "", paramString1, paramString1, 0, 0, str, "", paramString2, "");
  }
  
  private int[] a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 3011) {
      return ChatHistoryC2CViewController.jdField_a_of_type_ArrayOfInt;
    }
    if (i == 3012) {
      return ChatHistoryTroopViewController.jdField_a_of_type_ArrayOfInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getItemNames error: invalid fromType ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.e("Q.history.ChatHistoryMenuFragment", 1, localStringBuilder.toString());
    return new int[0];
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageSearchDialog == null)
    {
      Object localObject = (MessageRoamManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      int i = this.jdField_a_of_type_Int;
      if (i == 3011)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageSearchDialog = new C2CMessageSearchDialog(getActivity(), (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((MessageRoamManager)localObject).l());
      }
      else if (i == 3012)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageSearchDialog = new TroopAllMessageSearchDialog(getActivity(), (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((MessageRoamManager)localObject).l());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showSearchDialog error: invalid fromType ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.e("Q.history.ChatHistoryMenuFragment", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageSearchDialog.isShowing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageSearchDialog.show();
    a("0X800BBF6");
  }
  
  private void c()
  {
    BaseMessageSearchDialog localBaseMessageSearchDialog = this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageSearchDialog;
    if ((localBaseMessageSearchDialog != null) && (localBaseMessageSearchDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageSearchDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageSearchDialog = null;
    }
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent(getActivity(), ChatHistoryActivity.class);
    localIntent.putExtra("FromType", this.jdField_a_of_type_Int);
    localIntent.putExtra("SissionUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("TargetTabPos", paramInt);
    getActivity().startActivity(localIntent);
    a("0X800BBF7", getResources().getString(this.jdField_a_of_type_ArrayOfInt[paramInt]));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131366333) {
      if (i != 2131369202)
      {
        if (i != 2131377050) {
          break label50;
        }
      }
      else
      {
        getActivity().finish();
        QLog.d("Q.history.ChatHistoryMenuFragment", 1, "user clicked left back btn, do finish");
        break label50;
      }
    }
    b();
    label50:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
    this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    this.jdField_a_of_type_AndroidContentIntent = getActivity().getIntent();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("FromType", 3011);
    this.jdField_a_of_type_ArrayOfInt = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = ChatTextSizeSettingActivity.a(getActivity());
    a(paramLayoutInflater, paramViewGroup);
    a("0X800BBF5");
    paramLayoutInflater = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    c();
    super.onDetach();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryMenuFragment
 * JD-Core Version:    0.7.0.1
 */