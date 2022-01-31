import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.RegionDrawableData;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.mobileqq.gallery.view.GalleryBaseAdapter;
import com.tencent.mobileqq.gallery.view.GalleryUrlImageView;

public class apud
  extends GalleryBaseAdapter
  implements agdg, apsl
{
  public Context a;
  public apte a;
  
  public apud(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private boolean a(RelativeLayout paramRelativeLayout)
  {
    if (paramRelativeLayout == null) {}
    for (;;)
    {
      return false;
      RelativeLayout localRelativeLayout = this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.a();
      int i = localRelativeLayout.getChildCount() - 1;
      while (i >= 0)
      {
        if (paramRelativeLayout == localRelativeLayout.getChildAt(i)) {
          return true;
        }
        i -= 1;
      }
    }
  }
  
  public apsr a(int paramInt)
  {
    if ((this.jdField_a_of_type_Apte == null) || (this.jdField_a_of_type_Apte.jdField_a_of_type_Apss == null)) {
      return null;
    }
    return this.jdField_a_of_type_Apte.jdField_a_of_type_Apss.a(paramInt);
  }
  
  public apue a()
  {
    AIOGalleryBasePresenter localAIOGalleryBasePresenter = a(this.jdField_a_of_type_Apte.a());
    if (localAIOGalleryBasePresenter != null) {
      return localAIOGalleryBasePresenter.a;
    }
    return null;
  }
  
  public AIOGalleryBasePresenter a(int paramInt)
  {
    paramInt = getItemViewType(paramInt);
    return this.jdField_a_of_type_Apte.a(paramInt);
  }
  
  public void a(int paramInt)
  {
    apsm.a().a().a(" AIOGalleryAdapter", 4, "onItemSelected position =" + paramInt);
    int i = getItemViewType(this.jdField_a_of_type_Apte.a());
    paramInt = getItemViewType(paramInt);
    if (i != paramInt)
    {
      localAIOGalleryBasePresenter = this.jdField_a_of_type_Apte.a(i);
      if ((localAIOGalleryBasePresenter != null) && (localAIOGalleryBasePresenter.a != null) && (a(localAIOGalleryBasePresenter.a.b))) {
        this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.a().removeView(localAIOGalleryBasePresenter.a.b);
      }
    }
    AIOGalleryBasePresenter localAIOGalleryBasePresenter = this.jdField_a_of_type_Apte.a(paramInt);
    if ((localAIOGalleryBasePresenter != null) && (localAIOGalleryBasePresenter.a != null) && (!a(localAIOGalleryBasePresenter.a.b)))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.a().addView(localAIOGalleryBasePresenter.a.b, localLayoutParams);
    }
  }
  
  public void a(apte paramapte)
  {
    super.a(paramapte);
    this.jdField_a_of_type_Apte = paramapte;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Apte.o();
    return true;
  }
  
  public boolean a(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Apte != null)
    {
      if (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null) {
        this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.c(false);
      }
      if (this.jdField_a_of_type_Apte.a() != null)
      {
        this.jdField_a_of_type_Apte.a().d();
        this.jdField_a_of_type_Apte.a().c();
      }
    }
    this.jdField_a_of_type_Apte.p();
    return true;
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apss != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apss.a();
    }
    return super.getCount();
  }
  
  public int getItemViewType(int paramInt)
  {
    apsr localapsr = a(paramInt);
    if ((localapsr != null) && (localapsr.a != null)) {
      return localapsr.a.a();
    }
    return super.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = a(paramInt);
    GalleryUrlImageView localGalleryUrlImageView = new GalleryUrlImageView(this.jdField_a_of_type_AndroidContentContext);
    if ((localObject == null) || (((apsr)localObject).a == null) || (this.jdField_a_of_type_Apte == null))
    {
      apsm.a().a().c(" AIOGalleryAdapter", 2, " getView(): position=" + paramInt + " data is null");
      return localGalleryUrlImageView;
    }
    int i = ((apsr)localObject).a.a();
    if (this.jdField_a_of_type_Apte.a(i) == null) {
      this.jdField_a_of_type_Apte.b(i);
    }
    localObject = this.jdField_a_of_type_Apte.a(i);
    if (localObject != null)
    {
      localObject = ((AIOGalleryBasePresenter)localObject).a;
      if (localObject != null)
      {
        paramView = ((apue)localObject).a(paramInt, paramView, paramViewGroup);
        if ((paramView != null) && ((paramView.getTag() instanceof apum))) {
          ((apue)localObject).a((apum)paramView.getTag());
        }
        return paramView;
      }
      apsm.a().a().c(" AIOGalleryAdapter", 2, "getView() aioGalleryBaseView is null");
      return localGalleryUrlImageView;
    }
    apsm.a().a().c(" AIOGalleryAdapter", 2, "getView() presenter is null");
    return localGalleryUrlImageView;
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    apsm.a().a().a(" AIOGalleryAdapter", 4, "onCreateView position =" + paramInt);
    paramView = a(paramInt);
    if (paramView != null)
    {
      paramViewGroup = a(paramInt);
      if ((paramViewGroup != null) && (paramViewGroup.a != null)) {
        paramViewGroup.a.a(paramInt, paramView);
      }
    }
    return null;
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    apsm.a().a().a(" AIOGalleryAdapter", 4, "onDestroyView position =" + paramInt);
    AIOGalleryBasePresenter localAIOGalleryBasePresenter = a(paramInt);
    if ((localAIOGalleryBasePresenter != null) && (localAIOGalleryBasePresenter.a != null)) {
      localAIOGalleryBasePresenter.a.a(paramInt, paramView, paramViewGroup);
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    AIOGalleryBasePresenter localAIOGalleryBasePresenter = a(paramInt);
    if ((localAIOGalleryBasePresenter != null) && (localAIOGalleryBasePresenter.a != null)) {
      localAIOGalleryBasePresenter.a.a(paramInt, paramView, paramRegionDrawableData);
    }
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    apsm.a().a().b(" AIOGalleryAdapter", 2, "onSlot(): position = " + paramInt);
    System.gc();
  }
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    apsm.a().a().b(" AIOGalleryAdapter", 2, "onViewDetached position = " + paramInt);
    paramViewGroup = a(paramInt);
    if ((paramViewGroup != null) && (paramViewGroup.a != null))
    {
      apsr localapsr = a(paramInt);
      paramViewGroup.a.a(paramInt, paramView, localapsr);
    }
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AIOGalleryBasePresenter localAIOGalleryBasePresenter = a(paramInt);
    if ((localAIOGalleryBasePresenter != null) && (localAIOGalleryBasePresenter.a != null)) {
      localAIOGalleryBasePresenter.a.b(paramInt, paramView, paramViewGroup);
    }
    paramView = a(paramInt);
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_Apte.a().c(paramView.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apud
 * JD-Core Version:    0.7.0.1
 */