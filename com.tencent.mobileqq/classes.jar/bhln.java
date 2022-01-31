import android.graphics.Bitmap;
import android.graphics.Matrix;

class bhln
  implements bhlh
{
  bhln(bhlm parambhlm, bhlh parambhlh, boolean paramBoolean) {}
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Bhlh != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label90;
      }
      if (paramBitmap != null)
      {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Object localObject = new Matrix();
        ((Matrix)localObject).setScale(0.5F, 0.5F);
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
        this.jdField_a_of_type_Bhlh.a((Bitmap)localObject);
        bhlm.a(this.jdField_a_of_type_Bhlm, paramBitmap);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Bhlh.a(paramBitmap);
    return;
    label90:
    this.jdField_a_of_type_Bhlh.a(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhln
 * JD-Core Version:    0.7.0.1
 */