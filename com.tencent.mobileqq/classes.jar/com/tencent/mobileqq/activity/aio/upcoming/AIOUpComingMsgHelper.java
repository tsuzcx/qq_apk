package com.tencent.mobileqq.activity.aio.upcoming;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.ColorNoteCurd.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AIOUpComingMsgHelper
  implements Handler.Callback, ILifeCycleHelper
{
  private long jdField_a_of_type_Long = -1L;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private MultiColorNoteGenerator jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingMultiColorNoteGenerator;
  private UpcomingTimeSelector jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingTimeSelector;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new AIOUpComingMsgHelper.2(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ColorNoteCurd.OnColorNoteCurdListener jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd$OnColorNoteCurdListener = new AIOUpComingMsgHelper.5(this);
  private ColorNoteCurd jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private MessageRecord b;
  
  public AIOUpComingMsgHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = true;
    g();
  }
  
  private void a(String paramString)
  {
    Object localObject;
    android.os.Message localMessage;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
      localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
      localMessage.what = 2;
      if (localObject == null) {
        break label122;
      }
      if (((HotChatInfo)localObject).state != 6) {
        break label91;
      }
      localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getResources().getString(2131690060);
    }
    for (;;)
    {
      if (localMessage.obj != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      }
      return;
      label91:
      if (((HotChatInfo)localObject).state == 7)
      {
        localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getResources().getString(2131690066);
        continue;
        label122:
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject != null)
        {
          paramString = ((TroopManager)localObject).a(paramString + "", true);
          if (paramString != null)
          {
            if ((paramString.isKicked()) || (paramString.isExited())) {
              localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getResources().getString(2131690060);
            } else if (paramString.isDisband()) {
              localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getResources().getString(2131690066);
            }
          }
          else {
            localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getResources().getString(2131690060);
          }
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(AIOUpComingMsgHelper.class);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  private void c()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getIntent();
    if (localIntent != null) {
      this.jdField_a_of_type_Long = localIntent.getLongExtra("key_uniseq", -1L);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
  }
  
  private void c(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      ArrayList localArrayList = new ArrayList();
      if (1 == paramInt) {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq != ((MessageRecord)paramList.get(0)).uniseq) {
          localArrayList.add(paramList.get(0));
        }
      }
      while (!localArrayList.isEmpty())
      {
        a(paramList, paramLong, paramInt);
        return;
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq != localMessageRecord.uniseq) {
            localArrayList.add(paramList.get(0));
          }
        }
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), 1, 2131690045, 0).a();
      return;
    }
    a(paramList, paramLong, paramInt);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Long != -1L)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(false, null, false, false, true);
      long l = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = -1L;
      ThreadManager.getSubThreadHandler().postAtTime(new AIOUpComingMsgHelper.1(this, l), AIOUpComingMsgHelper.class, 0L);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingTimeSelector == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingTimeSelector = new UpcomingTimeSelector(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd = new ColorNoteCurd();
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd$OnColorNoteCurdListener);
    }
  }
  
  private void g()
  {
    if ((this.b != null) && (this.jdField_a_of_type_Boolean))
    {
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof FriendChatPie)) {
        break label65;
      }
      ((FriendChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a(22, this.b.msgUid, this.b.time, this.b);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = null;
      return;
      label65:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.h())
      {
        com.tencent.imcore.message.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(22, this.b.shmsgseq, (int)(localMessage.shmsgseq - this.b.shmsgseq), null);
      }
    }
  }
  
  ColorNote a(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingMultiColorNoteGenerator == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingMultiColorNoteGenerator = new MultiColorNoteGenerator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingMultiColorNoteGenerator.a(paramList, paramLong, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingMultiColorNoteGenerator == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingMultiColorNoteGenerator = new MultiColorNoteGenerator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingMultiColorNoteGenerator.a(paramList, paramLong, 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    QLog.d("UpComingMsgLogic.AIOUpComingMsgHelper", 4, paramChatMessage.toString());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramChatMessage);
    e();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingTimeSelector.a(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingTimeSelector.a(new AIOUpComingMsgHelper.3(this, localArrayList));
    int i = UpComingMsgUtil.a(paramChatMessage);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE7D", "0X800AE7D", i, 0, "", "", "", "");
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692257, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    }
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = MultiMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramList);
      } while ((localObject1 == null) || (((ArrayList)localObject1).size() == 0));
      MultiMsgManager.a().b((List)localObject1);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "multiForwardTogether|checklist.size = " + ((ArrayList)localObject1).size());
      }
    } while (((ArrayList)localObject1).size() == 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e(2131698459);
    paramList = new ArrayList();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = MsgProxyUtils.a((ChatMessage)((Iterator)localObject2).next());
      if (!paramList.contains(str)) {
        paramList.add(str);
      }
    }
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.clear();
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
    MultiMsgManager.a().jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList, false, null);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
      localObject2 = ((MqqHandler)localObject1).obtainMessage(24);
      ((android.os.Message)localObject2).arg1 = paramList.size();
      ((MqqHandler)localObject1).sendMessageDelayed((android.os.Message)localObject2, 30000L);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendNickByBatch(paramList);
      }
    }
  }
  
  public void a(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    f();
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(0, "update_process_state", false);
    if (!this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a()) {
      ColorNoteUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    }
    for (;;)
    {
      return;
      if ((paramList != null) && (paramList.size() > 0))
      {
        f();
        try
        {
          paramList = a(paramList, paramLong, paramInt);
          if (paramList != null)
          {
            paramList = paramList.parseBundle();
            this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(paramList);
            return;
          }
        }
        catch (IllegalAccessException paramList)
        {
          QLog.e("UpComingMsgLogic.AIOUpComingMsgHelper", 1, "addColorNote occur error.", paramList);
        }
      }
    }
  }
  
  public void b(List<ChatMessage> paramList, long paramLong, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    e();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingTimeSelector.a(2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingTimeSelector.a(new AIOUpComingMsgHelper.4(this, localArrayList, paramList));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE7E", "0X800AE7E", paramList.size(), 0, "", "", "", "");
  }
  
  public String getTag()
  {
    return "UpComingMsgLogic.AIOUpComingMsgHelper";
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(AIOUpComingMsgHelper.class);
      this.b = ((MessageRecord)paramMessage.obj);
      if (this.b == null)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), 2131697693, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getTitleBarHeight());
      }
      else
      {
        g();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRightRootVisibility(4);
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), (String)paramMessage.obj, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getTitleBarHeight());
      }
    }
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 14, 6, 8 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      c();
      return;
    case 6: 
      d();
      return;
    case 8: 
      a();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper
 * JD-Core Version:    0.7.0.1
 */