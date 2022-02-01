import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;

public class artr
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final arvo jdField_a_of_type_Arvo = new arvo();
  
  public int a()
  {
    return this.jdField_a_of_type_Arvo.a();
  }
  
  public Bitmap a(aruc paramaruc, arul paramarul)
  {
    if (paramaruc == null) {
      throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
    }
    try
    {
      if (paramaruc.f())
      {
        Object localObject2 = paramaruc.a();
        Object localObject1;
        if (localObject2 == null) {
          localObject1 = this.jdField_a_of_type_Arvo.a((int)paramaruc.f(), (int)paramaruc.g());
        }
        for (;;)
        {
          paramaruc.a((Bitmap)localObject1);
          if (localObject1 != null) {
            break;
          }
          return null;
          if (((Bitmap)localObject2).getWidth() >= (int)paramaruc.f())
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() >= (int)paramaruc.g()) {}
          }
          else
          {
            this.jdField_a_of_type_Arvo.a((Bitmap)localObject2);
            localObject1 = this.jdField_a_of_type_Arvo.a((int)paramaruc.f(), (int)paramaruc.g());
          }
        }
        localObject2 = paramaruc.a();
        if (localObject2 == null)
        {
          localObject2 = new Canvas((Bitmap)localObject1);
          paramaruc.a((Canvas)localObject2);
        }
        for (;;)
        {
          ((Bitmap)localObject1).eraseColor(0);
          paramaruc.c(false);
          paramarul.a(paramaruc).a((Canvas)localObject2, paramaruc, paramarul, arul.a().g(), arul.a().c());
          return localObject1;
          ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
        }
      }
      paramaruc = paramaruc.a();
    }
    finally {}
    return paramaruc;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (arwc.a())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Arvo.a(paramBitmap);
  }
  
  public void a(aruc paramaruc, arul paramarul) {}
  
  public int b()
  {
    return this.jdField_a_of_type_Arvo.c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Arvo.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Arvo.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artr
 * JD-Core Version:    0.7.0.1
 */