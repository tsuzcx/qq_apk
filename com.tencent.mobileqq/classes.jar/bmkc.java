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

public class bmkc
{
  public static ResourceModel a(int paramInt, @NonNull List<CutModelKt> paramList1, @NonNull List<CutModelKt> paramList2, @NonNull List<CropConfig> paramList, @Nullable MediaModel paramMediaModel)
  {
    LinkedList localLinkedList1 = new LinkedList(paramList1);
    localLinkedList1.addAll(paramInt + 1, paramList2);
    if ((paramMediaModel != null) && (paramMediaModel.getMediaResourceModel() != null) && (!CollectionUtils.isEmpty(paramMediaModel.getMediaResourceModel().getVideos())))
    {
      LinkedList localLinkedList2 = new LinkedList();
      int i = 0;
      while (i < paramList2.size())
      {
        MediaClipModel localMediaClipModel = ((CutModelKt)paramList2.get(i)).convert();
        if (localMediaClipModel.getResource().getType() == 2)
        {
          CropConfig localCropConfig1 = null;
          if (paramList.size() > i) {
            localCropConfig1 = (CropConfig)paramList.get(i);
          }
          CropConfig localCropConfig2 = localCropConfig1;
          if (localCropConfig1 == null) {
            localCropConfig2 = new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
          }
          localMediaClipModel.setConfig(localCropConfig2);
        }
        localLinkedList2.add(localMediaClipModel);
        i += 1;
      }
      paramMediaModel.getMediaResourceModel().getVideos().addAll(paramInt + 1, localLinkedList2);
    }
    return new ResourceModel(((CutModelKt)paramList2.get(0)).getUuid(), true, localLinkedList1, paramList1, new ArrayList(), -1, 0);
  }
  
  public static ResourceModel a(@NonNull String paramString, float paramFloat, @NonNull List<CutModelKt> paramList, @Nullable MediaModel paramMediaModel)
  {
    LinkedList localLinkedList3 = new LinkedList(paramList);
    Object localObject1 = null;
    int i = -1;
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList1 = new LinkedList();
    int j = 0;
    if (j < localLinkedList3.size())
    {
      localObject2 = (CutModelKt)localLinkedList3.get(j);
      if (localObject1 != null) {
        localLinkedList1.add(localObject2);
      }
      for (;;)
      {
        j += 1;
        break;
        if (paramString.equals(((CutModelKt)localObject2).getUuid()))
        {
          localObject1 = localObject2;
          i = j;
        }
        else
        {
          localLinkedList2.add(localObject2);
        }
      }
    }
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject2 = new VideoResourceModelKt(localObject1.getResource().getPath(), localObject1.getResource().getType(), ((float)localObject1.getResource().getSelectTimeDuration() / paramFloat), localObject1.getResource().getSourceTimeStart(), localObject1.getResource().getSourceTimeDuration(), localObject1.getResource().getSourceTimeStartUs(), localObject1.getResource().getSourceTimeDurationUs(), localObject1.getResource().getSelectTimeStart(), localObject1.getResource().getSelectTimeDuration(), localObject1.getResource().getSelectTimeStartUs(), localObject1.getResource().getSelectTimeDurationUs(), localObject1.getResource().getCutTimeStart(), localObject1.getResource().getCutTimeDuration(), localObject1.getResource().getWidth(), localObject1.getResource().getHeight(), localObject1.getResource().getRotate());
      localObject2 = new CutModelKt(localObject1.getUuid(), (VideoResourceModelKt)localObject2, localObject1.getVideoConfiguration(), localObject1.getAudioConfiguration());
    }
    localLinkedList2 = new LinkedList(localLinkedList2);
    if (localObject2 != null) {
      localLinkedList2.add(localObject2);
    }
    localLinkedList2.addAll(localLinkedList1);
    if ((paramMediaModel != null) && (paramMediaModel.getMediaResourceModel() != null) && (!CollectionUtils.isEmpty(paramMediaModel.getMediaResourceModel().getVideos())) && (i != -1) && (paramMediaModel.getMediaResourceModel().getVideos().size() > i))
    {
      paramMediaModel = (MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().get(i);
      if (paramMediaModel.getResource() != null) {
        paramMediaModel.getResource().setScaleDuration(((float)localObject1.getResource().getSelectTimeDuration() / paramFloat));
      }
    }
    return new ResourceModel(paramString, false, localLinkedList2, paramList, new ArrayList(), -1, 0);
  }
  
