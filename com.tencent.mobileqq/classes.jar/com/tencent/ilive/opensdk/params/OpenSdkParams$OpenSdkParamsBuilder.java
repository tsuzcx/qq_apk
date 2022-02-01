package com.tencent.ilive.opensdk.params;

import android.graphics.Bitmap;
import android.view.View;

public class OpenSdkParams$OpenSdkParamsBuilder
{
  private OpenSdkParams openSdkParams = new OpenSdkParams();
  
  public OpenSdkParams build()
  {
    return this.openSdkParams;
  }
  
  public OpenSdkParamsBuilder setAuthEncryptionType(int paramInt)
  {
    this.openSdkParams.authEncryptionType = paramInt;
    return this;
  }
  
  public OpenSdkParamsBuilder setCoverBitmap(Bitmap paramBitmap)
  {
    OpenSdkParams.access$602(this.openSdkParams, paramBitmap);
    return this;
  }
  
  public OpenSdkParamsBuilder setLiveType(int paramInt)
  {
    OpenSdkParams.access$402(this.openSdkParams, paramInt);
    return this;
  }
  
  public OpenSdkParamsBuilder setRenderContainer(View paramView)
  {
    OpenSdkParams.access$502(this.openSdkParams, paramView);
    return this;
  }
  
  public OpenSdkParamsBuilder setRoles(String paramString)
  {
    OpenSdkParams.access$702(this.openSdkParams, paramString);
    return this;
  }
  
  public OpenSdkParamsBuilder setRoomId(long paramLong)
  {
    OpenSdkParams.access$202(this.openSdkParams, paramLong);
    return this;
  }
  
  public OpenSdkParamsBuilder setRoomSig(byte[] paramArrayOfByte)
  {
    OpenSdkParams.access$302(this.openSdkParams, paramArrayOfByte);
    return this;
  }
  
  public OpenSdkParamsBuilder setSelfUid(long paramLong)
  {
    OpenSdkParams.access$102(this.openSdkParams, paramLong);
    return this;
  }
  
  public OpenSdkParamsBuilder setSwitchRoom(Boolean paramBoolean)
  {
    OpenSdkParams.access$802(this.openSdkParams, paramBoolean.booleanValue());
    return this;
  }
  
  public OpenSdkParamsBuilder setUid(long paramLong)
  {
    OpenSdkParams.access$002(this.openSdkParams, paramLong);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.OpenSdkParams.OpenSdkParamsBuilder
 * JD-Core Version:    0.7.0.1
 */