package com.tencent.mobileqq.activity.aio.forward;

import android.content.Intent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MergeForwardRevokeHelper
{
  private static int jdField_a_of_type_Int;
  private static BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private long jdField_a_of_type_Long = 0L;
  private MergeForwardRevokeHelper.OnRevokeListener jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper$OnRevokeListener;
  private MergeForwardRevokeHelper.RevokeMessageObserver jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper$RevokeMessageObserver;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public boolean a;
  
  public MergeForwardRevokeHelper()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a(List<MessageRecord> paramList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("containCurMsg  mOriginUniSeq:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      QLog.d("MergeForwardRevokeHelper", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (MessageRecord)paramList.next();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("containCurMsg  mr.uniseq:");
          localStringBuilder.append(((MessageRecord)localObject).uniseq);
          QLog.d("MergeForwardRevokeHelper", 2, localStringBuilder.toString());
        }
        if (((MessageRecord)localObject).uniseq == this.jdField_a_of_type_Long) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void d(BaseActivity paramBaseActivity)
  {
    Object localObject = (ViewGroup)paramBaseActivity.getWindow().getDecorView();
    ImageView localImageView = new ImageView(paramBaseActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localImageView.setImageResource(2130845247);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    ((ViewGroup)localObject).addView(localImageView, localLayoutParams);
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramBaseActivity, 230).setMessage(HardCodeUtil.a(2131706590)).setPositiveButton(paramBaseActivity.getString(2131693890), new MergeForwardRevokeHelper.1(this, paramBaseActivity));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    paramBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper$OnRevokeListener;
    if (paramBaseActivity != null) {
      paramBaseActivity.a();
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    jdField_a_of_type_Int += 1;
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "onCreate");
    }
    if ((paramBaseActivity.getIntent() != null) && (paramBaseActivity.getAppInterface() != null))
    {
      AppInterface localAppInterface = paramBaseActivity.getAppInterface();
      MergeForwardRevokeHelper.RevokeMessageObserver localRevokeMessageObserver = new MergeForwardRevokeHelper.RevokeMessageObserver(this, paramBaseActivity, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper$RevokeMessageObserver = localRevokeMessageObserver;
      localAppInterface.addObserver(localRevokeMessageObserver);
      this.jdField_a_of_type_Long = paramBaseActivity.getIntent().getLongExtra("origin_merge_structing_msg_uniseq", -1L);
    }
  }
  
  public void b(BaseActivity paramBaseActivity)
  {
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "onResume");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "onDestroy");
    }
    if (paramBaseActivity.getAppInterface() != null) {
      paramBaseActivity.getAppInterface().removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper$RevokeMessageObserver);
    }
    paramBaseActivity = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((paramBaseActivity != null) && (paramBaseActivity.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    int i = jdField_a_of_type_Int - 1;
    jdField_a_of_type_Int = i;
    if (i <= 0) {
      jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.forward.MergeForwardRevokeHelper
 * JD-Core Version:    0.7.0.1
 */