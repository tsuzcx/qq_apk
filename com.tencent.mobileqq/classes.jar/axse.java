import android.support.annotation.NonNull;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.util.LinkedList;

public class axse
  extends GPUBaseFilter
{
  private float jdField_a_of_type_Float;
  private axrx jdField_a_of_type_Axrx;
  private final LinkedList<Runnable> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private axrx b;
  
  private void a(@NonNull Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramRunnable);
      return;
    }
  }
  
  private void a(@NonNull LinkedList<Runnable> paramLinkedList)
  {
    try
    {
      while (!paramLinkedList.isEmpty())
      {
        Runnable localRunnable = (Runnable)paramLinkedList.poll();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
    finally {}
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_JavaUtilLinkedList);
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5)
  {
    a(new GpuImagePartsFilterGroup.2(this, paramInt1, paramInt4, paramInt5, paramInt2, paramInt3, paramFloat));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!axrv.a(paramInt1)) {
      throw new IllegalArgumentException("filterType " + paramInt1 + " is invalid color filter type");
    }
    a(new GpuImagePartsFilterGroup.1(this, paramInt1, paramInt2, paramInt3));
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Axrx != null) || (this.b != null);
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Axrx != null) {
      this.jdField_a_of_type_Axrx.destroy();
    }
    if (this.b != null) {
      this.b.destroy();
    }
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (!a())
    {
      wsv.e("Q.qqstory.publish.edit GpuImagePartsFilterGroup", "must set filters before draw texture");
      return;
    }
    if (this.jdField_a_of_type_Axrx != null) {
      this.jdField_a_of_type_Axrx.drawTexture(paramInt, paramArrayOfFloat1, paramArrayOfFloat2);
    }
    this.b.drawTexture(paramInt, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void init()
  {
    if ((this.jdField_a_of_type_Axrx != null) && (!this.jdField_a_of_type_Axrx.isInitialized())) {
      this.jdField_a_of_type_Axrx.init();
    }
    if ((this.b != null) && (!this.b.isInitialized())) {
      this.b.init();
    }
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Axrx != null) {
      this.jdField_a_of_type_Axrx.onOutputSizeChanged(paramInt1, paramInt2);
    }
    if (this.b != null) {
      this.b.onOutputSizeChanged(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axse
 * JD-Core Version:    0.7.0.1
 */