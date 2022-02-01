package com.tencent.biz.qqstory.model.lbs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.Address;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

class LbsManager$3
  implements CmdTaskManger.CommandCallback<CommonRequest<qqstory_service.ReqGetPOIList>, CommonResponse>
{
  LbsManager$3(LbsManager paramLbsManager, WeakReference paramWeakReference, LbsManager.POIListRequestSession paramPOIListRequestSession) {}
  
  public void a(@NonNull CommonRequest<qqstory_service.ReqGetPOIList> paramCommonRequest, @Nullable CommonResponse paramCommonResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramCommonResponse == null)
    {
      SLog.d("LbsManager", "response is null");
      paramCommonRequest = (LbsManager.POIListRequestCallback)this.a.get();
      if (paramCommonRequest != null) {
        ThreadManager.getUIHandler().post(new LbsManager.3.1(this, paramCommonRequest, paramErrorMessage));
      }
      return;
    }
    paramCommonRequest = new qqstory_service.RspGetPOIList();
    paramCommonResponse = paramCommonResponse.b;
    try
    {
      paramCommonRequest.mergeFrom(paramCommonResponse);
    }
    catch (InvalidProtocolBufferMicroException paramCommonResponse)
    {
      paramErrorMessage = new StringBuilder();
      paramErrorMessage.append("InvalidProtocolBufferMicroException: ");
      paramErrorMessage.append(paramCommonResponse.getMessage());
      SLog.e("LbsManager", paramErrorMessage.toString());
    }
    paramCommonResponse = new ArrayList();
    if (paramCommonRequest.result.error_code.get() == 0)
    {
      paramErrorMessage = paramCommonRequest.poi_list.get();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("poiListSize = ");
      ((StringBuilder)localObject).append(paramCommonRequest.poi_list.size());
      SLog.b("LbsManager", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("poiList isend = ");
      ((StringBuilder)localObject).append(paramCommonRequest.is_end.get());
      SLog.b("LbsManager", ((StringBuilder)localObject).toString());
      if (paramErrorMessage.size() > 0)
      {
        int i;
        if (paramCommonRequest.is_end.get() > 0) {
          i = 1;
        } else {
          i = 0;
        }
        this.b.b = (i ^ 0x1);
        localObject = paramCommonRequest.next_cookie.get().toStringUtf8();
        if (!this.b.f.contains(localObject))
        {
          i = 0;
          while (i < paramErrorMessage.size())
          {
            qqstory_struct.Address localAddress = (qqstory_struct.Address)paramErrorMessage.get(i);
            String str1 = localAddress.city.get().toStringUtf8();
            String str2 = localAddress.building.get().toStringUtf8();
            int j;
            if (localAddress.gps.has()) {
              j = localAddress.gps.lng.get();
            } else {
              j = 0;
            }
            String str3 = localAddress.street.get().toStringUtf8();
            int k;
            if (localAddress.gps.has()) {
              k = localAddress.gps.lat.get();
            } else {
              k = 0;
            }
            paramCommonResponse.add(new TroopBarPOI("", str1, str2, j, str3, k, localAddress.province.get().toString()));
            i += 1;
          }
          this.b.f.add(localObject);
          this.b.d = ((String)localObject);
        }
      }
    }
    paramErrorMessage = (LbsManager.POIListRequestCallback)this.a.get();
    if (paramErrorMessage != null)
    {
      ThreadManager.getUIHandler().post(new LbsManager.3.2(this, paramErrorMessage, paramCommonRequest, paramCommonResponse));
      return;
    }
    SLog.d("LbsManager", "POIListRequestCallback has been recycled.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.3
 * JD-Core Version:    0.7.0.1
 */