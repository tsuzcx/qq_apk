package com.tencent.mobileqq.activity.aio.tips;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studyroom.StudyRoomManager;
import com.tencent.mobileqq.studyroom.api.IStudyRoomReporter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class StudyRoomTipsBar
  implements View.OnClickListener, TipsBarTask
{
  View a;
  private QQAppInterface b;
  private BaseActivity c;
  private String d;
  private TextView e;
  
  public StudyRoomTipsBar(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.b = paramQQAppInterface;
    this.c = paramBaseActivity;
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.a == null)
    {
      this.a = LayoutInflater.from(this.c).inflate(2131627286, null);
      this.e = ((TextView)this.a.findViewById(2131446496));
      this.a.setOnClickListener(this);
    }
    d();
    return this.a;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public int b()
  {
    return 28;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public void d()
  {
    int i = ((StudyRoomManager)this.b.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).b(this.d);
    Object localObject;
    if (i > 0)
    {
      localObject = this.e;
      Resources localResources = this.c.getResources();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      ((TextView)localObject).setText(localResources.getString(2131916830, new Object[] { localStringBuilder.toString() }));
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update. member count :");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" with troopUin:");
      ((StringBuilder)localObject).append(this.d);
      QLog.i("StudyRoomTipsBar", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.c))
    {
      QQToast.makeText(this.c, 2131894999, 0).show(this.c.getTitleBarHeight());
    }
    else
    {
      Object localObject = new HashMap();
      ((HashMap)localObject).put("groupId", this.d);
      ((StudyRoomManager)this.b.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.c, "enter", (HashMap)localObject);
      int i = ((StudyRoomManager)this.b.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).b(this.d);
      localObject = new Bundle();
      ((Bundle)localObject).putString("action", "click");
      ((Bundle)localObject).putString("page", "group_page");
      ((Bundle)localObject).putString("module", "banner");
      ((Bundle)localObject).putString("entry_type", "1");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      ((Bundle)localObject).putString("study_number", localStringBuilder.toString());
      ((IStudyRoomReporter)QRoute.api(IStudyRoomReporter.class)).reportWithBundle((Bundle)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.StudyRoomTipsBar
 * JD-Core Version:    0.7.0.1
 */