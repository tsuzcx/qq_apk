import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.PasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceAndTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.ArrayList;
import java.util.List;

public class angt
  implements Runnable
{
  public angt(DynamicFaceLayer paramDynamicFaceLayer, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject2 = (PasterParcelData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (TextUtils.isEmpty(((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString)) {}
      label136:
      label306:
      label461:
      label609:
      label625:
      for (;;)
      {
        i += 1;
        break;
        Object localObject1;
        FaceLayer.LayerParams localLayerParams;
        if ((DynamicFaceLayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer).a != null) && (DynamicFaceLayer.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer).a.b()))
        {
          localObject1 = VasApngUtil.a(BaseApplicationImpl.sApplication.getRuntime(), ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, "-Dynamic-", URLDrawableHelper.a, new int[] { 13 }, "-Dynamic-", null);
          if (localObject1 != null)
          {
            if (((URLDrawable)localObject1).getStatus() != 1) {
              ((URLDrawable)localObject1).restartDownload();
            }
            ((Drawable)localObject1).setCallback(DynamicFaceLayer.c(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer));
            int j = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.left;
            int k = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.right;
            int m = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.top;
            int n = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.bottom;
            if (localObject1 == null) {
              continue;
            }
            ((Drawable)localObject1).setBounds(j, m, k, n);
            if (!TextUtils.isEmpty(((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString)) {
              break label461;
            }
            SLog.b("DynamicFaceLayer", "Create Normal FaceItem.");
            localLayerParams = new FaceLayer.LayerParams(((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.x, ((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.y, ((PasterParcelData)localObject2).jdField_a_of_type_Float, ((PasterParcelData)localObject2).jdField_b_of_type_Float, ((PasterParcelData)localObject2).jdField_c_of_type_Float, ((PasterParcelData)localObject2).jdField_d_of_type_Float, (int)((PasterParcelData)localObject2).e, (int)((PasterParcelData)localObject2).jdField_f_of_type_Float);
            localObject1 = new FaceLayer.FaceItem(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer, (Drawable)localObject1, localLayerParams, ((PasterParcelData)localObject2).jdField_a_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_b_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_d_of_type_Int);
            ((FaceLayer.FaceItem)localObject1).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(((PasterParcelData)localObject2).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
            ((FaceLayer.FaceItem)localObject1).e = 0;
            if (((FaceLayer.FaceItem)localObject1).h == 1) {
              break label609;
            }
            localObject2 = (FaceLayer)DynamicFaceLayer.d(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer).a(FaceLayer.jdField_a_of_type_JavaLangString);
            if (localObject2 != null) {
              ((FaceLayer)localObject2).jdField_a_of_type_JavaUtilList.add(localObject1);
            }
          }
        }
        for (;;)
        {
          if ((DynamicFaceLayer.e(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer).a == null) || (!DynamicFaceLayer.f(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer).a.b())) {
            break label625;
          }
          ((FaceLayer.FaceItem)localObject1).b(true);
          break;
          if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, "apng error");
          }
          localObject1 = null;
          break label136;
          localObject1 = DynamicFaceLayer.a(((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString);
          ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
          ((PasterParcelData)localObject2).jdField_d_of_type_Int = 0;
          localObject1 = DynamicFaceLayer.a((String)localObject1);
          break label136;
          SLog.b("DynamicFaceLayer", "Create FaceAndTextItem with text:" + ((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString);
          localLayerParams = new FaceLayer.LayerParams(((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.x, ((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.y, ((PasterParcelData)localObject2).jdField_a_of_type_Float, ((PasterParcelData)localObject2).jdField_b_of_type_Float, ((PasterParcelData)localObject2).jdField_c_of_type_Float, ((PasterParcelData)localObject2).jdField_d_of_type_Float, (int)((PasterParcelData)localObject2).e, (int)((PasterParcelData)localObject2).jdField_f_of_type_Float, ((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString, ((PasterParcelData)localObject2).g, ((PasterParcelData)localObject2).jdField_f_of_type_Int);
          localObject1 = new FaceLayer.FaceAndTextItem(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer, (Drawable)localObject1, localLayerParams, ((PasterParcelData)localObject2).jdField_a_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_b_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_d_of_type_Int);
          ((FaceLayer.FaceAndTextItem)localObject1).a();
          break label306;
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer.jdField_a_of_type_JavaUtilList.add(localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     angt
 * JD-Core Version:    0.7.0.1
 */