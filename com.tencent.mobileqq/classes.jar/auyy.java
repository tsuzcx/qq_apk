import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.support.annotation.Nullable;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class auyy
  implements auxv, auyb
{
  private auxu jdField_a_of_type_Auxu = new auyz(this);
  private auzb jdField_a_of_type_Auzb;
  private auzc jdField_a_of_type_Auzc = new auzc();
  private Comparator<auxx> jdField_a_of_type_JavaUtilComparator = new auza(this);
  private final List<auxx> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((auxx)localIterator.next()).b();
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
  
  public int a(List<auxx> paramList)
  {
    if (paramList.size() > 0) {
      urk.c("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size " + paramList.size() + ", range [" + ((auxx)paramList.get(0)).a() + " - " + ((auxx)paramList.get(paramList.size() - 1)).a() + "], cycle " + ((auxx)paramList.get(0)).b() + ", current size " + this.jdField_a_of_type_JavaUtilList.size());
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
        if ((i != 0) && (this.jdField_a_of_type_Auzb != null)) {
          this.jdField_a_of_type_Auzb.a();
        }
        return j;
        urk.d("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size 0");
      }
      int i = 0;
    }
  }
  
  @Nullable
  public auxx a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        auxx localauxx = (auxx)this.jdField_a_of_type_JavaUtilList.remove(0);
        return localauxx;
      }
      return null;
    }
  }
  
  public void a()
  {
    urk.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "stopDecode", new Object[0]);
    this.jdField_a_of_type_Auzc.a();
    urk.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of stopDecode");
    f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Auzc.a(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Auzc.a(paramLong1, paramLong2);
  }
  
  public void a(auxr paramauxr, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, auxu paramauxu)
  {
    throw new AndroidRuntimeException("please use startDecode(FlowDecodeConfig, FlowListener) instead");
  }
  
  public void a(auya paramauya, auzb paramauzb)
  {
    this.jdField_a_of_type_Auzb = paramauzb;
    urk.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "startDecode : decodeConfig = %s", new Object[] { paramauya });
    this.jdField_a_of_type_Auzc.a(paramauya, this.jdField_a_of_type_Auxu, this);
  }
  
  @Nullable
  public auxx b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        auxx localauxx = (auxx)this.jdField_a_of_type_JavaUtilList.get(0);
        return localauxx;
      }
      return null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Auzc.b();
  }
  
  @Nullable
  public auxx c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() >= 2)
      {
        auxx localauxx = (auxx)this.jdField_a_of_type_JavaUtilList.get(1);
        return localauxx;
      }
      return null;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Auzc.c();
  }
  
  public void d()
  {
    urk.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of play range change");
    f();
  }
  
  public void e()
  {
    urk.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of direction change");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auyy
 * JD-Core Version:    0.7.0.1
 */