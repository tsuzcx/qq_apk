import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;

public class ampd
{
  private final amra jdField_a_of_type_Amra = new amra();
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  
  public int a()
  {
    return this.jdField_a_of_type_Amra.a();
  }
  
  public Bitmap a(ampo paramampo, ampx paramampx)
  {
    if (paramampo == null) {
      throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
    }
    try
    {
      if (paramampo.f())
      {
        Object localObject2 = paramampo.a();
        Object localObject1;
        if (localObject2 == null) {
          localObject1 = this.jdField_a_of_type_Amra.a((int)paramampo.f(), (int)paramampo.g());
        }
        for (;;)
        {
          paramampo.a((Bitmap)localObject1);
          if (localObject1 != null) {
            break;
          }
          return null;
          if (((Bitmap)localObject2).getWidth() >= (int)paramampo.f())
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() >= (int)paramampo.g()) {}
          }
          else
          {
            this.jdField_a_of_type_Amra.a((Bitmap)localObject2);
            localObject1 = this.jdField_a_of_type_Amra.a((int)paramampo.f(), (int)paramampo.g());
          }
        }
        localObject2 = paramampo.a();
        if (localObject2 == null)
        {
          localObject2 = new Canvas((Bitmap)localObject1);
          paramampo.a((Canvas)localObject2);
        }
        for (;;)
        {
          ((Bitmap)localObject1).eraseColor(0);
          paramampo.c(false);
          paramampx.a(paramampo).a((Canvas)localObject2, paramampo, paramampx, ampx.a().g(), ampx.a().c());
          return localObject1;
          ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
        }
      }
      paramampo = paramampo.a();
    }
    finally {}
    return paramampo;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (amro.a())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(ampo paramampo, ampx paramampx) {}
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Amra.a(paramBitmap);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Amra.c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Amra.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Amra.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ampd
 * JD-Core Version:    0.7.0.1
 */