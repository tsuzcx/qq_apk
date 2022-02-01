import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class asrx
  extends asrw
{
  public final String b;
  
  asrx(asry paramasry, int paramInt)
  {
    super(paramasry, paramInt);
    this.jdField_b_of_type_JavaLangString = "ExtendFriendLimitChatIdleStateHandler";
  }
  
  public void a(int paramInt)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "requestMatch id" + paramInt);
    Object localObject = new asne();
    ((asne)localObject).jdField_b_of_type_Int = paramInt;
    this.a.a(101, (asne)localObject);
    localObject = (aslm)this.a.a.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localObject != null)
    {
      int i = asqt.a(this.a.a);
      ((aslm)localObject).a(this.a.a.getCurrentAccountUin(), i, paramInt);
    }
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCancelMatchMsg 取消匹配: " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, asne paramasne, String paramString)
  {
    if ((paramBoolean) && (paramasne != null))
    {
      QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配 " + paramInt + paramasne.toString());
      return;
    }
    paramasne = paramString;
    if (paramString == null) {
      paramasne = "";
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配失败 suc:" + paramBoolean + " ret:" + paramInt + " errMsg : " + paramasne);
  }
  
  void a(boolean paramBoolean, asne paramasne)
  {
    if (paramasne == null)
    {
      QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg null indo");
      return;
    }
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
    if (paramBoolean)
    {
      a(paramasne.jdField_b_of_type_JavaLangString, paramasne.jdField_a_of_type_JavaLangString, paramasne.jdField_a_of_type_ArrayOfByte);
      c(paramasne);
      a(paramasne.jdField_b_of_type_JavaLangString, paramasne.e);
      return;
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrx
 * JD-Core Version:    0.7.0.1
 */