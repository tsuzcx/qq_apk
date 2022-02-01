import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class axfy
{
  private static axfy jdField_a_of_type_Axfy;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public static axfy a()
  {
    if (jdField_a_of_type_Axfy == null) {}
    try
    {
      if (jdField_a_of_type_Axfy == null) {
        jdField_a_of_type_Axfy = new axfy();
      }
      return jdField_a_of_type_Axfy;
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
    Object localObject1 = new axhi();
    ((axhi)localObject1).c(localObject2[1]);
    ((axhi)localObject1).b(localObject2[0]);
    localObject2 = new ArrayList(2);
    if (this.jdField_a_of_type_Int == 1)
    {
      ((axhi)localObject1).a(axjd.a().b());
      ((List)localObject2).add(Integer.valueOf(axjd.a().d()));
      ((List)localObject2).add(Integer.valueOf(axjd.a().c()));
    }
    for (;;)
    {
      ((axhi)localObject1).a(4);
      ((axhi)localObject1).a((List)localObject2);
      localObject1 = ((axhi)localObject1).a();
      ((axfx)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(162)).a((MsgBackupUserData)localObject1, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupAuthProcessor", 2, "confirmQrReq, userData: " + localObject1 + ", biztype = " + this.jdField_a_of_type_Int + ", qr_sig = " + this.jdField_a_of_type_JavaLangString);
      }
      return;
      if (this.jdField_a_of_type_Int == 2)
      {
        ((axhi)localObject1).a(axjd.a().a());
        ((List)localObject2).add(Integer.valueOf(axjd.a().b()));
        ((List)localObject2).add(Integer.valueOf(axjd.a().a()));
      }
      else
      {
        ((axhi)localObject1).a(axjd.a().a());
        ((List)localObject2).add(Integer.valueOf(axjd.a().b()));
        ((List)localObject2).add(Integer.valueOf(axjd.a().a()));
      }
    }
  }
  
  public void a(int paramInt)
  {
    axjk.a();
    axjk.a.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject2 = a(BaseApplicationImpl.getContext());
    Object localObject1 = new axhi();
    ((axhi)localObject1).c(localObject2[1]);
    ((axhi)localObject1).b(localObject2[0]);
    localObject2 = new ArrayList(2);
    ((axhi)localObject1).a(axjd.a().b());
    ((List)localObject2).add(Integer.valueOf(axjd.a().d()));
    ((List)localObject2).add(Integer.valueOf(axjd.a().c()));
    ((axhi)localObject1).a(4);
    ((axhi)localObject1).a((List)localObject2);
    localObject1 = ((axhi)localObject1).a();
    ((axfx)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(162)).a((MsgBackupUserData)localObject1, this.jdField_a_of_type_Int, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupAuthProcessor", 2, "requestQR, userData: " + localObject1 + ", biztype = " + this.jdField_a_of_type_Int + ", ispush = " + paramBoolean);
    }
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axfy
 * JD-Core Version:    0.7.0.1
 */