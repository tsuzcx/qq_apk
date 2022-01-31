import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.1;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aojq
{
  private int a;
  public aofp a;
  public aojs a;
  public final String a;
  
  aojq(aojs paramaojs, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChat";
    this.jdField_a_of_type_Aofp = new aofp();
    this.jdField_a_of_type_Aojs = paramaojs;
    this.jdField_a_of_type_Aofp.a();
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
  
  public void a(aofp paramaofp)
  {
    this.jdField_a_of_type_Aofp.jdField_a_of_type_JavaLangString = paramaofp.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Aofp.jdField_a_of_type_ArrayOfByte = paramaofp.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_Aofp.jdField_b_of_type_JavaLangString = paramaofp.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Aofp.c = paramaofp.c;
    this.jdField_a_of_type_Aofp.jdField_a_of_type_Long = paramaofp.jdField_a_of_type_Long;
    this.jdField_a_of_type_Aofp.jdField_a_of_type_Int = paramaofp.jdField_a_of_type_Int;
    this.jdField_a_of_type_Aofp.e = paramaofp.e;
    this.jdField_a_of_type_Aofp.jdField_b_of_type_Int = paramaofp.jdField_b_of_type_Int;
    this.jdField_a_of_type_Aofp.f = paramaofp.f;
    this.jdField_a_of_type_Aofp.jdField_a_of_type_Aofc = paramaofp.jdField_a_of_type_Aofc;
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
    this.jdField_a_of_type_Aojs.a.a().c(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCScancelMatchMsg in wrong state!! " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, aofp paramaofp, String paramString)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCSRequestMsg in wrong state!!");
  }
  
  void a(boolean paramBoolean, aofp paramaofp)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onPushMsg in wrong state!!");
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aofp.a();
  }
  
  public void b(aofp paramaofp)
  {
    this.jdField_a_of_type_Aofp.a();
    if (paramaofp != null) {
      a(paramaofp);
    }
  }
  
  protected void c(aofp paramaofp)
  {
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.2(this, paramaofp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aojq
 * JD-Core Version:    0.7.0.1
 */