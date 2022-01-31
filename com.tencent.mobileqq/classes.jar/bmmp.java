import android.graphics.Bitmap;
import android.graphics.Canvas;

class bmmp
{
  int jdField_a_of_type_Int;
  bmiq jdField_a_of_type_Bmiq;
  bmir jdField_a_of_type_Bmir;
  wqw jdField_a_of_type_Wqw;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public bmmp(bmml parambmml)
  {
    this.jdField_a_of_type_Int = aepi.a(15.0F, parambmml.a());
    this.b = aepi.a(12.0F, parambmml.a());
    this.c = aepi.a(2.0F, parambmml.a());
    this.d = ((bnsm.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Wqw = new wqw(aepi.a(3.0F, parambmml.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Bmiq = ((bmiq)parambmml.a(bmiq.class));
    this.jdField_a_of_type_Bmir = ((bmir)parambmml.a(bmir.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Bmiq != null) {
      if (this.jdField_a_of_type_Bmiq.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bmir != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Bmir.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Bmiq.a(paramInt, false);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Bmir != null) {
            this.jdField_a_of_type_Bmir.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = xqw.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Bmiq.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Wqw.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(bmpw parambmpw, bmmq parambmmq)
  {
    Bitmap localBitmap = xqw.a(parambmpw.c, this.e, this.f, false);
    parambmpw = null;
    if (localBitmap != null) {
      parambmpw = this.jdField_a_of_type_Wqw.a(localBitmap);
    }
    parambmmq.b = parambmpw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmp
 * JD-Core Version:    0.7.0.1
 */