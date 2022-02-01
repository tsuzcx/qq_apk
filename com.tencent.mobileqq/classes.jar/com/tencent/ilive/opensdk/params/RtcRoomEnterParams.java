package com.tencent.ilive.opensdk.params;

import com.tencent.ilive.opensdk.callbacks.RtcCoreEventCallback;

public class RtcRoomEnterParams
  extends BaseRoomParams
{
  public String appVersion = null;
  public long explicitID = 0L;
  private RtcCoreEventCallback mAVCoreEventCallback;
  private byte[] mFreeFlowSig;
  private boolean mIsFreeFlow = false;
  private boolean mIsSwitchRoom = false;
  private int mRoomType = -1;
  private long mSelfUin = 0L;
  private long mSubRoomId = 0L;
  private long mUin = 0L;
  private String mUrl1;
  private String mUrl2;
  private String mUrl3;
  private String mUrl4;
  private OpenSdkParams openSdkParams;
  public String role = null;
  
  public RtcRoomEnterParams(int paramInt1, int paramInt2)
  {
    super(paramInt1);
    this.mRoomType = paramInt2;
  }
  
  public void clear()
  {
    this.mAVCoreEventCallback = null;
    if (this.openSdkParams != null)
    {
      this.openSdkParams.clear();
      this.openSdkParams = null;
    }
  }
  
  public RtcCoreEventCallback getAVCoreEventCallback()
  {
    return this.mAVCoreEventCallback;
  }
  
  public long getAnchorUin()
  {
    return this.mUin;
  }
  
  public byte[] getFreeFlowSig()
  {
    return this.mFreeFlowSig;
  }
  
  public OpenSdkParams getOpenSdkParams()
  {
    return this.openSdkParams;
  }
  
  public int getRoomType()
  {
    return this.mRoomType;
  }
  
  public long getSelfUin()
  {
    return this.mSelfUin;
  }
  
  public long getSubRoomId()
  {
    return this.mSubRoomId;
  }
  
  public String getUrl1()
  {
    return this.mUrl1;
  }
  
  public String getUrl2()
  {
    return this.mUrl2;
  }
  
  public String getUrl3()
  {
    return this.mUrl3;
  }
  
  public String getUrl4()
  {
    return this.mUrl4;
  }
  
  public boolean isIsFreeFlow()
  {
    return this.mIsFreeFlow;
  }
  
  public boolean isIsSwitchRoom()
  {
    return this.mIsSwitchRoom;
  }
  
  public BaseRoomParams mUrl1(String paramString)
  {
    this.mUrl1 = paramString;
    return this;
  }
  
  public BaseRoomParams mUrl2(String paramString)
  {
    this.mUrl2 = paramString;
    return this;
  }
  
  public BaseRoomParams mUrl3(String paramString)
  {
    this.mUrl3 = paramString;
    return this;
  }
  
  public BaseRoomParams mUrl4(String paramString)
  {
    this.mUrl4 = paramString;
    return this;
  }
  
  public RtcRoomEnterParams setAVCoreEventCallback(RtcCoreEventCallback paramRtcCoreEventCallback)
  {
    this.mAVCoreEventCallback = paramRtcCoreEventCallback;
    return this;
  }
  
  public BaseRoomParams setFreeFlowSig(byte[] paramArrayOfByte)
  {
    this.mFreeFlowSig = paramArrayOfByte;
    return this;
  }
  
  public BaseRoomParams setIsFreeFlow(boolean paramBoolean)
  {
    this.mIsFreeFlow = paramBoolean;
    return this;
  }
  
  public BaseRoomParams setIsSwitchRoom(boolean paramBoolean)
  {
    this.mIsSwitchRoom = paramBoolean;
    return this;
  }
  
  public RtcRoomEnterParams setOpenSdkParams(OpenSdkParams paramOpenSdkParams)
  {
    this.openSdkParams = paramOpenSdkParams;
    return this;
  }
  
  public BaseRoomParams setRoomType(int paramInt)
  {
    this.mRoomType = paramInt;
    return this;
  }
  
  public BaseRoomParams setSelfUin(long paramLong)
  {
    this.mSelfUin = paramLong;
    return this;
  }
  
  public BaseRoomParams setSubRoomId(long paramLong)
  {
    this.mSubRoomId = paramLong;
    return this;
  }
  
  public BaseRoomParams setUin(long paramLong)
  {
    this.mUin = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.RtcRoomEnterParams
 * JD-Core Version:    0.7.0.1
 */