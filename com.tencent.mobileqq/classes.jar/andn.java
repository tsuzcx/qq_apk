import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class andn
  implements ancl, ancp
{
  private static int jdField_a_of_type_Int;
  public anda a;
  private andi jdField_a_of_type_Andi;
  private CopyOnWriteArrayList<SpriteTaskParam> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private int jdField_b_of_type_Int;
  private CopyOnWriteArrayList<ancq> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public andn(andi paramandi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, "SpriteTaskHandler constructor.");
    }
    this.jdField_a_of_type_Andi = paramandi;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
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
      QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, "[findTask], task NOT found in queue");
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, "[clear]");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Andi != null)) {
      VipUtils.a(null, "cmshow", "Apollo", "play_times", ApolloUtil.b(this.jdField_a_of_type_Andi.jdField_a_of_type_Int), 0, new String[] { Integer.toString(this.jdField_b_of_type_Int), this.jdField_a_of_type_Andi.jdField_a_of_type_JavaLangString });
    }
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      QLog.w("CmShow_SpriteDrawerInfoTaskHandler", 1, "[removeTask], fail. NO task. taskId:" + paramInt);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[removeTask], total task num:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramInt) });
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
    QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, "[removeTask], task NOT found in queue");
  }
  
  public void a(anda paramanda)
  {
    this.jdField_a_of_type_Anda = paramanda;
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_Andi == null))
    {
      QLog.w("CmShow_SpriteDrawerInfoTaskHandler", 1, "[addTask], fail. null param");
      return;
    }
    paramSpriteTaskParam.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[addTask], size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramSpriteTaskParam.jdField_a_of_type_Int) });
    }
    a(null);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[onStartAction], taskId:", Integer.valueOf(paramInt) });
    }
    SpriteTaskParam localSpriteTaskParam = a(paramInt);
    if (localSpriteTaskParam == null) {
      return;
    }
    localSpriteTaskParam.jdField_b_of_type_Int = 3;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      ancq localancq = (ancq)localIterator.next();
      if (localancq != null) {
        localancq.a(localSpriteTaskParam, localSpriteTaskParam.jdField_a_of_type_Long);
      }
    }
    if ((this.jdField_a_of_type_Anda != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localSpriteTaskParam.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Anda.a(localSpriteTaskParam.jdField_a_of_type_JavaLangString, localSpriteTaskParam.f, localSpriteTaskParam.jdField_a_of_type_Int);
    }
    this.jdField_b_of_type_Int += 1;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[onCompleteAction], taskId:", Integer.valueOf(paramInt1), ",type:", paramInt2 + " uin:" + paramString });
    }
    SpriteTaskParam localSpriteTaskParam = a(paramInt1);
    if (localSpriteTaskParam == null) {}
    do
    {
      do
      {
        return;
        localSpriteTaskParam.jdField_b_of_type_Int = 6;
        Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator.hasNext())
        {
          ancq localancq = (ancq)localIterator.next();
          if (localancq != null) {
            localancq.a(localSpriteTaskParam, localSpriteTaskParam.jdField_a_of_type_Long, paramInt2);
          }
        }
      } while ((this.jdField_a_of_type_Anda == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localSpriteTaskParam.jdField_a_of_type_JavaLangString)));
      this.jdField_a_of_type_Anda.a(localSpriteTaskParam.jdField_a_of_type_JavaLangString, localSpriteTaskParam.f, localSpriteTaskParam.jdField_a_of_type_Int, localSpriteTaskParam.m, localSpriteTaskParam.jdField_a_of_type_AndroidOsBundle);
    } while (localSpriteTaskParam.n == 1);
    a(paramInt1);
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
  
  public boolean a(SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Andi == null) || (!this.jdField_a_of_type_Andi.a()))
    {
      QLog.w("CmShow_SpriteDrawerInfoTaskHandler", 1, "surfaceview is NOT ready.");
      bool = false;
    }
    SpriteTaskParam localSpriteTaskParam;
    do
    {
      return bool;
      localSpriteTaskParam = paramSpriteTaskParam;
      if (paramSpriteTaskParam == null) {
        localSpriteTaskParam = a();
      }
      if ((localSpriteTaskParam == null) || (localSpriteTaskParam.jdField_b_of_type_Int == 2)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[execSpriteTask], taskId:", Integer.valueOf(localSpriteTaskParam.jdField_a_of_type_Int), ",actionId:", Integer.valueOf(localSpriteTaskParam.f) });
      }
    } while (localSpriteTaskParam.jdField_a_of_type_Ancm == null);
    localSpriteTaskParam.jdField_a_of_type_Ancm.b(localSpriteTaskParam);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andn
 * JD-Core Version:    0.7.0.1
 */