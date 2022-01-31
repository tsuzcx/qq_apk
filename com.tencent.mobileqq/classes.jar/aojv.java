import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.1;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aojv
{
  private int a;
  public aofu a;
  public aojx a;
  public final String a;
  
  aojv(aojx paramaojx, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChat";
    this.jdField_a_of_type_Aofu = new aofu();
    this.jdField_a_of_type_Aojx = paramaojx;
    this.jdField_a_of_type_Aofu.a();
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
  
  public void a(aofu paramaofu)
  {
    this.jdField_a_of_type_Aofu.jdField_a_of_type_JavaLangString = paramaofu.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Aofu.jdField_a_of_type_ArrayOfByte = paramaofu.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_Aofu.jdField_b_of_type_JavaLangString = paramaofu.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Aofu.c = paramaofu.c;
    this.jdField_a_of_type_Aofu.jdField_a_of_type_Long = paramaofu.jdField_a_of_type_Long;
    this.jdField_a_of_type_Aofu.jdField_a_of_type_Int = paramaofu.jdField_a_of_type_Int;
    this.jdField_a_of_type_Aofu.e = paramaofu.e;
    this.jdField_a_of_type_Aofu.jdField_b_of_type_Int = paramaofu.jdField_b_of_type_Int;
    this.jdField_a_of_type_Aofu.f = paramaofu.f;
    this.jdField_a_of_type_Aofu.jdField_a_of_type_Aofh = paramaofu.jdField_a_of_type_Aofh;
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
    this.jdField_a_of_type_Aojx.a.a().c(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCScancelMatchMsg in wrong state!! " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, aofu paramaofu, String paramString)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCSRequestMsg in wrong state!!");
  }
  
  void a(boolean paramBoolean, aofu paramaofu)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onPushMsg in wrong state!!");
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aofu.a();
  }
  
  public void b(aofu paramaofu)
  {
    this.jdField_a_of_type_Aofu.a();
    if (paramaofu != null) {
      a(paramaofu);
    }
  }
  
  protected void c(aofu paramaofu)
  {
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.2(this, paramaofu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aojv
 * JD-Core Version:    0.7.0.1
 */