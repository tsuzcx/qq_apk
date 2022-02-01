package com.tencent.avgame.gamelogic.data;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.Indexable;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class EngineData
  implements Cloneable
{
  public volatile byte a;
  public volatile int a;
  public volatile long a;
  public volatile FontStyleConfig a;
  private Game jdField_a_of_type_ComTencentAvgameGamelogicDataGame = new Game();
  public volatile PkCJOperationData a;
  private RoomInfo jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo = new RoomInfo();
  public volatile SurvivalPkResultInfo a;
  public String a;
  public List<ITopic> a;
  public CopyOnWriteArrayList<GameItem> a;
  public volatile boolean a;
  public volatile int b;
  public volatile long b;
  public String b;
  public volatile List<Long> b;
  private CopyOnWriteArrayList<QuestionClassInfo> b;
  public volatile boolean b;
  public volatile int c;
  public volatile List<Long> c;
  public volatile boolean c;
  public volatile int d;
  public volatile List<Long> d;
  public volatile boolean d;
  public volatile int e;
  public boolean e;
  public volatile int f;
  public volatile int g;
  public volatile int h;
  public volatile int i;
  public int j;
  
  public EngineData()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo = new SurvivalPkResultInfo();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData = new PkCJOperationData();
    this.jdField_a_of_type_ComTencentAvgameDataFontStyleConfig = new FontStyleConfig();
    this.jdField_e_of_type_Boolean = true;
    a();
  }
  
  private void f()
  {
    a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
    a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.b);
    a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.c);
    a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.d);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.c();
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a(paramString);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.id;
  }
  
  public ITopic a()
  {
    try
    {
      ITopic localITopic = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a();
      return localITopic;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public EngineData a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 2	com/tencent/avgame/gamelogic/data/EngineData
    //   5: dup
    //   6: invokespecial 119	com/tencent/avgame/gamelogic/data/EngineData:<init>	()V
    //   9: astore_1
    //   10: aload_1
    //   11: getfield 82	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   14: aload_0
    //   15: getfield 82	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   18: invokevirtual 123	com/tencent/avgame/gamelogic/data/RoomInfo:copyFrom	(Lcom/tencent/avgame/gamelogic/data/RoomInfo;)V
    //   21: aload_1
    //   22: getfield 87	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataGame	Lcom/tencent/avgame/gamelogic/data/Game;
    //   25: aload_0
    //   26: getfield 87	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataGame	Lcom/tencent/avgame/gamelogic/data/Game;
    //   29: invokevirtual 126	com/tencent/avgame/gamelogic/data/Game:a	(Lcom/tencent/avgame/gamelogic/data/Game;)V
    //   32: aload_1
    //   33: getfield 41	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   36: aload_0
    //   37: getfield 41	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   40: invokevirtual 130	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   43: pop
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 132	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Int	I
    //   49: putfield 132	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Int	I
    //   52: aload_1
    //   53: getfield 46	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   56: aload_0
    //   57: getfield 46	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   60: invokeinterface 135 2 0
    //   65: pop
    //   66: aload_1
    //   67: getfield 48	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   70: aload_0
    //   71: getfield 48	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   74: invokevirtual 130	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   77: pop
    //   78: aload_1
    //   79: aload_0
    //   80: getfield 137	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   83: putfield 137	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: aload_1
    //   87: aload_0
    //   88: getfield 139	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   91: putfield 139	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   94: aload_1
    //   95: aload_0
    //   96: getfield 141	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Boolean	Z
    //   99: putfield 141	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Boolean	Z
    //   102: aload_1
    //   103: aload_0
    //   104: getfield 65	com/tencent/avgame/gamelogic/data/EngineData:jdField_d_of_type_Boolean	Z
    //   107: putfield 65	com/tencent/avgame/gamelogic/data/EngineData:jdField_d_of_type_Boolean	Z
    //   110: aload_1
    //   111: aload_0
    //   112: getfield 63	com/tencent/avgame/gamelogic/data/EngineData:jdField_c_of_type_Boolean	Z
    //   115: putfield 63	com/tencent/avgame/gamelogic/data/EngineData:jdField_c_of_type_Boolean	Z
    //   118: aload_1
    //   119: aload_0
    //   120: getfield 143	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_Int	I
    //   123: putfield 143	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_Int	I
    //   126: aload_1
    //   127: aload_0
    //   128: getfield 145	com/tencent/avgame/gamelogic/data/EngineData:jdField_c_of_type_Int	I
    //   131: putfield 145	com/tencent/avgame/gamelogic/data/EngineData:jdField_c_of_type_Int	I
    //   134: aload_1
    //   135: aload_0
    //   136: getfield 50	com/tencent/avgame/gamelogic/data/EngineData:jdField_d_of_type_Int	I
    //   139: putfield 50	com/tencent/avgame/gamelogic/data/EngineData:jdField_d_of_type_Int	I
    //   142: aload_1
    //   143: aload_0
    //   144: getfield 147	com/tencent/avgame/gamelogic/data/EngineData:jdField_e_of_type_Int	I
    //   147: putfield 147	com/tencent/avgame/gamelogic/data/EngineData:jdField_e_of_type_Int	I
    //   150: aload_1
    //   151: aload_0
    //   152: getfield 149	com/tencent/avgame/gamelogic/data/EngineData:f	I
    //   155: putfield 149	com/tencent/avgame/gamelogic/data/EngineData:f	I
    //   158: aload_1
    //   159: aload_0
    //   160: getfield 151	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Long	J
    //   163: putfield 151	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Long	J
    //   166: aload_1
    //   167: aload_0
    //   168: getfield 153	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_Long	J
    //   171: putfield 153	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_Long	J
    //   174: aload_1
    //   175: aload_0
    //   176: getfield 155	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Byte	B
    //   179: putfield 155	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Byte	B
    //   182: aload_1
    //   183: aload_0
    //   184: getfield 157	com/tencent/avgame/gamelogic/data/EngineData:h	I
    //   187: putfield 157	com/tencent/avgame/gamelogic/data/EngineData:h	I
    //   190: aload_1
    //   191: aload_0
    //   192: getfield 159	com/tencent/avgame/gamelogic/data/EngineData:i	I
    //   195: putfield 159	com/tencent/avgame/gamelogic/data/EngineData:i	I
    //   198: aload_1
    //   199: aload_0
    //   200: getfield 161	com/tencent/avgame/gamelogic/data/EngineData:g	I
    //   203: putfield 161	com/tencent/avgame/gamelogic/data/EngineData:g	I
    //   206: aload_1
    //   207: aload_0
    //   208: getfield 163	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_Boolean	Z
    //   211: putfield 163	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_Boolean	Z
    //   214: aload_1
    //   215: getfield 52	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   218: aload_0
    //   219: getfield 52	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   222: invokeinterface 135 2 0
    //   227: pop
    //   228: aload_1
    //   229: getfield 54	com/tencent/avgame/gamelogic/data/EngineData:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   232: aload_0
    //   233: getfield 54	com/tencent/avgame/gamelogic/data/EngineData:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   236: invokeinterface 135 2 0
    //   241: pop
    //   242: aload_1
    //   243: getfield 56	com/tencent/avgame/gamelogic/data/EngineData:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   246: aload_0
    //   247: getfield 56	com/tencent/avgame/gamelogic/data/EngineData:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   250: invokeinterface 135 2 0
    //   255: pop
    //   256: aload_1
    //   257: getfield 61	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo	Lcom/tencent/avgame/gamelogic/data/SurvivalPkResultInfo;
    //   260: aload_0
    //   261: getfield 61	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo	Lcom/tencent/avgame/gamelogic/data/SurvivalPkResultInfo;
    //   264: invokevirtual 166	com/tencent/avgame/gamelogic/data/SurvivalPkResultInfo:copyFrom	(Lcom/tencent/avgame/gamelogic/data/SurvivalPkResultInfo;)V
    //   267: aload_1
    //   268: aload_0
    //   269: getfield 70	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData	Lcom/tencent/avgame/gamelogic/data/PkCJOperationData;
    //   272: putfield 70	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData	Lcom/tencent/avgame/gamelogic/data/PkCJOperationData;
    //   275: aload_1
    //   276: aload_0
    //   277: getfield 75	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameDataFontStyleConfig	Lcom/tencent/avgame/data/FontStyleConfig;
    //   280: putfield 75	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameDataFontStyleConfig	Lcom/tencent/avgame/data/FontStyleConfig;
    //   283: aload_1
    //   284: aload_0
    //   285: getfield 168	com/tencent/avgame/gamelogic/data/EngineData:j	I
    //   288: putfield 168	com/tencent/avgame/gamelogic/data/EngineData:j	I
    //   291: aload_1
    //   292: aload_0
    //   293: getfield 77	com/tencent/avgame/gamelogic/data/EngineData:jdField_e_of_type_Boolean	Z
    //   296: putfield 77	com/tencent/avgame/gamelogic/data/EngineData:jdField_e_of_type_Boolean	Z
    //   299: aload_0
    //   300: monitorexit
    //   301: aload_1
    //   302: areturn
    //   303: astore_1
    //   304: aload_0
    //   305: monitorexit
    //   306: aload_1
    //   307: athrow
    //   308: astore_2
    //   309: goto -10 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	EngineData
    //   9	293	1	localEngineData	EngineData
    //   303	4	1	localObject	Object
    //   308	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	10	303	finally
    //   10	299	303	finally
    //   10	299	308	java/lang/Exception
  }
  
  public Game a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame;
  }
  
  public Game a(Game paramGame)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.b(paramGame);
      paramGame = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame;
      return paramGame;
    }
    finally
    {
      paramGame = finally;
      throw paramGame;
    }
  }
  
  public GameItem a()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() > this.jdField_a_of_type_Int)) {
      return (GameItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(this.jdField_a_of_type_Int);
    }
    return null;
  }
  
  public GameRecordInfo a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.gameType == 0) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.gameType = c();
      }
      GameRecordInfo localGameRecordInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo;
      return localGameRecordInfo;
    }
    finally {}
  }
  
  public Player a()
  {
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.getPlayer(str);
  }
  
  public QuestionClassInfo a(int paramInt)
  {
    Object localObject3 = null;
    try
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      Object localObject1;
      int k;
      do
      {
        localObject1 = localObject3;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (QuestionClassInfo)localIterator.next();
        k = ((QuestionClassInfo)localObject1).jdField_a_of_type_Int;
      } while (k != paramInt);
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public RoomInfo a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
  }
  
  public RoomInfo a(RoomInfo paramRoomInfo, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.copyFrom(paramRoomInfo);
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a();
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      paramRoomInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
      return paramRoomInfo;
    }
    finally {}
  }
  
  public SurvivalPkResultInfo a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo;
  }
  
  public String a()
  {
    if (c() == 3) {
      return MobileQQ.sMobileQQ.getApplicationContext().getString(2131690514);
    }
    int k = d();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      GameItem localGameItem = (GameItem)localIterator.next();
      if ((localGameItem != null) && (localGameItem.jdField_a_of_type_Int == k)) {
        return localGameItem.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  public List<ITopic> a()
  {
    try
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.reset();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.f = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Byte = 0;
    this.h = 0;
    this.i = 0;
    this.g = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo = new SurvivalPkResultInfo();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData = new PkCJOperationData();
    this.jdField_a_of_type_ComTencentAvgameDataFontStyleConfig = new FontStyleConfig();
    this.j = 0;
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    try
    {
      n = this.jdField_a_of_type_Int;
      k = 0;
    }
    finally
    {
      for (;;)
      {
        int n;
        int k;
        int m;
        for (;;)
        {
          throw localObject;
        }
        label68:
        k += 1;
      }
    }
    m = n;
    if (k < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      if (paramInt != ((GameItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k)).jdField_a_of_type_Int) {
        break label68;
      }
      m = k;
    }
    this.jdField_a_of_type_Int = m;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initForSurvivalPk ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramBoolean);
    QLog.d("EngineData", 2, localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(long paramLong, int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.id == paramLong)) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.matchStatus = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(PkCJOperationData paramPkCJOperationData)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData = paramPkCJOperationData;
  }
  
  public void a(Player paramPlayer)
  {
    if (paramPlayer != null)
    {
      if (TextUtils.isEmpty(paramPlayer.uin)) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.players.iterator();
      while (localIterator.hasNext())
      {
        Player localPlayer = (Player)localIterator.next();
        if (paramPlayer.isSame(localPlayer)) {
          paramPlayer.nick = localPlayer.nick;
        }
      }
    }
  }
  
  public void a(SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.copyFrom(paramSurvivalPkResultInfo);
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a(paramString1, paramString2, paramLong);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(List<Long> paramList)
  {
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    Iterator localIterator1 = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator1.hasNext())
    {
      int m = 0;
      Long localLong = (Long)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      do
      {
        k = m;
        if (!localIterator2.hasNext()) {
          break;
        }
      } while (!localLong.equals((Long)localIterator2.next()));
      int k = 1;
      if (k == 0) {
        this.jdField_c_of_type_JavaUtilList.add(localLong);
      } else {
        this.jdField_b_of_type_JavaUtilList.remove(localLong);
      }
    }
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(List<GameItem> paramList, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      if (paramList == null) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GameItem localGameItem = (GameItem)paramList.next();
        if (GameUtil.d(GameUtil.a(localGameItem.jdField_a_of_type_Int))) {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localGameItem);
        }
      }
      e();
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(List<QuestionClassInfo> paramList, String paramString1, String paramString2)
  {
    if ((paramList != null) && (paramString1 != null) && (paramString2 != null)) {
      try
      {
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          QuestionClassInfo localQuestionClassInfo = (QuestionClassInfo)paramList.next();
          this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localQuestionClassInfo);
        }
        this.jdField_a_of_type_JavaLangString = paramString1;
        this.jdField_b_of_type_JavaLangString = paramString2;
        return;
      }
      finally {}
    }
  }
  
  public void a(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.size() <= 0) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.updateNicks(paramMap);
      f();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo != null) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.matchV2Extra = paramArrayOfByte;
      }
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.id != 0L) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a()));
  }
  
  public boolean a(ITopic paramITopic)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a(paramITopic);
      return bool;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  public boolean a(ITopic paramITopic, int paramInt1, Player paramPlayer, long paramLong, int paramInt2, AnswerInfo paramAnswerInfo, boolean paramBoolean)
  {
    try
    {
      paramBoolean = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a(paramITopic, paramInt1, paramPlayer, paramLong, paramInt2, paramAnswerInfo, paramBoolean);
      if (paramBoolean) {
        a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.d);
      }
      return paramBoolean;
    }
    finally {}
  }
  
  public boolean a(ITopic paramITopic, AnswerInfo paramAnswerInfo, boolean paramBoolean)
  {
    try
    {
      paramBoolean = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a(paramITopic, paramAnswerInfo, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  public boolean a(ITopic paramITopic, boolean paramBoolean)
  {
    try
    {
      paramBoolean = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a(paramITopic, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  public boolean a(Game paramGame)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a(paramGame);
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.b();
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.onGameStart();
      this.jdField_a_of_type_JavaUtilList.clear();
      f();
      if (this.jdField_a_of_type_Boolean)
      {
        f(3);
        if ((paramGame != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null))
        {
          int k = 0;
          while (k < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
          {
            if (((GameItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k)).jdField_a_of_type_Int == paramGame.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_a_of_type_Int)
            {
              this.jdField_a_of_type_Int = k;
              break;
            }
            k += 1;
          }
        }
      }
      return true;
    }
    finally {}
    for (;;)
    {
      throw paramGame;
    }
  }
  
  public boolean a(Player paramPlayer)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a(paramPlayer);
      if (bool) {
        a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.c);
      }
      return bool;
    }
    finally {}
  }
  
  public boolean a(Player paramPlayer, ITopic paramITopic)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a(paramPlayer, paramITopic);
      if (bool) {
        a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
      }
      return bool;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    if (d())
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) && (paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return false;
      }
      if ((paramString.equalsIgnoreCase(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount())) && (paramInt == 1)) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.c();
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.onChangeUserStatus(paramString, paramInt);
      return true;
    }
    finally {}
  }
  
  public boolean a(List<UserScore> paramList)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a(paramList);
      return bool;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
      boolean bool = false;
      if (localObject1 != null)
      {
        if (paramBoolean)
        {
          paramBoolean = bool;
          if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.isRoomMatching()) {
            if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.matchShareId <= 0)
            {
              localObject1 = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.matchV2Extra;
              paramBoolean = bool;
              if (localObject1 == null) {}
            }
            else
            {
              paramBoolean = true;
            }
          }
          return paramBoolean;
        }
        paramBoolean = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.isRoomMatching();
        return paramBoolean;
      }
      return false;
    }
    finally {}
  }
  
  public byte[] a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo != null)
      {
        byte[] arrayOfByte = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.matchV2Extra;
        return arrayOfByte;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int b()
  {
    Player localPlayer = a();
    if (localPlayer != null) {
      return localPlayer.status;
    }
    return 1;
  }
  
  public long b()
  {
    long l1 = 9223372036854775807L;
    int k = 0;
    while (k < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      GameItem localGameItem = (GameItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k);
      long l2 = l1;
      if (GameUtil.b((GameItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k)))
      {
        l2 = localGameItem.jdField_b_of_type_Long - NetConnInfoCenter.getServerTime();
        if (l2 < 0L) {
          return 0L;
        }
        l2 = Math.min(l1, l2);
      }
      k += 1;
      l1 = l2;
    }
    return l1;
  }
  
  public Player b()
  {
    try
    {
      Player localPlayer = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a();
      return localPlayer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a();
  }
  
  public List<ITopic> b()
  {
    a();
    int k = e();
    ArrayList localArrayList = new ArrayList();
    while (k < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(k));
      k += 1;
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.reset();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSurvivalPoolId ");
    localStringBuilder.append(paramInt);
    QLog.d("EngineData", 2, localStringBuilder.toString());
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(long paramLong, int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.id == paramLong)) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.matchShareId = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(List<Long> paramList, int paramInt)
  {
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    if (paramInt == 1)
    {
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      return;
    }
    if (paramInt == 2) {
      this.jdField_c_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo == null;
  }
  
  public boolean b(ITopic paramITopic)
  {
    if (paramITopic == null) {
      return false;
    }
    try
    {
      paramITopic = paramITopic.a();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramITopic);
      return true;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  public boolean b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.c() != 0) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.c() != 10)) {
      return a(paramString);
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a();
  }
  
  public long c()
  {
    long l1 = 9223372036854775807L;
    int k = 0;
    while (k < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      GameItem localGameItem = (GameItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k);
      long l2 = l1;
      if (GameUtil.a((GameItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k)))
      {
        l2 = localGameItem.c - NetConnInfoCenter.getServerTime();
        if (l2 < 0L) {
          return 0L;
        }
        l2 = Math.min(l1, l2);
      }
      k += 1;
      l1 = l2;
    }
    return l1;
  }
  
  public String c()
  {
    String str = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_a_of_type_JavaLangString;
    Object localObject;
    if (str != null)
    {
      localObject = str;
      if (str.length() != 0) {}
    }
    else
    {
      localObject = a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.b());
      int k;
      if ((localObject != null) && (((QuestionClassInfo)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (((QuestionClassInfo)localObject).jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0) {
        return MobileQQ.sMobileQQ.getApplicationContext().getString(2131690435);
      }
      localObject = null;
    }
    return localObject;
  }
  
  public List<Long> c()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.reset();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.f = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Byte = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo = new SurvivalPkResultInfo();
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.b();
      if (bool) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.onGameOver();
      }
      return bool;
    }
    finally {}
  }
  
  public boolean c(ITopic paramITopic)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.b(paramITopic);
      return bool;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  public boolean c(String paramString)
  {
    int k = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.c();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (k != 0)
    {
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.c() == 10) {
        return false;
      }
      String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      bool1 = bool2;
      if (c() == 3)
      {
        bool1 = bool2;
        if (TextUtils.equals(paramString, str)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.b();
  }
  
  public long d()
  {
    return Math.min(b(), c());
  }
  
  public String d()
  {
    String str = c();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (str != null)
    {
      if (str.length() == 0) {
        return null;
      }
      localObject1 = a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.b());
      if (localObject1 != null)
      {
        localObject1 = ((QuestionClassInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localQuestionClassInfoItem = (QuestionClassInfoItem)((Iterator)localObject1).next();
          if ((localQuestionClassInfoItem.jdField_a_of_type_JavaLangString != null) && (localQuestionClassInfoItem.jdField_a_of_type_JavaLangString.equals(str))) {
            break label92;
          }
        }
      }
      QuestionClassInfoItem localQuestionClassInfoItem = null;
      label92:
      localObject1 = localObject2;
      if (localQuestionClassInfoItem != null) {
        localObject1 = localQuestionClassInfoItem.c;
      }
    }
    return localObject1;
  }
  
  public List<Long> d()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo = null;
  }
  
  public void d(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFromMatchV2 ");
      localStringBuilder.append(paramBoolean);
      QLog.d("EngineData", 2, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.fromMatchB2 = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean d()
  {
    return GameUtil.a(c());
  }
  
  public boolean d(ITopic paramITopic)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.c(paramITopic);
      return bool;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  public boolean d(String paramString)
  {
    return a(paramString);
  }
  
  public int e()
  {
    ITopic localITopic = a();
    if ((localITopic instanceof Indexable)) {
      return ((Indexable)localITopic).c_();
    }
    return 0;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData.bizTitlePicIdx;
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        GameItem localGameItem = (GameItem)((Iterator)localObject).next();
        if (GameUtil.a(localGameItem))
        {
          if ((localGameItem.jdField_b_of_type_Int == 1) && (localGameItem.jdField_b_of_type_Long <= NetConnInfoCenter.getServerTime())) {
            localGameItem.jdField_b_of_type_Int = 2;
          }
          if (localGameItem.c <= NetConnInfoCenter.getServerTime())
          {
            int k = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.indexOf(localGameItem);
            if (this.jdField_a_of_type_Int == k) {
              this.jdField_a_of_type_Int = 0;
            }
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localGameItem);
          }
        }
      }
    }
  }
  
  public void e(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSurvivalPkState ");
    localStringBuilder.append(paramInt);
    QLog.d("EngineData", 2, localStringBuilder.toString());
    this.f = paramInt;
  }
  
  public void e(boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMatchingB2Quick ");
      localStringBuilder.append(paramBoolean);
      QLog.d("EngineData", 2, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.startMatching2Quick = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean e()
  {
    try
    {
      RoomInfo localRoomInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localRoomInfo != null)
      {
        int k = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.getPlayers().size();
        bool1 = bool2;
        if (k >= 8) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public boolean e(String paramString)
  {
    return Long.toString(this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.owner).equalsIgnoreCase(paramString);
  }
  
  public int f()
  {
    return a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.h;
  }
  
  public String f()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData.bizTitelPicUrl;
  }
  
  public void f(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSurvivalGameStatus ");
    localStringBuilder.append(paramInt);
    QLog.d("EngineData", 2, localStringBuilder.toString());
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int g()
  {
    int k = a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.g;
    if (k == 0)
    {
      k = a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_c_of_type_Int;
      int m = a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_e_of_type_Int + a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.f;
      if (m > 0) {
        return k / m;
      }
    }
    else if (k == 1)
    {
      return a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.h;
    }
    return 0;
  }
  
  public String g()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData.biaAdTip;
  }
  
  public void g(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSurvivalCurRound ");
    localStringBuilder.append(paramInt);
    QLog.d("EngineData", 2, localStringBuilder.toString());
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public boolean g()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int h()
  {
    RoomInfo localRoomInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
    if (localRoomInfo == null) {
      return 0;
    }
    return localRoomInfo.getUins().size();
  }
  
  public String h()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData.waitingBgUrl;
  }
  
  public void h(int paramInt)
  {
    this.g = paramInt;
  }
  
  public boolean h()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int i()
  {
    int k = 0;
    try
    {
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo != null) {
        k = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.matchShareId;
      }
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String i()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData.answerTip;
  }
  
  public boolean i()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int j()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean j()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.fromMatchB2;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int k()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public boolean k()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.startMatching2Quick;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int l()
  {
    return this.h;
  }
  
  public boolean l()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int m()
  {
    return this.i;
  }
  
  public int n()
  {
    return this.f;
  }
  
  public int o()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public int p()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public int q()
  {
    return this.g;
  }
  
  public int r()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData.sponsorId;
  }
  
  public int s()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.a();
  }
  
  public int t()
  {
    return this.j;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n");
    localStringBuilder.append("roomInfo");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo);
    localStringBuilder.append("\n");
    localStringBuilder.append("game");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame);
    localStringBuilder.append("\n");
    localStringBuilder.append("curGameIndex");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("gameListSize");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    localStringBuilder.append("\n");
    localStringBuilder.append("topicCount");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.EngineData
 * JD-Core Version:    0.7.0.1
 */