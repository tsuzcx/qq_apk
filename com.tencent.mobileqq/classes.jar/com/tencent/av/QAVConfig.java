package com.tencent.av;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.opengl.effects.EffectBeautyTools;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public class QAVConfig
{
  private static int a(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("task_id");
      return i;
    }
    catch (Exception paramString)
    {
      label16:
      break label16;
    }
    return 0;
  }
  
  public static String a(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("QAVConfig_");
    ((StringBuilder)localObject1).append(paramInt2);
    String str = ((StringBuilder)localObject1).toString();
    if (paramConfig.msg_content_list != null) {
      paramInt2 = paramConfig.msg_content_list.size();
    } else {
      paramInt2 = -1;
    }
    int i = paramConfig.version.get();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handleCompressConfig, serverVersion[");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append("], localVersion[");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("], size[");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append("]");
    QLog.w(str, 1, ((StringBuilder)localObject1).toString());
    if (i == paramInt1) {
      return null;
    }
    if (paramInt2 <= 0) {
      return "";
    }
    localObject1 = null;
    paramInt1 = 0;
    CharSequence localCharSequence;
    while (paramInt1 < paramInt2)
    {
      ConfigurationService.Content localContent = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramInt1);
      if (localContent != null)
      {
        int j = localContent.task_id.get();
        Object localObject2 = localContent.content.get().toByteArray();
        localObject1 = localObject2;
        if (localContent.compress.get() == 1)
        {
          localObject2 = ArConfigUtils.a((byte[])localObject2);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            if (QLog.isDevelopLevel())
            {
              QLog.w(str, 1, "handleCompressConfig, 解压失败");
              localObject1 = localObject2;
            }
          }
        }
        if (localObject1 != null) {
          try
          {
            localObject1 = new String((byte[])localObject1, "utf-8");
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            if (QLog.isDevelopLevel()) {
              QLog.w(str, 1, "handleCompressConfig, 编码失败", localUnsupportedEncodingException);
            }
          }
        } else {
          localCharSequence = null;
        }
        if ((paramInt2 > 1) && (!TextUtils.isEmpty(localCharSequence))) {
          i = a(localCharSequence);
        } else {
          i = 0;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleCompressConfig, task_id[");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("], jsonContent[");
        boolean bool;
        if (localCharSequence != null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append("]");
        QLog.w(str, 1, ((StringBuilder)localObject2).toString());
        if (i == j) {
          return localCharSequence;
        }
      }
      paramInt1 += 1;
    }
    return localCharSequence;
  }
  
  public static void a(int paramInt, String paramString, ConfigurationService.Config paramConfig)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QAVConfig_");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      b(paramInt, paramString, paramConfig);
      return;
    }
    catch (Exception paramString)
    {
      label33:
      break label33;
    }
    if (QLog.isDevelopLevel()) {
      QLog.w((String)localObject, 1, "receiveAllConfigs, Exception");
    }
  }
  
  public static void a(int paramInt, String paramString, ConfigurationService.ConfigSeq paramConfigSeq)
  {
    paramString = new StringBuilder();
    paramString.append("QAVConfig_");
    paramString.append(paramInt);
    paramString = paramString.toString();
    if (paramInt != 149)
    {
      if ((paramInt == 180) || (paramInt == 218))
      {
        paramInt = QAVConfigUtils.c(paramInt, QAVConfigUtils.b);
        paramConfigSeq.version.set(paramInt);
        paramConfigSeq.compress.set(1);
      }
    }
    else
    {
      paramInt = SharedPreUtils.c(BaseApplicationImpl.getContext());
      paramConfigSeq.version.set(paramInt);
      paramConfigSeq.compress.set(1);
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addAllConfigs, version[");
      localStringBuilder.append(paramConfigSeq.version.get());
      localStringBuilder.append("]");
      QLog.w(paramString, 1, localStringBuilder.toString());
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean, ConfigurationService.RespGetConfig paramRespGetConfig)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QAVConfig_");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    if (!paramBoolean)
    {
      QLog.d((String)localObject, 2, "receiveConfigFail, timeout");
      return;
    }
    if (paramRespGetConfig.result.get() != 0)
    {
      paramInt = paramRespGetConfig.result.get();
      paramRespGetConfig = new StringBuilder();
      paramRespGetConfig.append("receiveConfigFail, result[");
      paramRespGetConfig.append(paramInt);
      paramRespGetConfig.append("]");
      QLog.d((String)localObject, 2, paramRespGetConfig.toString());
      return;
    }
    if ((paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0)) {
      QLog.d((String)localObject, 2, "receiveConfigFail, config_list is null");
    }
  }
  
  public static void b(int paramInt, String paramString, ConfigurationService.Config paramConfig)
  {
    paramString = new StringBuilder();
    paramString.append("QAVConfig_");
    paramString.append(paramInt);
    String str = paramString.toString();
    int j = paramConfig.version.get();
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int i;
    if (paramInt != 149)
    {
      if (paramInt != 180)
      {
        if (paramInt != 218)
        {
          paramString = HardCodeUtil.a(2131906663);
          paramInt = -1;
        }
        else
        {
          i = QAVConfigUtils.c(paramInt, QAVConfigUtils.b);
          paramString = a(paramConfig, i, paramInt);
          if (paramString != null) {
            QAVConfigUtils.a(paramInt, QAVConfigUtils.b, j, paramString);
          }
          paramInt = i;
        }
      }
      else
      {
        i = QAVConfigUtils.c(paramInt, QAVConfigUtils.b);
        paramConfig = a(paramConfig, i, paramInt);
        paramInt = i;
        paramString = paramConfig;
        if (paramConfig != null)
        {
          EffectBeautyTools.a(((QQAppInterface)localObject).getApplication(), paramConfig, j, true);
          paramInt = i;
          paramString = paramConfig;
        }
      }
    }
    else
    {
      i = SharedPreUtils.c(((QQAppInterface)localObject).getApplication());
      paramConfig = a(paramConfig, i, paramInt);
      paramInt = i;
      paramString = paramConfig;
      if (paramConfig != null)
      {
        SharedPreUtils.a(((QQAppInterface)localObject).getApplication(), j);
        localObject = SharedPreUtils.c(((QQAppInterface)localObject).getCurrentAccountUin());
        paramInt = i;
        paramString = paramConfig;
        if (localObject != null)
        {
          ((SharedPreferences)localObject).edit().putString("AvWeakNet_video_ConfigContent", paramConfig).commit();
          paramString = paramConfig;
          paramInt = i;
        }
      }
    }
    if (QLog.isDevelopLevel())
    {
      paramConfig = new StringBuilder();
      paramConfig.append("receiveAllConfigs, ver[");
      paramConfig.append(paramInt);
      paramConfig.append("->");
      paramConfig.append(j);
      paramConfig.append("], content[\n");
      paramConfig.append(paramString);
      paramConfig.append("\n]");
      QLog.w(str, 1, paramConfig.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.QAVConfig
 * JD-Core Version:    0.7.0.1
 */