import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.1;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aqgg
{
  private int a;
  public aqcl a;
  public aqgi a;
  public final String a;
  
  aqgg(aqgi paramaqgi, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChat";
    this.jdField_a_of_type_Aqcl = new aqcl();
    this.jdField_a_of_type_Aqgi = paramaqgi;
    this.jdField_a_of_type_Aqcl.a();
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
  
  public void a(aqcl paramaqcl)
  {
    this.jdField_a_of_type_Aqcl.jdField_a_of_type_JavaLangString = paramaqcl.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Aqcl.jdField_a_of_type_ArrayOfByte = paramaqcl.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_Aqcl.jdField_b_of_type_JavaLangString = paramaqcl.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Aqcl.c = paramaqcl.c;
    this.jdField_a_of_type_Aqcl.jdField_a_of_type_Long = paramaqcl.jdField_a_of_type_Long;
    this.jdField_a_of_type_Aqcl.jdField_a_of_type_Int = paramaqcl.jdField_a_of_type_Int;
    this.jdField_a_of_type_Aqcl.e = paramaqcl.e;
    this.jdField_a_of_type_Aqcl.jdField_b_of_type_Int = paramaqcl.jdField_b_of_type_Int;
    this.jdField_a_of_type_Aqcl.f = paramaqcl.f;
    this.jdField_a_of_type_Aqcl.jdField_a_of_type_Aqbt = paramaqcl.jdField_a_of_type_Aqbt;
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
    this.jdField_a_of_type_Aqgi.a.a().c(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCScancelMatchMsg in wrong state!! " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, aqcl paramaqcl, String paramString)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCSRequestMsg in wrong state!!");
  }
  
  void a(boolean paramBoolean, aqcl paramaqcl)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onPushMsg in wrong state!!");
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aqcl.a();
  }
  
  public void b(aqcl paramaqcl)
  {
    this.jdField_a_of_type_Aqcl.a();
    if (paramaqcl != null) {
      a(paramaqcl);
    }
  }
  
  protected void c(aqcl paramaqcl)
  {
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.2(this, paramaqcl));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgg
 * JD-Core Version:    0.7.0.1
 */