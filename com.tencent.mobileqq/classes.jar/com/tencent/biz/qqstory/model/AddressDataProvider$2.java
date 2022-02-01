package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetLocationRequest;
import com.tencent.biz.qqstory.network.response.GetLocationResponse;
import com.tencent.biz.qqstory.support.logging.SLog;

class AddressDataProvider$2
  implements CmdTaskManger.CommandCallback<GetLocationRequest, GetLocationResponse>
{
  AddressDataProvider$2(AddressDataProvider paramAddressDataProvider) {}
  
  public void a(@NonNull GetLocationRequest paramGetLocationRequest, @Nullable GetLocationResponse paramGetLocationResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.b("AddressDataProvider", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramGetLocationResponse != null))
    {
      SLog.a("AddressDataProvider", "requestAddress onCmdRespond success : %s .", paramGetLocationResponse.toString());
      this.a.c = new AddressDataProvider.AddressInfo(paramGetLocationResponse.a, paramGetLocationResponse.b, paramGetLocationResponse.e, paramGetLocationResponse.f, paramGetLocationResponse.g, paramGetLocationRequest.f, paramGetLocationRequest.g);
      this.a.a("country", paramGetLocationResponse.a);
      this.a.a("province", paramGetLocationResponse.b);
      this.a.a("city", paramGetLocationResponse.e);
      this.a.a("district", paramGetLocationResponse.f);
      this.a.a("street", paramGetLocationResponse.g);
      this.a.a("longitude", paramGetLocationRequest.f);
      this.a.a("latitude", paramGetLocationRequest.g);
      this.a.a("time", System.currentTimeMillis());
      paramGetLocationRequest = this.a;
      paramGetLocationRequest.a(true, paramGetLocationRequest.c);
    }
    else
    {
      SLog.d("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramGetLocationRequest });
      this.a.a(false, null);
    }
    this.a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.AddressDataProvider.2
 * JD-Core Version:    0.7.0.1
 */