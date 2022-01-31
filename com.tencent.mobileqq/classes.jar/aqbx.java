import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.1;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aqbx
{
  private int a;
  public apyc a;
  public aqbz a;
  public final String a;
  
  aqbx(aqbz paramaqbz, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChat";
    this.jdField_a_of_type_Apyc = new apyc();
    this.jdField_a_of_type_Aqbz = paramaqbz;
    this.jdField_a_of_type_Apyc.a();
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
  
  public void a(apyc paramapyc)
  {
    this.jdField_a_of_type_Apyc.jdField_a_of_type_JavaLangString = paramapyc.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Apyc.jdField_a_of_type_ArrayOfByte = paramapyc.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_Apyc.jdField_b_of_type_JavaLangString = paramapyc.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Apyc.c = paramapyc.c;
    this.jdField_a_of_type_Apyc.jdField_a_of_type_Long = paramapyc.jdField_a_of_type_Long;
    this.jdField_a_of_type_Apyc.jdField_a_of_type_Int = paramapyc.jdField_a_of_type_Int;
    this.jdField_a_of_type_Apyc.e = paramapyc.e;
    this.jdField_a_of_type_Apyc.jdField_b_of_type_Int = paramapyc.jdField_b_of_type_Int;
    this.jdField_a_of_type_Apyc.f = paramapyc.f;
    this.jdField_a_of_type_Apyc.jdField_a_of_type_Apxk = paramapyc.jdField_a_of_type_Apxk;
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
    this.jdField_a_of_type_Aqbz.a.a().c(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCScancelMatchMsg in wrong state!! " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, apyc paramapyc, String paramString)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCSRequestMsg in wrong state!!");
  }
  
  void a(boolean paramBoolean, apyc paramapyc)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onPushMsg in wrong state!!");
  }
  
  public void b()
  {
    this.jdField_a_of_type_Apyc.a();
  }
  
  public void b(apyc paramapyc)
  {
    this.jdField_a_of_type_Apyc.a();
    if (paramapyc != null) {
      a(paramapyc);
    }
  }
  
  protected void c(apyc paramapyc)
  {
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.2(this, paramapyc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbx
 * JD-Core Version:    0.7.0.1
 */