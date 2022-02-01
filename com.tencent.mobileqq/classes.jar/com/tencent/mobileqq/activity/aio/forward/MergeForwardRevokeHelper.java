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
  private static BaseActivity b;
  private static int c;
  public boolean a = false;
  private QQCustomDialog d;
  private long e = 0L;
  private MergeForwardRevokeHelper.RevokeMessageObserver f;
  private MergeForwardRevokeHelper.OnRevokeListener g;
  
  private boolean a(List<MessageRecord> paramList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("containCurMsg  mOriginUniSeq:");
      ((StringBuilder)localObject).append(this.e);
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
        if (((MessageRecord)localObject).uniseq == this.e) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void e(BaseActivity paramBaseActivity)
  {
    Object localObject = (ViewGroup)paramBaseActivity.getWindow().getDecorView();
    ImageView localImageView = new ImageView(paramBaseActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localImageView.setImageResource(2130846689);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    ((ViewGroup)localObject).addView(localImageView, localLayoutParams);
    localObject = this.d;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    this.d = DialogUtil.a(paramBaseActivity, 230).setMessage(HardCodeUtil.a(2131904441)).setPositiveButton(paramBaseActivity.getString(2131891511), new MergeForwardRevokeHelper.1(this, paramBaseActivity));
    this.d.show();
    paramBaseActivity = this.g;
    if (paramBaseActivity != null) {
      paramBaseActivity.a();
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    c += 1;
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "onCreate");
    }
    if ((paramBaseActivity.getIntent() != null) && (paramBaseActivity.getAppInterface() != null))
    {
      AppInterface localAppInterface = paramBaseActivity.getAppInterface();
      MergeForwardRevokeHelper.RevokeMessageObserver localRevokeMessageObserver = new MergeForwardRevokeHelper.RevokeMessageObserver(this, paramBaseActivity, null);
      this.f = localRevokeMessageObserver;
      localAppInterface.addObserver(localRevokeMessageObserver);
      this.e = paramBaseActivity.getIntent().getLongExtra("origin_merge_structing_msg_uniseq", -1L);
    }
  }
  
  public void b(BaseActivity paramBaseActivity)
  {
    b = paramBaseActivity;
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "onResume");
    }
    this.a = false;
  }
  
  public void c(BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MergeForwardRevokeHelper", 2, "onDestroy");
    }
    if (paramBaseActivity.getAppInterface() != null) {
      paramBaseActivity.getAppInterface().removeObserver(this.f);
    }
    paramBaseActivity = this.d;
    if ((paramBaseActivity != null) && (paramBaseActivity.isShowing())) {
      this.d.dismiss();
    }
    this.d = null;
    int i = c - 1;
    c = i;
    if (i <= 0) {
      b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.forward.MergeForwardRevokeHelper
 * JD-Core Version:    0.7.0.1
 */