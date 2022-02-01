import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class atbj
  extends atbi
{
  public final String b;
  
  atbj(atbk paramatbk, int paramInt)
  {
    super(paramatbk, paramInt);
    this.jdField_b_of_type_JavaLangString = "ExtendFriendLimitChatIdleStateHandler";
  }
  
  public void a(int paramInt)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "requestMatch id" + paramInt);
    Object localObject = new aswv();
    ((aswv)localObject).jdField_b_of_type_Int = paramInt;
    this.a.a(101, (aswv)localObject);
    localObject = (asvg)this.a.a.a(127);
    if (localObject != null)
    {
      int i = atag.a(this.a.a);
      ((asvg)localObject).a(this.a.a.getCurrentAccountUin(), i, paramInt);
    }
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCancelMatchMsg 取消匹配: " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, aswv paramaswv, String paramString)
  {
    if ((paramBoolean) && (paramaswv != null))
    {
      QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配 " + paramInt + paramaswv.toString());
      return;
    }
    paramaswv = paramString;
    if (paramString == null) {
      paramaswv = "";
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配失败 suc:" + paramBoolean + " ret:" + paramInt + " errMsg : " + paramaswv);
  }
  
  void a(boolean paramBoolean, aswv paramaswv)
  {
    if (paramaswv == null)
    {
      QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg null indo");
      return;
    }
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
    if (paramBoolean)
    {
      a(paramaswv.jdField_b_of_type_JavaLangString, paramaswv.jdField_a_of_type_JavaLangString, paramaswv.jdField_a_of_type_ArrayOfByte);
      c(paramaswv);
      a(paramaswv.jdField_b_of_type_JavaLangString, paramaswv.e);
      return;
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbj
 * JD-Core Version:    0.7.0.1
 */