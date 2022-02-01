package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;

class FaceListPage$2
  implements Runnable
{
  FaceListPage$2(FaceListPage paramFaceListPage, NormalFacePackage paramNormalFacePackage, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.a(this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Boolean)
    {
      SLog.b("FaceListPage", "FacePkg is already download.show face list.");
      FaceListPage.a(this.this$0).setMax(1);
      FaceListPage.a(this.this$0).setProgress(1);
      this.this$0.postDelayed(new FaceListPage.2.1(this), 30L);
      return;
    }
    FaceListPage.a(this.this$0).setVisibility(4);
    FaceListPage.b(this.this$0).setVisibility(4);
    FaceListPage.a(this.this$0).setVisibility(0);
    Object localObject = (String)FaceListPage.a(this.this$0).getTag(2131378314);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.jdField_d_of_type_JavaLangString)))
    {
      FaceListPage.a(this.this$0).setTag(2131378314, this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.jdField_d_of_type_JavaLangString);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = FaceListPage.a(this.this$0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = FaceListPage.a(this.this$0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.getStickerFailedDrawable();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.jdField_d_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      FaceListPage.a(this.this$0).setImageDrawable((Drawable)localObject);
    }
    TextView localTextView = FaceListPage.a(this.this$0);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.jdField_b_of_type_JavaLangString)) {
      localObject = "";
    } else {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.jdField_b_of_type_JavaLangString;
    }
    localTextView.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.jdField_b_of_type_Boolean)
    {
      FaceListPage.a(this.this$0).setMax(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.c);
      FaceListPage.a(this.this$0).setProgress(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.jdField_d_of_type_Int);
      FaceListPage.b(this.this$0).setText(HardCodeUtil.a(2131704413));
      FaceListPage.a(this.this$0).setVisibility(0);
      return;
    }
    FaceListPage.a(this.this$0).setMax(1);
    FaceListPage.a(this.this$0).setProgress(0);
    FaceListPage.b(this.this$0).setBackgroundResource(2130846721);
    FaceListPage.a(this.this$0).setVisibility(4);
    if (!StringUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.e)) {
      FaceListPage.b(this.this$0).setText(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.2
 * JD-Core Version:    0.7.0.1
 */