  public static ResourceModel a(@NonNull String paramString, int paramInt, @NonNull List<CutModelKt> paramList, @Nullable MediaModel paramMediaModel)
  {
    LinkedList localLinkedList = new LinkedList(paramList);
    int i = 0;
    if (i < localLinkedList.size()) {
      if (!paramString.equals(((CutModelKt)localLinkedList.get(i)).getUuid())) {}
    }
    for (;;)
    {
      if (i != -1) {
        localLinkedList.add(paramInt, (CutModelKt)localLinkedList.remove(i));
      }
      if ((paramMediaModel != null) && (paramMediaModel.getMediaResourceModel() != null) && (!CollectionUtils.isEmpty(paramMediaModel.getMediaResourceModel().getVideos())) && (i != -1))
      {
        paramString = (MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().remove(i);
        paramMediaModel.getMediaResourceModel().getVideos().add(paramInt, paramString);
      }
      return new ResourceModel(null, false, localLinkedList, paramList, new ArrayList(), -1, 0);
      i += 1;
      break;
      i = -1;
    }
  }
  
  public static ResourceModel a(@NonNull String paramString, long paramLong1, long paramLong2, @NonNull List<CutModelKt> paramList, @Nullable MediaModel paramMediaModel)
  {
    LinkedList localLinkedList3 = new LinkedList(paramList);
    Object localObject1 = null;
    int i = -1;
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList1 = new LinkedList();
    int j = 0;
    if (j < localLinkedList3.size())
    {
      localObject2 = (CutModelKt)localLinkedList3.get(j);
      if (localObject1 != null) {
        localLinkedList1.add(localObject2);
      }
      for (;;)
      {
        j += 1;
        break;
        if (paramString.equals(((CutModelKt)localObject2).getUuid()))
        {
          localObject1 = localObject2;
          i = j;
        }
        else
        {
          localLinkedList2.add(localObject2);
        }
      }
    }
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject2 = new VideoResourceModelKt(localObject1.getResource().getPath(), localObject1.getResource().getType(), ((float)(paramLong2 / 1000L) / localObject1.getResource().getScaleSpeed()), localObject1.getResource().getSourceTimeStart(), localObject1.getResource().getSourceTimeDuration(), localObject1.getResource().getSourceTimeStartUs(), localObject1.getResource().getSourceTimeDurationUs(), paramLong1 / 1000L, paramLong2 / 1000L, paramLong1, paramLong2, paramLong1 / 1000L, paramLong2 / 1000L, localObject1.getResource().getWidth(), localObject1.getResource().getHeight(), localObject1.getResource().getRotate());
      localObject2 = new CutModelKt(localObject1.getUuid(), (VideoResourceModelKt)localObject2, localObject1.getVideoConfiguration(), localObject1.getAudioConfiguration());
    }
    localLinkedList2 = new LinkedList(localLinkedList2);
    if (localObject2 != null) {
      localLinkedList2.add(localObject2);
    }
    localLinkedList2.addAll(localLinkedList1);
    if ((paramMediaModel != null) && (paramMediaModel.getMediaResourceModel() != null) && (!CollectionUtils.isEmpty(paramMediaModel.getMediaResourceModel().getVideos())) && (i != -1) && (paramMediaModel.getMediaResourceModel().getVideos().size() > i))
    {
      paramMediaModel = (MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().get(i);
      if (paramMediaModel.getResource() != null)
      {
        paramMediaModel.getResource().setScaleDuration(((float)(paramLong2 / 1000L) / localObject1.getResource().getScaleSpeed()));
        paramMediaModel.getResource().setSelectTimeStart(paramLong1 / 1000L);
        paramMediaModel.getResource().setSelectTimeDuration(paramLong2 / 1000L);
      }
    }
    return new ResourceModel(paramString, false, localLinkedList2, paramList, new ArrayList(), -1, 0);
  }
  
  public static ResourceModel a(@NonNull String paramString, @NonNull List<CutModelKt> paramList, @Nullable MediaModel paramMediaModel)
  {
    LinkedList localLinkedList = new LinkedList(paramList);
    int i = 0;
    CutModelKt localCutModelKt;
    if (i < localLinkedList.size())
    {
      localCutModelKt = (CutModelKt)localLinkedList.get(i);
      if (localCutModelKt == null) {}
      while (!paramString.equals(localCutModelKt.getUuid()))
      {
        i += 1;
        break;
      }
    }
    for (paramString = localCutModelKt;; paramString = null)
    {
      if (paramString != null) {
        localLinkedList.remove(paramString);
      }
      if ((paramMediaModel != null) && (paramMediaModel.getMediaResourceModel() != null) && (!CollectionUtils.isEmpty(paramMediaModel.getMediaResourceModel().getVideos())) && (i != -1)) {
        paramMediaModel.getMediaResourceModel().getVideos().remove(i);
      }
      return new ResourceModel(null, false, localLinkedList, paramList, new ArrayList(), -1, 0);
      i = -1;
    }
  }
  
  public static ResourceModel a(@NonNull List<CutModelKt> paramList1, @Nullable List<CutModelKt> paramList2)
  {
    return new ResourceModel(null, false, paramList1, paramList2, new ArrayList(), -1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkc
 * JD-Core Version:    0.7.0.1
 */