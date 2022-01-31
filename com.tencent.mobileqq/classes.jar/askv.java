import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class askv
{
  private static askv jdField_a_of_type_Askv;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public static askv a()
  {
    if (jdField_a_of_type_Askv == null) {}
    try
    {
      if (jdField_a_of_type_Askv == null) {
        jdField_a_of_type_Askv = new askv();
      }
      return jdField_a_of_type_Askv;
    }
    finally {}
  }
  
  private String[] a(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext != null)
    {
      paramContext = paramContext.getConnectionInfo();
      arrayOfString[0] = paramContext.getSSID();
      arrayOfString[1] = paramContext.getBSSID();
    }
    return arrayOfString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    Object localObject2 = a(BaseApplicationImpl.getContext());
    Object localObject1 = new asmf();
    ((asmf)localObject1).c(localObject2[1]);
    ((asmf)localObject1).b(localObject2[0]);
    localObject2 = new ArrayList(2);
    if (this.jdField_a_of_type_Int == 1)
    {
      ((asmf)localObject1).a(asoi.a(asnz.a().d().ipv4));
      ((List)localObject2).add(Integer.valueOf(asnz.a().d().port));
      ((List)localObject2).add(Integer.valueOf(asnz.a().c().port));
    }
    for (;;)
    {
      ((asmf)localObject1).a(4);
      ((asmf)localObject1).a((List)localObject2);
      localObject1 = ((asmf)localObject1).a();
      ((asku)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(162)).a((MsgBackupUserData)localObject1, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupAuthProcessor", 2, "confirmQrReq, userData: " + localObject1 + ", biztype = " + this.jdField_a_of_type_Int + ", qr_sig = " + this.jdField_a_of_type_JavaLangString);
      }
      return;
      if (this.jdField_a_of_type_Int == 2)
      {
        ((asmf)localObject1).a(asoi.a(asnz.a().b().ipv4));
        ((List)localObject2).add(Integer.valueOf(asnz.a().b().port));
        ((List)localObject2).add(Integer.valueOf(asnz.a().a().port));
      }
      else
      {
        ((asmf)localObject1).a(asoi.a(asnz.a().b().ipv4));
        ((List)localObject2).add(Integer.valueOf(asnz.a().b().port));
        ((List)localObject2).add(Integer.valueOf(asnz.a().a().port));
      }
    }
  }
  
  public void a(int paramInt)
  {
    asog.a();
    asog.a.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject2 = a(BaseApplicationImpl.getContext());
    Object localObject1 = new asmf();
    ((asmf)localObject1).c(localObject2[1]);
    ((asmf)localObject1).b(localObject2[0]);
    localObject2 = new ArrayList(2);
    ((asmf)localObject1).a(asoi.a(asnz.a().d().ipv4));
    ((List)localObject2).add(Integer.valueOf(asnz.a().d().port));
    ((List)localObject2).add(Integer.valueOf(asnz.a().c().port));
    ((asmf)localObject1).a(4);
    ((asmf)localObject1).a((List)localObject2);
    localObject1 = ((asmf)localObject1).a();
    ((asku)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(162)).a((MsgBackupUserData)localObject1, this.jdField_a_of_type_Int, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupAuthProcessor", 2, "requestQR, userData: " + localObject1 + ", biztype = " + this.jdField_a_of_type_Int + ", ispush = " + paramBoolean);
    }
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     askv
 * JD-Core Version:    0.7.0.1
 */