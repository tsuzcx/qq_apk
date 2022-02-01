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

public class bjwy
{
  private static volatile bjwy jdField_a_of_type_Bjwy;
  private EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new bjwz(this);
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<bjwh>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  
  public static bjwy a()
  {
    if (jdField_a_of_type_Bjwy == null) {}
    try
    {
      if (jdField_a_of_type_Bjwy == null) {
        jdField_a_of_type_Bjwy = new bjwy();
      }
      return jdField_a_of_type_Bjwy;
    }
    finally {}
  }
  
  private String a(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  private void a(String paramString, bjwh parambjwh)
  {
    if ((TextUtils.isEmpty(paramString)) || (parambjwh == null)) {}
    List localList1;
    do
    {
      return;
      List localList2 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localList1 = localList2;
      if (localList2 == null) {
        localList1 = Collections.synchronizedList(new ArrayList());
      }
    } while (localList1.contains(parambjwh));
    localList1.add(parambjwh);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localList1);
  }
  
  public void a(String paramString, int paramInt, bjwh parambjwh)
  {
    a(a(paramString, paramInt), parambjwh);
    parambjwh = new Bundle();
    parambjwh.putString("PackageName", paramString);
    parambjwh.putInt("VersionCode", paramInt);
    bjtx.c("DownloaderGetCodeClient", paramString + "_" + paramInt + " begin getApkCode ......");
    this.jdField_a_of_type_JavaUtilMap.put(a(paramString, paramInt), Boolean.valueOf(true));
    QIPCClientHelper.getInstance().callServer("Module_DownloaderGetCodeServer", "DownloaderWriteCodeIPC_Action__GetCode", parambjwh, this.jdField_a_of_type_EipcEIPCResultCallback);
    ThreadManager.getSubThreadHandler().postDelayed(new DownloaderGetCodeClient.1(this, paramString, paramInt, parambjwh), 3000L);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, bjwh parambjwh)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.b.put(a(paramString2, paramInt), paramString1);
    }
    a(paramString2, paramInt, parambjwh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwy
 * JD-Core Version:    0.7.0.1
 */