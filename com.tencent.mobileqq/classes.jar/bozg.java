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

public class bozg
  implements boid
{
  private bozg(DoodleLayout paramDoodleLayout) {}
  
  private boolean a(boww paramboww, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper, boolean paramBoolean)
  {
    boolean bool;
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e == 0) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d == 0)) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e > this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d))
    {
      bovz localbovz = new bovz(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, paramboww.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), paramboww.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
      if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.report(615, 6);
      }
      bovr localbovr = this.a.a();
      Object localObject = localbovr;
      if (paramboww.jdField_a_of_type_Int == 1) {
        if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject = localbovr;
          if (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject = this.a.a();
        }
      }
      bool = ((bovr)localObject).a(paramboww.jdField_a_of_type_JavaLangString, paramboww.b, paramboww.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbovz, paramString, false, paramboww.jdField_a_of_type_Int, this.a.d(), paramSegmentKeeper);
      if ((!this.a.b) || (!bool)) {
        break label251;
      }
    }
    label251:
    for (paramBoolean = true;; paramBoolean = false)
    {
      DoodleLayout.c(paramBoolean);
      return bool;
      paramFloat2 = bptp.b / 2;
      break;
    }
  }
  
  public void a()
  {
    this.a.a().d();
    this.a.a().d();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void a(boww paramboww, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    ykq.b("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { paramboww, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
    if (a(paramboww, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, true))
    {
      DoodleLayout.a("clk_oneface");
      ykw.a("0X80076CA");
      ykw.b("0X80075DF");
    }
    if (yzz.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 8, 1);
    }
  }
  
  public void a(bpba parambpba, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (parambpba == null) {
      ykq.e("DoodleLayout", "the item is null.");
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
      ykq.a("DoodleLayout", "onInformationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", parambpba.b, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
      this.a.b();
      ykq.b("DoodleLayout", "addLocationFaceItem:" + parambpba.toString());
      boolean bool = this.a.getContext() instanceof EditPicActivity;
      bpcq localbpcq;
      Object localObject1;
      if (bool)
      {
        parambpba.d = 0;
        localbpcq = bpbb.a(parambpba, this.a.getContext(), -1L);
        if (!bool) {
          break label474;
        }
        if (localbpcq == null) {
          break label507;
        }
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), localbpcq.a());
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
        bovz localbovz;
        Object localObject2;
        int i;
        if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e == 0) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d == 0)) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e > this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d))
        {
          localbovz = new bovz(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
          localObject2 = this.a.a();
          if ((parambpba.d != 3) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {
            break label492;
          }
          i = 3;
          localObject2 = this.a.a();
          if (!TextUtils.isEmpty(paramString)) {
            break label504;
          }
          paramString = parambpba.b;
        }
        for (;;)
        {
          bool = ((bovr)localObject2).a(parambpba.m, paramString, (Drawable)localObject1, localbovz, "", parambpba.a, parambpba.l, i, localbpcq.c(), 0, this.a.d());
          if (QLog.isColorLevel()) {
            QLog.d("DoodleLayout", 2, "add Face result" + bool);
          }
          if ((this.a.b) && (bool)) {}
          for (bool = true;; bool = false)
          {
            DoodleLayout.c(bool);
            return;
            parambpba.d = 3;
            break;
            localObject1 = localbpcq;
            break label143;
            paramFloat2 = bptp.b / 2;
            break label277;
            i = 0;
            break label356;
          }
        }
        localObject1 = null;
      }
    }
  }
  
  public void a(bpbd parambpbd, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ykq.a("DoodleLayout", "onLocationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", parambpbd.d, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
    this.a.a(parambpbd, paramFloat1, paramFloat2, paramFloat3);
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    ykw.b("0X80075E3");
  }
  
  public void a(bpbd parambpbd, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
  {
    ykq.b("DoodleLayout", "onComboLocationFaceSelected, pictureUrl:" + parambpbd.d);
    this.a.a(parambpbd, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper);
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    ykw.b("0X80075E3");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a().a(paramString1, paramString2);
    this.a.a().a(paramString1, paramString2);
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void b(boww paramboww, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    ykq.b("DoodleLayout", "onInformationFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { paramboww, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
    a(paramboww, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozg
 * JD-Core Version:    0.7.0.1
 */