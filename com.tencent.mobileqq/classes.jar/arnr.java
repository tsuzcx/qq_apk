import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arnr
  extends arnq
{
  public final String b;
  
  arnr(arns paramarns, int paramInt)
  {
    super(paramarns, paramInt);
    this.jdField_b_of_type_JavaLangString = "ExtendFriendLimitChatIdleStateHandler";
  }
  
  public void a(int paramInt)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "requestMatch id" + paramInt);
    Object localObject = new ariy();
    ((ariy)localObject).jdField_b_of_type_Int = paramInt;
    this.a.a(101, (ariy)localObject);
    localObject = (arhg)this.a.a.getBusinessHandler(127);
    if (localObject != null)
    {
      int i = armn.a(this.a.a);
      ((arhg)localObject).a(this.a.a.getCurrentAccountUin(), i, paramInt);
    }
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCancelMatchMsg 取消匹配: " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, ariy paramariy, String paramString)
  {
    if ((paramBoolean) && (paramariy != null))
    {
      QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配 " + paramInt + paramariy.toString());
      return;
    }
    paramariy = paramString;
    if (paramString == null) {
      paramariy = "";
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配失败 suc:" + paramBoolean + " ret:" + paramInt + " errMsg : " + paramariy);
  }
  
  void a(boolean paramBoolean, ariy paramariy)
  {
    if (paramariy == null)
    {
      QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg null indo");
      return;
    }
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
    if (paramBoolean)
    {
      a(paramariy.jdField_b_of_type_JavaLangString, paramariy.jdField_a_of_type_JavaLangString, paramariy.jdField_a_of_type_ArrayOfByte);
      c(paramariy);
      a(paramariy.jdField_b_of_type_JavaLangString, paramariy.e);
      return;
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arnr
 * JD-Core Version:    0.7.0.1
 */