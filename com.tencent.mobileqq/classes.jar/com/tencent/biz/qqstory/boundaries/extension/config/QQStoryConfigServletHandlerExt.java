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
    boolean bool;
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQStoryConfigServletHandlerExt", 2, "handleStoryMsgTabNodeConfigCmd data is null!!!");
      }
      localStoryConfigManager.b("key_story_msg_tab_show", Boolean.valueOf(false));
      bool = true;
    }
    for (;;)
    {
      ((QQStoryHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1021, true, null);
      return bool;
      paramList = (String)paramList.get(0);
      if (paramList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.infoTabShow", 2, "config content: " + paramList);
        }
        try
        {
          paramList = new JSONObject(paramList);
          if (paramList.getInt("StoryShowInMsgTab") != 0) {}
          for (bool = true;; bool = false)
          {
            localStoryConfigManager.b("key_story_msg_tab_show", Boolean.valueOf(bool));
            localStoryConfigManager.b("key_story_msg_tab_autoshow_quota", Integer.valueOf(paramList.optInt("StoryAutoExpInMsgTab", 2)));
            bool = true;
            break;
          }
          bool = false;
        }
        catch (JSONException paramList)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.qqstory.infoTabShow", 2, paramList.getMessage());
          }
        }
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.infoTabShow", 2, "handleStoryMsgTabNodePreloaderConfigCmd config content: " + paramList);
    }
    try
    {
      paramList = new JSONObject(paramList);
      int i = paramList.getInt("MsgTabPrestrainbNum");
      paramList = paramList.getString("4G");
      StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
      localStoryConfigManager.b("key_story_msg_tab_node_preload", Integer.valueOf(i));
      localStoryConfigManager.b("key_story_msg_tab_node_preload_4g", Boolean.valueOf("1".equals(paramList)));
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
    switch (paramInt)
    {
    default: 
      return false;
    case 243: 
      return a(paramList);
    }
    return b(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.extension.config.QQStoryConfigServletHandlerExt
 * JD-Core Version:    0.7.0.1
 */