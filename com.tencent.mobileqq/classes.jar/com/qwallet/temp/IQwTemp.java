package com.qwallet.temp;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQwTemp
  extends QRouteApi
{
  public abstract int AIOUtils$getLifeConst(String paramString);
  
  public abstract String ContactUtils$getBuddyName(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean);
  
  public abstract String ContactUtils$getDateNickName(AppInterface paramAppInterface, String paramString);
  
  public abstract int GifProcessor$convertVideoToGifForLocal(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract String ReadInJoyCameraCaptureConstants$KEY_READINJOY_CAPTURE_ABILITY_FLAG();
  
  public abstract Class<? extends Activity> getSendPhotoActivity();
  
  public abstract void mediaPlayer_doStop(boolean paramBoolean, AppRuntime paramAppRuntime);
  
  public abstract void mixSong(byte[] paramArrayOfByte, String paramString1, String paramString2, RecordParams.RecorderParam paramRecorderParam, String paramString3);
  
  public abstract IChatActivityFacadeTemp newIChatActivityFacadeTemp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.IQwTemp
 * JD-Core Version:    0.7.0.1
 */