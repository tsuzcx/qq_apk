package com.tencent.av.ui;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.utils.InviteBaseData;
import com.tencent.av.utils.PstnUtils;
import com.tencent.biz.widgets.GridViewForScrollView;
import com.tencent.mobileqq.activity.C2CCallToGroupCall;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import jvq;

public class InviteStartAudioDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ScrollView jdField_a_of_type_AndroidWidgetScrollView;
  private GridViewForScrollView jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView;
  private C2CCallToGroupCall jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList;
  private jvq jdField_a_of_type_Jvq;
  private int jdField_b_of_type_Int;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  
  private Bitmap a(InviteBaseData paramInviteBaseData)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramInviteBaseData.jdField_a_of_type_Int == 0) || (paramInviteBaseData.jdField_a_of_type_Int == 1) || (paramInviteBaseData.jdField_a_of_type_Int == 2) || (paramInviteBaseData.jdField_a_of_type_Int == 1000)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramInviteBaseData.jdField_a_of_type_JavaLangString);
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = localObject2;
        } while (paramInviteBaseData.jdField_a_of_type_Int != 1006);
        localObject1 = localObject2;
      } while (TextUtils.isEmpty(paramInviteBaseData.c));
      localObject1 = localObject2;
    } while (!paramInviteBaseData.c.startsWith("+"));
    return this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(11, paramInviteBaseData.c);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366083));
    this.jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView = ((GridViewForScrollView)findViewById(2131366082));
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)findViewById(2131362557));
    this.jdField_a_of_type_Jvq = new jvq(this, null);
    this.jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView.setAdapter(this.jdField_a_of_type_Jvq);
    this.jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView.setOnItemClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  private void a(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams();
    float f = DeviceInfoUtil.a();
    if (QLog.isColorLevel()) {
      QLog.i("InviteStartAudioDialog", 2, "setLayoutHeight.desity:" + f + ", num:" + paramInt);
    }
    int i = (int)f * 84;
    int j = (int)f * 20;
    if (paramInt <= 3) {
      localLayoutParams.height = i;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetScrollView.setLayoutParams(localLayoutParams);
      return;
      if (paramInt <= 6) {
        localLayoutParams.height = (j + i * 2);
      } else {
        localLayoutParams.height = (j * 2 + i * 3);
      }
    }
  }
  
  private void a(InviteStartAudioDialog.ViewHolder paramViewHolder)
  {
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839128);
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramViewHolder.b.setText("");
    paramViewHolder.b.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131492879));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      InviteBaseData localInviteBaseData = (InviteBaseData)this.jdField_a_of_type_JavaUtilList.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("InviteStartAudioDialog", 2, "onClick data:" + localInviteBaseData + "callType:" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localInviteBaseData.jdField_a_of_type_Int, localInviteBaseData.jdField_a_of_type_JavaLangString, localInviteBaseData.jdField_b_of_type_JavaLangString, localInviteBaseData.c, true, null, true, true, null, "from_internal");
        dismiss();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F5", "0X80063F5", 1, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        PstnSessionInfo localPstnSessionInfo;
        if (localInviteBaseData.jdField_a_of_type_Int == 2016) {
          if ((localInviteBaseData.jdField_a_of_type_JavaLangString == null) || (localInviteBaseData.jdField_a_of_type_JavaLangString.length() == 0))
          {
            paramView = localInviteBaseData.c;
            RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
            localPstnSessionInfo = new PstnSessionInfo();
            localPstnSessionInfo.c = (localRespondQueryQQBindingStat.nationCode + localRespondQueryQQBindingStat.mobileNo);
            localPstnSessionInfo.jdField_b_of_type_JavaLangString = paramView;
            localPstnSessionInfo.d = localInviteBaseData.jdField_b_of_type_JavaLangString;
            if (TextUtils.isEmpty(localInviteBaseData.jdField_a_of_type_JavaLangString)) {
              break label472;
            }
            localPstnSessionInfo.jdField_a_of_type_JavaLangString = localInviteBaseData.jdField_a_of_type_JavaLangString;
            label297:
            localPstnSessionInfo.jdField_a_of_type_Int = localInviteBaseData.jdField_a_of_type_Int;
            if ((PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1)) || (!PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2))) {
              break label481;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall = new C2CCallToGroupCall();
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall.getActivity(), localPstnSessionInfo.c, localPstnSessionInfo.jdField_a_of_type_JavaLangString, localPstnSessionInfo.d, localPstnSessionInfo.jdField_a_of_type_Int, localPstnSessionInfo.jdField_b_of_type_JavaLangString, 3);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131558448);
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext(), false);
          }
        }
        for (;;)
        {
          dismiss();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F5", "0X80063F5", 2, 0, "", "", "", "");
          return;
          paramView = localInviteBaseData.jdField_a_of_type_JavaLangString;
          break;
          paramView = localInviteBaseData.c;
          break;
          label472:
          localPstnSessionInfo.jdField_a_of_type_JavaLangString = paramView;
          break label297;
          label481:
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localPstnSessionInfo, 5);
        }
      }
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localInviteBaseData.jdField_a_of_type_Int, localInviteBaseData.jdField_a_of_type_JavaLangString, localInviteBaseData.jdField_b_of_type_JavaLangString, localInviteBaseData.c, true, null, true, true, null, null, 3, true);
      dismiss();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("InviteStartAudioDialog", 2, "onClick group call, groupUin:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 3000, this.jdField_a_of_type_JavaLangString, true, true, true, null, this.jdField_b_of_type_JavaUtilArrayList, 2, 3);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 5, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F5", "0X80063F5", 4, 0, "", "", "", "");
    }
    for (;;)
    {
      dismiss();
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 3000, this.jdField_a_of_type_JavaLangString, true, true, true, null, this.jdField_b_of_type_JavaUtilArrayList, 3, 3);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 6, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F5", "0X80063F5", 3, 0, "", "", "", "");
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130969310);
    a();
    this.jdField_a_of_type_Jvq.a(this.jdField_a_of_type_JavaUtilList);
    a(this.jdField_a_of_type_Jvq.getCount());
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (InviteBaseData)paramAdapterView.getItemAtPosition(paramInt);
    if ((paramAdapterView != null) && (paramAdapterView.jdField_b_of_type_Int == 1))
    {
      PhoneContactSelectActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2131034134, 2131034135);
      dismiss();
      if (this.jdField_a_of_type_Int != 1) {
        break label136;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F4", "0X80063F4", 1, 0, "", "", "", "");
    }
    label136:
    do
    {
      while (this.jdField_b_of_type_Int == 1)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F4", "0X80063F4", 4, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_Int == 2) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F4", "0X80063F4", 2, 0, "", "", "", "");
        }
      }
    } while (this.jdField_b_of_type_Int != 2);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F4", "0X80063F4", 3, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.InviteStartAudioDialog
 * JD-Core Version:    0.7.0.1
 */