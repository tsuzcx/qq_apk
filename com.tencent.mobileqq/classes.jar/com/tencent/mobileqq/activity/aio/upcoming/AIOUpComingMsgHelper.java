package com.tencent.mobileqq.activity.aio.upcoming;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.FriendScroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberInfoHandler;
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
  private ColorNoteCurd jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd;
  private OnColorNoteCurdListener jdField_a_of_type_ComTencentMobileqqColornoteOnColorNoteCurdListener = new AIOUpComingMsgHelper.5(this);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      Object localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
      localMessage.what = 2;
      if (localObject != null)
      {
        if (((HotChatInfo)localObject).state == 6) {
          localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getResources().getString(2131689976);
        } else if (((HotChatInfo)localObject).state == 7) {
          localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getResources().getString(2131689982);
        }
      }
      else
      {
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("");
          paramString = ((TroopManager)localObject).a(localStringBuilder.toString(), true);
          if (paramString != null)
          {
            if ((!paramString.isKicked()) && (!paramString.isExited()))
            {
              if (paramString.isDisband()) {
                localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getResources().getString(2131689982);
              }
            }
            else {
              localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getResources().getString(2131689976);
            }
          }
          else {
            localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getResources().getString(2131689976);
          }
        }
      }
      if (localMessage.obj != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      }
    }
  }
  
  private void b()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(AIOUpComingMsgHelper.class);
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
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        ArrayList localArrayList = new ArrayList();
        if (1 == paramInt)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq != ((MessageRecord)paramList.get(0)).uniseq) {
            localArrayList.add(paramList.get(0));
          }
        }
        else
        {
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
            if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq != localMessageRecord.uniseq) {
              localArrayList.add(paramList.get(0));
            }
          }
        }
        if (!localArrayList.isEmpty())
        {
          a(paramList, paramLong, paramInt);
          return;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), 1, 2131689960, 0).a();
        return;
      }
      a(paramList, paramLong, paramInt);
    }
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
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(this.jdField_a_of_type_ComTencentMobileqqColornoteOnColorNoteCurdListener);
    }
  }
  
  private void g()
  {
    if ((this.b != null) && (this.jdField_a_of_type_Boolean))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((localObject instanceof FriendChatPie))
      {
        ((FriendScroller)((BaseChatPie)localObject).b().a().a()).a(22, this.b.msgUid, this.b.time);
      }
      else if (((BaseChatPie)localObject).e())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a().a().a(22, this.b.shmsgseq, (int)(((MessageRecord)localObject).shmsgseq - this.b.shmsgseq));
      }
      this.jdField_a_of_type_Boolean = false;
      this.b = null;
    }
  }
  
  ColorNote a(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingMultiColorNoteGenerator == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingMultiColorNoteGenerator = new MultiColorNoteGenerator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingMultiColorNoteGenerator.a(paramList, paramLong, 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingMultiColorNoteGenerator == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingMultiColorNoteGenerator = new MultiColorNoteGenerator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingMultiColorNoteGenerator.a(paramList, paramLong, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692183, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    }
    Object localObject1 = MultiMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramList);
    if (localObject1 != null)
    {
      if (((ArrayList)localObject1).size() == 0) {
        return;
      }
      MultiMsgManager.a().b((List)localObject1);
      if (QLog.isDevelopLevel())
      {
        paramList = new StringBuilder();
        paramList.append("multiForwardTogether|checklist.size = ");
        paramList.append(((ArrayList)localObject1).size());
        QLog.d("MultiMsg_TAG", 4, paramList.toString());
      }
      if (((ArrayList)localObject1).size() == 0) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c(2131698525);
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
        ((ITroopMemberInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList, false, null);
      } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendNickByBatch(paramList);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
      localObject2 = ((MqqHandler)localObject1).obtainMessage(24);
      ((Message)localObject2).arg1 = paramList.size();
      ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject2, 30000L);
    }
  }
  
  public void a(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    f();
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(0, "update_process_state", false);
    if (!this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a())
    {
      ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).showFullDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    }
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
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
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRightRootVisibility(4);
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), (String)paramMessage.obj, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getTitleBarHeight());
      return true;
    }
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(AIOUpComingMsgHelper.class);
    this.b = ((MessageRecord)paramMessage.obj);
    if (this.b == null)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), 2131697699, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getTitleBarHeight());
      return true;
    }
    g();
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15, 7, 9 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 7)
      {
        if (paramInt != 9)
        {
          if (paramInt != 15) {
            return;
          }
          b();
          return;
        }
        a();
        return;
      }
      d();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper
 * JD-Core Version:    0.7.0.1
 */