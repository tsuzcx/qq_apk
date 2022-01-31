import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2;

public class bkgu
  implements bjfu
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QIMCommonLoadingView jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  
  bkgu(bkgs parambkgs, QIMCommonLoadingView paramQIMCommonLoadingView, ImageView paramImageView)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = paramQIMCommonLoadingView;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_JavaLangBoolean = ((Boolean)paramImageView.getTag(2131376851));
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_JavaLangBoolean = null;
  }
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    paramInt = (int)paramFloat;
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.post(new InformationFaceAdapter.DownloadProgressCallback.1(this, paramInt));
  }
  
  public void a(boolean paramBoolean, String paramString, bkgd parambkgd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "isSucess:" + paramBoolean);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.post(new InformationFaceAdapter.DownloadProgressCallback.2(this, paramBoolean, parambkgd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkgu
 * JD-Core Version:    0.7.0.1
 */