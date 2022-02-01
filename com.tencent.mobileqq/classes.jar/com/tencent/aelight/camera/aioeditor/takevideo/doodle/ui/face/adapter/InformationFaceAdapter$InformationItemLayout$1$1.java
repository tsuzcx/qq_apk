package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.VasApngUtil;
import java.lang.ref.WeakReference;

class InformationFaceAdapter$InformationItemLayout$1$1
  implements Runnable
{
  InformationFaceAdapter$InformationItemLayout$1$1(InformationFaceAdapter.InformationItemLayout.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    ((QIMCommonLoadingView)this.b.b.get()).setVisibility(8);
    ((ImageView)this.b.c.get()).setVisibility(0);
    if (this.a)
    {
      URLDrawable localURLDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), this.b.d, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
      if (localURLDrawable != null)
      {
        ImageView localImageView = (ImageView)this.b.c.get();
        if (this.b.e) {
          localObject = localURLDrawable;
        } else {
          localObject = null;
        }
        localImageView.setImageDrawable((Drawable)localObject);
        ((ImageView)this.b.c.get()).setTag(2131446799, Boolean.valueOf(true));
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.restartDownload();
        }
        if (localURLDrawable.getStatus() == 1) {
          this.b.f.onLoadSuccessed((View)this.b.c.get(), localURLDrawable);
        }
        Object localObject = (ImageView)this.b.c.get();
        if (!this.b.e) {
          localURLDrawable = null;
        }
        ((ImageView)localObject).setImageDrawable(localURLDrawable);
      }
    }
    else
    {
      ((ImageView)this.b.c.get()).setImageDrawable(URLDrawableHelperConstants.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout.1.1
 * JD-Core Version:    0.7.0.1
 */