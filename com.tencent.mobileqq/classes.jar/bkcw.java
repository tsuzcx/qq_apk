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

public class bkcw
  implements bjcd
{
  public bkcw(DoodleEditView paramDoodleEditView) {}
  
  private void c(bkbe parambkbe, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    if (!this.a.jdField_a_of_type_Bkah.b()) {
      return;
    }
    paramSegmentKeeper = bkhu.a(parambkbe, paramFloat1, paramFloat2, paramFloat3);
    parambkbe = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bkah.a(), parambkbe.jdField_a_of_type_JavaLangString, parambkbe.b, parambkbe.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramSegmentKeeper, paramString, parambkbe.jdField_a_of_type_Int, false, null, null, this.a.a());
    this.a.jdField_a_of_type_Bkah.c(parambkbe);
    this.a.postInvalidate();
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_Bkah.c();
  }
  
  public void a(bkbe parambkbe, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambkbe, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
  
  public void a(bkfm parambkfm, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((!this.a.jdField_a_of_type_Bkah.b()) || (parambkfm == null)) {
      return;
    }
    Object localObject1 = null;
    veg.b("DoodleEditView", "addLocationFaceItem:" + parambkfm.toString());
    boolean bool = this.a.getContext() instanceof EditPicActivity;
    label70:
    Object localObject2;
    label120:
    float f1;
    float f2;
    if (bool)
    {
      parambkfm.d = 0;
      localObject2 = bkfn.a(parambkfm, this.a.getContext(), -1L);
      if (!bool) {
        break label592;
      }
      if (localObject2 != null) {
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), ((bkhg)localObject2).a());
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
      if (!(this.a.jdField_a_of_type_Bkah.a instanceof bjzx)) {
        break label665;
      }
      localObject2 = (bjzx)this.a.jdField_a_of_type_Bkah.a;
      if (((bjzx)localObject2).q > 4.0D) {
        ((bjzx)localObject2).q = 1.0F;
      }
      f1 = ((bjzx)localObject2).b.x;
      f2 = ((bjzx)localObject2).q * ((Drawable)localObject1).getIntrinsicWidth() / 2.0F;
      f1 = ((bjzx)localObject2).s + (f1 - f2);
      f2 = ((bjzx)localObject2).b.x;
      if (f1 >= blbz.a(23.0F)) {
        break label662;
      }
      f2 = ((bjzx)localObject2).b.x - f1 + blbz.a(23.0F);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "startX:" + f1 + "x:" + paramFloat1);
      }
      localObject2 = new bkab(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (TextUtils.isEmpty(paramString)) {
        paramString = parambkfm.b;
      }
      for (;;)
      {
        if ((localObject1 instanceof bkhg)) {}
        for (parambkfm = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bkah.a(), parambkfm.m, paramString, (Drawable)localObject1, (bkab)localObject2, "", parambkfm.d, parambkfm.a, parambkfm.l, ((bkhg)localObject1).c(), this.a.a());; parambkfm = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bkah.a(), parambkfm.m, paramString, (Drawable)localObject1, (bkab)localObject2, "", parambkfm.d, false, parambkfm.l, null, this.a.a()))
        {
          if (((parambkfm instanceof bjzx)) && ((this.a.jdField_a_of_type_Bkah.a instanceof bjzx))) {
            ((bjzx)parambkfm).g = ((bjzx)this.a.jdField_a_of_type_Bkah.a).g;
          }
          this.a.jdField_a_of_type_Bkah.c(parambkfm);
          parambkfm.b.x = f2;
          this.a.postInvalidate();
          return;
          parambkfm.d = 3;
          break label70;
          label592:
          localObject1 = localObject2;
          break label120;
          label597:
          break;
          parambkfm.d = 0;
        }
      }
      label662:
      continue;
      label665:
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void a(bkfq parambkfq, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.a.jdField_a_of_type_Bkah.b()) {
      return;
    }
    bkab localbkab = bkhu.a(parambkfq, this.a.getWidth(), this.a.getHeight(), paramFloat1, paramFloat2);
    if (localbkab != null) {
      if ((parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)))
      {
        File localFile = ((URLDrawable)parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile != null) && (localFile.exists()))
        {
          parambkfq = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_Bkah.a(), parambkfq.g, parambkfq.c, parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbkab, localFile.getAbsolutePath(), parambkfq.jdField_a_of_type_Int, false, null, null, this.a.a());
          this.a.jdField_a_of_type_Bkah.c(parambkfq);
        }
      }
    }
    for (;;)
    {
      this.a.postInvalidate();
      return;
      veg.e("DoodleEditView", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(bkfq parambkfq, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(bkbe parambkbe, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(parambkbe, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkcw
 * JD-Core Version:    0.7.0.1
 */