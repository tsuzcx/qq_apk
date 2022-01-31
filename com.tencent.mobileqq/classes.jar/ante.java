import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ante
{
  private int a;
  public anpe a;
  public antg a;
  public final String a;
  
  ante(antg paramantg, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChat";
    this.jdField_a_of_type_Anpe = new anpe();
    this.jdField_a_of_type_Antg = paramantg;
    this.jdField_a_of_type_Anpe.a();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a()
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " requestMatch in wrong state!!");
  }
  
  public void a(anpe paramanpe)
  {
    this.jdField_a_of_type_Anpe.jdField_a_of_type_JavaLangString = paramanpe.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Anpe.jdField_a_of_type_ArrayOfByte = paramanpe.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_Anpe.b = paramanpe.b;
    this.jdField_a_of_type_Anpe.c = paramanpe.c;
    this.jdField_a_of_type_Anpe.jdField_a_of_type_Long = paramanpe.jdField_a_of_type_Long;
    this.jdField_a_of_type_Anpe.jdField_a_of_type_Int = paramanpe.jdField_a_of_type_Int;
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
    this.jdField_a_of_type_Antg.a.a().c(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCScancelMatchMsg in wrong state!! " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, anpe paramanpe, String paramString)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCSRequestMsg in wrong state!!");
  }
  
  void a(boolean paramBoolean, anpe paramanpe)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onPushMsg in wrong state!!");
  }
  
  void b()
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " cancelMatch in wrong state!!");
  }
  
  public void b(anpe paramanpe)
  {
    this.jdField_a_of_type_Anpe.a();
    if (paramanpe != null) {
      a(paramanpe);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Anpe.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ante
 * JD-Core Version:    0.7.0.1
 */