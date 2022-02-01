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
    Map localMap = a;
    Integer localInteger = Integer.valueOf(2131427940);
    Boolean localBoolean = Boolean.valueOf(false);
    localMap.put(localInteger, localBoolean);
    b.put(localInteger, localBoolean);
  }
  
  public static void a()
  {
    boolean bool1 = BaseChatPanelBarConfProcessor.C2CChatPanelBarConfProcessor.a().a();
    boolean bool2 = BaseChatPanelBarConfProcessor.GroupChatPanelBarConfProcessor.b().a();
    Map localMap = a;
    Integer localInteger = Integer.valueOf(2131427940);
    localMap.put(localInteger, Boolean.valueOf(bool1));
    b.put(localInteger, Boolean.valueOf(bool2));
  }
  
  public static boolean a(AIOPanelIconItem paramAIOPanelIconItem)
  {
    if (!a.containsKey(Integer.valueOf(paramAIOPanelIconItem.o))) {
      return true;
    }
    int i;
    if ((!StudyModeManager.h()) && (!SimpleUIUtil.e())) {
      i = 0;
    } else {
      i = 1;
    }
    paramAIOPanelIconItem = (Boolean)a.get(Integer.valueOf(paramAIOPanelIconItem.o));
    return (paramAIOPanelIconItem != null) && (paramAIOPanelIconItem.booleanValue()) && (i == 0);
  }
  
  public static boolean b(AIOPanelIconItem paramAIOPanelIconItem)
  {
    if (!b.containsKey(Integer.valueOf(paramAIOPanelIconItem.o))) {
      return true;
    }
    int i;
    if ((!StudyModeManager.h()) && (!SimpleUIUtil.e())) {
      i = 0;
    } else {
      i = 1;
    }
    paramAIOPanelIconItem = (Boolean)b.get(Integer.valueOf(paramAIOPanelIconItem.o));
    return (paramAIOPanelIconItem != null) && (paramAIOPanelIconItem.booleanValue()) && (i == 0);
  }
  
  public static boolean c(AIOPanelIconItem paramAIOPanelIconItem)
  {
    return (!b.containsKey(Integer.valueOf(paramAIOPanelIconItem.o))) && (!a.containsKey(Integer.valueOf(paramAIOPanelIconItem.o)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.ChatPanelDisplayManager
 * JD-Core Version:    0.7.0.1
 */