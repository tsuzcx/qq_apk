import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bnis
  extends QIPCModule
{
  private List<bnkt> a = new ArrayList();
  
  private bnis(String paramString)
  {
    super(paramString);
    this.a.add(bnkt.b);
    this.a.add(bnkt.c);
  }
  
  public static bnis a()
  {
    return bniw.a;
  }
  
  private void a(int paramInt)
  {
    QLog.d("AECMShowQipcModule", 1, " handleDownloadAERes ");
    bniv localbniv = new bniv(this, paramInt);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      bnkt localbnkt = (bnkt)localIterator.next();
      if (bnky.c(localbnkt))
      {
        bnrh.b("AECMShowQipcModule", "[handleDownloadAERes], resInfo=" + localbnkt + " local file exists");
        localbniv.onAEDownloadFinish(localbnkt, "", true, 0);
      }
      else
      {
        bnrh.b("AECMShowQipcModule", "[handleDownloadAERes], resInfo=" + localbnkt + " start download");
        bnku.a().a(localbnkt, localbniv, false);
      }
    }
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("key_resource_id_list"))) {}
    for (paramBundle = paramBundle.getStringArrayList("key_resource_id_list");; paramBundle = null)
    {
      if (CollectionUtils.isEmpty(paramBundle))
      {
        callbackResult(paramInt, EIPCResult.createResult(-102, null));
        return;
      }
      bnjd.a().a(paramBundle, new bniu(this, paramInt));
      return;
    }
  }
  
  public static void a(@Nullable EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("AECMShowQipcModule", "action_download_ae_res", null, paramEIPCResultCallback);
  }
  
  public static void a(@NonNull ArrayList<String> paramArrayList, @Nullable bnjf parambnjf)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("key_resource_id_list", paramArrayList);
    QIPCClientHelper.getInstance().callServer("AECMShowQipcModule", "action_download_essential_resource", localBundle, new bnit(parambnjf));
  }
  
  private void b(int paramInt)
  {
    int i = bnji.a().a();
    int j = bnji.a().b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_CMSHOW_IMG_MAX_LENGTH", Integer.valueOf(i));
    localHashMap.put("KEY_CMSHOW_IMG_QUALITY", Integer.valueOf(j));
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_request_image_param", localHashMap);
    callbackResult(paramInt, EIPCResult.createSuccessResult(localBundle));
  }
  
  public static void b(@Nullable EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("AECMShowQipcModule", "action_get_request_image_param", null, paramEIPCResultCallback);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_download_essential_resource".equals(paramString)) {
      a(paramBundle, paramInt);
    }
    for (;;)
    {
      return null;
      if ("action_download_ae_res".equals(paramString)) {
        a(paramInt);
      } else if ("action_get_request_image_param".equals(paramString)) {
        b(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnis
 * JD-Core Version:    0.7.0.1
 */