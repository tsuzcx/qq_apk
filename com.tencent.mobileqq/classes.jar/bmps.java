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

public class bmps
  implements blof
{
  private bmps(DoodleLayout paramDoodleLayout) {}
  
  private boolean a(bmnf parambmnf, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper, boolean paramBoolean)
  {
    boolean bool;
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d == 0) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c == 0)) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d > this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c))
    {
      bmmc localbmmc = new bmmc(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, parambmnf.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), parambmnf.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
      if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.report(615, 6);
      }
      bmlu localbmlu = this.a.a();
      Object localObject = localbmlu;
      if (parambmnf.jdField_a_of_type_Int == 1) {
        if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject = localbmlu;
          if (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject = this.a.a();
        }
      }
      bool = ((bmlu)localObject).a(parambmnf.jdField_a_of_type_JavaLangString, parambmnf.b, parambmnf.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbmmc, paramString, false, parambmnf.jdField_a_of_type_Int, this.a.d(), paramSegmentKeeper);
      if ((!this.a.b) || (!bool)) {
        break label251;
      }
    }
    label251:
    for (paramBoolean = true;; paramBoolean = false)
    {
      DoodleLayout.d(paramBoolean);
      return bool;
      paramFloat2 = bnoa.b / 2;
      break;
    }
  }
  
  public void a()
  {
    this.a.a().d();
    this.a.a().d();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void a(bmnf parambmnf, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    wsv.b("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { parambmnf, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
    if (a(parambmnf, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, true))
    {
      DoodleLayout.a("clk_oneface");
      wtb.a("0X80076CA");
      wtb.b("0X80075DF");
    }
    if (xir.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 8, 1);
    }
  }
  
  public void a(bmrn parambmrn, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (parambmrn == null) {
      wsv.e("DoodleLayout", "the item is null.");
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
      wsv.a("DoodleLayout", "onInformationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", parambmrn.b, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
      this.a.c();
      wsv.b("DoodleLayout", "addLocationFaceItem:" + parambmrn.toString());
      boolean bool = this.a.getContext() instanceof EditPicActivity;
      bmth localbmth;
      Object localObject1;
      if (bool)
      {
        parambmrn.d = 0;
        localbmth = bmro.a(parambmrn, this.a.getContext(), -1L);
        if (!bool) {
          break label474;
        }
        if (localbmth == null) {
          break label507;
        }
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), localbmth.a());
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
        bmmc localbmmc;
        Object localObject2;
        int i;
        if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d == 0) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c == 0)) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d > this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c))
        {
          localbmmc = new bmmc(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
          localObject2 = this.a.a();
          if ((parambmrn.d != 3) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {
            break label492;
          }
          i = 3;
          localObject2 = this.a.a();
          if (!TextUtils.isEmpty(paramString)) {
            break label504;
          }
          paramString = parambmrn.b;
        }
        for (;;)
        {
          bool = ((bmlu)localObject2).a(parambmrn.m, paramString, (Drawable)localObject1, localbmmc, "", parambmrn.a, parambmrn.l, i, localbmth.c(), 0, this.a.d());
          if (QLog.isColorLevel()) {
            QLog.d("DoodleLayout", 2, "add Face result" + bool);
          }
          if ((this.a.b) && (bool)) {}
          for (bool = true;; bool = false)
          {
            DoodleLayout.d(bool);
            return;
            parambmrn.d = 3;
            break;
            localObject1 = localbmth;
            break label143;
            paramFloat2 = bnoa.b / 2;
            break label277;
            i = 0;
            break label356;
          }
        }
        localObject1 = null;
      }
    }
  }
  
  public void a(bmrr parambmrr, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    wsv.a("DoodleLayout", "onLocationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", parambmrr.d, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
    this.a.a(parambmrr, paramFloat1, paramFloat2, paramFloat3);
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    wtb.b("0X80075E3");
  }
  
  public void a(bmrr parambmrr, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
  {
    wsv.b("DoodleLayout", "onComboLocationFaceSelected, pictureUrl:" + parambmrr.d);
    this.a.a(parambmrr, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper);
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    wtb.b("0X80075E3");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a().a(paramString1, paramString2);
    this.a.a().a(paramString1, paramString2);
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void b(bmnf parambmnf, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    wsv.b("DoodleLayout", "onInformationFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { parambmnf, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
    a(parambmnf, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmps
 * JD-Core Version:    0.7.0.1
 */