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

public class bcgw
{
  private static volatile bcgw jdField_a_of_type_Bcgw;
  private EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new bcgx(this);
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<bcge>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  
  public static bcgw a()
  {
    if (jdField_a_of_type_Bcgw == null) {}
    try
    {
      if (jdField_a_of_type_Bcgw == null) {
        jdField_a_of_type_Bcgw = new bcgw();
      }
      return jdField_a_of_type_Bcgw;
    }
    finally {}
  }
  
  private String a(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  private void a(String paramString, bcge parambcge)
  {
    if ((TextUtils.isEmpty(paramString)) || (parambcge == null)) {}
    List localList1;
    do
    {
      return;
      List localList2 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localList1 = localList2;
      if (localList2 == null) {
        localList1 = Collections.synchronizedList(new ArrayList());
      }
    } while (localList1.contains(parambcge));
    localList1.add(parambcge);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localList1);
  }
  
  public void a(String paramString, int paramInt, bcge parambcge)
  {
    a(a(paramString, paramInt), parambcge);
    parambcge = new Bundle();
    parambcge.putString("PackageName", paramString);
    parambcge.putInt("VersionCode", paramInt);
    bcds.c("DownloaderGetCodeClient", paramString + "_" + paramInt + " begin getApkCode ......");
    this.jdField_a_of_type_JavaUtilMap.put(a(paramString, paramInt), Boolean.valueOf(true));
    QIPCClientHelper.getInstance().callServer("Module_DownloaderGetCodeServer", "DownloaderWriteCodeIPC_Action__GetCode", parambcge, this.jdField_a_of_type_EipcEIPCResultCallback);
    ThreadManager.getSubThreadHandler().postDelayed(new DownloaderGetCodeClient.1(this, paramString, paramInt, parambcge), 3000L);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, bcge parambcge)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.b.put(a(paramString2, paramInt), paramString1);
    }
    a(paramString2, paramInt, parambcge);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcgw
 * JD-Core Version:    0.7.0.1
 */