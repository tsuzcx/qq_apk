package com.tencent.biz.qqstory.boundaries.extension.config;

import android.content.Intent;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.model.QQStoryConfigServletHandler;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class QQStoryConfigServletHandlerExt
  extends QQStoryConfigServletHandler
{
  private boolean a(List<String> paramList)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)QQStoryContext.a();
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    boolean bool1 = paramList.isEmpty();
    boolean bool2 = false;
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQStoryConfigServletHandlerExt", 2, "handleStoryMsgTabNodeConfigCmd data is null!!!");
      }
      localStoryConfigManager.b("key_story_msg_tab_show", Boolean.valueOf(false));
      bool1 = true;
    }
    else
    {
      paramList = (String)paramList.get(0);
      bool1 = bool2;
      if (paramList != null) {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("config content: ");
          localStringBuilder.append(paramList);
          QLog.d("Q.qqstory.infoTabShow", 2, localStringBuilder.toString());
        }
      }
    }
    for (;;)
    {
      try
      {
        paramList = new JSONObject(paramList);
        if (paramList.getInt("StoryShowInMsgTab") == 0) {
          break label215;
        }
        bool1 = true;
        localStoryConfigManager.b("key_story_msg_tab_show", Boolean.valueOf(bool1));
        localStoryConfigManager.b("key_story_msg_tab_autoshow_quota", Integer.valueOf(paramList.optInt("StoryAutoExpInMsgTab", 2)));
      }
      catch (JSONException paramList)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.qqstory.infoTabShow", 2, paramList.getMessage());
          bool1 = bool2;
        }
      }
      ((QQStoryHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1021, true, null);
      return bool1;
      label215:
      bool1 = false;
    }
  }
  
  private boolean b(List<String> paramList)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQStoryConfigServletHandlerExt", 2, "handleStoryMsgTabNodePreloaderConfigCmd data is null!!!");
      }
      return false;
    }
    paramList = (String)paramList.get(0);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleStoryMsgTabNodePreloaderConfigCmd config content: ");
      ((StringBuilder)localObject).append(paramList);
      QLog.d("Q.qqstory.infoTabShow", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramList = new JSONObject(paramList);
      int i = paramList.getInt("MsgTabPrestrainbNum");
      paramList = paramList.getString("4G");
      localObject = (StoryConfigManager)SuperManager.a(10);
      ((StoryConfigManager)localObject).b("key_story_msg_tab_node_preload", Integer.valueOf(i));
      ((StoryConfigManager)localObject).b("key_story_msg_tab_node_preload_4g", Boolean.valueOf("1".equals(paramList)));
      return true;
    }
    catch (JSONException paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.infoTabShow", 2, paramList.getMessage());
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, Intent paramIntent, ConfigurationService.Config paramConfig, List<String> paramList)
  {
    if (paramInt != 243)
    {
      if (paramInt != 248) {
        return false;
      }
      return b(paramList);
    }
    return a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.extension.config.QQStoryConfigServletHandlerExt
 * JD-Core Version:    0.7.0.1
 */