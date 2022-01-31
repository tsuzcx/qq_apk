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

public class bkdn
  implements bjcu
{
  public bkdn(DoodleEditView paramDoodleEditView) {}
  
  private void c(bkbv parambkbv, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    if (!this.a.jdField_a_of_type_Bkay.b()) {
      return;
    }
    paramSegmentKeeper = bkil.a(parambkbv, paramFloat1, paramFloat2, paramFloat3);
    parambkbv = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bkay.a(), parambkbv.jdField_a_of_type_JavaLangString, parambkbv.b, parambkbv.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramSegmentKeeper, paramString, parambkbv.jdField_a_of_type_Int, false, null, null, this.a.a());
    this.a.jdField_a_of_type_Bkay.c(parambkbv);
    this.a.postInvalidate();
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_Bkay.c();
  }
  
  public void a(bkbv parambkbv, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambkbv, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
  
  public void a(bkgd parambkgd, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((!this.a.jdField_a_of_type_Bkay.b()) || (parambkgd == null)) {
      return;
    }
    Object localObject1 = null;
    ved.b("DoodleEditView", "addLocationFaceItem:" + parambkgd.toString());
    boolean bool = this.a.getContext() instanceof EditPicActivity;
    label70:
    Object localObject2;
    label120:
    float f1;
    float f2;
    if (bool)
    {
      parambkgd.d = 0;
      localObject2 = bkge.a(parambkgd, this.a.getContext(), -1L);
      if (!bool) {
        break label592;
      }
      if (localObject2 != null) {
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), ((bkhx)localObject2).a());
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
      if (!(this.a.jdField_a_of_type_Bkay.a instanceof bkao)) {
        break label665;
      }
      localObject2 = (bkao)this.a.jdField_a_of_type_Bkay.a;
      if (((bkao)localObject2).q > 4.0D) {
        ((bkao)localObject2).q = 1.0F;
      }
      f1 = ((bkao)localObject2).b.x;
      f2 = ((bkao)localObject2).q * ((Drawable)localObject1).getIntrinsicWidth() / 2.0F;
      f1 = ((bkao)localObject2).s + (f1 - f2);
      f2 = ((bkao)localObject2).b.x;
      if (f1 >= blcq.a(23.0F)) {
        break label662;
      }
      f2 = ((bkao)localObject2).b.x - f1 + blcq.a(23.0F);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "startX:" + f1 + "x:" + paramFloat1);
      }
      localObject2 = new bkas(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (TextUtils.isEmpty(paramString)) {
        paramString = parambkgd.b;
      }
      for (;;)
      {
        if ((localObject1 instanceof bkhx)) {}
        for (parambkgd = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bkay.a(), parambkgd.m, paramString, (Drawable)localObject1, (bkas)localObject2, "", parambkgd.d, parambkgd.a, parambkgd.l, ((bkhx)localObject1).c(), this.a.a());; parambkgd = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bkay.a(), parambkgd.m, paramString, (Drawable)localObject1, (bkas)localObject2, "", parambkgd.d, false, parambkgd.l, null, this.a.a()))
        {
          if (((parambkgd instanceof bkao)) && ((this.a.jdField_a_of_type_Bkay.a instanceof bkao))) {
            ((bkao)parambkgd).g = ((bkao)this.a.jdField_a_of_type_Bkay.a).g;
          }
          this.a.jdField_a_of_type_Bkay.c(parambkgd);
          parambkgd.b.x = f2;
          this.a.postInvalidate();
          return;
          parambkgd.d = 3;
          break label70;
          label592:
          localObject1 = localObject2;
          break label120;
          label597:
          break;
          parambkgd.d = 0;
        }
      }
      label662:
      continue;
      label665:
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void a(bkgh parambkgh, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.a.jdField_a_of_type_Bkay.b()) {
      return;
    }
    bkas localbkas = bkil.a(parambkgh, this.a.getWidth(), this.a.getHeight(), paramFloat1, paramFloat2);
    if (localbkas != null) {
      if ((parambkgh.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((parambkgh.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)))
      {
        File localFile = ((URLDrawable)parambkgh.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile != null) && (localFile.exists()))
        {
          parambkgh = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bkay.a(), parambkgh.g, parambkgh.c, parambkgh.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbkas, localFile.getAbsolutePath(), parambkgh.jdField_a_of_type_Int, false, null, null, this.a.a());
          this.a.jdField_a_of_type_Bkay.c(parambkgh);
        }
      }
    }
    for (;;)
    {
      this.a.postInvalidate();
      return;
      ved.e("DoodleEditView", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(bkgh parambkgh, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(bkbv parambkbv, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambkbv, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkdn
 * JD-Core Version:    0.7.0.1
 */