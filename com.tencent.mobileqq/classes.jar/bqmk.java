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

public class bqmk
  implements bpnq
{
  public bqmk(DoodleEditView paramDoodleEditView) {}
  
  private void c(bqks parambqks, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    if (!this.a.jdField_a_of_type_Bqjv.b()) {
      return;
    }
    paramSegmentKeeper = bqri.a(parambqks, paramFloat1, paramFloat2, paramFloat3);
    parambqks = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bqjv.a(), parambqks.jdField_a_of_type_JavaLangString, parambqks.b, parambqks.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramSegmentKeeper, paramString, parambqks.jdField_a_of_type_Int, false, null, null, this.a.a());
    this.a.jdField_a_of_type_Bqjv.c(parambqks);
    this.a.postInvalidate();
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_Bqjv.c();
  }
  
  public void a(bqks parambqks, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambqks, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
  
  public void a(bqpa parambqpa, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((!this.a.jdField_a_of_type_Bqjv.b()) || (parambqpa == null)) {
      return;
    }
    Object localObject1 = null;
    yuk.b("DoodleEditView", "addLocationFaceItem:" + parambqpa.toString());
    boolean bool = this.a.getContext() instanceof EditPicActivity;
    label70:
    Object localObject2;
    label120:
    float f1;
    float f2;
    if (bool)
    {
      parambqpa.d = 0;
      localObject2 = bqpb.a(parambqpa, this.a.getContext(), -1L);
      if (!bool) {
        break label592;
      }
      if (localObject2 != null) {
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), ((bqqu)localObject2).a());
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
      if (!(this.a.jdField_a_of_type_Bqjv.a instanceof bqjl)) {
        break label665;
      }
      localObject2 = (bqjl)this.a.jdField_a_of_type_Bqjv.a;
      if (((bqjl)localObject2).q > 4.0D) {
        ((bqjl)localObject2).q = 1.0F;
      }
      f1 = ((bqjl)localObject2).b.x;
      f2 = ((bqjl)localObject2).q * ((Drawable)localObject1).getIntrinsicWidth() / 2.0F;
      f1 = ((bqjl)localObject2).s + (f1 - f2);
      f2 = ((bqjl)localObject2).b.x;
      if (f1 >= brkm.a(23.0F)) {
        break label662;
      }
      f2 = ((bqjl)localObject2).b.x - f1 + brkm.a(23.0F);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "startX:" + f1 + "x:" + paramFloat1);
      }
      localObject2 = new bqjp(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (TextUtils.isEmpty(paramString)) {
        paramString = parambqpa.b;
      }
      for (;;)
      {
        if ((localObject1 instanceof bqqu)) {}
        for (parambqpa = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bqjv.a(), parambqpa.m, paramString, (Drawable)localObject1, (bqjp)localObject2, "", parambqpa.d, parambqpa.a, parambqpa.l, ((bqqu)localObject1).c(), this.a.a());; parambqpa = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bqjv.a(), parambqpa.m, paramString, (Drawable)localObject1, (bqjp)localObject2, "", parambqpa.d, false, parambqpa.l, null, this.a.a()))
        {
          if (((parambqpa instanceof bqjl)) && ((this.a.jdField_a_of_type_Bqjv.a instanceof bqjl))) {
            ((bqjl)parambqpa).g = ((bqjl)this.a.jdField_a_of_type_Bqjv.a).g;
          }
          this.a.jdField_a_of_type_Bqjv.c(parambqpa);
          parambqpa.b.x = f2;
          this.a.postInvalidate();
          return;
          parambqpa.d = 3;
          break label70;
          label592:
          localObject1 = localObject2;
          break label120;
          label597:
          break;
          parambqpa.d = 0;
        }
      }
      label662:
      continue;
      label665:
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void a(bqpe parambqpe, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.a.jdField_a_of_type_Bqjv.b()) {
      return;
    }
    bqjp localbqjp = bqri.a(parambqpe, this.a.getWidth(), this.a.getHeight(), paramFloat1, paramFloat2);
    if (localbqjp != null) {
      if ((parambqpe.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((parambqpe.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)))
      {
        File localFile = ((URLDrawable)parambqpe.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile != null) && (localFile.exists()))
        {
          parambqpe = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bqjv.a(), parambqpe.g, parambqpe.c, parambqpe.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbqjp, localFile.getAbsolutePath(), parambqpe.jdField_a_of_type_Int, false, null, null, this.a.a());
          this.a.jdField_a_of_type_Bqjv.c(parambqpe);
        }
      }
    }
    for (;;)
    {
      this.a.postInvalidate();
      return;
      yuk.e("DoodleEditView", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(bqpe parambqpe, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(bqks parambqks, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambqks, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqmk
 * JD-Core Version:    0.7.0.1
 */