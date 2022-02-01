package com.tencent.biz.qqcircle.fragments.chat;

import com.tencent.biz.qcircleshadow.local.util.QCircleHostProtoUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;

public class QCircleChatGiftManager
{
  private static final String TAG = "QCircleChatGiftManager";
  private static volatile QCircleChatGiftManager sInstance;
  private ConcurrentHashMap<String, QQCirclePrivateMsgShow.UserPMGiftInfo> mGiftInfoMap = new ConcurrentHashMap();
  
  public static QCircleChatGiftManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCircleChatGiftManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public byte[] getUserGiftInfo(String paramString)
  {
    paramString = (QQCirclePrivateMsgShow.UserPMGiftInfo)this.mGiftInfoMap.get(paramString);
    if (paramString != null) {
      return paramString.toByteArray();
    }
    return null;
  }
  
  public void saveGiftInfo(List<byte[]> paramList)
  {
    paramList = QCircleHostProtoUtil.b(paramList);
    QLog.d("QCircleChatGiftManager", 1, "updateGiftInfo");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCirclePrivateMsgShow.UserPMGiftInfo localUserPMGiftInfo = (QQCirclePrivateMsgShow.UserPMGiftInfo)paramList.next();
      if (localUserPMGiftInfo != null) {
        this.mGiftInfoMap.put(localUserPMGiftInfo.uid.get(), localUserPMGiftInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.chat.QCircleChatGiftManager
 * JD-Core Version:    0.7.0.1
 */