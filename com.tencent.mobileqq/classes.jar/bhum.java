import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.QueryItemVersionCallback;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateEngineV2.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.ICmdManager;
import com.tencent.vas.update.callback.listener.ICmdListener;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.lang.ref.WeakReference;

public class bhum
  implements bhuj
{
  private bhuk jdField_a_of_type_Bhuk;
  private bhur jdField_a_of_type_Bhur;
  
  public bhum(QQAppInterface paramQQAppInterface)
  {
    try
    {
      this.jdField_a_of_type_Bhuk = ((bhuk)paramQQAppInterface.getManager(QQManagerFactory.QQ_VAS_UPDATE_MANAGER));
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      this.jdField_a_of_type_Bhuk = new bhuk(null);
    }
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString)
  {
    if ((this.jdField_a_of_type_Bhuk != null) && (this.jdField_a_of_type_Bhuk.getBusinessCallback(paramLong) != null)) {
      this.jdField_a_of_type_Bhuk.getBusinessCallback(paramLong).cancelDownload(paramString);
    }
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if ((this.jdField_a_of_type_Bhuk != null) && (this.jdField_a_of_type_Bhuk.getBusinessCallback(paramLong) != null))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramString1 = new BusinessUpdateParams(paramLong, paramArrayOfString[i], paramString2);
        this.jdField_a_of_type_Bhuk.getBusinessCallback(paramLong).startDownload(paramString1);
        i += 1;
      }
    }
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Bhuk != null) && (this.jdField_a_of_type_Bhuk.getBusinessCallback(paramLong) != null))
    {
      paramString1 = new BusinessUpdateParams(paramLong, paramString1, paramString2);
      this.jdField_a_of_type_Bhuk.getBusinessCallback(paramLong).startDownload(paramString1);
    }
  }
  
  public void onDestory()
  {
    this.jdField_a_of_type_Bhuk = null;
  }
  
  public void onPbMsgRecv(int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Bhur != null) && (this.jdField_a_of_type_Bhur.a() != null)) {
      this.jdField_a_of_type_Bhur.a().onPbResponse(paramInt, paramString1, paramString2);
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean, VasQuickUpdateManager.QueryItemVersionCallback paramQueryItemVersionCallback)
  {
    ThreadManagerV2.excute(new VasUpdateEngineV2.1(this, paramQueryItemVersionCallback, paramInt, paramString), 32, null, true);
  }
  
  public void setWeakHandler(WeakReference<VasExtensionHandler> paramWeakReference)
  {
    if (this.jdField_a_of_type_Bhuk == null) {}
    while (this.jdField_a_of_type_Bhuk.a() == null) {
      return;
    }
    ICmdManager localICmdManager = VasUpdateWrapper.getCmdManager();
    if ((localICmdManager == null) || (!(localICmdManager instanceof bhur)))
    {
      QLog.e("VasUpdate_VasUpdateEngineV2", 1, "setWeakHandler cmdManager == null or != VasCmdImpl");
      return;
    }
    this.jdField_a_of_type_Bhur = ((bhur)localICmdManager);
    this.jdField_a_of_type_Bhur.a(paramWeakReference);
  }
  
  public void startUpdateAllItem()
  {
    if (this.jdField_a_of_type_Bhuk != null) {
      this.jdField_a_of_type_Bhuk.updateAllItem();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhum
 * JD-Core Version:    0.7.0.1
 */