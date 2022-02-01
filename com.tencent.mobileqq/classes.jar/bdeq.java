import android.opengl.GLES20;
import com.tencent.maxvideo.common.AVIOStruct;
import java.util.concurrent.atomic.AtomicInteger;

public class bdeq
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private bden[] jdField_a_of_type_ArrayOfBden = new bden[3];
  
  private boolean c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public bden a()
  {
    if (!c()) {
      return null;
    }
    int i = 0;
    bden localbden;
    if (i < this.jdField_a_of_type_ArrayOfBden.length) {
      if (this.jdField_a_of_type_ArrayOfBden[i].b() == 0)
      {
        localbden = this.jdField_a_of_type_ArrayOfBden[i];
        localbden.d();
      }
    }
    for (;;)
    {
      return localbden;
      i += 1;
      break;
      localbden = null;
    }
  }
  
  public void a()
  {
    int i = 0;
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    while (i < this.jdField_a_of_type_ArrayOfBden.length)
    {
      this.jdField_a_of_type_ArrayOfBden[i] = new bden(this.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(1);
  }
  
  public void a(bdep parambdep)
  {
    if (c())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBden.length)
      {
        this.jdField_a_of_type_ArrayOfBden[i].a(parambdep);
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
      while (i < this.jdField_a_of_type_ArrayOfBden.length)
      {
        if (this.jdField_a_of_type_ArrayOfBden[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public bden b()
  {
    if (!c()) {
      return null;
    }
    int i = 0;
    bden localbden;
    if (i < this.jdField_a_of_type_ArrayOfBden.length)
    {
      if (this.jdField_a_of_type_ArrayOfBden[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfBden[i].a() != 0)
      {
        i += 1;
        break;
      }
      localbden = this.jdField_a_of_type_ArrayOfBden[i];
      localbden.d();
    }
    for (;;)
    {
      return localbden;
      localbden = null;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(0) == 1)
    {
      GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBden.length)
      {
        if (this.jdField_a_of_type_ArrayOfBden[i] != null)
        {
          this.jdField_a_of_type_ArrayOfBden[i].b();
          this.jdField_a_of_type_ArrayOfBden[i] = null;
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
    while (i < this.jdField_a_of_type_ArrayOfBden.length)
    {
      this.jdField_a_of_type_ArrayOfBden[i].c();
      i += 1;
    }
    return true;
  }
  
  public bden c()
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
    } while (i >= this.jdField_a_of_type_ArrayOfBden.length);
    bden localbden;
    if (this.jdField_a_of_type_ArrayOfBden[i].a() == 2)
    {
      localbden = this.jdField_a_of_type_ArrayOfBden[i];
      if (localObject1 == null) {
        localObject1 = localbden;
      }
    }
    for (;;)
    {
      i += 1;
      break label18;
      AVIOStruct localAVIOStruct = (AVIOStruct)localObject1.a.a;
      localObject2 = (AVIOStruct)localbden.a.a;
      long l = localAVIOStruct.vFrameTime;
      if (((AVIOStruct)localObject2).vFrameTime > l)
      {
        localObject2 = localObject1;
        if (localAVIOStruct.pFrameIndex == 0) {
          break;
        }
        localObject1.c();
        localObject1 = localbden;
        continue;
      }
      localbden.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdeq
 * JD-Core Version:    0.7.0.1
 */