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

public class bmtj
  implements blsr
{
  public bmtj(DoodleEditView paramDoodleEditView) {}
  
  private void c(bmrr parambmrr, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    if (!this.a.jdField_a_of_type_Bmqu.b()) {
      return;
    }
    paramSegmentKeeper = bmyh.a(parambmrr, paramFloat1, paramFloat2, paramFloat3);
    parambmrr = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bmqu.a(), parambmrr.jdField_a_of_type_JavaLangString, parambmrr.b, parambmrr.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramSegmentKeeper, paramString, parambmrr.jdField_a_of_type_Int, false, null, null, this.a.a());
    this.a.jdField_a_of_type_Bmqu.c(parambmrr);
    this.a.postInvalidate();
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_Bmqu.c();
  }
  
  public void a(bmrr parambmrr, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambmrr, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
  
  public void a(bmvz parambmvz, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((!this.a.jdField_a_of_type_Bmqu.b()) || (parambmvz == null)) {
      return;
    }
    Object localObject1 = null;
    wxe.b("DoodleEditView", "addLocationFaceItem:" + parambmvz.toString());
    boolean bool = this.a.getContext() instanceof EditPicActivity;
    label70:
    Object localObject2;
    label120:
    float f1;
    float f2;
    if (bool)
    {
      parambmvz.d = 0;
      localObject2 = bmwa.a(parambmvz, this.a.getContext(), -1L);
      if (!bool) {
        break label592;
      }
      if (localObject2 != null) {
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), ((bmxt)localObject2).a());
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
      if (!(this.a.jdField_a_of_type_Bmqu.a instanceof bmqk)) {
        break label665;
      }
      localObject2 = (bmqk)this.a.jdField_a_of_type_Bmqu.a;
      if (((bmqk)localObject2).q > 4.0D) {
        ((bmqk)localObject2).q = 1.0F;
      }
      f1 = ((bmqk)localObject2).b.x;
      f2 = ((bmqk)localObject2).q * ((Drawable)localObject1).getIntrinsicWidth() / 2.0F;
      f1 = ((bmqk)localObject2).s + (f1 - f2);
      f2 = ((bmqk)localObject2).b.x;
      if (f1 >= bnsm.a(23.0F)) {
        break label662;
      }
      f2 = ((bmqk)localObject2).b.x - f1 + bnsm.a(23.0F);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "startX:" + f1 + "x:" + paramFloat1);
      }
      localObject2 = new bmqo(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (TextUtils.isEmpty(paramString)) {
        paramString = parambmvz.b;
      }
      for (;;)
      {
        if ((localObject1 instanceof bmxt)) {}
        for (parambmvz = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bmqu.a(), parambmvz.m, paramString, (Drawable)localObject1, (bmqo)localObject2, "", parambmvz.d, parambmvz.a, parambmvz.l, ((bmxt)localObject1).c(), this.a.a());; parambmvz = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bmqu.a(), parambmvz.m, paramString, (Drawable)localObject1, (bmqo)localObject2, "", parambmvz.d, false, parambmvz.l, null, this.a.a()))
        {
          if (((parambmvz instanceof bmqk)) && ((this.a.jdField_a_of_type_Bmqu.a instanceof bmqk))) {
            ((bmqk)parambmvz).g = ((bmqk)this.a.jdField_a_of_type_Bmqu.a).g;
          }
          this.a.jdField_a_of_type_Bmqu.c(parambmvz);
          parambmvz.b.x = f2;
          this.a.postInvalidate();
          return;
          parambmvz.d = 3;
          break label70;
          label592:
          localObject1 = localObject2;
          break label120;
          label597:
          break;
          parambmvz.d = 0;
        }
      }
      label662:
      continue;
      label665:
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void a(bmwd parambmwd, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.a.jdField_a_of_type_Bmqu.b()) {
      return;
    }
    bmqo localbmqo = bmyh.a(parambmwd, this.a.getWidth(), this.a.getHeight(), paramFloat1, paramFloat2);
    if (localbmqo != null) {
      if ((parambmwd.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((parambmwd.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)))
      {
        File localFile = ((URLDrawable)parambmwd.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile != null) && (localFile.exists()))
        {
          parambmwd = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bmqu.a(), parambmwd.g, parambmwd.c, parambmwd.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbmqo, localFile.getAbsolutePath(), parambmwd.jdField_a_of_type_Int, false, null, null, this.a.a());
          this.a.jdField_a_of_type_Bmqu.c(parambmwd);
        }
      }
    }
    for (;;)
    {
      this.a.postInvalidate();
      return;
      wxe.e("DoodleEditView", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(bmwd parambmwd, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(bmrr parambmrr, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambmrr, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtj
 * JD-Core Version:    0.7.0.1
 */