import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bkei
  implements bjcu
{
  private bkei(DoodleLayout paramDoodleLayout) {}
  
  private boolean a(bkbv parambkbv, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper, boolean paramBoolean)
  {
    boolean bool;
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d == 0) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c == 0)) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d > this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c))
    {
      bkas localbkas = new bkas(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, parambkbv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), parambkbv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
      if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.report(615, 6);
      }
      bkak localbkak = this.a.a();
      Object localObject = localbkak;
      if (parambkbv.jdField_a_of_type_Int == 1) {
        if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject = localbkak;
          if (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject = this.a.a();
        }
      }
      bool = ((bkak)localObject).a(parambkbv.jdField_a_of_type_JavaLangString, parambkbv.b, parambkbv.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbkas, paramString, false, parambkbv.jdField_a_of_type_Int, this.a.d(), paramSegmentKeeper);
      if ((!this.a.b) || (!bool)) {
        break label251;
      }
    }
    label251:
    for (paramBoolean = true;; paramBoolean = false)
    {
      DoodleLayout.d(paramBoolean);
      return bool;
      paramFloat2 = blcq.b / 2;
      break;
    }
  }
  
  public void a()
  {
    this.a.a().d();
    this.a.a().d();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void a(bkbv parambkbv, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    ved.b("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { parambkbv, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
    if (a(parambkbv, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, true))
    {
      DoodleLayout.a("clk_oneface");
      vej.a("0X80076CA");
      vej.b("0X80075DF");
    }
    if (vtz.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 8, 1);
    }
  }
  
  public void a(bkgd parambkgd, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (parambkgd == null) {
      ved.e("DoodleLayout", "the item is null.");
    }
    label143:
    label277:
    label356:
    label492:
    label504:
    label507:
    label511:
    for (;;)
    {
      return;
      ved.a("DoodleLayout", "onInformationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", parambkgd.b, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
      this.a.c();
      ved.b("DoodleLayout", "addLocationFaceItem:" + parambkgd.toString());
      boolean bool = this.a.getContext() instanceof EditPicActivity;
      bkhx localbkhx;
      Object localObject1;
      if (bool)
      {
        parambkgd.d = 0;
        localbkhx = bkge.a(parambkgd, this.a.getContext(), -1L);
        if (!bool) {
          break label474;
        }
        if (localbkhx == null) {
          break label507;
        }
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), localbkhx.a());
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label511;
        }
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "[" + ((Drawable)localObject1).getIntrinsicWidth() + "," + ((Drawable)localObject1).getIntrinsicHeight() + "]");
        }
        bkas localbkas;
        Object localObject2;
        int i;
        if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d == 0) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c == 0)) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d > this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c))
        {
          localbkas = new bkas(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
          localObject2 = this.a.a();
          if ((parambkgd.d != 3) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {
            break label492;
          }
          i = 3;
          localObject2 = this.a.a();
          if (!TextUtils.isEmpty(paramString)) {
            break label504;
          }
          paramString = parambkgd.b;
        }
        for (;;)
        {
          bool = ((bkak)localObject2).a(parambkgd.m, paramString, (Drawable)localObject1, localbkas, "", parambkgd.a, parambkgd.l, i, localbkhx.c(), 0, this.a.d());
          if (QLog.isColorLevel()) {
            QLog.d("DoodleLayout", 2, "add Face result" + bool);
          }
          if ((this.a.b) && (bool)) {}
          for (bool = true;; bool = false)
          {
            DoodleLayout.d(bool);
            return;
            parambkgd.d = 3;
            break;
            localObject1 = localbkhx;
            break label143;
            paramFloat2 = blcq.b / 2;
            break label277;
            i = 0;
            break label356;
          }
        }
        localObject1 = null;
      }
    }
  }
  
  public void a(bkgh parambkgh, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ved.a("DoodleLayout", "onLocationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", parambkgh.d, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
    this.a.a(parambkgh, paramFloat1, paramFloat2, paramFloat3);
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    vej.b("0X80075E3");
  }
  
  public void a(bkgh parambkgh, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
  {
    ved.b("DoodleLayout", "onComboLocationFaceSelected, pictureUrl:" + parambkgh.d);
    this.a.a(parambkgh, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper);
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    vej.b("0X80075E3");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a().a(paramString1, paramString2);
    this.a.a().a(paramString1, paramString2);
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void b(bkbv parambkbv, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    ved.b("DoodleLayout", "onInformationFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { parambkbv, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
    a(parambkbv, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkei
 * JD-Core Version:    0.7.0.1
 */