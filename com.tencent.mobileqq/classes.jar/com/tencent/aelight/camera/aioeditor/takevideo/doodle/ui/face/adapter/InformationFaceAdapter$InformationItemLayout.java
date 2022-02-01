package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerSaveUtils;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.av.AVNetEngine;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

class InformationFaceAdapter$InformationItemLayout
  extends LinearLayout
{
  private int a;
  private int b;
  private float c;
  private int d;
  private View.OnClickListener e;
  private Context f;
  private BaseFaceListAdapter g;
  
  public InformationFaceAdapter$InformationItemLayout(Context paramContext, int paramInt1, int paramInt2, float paramFloat, View.OnClickListener paramOnClickListener, BaseFaceListAdapter paramBaseFaceListAdapter)
  {
    super(paramContext);
    this.f = paramContext;
    this.e = paramOnClickListener;
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramFloat;
    this.g = paramBaseFaceListAdapter;
    paramInt1 = DisplayUtil.b(getContext(), 6.0F);
    paramInt2 = this.a;
    int i = this.b;
    this.d = ((paramInt2 - (i - 1) * 2 * paramInt1) / i);
    a();
  }
  
  private URLDrawable a(InformationFacePackage.Item paramItem)
  {
    Object localObject1 = InfoStickerSaveUtils.b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramItem.b);
    ((StringBuilder)localObject2).append("_static.png");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = new File((String)localObject1);
    if (((File)localObject1).exists())
    {
      if (!((File)localObject1).isDirectory()) {
        ((File)localObject1).delete();
      }
    }
    else {
      ((File)localObject1).mkdirs();
    }
    localObject1 = new File((File)localObject1, (String)localObject2);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("static file name:");
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      QLog.d("InformationFaceAdapter", 2, ((StringBuilder)localObject2).toString());
    }
    paramItem = new URL(paramItem.e);
    localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).Recycle();
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelperConstants.a;
    return URLDrawable.getDrawable(paramItem, (URLDrawable.URLDrawableOptions)localObject1);
  }
  
  private void a()
  {
    setOrientation(0);
    setGravity(17);
    int j = DisplayUtil.b(getContext(), 12.0F);
    int k = (int)((this.d - j * 2) * this.c);
    int i = 0;
    while (i < this.b)
    {
      View localView = LayoutInflater.from(getContext()).inflate(2131628068, null);
      int m = this.d;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(m, m);
      if (i == 0)
      {
        localLayoutParams.setMargins(0, j, j / 2, 0);
      }
      else if (this.b - 1 == i)
      {
        localLayoutParams.setMargins(j / 2, j, 0, 0);
      }
      else
      {
        m = j / 2;
        localLayoutParams.setMargins(m, j, m, 0);
      }
      localView.setLayoutParams(localLayoutParams);
      ((ImageView)localView.findViewById(2131435789)).setPadding(k, k, k, k);
      addView(localView);
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
  
  private void a(InformationFacePackage.Item paramItem, URLImageView paramURLImageView, QIMCommonLoadingView paramQIMCommonLoadingView, ProgressBar paramProgressBar, InformationFaceAdapter.URLDrawableListener paramURLDrawableListener, boolean paramBoolean, BaseFaceListAdapter paramBaseFaceListAdapter)
  {
    Object localObject1 = InfoStickerSaveUtils.b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramItem.b);
    ((StringBuilder)localObject2).append("_dynamic.png");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = new File((String)localObject1);
    if (((File)localObject1).exists())
    {
      if (!((File)localObject1).isDirectory()) {
        ((File)localObject1).delete();
      }
    }
    else {
      ((File)localObject1).mkdirs();
    }
    localObject2 = new File((File)localObject1, (String)localObject2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("apng file name:");
      ((StringBuilder)localObject1).append(((File)localObject2).getAbsolutePath());
      QLog.d("InformationFaceAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    String str = ((File)localObject2).getAbsolutePath();
    if (((File)localObject2).exists()) {
      try
      {
        bool = ApngDrawable.isApngFile((File)localObject2);
        if (!bool) {}
      }
      catch (IOException localIOException2)
      {
        int i;
        bool = false;
      }
    }
    try
    {
      localObject1 = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), ((File)localObject2).getAbsolutePath(), "-Dynamic-", URLDrawableHelperConstants.a, new int[] { 13 }, "-Dynamic-", null);
      if (localObject1 == null) {
        break label516;
      }
      if (((URLDrawable)localObject1).getStatus() != 1) {
        ((URLDrawable)localObject1).restartDownload();
      }
      i = ((URLDrawable)localObject1).getStatus();
      if (i != 1) {
        break label502;
      }
      try
      {
        paramURLDrawableListener.onLoadSuccessed(paramURLImageView, (URLDrawable)localObject1);
      }
      catch (IOException localIOException1)
      {
        break label314;
      }
      paramURLImageView.setImageDrawable((Drawable)localObject1);
    }
    catch (IOException localIOException3)
    {
      break label314;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("apng invalid file:");
      ((StringBuilder)localObject1).append(((File)localObject2).getAbsolutePath());
      QLog.d("InformationFaceAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    ((File)localObject2).delete();
    break label325;
    label314:
    localIOException2.printStackTrace();
    break label325;
    boolean bool = false;
    label516:
    for (;;)
    {
      label325:
      if (!bool)
      {
        paramURLImageView = new java.lang.ref.WeakReference(paramURLImageView);
        paramQIMCommonLoadingView = new java.lang.ref.WeakReference(paramQIMCommonLoadingView);
        paramProgressBar = new mqq.util.WeakReference(paramProgressBar);
        new java.lang.ref.WeakReference(paramBaseFaceListAdapter);
        paramBaseFaceListAdapter = paramItem.d;
        localHttpNetReq = new HttpNetReq();
        localHttpNetReq.mCallback = new InformationFaceAdapter.InformationItemLayout.1(this, (File)localObject2, paramQIMCommonLoadingView, paramURLImageView, str, paramBoolean, paramURLDrawableListener, paramProgressBar);
        localHttpNetReq.mReqUrl = paramBaseFaceListAdapter;
        if (QLog.isColorLevel())
        {
          paramURLImageView = new StringBuilder();
          paramURLImageView.append("apng url:");
          paramURLImageView.append(paramBaseFaceListAdapter);
          QLog.d("InformationFaceAdapter", 2, paramURLImageView.toString());
        }
        localHttpNetReq.mHttpMethod = 0;
        localHttpNetReq.mOutPath = ((File)localObject2).getAbsolutePath();
        localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        localHttpNetReq.setUserData(paramItem);
        AVNetEngine.a().sendReq(localHttpNetReq);
      }
      return;
      label502:
      if (paramBoolean) {
        break;
      }
      HttpNetReq localHttpNetReq = null;
      break;
    }
  }
  
  public void a(InformationFacePackage paramInformationFacePackage, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.b;
    int i = paramInt1 * j;
    if (paramInt1 == paramInt2 - 1) {
      paramInt1 = paramInformationFacePackage.d();
    } else {
      paramInt1 = i + j;
    }
    a(paramInt1 - i);
    paramInt2 = i;
    while (paramInt2 < paramInt1)
    {
      Object localObject1 = getChildAt(paramInt2 - i);
      Object localObject2 = ((View)localObject1).findViewById(2131435791);
      URLImageView localURLImageView = (URLImageView)((View)localObject1).findViewById(2131435789);
      ProgressBar localProgressBar = (ProgressBar)((View)localObject1).findViewById(2131435790);
      QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)((View)localObject1).findViewById(2131435788);
      if ((this.f instanceof EditPicActivity)) {
        localObject1 = paramInformationFacePackage.b(paramInt2);
      } else {
        localObject1 = paramInformationFacePackage.a(paramInt2);
      }
      if (localObject1 == null)
      {
        SLog.e("InformationFaceAdapter", "FacePackage's thumbUri is empty , pkg : %s", new Object[] { paramInformationFacePackage.toString() });
      }
      else
      {
        ((View)localObject2).setOnClickListener(this.e);
        localURLImageView.setTag(2131446820, Integer.valueOf(paramInt2));
        if (!paramBoolean)
        {
          localProgressBar.setVisibility(4);
          localURLImageView.setImageDrawable(null);
        }
        else
        {
          localURLImageView.setTag(2131446833, localObject1);
          localURLImageView.setTag(2131446799, Boolean.valueOf(false));
          localProgressBar.setVisibility(0);
          localObject2 = new InformationFaceAdapter.URLDrawableListener((String)localObject1, localURLImageView, localProgressBar);
          localURLImageView.setURLDrawableDownListener((URLDrawableDownListener)localObject2);
          if ((this.f instanceof EditPicActivity))
          {
            localObject1 = a((InformationFacePackage.Item)paramInformationFacePackage.l.get(paramInt2));
            if (localObject1 != null)
            {
              if (((URLDrawable)localObject1).getStatus() != 1) {
                ((URLDrawable)localObject1).restartDownload();
              }
              if (((URLDrawable)localObject1).getStatus() == 1) {
                ((InformationFaceAdapter.URLDrawableListener)localObject2).onLoadSuccessed(localURLImageView, (URLDrawable)localObject1);
              }
              if (!paramBoolean) {
                localObject1 = null;
              }
              localURLImageView.setImageDrawable((Drawable)localObject1);
            }
          }
          else
          {
            a((InformationFacePackage.Item)paramInformationFacePackage.l.get(paramInt2), localURLImageView, localQIMCommonLoadingView, localProgressBar, (InformationFaceAdapter.URLDrawableListener)localObject2, paramBoolean, this.g);
          }
        }
      }
      paramInt2 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout
 * JD-Core Version:    0.7.0.1
 */