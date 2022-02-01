package com.tencent.biz.qqstory.network.handler;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspIconPostfix;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

public class GetUserIconHandler$GetUserIconListResponse
  extends LegoResponseBase
{
  qqstory_service.RspIconPostfix a;
  
  public GetUserIconHandler$GetUserIconListResponse() {}
  
  public GetUserIconHandler$GetUserIconListResponse(qqstory_service.RspIconPostfix paramRspIconPostfix)
  {
    super(paramRspIconPostfix.result);
    this.a = paramRspIconPostfix;
  }
  
  public void a()
  {
    if ((this.a.icon_info.has()) && (this.a.icon_info.size() > 0)) {
      Bosses.get().postJob(new GetUserIconHandler.GetUserIconListResponse.1(this, "GetUserIconHandler"));
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("GetUserIconListResponse onNetError errorCode ");
      paramBundle.append(paramInt);
      QLog.e("GetUserIconHandler", 2, paramBundle.toString());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GetUserIconListResponse errorCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" errorMsg:");
      localStringBuilder.append(paramString);
      QLog.e("GetUserIconHandler", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserIconHandler.GetUserIconListResponse
 * JD-Core Version:    0.7.0.1
 */