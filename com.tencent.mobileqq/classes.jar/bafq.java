import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.support.annotation.Nullable;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class bafq
  implements baen, baet
{
  private baem jdField_a_of_type_Baem = new bafr(this);
  private baft jdField_a_of_type_Baft;
  private bafu jdField_a_of_type_Bafu = new bafu();
  private Comparator<baep> jdField_a_of_type_JavaUtilComparator = new bafs(this);
  private final List<baep> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((baep)localIterator.next()).b();
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
  
  public int a(List<baep> paramList)
  {
    if (paramList.size() > 0) {
      xvv.c("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size " + paramList.size() + ", range [" + ((baep)paramList.get(0)).a() + " - " + ((baep)paramList.get(paramList.size() - 1)).a() + "], cycle " + ((baep)paramList.get(0)).b() + ", current size " + this.jdField_a_of_type_JavaUtilList.size());
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
        if ((i != 0) && (this.jdField_a_of_type_Baft != null)) {
          this.jdField_a_of_type_Baft.a();
        }
        return j;
        xvv.d("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size 0");
      }
      int i = 0;
    }
  }
  
  @Nullable
  public baep a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        baep localbaep = (baep)this.jdField_a_of_type_JavaUtilList.remove(0);
        return localbaep;
      }
      return null;
    }
  }
  
  public void a()
  {
    xvv.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "stopDecode", new Object[0]);
    this.jdField_a_of_type_Bafu.a();
    xvv.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of stopDecode");
    f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bafu.a(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bafu.a(paramLong1, paramLong2);
  }
  
  public void a(baej parambaej, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, baem parambaem)
  {
    throw new AndroidRuntimeException("please use startDecode(FlowDecodeConfig, FlowListener) instead");
  }
  
  public void a(baes parambaes, baft parambaft)
  {
    this.jdField_a_of_type_Baft = parambaft;
    xvv.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "startDecode : decodeConfig = %s", new Object[] { parambaes });
    this.jdField_a_of_type_Bafu.a(parambaes, this.jdField_a_of_type_Baem, this);
  }
  
  @Nullable
  public baep b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        baep localbaep = (baep)this.jdField_a_of_type_JavaUtilList.get(0);
        return localbaep;
      }
      return null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bafu.b();
  }
  
  @Nullable
  public baep c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() >= 2)
      {
        baep localbaep = (baep)this.jdField_a_of_type_JavaUtilList.get(1);
        return localbaep;
      }
      return null;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bafu.c();
  }
  
  public void d()
  {
    xvv.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of play range change");
    f();
  }
  
  public void e()
  {
    xvv.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of direction change");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafq
 * JD-Core Version:    0.7.0.1
 */