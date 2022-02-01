import android.app.Activity;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
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

public class bllp
  extends AsyncTask<Object, Object, List<LocalMediaInfo>>
{
  public bllp(bllh parambllh) {}
  
  protected List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.a.jdField_a_of_type_Blly.a;
    if (localPhotoCommonBaseData.selectedPhotoList == null) {
      localPhotoCommonBaseData.selectedPhotoList = new ArrayList();
    }
    if (localPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
      localPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
    }
    Object localObject1 = localPhotoCommonBaseData.selectedMediaInfoHashMap;
    bfwl.a();
    paramVarArgs = this.a.jdField_a_of_type_Blly.a();
    if (paramVarArgs == null) {
      paramVarArgs = new ArrayList();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.videoSelectedCnt = 0;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.gifSelectedCount = 0;
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if (QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(localPhotoCommonBaseData.albumId)) {}
      label1060:
      for (int j = ((Integer)QAlbumUtil.sLastAlbumPhotoCountMap.get(localPhotoCommonBaseData.albumId)).intValue();; j = 0)
      {
        Object localObject2;
        Object localObject3;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) && (localPhotoCommonBaseData.albumId.equals("$RecentAlbumId")))
        {
          localObject2 = paramVarArgs.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (LocalMediaInfo)((Iterator)localObject2).next();
            if ((localObject3 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject3).path)))
            {
              PhotoListBaseData.newCaptureMediaInfo.remove(((LocalMediaInfo)localObject3).path);
              ((HashMap)localObject1).remove(((LocalMediaInfo)localObject3).path);
            }
          }
          paramVarArgs.addAll(0, PhotoListBaseData.newCaptureMediaInfo.values());
        }
        int i;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showCameraInVideo) && (localPhotoCommonBaseData.albumId.equals("$VideoAlbumId")))
        {
          localObject2 = paramVarArgs.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (LocalMediaInfo)((Iterator)localObject2).next();
            if ((localObject3 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject3).path)))
            {
              PhotoListBaseData.newCaptureMediaInfo.remove(((LocalMediaInfo)localObject3).path);
              ((HashMap)localObject1).remove(((LocalMediaInfo)localObject3).path);
            }
          }
          localObject2 = PhotoListBaseData.newCaptureMediaInfo.values().iterator();
          i = 0;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (LocalMediaInfo)((Iterator)localObject2).next();
            if ((localObject3 == null) || (!"video/mp4".equals(((LocalMediaInfo)localObject3).mMimeType))) {
              break label1125;
            }
            paramVarArgs.add(i, localObject3);
            i += 1;
          }
        }
        label940:
        label1079:
        label1125:
        for (;;)
        {
          break;
          this.a.jdField_a_of_type_Blly.a(paramVarArgs);
          int k = paramVarArgs.size();
          localObject2 = new ArrayList(k);
          i = 0;
          Object localObject4;
          if (i < paramVarArgs.size())
          {
            localObject3 = (LocalMediaInfo)paramVarArgs.get(i);
            if (((LocalMediaInfo)localObject3).path == null) {}
            for (;;)
            {
              i += 1;
              break;
              int m = QAlbumUtil.getMediaType((LocalMediaInfo)localObject3);
              ((LocalMediaInfo)localObject3).position = Integer.valueOf(((ArrayList)localObject2).size());
              ((ArrayList)localObject2).add(((LocalMediaInfo)localObject3).path);
              if (localPhotoCommonBaseData.selectedPhotoList.contains(((LocalMediaInfo)localObject3).path))
              {
                ((LocalMediaInfo)localObject3).selectStatus = 1;
                if (!localPhotoCommonBaseData.selectedIndex.contains(((LocalMediaInfo)localObject3).position)) {
                  localPhotoCommonBaseData.selectedIndex.add(((LocalMediaInfo)localObject3).position);
                }
                if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSupportVideoCheckbox) && (m == 1))
                {
                  localObject4 = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
                  ((PhotoListBaseData)localObject4).videoSelectedCnt += 1;
                  if (this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.videoSelectedCnt == 1) {
                    this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.selectedVideoInfo = ((LocalMediaInfo)localObject3);
                  }
                }
                if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) && (!((HashMap)localObject1).containsKey(((LocalMediaInfo)localObject3).path))) {
                  ((HashMap)localObject1).put(((LocalMediaInfo)localObject3).path, localObject3);
                }
                if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject3).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject3).mMimeType)))
                {
                  localObject3 = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
                  ((PhotoListBaseData)localObject3).gifSelectedCount += 1;
                }
              }
              else if ((localPhotoCommonBaseData.selectedPhotoList.size() < localPhotoCommonBaseData.maxSelectNum) && (((LocalMediaInfo)localObject3).path.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.currentPhotoPath)))
              {
                ((LocalMediaInfo)localObject3).selectStatus = 1;
                localPhotoCommonBaseData.selectedPhotoList.add(((LocalMediaInfo)localObject3).path);
                localPhotoCommonBaseData.selectedIndex.add(((LocalMediaInfo)localObject3).position);
                if (localPhotoCommonBaseData.needMediaInfo) {
                  ((HashMap)localObject1).put(((LocalMediaInfo)localObject3).path, localObject3);
                }
              }
              else if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isRecodeLastAlbumPath) && (l1 - l2 <= 60000L) && (j == paramVarArgs.size()) && (((LocalMediaInfo)localObject3).path.equals(QAlbumUtil.sLastAlbumPath)))
              {
                ((LocalMediaInfo)localObject3).selectStatus = 3;
              }
              else
              {
                ((LocalMediaInfo)localObject3).selectStatus = 2;
              }
            }
          }
          if (this.a.jdField_a_of_type_Blly.a())
          {
            if (localPhotoCommonBaseData.allMediaInfoHashMap == null)
            {
              localPhotoCommonBaseData.allMediaInfoHashMap = new HashMap();
              i = 0;
              if (i >= k) {
                break label1079;
              }
              localObject1 = (LocalMediaInfo)paramVarArgs.get(i);
              if (((LocalMediaInfo)localObject1).path != null) {
                break label1060;
              }
            }
            for (;;)
            {
              i += 1;
              break label940;
              localObject3 = localPhotoCommonBaseData.selectedPhotoList.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (String)((Iterator)localObject3).next();
                if ((localPhotoCommonBaseData.allMediaInfoHashMap.containsKey(localObject4)) && (!((HashMap)localObject1).containsKey(localObject4))) {
                  ((HashMap)localObject1).put(localObject4, localPhotoCommonBaseData.allMediaInfoHashMap.get(localObject4));
                }
              }
              localPhotoCommonBaseData.allMediaInfoHashMap.clear();
              break;
              localPhotoCommonBaseData.allMediaInfoHashMap.put(((LocalMediaInfo)localObject1).path, localObject1);
            }
          }
          localPhotoCommonBaseData.mediaPathsList = ((ArrayList)localObject2);
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
    this.a.jdField_a_of_type_Blly.a(paramList);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.getActivity().runOnUiThread(new AEAbstractPhotoListFragment.QueryPhotoTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bllp
 * JD-Core Version:    0.7.0.1
 */