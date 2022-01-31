import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.gallery.animation.AnimationView;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import java.util.ArrayList;
import java.util.Iterator;

public class apsd
  extends apsb
{
  int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  apsw jdField_a_of_type_Apsw;
  AnimationView jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView;
  View b;
  View c;
  
  public apsd(Activity paramActivity, apsw paramapsw)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Apsw = paramapsw;
    this.jdField_a_of_type_Int = paramActivity.getResources().getDisplayMetrics().densityDpi;
  }
  
  private Drawable a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, apsv paramapsv, boolean paramBoolean)
  {
    if (paramapsv == null) {
      return null;
    }
    Drawable localDrawable = paramapsv.a();
    paramRect1 = paramapsv.a();
    if ((paramRect1 == null) || (localDrawable == null) || (!paramapsv.a(paramBoolean))) {
      return null;
    }
    int i = this.jdField_a_of_type_AndroidViewView.getWidth();
    int j = this.jdField_a_of_type_AndroidViewView.getHeight();
    int k = localDrawable.getIntrinsicWidth();
    int m = localDrawable.getIntrinsicHeight();
    paramRect2.set(0, 0, k, m);
    paramRect3.set(paramRect1);
    paramRect1 = null;
    if ((paramapsv instanceof apsr)) {
      paramRect1 = ((apsr)paramapsv).a;
    }
    if ((!befo.e()) && ((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable)))
    {
      paramRect2 = paramRect1;
      if (((GalleryBaseData)paramRect1).a() == 1) {
        paramRect2 = aptt.a((AIOPicData)paramRect1);
      }
      paramRect3 = apse.a(k, m, i, j, false, paramRect2);
      paramRect1 = paramRect2;
    }
    for (paramRect2 = paramRect3;; paramRect2 = null)
    {
      if (paramRect2 == null)
      {
        paramRect2 = paramRect1;
        if (((GalleryBaseData)paramRect1).a() == 1) {
          paramRect2 = aptt.a((AIOPicData)paramRect1);
        }
      }
      for (paramRect1 = apse.a(k, m, i, j, paramRect2);; paramRect1 = paramRect2)
      {
        paramRect4.set(paramRect1);
        return localDrawable;
      }
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((apsc)localIterator.next()).b();
    }
  }
  
  public boolean b()
  {
    boolean bool = true;
    if (a()) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      f();
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    apsv localapsv = this.jdField_a_of_type_Apsw.a();
    if (localapsv == null) {
      return false;
    }
    Rect localRect3 = localapsv.b();
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(null, localRect4, localRect1, localRect2, localapsv, true);
    this.jdField_a_of_type_Boolean = true;
    if (localDrawable != null)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label126;
      }
      this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.setVisibility(4);
    }
    for (;;)
    {
      return this.jdField_b_of_type_Boolean;
      bool = false;
      break;
      label126:
      this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.jdField_a_of_type_Boolean = localapsv.d;
      if (localRect3 == null) {
        this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.a(localDrawable, localRect1, localRect2, localapsv.a(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.a(localDrawable, localRect3, localRect4, localRect1, localRect2, this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.setVisibility(4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((apsc)localIterator.next()).c();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public boolean c()
  {
    if (a()) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      f();
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    apsv localapsv = this.jdField_a_of_type_Apsw.a();
    Rect localRect3;
    Rect localRect4;
    Drawable localDrawable;
    boolean bool;
    if (localapsv != null)
    {
      localRect3 = localapsv.b();
      localRect4 = new Rect();
      localDrawable = a(localRect3, localRect4, localRect1, localRect2, localapsv, false);
      this.jdField_a_of_type_Boolean = true;
      if (localDrawable == null) {
        break label122;
      }
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label127;
      }
      this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.setVisibility(4);
    }
    for (;;)
    {
      return this.jdField_b_of_type_Boolean;
      return false;
      label122:
      bool = false;
      break;
      label127:
      this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.jdField_a_of_type_Boolean = localapsv.d;
      this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.a(localDrawable, localRect1, localRect2, localapsv.a(), localapsv.b(), localapsv.c(), this.jdField_a_of_type_Long);
      if (localRect3 == null) {
        this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.a(localDrawable, localRect1, localRect2, localapsv.a(), localapsv.b(), localapsv.c(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.b(localDrawable, localRect3, localRect4, localRect1, localRect2, this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((apsc)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.setVisibility(4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((apsc)localIterator.next()).e();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131301286);
    this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView = ((AnimationView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297010));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131309736);
    this.c = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apsd
 * JD-Core Version:    0.7.0.1
 */