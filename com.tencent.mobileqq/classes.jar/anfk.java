import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;

public class anfk
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final anhh jdField_a_of_type_Anhh = new anhh();
  
  public int a()
  {
    return this.jdField_a_of_type_Anhh.a();
  }
  
  public Bitmap a(anfv paramanfv, ange paramange)
  {
    if (paramanfv == null) {
      throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
    }
    try
    {
      if (paramanfv.f())
      {
        Object localObject2 = paramanfv.a();
        Object localObject1;
        if (localObject2 == null) {
          localObject1 = this.jdField_a_of_type_Anhh.a((int)paramanfv.f(), (int)paramanfv.g());
        }
        for (;;)
        {
          paramanfv.a((Bitmap)localObject1);
          if (localObject1 != null) {
            break;
          }
          return null;
          if (((Bitmap)localObject2).getWidth() >= (int)paramanfv.f())
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() >= (int)paramanfv.g()) {}
          }
          else
          {
            this.jdField_a_of_type_Anhh.a((Bitmap)localObject2);
            localObject1 = this.jdField_a_of_type_Anhh.a((int)paramanfv.f(), (int)paramanfv.g());
          }
        }
        localObject2 = paramanfv.a();
        if (localObject2 == null)
        {
          localObject2 = new Canvas((Bitmap)localObject1);
          paramanfv.a((Canvas)localObject2);
        }
        for (;;)
        {
          ((Bitmap)localObject1).eraseColor(0);
          paramanfv.c(false);
          paramange.a(paramanfv).a((Canvas)localObject2, paramanfv, paramange, ange.a().g(), ange.a().c());
          return localObject1;
          ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
        }
      }
      paramanfv = paramanfv.a();
    }
    finally {}
    return paramanfv;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (anhv.a())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Anhh.a(paramBitmap);
  }
  
  public void a(anfv paramanfv, ange paramange) {}
  
  public int b()
  {
    return this.jdField_a_of_type_Anhh.c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Anhh.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Anhh.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anfk
 * JD-Core Version:    0.7.0.1
 */