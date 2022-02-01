package com.tencent.biz.qqstory.model;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class QQStoryConfigServletHandler
  implements KeepConstructor
{
  private boolean a(List<String> paramList)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleAlbumEntraConfig data is null!!!");
      }
      return false;
    }
    String str = (String)paramList.get(0);
    if (str == null) {
      paramList = "";
    } else {
      paramList = str;
    }
    SLog.a("Q.qqstory.config.QQStoryConfigServletHandler", "handleAlbumEntraConfig type: 日迹主页影集入口配置, content: \n", paramList);
    paramList = (StoryScanManager)SuperManager.a(30);
    if ((!TextUtils.isEmpty(str)) && (str.trim().length() != 0)) {
      return paramList.a(str);
    }
    paramList.d();
    return true;
  }
  
  private boolean a(List<String> paramList, int paramInt)
  {
    HashMap localHashMap;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    String str9;
    String str10;
    boolean bool;
    StringBuilder localStringBuilder;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localHashMap = new HashMap();
      int i = 0;
      while (i < paramList.size())
      {
        localObject1 = (String)paramList.get(i);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("receiveAllConfigs|type: -128,content: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(",version: ");
          ((StringBuilder)localObject2).append(paramInt);
          QLog.d("Q.qqstory.videoConfig", 2, ((StringBuilder)localObject2).toString());
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "received TAG_STORY_VIDEO_CONFIG IGNORE THIS ACTION  because of SAME VERSION or empty content");
        }
        else
        {
          localObject1 = ((String)localObject1).split("\n");
          int k = localObject1.length;
          int j = 0;
          while (j < k)
          {
            localObject2 = localObject1[j].split("=");
            if (localObject2.length == 2)
            {
              localHashMap.put(localObject2[0].trim(), localObject2[1].trim());
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("STORY_VIDEO_CONFIG, name=");
                ((StringBuilder)localObject3).append(localObject2[0].trim());
                ((StringBuilder)localObject3).append(", val=");
                ((StringBuilder)localObject3).append(localObject2[1].trim());
                QLog.i("Q.qqstory.videoConfig", 2, ((StringBuilder)localObject3).toString());
              }
            }
            j += 1;
          }
        }
        i += 1;
      }
      localObject1 = (StoryConfigManager)SuperManager.a(10);
      localObject2 = (String)localHashMap.get("key");
      localObject3 = (String)localHashMap.get("Width");
      str1 = (String)localHashMap.get("Height");
      str2 = (String)localHashMap.get("Maxrate");
      str3 = (String)localHashMap.get("Minrate");
      str4 = (String)localHashMap.get("crf");
      str5 = (String)localHashMap.get("qmax");
      str6 = (String)localHashMap.get("qmin");
      str7 = (String)localHashMap.get("qdiff");
      str8 = (String)localHashMap.get("newWidth");
      str9 = (String)localHashMap.get("newHeight");
      str10 = (String)localHashMap.get("newBitRate");
      String str11 = (String)localHashMap.get("cq");
      try
      {
        paramInt = Integer.valueOf(str11).intValue();
        if (paramInt != 0) {
          break label1314;
        }
        bool = true;
        try
        {
          ((StoryConfigManager)localObject1).d("boolean_enable_cq_mode", Boolean.valueOf(bool));
        }
        catch (NumberFormatException paramList) {}
        localStringBuilder = new StringBuilder();
      }
      catch (NumberFormatException paramList) {}
      localStringBuilder.append("get enableCqMode= ");
      localStringBuilder.append(str11);
      localStringBuilder.append(" from json error:");
      localStringBuilder.append(paramList);
      SLog.e("Q.qqstory.config.QQStoryConfigServletHandler", localStringBuilder.toString());
      paramList = (String)localHashMap.get("hbr");
      try
      {
        ((StoryConfigManager)localObject1).d("int_high_bitrate", Integer.valueOf(Integer.valueOf(paramList).intValue()));
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("get highBitrate= ");
        localStringBuilder.append(paramList);
        localStringBuilder.append(" from json error:");
        localStringBuilder.append(localNumberFormatException1);
        SLog.e("Q.qqstory.config.QQStoryConfigServletHandler", localStringBuilder.toString());
      }
      paramList = (String)localHashMap.get("hprf");
    }
    for (;;)
    {
      try
      {
        if (Integer.valueOf(paramList).intValue() != 1) {
          break label1320;
        }
        bool = true;
        ((StoryConfigManager)localObject1).d("boolean_need_high_profile", Boolean.valueOf(bool));
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("get codecProfile= ");
        localStringBuilder.append(paramList);
        localStringBuilder.append(" from json error:");
        localStringBuilder.append(localNumberFormatException2);
        SLog.e("Q.qqstory.config.QQStoryConfigServletHandler", localStringBuilder.toString());
      }
      paramList = (String)localHashMap.get("mvs");
      try
      {
        ((StoryConfigManager)localObject1).d("int_upload_video_size_limit", Integer.valueOf(Integer.valueOf(paramList).intValue()));
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("get maxVideoSize= ");
        localStringBuilder.append(paramList);
        localStringBuilder.append(" from json error:");
        localStringBuilder.append(localNumberFormatException3);
        SLog.e("Q.qqstory.config.QQStoryConfigServletHandler", localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("key = ");
        paramList.append((String)localObject2);
        paramList.append(" Width = ");
        paramList.append((String)localObject3);
        paramList.append("Height = ");
        paramList.append(str1);
        paramList.append("Maxrate = ");
        paramList.append(str2);
        paramList.append("Minrate = ");
        paramList.append(str3);
        paramList.append(" newWidth=");
        paramList.append(str8);
        paramList.append(" newHeight=");
        paramList.append(str9);
        paramList.append(" newBitRate=");
        paramList.append(str10);
        QLog.i("Q.qqstory.videoConfig", 2, paramList.toString());
      }
      if (str8 != null) {}
      try
      {
        ((StoryConfigManager)localObject1).d("NewStoryVideoWidth", Integer.valueOf(str8));
        if (str9 != null) {
          ((StoryConfigManager)localObject1).d("NewStoryVideoHeight", Integer.valueOf(str9));
        }
        if (str10 != null) {
          ((StoryConfigManager)localObject1).d("NewStoryBitRate", Integer.valueOf(str10));
        }
        if (localObject2 != null) {
          ((StoryConfigManager)localObject1).d("StoryVideoKey", localObject2);
        }
        if (localObject3 != null) {
          ((StoryConfigManager)localObject1).d("StoryVideoWidth", Integer.valueOf((String)localObject3));
        }
        if (str1 != null) {
          ((StoryConfigManager)localObject1).d("StoryVideoHeight", Integer.valueOf(str1));
        }
        if (str2 != null) {
          ((StoryConfigManager)localObject1).d("StoryVideoMaxrate", Integer.valueOf(str2));
        }
        if (str3 != null) {
          ((StoryConfigManager)localObject1).d("StoryVideoMinrate", Integer.valueOf(str3));
        }
        if (str4 != null) {
          ((StoryConfigManager)localObject1).d("key_encode_crf", Integer.valueOf(str4));
        }
        if (str5 != null) {
          ((StoryConfigManager)localObject1).d("key_encode_qmax", Integer.valueOf(str5));
        }
        if (str6 != null) {
          ((StoryConfigManager)localObject1).d("key_encode_qmin", Integer.valueOf(str6));
        }
        if (str7 != null) {
          ((StoryConfigManager)localObject1).d("key_encode_qdiff", Integer.valueOf(str7));
        }
        paramList = (String)localHashMap.get("localUploadVideoSizeLimit");
        if (paramList != null) {
          ((StoryConfigManager)localObject1).d("localUploadVideoSizeLimit", Integer.valueOf(paramList));
        }
        paramList = (String)localHashMap.get("localUploadVideoMinResolutionLimit");
        if (paramList != null) {
          ((StoryConfigManager)localObject1).d("localUploadVideoMinResolutionLimit", Integer.valueOf(paramList));
        }
        paramList = (String)localHashMap.get("localUploadVideoDurationLimit");
        if (paramList != null) {
          ((StoryConfigManager)localObject1).d("localUploadVideoDurationLimit", Integer.valueOf(paramList));
        }
        paramList = (String)localHashMap.get("localUploadVideoRatioLimit");
        if (paramList != null) {
          ((StoryConfigManager)localObject1).d("localUploadVideoRatioLimit", Integer.valueOf(paramList));
        }
        paramList = (String)localHashMap.get("localUploadImageSizeLimit");
        if (paramList != null) {
          ((StoryConfigManager)localObject1).d("localUploadImageSizeLimit", Integer.valueOf(paramList));
        }
        paramList = (String)localHashMap.get("localUploadImageMinResolutionLimit");
        if (paramList == null) {
          break label1310;
        }
        ((StoryConfigManager)localObject1).d("localUploadImageMinResolutionLimit", Integer.valueOf(paramList));
      }
      catch (Exception paramList)
      {
        label1300:
        label1310:
        label1314:
        label1320:
        break label1300;
      }
      QLog.w("Q.qqstory.videoConfig", 2, "save sp error", paramList);
      return true;
      return false;
      bool = false;
      break;
      bool = false;
    }
  }
  
  private boolean a(List<String> paramList, String paramString)
  {
    long l1;
    if ((!paramList.isEmpty()) && (!TextUtils.isEmpty(paramString)))
    {
      SLog.a("Q.qqstory.config.QQStoryConfigServletHandler", "handleQzoneSync2QQStory config=%s", paramList);
      paramList = (String)paramList.get(0);
      if (!TextUtils.isEmpty(paramList)) {
        l1 = 0L;
      }
    }
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (Throwable paramString)
    {
      label60:
      break label60;
    }
    SLog.e("Q.qqstory.config.QQStoryConfigServletHandler", "handleQzoneSync2QQStory  parseLong error");
    LocalMultiProcConfig.putString4Uin("key_qzone_sync_to_qqstory_config", paramList, l1);
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleQzoneSync2QQStory data is null!!!");
    }
    return false;
  }
  
  private boolean b(List<String> paramList)
  {
    StoryScanManager localStoryScanManager = (StoryScanManager)SuperManager.a(30);
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleAlbumConfig data is null!!! clear config");
      }
      localStoryScanManager.e();
      return true;
    }
    String str = (String)paramList.get(0);
    if (str == null) {
      paramList = "";
    } else {
      paramList = str;
    }
    SLog.a("Q.qqstory.config.QQStoryConfigServletHandler", "handleAlbumConfig type: 影集配置, content: \n", paramList);
    if ((!TextUtils.isEmpty(str)) && (str.trim().length() != 0)) {
      return localStoryScanManager.b(str);
    }
    localStoryScanManager.e();
    return true;
  }
  
  private boolean b(List<String> paramList, int paramInt)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.videoCache", 2, "handleStoryCacheConfigCmd, configList is empty");
      }
      return false;
    }
    paramList = (String)paramList.get(0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleStoryCacheConfigCmd, version = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", json = ");
      localStringBuilder.append(paramList);
      QLog.d("Q.qqstory.videoCache", 2, localStringBuilder.toString());
    }
    return ((StoryManager)SuperManager.a(5)).l(paramList);
  }
  
  private boolean c(List<String> paramList)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleMsgTabTakeVideoNodeConfig data is null!!!");
      }
      return false;
    }
    MsgTabStoryNodeConfigManager localMsgTabStoryNodeConfigManager = (MsgTabStoryNodeConfigManager)QQStoryContext.j().getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER);
    String str = (String)paramList.get(0);
    if (str == null) {
      paramList = "";
    } else {
      paramList = str;
    }
    SLog.a("Q.qqstory.config.QQStoryConfigServletHandler", "handleMsgTabTakeVideoNodeConfig type: 日迹拍摄配置, content: \n", paramList);
    if ((!TextUtils.isEmpty(str)) && (str.trim().length() != 0)) {
      return localMsgTabStoryNodeConfigManager.a(str);
    }
    localMsgTabStoryNodeConfigManager.c();
    return true;
  }
  
  private boolean d(List<String> paramList)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handledAIOSyncToStory data is null!!!");
      }
      return false;
    }
    SLog.a("Q.qqstory.config.QQStoryConfigServletHandler", "handledAIOSyncToStory config=%s", (String)paramList.get(0));
    return false;
  }
  
  private boolean e(List<String> paramList)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleStoryEditVideoConfig data is null!!!");
      }
      return false;
    }
    SLog.a("Q.qqstory.config.QQStoryConfigServletHandler", "handleStorySync2QzoneConfig config=%s", paramList);
    paramList = (String)paramList.get(0);
    if (TextUtils.isEmpty(paramList))
    {
      SLog.d("Q.qqstory.config.QQStoryConfigServletHandler", "handleStorySync2QzoneConfig clear config");
      StoryConfigManager.c(false);
      StoryConfigManager.d(false);
      return true;
    }
    for (;;)
    {
      try
      {
        paramList = new JSONObject(paramList);
        int i = paramList.optInt("show_sync_btn");
        int j = paramList.optInt("default_status");
        SLog.a("Q.qqstory.config.QQStoryConfigServletHandler", "handleStorySync2QzoneConfig showSyncBtn = %d,defaultStatus=%d", Integer.valueOf(i), Integer.valueOf(j));
        if (i == 1)
        {
          bool = true;
          StoryConfigManager.c(bool);
          if (j != 1) {
            break label199;
          }
          bool = true;
          StoryConfigManager.d(bool);
          return true;
        }
      }
      catch (JSONException paramList)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleStorySync2QzoneConfig:");
        localStringBuilder.append(paramList.toString());
        AssertUtils.fail(localStringBuilder.toString(), new Object[0]);
        paramList.printStackTrace();
        return false;
      }
      boolean bool = false;
      continue;
      label199:
      bool = false;
    }
  }
  
  private boolean f(List<String> paramList)
  {
    boolean bool = paramList.isEmpty();
    Boolean localBoolean = Boolean.valueOf(false);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleStoryEditVideoConfig data is null!!!");
      }
      return false;
    }
    paramList = (String)paramList.get(0);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleStoryEditVideoConfig config content: ");
      ((StringBuilder)localObject).append(paramList);
      QLog.i("Q.qqstory.editVideoConfig", 2, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      int i;
      try
      {
        paramList = (StoryEditVideoConfig)JsonORM.a(new JSONObject(paramList), StoryEditVideoConfig.class);
        localObject = (StoryConfigManager)SuperManager.a(10);
        ((StoryConfigManager)localObject).d("boolean_enable_revert_play_mode", Boolean.valueOf(true));
        ((StoryConfigManager)localObject).d("boolean_enable_fast_play_mode", Boolean.valueOf(true));
        ((StoryConfigManager)localObject).d("boolean_enable_slow_play_mode", Boolean.valueOf(true));
        ((StoryConfigManager)localObject).d("boolean_enable_hw_encode_pic_to_video", Boolean.valueOf(true));
        ((StoryConfigManager)localObject).d("boolean_enable_flow_decode", Boolean.valueOf(true));
        ((StoryConfigManager)localObject).d("boolean_use_flow_decode_first", localBoolean);
        ((StoryConfigManager)localObject).d("key_story_home_preload_count", Integer.valueOf(4));
        ((StoryConfigManager)localObject).d("key_story_video_preload_duration", Integer.valueOf(2));
        StoryEditVideoConfig.Device[] arrayOfDevice;
        if (paramList.f != null)
        {
          arrayOfDevice = paramList.f;
          j = arrayOfDevice.length;
          i = 0;
          if (i < j)
          {
            if (!arrayOfDevice[i].a()) {
              break label737;
            }
            QLog.i("Q.qqstory.editVideoConfig", 2, "use flow decode first");
            ((StoryConfigManager)localObject).d("boolean_use_flow_decode_first", Boolean.valueOf(true));
          }
        }
        if (paramList.a != null)
        {
          arrayOfDevice = paramList.a;
          j = arrayOfDevice.length;
          i = 0;
          if (i < j)
          {
            if (!arrayOfDevice[i].a()) {
              break label744;
            }
            QLog.i("Q.qqstory.editVideoConfig", 2, "disable revert play mode");
            ((StoryConfigManager)localObject).d("boolean_enable_revert_play_mode", localBoolean);
          }
        }
        if (paramList.b != null)
        {
          arrayOfDevice = paramList.b;
          j = arrayOfDevice.length;
          i = 0;
          if (i < j)
          {
            if (!arrayOfDevice[i].a()) {
              break label751;
            }
            QLog.i("Q.qqstory.editVideoConfig", 2, "disable fast play mode");
            ((StoryConfigManager)localObject).d("boolean_enable_fast_play_mode", localBoolean);
          }
        }
        if (paramList.c != null)
        {
          arrayOfDevice = paramList.c;
          j = arrayOfDevice.length;
          i = 0;
          if (i < j)
          {
            if (!arrayOfDevice[i].a()) {
              break label758;
            }
            QLog.i("Q.qqstory.editVideoConfig", 2, "disable slow play mode");
            ((StoryConfigManager)localObject).d("boolean_enable_slow_play_mode", localBoolean);
          }
        }
        if (paramList.d != null)
        {
          arrayOfDevice = paramList.d;
          j = arrayOfDevice.length;
          i = 0;
          if (i < j)
          {
            if (!arrayOfDevice[i].a()) {
              break label765;
            }
            QLog.i("Q.qqstory.editVideoConfig", 2, "disable hw encode picToVideo");
            ((StoryConfigManager)localObject).d("boolean_enable_hw_encode_pic_to_video", localBoolean);
          }
        }
        if (paramList.e != null)
        {
          arrayOfDevice = paramList.e;
          j = arrayOfDevice.length;
          i = 0;
          if (i < j)
          {
            if (!arrayOfDevice[i].a()) {
              break label772;
            }
            QLog.i("Q.qqstory.editVideoConfig", 2, "disable flow decode");
            ((StoryConfigManager)localObject).d("boolean_enable_flow_decode", localBoolean);
          }
        }
        int j = -1;
        i = j;
        if (paramList.g != null) {
          if ("DEBUG".contains(paramList.g))
          {
            i = 3;
          }
          else if ("INFO".contains(paramList.g))
          {
            i = 4;
          }
          else
          {
            i = j;
            if ("WARN".contains(paramList.g)) {
              i = 5;
            }
          }
        }
        ((StoryConfigManager)localObject).d("string_story_global_log_level", Integer.valueOf(i));
        ((StoryConfigManager)localObject).d("string_auto_play_report_control", paramList.h);
        if ((paramList.i > 0) && (paramList.i < 20)) {
          ((StoryConfigManager)localObject).d("key_story_home_preload_count", Integer.valueOf(paramList.i));
        }
        if ((paramList.j > 0) && (paramList.j < 10)) {
          ((StoryConfigManager)localObject).d("key_story_video_preload_duration", Integer.valueOf(paramList.j));
        }
        return true;
      }
      catch (JsonORM.JsonParseException paramList)
      {
        QLog.w("Q.qqstory.editVideoConfig", 2, paramList.getMessage());
      }
      catch (JSONException paramList)
      {
        QLog.w("Q.qqstory.editVideoConfig", 2, paramList.getMessage());
      }
      return false;
      label737:
      i += 1;
      continue;
      label744:
      i += 1;
      continue;
      label751:
      i += 1;
      continue;
      label758:
      i += 1;
      continue;
      label765:
      i += 1;
      continue;
      label772:
      i += 1;
    }
  }
  
  private boolean g(List<String> paramList)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleStoryPlayerProxyConfigCmd data is null!!!");
      }
      return false;
    }
    Object localObject = QQStoryContext.j();
    paramList = (String)paramList.get(0);
    if (!TextUtils.isEmpty(paramList)) {
      SharedPreUtils.i(((QQAppInterface)localObject).getApp(), ((QQAppInterface)localObject).getCurrentUin(), paramList);
    } else {
      SharedPreUtils.i(((QQAppInterface)localObject).getApp(), ((QQAppInterface)localObject).getCurrentUin(), null);
    }
    ((QQStoryManager)((QQAppInterface)localObject).getManager(QQManagerFactory.QQSTORY_MANAGER)).c(paramList);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleStoryPlayerProxyConfigCmd configContent = ");
      ((StringBuilder)localObject).append(paramList);
      QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, ((StringBuilder)localObject).toString());
    }
    return true;
  }
  
  private boolean h(List<String> paramList)
  {
    if (paramList.isEmpty()) {
      return false;
    }
    paramList = (String)paramList.get(0);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("config content: ");
      ((StringBuilder)localObject).append(paramList);
      QLog.d("Q.qqstory.config", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject(paramList);
      paramList = (StoryConfigManager)SuperManager.a(10);
      JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("mainHallConfig");
      if (localJSONObject != null) {
        paramList.d("mainHallConfig", localJSONObject.toString());
      } else {
        paramList.d("mainHallConfig", "");
      }
      localObject = ((JSONObject)localObject).optJSONObject("troopStoryHallConfig");
      if (localObject != null) {
        paramList.d("troopStoryHallConfig", ((JSONObject)localObject).toString());
      } else {
        paramList.d("troopStoryHallConfig", "");
      }
      return true;
    }
    catch (JSONException paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.config", 2, paramList.getMessage());
      }
    }
    return false;
  }
  
  private boolean i(List<String> paramList)
  {
    boolean bool = paramList.isEmpty();
    Object localObject1 = Boolean.valueOf(false);
    if (bool) {
      return false;
    }
    paramList = (String)paramList.get(0);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("config content: ");
      ((StringBuilder)localObject2).append(paramList);
      QLog.d("Q.qqstory.commonConfig", 2, ((StringBuilder)localObject2).toString());
    }
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramList);
        Object localObject4 = localJSONObject.optJSONObject("certificationLink");
        localObject2 = (StoryConfigManager)SuperManager.a(10);
        if (localObject4 != null)
        {
          localObject3 = ((JSONObject)localObject4).optString("text");
          localObject4 = ((JSONObject)localObject4).optString("url");
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (HttpUtil.isValidUrl((String)localObject4)))
          {
            ((StoryConfigManager)localObject2).d("CertificationLinkText", localObject3);
            ((StoryConfigManager)localObject2).d("CertificationLinkUrl", localObject4);
          }
          else
          {
            ((StoryConfigManager)localObject2).d("CertificationLinkText", "");
            ((StoryConfigManager)localObject2).d("CertificationLinkUrl", "");
          }
        }
        else
        {
          ((StoryConfigManager)localObject2).d("CertificationLinkText", "");
          ((StoryConfigManager)localObject2).d("CertificationLinkUrl", "");
        }
        Object localObject3 = localJSONObject.optJSONObject("localVideo");
        int j;
        if (localObject3 != null)
        {
          j = ((JSONObject)localObject3).getInt("scanInterval");
          i = j;
          if (j == 0) {
            i = 1439;
          }
          ((StoryConfigManager)localObject2).d("localVideoScanInterval", String.valueOf(i));
        }
        else
        {
          ((StoryConfigManager)localObject2).d("localVideoScanInterval", "1441");
        }
        localObject3 = localJSONObject.optJSONObject("mainHallConfig");
        if (localObject3 != null) {
          ((StoryConfigManager)localObject2).d("mainHallConfig", ((JSONObject)localObject3).toString());
        } else {
          ((StoryConfigManager)localObject2).d("mainHallConfig", "");
        }
        localObject3 = localJSONObject.optJSONObject("troopStoryHallConfig");
        if (localObject3 != null) {
          ((StoryConfigManager)localObject2).d("troopStoryHallConfig", ((JSONObject)localObject3).toString());
        } else {
          ((StoryConfigManager)localObject2).d("troopStoryHallConfig", "");
        }
        localObject3 = localJSONObject.optJSONObject("storyShareTokenConfig");
        if (localObject3 != null)
        {
          if (((JSONObject)localObject3).optInt("encry", 0) == 0) {
            break label660;
          }
          bool = true;
          ((StoryConfigManager)localObject2).d("key_share_encrypt_flag", Boolean.valueOf(bool));
        }
        else
        {
          ((StoryConfigManager)localObject2).d("key_share_encrypt_flag", localObject1);
        }
        localObject3 = localJSONObject.optJSONObject("createShareGroup");
        if (localObject3 != null)
        {
          if (((JSONObject)localObject3).optInt("show", 1) == 0) {
            break label666;
          }
          bool = true;
          ((StoryConfigManager)localObject2).d("key_show_in_friend_story_main_page", Boolean.valueOf(bool));
        }
        else
        {
          ((StoryConfigManager)localObject2).d("key_show_in_friend_story_main_page", Boolean.valueOf(true));
        }
        localObject3 = localJSONObject.optJSONArray("multiFragmentBlackModelList");
        if (localObject3 != null)
        {
          localObject4 = Build.MODEL.toLowerCase();
          j = ((JSONArray)localObject3).length();
          ((StoryConfigManager)localObject2).d("boolean_enable_multi_video_fragment", Boolean.valueOf(true));
          i = 0;
          if (i < j)
          {
            String str = ((JSONArray)localObject3).optString(i);
            if (!((String)localObject4).equalsIgnoreCase(str)) {
              if (!"all".equalsIgnoreCase(str)) {
                break label672;
              }
            }
            ((StoryConfigManager)localObject2).d("boolean_enable_multi_video_fragment", localObject1);
          }
        }
        else
        {
          ((StoryConfigManager)localObject2).d("boolean_enable_multi_video_fragment", Boolean.valueOf(true));
        }
        i = localJSONObject.optInt("qim_sync_to_qq", 0);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("qim_sync_to_qq: ");
        ((StringBuilder)localObject1).append(paramList);
        QLog.d("Q.qqstory.commonConfig", 2, ((StringBuilder)localObject1).toString());
        ((StoryConfigManager)localObject2).d("key_qim_int_qim_sync_to_qq_default", Integer.valueOf(i));
        return true;
      }
      catch (JSONException paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.commonConfig", 2, paramList.getMessage());
        }
        return false;
      }
      label660:
      bool = false;
      continue;
      label666:
      bool = false;
      continue;
      label672:
      i += 1;
    }
  }
  
  private boolean j(List<String> paramList)
  {
    boolean bool = paramList.isEmpty();
    Boolean localBoolean = Boolean.valueOf(false);
    if (bool) {
      return false;
    }
    Object localObject = (String)paramList.get(0);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("config content: ");
      paramList.append((String)localObject);
      QLog.d("Q.qqstory.shareConfig", 2, paramList.toString());
    }
    paramList = (StoryConfigManager)SuperManager.a(10);
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject).optJSONObject("shareToDiscoverConfig");
        if (localObject != null)
        {
          if (((JSONObject)localObject).optInt("show") != 0)
          {
            bool = true;
            paramList.d("share_to_discover_show", Boolean.valueOf(bool));
            return true;
          }
        }
        else
        {
          paramList.d("share_to_discover_show", localBoolean);
          return true;
        }
      }
      catch (JSONException localJSONException)
      {
        paramList.d("share_to_discover_show", localBoolean);
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.shareConfig", 2, localJSONException.getMessage());
        }
        return false;
      }
      bool = false;
    }
  }
  
  public boolean a(int paramInt, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    String str = paramIntent.getStringExtra("key_uin");
    Object localObject = StoryConfigManager.a(paramInt);
    int i = SharedPreUtils.c(QQStoryContext.j().getApp(), (String)localObject, str);
    int j = paramConfig.version.get();
    localObject = ConfigServlet.c(paramConfig, i, paramInt);
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    if (paramInt != -220)
    {
      if (paramInt != -208)
      {
        if (paramInt != 152)
        {
          if (paramInt != 219)
          {
            if (paramInt != 350)
            {
              if (paramInt != 356)
              {
                if (paramInt != 366)
                {
                  if (paramInt != -151)
                  {
                    if (paramInt != -150)
                    {
                      if (paramInt != -128)
                      {
                        if (paramInt != -127)
                        {
                          if (paramInt != 317)
                          {
                            if (paramInt == 318) {
                              bool1 = e((List)localObject);
                            }
                          }
                          else {
                            bool1 = a((List)localObject, str);
                          }
                        }
                        else {
                          bool1 = g((List)localObject);
                        }
                      }
                      else {
                        bool1 = a((List)localObject, j);
                      }
                    }
                    else {
                      bool1 = b((List)localObject, j);
                    }
                  }
                  else {
                    bool1 = i((List)localObject);
                  }
                }
                else {
                  bool1 = a((List)localObject);
                }
              }
              else {
                bool1 = b((List)localObject);
              }
            }
            else {
              bool1 = c((List)localObject);
            }
          }
          else {
            bool1 = f((List)localObject);
          }
        }
        else {
          bool1 = d((List)localObject);
        }
      }
      else {
        bool1 = j((List)localObject);
      }
    }
    else {
      bool1 = h((List)localObject);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = a(paramInt, paramIntent, paramConfig, (List)localObject);
    }
    return bool2;
  }
  
  public abstract boolean a(int paramInt, Intent paramIntent, ConfigurationService.Config paramConfig, List<String> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.QQStoryConfigServletHandler
 * JD-Core Version:    0.7.0.1
 */