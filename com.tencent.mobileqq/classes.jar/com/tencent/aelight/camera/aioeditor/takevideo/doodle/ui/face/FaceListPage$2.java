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
    this.a.a(this.b);
    if (this.c)
    {
      SLog.b("FaceListPage", "FacePkg is already download.show face list.");
      FaceListPage.a(this.this$0).setMax(1);
      FaceListPage.a(this.this$0).setProgress(1);
      this.this$0.postDelayed(new FaceListPage.2.1(this), 30L);
      return;
    }
    FaceListPage.d(this.this$0).setVisibility(4);
    FaceListPage.c(this.this$0).setVisibility(4);
    FaceListPage.b(this.this$0).setVisibility(0);
    Object localObject = (String)FaceListPage.f(this.this$0).getTag(2131446833);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(this.a.d)))
    {
      FaceListPage.f(this.this$0).setTag(2131446833, this.a.d);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = FaceListPage.g(this.this$0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = FaceListPage.g(this.this$0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.getStickerFailedDrawable();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      localObject = URLDrawable.getDrawable(this.a.d, (URLDrawable.URLDrawableOptions)localObject);
      FaceListPage.f(this.this$0).setImageDrawable((Drawable)localObject);
    }
    TextView localTextView = FaceListPage.h(this.this$0);
    if (TextUtils.isEmpty(this.a.b)) {
      localObject = "";
    } else {
      localObject = this.a.b;
    }
    localTextView.setText((CharSequence)localObject);
    if (this.a.n)
    {
      FaceListPage.a(this.this$0).setMax(this.a.o);
      FaceListPage.a(this.this$0).setProgress(this.a.p);
      FaceListPage.i(this.this$0).setText(HardCodeUtil.a(2131902326));
      FaceListPage.a(this.this$0).setVisibility(0);
      return;
    }
    FaceListPage.a(this.this$0).setMax(1);
    FaceListPage.a(this.this$0).setProgress(0);
    FaceListPage.i(this.this$0).setBackgroundResource(2130848273);
    FaceListPage.a(this.this$0).setVisibility(4);
    if (!StringUtil.isEmpty(this.a.f)) {
      FaceListPage.i(this.this$0).setText(this.a.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.2
 * JD-Core Version:    0.7.0.1
 */