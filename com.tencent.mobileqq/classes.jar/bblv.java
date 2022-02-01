import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.support.annotation.Nullable;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class bblv
  implements bbks, bbky
{
  private bbkr jdField_a_of_type_Bbkr = new bblw(this);
  private bbly jdField_a_of_type_Bbly;
  private bblz jdField_a_of_type_Bblz = new bblz();
  private Comparator<bbku> jdField_a_of_type_JavaUtilComparator = new bblx(this);
  private final List<bbku> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((bbku)localIterator.next()).b();
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
  
  public int a(List<bbku> paramList)
  {
    if (paramList.size() > 0) {
      yuk.c("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size " + paramList.size() + ", range [" + ((bbku)paramList.get(0)).a() + " - " + ((bbku)paramList.get(paramList.size() - 1)).a() + "], cycle " + ((bbku)paramList.get(0)).b() + ", current size " + this.jdField_a_of_type_JavaUtilList.size());
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
        if ((i != 0) && (this.jdField_a_of_type_Bbly != null)) {
          this.jdField_a_of_type_Bbly.a();
        }
        return j;
        yuk.d("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size 0");
      }
      int i = 0;
    }
  }
  
  @Nullable
  public bbku a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        bbku localbbku = (bbku)this.jdField_a_of_type_JavaUtilList.remove(0);
        return localbbku;
      }
      return null;
    }
  }
  
  public void a()
  {
    yuk.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "stopDecode", new Object[0]);
    this.jdField_a_of_type_Bblz.a();
    yuk.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of stopDecode");
    f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bblz.a(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bblz.a(paramLong1, paramLong2);
  }
  
  public void a(bbko parambbko, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, bbkr parambbkr)
  {
    throw new AndroidRuntimeException("please use startDecode(FlowDecodeConfig, FlowListener) instead");
  }
  
  public void a(bbkx parambbkx, bbly parambbly)
  {
    this.jdField_a_of_type_Bbly = parambbly;
    yuk.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "startDecode : decodeConfig = %s", new Object[] { parambbkx });
    this.jdField_a_of_type_Bblz.a(parambbkx, this.jdField_a_of_type_Bbkr, this);
  }
  
  @Nullable
  public bbku b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        bbku localbbku = (bbku)this.jdField_a_of_type_JavaUtilList.get(0);
        return localbbku;
      }
      return null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bblz.b();
  }
  
  @Nullable
  public bbku c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() >= 2)
      {
        bbku localbbku = (bbku)this.jdField_a_of_type_JavaUtilList.get(1);
        return localbbku;
      }
      return null;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bblz.c();
  }
  
  public void d()
  {
    yuk.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of play range change");
    f();
  }
  
  public void e()
  {
    yuk.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of direction change");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblv
 * JD-Core Version:    0.7.0.1
 */