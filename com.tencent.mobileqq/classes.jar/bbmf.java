import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.support.annotation.Nullable;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class bbmf
  implements bblc, bbli
{
  private bblb jdField_a_of_type_Bblb = new bbmg(this);
  private bbmi jdField_a_of_type_Bbmi;
  private bbmj jdField_a_of_type_Bbmj = new bbmj();
  private Comparator<bble> jdField_a_of_type_JavaUtilComparator = new bbmh(this);
  private final List<bble> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((bble)localIterator.next()).b();
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
  
  public int a(List<bble> paramList)
  {
    if (paramList.size() > 0) {
      ykq.c("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size " + paramList.size() + ", range [" + ((bble)paramList.get(0)).a() + " - " + ((bble)paramList.get(paramList.size() - 1)).a() + "], cycle " + ((bble)paramList.get(0)).b() + ", current size " + this.jdField_a_of_type_JavaUtilList.size());
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
        if ((i != 0) && (this.jdField_a_of_type_Bbmi != null)) {
          this.jdField_a_of_type_Bbmi.a();
        }
        return j;
        ykq.d("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size 0");
      }
      int i = 0;
    }
  }
  
  @Nullable
  public bble a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        bble localbble = (bble)this.jdField_a_of_type_JavaUtilList.remove(0);
        return localbble;
      }
      return null;
    }
  }
  
  public void a()
  {
    ykq.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "stopDecode", new Object[0]);
    this.jdField_a_of_type_Bbmj.a();
    ykq.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of stopDecode");
    f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bbmj.a(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bbmj.a(paramLong1, paramLong2);
  }
  
  public void a(bbky parambbky, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, bblb parambblb)
  {
    throw new AndroidRuntimeException("please use startDecode(FlowDecodeConfig, FlowListener) instead");
  }
  
  public void a(bblh parambblh, bbmi parambbmi)
  {
    this.jdField_a_of_type_Bbmi = parambbmi;
    ykq.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "startDecode : decodeConfig = %s", new Object[] { parambblh });
    this.jdField_a_of_type_Bbmj.a(parambblh, this.jdField_a_of_type_Bblb, this);
  }
  
  @Nullable
  public bble b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        bble localbble = (bble)this.jdField_a_of_type_JavaUtilList.get(0);
        return localbble;
      }
      return null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bbmj.b();
  }
  
  @Nullable
  public bble c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() >= 2)
      {
        bble localbble = (bble)this.jdField_a_of_type_JavaUtilList.get(1);
        return localbble;
      }
      return null;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bbmj.c();
  }
  
  public void d()
  {
    ykq.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of play range change");
    f();
  }
  
  public void e()
  {
    ykq.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of direction change");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmf
 * JD-Core Version:    0.7.0.1
 */