import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atrv
{
  private static atrv jdField_a_of_type_Atrv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public static atrv a()
  {
    try
    {
      if (jdField_a_of_type_Atrv == null) {
        jdField_a_of_type_Atrv = new atrv();
      }
      atrv localatrv = jdField_a_of_type_Atrv;
      return localatrv;
    }
    finally {}
  }
  
  public long a()
  {
    atix localatix = (atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
    if (localatix.a() != null) {
      return localatix.a().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferDownloadConfig a()
  {
    atix localatix = (atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
    if (localatix.a() != null) {
      return localatix.a().a();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  public ExcitingTransferUploadChnConfigInfo a()
  {
    atix localatix = (atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
    if (localatix.a() != null) {
      return localatix.a().a();
    }
    return new ExcitingTransferUploadChnConfigInfo();
  }
  
  public List<ExcitingTransferHostInfo> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ConfigManager.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine());
    if (localObject1 != null)
    {
      Object localObject2 = ((ConfigManager)localObject1).getIpList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), paramBoolean);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          EndPoint localEndPoint = (EndPoint)((Iterator)localObject2).next();
          if ((localEndPoint != null) && (!TextUtils.isEmpty(localEndPoint.host))) {
            if (paramBoolean) {
              localArrayList.add(new ExcitingTransferHostInfo("[" + localEndPoint.host + "]", localEndPoint.port));
            } else {
              localArrayList.add(new ExcitingTransferHostInfo(localEndPoint.host, localEndPoint.port));
            }
          }
        }
      }
      if (localArrayList.size() == 0)
      {
        localObject1 = ((ConfigManager)localObject1).getNextSrvAddr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBoolean);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((EndPoint)localObject1).host)))
        {
          if (!paramBoolean) {
            break label328;
          }
          if (!IPAddressUtil.isIPv6LiteralAddress(((EndPoint)localObject1).host)) {
            break label304;
          }
          localArrayList.add(new ExcitingTransferHostInfo("[" + ((EndPoint)localObject1).host + "]", ((EndPoint)localObject1).port));
        }
      }
    }
    return localArrayList;
    label304:
    localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject1).host, ((EndPoint)localObject1).port));
    return localArrayList;
    label328:
    localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject1).host, ((EndPoint)localObject1).port));
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
    atix localatix = (atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
    if (localatix.a() != null) {
      return localatix.a().a();
    }
    return false;
  }
  
  public long b()
  {
    atix localatix = (atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
    if (localatix.a() != null) {
      return localatix.a().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferDownloadConfig b()
  {
    atix localatix = (atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
    if (localatix.a() != null) {
      return localatix.a().a();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  public ExcitingTransferUploadChnConfigInfo b()
  {
    atix localatix = (atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
    if (localatix.a() != null) {
      return localatix.a().a();
    }
    return new ExcitingTransferUploadChnConfigInfo();
  }
  
  public boolean b()
  {
    atix localatix = (atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
    if (localatix.a() != null) {
      return localatix.a().a();
    }
    return false;
  }
  
  public long c()
  {
    atix localatix = (atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
    if (localatix.a() != null) {
      return localatix.a().a();
    }
    return 20971520L;
  }
  
  public boolean c()
  {
    atix localatix = (atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
    if (localatix.a() != null) {
      return localatix.a().a();
    }
    return false;
  }
  
  public long d()
  {
    atix localatix = (atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
    if (localatix.a() != null) {
      return localatix.a().a();
    }
    return 20971520L;
  }
  
  public boolean d()
  {
    atix localatix = (atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
    if (localatix.a() != null) {
      return localatix.a().a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrv
 * JD-Core Version:    0.7.0.1
 */