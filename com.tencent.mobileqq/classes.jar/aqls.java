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

public class aqls
  extends aqlq
{
  int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  aqml jdField_a_of_type_Aqml;
  AnimationView jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView;
  View b;
  View c;
  
  public aqls(Activity paramActivity, aqml paramaqml)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Aqml = paramaqml;
    this.jdField_a_of_type_Int = paramActivity.getResources().getDisplayMetrics().densityDpi;
  }
  
  private Drawable a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, aqmk paramaqmk, boolean paramBoolean)
  {
    if (paramaqmk == null) {
      return null;
    }
    Drawable localDrawable = paramaqmk.a();
    paramRect1 = paramaqmk.a();
    if ((paramRect1 == null) || (localDrawable == null) || (!paramaqmk.a(paramBoolean))) {
      return null;
    }
    int i = this.jdField_a_of_type_AndroidViewView.getWidth();
    int j = this.jdField_a_of_type_AndroidViewView.getHeight();
    int k = localDrawable.getIntrinsicWidth();
    int m = localDrawable.getIntrinsicHeight();
    paramRect2.set(0, 0, k, m);
    paramRect3.set(paramRect1);
    paramRect1 = null;
    if ((paramaqmk instanceof aqmg)) {
      paramRect1 = ((aqmg)paramaqmk).a;
    }
    if ((!bfni.e()) && ((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable)))
    {
      paramRect2 = paramRect1;
      if (((GalleryBaseData)paramRect1).a() == 1) {
        paramRect2 = aqnt.a((AIOPicData)paramRect1);
      }
      paramRect3 = aqlt.a(k, m, i, j, false, paramRect2);
      paramRect1 = paramRect2;
    }
    for (paramRect2 = paramRect3;; paramRect2 = null)
    {
      if (paramRect2 == null)
      {
        paramRect2 = paramRect1;
        if (((GalleryBaseData)paramRect1).a() == 1) {
          paramRect2 = aqnt.a((AIOPicData)paramRect1);
        }
      }
      for (paramRect1 = aqlt.a(k, m, i, j, paramRect2);; paramRect1 = paramRect2)
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
      ((aqlr)localIterator.next()).b();
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
    aqmk localaqmk = this.jdField_a_of_type_Aqml.a();
    if (localaqmk == null) {
      return false;
    }
    Rect localRect3 = localaqmk.b();
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(null, localRect4, localRect1, localRect2, localaqmk, true);
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
      this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.jdField_a_of_type_Boolean = localaqmk.d;
      if (localRect3 == null) {
        this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.a(localDrawable, localRect1, localRect2, localaqmk.a(), this.jdField_a_of_type_Long);
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
      ((aqlr)localIterator.next()).c();
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
    aqmk localaqmk = this.jdField_a_of_type_Aqml.a();
    Rect localRect3;
    Rect localRect4;
    Drawable localDrawable;
    boolean bool;
    if (localaqmk != null)
    {
      localRect3 = localaqmk.b();
      localRect4 = new Rect();
      localDrawable = a(localRect3, localRect4, localRect1, localRect2, localaqmk, false);
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
      this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.jdField_a_of_type_Boolean = localaqmk.d;
      this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.a(localDrawable, localRect1, localRect2, localaqmk.a(), localaqmk.b(), localaqmk.c(), this.jdField_a_of_type_Long);
      if (localRect3 == null) {
        this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.a(localDrawable, localRect1, localRect2, localaqmk.a(), localaqmk.b(), localaqmk.c(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.b(localDrawable, localRect3, localRect4, localRect1, localRect2, this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((aqlr)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView.setVisibility(4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((aqlr)localIterator.next()).e();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131366897);
    this.jdField_a_of_type_ComTencentMobileqqGalleryAnimationAnimationView = ((AnimationView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362549));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131375491);
    this.c = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqls
 * JD-Core Version:    0.7.0.1
 */