import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.support.annotation.Nullable;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class axvb
  implements axty, axue
{
  private axtx jdField_a_of_type_Axtx = new axvc(this);
  private axve jdField_a_of_type_Axve;
  private axvf jdField_a_of_type_Axvf = new axvf();
  private Comparator<axua> jdField_a_of_type_JavaUtilComparator = new axvd(this);
  private final List<axua> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((axua)localIterator.next()).b();
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
  
  public int a(List<axua> paramList)
  {
    if (paramList.size() > 0) {
      wxe.c("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size " + paramList.size() + ", range [" + ((axua)paramList.get(0)).a() + " - " + ((axua)paramList.get(paramList.size() - 1)).a() + "], cycle " + ((axua)paramList.get(0)).b() + ", current size " + this.jdField_a_of_type_JavaUtilList.size());
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
        if ((i != 0) && (this.jdField_a_of_type_Axve != null)) {
          this.jdField_a_of_type_Axve.a();
        }
        return j;
        wxe.d("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size 0");
      }
      int i = 0;
    }
  }
  
  @Nullable
  public axua a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        axua localaxua = (axua)this.jdField_a_of_type_JavaUtilList.remove(0);
        return localaxua;
      }
      return null;
    }
  }
  
  public void a()
  {
    wxe.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "stopDecode", new Object[0]);
    this.jdField_a_of_type_Axvf.a();
    wxe.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of stopDecode");
    f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Axvf.a(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Axvf.a(paramLong1, paramLong2);
  }
  
  public void a(axtu paramaxtu, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, axtx paramaxtx)
  {
    throw new AndroidRuntimeException("please use startDecode(FlowDecodeConfig, FlowListener) instead");
  }
  
  public void a(axud paramaxud, axve paramaxve)
  {
    this.jdField_a_of_type_Axve = paramaxve;
    wxe.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "startDecode : decodeConfig = %s", new Object[] { paramaxud });
    this.jdField_a_of_type_Axvf.a(paramaxud, this.jdField_a_of_type_Axtx, this);
  }
  
  @Nullable
  public axua b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        axua localaxua = (axua)this.jdField_a_of_type_JavaUtilList.get(0);
        return localaxua;
      }
      return null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Axvf.b();
  }
  
  @Nullable
  public axua c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() >= 2)
      {
        axua localaxua = (axua)this.jdField_a_of_type_JavaUtilList.get(1);
        return localaxua;
      }
      return null;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Axvf.c();
  }
  
  public void d()
  {
    wxe.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of play range change");
    f();
  }
  
  public void e()
  {
    wxe.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of direction change");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axvb
 * JD-Core Version:    0.7.0.1
 */