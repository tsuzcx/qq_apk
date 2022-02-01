package com.tencent.mobileqq.activity.contacts.topentry;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class CardViewController$1
  extends FriendListObserver
{
  CardViewController$1(CardViewController paramCardViewController) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    super.onCancelMayKnowRecommend(paramBoolean, paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete mayKnowData ");
      String str;
      if (paramBoolean) {
        str = "success";
      } else {
        str = "false";
      }
      localStringBuilder.append(str);
      localStringBuilder.append(", delete uin is ");
      localStringBuilder.append(paramString);
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    this.a.b();
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    super.onMayKnowEntryStateChanged(paramBoolean, paramBundle);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("do network checkUpdate, rsp ");
      if (paramBoolean) {
        paramBundle = "success";
      } else {
        paramBundle = "false";
      }
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(". msg: \"send network respond done\"");
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    if (!paramBoolean) {
      CardViewController.a(this.a, System.currentTimeMillis());
    } else {
      CardViewController.a(this.a);
    }
    CardViewController.a(this.a, true, paramBoolean);
  }
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recv mayKnowData push add ");
      String str;
      if (paramBoolean) {
        str = "success";
      } else {
        str = "false";
      }
      localStringBuilder.append(str);
      localStringBuilder.append(", push uin size is ");
      int i;
      if (paramList != null) {
        i = paramList.size();
      } else {
        i = 0;
      }
      localStringBuilder.append(i);
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      CardViewController.a(this.a, paramList.size());
    }
    this.a.b();
  }
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recv mayKnowData push del ");
      String str;
      if (paramBoolean) {
        str = "success";
      } else {
        str = "false";
      }
      localStringBuilder.append(str);
      localStringBuilder.append(", push uin size is ");
      int i;
      if (paramList != null) {
        i = paramList.size();
      } else {
        i = 0;
      }
      localStringBuilder.append(i);
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CardViewController.1
 * JD-Core Version:    0.7.0.1
 */