package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.util.ImageLoader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;

class NormalFaceAdapter$NormalItemLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFaceListAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter;
  private int b;
  private int c;
  private int d;
  
  public NormalFaceAdapter$NormalItemLayout(Context paramContext, int paramInt1, int paramInt2, float paramFloat, View.OnClickListener paramOnClickListener, BaseFaceListAdapter paramBaseFaceListAdapter)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter = paramBaseFaceListAdapter;
    paramInt1 /= this.b;
    this.c = ((int)(paramInt1 * paramFloat));
    this.d = (paramInt1 - this.c * 2);
    a();
  }
  
  private void a()
  {
    int i = 0;
    setOrientation(0);
    setGravity(17);
    int j = this.jdField_a_of_type_Int / this.b;
    while (i < this.b)
    {
      URLImageView localURLImageView = new URLImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
      if (i == 0) {
        localLayoutParams.leftMargin = DisplayUtil.b(getContext(), 7.0F);
      }
      if (i == this.b - 1) {
        localLayoutParams.rightMargin = DisplayUtil.b(getContext(), 7.0F);
      }
      localURLImageView.setLayoutParams(localLayoutParams);
      int k = this.c;
      localURLImageView.setPadding(k, k, k, k);
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      addView(localURLImageView);
      i += 1;
    }
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    int j;
    for (;;)
    {
      j = paramInt;
      if (i >= paramInt) {
        break;
      }
      j = paramInt;
      if (i >= getChildCount()) {
        break;
      }
      getChildAt(i).setVisibility(0);
      i += 1;
    }
    while ((j < this.b) && (j < getChildCount()))
    {
      getChildAt(j).setVisibility(4);
      j += 1;
    }
  }
  
  public void a(NormalFacePackage paramNormalFacePackage, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.b;
    int i = paramInt1 * j;
    if (paramInt1 == paramInt2 - 1) {
      paramInt1 = paramNormalFacePackage.b();
    } else {
      paramInt1 = i + j;
    }
    a(paramInt1 - i);
    paramInt2 = i;
    while (paramInt2 < paramInt1)
    {
      ImageView localImageView = (ImageView)getChildAt(paramInt2 - i);
      localImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      Object localObject = paramNormalFacePackage.a(paramInt2);
      localImageView.setTag(2131378314, localObject);
      localImageView.setTag(2131378301, Integer.valueOf(paramInt2));
      ImageLoader localImageLoader;
      if (paramNormalFacePackage.a(paramInt2) == 1)
      {
        if ((getContext() instanceof EditPicActivity))
        {
          localObject = paramNormalFacePackage.b(paramInt2);
          localImageView.setTag(2131378314, localObject);
          localImageLoader = ImageLoader.a();
          j = this.d;
          localImageLoader.a(localImageView, (String)localObject, j, j, paramBoolean);
        }
        else
        {
          localObject = Uri.parse((String)localObject).getPath();
          localObject = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), (String)localObject, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
          if (localObject != null)
          {
            if (((URLDrawable)localObject).getStatus() == 2) {
              ((URLDrawable)localObject).restartDownload();
            }
            if (!paramBoolean) {
              localObject = null;
            }
            localImageView.setImageDrawable((Drawable)localObject);
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("NormalFaceAdapter", 2, "urlDrawable apng error");
          }
        }
      }
      else
      {
        localImageLoader = ImageLoader.a();
        j = this.d;
        localImageLoader.a(localImageView, (String)localObject, j, j, paramBoolean);
      }
      paramInt2 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.NormalFaceAdapter.NormalItemLayout
 * JD-Core Version:    0.7.0.1
 */