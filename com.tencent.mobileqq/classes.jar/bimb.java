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

public class bimb
  implements bhhl
{
  public bimb(DoodleEditView paramDoodleEditView) {}
  
  private void c(bikj parambikj, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    if (!this.a.jdField_a_of_type_Bijm.b()) {
      return;
    }
    paramSegmentKeeper = biqz.a(parambikj, paramFloat1, paramFloat2, paramFloat3);
    parambikj = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bijm.a(), parambikj.jdField_a_of_type_JavaLangString, parambikj.b, parambikj.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramSegmentKeeper, paramString, parambikj.jdField_a_of_type_Int, false, null, null, this.a.a());
    this.a.jdField_a_of_type_Bijm.c(parambikj);
    this.a.postInvalidate();
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_Bijm.c();
  }
  
  public void a(bikj parambikj, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambikj, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
  
  public void a(bior parambior, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((!this.a.jdField_a_of_type_Bijm.b()) || (parambior == null)) {
      return;
    }
    Object localObject1 = null;
    urk.b("DoodleEditView", "addLocationFaceItem:" + parambior.toString());
    boolean bool = this.a.getContext() instanceof EditPicActivity;
    label70:
    Object localObject2;
    label120:
    float f1;
    float f2;
    if (bool)
    {
      parambior.d = 0;
      localObject2 = bios.a(parambior, this.a.getContext(), -1L);
      if (!bool) {
        break label592;
      }
      if (localObject2 != null) {
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), ((biql)localObject2).a());
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
      if (!(this.a.jdField_a_of_type_Bijm.a instanceof bijc)) {
        break label665;
      }
      localObject2 = (bijc)this.a.jdField_a_of_type_Bijm.a;
      if (((bijc)localObject2).q > 4.0D) {
        ((bijc)localObject2).q = 1.0F;
      }
      f1 = ((bijc)localObject2).b.x;
      f2 = ((bijc)localObject2).q * ((Drawable)localObject1).getIntrinsicWidth() / 2.0F;
      f1 = ((bijc)localObject2).s + (f1 - f2);
      f2 = ((bijc)localObject2).b.x;
      if (f1 >= bjlo.a(23.0F)) {
        break label662;
      }
      f2 = ((bijc)localObject2).b.x - f1 + bjlo.a(23.0F);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "startX:" + f1 + "x:" + paramFloat1);
      }
      localObject2 = new bijg(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (TextUtils.isEmpty(paramString)) {
        paramString = parambior.b;
      }
      for (;;)
      {
        if ((localObject1 instanceof biql)) {}
        for (parambior = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bijm.a(), parambior.m, paramString, (Drawable)localObject1, (bijg)localObject2, "", parambior.d, parambior.a, parambior.l, ((biql)localObject1).c(), this.a.a());; parambior = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bijm.a(), parambior.m, paramString, (Drawable)localObject1, (bijg)localObject2, "", parambior.d, false, parambior.l, null, this.a.a()))
        {
          if (((parambior instanceof bijc)) && ((this.a.jdField_a_of_type_Bijm.a instanceof bijc))) {
            ((bijc)parambior).g = ((bijc)this.a.jdField_a_of_type_Bijm.a).g;
          }
          this.a.jdField_a_of_type_Bijm.c(parambior);
          parambior.b.x = f2;
          this.a.postInvalidate();
          return;
          parambior.d = 3;
          break label70;
          label592:
          localObject1 = localObject2;
          break label120;
          label597:
          break;
          parambior.d = 0;
        }
      }
      label662:
      continue;
      label665:
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void a(biov parambiov, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.a.jdField_a_of_type_Bijm.b()) {
      return;
    }
    bijg localbijg = biqz.a(parambiov, this.a.getWidth(), this.a.getHeight(), paramFloat1, paramFloat2);
    if (localbijg != null) {
      if ((parambiov.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((parambiov.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)))
      {
        File localFile = ((URLDrawable)parambiov.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile != null) && (localFile.exists()))
        {
          parambiov = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bijm.a(), parambiov.g, parambiov.c, parambiov.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbijg, localFile.getAbsolutePath(), parambiov.jdField_a_of_type_Int, false, null, null, this.a.a());
          this.a.jdField_a_of_type_Bijm.c(parambiov);
        }
      }
    }
    for (;;)
    {
      this.a.postInvalidate();
      return;
      urk.e("DoodleEditView", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(biov parambiov, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(bikj parambikj, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambikj, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bimb
 * JD-Core Version:    0.7.0.1
 */