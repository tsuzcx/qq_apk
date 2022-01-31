import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.StringUtil;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import java.util.List;

class aoam
  implements Runnable
{
  aoam(aoal paramaoal, NormalFacePackage paramNormalFacePackage, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.a(this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Boolean)
    {
      SLog.b("FaceListPage", "FacePkg is already download.show face list.");
      FaceListPage.a(this.jdField_a_of_type_Aoal.a).setMax(1);
      FaceListPage.a(this.jdField_a_of_type_Aoal.a).setProgress(1);
      this.jdField_a_of_type_Aoal.a.postDelayed(new aoan(this), 50L);
    }
    do
    {
      return;
      FaceListPage.a(this.jdField_a_of_type_Aoal.a).setVisibility(4);
      FaceListPage.b(this.jdField_a_of_type_Aoal.a).setVisibility(4);
      FaceListPage.a(this.jdField_a_of_type_Aoal.a).setVisibility(0);
      Object localObject = (String)FaceListPage.a(this.jdField_a_of_type_Aoal.a).getTag(2131362360);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_d_of_type_JavaLangString)))
      {
        FaceListPage.a(this.jdField_a_of_type_Aoal.a).setTag(2131362360, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_d_of_type_JavaLangString);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = FaceListPage.a(this.jdField_a_of_type_Aoal.a);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = FaceListPage.a(this.jdField_a_of_type_Aoal.a);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.c();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.a;
        ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_d_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        FaceListPage.a(this.jdField_a_of_type_Aoal.a).setImageDrawable((Drawable)localObject);
      }
      TextView localTextView = FaceListPage.a(this.jdField_a_of_type_Aoal.a);
      if (TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_b_of_type_JavaLangString)) {}
      for (localObject = "";; localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText((CharSequence)localObject);
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_b_of_type_Boolean) {
          break;
        }
        FaceListPage.a(this.jdField_a_of_type_Aoal.a).setMax(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.c);
        FaceListPage.a(this.jdField_a_of_type_Aoal.a).setProgress(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_d_of_type_Int);
        FaceListPage.b(this.jdField_a_of_type_Aoal.a).setText("正在下载");
        FaceListPage.a(this.jdField_a_of_type_Aoal.a).setVisibility(0);
        return;
      }
      FaceListPage.a(this.jdField_a_of_type_Aoal.a).setMax(1);
      FaceListPage.a(this.jdField_a_of_type_Aoal.a).setProgress(0);
      FaceListPage.b(this.jdField_a_of_type_Aoal.a).setBackgroundResource(2130843452);
      FaceListPage.a(this.jdField_a_of_type_Aoal.a).setVisibility(4);
    } while (StringUtil.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.e));
    FaceListPage.b(this.jdField_a_of_type_Aoal.a).setText(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoam
 * JD-Core Version:    0.7.0.1
 */