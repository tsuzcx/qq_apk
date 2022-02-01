package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.framebusiness.ContactsInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.ConversationInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.LebaInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.QzoneFrameInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.StateMachineInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.FrameControllerInjectImpl;
import com.tencent.mobileqq.kandian.biz.tab.RIJInjectImpl;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class FrameControllerInjectUtil
{
  @ConfigInject(configPath="Foundation/QQActivity/src/main/resources/Inject_FrameFragmentTabConfig.yml", version=2)
  public static ArrayList<Class<? extends IFrameControllerInterface>> a = new ArrayList();
  @ConfigInject(configPath="Foundation/QQActivity/src/main/resources/Inject_FrameFragmentTabConfig.yml", version=1)
  public static ArrayList<Class<? extends IFrameBusinessInterface>> b;
  
  static
  {
    a.add(FrameControllerInjectImpl.class);
    b = new ArrayList();
    b.add(ContactsInjectImpl.class);
    b.add(ConversationInjectImpl.class);
    b.add(LebaInjectImpl.class);
    b.add(QCircleInjectImpl.class);
    b.add(QzoneFrameInjectImpl.class);
    b.add(RIJInjectImpl.class);
    b.add(StateMachineInjectImpl.class);
    b.add(GuildInjectImpl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.FrameControllerInjectUtil
 * JD-Core Version:    0.7.0.1
 */