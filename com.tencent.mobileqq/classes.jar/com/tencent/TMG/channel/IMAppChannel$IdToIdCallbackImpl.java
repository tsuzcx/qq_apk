package com.tencent.TMG.channel;

import com.tencent.TIMUser;
import com.tencent.TIMValueCallBack;
import java.util.List;

public class IMAppChannel$IdToIdCallbackImpl
  implements TIMValueCallBack<List<TIMUser>>
{
  private AVAppChannel.IdToIdCallback mCallback;
  
  public IMAppChannel$IdToIdCallbackImpl(IMAppChannel paramIMAppChannel, AVAppChannel.IdToIdCallback paramIdToIdCallback)
  {
    this.mCallback = paramIdToIdCallback;
  }
  
  public void onError(int paramInt, String paramString)
  {
    if (this.mCallback != null)
    {
      this.mCallback.onError(paramInt, paramString);
      this.mCallback = null;
    }
  }
  
  public void onSuccess(List<TIMUser> paramList)
  {
    if (this.mCallback != null)
    {
      int j = paramList.size();
      String[] arrayOfString = new String[j];
      long[] arrayOfLong = new long[j];
      int i = 0;
      while (i < j)
      {
        TIMUser localTIMUser = (TIMUser)paramList.get(i);
        arrayOfString[i] = localTIMUser.getIdentifier();
        arrayOfLong[i] = localTIMUser.getTinyId();
        i += 1;
      }
      this.mCallback.onSuccess(arrayOfString, arrayOfLong);
      this.mCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.channel.IMAppChannel.IdToIdCallbackImpl
 * JD-Core Version:    0.7.0.1
 */