import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;

public class aoww
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final aoyt jdField_a_of_type_Aoyt = new aoyt();
  
  public int a()
  {
    return this.jdField_a_of_type_Aoyt.a();
  }
  
  public Bitmap a(aoxh paramaoxh, aoxq paramaoxq)
  {
    if (paramaoxh == null) {
      throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
    }
    try
    {
      if (paramaoxh.f())
      {
        Object localObject2 = paramaoxh.a();
        Object localObject1;
        if (localObject2 == null) {
          localObject1 = this.jdField_a_of_type_Aoyt.a((int)paramaoxh.f(), (int)paramaoxh.g());
        }
        for (;;)
        {
          paramaoxh.a((Bitmap)localObject1);
          if (localObject1 != null) {
            break;
          }
          return null;
          if (((Bitmap)localObject2).getWidth() >= (int)paramaoxh.f())
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() >= (int)paramaoxh.g()) {}
          }
          else
          {
            this.jdField_a_of_type_Aoyt.a((Bitmap)localObject2);
            localObject1 = this.jdField_a_of_type_Aoyt.a((int)paramaoxh.f(), (int)paramaoxh.g());
          }
        }
        localObject2 = paramaoxh.a();
        if (localObject2 == null)
        {
          localObject2 = new Canvas((Bitmap)localObject1);
          paramaoxh.a((Canvas)localObject2);
        }
        for (;;)
        {
          ((Bitmap)localObject1).eraseColor(0);
          paramaoxh.c(false);
          paramaoxq.a(paramaoxh).a((Canvas)localObject2, paramaoxh, paramaoxq, aoxq.a().g(), aoxq.a().c());
          return localObject1;
          ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
        }
      }
      paramaoxh = paramaoxh.a();
    }
    finally {}
    return paramaoxh;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (aozh.a())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Aoyt.a(paramBitmap);
  }
  
  public void a(aoxh paramaoxh, aoxq paramaoxq) {}
  
  public int b()
  {
    return this.jdField_a_of_type_Aoyt.c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aoyt.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Aoyt.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoww
 * JD-Core Version:    0.7.0.1
 */