import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.support.annotation.Nullable;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class avyr
  implements avxo, avxu
{
  private avxn jdField_a_of_type_Avxn = new avys(this);
  private avyu jdField_a_of_type_Avyu;
  private avyv jdField_a_of_type_Avyv = new avyv();
  private Comparator<avxq> jdField_a_of_type_JavaUtilComparator = new avyt(this);
  private final List<avxq> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((avxq)localIterator.next()).b();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public int a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      return i;
    }
  }
  
  public int a(List<avxq> paramList)
  {
    if (paramList.size() > 0) {
      veg.c("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size " + paramList.size() + ", range [" + ((avxq)paramList.get(0)).a() + " - " + ((avxq)paramList.get(paramList.size() - 1)).a() + "], cycle " + ((avxq)paramList.get(0)).b() + ", current size " + this.jdField_a_of_type_JavaUtilList.size());
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
        int j = this.jdField_a_of_type_JavaUtilList.size();
        if (j <= 5) {
          break;
        }
        i = 1;
        if ((i != 0) && (this.jdField_a_of_type_Avyu != null)) {
          this.jdField_a_of_type_Avyu.a();
        }
        return j;
        veg.d("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size 0");
      }
      int i = 0;
    }
  }
  
  @Nullable
  public avxq a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        avxq localavxq = (avxq)this.jdField_a_of_type_JavaUtilList.remove(0);
        return localavxq;
      }
      return null;
    }
  }
  
  public void a()
  {
    veg.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "stopDecode", new Object[0]);
    this.jdField_a_of_type_Avyv.a();
    veg.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of stopDecode");
    f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Avyv.a(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Avyv.a(paramLong1, paramLong2);
  }
  
  public void a(avxk paramavxk, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, avxn paramavxn)
  {
    throw new AndroidRuntimeException("please use startDecode(FlowDecodeConfig, FlowListener) instead");
  }
  
  public void a(avxt paramavxt, avyu paramavyu)
  {
    this.jdField_a_of_type_Avyu = paramavyu;
    veg.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "startDecode : decodeConfig = %s", new Object[] { paramavxt });
    this.jdField_a_of_type_Avyv.a(paramavxt, this.jdField_a_of_type_Avxn, this);
  }
  
  @Nullable
  public avxq b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        avxq localavxq = (avxq)this.jdField_a_of_type_JavaUtilList.get(0);
        return localavxq;
      }
      return null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Avyv.b();
  }
  
  @Nullable
  public avxq c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() >= 2)
      {
        avxq localavxq = (avxq)this.jdField_a_of_type_JavaUtilList.get(1);
        return localavxq;
      }
      return null;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Avyv.c();
  }
  
  public void d()
  {
    veg.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of play range change");
    f();
  }
  
  public void e()
  {
    veg.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of direction change");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avyr
 * JD-Core Version:    0.7.0.1
 */