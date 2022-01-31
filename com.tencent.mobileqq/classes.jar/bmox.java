import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.io.File;

public class bmox
  implements blof
{
  public bmox(DoodleEditView paramDoodleEditView) {}
  
  private void c(bmnf parambmnf, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    if (!this.a.jdField_a_of_type_Bmmi.b()) {
      return;
    }
    paramSegmentKeeper = bmtv.a(parambmnf, paramFloat1, paramFloat2, paramFloat3);
    parambmnf = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bmmi.a(), parambmnf.jdField_a_of_type_JavaLangString, parambmnf.b, parambmnf.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramSegmentKeeper, paramString, parambmnf.jdField_a_of_type_Int, false, null, null, this.a.a());
    this.a.jdField_a_of_type_Bmmi.c(parambmnf);
    this.a.postInvalidate();
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_Bmmi.c();
  }
  
  public void a(bmnf parambmnf, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambmnf, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
  
  public void a(bmrn parambmrn, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((!this.a.jdField_a_of_type_Bmmi.b()) || (parambmrn == null)) {
      return;
    }
    Object localObject1 = null;
    wsv.b("DoodleEditView", "addLocationFaceItem:" + parambmrn.toString());
    boolean bool = this.a.getContext() instanceof EditPicActivity;
    label70:
    Object localObject2;
    label120:
    float f1;
    float f2;
    if (bool)
    {
      parambmrn.d = 0;
      localObject2 = bmro.a(parambmrn, this.a.getContext(), -1L);
      if (!bool) {
        break label592;
      }
      if (localObject2 != null) {
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), ((bmth)localObject2).a());
      }
      if (localObject1 == null) {
        break label597;
      }
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "[" + ((Drawable)localObject1).getIntrinsicWidth() + "," + ((Drawable)localObject1).getIntrinsicHeight() + "]");
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "x:" + paramFloat1);
      }
      if (!(this.a.jdField_a_of_type_Bmmi.a instanceof bmly)) {
        break label665;
      }
      localObject2 = (bmly)this.a.jdField_a_of_type_Bmmi.a;
      if (((bmly)localObject2).q > 4.0D) {
        ((bmly)localObject2).q = 1.0F;
      }
      f1 = ((bmly)localObject2).b.x;
      f2 = ((bmly)localObject2).q * ((Drawable)localObject1).getIntrinsicWidth() / 2.0F;
      f1 = ((bmly)localObject2).s + (f1 - f2);
      f2 = ((bmly)localObject2).b.x;
      if (f1 >= bnoa.a(23.0F)) {
        break label662;
      }
      f2 = ((bmly)localObject2).b.x - f1 + bnoa.a(23.0F);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "startX:" + f1 + "x:" + paramFloat1);
      }
      localObject2 = new bmmc(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (TextUtils.isEmpty(paramString)) {
        paramString = parambmrn.b;
      }
      for (;;)
      {
        if ((localObject1 instanceof bmth)) {}
        for (parambmrn = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bmmi.a(), parambmrn.m, paramString, (Drawable)localObject1, (bmmc)localObject2, "", parambmrn.d, parambmrn.a, parambmrn.l, ((bmth)localObject1).c(), this.a.a());; parambmrn = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bmmi.a(), parambmrn.m, paramString, (Drawable)localObject1, (bmmc)localObject2, "", parambmrn.d, false, parambmrn.l, null, this.a.a()))
        {
          if (((parambmrn instanceof bmly)) && ((this.a.jdField_a_of_type_Bmmi.a instanceof bmly))) {
            ((bmly)parambmrn).g = ((bmly)this.a.jdField_a_of_type_Bmmi.a).g;
          }
          this.a.jdField_a_of_type_Bmmi.c(parambmrn);
          parambmrn.b.x = f2;
          this.a.postInvalidate();
          return;
          parambmrn.d = 3;
          break label70;
          label592:
          localObject1 = localObject2;
          break label120;
          label597:
          break;
          parambmrn.d = 0;
        }
      }
      label662:
      continue;
      label665:
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void a(bmrr parambmrr, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.a.jdField_a_of_type_Bmmi.b()) {
      return;
    }
    bmmc localbmmc = bmtv.a(parambmrr, this.a.getWidth(), this.a.getHeight(), paramFloat1, paramFloat2);
    if (localbmmc != null) {
      if ((parambmrr.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((parambmrr.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)))
      {
        File localFile = ((URLDrawable)parambmrr.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile != null) && (localFile.exists()))
        {
          parambmrr = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bmmi.a(), parambmrr.g, parambmrr.c, parambmrr.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbmmc, localFile.getAbsolutePath(), parambmrr.jdField_a_of_type_Int, false, null, null, this.a.a());
          this.a.jdField_a_of_type_Bmmi.c(parambmrr);
        }
      }
    }
    for (;;)
    {
      this.a.postInvalidate();
      return;
      wsv.e("DoodleEditView", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(bmrr parambmrr, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(bmnf parambmnf, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambmnf, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmox
 * JD-Core Version:    0.7.0.1
 */