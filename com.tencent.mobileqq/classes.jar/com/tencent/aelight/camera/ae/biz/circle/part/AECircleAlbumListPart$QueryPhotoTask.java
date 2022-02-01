package com.tencent.aelight.camera.ae.biz.circle.part;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.log.AEQLog;
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
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public AECircleAlbumListPart$QueryPhotoTask(AECircleAlbumListPart paramAECircleAlbumListPart, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  protected List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = AECircleAlbumListPart.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
    if (localPhotoCommonBaseData.selectedPhotoList == null) {
      localPhotoCommonBaseData.selectedPhotoList = new ArrayList();
    }
    if (localPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
      localPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
    }
    HashMap localHashMap = localPhotoCommonBaseData.selectedMediaInfoHashMap;
    LogTag.a();
    Object localObject1 = AECircleAlbumListPart.b(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart).a(this.jdField_a_of_type_Boolean);
    paramVarArgs = (Object[])localObject1;
    if (localObject1 == null) {
      paramVarArgs = new ArrayList();
    }
    localObject1 = AECircleAlbumListPart.a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart);
    int j = 0;
    ((PhotoListBaseData)localObject1).c = 0;
    AECircleAlbumListPart.b(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart).d = 0;
    System.currentTimeMillis();
    long l = QAlbumUtil.sLastAlbumRecordTime;
    if (QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(localPhotoCommonBaseData.albumId)) {
      ((Integer)QAlbumUtil.sLastAlbumPhotoCountMap.get(localPhotoCommonBaseData.albumId)).intValue();
    }
    Object localObject2;
    if ((AECircleAlbumListPart.c(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart).r) && (localPhotoCommonBaseData.albumId.equals("$RecentAlbumId")))
    {
      localObject1 = paramVarArgs.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject2).path)))
        {
          PhotoListBaseData.jdField_a_of_type_JavaUtilMap.remove(((LocalMediaInfo)localObject2).path);
          localHashMap.remove(((LocalMediaInfo)localObject2).path);
        }
      }
      paramVarArgs.addAll(0, PhotoListBaseData.jdField_a_of_type_JavaUtilMap.values());
    }
    if ((AECircleAlbumListPart.d(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart).s) && (localPhotoCommonBaseData.albumId.equals("$VideoAlbumId")))
    {
      localObject1 = paramVarArgs.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject2).path)))
        {
          PhotoListBaseData.jdField_a_of_type_JavaUtilMap.remove(((LocalMediaInfo)localObject2).path);
          localHashMap.remove(((LocalMediaInfo)localObject2).path);
        }
      }
      localObject1 = PhotoListBaseData.jdField_a_of_type_JavaUtilMap.values().iterator();
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
          if ((AECircleAlbumListPart.e(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart).n) && (j == 1))
          {
            PhotoListBaseData localPhotoListBaseData = AECircleAlbumListPart.f(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart);
            localPhotoListBaseData.c += 1;
            if (AECircleAlbumListPart.g(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart).c == 1) {
              AECircleAlbumListPart.h(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)localObject2);
            }
          }
          if ((AECircleAlbumListPart.i(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart).r) && (!localHashMap.containsKey(((LocalMediaInfo)localObject2).path))) {
            localHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
          }
          if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject2).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject2).mMimeType)))
          {
            localObject2 = AECircleAlbumListPart.j(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart);
            ((PhotoListBaseData)localObject2).d += 1;
          }
        }
        else if ((localPhotoCommonBaseData.selectedPhotoList.size() < localPhotoCommonBaseData.maxSelectNum) && (((LocalMediaInfo)localObject2).path.equals(AECircleAlbumListPart.k(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart).e)))
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
    AECircleAlbumListPart.c(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart).a(paramList, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      paramList = this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart;
      boolean bool = false;
      paramList.a(false, false);
      if (AECircleAlbumListPart.d(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart).jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum > 0) {
        bool = true;
      }
      AEReportUtils.a(bool);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleAlbumListPart.QueryPhotoTask
 * JD-Core Version:    0.7.0.1
 */