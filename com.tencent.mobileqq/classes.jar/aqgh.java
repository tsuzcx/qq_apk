import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqgh
  extends aqgg
{
  public final String b;
  
  aqgh(aqgi paramaqgi, int paramInt)
  {
    super(paramaqgi, paramInt);
    this.jdField_b_of_type_JavaLangString = "ExtendFriendLimitChatIdleStateHandler";
  }
  
  public void a(int paramInt)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "requestMatch id" + paramInt);
    Object localObject = new aqcl();
    ((aqcl)localObject).jdField_b_of_type_Int = paramInt;
    this.a.a(101, (aqcl)localObject);
    localObject = (aqbe)this.a.a.a(127);
    if (localObject != null)
    {
      int i = aqfk.a(this.a.a);
      ((aqbe)localObject).a(this.a.a.getCurrentAccountUin(), i, paramInt);
    }
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCancelMatchMsg 取消匹配: " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, aqcl paramaqcl, String paramString)
  {
    if ((paramBoolean) && (paramaqcl != null))
    {
      QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配 " + paramInt + paramaqcl.toString());
      return;
    }
    paramaqcl = paramString;
    if (paramString == null) {
      paramaqcl = "";
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配失败 suc:" + paramBoolean + " ret:" + paramInt + " errMsg : " + paramaqcl);
  }
  
  void a(boolean paramBoolean, aqcl paramaqcl)
  {
    if (paramaqcl == null)
    {
      QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg null indo");
      return;
    }
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
    if (paramBoolean)
    {
      a(paramaqcl.jdField_b_of_type_JavaLangString, paramaqcl.jdField_a_of_type_JavaLangString, paramaqcl.jdField_a_of_type_ArrayOfByte);
      c(paramaqcl);
      a(paramaqcl.jdField_b_of_type_JavaLangString, paramaqcl.e);
      return;
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgh
 * JD-Core Version:    0.7.0.1
 */