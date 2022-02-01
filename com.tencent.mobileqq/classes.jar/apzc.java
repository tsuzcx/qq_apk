import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class apzc
  implements ArkAppCacheMgr.OnGetAppIcon
{
  apzc(apzb paramapzb, apzf paramapzf) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_Apzf.b.setVisibility(0);
      this.jdField_a_of_type_Apzf.a.setVisibility(0);
      this.jdField_a_of_type_Apzf.a.setImageBitmap(paramBitmap);
      return;
    }
    this.jdField_a_of_type_Apzf.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzc
 * JD-Core Version:    0.7.0.1
 */