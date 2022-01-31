import android.opengl.GLES20;
import com.tencent.maxvideo.common.AVIOStruct;
import java.util.concurrent.atomic.AtomicInteger;

public class axlt
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private axlq[] jdField_a_of_type_ArrayOfAxlq = new axlq[3];
  
  private boolean c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public axlq a()
  {
    if (!c()) {
      return null;
    }
    int i = 0;
    axlq localaxlq;
    if (i < this.jdField_a_of_type_ArrayOfAxlq.length) {
      if (this.jdField_a_of_type_ArrayOfAxlq[i].b() == 0)
      {
        localaxlq = this.jdField_a_of_type_ArrayOfAxlq[i];
        localaxlq.d();
      }
    }
    for (;;)
    {
      return localaxlq;
      i += 1;
      break;
      localaxlq = null;
    }
  }
  
  public void a()
  {
    int i = 0;
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    while (i < this.jdField_a_of_type_ArrayOfAxlq.length)
    {
      this.jdField_a_of_type_ArrayOfAxlq[i] = new axlq(this.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(1);
  }
  
  public void a(axls paramaxls)
  {
    if (c())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAxlq.length)
      {
        this.jdField_a_of_type_ArrayOfAxlq[i].a(paramaxls);
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    if (!c()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAxlq.length)
      {
        if (this.jdField_a_of_type_ArrayOfAxlq[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public axlq b()
  {
    if (!c()) {
      return null;
    }
    int i = 0;
    axlq localaxlq;
    if (i < this.jdField_a_of_type_ArrayOfAxlq.length)
    {
      if (this.jdField_a_of_type_ArrayOfAxlq[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfAxlq[i].a() != 0)
      {
        i += 1;
        break;
      }
      localaxlq = this.jdField_a_of_type_ArrayOfAxlq[i];
      localaxlq.d();
    }
    for (;;)
    {
      return localaxlq;
      localaxlq = null;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(0) == 1)
    {
      GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAxlq.length)
      {
        if (this.jdField_a_of_type_ArrayOfAxlq[i] != null)
        {
          this.jdField_a_of_type_ArrayOfAxlq[i].b();
          this.jdField_a_of_type_ArrayOfAxlq[i] = null;
        }
        this.jdField_a_of_type_ArrayOfInt[i] = 0;
        i += 1;
      }
    }
  }
  
  public boolean b()
  {
    int i = 0;
    if (!c()) {
      return false;
    }
    while (i < this.jdField_a_of_type_ArrayOfAxlq.length)
    {
      this.jdField_a_of_type_ArrayOfAxlq[i].c();
      i += 1;
    }
    return true;
  }
  
  public axlq c()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (!c()) {}
    int i;
    label18:
    do
    {
      return localObject2;
      i = 0;
      localObject2 = localObject1;
    } while (i >= this.jdField_a_of_type_ArrayOfAxlq.length);
    axlq localaxlq;
    if (this.jdField_a_of_type_ArrayOfAxlq[i].a() == 2)
    {
      localaxlq = this.jdField_a_of_type_ArrayOfAxlq[i];
      if (localObject1 == null) {
        localObject1 = localaxlq;
      }
    }
    for (;;)
    {
      i += 1;
      break label18;
      AVIOStruct localAVIOStruct = (AVIOStruct)localObject1.a.a;
      localObject2 = (AVIOStruct)localaxlq.a.a;
      long l = localAVIOStruct.vFrameTime;
      if (((AVIOStruct)localObject2).vFrameTime > l)
      {
        localObject2 = localObject1;
        if (localAVIOStruct.pFrameIndex == 0) {
          break;
        }
        localObject1.c();
        localObject1 = localaxlq;
        continue;
      }
      localaxlq.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axlt
 * JD-Core Version:    0.7.0.1
 */