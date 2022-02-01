package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TroopMemberApiService$15
  extends ReadInJoyObserver
{
  TroopMemberApiService$15(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", paramInt);
    localBundle.putString("processName", TroopMemberApiClient.d());
    this.a.a(138, localBundle);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    if (paramJSONObject.optBoolean("isDeliverStart", false)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("resultCode", paramInt);
    localBundle.putString("resultMsg", paramString1);
    localBundle.putString("publisherExtra", paramJSONObject.toString());
    try
    {
      localBundle.putInt("seq", Integer.parseInt(paramString2));
    }
    catch (NumberFormatException paramString1)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("seqCallback is : ");
      paramJSONObject.append(paramString2);
      QLog.e("TroopMemberApiService", 1, paramString1, new Object[] { paramJSONObject.toString() });
    }
    localBundle.putString("processName", TroopMemberApiClient.d());
    this.a.a(162, localBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("rowKey", paramString1);
    localBundle.putString("action", paramString2);
    localBundle.putInt("seq", paramInt);
    localBundle.putString("processName", TroopMemberApiClient.d());
    this.a.a(137, localBundle);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("rowKey", paramString1);
      localBundle.putString("commentId", paramString2);
      localBundle.putString("action", paramString3);
      localBundle.putInt("seq", paramInt1);
      localBundle.putInt("totalDeleteCount", paramInt2);
      localBundle.putString("processName", TroopMemberApiClient.d());
      this.a.a(136, localBundle);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("rowKey", paramString1);
      localBundle.putString("commentId", paramString2);
      localBundle.putString("commentContent", paramString3);
      localBundle.putInt("commentLevel", paramInt1);
      localBundle.putString("action", paramString4);
      localBundle.putString("parentCommentId", paramString5);
      localBundle.putInt("seq", paramInt2);
      localBundle.putString("processName", TroopMemberApiClient.d());
      this.a.a(134, localBundle);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("rowKey", paramString1);
      localBundle.putString("commentId", paramString2);
      localBundle.putString("likeStatus", paramString3);
      localBundle.putString("action", paramString4);
      localBundle.putInt("seq", paramInt);
      localBundle.putString("processName", TroopMemberApiClient.d());
      this.a.a(135, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.15
 * JD-Core Version:    0.7.0.1
 */