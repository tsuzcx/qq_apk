package com.tencent.mobileqq.arcard;

import aafz;
import aaga;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class ARRelationShipFileUpload
{
  protected AppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public ARRelationShipFileUpload(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  /* Error */
  private byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 35	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 7
    //   16: new 40	java/io/FileInputStream
    //   19: dup
    //   20: aload 7
    //   22: invokespecial 43	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore 4
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: aload 7
    //   34: invokevirtual 47	java/io/File:length	()J
    //   37: invokestatic 53	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   40: astore 7
    //   42: aload 7
    //   44: astore_1
    //   45: aload_1
    //   46: astore_3
    //   47: aload 4
    //   49: ifnull +10 -> 59
    //   52: aload 4
    //   54: invokevirtual 56	java/io/FileInputStream:close	()V
    //   57: aload_1
    //   58: astore_3
    //   59: aload_3
    //   60: areturn
    //   61: astore_3
    //   62: aload 4
    //   64: astore_3
    //   65: new 35	java/io/File
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore 7
    //   75: aload 4
    //   77: astore_3
    //   78: aload 7
    //   80: invokevirtual 60	java/io/File:exists	()Z
    //   83: istore_2
    //   84: aload 5
    //   86: astore_1
    //   87: iload_2
    //   88: ifeq -43 -> 45
    //   91: aload 4
    //   93: astore_3
    //   94: aload 7
    //   96: invokestatic 65	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +14 -> 115
    //   104: aload 4
    //   106: astore_3
    //   107: aload_1
    //   108: invokestatic 69	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   111: astore_1
    //   112: goto -67 -> 45
    //   115: ldc 71
    //   117: astore_1
    //   118: goto -14 -> 104
    //   121: astore_3
    //   122: aload_3
    //   123: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   126: aload_1
    //   127: areturn
    //   128: astore 5
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_1
    //   133: astore_3
    //   134: aload 5
    //   136: invokevirtual 75	java/lang/Exception:printStackTrace	()V
    //   139: aload 6
    //   141: astore_3
    //   142: aload_1
    //   143: ifnull -84 -> 59
    //   146: aload_1
    //   147: invokevirtual 56	java/io/FileInputStream:close	()V
    //   150: aconst_null
    //   151: areturn
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   157: aconst_null
    //   158: areturn
    //   159: astore_1
    //   160: aconst_null
    //   161: astore_3
    //   162: aload_3
    //   163: ifnull +7 -> 170
    //   166: aload_3
    //   167: invokevirtual 56	java/io/FileInputStream:close	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_3
    //   173: aload_3
    //   174: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   177: goto -7 -> 170
    //   180: astore_1
    //   181: goto -19 -> 162
    //   184: astore 5
    //   186: aload 4
    //   188: astore_1
    //   189: goto -57 -> 132
    //   192: astore_1
    //   193: aload 5
    //   195: astore_1
    //   196: goto -151 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	ARRelationShipFileUpload
    //   0	199	1	paramString	String
    //   83	5	2	bool	boolean
    //   29	31	3	localObject1	Object
    //   61	1	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   64	43	3	localFileInputStream1	java.io.FileInputStream
    //   121	2	3	localIOException1	java.io.IOException
    //   133	34	3	localObject2	Object
    //   172	2	3	localIOException2	java.io.IOException
    //   25	162	4	localFileInputStream2	java.io.FileInputStream
    //   4	81	5	localObject3	Object
    //   128	7	5	localException1	java.lang.Exception
    //   184	10	5	localException2	java.lang.Exception
    //   1	139	6	localObject4	Object
    //   14	81	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   30	42	61	java/lang/UnsatisfiedLinkError
    //   52	57	121	java/io/IOException
    //   6	27	128	java/lang/Exception
    //   146	150	152	java/io/IOException
    //   6	27	159	finally
    //   166	170	172	java/io/IOException
    //   30	42	180	finally
    //   65	75	180	finally
    //   78	84	180	finally
    //   94	100	180	finally
    //   107	112	180	finally
    //   134	139	180	finally
    //   30	42	184	java/lang/Exception
    //   65	75	184	java/lang/Exception
    //   78	84	184	java/lang/Exception
    //   94	100	184	java/lang/Exception
    //   107	112	184	java/lang/Exception
    //   94	100	192	java/io/IOException
    //   107	112	192	java/io/IOException
  }
  
  public int a()
  {
    int i = 0;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        int j = this.jdField_a_of_type_JavaUtilArrayList.size();
        i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          QLog.i("ARRelationShipFileUpload", 1, "cancelTransactionTask. sessionId = " + ((aaga)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipReqInfo.b);
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().cancelTransactionTask(((aaga)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
          i += 1;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i = j;
      }
      return i;
    }
  }
  
  public String a()
  {
    return String.format("%s_%s_%05d", new Object[] { this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)) });
  }
  
  public boolean a(ARRelationShipFileUpload.ARRelationShipReqInfo paramARRelationShipReqInfo, ARRelationShipFileUpload.ARRelationShipFileUploadCallBack arg2)
  {
    if ((paramARRelationShipReqInfo == null) || (??? == null))
    {
      QLog.i("ARRelationShipFileUpload", 1, "filePath == null || callBack == null");
      return false;
    }
    new File(paramARRelationShipReqInfo.jdField_a_of_type_JavaLangString);
    Object localObject1 = new aafz(this, paramARRelationShipReqInfo);
    Object localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length == 0)) {}
    try
    {
      if (SessionInfo.getInstance((String)localObject2).getHttpconn_sig_session() != null)
      {
        i = SessionInfo.getInstance((String)localObject2).getHttpconn_sig_session().length;
        this.jdField_a_of_type_ArrayOfByte = new byte[i];
        System.arraycopy(SessionInfo.getInstance((String)localObject2).getHttpconn_sig_session(), 0, this.jdField_a_of_type_ArrayOfByte, 0, i);
      }
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length == 0))
      {
        HwServlet.getConfig(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject2);
        QLog.i("ARRelationShipFileUpload", 1, "requestToUpload failed. mSigSession == null || mSigSession.length == 0.");
        return false;
      }
    }
    finally {}
    byte[] arrayOfByte = a(paramARRelationShipReqInfo.jdField_a_of_type_JavaLangString);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      QLog.i("ARRelationShipFileUpload", 1, "requestToUpload failed. fileMd5 == null || fileMd5.length == 0.");
      return false;
    }
    if (paramARRelationShipReqInfo.jdField_a_of_type_Int == 1) {}
    for (int i = 55;; i = 56) {
      for (;;)
      {
        localObject1 = new Transaction((String)localObject2, i, paramARRelationShipReqInfo.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ArrayOfByte, arrayOfByte, (ITransactionCallback)localObject1);
        localObject2 = new aaga();
        ((aaga)localObject2).jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipReqInfo = paramARRelationShipReqInfo;
        ((aaga)localObject2).jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = ((Transaction)localObject1);
        ((aaga)localObject2).jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipFileUploadCallBack = ???;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject1);
          QLog.i("ARRelationShipFileUpload", 1, "submitTransactionTask. retCode = " + i + ", reqInfo = " + paramARRelationShipReqInfo.jdField_a_of_type_JavaLangString);
          if (i != 0) {
            break;
          }
          return true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARRelationShipFileUpload
 * JD-Core Version:    0.7.0.1
 */