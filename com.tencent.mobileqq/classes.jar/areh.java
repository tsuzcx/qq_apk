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

public class areh
{
  private static areh jdField_a_of_type_Areh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public static areh a()
  {
    try
    {
      if (jdField_a_of_type_Areh == null) {
        jdField_a_of_type_Areh = new areh();
      }
      areh localareh = jdField_a_of_type_Areh;
      return localareh;
    }
    finally {}
  }
  
  public long a()
  {
    aqud localaqud = (aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqud.a() != null) {
      return localaqud.a().a();
    }
    return 20971520L;
  }
  
  @Deprecated
  public ExcitingTransferDownloadConfig a()
  {
    return ((aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a().a();
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
    aqud localaqud = (aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqud.a() != null) {
      return localaqud.a().a();
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
    aqud localaqud = (aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqud.a() != null) {
      return localaqud.a().a();
    }
    return false;
  }
  
  public long b()
  {
    aqud localaqud = (aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqud.a() != null) {
      return localaqud.a().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferDownloadConfig b()
  {
    aqud localaqud = (aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqud.a() != null) {
      return localaqud.a().a();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  public ExcitingTransferUploadChnConfigInfo b()
  {
    aqud localaqud = (aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqud.a() != null) {
      return localaqud.a().a();
    }
    return new ExcitingTransferUploadChnConfigInfo();
  }
  
  public boolean b()
  {
    aqud localaqud = (aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqud.a() != null) {
      return localaqud.a().a();
    }
    return false;
  }
  
  public long c()
  {
    aqud localaqud = (aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqud.a() != null) {
      return localaqud.a().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferDownloadConfig c()
  {
    aqud localaqud = (aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqud.a() != null) {
      return localaqud.a().a();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  public boolean c()
  {
    aqud localaqud = (aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqud.a() != null) {
      return localaqud.a().a();
    }
    return false;
  }
  
  public long d()
  {
    aqud localaqud = (aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqud.a() != null) {
      return localaqud.a().a();
    }
    return 20971520L;
  }
  
  public boolean d()
  {
    aqud localaqud = (aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaqud.a() != null) {
      return localaqud.a().a();
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
 * Qualified Name:     areh
 * JD-Core Version:    0.7.0.1
 */