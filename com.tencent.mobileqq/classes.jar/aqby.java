import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqby
  extends aqbx
{
  public final String b;
  
  aqby(aqbz paramaqbz, int paramInt)
  {
    super(paramaqbz, paramInt);
    this.jdField_b_of_type_JavaLangString = "ExtendFriendLimitChatIdleStateHandler";
  }
  
  public void a(int paramInt)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "requestMatch id" + paramInt);
    Object localObject = new apyc();
    ((apyc)localObject).jdField_b_of_type_Int = paramInt;
    this.a.a(101, (apyc)localObject);
    localObject = (apwv)this.a.a.a(127);
    if (localObject != null)
    {
      int i = aqbb.a(this.a.a);
      ((apwv)localObject).a(this.a.a.getCurrentAccountUin(), i, paramInt);
    }
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCancelMatchMsg 取消匹配: " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, apyc paramapyc, String paramString)
  {
    if ((paramBoolean) && (paramapyc != null))
    {
      QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配 " + paramInt + paramapyc.toString());
      return;
    }
    paramapyc = paramString;
    if (paramString == null) {
      paramapyc = "";
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配失败 suc:" + paramBoolean + " ret:" + paramInt + " errMsg : " + paramapyc);
  }
  
  void a(boolean paramBoolean, apyc paramapyc)
  {
    if (paramapyc == null)
    {
      QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg null indo");
      return;
    }
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
    if (paramBoolean)
    {
      a(paramapyc.jdField_b_of_type_JavaLangString, paramapyc.jdField_a_of_type_JavaLangString, paramapyc.jdField_a_of_type_ArrayOfByte);
      c(paramapyc);
      a(paramapyc.jdField_b_of_type_JavaLangString, paramapyc.e);
      return;
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqby
 * JD-Core Version:    0.7.0.1
 */