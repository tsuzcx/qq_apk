import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.support.annotation.Nullable;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class axqs
  implements axpp, axpv
{
  private axpo jdField_a_of_type_Axpo = new axqt(this);
  private axqv jdField_a_of_type_Axqv;
  private axqw jdField_a_of_type_Axqw = new axqw();
  private Comparator<axpr> jdField_a_of_type_JavaUtilComparator = new axqu(this);
  private final List<axpr> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((axpr)localIterator.next()).b();
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
  
  public int a(List<axpr> paramList)
  {
    if (paramList.size() > 0) {
      wsv.c("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size " + paramList.size() + ", range [" + ((axpr)paramList.get(0)).a() + " - " + ((axpr)paramList.get(paramList.size() - 1)).a() + "], cycle " + ((axpr)paramList.get(0)).b() + ", current size " + this.jdField_a_of_type_JavaUtilList.size());
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
        if ((i != 0) && (this.jdField_a_of_type_Axqv != null)) {
          this.jdField_a_of_type_Axqv.a();
        }
        return j;
        wsv.d("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size 0");
      }
      int i = 0;
    }
  }
  
  @Nullable
  public axpr a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        axpr localaxpr = (axpr)this.jdField_a_of_type_JavaUtilList.remove(0);
        return localaxpr;
      }
      return null;
    }
  }
  
  public void a()
  {
    wsv.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "stopDecode", new Object[0]);
    this.jdField_a_of_type_Axqw.a();
    wsv.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of stopDecode");
    f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Axqw.a(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Axqw.a(paramLong1, paramLong2);
  }
  
  public void a(axpl paramaxpl, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, axpo paramaxpo)
  {
    throw new AndroidRuntimeException("please use startDecode(FlowDecodeConfig, FlowListener) instead");
  }
  
  public void a(axpu paramaxpu, axqv paramaxqv)
  {
    this.jdField_a_of_type_Axqv = paramaxqv;
    wsv.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "startDecode : decodeConfig = %s", new Object[] { paramaxpu });
    this.jdField_a_of_type_Axqw.a(paramaxpu, this.jdField_a_of_type_Axpo, this);
  }
  
  @Nullable
  public axpr b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        axpr localaxpr = (axpr)this.jdField_a_of_type_JavaUtilList.get(0);
        return localaxpr;
      }
      return null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Axqw.b();
  }
  
  @Nullable
  public axpr c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() >= 2)
      {
        axpr localaxpr = (axpr)this.jdField_a_of_type_JavaUtilList.get(1);
        return localaxpr;
      }
      return null;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Axqw.c();
  }
  
  public void d()
  {
    wsv.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of play range change");
    f();
  }
  
  public void e()
  {
    wsv.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of direction change");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axqs
 * JD-Core Version:    0.7.0.1
 */