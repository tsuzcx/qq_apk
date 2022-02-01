import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;

public class arec
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final arfz jdField_a_of_type_Arfz = new arfz();
  
  public int a()
  {
    return this.jdField_a_of_type_Arfz.a();
  }
  
  public Bitmap a(aren paramaren, arew paramarew)
  {
    if (paramaren == null) {
      throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
    }
    try
    {
      if (paramaren.f())
      {
        Object localObject2 = paramaren.a();
        Object localObject1;
        if (localObject2 == null) {
          localObject1 = this.jdField_a_of_type_Arfz.a((int)paramaren.f(), (int)paramaren.g());
        }
        for (;;)
        {
          paramaren.a((Bitmap)localObject1);
          if (localObject1 != null) {
            break;
          }
          return null;
          if (((Bitmap)localObject2).getWidth() >= (int)paramaren.f())
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() >= (int)paramaren.g()) {}
          }
          else
          {
            this.jdField_a_of_type_Arfz.a((Bitmap)localObject2);
            localObject1 = this.jdField_a_of_type_Arfz.a((int)paramaren.f(), (int)paramaren.g());
          }
        }
        localObject2 = paramaren.a();
        if (localObject2 == null)
        {
          localObject2 = new Canvas((Bitmap)localObject1);
          paramaren.a((Canvas)localObject2);
        }
        for (;;)
        {
          ((Bitmap)localObject1).eraseColor(0);
          paramaren.c(false);
          paramarew.a(paramaren).a((Canvas)localObject2, paramaren, paramarew, arew.a().g(), arew.a().c());
          return localObject1;
          ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
        }
      }
      paramaren = paramaren.a();
    }
    finally {}
    return paramaren;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (argn.a())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Arfz.a(paramBitmap);
  }
  
  public void a(aren paramaren, arew paramarew) {}
  
  public int b()
  {
    return this.jdField_a_of_type_Arfz.c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Arfz.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Arfz.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arec
 * JD-Core Version:    0.7.0.1
 */