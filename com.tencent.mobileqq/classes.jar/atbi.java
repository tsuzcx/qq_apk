import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.1;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class atbi
{
  private int a;
  public aswv a;
  public atbk a;
  public final String a;
  
  atbi(atbk paramatbk, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChat";
    this.jdField_a_of_type_Aswv = new aswv();
    this.jdField_a_of_type_Atbk = paramatbk;
    this.jdField_a_of_type_Aswv.a();
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
  
  public void a(aswv paramaswv)
  {
    this.jdField_a_of_type_Aswv.jdField_a_of_type_JavaLangString = paramaswv.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Aswv.jdField_a_of_type_ArrayOfByte = paramaswv.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_Aswv.jdField_b_of_type_JavaLangString = paramaswv.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Aswv.c = paramaswv.c;
    this.jdField_a_of_type_Aswv.jdField_a_of_type_Long = paramaswv.jdField_a_of_type_Long;
    this.jdField_a_of_type_Aswv.jdField_a_of_type_Int = paramaswv.jdField_a_of_type_Int;
    this.jdField_a_of_type_Aswv.e = paramaswv.e;
    this.jdField_a_of_type_Aswv.jdField_b_of_type_Int = paramaswv.jdField_b_of_type_Int;
    this.jdField_a_of_type_Aswv.f = paramaswv.f;
    this.jdField_a_of_type_Aswv.jdField_a_of_type_Aswb = paramaswv.jdField_a_of_type_Aswb;
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
    this.jdField_a_of_type_Atbk.a.a().c(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCScancelMatchMsg in wrong state!! " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, aswv paramaswv, String paramString)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCSRequestMsg in wrong state!!");
  }
  
  void a(boolean paramBoolean, aswv paramaswv)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onPushMsg in wrong state!!");
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aswv.a();
  }
  
  public void b(aswv paramaswv)
  {
    this.jdField_a_of_type_Aswv.a();
    if (paramaswv != null) {
      a(paramaswv);
    }
  }
  
  protected void c(aswv paramaswv)
  {
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.2(this, paramaswv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbi
 * JD-Core Version:    0.7.0.1
 */