import android.graphics.Bitmap;
import android.graphics.Canvas;

class bpdv
{
  int jdField_a_of_type_Int;
  bozw jdField_a_of_type_Bozw;
  bozx jdField_a_of_type_Bozx;
  ykh jdField_a_of_type_Ykh;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public bpdv(bpdr parambpdr)
  {
    this.jdField_a_of_type_Int = afur.a(15.0F, parambpdr.a());
    this.b = afur.a(12.0F, parambpdr.a());
    this.c = afur.a(2.0F, parambpdr.a());
    this.d = ((bqja.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Ykh = new ykh(afur.a(3.0F, parambpdr.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Bozw = ((bozw)parambpdr.a(bozw.class));
    this.jdField_a_of_type_Bozx = ((bozx)parambpdr.a(bozx.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Bozw != null) {
      if (this.jdField_a_of_type_Bozw.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bozx != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Bozx.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Bozw.a(paramInt, false);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Bozx != null) {
            this.jdField_a_of_type_Bozx.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = zkh.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Bozw.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Ykh.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(bphc parambphc, bpdw parambpdw)
  {
    Bitmap localBitmap = zkh.a(parambphc.c, this.e, this.f, false);
    parambphc = null;
    if (localBitmap != null) {
      parambphc = this.jdField_a_of_type_Ykh.a(localBitmap);
    }
    parambpdw.b = parambphc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdv
 * JD-Core Version:    0.7.0.1
 */