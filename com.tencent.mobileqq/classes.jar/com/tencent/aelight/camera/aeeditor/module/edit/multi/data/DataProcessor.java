package com.tencent.aelight.camera.aeeditor.module.edit.multi.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.ae.album.data.AEAlbumImageModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumMediaBaseModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumVideoModel;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.tavcut.util.VideoUtil;
import com.tencent.qcircle.weseevideo.model.resource.AudioConfigurationModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoConfigurationModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DataProcessor
{
  public static MediaClipModel a(@NonNull AEAlbumImageModel paramAEAlbumImageModel)
  {
    return a(paramAEAlbumImageModel, false);
  }
  
  public static MediaClipModel a(@NonNull AEAlbumImageModel paramAEAlbumImageModel, boolean paramBoolean)
  {
    MediaClipModel localMediaClipModel = new MediaClipModel();
    VideoResourceModel localVideoResourceModel = new VideoResourceModel();
    localVideoResourceModel.setPath(paramAEAlbumImageModel.getPath());
    localVideoResourceModel.setType(2);
    if (paramBoolean)
    {
      localVideoResourceModel.setSelectTimeDurationUs(5000000L);
      localVideoResourceModel.setSourceTimeDurationUs(5000000L);
      localVideoResourceModel.setScaleDuration(5000L);
    }
    else
    {
      localVideoResourceModel.setSelectTimeDurationUs(2500000L);
      localVideoResourceModel.setSourceTimeDurationUs(3000000L);
      localVideoResourceModel.setScaleDuration(2500L);
    }
    paramAEAlbumImageModel = BitmapUtil.getImageSize(paramAEAlbumImageModel.getPath());
    localVideoResourceModel.setWidth(paramAEAlbumImageModel.getWidth());
    localVideoResourceModel.setHeight(paramAEAlbumImageModel.getHeight());
    localVideoResourceModel.setRotate(0);
    localMediaClipModel.setResource(localVideoResourceModel);
    localMediaClipModel.setVideoConfigurationModel(new VideoConfigurationModel());
    localMediaClipModel.setAudioConfigurationModel(new AudioConfigurationModel());
    return localMediaClipModel;
  }
  
  public static MediaClipModel a(@NonNull AEAlbumVideoModel paramAEAlbumVideoModel)
  {
    MediaClipModel localMediaClipModel = new MediaClipModel();
    VideoResourceModel localVideoResourceModel = new VideoResourceModel();
    localVideoResourceModel.setPath(paramAEAlbumVideoModel.getPath());
    localVideoResourceModel.setType(1);
    long l1 = DecoderUtils.getDuration(paramAEAlbumVideoModel.getPath()) / 1000L;
    long l2 = 1000L * l1 - 1L;
    localVideoResourceModel.setSelectTimeDurationUs(l2);
    localVideoResourceModel.setSourceTimeDurationUs(l2);
    localVideoResourceModel.setScaleDuration(l1 - 1L);
    paramAEAlbumVideoModel = VideoUtil.getVideoSize(paramAEAlbumVideoModel.getPath());
    localVideoResourceModel.setWidth(paramAEAlbumVideoModel.getWidth());
    localVideoResourceModel.setHeight(paramAEAlbumVideoModel.getHeight());
    localVideoResourceModel.setRotate(0);
    localMediaClipModel.setResource(localVideoResourceModel);
    localMediaClipModel.setVideoConfigurationModel(new VideoConfigurationModel());
    localMediaClipModel.setAudioConfigurationModel(new AudioConfigurationModel());
    return localMediaClipModel;
  }
  
  public static List<MediaClipModel> a(@Nullable List<AEAlbumMediaBaseModel> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return new LinkedList();
    }
    LinkedList localLinkedList = new LinkedList();
    if ((paramList.size() == 1) && ((paramList.get(0) instanceof AEAlbumImageModel)))
    {
      localLinkedList.add(a((AEAlbumImageModel)paramList.get(0)));
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AEAlbumMediaBaseModel localAEAlbumMediaBaseModel = (AEAlbumMediaBaseModel)localIterator.next();
      paramList = null;
      if ((localAEAlbumMediaBaseModel instanceof AEAlbumVideoModel)) {
        paramList = a((AEAlbumVideoModel)localAEAlbumMediaBaseModel);
      } else if ((localAEAlbumMediaBaseModel instanceof AEAlbumImageModel)) {
        paramList = a((AEAlbumImageModel)localAEAlbumMediaBaseModel);
      }
      if (paramList != null) {
        localLinkedList.add(paramList);
      }
    }
    return localLinkedList;
  }
  
  public static List<CropConfig> b(@Nullable List<AEAlbumMediaBaseModel> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return new LinkedList();
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AEAlbumMediaBaseModel localAEAlbumMediaBaseModel = (AEAlbumMediaBaseModel)localIterator.next();
      paramList = null;
      if ((localAEAlbumMediaBaseModel instanceof AEAlbumImageModel))
      {
        paramList = ((AEAlbumImageModel)localAEAlbumMediaBaseModel).getEditorPicInfo();
        if (paramList != null) {
          paramList = new CropConfig((float)paramList.x, (float)paramList.y, (float)Math.min(paramList.w, 1.0D), (float)paramList.h);
        } else {
          paramList = new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
        }
      }
      localLinkedList.add(paramList);
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.data.DataProcessor
 * JD-Core Version:    0.7.0.1
 */