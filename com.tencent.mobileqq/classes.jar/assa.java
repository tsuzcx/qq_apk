import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.MatchingStateHandler.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class assa
  extends asrw
  implements Handler.Callback
{
  public final int a;
  Handler a;
  public final int b;
  public final String b;
  private int jdField_c_of_type_Int = 101;
  private String jdField_c_of_type_JavaLangString = "";
  private int d = 1;
  
  assa(asry paramasry, int paramInt)
  {
    super(paramasry, paramInt);
    this.jdField_b_of_type_JavaLangString = "ExtendFriendLimitChatMatchingStateHandler";
    this.jdField_a_of_type_Int = 60;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Int = 1;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Asry != null)
    {
      this.jdField_a_of_type_Asry.a(100, null);
      c();
    }
    QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onFailedMatchPb  failedType：" + paramInt);
    if ((this.jdField_a_of_type_Asry != null) && (this.jdField_a_of_type_Asry.jdField_a_of_type_Asrz != null)) {
      this.jdField_a_of_type_Asry.jdField_a_of_type_Asrz.a(paramInt, null, "", paramString);
    }
  }
  
  private void c()
  {
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "clearMsg");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  private void d()
  {
    ThreadManager.getSubThreadHandler().post(new MatchingStateHandler.1(this));
  }
  
  public void a()
  {
    if ((this.jdField_c_of_type_Int == 101) || (this.jdField_c_of_type_Int == 104))
    {
      QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state REQUEST_MATCHING or WAIT_PUSH ");
      c();
      if (this.jdField_a_of_type_Asry != null)
      {
        aslm localaslm = (aslm)this.jdField_a_of_type_Asry.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        if (localaslm != null) {
          localaslm.a(this.jdField_a_of_type_Asry.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        this.jdField_a_of_type_Asry.a(100, null);
        return;
      }
      QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state machine is null");
      return;
    }
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state unknown!!" + this.jdField_c_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "requestMatch in matching state id:" + paramInt);
  }
  
  public void a(int paramInt, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCancelMatchMsg 取消匹配: " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, asne paramasne, String paramString)
  {
    long l2 = 60000L;
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg");
    long l1;
    if (paramBoolean)
    {
      if (paramInt == 0)
      {
        if ((paramasne != null) && (paramasne.a()))
        {
          QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg - 》 STATE_PROTO_AIO_OPEN matchinf:" + paramasne.toString());
          a(paramasne);
          a(paramasne.jdField_b_of_type_JavaLangString, paramasne.jdField_a_of_type_JavaLangString, paramasne.jdField_a_of_type_ArrayOfByte);
          a(paramasne.jdField_b_of_type_JavaLangString, paramasne.e);
          this.jdField_c_of_type_Int = 105;
          d();
          return;
        }
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg MatchInfo is wrong ");
        a(1, paramString);
        return;
      }
      if (paramInt == 1)
      {
        this.jdField_c_of_type_Int = 104;
        l1 = 30000L;
        if (paramasne != null)
        {
          l1 = paramasne.jdField_a_of_type_Int * 1000;
          if (60000L >= l1) {
            break label540;
          }
          l1 = l2;
        }
      }
    }
    label516:
    label522:
    label528:
    label540:
    for (;;)
    {
      a(1, l1);
      if (paramString == null) {}
      for (paramasne = "";; paramasne = paramString)
      {
        QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg - 》 STATE_PROTO_WAIT_PUSH  pushimte ：" + l1 + "tips errm:" + paramasne);
        this.jdField_c_of_type_JavaLangString = paramString;
        return;
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg STATE_PROTO_WAIT_PUSH but matchinfo  is wrong,push time use 30");
        break;
        if (paramInt == 3) {
          if (paramString != null) {
            break label528;
          }
        }
        for (paramasne = "";; paramasne = paramString)
        {
          QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg fail   ret is MatchOpRetCode_Security_Beat errmsg:" + paramasne);
          a(7, paramString);
          return;
          if (paramInt == 4) {
            if (paramString != null) {
              break label522;
            }
          }
          for (paramasne = "";; paramasne = paramString)
          {
            QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg fail   ret is MatchOpRetCode_Security_Limit errmsg:" + paramasne);
            a(8, paramString);
            return;
            if (paramInt == 2) {
              if (paramString != null) {
                break label516;
              }
            }
            for (paramasne = "";; paramasne = paramString)
            {
              QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg fail   ret is MatchOpRetCode_Security_Beat errmsg:" + paramasne);
              a(6, paramString);
              return;
              if (paramInt == 12) {
                if (paramString != null) {
                  break label510;
                }
              }
              label510:
              for (paramasne = "";; paramasne = paramString)
              {
                QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg fail   ret is MatchOpRetCode_No_Times errmsg:" + paramasne);
                a(9, paramString);
                return;
                if (paramString == null) {}
                for (paramasne = "";; paramasne = paramString)
                {
                  QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg RECODE = " + paramInt + " errMsg:" + paramasne);
                  a(1, paramString);
                  return;
                  QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg success = " + paramBoolean);
                  a(1, "");
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, asne paramasne)
  {
    if ((paramBoolean) && (paramasne != null) && (paramasne.jdField_b_of_type_Int != this.d))
    {
      a(paramasne.jdField_b_of_type_JavaLangString, paramasne.jdField_a_of_type_JavaLangString, paramasne.jdField_a_of_type_ArrayOfByte);
      c(paramasne);
      a(paramasne.jdField_b_of_type_JavaLangString, paramasne.e);
      QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "ON PUSH WITH PUSH TAG" + paramasne.jdField_b_of_type_Int + " wait id:" + this.d);
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (paramasne == null)
      {
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onPushMsg null indo");
        return;
      }
      QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onPushMsg ");
      if (!paramBoolean) {
        break label301;
      }
      a(paramasne.jdField_b_of_type_JavaLangString, paramasne.jdField_a_of_type_JavaLangString, paramasne.jdField_a_of_type_ArrayOfByte);
      a(paramasne);
      a(paramasne.jdField_b_of_type_JavaLangString, paramasne.e);
      if (this.jdField_c_of_type_Int != 104) {
        break;
      }
    } while (!paramasne.a());
    a(paramasne);
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "STATE_PROTO_WAIT_PUSH - 》 STATE_PROTO_AIO_OPEN matchinf:" + paramasne.toString());
    this.jdField_c_of_type_Int = 105;
    aslo localaslo = (aslo)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if ((localaslo != null) && (paramasne.jdField_a_of_type_Asmk != null) && (paramasne.jdField_a_of_type_Asmk.d == 1)) {
      localaslo.a();
    }
    d();
    return;
    QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "WAIT PUSH IN STATE: UN HANDLED" + this.jdField_c_of_type_Int + paramasne.toString());
    return;
    label301:
    a(2, this.jdField_c_of_type_JavaLangString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Asne.a();
    c();
  }
  
  public void b(asne paramasne)
  {
    this.jdField_a_of_type_Asne.a();
    if (paramasne != null)
    {
      a(paramasne);
      this.d = paramasne.jdField_b_of_type_Int;
    }
    this.jdField_c_of_type_Int = 101;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "超时 on timer TIMER_FOR_PUSH：" + this.jdField_a_of_type_Asne.toString());
      a();
      a(2, this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assa
 * JD-Core Version:    0.7.0.1
 */