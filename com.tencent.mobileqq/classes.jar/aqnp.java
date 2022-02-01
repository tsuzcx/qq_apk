import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;

public class aqnp
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final aqpm jdField_a_of_type_Aqpm = new aqpm();
  
  public int a()
  {
    return this.jdField_a_of_type_Aqpm.a();
  }
  
  public Bitmap a(aqoa paramaqoa, aqoj paramaqoj)
  {
    if (paramaqoa == null) {
      throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
    }
    try
    {
      if (paramaqoa.f())
      {
        Object localObject2 = paramaqoa.a();
        Object localObject1;
        if (localObject2 == null) {
          localObject1 = this.jdField_a_of_type_Aqpm.a((int)paramaqoa.f(), (int)paramaqoa.g());
        }
        for (;;)
        {
          paramaqoa.a((Bitmap)localObject1);
          if (localObject1 != null) {
            break;
          }
          return null;
          if (((Bitmap)localObject2).getWidth() >= (int)paramaqoa.f())
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() >= (int)paramaqoa.g()) {}
          }
          else
          {
            this.jdField_a_of_type_Aqpm.a((Bitmap)localObject2);
            localObject1 = this.jdField_a_of_type_Aqpm.a((int)paramaqoa.f(), (int)paramaqoa.g());
          }
        }
        localObject2 = paramaqoa.a();
        if (localObject2 == null)
        {
          localObject2 = new Canvas((Bitmap)localObject1);
          paramaqoa.a((Canvas)localObject2);
        }
        for (;;)
        {
          ((Bitmap)localObject1).eraseColor(0);
          paramaqoa.c(false);
          paramaqoj.a(paramaqoa).a((Canvas)localObject2, paramaqoa, paramaqoj, aqoj.a().g(), aqoj.a().c());
          return localObject1;
          ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
        }
      }
      paramaqoa = paramaqoa.a();
    }
    finally {}
    return paramaqoa;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (aqqa.b())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Aqpm.a(paramBitmap);
  }
  
  public void a(aqoa paramaqoa, aqoj paramaqoj) {}
  
  public int b()
  {
    return this.jdField_a_of_type_Aqpm.c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aqpm.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Aqpm.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnp
 * JD-Core Version:    0.7.0.1
 */