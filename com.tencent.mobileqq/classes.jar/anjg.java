import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InformationFaceConstant;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.InfoStickerDrawable;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class anjg
  implements IFaceSelectedListener
{
  private anjg(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    this.a.a().c();
    this.a.a().c();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void a(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    SLog.b("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { paramSelectedItem, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d == 0) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c == 0)) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d > this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c)) {}
    for (;;)
    {
      FaceLayer.LayerParams localLayerParams = new FaceLayer.LayerParams(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
      if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.report(615, 6);
      }
      FaceLayer localFaceLayer = this.a.a();
      Object localObject = localFaceLayer;
      if (paramSelectedItem.jdField_a_of_type_Int == 1) {
        if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject = localFaceLayer;
          if (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject = this.a.a();
        }
      }
      if (((FaceLayer)localObject).a(paramSelectedItem.jdField_a_of_type_JavaLangString, paramSelectedItem.b, paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localLayerParams, paramString, false, paramSelectedItem.jdField_a_of_type_Int, this.a.d(), paramSegmentKeeper))
      {
        DoodleLayout.a(this.a, (FaceLayer)localObject);
        DoodleLayout.a("clk_oneface");
        VideoEditReport.a("0X80076CA");
        VideoEditReport.b("0X80075DF");
      }
      return;
      paramFloat2 = ScreenUtil.b / 2;
    }
  }
  
  public void a(InfomationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    SLog.a("DoodleLayout", "onInformationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", paramItem.jdField_a_of_type_JavaLangString, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
    this.a.a();
    if (paramItem == null) {
      SLog.e("DoodleLayout", "the item is null.");
    }
    label530:
    label536:
    label540:
    for (;;)
    {
      return;
      SLog.b("DoodleLayout", "addLocationFaceItem:" + paramItem.toString());
      Object localObject1 = paramItem.g;
      paramItem.g = ((QIMInformationPasterManager)QIMManager.a().c(12)).a();
      Object localObject2;
      if (TextUtils.isEmpty(paramItem.g))
      {
        QQStoryContext.a();
        localObject2 = QQStoryContext.a();
        paramItem.g = SharedPreUtils.u(this.a.getContext(), ((AppInterface)localObject2).getCurrentAccountUin());
        if (TextUtils.isEmpty(paramItem.g)) {
          paramItem.g = ((String)localObject1);
        }
      }
      InfoStickerDrawable localInfoStickerDrawable = InformationFaceConstant.a(paramItem, this.a.getContext(), -1L);
      paramItem.g = ((String)localObject1);
      if ((this.a.getContext() instanceof EditPicActivity))
      {
        if (localInfoStickerDrawable == null) {
          break label536;
        }
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), localInfoStickerDrawable.a());
        paramItem.c = 0;
      }
      for (;;)
      {
        label217:
        if (localObject1 == null) {
          break label540;
        }
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "[" + ((Drawable)localObject1).getIntrinsicWidth() + "," + ((Drawable)localObject1).getIntrinsicHeight() + "]");
        }
        label351:
        FaceLayer.LayerParams localLayerParams;
        int i;
        if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d == 0) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c == 0)) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d > this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c))
        {
          localLayerParams = new FaceLayer.LayerParams(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
          localObject2 = this.a.a();
          if ((paramItem.c != 3) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {
            break label530;
          }
          i = 3;
          localObject2 = this.a.a();
        }
        for (;;)
        {
          boolean bool = ((FaceLayer)localObject2).a(paramItem.h, paramItem.jdField_a_of_type_JavaLangString, (Drawable)localObject1, localLayerParams, "", paramItem.jdField_a_of_type_Boolean, paramItem.g, i, localInfoStickerDrawable.c(), 0, this.a.d());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("DoodleLayout", 2, "add Face result" + bool);
          return;
          paramItem.c = 3;
          localObject1 = localInfoStickerDrawable;
          break label217;
          paramFloat2 = ScreenUtil.b / 2;
          break label351;
          i = 0;
        }
        localObject1 = null;
      }
    }
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    SLog.a("DoodleLayout", "onLocationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", paramItem.d, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
    this.a.a(paramItem, paramFloat1, paramFloat2, paramFloat3);
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    VideoEditReport.b("0X80075E3");
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
  {
    SLog.b("DoodleLayout", "onComboLocationFaceSelected, pictureUrl:" + paramItem.d);
    this.a.a(paramItem, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper);
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    VideoEditReport.b("0X80075E3");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a().a(paramString1, paramString2);
    this.a.a().a(paramString1, paramString2);
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anjg
 * JD-Core Version:    0.7.0.1
 */