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

public class bniw
  implements bmsl
{
  public bniw(DoodleEditView paramDoodleEditView) {}
  
  private void c(bnhe parambnhe, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    if (!this.a.jdField_a_of_type_Bngl.b()) {
      return;
    }
    paramSegmentKeeper = bnnm.a(parambnhe, paramFloat1, paramFloat2, paramFloat3);
    parambnhe = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bngl.a(), parambnhe.jdField_a_of_type_JavaLangString, parambnhe.b, parambnhe.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramSegmentKeeper, paramString, parambnhe.jdField_a_of_type_Int, false, null, null, this.a.a());
    this.a.jdField_a_of_type_Bngl.c(parambnhe);
    this.a.postInvalidate();
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_Bngl.c();
  }
  
  public void a(bnhe parambnhe, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambnhe, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
  
  public void a(bnli parambnli, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((!this.a.jdField_a_of_type_Bngl.b()) || (parambnli == null)) {
      return;
    }
    Object localObject1 = null;
    xvv.b("DoodleEditView", "addLocationFaceItem:" + parambnli.toString());
    boolean bool = this.a.getContext() instanceof EditPicActivity;
    label70:
    Object localObject2;
    label120:
    float f1;
    float f2;
    if (bool)
    {
      parambnli.d = 0;
      localObject2 = bnlj.a(parambnli, this.a.getContext(), -1L);
      if (!bool) {
        break label592;
      }
      if (localObject2 != null) {
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), ((bnmy)localObject2).a());
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
      if (!(this.a.jdField_a_of_type_Bngl.a instanceof bngd)) {
        break label665;
      }
      localObject2 = (bngd)this.a.jdField_a_of_type_Bngl.a;
      if (((bngd)localObject2).q > 4.0D) {
        ((bngd)localObject2).q = 1.0F;
      }
      f1 = ((bngd)localObject2).a.x;
      f2 = ((bngd)localObject2).q * ((Drawable)localObject1).getIntrinsicWidth() / 2.0F;
      f1 = ((bngd)localObject2).s + (f1 - f2);
      f2 = ((bngd)localObject2).a.x;
      if (f1 >= bodx.a(23.0F)) {
        break label662;
      }
      f2 = ((bngd)localObject2).a.x - f1 + bodx.a(23.0F);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "startX:" + f1 + "x:" + paramFloat1);
      }
      localObject2 = new bngh(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (TextUtils.isEmpty(paramString)) {
        paramString = parambnli.b;
      }
      for (;;)
      {
        if ((localObject1 instanceof bnmy)) {}
        for (parambnli = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bngl.a(), parambnli.m, paramString, (Drawable)localObject1, (bngh)localObject2, "", parambnli.d, parambnli.a, parambnli.l, ((bnmy)localObject1).c(), this.a.a());; parambnli = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bngl.a(), parambnli.m, paramString, (Drawable)localObject1, (bngh)localObject2, "", parambnli.d, false, parambnli.l, null, this.a.a()))
        {
          if (((parambnli instanceof bngd)) && ((this.a.jdField_a_of_type_Bngl.a instanceof bngd))) {
            ((bngd)parambnli).g = ((bngd)this.a.jdField_a_of_type_Bngl.a).g;
          }
          this.a.jdField_a_of_type_Bngl.c(parambnli);
          parambnli.a.x = f2;
          this.a.postInvalidate();
          return;
          parambnli.d = 3;
          break label70;
          label592:
          localObject1 = localObject2;
          break label120;
          label597:
          break;
          parambnli.d = 0;
        }
      }
      label662:
      continue;
      label665:
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void a(bnll parambnll, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.a.jdField_a_of_type_Bngl.b()) {
      return;
    }
    bngh localbngh = bnnm.a(parambnll, this.a.getWidth(), this.a.getHeight(), paramFloat1, paramFloat2);
    if (localbngh != null) {
      if ((parambnll.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((parambnll.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)))
      {
        File localFile = ((URLDrawable)parambnll.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile != null) && (localFile.exists()))
        {
          parambnll = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bngl.a(), parambnll.g, parambnll.c, parambnll.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbngh, localFile.getAbsolutePath(), parambnll.jdField_a_of_type_Int, false, null, null, this.a.a());
          this.a.jdField_a_of_type_Bngl.c(parambnll);
        }
      }
    }
    for (;;)
    {
      this.a.postInvalidate();
      return;
      xvv.e("DoodleEditView", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(bnll parambnll, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(bnhe parambnhe, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambnhe, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bniw
 * JD-Core Version:    0.7.0.1
 */