import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.debug.CmGameDebugManager.1;
import com.tencent.mobileqq.apollo.debug.CmGameDebugManager.2;
import com.tencent.mobileqq.apollo.debug.page.CmGameDebugBaseFragment;
import com.tencent.mobileqq.apollo.debug.page.CmGameDebugLogFragment;
import com.tencent.mobileqq.apollo.debug.page.CmGameDebugToolFragment;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import mqq.os.MqqHandler;

public class amxt
{
  public static final String[] a;
  public static final String[] b;
  public static final String[] c;
  private WeakReference<amxu> jdField_a_of_type_JavaLangRefWeakReference;
  private BlockingQueue<amyc> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new ArrayBlockingQueue(100);
  private boolean jdField_a_of_type_Boolean;
  private BlockingQueue<amyc> b;
  private BlockingQueue<amyc> c;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "Log", "Tool" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "All", "Log", "Info", "Error", "Game" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "#000000", "#000000", "#6a59d6", "#FF0000", "#556B2F" };
  }
  
  public amxt()
  {
    this.jdField_b_of_type_JavaUtilConcurrentBlockingQueue = new ArrayBlockingQueue(50);
    this.jdField_c_of_type_JavaUtilConcurrentBlockingQueue = new ArrayBlockingQueue(50);
  }
  
  public static CmGameDebugBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new CmGameDebugLogFragment();
    case 0: 
      return new CmGameDebugLogFragment();
    }
    return new CmGameDebugToolFragment();
  }
  
  private void a(amyc paramamyc)
  {
    if (paramamyc == null) {
      return;
    }
    switch (paramamyc.a)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.offer(paramamyc);
      if (this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.size() == 100) {
        this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.poll();
      }
      ThreadManager.getUIHandler().post(new CmGameDebugManager.1(this, paramamyc));
      return;
      this.jdField_c_of_type_JavaUtilConcurrentBlockingQueue.offer(paramamyc);
      if (this.jdField_c_of_type_JavaUtilConcurrentBlockingQueue.size() == 50)
      {
        this.jdField_c_of_type_JavaUtilConcurrentBlockingQueue.poll();
        continue;
        this.jdField_b_of_type_JavaUtilConcurrentBlockingQueue.offer(paramamyc);
        if (this.jdField_b_of_type_JavaUtilConcurrentBlockingQueue.size() == 50) {
          this.jdField_b_of_type_JavaUtilConcurrentBlockingQueue.poll();
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    andn localandn = anbd.a();
    if (localandn != null) {
      return localandn.a(paramInt);
    }
    return false;
  }
  
  public static boolean a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramStartCheckParam != null)
    {
      bool1 = bool2;
      if (paramStartCheckParam.isWhiteUsr)
      {
        bool1 = bool2;
        if (a(paramStartCheckParam.gameId)) {
          bool1 = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0).getBoolean("game_debug_tool_switch", true);
        }
      }
    }
    return bool1;
  }
  
  private List<amyc> b(int paramInt)
  {
    Object localObject = Arrays.asList(this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.toArray(new amyc[0]));
    if (paramInt == 0) {
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      amyc localamyc = (amyc)((Iterator)localObject).next();
      if (localamyc.a == paramInt) {
        localArrayList.add(localamyc);
      }
    }
    return localArrayList;
  }
  
  public List<amyc> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    switch (paramInt)
    {
    default: 
      return localArrayList;
    case 0: 
      return Arrays.asList(this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.toArray(new amyc[0]));
    case 1: 
      return b(1);
    case 2: 
      return b(2);
    case 3: 
      return Arrays.asList(this.jdField_b_of_type_JavaUtilConcurrentBlockingQueue.toArray(new amyc[0]));
    }
    return Arrays.asList(this.jdField_c_of_type_JavaUtilConcurrentBlockingQueue.toArray(new amyc[0]));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    a(false);
  }
  
  public void a(amxu paramamxu)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramamxu);
  }
  
  public void a(String paramString, int paramInt, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    localStringBuilder.append(paramString).append(" | ");
    int i = 0;
    while (i < paramVarArgs.length)
    {
      paramString = paramVarArgs[i];
      if (paramString != null) {
        localStringBuilder.append(paramString.toString());
      }
      i += 1;
    }
    a(new amyc(localStringBuilder.toString(), paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.clear();
    this.jdField_c_of_type_JavaUtilConcurrentBlockingQueue.clear();
    this.jdField_b_of_type_JavaUtilConcurrentBlockingQueue.clear();
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      ThreadManager.getUIHandler().post(new CmGameDebugManager.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxt
 * JD-Core Version:    0.7.0.1
 */