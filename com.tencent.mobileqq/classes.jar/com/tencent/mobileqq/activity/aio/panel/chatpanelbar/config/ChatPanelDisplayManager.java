package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config;

import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import java.util.Map;
import java.util.TreeMap;

public class ChatPanelDisplayManager
{
  static final Map<Integer, Boolean> a = new TreeMap();
  static final Map<Integer, Boolean> b = new TreeMap();
  
  static
  {
    a.put(Integer.valueOf(2131362384), Boolean.valueOf(false));
    b.put(Integer.valueOf(2131362384), Boolean.valueOf(false));
  }
  
  public static void a()
  {
    boolean bool1 = BaseChatPanelBarConfProcessor.C2CChatPanelBarConfProcessor.a().a();
    boolean bool2 = BaseChatPanelBarConfProcessor.GroupChatPanelBarConfProcessor.b().a();
    a.put(Integer.valueOf(2131362384), Boolean.valueOf(bool1));
    b.put(Integer.valueOf(2131362384), Boolean.valueOf(bool2));
  }
  
  public static boolean a(AIOPanelIconItem paramAIOPanelIconItem)
  {
    if (!a.containsKey(Integer.valueOf(paramAIOPanelIconItem.e))) {
      return true;
    }
    if ((StudyModeManager.a()) || (SimpleUIUtil.a())) {}
    for (int i = 1;; i = 0)
    {
      paramAIOPanelIconItem = (Boolean)a.get(Integer.valueOf(paramAIOPanelIconItem.e));
      if ((paramAIOPanelIconItem != null) && (paramAIOPanelIconItem.booleanValue()) && (i == 0)) {
        break;
      }
      return false;
    }
  }
  
  public static boolean b(AIOPanelIconItem paramAIOPanelIconItem)
  {
    if (!b.containsKey(Integer.valueOf(paramAIOPanelIconItem.e))) {
      return true;
    }
    if ((StudyModeManager.a()) || (SimpleUIUtil.a())) {}
    for (int i = 1;; i = 0)
    {
      paramAIOPanelIconItem = (Boolean)b.get(Integer.valueOf(paramAIOPanelIconItem.e));
      if ((paramAIOPanelIconItem != null) && (paramAIOPanelIconItem.booleanValue()) && (i == 0)) {
        break;
      }
      return false;
    }
  }
  
  public static boolean c(AIOPanelIconItem paramAIOPanelIconItem)
  {
    return (!b.containsKey(Integer.valueOf(paramAIOPanelIconItem.e))) && (!a.containsKey(Integer.valueOf(paramAIOPanelIconItem.e)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.ChatPanelDisplayManager
 * JD-Core Version:    0.7.0.1
 */