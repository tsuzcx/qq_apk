import android.graphics.Bitmap;
import android.graphics.Canvas;

class bqfq
{
  int jdField_a_of_type_Int;
  bqbr jdField_a_of_type_Bqbr;
  bqbs jdField_a_of_type_Bqbs;
  yoc jdField_a_of_type_Yoc;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public bqfq(bqfm parambqfm)
  {
    this.jdField_a_of_type_Int = agej.a(15.0F, parambqfm.a());
    this.b = agej.a(12.0F, parambqfm.a());
    this.c = agej.a(2.0F, parambqfm.a());
    this.d = ((brkm.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Yoc = new yoc(agej.a(3.0F, parambqfm.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Bqbr = ((bqbr)parambqfm.a(bqbr.class));
    this.jdField_a_of_type_Bqbs = ((bqbs)parambqfm.a(bqbs.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Bqbr != null) {
      if (this.jdField_a_of_type_Bqbr.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bqbs != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Bqbs.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Bqbr.a(paramInt, false);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Bqbs != null) {
            this.jdField_a_of_type_Bqbs.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = zoc.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Bqbr.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Yoc.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(bqix parambqix, bqfr parambqfr)
  {
    Bitmap localBitmap = zoc.a(parambqix.c, this.e, this.f, false);
    parambqix = null;
    if (localBitmap != null) {
      parambqix = this.jdField_a_of_type_Yoc.a(localBitmap);
    }
    parambqfr.b = parambqix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqfq
 * JD-Core Version:    0.7.0.1
 */