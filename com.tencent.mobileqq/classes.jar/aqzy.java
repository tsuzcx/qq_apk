import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqzy
{
  private static aqzy jdField_a_of_type_Aqzy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public static aqzy a()
  {
    try
    {
      if (jdField_a_of_type_Aqzy == null) {
        jdField_a_of_type_Aqzy = new aqzy();
      }
      aqzy localaqzy = jdField_a_of_type_Aqzy;
      return localaqzy;
    }
    finally {}
  }
  
  public long a()
  {
    aqpu localaqpu = (aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqpu.a() != null) {
      return localaqpu.a().a();
    }
    return 20971520L;
  }
  
  @Deprecated
  public ExcitingTransferDownloadConfig a()
  {
    return ((aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a().a();
  }
  
  public ExcitingTransferHostInfo a()
  {
    EndPoint localEndPoint = ConfigManager.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine()).getNextSrvAddr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (localEndPoint != null) {
      return new ExcitingTransferHostInfo(localEndPoint.host, localEndPoint.port);
    }
    return new ExcitingTransferHostInfo("", 0);
  }
  
  public ExcitingTransferUploadChnConfigInfo a()
  {
    aqpu localaqpu = (aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqpu.a() != null) {
      return localaqpu.a().a();
    }
    return new ExcitingTransferUploadChnConfigInfo();
  }
  
  public List<ExcitingTransferHostInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = ConfigManager.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine());
    if (localObject != null)
    {
      localObject = ((ConfigManager)localObject).getIpList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), false);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          EndPoint localEndPoint = (EndPoint)((Iterator)localObject).next();
          if ((localEndPoint != null) && (!TextUtils.isEmpty(localEndPoint.host))) {
            localArrayList.add(new ExcitingTransferHostInfo(localEndPoint.host, localEndPoint.port));
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public boolean a()
  {
    aqpu localaqpu = (aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqpu.a() != null) {
      return localaqpu.a().a();
    }
    return false;
  }
  
  public long b()
  {
    aqpu localaqpu = (aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqpu.a() != null) {
      return localaqpu.a().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferDownloadConfig b()
  {
    aqpu localaqpu = (aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqpu.a() != null) {
      return localaqpu.a().a();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  public ExcitingTransferUploadChnConfigInfo b()
  {
    aqpu localaqpu = (aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqpu.a() != null) {
      return localaqpu.a().a();
    }
    return new ExcitingTransferUploadChnConfigInfo();
  }
  
  public boolean b()
  {
    aqpu localaqpu = (aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqpu.a() != null) {
      return localaqpu.a().a();
    }
    return false;
  }
  
  public long c()
  {
    aqpu localaqpu = (aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqpu.a() != null) {
      return localaqpu.a().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferDownloadConfig c()
  {
    aqpu localaqpu = (aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqpu.a() != null) {
      return localaqpu.a().a();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  public boolean c()
  {
    aqpu localaqpu = (aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqpu.a() != null) {
      return localaqpu.a().a();
    }
    return false;
  }
  
  public long d()
  {
    aqpu localaqpu = (aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqpu.a() != null) {
      return localaqpu.a().a();
    }
    return 20971520L;
  }
  
  public boolean d()
  {
    aqpu localaqpu = (aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqpu.a() != null) {
      return localaqpu.a().a();
    }
    return false;
  }
  
  public long e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
  }
  
  @Deprecated
  public boolean e()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzy
 * JD-Core Version:    0.7.0.1
 */