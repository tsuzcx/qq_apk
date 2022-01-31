import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class aozi
{
  private aoun jdField_a_of_type_Aoun = new aozj(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<Long, apgw> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public aozi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aoun);
  }
  
  /* Error */
  public int a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	aozi:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: lload 5
    //   8: invokestatic 47	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   11: invokevirtual 51	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 53	apgw
    //   17: astore 7
    //   19: aload 7
    //   21: ifnull +17 -> 38
    //   24: aload 7
    //   26: invokeinterface 57 1 0
    //   31: istore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: iload 4
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 28	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Laoze;
    //   45: lload_1
    //   46: aload_3
    //   47: iload 4
    //   49: lload 5
    //   51: invokevirtual 65	aoze:a	(JLjava/lang/String;IJ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnonnull +9 -> 65
    //   59: iconst_m1
    //   60: istore 4
    //   62: goto -29 -> 33
    //   65: aload_0
    //   66: getfield 26	aozi:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   69: aload_3
    //   70: getfield 71	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   73: invokestatic 47	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: invokevirtual 51	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 53	apgw
    //   82: ifnull +12 -> 94
    //   85: aload_3
    //   86: getfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   89: istore 4
    //   91: goto -58 -> 33
    //   94: iconst_m1
    //   95: istore 4
    //   97: goto -64 -> 33
    //   100: astore_3
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_3
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	aozi
    //   0	105	1	paramLong1	long
    //   0	105	3	paramString	String
    //   0	105	4	paramInt	int
    //   0	105	5	paramLong2	long
    //   17	8	7	localapgw	apgw
    // Exception table:
    //   from	to	target	type
    //   2	19	100	finally
    //   24	33	100	finally
    //   38	55	100	finally
    //   65	91	100	finally
  }
  
  /* Error */
  public long a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Laoze;
    //   9: lload 4
    //   11: aload_1
    //   12: iload 6
    //   14: invokevirtual 79	aoze:a	(JLjava/lang/String;I)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   17: astore 7
    //   19: aload 7
    //   21: ifnull +45 -> 66
    //   24: aload_0
    //   25: getfield 26	aozi:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   28: aload 7
    //   30: getfield 71	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   33: invokestatic 47	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokevirtual 51	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 53	apgw
    //   42: astore 7
    //   44: aload 7
    //   46: ifnull +20 -> 66
    //   49: aload 7
    //   51: invokeinterface 82 1 0
    //   56: istore 6
    //   58: iload 6
    //   60: i2l
    //   61: lstore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: lload_2
    //   65: lreturn
    //   66: aload_0
    //   67: getfield 28	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Laoze;
    //   73: aload_1
    //   74: lload_2
    //   75: lload 4
    //   77: iload 6
    //   79: invokevirtual 84	aoze:a	(Ljava/lang/String;JJI)J
    //   82: lstore_2
    //   83: goto -21 -> 62
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	aozi
    //   0	91	1	paramString	String
    //   0	91	2	paramLong1	long
    //   0	91	4	paramLong2	long
    //   0	91	6	paramInt	int
    //   17	33	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	86	finally
    //   24	44	86	finally
    //   49	58	86	finally
    //   66	83	86	finally
  }
  
  /* Error */
  public FileManagerEntity a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	aozi:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: invokevirtual 88	java/util/LinkedHashMap:size	()I
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_1
    //   12: if_icmpge +9 -> 21
    //   15: aconst_null
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aload_0
    //   22: getfield 26	aozi:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   25: invokevirtual 92	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   28: invokeinterface 98 1 0
    //   33: astore_3
    //   34: aload_3
    //   35: invokeinterface 104 1 0
    //   40: ifeq +53 -> 93
    //   43: aload_3
    //   44: invokeinterface 108 1 0
    //   49: checkcast 43	java/lang/Long
    //   52: astore 4
    //   54: aload_0
    //   55: getfield 26	aozi:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   58: aload 4
    //   60: invokevirtual 51	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 53	apgw
    //   66: astore 4
    //   68: aload_1
    //   69: aload 4
    //   71: invokeinterface 111 1 0
    //   76: invokevirtual 117	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   79: ifeq -45 -> 34
    //   82: aload 4
    //   84: invokeinterface 120 1 0
    //   89: astore_1
    //   90: goto -73 -> 17
    //   93: aconst_null
    //   94: astore_1
    //   95: goto -78 -> 17
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	aozi
    //   0	103	1	paramString	String
    //   9	4	2	i	int
    //   33	11	3	localIterator	Iterator
    //   52	31	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	98	finally
    //   21	34	98	finally
    //   34	90	98	finally
  }
  
  public FileManagerEntity a(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        int i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
        if (i < 1)
        {
          paramString1 = null;
          return paramString1;
        }
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
          if (localIterator.hasNext())
          {
            Object localObject = (Long)localIterator.next();
            localObject = (apgw)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
            FileManagerEntity localFileManagerEntity = ((apgw)localObject).a();
            if ((paramString1.equalsIgnoreCase((String)localFileManagerEntity.mContext)) && (paramString2.equals(localFileManagerEntity.zipInnerPath))) {
              paramString1 = ((apgw)localObject).a();
            }
          }
          else
          {
            paramString1 = null;
          }
        }
        else
        {
          paramString1 = null;
        }
      }
      finally {}
    }
  }
  
  public void a()
  {
    label56:
    Long localLong;
    int j;
    try
    {
      i = bgbg.a(BaseApplication.getContext());
      if (i == 1) {
        break label596;
      }
      if (i != 2) {
        break label591;
      }
    }
    finally {}
    int[] arrayOfInt = new int[3];
    long[] arrayOfLong = new long[4];
    int i = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    String str2 = "";
    String str1 = "";
    apgw localapgw;
    label157:
    int k;
    label229:
    int n;
    while (localIterator.hasNext())
    {
      localLong = (Long)localIterator.next();
      localapgw = (apgw)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localLong);
      if (localapgw == null)
      {
        str1 = str1 + "!!!!runRSWorker error, get worker null!!! sessionID[" + localLong + "]\n";
      }
      else
      {
        if (localapgw.a() == 0) {
          break label601;
        }
        if (localapgw.a() == 6) {
          break label601;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSCenter<FileAssistant>", 1, "run worker[" + localLong + "],direction Type : " + j);
          }
          if (!localapgw.a()) {
            break label626;
          }
          if (arrayOfInt[j] >= k) {
            break label588;
          }
          if (j == 1) {
            break label606;
          }
          if (j != 2) {
            break label499;
          }
          break label606;
          int m = n;
          if (j < arrayOfLong.length)
          {
            if (arrayOfLong[j] != localapgw.a()) {
              break label619;
            }
            m = 1;
          }
          if (m == 0) {
            break label426;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("FileManagerRSCenter<FileAssistant>", 1, "run worker[" + localLong + "],file is uploadding continue ");
          break;
          if ((localapgw.a() == 1) || (localapgw.a() == 8) || (localapgw.a() == 5) || (localapgw.a() == 50)) {
            break label614;
          }
          if (localapgw.a() != 41) {
            break label376;
          }
          j = 2;
        }
        label376:
        str2 = str2 + "type[" + localapgw.a() + "] is not processed, maxtype is " + 8 + "\n";
        continue;
        label426:
        QLog.i("FileManagerRSCenter<FileAssistant>", 1, "!!!run worker[" + localLong + "]!!!");
        localapgw.aw_();
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localCharSequence)) {
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, localCharSequence);
      }
      if (!TextUtils.isEmpty(str2)) {
        QLog.i("FileManagerRSCenter<FileAssistant>", 1, str2);
      }
      return;
      label499:
      localapgw.aw_();
    }
    label509:
    long l = localapgw.a();
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSCenter<FileAssistant>", 1, "work[" + localLong + "] is running, setIndex[" + i + "] fileSize:" + l);
    }
    for (;;)
    {
      label572:
      arrayOfInt[j] += 1;
      label582:
      break label56;
      label588:
      label591:
      label596:
      label601:
      label606:
      label614:
      label619:
      label626:
      do
      {
        break label572;
        break label582;
        k = 2;
        break;
        k = 1;
        break;
        j = 1;
        break label157;
        n = 0;
        j = 0;
        break label229;
        j = 0;
        break label157;
        j += 1;
        break label229;
        if (j == 1) {
          break label509;
        }
      } while (j != 2);
      break label509;
      arrayOfLong[i] = l;
      i += 1;
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      apgw localapgw = (apgw)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      if (localapgw != null) {
        localapgw.b();
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSCenter<FileAssistant>", 2, "remove worker, sessionId[" + String.valueOf(paramLong) + "]");
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(paramLong));
      a();
      return;
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1);
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
    if (localFileManagerEntity2 == null) {
      localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2, paramString, paramInt1);
    }
    if (localFileManagerEntity1 == null)
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity is null ,why you can choose!!!");
      return;
    }
    if ((localFileManagerEntity1.cloudType != 2) && (localFileManagerEntity1.cloudType != 0))
    {
      if (apvd.b(localFileManagerEntity1.getFilePath()))
      {
        localFileManagerEntity1.status = 1;
        localFileManagerEntity1.cloudType = 3;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity[" + localFileManagerEntity1.nSessionId + "] local existed so notify Success");
        return;
      }
      if ((TextUtils.isEmpty(localFileManagerEntity1.Uuid)) && (!localFileManagerEntity1.isZipInnerFile))
      {
        apug.a(BaseApplicationImpl.getContext().getString(2131692857));
        localFileManagerEntity1.status = 16;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity[" + localFileManagerEntity1.nSessionId + "] uuid null, but not Zipfile, set invalid!");
        return;
      }
    }
    if ((localFileManagerEntity1.nFileType == 2) && (!localFileManagerEntity1.isZipInnerFile) && (localFileManagerEntity1.cloudType != 2) && ((localFileManagerEntity1.peerType == 3000) || (localFileManagerEntity1.peerType == 0)))
    {
      localFileManagerEntity1.nOpType = 8;
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v> entity[" + localFileManagerEntity1.nSessionId + "] is video, start init video sdk");
      apab.a(BaseActivity.sTopActivity, new aozl(this, localFileManagerEntity1));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
      return;
    }
    localFileManagerEntity1.nOpType = paramInt2;
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Long.valueOf(paramLong1)) == true)
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity[" + paramLong1 + "] is processing");
      return;
    }
    b(localFileManagerEntity1);
  }
  
  public void a(long paramLong, apgw paramapgw)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramLong), paramapgw);
      QLog.i("FileManagerRSCenter<FileAssistant>", 1, "=_= v> entity[" + paramLong + "] is add to download list");
      a();
      return;
    }
    finally {}
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.bDelInFM == true)
    {
      paramFileManagerEntity.bDelInFM = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
    }
    int i;
    Object localObject;
    if (!bbdx.b(paramFileManagerEntity.getFilePath()))
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]file is not exist or empty,path[" + paramFileManagerEntity.getFilePath() + "], please check file!");
      i = 0;
      String str = apug.a();
      if ((paramFileManagerEntity.getFilePath() == null) || (paramFileManagerEntity.getFilePath().length() == 0))
      {
        i = 9005;
        localObject = "filePathNull:" + str;
        switch (paramFileManagerEntity.nOpType)
        {
        }
      }
      for (;;)
      {
        paramFileManagerEntity.status = 16;
        paramFileManagerEntity.fProgress = 1.0F;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        return;
        if (!apug.b(paramFileManagerEntity.getFilePath()))
        {
          i = 9042;
          localObject = "fileNotExists:" + str;
          break;
        }
        localObject = str;
        if (apug.a(paramFileManagerEntity.getFilePath()) != 0L) {
          break;
        }
        i = 9071;
        localObject = "fileExistsEmpty:" + str;
        break;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 15, null, 1, null);
        paramFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileUp", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
        apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileUpDetail", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
        continue;
        paramFileManagerEntity.status = 0;
        paramFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 38, null, 1, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileWyUp", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
      }
    }
    if (paramFileManagerEntity.peerType == 3000) {
      localObject = new apgq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), localObject);
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerRSCenter<FileAssistant>", 2, "Add a New Send Work!, sessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]");
        }
        a();
        return;
      }
      finally {}
      localObject = (aset)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(16);
      if ((localObject != null) && (((aset)localObject).a(paramFileManagerEntity.peerUin)))
      {
        paramFileManagerEntity.isReaded = false;
        if (paramFileManagerEntity.status != 16) {}
        for (i = 0;; i = 16)
        {
          paramFileManagerEntity.status = i;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
          QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= ! Id[" + paramFileManagerEntity.nSessionId + "] frend in blacklist!");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 15, null, -1, ajya.a(2131704541));
          return;
        }
      }
      if (paramFileManagerEntity.nOpType == 0)
      {
        if ((apha.a().a()) && (paramFileManagerEntity.fileSize > apha.a().a())) {
          localObject = new aphr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
        } else {
          localObject = new apax(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
        }
      }
      else {
        localObject = new aozm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    Object localObject2;
    try
    {
      int j = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
      if (j < 1) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        localArrayList.add(0, (apgw)((Iterator)localObject2).next());
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    }
    finally {}
    Iterator localIterator = localObject1.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject2 = (apgw)localIterator.next();
        ((apgw)localObject2).c();
        if (!paramBoolean)
        {
          ((apgw)localObject2).e();
        }
        else
        {
          ((apgw)localObject2).a(null, 0);
          i = 1;
        }
      }
      else
      {
        if ((paramBoolean) && (i == 0)) {
          apug.a(BaseApplicationImpl.getContext().getString(2131692885));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        break;
      }
    }
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	aozi:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: lload_1
    //   7: invokestatic 47	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokevirtual 51	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 53	apgw
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +26 -> 46
    //   23: aload 4
    //   25: invokeinterface 461 1 0
    //   30: aload_0
    //   31: getfield 26	aozi:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   34: lload_1
    //   35: invokestatic 47	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   38: invokevirtual 237	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: aload_0
    //   43: invokevirtual 239	aozi:a	()V
    //   46: aload_0
    //   47: getfield 28	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Laoze;
    //   53: lload_1
    //   54: invokevirtual 243	aoze:a	(J)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   57: astore 4
    //   59: aload 4
    //   61: ifnull +87 -> 148
    //   64: aload 4
    //   66: getfield 290	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   69: iconst_2
    //   70: if_icmpne +78 -> 148
    //   73: new 154	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   80: ldc 152
    //   82: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload 4
    //   87: getfield 71	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   90: invokevirtual 221	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   93: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 462	apab:a	(Ljava/lang/String;)V
    //   99: aload 4
    //   101: getfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   104: iconst_2
    //   105: if_icmpeq +12 -> 117
    //   108: aload 4
    //   110: getfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   113: iconst_m1
    //   114: if_icmpne +9 -> 123
    //   117: aload 4
    //   119: iconst_3
    //   120: putfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   123: aload_0
    //   124: getfield 28	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   127: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Laoze;
    //   130: aload 4
    //   132: invokevirtual 258	aoze:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   135: aload_0
    //   136: getfield 28	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   139: invokevirtual 33	com/tencent/mobileqq/app/QQAppInterface:a	()Laozg;
    //   142: iconst_1
    //   143: iconst_0
    //   144: aconst_null
    //   145: invokevirtual 261	aozg:a	(ZILjava/lang/Object;)V
    //   148: aload 4
    //   150: ifnull +36 -> 186
    //   153: aload 4
    //   155: getfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   158: iconst_2
    //   159: if_icmpne +27 -> 186
    //   162: aload 4
    //   164: iconst_3
    //   165: putfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   168: aload_0
    //   169: getfield 28	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   172: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Laoze;
    //   175: aload 4
    //   177: invokevirtual 258	aoze:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   180: iconst_1
    //   181: istore_3
    //   182: aload_0
    //   183: monitorexit
    //   184: iload_3
    //   185: ireturn
    //   186: iconst_0
    //   187: istore_3
    //   188: goto -6 -> 182
    //   191: astore 4
    //   193: aload_0
    //   194: monitorexit
    //   195: aload 4
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	aozi
    //   0	198	1	paramLong	long
    //   181	7	3	bool	boolean
    //   16	160	4	localObject1	Object
    //   191	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	191	finally
    //   23	46	191	finally
    //   46	59	191	finally
    //   64	117	191	finally
    //   117	123	191	finally
    //   123	148	191	finally
    //   153	180	191	finally
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	aozi:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: invokevirtual 88	java/util/LinkedHashMap:size	()I
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_1
    //   12: if_icmpge +9 -> 21
    //   15: iconst_0
    //   16: istore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_3
    //   20: ireturn
    //   21: aload_0
    //   22: getfield 26	aozi:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   25: invokevirtual 92	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   28: invokeinterface 98 1 0
    //   33: astore 4
    //   35: aload 4
    //   37: invokeinterface 104 1 0
    //   42: ifeq +61 -> 103
    //   45: aload 4
    //   47: invokeinterface 108 1 0
    //   52: checkcast 43	java/lang/Long
    //   55: astore 5
    //   57: aload_0
    //   58: getfield 26	aozi:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   61: aload 5
    //   63: invokevirtual 51	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   66: checkcast 53	apgw
    //   69: invokeinterface 120 1 0
    //   74: astore 5
    //   76: aload 5
    //   78: getfield 465	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFilePath	Ljava/lang/String;
    //   81: ifnull -46 -> 35
    //   84: aload 5
    //   86: getfield 465	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFilePath	Ljava/lang/String;
    //   89: aload_1
    //   90: invokevirtual 117	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   93: istore_3
    //   94: iload_3
    //   95: ifeq -60 -> 35
    //   98: iconst_1
    //   99: istore_3
    //   100: goto -83 -> 17
    //   103: iconst_0
    //   104: istore_3
    //   105: goto -88 -> 17
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	aozi
    //   0	113	1	paramString	String
    //   9	4	2	i	int
    //   16	89	3	bool	boolean
    //   33	13	4	localIterator	Iterator
    //   55	30	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	108	finally
    //   21	35	108	finally
    //   35	94	108	finally
  }
  
  /* Error */
  public boolean a(String paramString, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Laoze;
    //   9: lload_2
    //   10: aload_1
    //   11: iload 4
    //   13: ldc2_w 467
    //   16: invokevirtual 65	aoze:a	(JLjava/lang/String;IJ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +11 -> 32
    //   24: iconst_0
    //   25: istore 5
    //   27: aload_0
    //   28: monitorexit
    //   29: iload 5
    //   31: ireturn
    //   32: aload_0
    //   33: aload_1
    //   34: getfield 71	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   37: invokevirtual 470	aozi:a	(J)Z
    //   40: istore 5
    //   42: goto -15 -> 27
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	aozi
    //   0	50	1	paramString	String
    //   0	50	2	paramLong	long
    //   0	50	4	paramInt	int
    //   25	16	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	45	finally
    //   32	42	45	finally
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.bDelInFM == true)
    {
      paramFileManagerEntity.bDelInFM = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
    }
    if ((paramFileManagerEntity.nFileType == 2) && (!paramFileManagerEntity.isZipInnerFile) && (paramFileManagerEntity.cloudType != 2))
    {
      apab.a(BaseActivity.sTopActivity, new aozk(this, paramFileManagerEntity));
      return;
    }
    if ((paramFileManagerEntity.peerType == 0) && (paramFileManagerEntity.nOpType != 5) && (paramFileManagerEntity.nOpType != 50) && (apha.a().b()) && (paramFileManagerEntity.fileSize > apha.a().b()) && (!TextUtils.isEmpty(paramFileManagerEntity.Uuid))) {}
    for (Object localObject = new aphl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);; localObject = new aozm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity)) {
      try
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), localObject);
        QLog.i("FileManagerRSCenter<FileAssistant>", 1, "=_= v> entity[" + paramFileManagerEntity.nSessionId + "] is add to download list");
        a();
        return;
      }
      finally {}
    }
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      try
      {
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, "entry is null, retry ge mao!");
        return;
      }
      finally {}
      apgw localapgw = (apgw)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramFileManagerEntity.nSessionId));
      if ((localapgw == null) || (localapgw.a())) {
        break;
      }
      QLog.i("FileManagerRSCenter<FileAssistant>", 1, "uniseq[ " + String.valueOf(paramFileManagerEntity.uniseq) + " ],sessionid[ " + String.valueOf(paramFileManagerEntity.nSessionId) + " ] work,is procressing!");
    }
    switch (paramFileManagerEntity.nOpType)
    {
    }
    for (;;)
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "Unknow actionType!");
      break;
      a(paramFileManagerEntity);
      break;
      b(paramFileManagerEntity);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aozi
 * JD-Core Version:    0.7.0.1
 */