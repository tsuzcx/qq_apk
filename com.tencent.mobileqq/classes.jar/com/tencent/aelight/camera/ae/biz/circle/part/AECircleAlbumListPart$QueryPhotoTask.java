package com.tencent.aelight.camera.ae.biz.circle.part;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleLoadRecomAutoTemplateDataEvent;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AECircleAlbumListPart$QueryPhotoTask
  extends AsyncTask<Object, Object, List<LocalMediaInfo>>
{
  private boolean b;
  private boolean c;
  
  public AECircleAlbumListPart$QueryPhotoTask(AECircleAlbumListPart paramAECircleAlbumListPart, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramBoolean1;
    this.c = paramBoolean2;
  }
  
  protected List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = AECircleAlbumListPart.a(this.a).c;
    if (localPhotoCommonBaseData.selectedPhotoList == null) {
      localPhotoCommonBaseData.selectedPhotoList = new ArrayList();
    }
    if (localPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
      localPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
    }
    HashMap localHashMap = localPhotoCommonBaseData.selectedMediaInfoHashMap;
    LogTag.a();
    Object localObject1 = AECircleAlbumListPart.b(this.a).a(this.b);
    paramVarArgs = (Object[])localObject1;
    if (localObject1 == null) {
      paramVarArgs = new ArrayList();
    }
    localObject1 = AECircleAlbumListPart.c(this.a);
    int j = 0;
    ((PhotoListBaseData)localObject1).C = 0;
    AECircleAlbumListPart.d(this.a).D = 0;
    System.currentTimeMillis();
    long l = QAlbumUtil.sLastAlbumRecordTime;
    if (QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(localPhotoCommonBaseData.albumId)) {
      ((Integer)QAlbumUtil.sLastAlbumPhotoCountMap.get(localPhotoCommonBaseData.albumId)).intValue();
    }
    Object localObject2;
    if ((AECircleAlbumListPart.e(this.a).O) && (localPhotoCommonBaseData.albumId.equals("$RecentAlbumId")))
    {
      localObject1 = paramVarArgs.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject2).path)))
        {
          PhotoListBaseData.x.remove(((LocalMediaInfo)localObject2).path);
          localHashMap.remove(((LocalMediaInfo)localObject2).path);
        }
      }
      paramVarArgs.addAll(0, PhotoListBaseData.x.values());
    }
    if ((AECircleAlbumListPart.f(this.a).P) && (localPhotoCommonBaseData.albumId.equals("$VideoAlbumId")))
    {
      localObject1 = paramVarArgs.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject2).path)))
        {
          PhotoListBaseData.x.remove(((LocalMediaInfo)localObject2).path);
          localHashMap.remove(((LocalMediaInfo)localObject2).path);
        }
      }
      localObject1 = PhotoListBaseData.x.values().iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
        if ((localObject2 != null) && ("video/mp4".equals(((LocalMediaInfo)localObject2).mMimeType)))
        {
          paramVarArgs.add(i, localObject2);
          i += 1;
        }
      }
    }
    localObject1 = new ArrayList(paramVarArgs.size());
    int i = j;
    while (i < paramVarArgs.size())
    {
      localObject2 = (LocalMediaInfo)paramVarArgs.get(i);
      if (((LocalMediaInfo)localObject2).path != null)
      {
        j = QAlbumUtil.getMediaType((LocalMediaInfo)localObject2);
        ((LocalMediaInfo)localObject2).position = Integer.valueOf(((ArrayList)localObject1).size());
        ((ArrayList)localObject1).add(((LocalMediaInfo)localObject2).path);
        if (localPhotoCommonBaseData.selectedPhotoList.contains(((LocalMediaInfo)localObject2).path))
        {
          ((LocalMediaInfo)localObject2).selectStatus = 1;
          localPhotoCommonBaseData.selectedMediaInfoHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
          if (!localPhotoCommonBaseData.selectedIndex.contains(((LocalMediaInfo)localObject2).position)) {
            localPhotoCommonBaseData.selectedIndex.add(((LocalMediaInfo)localObject2).position);
          }
          if ((AECircleAlbumListPart.g(this.a).B) && (j == 1))
          {
            PhotoListBaseData localPhotoListBaseData = AECircleAlbumListPart.h(this.a);
            localPhotoListBaseData.C += 1;
            if (AECircleAlbumListPart.i(this.a).C == 1) {
              AECircleAlbumListPart.j(this.a).E = ((LocalMediaInfo)localObject2);
            }
          }
          if ((AECircleAlbumListPart.k(this.a).O) && (!localHashMap.containsKey(((LocalMediaInfo)localObject2).path))) {
            localHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
          }
          if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject2).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject2).mMimeType)))
          {
            localObject2 = AECircleAlbumListPart.l(this.a);
            ((PhotoListBaseData)localObject2).D += 1;
          }
        }
        else if ((localPhotoCommonBaseData.selectedPhotoList.size() < localPhotoCommonBaseData.maxSelectNum) && (((LocalMediaInfo)localObject2).path.equals(AECircleAlbumListPart.m(this.a).A)))
        {
          ((LocalMediaInfo)localObject2).selectStatus = 1;
          localPhotoCommonBaseData.selectedPhotoList.add(((LocalMediaInfo)localObject2).path);
          localPhotoCommonBaseData.selectedIndex.add(((LocalMediaInfo)localObject2).position);
          localHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
        }
        else
        {
          ((LocalMediaInfo)localObject2).selectStatus = 2;
        }
      }
      i += 1;
    }
    localPhotoCommonBaseData.mediaPathsList = ((ArrayList)localObject1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QueryPhotoTask,doInBackground,mediaList.size :");
      ((StringBuilder)localObject1).append(paramVarArgs.size());
      QLog.d("AECircleAlbumListPart", 2, ((StringBuilder)localObject1).toString());
    }
    return paramVarArgs;
  }
  
  protected void a(List<LocalMediaInfo> paramList)
  {
    long l = System.currentTimeMillis();
    AECircleAlbumListPart.n(this.a).a(paramList, this.b);
    if (this.b)
    {
      paramList = this.a;
      boolean bool = false;
      paramList.a(false, false);
      SimpleEventBus.getInstance().dispatchEvent(new AECircleLoadRecomAutoTemplateDataEvent());
      paramList = AECircleAlbumListPart.o(this.a).i();
      if (AECircleAlbumListPart.p(this.a).m.initialHasPickedNum > 0) {
        bool = true;
      }
      AEReportUtils.a(bool, paramList);
    }
    paramList = new StringBuilder();
    paramList.append("[onPostExecute] + END, time cost = ");
    paramList.append(System.currentTimeMillis() - l);
    AEQLog.b("[Performance2]AECircleAlbumListPart", paramList.toString());
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleAlbumListPart.QueryPhotoTask
 * JD-Core Version:    0.7.0.1
 */