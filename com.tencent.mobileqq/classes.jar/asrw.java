import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.1;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class asrw
{
  private int a;
  public asne a;
  public asry a;
  public final String a;
  
  asrw(asry paramasry, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChat";
    this.jdField_a_of_type_Asne = new asne();
    this.jdField_a_of_type_Asry = paramasry;
    this.jdField_a_of_type_Asne.a();
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
  
  public void a(asne paramasne)
  {
    this.jdField_a_of_type_Asne.jdField_a_of_type_JavaLangString = paramasne.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Asne.jdField_a_of_type_ArrayOfByte = paramasne.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_Asne.jdField_b_of_type_JavaLangString = paramasne.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Asne.c = paramasne.c;
    this.jdField_a_of_type_Asne.jdField_a_of_type_Long = paramasne.jdField_a_of_type_Long;
    this.jdField_a_of_type_Asne.jdField_a_of_type_Int = paramasne.jdField_a_of_type_Int;
    this.jdField_a_of_type_Asne.e = paramasne.e;
    this.jdField_a_of_type_Asne.jdField_b_of_type_Int = paramasne.jdField_b_of_type_Int;
    this.jdField_a_of_type_Asne.f = paramasne.f;
    this.jdField_a_of_type_Asne.jdField_a_of_type_Asmk = paramasne.jdField_a_of_type_Asmk;
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
    this.jdField_a_of_type_Asry.a.getMsgCache().c(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCScancelMatchMsg in wrong state!! " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, asne paramasne, String paramString)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCSRequestMsg in wrong state!!");
  }
  
  void a(boolean paramBoolean, asne paramasne)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onPushMsg in wrong state!!");
  }
  
  public void b()
  {
    this.jdField_a_of_type_Asne.a();
  }
  
  public void b(asne paramasne)
  {
    this.jdField_a_of_type_Asne.a();
    if (paramasne != null) {
      a(paramasne);
    }
  }
  
  protected void c(asne paramasne)
  {
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.2(this, paramasne));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrw
 * JD-Core Version:    0.7.0.1
 */