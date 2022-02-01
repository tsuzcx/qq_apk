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

public class bqnf
  implements bpnq
{
  private bqnf(DoodleLayout paramDoodleLayout) {}
  
  private boolean a(bqks parambqks, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper, boolean paramBoolean)
  {
    boolean bool;
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d == 0) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c == 0)) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d > this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c))
    {
      bqjp localbqjp = new bqjp(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, parambqks.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), parambqks.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
      if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.report(615, 6);
      }
      bqjh localbqjh = this.a.a();
      Object localObject = localbqjh;
      if (parambqks.jdField_a_of_type_Int == 1) {
        if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject = localbqjh;
          if (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject = this.a.a();
        }
      }
      bool = ((bqjh)localObject).a(parambqks.jdField_a_of_type_JavaLangString, parambqks.b, parambqks.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbqjp, paramString, false, parambqks.jdField_a_of_type_Int, this.a.d(), paramSegmentKeeper);
      if ((!this.a.b) || (!bool)) {
        break label251;
      }
    }
    label251:
    for (paramBoolean = true;; paramBoolean = false)
    {
      DoodleLayout.d(paramBoolean);
      return bool;
      paramFloat2 = brkm.b / 2;
      break;
    }
  }
  
  public void a()
  {
    this.a.a().d();
    this.a.a().d();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void a(bqks parambqks, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    yuk.b("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { parambqks, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
    if (a(parambqks, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, true))
    {
      DoodleLayout.a("clk_oneface");
      yuq.a("0X80076CA");
      yuq.b("0X80075DF");
    }
    if (zkg.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 8, 1);
    }
  }
  
  public void a(bqpa parambqpa, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (parambqpa == null) {
      yuk.e("DoodleLayout", "the item is null.");
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
      yuk.a("DoodleLayout", "onInformationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", parambqpa.b, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
      this.a.c();
      yuk.b("DoodleLayout", "addLocationFaceItem:" + parambqpa.toString());
      boolean bool = this.a.getContext() instanceof EditPicActivity;
      bqqu localbqqu;
      Object localObject1;
      if (bool)
      {
        parambqpa.d = 0;
        localbqqu = bqpb.a(parambqpa, this.a.getContext(), -1L);
        if (!bool) {
          break label474;
        }
        if (localbqqu == null) {
          break label507;
        }
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), localbqqu.a());
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
        bqjp localbqjp;
        Object localObject2;
        int i;
        if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d == 0) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c == 0)) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d > this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c))
        {
          localbqjp = new bqjp(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
          localObject2 = this.a.a();
          if ((parambqpa.d != 3) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {
            break label492;
          }
          i = 3;
          localObject2 = this.a.a();
          if (!TextUtils.isEmpty(paramString)) {
            break label504;
          }
          paramString = parambqpa.b;
        }
        for (;;)
        {
          bool = ((bqjh)localObject2).a(parambqpa.m, paramString, (Drawable)localObject1, localbqjp, "", parambqpa.a, parambqpa.l, i, localbqqu.c(), 0, this.a.d());
          if (QLog.isColorLevel()) {
            QLog.d("DoodleLayout", 2, "add Face result" + bool);
          }
          if ((this.a.b) && (bool)) {}
          for (bool = true;; bool = false)
          {
            DoodleLayout.d(bool);
            return;
            parambqpa.d = 3;
            break;
            localObject1 = localbqqu;
            break label143;
            paramFloat2 = brkm.b / 2;
            break label277;
            i = 0;
            break label356;
          }
        }
        localObject1 = null;
      }
    }
  }
  
  public void a(bqpe parambqpe, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    yuk.a("DoodleLayout", "onLocationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", parambqpe.d, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
    this.a.a(parambqpe, paramFloat1, paramFloat2, paramFloat3);
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    yuq.b("0X80075E3");
  }
  
  public void a(bqpe parambqpe, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
  {
    yuk.b("DoodleLayout", "onComboLocationFaceSelected, pictureUrl:" + parambqpe.d);
    this.a.a(parambqpe, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper);
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    yuq.b("0X80075E3");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a().a(paramString1, paramString2);
    this.a.a().a(paramString1, paramString2);
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void b(bqks parambqks, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    yuk.b("DoodleLayout", "onInformationFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { parambqks, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
    a(parambqks, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqnf
 * JD-Core Version:    0.7.0.1
 */