package com.tencent.mobileqq.activity.aio.panel.chatpanelbar;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.bizstatus.RedBagShowData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.UpdateParams;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.ChatPanelBarLoaderFactory;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.IChatPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.C2CPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.GroupPanelBarLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatPanelBarModel
  implements IChatPanelBarData
{
  private static RedBagShowData jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarBizstatusRedBagShowData = new RedBagShowData();
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private ChatPanelBarLoaderFactory jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderChatPanelBarLoaderFactory;
  IChatPanelBarLoader jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderIChatPanelBarLoader;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<int[]> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<int[], int[]> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private Map<int[], int[]> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  private void a()
  {
    this.jdField_b_of_type_JavaUtilMap.put(AIOPanelUtiles.e, AIOPanelUtiles.i);
    this.jdField_b_of_type_JavaUtilMap.put(AIOPanelUtiles.f, AIOPanelUtiles.j);
    this.jdField_b_of_type_JavaUtilMap.put(AIOPanelUtiles.g, AIOPanelUtiles.k);
    this.jdField_b_of_type_JavaUtilMap.put(AIOPanelUtiles.l, AIOPanelUtiles.p);
    this.jdField_b_of_type_JavaUtilMap.put(AIOPanelUtiles.m, AIOPanelUtiles.q);
    this.jdField_b_of_type_JavaUtilMap.put(AIOPanelUtiles.n, AIOPanelUtiles.r);
    this.jdField_a_of_type_JavaUtilMap.put(AIOPanelUtiles.i, AIOPanelUtiles.e);
    this.jdField_a_of_type_JavaUtilMap.put(AIOPanelUtiles.j, AIOPanelUtiles.f);
    this.jdField_a_of_type_JavaUtilMap.put(AIOPanelUtiles.k, AIOPanelUtiles.g);
    this.jdField_a_of_type_JavaUtilMap.put(AIOPanelUtiles.p, AIOPanelUtiles.l);
    this.jdField_a_of_type_JavaUtilMap.put(AIOPanelUtiles.q, AIOPanelUtiles.m);
    this.jdField_a_of_type_JavaUtilMap.put(AIOPanelUtiles.r, AIOPanelUtiles.n);
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderIChatPanelBarLoader = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderChatPanelBarLoaderFactory.a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public RedBagShowData a()
  {
    return jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarBizstatusRedBagShowData;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
  }
  
  public ArrayList<int[]> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List<AIOPanelIconItem> a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderIChatPanelBarLoader.a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie)) {
      a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderIChatPanelBarLoader.a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  public void a(ChatPanelBarContext paramChatPanelBarContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderChatPanelBarLoaderFactory = new ChatPanelBarLoaderFactory(paramChatPanelBarContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderIChatPanelBarLoader = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderChatPanelBarLoaderFactory.a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderIChatPanelBarLoader.b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie));
    a();
  }
  
  public void a(UpdateParams paramUpdateParams)
  {
    if (paramUpdateParams == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramUpdateParams.c;
    this.c = paramUpdateParams.jdField_b_of_type_Boolean;
    this.jdField_b_of_type_Boolean = paramUpdateParams.jdField_a_of_type_Boolean;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public int[] a(int[] paramArrayOfInt)
  {
    return (int[])this.jdField_b_of_type_JavaUtilMap.get(paramArrayOfInt);
  }
  
  public List<int[]> b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderIChatPanelBarLoader.a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie)) {
      a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderIChatPanelBarLoader.b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderIChatPanelBarLoader instanceof GroupPanelBarLoader;
  }
  
  public int[] b(int[] paramArrayOfInt)
  {
    return (int[])this.jdField_a_of_type_JavaUtilMap.get(paramArrayOfInt);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderIChatPanelBarLoader instanceof C2CPanelBarLoader;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarModel
 * JD-Core Version:    0.7.0.1
 */