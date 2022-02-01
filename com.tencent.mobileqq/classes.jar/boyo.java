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

public class boyo
  implements boid
{
  public boyo(DoodleEditView paramDoodleEditView) {}
  
  private void c(boww paramboww, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    if (!this.a.jdField_a_of_type_Bowd.b()) {
      return;
    }
    paramSegmentKeeper = bpde.a(paramboww, paramFloat1, paramFloat2, paramFloat3);
    paramboww = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bowd.a(), paramboww.jdField_a_of_type_JavaLangString, paramboww.b, paramboww.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramSegmentKeeper, paramString, paramboww.jdField_a_of_type_Int, false, null, null, this.a.a());
    this.a.jdField_a_of_type_Bowd.c(paramboww);
    this.a.postInvalidate();
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_Bowd.c();
  }
  
  public void a(boww paramboww, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(paramboww, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
  
  public void a(bpba parambpba, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((!this.a.jdField_a_of_type_Bowd.b()) || (parambpba == null)) {
      return;
    }
    Object localObject1 = null;
    ykq.b("DoodleEditView", "addLocationFaceItem:" + parambpba.toString());
    boolean bool = this.a.getContext() instanceof EditPicActivity;
    label70:
    Object localObject2;
    label120:
    float f1;
    float f2;
    if (bool)
    {
      parambpba.d = 0;
      localObject2 = bpbb.a(parambpba, this.a.getContext(), -1L);
      if (!bool) {
        break label592;
      }
      if (localObject2 != null) {
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), ((bpcq)localObject2).a());
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
      if (!(this.a.jdField_a_of_type_Bowd.a instanceof bovv)) {
        break label665;
      }
      localObject2 = (bovv)this.a.jdField_a_of_type_Bowd.a;
      if (((bovv)localObject2).q > 4.0D) {
        ((bovv)localObject2).q = 1.0F;
      }
      f1 = ((bovv)localObject2).a.x;
      f2 = ((bovv)localObject2).q * ((Drawable)localObject1).getIntrinsicWidth() / 2.0F;
      f1 = ((bovv)localObject2).s + (f1 - f2);
      f2 = ((bovv)localObject2).a.x;
      if (f1 >= bptp.a(23.0F)) {
        break label662;
      }
      f2 = ((bovv)localObject2).a.x - f1 + bptp.a(23.0F);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "startX:" + f1 + "x:" + paramFloat1);
      }
      localObject2 = new bovz(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (TextUtils.isEmpty(paramString)) {
        paramString = parambpba.b;
      }
      for (;;)
      {
        if ((localObject1 instanceof bpcq)) {}
        for (parambpba = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bowd.a(), parambpba.m, paramString, (Drawable)localObject1, (bovz)localObject2, "", parambpba.d, parambpba.a, parambpba.l, ((bpcq)localObject1).c(), this.a.a());; parambpba = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bowd.a(), parambpba.m, paramString, (Drawable)localObject1, (bovz)localObject2, "", parambpba.d, false, parambpba.l, null, this.a.a()))
        {
          if (((parambpba instanceof bovv)) && ((this.a.jdField_a_of_type_Bowd.a instanceof bovv))) {
            ((bovv)parambpba).g = ((bovv)this.a.jdField_a_of_type_Bowd.a).g;
          }
          this.a.jdField_a_of_type_Bowd.c(parambpba);
          parambpba.a.x = f2;
          this.a.postInvalidate();
          return;
          parambpba.d = 3;
          break label70;
          label592:
          localObject1 = localObject2;
          break label120;
          label597:
          break;
          parambpba.d = 0;
        }
      }
      label662:
      continue;
      label665:
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void a(bpbd parambpbd, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.a.jdField_a_of_type_Bowd.b()) {
      return;
    }
    bovz localbovz = bpde.a(parambpbd, this.a.getWidth(), this.a.getHeight(), paramFloat1, paramFloat2);
    if (localbovz != null) {
      if ((parambpbd.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((parambpbd.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)))
      {
        File localFile = ((URLDrawable)parambpbd.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile != null) && (localFile.exists()))
        {
          parambpbd = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bowd.a(), parambpbd.g, parambpbd.c, parambpbd.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbovz, localFile.getAbsolutePath(), parambpbd.jdField_a_of_type_Int, false, null, null, this.a.a());
          this.a.jdField_a_of_type_Bowd.c(parambpbd);
        }
      }
    }
    for (;;)
    {
      this.a.postInvalidate();
      return;
      ykq.e("DoodleEditView", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(bpbd parambpbd, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(boww paramboww, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(paramboww, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boyo
 * JD-Core Version:    0.7.0.1
 */