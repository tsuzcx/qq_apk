import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class bdhz
  extends URLDrawableParams
{
  private ProtocolDownloader a;
  
  public bdhz(MobileQQ paramMobileQQ)
  {
    super(paramMobileQQ);
  }
  
  public ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    if ((("http".equals(paramString)) || ("https".equals(paramString))) && (this.a == null)) {
      this.a = new beuf();
    }
    return this.a;
  }
  
  public String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  public ApngSoLoader getApngSoLoader()
  {
    return bhzi.a();
  }
  
  public Drawable getDefaultLoadingDrawable()
  {
    return BaseApplicationImpl.getContext().getResources().getDrawable(2130847845);
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    return BaseApplicationImpl.getContext().getResources().getDrawable(2130847845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhz
 * JD-Core Version:    0.7.0.1
 */