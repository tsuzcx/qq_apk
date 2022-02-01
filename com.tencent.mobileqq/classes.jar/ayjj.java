import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.util.VersionUtils;

public class ayjj
  extends abkd
{
  private abjt b;
  
  public ayjj(Activity paramActivity, abjt paramabjt)
  {
    super(paramActivity, paramabjt);
    this.jdField_b_of_type_Abjt = paramabjt;
  }
  
  private Drawable a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, abkf paramabkf, boolean paramBoolean)
  {
    if (paramabkf == null) {}
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = paramabkf.c();
      paramRect1 = paramabkf.b();
    } while ((paramRect1 == null) || (localDrawable == null) || (!paramabkf.a(paramBoolean)));
    int i = this.jdField_a_of_type_AndroidViewView.getWidth();
    int j = this.jdField_a_of_type_AndroidViewView.getHeight();
    int k = localDrawable.getIntrinsicWidth();
    int m = localDrawable.getIntrinsicHeight();
    paramRect2.set(0, 0, k, m);
    paramRect3.set(paramRect1);
    if ((paramabkf instanceof aidw)) {}
    for (paramRect2 = ((aidw)paramabkf).a;; paramRect2 = null)
    {
      if ((!VersionUtils.isHoneycomb()) && ((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable))) {}
      for (paramRect1 = abke.a(k, m, i, j, false, paramRect2);; paramRect1 = null)
      {
        if (paramRect1 == null) {
          paramRect1 = abke.a(k, m, i, j, paramRect2);
        }
        for (;;)
        {
          paramRect4.set(paramRect1);
          return localDrawable;
        }
      }
    }
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (a()) {
      bool1 = true;
    }
    Rect localRect1;
    Rect localRect2;
    abkf localabkf;
    Rect localRect3;
    Rect localRect4;
    Drawable localDrawable;
    do
    {
      do
      {
        do
        {
          return bool1;
          if (this.jdField_a_of_type_AndroidViewView == null) {
            b();
          }
          localRect1 = new Rect();
          localRect2 = new Rect();
          localabkf = this.jdField_b_of_type_Abjt.a();
          bool1 = bool3;
        } while (localabkf == null);
        localRect3 = localabkf.a();
        localRect4 = new Rect();
        localDrawable = a(null, localRect4, localRect1, localRect2, localabkf, true);
        bool1 = bool3;
      } while (localRect4.right == -1);
      bool1 = bool3;
    } while (localRect4.bottom == -1);
    this.jdField_a_of_type_Boolean = true;
    if (localDrawable != null)
    {
      bool1 = bool2;
      this.jdField_b_of_type_Boolean = bool1;
      if (this.jdField_b_of_type_Boolean) {
        break label158;
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    }
    for (;;)
    {
      return this.jdField_b_of_type_Boolean;
      bool1 = false;
      break;
      label158:
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.jdField_a_of_type_Boolean = localabkf.c;
      if (localRect3 == null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect1, localRect2, localabkf.a(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect3, localRect4, localRect1, localRect2, this.jdField_a_of_type_Long);
      }
    }
  }
  
  public boolean c()
  {
    if (a()) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      b();
    }
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    abkf localabkf = this.jdField_b_of_type_Abjt.a();
    Rect localRect1 = null;
    if (localabkf != null) {
      localRect1 = localabkf.a();
    }
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(localRect1, localRect4, localRect2, localRect3, localabkf, false);
    if ((localRect4.right == -1) || (localRect4.bottom == -1)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    boolean bool;
    if (localDrawable != null)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label147;
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    }
    for (;;)
    {
      return this.jdField_b_of_type_Boolean;
      bool = false;
      break;
      label147:
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.jdField_a_of_type_Boolean = localabkf.c;
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect2, localRect3, localabkf.a(), localabkf.c(), localabkf.d(), this.jdField_a_of_type_Long);
      if (localRect1 == null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect2, localRect3, localabkf.a(), localabkf.c(), localabkf.d(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.b(localDrawable, localRect1, localRect4, localRect2, localRect3, this.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjj
 * JD-Core Version:    0.7.0.1
 */