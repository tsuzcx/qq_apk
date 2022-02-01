import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;

public class arra
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final arsx jdField_a_of_type_Arsx = new arsx();
  
  public int a()
  {
    return this.jdField_a_of_type_Arsx.a();
  }
  
  public Bitmap a(arrl paramarrl, arru paramarru)
  {
    if (paramarrl == null) {
      throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
    }
    try
    {
      if (paramarrl.f())
      {
        Object localObject2 = paramarrl.a();
        Object localObject1;
        if (localObject2 == null) {
          localObject1 = this.jdField_a_of_type_Arsx.a((int)paramarrl.f(), (int)paramarrl.g());
        }
        for (;;)
        {
          paramarrl.a((Bitmap)localObject1);
          if (localObject1 != null) {
            break;
          }
          return null;
          if (((Bitmap)localObject2).getWidth() >= (int)paramarrl.f())
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() >= (int)paramarrl.g()) {}
          }
          else
          {
            this.jdField_a_of_type_Arsx.a((Bitmap)localObject2);
            localObject1 = this.jdField_a_of_type_Arsx.a((int)paramarrl.f(), (int)paramarrl.g());
          }
        }
        localObject2 = paramarrl.a();
        if (localObject2 == null)
        {
          localObject2 = new Canvas((Bitmap)localObject1);
          paramarrl.a((Canvas)localObject2);
        }
        for (;;)
        {
          ((Bitmap)localObject1).eraseColor(0);
          paramarrl.c(false);
          paramarru.a(paramarrl).a((Canvas)localObject2, paramarrl, paramarru, arru.a().g(), arru.a().c());
          return localObject1;
          ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
        }
      }
      paramarrl = paramarrl.a();
    }
    finally {}
    return paramarrl;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (artl.b())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Arsx.a(paramBitmap);
  }
  
  public void a(arrl paramarrl, arru paramarru) {}
  
  public int b()
  {
    return this.jdField_a_of_type_Arsx.c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Arsx.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Arsx.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arra
 * JD-Core Version:    0.7.0.1
 */