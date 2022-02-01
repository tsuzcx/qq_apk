package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qqcircle.requests.QCircleExposeTipsRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qcircle.api.global.QCircleTipsConfig;
import com.tencent.qcircle.cooperation.config.QCircleSpUtil;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleEnvHub.ExposeTipsRsp;
import qqcircle.QQCircleEnvHub.Tips;

public class QCircleTipsUtil
{
  public static QQCircleEnvHub.Tips a(int paramInt)
  {
    byte[] arrayOfByte = QCircleTipsConfig.getInstance().getTipConfig(paramInt);
    if (arrayOfByte != null)
    {
      QQCircleEnvHub.Tips localTips = new QQCircleEnvHub.Tips();
      try
      {
        localTips.mergeFrom(arrayOfByte);
        return localTips;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a()
  {
    QCircleSpUtil.a("key_sp_tip_push_feedback_STATUS", Boolean.valueOf(true));
  }
  
  public static void a(String paramString, QQCircleEnvHub.Tips paramTips)
  {
    if (paramTips == null)
    {
      QLog.d("QCircleTipsUtil", 1, "tips is null");
      return;
    }
    paramString = new QCircleExposeTipsRequest(paramString, paramTips.id.get());
    VSNetworkHelper.getInstance().sendRequest(paramString, new QCircleTipsUtil.1());
  }
  
  private static void b(QQCircleEnvHub.ExposeTipsRsp paramExposeTipsRsp)
  {
    if (paramExposeTipsRsp == null)
    {
      QLog.d("QCircleTipsUtil", 1, "exposeTipsRsp is null");
      return;
    }
    QCircleSpUtil.a("key_sp_tip_push_feedback_STATUS", Boolean.valueOf(false));
    QCircleTipsConfig.getInstance().updateTipsConfig(paramExposeTipsRsp.toByteArray());
  }
  
  public static boolean b()
  {
    boolean bool2 = ((Boolean)QCircleSpUtil.b("key_sp_tip_push_feedback_STATUS", Boolean.valueOf(true))).booleanValue();
    boolean bool1 = bool2;
    if (bool2)
    {
      QQCircleEnvHub.Tips localTips = a(1);
      bool1 = bool2;
      if (localTips != null)
      {
        bool1 = bool2;
        if (!localTips.canExpose.get())
        {
          QCircleSpUtil.a("key_sp_tip_push_feedback_STATUS", Boolean.valueOf(false));
          bool1 = false;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleTipsUtil
 * JD-Core Version:    0.7.0.1
 */