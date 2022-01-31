import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class anki
  implements ArkAppCacheMgr.OnGetAppIcon
{
  anki(ankh paramankh, ankl paramankl) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_Ankl.b.setVisibility(0);
      this.jdField_a_of_type_Ankl.a.setVisibility(0);
      this.jdField_a_of_type_Ankl.a.setImageBitmap(paramBitmap);
      return;
    }
    this.jdField_a_of_type_Ankl.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anki
 * JD-Core Version:    0.7.0.1
 */