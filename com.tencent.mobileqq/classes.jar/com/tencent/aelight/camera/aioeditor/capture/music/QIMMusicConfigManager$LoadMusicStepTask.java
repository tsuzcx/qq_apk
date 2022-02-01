package com.tencent.aelight.camera.aioeditor.capture.music;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class QIMMusicConfigManager$LoadMusicStepTask
  implements INetEngineListener, Runnable
{
  final QIMMusicConfigManager jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager;
  final AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  final IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  final String b;
  final String c;
  
  QIMMusicConfigManager$LoadMusicStepTask(QIMMusicConfigManager paramQIMMusicConfigManager)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager = paramQIMMusicConfigManager;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQIMMusicConfigManager.a();
    this.b = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    this.c = paramQIMMusicConfigManager.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = paramQIMMusicConfigManager.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  }
  
  String a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OpitrtqeGzopIlwxs");
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("2000000228");
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("TCOHANTCNlddnsTY");
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("uZliVvhTJzkDPlHX");
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    String str = MD5.a((String)localObject).toLowerCase();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate the sign string, pre=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", md5=");
      localStringBuilder.append(str);
      QLog.d("QIMMusicConfigManager", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  String a(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (!paramMap.isEmpty())
    {
      int i = 1;
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        if (i != 0)
        {
          localStringBuilder.append("?");
          i = 0;
        }
        else
        {
          localStringBuilder.append("&");
        }
        localStringBuilder.append((String)paramMap.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)paramMap.getValue());
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("genQQMusicReqUrl url");
      paramString.append(localStringBuilder.toString());
      QLog.d("QIMMusicConfigManager", 2, paramString.toString());
    }
    return localStringBuilder.toString();
  }
  
  Map<String, String> a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_type", String.valueOf(1));
    localHashMap.put("uin", paramString1);
    localHashMap.put("ticket_type", "skey");
    localHashMap.put("auth", paramString2);
    return localHashMap;
  }
  
  void a()
  {
    ThreadManager.executeOnSubThread(this);
  }
  
  public void onResp(NetResp paramNetResp) {}
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager.LoadMusicStepTask
 * JD-Core Version:    0.7.0.1
 */