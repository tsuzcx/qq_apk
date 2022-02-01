import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class amcx
  extends amdf
{
  public amcx(SpecailCareListActivity paramSpecailCareListActivity)
  {
    super(paramSpecailCareListActivity, null);
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (this.a.d != 0) {
      this.a.b = true;
    }
    while ((paramInt2 != 200) || (paramBitmap == null)) {
      return;
    }
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcx
 * JD-Core Version:    0.7.0.1
 */