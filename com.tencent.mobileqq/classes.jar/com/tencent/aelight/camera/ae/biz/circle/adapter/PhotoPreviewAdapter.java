package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.widget.AECircleVideoPreviewItemView;
import com.tencent.aelight.camera.ae.biz.circle.widget.MultiTouchImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class PhotoPreviewAdapter
  extends RecyclerView.Adapter<PhotoPreviewAdapter.PhotoPreviewVH>
{
  private final Context jdField_a_of_type_AndroidContentContext;
  public ColorDrawable a;
  private AECirclePhotoListLogic jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener;
  public ArrayList<LocalMediaInfo> a;
  
  public PhotoPreviewAdapter(Context paramContext, AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic = paramAECirclePhotoListLogic;
  }
  
  private View a()
  {
    AECircleVideoPreviewItemView localAECircleVideoPreviewItemView = new AECircleVideoPreviewItemView(this.jdField_a_of_type_AndroidContentContext);
    localAECircleVideoPreviewItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    return localAECircleVideoPreviewItemView;
  }
  
  private URLDrawable.URLDrawableOptions a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
    localURLDrawableOptions.mFailedDrawable = localColorDrawable;
    return localURLDrawableOptions;
  }
  
  private URLDrawableDownListener a()
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawableDownListener == null) {
      this.jdField_a_of_type_ComTencentImageURLDrawableDownListener = new PhotoPreviewAdapter.1(this);
    }
    return this.jdField_a_of_type_ComTencentImageURLDrawableDownListener;
  }
  
  private View b()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2064318476, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    return localView;
  }
  
  public PhotoPreviewAdapter.PhotoPreviewVH a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return new PhotoPreviewAdapter.PhotoPreviewVH(a());
    }
    return new PhotoPreviewAdapter.PhotoPreviewVH(b());
  }
  
  public void a(int paramInt, PhotoPreviewAdapter.PhotoPreviewVH paramPhotoPreviewVH)
  {
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramPhotoPreviewVH.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetMultiTouchImageView.setURLDrawableDownListener(a());
    paramPhotoPreviewVH.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetMultiTouchImageView.setImageDrawable(URLDrawable.getFileDrawable(localLocalMediaInfo.path, a()));
  }
  
  public void a(PhotoPreviewAdapter.PhotoPreviewVH paramPhotoPreviewVH, int paramInt)
  {
    int i = getItemViewType(paramInt);
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      b(paramInt, paramPhotoPreviewVH);
      return;
    }
    a(paramInt, paramPhotoPreviewVH);
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      ThreadManager.getUIHandler().post(new PhotoPreviewAdapter.2(this));
    }
  }
  
  public void b(int paramInt, PhotoPreviewAdapter.PhotoPreviewVH paramPhotoPreviewVH)
  {
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramPhotoPreviewVH.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetAECircleVideoPreviewItemView.a(localLocalMediaInfo);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */