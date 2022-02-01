package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class DiscussionInfoCardActivity$11
  extends DiscussionObserver
{
  DiscussionInfoCardActivity$11(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionInfoCardActivity", 2, "onGetFlyTicket: " + paramBoolean);
    }
    if (!paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        paramString1 = HardCodeUtil.a(2131703379);
      }
      for (;;)
      {
        this.a.a(2130839715, paramString1);
        return;
        paramString1 = HardCodeUtil.a(2131703394);
        continue;
        paramString1 = HardCodeUtil.a(2131703390);
      }
    }
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences("qrcode", 0).edit();
    localEditor.putLong("discussionvalidtime" + DiscussionInfoCardActivity.a(this.a), paramLong1);
    localEditor.putString("discussion" + DiscussionInfoCardActivity.a(this.a), paramString2);
    localEditor.putString("discussionfullSig" + DiscussionInfoCardActivity.a(this.a), paramString1);
    localEditor.commit();
    this.a.jdField_a_of_type_Long = paramLong1;
    this.a.b = paramString2;
    this.a.c = paramString1;
    this.a.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if ((paramBoolean) && (paramLong == Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue()))
    {
      DiscussionInfoCardActivity.c(this.a);
      this.a.a(2, this.a.getString(2131689567));
    }
  }
  
  public void a(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionInfoCardActivity", 2, "onCollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    if ((paramBoolean) && (paramLong != null) && (String.valueOf(paramLong).equals(DiscussionInfoCardActivity.a(this.a))))
    {
      ReportController.b(this.a.app, "CliOper", "", "", "discuss", "discuss_common", 0, 0, "", "", "", "");
      if (!this.a.isFinishing())
      {
        paramLong = this.a.app.getApp().getSharedPreferences(this.a.app.getCurrentAccountUin(), 0);
        if (paramLong.getBoolean("multi_chat_set_common_use_key", true))
        {
          this.a.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.a, 230, this.a.getString(2131694375), this.a.getString(2131694374), 2131690800, 2131719599, new DiscussionInfoCardActivity.11.1(this), null);
          this.a.jdField_a_of_type_AndroidAppDialog.show();
          paramLong.edit().putBoolean("multi_chat_set_common_use_key", false).commit();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if ((paramBoolean) && (paramLong1 != null) && (String.valueOf(paramLong1).equals(DiscussionInfoCardActivity.a(this.a))))
    {
      DiscussionInfoCardActivity.c(this.a);
      return;
    }
    QQToast.a(this.a, 1, this.a.getString(2131691862), 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (ArrayList)paramObject;
    int i = paramObject.indexOf(DiscussionInfoCardActivity.a(this.a));
    if (i != -1)
    {
      paramObject = (Boolean)paramObject.get(i + 1);
      if ((paramBoolean) && (paramObject.booleanValue()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = DiscussionInfoCardActivity.a(this.a).a(DiscussionInfoCardActivity.a(this.a));
        DiscussionInfoCardActivity.c(this.a);
        this.a.a();
        DiscussionInfoCardActivity.d(this.a);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (DiscussionInfoCardActivity.a(this.a).equals(paramString))
    {
      if (!paramBoolean) {
        break label154;
      }
      paramString = DiscussionInfoCardActivity.a(this.a).a(paramString);
      if (paramString != null)
      {
        DiscussionInfoCardActivity.a(this.a, paramString.discussionName);
        DiscussionInfoCardActivity.a(this.a, DiscussionInfoCardActivity.b(this.a));
      }
      if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
      {
        DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131690855));
        DiscussionInfoCardActivity.a(this.a).d(2130839730);
        DiscussionInfoCardActivity.a(this.a).b(false);
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(17, 1500L);
      }
    }
    label154:
    do
    {
      return;
      DiscussionInfoCardActivity.a(this.a, DiscussionInfoCardActivity.b(this.a));
    } while ((DiscussionInfoCardActivity.a(this.a) == null) || (!DiscussionInfoCardActivity.a(this.a).isShowing()) || (this.a.isFinishing()));
    DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131690853));
    DiscussionInfoCardActivity.a(this.a).d(2130839730);
    DiscussionInfoCardActivity.a(this.a).b(false);
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(17, 1500L);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    String str = (String)paramArrayOfObject[0];
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    paramArrayOfObject = (String)paramArrayOfObject[2];
    if ((paramArrayOfObject == null) || (paramArrayOfObject.trim().equals(""))) {
      paramArrayOfObject = this.a.getString(2131693169);
    }
    for (;;)
    {
      if ((DiscussionInfoCardActivity.a(this.a).equals(str)) && (!this.a.isFinishing()))
      {
        if ((10001 == i) || (10002 == i)) {
          DialogUtil.a(this.a, 230, null, paramArrayOfObject, new DiscussionInfoCardActivity.11.2(this, str), null).show();
        }
      }
      else {
        return;
      }
      this.a.a(1, paramArrayOfObject);
      return;
    }
  }
  
  public void b(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionInfoCardActivity", 2, "onUncollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    if ((paramBoolean) && (paramLong != null) && (String.valueOf(paramLong).equals(DiscussionInfoCardActivity.a(this.a)))) {}
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    if (DiscussionInfoCardActivity.a(this.a).equals(paramString))
    {
      if (!paramBoolean) {
        break label112;
      }
      if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
      {
        DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131692169));
        DiscussionInfoCardActivity.a(this.a).d(2130839730);
        DiscussionInfoCardActivity.a(this.a).b(false);
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16, 1500L);
      }
    }
    label112:
    while ((DiscussionInfoCardActivity.a(this.a) == null) || (!DiscussionInfoCardActivity.a(this.a).isShowing()) || (this.a.isFinishing())) {
      return;
    }
    DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131692165));
    DiscussionInfoCardActivity.a(this.a).d(2130839715);
    DiscussionInfoCardActivity.a(this.a).b(false);
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(17, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.11
 * JD-Core Version:    0.7.0.1
 */