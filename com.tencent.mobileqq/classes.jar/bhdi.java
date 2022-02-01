import com.tencent.mobileqq.app.QQAppInterface;
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

public class bhdi
  implements bhdf
{
  private bhdg jdField_a_of_type_Bhdg;
  private bhdm jdField_a_of_type_Bhdm;
  
  public bhdi(QQAppInterface paramQQAppInterface)
  {
    try
    {
      this.jdField_a_of_type_Bhdg = ((bhdg)paramQQAppInterface.getManager(374));
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      this.jdField_a_of_type_Bhdg = new bhdg(null);
    }
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString)
  {
    if ((this.jdField_a_of_type_Bhdg != null) && (this.jdField_a_of_type_Bhdg.getBusinessCallback(paramLong) != null)) {
      this.jdField_a_of_type_Bhdg.getBusinessCallback(paramLong).cancelDownload(paramString);
    }
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if ((this.jdField_a_of_type_Bhdg != null) && (this.jdField_a_of_type_Bhdg.getBusinessCallback(paramLong) != null))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramString1 = new BusinessUpdateParams(paramLong, paramArrayOfString[i], paramString2);
        this.jdField_a_of_type_Bhdg.getBusinessCallback(paramLong).startDownload(paramString1);
        i += 1;
      }
    }
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Bhdg != null) && (this.jdField_a_of_type_Bhdg.getBusinessCallback(paramLong) != null))
    {
      paramString1 = new BusinessUpdateParams(paramLong, paramString1, paramString2);
      this.jdField_a_of_type_Bhdg.getBusinessCallback(paramLong).startDownload(paramString1);
    }
  }
  
  public void onDestory()
  {
    this.jdField_a_of_type_Bhdg = null;
  }
  
  public void onPbMsgRecv(int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Bhdm != null) && (this.jdField_a_of_type_Bhdm.a() != null)) {
      this.jdField_a_of_type_Bhdm.a().onPbResponse(paramInt, paramString1, paramString2);
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean, VasQuickUpdateManager.QueryItemVersionCallback paramQueryItemVersionCallback)
  {
    ThreadManagerV2.excute(new VasUpdateEngineV2.1(this, paramQueryItemVersionCallback, paramInt, paramString), 32, null, true);
  }
  
  public void setWeakHandler(WeakReference<VasExtensionHandler> paramWeakReference)
  {
    if (this.jdField_a_of_type_Bhdg == null) {}
    while (this.jdField_a_of_type_Bhdg.a() == null) {
      return;
    }
    ICmdManager localICmdManager = VasUpdateWrapper.getCmdManager();
    if ((localICmdManager == null) || (!(localICmdManager instanceof bhdm)))
    {
      QLog.e("VasUpdate_VasUpdateEngineV2", 1, "setWeakHandler cmdManager == null or != VasCmdImpl");
      return;
    }
    this.jdField_a_of_type_Bhdm = ((bhdm)localICmdManager);
    this.jdField_a_of_type_Bhdm.a(paramWeakReference);
  }
  
  public void startUpdateAllItem()
  {
    if (this.jdField_a_of_type_Bhdg != null) {
      this.jdField_a_of_type_Bhdg.updateAllItem();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdi
 * JD-Core Version:    0.7.0.1
 */