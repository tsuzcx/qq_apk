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

public class atjl
{
  private static atjl jdField_a_of_type_Atjl;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public static atjl a()
  {
    try
    {
      if (jdField_a_of_type_Atjl == null) {
        jdField_a_of_type_Atjl = new atjl();
      }
      atjl localatjl = jdField_a_of_type_Atjl;
      return localatjl;
    }
    finally {}
  }
  
  public long a()
  {
    atam localatam = (atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localatam.a() != null) {
      return localatam.a().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferDownloadConfig a()
  {
    atam localatam = (atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localatam.a() != null) {
      return localatam.a().a();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  public ExcitingTransferUploadChnConfigInfo a()
  {
    atam localatam = (atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localatam.a() != null) {
      return localatam.a().a();
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
          if (!bdvy.b(((EndPoint)localObject1).host)) {
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
    atam localatam = (atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localatam.a() != null) {
      return localatam.a().a();
    }
    return false;
  }
  
  public long b()
  {
    atam localatam = (atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localatam.a() != null) {
      return localatam.a().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferDownloadConfig b()
  {
    atam localatam = (atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localatam.a() != null) {
      return localatam.a().a();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  public ExcitingTransferUploadChnConfigInfo b()
  {
    atam localatam = (atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localatam.a() != null) {
      return localatam.a().a();
    }
    return new ExcitingTransferUploadChnConfigInfo();
  }
  
  public boolean b()
  {
    atam localatam = (atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localatam.a() != null) {
      return localatam.a().a();
    }
    return false;
  }
  
  public long c()
  {
    atam localatam = (atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localatam.a() != null) {
      return localatam.a().a();
    }
    return 20971520L;
  }
  
  public boolean c()
  {
    atam localatam = (atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localatam.a() != null) {
      return localatam.a().a();
    }
    return false;
  }
  
  public long d()
  {
    atam localatam = (atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localatam.a() != null) {
      return localatam.a().a();
    }
    return 20971520L;
  }
  
  public boolean d()
  {
    atam localatam = (atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localatam.a() != null) {
      return localatam.a().a();
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
 * Qualified Name:     atjl
 * JD-Core Version:    0.7.0.1
 */