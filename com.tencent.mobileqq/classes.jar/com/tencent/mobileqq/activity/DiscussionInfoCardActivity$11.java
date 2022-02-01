package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
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
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetFlyTicket: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("DiscussionInfoCardActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          paramString1 = HardCodeUtil.a(2131901463);
        } else {
          paramString1 = HardCodeUtil.a(2131901474);
        }
      }
      else {
        paramString1 = HardCodeUtil.a(2131901478);
      }
      this.a.a(2130839791, paramString1);
      return;
    }
    Object localObject = this.a.getSharedPreferences("qrcode", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("discussionvalidtime");
    localStringBuilder.append(DiscussionInfoCardActivity.c(this.a));
    ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("discussion");
    localStringBuilder.append(DiscussionInfoCardActivity.c(this.a));
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString2);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("discussionfullSig");
    localStringBuilder.append(DiscussionInfoCardActivity.c(this.a));
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString1);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = this.a;
    ((DiscussionInfoCardActivity)localObject).n = paramLong1;
    ((DiscussionInfoCardActivity)localObject).o = paramString2;
    ((DiscussionInfoCardActivity)localObject).p = paramString1;
    ((DiscussionInfoCardActivity)localObject).q = true;
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if ((paramBoolean) && (paramLong == Long.valueOf(DiscussionInfoCardActivity.c(this.a)).longValue()))
    {
      DiscussionInfoCardActivity.s(this.a);
      paramArrayList = this.a;
      paramArrayList.a(2, paramArrayList.getString(2131886209));
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCollectDiscussion isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("DiscussionInfoCardActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean) && (paramLong != null) && (String.valueOf(paramLong).equals(DiscussionInfoCardActivity.c(this.a))))
    {
      ReportController.b(this.a.app, "CliOper", "", "", "discuss", "discuss_common", 0, 0, "", "", "", "");
      if (!this.a.isFinishing())
      {
        paramLong = this.a.app.getApp().getSharedPreferences(this.a.app.getCurrentAccountUin(), 0);
        if (paramLong.getBoolean("multi_chat_set_common_use_key", true))
        {
          localObject = this.a;
          ((DiscussionInfoCardActivity)localObject).j = DialogUtil.a((Context)localObject, 230, ((DiscussionInfoCardActivity)localObject).getString(2131892013), this.a.getString(2131892012), 2131887648, 2131916870, new DiscussionInfoCardActivity.11.1(this), null);
          this.a.j.show();
          paramLong.edit().putBoolean("multi_chat_set_common_use_key", false).commit();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if ((paramBoolean) && (paramLong1 != null) && (String.valueOf(paramLong1).equals(DiscussionInfoCardActivity.c(this.a))))
    {
      DiscussionInfoCardActivity.s(this.a);
      return;
    }
    paramLong1 = this.a;
    QQToast.makeText(paramLong1, 1, paramLong1.getString(2131888746), 0).show(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (ArrayList)paramObject;
    int i = paramObject.indexOf(DiscussionInfoCardActivity.c(this.a));
    if (i != -1)
    {
      paramObject = (Boolean)paramObject.get(i + 1);
      if ((paramBoolean) && (paramObject.booleanValue()))
      {
        paramObject = this.a;
        paramObject.h = DiscussionInfoCardActivity.d(paramObject).d(DiscussionInfoCardActivity.c(this.a));
        DiscussionInfoCardActivity.s(this.a);
        this.a.a();
        DiscussionInfoCardActivity.t(this.a);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (DiscussionInfoCardActivity.c(this.a).equals(paramString)) {
      if (paramBoolean)
      {
        paramString = DiscussionInfoCardActivity.d(this.a).d(paramString);
        if (paramString != null)
        {
          DiscussionInfoCardActivity.a(this.a, paramString.discussionName);
          paramString = this.a;
          DiscussionInfoCardActivity.a(paramString, DiscussionInfoCardActivity.k(paramString));
        }
        if ((DiscussionInfoCardActivity.i(this.a) != null) && (DiscussionInfoCardActivity.i(this.a).isShowing()) && (!this.a.isFinishing()))
        {
          DiscussionInfoCardActivity.i(this.a).a(this.a.getString(2131887705));
          DiscussionInfoCardActivity.i(this.a).d(2130839806);
          DiscussionInfoCardActivity.i(this.a).b(false);
          this.a.t.sendEmptyMessageDelayed(17, 1500L);
        }
      }
      else
      {
        paramString = this.a;
        DiscussionInfoCardActivity.a(paramString, DiscussionInfoCardActivity.k(paramString));
        if ((DiscussionInfoCardActivity.i(this.a) != null) && (DiscussionInfoCardActivity.i(this.a).isShowing()) && (!this.a.isFinishing()))
        {
          DiscussionInfoCardActivity.i(this.a).a(this.a.getString(2131887703));
          DiscussionInfoCardActivity.i(this.a).d(2130839806);
          DiscussionInfoCardActivity.i(this.a).b(false);
          this.a.t.sendEmptyMessageDelayed(17, 1500L);
        }
      }
    }
  }
  
  protected void a(Object[] paramArrayOfObject)
  {
    String str2 = (String)paramArrayOfObject[0];
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    String str1 = (String)paramArrayOfObject[2];
    if (str1 != null)
    {
      paramArrayOfObject = str1;
      if (!str1.trim().equals("")) {}
    }
    else
    {
      paramArrayOfObject = this.a.getString(2131890668);
    }
    if ((DiscussionInfoCardActivity.c(this.a).equals(str2)) && (!this.a.isFinishing()))
    {
      if ((10001 != i) && (10002 != i))
      {
        this.a.a(1, paramArrayOfObject);
        return;
      }
      DialogUtil.a(this.a, 230, null, paramArrayOfObject, new DiscussionInfoCardActivity.11.2(this, str2), null).show();
    }
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUncollectDiscussion isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" uin:");
      localStringBuilder.append(paramLong);
      QLog.d("DiscussionInfoCardActivity", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramLong != null)) {
      String.valueOf(paramLong).equals(DiscussionInfoCardActivity.c(this.a));
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (DiscussionInfoCardActivity.c(this.a).equals(paramString)) {
      if (paramBoolean)
      {
        if ((DiscussionInfoCardActivity.i(this.a) != null) && (DiscussionInfoCardActivity.i(this.a).isShowing()) && (!this.a.isFinishing()))
        {
          DiscussionInfoCardActivity.i(this.a).a(this.a.getString(2131889067));
          DiscussionInfoCardActivity.i(this.a).d(2130839806);
          DiscussionInfoCardActivity.i(this.a).b(false);
          this.a.t.sendEmptyMessageDelayed(16, 1500L);
        }
      }
      else if ((DiscussionInfoCardActivity.i(this.a) != null) && (DiscussionInfoCardActivity.i(this.a).isShowing()) && (!this.a.isFinishing()))
      {
        DiscussionInfoCardActivity.i(this.a).a(this.a.getString(2131889057));
        DiscussionInfoCardActivity.i(this.a).d(2130839791);
        DiscussionInfoCardActivity.i(this.a).b(false);
        this.a.t.sendEmptyMessageDelayed(17, 1500L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.11
 * JD-Core Version:    0.7.0.1
 */