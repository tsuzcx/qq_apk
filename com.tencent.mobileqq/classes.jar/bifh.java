import android.graphics.Bitmap;
import android.graphics.Canvas;

class bifh
{
  int jdField_a_of_type_Int;
  bibg jdField_a_of_type_Bibg;
  bibh jdField_a_of_type_Bibh;
  ulc jdField_a_of_type_Ulc;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public bifh(bifd parambifd)
  {
    this.jdField_a_of_type_Int = aciy.a(15.0F, parambifd.a());
    this.b = aciy.a(12.0F, parambifd.a());
    this.c = aciy.a(2.0F, parambifd.a());
    this.d = ((bjlo.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Ulc = new ulc(aciy.a(3.0F, parambifd.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Bibg = ((bibg)parambifd.a(bibg.class));
    this.jdField_a_of_type_Bibh = ((bibh)parambifd.a(bibh.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Bibg != null) {
      if (this.jdField_a_of_type_Bibg.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bibh != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Bibh.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Bibg.a(paramInt, false);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Bibh != null) {
            this.jdField_a_of_type_Bibh.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = vlc.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Bibg.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Ulc.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(biio parambiio, bifi parambifi)
  {
    Bitmap localBitmap = vlc.a(parambiio.c, this.e, this.f, false);
    parambiio = null;
    if (localBitmap != null) {
      parambiio = this.jdField_a_of_type_Ulc.a(localBitmap);
    }
    parambifi.b = parambiio;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bifh
 * JD-Core Version:    0.7.0.1
 */