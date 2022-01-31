import android.graphics.Bitmap;
import android.graphics.Canvas;

class bjwc
{
  int jdField_a_of_type_Int;
  bjsd jdField_a_of_type_Bjsd;
  bjse jdField_a_of_type_Bjse;
  uxy jdField_a_of_type_Uxy;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public bjwc(bjvy parambjvy)
  {
    this.jdField_a_of_type_Int = actn.a(15.0F, parambjvy.a());
    this.b = actn.a(12.0F, parambjvy.a());
    this.c = actn.a(2.0F, parambjvy.a());
    this.d = ((blbz.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Uxy = new uxy(actn.a(3.0F, parambjvy.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Bjsd = ((bjsd)parambjvy.a(bjsd.class));
    this.jdField_a_of_type_Bjse = ((bjse)parambjvy.a(bjse.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Bjsd != null) {
      if (this.jdField_a_of_type_Bjsd.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bjse != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Bjse.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Bjsd.a(paramInt, false);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Bjse != null) {
            this.jdField_a_of_type_Bjse.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = vxy.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Bjsd.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Uxy.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(bjzj parambjzj, bjwd parambjwd)
  {
    Bitmap localBitmap = vxy.a(parambjzj.c, this.e, this.f, false);
    parambjzj = null;
    if (localBitmap != null) {
      parambjzj = this.jdField_a_of_type_Uxy.a(localBitmap);
    }
    parambjwd.b = parambjzj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjwc
 * JD-Core Version:    0.7.0.1
 */