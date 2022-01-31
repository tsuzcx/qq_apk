import android.app.Activity;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.QueryPhotoTask.1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bkqq
  extends AsyncTask<Object, Object, List<LocalMediaInfo>>
{
  public bkqq(bkql parambkql) {}
  
  protected List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    aiqy localaiqy = this.a.jdField_a_of_type_Bkrb.a;
    if (localaiqy.selectedPhotoList == null) {
      localaiqy.selectedPhotoList = new ArrayList();
    }
    Object localObject2 = localaiqy.selectedPhotoList;
    if (localaiqy.selectedMediaInfoHashMap == null) {
      localaiqy.selectedMediaInfoHashMap = new HashMap();
    }
    Object localObject1 = localaiqy.selectedMediaInfoHashMap;
    bdif.a();
    paramVarArgs = this.a.jdField_a_of_type_Bkrb.a();
    if (paramVarArgs == null) {
      paramVarArgs = new ArrayList();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.videoSelectedCnt = 0;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.gifSelectedCount = 0;
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if (QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(localaiqy.albumId)) {}
      label1055:
      for (int j = ((Integer)QAlbumUtil.sLastAlbumPhotoCountMap.get(localaiqy.albumId)).intValue();; j = 0)
      {
        Object localObject3;
        Object localObject4;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) && (localaiqy.albumId.equals("$RecentAlbumId")))
        {
          localObject3 = paramVarArgs.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (LocalMediaInfo)((Iterator)localObject3).next();
            if ((localObject4 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject4).path)))
            {
              PhotoListBaseData.newCaptureMediaInfo.remove(((LocalMediaInfo)localObject4).path);
              ((HashMap)localObject1).remove(((LocalMediaInfo)localObject4).path);
            }
          }
          paramVarArgs.addAll(0, PhotoListBaseData.newCaptureMediaInfo.values());
        }
        int i;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showCameraInVideo) && (localaiqy.albumId.equals("$VideoAlbumId")))
        {
          localObject3 = paramVarArgs.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (LocalMediaInfo)((Iterator)localObject3).next();
            if ((localObject4 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject4).path)))
            {
              PhotoListBaseData.newCaptureMediaInfo.remove(((LocalMediaInfo)localObject4).path);
              ((HashMap)localObject1).remove(((LocalMediaInfo)localObject4).path);
            }
          }
          localObject3 = PhotoListBaseData.newCaptureMediaInfo.values().iterator();
          i = 0;
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (LocalMediaInfo)((Iterator)localObject3).next();
            if ((localObject4 == null) || (!"video/mp4".equals(((LocalMediaInfo)localObject4).mMimeType))) {
              break label1120;
            }
            paramVarArgs.add(i, localObject4);
            i += 1;
          }
        }
        label938:
        label1074:
        label1120:
        for (;;)
        {
          break;
          this.a.jdField_a_of_type_Bkrb.a(paramVarArgs);
          int k = paramVarArgs.size();
          localObject3 = new ArrayList(k);
          i = 0;
          if (i < paramVarArgs.size())
          {
            localObject4 = (LocalMediaInfo)paramVarArgs.get(i);
            if (((LocalMediaInfo)localObject4).path == null) {}
            for (;;)
            {
              i += 1;
              break;
              int m = QAlbumUtil.getMediaType((LocalMediaInfo)localObject4);
              ((LocalMediaInfo)localObject4).position = Integer.valueOf(((ArrayList)localObject3).size());
              ((ArrayList)localObject3).add(((LocalMediaInfo)localObject4).path);
              if (((ArrayList)localObject2).contains(((LocalMediaInfo)localObject4).path))
              {
                ((LocalMediaInfo)localObject4).selectStatus = 1;
                if (!localaiqy.selectedIndex.contains(((LocalMediaInfo)localObject4).position)) {
                  localaiqy.selectedIndex.add(((LocalMediaInfo)localObject4).position);
                }
                if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSupportVideoCheckbox) && (m == 1))
                {
                  PhotoListBaseData localPhotoListBaseData = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
                  localPhotoListBaseData.videoSelectedCnt += 1;
                  if (this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.videoSelectedCnt == 1) {
                    this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.selectedVideoInfo = ((LocalMediaInfo)localObject4);
                  }
                }
                if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) && (!((HashMap)localObject1).containsKey(((LocalMediaInfo)localObject4).path))) {
                  ((HashMap)localObject1).put(((LocalMediaInfo)localObject4).path, localObject4);
                }
                if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject4).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject4).mMimeType)))
                {
                  localObject4 = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
                  ((PhotoListBaseData)localObject4).gifSelectedCount += 1;
                }
              }
              else if ((((ArrayList)localObject2).size() < localaiqy.maxSelectNum) && (((LocalMediaInfo)localObject4).path.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.currentPhotoPath)))
              {
                ((LocalMediaInfo)localObject4).selectStatus = 1;
                ((ArrayList)localObject2).add(((LocalMediaInfo)localObject4).path);
                localaiqy.selectedIndex.add(((LocalMediaInfo)localObject4).position);
                if (localaiqy.needMediaInfo) {
                  ((HashMap)localObject1).put(((LocalMediaInfo)localObject4).path, localObject4);
                }
              }
              else if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isRecodeLastAlbumPath) && (l1 - l2 <= 60000L) && (j == paramVarArgs.size()) && (((LocalMediaInfo)localObject4).path.equals(QAlbumUtil.sLastAlbumPath)))
              {
                ((LocalMediaInfo)localObject4).selectStatus = 3;
              }
              else
              {
                ((LocalMediaInfo)localObject4).selectStatus = 2;
              }
            }
          }
          if (this.a.jdField_a_of_type_Bkrb.a())
          {
            if (localaiqy.allMediaInfoHashMap == null)
            {
              localaiqy.allMediaInfoHashMap = new HashMap();
              i = 0;
              if (i >= k) {
                break label1074;
              }
              localObject1 = (LocalMediaInfo)paramVarArgs.get(i);
              if (((LocalMediaInfo)localObject1).path != null) {
                break label1055;
              }
            }
            for (;;)
            {
              i += 1;
              break label938;
              localObject2 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject4 = (String)((Iterator)localObject2).next();
                if ((localaiqy.allMediaInfoHashMap.containsKey(localObject4)) && (!((HashMap)localObject1).containsKey(localObject4))) {
                  ((HashMap)localObject1).put(localObject4, localaiqy.allMediaInfoHashMap.get(localObject4));
                }
              }
              localaiqy.allMediaInfoHashMap.clear();
              break;
              localaiqy.allMediaInfoHashMap.put(((LocalMediaInfo)localObject1).path, localObject1);
            }
          }
          localaiqy.mediaPathsList = ((ArrayList)localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + paramVarArgs.size());
          }
          return paramVarArgs;
        }
      }
    }
  }
  
  protected void a(List<LocalMediaInfo> paramList)
  {
    this.a.jdField_a_of_type_Bkrb.a(paramList);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.getActivity().runOnUiThread(new AEAbstractPhotoListFragment.QueryPhotoTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqq
 * JD-Core Version:    0.7.0.1
 */