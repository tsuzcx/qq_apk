import android.opengl.GLES20;
import com.tencent.maxvideo.common.AVIOStruct;
import java.util.concurrent.atomic.AtomicInteger;

public class azlk
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private azlh[] jdField_a_of_type_ArrayOfAzlh = new azlh[3];
  
  private boolean c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public azlh a()
  {
    if (!c()) {
      return null;
    }
    int i = 0;
    azlh localazlh;
    if (i < this.jdField_a_of_type_ArrayOfAzlh.length) {
      if (this.jdField_a_of_type_ArrayOfAzlh[i].b() == 0)
      {
        localazlh = this.jdField_a_of_type_ArrayOfAzlh[i];
        localazlh.d();
      }
    }
    for (;;)
    {
      return localazlh;
      i += 1;
      break;
      localazlh = null;
    }
  }
  
  public void a()
  {
    int i = 0;
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    while (i < this.jdField_a_of_type_ArrayOfAzlh.length)
    {
      this.jdField_a_of_type_ArrayOfAzlh[i] = new azlh(this.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(1);
  }
  
  public void a(azlj paramazlj)
  {
    if (c())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAzlh.length)
      {
        this.jdField_a_of_type_ArrayOfAzlh[i].a(paramazlj);
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
      while (i < this.jdField_a_of_type_ArrayOfAzlh.length)
      {
        if (this.jdField_a_of_type_ArrayOfAzlh[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public azlh b()
  {
    if (!c()) {
      return null;
    }
    int i = 0;
    azlh localazlh;
    if (i < this.jdField_a_of_type_ArrayOfAzlh.length)
    {
      if (this.jdField_a_of_type_ArrayOfAzlh[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfAzlh[i].a() != 0)
      {
        i += 1;
        break;
      }
      localazlh = this.jdField_a_of_type_ArrayOfAzlh[i];
      localazlh.d();
    }
    for (;;)
    {
      return localazlh;
      localazlh = null;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(0) == 1)
    {
      GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAzlh.length)
      {
        if (this.jdField_a_of_type_ArrayOfAzlh[i] != null)
        {
          this.jdField_a_of_type_ArrayOfAzlh[i].b();
          this.jdField_a_of_type_ArrayOfAzlh[i] = null;
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
    while (i < this.jdField_a_of_type_ArrayOfAzlh.length)
    {
      this.jdField_a_of_type_ArrayOfAzlh[i].c();
      i += 1;
    }
    return true;
  }
  
  public azlh c()
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
    } while (i >= this.jdField_a_of_type_ArrayOfAzlh.length);
    azlh localazlh;
    if (this.jdField_a_of_type_ArrayOfAzlh[i].a() == 2)
    {
      localazlh = this.jdField_a_of_type_ArrayOfAzlh[i];
      if (localObject1 == null) {
        localObject1 = localazlh;
      }
    }
    for (;;)
    {
      i += 1;
      break label18;
      AVIOStruct localAVIOStruct = (AVIOStruct)localObject1.a.a;
      localObject2 = (AVIOStruct)localazlh.a.a;
      long l = localAVIOStruct.vFrameTime;
      if (((AVIOStruct)localObject2).vFrameTime > l)
      {
        localObject2 = localObject1;
        if (localAVIOStruct.pFrameIndex == 0) {
          break;
        }
        localObject1.c();
        localObject1 = localazlh;
        continue;
      }
      localazlh.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlk
 * JD-Core Version:    0.7.0.1
 */