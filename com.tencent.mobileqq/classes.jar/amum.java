import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.script.SpriteTaskHandler.1;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import mqq.os.MqqHandler;

public class amum
  implements amup, amut
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private amug jdField_a_of_type_Amug;
  private amuv jdField_a_of_type_Amuv;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SpriteTaskHandler.1(this);
  private Map<Integer, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private BlockingDeque<SpriteTaskParam> jdField_a_of_type_JavaUtilConcurrentBlockingDeque;
  private CopyOnWriteArrayList<SpriteTaskParam> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private int jdField_b_of_type_Int;
  private CopyOnWriteArrayList<amuu> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public amum(amug paramamug, amuv paramamuv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "SpriteTaskHandler constructor.");
    }
    this.jdField_a_of_type_Amug = paramamug;
    this.jdField_a_of_type_Amuv = paramamuv;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque = new LinkedBlockingDeque(50);
    jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public SpriteTaskParam a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return null;
    }
    return (SpriteTaskParam)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0);
  }
  
  public SpriteTaskParam a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if (localSpriteTaskParam.jdField_a_of_type_Int == paramInt) {
        return localSpriteTaskParam;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[findTask], task NOT found in queue");
    }
    return null;
  }
  
  public SpriteTaskParam a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if (localSpriteTaskParam.jdField_a_of_type_Long == paramLong) {
        return localSpriteTaskParam;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[findTaskByTaskId], task NOT found in queue");
    }
    return null;
  }
  
  public SpriteTaskParam a(long paramLong, int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      localObject = null;
    }
    SpriteTaskParam localSpriteTaskParam;
    do
    {
      return localObject;
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localSpriteTaskParam = (SpriteTaskParam)((Iterator)localObject).next();
      } while ((localSpriteTaskParam == null) || (localSpriteTaskParam.jdField_a_of_type_Long != paramLong) || (paramInt != 2));
      localObject = localSpriteTaskParam;
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[stopTask], msgId:", Long.valueOf(paramLong), ",taskId:", Integer.valueOf(localSpriteTaskParam.jdField_a_of_type_Int) });
    return localSpriteTaskParam;
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[clear]");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Amug != null)) {
      VipUtils.a(this.jdField_a_of_type_Amug.a(), "cmshow", "Apollo", "play_times", ApolloUtil.b(this.jdField_a_of_type_Amug.jdField_a_of_type_Int), 0, new String[] { Integer.toString(this.jdField_b_of_type_Int), this.jdField_a_of_type_Amug.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.clear();
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "[removeTask], fail. NO task. taskId:" + paramInt);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[removeTask], total task num:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramInt) });
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
        if (localSpriteTaskParam.jdField_a_of_type_Int == paramInt)
        {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localSpriteTaskParam);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[removeTask], task NOT found in queue");
  }
  
  public void a(amuu paramamuu)
  {
    if ((paramamuu != null) && (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null))
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramamuu)) {
        QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "[addActionCallback], repeat callback.");
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramamuu);
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_Amug == null)) {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "[addTask], fail. null param");
    }
    do
    {
      do
      {
        return;
        if ((1 == this.jdField_a_of_type_Amug.d) && (paramSpriteTaskParam.g != 1))
        {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
          if ((this.jdField_a_of_type_Amuv instanceof SpriteUIHandler)) {
            ((SpriteUIHandler)this.jdField_a_of_type_Amuv).a(false, true, null);
          }
          localObject1 = this.jdField_a_of_type_Amug.a();
          localObject2 = Integer.toString(ApolloUtil.b(this.jdField_a_of_type_Amug.jdField_a_of_type_Int));
          if (paramSpriteTaskParam.g == 2) {}
          for (paramSpriteTaskParam = "1";; paramSpriteTaskParam = "2")
          {
            VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { localObject2, paramSpriteTaskParam });
            return;
          }
        }
        if ((this.jdField_a_of_type_Amug.h()) || (!this.jdField_a_of_type_Amug.g()) || (this.jdField_a_of_type_Amug.c())) {
          break;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
      } while (!(this.jdField_a_of_type_Amuv instanceof SpriteUIHandler));
      ((SpriteUIHandler)this.jdField_a_of_type_Amuv).a(false, false, "none_apollo_play_action");
      return;
      if (!a(paramSpriteTaskParam)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[addTask], same task. discard it.");
    return;
    Object localObject1 = a(paramSpriteTaskParam.jdField_a_of_type_Long, paramSpriteTaskParam.g);
    if (localObject1 == null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.offerLast(paramSpriteTaskParam);
      long l = System.currentTimeMillis();
      if ((l - this.jdField_a_of_type_Long > 500L) || (!a()))
      {
        paramSpriteTaskParam = (SpriteTaskParam)this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.pollLast();
        this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.clear();
        this.jdField_a_of_type_Long = l;
        if (paramSpriteTaskParam == null) {
          QLog.e("cmshow_scripted_SpriteTaskHandler", 1, "[addTask] poll task from deque failed");
        }
      }
      else
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
        return;
      }
      paramSpriteTaskParam.jdField_b_of_type_Int = 1;
      i = jdField_a_of_type_Int + 1;
      jdField_a_of_type_Int = i;
      paramSpriteTaskParam.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[addTask], size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramSpriteTaskParam.jdField_a_of_type_Int) });
      }
      b((SpriteTaskParam)localObject1);
      return;
    }
    ((SpriteTaskParam)localObject1).jdField_b_of_type_Int = 5;
    Object localObject2 = this.jdField_a_of_type_Amug.a();
    int i = ApolloUtil.b(this.jdField_a_of_type_Amug.jdField_a_of_type_Int);
    String str = Integer.toString(paramSpriteTaskParam.f);
    if (paramSpriteTaskParam.jdField_a_of_type_Boolean) {}
    for (paramSpriteTaskParam = "0";; paramSpriteTaskParam = "1")
    {
      VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "msg_paly_stop", i, 0, new String[] { str, paramSpriteTaskParam });
      break;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[onStartAction], taskId:", Integer.valueOf(paramInt) });
    }
    paramString = a(paramInt);
    if (paramString == null) {
      return;
    }
    paramString.jdField_b_of_type_Int = 3;
    if (this.jdField_a_of_type_Amuv != null) {
      this.jdField_a_of_type_Amuv.a(paramString, paramString.jdField_a_of_type_Long);
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      amuu localamuu = (amuu)localIterator.next();
      if (localamuu != null) {
        localamuu.a(paramString, paramString.jdField_a_of_type_Long);
      }
    }
    this.jdField_b_of_type_Int += 1;
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[onCompleteAction], taskId:", Integer.valueOf(paramInt1), ",type:", Integer.valueOf(paramInt2) });
    }
    paramString = a(paramInt1);
    if (paramString == null) {
      return;
    }
    if (this.jdField_a_of_type_Amuv != null) {
      this.jdField_a_of_type_Amuv.a(paramString, paramString.jdField_a_of_type_Long, paramInt2);
    }
    paramString.jdField_b_of_type_Int = 6;
    Object localObject = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      amuu localamuu = (amuu)((Iterator)localObject).next();
      if (localamuu != null) {
        localamuu.a(paramString, paramString.jdField_a_of_type_Long, paramInt2);
      }
    }
    a(paramInt1);
    long l = ((Long)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1))).longValue();
    if ((l > 0L) && (this.jdField_a_of_type_Amug != null))
    {
      l = System.currentTimeMillis() - l;
      if (!ApolloPanel.jdField_a_of_type_Boolean) {
        break label328;
      }
      paramInt2 = 1;
      label189:
      localObject = this.jdField_a_of_type_Amug.a();
      if (paramString.c != 1) {
        break label333;
      }
      VipUtils.a(this.jdField_a_of_type_Amug.a(), "cmshow", "Apollo", "emotion_play_time", paramInt2, 0, new String[] { String.valueOf(amhd.a((QQAppInterface)localObject)), "", "", String.valueOf(l) });
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt1));
      if ((!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) || (this.jdField_a_of_type_Amug.h()) || (!this.jdField_a_of_type_Amug.g()) || (!(this.jdField_a_of_type_Amuv instanceof SpriteUIHandler))) {
        break;
      }
      ((SpriteUIHandler)this.jdField_a_of_type_Amuv).a(true, "none_apollo_play_action");
      return;
      label328:
      paramInt2 = 0;
      break label189;
      label333:
      if (paramString.l == 1)
      {
        VipUtils.a(this.jdField_a_of_type_Amug.a(), "cmshow", "Apollo", "quickresponse_play_time", paramInt2, 0, new String[] { "", "", "", String.valueOf(l) });
      }
      else if (paramString.l == 2)
      {
        VipUtils.a(this.jdField_a_of_type_Amug.a(), "cmshow", "Apollo", "groupplus_play_time", paramInt2, 0, new String[] { "", "", "", String.valueOf(l) });
      }
      else if (localObject != null)
      {
        int i = ((ancd)((QQAppInterface)localObject).getManager(155)).a(paramString.f);
        VipUtils.a(this.jdField_a_of_type_Amug.a(), "cmshow", "Apollo", "action_play_time", paramInt2, 0, new String[] { "655_" + i, "", "", String.valueOf(l) });
      }
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if ((localSpriteTaskParam != null) && (localSpriteTaskParam.jdField_b_of_type_Int == 3)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {}
    SpriteTaskParam localSpriteTaskParam;
    do
    {
      return false;
      localSpriteTaskParam = a(paramLong);
    } while ((localSpriteTaskParam == null) || (localSpriteTaskParam.jdField_b_of_type_Int != 3));
    return true;
  }
  
  public boolean a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return false;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if ((localSpriteTaskParam != null) && (localSpriteTaskParam.jdField_a_of_type_Long == paramSpriteTaskParam.jdField_a_of_type_Long) && (localSpriteTaskParam.g != 2) && (localSpriteTaskParam.g != 3)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((this.jdField_a_of_type_Amug == null) || (!this.jdField_a_of_type_Amug.c()))
    {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "surfaceview is NOT ready.");
      return false;
    }
    SpriteTaskParam localSpriteTaskParam = paramSpriteTaskParam;
    if (paramSpriteTaskParam == null) {
      localSpriteTaskParam = a();
    }
    if ((localSpriteTaskParam == null) || (localSpriteTaskParam.jdField_b_of_type_Int == 2)) {
      return false;
    }
    if ((!this.jdField_a_of_type_Amug.h()) && (this.jdField_a_of_type_Amug.g()) && ((this.jdField_a_of_type_Amuv instanceof SpriteUIHandler))) {
      ((SpriteUIHandler)this.jdField_a_of_type_Amuv).a(false, "none_apollo_play_action");
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[execSpriteTask], taskId:", Integer.valueOf(localSpriteTaskParam.jdField_a_of_type_Int), ",actionId:", Integer.valueOf(localSpriteTaskParam.f) });
    }
    if (localSpriteTaskParam.jdField_a_of_type_Amuq != null) {
      localSpriteTaskParam.jdField_a_of_type_Amuq.b(localSpriteTaskParam);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amum
 * JD-Core Version:    0.7.0.1
 */