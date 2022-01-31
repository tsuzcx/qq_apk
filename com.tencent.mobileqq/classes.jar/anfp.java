import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;

public class anfp
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final anhm jdField_a_of_type_Anhm = new anhm();
  
  public int a()
  {
    return this.jdField_a_of_type_Anhm.a();
  }
  
  public Bitmap a(anga paramanga, angj paramangj)
  {
    if (paramanga == null) {
      throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
    }
    try
    {
      if (paramanga.f())
      {
        Object localObject2 = paramanga.a();
        Object localObject1;
        if (localObject2 == null) {
          localObject1 = this.jdField_a_of_type_Anhm.a((int)paramanga.f(), (int)paramanga.g());
        }
        for (;;)
        {
          paramanga.a((Bitmap)localObject1);
          if (localObject1 != null) {
            break;
          }
          return null;
          if (((Bitmap)localObject2).getWidth() >= (int)paramanga.f())
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() >= (int)paramanga.g()) {}
          }
          else
          {
            this.jdField_a_of_type_Anhm.a((Bitmap)localObject2);
            localObject1 = this.jdField_a_of_type_Anhm.a((int)paramanga.f(), (int)paramanga.g());
          }
        }
        localObject2 = paramanga.a();
        if (localObject2 == null)
        {
          localObject2 = new Canvas((Bitmap)localObject1);
          paramanga.a((Canvas)localObject2);
        }
        for (;;)
        {
          ((Bitmap)localObject1).eraseColor(0);
          paramanga.c(false);
          paramangj.a(paramanga).a((Canvas)localObject2, paramanga, paramangj, angj.a().g(), angj.a().c());
          return localObject1;
          ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
        }
      }
      paramanga = paramanga.a();
    }
    finally {}
    return paramanga;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (ania.a())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Anhm.a(paramBitmap);
  }
  
  public void a(anga paramanga, angj paramangj) {}
  
  public int b()
  {
    return this.jdField_a_of_type_Anhm.c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Anhm.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Anhm.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anfp
 * JD-Core Version:    0.7.0.1
 */