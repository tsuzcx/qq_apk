package com.tencent.mobileqq.app;

import MQQ.GetRoamToastRsp;
import QC.BubbleRecommendRsp;
import QC.FaceRsp;
import QC.FontRecommendRsp;
import QC.SetFontBubbleRsp;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class SVIPObserver
  implements BusinessObserver
{
  private static final String TAG = "SVIPObserver";
  
  public void onAuthHiBoom(boolean paramBoolean, Object paramObject) {}
  
  public void onBubbleChanged(int paramInt) {}
  
  public void onDefaultCardRsp(boolean paramBoolean, Object paramObject) {}
  
  public void onFontBubblePaySuccess(Bundle paramBundle) {}
  
  public void onFriendCloneAuth(boolean paramBoolean, Object paramObject) {}
  
  public void onGetBigTroopExpiredInfo(boolean paramBoolean, Object paramObject) {}
  
  public void onGetBubbleRecommend(boolean paramBoolean, BubbleRecommendRsp paramBubbleRecommendRsp) {}
  
  public void onGetColorNickData(boolean paramBoolean, Object paramObject) {}
  
  public void onGetFontRecommend(boolean paramBoolean, FontRecommendRsp paramFontRecommendRsp) {}
  
  public void onGetRoamToast(boolean paramBoolean, GetRoamToastRsp paramGetRoamToastRsp) {}
  
  public void onGetRoamType(String paramString, int paramInt) {}
  
  public void onSetFace(boolean paramBoolean, FaceRsp paramFaceRsp) {}
  
  public void onSetFontBubble(boolean paramBoolean, SetFontBubbleRsp paramSetFontBubbleRsp, int paramInt) {}
  
  public void onSetHiBoom(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      onUpdateContinue1(paramInt, paramBoolean, paramObject);
      return;
    case 105: 
      onGetColorNickData(paramBoolean, paramObject);
      return;
    case 104: 
      onFriendCloneAuth(paramBoolean, paramObject);
      return;
    case 103: 
      onSetHiBoom(paramBoolean, paramObject);
      return;
    case 102: 
      onAuthHiBoom(paramBoolean, paramObject);
      return;
    case 101: 
      if ((paramObject instanceof Integer))
      {
        onBubbleChanged(((Integer)paramObject).intValue());
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("SVIPObserver", 2, "NOTIFY_TYPE_SVIP_BUBBLE_CHANGE param error");
        return;
      }
      break;
    case 100: 
      onVipStatusChanged();
    }
  }
  
  public void onUpdateContinue1(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 114: 
      paramObject = (Object[])paramObject;
      onGetRoamType((String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    case 113: 
      onGetBigTroopExpiredInfo(paramBoolean, paramObject);
      return;
    case 112: 
      onSetFace(paramBoolean, (FaceRsp)paramObject);
      return;
    case 111: 
      onGetRoamToast(paramBoolean, (GetRoamToastRsp)paramObject);
      return;
    case 110: 
      onFontBubblePaySuccess((Bundle)paramObject);
      return;
    case 109: 
      paramObject = (Object[])paramObject;
      onSetFontBubble(paramBoolean, (SetFontBubbleRsp)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    case 108: 
      onGetBubbleRecommend(paramBoolean, (BubbleRecommendRsp)paramObject);
      return;
    case 107: 
      onGetFontRecommend(paramBoolean, (FontRecommendRsp)paramObject);
      return;
    }
    onDefaultCardRsp(paramBoolean, paramObject);
  }
  
  public void onVipStatusChanged() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SVIPObserver
 * JD-Core Version:    0.7.0.1
 */