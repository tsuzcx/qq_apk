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
      this.a.d = String.valueOf(paramRespGetDiscussInfo.DiscussUin);
      this.a.c = paramRespGetDiscussInfo.Name;
      this.a.jdField_a_of_type_JavaUtilList = paramRespGetDiscussInfo.Members;
      this.a.jdField_a_of_type_Long = paramRespGetDiscussInfo.OwnerUin;
      this.a.jdField_b_of_type_Long = (paramRespGetDiscussInfo.CreateTime * 1000L);
      HashMap localHashMap = new HashMap();
      if (this.a.jdField_a_of_type_JavaUtilList != null)
      {
        Object localObject2 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (DiscussMemberInfo)((Iterator)localObject2).next();
          if (((DiscussMemberInfo)localObject1).Uin == this.a.jdField_a_of_type_Long) {
            this.a.e = ((DiscussMemberInfo)localObject1).StInteRemark.StrValue;
          }
          l = ((DiscussMemberInfo)localObject1).Uin;
          localObject3 = new DiscussionMemberInfo();
          ((DiscussionMemberInfo)localObject3).discussionUin = this.a.d;
          ((DiscussionMemberInfo)localObject3).memberUin = String.valueOf(l);
          ((DiscussionMemberInfo)localObject3).flag = ((DiscussMemberInfo)localObject1).Flag;
          if ((((DiscussMemberInfo)localObject1).StInteRemark != null) && (!TextUtils.isEmpty(((DiscussMemberInfo)localObject1).StInteRemark.StrValue)))
          {
            ((DiscussionMemberInfo)localObject3).inteRemark = ((DiscussMemberInfo)localObject1).StInteRemark.StrValue;
            ((DiscussionMemberInfo)localObject3).inteRemarkSource = ((DiscussMemberInfo)localObject1).StInteRemark.Source;
          }
          else if (TextUtils.isEmpty(((DiscussionMemberInfo)localObject3).inteRemark))
          {
            localObject1 = ((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((DiscussionMemberInfo)localObject3).memberUin);
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
        if (this.a.jdField_a_of_type_JavaUtilList != null)
        {
          l = Long.parseLong(this.a.app.getCurrentAccountUin());
          paramInt = 0;
          while (paramInt < this.a.jdField_a_of_type_JavaUtilList.size())
          {
            if (((DiscussMemberInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).Uin != l) {
              ((ArrayList)localObject1).add(Long.valueOf(((DiscussMemberInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).Uin));
            }
            paramInt += 1;
          }
        }
        this.a.jdField_b_of_type_Int = Math.min(((ArrayList)localObject1).size(), 4);
        this.a.jdField_a_of_type_JavaUtilArrayList.clear();
        this.a.f = "";
        paramInt = 0;
        while (paramInt < this.a.jdField_b_of_type_Int)
        {
          localObject2 = String.valueOf(((ArrayList)localObject1).get(paramInt));
          if (FaceDrawable.getFaceDrawable(this.a.app, 1, (String)localObject2) != null)
          {
            this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            localObject2 = new StringBuilder();
            localObject3 = this.a;
            ((StringBuilder)localObject2).append(((JoinDiscussionActivity)localObject3).f);
            ((StringBuilder)localObject2).append(String.valueOf(((ArrayList)localObject1).get(paramInt)));
            ((StringBuilder)localObject2).append(";");
            ((JoinDiscussionActivity)localObject3).f = ((StringBuilder)localObject2).toString();
          }
          paramInt += 1;
        }
      }
      long l = paramRespGetDiscussInfo.DiscussFlag;
      Object localObject1 = this.a;
      ((JoinDiscussionActivity)localObject1).c = ContactUtils.a(((JoinDiscussionActivity)localObject1).app, this.a.d, String.valueOf(this.a.jdField_a_of_type_Long), l | 0x20000000, paramRespGetDiscussInfo.Name, localHashMap);
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() == this.a.jdField_b_of_type_Int) {
        ThreadManager.post(new JoinDiscussionActivity.MyDiscussionObserver.1(this), 8, null, true);
      }
      JoinDiscussionActivity.a(this.a);
      if (TextUtils.isEmpty(this.a.e))
      {
        paramRespGetDiscussInfo = (FriendListHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.a.jdField_a_of_type_Long);
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
        if (this.a.jdField_a_of_type_JavaUtilList != null)
        {
          paramLong = Long.parseLong(this.a.app.getCurrentAccountUin());
          paramInt = 0;
          while (paramInt < this.a.jdField_a_of_type_JavaUtilList.size())
          {
            if (((DiscussMemberInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).Uin == paramLong)
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
          QQToast.a(this.a, HardCodeUtil.a(2131705951), 0).b(this.a.getTitleBarHeight());
        }
        Intent localIntent = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
        localIntent.putExtra("uin", str);
        localIntent.putExtra("uintype", 3000);
        localIntent.putExtra("uinname", this.a.c);
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
      localJoinDiscussionActivity.jdField_a_of_type_JavaLangString = paramString;
      localJoinDiscussionActivity.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.c(this.a.jdField_a_of_type_JavaLangString);
      return;
    }
    this.a.a(0, -161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity.MyDiscussionObserver
 * JD-Core Version:    0.7.0.1
 */