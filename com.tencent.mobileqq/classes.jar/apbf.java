import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;

public class apbf
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final apdc jdField_a_of_type_Apdc = new apdc();
  
  public int a()
  {
    return this.jdField_a_of_type_Apdc.a();
  }
  
  public Bitmap a(apbq paramapbq, apbz paramapbz)
  {
    if (paramapbq == null) {
      throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
    }
    try
    {
      if (paramapbq.f())
      {
        Object localObject2 = paramapbq.a();
        Object localObject1;
        if (localObject2 == null) {
          localObject1 = this.jdField_a_of_type_Apdc.a((int)paramapbq.f(), (int)paramapbq.g());
        }
        for (;;)
        {
          paramapbq.a((Bitmap)localObject1);
          if (localObject1 != null) {
            break;
          }
          return null;
          if (((Bitmap)localObject2).getWidth() >= (int)paramapbq.f())
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() >= (int)paramapbq.g()) {}
          }
          else
          {
            this.jdField_a_of_type_Apdc.a((Bitmap)localObject2);
            localObject1 = this.jdField_a_of_type_Apdc.a((int)paramapbq.f(), (int)paramapbq.g());
          }
        }
        localObject2 = paramapbq.a();
        if (localObject2 == null)
        {
          localObject2 = new Canvas((Bitmap)localObject1);
          paramapbq.a((Canvas)localObject2);
        }
        for (;;)
        {
          ((Bitmap)localObject1).eraseColor(0);
          paramapbq.c(false);
          paramapbz.a(paramapbq).a((Canvas)localObject2, paramapbq, paramapbz, apbz.a().g(), apbz.a().c());
          return localObject1;
          ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
        }
      }
      paramapbq = paramapbq.a();
    }
    finally {}
    return paramapbq;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (apdq.a())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Apdc.a(paramBitmap);
  }
  
  public void a(apbq paramapbq, apbz paramapbz) {}
  
  public int b()
  {
    return this.jdField_a_of_type_Apdc.c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Apdc.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Apdc.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbf
 * JD-Core Version:    0.7.0.1
 */