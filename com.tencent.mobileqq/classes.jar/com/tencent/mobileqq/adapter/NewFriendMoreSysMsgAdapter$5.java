package com.tencent.mobileqq.adapter;

import ajbi;
import ajbw;
import amik;
import android.text.TextUtils;
import antl;
import anvk;
import aoay;
import bdzx;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class NewFriendMoreSysMsgAdapter$5
  implements Runnable
{
  public NewFriendMoreSysMsgAdapter$5(amik paramamik, boolean paramBoolean) {}
  
  public void run()
  {
    long l;
    ArrayList localArrayList;
    MessageForSystemMsg localMessageForSystemMsg;
    synchronized (this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      l = bdzx.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l);
      localArrayList = new ArrayList(localList.size());
      if ((localList == null) || (localList.size() <= 0)) {
        break label448;
      }
      int i = localList.size() - 1;
      if (i < 0) {
        break label448;
      }
      ??? = (MessageRecord)localList.get(i);
      if ((??? instanceof MessageForSystemMsg))
      {
        localMessageForSystemMsg = (MessageForSystemMsg)???;
        if (localMessageForSystemMsg.structMsg == null) {
          localMessageForSystemMsg.parse();
        }
        if ((localMessageForSystemMsg.structMsg.msg.sub_type.get() != 13) || (!amik.a(this.this$0).b(String.valueOf(localMessageForSystemMsg.structMsg.req_uin.get())))) {}
      }
      else
      {
        i -= 1;
      }
    }
    String str;
    Object localObject3;
    if ((localMessageForSystemMsg.structMsg.msg.uint32_source_flag.get() & 0x8) == 8)
    {
      ??? = "";
      str = localMessageForSystemMsg.structMsg.msg.msg_source.get();
      l = localMessageForSystemMsg.structMsg.msg.uint64_discuss_uin.get();
      if (l != 0L)
      {
        ??? = ContactUtils.getDiscussionNameCanNull(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l));
        if (TextUtils.isEmpty((CharSequence)???))
        {
          localObject3 = (antl)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
          if (localObject3 != null) {
            ((antl)localObject3).a(l);
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        ConcurrentHashMap localConcurrentHashMap = this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        if (??? != null) {
          continue;
        }
        localObject3 = "";
        localConcurrentHashMap.put(Long.valueOf(l), localObject3);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "NewFriendMoreSysMsgAdapter source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", new Object[] { Integer.valueOf(localMessageForSystemMsg.structMsg.msg.uint32_source_flag.get()), Long.valueOf(l), ???, str }));
      }
      localArrayList.add(new ajbi(localMessageForSystemMsg));
      break;
      localObject3 = ???;
    }
    label448:
    ??? = amik.a(this.this$0).a(true);
    if (((ArrayList)???).size() > 0) {
      localArrayList.addAll((Collection)???);
    }
    ??? = amik.a(this.this$0).c();
    if ((??? != null) && (!((ArrayList)???).isEmpty()))
    {
      ??? = ((ArrayList)((ArrayList)???).clone()).iterator();
      while (((Iterator)???).hasNext()) {
        localArrayList.add(new ajbw((PhoneContactAdd)((Iterator)???).next()));
      }
    }
    Collections.sort(localArrayList, amik.a(this.this$0));
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new NewFriendMoreSysMsgAdapter.5.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.5
 * JD-Core Version:    0.7.0.1
 */