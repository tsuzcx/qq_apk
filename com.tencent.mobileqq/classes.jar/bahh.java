import android.graphics.Bitmap;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bahh
  implements bbst
{
  private WeakReference<bahb> a;
  
  public bahh(bahb parambahb)
  {
    this.a = new WeakReference(parambahb);
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileContentSignComponent", 2, String.format("onGetIcon actionId=%s size=%s icon=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramBitmap }));
    }
    if (paramBitmap != null)
    {
      paramBitmap = (bahb)this.a.get();
      if ((paramBitmap != null) && (bahb.f(paramBitmap) != null))
      {
        RichStatus localRichStatus = ((azxr)bahb.g(paramBitmap)).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
        if ((localRichStatus != null) && (localRichStatus.actionId == paramInt1)) {
          bahb.a(paramBitmap, ((azxr)bahb.h(paramBitmap)).jdField_a_of_type_ComTencentMobileqqDataCard, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahh
 * JD-Core Version:    0.7.0.1
 */