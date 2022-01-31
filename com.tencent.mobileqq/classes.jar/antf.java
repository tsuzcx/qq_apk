import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.IdleStateHandler.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class antf
  extends ante
{
  public final String b = "ExtendFriendLimitChatIdleStateHandler";
  
  antf(antg paramantg, int paramInt)
  {
    super(paramantg, paramInt);
  }
  
  private void c(anpe paramanpe)
  {
    ThreadManager.getSubThreadHandler().post(new IdleStateHandler.1(this, paramanpe));
  }
  
  public void a()
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "requestMatch");
    this.a.a(101, null);
    anod localanod = (anod)this.a.a.a(127);
    if (localanod != null)
    {
      int i = ansl.a(this.a.a);
      localanod.a(this.a.a.getCurrentAccountUin(), i);
    }
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCancelMatchMsg 取消匹配: " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, anpe paramanpe, String paramString)
  {
    if ((paramBoolean) && (paramanpe != null))
    {
      QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配 " + paramInt + paramanpe.toString());
      return;
    }
    paramanpe = paramString;
    if (paramString == null) {
      paramanpe = "";
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配失败 suc:" + paramBoolean + " ret:" + paramInt + " errMsg : " + paramanpe);
  }
  
  void a(boolean paramBoolean, anpe paramanpe)
  {
    if (paramanpe == null)
    {
      QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg null indo");
      return;
    }
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
    if (paramBoolean)
    {
      a(paramanpe.b, paramanpe.jdField_a_of_type_JavaLangString, paramanpe.jdField_a_of_type_ArrayOfByte);
      c(paramanpe);
      a(paramanpe.b, paramanpe.e);
      return;
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     antf
 * JD-Core Version:    0.7.0.1
 */