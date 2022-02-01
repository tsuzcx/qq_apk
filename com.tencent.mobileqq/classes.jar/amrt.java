import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameManager.2;
import com.tencent.mobileqq.apollo.process.data.CmGameManager.3;
import com.tencent.mobileqq.apollo.store.ApolloDiyTextActivity;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;

public class amrt
  implements Manager
{
  public static final Class[] a;
  public int a;
  private amlz jdField_a_of_type_Amlz;
  protected BroadcastReceiver a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ApolloCmdChannel jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CmGameManager.2(this);
  public List<amrw> a;
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<Integer, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<amrk> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangClass = new Class[] { ApolloGameActivity.class, ApolloDiyTextActivity.class };
  }
  
  public amrt(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    QLog.i("cmgame_process.CmGameManager", 1, "[CmGameManager] created.");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel = new ApolloCmdChannel(ampj.a());
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new amrv();
    paramAppInterface = new IntentFilter();
    paramAppInterface.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    try
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramAppInterface, "com.tencent.msg.permission.pushnotify", null);
      }
      ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 64, null, true);
      return;
    }
    catch (Throwable paramAppInterface)
    {
      for (;;)
      {
        QLog.e("cmgame_process.CmGameManager", 1, paramAppInterface, new Object[0]);
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("apollo_sp", 4);
    this.jdField_b_of_type_Int = localSharedPreferences.getInt("sp_key_exit_game_guide_count_limit", 0);
    if (localSharedPreferences.getInt("sp_key_exit_show_game_box_guide", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 4);
      this.jdField_a_of_type_Int = localSharedPreferences.getInt("sp_key_exit_game_guide_count", 0);
      e();
      if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        WindowManager localWindowManager = (WindowManager)BaseApplicationImpl.getApplication().getSystemService("window");
        if (localWindowManager != null)
        {
          int i = localWindowManager.getDefaultDisplay().getWidth();
          if (i <= 480)
          {
            this.jdField_a_of_type_Boolean = false;
            QLog.e("cmgame_process.CmGameManager", 1, new Object[] { "initGameExitData current display not should show game exit guide width:", Integer.valueOf(i) });
          }
        }
        if (localSharedPreferences.contains("exit_game_guide_today_" + ApolloUtil.b())) {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "initGameExitData mGameExitCurrentCount:", Integer.valueOf(this.jdField_a_of_type_Int), ",mGameExitLimitCount:", Integer.valueOf(this.jdField_b_of_type_Int), ",mShouldShowGameGuide:", Boolean.valueOf(this.jdField_a_of_type_Boolean), ",mShouldShowGameBoxGuide:", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      return;
    }
  }
  
  private void d()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 4);
    String str1 = "exit_game_guide_today_" + ApolloUtil.b();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    if (((SharedPreferences)localObject1).contains(str1)) {
      QLog.e("cmgame_process.CmGameManager", 1, "recordTodayCount today has show");
    }
    for (;;)
    {
      localEditor.commit();
      this.jdField_a_of_type_Boolean = false;
      return;
      Object localObject2 = ((SharedPreferences)localObject1).getAll();
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          String str2 = (String)localEntry.getKey();
          if ((str2 != null) && (str2.startsWith("exit_game_guide_today_"))) {
            ((List)localObject1).add(localEntry.getKey());
          }
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localEditor.remove((String)((Iterator)localObject1).next());
        }
      }
      localEditor.putInt(str1, 1);
    }
  }
  
  private void e()
  {
    int i = 0;
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_play.png";
    arrayOfString[1] = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_play_landscape.png";
    arrayOfString[2] = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_plus.png";
    arrayOfString[3] = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_plus_landscape.png";
    while (i < arrayOfString.length)
    {
      amwz.a(arrayOfString[i]);
      i += 1;
    }
  }
  
  private void f()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) || (this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp() == null)) {}
    for (;;)
    {
      return;
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 4).getString(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_" + "cmgame_sp_dev_game_list", "");
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "initDevGameList get gameList:", localObject });
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        continue;
      }
      if (((String)localObject).equals("1"))
      {
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1));
        return;
      }
      try
      {
        localObject = new JSONArray((String)localObject);
        while (i < ((JSONArray)localObject).length())
        {
          this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(((JSONArray)localObject).getInt(i)));
          i += 1;
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameManager", 1, "initDevGameList e:", localException);
      }
    }
  }
  
  /* Error */
  public amlz a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 377	amrt:c	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_2
    //   16: areturn
    //   17: aload_0
    //   18: getfield 379	amrt:jdField_a_of_type_Amlz	Lamlz;
    //   21: ifnonnull +29 -> 50
    //   24: aload_0
    //   25: new 381	amlz
    //   28: dup
    //   29: invokespecial 382	amlz:<init>	()V
    //   32: putfield 379	amrt:jdField_a_of_type_Amlz	Lamlz;
    //   35: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   38: ifeq +12 -> 50
    //   41: ldc 70
    //   43: iconst_2
    //   44: ldc_w 384
    //   47: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: getfield 379	amrt:jdField_a_of_type_Amlz	Lamlz;
    //   54: astore_2
    //   55: goto -42 -> 13
    //   58: astore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	amrt
    //   6	2	1	bool	boolean
    //   12	43	2	localamlz	amlz
    //   58	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	58	finally
    //   17	50	58	finally
    //   50	55	58	finally
  }
  
  public amrk a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      amrk localamrk = (amrk)localIterator.next();
      if ((localamrk != null) && (!ampj.a(localamrk.a())) && (!ampj.b(localamrk.a()))) {
        return localamrk;
      }
    }
    return null;
  }
  
  public amrk a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      amrk localamrk = (amrk)localIterator.next();
      if ((localamrk != null) && (paramInt == localamrk.a())) {
        return localamrk;
      }
    }
    return null;
  }
  
  public amrk a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameManager", 2, "[getLauncher], invalid gameId.");
        }
        localamrk = null;
        return localamrk;
      }
      finally {}
      amrk localamrk = new amrk(paramInt1);
      localamrk.d = paramInt2;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, localamrk);
      QLog.i("cmgame_process.CmGameManager", 1, "add a new launcher, gameId:" + paramInt1 + ",total size:" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
  }
  
  /* Error */
  public amrk a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	amrt:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 388	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore 6
    //   11: aload 6
    //   13: invokeinterface 290 1 0
    //   18: ifeq +49 -> 67
    //   21: aload 6
    //   23: invokeinterface 294 1 0
    //   28: checkcast 390	amrk
    //   31: astore 5
    //   33: aload 5
    //   35: ifnull -24 -> 11
    //   38: aload 5
    //   40: invokevirtual 423	amrk:a	()Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   43: astore 7
    //   45: aload 7
    //   47: ifnull -36 -> 11
    //   50: aload 7
    //   52: invokevirtual 429	com/tencent/mobileqq/apollo/ApolloSurfaceView:getLuaState	()J
    //   55: lstore_3
    //   56: lload_3
    //   57: lload_1
    //   58: lcmp
    //   59: ifne -48 -> 11
    //   62: aload_0
    //   63: monitorexit
    //   64: aload 5
    //   66: areturn
    //   67: aconst_null
    //   68: astore 5
    //   70: goto -8 -> 62
    //   73: astore 5
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 5
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	amrt
    //   0	80	1	paramLong	long
    //   55	2	3	l	long
    //   31	38	5	localamrk	amrk
    //   73	5	5	localObject	Object
    //   9	13	6	localIterator	Iterator
    //   43	8	7	localApolloSurfaceView	com.tencent.mobileqq.apollo.ApolloSurfaceView
    // Exception table:
    //   from	to	target	type
    //   2	11	73	finally
    //   11	33	73	finally
    //   38	45	73	finally
    //   50	56	73	finally
  }
  
  public ApolloCmdChannel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel;
  }
  
  public String a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) != null) {
      return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    }
    return "^(apollo_game_[_a-zA-Z0-9.]*|apollo_aio_game[_a-zA-Z0-9.]*)";
  }
  
  public List<amrw> a()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    Collections.sort(localArrayList, new amru(this));
    return localArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameManager", 1, "checkValidGameTask");
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      amrw localamrw = (amrw)localIterator.next();
      if (localamrw != null) {
        if (localamrw.jdField_a_of_type_JavaLangRefWeakReference == null)
        {
          localArrayList.add(localamrw);
          QLog.e("cmgame_process.CmGameManager", 1, "checkValidGameTask remove invalid 1 gameTask:" + localamrw.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
        }
        else
        {
          if (localamrw.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
            localArrayList.add(localamrw);
          }
          QLog.e("cmgame_process.CmGameManager", 1, "checkValidGameTask remove invalid 2 gameTask:" + localamrw.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.removeAll(localArrayList);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "ssoCmdRule gameId: " + paramInt + ", rule: ", paramString });
    }
    if ((paramInt > 0) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramString);
    }
  }
  
  public void a(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    a();
    QLog.d("cmgame_process.CmGameManager", 1, "onGameActivityCreate activity" + paramActivity + " mRunningTaskList.size():" + this.jdField_a_of_type_JavaUtilList.size());
    if ((paramStartCheckParam != null) && (paramActivity != null)) {
      if (paramStartCheckParam.gameId != 3112) {}
    }
    label254:
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      amrw localamrw;
      while (localIterator.hasNext())
      {
        localamrw = (amrw)localIterator.next();
        if ((localamrw != null) && (localamrw.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId == paramStartCheckParam.gameId))
        {
          localamrw.jdField_a_of_type_Int = 1;
          localamrw.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
          QLog.d("cmgame_process.CmGameManager", 1, "onGameActivityCreate foundTask" + localamrw);
        }
      }
      for (;;)
      {
        if (localamrw != null) {
          break label254;
        }
        if (paramStartCheckParam != null) {
          QLog.e("cmgame_process.CmGameManager", 1, new Object[] { "onGameActivityCreate but no found gameId:", Integer.valueOf(paramStartCheckParam.gameId) });
        }
        if (paramActivity == null) {
          break;
        }
        localamrw = new amrw();
        localamrw.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
        localamrw.jdField_a_of_type_JavaLangString = paramActivity.getClass().getSimpleName();
        localamrw.jdField_a_of_type_Int = 1;
        localamrw.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
        this.jdField_a_of_type_JavaUtilList.add(localamrw);
        return;
        localamrw = null;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (QLog.isColorLevel())) {
        QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "isShowGameExitGuide GameExitCurrentCount:", Integer.valueOf(this.jdField_a_of_type_Int), ",mGameExitLimitCount:", Integer.valueOf(this.jdField_b_of_type_Int), ",mShouldShowGameGuide:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
      return i & this.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(1))) || (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)));
  }
  
  /* Error */
  public amrk b(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	amrt:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 388	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore 4
    //   11: aload 4
    //   13: invokeinterface 290 1 0
    //   18: ifeq +91 -> 109
    //   21: aload 4
    //   23: invokeinterface 294 1 0
    //   28: checkcast 390	amrk
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull -22 -> 11
    //   36: iload_1
    //   37: aload_3
    //   38: invokevirtual 392	amrk:a	()I
    //   41: if_icmpne -30 -> 11
    //   44: iload_2
    //   45: aload_3
    //   46: getfield 406	amrk:d	I
    //   49: if_icmpne -38 -> 11
    //   52: aload_0
    //   53: getfield 47	amrt:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   56: aload_3
    //   57: invokevirtual 525	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   60: ifeq -49 -> 11
    //   63: ldc 70
    //   65: iconst_1
    //   66: new 168	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 527
    //   76: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload_1
    //   80: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: ldc_w 416
    //   86: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: getfield 47	amrt:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   93: invokevirtual 419	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   96: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 78	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_3
    //   108: areturn
    //   109: aconst_null
    //   110: astore_3
    //   111: goto -6 -> 105
    //   114: astore_3
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_3
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	amrt
    //   0	119	1	paramInt1	int
    //   0	119	2	paramInt2	int
    //   31	80	3	localamrk	amrk
    //   114	4	3	localObject	Object
    //   9	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	11	114	finally
    //   11	32	114	finally
    //   36	105	114	finally
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int += 1;
    ThreadManager.excute(new CmGameManager.3(this), 64, null, true);
  }
  
  public void b(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    QLog.d("cmgame_process.CmGameManager", 1, "onGameActivityResume activity" + paramActivity + " mRunningTaskList.size():" + this.jdField_a_of_type_JavaUtilList.size());
    if ((paramStartCheckParam != null) && (paramActivity != null)) {
      if (paramStartCheckParam.gameId != 3112) {}
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      amrw localamrw;
      while (localIterator.hasNext())
      {
        localamrw = (amrw)localIterator.next();
        if ((localamrw != null) && (localamrw.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId == paramStartCheckParam.gameId))
        {
          localamrw.jdField_a_of_type_Int = 2;
          localamrw.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
          localamrw.jdField_a_of_type_Long = System.currentTimeMillis();
          QLog.d("cmgame_process.CmGameManager", 1, "onGameActivityResume foundTask" + localamrw);
        }
      }
      for (paramActivity = localamrw; (paramActivity == null) && (paramStartCheckParam != null); paramActivity = null)
      {
        QLog.e("cmgame_process.CmGameManager", 1, new Object[] { "onGameActivityResume but no found gameId:", Integer.valueOf(paramStartCheckParam.gameId) });
        return;
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam != null) && (paramActivity != null))
    {
      if (paramStartCheckParam.gameId == 3112) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        paramActivity = (amrw)localIterator.next();
        if ((paramActivity != null) && (paramActivity.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId == paramStartCheckParam.gameId))
        {
          paramActivity.jdField_a_of_type_Int = 5;
          paramActivity.jdField_a_of_type_JavaLangRefWeakReference = null;
        }
      }
    }
    for (;;)
    {
      if (paramActivity == null)
      {
        if (paramStartCheckParam == null) {
          break;
        }
        QLog.e("cmgame_process.CmGameManager", 1, new Object[] { "onGameActivityDestroy but no found gameId:", paramStartCheckParam.gameId + " mRunningTaskList.size():" + this.jdField_a_of_type_JavaUtilList.size() });
        return;
      }
      this.jdField_a_of_type_JavaUtilList.remove(paramActivity);
      QLog.i("cmgame_process.CmGameManager", 1, "onGameActivityDestroy remove foundTask:" + paramActivity + " mRunningTaskList.size():" + this.jdField_a_of_type_JavaUtilList.size());
      return;
      paramActivity = null;
    }
  }
  
  public void onDestroy()
  {
    QLog.i("cmgame_process.CmGameManager", 1, "[CmGameManager] destroyed.");
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      amnk.a();
      if (this.jdField_a_of_type_Amlz != null) {
        this.jdField_a_of_type_Amlz.a();
      }
      this.c = false;
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameManager", 1, "[doDestroy] exception=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrt
 * JD-Core Version:    0.7.0.1
 */