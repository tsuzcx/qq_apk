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

public class bpkp
  implements bolv
{
  public bpkp(DoodleEditView paramDoodleEditView) {}
  
  private void c(bpix parambpix, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    if (!this.a.jdField_a_of_type_Bpia.b()) {
      return;
    }
    paramSegmentKeeper = bppn.a(parambpix, paramFloat1, paramFloat2, paramFloat3);
    parambpix = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bpia.a(), parambpix.jdField_a_of_type_JavaLangString, parambpix.b, parambpix.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramSegmentKeeper, paramString, parambpix.jdField_a_of_type_Int, false, null, null, this.a.a());
    this.a.jdField_a_of_type_Bpia.c(parambpix);
    this.a.postInvalidate();
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_Bpia.c();
  }
  
  public void a(bpix parambpix, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambpix, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
  
  public void a(bpnf parambpnf, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((!this.a.jdField_a_of_type_Bpia.b()) || (parambpnf == null)) {
      return;
    }
    Object localObject1 = null;
    yqp.b("DoodleEditView", "addLocationFaceItem:" + parambpnf.toString());
    boolean bool = this.a.getContext() instanceof EditPicActivity;
    label70:
    Object localObject2;
    label120:
    float f1;
    float f2;
    if (bool)
    {
      parambpnf.d = 0;
      localObject2 = bpng.a(parambpnf, this.a.getContext(), -1L);
      if (!bool) {
        break label592;
      }
      if (localObject2 != null) {
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), ((bpoz)localObject2).a());
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
      if (!(this.a.jdField_a_of_type_Bpia.a instanceof bphq)) {
        break label665;
      }
      localObject2 = (bphq)this.a.jdField_a_of_type_Bpia.a;
      if (((bphq)localObject2).q > 4.0D) {
        ((bphq)localObject2).q = 1.0F;
      }
      f1 = ((bphq)localObject2).b.x;
      f2 = ((bphq)localObject2).q * ((Drawable)localObject1).getIntrinsicWidth() / 2.0F;
      f1 = ((bphq)localObject2).s + (f1 - f2);
      f2 = ((bphq)localObject2).b.x;
      if (f1 >= bqja.a(23.0F)) {
        break label662;
      }
      f2 = ((bphq)localObject2).b.x - f1 + bqja.a(23.0F);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "startX:" + f1 + "x:" + paramFloat1);
      }
      localObject2 = new bphu(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (TextUtils.isEmpty(paramString)) {
        paramString = parambpnf.b;
      }
      for (;;)
      {
        if ((localObject1 instanceof bpoz)) {}
        for (parambpnf = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bpia.a(), parambpnf.m, paramString, (Drawable)localObject1, (bphu)localObject2, "", parambpnf.d, parambpnf.a, parambpnf.l, ((bpoz)localObject1).c(), this.a.a());; parambpnf = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bpia.a(), parambpnf.m, paramString, (Drawable)localObject1, (bphu)localObject2, "", parambpnf.d, false, parambpnf.l, null, this.a.a()))
        {
          if (((parambpnf instanceof bphq)) && ((this.a.jdField_a_of_type_Bpia.a instanceof bphq))) {
            ((bphq)parambpnf).g = ((bphq)this.a.jdField_a_of_type_Bpia.a).g;
          }
          this.a.jdField_a_of_type_Bpia.c(parambpnf);
          parambpnf.b.x = f2;
          this.a.postInvalidate();
          return;
          parambpnf.d = 3;
          break label70;
          label592:
          localObject1 = localObject2;
          break label120;
          label597:
          break;
          parambpnf.d = 0;
        }
      }
      label662:
      continue;
      label665:
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void a(bpnj parambpnj, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.a.jdField_a_of_type_Bpia.b()) {
      return;
    }
    bphu localbphu = bppn.a(parambpnj, this.a.getWidth(), this.a.getHeight(), paramFloat1, paramFloat2);
    if (localbphu != null) {
      if ((parambpnj.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((parambpnj.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)))
      {
        File localFile = ((URLDrawable)parambpnj.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile != null) && (localFile.exists()))
        {
          parambpnj = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bpia.a(), parambpnj.g, parambpnj.c, parambpnj.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbphu, localFile.getAbsolutePath(), parambpnj.jdField_a_of_type_Int, false, null, null, this.a.a());
          this.a.jdField_a_of_type_Bpia.c(parambpnj);
        }
      }
    }
    for (;;)
    {
      this.a.postInvalidate();
      return;
      yqp.e("DoodleEditView", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(bpnj parambpnj, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(bpix parambpix, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambpix, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpkp
 * JD-Core Version:    0.7.0.1
 */