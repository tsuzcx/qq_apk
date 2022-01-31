import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import java.lang.ref.WeakReference;

public class bclk
  extends AsyncTask<Boolean, Void, Bitmap>
{
  private WeakReference<RollangleImageView> a;
  
  public bclk(RollangleImageView paramRollangleImageView)
  {
    this.a = new WeakReference(paramRollangleImageView);
  }
  
  protected Bitmap a(Boolean... paramVarArgs)
  {
    RollangleImageView localRollangleImageView = (RollangleImageView)this.a.get();
    if (localRollangleImageView != null) {
      return RollangleImageView.a(localRollangleImageView, paramVarArgs[0].booleanValue());
    }
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    RollangleImageView localRollangleImageView = (RollangleImageView)this.a.get();
    if (localRollangleImageView != null)
    {
      if (paramBitmap != null) {
        localRollangleImageView.setImageBitmap(paramBitmap);
      }
    }
    else {
      return;
    }
    localRollangleImageView.setImageResource(arrr.b(localRollangleImageView.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclk
 * JD-Core Version:    0.7.0.1
 */