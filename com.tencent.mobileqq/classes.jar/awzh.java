import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class awzh
{
  private static awzh jdField_a_of_type_Awzh;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public static awzh a()
  {
    if (jdField_a_of_type_Awzh == null) {}
    try
    {
      if (jdField_a_of_type_Awzh == null) {
        jdField_a_of_type_Awzh = new awzh();
      }
      return jdField_a_of_type_Awzh;
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
    Object localObject1 = new axar();
    ((axar)localObject1).c(localObject2[1]);
    ((axar)localObject1).b(localObject2[0]);
    localObject2 = new ArrayList(2);
    if (this.jdField_a_of_type_Int == 1)
    {
      ((axar)localObject1).a(axcm.a().b());
      ((List)localObject2).add(Integer.valueOf(axcm.a().d()));
      ((List)localObject2).add(Integer.valueOf(axcm.a().c()));
    }
    for (;;)
    {
      ((axar)localObject1).a(4);
      ((axar)localObject1).a((List)localObject2);
      localObject1 = ((axar)localObject1).a();
      ((awzg)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.MSG_BACK_UP_HANDLER)).a((MsgBackupUserData)localObject1, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupAuthProcessor", 2, "confirmQrReq, userData: " + localObject1 + ", biztype = " + this.jdField_a_of_type_Int + ", qr_sig = " + this.jdField_a_of_type_JavaLangString);
      }
      return;
      if (this.jdField_a_of_type_Int == 2)
      {
        ((axar)localObject1).a(axcm.a().a());
        ((List)localObject2).add(Integer.valueOf(axcm.a().b()));
        ((List)localObject2).add(Integer.valueOf(axcm.a().a()));
      }
      else
      {
        ((axar)localObject1).a(axcm.a().a());
        ((List)localObject2).add(Integer.valueOf(axcm.a().b()));
        ((List)localObject2).add(Integer.valueOf(axcm.a().a()));
      }
    }
  }
  
  public void a(int paramInt)
  {
    axct.a();
    axct.a.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject2 = a(BaseApplicationImpl.getContext());
    Object localObject1 = new axar();
    ((axar)localObject1).c(localObject2[1]);
    ((axar)localObject1).b(localObject2[0]);
    localObject2 = new ArrayList(2);
    ((axar)localObject1).a(axcm.a().b());
    ((List)localObject2).add(Integer.valueOf(axcm.a().d()));
    ((List)localObject2).add(Integer.valueOf(axcm.a().c()));
    ((axar)localObject1).a(4);
    ((axar)localObject1).a((List)localObject2);
    localObject1 = ((axar)localObject1).a();
    ((awzg)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.MSG_BACK_UP_HANDLER)).a((MsgBackupUserData)localObject1, this.jdField_a_of_type_Int, paramBoolean);
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
 * Qualified Name:     awzh
 * JD-Core Version:    0.7.0.1
 */