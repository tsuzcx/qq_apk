package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.util.PasterUtil;
import com.tencent.aelight.camera.aioeditor.capture.util.PasterUtil.Position;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class NormalFaceAdapter
  extends BaseFaceListAdapter<NormalFacePackage>
  implements View.OnClickListener
{
  private BaseFaceListAdapter.CacheRefMap<String, Drawable> f = new BaseFaceListAdapter.CacheRefMap();
  
  public NormalFaceAdapter(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
  }
  
  private void a(View paramView)
  {
    ImageView localImageView = (ImageView)paramView;
    int j = ((Integer)localImageView.getTag(2131446820)).intValue();
    NormalFacePackage localNormalFacePackage = (NormalFacePackage)this.b;
    StoryReportor.a((Activity)paramView.getContext(), "sticker_element", ((NormalFacePackage)this.b).a, String.valueOf(j));
    int i = localNormalFacePackage.c(j);
    String str1 = Uri.parse(localNormalFacePackage.a(j)).getPath();
    String str2 = new File(str1).getName();
    if ((i == 1) && ((this.a instanceof EditPicActivity)))
    {
      paramView = localNormalFacePackage.b(j);
      if (paramView != null)
      {
        str1 = Uri.parse(paramView).getPath();
        i = 0;
      }
    }
    Drawable localDrawable = (Drawable)this.f.a(str1);
    if (localDrawable == null)
    {
      if (i != 1)
      {
        try
        {
          paramView = Drawable.createFromPath(str1);
        }
        catch (OutOfMemoryError paramView)
        {
          for (;;)
          {
            SLog.c("NormalFaceAdapter", "createFromPath error", paramView);
            paramView = localDrawable;
          }
        }
      }
      else
      {
        paramView = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), str1, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
        if (paramView != null)
        {
          j = paramView.getStatus();
          if (j != 1)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("urlDrawable is not  SUCCESSED :");
              localStringBuilder.append(j);
              QLog.e("NormalFaceAdapter", 2, localStringBuilder.toString());
            }
            if (j == 2) {
              paramView.restartDownload();
            } else {
              paramView.startDownload();
            }
            paramView.setURLDrawableListener(new NormalFaceAdapter.2(this, str1, localNormalFacePackage, localImageView, str2));
            paramView = localDrawable;
          }
        }
        else
        {
          paramView = localDrawable;
          if (QLog.isColorLevel())
          {
            QLog.d("NormalFaceAdapter", 2, "urlDrawable apng error");
            paramView = localDrawable;
          }
        }
      }
      if (paramView != null) {
        this.f.a(str1, paramView);
      }
    }
    else
    {
      this.f.a();
      paramView = localDrawable;
    }
    if (paramView != null)
    {
      paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
      a(localNormalFacePackage, paramView, localImageView, str1, str2, i);
      return;
    }
    paramView = new StringBuilder();
    paramView.append("can create drawable from path:");
    paramView.append(str1);
    SLog.e("NormalFaceAdapter", paramView.toString());
  }
  
  private void a(NormalFacePackage paramNormalFacePackage, Drawable paramDrawable, ImageView paramImageView, String paramString1, String paramString2, int paramInt)
  {
    int i;
    if (paramDrawable.getIntrinsicWidth() > paramDrawable.getIntrinsicHeight()) {
      i = paramDrawable.getIntrinsicWidth();
    } else {
      i = paramDrawable.getIntrinsicHeight();
    }
    int k = paramImageView.getWidth();
    int j;
    if (paramImageView.getPaddingLeft() > paramImageView.getPaddingTop()) {
      j = paramImageView.getPaddingLeft();
    } else {
      j = paramImageView.getPaddingTop();
    }
    if (k > i) {
      f1 = ((k - i) / 2 - j) * 2 + i;
    } else {
      f1 = i - ((i - k) / 2 + j) * 2;
    }
    double d1 = f1 / i;
    double d2 = paramNormalFacePackage.h;
    Double.isNaN(d1);
    float f1 = (float)(d1 * d2);
    paramNormalFacePackage = new SelectedItem(paramNormalFacePackage.b, paramString2, paramDrawable, paramInt);
    paramDrawable = PasterUtil.a();
    this.c.a(paramNormalFacePackage, paramDrawable.a, paramDrawable.b, f1, paramString1, null);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.b == null) {
      return paramView;
    }
    if (paramView == null) {
      paramView = new NormalFaceAdapter.NormalItemLayout(this.a, paramViewGroup.getWidth(), ((NormalFacePackage)this.b).a(), ((NormalFacePackage)this.b).b(), this, this);
    } else {
      paramView = (NormalFaceAdapter.NormalItemLayout)paramView;
    }
    paramView.a((NormalFacePackage)this.b, paramInt, getCount(), a());
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    ThreadManager.postImmediately(new NormalFaceAdapter.1(this, paramView), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.NormalFaceAdapter
 * JD-Core Version:    0.7.0.1
 */