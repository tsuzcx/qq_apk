import android.opengl.GLES20;
import com.tencent.maxvideo.common.AVIOStruct;
import java.util.concurrent.atomic.AtomicInteger;

public class bcmi
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private bcmf[] jdField_a_of_type_ArrayOfBcmf = new bcmf[3];
  
  private boolean c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public bcmf a()
  {
    if (!c()) {
      return null;
    }
    int i = 0;
    bcmf localbcmf;
    if (i < this.jdField_a_of_type_ArrayOfBcmf.length) {
      if (this.jdField_a_of_type_ArrayOfBcmf[i].b() == 0)
      {
        localbcmf = this.jdField_a_of_type_ArrayOfBcmf[i];
        localbcmf.d();
      }
    }
    for (;;)
    {
      return localbcmf;
      i += 1;
      break;
      localbcmf = null;
    }
  }
  
  public void a()
  {
    int i = 0;
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    while (i < this.jdField_a_of_type_ArrayOfBcmf.length)
    {
      this.jdField_a_of_type_ArrayOfBcmf[i] = new bcmf(this.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(1);
  }
  
  public void a(bcmh parambcmh)
  {
    if (c())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBcmf.length)
      {
        this.jdField_a_of_type_ArrayOfBcmf[i].a(parambcmh);
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
      while (i < this.jdField_a_of_type_ArrayOfBcmf.length)
      {
        if (this.jdField_a_of_type_ArrayOfBcmf[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public bcmf b()
  {
    if (!c()) {
      return null;
    }
    int i = 0;
    bcmf localbcmf;
    if (i < this.jdField_a_of_type_ArrayOfBcmf.length)
    {
      if (this.jdField_a_of_type_ArrayOfBcmf[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfBcmf[i].a() != 0)
      {
        i += 1;
        break;
      }
      localbcmf = this.jdField_a_of_type_ArrayOfBcmf[i];
      localbcmf.d();
    }
    for (;;)
    {
      return localbcmf;
      localbcmf = null;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(0) == 1)
    {
      GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBcmf.length)
      {
        if (this.jdField_a_of_type_ArrayOfBcmf[i] != null)
        {
          this.jdField_a_of_type_ArrayOfBcmf[i].b();
          this.jdField_a_of_type_ArrayOfBcmf[i] = null;
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
    while (i < this.jdField_a_of_type_ArrayOfBcmf.length)
    {
      this.jdField_a_of_type_ArrayOfBcmf[i].c();
      i += 1;
    }
    return true;
  }
  
  public bcmf c()
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
    } while (i >= this.jdField_a_of_type_ArrayOfBcmf.length);
    bcmf localbcmf;
    if (this.jdField_a_of_type_ArrayOfBcmf[i].a() == 2)
    {
      localbcmf = this.jdField_a_of_type_ArrayOfBcmf[i];
      if (localObject1 == null) {
        localObject1 = localbcmf;
      }
    }
    for (;;)
    {
      i += 1;
      break label18;
      AVIOStruct localAVIOStruct = (AVIOStruct)localObject1.a.a;
      localObject2 = (AVIOStruct)localbcmf.a.a;
      long l = localAVIOStruct.vFrameTime;
      if (((AVIOStruct)localObject2).vFrameTime > l)
      {
        localObject2 = localObject1;
        if (localAVIOStruct.pFrameIndex == 0) {
          break;
        }
        localObject1.c();
        localObject1 = localbcmf;
        continue;
      }
      localbcmf.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmi
 * JD-Core Version:    0.7.0.1
 */