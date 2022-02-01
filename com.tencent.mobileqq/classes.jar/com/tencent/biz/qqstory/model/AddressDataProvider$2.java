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
      this.a.jdField_a_of_type_JavaLangObject = new AddressDataProvider.AddressInfo(paramGetLocationResponse.a, paramGetLocationResponse.c, paramGetLocationResponse.d, paramGetLocationResponse.e, paramGetLocationResponse.f, paramGetLocationRequest.d, paramGetLocationRequest.e);
      this.a.a("country", paramGetLocationResponse.a);
      this.a.a("province", paramGetLocationResponse.c);
      this.a.a("city", paramGetLocationResponse.d);
      this.a.a("district", paramGetLocationResponse.e);
      this.a.a("street", paramGetLocationResponse.f);
      this.a.a("longitude", paramGetLocationRequest.d);
      this.a.a("latitude", paramGetLocationRequest.e);
      this.a.a("time", System.currentTimeMillis());
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      SLog.d("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramGetLocationRequest });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.AddressDataProvider.2
 * JD-Core Version:    0.7.0.1
 */