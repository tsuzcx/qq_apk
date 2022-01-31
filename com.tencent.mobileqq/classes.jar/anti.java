import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.MatchingStateHandler.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class anti
  extends ante
  implements Handler.Callback
{
  public final int a;
  Handler a;
  public final int b;
  public final String b;
  private int jdField_c_of_type_Int = 101;
  private String jdField_c_of_type_JavaLangString = "";
  
  anti(antg paramantg, int paramInt)
  {
    super(paramantg, paramInt);
    this.jdField_b_of_type_JavaLangString = "ExtendFriendLimitChatMatchingStateHandler";
    this.jdField_a_of_type_Int = 60;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Int = 1;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Antg != null)
    {
      this.jdField_a_of_type_Antg.a(100, null);
      d();
    }
    QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onFailedMatchPb  failedType：" + paramInt);
    if ((this.jdField_a_of_type_Antg != null) && (this.jdField_a_of_type_Antg.jdField_a_of_type_Anth != null)) {
      this.jdField_a_of_type_Antg.jdField_a_of_type_Anth.a(paramInt, null, "", paramString);
    }
  }
  
  private void d()
  {
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "clearMsg");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  private void e()
  {
    ThreadManager.getSubThreadHandler().post(new MatchingStateHandler.1(this));
  }
  
  public void a()
  {
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "requestMatch in matching state");
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
  
  void a(boolean paramBoolean, int paramInt, anpe paramanpe, String paramString)
  {
    long l2 = 60000L;
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg");
    long l1;
    if (paramBoolean)
    {
      if (paramInt == 0)
      {
        if ((paramanpe != null) && (paramanpe.a()))
        {
          QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg - 》 STATE_PROTO_AIO_OPEN matchinf:" + paramanpe.toString());
          a(paramanpe);
          a(paramanpe.jdField_b_of_type_JavaLangString, paramanpe.jdField_a_of_type_JavaLangString, paramanpe.jdField_a_of_type_ArrayOfByte);
          a(paramanpe.jdField_b_of_type_JavaLangString, paramanpe.e);
          this.jdField_c_of_type_Int = 105;
          e();
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
        if (paramanpe != null)
        {
          l1 = paramanpe.jdField_a_of_type_Int * 1000;
          if (60000L >= l1) {
            break label433;
          }
          l1 = l2;
        }
      }
    }
    label415:
    label421:
    label433:
    for (;;)
    {
      a(1, l1);
      if (paramString == null) {}
      for (paramanpe = "";; paramanpe = paramString)
      {
        QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg - 》 STATE_PROTO_WAIT_PUSH  pushimte ：" + l1 + "tips errm:" + paramanpe);
        this.jdField_c_of_type_JavaLangString = paramString;
        return;
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg STATE_PROTO_WAIT_PUSH but matchinfo  is wrong,push time use 30");
        break;
        if (paramInt == 3) {
          if (paramString != null) {
            break label421;
          }
        }
        for (paramanpe = "";; paramanpe = paramString)
        {
          QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg fail   ret is MatchOpRetCode_Security_Beat errmsg:" + paramanpe);
          a(7, paramString);
          return;
          if (paramInt == 2) {
            if (paramString != null) {
              break label415;
            }
          }
          for (paramanpe = "";; paramanpe = paramString)
          {
            QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg fail   ret is MatchOpRetCode_Security_Beat errmsg:" + paramanpe);
            a(6, paramString);
            return;
            if (paramString == null) {}
            for (paramanpe = "";; paramanpe = paramString)
            {
              QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg RECODE = " + paramInt + " errMsg:" + paramanpe);
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
  
  public void a(boolean paramBoolean, anpe paramanpe)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (paramanpe == null) {
      QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onPushMsg null indo");
    }
    do
    {
      return;
      QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onPushMsg ");
      if (!paramBoolean) {
        break label162;
      }
      a(paramanpe.jdField_b_of_type_JavaLangString, paramanpe.jdField_a_of_type_JavaLangString, paramanpe.jdField_a_of_type_ArrayOfByte);
      a(paramanpe);
      a(paramanpe.jdField_b_of_type_JavaLangString, paramanpe.e);
      if (this.jdField_c_of_type_Int != 104) {
        break;
      }
    } while (!paramanpe.a());
    a(paramanpe);
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "STATE_PROTO_WAIT_PUSH - 》 STATE_PROTO_AIO_OPEN matchinf:" + paramanpe.toString());
    this.jdField_c_of_type_Int = 105;
    e();
    return;
    QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "WAIT PUSH IN STATE: UN HANDLED" + this.jdField_c_of_type_Int + paramanpe.toString());
    return;
    label162:
    a(2, this.jdField_c_of_type_JavaLangString);
  }
  
  public void b()
  {
    if ((this.jdField_c_of_type_Int == 101) || (this.jdField_c_of_type_Int == 104))
    {
      QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state REQUEST_MATCHING or WAIT_PUSH ");
      d();
      if (this.jdField_a_of_type_Antg != null)
      {
        anod localanod = (anod)this.jdField_a_of_type_Antg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127);
        if (localanod != null) {
          localanod.a(this.jdField_a_of_type_Antg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        this.jdField_a_of_type_Antg.a(100, null);
        return;
      }
      QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state machine is null");
      return;
    }
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state unknown!!" + this.jdField_c_of_type_Int);
  }
  
  public void b(anpe paramanpe)
  {
    this.jdField_a_of_type_Anpe.a();
    if (paramanpe != null) {
      a(paramanpe);
    }
    this.jdField_c_of_type_Int = 101;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Anpe.a();
    d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "超时 on timer TIMER_FOR_PUSH：" + this.jdField_a_of_type_Anpe.toString());
      b();
      a(2, this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anti
 * JD-Core Version:    0.7.0.1
 */