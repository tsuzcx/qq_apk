package com.tencent.mobileqq.activity;

import QQService.DiscussMemberInfo;
import QQService.InteRemarkInfo;
import QQService.RespGetDiscussInfo;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class JoinDiscussionActivity$MyDiscussionObserver
  extends DiscussionObserver
{
  private JoinDiscussionActivity$MyDiscussionObserver(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, RespGetDiscussInfo paramRespGetDiscussInfo)
  {
    if (paramBoolean)
    {
      this.a.stopTitleProgress();
      this.a.i = String.valueOf(paramRespGetDiscussInfo.DiscussUin);
      this.a.h = paramRespGetDiscussInfo.Name;
      this.a.j = paramRespGetDiscussInfo.Members;
      this.a.k = paramRespGetDiscussInfo.OwnerUin;
      this.a.m = (paramRespGetDiscussInfo.CreateTime * 1000L);
      HashMap localHashMap = new HashMap();
      if (this.a.j != null)
      {
        Object localObject2 = this.a.j.iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (DiscussMemberInfo)((Iterator)localObject2).next();
          if (((DiscussMemberInfo)localObject1).Uin == this.a.k) {
            this.a.l = ((DiscussMemberInfo)localObject1).StInteRemark.StrValue;
          }
          l = ((DiscussMemberInfo)localObject1).Uin;
          localObject3 = new DiscussionMemberInfo();
          ((DiscussionMemberInfo)localObject3).discussionUin = this.a.i;
          ((DiscussionMemberInfo)localObject3).memberUin = String.valueOf(l);
          ((DiscussionMemberInfo)localObject3).flag = ((DiscussMemberInfo)localObject1).Flag;
          if ((((DiscussMemberInfo)localObject1).StInteRemark != null) && (!TextUtils.isEmpty(((DiscussMemberInfo)localObject1).StInteRemark.StrValue)))
          {
            ((DiscussionMemberInfo)localObject3).inteRemark = ((DiscussMemberInfo)localObject1).StInteRemark.StrValue;
            ((DiscussionMemberInfo)localObject3).inteRemarkSource = ((DiscussMemberInfo)localObject1).StInteRemark.Source;
          }
          else if (TextUtils.isEmpty(((DiscussionMemberInfo)localObject3).inteRemark))
          {
            localObject1 = ((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(((DiscussionMemberInfo)localObject3).memberUin);
            if ((localObject1 != null) && (((Friends)localObject1).isFriend()))
            {
              ((DiscussionMemberInfo)localObject3).memberName = ((Friends)localObject1).name;
              if (TextUtils.isEmpty(((Friends)localObject1).remark)) {
                localObject1 = ((Friends)localObject1).name;
              } else {
                localObject1 = ((Friends)localObject1).remark;
              }
              ((DiscussionMemberInfo)localObject3).inteRemark = ((String)localObject1);
              ((DiscussionMemberInfo)localObject3).inteRemarkSource = 129L;
            }
            else
            {
              ((DiscussionMemberInfo)localObject3).inteRemarkSource = 0L;
            }
          }
          localHashMap.put(((DiscussionMemberInfo)localObject3).memberUin, localObject3);
        }
        localObject1 = new ArrayList();
        if (this.a.j != null)
        {
          l = Long.parseLong(this.a.app.getCurrentAccountUin());
          paramInt = 0;
          while (paramInt < this.a.j.size())
          {
            if (((DiscussMemberInfo)this.a.j.get(paramInt)).Uin != l) {
              ((ArrayList)localObject1).add(Long.valueOf(((DiscussMemberInfo)this.a.j.get(paramInt)).Uin));
            }
            paramInt += 1;
          }
        }
        this.a.n = Math.min(((ArrayList)localObject1).size(), 4);
        this.a.p.clear();
        this.a.o = "";
        paramInt = 0;
        while (paramInt < this.a.n)
        {
          localObject2 = String.valueOf(((ArrayList)localObject1).get(paramInt));
          if (FaceDrawable.getFaceDrawable(this.a.app, 1, (String)localObject2) != null)
          {
            this.a.p.add(localObject2);
            localObject2 = new StringBuilder();
            localObject3 = this.a;
            ((StringBuilder)localObject2).append(((JoinDiscussionActivity)localObject3).o);
            ((StringBuilder)localObject2).append(String.valueOf(((ArrayList)localObject1).get(paramInt)));
            ((StringBuilder)localObject2).append(";");
            ((JoinDiscussionActivity)localObject3).o = ((StringBuilder)localObject2).toString();
          }
          paramInt += 1;
        }
      }
      long l = paramRespGetDiscussInfo.DiscussFlag;
      Object localObject1 = this.a;
      ((JoinDiscussionActivity)localObject1).h = ContactUtils.a(((JoinDiscussionActivity)localObject1).app, this.a.i, String.valueOf(this.a.k), l | 0x20000000, paramRespGetDiscussInfo.Name, localHashMap);
      if (this.a.p.size() == this.a.n) {
        ThreadManager.post(new JoinDiscussionActivity.MyDiscussionObserver.1(this), 8, null, true);
      }
      JoinDiscussionActivity.a(this.a);
      if (TextUtils.isEmpty(this.a.l))
      {
        paramRespGetDiscussInfo = (FriendListHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.a.k);
        ((StringBuilder)localObject1).append("");
        paramRespGetDiscussInfo.getFriendInfo(((StringBuilder)localObject1).toString(), false);
      }
    }
    else
    {
      this.a.a(0, paramInt);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      ReportController.b(this.a.app, "CliOper", "", this.a.app.getCurrentAccountUin(), "discuss", "discuss_QR_join", 0, 0, "", "", "", "");
      this.a.stopTitleProgress();
      String str = String.valueOf(paramLong);
      if ((str != null) && (str.length() > 0))
      {
        if (this.a.j != null)
        {
          paramLong = Long.parseLong(this.a.app.getCurrentAccountUin());
          paramInt = 0;
          while (paramInt < this.a.j.size())
          {
            if (((DiscussMemberInfo)this.a.j.get(paramInt)).Uin == paramLong)
            {
              paramInt = 1;
              break label159;
            }
            paramInt += 1;
          }
        }
        paramInt = 0;
        label159:
        if (paramInt != 0) {
          QQToast.makeText(this.a, HardCodeUtil.a(2131903831), 0).show(this.a.getTitleBarHeight());
        }
        Intent localIntent = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
        localIntent.putExtra("uin", str);
        localIntent.putExtra("uintype", 3000);
        localIntent.putExtra("uinname", this.a.h);
        localIntent.putExtra("isBack2Root", true);
        localIntent.putExtra("isFromDiscussionFlyTicket", true);
        this.a.startActivity(localIntent);
        this.a.finish();
      }
    }
    else
    {
      this.a.a(1, paramInt);
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      JoinDiscussionActivity localJoinDiscussionActivity = this.a;
      localJoinDiscussionActivity.a = paramString;
      localJoinDiscussionActivity.g.c(this.a.a);
      return;
    }
    this.a.a(0, -161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity.MyDiscussionObserver
 * JD-Core Version:    0.7.0.1
 */