import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;

public class asrq
  extends xgw
{
  private xgm b;
  
  public asrq(Activity paramActivity, xgm paramxgm)
  {
    super(paramActivity, paramxgm);
    this.jdField_b_of_type_Xgm = paramxgm;
  }
  
  private Drawable a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, xgy paramxgy, boolean paramBoolean)
  {
    if (paramxgy == null) {}
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = paramxgy.c();
      paramRect1 = paramxgy.b();
    } while ((paramRect1 == null) || (localDrawable == null) || (!paramxgy.a(paramBoolean)));
    int i = this.jdField_a_of_type_AndroidViewView.getWidth();
    int j = this.jdField_a_of_type_AndroidViewView.getHeight();
    int k = localDrawable.getIntrinsicWidth();
    int m = localDrawable.getIntrinsicHeight();
    paramRect2.set(0, 0, k, m);
    paramRect3.set(paramRect1);
    if ((paramxgy instanceof adyb)) {}
    for (paramRect2 = ((adyb)paramxgy).a;; paramRect2 = null)
    {
      if ((!befo.e()) && ((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable))) {}
      for (paramRect1 = xgx.a(k, m, i, j, false, paramRect2);; paramRect1 = null)
      {
        if (paramRect1 == null) {
          paramRect1 = xgx.a(k, m, i, j, paramRect2);
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
    xgy localxgy;
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
            f();
          }
          localRect1 = new Rect();
          localRect2 = new Rect();
          localxgy = this.jdField_b_of_type_Xgm.a();
          bool1 = bool3;
        } while (localxgy == null);
        localRect3 = localxgy.a();
        localRect4 = new Rect();
        localDrawable = a(null, localRect4, localRect1, localRect2, localxgy, true);
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
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.jdField_a_of_type_Boolean = localxgy.c;
      if (localRect3 == null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect1, localRect2, localxgy.a(), this.jdField_a_of_type_Long);
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
      f();
    }
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    xgy localxgy = this.jdField_b_of_type_Xgm.a();
    Rect localRect1 = null;
    if (localxgy != null) {
      localRect1 = localxgy.a();
    }
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(localRect1, localRect4, localRect2, localRect3, localxgy, false);
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
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.jdField_a_of_type_Boolean = localxgy.c;
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect2, localRect3, localxgy.a(), localxgy.c(), localxgy.d(), this.jdField_a_of_type_Long);
      if (localRect1 == null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect2, localRect3, localxgy.a(), localxgy.c(), localxgy.d(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.b(localDrawable, localRect1, localRect4, localRect2, localRect3, this.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asrq
 * JD-Core Version:    0.7.0.1
 */