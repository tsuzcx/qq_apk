package com.tencent.aladdin.config.network;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import com.tencent.aladdin.config.utils.Log;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;

class AladdinRequestHandler$1
  implements AladdinResponseHandler
{
  AladdinRequestHandler$1(AladdinRequestHandler paramAladdinRequestHandler) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void onReceive(@NonNull byte[] paramArrayOfByte, @NonNull Bundle paramBundle)
  {
    oidb_cmd0xbf8.RspBody localRspBody = new oidb_cmd0xbf8.RspBody();
    int j;
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      int k = localRspBody.rsp_type.get();
      int m = localRspBody.ret_code.get();
      Log.i("AladdinRequestHandler", "onReceive: retCode=" + m + ", rspType=" + k);
      if (k == 0)
      {
        paramArrayOfByte = AladdinRequestHandler.access$000(this.this$0, (oidb_cmd0xbf8.RspBodyType1)localRspBody.body_type_1.get());
        paramBundle.putLong("key_config_count", paramArrayOfByte.size());
        paramArrayOfByte = paramArrayOfByte.iterator();
        i = 0;
        if (paramArrayOfByte.hasNext())
        {
          if (AladdinRequestHandler.ConfigResult.access$100((AladdinRequestHandler.ConfigResult)paramArrayOfByte.next()) == 0) {
            break label218;
          }
          j = 1;
        }
        else
        {
          paramBundle.putLong("key_failed_count", i);
        }
      }
      else
      {
        for (;;)
        {
          paramBundle.putInt("key_rsp_type", k);
          paramBundle.putInt("key_ret_code", m);
          paramBundle.putLong("key_response_timestamp", System.currentTimeMillis());
          return;
          if (k == 1) {
            AladdinRequestHandler.access$200((oidb_cmd0xbf8.RspBodyType2)localRspBody.body_type_2.get());
          }
        }
      }
      int i = j + i;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      Log.e("AladdinRequestHandler", "onReceive: ", paramArrayOfByte);
      return;
    }
    for (;;)
    {
      break;
      label218:
      j = 0;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aladdin.config.network.AladdinRequestHandler.1
 * JD-Core Version:    0.7.0.1
 */