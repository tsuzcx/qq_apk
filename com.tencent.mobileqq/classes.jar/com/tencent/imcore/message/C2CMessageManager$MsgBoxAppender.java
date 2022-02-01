package com.tencent.imcore.message;

import com.tencent.imcore.message.msgboxappender.IMsgBoxAppender;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class C2CMessageManager$MsgBoxAppender
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private RecentUserProxy jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private IConversationFacade jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, RecentUser> jdField_a_of_type_JavaUtilMap;
  
  public C2CMessageManager$MsgBoxAppender(MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, IConversationFacade paramIConversationFacade, String paramString, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramEntityManager;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramMap;
    this.jdField_a_of_type_JavaUtilMap = paramRecentUserProxy;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = paramIConversationFacade;
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade = paramString;
    this.jdField_a_of_type_JavaLangString = paramInt;
    this.jdField_a_of_type_Int = paramLong;
    Object localObject;
    this.jdField_a_of_type_Long = localObject;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public MsgBoxAppender a()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager.a.getRegistry().j().iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = ((IMsgBoxAppender)localIterator.next()).a(this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy, this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      if (((Boolean)arrayOfObject[0]).booleanValue())
      {
        this.jdField_a_of_type_JavaLangString = ((String)arrayOfObject[1]);
        this.jdField_a_of_type_Int = ((Integer)arrayOfObject[2]).intValue();
        this.jdField_a_of_type_Long = ((Long)arrayOfObject[3]).longValue();
      }
    }
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManager.MsgBoxAppender
 * JD-Core Version:    0.7.0.1
 */