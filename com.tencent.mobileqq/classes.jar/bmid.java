import android.graphics.Bitmap;
import android.graphics.Canvas;

class bmid
{
  int jdField_a_of_type_Int;
  bmee jdField_a_of_type_Bmee;
  bmef jdField_a_of_type_Bmef;
  wmn jdField_a_of_type_Wmn;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public bmid(bmhz parambmhz)
  {
    this.jdField_a_of_type_Int = aekt.a(15.0F, parambmhz.a());
    this.b = aekt.a(12.0F, parambmhz.a());
    this.c = aekt.a(2.0F, parambmhz.a());
    this.d = ((bnoa.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Wmn = new wmn(aekt.a(3.0F, parambmhz.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Bmee = ((bmee)parambmhz.a(bmee.class));
    this.jdField_a_of_type_Bmef = ((bmef)parambmhz.a(bmef.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Bmee != null) {
      if (this.jdField_a_of_type_Bmee.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bmef != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Bmef.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Bmee.a(paramInt, false);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Bmef != null) {
            this.jdField_a_of_type_Bmef.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = xmn.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Bmee.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Wmn.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(bmlk parambmlk, bmie parambmie)
  {
    Bitmap localBitmap = xmn.a(parambmlk.c, this.e, this.f, false);
    parambmlk = null;
    if (localBitmap != null) {
      parambmlk = this.jdField_a_of_type_Wmn.a(localBitmap);
    }
    parambmie.b = parambmlk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmid
 * JD-Core Version:    0.7.0.1
 */