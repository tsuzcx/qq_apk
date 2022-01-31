import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.support.annotation.Nullable;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class avyt
  implements avxq, avxw
{
  private avxp jdField_a_of_type_Avxp = new avyu(this);
  private avyw jdField_a_of_type_Avyw;
  private avyx jdField_a_of_type_Avyx = new avyx();
  private Comparator<avxs> jdField_a_of_type_JavaUtilComparator = new avyv(this);
  private final List<avxs> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((avxs)localIterator.next()).b();
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
  
  public int a(List<avxs> paramList)
  {
    if (paramList.size() > 0) {
      ved.c("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size " + paramList.size() + ", range [" + ((avxs)paramList.get(0)).a() + " - " + ((avxs)paramList.get(paramList.size() - 1)).a() + "], cycle " + ((avxs)paramList.get(0)).b() + ", current size " + this.jdField_a_of_type_JavaUtilList.size());
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
        if ((i != 0) && (this.jdField_a_of_type_Avyw != null)) {
          this.jdField_a_of_type_Avyw.a();
        }
        return j;
        ved.d("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size 0");
      }
      int i = 0;
    }
  }
  
  @Nullable
  public avxs a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        avxs localavxs = (avxs)this.jdField_a_of_type_JavaUtilList.remove(0);
        return localavxs;
      }
      return null;
    }
  }
  
  public void a()
  {
    ved.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "stopDecode", new Object[0]);
    this.jdField_a_of_type_Avyx.a();
    ved.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of stopDecode");
    f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Avyx.a(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Avyx.a(paramLong1, paramLong2);
  }
  
  public void a(avxm paramavxm, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, avxp paramavxp)
  {
    throw new AndroidRuntimeException("please use startDecode(FlowDecodeConfig, FlowListener) instead");
  }
  
  public void a(avxv paramavxv, avyw paramavyw)
  {
    this.jdField_a_of_type_Avyw = paramavyw;
    ved.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "startDecode : decodeConfig = %s", new Object[] { paramavxv });
    this.jdField_a_of_type_Avyx.a(paramavxv, this.jdField_a_of_type_Avxp, this);
  }
  
  @Nullable
  public avxs b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        avxs localavxs = (avxs)this.jdField_a_of_type_JavaUtilList.get(0);
        return localavxs;
      }
      return null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Avyx.b();
  }
  
  @Nullable
  public avxs c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() >= 2)
      {
        avxs localavxs = (avxs)this.jdField_a_of_type_JavaUtilList.get(1);
        return localavxs;
      }
      return null;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Avyx.c();
  }
  
  public void d()
  {
    ved.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of play range change");
    f();
  }
  
  public void e()
  {
    ved.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of direction change");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avyt
 * JD-Core Version:    0.7.0.1
 */