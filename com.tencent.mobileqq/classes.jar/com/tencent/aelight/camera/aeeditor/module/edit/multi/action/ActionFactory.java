package com.tencent.aelight.camera.aeeditor.module.edit.multi.action;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.ResourceModel;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ActionFactory
{
  public static ResourceModel a(int paramInt, @NonNull List<CutModelKt> paramList1, @NonNull List<CutModelKt> paramList2, @NonNull List<CropConfig> paramList, @Nullable MediaModel paramMediaModel)
  {
    LinkedList localLinkedList1 = new LinkedList(paramList1);
    int i = paramInt + 1;
    localLinkedList1.addAll(i, paramList2);
    if ((paramMediaModel != null) && (paramMediaModel.getMediaResourceModel() != null) && (!CollectionUtils.isEmpty(paramMediaModel.getMediaResourceModel().getVideos())))
    {
      LinkedList localLinkedList2 = new LinkedList();
      paramInt = 0;
      while (paramInt < paramList2.size())
      {
        MediaClipModel localMediaClipModel = ((CutModelKt)paramList2.get(paramInt)).convert();
        if (localMediaClipModel.getResource().getType() == 2)
        {
          CropConfig localCropConfig1 = null;
          if (paramList.size() > paramInt) {
            localCropConfig1 = (CropConfig)paramList.get(paramInt);
          }
          CropConfig localCropConfig2 = localCropConfig1;
          if (localCropConfig1 == null) {
            localCropConfig2 = new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
          }
          localMediaClipModel.setConfig(localCropConfig2);
        }
        localLinkedList2.add(localMediaClipModel);
        paramInt += 1;
      }
      paramMediaModel.getMediaResourceModel().getVideos().addAll(i, localLinkedList2);
    }
    return new ResourceModel(((CutModelKt)paramList2.get(0)).getUuid(), true, localLinkedList1, paramList1, new ArrayList(), -1, 0);
  }
  
  public static ResourceModel a(@NonNull String paramString, float paramFloat, @NonNull List<CutModelKt> paramList, @Nullable MediaModel paramMediaModel)
  {
    LinkedList localLinkedList3 = new LinkedList(paramList);
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject2 = null;
    int i = 0;
    Object localObject1 = null;
    int j = -1;
    while (i < localLinkedList3.size())
    {
      localObject3 = (CutModelKt)localLinkedList3.get(i);
      if (localObject1 != null)
      {
        localLinkedList1.add(localObject3);
      }
      else if (paramString.equals(((CutModelKt)localObject3).getUuid()))
      {
        j = i;
        localObject1 = localObject3;
      }
      else
      {
        localLinkedList2.add(localObject3);
      }
      i += 1;
    }
    if (localObject1 != null)
    {
      localObject2 = new VideoResourceModelKt(localObject1.getResource().getPath(), localObject1.getResource().getType(), ((float)localObject1.getResource().getSelectTimeDuration() / paramFloat), localObject1.getResource().getSourceTimeStart(), localObject1.getResource().getSourceTimeDuration(), localObject1.getResource().getSourceTimeStartUs(), localObject1.getResource().getSourceTimeDurationUs(), localObject1.getResource().getSelectTimeStart(), localObject1.getResource().getSelectTimeDuration(), localObject1.getResource().getSelectTimeStartUs(), localObject1.getResource().getSelectTimeDurationUs(), localObject1.getResource().getCutTimeStart(), localObject1.getResource().getCutTimeDuration(), localObject1.getResource().getWidth(), localObject1.getResource().getHeight(), localObject1.getResource().getRotate());
      localObject2 = new CutModelKt(localObject1.getUuid(), (VideoResourceModelKt)localObject2, localObject1.getVideoConfiguration(), localObject1.getAudioConfiguration());
    }
    Object localObject3 = new LinkedList(localLinkedList2);
    if (localObject2 != null) {
      ((List)localObject3).add(localObject2);
    }
    ((List)localObject3).addAll(localLinkedList1);
    if ((paramMediaModel != null) && (paramMediaModel.getMediaResourceModel() != null) && (!CollectionUtils.isEmpty(paramMediaModel.getMediaResourceModel().getVideos())) && (j != -1) && (paramMediaModel.getMediaResourceModel().getVideos().size() > j))
    {
      paramMediaModel = (MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().get(j);
      if (paramMediaModel.getResource() != null) {
        paramMediaModel.getResource().setScaleDuration(((float)localObject1.getResource().getSelectTimeDuration() / paramFloat));
      }
    }
    return new ResourceModel(paramString, false, (List)localObject3, paramList, new ArrayList(), -1, 0);
  }
  
  public static ResourceModel a(@NonNull String paramString, int paramInt, @NonNull List<CutModelKt> paramList, @Nullable MediaModel paramMediaModel)
  {
    LinkedList localLinkedList = new LinkedList(paramList);
    int i = 0;
    while (i < localLinkedList.size())
    {
      if (paramString.equals(((CutModelKt)localLinkedList.get(i)).getUuid())) {
        break label62;
      }
      i += 1;
    }
    i = -1;
    label62:
    if (i != -1) {
      localLinkedList.add(paramInt, (CutModelKt)localLinkedList.remove(i));
    }
    if ((paramMediaModel != null) && (paramMediaModel.getMediaResourceModel() != null) && (!CollectionUtils.isEmpty(paramMediaModel.getMediaResourceModel().getVideos())) && (i != -1))
    {
      paramString = (MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().remove(i);
      paramMediaModel.getMediaResourceModel().getVideos().add(paramInt, paramString);
    }
    return new ResourceModel(null, false, localLinkedList, paramList, new ArrayList(), -1, 0);
  }
  
  public static ResourceModel a(@NonNull String paramString, long paramLong1, long paramLong2, @NonNull List<CutModelKt> paramList, @Nullable MediaModel paramMediaModel)
  {
    LinkedList localLinkedList3 = new LinkedList(paramList);
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject2 = null;
    int i = 0;
    Object localObject1 = null;
    int j = -1;
    while (i < localLinkedList3.size())
    {
      localObject3 = (CutModelKt)localLinkedList3.get(i);
      if (localObject1 != null)
      {
        localLinkedList1.add(localObject3);
      }
      else if (paramString.equals(((CutModelKt)localObject3).getUuid()))
      {
        j = i;
        localObject1 = localObject3;
      }
      else
      {
        localLinkedList2.add(localObject3);
      }
      i += 1;
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1.getResource().getPath();
      i = localObject1.getResource().getType();
      long l1 = paramLong2 / 1000L;
      long l2 = ((float)l1 / localObject1.getResource().getScaleSpeed());
      long l3 = localObject1.getResource().getSourceTimeStart();
      long l4 = localObject1.getResource().getSourceTimeDuration();
      long l5 = localObject1.getResource().getSourceTimeStartUs();
      long l6 = localObject1.getResource().getSourceTimeDurationUs();
      long l7 = paramLong1 / 1000L;
      localObject2 = new VideoResourceModelKt((String)localObject2, i, l2, l3, l4, l5, l6, l7, l1, paramLong1, paramLong2, l7, l1, localObject1.getResource().getWidth(), localObject1.getResource().getHeight(), localObject1.getResource().getRotate());
      localObject2 = new CutModelKt(localObject1.getUuid(), (VideoResourceModelKt)localObject2, localObject1.getVideoConfiguration(), localObject1.getAudioConfiguration());
    }
    Object localObject3 = new LinkedList(localLinkedList2);
    if (localObject2 != null) {
      ((List)localObject3).add(localObject2);
    }
    ((List)localObject3).addAll(localLinkedList1);
    if ((paramMediaModel != null) && (paramMediaModel.getMediaResourceModel() != null) && (!CollectionUtils.isEmpty(paramMediaModel.getMediaResourceModel().getVideos())) && (j != -1) && (paramMediaModel.getMediaResourceModel().getVideos().size() > j))
    {
      paramMediaModel = (MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().get(j);
      if (paramMediaModel.getResource() != null)
      {
        paramMediaModel.getResource().setScaleDuration(((float)(paramLong2 / 1000L) / localObject1.getResource().getScaleSpeed()));
        paramMediaModel.getResource().setSelectTimeStartUs(paramLong1);
        paramMediaModel.getResource().setSelectTimeDurationUs(paramLong2);
      }
    }
    return new ResourceModel(paramString, false, (List)localObject3, paramList, new ArrayList(), -1, 0);
  }
  
  public static ResourceModel a(@NonNull String paramString, @NonNull List<CutModelKt> paramList, @Nullable MediaModel paramMediaModel)
  {
    LinkedList localLinkedList = new LinkedList(paramList);
    int i = 0;
    while (i < localLinkedList.size())
    {
      CutModelKt localCutModelKt = (CutModelKt)localLinkedList.get(i);
      if ((localCutModelKt != null) && (paramString.equals(localCutModelKt.getUuid())))
      {
        paramString = localCutModelKt;
        break label73;
      }
      i += 1;
    }
    paramString = null;
    i = -1;
    label73:
    if (paramString != null) {
      localLinkedList.remove(paramString);
    }
    if ((paramMediaModel != null) && (paramMediaModel.getMediaResourceModel() != null) && (!CollectionUtils.isEmpty(paramMediaModel.getMediaResourceModel().getVideos())) && (i != -1)) {
      paramMediaModel.getMediaResourceModel().getVideos().remove(i);
    }
    return new ResourceModel(null, false, localLinkedList, paramList, new ArrayList(), -1, 0);
  }
  
  public static ResourceModel a(@NonNull List<CutModelKt> paramList1, @Nullable List<CutModelKt> paramList2)
  {
    return new ResourceModel(null, false, paramList1, paramList2, new ArrayList(), -1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.action.ActionFactory
 * JD-Core Version:    0.7.0.1
 */