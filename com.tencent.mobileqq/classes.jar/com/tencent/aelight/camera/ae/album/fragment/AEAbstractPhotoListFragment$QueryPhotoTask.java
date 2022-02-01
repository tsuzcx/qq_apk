package com.tencent.aelight.camera.ae.album.fragment;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic;
import com.tencent.aelight.camera.aebase.AEReportUtils;
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

public class AEAbstractPhotoListFragment$QueryPhotoTask
  extends AsyncTask<Object, Object, List<LocalMediaInfo>>
{
  private boolean b;
  private boolean c;
  
  public AEAbstractPhotoListFragment$QueryPhotoTask(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramBoolean1;
    this.c = paramBoolean2;
  }
  
  protected List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.a.a.c;
    if (localPhotoCommonBaseData.selectedPhotoList == null) {
      localPhotoCommonBaseData.selectedPhotoList = new ArrayList();
    }
    if (localPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
      localPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
    }
    Object localObject2 = localPhotoCommonBaseData.selectedMediaInfoHashMap;
    LogTag.a();
    Object localObject1 = this.a.a.b(this.b);
    paramVarArgs = (Object[])localObject1;
    if (localObject1 == null) {
      paramVarArgs = new ArrayList();
    }
    localObject1 = this.a.b;
    int k = 0;
    ((PhotoListBaseData)localObject1).C = 0;
    this.a.b.D = 0;
    long l1 = System.currentTimeMillis();
    long l2 = QAlbumUtil.sLastAlbumRecordTime;
    int i;
    if (QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(localPhotoCommonBaseData.albumId)) {
      i = ((Integer)QAlbumUtil.sLastAlbumPhotoCountMap.get(localPhotoCommonBaseData.albumId)).intValue();
    } else {
      i = 0;
    }
    Object localObject3;
    if ((this.a.b.O) && (localPhotoCommonBaseData.albumId.equals("$RecentAlbumId")))
    {
      localObject1 = paramVarArgs.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (LocalMediaInfo)((Iterator)localObject1).next();
        if ((localObject3 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject3).path)))
        {
          PhotoListBaseData.x.remove(((LocalMediaInfo)localObject3).path);
          ((HashMap)localObject2).remove(((LocalMediaInfo)localObject3).path);
        }
      }
      paramVarArgs.addAll(0, PhotoListBaseData.x.values());
    }
    if ((this.a.b.P) && (localPhotoCommonBaseData.albumId.equals("$VideoAlbumId")))
    {
      localObject1 = paramVarArgs.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (LocalMediaInfo)((Iterator)localObject1).next();
        if ((localObject3 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject3).path)))
        {
          PhotoListBaseData.x.remove(((LocalMediaInfo)localObject3).path);
          ((HashMap)localObject2).remove(((LocalMediaInfo)localObject3).path);
        }
      }
      localObject1 = PhotoListBaseData.x.values().iterator();
      j = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (LocalMediaInfo)((Iterator)localObject1).next();
        if ((localObject3 != null) && ("video/mp4".equals(((LocalMediaInfo)localObject3).mMimeType)))
        {
          paramVarArgs.add(j, localObject3);
          j += 1;
        }
      }
    }
    this.a.a.a(paramVarArgs);
    int m = paramVarArgs.size();
    localObject1 = new ArrayList(m);
    int j = 0;
    Object localObject4;
    while (j < paramVarArgs.size())
    {
      localObject3 = (LocalMediaInfo)paramVarArgs.get(j);
      if (((LocalMediaInfo)localObject3).path != null)
      {
        int n = QAlbumUtil.getMediaType((LocalMediaInfo)localObject3);
        ((LocalMediaInfo)localObject3).position = Integer.valueOf(((ArrayList)localObject1).size());
        ((ArrayList)localObject1).add(((LocalMediaInfo)localObject3).path);
        if (localPhotoCommonBaseData.selectedPhotoList.contains(((LocalMediaInfo)localObject3).path))
        {
          ((LocalMediaInfo)localObject3).selectStatus = 1;
          if (!localPhotoCommonBaseData.selectedIndex.contains(((LocalMediaInfo)localObject3).position)) {
            localPhotoCommonBaseData.selectedIndex.add(((LocalMediaInfo)localObject3).position);
          }
          if ((this.a.b.B) && (n == 1))
          {
            localObject4 = this.a.b;
            ((PhotoListBaseData)localObject4).C += 1;
            if (this.a.b.C == 1) {
              this.a.b.E = ((LocalMediaInfo)localObject3);
            }
          }
          if ((this.a.b.O) && (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject3).path))) {
            ((HashMap)localObject2).put(((LocalMediaInfo)localObject3).path, localObject3);
          }
          if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject3).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject3).mMimeType)))
          {
            localObject3 = this.a.b;
            ((PhotoListBaseData)localObject3).D += 1;
          }
        }
        else if ((localPhotoCommonBaseData.selectedPhotoList.size() < localPhotoCommonBaseData.maxSelectNum) && (((LocalMediaInfo)localObject3).path.equals(this.a.b.A)))
        {
          ((LocalMediaInfo)localObject3).selectStatus = 1;
          localPhotoCommonBaseData.selectedPhotoList.add(((LocalMediaInfo)localObject3).path);
          localPhotoCommonBaseData.selectedIndex.add(((LocalMediaInfo)localObject3).position);
          ((HashMap)localObject2).put(((LocalMediaInfo)localObject3).path, localObject3);
        }
        else if ((this.a.b.N) && (l1 - l2 <= 60000L) && (i == paramVarArgs.size()) && (((LocalMediaInfo)localObject3).path.equals(QAlbumUtil.sLastAlbumPath)))
        {
          ((LocalMediaInfo)localObject3).selectStatus = 3;
        }
        else
        {
          ((LocalMediaInfo)localObject3).selectStatus = 2;
        }
      }
      j += 1;
    }
    if (this.a.a.e())
    {
      if (localPhotoCommonBaseData.allMediaInfoHashMap == null)
      {
        localPhotoCommonBaseData.allMediaInfoHashMap = new HashMap();
        i = k;
      }
      else
      {
        localObject3 = localPhotoCommonBaseData.selectedPhotoList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          if ((localPhotoCommonBaseData.allMediaInfoHashMap.containsKey(localObject4)) && (!((HashMap)localObject2).containsKey(localObject4))) {
            ((HashMap)localObject2).put(localObject4, localPhotoCommonBaseData.allMediaInfoHashMap.get(localObject4));
          }
        }
        localPhotoCommonBaseData.allMediaInfoHashMap.clear();
        i = k;
      }
      while (i < m)
      {
        localObject2 = (LocalMediaInfo)paramVarArgs.get(i);
        if (((LocalMediaInfo)localObject2).path != null) {
          localPhotoCommonBaseData.allMediaInfoHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
        }
        i += 1;
      }
    }
    localPhotoCommonBaseData.mediaPathsList = ((ArrayList)localObject1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QueryPhotoTask,doInBackground,mediaList.size :");
      ((StringBuilder)localObject1).append(paramVarArgs.size());
      QLog.d("PhotoListActivity", 2, ((StringBuilder)localObject1).toString());
    }
    return paramVarArgs;
  }
  
  protected void a(List<LocalMediaInfo> paramList)
  {
    this.a.a.a(paramList, this.b);
    if (this.b)
    {
      paramList = this.a;
      boolean bool = false;
      paramList.a(false, false);
      if (this.a.a.e.initialHasPickedNum > 0) {
        bool = true;
      }
      AEReportUtils.a(bool, "1");
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    if (this.c) {
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.QueryPhotoTask
 * JD-Core Version:    0.7.0.1
 */