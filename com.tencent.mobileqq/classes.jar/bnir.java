import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.TextView;
import dov.com.qq.im.ae.cmshow.AECMShowPhotoPreviewFragment;
import java.util.List;

public class bnir
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  
  public bnir(AECMShowPhotoPreviewFragment paramAECMShowPhotoPreviewFragment) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_Int += 1;
    bnrh.a("AECMShowPhotoPreviewFragment", "[onGlobalLayout] called, invokeCount=" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int >= 2)
    {
      localObject = AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment).getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive())
      {
        if (Build.VERSION.SDK_INT < 16) {
          break label87;
        }
        ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
      }
    }
    while (AECMShowPhotoPreviewFragment.b(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment))
    {
      return;
      label87:
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this);
    }
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment, true);
    Object localObject = AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment, AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment), AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment));
    if ((localObject != null) && (((bolh)localObject).a != null) && (((Boolean)((bolh)localObject).a).booleanValue()))
    {
      AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment, (List)((bolh)localObject).b);
      return;
    }
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment).setEnabled(true);
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment).setText(2131689678);
    AECMShowPhotoPreviewFragment.b(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment).setVisibility(0);
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnir
 * JD-Core Version:    0.7.0.1
 */