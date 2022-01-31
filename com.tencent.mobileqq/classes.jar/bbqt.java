import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.5;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class bbqt
  extends TroopFileTransferManager
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  protected int a;
  protected bbrz a;
  protected bbth a;
  protected int b;
  
  static
  {
    if (!bbqt.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public bbqt(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.e = paramLong;
  }
  
  public static void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      if ((paramBoolean) || (Thread.currentThread() != jdField_a_of_type_AndroidOsHandler.getLooper().getThread()))
      {
        jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
        return;
      }
    }
    finally {}
    paramRunnable.run();
  }
  
  public int a(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      bbnr localbbnr;
      TroopFileTransferManager.Item localItem;
      synchronized (a()) {}
      int i = 0;
    }
  }
  
  public bbpe a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    synchronized (a()) {}
    try
    {
      paramString2 = ???.a(paramString2, paramLong2, 102);
      if (paramString2 == null) {
        return null;
      }
      c();
      paramString2 = new TroopFileTransferManager.Item(paramString2);
      paramString2.RandomNum = paramInt2;
      paramString2.ForwardPath = paramString1;
      paramString2.ForwardTroopuin = paramLong1;
      paramString2.ForwardBusId = paramInt1;
      paramString2.Status = 4;
      paramString2.LocalFile = paramString3;
      paramString2.entrySessionID = paramLong3;
      paramString1 = (MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramLong1), 1, paramString1);
      if (paramString1 != null)
      {
        paramString2.width = paramString1.width;
        paramString2.height = paramString1.height;
      }
      paramString3 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong1);
      if ((paramString3 != null) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.uuid)))
      {
        paramString1 = paramString3.a(UUID.fromString(paramString1.uuid));
        if (paramString1 != null)
        {
          paramString2.largeThumbnailFile = paramString1.largeThumbnailFile;
          paramString2.middleThumbnailFile = paramString1.middleThumbnailFile;
        }
      }
      a(paramString2);
      paramString1 = bbsm.a(this.e, paramString2);
      if (paramString1 == null)
      {
        return null;
        paramString1 = finally;
        throw paramString1;
      }
      paramString1.a();
      paramString1 = paramString2.getInfo(this.e);
      return paramString1;
    }
    finally {}
  }
  
  /* Error */
  public bbpe a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 79	bbqt:a	()Lbcil;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload 8
    //   13: aload_1
    //   14: aload_2
    //   15: lload_3
    //   16: iload 5
    //   18: invokevirtual 99	bcil:a	(Ljava/lang/String;Ljava/lang/String;JI)Lbbnr;
    //   21: astore 9
    //   23: aload 9
    //   25: ifnonnull +10 -> 35
    //   28: aload_0
    //   29: monitorexit
    //   30: aload 8
    //   32: monitorexit
    //   33: aconst_null
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 115	bbqt:c	()V
    //   39: iconst_0
    //   40: istore 6
    //   42: aload_0
    //   43: getfield 118	bbqt:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   46: aload 9
    //   48: getfield 113	bbnr:a	Ljava/util/UUID;
    //   51: invokeinterface 124 2 0
    //   56: checkcast 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   59: astore 7
    //   61: aload 7
    //   63: ifnonnull +165 -> 228
    //   66: new 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   69: dup
    //   70: aload 9
    //   72: invokespecial 129	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lbbnr;)V
    //   75: astore_1
    //   76: iconst_1
    //   77: istore 5
    //   79: aload_1
    //   80: aload_2
    //   81: putfield 132	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   84: aload_1
    //   85: lload_3
    //   86: putfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   89: aload_1
    //   90: lconst_0
    //   91: putfield 138	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   94: iload 5
    //   96: ifeq +8 -> 104
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 159	bbqt:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   104: aload_1
    //   105: getfield 132	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   108: invokestatic 298	arni:a	(Ljava/lang/String;)I
    //   111: iconst_2
    //   112: if_icmpne +196 -> 308
    //   115: aload_0
    //   116: getfield 29	bbqt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   119: invokestatic 303	aroo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   122: ifeq +186 -> 308
    //   125: aload_0
    //   126: getfield 29	bbqt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: invokevirtual 307	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   132: invokevirtual 313	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   135: new 315	bbqw
    //   138: dup
    //   139: aload_0
    //   140: aload_1
    //   141: invokespecial 318	bbqw:<init>	(Lbbqt;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   144: invokestatic 323	aqsz:a	(Landroid/content/Context;Laqte;)V
    //   147: aload_2
    //   148: invokestatic 328	arof:a	(Ljava/lang/String;)Ljava/lang/String;
    //   151: astore_2
    //   152: aload_0
    //   153: getfield 29	bbqt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   156: ldc_w 330
    //   159: ldc_w 332
    //   162: ldc_w 332
    //   165: ldc_w 334
    //   168: ldc_w 336
    //   171: iconst_0
    //   172: iconst_0
    //   173: ldc_w 332
    //   176: new 163	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   183: aload_0
    //   184: getfield 33	bbqt:e	J
    //   187: invokevirtual 339	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: ldc_w 332
    //   193: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: aload_2
    //   200: ldc_w 332
    //   203: invokestatic 344	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload_1
    //   207: aload_0
    //   208: getfield 33	bbqt:e	J
    //   211: invokevirtual 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lbbpe;
    //   214: astore_1
    //   215: aload_0
    //   216: monitorexit
    //   217: aload 8
    //   219: monitorexit
    //   220: aload_1
    //   221: areturn
    //   222: astore_1
    //   223: aload 8
    //   225: monitorexit
    //   226: aload_1
    //   227: athrow
    //   228: aload 7
    //   230: astore_1
    //   231: iload 6
    //   233: istore 5
    //   235: aload 7
    //   237: getfield 211	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   240: bipush 7
    //   242: if_icmpeq -163 -> 79
    //   245: aload 7
    //   247: getfield 211	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   250: bipush 11
    //   252: if_icmpne +21 -> 273
    //   255: aload 7
    //   257: astore_1
    //   258: iload 6
    //   260: istore 5
    //   262: aload 9
    //   264: getfield 347	bbnr:h	Ljava/lang/String;
    //   267: invokestatic 352	bdcs:a	(Ljava/lang/String;)Z
    //   270: ifeq -191 -> 79
    //   273: aload 7
    //   275: getfield 211	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   278: bipush 6
    //   280: if_icmpne +21 -> 301
    //   283: aload 7
    //   285: astore_1
    //   286: iload 6
    //   288: istore 5
    //   290: aload 9
    //   292: getfield 347	bbnr:h	Ljava/lang/String;
    //   295: invokestatic 352	bdcs:a	(Ljava/lang/String;)Z
    //   298: ifeq -219 -> 79
    //   301: aload_0
    //   302: monitorexit
    //   303: aload 8
    //   305: monitorexit
    //   306: aconst_null
    //   307: areturn
    //   308: invokestatic 205	bbrw:a	()Lbbrw;
    //   311: aload_0
    //   312: getfield 33	bbqt:e	J
    //   315: aload_1
    //   316: aconst_null
    //   317: invokevirtual 354	bbrw:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   320: pop
    //   321: goto -174 -> 147
    //   324: astore_1
    //   325: aload_0
    //   326: monitorexit
    //   327: aload_1
    //   328: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	bbqt
    //   0	329	1	paramString1	String
    //   0	329	2	paramString2	String
    //   0	329	3	paramLong	long
    //   0	329	5	paramInt	int
    //   40	247	6	i	int
    //   59	225	7	localItem	TroopFileTransferManager.Item
    //   4	300	8	localbcil	bcil
    //   21	270	9	localbbnr	bbnr
    // Exception table:
    //   from	to	target	type
    //   9	11	222	finally
    //   30	33	222	finally
    //   217	220	222	finally
    //   223	226	222	finally
    //   303	306	222	finally
    //   327	329	222	finally
    //   11	23	324	finally
    //   28	30	324	finally
    //   35	39	324	finally
    //   42	61	324	finally
    //   66	76	324	finally
    //   79	94	324	finally
    //   99	104	324	finally
    //   104	147	324	finally
    //   147	217	324	finally
    //   235	255	324	finally
    //   262	273	324	finally
    //   273	283	324	finally
    //   290	301	324	finally
    //   301	303	324	finally
    //   308	321	324	finally
    //   325	327	324	finally
  }
  
  public bbpe a(String paramString, boolean paramBoolean, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      Object localObject = ???.b(paramString);
      if (localObject == null) {
        return null;
      }
      c();
      localObject = new TroopFileTransferManager.Item((bbnr)localObject);
      ((TroopFileTransferManager.Item)localObject).BusId = 102;
      ((TroopFileTransferManager.Item)localObject).isFromAIO = paramBoolean;
      ((TroopFileTransferManager.Item)localObject).RandomNum = paramInt;
      paramString = new VFSFile(paramString);
      if (paramString.exists()) {
        ((TroopFileTransferManager.Item)localObject).origLastModifyTime = paramString.lastModified();
      }
      a((TroopFileTransferManager.Item)localObject);
      if (bdee.a(BaseApplication.getContext()) == 0)
      {
        a((TroopFileTransferManager.Item)localObject, 3, 106);
        paramString = ((TroopFileTransferManager.Item)localObject).getInfo(this.e);
        return paramString;
        paramString = finally;
        throw paramString;
      }
      bbtf.a().a(this.e, (TroopFileTransferManager.Item)localObject, null);
      paramString = ((TroopFileTransferManager.Item)localObject).getInfo(this.e);
      return paramString;
    }
    finally {}
  }
  
  public TroopFileTransferManager.Item a(UUID paramUUID, boolean paramBoolean)
  {
    try
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
      if ((paramBoolean) && (localItem != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.e, paramUUID);
      }
      return localItem;
    }
    finally {}
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Bbth == null)
    {
      this.jdField_a_of_type_Bbth = new bbqu(this);
      bbtf.a().addObserver(this.jdField_a_of_type_Bbth);
    }
    if (this.jdField_a_of_type_Bbrz == null)
    {
      this.jdField_a_of_type_Bbrz = new bbqv(this);
      bbrw.a().addObserver(this.jdField_a_of_type_Bbrz);
    }
    bbrc.c("TroopFileTransferMgr", bbrc.a, "init");
  }
  
  /* Error */
  public void a(bbnr parambbnr)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 79	bbqt:a	()Lbcil;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: ifnonnull +9 -> 21
    //   15: aload_0
    //   16: monitorexit
    //   17: aload 4
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: invokevirtual 115	bbqt:c	()V
    //   25: aload_0
    //   26: getfield 118	bbqt:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   29: aload_1
    //   30: getfield 113	bbnr:a	Ljava/util/UUID;
    //   33: invokeinterface 124 2 0
    //   38: checkcast 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   41: astore_3
    //   42: aload_3
    //   43: astore_2
    //   44: aload_3
    //   45: ifnonnull +17 -> 62
    //   48: new 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 129	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lbbnr;)V
    //   56: astore_2
    //   57: aload_0
    //   58: aload_2
    //   59: invokevirtual 159	bbqt:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   62: aload_2
    //   63: aload_1
    //   64: getfield 443	bbnr:j	Ljava/lang/String;
    //   67: putfield 277	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:largeThumbnailFile	Ljava/lang/String;
    //   70: aload_2
    //   71: aload_1
    //   72: getfield 446	bbnr:k	Ljava/lang/String;
    //   75: putfield 280	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:middleThumbnailFile	Ljava/lang/String;
    //   78: aload_2
    //   79: aload_1
    //   80: getfield 448	bbnr:i	Ljava/lang/String;
    //   83: putfield 451	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:smallThumbFile	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_2
    //   88: invokevirtual 453	bbqt:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: aload 4
    //   95: monitorexit
    //   96: return
    //   97: astore_1
    //   98: aload 4
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	bbqt
    //   0	108	1	parambbnr	bbnr
    //   43	45	2	localItem1	TroopFileTransferManager.Item
    //   41	4	3	localItem2	TroopFileTransferManager.Item
    //   4	95	4	localbcil	bcil
    // Exception table:
    //   from	to	target	type
    //   9	11	97	finally
    //   17	20	97	finally
    //   93	96	97	finally
    //   98	101	97	finally
    //   106	108	97	finally
    //   15	17	103	finally
    //   21	42	103	finally
    //   48	62	103	finally
    //   62	93	103	finally
    //   104	106	103	finally
  }
  
  public void a(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramItem);
      if (paramItem.troopuin == 0L) {
        paramItem.troopuin = this.e;
      }
      if (paramItem.troopuin != this.e)
      {
        bbrc.b("TroopFileTransferMgr", bbrc.a, "newItem troop confit. item.troopuin:" + paramItem.troopuin + " mTroopUin" + this.e);
        paramItem.troopuin = this.e;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramItem, null);
      return;
    }
    finally {}
  }
  
  public void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    try
    {
      bbqm.a(this.e, paramItem, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public void a(TroopFileTransferManager.Item paramItem, int paramInt, bcii parambcii)
  {
    try
    {
      bbqm.a(this.e, paramItem, paramInt, parambcii);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  @Deprecated
  public void a(TroopFileTransferManager.Item paramItem, int paramInt, boolean paramBoolean)
  {
    try
    {
      bbrc.b("TroopFileTransferMgr", bbrc.a, "!!!warning: oldver fun: doReqDownload be called");
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 79	bbqt:a	()Lbcil;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +9 -> 24
    //   18: aload_0
    //   19: monitorexit
    //   20: aload 6
    //   22: monitorexit
    //   23: return
    //   24: aload 6
    //   26: aload_2
    //   27: lload_3
    //   28: bipush 25
    //   30: invokevirtual 215	bcil:a	(Ljava/lang/String;JI)Lbbnr;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnonnull +15 -> 50
    //   38: aload_0
    //   39: monitorexit
    //   40: aload 6
    //   42: monitorexit
    //   43: return
    //   44: astore_1
    //   45: aload 6
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: aload_0
    //   51: invokevirtual 115	bbqt:c	()V
    //   54: new 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 129	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lbbnr;)V
    //   62: astore_2
    //   63: aload_2
    //   64: aload_1
    //   65: putfield 221	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardPath	Ljava/lang/String;
    //   68: aload_2
    //   69: aload_0
    //   70: getfield 29	bbqt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   73: invokevirtual 487	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   76: invokestatic 492	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   79: invokevirtual 495	java/lang/Long:longValue	()J
    //   82: putfield 224	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   85: aload_2
    //   86: iload 5
    //   88: putfield 227	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   91: aload_2
    //   92: iconst_4
    //   93: putfield 211	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   96: aload_2
    //   97: bipush 25
    //   99: putfield 361	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   102: aload_0
    //   103: aload_2
    //   104: invokevirtual 159	bbqt:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   107: aload_0
    //   108: getfield 33	bbqt:e	J
    //   111: aload_2
    //   112: invokestatic 500	bbsi:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Lbbsi;
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull +14 -> 131
    //   120: aload_1
    //   121: invokevirtual 501	bbsi:a	()I
    //   124: pop
    //   125: aload_0
    //   126: monitorexit
    //   127: aload 6
    //   129: monitorexit
    //   130: return
    //   131: ldc 161
    //   133: getstatic 436	bbrc:a	I
    //   136: ldc_w 503
    //   139: invokestatic 505	bbrc:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: goto -17 -> 125
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	bbqt
    //   0	150	1	paramString1	String
    //   0	150	2	paramString2	String
    //   0	150	3	paramLong	long
    //   0	150	5	paramInt	int
    //   4	124	6	localbcil	bcil
    // Exception table:
    //   from	to	target	type
    //   9	11	44	finally
    //   20	23	44	finally
    //   40	43	44	finally
    //   45	48	44	finally
    //   127	130	44	finally
    //   148	150	44	finally
    //   11	20	145	finally
    //   24	34	145	finally
    //   38	40	145	finally
    //   50	116	145	finally
    //   120	125	145	finally
    //   125	127	145	finally
    //   131	142	145	finally
    //   146	148	145	finally
  }
  
  public void a(Collection<String> paramCollection, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject2;
      synchronized (a())
      {
        try
        {
          if (bdee.a(BaseApplication.getContext()) == 0)
          {
            i = 1;
            paramCollection = paramCollection.iterator();
            if (!paramCollection.hasNext()) {
              break;
            }
            Object localObject1 = (String)paramCollection.next();
            localObject2 = ???.b((String)localObject1);
            if (localObject2 == null) {
              continue;
            }
            c();
            localObject2 = new TroopFileTransferManager.Item((bbnr)localObject2);
            ((TroopFileTransferManager.Item)localObject2).BusId = 102;
            ((TroopFileTransferManager.Item)localObject2).isFromAIO = paramBoolean;
            localObject1 = new VFSFile((String)localObject1);
            if (((VFSFile)localObject1).exists()) {
              ((TroopFileTransferManager.Item)localObject2).origLastModifyTime = ((VFSFile)localObject1).lastModified();
            }
            a((TroopFileTransferManager.Item)localObject2);
            if (i == 0) {
              break label158;
            }
            a((TroopFileTransferManager.Item)localObject2, 3, 106);
            continue;
            paramCollection = finally;
          }
        }
        finally {}
      }
      int i = 0;
      continue;
      label158:
      bbtf.a().a(this.e, (TroopFileTransferManager.Item)localObject2, null);
    }
  }
  
  public void a(List<bbpe> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList;
    synchronized (a())
    {
      try
      {
        c();
        localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          bbpe localbbpe = (bbpe)paramList.next();
          if (!TextUtils.isEmpty(localbbpe.e))
          {
            Object localObject = ???.a(localbbpe.g, localbbpe.c, 25);
            if (localObject != null)
            {
              localObject = new TroopFileTransferManager.Item((bbnr)localObject);
              a((TroopFileTransferManager.Item)localObject);
              ((TroopFileTransferManager.Item)localObject).ForwardPath = localbbpe.e;
              ((TroopFileTransferManager.Item)localObject).ForwardTroopuin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
              ((TroopFileTransferManager.Item)localObject).ForwardBusId = localbbpe.h;
              ((TroopFileTransferManager.Item)localObject).Status = 4;
              ((TroopFileTransferManager.Item)localObject).BusId = 25;
              localArrayList.add(localObject);
              continue;
              paramList = finally;
            }
          }
        }
      }
      finally {}
    }
    if (localArrayList.size() == 0) {
      return;
    }
    paramList = bbsk.a(this.e, localArrayList);
    if (paramList != null) {
      paramList.a();
    }
    for (;;)
    {
      return;
      bbrc.a("TroopFileTransferMgr", bbrc.a, "startMultiCopyToWeiyun forwarder=null");
    }
  }
  
  /* Error */
  public void a(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 115	bbqt:c	()V
    //   6: aload_0
    //   7: getfield 118	bbqt:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 124 2 0
    //   16: checkcast 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   19: astore_2
    //   20: aload_2
    //   21: ifnonnull +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: ldc 161
    //   29: getstatic 436	bbrc:a	I
    //   32: new 163	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 560
    //   42: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 177	java/util/UUID:toString	()Ljava/lang/String;
    //   49: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 562
    //   55: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 440	bbrc:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: new 564	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr$3
    //   67: dup
    //   68: aload_0
    //   69: aload_2
    //   70: aload_1
    //   71: invokespecial 567	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr$3:<init>	(Lbbqt;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Ljava/util/UUID;)V
    //   74: iconst_5
    //   75: aconst_null
    //   76: iconst_0
    //   77: invokestatic 572	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   80: goto -56 -> 24
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	bbqt
    //   0	88	1	paramUUID	UUID
    //   19	51	2	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   2	20	83	finally
    //   27	80	83	finally
  }
  
  @Deprecated
  public boolean a()
  {
    try
    {
      bbrc.b("TroopFileTransferMgr", bbrc.a, "!!!warning: oldver fun: saveStatus be called");
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    return bbsw.a(this.e, paramItem, paramInt);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    bbnr localbbnr;
    synchronized (a()) {}
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    synchronized (a()) {}
    try
    {
      int i = arni.a(arof.a(paramString2));
      if ((i != 0) && (i != 2)) {
        return false;
      }
      bbnr localbbnr = ???.a(paramString1, paramString2, 0L, paramInt1);
      if (localbbnr == null)
      {
        return false;
        paramString1 = finally;
        throw paramString1;
      }
      c();
      paramString2 = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(localbbnr.a);
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = new TroopFileTransferManager.Item(localbbnr);
        a(paramString1);
      }
      bbsw.a().a(this.e, paramString1, paramInt2);
      return true;
    }
    finally {}
  }
  
  /* Error */
  public boolean a(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 115	bbqt:c	()V
    //   8: aload_0
    //   9: getfield 118	bbqt:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 124 2 0
    //   18: checkcast 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +7 -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: invokestatic 395	bbtf:a	()Lbbtf;
    //   35: aload_1
    //   36: aconst_null
    //   37: invokevirtual 595	bbtf:a	(Ljava/util/UUID;Landroid/os/Bundle;)I
    //   40: istore_2
    //   41: iload_2
    //   42: ifne +8 -> 50
    //   45: iconst_1
    //   46: istore_3
    //   47: goto -19 -> 28
    //   50: iconst_0
    //   51: istore_3
    //   52: goto -5 -> 47
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	bbqt
    //   0	60	1	paramUUID	UUID
    //   40	2	2	i	int
    //   1	51	3	bool	boolean
    //   21	3	4	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   4	23	55	finally
    //   32	41	55	finally
  }
  
  public boolean a(UUID paramUUID, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      bbnr localbbnr = ???.a(paramUUID);
      if (localbbnr == null) {
        return false;
      }
      int i = arni.a(arof.a(localbbnr.c));
      if ((i != 0) && (i != 2))
      {
        return false;
        paramUUID = finally;
        throw paramUUID;
      }
      c();
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
      paramUUID = localItem;
      if (localItem == null)
      {
        paramUUID = new TroopFileTransferManager.Item(localbbnr);
        a(paramUUID);
      }
      bbsw.a().a(this.e, paramUUID, paramInt);
      return true;
    }
    finally {}
  }
  
  public void b()
  {
    bbrc.c("TroopFileTransferMgr", bbrc.a, "release");
    if (this.jdField_a_of_type_Bbth != null)
    {
      bbtf.a().deleteObserver(this.jdField_a_of_type_Bbth);
      this.jdField_a_of_type_Bbth = null;
    }
    if (this.jdField_a_of_type_Bbrz != null)
    {
      bbrw.a().deleteObserver(this.jdField_a_of_type_Bbrz);
      this.jdField_a_of_type_Bbrz = null;
    }
  }
  
  public void b(TroopFileTransferManager.Item paramItem)
  {
    bbqm.a(this.e, paramItem);
  }
  
  /* Error */
  public boolean b(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 115	bbqt:c	()V
    //   8: aload_0
    //   9: getfield 118	bbqt:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 124 2 0
    //   18: checkcast 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +7 -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: invokestatic 395	bbtf:a	()Lbbtf;
    //   33: aload_0
    //   34: getfield 33	bbqt:e	J
    //   37: aload_1
    //   38: aconst_null
    //   39: invokevirtual 396	bbtf:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   42: istore_2
    //   43: iload_2
    //   44: ifne +8 -> 52
    //   47: iconst_1
    //   48: istore_3
    //   49: goto -23 -> 26
    //   52: iconst_0
    //   53: istore_3
    //   54: goto -5 -> 49
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	bbqt
    //   0	62	1	paramUUID	UUID
    //   42	2	2	i	int
    //   1	53	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	22	57	finally
    //   30	43	57	finally
  }
  
  public void c()
  {
    try
    {
      boolean bool = this.b;
      if (bool) {
        label11:
        return;
      }
      this.b = true;
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.e);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      if ((!jdField_a_of_type_Boolean) && (localList == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    Object localObject2;
    if (localObject1 != null)
    {
      localIterator = localObject1.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (TroopFileTansferItemEntity)localIterator.next();
        if (((TroopFileTansferItemEntity)localObject2).Id != null)
        {
          if (!((TroopFileTansferItemEntity)localObject2).isCheckPrivateDir)
          {
            ((TroopFileTansferItemEntity)localObject2).isCheckPrivateDir = true;
            if (!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).LocalFile)) {
              ((TroopFileTansferItemEntity)localObject2).LocalFile = bduw.a(((TroopFileTansferItemEntity)localObject2).LocalFile);
            }
            if (!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).smallThumbFile)) {
              ((TroopFileTansferItemEntity)localObject2).smallThumbFile = bduw.a(((TroopFileTansferItemEntity)localObject2).smallThumbFile);
            }
            if (!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).largeThumbnailFile)) {
              ((TroopFileTansferItemEntity)localObject2).largeThumbnailFile = bduw.a(((TroopFileTansferItemEntity)localObject2).largeThumbnailFile);
            }
            if (!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).middleThumbnailFile)) {
              ((TroopFileTansferItemEntity)localObject2).middleThumbnailFile = bduw.a(((TroopFileTansferItemEntity)localObject2).middleThumbnailFile);
            }
          }
          this.jdField_a_of_type_JavaUtilMap.put(((TroopFileTansferItemEntity)localObject2).Id, new TroopFileTransferManager.Item((TroopFileTansferItemEntity)localObject2));
        }
        else
        {
          bbrc.a("TroopFileTransferMgr", bbrc.a, "entity.Id is null");
        }
      }
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext()) {
        localObject2 = (TroopFileTransferManager.Item)localIterator.next();
      }
      switch (((TroopFileTransferManager.Item)localObject2).Status)
      {
      case 0: 
      case 1: 
        ((TroopFileTransferManager.Item)localObject2).Status = 3;
        break;
      case 8: 
        ((TroopFileTransferManager.Item)localObject2).Status = 10;
        continue;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          ThreadManager.post(new TroopFileTransferMgr.5(this), 8, null, true);
          break label11;
        }
        c();
        break label11;
      }
    }
  }
  
  public void c(TroopFileTransferManager.Item paramItem)
  {
    paramItem = bbtc.a(this.e, paramItem);
    if (paramItem != null) {
      paramItem.j();
    }
  }
  
  /* Error */
  public boolean c(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 115	bbqt:c	()V
    //   8: aload_0
    //   9: getfield 118	bbqt:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 124 2 0
    //   18: checkcast 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +7 -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: aload_1
    //   31: getfield 141	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   34: ifeq +21 -> 55
    //   37: invokestatic 205	bbrw:a	()Lbbrw;
    //   40: aload_0
    //   41: getfield 33	bbqt:e	J
    //   44: aload_1
    //   45: aconst_null
    //   46: invokevirtual 208	bbrw:b	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   49: pop
    //   50: iconst_1
    //   51: istore_3
    //   52: goto -26 -> 26
    //   55: invokestatic 205	bbrw:a	()Lbbrw;
    //   58: aload_0
    //   59: getfield 33	bbqt:e	J
    //   62: aload_1
    //   63: aconst_null
    //   64: invokevirtual 354	bbrw:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   67: istore_2
    //   68: iload_2
    //   69: ifne +8 -> 77
    //   72: iconst_1
    //   73: istore_3
    //   74: goto -48 -> 26
    //   77: iconst_0
    //   78: istore_3
    //   79: goto -5 -> 74
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	bbqt
    //   0	87	1	paramUUID	UUID
    //   67	2	2	i	int
    //   1	78	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	22	82	finally
    //   30	50	82	finally
    //   55	68	82	finally
  }
  
  public void d()
  {
    for (;;)
    {
      TroopFileTransferManager.Item localItem;
      Bundle localBundle;
      try
      {
        c();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
        if (!localIterator.hasNext()) {
          break label204;
        }
        localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem.W2MPause != 2) {
          continue;
        }
        localItem.W2MPause = 0;
        localBundle = new Bundle();
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
        case 8: 
          localItem.Pausing = 0;
          break;
        case 2: 
          localBundle.putBoolean("_wifi2mobile_resume_", true);
        }
      }
      finally {}
      bbtf.a().a(this.e, localItem, localBundle);
      continue;
      localBundle.putBoolean("_wifi2mobile_resume_", true);
      if (localItem.isZipInnerFile)
      {
        bbrw.a().b(this.e, localItem, localBundle);
      }
      else
      {
        bbrw.a().a(this.e, localItem, localBundle);
        continue;
        label204:
        return;
      }
    }
  }
  
  public void d(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      bbqm.b(this.e, paramItem);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  /* Error */
  public boolean d(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 115	bbqt:c	()V
    //   8: aload_0
    //   9: getfield 118	bbqt:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 124 2 0
    //   18: checkcast 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +7 -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: invokestatic 205	bbrw:a	()Lbbrw;
    //   35: aload_1
    //   36: aconst_null
    //   37: invokevirtual 674	bbrw:a	(Ljava/util/UUID;Landroid/os/Bundle;)I
    //   40: istore_2
    //   41: aload 4
    //   43: getfield 132	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   46: invokestatic 298	arni:a	(Ljava/lang/String;)I
    //   49: iconst_2
    //   50: if_icmpne +29 -> 79
    //   53: aload_0
    //   54: getfield 29	bbqt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokestatic 303	aroo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   60: ifeq +19 -> 79
    //   63: aload 4
    //   65: getfield 677	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   68: invokestatic 679	aqsz:a	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: aload 4
    //   74: bipush 9
    //   76: invokevirtual 682	bbqt:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   79: iload_2
    //   80: ifne +8 -> 88
    //   83: iconst_1
    //   84: istore_3
    //   85: goto -57 -> 28
    //   88: iconst_0
    //   89: istore_3
    //   90: goto -5 -> 85
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	bbqt
    //   0	98	1	paramUUID	UUID
    //   40	40	2	i	int
    //   1	89	3	bool	boolean
    //   21	52	4	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   4	23	93	finally
    //   32	79	93	finally
  }
  
  @Deprecated
  public void e()
  {
    try
    {
      bbrc.b("TroopFileTransferMgr", bbrc.a, "!!!warning: oldver fun: Interrupt be called");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public void e(TroopFileTransferManager.Item paramItem)
  {
    bbrc.b("TroopFileTransferMgr", bbrc.a, "!!!warning: oldver fun: doReqUpload be called");
  }
  
  public boolean e(UUID paramUUID)
  {
    bbnr localbbnr;
    TroopFileTransferManager.Item localItem;
    synchronized (a()) {}
  }
  
  @Deprecated
  public void f(TroopFileTransferManager.Item paramItem)
  {
    bbrc.b("TroopFileTransferMgr", bbrc.a, "!!!warning: oldver fun: doReqResend be called");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqt
 * JD-Core Version:    0.7.0.1
 */