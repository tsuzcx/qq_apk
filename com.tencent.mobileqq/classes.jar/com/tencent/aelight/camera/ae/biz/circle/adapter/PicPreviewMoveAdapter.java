package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.content.Context;
import android.provider.MediaStore.Images.Thumbnails;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.log.AEQLog;
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
  public String a = "";
  private ArrayList<String> b;
  private LayoutInflater c;
  private Context d;
  private int e = 9;
  private PicPreviewMoveAdapter.PicOperationListener f;
  private AECirclePhotoListLogic g;
  private HashMap<String, LocalMediaInfo> h;
  
  public PicPreviewMoveAdapter(@NonNull Context paramContext, AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    this.d = paramContext;
    this.g = paramAECirclePhotoListLogic;
    this.c = LayoutInflater.from(paramContext);
    paramContext = this.g;
    if ((paramContext != null) && (paramContext.c != null) && (this.g.c.selectedPhotoList != null)) {
      this.h = this.g.e().selectedMediaInfoHashMap;
    }
  }
  
  public PicPreviewMoveAdapter(@NonNull Context paramContext, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    this.d = paramContext;
    this.h = paramHashMap;
    this.c = LayoutInflater.from(paramContext);
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    if (paramInt >= 0)
    {
      if (paramInt > ((ArrayList)localObject).size()) {
        return;
      }
      localObject = this.h;
      if (localObject != null)
      {
        localObject = (LocalMediaInfo)((HashMap)localObject).get(this.b.get(paramInt));
        if ((localObject != null) && (localObject != null)) {
          ((LocalMediaInfo)localObject).selectStatus = 2;
        }
        if (localObject != null) {
          this.h.remove(((LocalMediaInfo)localObject).path);
        }
      }
      this.b.remove(paramInt);
      notifyItemRemoved(paramInt);
      notifyItemRangeChanged(paramInt, getItemCount() - paramInt);
      localObject = this.f;
      if (localObject != null) {
        ((PicPreviewMoveAdapter.PicOperationListener)localObject).a(paramInt);
      }
    }
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList = this.b;
    if (localArrayList == null) {
      return;
    }
    if (paramInt >= 0)
    {
      if (paramInt > localArrayList.size()) {
        return;
      }
      this.b.remove(paramInt);
      notifyItemRemoved(paramInt);
      notifyItemRangeChanged(paramInt, getItemCount() - paramInt, "payload");
    }
  }
  
  public void a(PicPreviewMoveAdapter.PicOperationListener paramPicOperationListener)
  {
    this.f = paramPicOperationListener;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.b = paramArrayList;
    if (this.b == null) {
      this.b = new ArrayList();
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.b;
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
      Object localObject = (String)this.b.get(paramInt);
      localObject = (PicPreviewMoveAdapter.PicViewHolder)paramViewHolder;
      ((PicPreviewMoveAdapter.PicViewHolder)localObject).itemView.setVisibility(0);
      ((PicPreviewMoveAdapter.PicViewHolder)localObject).a.setVisibility(8);
      if (this.a.equals("AutoTemplateMidPage"))
      {
        paramViewHolder = this.b;
        if ((paramViewHolder != null) && (paramViewHolder.size() == 1)) {
          PicPreviewMoveAdapter.PicViewHolder.a((PicPreviewMoveAdapter.PicViewHolder)localObject).setVisibility(8);
        }
      }
      paramViewHolder = this.h;
      if (paramViewHolder != null)
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramViewHolder.get(this.b.get(paramInt));
        if (localLocalMediaInfo != null)
        {
          paramInt = QAlbumUtil.getMediaType(localLocalMediaInfo);
          if (paramInt == 0)
          {
            paramViewHolder = MediaStore.Images.Thumbnails.getThumbnail(this.d.getContentResolver(), localLocalMediaInfo._id, 3, null);
            PicPreviewMoveAdapter.PicViewHolder.b((PicPreviewMoveAdapter.PicViewHolder)localObject).setImageBitmap(paramViewHolder);
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
            PicPreviewMoveAdapter.PicViewHolder.b((PicPreviewMoveAdapter.PicViewHolder)localObject).setImageDrawable(paramViewHolder);
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
        else
        {
          AEQLog.d("QCirclePicPreviewMoveAdapter", "localMediaInfo == null");
        }
      }
      else
      {
        AEQLog.d("QCirclePicPreviewMoveAdapter", "mMediaInfoHashMap == null");
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
      return new PicPreviewMoveAdapter.PicViewHolder(this, this.c.inflate(2064056382, paramViewGroup, false));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PicPreviewMoveAdapter
 * JD-Core Version:    0.7.0.1
 */