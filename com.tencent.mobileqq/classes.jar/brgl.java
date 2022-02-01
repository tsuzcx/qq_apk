import android.support.annotation.NonNull;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class brgl
  extends GPUBaseFilter
{
  private int jdField_a_of_type_Int = -1;
  private List<GPUBaseFilter> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List<RenderBuffer> b;
  
  private void a()
  {
    if (this.b != null)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((RenderBuffer)localIterator.next()).destroy();
      }
      this.b = null;
    }
  }
  
  public RenderBuffer a()
  {
    if ((this.b != null) && (this.b.size() > 0)) {
      return (RenderBuffer)this.b.get(this.b.size() - 1);
    }
    throw new RuntimeException("please check your state");
  }
  
  public void a(@NonNull GPUBaseFilter paramGPUBaseFilter)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramGPUBaseFilter);
  }
  
  public void destroy()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GPUBaseFilter)localIterator.next()).destroy();
    }
    a();
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramInt = 0;
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (paramInt != this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        ((RenderBuffer)this.b.get(paramInt)).bind();
        ((GPUBaseFilter)this.jdField_a_of_type_JavaUtilList.get(paramInt)).drawTexture(this.jdField_a_of_type_Int, null, null);
        ((RenderBuffer)this.b.get(paramInt)).unbind();
        this.jdField_a_of_type_Int = ((RenderBuffer)this.b.get(paramInt)).getTexId();
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (this.jdField_a_of_type_Boolean)
        {
          ((GPUBaseFilter)this.jdField_a_of_type_JavaUtilList.get(paramInt)).drawTexture(this.jdField_a_of_type_Int, paramArrayOfFloat1, paramArrayOfFloat2);
        }
        else
        {
          ((RenderBuffer)this.b.get(paramInt)).bind();
          ((GPUBaseFilter)this.jdField_a_of_type_JavaUtilList.get(paramInt)).drawTexture(this.jdField_a_of_type_Int, paramArrayOfFloat1, paramArrayOfFloat2);
          ((RenderBuffer)this.b.get(paramInt)).unbind();
          this.jdField_a_of_type_Int = ((RenderBuffer)this.b.get(paramInt)).getTexId();
        }
      }
    }
  }
  
  public void init()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GPUBaseFilter)localIterator.next()).init();
    }
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GPUBaseFilter)((Iterator)localObject).next()).onOutputSizeChanged(paramInt1, paramInt2);
    }
    a();
    this.b = new ArrayList();
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = j;
    if (this.jdField_a_of_type_Boolean) {
      i = j - 1;
    }
    j = 0;
    while (j < i)
    {
      localObject = new RenderBuffer(paramInt1, paramInt2, 33984);
      this.b.add(localObject);
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brgl
 * JD-Core Version:    0.7.0.1
 */