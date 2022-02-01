import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class azvb
  implements azus
{
  private static azvb jdField_a_of_type_Azvb;
  private azut jdField_a_of_type_Azut;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new azvc(this, "PrecoverIPCServer_MODEL");
  
  private azvb()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_Azut = ((azut)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(179));
      this.jdField_a_of_type_Azut.a().a(this);
    }
  }
  
  public static azvb a()
  {
    if (jdField_a_of_type_Azvb == null) {}
    try
    {
      if (jdField_a_of_type_Azvb == null) {
        jdField_a_of_type_Azvb = new azvb();
      }
      return jdField_a_of_type_Azvb;
    }
    finally {}
  }
  
  private EIPCResult a(Bundle paramBundle, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = paramBundle.getString("businessId");
    String str = paramBundle.getString("md5");
    if (TextUtils.isEmpty(str))
    {
      localObject1 = EIPCResult.createResult(10, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverIPCServer", 2, "getResource, md5 emtpy");
      }
      paramBundle.putInt("callbackId", paramInt);
      return localObject1;
    }
    if (this.jdField_a_of_type_Azut != null)
    {
      localObject1 = this.jdField_a_of_type_Azut.a((String)localObject2, str);
      if (localObject1 == null) {
        break label100;
      }
      paramBundle.putParcelable("resource", (Parcelable)localObject1);
      localObject1 = EIPCResult.createSuccessResult(paramBundle);
    }
    for (;;)
    {
      paramBundle.putInt("callbackId", paramInt);
      return localObject1;
      label100:
      localObject2 = EIPCResult.createResult(12, paramBundle);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverIPCServer", 2, "getResource, RESULT_RESOURCE_NOT_FOUND");
        localObject1 = localObject2;
      }
    }
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
  
  public void a(int paramInt, String paramString, PrecoverResource paramPrecoverResource, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])) && ("PrecoverIPCServer_MODEL".equals(((Object[])(Object[])paramObject)[0])))
    {
      int i = ((Integer)((Object[])(Object[])paramObject)[1]).intValue();
      paramObject = new Bundle();
      paramObject.putString("key_action", azva.b);
      paramObject.putParcelable("resource", paramPrecoverResource);
      paramObject.putInt("errCode", paramInt);
      paramObject.putString("errDesc", paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverIPCServer", 2, "onDownloadFinish, errCode=" + paramInt + ", errDesc=" + paramString + ", resource" + paramPrecoverResource);
      }
      this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule.callbackResult(i, EIPCResult.createSuccessResult(paramObject));
    }
  }
  
  public void a(PrecoverResource paramPrecoverResource, Object paramObject, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvb
 * JD-Core Version:    0.7.0.1
 */