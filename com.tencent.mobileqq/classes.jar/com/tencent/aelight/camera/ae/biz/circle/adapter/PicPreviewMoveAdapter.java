package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PicPreviewMoveAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int = 9;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AECirclePhotoListLogic jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic;
  private PicPreviewMoveAdapter.PicOperationListener jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter$PicOperationListener;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  public PicPreviewMoveAdapter(@NonNull Context paramContext, AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic = paramAECirclePhotoListLogic;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject == null) {
      return;
    }
    if (paramInt >= 0)
    {
      if (paramInt > ((ArrayList)localObject).size()) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic;
      if ((localObject != null) && (((AECirclePhotoListLogic)localObject).a != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a.selectedPhotoList != null))
      {
        localObject = (LocalMediaInfo)this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.get(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        if ((localObject != null) && (localObject != null)) {
          ((LocalMediaInfo)localObject).selectStatus = 2;
        }
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.remove(((LocalMediaInfo)localObject).path);
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
      notifyItemRemoved(paramInt);
      notifyItemRangeChanged(paramInt, getItemCount() - paramInt);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter$PicOperationListener;
      if (localObject != null) {
        ((PicPreviewMoveAdapter.PicOperationListener)localObject).a(paramInt);
      }
    }
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return;
    }
    if (paramInt >= 0)
    {
      if (paramInt > localArrayList.size()) {
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
      notifyItemRemoved(paramInt);
      notifyItemRangeChanged(paramInt, getItemCount() - paramInt, "payload");
    }
  }
  
  public void a(PicPreviewMoveAdapter.PicOperationListener paramPicOperationListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter$PicOperationListener = paramPicOperationListener;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return 101;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder.getItemViewType() == 101)
    {
      Object localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localObject = (PicPreviewMoveAdapter.PicViewHolder)paramViewHolder;
      ((PicPreviewMoveAdapter.PicViewHolder)localObject).itemView.setVisibility(0);
      ((PicPreviewMoveAdapter.PicViewHolder)localObject).a.setVisibility(8);
      paramViewHolder = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic;
      if ((paramViewHolder != null) && (paramViewHolder.a != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a.selectedPhotoList != null))
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.get(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        if (localLocalMediaInfo != null)
        {
          paramInt = QAlbumUtil.getMediaType(localLocalMediaInfo);
          if (paramInt == 0)
          {
            paramViewHolder = URLDrawableHelper.getDrawable(QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo));
            PicPreviewMoveAdapter.PicViewHolder.a((PicPreviewMoveAdapter.PicViewHolder)localObject).setImageDrawable(paramViewHolder);
            return;
          }
          if (paramInt == 1)
          {
            if (localLocalMediaInfo.isSystemMeidaStore) {
              paramViewHolder = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "VIDEO");
            } else {
              paramViewHolder = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "APP_VIDEO");
            }
            paramInt = AlbumThumbDownloader.THUMB_WIDHT;
            localLocalMediaInfo.thumbHeight = paramInt;
            localLocalMediaInfo.thumbWidth = paramInt;
            paramViewHolder = URLDrawableHelper.getDrawable(paramViewHolder);
            PicPreviewMoveAdapter.PicViewHolder.a((PicPreviewMoveAdapter.PicViewHolder)localObject).setImageDrawable(paramViewHolder);
            paramViewHolder = ((PicPreviewMoveAdapter.PicViewHolder)localObject).a;
            if ((!localLocalMediaInfo.isSystemMeidaStore) && (localLocalMediaInfo.mDuration <= 0L))
            {
              paramViewHolder.setVisibility(8);
              return;
            }
            paramViewHolder.setVisibility(0);
            paramViewHolder.setText(QAlbumUtil.formatTimeToString(localLocalMediaInfo.mDuration));
          }
        }
      }
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt, List<Object> paramList)
  {
    if (paramList.isEmpty())
    {
      onBindViewHolder(paramViewHolder, paramInt);
      return;
    }
    if (paramViewHolder.getItemViewType() == 101) {
      ((PicPreviewMoveAdapter.PicViewHolder)paramViewHolder).itemView.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 101) {
      return new PicPreviewMoveAdapter.PicViewHolder(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2064318513, paramViewGroup, false));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PicPreviewMoveAdapter
 * JD-Core Version:    0.7.0.1
 */