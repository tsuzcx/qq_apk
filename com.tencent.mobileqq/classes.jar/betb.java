import android.graphics.Bitmap;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class betb
  implements aybr
{
  final WeakReference<ProfileCardMoreInfoView> a;
  
  public betb(ProfileCardMoreInfoView paramProfileCardMoreInfoView)
  {
    this.a = new WeakReference(paramProfileCardMoreInfoView);
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardMoreInfoView", 2, String.format("onGetIcon actionId=%s size=%s icon=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramBitmap }));
    }
    if (paramBitmap == null) {
      QLog.e("ProfileCardMoreInfoView", 1, "onGetIcon decode icon fail.");
    }
    do
    {
      return;
      paramBitmap = (ProfileCardMoreInfoView)this.a.get();
    } while ((paramBitmap == null) || (paramBitmap.a == null) || (paramBitmap.a.a == null) || (paramBitmap.a.a.actionId != paramInt1));
    paramBitmap.a(paramBitmap.a, true, new String[] { "map_key_sig" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betb
 * JD-Core Version:    0.7.0.1
 */