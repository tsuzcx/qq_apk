import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicManager.1;
import com.tencent.mobileqq.hotpic.HotPicManager.2;
import com.tencent.mobileqq.hotpic.HotPicManager.5;
import com.tencent.mobileqq.hotpic.HotPicSendData;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetImgInfoReq;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetVideoInfoReq;
import com.tencent.pb.hotpicmsg.HotPicMsg.ReqBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;

public class aqfa
  implements Handler.Callback, Manager
{
  public int a;
  private SparseArray<ArrayList<HotPicData>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  aqfc jdField_a_of_type_Aqfc;
  private aqhg jdField_a_of_type_Aqhg;
  private atmp jdField_a_of_type_Atmp;
  private befq jdField_a_of_type_Befq = new befq(ThreadManager.getFileThreadLooper(), this);
  public QQAppInterface a;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private LinkedList<HotPicSendData> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List<HotPicTagInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  volatile boolean jdField_a_of_type_Boolean = false;
  private SparseArray<ArrayList<HotPicData>> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private List<HotPicTagInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  boolean c = false;
  boolean d = false;
  boolean e = false;
  private boolean f;
  private boolean g;
  
  public aqfa(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("sp_hotpic_" + paramQQAppInterface.c(), 0).getInt("k_hotlist_config_v", 0);
  }
  
  public static aqfa a(QQAppInterface paramQQAppInterface)
  {
    return (aqfa)paramQQAppInterface.getManager(206);
  }
  
  public static ArrayList<HotVideoData> a(ArrayList<HotPicData> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      HotPicData localHotPicData = (HotPicData)paramArrayList.next();
      if (localHotPicData.getDataType() == 2) {
        localArrayList.add((HotVideoData)localHotPicData);
      }
    }
    return localArrayList;
  }
  
  private void a(ArrayList<HotPicTagInfo> paramArrayList)
  {
    try
    {
      this.jdField_a_of_type_Atmp.a(HotPicTagInfo.class);
      paramArrayList = ((ArrayList)paramArrayList.clone()).iterator();
      while (paramArrayList.hasNext())
      {
        HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)paramArrayList.next();
        this.jdField_a_of_type_Atmp.b(localHotPicTagInfo);
      }
    }
    finally {}
  }
  
  private void a(List<HotPicTagInfo> paramList, int paramInt)
  {
    HotPicTagInfo localHotPicTagInfo = new HotPicTagInfo();
    localHotPicTagInfo.tagName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131633312);
    localHotPicTagInfo.version = paramInt;
    localHotPicTagInfo.tagId = 2;
    localHotPicTagInfo.tagType = 1;
    localHotPicTagInfo.position = 0;
    paramList.add(localHotPicTagInfo);
    localHotPicTagInfo = new HotPicTagInfo();
    localHotPicTagInfo.tagName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131633313);
    localHotPicTagInfo.version = paramInt;
    localHotPicTagInfo.tagId = -20;
    localHotPicTagInfo.tagType = 255;
    localHotPicTagInfo.position = 1;
    paramList.add(localHotPicTagInfo);
  }
  
  private void a(List<HotVideoData> paramList, boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotPicManager", 2, "updateHotVideoData " + paramBoolean);
      }
      if (paramBoolean) {
        this.jdField_a_of_type_Atmp.a(HotVideoData.class);
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        HotPicData localHotPicData = (HotPicData)localIterator.next();
        this.jdField_a_of_type_Atmp.b(localHotPicData);
        if (QLog.isColorLevel()) {
          QLog.i("HotPicManager", 2, "updateHotVideoData " + localHotPicData.toString());
        }
      }
      if (!QLog.isColorLevel()) {
        break label162;
      }
    }
    finally {}
    QLog.i("HotPicManager", 2, "updateHotVideoData size:" + paramList.size());
    label162:
  }
  
  /* Error */
  private void b(List<HotPicData> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 219
    //   10: iconst_2
    //   11: new 97	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   18: ldc 243
    //   20: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_2
    //   24: invokevirtual 224	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 228	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: iload_2
    //   34: ifeq +13 -> 47
    //   37: aload_0
    //   38: getfield 133	aqfa:jdField_a_of_type_Atmp	Latmp;
    //   41: ldc 150
    //   43: invokevirtual 170	atmp:a	(Ljava/lang/Class;)Z
    //   46: pop
    //   47: aload_0
    //   48: getfield 133	aqfa:jdField_a_of_type_Atmp	Latmp;
    //   51: invokevirtual 246	atmp:a	()Latmr;
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual 250	atmr:a	()V
    //   59: aload_1
    //   60: invokeinterface 229 1 0
    //   65: astore_1
    //   66: aload_1
    //   67: invokeinterface 144 1 0
    //   72: ifeq +38 -> 110
    //   75: aload_1
    //   76: invokeinterface 148 1 0
    //   81: checkcast 150	com/tencent/mobileqq/hotpic/HotPicData
    //   84: astore 4
    //   86: aload_0
    //   87: getfield 133	aqfa:jdField_a_of_type_Atmp	Latmp;
    //   90: aload 4
    //   92: invokevirtual 176	atmp:b	(Latmo;)V
    //   95: goto -29 -> 66
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   103: aload_3
    //   104: invokevirtual 255	atmr:b	()V
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: aload_3
    //   111: invokevirtual 257	atmr:c	()V
    //   114: aload_3
    //   115: invokevirtual 255	atmr:b	()V
    //   118: goto -11 -> 107
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    //   126: astore_1
    //   127: aload_3
    //   128: invokevirtual 255	atmr:b	()V
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	aqfa
    //   0	133	1	paramList	List<HotPicData>
    //   0	133	2	paramBoolean	boolean
    //   54	74	3	localatmr	atmr
    //   84	7	4	localHotPicData	HotPicData
    // Exception table:
    //   from	to	target	type
    //   55	66	98	java/lang/Exception
    //   66	95	98	java/lang/Exception
    //   110	114	98	java/lang/Exception
    //   2	33	121	finally
    //   37	47	121	finally
    //   47	55	121	finally
    //   103	107	121	finally
    //   114	118	121	finally
    //   127	133	121	finally
    //   55	66	126	finally
    //   66	95	126	finally
    //   99	103	126	finally
    //   110	114	126	finally
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	aqfa:e	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 83	aqfa:e	Z
    //   19: new 260	java/io/File
    //   22: dup
    //   23: getstatic 264	aqes:a	Ljava/lang/String;
    //   26: invokespecial 267	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 4
    //   31: aload 4
    //   33: invokevirtual 271	java/io/File:listFiles	()[Ljava/io/File;
    //   36: astore_3
    //   37: aload 4
    //   39: invokevirtual 274	java/io/File:exists	()Z
    //   42: ifeq -31 -> 11
    //   45: aload 4
    //   47: invokevirtual 277	java/io/File:isDirectory	()Z
    //   50: ifeq -39 -> 11
    //   53: aload_3
    //   54: arraylength
    //   55: istore_1
    //   56: iload_1
    //   57: sipush 500
    //   60: if_icmple -49 -> 11
    //   63: aload_3
    //   64: new 279	aqfb
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 282	aqfb:<init>	(Laqfa;)V
    //   72: invokestatic 288	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
    //   75: new 42	java/util/HashSet
    //   78: dup
    //   79: invokespecial 43	java/util/HashSet:<init>	()V
    //   82: astore 4
    //   84: aload_0
    //   85: getfield 81	aqfa:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   88: invokevirtual 289	java/util/LinkedList:clone	()Ljava/lang/Object;
    //   91: checkcast 78	java/util/LinkedList
    //   94: invokeinterface 229 1 0
    //   99: astore 5
    //   101: aload 5
    //   103: invokeinterface 144 1 0
    //   108: ifeq +64 -> 172
    //   111: aload 5
    //   113: invokeinterface 148 1 0
    //   118: checkcast 150	com/tencent/mobileqq/hotpic/HotPicData
    //   121: getfield 292	com/tencent/mobileqq/hotpic/HotPicData:url	Ljava/lang/String;
    //   124: invokestatic 295	aqes:a	(Ljava/lang/String;)Ljava/io/File;
    //   127: astore 6
    //   129: aload 6
    //   131: ifnull -30 -> 101
    //   134: aload 4
    //   136: aload 6
    //   138: invokeinterface 298 2 0
    //   143: pop
    //   144: goto -43 -> 101
    //   147: astore_3
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_3
    //   151: athrow
    //   152: astore 4
    //   154: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq -82 -> 75
    //   160: ldc 219
    //   162: iconst_2
    //   163: ldc_w 300
    //   166: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: goto -94 -> 75
    //   172: new 71	java/util/ArrayList
    //   175: dup
    //   176: invokespecial 72	java/util/ArrayList:<init>	()V
    //   179: astore 5
    //   181: sipush 500
    //   184: istore_1
    //   185: iload_1
    //   186: aload_3
    //   187: arraylength
    //   188: if_icmpge +46 -> 234
    //   191: aload_3
    //   192: iload_1
    //   193: aaload
    //   194: astore 6
    //   196: aload 4
    //   198: aload 6
    //   200: invokeinterface 305 2 0
    //   205: ifeq +16 -> 221
    //   208: aload 4
    //   210: aload 6
    //   212: invokeinterface 308 2 0
    //   217: pop
    //   218: goto +87 -> 305
    //   221: aload 5
    //   223: aload 6
    //   225: invokeinterface 209 2 0
    //   230: pop
    //   231: goto +74 -> 305
    //   234: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +35 -> 272
    //   240: ldc 219
    //   242: iconst_2
    //   243: new 97	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 310
    //   253: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload 5
    //   258: invokeinterface 235 1 0
    //   263: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload 5
    //   274: invokeinterface 229 1 0
    //   279: astore_3
    //   280: aload_3
    //   281: invokeinterface 144 1 0
    //   286: ifeq -275 -> 11
    //   289: aload_3
    //   290: invokeinterface 148 1 0
    //   295: checkcast 260	java/io/File
    //   298: invokevirtual 313	java/io/File:delete	()Z
    //   301: pop
    //   302: goto -22 -> 280
    //   305: iload_1
    //   306: iconst_1
    //   307: iadd
    //   308: istore_1
    //   309: goto -124 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	aqfa
    //   55	254	1	i	int
    //   6	2	2	bool	boolean
    //   36	28	3	arrayOfFile	java.io.File[]
    //   147	45	3	localObject1	Object
    //   279	11	3	localIterator	Iterator
    //   29	106	4	localObject2	Object
    //   152	57	4	localException	Exception
    //   99	174	5	localObject3	Object
    //   127	97	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   2	7	147	finally
    //   14	56	147	finally
    //   63	75	147	finally
    //   75	101	147	finally
    //   101	129	147	finally
    //   134	144	147	finally
    //   154	169	147	finally
    //   172	181	147	finally
    //   185	191	147	finally
    //   196	218	147	finally
    //   221	231	147	finally
    //   234	272	147	finally
    //   272	280	147	finally
    //   280	302	147	finally
    //   63	75	152	java/lang/Exception
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("sp_hotpic_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getInt("hot_pic_last_click", -1);
  }
  
  public ArrayList<HotPicTagInfo> a()
  {
    return (ArrayList)this.jdField_a_of_type_JavaUtilList;
  }
  
  public ArrayList<HotPicData> a(int paramInt)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        Object localObject1 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          return localObject1;
        }
        localArrayList = (ArrayList)((ArrayList)localObject1).clone();
        localObject1 = localArrayList;
        if (!a(paramInt)) {
          continue;
        }
        localObject1 = localArrayList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          HotPicData localHotPicData = (HotPicData)((Iterator)localObject1).next();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("HotPicManager", 2, "getHotPics IsVideo " + localHotPicData.toString());
          continue;
        }
        localObject3 = localArrayList;
      }
      finally {}
      Object localObject3;
      if (QLog.isColorLevel())
      {
        QLog.d("HotPicManager", 2, "getHotPics IsVideo size:" + localArrayList.size());
        localObject3 = localArrayList;
      }
    }
  }
  
  public LinkedList<HotPicSendData> a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList;
  }
  
  List<HotPicData> a()
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (a(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i))) {}
      for (;;)
      {
        i += 1;
        break;
        ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
          localArrayList1.addAll(localArrayList2);
        }
      }
    }
    return localArrayList1;
  }
  
  public void a()
  {
    for (;;)
    {
      int j;
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("sp_hotpic_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
          this.jdField_b_of_type_Boolean = ((SharedPreferences)localObject1).getBoolean("k_hotlist_f", true);
          this.c = ((SharedPreferences)localObject1).getBoolean("k_hotlist_s_e", false);
          this.jdField_a_of_type_Atmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          try
          {
            this.jdField_a_of_type_JavaUtilList = ((ArrayList)this.jdField_a_of_type_Atmp.a(HotPicTagInfo.class, true, null, null, null, null, "position asc", null));
            if (this.jdField_a_of_type_JavaUtilList == null)
            {
              this.jdField_a_of_type_JavaUtilList = new ArrayList();
              a(this.jdField_a_of_type_JavaUtilList, 0);
            }
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            if (!localIterator.hasNext()) {
              break label416;
            }
            HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
            int i = localHotPicTagInfo.tagType;
            if (i == 255) {
              continue;
            }
            j = localHotPicTagInfo.tagId;
            localObject1 = new String[1];
            localObject1[0] = String.valueOf(j);
            if (i != 2) {
              continue;
            }
            localArrayList2 = (ArrayList)this.jdField_a_of_type_Atmp.a(HotVideoData.class, true, "tag = ?", (String[])localObject1, null, null, "picIndex asc", null);
            localObject1 = localArrayList2;
            if (localArrayList2 == null) {
              localObject1 = new ArrayList();
            }
            localArrayList2 = new ArrayList();
            localArrayList2.addAll((Collection)localObject1);
            this.jdField_a_of_type_AndroidUtilSparseArray.put(j, localArrayList2);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("HotPicManager", 2, "makesureInit localTagInfo name is " + localHotPicTagInfo.tagName);
            continue;
            if (localObject2 == null) {
              continue;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            localObject2 = null;
          }
          Collections.sort((List)localObject2, Collections.reverseOrder());
          this.jdField_a_of_type_JavaUtilLinkedList.addAll((Collection)localObject2);
          this.jdField_a_of_type_Int = a();
        }
        return;
      }
      finally {}
      ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_Atmp.a(HotPicData.class, true, "tag = ?", (String[])localObject2, null, null, "picIndex asc", null);
      Object localObject2 = localArrayList2;
      if (localArrayList2 == null) {
        localObject2 = new ArrayList();
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(j, localObject2);
      continue;
      label416:
      ArrayList localArrayList1 = (ArrayList)this.jdField_a_of_type_Atmp.a(HotPicSendData.class, true, null, null, null, null, null, null);
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    HotPicTagInfo localHotPicTagInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
    } while ((localHotPicTagInfo.tagId != paramInt) || (localHotPicTagInfo.tagType != 2));
    for (int i = 10003;; i = 10002)
    {
      a(i, paramInt);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new HotPicManager.2(this, paramInt1, paramInt2), 8, null, false);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    int j = 1;
    int i = 1;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager", 2, "requestHotPicList " + paramInt1 + "-" + paramInt2 + " version= " + paramInt3 + " tag= " + paramInt4 + " checkUpdate" + paramBoolean + " reqType= " + paramInt5);
        }
        Object localObject1 = new HotPicMsg.ReqBody();
        if (paramInt5 == 10003)
        {
          localObject3 = new HotPicMsg.GetVideoInfoReq();
          ((HotPicMsg.ReqBody)localObject1).setHasFlag(true);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint64_src_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_src_term.set(3);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_start_video_index.set(paramInt1);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_end_video_index.set(paramInt2);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_build_ver.set(paramInt3);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_tag_id.set(paramInt4);
          ((HotPicMsg.GetVideoInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("8.2.6"));
          localObject4 = ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_need_update;
          if (paramBoolean)
          {
            paramInt1 = i;
            ((PBUInt32Field)localObject4).set(paramInt1);
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + SystemClock.uptimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("HotPicManager", 2, "sessionId:" + (String)localObject4);
            }
            ((HotPicMsg.GetVideoInfoReq)localObject3).bytes_session_id.set(ByteStringMicro.copyFromUtf8((String)localObject4));
            ((HotPicMsg.ReqBody)localObject1).msg_get_videoinfo_req.set((MessageMicro)localObject3);
            localObject1 = ((HotPicMsg.ReqBody)localObject1).toByteArray();
            localObject3 = ByteBuffer.allocate(localObject1.length + 4);
            ((ByteBuffer)localObject3).putInt(localObject1.length + 4).put((byte[])localObject1);
            localObject1 = ((ByteBuffer)localObject3).array();
            localObject3 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), aqfy.class);
            ((NewIntent)localObject3).putExtra("key_body", (byte[])localObject1);
            ((NewIntent)localObject3).putExtra("key_cmd", "ImagePopular.GetInfo");
            ((NewIntent)localObject3).putExtra("REQUEST_CHECK_UPDATE", paramBoolean);
            ((NewIntent)localObject3).putExtra("REQUEST_TAG", paramInt4);
            if (paramBoolean) {
              paramInt5 = 10001;
            }
            ((NewIntent)localObject3).putExtra("REQUEST_TYPE", paramInt5);
            ((NewIntent)localObject3).putExtra("REQUEST_VERSION", paramInt3);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject3);
            return;
          }
          paramInt1 = 0;
          continue;
        }
        Object localObject3 = new HotPicMsg.GetImgInfoReq();
        ((HotPicMsg.ReqBody)localObject1).setHasFlag(true);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint64_src_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_src_term.set(3);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_start_pic_index.set(paramInt1);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_end_pic_index.set(paramInt2);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_build_ver.set(paramInt3);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_pic_tag.set(paramInt4);
        ((HotPicMsg.GetImgInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("8.2.6"));
        Object localObject4 = ((HotPicMsg.GetImgInfoReq)localObject3).uint32_need_update;
        if (paramBoolean)
        {
          paramInt1 = j;
          ((PBUInt32Field)localObject4).set(paramInt1);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + SystemClock.uptimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("HotPicManager", 2, "sessionId:" + (String)localObject4);
          }
          ((HotPicMsg.GetImgInfoReq)localObject3).bytes_session_id.set(ByteStringMicro.copyFromUtf8((String)localObject4));
          ((HotPicMsg.ReqBody)localObject1).msg_get_imginfo_req.set((MessageMicro)localObject3);
        }
        else
        {
          paramInt1 = 0;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void a(android.content.Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 13
    //   5: aload_1
    //   6: ldc_w 572
    //   9: iconst_m1
    //   10: invokevirtual 607	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   13: istore 4
    //   15: aload_1
    //   16: ldc_w 565
    //   19: iconst_m1
    //   20: invokevirtual 607	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   23: istore 8
    //   25: aload_0
    //   26: invokevirtual 609	aqfa:b	()I
    //   29: istore_3
    //   30: aload_1
    //   31: ldc_w 560
    //   34: iconst_0
    //   35: invokevirtual 612	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   38: istore 10
    //   40: aload_1
    //   41: ldc_w 570
    //   44: iconst_m1
    //   45: invokevirtual 607	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   48: istore 5
    //   50: iload 5
    //   52: sipush 10003
    //   55: if_icmpne +846 -> 901
    //   58: iconst_1
    //   59: istore 9
    //   61: iload 5
    //   63: sipush 10001
    //   66: if_icmpne +2558 -> 2624
    //   69: aload_0
    //   70: iload 8
    //   72: invokevirtual 325	aqfa:a	(I)Z
    //   75: istore 9
    //   77: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +73 -> 153
    //   83: ldc 219
    //   85: iconst_2
    //   86: new 97	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 614
    //   96: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: iload 4
    //   101: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc_w 616
    //   107: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 8
    //   112: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc_w 618
    //   118: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_3
    //   122: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: ldc_w 620
    //   128: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: iload 10
    //   133: invokevirtual 224	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   136: ldc_w 622
    //   139: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: iload 5
    //   144: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_2
    //   154: invokevirtual 627	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   157: sipush 1000
    //   160: if_icmpne +1803 -> 1963
    //   163: aload_2
    //   164: invokevirtual 630	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   167: arraylength
    //   168: iconst_4
    //   169: isub
    //   170: istore 5
    //   172: iload 5
    //   174: newarray byte
    //   176: astore_1
    //   177: aload_1
    //   178: iconst_0
    //   179: aload_2
    //   180: invokevirtual 630	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   183: iconst_4
    //   184: iload 5
    //   186: invokestatic 635	bakz:a	([BI[BII)V
    //   189: aload_2
    //   190: aload_1
    //   191: invokevirtual 639	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   194: aload_2
    //   195: invokevirtual 630	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   198: astore_1
    //   199: new 641	com/tencent/pb/hotpicmsg/HotPicMsg$RspBody
    //   202: dup
    //   203: invokespecial 642	com/tencent/pb/hotpicmsg/HotPicMsg$RspBody:<init>	()V
    //   206: astore_2
    //   207: aload_2
    //   208: aload_1
    //   209: invokevirtual 646	com/tencent/pb/hotpicmsg/HotPicMsg$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   212: pop
    //   213: iload 9
    //   215: ifeq +692 -> 907
    //   218: aload_2
    //   219: getfield 650	com/tencent/pb/hotpicmsg/HotPicMsg$RspBody:msg_get_videoinfo_rsp	Lcom/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp;
    //   222: invokevirtual 655	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   225: checkcast 652	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp
    //   228: astore 11
    //   230: aconst_null
    //   231: astore 12
    //   233: aload 12
    //   235: ifnull +27 -> 262
    //   238: aload 12
    //   240: getfield 660	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   243: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   246: ifeq +45 -> 291
    //   249: aload 12
    //   251: getfield 660	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   254: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   257: bipush 251
    //   259: if_icmpeq +32 -> 291
    //   262: aload 11
    //   264: ifnull +1584 -> 1848
    //   267: aload 11
    //   269: getfield 666	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   272: invokevirtual 669	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   275: ifeq +16 -> 291
    //   278: aload 11
    //   280: getfield 666	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   283: invokevirtual 669	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   286: bipush 251
    //   288: if_icmpne +1560 -> 1848
    //   291: aconst_null
    //   292: astore_2
    //   293: aconst_null
    //   294: astore_1
    //   295: iload 9
    //   297: ifeq +628 -> 925
    //   300: aload 11
    //   302: getfield 670	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:uint32_build_ver	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   305: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   308: istore 5
    //   310: iload 5
    //   312: istore 4
    //   314: iload 4
    //   316: istore 6
    //   318: iload_3
    //   319: istore 7
    //   321: aload 11
    //   323: getfield 674	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:rpt_msg_tag_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   326: invokevirtual 679	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   329: ifeq +19 -> 348
    //   332: iload 4
    //   334: istore 6
    //   336: iload_3
    //   337: istore 7
    //   339: aload 11
    //   341: getfield 674	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:rpt_msg_tag_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   344: invokevirtual 681	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   347: astore_1
    //   348: iload 4
    //   350: istore 6
    //   352: iload_3
    //   353: istore 7
    //   355: aload_1
    //   356: astore_2
    //   357: iload 4
    //   359: istore 5
    //   361: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq +687 -> 1051
    //   367: iload 4
    //   369: istore 6
    //   371: iload_3
    //   372: istore 7
    //   374: ldc 219
    //   376: iconst_2
    //   377: new 97	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 683
    //   387: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: iload 4
    //   392: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: ldc_w 685
    //   398: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 11
    //   403: getfield 666	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   406: invokevirtual 669	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   409: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: aload_1
    //   419: astore_2
    //   420: iload_3
    //   421: istore 5
    //   423: iload 10
    //   425: ifeq +681 -> 1106
    //   428: iload_3
    //   429: istore 5
    //   431: aload_2
    //   432: ifnull +674 -> 1106
    //   435: iload 4
    //   437: istore 6
    //   439: iload_3
    //   440: istore 7
    //   442: iload_3
    //   443: istore 5
    //   445: aload_2
    //   446: invokeinterface 235 1 0
    //   451: ifle +655 -> 1106
    //   454: iload 4
    //   456: istore 6
    //   458: iload_3
    //   459: istore 7
    //   461: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   464: ifeq +62 -> 526
    //   467: iload 4
    //   469: istore 6
    //   471: iload_3
    //   472: istore 7
    //   474: ldc 219
    //   476: iconst_2
    //   477: new 97	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   484: ldc_w 687
    //   487: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: iload_3
    //   491: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: ldc_w 689
    //   497: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: iload 4
    //   502: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   505: ldc_w 691
    //   508: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_2
    //   512: invokeinterface 235 1 0
    //   517: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   520: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: iload 4
    //   528: istore 6
    //   530: iload_3
    //   531: istore 7
    //   533: aload_0
    //   534: getfield 85	aqfa:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   537: astore 14
    //   539: iload 4
    //   541: istore 6
    //   543: iload_3
    //   544: istore 7
    //   546: aload 14
    //   548: monitorenter
    //   549: iload_3
    //   550: ifne +508 -> 1058
    //   553: iload_3
    //   554: istore 7
    //   556: aload_0
    //   557: getfield 74	aqfa:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   560: astore_1
    //   561: iload 4
    //   563: istore_3
    //   564: iconst_1
    //   565: istore 6
    //   567: iload_3
    //   568: istore 7
    //   570: aload_1
    //   571: invokeinterface 694 1 0
    //   576: iload_3
    //   577: istore 7
    //   579: aload_0
    //   580: aload_1
    //   581: iload 4
    //   583: invokespecial 372	aqfa:a	(Ljava/util/List;I)V
    //   586: iload_3
    //   587: istore 7
    //   589: aload_2
    //   590: invokeinterface 229 1 0
    //   595: astore_2
    //   596: iload_3
    //   597: istore 7
    //   599: aload_2
    //   600: invokeinterface 144 1 0
    //   605: ifeq +467 -> 1072
    //   608: iload_3
    //   609: istore 7
    //   611: aload_2
    //   612: invokeinterface 148 1 0
    //   617: checkcast 696	com/tencent/pb/hotpicmsg/HotPicMsg$TagInfo
    //   620: astore 15
    //   622: iload_3
    //   623: istore 7
    //   625: new 165	com/tencent/mobileqq/hotpic/HotPicTagInfo
    //   628: dup
    //   629: invokespecial 179	com/tencent/mobileqq/hotpic/HotPicTagInfo:<init>	()V
    //   632: astore 16
    //   634: iload_3
    //   635: istore 7
    //   637: aload 16
    //   639: aload 15
    //   641: getfield 699	com/tencent/pb/hotpicmsg/HotPicMsg$TagInfo:uint32_tag_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   644: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   647: putfield 203	com/tencent/mobileqq/hotpic/HotPicTagInfo:tagType	I
    //   650: iload_3
    //   651: istore 7
    //   653: aload 16
    //   655: aload 15
    //   657: getfield 700	com/tencent/pb/hotpicmsg/HotPicMsg$TagInfo:uint32_tag_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   660: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   663: putfield 200	com/tencent/mobileqq/hotpic/HotPicTagInfo:tagId	I
    //   666: iload_3
    //   667: istore 7
    //   669: aload 16
    //   671: getfield 200	com/tencent/mobileqq/hotpic/HotPicTagInfo:tagId	I
    //   674: iconst_2
    //   675: if_icmpeq -79 -> 596
    //   678: iload_3
    //   679: istore 7
    //   681: aload 16
    //   683: aload_1
    //   684: invokeinterface 235 1 0
    //   689: putfield 206	com/tencent/mobileqq/hotpic/HotPicTagInfo:position	I
    //   692: iload_3
    //   693: istore 7
    //   695: aload 16
    //   697: aload 15
    //   699: getfield 703	com/tencent/pb/hotpicmsg/HotPicMsg$TagInfo:bytes_tag_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   702: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   705: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   708: putfield 194	com/tencent/mobileqq/hotpic/HotPicTagInfo:tagName	Ljava/lang/String;
    //   711: iload_3
    //   712: istore 7
    //   714: aload 16
    //   716: iload 4
    //   718: putfield 197	com/tencent/mobileqq/hotpic/HotPicTagInfo:version	I
    //   721: iload_3
    //   722: istore 7
    //   724: aload_1
    //   725: aload 16
    //   727: invokeinterface 209 2 0
    //   732: pop
    //   733: iload_3
    //   734: istore 7
    //   736: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   739: ifeq -143 -> 596
    //   742: iload_3
    //   743: istore 7
    //   745: ldc 219
    //   747: iconst_2
    //   748: new 97	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   755: ldc_w 711
    //   758: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: aload 16
    //   763: getfield 194	com/tencent/mobileqq/hotpic/HotPicTagInfo:tagName	Ljava/lang/String;
    //   766: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: ldc_w 713
    //   772: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: aload 16
    //   777: getfield 206	com/tencent/mobileqq/hotpic/HotPicTagInfo:position	I
    //   780: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   783: ldc_w 715
    //   786: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: aload 16
    //   791: getfield 200	com/tencent/mobileqq/hotpic/HotPicTagInfo:tagId	I
    //   794: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   797: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   800: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   803: goto -207 -> 596
    //   806: astore_1
    //   807: aload 14
    //   809: monitorexit
    //   810: iload 4
    //   812: istore 6
    //   814: aload_1
    //   815: athrow
    //   816: astore_1
    //   817: iload 6
    //   819: istore 4
    //   821: iload 7
    //   823: istore_3
    //   824: aload_1
    //   825: invokevirtual 716	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   828: aload 13
    //   830: astore_1
    //   831: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   834: ifeq +1233 -> 2067
    //   837: aload_1
    //   838: ifnull +1229 -> 2067
    //   841: aload_1
    //   842: invokevirtual 138	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   845: astore_2
    //   846: aload_2
    //   847: invokeinterface 144 1 0
    //   852: ifeq +1186 -> 2038
    //   855: aload_2
    //   856: invokeinterface 148 1 0
    //   861: checkcast 150	com/tencent/mobileqq/hotpic/HotPicData
    //   864: astore 11
    //   866: ldc 219
    //   868: iconst_2
    //   869: new 97	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   876: ldc_w 718
    //   879: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: aload 11
    //   884: invokevirtual 721	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   887: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   893: goto -47 -> 846
    //   896: astore_1
    //   897: aload_0
    //   898: monitorexit
    //   899: aload_1
    //   900: athrow
    //   901: iconst_0
    //   902: istore 9
    //   904: goto -843 -> 61
    //   907: aload_2
    //   908: getfield 725	com/tencent/pb/hotpicmsg/HotPicMsg$RspBody:msg_get_imginfo_rsp	Lcom/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp;
    //   911: invokevirtual 726	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   914: checkcast 657	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp
    //   917: astore 12
    //   919: aconst_null
    //   920: astore 11
    //   922: goto -689 -> 233
    //   925: aload 12
    //   927: getfield 727	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:uint32_build_ver	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   930: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   933: istore 5
    //   935: iload 5
    //   937: istore 4
    //   939: iload 4
    //   941: istore 6
    //   943: iload_3
    //   944: istore 7
    //   946: aload_2
    //   947: astore_1
    //   948: aload 12
    //   950: getfield 728	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:rpt_msg_tag_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   953: invokevirtual 679	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   956: ifeq +19 -> 975
    //   959: iload 4
    //   961: istore 6
    //   963: iload_3
    //   964: istore 7
    //   966: aload 12
    //   968: getfield 728	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:rpt_msg_tag_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   971: invokevirtual 681	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   974: astore_1
    //   975: iload 4
    //   977: istore 6
    //   979: iload_3
    //   980: istore 7
    //   982: aload_1
    //   983: astore_2
    //   984: iload 4
    //   986: istore 5
    //   988: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   991: ifeq +60 -> 1051
    //   994: iload 4
    //   996: istore 6
    //   998: iload_3
    //   999: istore 7
    //   1001: ldc 219
    //   1003: iconst_2
    //   1004: new 97	java/lang/StringBuilder
    //   1007: dup
    //   1008: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1011: ldc_w 730
    //   1014: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: iload 4
    //   1019: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1022: ldc_w 685
    //   1025: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: aload 12
    //   1030: getfield 660	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1033: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1036: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1039: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1042: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1045: iload 4
    //   1047: istore 5
    //   1049: aload_1
    //   1050: astore_2
    //   1051: iload 5
    //   1053: istore 4
    //   1055: goto -635 -> 420
    //   1058: iload_3
    //   1059: istore 7
    //   1061: aload_0
    //   1062: getfield 76	aqfa:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1065: astore_1
    //   1066: iconst_0
    //   1067: istore 6
    //   1069: goto -502 -> 567
    //   1072: iload_3
    //   1073: istore 7
    //   1075: aload 14
    //   1077: monitorexit
    //   1078: iload_3
    //   1079: istore 5
    //   1081: iload 6
    //   1083: ifeq +23 -> 1106
    //   1086: iload 4
    //   1088: istore 6
    //   1090: iload_3
    //   1091: istore 7
    //   1093: aload_0
    //   1094: getfield 62	aqfa:jdField_a_of_type_Befq	Lbefq;
    //   1097: bipush 104
    //   1099: invokevirtual 733	befq:sendEmptyMessage	(I)Z
    //   1102: pop
    //   1103: iload_3
    //   1104: istore 5
    //   1106: aconst_null
    //   1107: astore_2
    //   1108: iload 9
    //   1110: ifeq +374 -> 1484
    //   1113: aload 11
    //   1115: getfield 736	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:rpt_msg_video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1118: invokevirtual 681	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1121: astore 12
    //   1123: aload_2
    //   1124: astore_1
    //   1125: aload 12
    //   1127: ifnull +715 -> 1842
    //   1130: aload_2
    //   1131: astore_1
    //   1132: aload 12
    //   1134: invokeinterface 235 1 0
    //   1139: ifle +703 -> 1842
    //   1142: new 71	java/util/ArrayList
    //   1145: dup
    //   1146: invokespecial 72	java/util/ArrayList:<init>	()V
    //   1149: astore_1
    //   1150: aload 12
    //   1152: invokeinterface 229 1 0
    //   1157: astore_2
    //   1158: aload_2
    //   1159: invokeinterface 144 1 0
    //   1164: ifeq +1457 -> 2621
    //   1167: aload_2
    //   1168: invokeinterface 148 1 0
    //   1173: checkcast 738	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo
    //   1176: astore 12
    //   1178: new 156	com/tencent/mobileqq/hotpic/HotVideoData
    //   1181: dup
    //   1182: invokespecial 739	com/tencent/mobileqq/hotpic/HotVideoData:<init>	()V
    //   1185: astore 14
    //   1187: aload 14
    //   1189: aload 12
    //   1191: getfield 742	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_preview_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1194: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1197: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1200: invokevirtual 745	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1203: putfield 748	com/tencent/mobileqq/hotpic/HotVideoData:md5	Ljava/lang/String;
    //   1206: aload 14
    //   1208: aload 12
    //   1210: getfield 751	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint32_preview_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1213: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1216: putfield 754	com/tencent/mobileqq/hotpic/HotVideoData:width	I
    //   1219: aload 14
    //   1221: aload 12
    //   1223: getfield 757	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint32_preview_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1226: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1229: putfield 760	com/tencent/mobileqq/hotpic/HotVideoData:height	I
    //   1232: aload 14
    //   1234: aload 12
    //   1236: getfield 763	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_preview_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1239: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1242: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1245: putfield 766	com/tencent/mobileqq/hotpic/HotVideoData:mPreviewUUID	Ljava/lang/String;
    //   1248: aload 14
    //   1250: aload 12
    //   1252: getfield 769	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint64_preview_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1255: invokevirtual 771	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1258: putfield 775	com/tencent/mobileqq/hotpic/HotVideoData:fileSize	J
    //   1261: aload 14
    //   1263: aload 12
    //   1265: getfield 778	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint64_video_length	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1268: invokevirtual 771	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1271: putfield 781	com/tencent/mobileqq/hotpic/HotVideoData:videoLength	J
    //   1274: aload 14
    //   1276: aload 12
    //   1278: getfield 784	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_jump_icon	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1281: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1284: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1287: putfield 787	com/tencent/mobileqq/hotpic/HotVideoData:iconUrl	Ljava/lang/String;
    //   1290: aload 14
    //   1292: aload 12
    //   1294: getfield 790	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1297: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1300: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1303: putfield 793	com/tencent/mobileqq/hotpic/HotVideoData:jumpUrl	Ljava/lang/String;
    //   1306: aload 14
    //   1308: aload 12
    //   1310: getfield 796	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint32_video_index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1313: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1316: putfield 799	com/tencent/mobileqq/hotpic/HotVideoData:picIndex	I
    //   1319: aload 14
    //   1321: aload 12
    //   1323: getfield 802	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_video_source	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1326: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1329: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1332: putfield 805	com/tencent/mobileqq/hotpic/HotVideoData:videoSource	Ljava/lang/String;
    //   1335: aload 14
    //   1337: aload 12
    //   1339: getfield 808	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_video_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1342: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1345: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1348: putfield 811	com/tencent/mobileqq/hotpic/HotVideoData:name	Ljava/lang/String;
    //   1351: aload 14
    //   1353: aload 12
    //   1355: getfield 814	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint32_video_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1358: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1361: putfield 817	com/tencent/mobileqq/hotpic/HotVideoData:originalWidth	I
    //   1364: aload 14
    //   1366: aload 12
    //   1368: getfield 820	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint32_video_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1371: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1374: putfield 823	com/tencent/mobileqq/hotpic/HotVideoData:originalHeight	I
    //   1377: aload 14
    //   1379: aload 12
    //   1381: getfield 826	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_video_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1384: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1387: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1390: putfield 829	com/tencent/mobileqq/hotpic/HotVideoData:mVideoUUID	Ljava/lang/String;
    //   1393: aload 14
    //   1395: aload 12
    //   1397: getfield 832	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_video_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1400: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1403: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1406: putfield 835	com/tencent/mobileqq/hotpic/HotVideoData:originalMD5	Ljava/lang/String;
    //   1409: aload 14
    //   1411: aload 12
    //   1413: getfield 838	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_certificated_icon	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1416: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1419: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1422: putfield 841	com/tencent/mobileqq/hotpic/HotVideoData:mCertificatedIcon	Ljava/lang/String;
    //   1425: aload 14
    //   1427: aload 12
    //   1429: getfield 844	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint64_video_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1432: invokevirtual 771	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1435: putfield 847	com/tencent/mobileqq/hotpic/HotVideoData:oringinalSize	J
    //   1438: aload 14
    //   1440: aload 11
    //   1442: getfield 848	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:uint32_tag_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1445: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1448: putfield 851	com/tencent/mobileqq/hotpic/HotVideoData:tag	I
    //   1451: aload 14
    //   1453: iload 4
    //   1455: putfield 852	com/tencent/mobileqq/hotpic/HotVideoData:version	I
    //   1458: aload 14
    //   1460: ldc_w 854
    //   1463: putfield 855	com/tencent/mobileqq/hotpic/HotVideoData:url	Ljava/lang/String;
    //   1466: aload 14
    //   1468: ldc_w 854
    //   1471: putfield 858	com/tencent/mobileqq/hotpic/HotVideoData:originalUrl	Ljava/lang/String;
    //   1474: aload_1
    //   1475: aload 14
    //   1477: invokevirtual 160	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1480: pop
    //   1481: goto -323 -> 1158
    //   1484: aload 12
    //   1486: getfield 861	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:rpt_msg_img_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1489: invokevirtual 681	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1492: astore_2
    //   1493: aload_2
    //   1494: ifnull +1122 -> 2616
    //   1497: aload_2
    //   1498: invokeinterface 235 1 0
    //   1503: ifle +1113 -> 2616
    //   1506: new 71	java/util/ArrayList
    //   1509: dup
    //   1510: invokespecial 72	java/util/ArrayList:<init>	()V
    //   1513: astore_1
    //   1514: iconst_0
    //   1515: istore_3
    //   1516: iload_3
    //   1517: aload_2
    //   1518: invokeinterface 235 1 0
    //   1523: if_icmpge +319 -> 1842
    //   1526: aload_2
    //   1527: iload_3
    //   1528: invokeinterface 862 2 0
    //   1533: checkcast 864	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo
    //   1536: astore 12
    //   1538: new 150	com/tencent/mobileqq/hotpic/HotPicData
    //   1541: dup
    //   1542: invokespecial 865	com/tencent/mobileqq/hotpic/HotPicData:<init>	()V
    //   1545: astore 11
    //   1547: aload 11
    //   1549: iload 4
    //   1551: putfield 866	com/tencent/mobileqq/hotpic/HotPicData:version	I
    //   1554: aload 11
    //   1556: aload 12
    //   1558: getfield 869	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_pic_index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1561: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1564: putfield 870	com/tencent/mobileqq/hotpic/HotPicData:picIndex	I
    //   1567: aload 11
    //   1569: aload 12
    //   1571: getfield 873	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1574: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1577: putfield 876	com/tencent/mobileqq/hotpic/HotPicData:fileType	I
    //   1580: aload 11
    //   1582: aload 12
    //   1584: getfield 879	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_source_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1587: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1590: putfield 882	com/tencent/mobileqq/hotpic/HotPicData:sourceType	I
    //   1593: aload 11
    //   1595: aload 12
    //   1597: getfield 885	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_thumb_file_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1600: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1603: putfield 886	com/tencent/mobileqq/hotpic/HotPicData:height	I
    //   1606: aload 11
    //   1608: aload 12
    //   1610: getfield 889	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_thumb_file_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1613: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1616: putfield 890	com/tencent/mobileqq/hotpic/HotPicData:width	I
    //   1619: aload 11
    //   1621: aload 12
    //   1623: getfield 893	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:bytes_thumb_down_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1626: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1629: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1632: putfield 292	com/tencent/mobileqq/hotpic/HotPicData:url	Ljava/lang/String;
    //   1635: aload 11
    //   1637: aload 12
    //   1639: getfield 896	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1642: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1645: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1648: invokevirtual 745	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1651: putfield 897	com/tencent/mobileqq/hotpic/HotPicData:md5	Ljava/lang/String;
    //   1654: aload 11
    //   1656: aload 12
    //   1658: getfield 900	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint64_thumb_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1661: invokevirtual 771	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1664: putfield 901	com/tencent/mobileqq/hotpic/HotPicData:fileSize	J
    //   1667: aload 11
    //   1669: aload 12
    //   1671: getfield 904	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1674: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1677: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1680: invokevirtual 745	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1683: putfield 905	com/tencent/mobileqq/hotpic/HotPicData:originalMD5	Ljava/lang/String;
    //   1686: aload 11
    //   1688: aload 12
    //   1690: getfield 908	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:bytes_pic_down_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1693: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1696: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1699: putfield 909	com/tencent/mobileqq/hotpic/HotPicData:originalUrl	Ljava/lang/String;
    //   1702: aload 11
    //   1704: aload 12
    //   1706: getfield 912	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_file_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1709: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1712: putfield 913	com/tencent/mobileqq/hotpic/HotPicData:originalHeight	I
    //   1715: aload 11
    //   1717: aload 12
    //   1719: getfield 916	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_file_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1722: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1725: putfield 917	com/tencent/mobileqq/hotpic/HotPicData:originalWidth	I
    //   1728: aload 11
    //   1730: aload 12
    //   1732: getfield 920	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1735: invokevirtual 771	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1738: putfield 921	com/tencent/mobileqq/hotpic/HotPicData:oringinalSize	J
    //   1741: aload 11
    //   1743: iload 8
    //   1745: putfield 922	com/tencent/mobileqq/hotpic/HotPicData:tag	I
    //   1748: aload 11
    //   1750: getfield 882	com/tencent/mobileqq/hotpic/HotPicData:sourceType	I
    //   1753: iconst_3
    //   1754: if_icmpne +74 -> 1828
    //   1757: aload 12
    //   1759: getfield 926	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:msg_third_party_info	Lcom/tencent/pb/hotpicmsg/HotPicMsg$ThirdPartyInfo;
    //   1762: astore 12
    //   1764: aload 11
    //   1766: aload 12
    //   1768: getfield 931	com/tencent/pb/hotpicmsg/HotPicMsg$ThirdPartyInfo:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1771: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1774: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1777: putfield 932	com/tencent/mobileqq/hotpic/HotPicData:iconUrl	Ljava/lang/String;
    //   1780: aload 11
    //   1782: aload 12
    //   1784: getfield 935	com/tencent/pb/hotpicmsg/HotPicMsg$ThirdPartyInfo:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1787: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1790: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1793: putfield 936	com/tencent/mobileqq/hotpic/HotPicData:name	Ljava/lang/String;
    //   1796: aload 11
    //   1798: aload 12
    //   1800: getfield 937	com/tencent/pb/hotpicmsg/HotPicMsg$ThirdPartyInfo:bytes_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1803: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1806: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1809: putfield 938	com/tencent/mobileqq/hotpic/HotPicData:jumpUrl	Ljava/lang/String;
    //   1812: aload 11
    //   1814: aload 12
    //   1816: getfield 941	com/tencent/pb/hotpicmsg/HotPicMsg$ThirdPartyInfo:bytes_appid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1819: invokevirtual 706	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1822: invokevirtual 709	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1825: putfield 944	com/tencent/mobileqq/hotpic/HotPicData:appid	Ljava/lang/String;
    //   1828: aload_1
    //   1829: aload 11
    //   1831: invokevirtual 160	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1834: pop
    //   1835: iload_3
    //   1836: iconst_1
    //   1837: iadd
    //   1838: istore_3
    //   1839: goto -323 -> 1516
    //   1842: iload 5
    //   1844: istore_3
    //   1845: goto -1014 -> 831
    //   1848: iload 9
    //   1850: ifeq +67 -> 1917
    //   1853: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1856: ifeq +36 -> 1892
    //   1859: ldc 219
    //   1861: iconst_2
    //   1862: new 97	java/lang/StringBuilder
    //   1865: dup
    //   1866: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1869: ldc_w 946
    //   1872: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1875: aload 11
    //   1877: getfield 666	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1880: invokevirtual 669	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1883: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1886: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1889: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1892: invokestatic 949	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1895: invokestatic 954	awrn:a	(Landroid/content/Context;)Lawrn;
    //   1898: aconst_null
    //   1899: ldc_w 956
    //   1902: iconst_1
    //   1903: lconst_0
    //   1904: lconst_0
    //   1905: aconst_null
    //   1906: ldc_w 854
    //   1909: invokevirtual 959	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1912: aconst_null
    //   1913: astore_1
    //   1914: goto -69 -> 1845
    //   1917: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1920: ifeq -28 -> 1892
    //   1923: ldc 219
    //   1925: iconst_2
    //   1926: new 97	java/lang/StringBuilder
    //   1929: dup
    //   1930: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1933: ldc_w 961
    //   1936: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1939: aload 12
    //   1941: getfield 660	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1944: invokevirtual 662	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1947: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1950: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1953: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1956: goto -64 -> 1892
    //   1959: astore_1
    //   1960: goto -1136 -> 824
    //   1963: aload_0
    //   1964: getfield 45	aqfa:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1967: iload 8
    //   1969: invokestatic 966	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1972: invokeinterface 298 2 0
    //   1977: pop
    //   1978: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1981: ifeq +32 -> 2013
    //   1984: ldc 219
    //   1986: iconst_2
    //   1987: new 97	java/lang/StringBuilder
    //   1990: dup
    //   1991: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1994: ldc_w 968
    //   1997: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2000: aload_2
    //   2001: invokevirtual 627	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   2004: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2007: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2010: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2013: aload_0
    //   2014: getfield 970	aqfa:jdField_a_of_type_Aqfc	Laqfc;
    //   2017: ifnull +18 -> 2035
    //   2020: aload_0
    //   2021: getfield 970	aqfa:jdField_a_of_type_Aqfc	Laqfc;
    //   2024: bipush 6
    //   2026: iload 8
    //   2028: iload 4
    //   2030: invokeinterface 975 4 0
    //   2035: aload_0
    //   2036: monitorexit
    //   2037: return
    //   2038: ldc 219
    //   2040: iconst_2
    //   2041: new 97	java/lang/StringBuilder
    //   2044: dup
    //   2045: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2048: ldc_w 977
    //   2051: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2054: aload_1
    //   2055: invokevirtual 330	java/util/ArrayList:size	()I
    //   2058: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2061: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2064: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2067: aload_1
    //   2068: ifnull +10 -> 2078
    //   2071: aload_1
    //   2072: invokevirtual 330	java/util/ArrayList:size	()I
    //   2075: ifgt +167 -> 2242
    //   2078: iload_3
    //   2079: ifne +101 -> 2180
    //   2082: iconst_5
    //   2083: istore_3
    //   2084: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2087: ifeq +526 -> 2613
    //   2090: ldc 219
    //   2092: iconst_2
    //   2093: ldc_w 979
    //   2096: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2099: iconst_5
    //   2100: istore_3
    //   2101: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2104: ifeq +52 -> 2156
    //   2107: new 97	java/lang/StringBuilder
    //   2110: dup
    //   2111: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2114: ldc_w 981
    //   2117: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2120: iload_3
    //   2121: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2124: ldc_w 983
    //   2127: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2130: astore_1
    //   2131: aload_0
    //   2132: getfield 970	aqfa:jdField_a_of_type_Aqfc	Laqfc;
    //   2135: ifnull +509 -> 2644
    //   2138: iconst_1
    //   2139: istore 9
    //   2141: ldc 219
    //   2143: iconst_2
    //   2144: aload_1
    //   2145: iload 9
    //   2147: invokevirtual 224	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2150: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2153: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2156: aload_0
    //   2157: getfield 970	aqfa:jdField_a_of_type_Aqfc	Laqfc;
    //   2160: ifnull +435 -> 2595
    //   2163: aload_0
    //   2164: getfield 970	aqfa:jdField_a_of_type_Aqfc	Laqfc;
    //   2167: iload_3
    //   2168: iload 8
    //   2170: iload 4
    //   2172: invokeinterface 975 4 0
    //   2177: goto -142 -> 2035
    //   2180: iload 10
    //   2182: ifeq +21 -> 2203
    //   2185: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2188: ifeq -153 -> 2035
    //   2191: ldc 219
    //   2193: iconst_2
    //   2194: ldc_w 985
    //   2197: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2200: goto -165 -> 2035
    //   2203: bipush 6
    //   2205: istore_3
    //   2206: aload_0
    //   2207: getfield 45	aqfa:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   2210: iload 8
    //   2212: invokestatic 966	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2215: invokeinterface 298 2 0
    //   2220: pop
    //   2221: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2224: ifeq +389 -> 2613
    //   2227: ldc 219
    //   2229: iconst_2
    //   2230: ldc_w 987
    //   2233: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2236: bipush 6
    //   2238: istore_3
    //   2239: goto -138 -> 2101
    //   2242: aload_0
    //   2243: getfield 67	aqfa:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   2246: iload 8
    //   2248: invokevirtual 322	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   2251: checkcast 71	java/util/ArrayList
    //   2254: astore_2
    //   2255: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2258: ifeq +40 -> 2298
    //   2261: ldc 219
    //   2263: iconst_2
    //   2264: new 97	java/lang/StringBuilder
    //   2267: dup
    //   2268: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2271: ldc_w 989
    //   2274: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2277: iload 4
    //   2279: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2282: ldc_w 991
    //   2285: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2288: iload_3
    //   2289: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2292: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2295: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2298: iload_3
    //   2299: iload 4
    //   2301: if_icmpeq +93 -> 2394
    //   2304: iload 10
    //   2306: ifeq -271 -> 2035
    //   2309: aload_0
    //   2310: getfield 69	aqfa:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   2313: invokevirtual 992	android/util/SparseArray:clear	()V
    //   2316: aload_0
    //   2317: getfield 69	aqfa:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   2320: iload 8
    //   2322: aload_1
    //   2323: invokevirtual 385	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   2326: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2329: ifeq +40 -> 2369
    //   2332: ldc 219
    //   2334: iconst_2
    //   2335: new 97	java/lang/StringBuilder
    //   2338: dup
    //   2339: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2342: ldc_w 989
    //   2345: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2348: iload 4
    //   2350: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2353: ldc_w 991
    //   2356: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2359: iload_3
    //   2360: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2363: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2366: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2369: aload_0
    //   2370: getfield 970	aqfa:jdField_a_of_type_Aqfc	Laqfc;
    //   2373: ifnonnull -338 -> 2035
    //   2376: invokestatic 996	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   2379: new 998	com/tencent/mobileqq/hotpic/HotPicManager$3
    //   2382: dup
    //   2383: aload_0
    //   2384: invokespecial 999	com/tencent/mobileqq/hotpic/HotPicManager$3:<init>	(Laqfa;)V
    //   2387: invokevirtual 1004	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   2390: pop
    //   2391: goto -356 -> 2035
    //   2394: aload_2
    //   2395: invokevirtual 330	java/util/ArrayList:size	()I
    //   2398: ifne +38 -> 2436
    //   2401: aload_2
    //   2402: aload_1
    //   2403: invokevirtual 346	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2406: pop
    //   2407: bipush 7
    //   2409: istore_3
    //   2410: iload 9
    //   2412: ifeq +15 -> 2427
    //   2415: aload_0
    //   2416: aload_1
    //   2417: invokestatic 1006	aqfa:a	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   2420: iconst_0
    //   2421: invokespecial 1008	aqfa:a	(Ljava/util/List;Z)V
    //   2424: goto -323 -> 2101
    //   2427: aload_0
    //   2428: aload_2
    //   2429: iconst_0
    //   2430: invokespecial 1010	aqfa:b	(Ljava/util/List;Z)V
    //   2433: goto -332 -> 2101
    //   2436: iload_3
    //   2437: ifeq +202 -> 2639
    //   2440: aload_1
    //   2441: iconst_0
    //   2442: invokevirtual 1011	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2445: checkcast 150	com/tencent/mobileqq/hotpic/HotPicData
    //   2448: getfield 870	com/tencent/mobileqq/hotpic/HotPicData:picIndex	I
    //   2451: aload_2
    //   2452: invokevirtual 330	java/util/ArrayList:size	()I
    //   2455: if_icmpne +77 -> 2532
    //   2458: iload 9
    //   2460: ifeq +39 -> 2499
    //   2463: new 71	java/util/ArrayList
    //   2466: dup
    //   2467: invokespecial 72	java/util/ArrayList:<init>	()V
    //   2470: astore 11
    //   2472: aload 11
    //   2474: aload_1
    //   2475: invokestatic 1006	aqfa:a	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   2478: invokevirtual 346	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2481: pop
    //   2482: aload_2
    //   2483: aload 11
    //   2485: invokevirtual 346	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2488: pop
    //   2489: aload_0
    //   2490: aload 11
    //   2492: iconst_0
    //   2493: invokespecial 1008	aqfa:a	(Ljava/util/List;Z)V
    //   2496: goto +138 -> 2634
    //   2499: new 71	java/util/ArrayList
    //   2502: dup
    //   2503: invokespecial 72	java/util/ArrayList:<init>	()V
    //   2506: astore 11
    //   2508: aload 11
    //   2510: aload_1
    //   2511: invokevirtual 346	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2514: pop
    //   2515: aload_2
    //   2516: aload 11
    //   2518: invokevirtual 346	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2521: pop
    //   2522: aload_0
    //   2523: aload 11
    //   2525: iconst_0
    //   2526: invokespecial 1010	aqfa:b	(Ljava/util/List;Z)V
    //   2529: goto +105 -> 2634
    //   2532: ldc 219
    //   2534: iconst_1
    //   2535: new 97	java/lang/StringBuilder
    //   2538: dup
    //   2539: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2542: ldc_w 1013
    //   2545: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2548: aload_1
    //   2549: iconst_0
    //   2550: invokevirtual 1011	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2553: checkcast 150	com/tencent/mobileqq/hotpic/HotPicData
    //   2556: getfield 870	com/tencent/mobileqq/hotpic/HotPicData:picIndex	I
    //   2559: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2562: ldc_w 1015
    //   2565: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2568: aload_2
    //   2569: invokevirtual 330	java/util/ArrayList:size	()I
    //   2572: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2575: ldc_w 1017
    //   2578: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2581: iload 8
    //   2583: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2586: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2589: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2592: goto -557 -> 2035
    //   2595: invokestatic 996	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   2598: new 1019	com/tencent/mobileqq/hotpic/HotPicManager$4
    //   2601: dup
    //   2602: aload_0
    //   2603: invokespecial 1020	com/tencent/mobileqq/hotpic/HotPicManager$4:<init>	(Laqfa;)V
    //   2606: invokevirtual 1004	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   2609: pop
    //   2610: goto -575 -> 2035
    //   2613: goto -512 -> 2101
    //   2616: aconst_null
    //   2617: astore_1
    //   2618: goto -776 -> 1842
    //   2621: goto -779 -> 1842
    //   2624: goto -2547 -> 77
    //   2627: astore_1
    //   2628: iload 5
    //   2630: istore_3
    //   2631: goto -1807 -> 824
    //   2634: iconst_3
    //   2635: istore_3
    //   2636: goto -535 -> 2101
    //   2639: iconst_5
    //   2640: istore_3
    //   2641: goto -540 -> 2101
    //   2644: iconst_0
    //   2645: istore 9
    //   2647: goto -506 -> 2141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2650	0	this	aqfa
    //   0	2650	1	paramIntent	android.content.Intent
    //   0	2650	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   29	2612	3	i	int
    //   13	2336	4	j	int
    //   48	2581	5	k	int
    //   316	773	6	m	int
    //   319	773	7	n	int
    //   23	2559	8	i1	int
    //   59	2587	9	bool1	boolean
    //   38	2267	10	bool2	boolean
    //   228	2296	11	localObject1	Object
    //   231	1709	12	localObject2	Object
    //   3	826	13	localObject3	Object
    //   537	939	14	localObject4	Object
    //   620	78	15	localTagInfo	com.tencent.pb.hotpicmsg.HotPicMsg.TagInfo
    //   632	158	16	localHotPicTagInfo	HotPicTagInfo
    // Exception table:
    //   from	to	target	type
    //   556	561	806	finally
    //   570	576	806	finally
    //   579	586	806	finally
    //   589	596	806	finally
    //   599	608	806	finally
    //   611	622	806	finally
    //   625	634	806	finally
    //   637	650	806	finally
    //   653	666	806	finally
    //   669	678	806	finally
    //   681	692	806	finally
    //   695	711	806	finally
    //   714	721	806	finally
    //   724	733	806	finally
    //   736	742	806	finally
    //   745	803	806	finally
    //   807	810	806	finally
    //   1061	1066	806	finally
    //   1075	1078	806	finally
    //   321	332	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   339	348	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   361	367	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   374	418	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   445	454	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   461	467	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   474	526	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   533	539	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   546	549	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   814	816	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   948	959	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   966	975	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   988	994	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1001	1045	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1093	1103	816	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5	50	896	finally
    //   69	77	896	finally
    //   77	153	896	finally
    //   153	194	896	finally
    //   194	213	896	finally
    //   218	230	896	finally
    //   238	262	896	finally
    //   267	291	896	finally
    //   300	310	896	finally
    //   321	332	896	finally
    //   339	348	896	finally
    //   361	367	896	finally
    //   374	418	896	finally
    //   445	454	896	finally
    //   461	467	896	finally
    //   474	526	896	finally
    //   533	539	896	finally
    //   546	549	896	finally
    //   814	816	896	finally
    //   824	828	896	finally
    //   831	837	896	finally
    //   841	846	896	finally
    //   846	893	896	finally
    //   907	919	896	finally
    //   925	935	896	finally
    //   948	959	896	finally
    //   966	975	896	finally
    //   988	994	896	finally
    //   1001	1045	896	finally
    //   1093	1103	896	finally
    //   1113	1123	896	finally
    //   1132	1158	896	finally
    //   1158	1481	896	finally
    //   1484	1493	896	finally
    //   1497	1514	896	finally
    //   1516	1828	896	finally
    //   1828	1835	896	finally
    //   1853	1892	896	finally
    //   1892	1912	896	finally
    //   1917	1956	896	finally
    //   1963	2013	896	finally
    //   2013	2035	896	finally
    //   2038	2067	896	finally
    //   2071	2078	896	finally
    //   2084	2099	896	finally
    //   2101	2138	896	finally
    //   2141	2156	896	finally
    //   2156	2177	896	finally
    //   2185	2200	896	finally
    //   2206	2221	896	finally
    //   2221	2236	896	finally
    //   2242	2298	896	finally
    //   2309	2369	896	finally
    //   2369	2391	896	finally
    //   2394	2407	896	finally
    //   2415	2424	896	finally
    //   2427	2433	896	finally
    //   2440	2458	896	finally
    //   2463	2496	896	finally
    //   2499	2529	896	finally
    //   2532	2592	896	finally
    //   2595	2610	896	finally
    //   194	213	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   218	230	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   238	262	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   267	291	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   300	310	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   907	919	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   925	935	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1853	1892	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1892	1912	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1917	1956	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1113	1123	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1132	1158	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1158	1481	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1484	1493	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1497	1514	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1516	1828	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1828	1835	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void a(aqfc paramaqfc)
  {
    this.jdField_a_of_type_Aqfc = paramaqfc;
  }
  
  public void a(aqhg paramaqhg)
  {
    this.jdField_a_of_type_Aqhg = paramaqhg;
  }
  
  public void a(HotPicData paramHotPicData)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilLinkedList.size()) {
      if (!((HotPicSendData)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).md5.equals(paramHotPicData.md5)) {}
    }
    for (;;)
    {
      if (i >= 0) {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(i);
      }
      HotPicSendData localHotPicSendData1;
      if ((paramHotPicData instanceof HotPicSendData))
      {
        localHotPicSendData1 = (HotPicSendData)paramHotPicData;
        label62:
        localHotPicSendData1.sendTime = NetConnInfoCenter.getServerTime();
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(localHotPicSendData1);
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 500) {
          break label173;
        }
      }
      label173:
      for (HotPicSendData localHotPicSendData2 = (HotPicSendData)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();; localHotPicSendData2 = null)
      {
        if (this.jdField_a_of_type_Aqfc != null) {
          this.jdField_a_of_type_Aqfc.b(8, -20, 0);
        }
        ThreadManager.post(new HotPicManager.1(this, localHotPicSendData1, localHotPicSendData2), 5, null, false);
        if (this.jdField_a_of_type_Aqhg != null) {
          this.jdField_a_of_type_Aqhg.a(paramHotPicData);
        }
        return;
        i += 1;
        break;
        localHotPicSendData1 = HotPicSendData.build(paramHotPicData);
        break label62;
      }
      i = -1;
    }
  }
  
  public void a(HotPicTagInfo paramHotPicTagInfo)
  {
    int i = paramHotPicTagInfo.tagId;
    if ((a()) || (this.g))
    {
      this.g = false;
      if (i != -20) {
        a(10001, paramHotPicTagInfo.tagId);
      }
    }
    this.jdField_a_of_type_Int = i;
    ThreadManager.post(new HotPicManager.5(this, i), 5, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool = false;
    int i;
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_AndroidUtilSparseArray.clear();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          Object localObject1 = (HotPicTagInfo)localIterator.next();
          i = ((HotPicTagInfo)localObject1).tagId;
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(i);
          SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
          localObject1 = localArrayList;
          if (localArrayList == null) {
            localObject1 = new ArrayList();
          }
          localSparseArray.put(i, localObject1);
        }
      }
      if (QLog.isColorLevel()) {
        if ("update NewVersionTagInfo" + this.jdField_b_of_type_JavaUtilList.get(0) != null) {
          break label232;
        }
      }
    }
    for (Object localObject3 = "null";; localObject3 = Integer.valueOf(i))
    {
      QLog.d("HotPicManager", 2, new Object[] { localObject3 });
      this.jdField_b_of_type_AndroidUtilSparseArray.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.e = true;
      this.jdField_a_of_type_Befq.sendEmptyMessage(101);
      bool = true;
      return bool;
      label232:
      i = ((HotPicTagInfo)this.jdField_b_of_type_JavaUtilList.get(0)).version;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    HotPicTagInfo localHotPicTagInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
    } while ((localHotPicTagInfo.tagId != paramInt) || (localHotPicTagInfo.tagType != 2));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        int i = ((HotPicTagInfo)localIterator.next()).version;
        if (i != 0) {
          return i;
        }
      }
      return 0;
    }
  }
  
  List<HotVideoData> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (HotPicTagInfo)localIterator.next();
      if (((HotPicTagInfo)localObject).tagType == 2)
      {
        localObject = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(((HotPicTagInfo)localObject).tagId);
        if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
          localArrayList.addAll(a((ArrayList)localObject));
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (HotVideoData)localIterator.next();
        QLog.d("HotPicManager", 2, "getAllHotVideoDatas item:" + ((HotVideoData)localObject).toString());
      }
      QLog.d("HotPicManager", 2, "getAllHotVideoDatas size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void b()
  {
    if (!this.c) {}
    do
    {
      return;
      a();
      if (this.jdField_a_of_type_Int != -1)
      {
        if (this.jdField_a_of_type_Int != -20)
        {
          a(10001, this.jdField_a_of_type_Int);
          return;
        }
        a(10001, 2);
        return;
      }
    } while (!this.jdField_b_of_type_Boolean);
    a(10001, 2);
  }
  
  /* Error */
  public void b(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 87	aqfa:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: invokevirtual 95	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   11: new 97	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   18: ldc 100
    //   20: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 87	aqfa:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 107	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   30: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: iconst_0
    //   37: invokevirtual 116	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   40: astore 4
    //   42: aload 4
    //   44: ldc_w 349
    //   47: iconst_0
    //   48: invokeinterface 353 3 0
    //   53: istore_3
    //   54: iload_1
    //   55: iconst_1
    //   56: if_icmpne +88 -> 144
    //   59: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +39 -> 101
    //   65: ldc 219
    //   67: iconst_1
    //   68: new 97	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 1089
    //   78: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: iload_2
    //   82: invokevirtual 224	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: ldc_w 1091
    //   88: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: iload_3
    //   92: invokevirtual 224	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   95: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 228	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: iload_2
    //   102: iload_3
    //   103: if_icmpeq +38 -> 141
    //   106: aload_0
    //   107: iload_2
    //   108: putfield 47	aqfa:c	Z
    //   111: aload 4
    //   113: invokeinterface 1095 1 0
    //   118: ldc_w 355
    //   121: iload_2
    //   122: invokeinterface 1101 3 0
    //   127: invokeinterface 1104 1 0
    //   132: pop
    //   133: iload_2
    //   134: ifeq +7 -> 141
    //   137: aload_0
    //   138: invokevirtual 1105	aqfa:b	()V
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: iconst_0
    //   145: istore_2
    //   146: goto -87 -> 59
    //   149: astore 4
    //   151: aload_0
    //   152: monitorexit
    //   153: aload 4
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	aqfa
    //   0	156	1	paramInt	int
    //   1	145	2	bool1	boolean
    //   53	51	3	bool2	boolean
    //   40	72	4	localSharedPreferences	SharedPreferences
    //   149	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	54	149	finally
    //   59	101	149	finally
    //   106	133	149	finally
    //   137	141	149	finally
  }
  
  public boolean b()
  {
    if ((!this.c) && (!this.d))
    {
      this.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("sp_hotpic_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getBoolean("k_hotlist_s_e", false);
      this.d = true;
    }
    return this.c;
  }
  
  /* Error */
  public boolean b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	aqfa:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual 322	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   10: checkcast 71	java/util/ArrayList
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +18 -> 33
    //   18: aload_3
    //   19: invokevirtual 330	java/util/ArrayList:size	()I
    //   22: istore_1
    //   23: iload_1
    //   24: ifle +9 -> 33
    //   27: iconst_1
    //   28: istore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_2
    //   35: goto -6 -> 29
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	aqfa
    //   0	43	1	paramInt	int
    //   28	7	2	bool	boolean
    //   13	6	3	localArrayList	ArrayList
    //   38	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	38	finally
    //   18	23	38	finally
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_Befq.sendEmptyMessage(102);
    this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(103, 10000L);
  }
  
  public boolean c(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt));
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 1064	aqfa:a	()Z
    //   6: ifne +31 -> 37
    //   9: aload_0
    //   10: getfield 1073	aqfa:f	Z
    //   13: ifne +12 -> 25
    //   16: aload_0
    //   17: invokevirtual 1105	aqfa:b	()V
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 1073	aqfa:f	Z
    //   25: aload_0
    //   26: getfield 62	aqfa:jdField_a_of_type_Befq	Lbefq;
    //   29: bipush 103
    //   31: invokevirtual 1115	befq:removeMessages	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 1066	aqfa:g	Z
    //   42: goto -17 -> 25
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	aqfa
    //   45	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	45	finally
    //   25	34	45	finally
    //   37	42	45	finally
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("sp_hotpic_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit().putBoolean("k_hotlist_f", false).commit();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i == 101)
    {
      a(a());
      b(a(), true);
      a(b(), true);
      return true;
    }
    if (i == 104)
    {
      a(a());
      return false;
    }
    if (i == 102)
    {
      f();
      return false;
    }
    if ((i == 103) && (this.jdField_a_of_type_Aqfc == null)) {
      paramMessage = a().iterator();
    }
    for (;;)
    {
      Object localObject;
      if (paramMessage.hasNext())
      {
        localObject = (HotPicData)paramMessage.next();
        if (this.jdField_a_of_type_Aqfc == null) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager", 2, "clear urldrawable cache");
        }
        return false;
      }
      try
      {
        if (((HotPicData)localObject).getDataType() == 2)
        {
          localObject = aqgq.a((HotVideoData)localObject);
          if (localObject != null) {
            URLDrawable.removeMemoryCacheByUrl(((URL)localObject).toString());
          }
        }
        else
        {
          URLDrawable.removeMemoryCacheByUrl(aqes.a(((HotPicData)localObject).url).toString());
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Atmp != null) {
      this.jdField_a_of_type_Atmp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqfa
 * JD-Core Version:    0.7.0.1
 */