import android.annotation.TargetApi;
import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class basv
  extends AsyncTask<Void, Void, Void>
{
  private static Comparator<baso> jdField_a_of_type_JavaUtilComparator = new basy();
  private static final ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(0, 3, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new basw());
  private static Comparator<baso> jdField_b_of_type_JavaUtilComparator = new basz();
  private final int jdField_a_of_type_Int = 300;
  private bata jdField_a_of_type_Bata;
  private String jdField_a_of_type_JavaLangString;
  private List<? extends baso> jdField_a_of_type_JavaUtilList;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private List<Future<List<baso>>> jdField_b_of_type_JavaUtilList;
  private List<baso> c;
  
  public basv(String paramString1, String paramString2, List<? extends baso> paramList, bata parambata)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Bata = parambata;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(20);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
  }
  
  private void a(List<baso> paramList, String paramString)
  {
    if (paramList.size() > 20) {}
    for (int i = 20;; i = paramList.size())
    {
      int j = 0;
      while (j < i)
      {
        basn localbasn = (basn)paramList.get(j);
        if (QLog.isColorLevel()) {
          QLog.d("SearchTask", 2, "printSearchResultData " + paramString + "matchDegree : " + localbasn.c() + " message time : " + localbasn.Y);
        }
        j += 1;
      }
    }
  }
  
  protected Void a(Void... paramVarArgs)
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchTask", 2, "Start doInBackground , keyword = " + this.jdField_a_of_type_JavaLangString);
      }
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int m = k / 300;
      int i = 0;
      int n;
      if (i < m + 1)
      {
        n = i * 300;
        if (n + 300 <= k) {
          break label168;
        }
        j = k;
        label91:
        if ((!isCancelled()) && (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
          break label178;
        }
      }
      for (;;)
      {
        try
        {
          this.c.clear();
          l1 = System.currentTimeMillis();
          i = 0;
          if ((i >= this.jdField_b_of_type_JavaUtilList.size()) || (isCancelled()))
          {
            this.jdField_b_of_type_JavaUtilList.clear();
            boolean bool = isCancelled();
            if (!bool) {
              continue;
            }
            return null;
            label168:
            j = n + 300;
            break label91;
            label178:
            paramVarArgs = this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new basx(this, n, j));
            this.jdField_b_of_type_JavaUtilList.add(paramVarArgs);
            i += 1;
            break;
          }
          paramVarArgs = (List)((Future)this.jdField_b_of_type_JavaUtilList.get(i)).get();
          if (i == 0)
          {
            this.c.addAll(paramVarArgs);
            paramVarArgs.clear();
            i += 1;
            continue;
          }
          localIterator = paramVarArgs.iterator();
        }
        catch (InterruptedException paramVarArgs)
        {
          Iterator localIterator;
          baso localbaso;
          paramVarArgs.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SearchTask", 2, "InterruptedException happens, keyword = " + this.jdField_a_of_type_JavaLangString + " : ");
          this.jdField_a_of_type_Boolean = false;
          return null;
          if (((baso)this.c.get(j)).c() >= localbaso.c()) {
            continue;
          }
          this.c.set(j, localbaso);
          continue;
        }
        catch (ExecutionException paramVarArgs)
        {
          long l1;
          paramVarArgs.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SearchTask", 2, "InterruptedException happens, keyword = " + this.jdField_a_of_type_JavaLangString + " : ");
          continue;
          a(this.c);
          l2 = System.currentTimeMillis();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SearchTask", 2, "SearchTask ======= doInBackground time = " + (l2 - l1) + " , keyword = " + this.jdField_a_of_type_JavaLangString);
          continue;
        }
        if (localIterator.hasNext())
        {
          localbaso = (baso)localIterator.next();
          if (!isCancelled())
          {
            j = this.c.indexOf(localbaso);
            if (-1 != j) {
              continue;
            }
            this.c.add(localbaso);
          }
        }
      }
    }
    for (;;)
    {
      long l2;
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("SearchTask", 2, "doInBackground:: inputSet is null.");
      }
    }
  }
  
  @TargetApi(11)
  public void a()
  {
    executeOnExecutor(jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, new Void[0]);
    if (QLog.isColorLevel()) {
      QLog.d("SearchTask", 2, "Start execute , keyword = " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void a(Void paramVoid)
  {
    if (isCancelled())
    {
      this.c.clear();
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
      if (QLog.isColorLevel()) {
        QLog.d("SearchTask", 2, "onPostExecute:: isCancelled.");
      }
    }
    while (this.jdField_a_of_type_Bata == null) {
      return;
    }
    int i = 1;
    if (this.jdField_a_of_type_Boolean) {
      i = 0;
    }
    this.jdField_a_of_type_Bata.a(i, this.c);
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
  }
  
  protected void a(List<baso> paramList)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchTask", 2, "start sortResultSet(), keyword = " + this.jdField_a_of_type_JavaLangString);
    }
    Collections.sort(paramList, jdField_a_of_type_JavaUtilComparator);
    int i = Math.min(paramList.size(), 30);
    List localList = paramList.subList(0, i);
    Collections.sort(localList, jdField_b_of_type_JavaUtilComparator);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(localList);
    localArrayList.addAll(paramList.subList(i, paramList.size()));
    a(paramList, "after sort ");
    if (QLog.isColorLevel()) {
      QLog.d("SearchTask", 2, "sortResultSet() time = " + (System.currentTimeMillis() - l) + " , keyword = " + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basv
 * JD-Core Version:    0.7.0.1
 */