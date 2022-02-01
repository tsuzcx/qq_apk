package com.tencent.avgame.gamelogic.data;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.Indexable;
import com.tencent.avgame.gameroom.stage.util.FontStyleConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class EngineData
  implements Cloneable
{
  public volatile byte a;
  public volatile int a;
  public volatile long a;
  @NotNull
  private Game jdField_a_of_type_ComTencentAvgameGamelogicDataGame = new Game();
  public volatile PkCJOperationData a;
  @NotNull
  private RoomInfo jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo = new RoomInfo();
  public volatile SurvivalPkResultInfo a;
  public volatile FontStyleConfig a;
  public String a;
  public List<ITopic> a;
  @NotNull
  public CopyOnWriteArrayList<GameItem> a;
  public volatile boolean a;
  public volatile int b;
  public volatile long b;
  public String b;
  public volatile List<Long> b;
  @NotNull
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
    this.jdField_a_of_type_ComTencentAvgameGameroomStageUtilFontStyleConfig = new FontStyleConfig();
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
    //   6: invokespecial 120	com/tencent/avgame/gamelogic/data/EngineData:<init>	()V
    //   9: astore_1
    //   10: aload_1
    //   11: getfield 83	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   14: aload_0
    //   15: getfield 83	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   18: invokevirtual 124	com/tencent/avgame/gamelogic/data/RoomInfo:copyFrom	(Lcom/tencent/avgame/gamelogic/data/RoomInfo;)V
    //   21: aload_1
    //   22: getfield 88	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataGame	Lcom/tencent/avgame/gamelogic/data/Game;
    //   25: aload_0
    //   26: getfield 88	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataGame	Lcom/tencent/avgame/gamelogic/data/Game;
    //   29: invokevirtual 127	com/tencent/avgame/gamelogic/data/Game:a	(Lcom/tencent/avgame/gamelogic/data/Game;)V
    //   32: aload_1
    //   33: getfield 42	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   36: aload_0
    //   37: getfield 42	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   40: invokevirtual 131	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   43: pop
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 133	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Int	I
    //   49: putfield 133	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Int	I
    //   52: aload_1
    //   53: getfield 47	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   56: aload_0
    //   57: getfield 47	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   60: invokeinterface 136 2 0
    //   65: pop
    //   66: aload_1
    //   67: getfield 49	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   70: aload_0
    //   71: getfield 49	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   74: invokevirtual 131	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   77: pop
    //   78: aload_1
    //   79: aload_0
    //   80: getfield 138	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   83: putfield 138	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: aload_1
    //   87: aload_0
    //   88: getfield 140	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   91: putfield 140	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   94: aload_1
    //   95: aload_0
    //   96: getfield 142	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Boolean	Z
    //   99: putfield 142	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Boolean	Z
    //   102: aload_1
    //   103: aload_0
    //   104: getfield 66	com/tencent/avgame/gamelogic/data/EngineData:jdField_d_of_type_Boolean	Z
    //   107: putfield 66	com/tencent/avgame/gamelogic/data/EngineData:jdField_d_of_type_Boolean	Z
    //   110: aload_1
    //   111: aload_0
    //   112: getfield 64	com/tencent/avgame/gamelogic/data/EngineData:jdField_c_of_type_Boolean	Z
    //   115: putfield 64	com/tencent/avgame/gamelogic/data/EngineData:jdField_c_of_type_Boolean	Z
    //   118: aload_1
    //   119: aload_0
    //   120: getfield 144	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_Int	I
    //   123: putfield 144	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_Int	I
    //   126: aload_1
    //   127: aload_0
    //   128: getfield 146	com/tencent/avgame/gamelogic/data/EngineData:jdField_c_of_type_Int	I
    //   131: putfield 146	com/tencent/avgame/gamelogic/data/EngineData:jdField_c_of_type_Int	I
    //   134: aload_1
    //   135: aload_0
    //   136: getfield 51	com/tencent/avgame/gamelogic/data/EngineData:jdField_d_of_type_Int	I
    //   139: putfield 51	com/tencent/avgame/gamelogic/data/EngineData:jdField_d_of_type_Int	I
    //   142: aload_1
    //   143: aload_0
    //   144: getfield 148	com/tencent/avgame/gamelogic/data/EngineData:jdField_e_of_type_Int	I
    //   147: putfield 148	com/tencent/avgame/gamelogic/data/EngineData:jdField_e_of_type_Int	I
    //   150: aload_1
    //   151: aload_0
    //   152: getfield 150	com/tencent/avgame/gamelogic/data/EngineData:f	I
    //   155: putfield 150	com/tencent/avgame/gamelogic/data/EngineData:f	I
    //   158: aload_1
    //   159: aload_0
    //   160: getfield 152	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Long	J
    //   163: putfield 152	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Long	J
    //   166: aload_1
    //   167: aload_0
    //   168: getfield 154	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_Long	J
    //   171: putfield 154	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_Long	J
    //   174: aload_1
    //   175: aload_0
    //   176: getfield 156	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Byte	B
    //   179: putfield 156	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Byte	B
    //   182: aload_1
    //   183: aload_0
    //   184: getfield 158	com/tencent/avgame/gamelogic/data/EngineData:h	I
    //   187: putfield 158	com/tencent/avgame/gamelogic/data/EngineData:h	I
    //   190: aload_1
    //   191: aload_0
    //   192: getfield 160	com/tencent/avgame/gamelogic/data/EngineData:i	I
    //   195: putfield 160	com/tencent/avgame/gamelogic/data/EngineData:i	I
    //   198: aload_1
    //   199: aload_0
    //   200: getfield 162	com/tencent/avgame/gamelogic/data/EngineData:g	I
    //   203: putfield 162	com/tencent/avgame/gamelogic/data/EngineData:g	I
    //   206: aload_1
    //   207: aload_0
    //   208: getfield 164	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_Boolean	Z
    //   211: putfield 164	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_Boolean	Z
    //   214: aload_1
    //   215: getfield 53	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   218: aload_0
    //   219: getfield 53	com/tencent/avgame/gamelogic/data/EngineData:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   222: invokeinterface 136 2 0
    //   227: pop
    //   228: aload_1
    //   229: getfield 55	com/tencent/avgame/gamelogic/data/EngineData:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   232: aload_0
    //   233: getfield 55	com/tencent/avgame/gamelogic/data/EngineData:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   236: invokeinterface 136 2 0
    //   241: pop
    //   242: aload_1
    //   243: getfield 57	com/tencent/avgame/gamelogic/data/EngineData:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   246: aload_0
    //   247: getfield 57	com/tencent/avgame/gamelogic/data/EngineData:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   250: invokeinterface 136 2 0
    //   255: pop
    //   256: aload_1
    //   257: getfield 62	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo	Lcom/tencent/avgame/gamelogic/data/SurvivalPkResultInfo;
    //   260: aload_0
    //   261: getfield 62	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo	Lcom/tencent/avgame/gamelogic/data/SurvivalPkResultInfo;
    //   264: invokevirtual 167	com/tencent/avgame/gamelogic/data/SurvivalPkResultInfo:copyFrom	(Lcom/tencent/avgame/gamelogic/data/SurvivalPkResultInfo;)V
    //   267: aload_1
    //   268: aload_0
    //   269: getfield 71	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData	Lcom/tencent/avgame/gamelogic/data/PkCJOperationData;
    //   272: putfield 71	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData	Lcom/tencent/avgame/gamelogic/data/PkCJOperationData;
    //   275: aload_1
    //   276: aload_0
    //   277: getfield 76	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGameroomStageUtilFontStyleConfig	Lcom/tencent/avgame/gameroom/stage/util/FontStyleConfig;
    //   280: putfield 76	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGameroomStageUtilFontStyleConfig	Lcom/tencent/avgame/gameroom/stage/util/FontStyleConfig;
    //   283: aload_1
    //   284: aload_0
    //   285: getfield 169	com/tencent/avgame/gamelogic/data/EngineData:j	I
    //   288: putfield 169	com/tencent/avgame/gamelogic/data/EngineData:j	I
    //   291: aload_1
    //   292: aload_0
    //   293: getfield 78	com/tencent/avgame/gamelogic/data/EngineData:jdField_e_of_type_Boolean	Z
    //   296: putfield 78	com/tencent/avgame/gamelogic/data/EngineData:jdField_e_of_type_Boolean	Z
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
  
  @NotNull
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
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > this.jdField_a_of_type_Int)) {
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
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.getPlayer(str);
  }
  
  public QuestionClassInfo a(int paramInt)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (localIterator.hasNext())
        {
          QuestionClassInfo localQuestionClassInfo = (QuestionClassInfo)localIterator.next();
          int k = localQuestionClassInfo.jdField_a_of_type_Int;
          if (k != paramInt) {
            continue;
          }
          return localQuestionClassInfo;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  @NotNull
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
      return BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690586);
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
    this.jdField_a_of_type_ComTencentAvgameGameroomStageUtilFontStyleConfig = new FontStyleConfig();
    this.j = 0;
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        int m = this.jdField_a_of_type_Int;
        int k = 0;
        if (k < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
        {
          if (paramInt == ((GameItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k)).jdField_a_of_type_Int)
          {
            this.jdField_a_of_type_Int = k;
            return;
          }
          k += 1;
        }
        else
        {
          k = m;
        }
      }
      finally {}
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    QLog.d("EngineData", 2, "initForSurvivalPk " + paramInt + " " + paramBoolean);
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
    if ((paramPlayer == null) || (TextUtils.isEmpty(paramPlayer.uin))) {}
    for (;;)
    {
      return;
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
    Long localLong;
    if (localIterator1.hasNext())
    {
      localLong = (Long)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
      } while (!localLong.equals((Long)localIterator2.next()));
    }
    for (int k = 1;; k = 0)
    {
      if (k == 0)
      {
        this.jdField_c_of_type_JavaUtilList.add(localLong);
        break;
      }
      this.jdField_b_of_type_JavaUtilList.remove(localLong);
      break;
      this.jdField_d_of_type_JavaUtilList.clear();
      this.jdField_d_of_type_JavaUtilList.addAll(paramList);
      return;
    }
  }
  
  public void a(List<GameItem> paramList, int paramInt)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        if (paramList == null) {
          return;
        }
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          GameItem localGameItem = (GameItem)paramList.next();
          if (!GameUtil.d(GameUtil.a(localGameItem.jdField_a_of_type_Int))) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localGameItem);
          continue;
        }
        e();
      }
      finally {}
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(List<QuestionClassInfo> paramList, String paramString1, String paramString2)
  {
    if ((paramList == null) || (paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      return;
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
      }
      finally {}
      this.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
  
  public void a(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() <= 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.updateNicks(paramMap);
    f();
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
  
  /* Error */
  public boolean a(Game paramGame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 88	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataGame	Lcom/tencent/avgame/gamelogic/data/Game;
    //   6: aload_1
    //   7: invokevirtual 127	com/tencent/avgame/gamelogic/data/Game:a	(Lcom/tencent/avgame/gamelogic/data/Game;)V
    //   10: aload_0
    //   11: getfield 88	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataGame	Lcom/tencent/avgame/gamelogic/data/Game;
    //   14: invokevirtual 388	com/tencent/avgame/gamelogic/data/Game:b	()V
    //   17: aload_0
    //   18: getfield 83	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   21: invokevirtual 391	com/tencent/avgame/gamelogic/data/RoomInfo:onGameStart	()V
    //   24: aload_0
    //   25: getfield 47	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   28: invokeinterface 239 1 0
    //   33: aload_0
    //   34: invokespecial 364	com/tencent/avgame/gamelogic/data/EngineData:f	()V
    //   37: aload_0
    //   38: getfield 142	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Boolean	Z
    //   41: ifeq +61 -> 102
    //   44: aload_0
    //   45: iconst_3
    //   46: invokevirtual 393	com/tencent/avgame/gamelogic/data/EngineData:f	(I)V
    //   49: aload_1
    //   50: ifnull +52 -> 102
    //   53: aload_0
    //   54: getfield 42	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   57: ifnull +45 -> 102
    //   60: iconst_0
    //   61: istore_2
    //   62: iload_2
    //   63: aload_0
    //   64: getfield 42	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   67: invokevirtual 178	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   70: if_icmpge +32 -> 102
    //   73: aload_0
    //   74: getfield 42	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   77: iload_2
    //   78: invokevirtual 182	java/util/concurrent/CopyOnWriteArrayList:get	(I)Ljava/lang/Object;
    //   81: checkcast 184	com/tencent/avgame/gamelogic/data/GameItem
    //   84: getfield 254	com/tencent/avgame/gamelogic/data/GameItem:jdField_a_of_type_Int	I
    //   87: aload_1
    //   88: getfield 396	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo	Lcom/tencent/avgame/gamelogic/data/GameInfo;
    //   91: getfield 399	com/tencent/avgame/gamelogic/data/GameInfo:jdField_a_of_type_Int	I
    //   94: if_icmpne +12 -> 106
    //   97: aload_0
    //   98: iload_2
    //   99: putfield 133	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_Int	I
    //   102: aload_0
    //   103: monitorexit
    //   104: iconst_1
    //   105: ireturn
    //   106: iload_2
    //   107: iconst_1
    //   108: iadd
    //   109: istore_2
    //   110: goto -48 -> 62
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	EngineData
    //   0	118	1	paramGame	Game
    //   61	49	2	k	int
    // Exception table:
    //   from	to	target	type
    //   2	49	113	finally
    //   53	60	113	finally
    //   62	102	113	finally
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
    if ((!d()) || (TextUtils.isEmpty(paramString))) {}
    while ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) || (!paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin))) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: istore 4
    //   10: iload 4
    //   12: ifeq +9 -> 21
    //   15: iconst_0
    //   16: istore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_3
    //   20: ireturn
    //   21: aload_1
    //   22: invokestatic 201	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   25: invokevirtual 205	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   28: invokevirtual 211	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   31: invokevirtual 412	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   34: ifeq +15 -> 49
    //   37: iload_2
    //   38: iconst_1
    //   39: if_icmpne +10 -> 49
    //   42: aload_0
    //   43: getfield 88	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataGame	Lcom/tencent/avgame/gamelogic/data/Game;
    //   46: invokevirtual 415	com/tencent/avgame/gamelogic/data/Game:c	()V
    //   49: aload_0
    //   50: getfield 83	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   53: aload_1
    //   54: iload_2
    //   55: invokevirtual 419	com/tencent/avgame/gamelogic/data/RoomInfo:onChangeUserStatus	(Ljava/lang/String;I)V
    //   58: goto -41 -> 17
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	EngineData
    //   0	66	1	paramString	String
    //   0	66	2	paramInt	int
    //   1	19	3	bool1	boolean
    //   8	3	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	10	61	finally
    //   21	37	61	finally
    //   42	49	61	finally
    //   49	58	61	finally
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
  
  /* Error */
  public boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: iload_3
    //   5: istore_2
    //   6: aload_0
    //   7: getfield 83	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   10: ifnull +47 -> 57
    //   13: iload_1
    //   14: ifeq +47 -> 61
    //   17: iload_3
    //   18: istore_2
    //   19: aload_0
    //   20: getfield 83	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   23: invokevirtual 427	com/tencent/avgame/gamelogic/data/RoomInfo:isRoomMatching	()Z
    //   26: ifeq +31 -> 57
    //   29: aload_0
    //   30: getfield 83	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   33: getfield 430	com/tencent/avgame/gamelogic/data/RoomInfo:matchShareId	I
    //   36: ifgt +19 -> 55
    //   39: aload_0
    //   40: getfield 83	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   43: getfield 371	com/tencent/avgame/gamelogic/data/RoomInfo:matchV2Extra	[B
    //   46: astore 4
    //   48: iload_3
    //   49: istore_2
    //   50: aload 4
    //   52: ifnull +5 -> 57
    //   55: iconst_1
    //   56: istore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: iload_2
    //   60: ireturn
    //   61: aload_0
    //   62: getfield 83	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   65: invokevirtual 427	com/tencent/avgame/gamelogic/data/RoomInfo:isRoomMatching	()Z
    //   68: istore_2
    //   69: goto -12 -> 57
    //   72: astore 4
    //   74: aload_0
    //   75: monitorexit
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	EngineData
    //   0	79	1	paramBoolean	boolean
    //   5	64	2	bool1	boolean
    //   1	48	3	bool2	boolean
    //   46	5	4	arrayOfByte	byte[]
    //   72	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	13	72	finally
    //   19	48	72	finally
    //   61	69	72	finally
  }
  
  /* Error */
  public byte[] a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 83	com/tencent/avgame/gamelogic/data/EngineData:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   13: getfield 371	com/tencent/avgame/gamelogic/data/RoomInfo:matchV2Extra	[B
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aconst_null
    //   22: astore_1
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	EngineData
    //   16	7	1	arrayOfByte	byte[]
    //   26	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
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
    for (;;)
    {
      long l2 = l1;
      if (k < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
      {
        GameItem localGameItem = (GameItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k);
        l2 = l1;
        if (!GameUtil.b((GameItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k))) {
          break label85;
        }
        l2 = localGameItem.jdField_b_of_type_Long - NetConnInfoCenter.getServerTime();
        if (l2 < 0L) {
          l2 = 0L;
        }
      }
      else
      {
        return l2;
      }
      l2 = Math.min(l1, l2);
      label85:
      k += 1;
      l1 = l2;
    }
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
    QLog.d("EngineData", 2, "updateSurvivalPoolId " + paramInt);
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
    if (paramInt == 1) {
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    }
    while (paramInt != 2) {
      return;
    }
    this.jdField_c_of_type_JavaUtilList.addAll(paramList);
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
    boolean bool;
    if (paramITopic == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        paramITopic = paramITopic.a();
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramITopic);
        bool = true;
      }
      finally {}
    }
  }
  
  public boolean b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.c() == 0) || (this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.c() == 10)) {
      return false;
    }
    return a(paramString);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.a();
  }
  
  public long c()
  {
    long l1 = 9223372036854775807L;
    int k = 0;
    for (;;)
    {
      long l2 = l1;
      if (k < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
      {
        GameItem localGameItem = (GameItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k);
        l2 = l1;
        if (!GameUtil.a((GameItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k))) {
          break label85;
        }
        l2 = localGameItem.c - NetConnInfoCenter.getServerTime();
        if (l2 < 0L) {
          l2 = 0L;
        }
      }
      else
      {
        return l2;
      }
      l2 = Math.min(l1, l2);
      label85:
      k += 1;
      l1 = l2;
    }
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
      if ((localObject == null) || (((QuestionClassInfo)localObject).jdField_a_of_type_JavaUtilArrayList == null) || (((QuestionClassInfo)localObject).jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label78;
      }
    }
    label78:
    for (int k = 1; k != 0; k = 0)
    {
      localObject = BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690510);
      return localObject;
    }
    return null;
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
    if ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.c() == 0) || (this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.c() == 10)) {}
    String str;
    do
    {
      return false;
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    } while ((c() != 3) || (!TextUtils.equals(paramString, str)));
    return true;
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
    if ((str == null) || (str.length() == 0)) {
      return null;
    }
    Object localObject = a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame.b());
    if (localObject != null)
    {
      Iterator localIterator = ((QuestionClassInfo)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (QuestionClassInfoItem)localIterator.next();
      } while ((((QuestionClassInfoItem)localObject).jdField_a_of_type_JavaLangString == null) || (!((QuestionClassInfoItem)localObject).jdField_a_of_type_JavaLangString.equals(str)));
    }
    for (;;)
    {
      if (localObject != null) {
        return ((QuestionClassInfoItem)localObject).c;
      }
      return null;
      localObject = null;
    }
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
      QLog.d("EngineData", 2, "setFromMatchV2 " + paramBoolean);
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
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        GameItem localGameItem = (GameItem)localIterator.next();
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
    QLog.d("EngineData", 2, "updateSurvivalPkState " + paramInt);
    this.f = paramInt;
  }
  
  public void e(boolean paramBoolean)
  {
    try
    {
      QLog.d("EngineData", 2, "setMatchingB2Quick " + paramBoolean);
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo != null)
      {
        int k = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.getPlayers().size();
        bool1 = bool2;
        if (k >= 8) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
    QLog.d("EngineData", 2, "updateSurvivalGameStatus " + paramInt);
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
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData.biaAdWording;
  }
  
  public void g(int paramInt)
  {
    QLog.d("EngineData", 2, "updateSurvivalCurRound " + paramInt);
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public boolean g()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int h()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.getUins().size();
  }
  
  public String h()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData.biaAdTip;
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
  
  public boolean m()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataPkCJOperationData.closeRealtimeReport;
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
    localStringBuilder.append("\n").append("roomInfo").append("=").append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo);
    localStringBuilder.append("\n").append("game").append("=").append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGame);
    localStringBuilder.append("\n").append("curGameIndex").append("=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n").append("gameListSize").append("=").append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    localStringBuilder.append("\n").append("topicCount").append("=").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.EngineData
 * JD-Core Version:    0.7.0.1
 */