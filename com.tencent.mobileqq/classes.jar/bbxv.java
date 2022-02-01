import android.opengl.GLES20;
import com.tencent.maxvideo.common.AVIOStruct;
import java.util.concurrent.atomic.AtomicInteger;

public class bbxv
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private bbxs[] jdField_a_of_type_ArrayOfBbxs = new bbxs[3];
  
  private boolean c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public bbxs a()
  {
    if (!c()) {
      return null;
    }
    int i = 0;
    bbxs localbbxs;
    if (i < this.jdField_a_of_type_ArrayOfBbxs.length) {
      if (this.jdField_a_of_type_ArrayOfBbxs[i].b() == 0)
      {
        localbbxs = this.jdField_a_of_type_ArrayOfBbxs[i];
        localbbxs.d();
      }
    }
    for (;;)
    {
      return localbbxs;
      i += 1;
      break;
      localbbxs = null;
    }
  }
  
  public void a()
  {
    int i = 0;
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    while (i < this.jdField_a_of_type_ArrayOfBbxs.length)
    {
      this.jdField_a_of_type_ArrayOfBbxs[i] = new bbxs(this.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(1);
  }
  
  public void a(bbxu parambbxu)
  {
    if (c())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBbxs.length)
      {
        this.jdField_a_of_type_ArrayOfBbxs[i].a(parambbxu);
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
      while (i < this.jdField_a_of_type_ArrayOfBbxs.length)
      {
        if (this.jdField_a_of_type_ArrayOfBbxs[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public bbxs b()
  {
    if (!c()) {
      return null;
    }
    int i = 0;
    bbxs localbbxs;
    if (i < this.jdField_a_of_type_ArrayOfBbxs.length)
    {
      if (this.jdField_a_of_type_ArrayOfBbxs[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfBbxs[i].a() != 0)
      {
        i += 1;
        break;
      }
      localbbxs = this.jdField_a_of_type_ArrayOfBbxs[i];
      localbbxs.d();
    }
    for (;;)
    {
      return localbbxs;
      localbbxs = null;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(0) == 1)
    {
      GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBbxs.length)
      {
        if (this.jdField_a_of_type_ArrayOfBbxs[i] != null)
        {
          this.jdField_a_of_type_ArrayOfBbxs[i].b();
          this.jdField_a_of_type_ArrayOfBbxs[i] = null;
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
    while (i < this.jdField_a_of_type_ArrayOfBbxs.length)
    {
      this.jdField_a_of_type_ArrayOfBbxs[i].c();
      i += 1;
    }
    return true;
  }
  
  public bbxs c()
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
    } while (i >= this.jdField_a_of_type_ArrayOfBbxs.length);
    bbxs localbbxs;
    if (this.jdField_a_of_type_ArrayOfBbxs[i].a() == 2)
    {
      localbbxs = this.jdField_a_of_type_ArrayOfBbxs[i];
      if (localObject1 == null) {
        localObject1 = localbbxs;
      }
    }
    for (;;)
    {
      i += 1;
      break label18;
      AVIOStruct localAVIOStruct = (AVIOStruct)localObject1.a.a;
      localObject2 = (AVIOStruct)localbbxs.a.a;
      long l = localAVIOStruct.vFrameTime;
      if (((AVIOStruct)localObject2).vFrameTime > l)
      {
        localObject2 = localObject1;
        if (localAVIOStruct.pFrameIndex == 0) {
          break;
        }
        localObject1.c();
        localObject1 = localbbxs;
        continue;
      }
      localbbxs.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxv
 * JD-Core Version:    0.7.0.1
 */