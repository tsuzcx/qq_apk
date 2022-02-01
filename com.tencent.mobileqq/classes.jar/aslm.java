import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aslm
  extends asll
{
  public final String b;
  
  aslm(asln paramasln, int paramInt)
  {
    super(paramasln, paramInt);
    this.jdField_b_of_type_JavaLangString = "ExtendFriendLimitChatIdleStateHandler";
  }
  
  public void a(int paramInt)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "requestMatch id" + paramInt);
    Object localObject = new ashh();
    ((ashh)localObject).jdField_b_of_type_Int = paramInt;
    this.a.a(101, (ashh)localObject);
    localObject = (asfs)this.a.a.a(127);
    if (localObject != null)
    {
      int i = askk.a(this.a.a);
      ((asfs)localObject).a(this.a.a.getCurrentAccountUin(), i, paramInt);
    }
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCancelMatchMsg 取消匹配: " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, ashh paramashh, String paramString)
  {
    if ((paramBoolean) && (paramashh != null))
    {
      QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配 " + paramInt + paramashh.toString());
      return;
    }
    paramashh = paramString;
    if (paramString == null) {
      paramashh = "";
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配失败 suc:" + paramBoolean + " ret:" + paramInt + " errMsg : " + paramashh);
  }
  
  void a(boolean paramBoolean, ashh paramashh)
  {
    if (paramashh == null)
    {
      QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg null indo");
      return;
    }
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
    if (paramBoolean)
    {
      a(paramashh.jdField_b_of_type_JavaLangString, paramashh.jdField_a_of_type_JavaLangString, paramashh.jdField_a_of_type_ArrayOfByte);
      c(paramashh);
      a(paramashh.jdField_b_of_type_JavaLangString, paramashh.e);
      return;
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslm
 * JD-Core Version:    0.7.0.1
 */