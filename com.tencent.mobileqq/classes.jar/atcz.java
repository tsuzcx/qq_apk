import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
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

public class atcz
{
  private asyw jdField_a_of_type_Asyw = new atda(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<Long, atji> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public atcz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Asyw);
  }
  
  /* Error */
  public int a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	atcz:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: lload 5
    //   8: invokestatic 47	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   11: invokevirtual 51	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 53	atji
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
    //   39: getfield 28	atcz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Latcv;
    //   45: lload_1
    //   46: aload_3
    //   47: iload 4
    //   49: lload 5
    //   51: invokevirtual 65	atcv:a	(JLjava/lang/String;IJ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnonnull +9 -> 65
    //   59: iconst_m1
    //   60: istore 4
    //   62: goto -29 -> 33
    //   65: aload_0
    //   66: getfield 26	atcz:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   69: aload_3
    //   70: getfield 71	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   73: invokestatic 47	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: invokevirtual 51	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 53	atji
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
    //   0	105	0	this	atcz
    //   0	105	1	paramLong1	long
    //   0	105	3	paramString	String
    //   0	105	4	paramInt	int
    //   0	105	5	paramLong2	long
    //   17	8	7	localatji	atji
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
    //   3: getfield 28	atcz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Latcv;
    //   9: lload 4
    //   11: aload_1
    //   12: iload 6
    //   14: invokevirtual 79	atcv:a	(JLjava/lang/String;I)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   17: astore 7
    //   19: aload 7
    //   21: ifnull +45 -> 66
    //   24: aload_0
    //   25: getfield 26	atcz:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   28: aload 7
    //   30: getfield 71	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   33: invokestatic 47	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokevirtual 51	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 53	atji
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
    //   67: getfield 28	atcz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Latcv;
    //   73: aload_1
    //   74: lload_2
    //   75: lload 4
    //   77: iload 6
    //   79: invokevirtual 84	atcv:a	(Ljava/lang/String;JJI)J
    //   82: lstore_2
    //   83: goto -21 -> 62
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	atcz
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
    //   3: getfield 26	atcz:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
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
    //   22: getfield 26	atcz:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
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
    //   55: getfield 26	atcz:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   58: aload 4
    //   60: invokevirtual 51	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 53	atji
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
    //   0	103	0	this	atcz
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
            localObject = (atji)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
            FileManagerEntity localFileManagerEntity = ((atji)localObject).a();
            if ((paramString1.equalsIgnoreCase((String)localFileManagerEntity.mContext)) && (paramString2.equals(localFileManagerEntity.zipInnerPath))) {
              paramString1 = ((atji)localObject).a();
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
      i = bktw.a(BaseApplication.getContext());
      if (i == 1) {
        break label585;
      }
      if (i != 2) {
        break label580;
      }
    }
    finally {}
    int[] arrayOfInt = new int[3];
    long[] arrayOfLong = new long[4];
    int i = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    String str2 = "";
    String str1 = "";
    atji localatji;
    label157:
    int k;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localLong = (Long)localIterator.next();
        localatji = (atji)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localLong);
        if (localatji == null)
        {
          str1 = str1 + "!!!!runRSWorker error, get worker null!!! sessionID[" + localLong + "]\n";
        }
        else
        {
          if (localatji.a() == 0) {
            break label590;
          }
          if (localatji.a() == 6)
          {
            break label590;
            QLog.i("FileManagerRSCenter<FileAssistant>", 1, "run worker[" + localLong + "],direction Type : " + j);
            if (!localatji.a()) {
              break label487;
            }
            if (arrayOfInt[j] >= k) {
              break label577;
            }
            if (j == 1) {
              break label595;
            }
            if (j != 2) {
              break label445;
            }
            break label595;
          }
        }
      }
    }
    for (;;)
    {
      int n;
      int m = n;
      if (j < arrayOfLong.length)
      {
        if (arrayOfLong[j] == localatji.a()) {
          m = 1;
        }
      }
      else
      {
        if (m != 0)
        {
          QLog.i("FileManagerRSCenter<FileAssistant>", 1, "run worker[" + localLong + "],file is uploadding continue ");
          break label56;
          if ((localatji.a() == 1) || (localatji.a() == 8) || (localatji.a() == 5) || (localatji.a() == 50)) {
            break label603;
          }
          if (localatji.a() == 41)
          {
            j = 2;
            break label157;
          }
          str2 = str2 + "type[" + localatji.a() + "] is not processed, maxtype is " + 8 + "\n";
          break label56;
        }
        QLog.i("FileManagerRSCenter<FileAssistant>", 1, "!!!run worker[" + localLong + "]!!!");
        label445:
        localatji.aE_();
        if (!TextUtils.isEmpty(localCharSequence)) {
          QLog.e("FileManagerRSCenter<FileAssistant>", 1, localCharSequence);
        }
        if (!TextUtils.isEmpty(str2)) {
          QLog.i("FileManagerRSCenter<FileAssistant>", 1, str2);
        }
        return;
        label487:
        if ((j == 1) || (j == 2))
        {
          long l = localatji.a();
          QLog.i("FileManagerRSCenter<FileAssistant>", 1, "work[" + localLong + "] is running, setIndex[" + i + "] fileSize:" + l);
          arrayOfLong[i] = l;
          i += 1;
          arrayOfInt[j] += 1;
        }
        label561:
        label577:
        for (;;)
        {
          break;
          break label561;
        }
        label580:
        k = 2;
        break;
        label585:
        k = 1;
        break;
        label590:
        j = 1;
        break label157;
        label595:
        n = 0;
        j = 0;
        continue;
        label603:
        j = 0;
        break label157;
      }
      j += 1;
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      atji localatji = (atji)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      if (localatji != null) {
        localatji.b();
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1);
    if (localFileManagerEntity == null) {}
    for (paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2, paramString, paramInt1);; paramString = localFileManagerEntity)
    {
      if (paramString == null)
      {
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity is null ,why you can choose!!!");
        return;
      }
      if ((paramString.cloudType != 2) && (paramString.cloudType != 0))
      {
        if (atwl.b(paramString.getFilePath()))
        {
          paramString.status = 1;
          paramString.cloudType = 3;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
          QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity[" + paramString.nSessionId + "] local existed so notify Success");
          return;
        }
        if ((TextUtils.isEmpty(paramString.Uuid)) && (!paramString.isZipInnerFile))
        {
          atvo.a(BaseApplicationImpl.getContext().getString(2131692466));
          paramString.status = 16;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
          QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity[" + paramString.nSessionId + "] uuid null, but not Zipfile, set invalid!");
          return;
        }
      }
      if ((paramString.nFileType == 2) && (!paramString.isZipInnerFile) && (paramString.cloudType != 2) && ((paramString.peerType == 3000) || (paramString.peerType == 0)))
      {
        paramString.nOpType = 8;
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v> entity[" + paramString.nSessionId + "] is video, start init video sdk");
        new atnl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        if (paramString.peerType == 3000) {}
        for (paramString = new atno(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);; paramString = new atnl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString))
        {
          atdq.a(paramString).a();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
          return;
        }
      }
      paramString.nOpType = paramInt2;
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Long.valueOf(paramLong1)) == true)
      {
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity[" + paramLong1 + "] is processing");
        return;
      }
      b(paramString);
      return;
    }
  }
  
  public void a(long paramLong, atji paramatji)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramLong), paramatji);
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
    if (!bgmg.b(paramFileManagerEntity.getFilePath()))
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]file is not exist or empty,path[" + paramFileManagerEntity.getFilePath() + "], please check file!");
      i = 0;
      String str = atvo.a();
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
        if (!atvo.b(paramFileManagerEntity.getFilePath()))
        {
          i = 9042;
          localObject = "fileNotExists:" + str;
          break;
        }
        localObject = str;
        if (atvo.a(paramFileManagerEntity.getFilePath()) != 0L) {
          break;
        }
        i = 9071;
        localObject = "fileExistsEmpty:" + str;
        break;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 15, null, 1, null);
        paramFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileUp", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileUpDetail", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
        continue;
        paramFileManagerEntity.status = 0;
        paramFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 38, null, 1, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileWyUp", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
      }
    }
    if (paramFileManagerEntity.peerType == 3000) {
      localObject = new auao(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
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
      localObject = (awhl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(16);
      if ((localObject != null) && (((awhl)localObject).a(paramFileManagerEntity.peerUin)))
      {
        paramFileManagerEntity.isReaded = false;
        if (paramFileManagerEntity.status != 16) {}
        for (i = 0;; i = 16)
        {
          paramFileManagerEntity.status = i;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
          QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= ! Id[" + paramFileManagerEntity.nSessionId + "] frend in blacklist!");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 15, null, -1, anni.a(2131703322));
          return;
        }
      }
      if (paramFileManagerEntity.nOpType == 0)
      {
        if ((atjl.a().a()) && (paramFileManagerEntity.fileSize > atjl.a().a())) {
          localObject = new atkc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
        } else {
          localObject = new atet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
        }
      }
      else {
        localObject = new atdb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
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
        localArrayList.add(0, (atji)((Iterator)localObject2).next());
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    }
    finally {}
    Iterator localIterator = localObject1.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject2 = (atji)localIterator.next();
        ((atji)localObject2).c();
        if (!paramBoolean)
        {
          ((atji)localObject2).e();
        }
        else
        {
          ((atji)localObject2).a(null, 0);
          i = 1;
        }
      }
      else
      {
        if ((paramBoolean) && (i == 0)) {
          atvo.a(BaseApplicationImpl.getContext().getString(2131692495));
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
    //   3: getfield 26	atcz:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: lload_1
    //   7: invokestatic 47	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokevirtual 51	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 53	atji
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +26 -> 46
    //   23: aload 4
    //   25: invokeinterface 459 1 0
    //   30: aload_0
    //   31: getfield 26	atcz:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   34: lload_1
    //   35: invokestatic 47	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   38: invokevirtual 237	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: aload_0
    //   43: invokevirtual 239	atcz:a	()V
    //   46: aload_0
    //   47: getfield 28	atcz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Latcv;
    //   53: lload_1
    //   54: invokevirtual 243	atcv:a	(J)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   57: astore 4
    //   59: aload 4
    //   61: ifnull +72 -> 133
    //   64: aload 4
    //   66: getfield 290	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   69: iconst_2
    //   70: if_icmpne +63 -> 133
    //   73: aload 4
    //   75: getfield 71	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   78: invokestatic 229	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   81: invokestatic 460	atdq:a	(Ljava/lang/String;)V
    //   84: aload 4
    //   86: getfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   89: iconst_2
    //   90: if_icmpeq +12 -> 102
    //   93: aload 4
    //   95: getfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   98: iconst_m1
    //   99: if_icmpne +9 -> 108
    //   102: aload 4
    //   104: iconst_3
    //   105: putfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   108: aload_0
    //   109: getfield 28	atcz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   112: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Latcv;
    //   115: aload 4
    //   117: invokevirtual 258	atcv:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   120: aload_0
    //   121: getfield 28	atcz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   124: invokevirtual 33	com/tencent/mobileqq/app/QQAppInterface:a	()Latcx;
    //   127: iconst_1
    //   128: iconst_0
    //   129: aconst_null
    //   130: invokevirtual 261	atcx:a	(ZILjava/lang/Object;)V
    //   133: aload 4
    //   135: ifnull +36 -> 171
    //   138: aload 4
    //   140: getfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   143: iconst_2
    //   144: if_icmpne +27 -> 171
    //   147: aload 4
    //   149: iconst_3
    //   150: putfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   153: aload_0
    //   154: getfield 28	atcz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   157: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Latcv;
    //   160: aload 4
    //   162: invokevirtual 258	atcv:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   165: iconst_1
    //   166: istore_3
    //   167: aload_0
    //   168: monitorexit
    //   169: iload_3
    //   170: ireturn
    //   171: iconst_0
    //   172: istore_3
    //   173: goto -6 -> 167
    //   176: astore 4
    //   178: aload_0
    //   179: monitorexit
    //   180: aload 4
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	atcz
    //   0	183	1	paramLong	long
    //   166	7	3	bool	boolean
    //   16	145	4	localObject1	Object
    //   176	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	176	finally
    //   23	46	176	finally
    //   46	59	176	finally
    //   64	102	176	finally
    //   102	108	176	finally
    //   108	133	176	finally
    //   138	165	176	finally
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	atcz:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
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
    //   22: getfield 26	atcz:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
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
    //   58: getfield 26	atcz:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   61: aload 5
    //   63: invokevirtual 51	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   66: checkcast 53	atji
    //   69: invokeinterface 120 1 0
    //   74: astore 5
    //   76: aload 5
    //   78: invokevirtual 251	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   81: ifnull -46 -> 35
    //   84: aload 5
    //   86: invokevirtual 251	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
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
    //   0	113	0	this	atcz
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
    //   3: getfield 28	atcz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:a	()Latcv;
    //   9: lload_2
    //   10: aload_1
    //   11: iload 4
    //   13: ldc2_w 462
    //   16: invokevirtual 65	atcv:a	(JLjava/lang/String;IJ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
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
    //   37: invokevirtual 465	atcz:a	(J)Z
    //   40: istore 5
    //   42: goto -15 -> 27
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	atcz
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
      if (paramFileManagerEntity.peerType == 3000) {}
      for (paramFileManagerEntity = new atno(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);; paramFileManagerEntity = new atnl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity))
      {
        atdq.a(paramFileManagerEntity).a();
        return;
      }
    }
    if ((paramFileManagerEntity.peerType == 0) && (paramFileManagerEntity.nOpType != 5) && (paramFileManagerEntity.nOpType != 50) && (atjl.a().b()) && (paramFileManagerEntity.fileSize > atjl.a().b()) && (!TextUtils.isEmpty(paramFileManagerEntity.Uuid))) {}
    for (Object localObject = new atjw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);; localObject = new atdb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity)) {
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
      atji localatji = (atji)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramFileManagerEntity.nSessionId));
      if ((localatji == null) || (localatji.a())) {
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
 * Qualified Name:     atcz
 * JD-Core Version:    0.7.0.1
 */