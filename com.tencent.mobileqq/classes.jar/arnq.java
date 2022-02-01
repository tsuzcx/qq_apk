import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.1;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class arnq
{
  private int a;
  public ariy a;
  public arns a;
  public final String a;
  
  arnq(arns paramarns, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChat";
    this.jdField_a_of_type_Ariy = new ariy();
    this.jdField_a_of_type_Arns = paramarns;
    this.jdField_a_of_type_Ariy.a();
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
  
  public void a(ariy paramariy)
  {
    this.jdField_a_of_type_Ariy.jdField_a_of_type_JavaLangString = paramariy.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Ariy.jdField_a_of_type_ArrayOfByte = paramariy.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_Ariy.jdField_b_of_type_JavaLangString = paramariy.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Ariy.c = paramariy.c;
    this.jdField_a_of_type_Ariy.jdField_a_of_type_Long = paramariy.jdField_a_of_type_Long;
    this.jdField_a_of_type_Ariy.jdField_a_of_type_Int = paramariy.jdField_a_of_type_Int;
    this.jdField_a_of_type_Ariy.e = paramariy.e;
    this.jdField_a_of_type_Ariy.jdField_b_of_type_Int = paramariy.jdField_b_of_type_Int;
    this.jdField_a_of_type_Ariy.f = paramariy.f;
    this.jdField_a_of_type_Ariy.jdField_a_of_type_Arie = paramariy.jdField_a_of_type_Arie;
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
    this.jdField_a_of_type_Arns.a.getMsgCache().c(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCScancelMatchMsg in wrong state!! " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, ariy paramariy, String paramString)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCSRequestMsg in wrong state!!");
  }
  
  void a(boolean paramBoolean, ariy paramariy)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onPushMsg in wrong state!!");
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ariy.a();
  }
  
  public void b(ariy paramariy)
  {
    this.jdField_a_of_type_Ariy.a();
    if (paramariy != null) {
      a(paramariy);
    }
  }
  
  protected void c(ariy paramariy)
  {
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.2(this, paramariy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arnq
 * JD-Core Version:    0.7.0.1
 */