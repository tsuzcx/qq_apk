package com.tencent.mobileqq.armap;

import android.text.TextUtils;
import com.tencent.image.Utils;
import com.tencent.mobileqq.armap.utils.ARResUtil;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ARMapDownloader
  implements INetEngine.INetEngineListener
{
  private static String jdField_a_of_type_JavaLangString;
  private ArMapInterface jdField_a_of_type_ComTencentMobileqqArmapArMapInterface;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private List jdField_a_of_type_JavaUtilList = new Vector();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public ARMapDownloader(ArMapInterface paramArMapInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface = paramArMapInterface;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = ARResUtil.b + "/armap/";
    }
    String str = jdField_a_of_type_JavaLangString + Utils.Crc64String(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ARMapDownloader", 2, "getOutPath, url:" + paramString + " path:" + str);
    }
    return str;
  }
  
  public void a(ARMapDownloader.DownloadListener paramDownloadListener)
  {
    if (paramDownloadListener == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramDownloadListener)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramDownloadListener);
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_a_of_type_Int == 0) {}
    String str1;
    int i;
    for (boolean bool = true;; bool = false)
    {
      ??? = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      str1 = ((HttpNetReq)???).jdField_a_of_type_JavaLangString;
      String str2 = new File(((HttpNetReq)???).c).getAbsolutePath();
      i = paramNetResp.jdField_a_of_type_Int;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          break;
        }
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        ((ARMapDownloader.DownloadListener)localIterator.next()).onDownLoadFinish(str1, bool, str2, paramNetResp);
      }
    }
    this.jdField_a_of_type_JavaUtilMap.remove(str1);
    if (QLog.isColorLevel()) {
      QLog.i("ARMapDownloader", 2, "onResp reqUrl: " + str1 + " \nfilePath:" + str1 + " \nmResult: " + i + ",httpCode:" + paramNetResp.c + ",errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString + ",mHttpCode:" + paramNetResp.b);
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 70
    //   10: iconst_2
    //   11: new 41	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   18: ldc 164
    //   20: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_1
    //   34: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne +18 -> 55
    //   40: aload_0
    //   41: getfield 27	com/tencent/mobileqq/armap/ARMapDownloader:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   44: aload_1
    //   45: invokeinterface 167 2 0
    //   50: istore_2
    //   51: iload_2
    //   52: ifeq +6 -> 58
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: aload_0
    //   59: getfield 169	com/tencent/mobileqq/armap/ARMapDownloader:jdField_a_of_type_ComTencentMobileqqTransfileINetEngine	Lcom/tencent/mobileqq/transfile/INetEngine;
    //   62: ifnonnull +15 -> 77
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 29	com/tencent/mobileqq/armap/ARMapDownloader:jdField_a_of_type_ComTencentMobileqqArmapArMapInterface	Lcom/tencent/mobileqq/armap/ArMapInterface;
    //   70: iconst_0
    //   71: invokevirtual 175	com/tencent/mobileqq/armap/ArMapInterface:getNetEngine	(I)Lcom/tencent/mobileqq/transfile/INetEngine;
    //   74: putfield 169	com/tencent/mobileqq/armap/ARMapDownloader:jdField_a_of_type_ComTencentMobileqqTransfileINetEngine	Lcom/tencent/mobileqq/transfile/INetEngine;
    //   77: new 100	com/tencent/mobileqq/transfile/HttpNetReq
    //   80: dup
    //   81: invokespecial 176	com/tencent/mobileqq/transfile/HttpNetReq:<init>	()V
    //   84: astore_3
    //   85: aload_3
    //   86: aload_0
    //   87: putfield 179	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener	Lcom/tencent/mobileqq/transfile/INetEngine$INetEngineListener;
    //   90: aload_3
    //   91: aload_1
    //   92: putfield 101	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   95: aload_3
    //   96: iconst_0
    //   97: putfield 180	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_Int	I
    //   100: aload_3
    //   101: aload_1
    //   102: invokestatic 182	com/tencent/mobileqq/armap/ARMapDownloader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   105: putfield 106	com/tencent/mobileqq/transfile/HttpNetReq:c	Ljava/lang/String;
    //   108: aload_3
    //   109: iconst_1
    //   110: putfield 185	com/tencent/mobileqq/transfile/HttpNetReq:e	I
    //   113: aload_0
    //   114: getfield 169	com/tencent/mobileqq/armap/ARMapDownloader:jdField_a_of_type_ComTencentMobileqqTransfileINetEngine	Lcom/tencent/mobileqq/transfile/INetEngine;
    //   117: aload_3
    //   118: invokeinterface 190 2 0
    //   123: aload_0
    //   124: getfield 27	com/tencent/mobileqq/armap/ARMapDownloader:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   127: aload_1
    //   128: aload_3
    //   129: invokeinterface 194 3 0
    //   134: pop
    //   135: goto -80 -> 55
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	ARMapDownloader
    //   0	143	1	paramString	String
    //   50	2	2	bool	boolean
    //   84	45	3	localHttpNetReq	HttpNetReq
    // Exception table:
    //   from	to	target	type
    //   2	33	138	finally
    //   33	51	138	finally
    //   58	77	138	finally
    //   77	135	138	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapDownloader
 * JD-Core Version:    0.7.0.1
 */