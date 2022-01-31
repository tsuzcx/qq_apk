import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aojw
  extends aojv
{
  public final String b;
  
  aojw(aojx paramaojx, int paramInt)
  {
    super(paramaojx, paramInt);
    this.jdField_b_of_type_JavaLangString = "ExtendFriendLimitChatIdleStateHandler";
  }
  
  public void a(int paramInt)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "requestMatch id" + paramInt);
    Object localObject = new aofu();
    ((aofu)localObject).jdField_b_of_type_Int = paramInt;
    this.a.a(101, (aofu)localObject);
    localObject = (aoet)this.a.a.a(127);
    if (localObject != null)
    {
      int i = aojc.a(this.a.a);
      ((aoet)localObject).a(this.a.a.getCurrentAccountUin(), i, paramInt);
    }
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCancelMatchMsg 取消匹配: " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, aofu paramaofu, String paramString)
  {
    if ((paramBoolean) && (paramaofu != null))
    {
      QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配 " + paramInt + paramaofu.toString());
      return;
    }
    paramaofu = paramString;
    if (paramString == null) {
      paramaofu = "";
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配失败 suc:" + paramBoolean + " ret:" + paramInt + " errMsg : " + paramaofu);
  }
  
  void a(boolean paramBoolean, aofu paramaofu)
  {
    if (paramaofu == null)
    {
      QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg null indo");
      return;
    }
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
    if (paramBoolean)
    {
      a(paramaofu.jdField_b_of_type_JavaLangString, paramaofu.jdField_a_of_type_JavaLangString, paramaofu.jdField_a_of_type_ArrayOfByte);
      c(paramaofu);
      a(paramaofu.jdField_b_of_type_JavaLangString, paramaofu.e);
      return;
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aojw
 * JD-Core Version:    0.7.0.1
 */