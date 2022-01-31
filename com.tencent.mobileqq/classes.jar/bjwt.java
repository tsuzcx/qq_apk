import android.graphics.Bitmap;
import android.graphics.Canvas;

class bjwt
{
  int jdField_a_of_type_Int;
  bjsu jdField_a_of_type_Bjsu;
  bjsv jdField_a_of_type_Bjsv;
  uxv jdField_a_of_type_Uxv;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public bjwt(bjwp parambjwp)
  {
    this.jdField_a_of_type_Int = actj.a(15.0F, parambjwp.a());
    this.b = actj.a(12.0F, parambjwp.a());
    this.c = actj.a(2.0F, parambjwp.a());
    this.d = ((blcq.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Uxv = new uxv(actj.a(3.0F, parambjwp.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Bjsu = ((bjsu)parambjwp.a(bjsu.class));
    this.jdField_a_of_type_Bjsv = ((bjsv)parambjwp.a(bjsv.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Bjsu != null) {
      if (this.jdField_a_of_type_Bjsu.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bjsv != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Bjsv.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Bjsu.a(paramInt, false);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Bjsv != null) {
            this.jdField_a_of_type_Bjsv.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = vxv.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Bjsu.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Uxv.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(bkaa parambkaa, bjwu parambjwu)
  {
    Bitmap localBitmap = vxv.a(parambkaa.c, this.e, this.f, false);
    parambkaa = null;
    if (localBitmap != null) {
      parambkaa = this.jdField_a_of_type_Uxv.a(localBitmap);
    }
    parambjwu.b = parambkaa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjwt
 * JD-Core Version:    0.7.0.1
 */