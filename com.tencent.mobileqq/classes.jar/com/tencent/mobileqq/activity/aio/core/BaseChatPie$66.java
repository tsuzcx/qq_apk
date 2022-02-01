package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import anvi;
import asmh;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import friendlist.GetOnlineInfoResp;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class BaseChatPie$66
  extends anvi
{
  BaseChatPie$66(BaseChatPie paramBaseChatPie) {}
  
  public void onAddFriend(String paramString)
  {
    BaseChatPie.access$2400(this.this$0, paramString);
  }
  
  public void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    BaseChatPie.access$3400(this.this$0, paramBoolean, paramString1, paramString2);
  }
  
  public void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.access$3200(this.this$0, paramBoolean, paramObject);
  }
  
  public void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (TextUtils.equals(paramString, this.this$0.sessionInfo.curFriendUin)) {
      this.this$0.updateOnlineStatus();
    }
  }
  
  public void onGetSigZanInfo(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.access$3300(this.this$0, paramObject);
  }
  
  public void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet)
  {
    if (asmh.a(this.this$0.app, this.this$0.mContext, this.this$0.sessionInfo))
    {
      asmh.a(this.this$0.app, this.this$0.mContext, this.this$0.sessionInfo, this.this$0.listView, paramHashSet);
      return;
    }
    AvatarLayout.a(this.this$0.app, this.this$0.listView, paramHashSet);
  }
  
  public void onGetStrangerInfo(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.access$3100(this.this$0, paramBoolean, paramObject);
  }
  
  public void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    BaseChatPie.access$2500(this.this$0, paramBoolean, paramLong, paramInt1, paramInt2);
  }
  
  public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    BaseChatPie.access$2700(this.this$0, paramBoolean, paramString1, paramString2);
  }
  
  public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    BaseChatPie.access$2600(this.this$0, paramBoolean);
  }
  
  public void onUpdateC2ChatStatus(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    BaseChatPie.access$3000(this.this$0, paramHashMap);
  }
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (asmh.a(this.this$0.app, this.this$0.mContext, this.this$0.sessionInfo))
    {
      asmh.a(this.this$0.app, this.this$0.mContext, this.this$0.sessionInfo, this.this$0.listView, Collections.singletonList(paramString));
      return;
    }
    AvatarLayout.a(this.this$0.app, this.this$0.listView, Collections.singletonList(paramString));
  }
  
  public void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.access$2800(this.this$0, paramBoolean, paramObject);
  }
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    BaseChatPie.access$2900(this.this$0, paramString, paramBoolean);
  }
  
  public void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.this$0.updateOnlineStatus();
  }
  
  public void onUpdateRecentList() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.66
 * JD-Core Version:    0.7.0.1
 */