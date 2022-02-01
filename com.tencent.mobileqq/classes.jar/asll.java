import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.1;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class asll
{
  private int a;
  public ashh a;
  public asln a;
  public final String a;
  
  asll(asln paramasln, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChat";
    this.jdField_a_of_type_Ashh = new ashh();
    this.jdField_a_of_type_Asln = paramasln;
    this.jdField_a_of_type_Ashh.a();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a()
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " cancelMatch in wrong state!!");
  }
  
  void a(int paramInt)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " requestMatch in wrong state!! id:" + paramInt);
  }
  
  public void a(ashh paramashh)
  {
    this.jdField_a_of_type_Ashh.jdField_a_of_type_JavaLangString = paramashh.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Ashh.jdField_a_of_type_ArrayOfByte = paramashh.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_Ashh.jdField_b_of_type_JavaLangString = paramashh.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Ashh.c = paramashh.c;
    this.jdField_a_of_type_Ashh.jdField_a_of_type_Long = paramashh.jdField_a_of_type_Long;
    this.jdField_a_of_type_Ashh.jdField_a_of_type_Int = paramashh.jdField_a_of_type_Int;
    this.jdField_a_of_type_Ashh.e = paramashh.e;
    this.jdField_a_of_type_Ashh.jdField_b_of_type_Int = paramashh.jdField_b_of_type_Int;
    this.jdField_a_of_type_Ashh.f = paramashh.f;
    this.jdField_a_of_type_Ashh.jdField_a_of_type_Asgn = paramashh.jdField_a_of_type_Asgn;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ExtendFriendLimitChat", 2, "saveMatchAlgorithmId UIN IS EMPTY");
      return;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = "0";
      QLog.e("ExtendFriendLimitChat", 2, "saveMatchAlgorithmId algorithmId IS EMPTY");
    }
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.1(this, paramString1, str));
  }
  
  protected void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Asln.a.a().c(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCScancelMatchMsg in wrong state!! " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, ashh paramashh, String paramString)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCSRequestMsg in wrong state!!");
  }
  
  void a(boolean paramBoolean, ashh paramashh)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onPushMsg in wrong state!!");
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ashh.a();
  }
  
  public void b(ashh paramashh)
  {
    this.jdField_a_of_type_Ashh.a();
    if (paramashh != null) {
      a(paramashh);
    }
  }
  
  protected void c(ashh paramashh)
  {
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.2(this, paramashh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asll
 * JD-Core Version:    0.7.0.1
 */