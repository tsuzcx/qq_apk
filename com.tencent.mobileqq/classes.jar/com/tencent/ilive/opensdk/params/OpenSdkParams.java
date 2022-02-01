package com.tencent.ilive.opensdk.params;

import android.graphics.Bitmap;
import android.view.View;

public class OpenSdkParams
{
  int authEncryptionType = 2;
  private Bitmap mCoverBmp;
  private String mCurrentRoles = "";
  private int mLiveType = 0;
  private View mRenderViewContainer;
  private long mRoomId;
  private byte[] mRoomSig;
  private long mSelfUid;
  private boolean mSwitchRoom = false;
  private long mUid;
  
  public static OpenSdkParams copy(OpenSdkParams paramOpenSdkParams)
  {
    return new OpenSdkParams.OpenSdkParamsBuilder().setUid(paramOpenSdkParams.getUin()).setSelfUid(paramOpenSdkParams.getSelfUin()).setRoomId(paramOpenSdkParams.getRoomId()).setRoomSig(paramOpenSdkParams.getRoomSig()).setLiveType(paramOpenSdkParams.getLiveType()).setCoverBitmap(paramOpenSdkParams.getCoverBmp()).setRenderContainer(paramOpenSdkParams.getRenderContainer()).setRoles(paramOpenSdkParams.getRoles()).setAuthEncryptionType(paramOpenSdkParams.getAuthEncryptionType()).build();
  }
  
  public void clear()
  {
    this.mCoverBmp = null;
    this.mRenderViewContainer = null;
  }
  
  public int getAuthEncryptionType()
  {
    return this.authEncryptionType;
  }
  
  public Bitmap getCoverBmp()
  {
    return this.mCoverBmp;
  }
  
  public int getLiveType()
  {
    return this.mLiveType;
  }
  
  public View getRenderContainer()
  {
    return this.mRenderViewContainer;
  }
  
  public String getRoles()
  {
    return this.mCurrentRoles;
  }
  
  public long getRoomId()
  {
    return this.mRoomId;
  }
  
  public byte[] getRoomSig()
  {
    return this.mRoomSig;
  }
  
  public long getSelfUin()
  {
    return this.mSelfUid;
  }
  
  public long getUin()
  {
    return this.mUid;
  }
  
  public boolean isSwitchRoom()
  {
    return this.mSwitchRoom;
  }
  
  public void setAuthEncryptionType(int paramInt)
  {
    this.authEncryptionType = paramInt;
  }
  
  public void setCoverBitmap(Bitmap paramBitmap)
  {
    this.mCoverBmp = paramBitmap;
  }
  
  public void setLiveType(int paramInt)
  {
    this.mLiveType = paramInt;
  }
  
  public void setRenderContainer(View paramView)
  {
    this.mRenderViewContainer = paramView;
  }
  
  public void setRoles(String paramString)
  {
    this.mCurrentRoles = paramString;
  }
  
  public void setRoomId(long paramLong)
  {
    this.mRoomId = paramLong;
  }
  
  public void setRoomSig(byte[] paramArrayOfByte)
  {
    this.mRoomSig = paramArrayOfByte;
  }
  
  public void setSelfUin(long paramLong)
  {
    this.mSelfUid = paramLong;
  }
  
  public void setSwitchRoom(boolean paramBoolean)
  {
    this.mSwitchRoom = paramBoolean;
  }
  
  public void setUin(long paramLong)
  {
    this.mUid = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("OpenSdkParams{mUid=");
    localStringBuilder.append(this.mUid);
    localStringBuilder.append(", mSelfUid=");
    localStringBuilder.append(this.mSelfUid);
    localStringBuilder.append(", mRoomId=");
    localStringBuilder.append(this.mRoomId);
    localStringBuilder.append(", mLiveType=");
    localStringBuilder.append(this.mLiveType);
    localStringBuilder.append(", mRenderViewContainer=");
    localStringBuilder.append(this.mRenderViewContainer);
    localStringBuilder.append(", mCoverBmp=");
    localStringBuilder.append(this.mCoverBmp);
    localStringBuilder.append(", mSwitchRoom=");
    localStringBuilder.append(this.mSwitchRoom);
    localStringBuilder.append(", mCurrentRoles='");
    localStringBuilder.append(this.mCurrentRoles);
    localStringBuilder.append('\'');
    localStringBuilder.append(", authEncryptionType=");
    localStringBuilder.append(this.authEncryptionType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.OpenSdkParams
 * JD-Core Version:    0.7.0.1
 */