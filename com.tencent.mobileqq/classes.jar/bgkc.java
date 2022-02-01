import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.QueryItemVersionCallback;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateEngineProxy.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.entity.db.SeqConfigEntity;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;
import java.lang.ref.WeakReference;

public class bgkc
  implements bgka
{
  private bgka a;
  
  public bgkc(QQAppInterface paramQQAppInterface)
  {
    this.a = new bgkd(paramQQAppInterface);
  }
  
  private void a()
  {
    if (BaseApplicationImpl.getApplication().getSharedPreferences("quick_update_common", 0).getInt("isFirstMove", 0) == 0) {}
    try
    {
      bgkj localbgkj = (bgkj)((bgkb)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(374)).a().getDbManager();
      if (localbgkj != null) {
        localbgkj.a();
      }
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasUpdateEngineProxy", 2, "copySeqConfig");
    }
    VasUpdateWrapper.getCommonManager().copyFile(VasQuickUpdateEngine.ENGINE_CONFIG_PATH + File.separator + "seq.cfg", SeqConfigEntity.SEQ_CONFIG_PATH);
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString)
  {
    this.a.cancelDwonloadItem(paramLong, paramString);
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    this.a.downloadGatherItem(paramLong, paramString1, paramArrayOfString, paramString2);
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2)
  {
    this.a.downloadItem(paramLong, paramString1, paramString2);
  }
  
  public void onDestory()
  {
    this.a.onDestory();
  }
  
  public void onPbMsgRecv(int paramInt, String paramString1, String paramString2)
  {
    this.a.onPbMsgRecv(paramInt, paramString1, paramString2);
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean, VasQuickUpdateManager.QueryItemVersionCallback paramQueryItemVersionCallback)
  {
    this.a.queryItemVersion(paramInt, paramString, paramBoolean, paramQueryItemVersionCallback);
  }
  
  public void setWeakHandler(WeakReference<VasExtensionHandler> paramWeakReference)
  {
    this.a.setWeakHandler(paramWeakReference);
  }
  
  public void startUpdateAllItem()
  {
    ThreadManagerV2.excute(new VasUpdateEngineProxy.1(this), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkc
 * JD-Core Version:    0.7.0.1
 */