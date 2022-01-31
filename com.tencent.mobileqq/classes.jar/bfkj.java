import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.downloadnew.DownloaderGetCodeClient.1;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class bfkj
{
  private static volatile bfkj jdField_a_of_type_Bfkj;
  private EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new bfkk(this);
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<bfjr>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  
  public static bfkj a()
  {
    if (jdField_a_of_type_Bfkj == null) {}
    try
    {
      if (jdField_a_of_type_Bfkj == null) {
        jdField_a_of_type_Bfkj = new bfkj();
      }
      return jdField_a_of_type_Bfkj;
    }
    finally {}
  }
  
  private String a(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  private void a(String paramString, bfjr parambfjr)
  {
    if ((TextUtils.isEmpty(paramString)) || (parambfjr == null)) {}
    List localList1;
    do
    {
      return;
      List localList2 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localList1 = localList2;
      if (localList2 == null) {
        localList1 = Collections.synchronizedList(new ArrayList());
      }
    } while (localList1.contains(parambfjr));
    localList1.add(parambfjr);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localList1);
  }
  
  public void a(String paramString, int paramInt, bfjr parambfjr)
  {
    a(a(paramString, paramInt), parambfjr);
    parambfjr = new Bundle();
    parambfjr.putString("PackageName", paramString);
    parambfjr.putInt("VersionCode", paramInt);
    bfhg.c("DownloaderGetCodeClient", paramString + "_" + paramInt + " begin getApkCode ......");
    this.jdField_a_of_type_JavaUtilMap.put(a(paramString, paramInt), Boolean.valueOf(true));
    QIPCClientHelper.getInstance().callServer("Module_DownloaderGetCodeServer", "DownloaderWriteCodeIPC_Action__GetCode", parambfjr, this.jdField_a_of_type_EipcEIPCResultCallback);
    ThreadManager.getSubThreadHandler().postDelayed(new DownloaderGetCodeClient.1(this, paramString, paramInt, parambfjr), 3000L);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, bfjr parambfjr)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.b.put(a(paramString2, paramInt), paramString1);
    }
    a(paramString2, paramInt, parambfjr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfkj
 * JD-Core Version:    0.7.0.1
 */