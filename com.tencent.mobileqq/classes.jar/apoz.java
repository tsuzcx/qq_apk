import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class apoz
  implements ArkAppCacheMgr.OnGetAppIcon
{
  apoz(apoy paramapoy) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.a.a.b.setVisibility(0);
      this.a.a.a.setVisibility(0);
      this.a.a.a.setImageBitmap(paramBitmap);
      return;
    }
    this.a.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apoz
 * JD-Core Version:    0.7.0.1
 */