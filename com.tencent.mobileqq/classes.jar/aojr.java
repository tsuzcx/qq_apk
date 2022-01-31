import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aojr
  extends aojq
{
  public final String b;
  
  aojr(aojs paramaojs, int paramInt)
  {
    super(paramaojs, paramInt);
    this.jdField_b_of_type_JavaLangString = "ExtendFriendLimitChatIdleStateHandler";
  }
  
  public void a(int paramInt)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "requestMatch id" + paramInt);
    Object localObject = new aofp();
    ((aofp)localObject).jdField_b_of_type_Int = paramInt;
    this.a.a(101, (aofp)localObject);
    localObject = (aoeo)this.a.a.a(127);
    if (localObject != null)
    {
      int i = aoix.a(this.a.a);
      ((aoeo)localObject).a(this.a.a.getCurrentAccountUin(), i, paramInt);
    }
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCancelMatchMsg 取消匹配: " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, aofp paramaofp, String paramString)
  {
    if ((paramBoolean) && (paramaofp != null))
    {
      QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配 " + paramInt + paramaofp.toString());
      return;
    }
    paramaofp = paramString;
    if (paramString == null) {
      paramaofp = "";
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配失败 suc:" + paramBoolean + " ret:" + paramInt + " errMsg : " + paramaofp);
  }
  
  void a(boolean paramBoolean, aofp paramaofp)
  {
    if (paramaofp == null)
    {
      QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg null indo");
      return;
    }
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
    if (paramBoolean)
    {
      a(paramaofp.jdField_b_of_type_JavaLangString, paramaofp.jdField_a_of_type_JavaLangString, paramaofp.jdField_a_of_type_ArrayOfByte);
      c(paramaofp);
      a(paramaofp.jdField_b_of_type_JavaLangString, paramaofp.e);
      return;
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aojr
 * JD-Core Version:    0.7.0.1
 */