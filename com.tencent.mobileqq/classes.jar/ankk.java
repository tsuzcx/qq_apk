import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class ankk
  implements ArkAppCacheMgr.OnGetAppIcon
{
  ankk(ankj paramankj) {}
  
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
 * Qualified Name:     ankk
 * JD-Core Version:    0.7.0.1
 */