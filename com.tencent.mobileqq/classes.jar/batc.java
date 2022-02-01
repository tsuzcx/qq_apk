import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.support.annotation.Nullable;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class batc
  implements barz, basf
{
  private bary jdField_a_of_type_Bary = new batd(this);
  private batf jdField_a_of_type_Batf;
  private batg jdField_a_of_type_Batg = new batg();
  private Comparator<basb> jdField_a_of_type_JavaUtilComparator = new bate(this);
  private final List<basb> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((basb)localIterator.next()).b();
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
  
  public int a(List<basb> paramList)
  {
    if (paramList.size() > 0) {
      yqp.c("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size " + paramList.size() + ", range [" + ((basb)paramList.get(0)).a() + " - " + ((basb)paramList.get(paramList.size() - 1)).a() + "], cycle " + ((basb)paramList.get(0)).b() + ", current size " + this.jdField_a_of_type_JavaUtilList.size());
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
        if ((i != 0) && (this.jdField_a_of_type_Batf != null)) {
          this.jdField_a_of_type_Batf.a();
        }
        return j;
        yqp.d("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size 0");
      }
      int i = 0;
    }
  }
  
  @Nullable
  public basb a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        basb localbasb = (basb)this.jdField_a_of_type_JavaUtilList.remove(0);
        return localbasb;
      }
      return null;
    }
  }
  
  public void a()
  {
    yqp.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "stopDecode", new Object[0]);
    this.jdField_a_of_type_Batg.a();
    yqp.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of stopDecode");
    f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Batg.a(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Batg.a(paramLong1, paramLong2);
  }
  
  public void a(barv parambarv, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, bary parambary)
  {
    throw new AndroidRuntimeException("please use startDecode(FlowDecodeConfig, FlowListener) instead");
  }
  
  public void a(base parambase, batf parambatf)
  {
    this.jdField_a_of_type_Batf = parambatf;
    yqp.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "startDecode : decodeConfig = %s", new Object[] { parambase });
    this.jdField_a_of_type_Batg.a(parambase, this.jdField_a_of_type_Bary, this);
  }
  
  @Nullable
  public basb b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        basb localbasb = (basb)this.jdField_a_of_type_JavaUtilList.get(0);
        return localbasb;
      }
      return null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Batg.b();
  }
  
  @Nullable
  public basb c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() >= 2)
      {
        basb localbasb = (basb)this.jdField_a_of_type_JavaUtilList.get(1);
        return localbasb;
      }
      return null;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Batg.c();
  }
  
  public void d()
  {
    yqp.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of play range change");
    f();
  }
  
  public void e()
  {
    yqp.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of direction change");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batc
 * JD-Core Version:    0.7.0.1
 */