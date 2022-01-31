package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import cooperation.weiyun.utils.PreferenceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import xdm;
import xdp;
import xdq;

public class PhotoListActivity$QueryPhotoTask
  extends AsyncTask
{
  public PhotoListActivity$QueryPhotoTask(PhotoListActivity paramPhotoListActivity) {}
  
  protected List a(Object... paramVarArgs)
  {
    LogTag.a();
    int i = -1;
    if (this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId"))
    {
      i = 100;
      if (PhotoListActivity.b(this.a)) {
        i = QzoneConfig.getInstance().getConfig("PhotoAlbum", "MaxRecentPhotoNum", 200);
      }
    }
    int j;
    Object localObject1;
    if (((PhotoListActivity.b(this.a)) && (this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId"))) || ((this.a.k) && (this.a.j)))
    {
      j = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480);
      k = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100);
      localObject1 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
      paramVarArgs = null;
      if (localObject1 != null) {
        paramVarArgs = PhotoListActivity.a(this.a, (String)localObject1);
      }
      paramVarArgs = AlbumUtil.a(this.a, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString, i, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter, j, k, true, paramVarArgs, this.a.j, -1L);
    }
    for (;;)
    {
      LogTag.a("PEAK", "getAlbumMedias");
      if (paramVarArgs != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      return null;
      if (PhotoListActivity.c(this.a))
      {
        localObject1 = PreferenceUtils.a(this.a.getApplicationContext(), this.a.jdField_e_of_type_JavaLangString, "pref_select_album");
        paramVarArgs = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramVarArgs = PreferenceUtils.a((String)localObject1);
        }
        paramVarArgs = AlbumUtil.a(this.a, 1000, paramVarArgs, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter);
      }
      else if (this.a.P)
      {
        paramVarArgs = AlbumUtil.a(this.a, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString, i, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter, 0, 240, true, null, false, this.a.jdField_e_of_type_Long);
      }
      else
      {
        paramVarArgs = AlbumUtil.b(this.a, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString, i, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter, this.a.jdField_e_of_type_Long);
      }
    }
    if (((PhotoListActivity.d(this.a)) || (PhotoListActivity.e(this.a))) && (QzoneConfig.getInstance().getConfig("PhotoAlbum", "paranoramaOpenCheck", 1) != 0))
    {
      PhotoListActivity.a(this.a, paramVarArgs);
      if ((this.a.jdField_c_of_type_JavaUtilArrayList == null) || (this.a.jdField_c_of_type_JavaUtilArrayList.size() == 0)) {
        break label660;
      }
      i = 0;
      label456:
      if (i >= this.a.jdField_c_of_type_JavaUtilArrayList.size()) {
        break label660;
      }
      localObject1 = (String)this.a.jdField_c_of_type_JavaUtilArrayList.get(i);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label521;
      }
      QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
      j = i;
    }
    for (;;)
    {
      i = j + 1;
      break label456;
      QLog.i("PhotoListActivity", 2, "@panoramatest isnot fromqzone");
      break;
      label521:
      j = i;
      if (!new File((String)localObject1).exists()) {
        if ((((String)localObject1).startsWith("http")) && (this.a.jdField_b_of_type_JavaUtilHashMap != null))
        {
          j = i;
          if (this.a.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject1)) {}
        }
        else
        {
          this.a.jdField_c_of_type_JavaUtilArrayList.remove(i);
          i -= 1;
          if (!PhotoListActivity.e(this.a))
          {
            j = i;
            if (!PhotoListActivity.d(this.a)) {}
          }
          else
          {
            j = i;
            if (this.a.jdField_c_of_type_JavaUtilHashMap != null)
            {
              j = i;
              if (this.a.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject1))
              {
                this.a.jdField_c_of_type_JavaUtilHashMap.remove(localObject1);
                j = i;
              }
            }
          }
        }
      }
    }
    label660:
    if (this.a.L)
    {
      i = paramVarArgs.size() - 1;
      while (i >= 0)
      {
        localObject1 = (LocalMediaInfo)paramVarArgs.get(i);
        if ((!((LocalMediaInfo)localObject1).path.endsWith(".gif")) && ((((LocalMediaInfo)localObject1).mediaHeight < this.a.t) || (((LocalMediaInfo)localObject1).mediaWidth < this.a.s))) {
          paramVarArgs.remove(i);
        }
        if ((((LocalMediaInfo)localObject1).path.endsWith(".gif")) && (((LocalMediaInfo)localObject1).fileSize > this.a.jdField_u_of_type_Int)) {
          paramVarArgs.remove(i);
        }
        i -= 1;
      }
    }
    Object localObject2;
    Object localObject3;
    if (PhotoListActivity.c(this.a))
    {
      i = paramVarArgs.size();
      localObject2 = this.a.getIntent().getStringArrayListExtra("weiyun_filter_data");
      if (localObject2 != null)
      {
        i -= 1;
        if (i >= 0)
        {
          localObject1 = (LocalMediaInfo)paramVarArgs.get(i);
          j = ((LocalMediaInfo)localObject1).path.lastIndexOf("/");
          localObject3 = ((LocalMediaInfo)localObject1).path.substring(j + 1);
          File localFile = new File(((LocalMediaInfo)localObject1).path);
          if (localFile.exists()) {}
          for (localObject1 = (String)localObject3 + localFile.length();; localObject1 = (String)localObject3 + ((LocalMediaInfo)localObject1).fileSize)
          {
            if (((ArrayList)localObject2).contains(localObject1)) {
              paramVarArgs.remove(i);
            }
            i -= 1;
            break;
          }
        }
      }
    }
    if (this.a.N)
    {
      i = paramVarArgs.size() - 1;
      while (i >= 0)
      {
        if (!((LocalMediaInfo)paramVarArgs.get(i)).path.endsWith(".mp4")) {
          paramVarArgs.remove(i);
        }
        i -= 1;
      }
    }
    if (this.a.P)
    {
      i = paramVarArgs.size() - 1;
      while (i >= 0)
      {
        localObject1 = (LocalMediaInfo)paramVarArgs.get(i);
        if (!QQStoryFlowCallback.b(this.a, (LocalMediaInfo)localObject1)) {
          paramVarArgs.remove(i);
        }
        i -= 1;
      }
    }
    this.a.p = 0;
    this.a.q = 0;
    long l1 = System.currentTimeMillis();
    long l2 = AlbumUtil.jdField_a_of_type_Long;
    if (AlbumUtil.jdField_a_of_type_JavaUtilHashMap.containsKey(this.a.jdField_b_of_type_JavaLangString)) {}
    for (int k = ((Integer)AlbumUtil.jdField_a_of_type_JavaUtilHashMap.get(this.a.jdField_b_of_type_JavaLangString)).intValue();; k = 0)
    {
      if ((this.a.C) && (this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId")))
      {
        localObject1 = paramVarArgs.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject2).path)))
          {
            PhotoListActivity.a().remove(((LocalMediaInfo)localObject2).path);
            if (this.a.jdField_c_of_type_JavaUtilHashMap != null) {
              this.a.jdField_c_of_type_JavaUtilHashMap.remove(((LocalMediaInfo)localObject2).path);
            }
          }
        }
        paramVarArgs.addAll(0, PhotoListActivity.a().values());
      }
      if ((this.a.D) && (this.a.jdField_b_of_type_JavaLangString.equals("$VideoAlbumId")))
      {
        localObject1 = paramVarArgs.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject2).path)))
          {
            PhotoListActivity.a().remove(((LocalMediaInfo)localObject2).path);
            if (this.a.jdField_c_of_type_JavaUtilHashMap != null) {
              this.a.jdField_c_of_type_JavaUtilHashMap.remove(((LocalMediaInfo)localObject2).path);
            }
          }
        }
        localObject1 = PhotoListActivity.a().values();
        if (localObject1 != null)
        {
          localObject1 = ((Collection)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
            if ((localObject2 == null) || (!"video/mp4".equals(((LocalMediaInfo)localObject2).mMimeType))) {
              break label2269;
            }
            paramVarArgs.add(i, localObject2);
            i += 1;
          }
        }
      }
      label2206:
      label2223:
      label2269:
      for (;;)
      {
        break;
        int n = paramVarArgs.size();
        localObject1 = new ArrayList(n);
        i = 0;
        int m = 0;
        if (m < paramVarArgs.size())
        {
          localObject2 = (LocalMediaInfo)paramVarArgs.get(m);
          if (((LocalMediaInfo)localObject2).path == null) {
            j = i;
          }
          for (;;)
          {
            m += 1;
            i = j;
            break;
            int i1 = AlbumUtil.a((LocalMediaInfo)localObject2);
            if (((PhotoListActivity.e(this.a)) || (PhotoListActivity.d(this.a)) || (PhotoListActivity.f(this.a))) && (this.a.K))
            {
              ((LocalMediaInfo)localObject2).position = Integer.valueOf(m);
              ((ArrayList)localObject1).add(((LocalMediaInfo)localObject2).path);
              if (this.a.jdField_c_of_type_JavaUtilArrayList.contains(((LocalMediaInfo)localObject2).path))
              {
                ((LocalMediaInfo)localObject2).selectStatus = 1;
                if (!this.a.d.contains(((LocalMediaInfo)localObject2).position)) {
                  this.a.d.add(((LocalMediaInfo)localObject2).position);
                }
                if ((this.a.K) && (i1 == 1))
                {
                  localObject3 = this.a;
                  ((PhotoListActivity)localObject3).p += 1;
                  if (this.a.p == 1) {
                    this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)localObject2);
                  }
                }
                if ((this.a.C) && (this.a.jdField_c_of_type_JavaUtilHashMap != null) && (!this.a.jdField_c_of_type_JavaUtilHashMap.containsKey(((LocalMediaInfo)localObject2).path))) {
                  this.a.jdField_c_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
                }
                j = i;
                if (TextUtils.isEmpty(((LocalMediaInfo)localObject2).mMimeType)) {
                  continue;
                }
                j = i;
                if (!"image/gif".equals(((LocalMediaInfo)localObject2).mMimeType)) {
                  continue;
                }
                localObject2 = this.a;
                ((PhotoListActivity)localObject2).q += 1;
                j = i;
              }
            }
            else
            {
              if (i1 == 0)
              {
                ((ArrayList)localObject1).add(((LocalMediaInfo)localObject2).path);
                j = i;
              }
              for (;;)
              {
                ((LocalMediaInfo)localObject2).position = Integer.valueOf(m - j);
                i = j;
                break;
                j = i;
                if (i1 == 1) {
                  j = i + 1;
                }
              }
            }
            if ((this.a.jdField_c_of_type_JavaUtilArrayList.size() < this.a.i) && (this.a.jdField_m_of_type_JavaLangString != null) && (((LocalMediaInfo)localObject2).path.equals(this.a.jdField_m_of_type_JavaLangString)))
            {
              ((LocalMediaInfo)localObject2).selectStatus = 1;
              this.a.jdField_c_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject2).path);
              this.a.d.add(((LocalMediaInfo)localObject2).position);
              if ((!PhotoListActivity.e(this.a)) && (!PhotoListActivity.d(this.a)))
              {
                j = i;
                if (!PhotoListActivity.g(this.a)) {}
              }
              else
              {
                this.a.jdField_c_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
                j = i;
              }
            }
            else if ((this.a.jdField_u_of_type_Boolean) && (l1 - l2 <= 60000L) && (k == paramVarArgs.size()) && (((LocalMediaInfo)localObject2).path.equals(AlbumUtil.jdField_a_of_type_JavaLangString)))
            {
              ((LocalMediaInfo)localObject2).selectStatus = 3;
              j = i;
            }
            else
            {
              ((LocalMediaInfo)localObject2).selectStatus = 2;
              j = i;
            }
          }
        }
        if (((PhotoListActivity.e(this.a)) || (PhotoListActivity.d(this.a)) || (PhotoListActivity.f(this.a))) && (this.a.K))
        {
          System.currentTimeMillis();
          if (PhotoListActivity.jdField_a_of_type_JavaUtilHashMap == null)
          {
            PhotoListActivity.jdField_a_of_type_JavaUtilHashMap = new HashMap();
            i = 0;
            label2164:
            if (i >= n) {
              break label2223;
            }
            localObject2 = (LocalMediaInfo)paramVarArgs.get(i);
            if (((LocalMediaInfo)localObject2).path != null) {
              break label2206;
            }
          }
          for (;;)
          {
            i += 1;
            break label2164;
            PhotoListActivity.jdField_a_of_type_JavaUtilHashMap.clear();
            break;
            PhotoListActivity.jdField_a_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
          }
          System.currentTimeMillis();
        }
        if (n > 1000)
        {
          PhotoListActivity.jdField_a_of_type_JavaUtilArrayList = (ArrayList)localObject1;
          this.a.x = true;
          return paramVarArgs;
        }
        this.a.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
        this.a.x = false;
        return paramVarArgs;
      }
    }
  }
  
  protected void a(List paramList)
  {
    int m = 0;
    this.a.runOnUiThread(new xdq(this));
    Object localObject;
    if (paramList == null)
    {
      if ((!this.a.C) || (!this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId")))
      {
        localObject = paramList;
        if (this.a.D)
        {
          localObject = paramList;
          if (!this.a.jdField_b_of_type_JavaLangString.equals("$VideoAlbumId")) {}
        }
      }
      else
      {
        paramList = new LocalMediaInfo();
        paramList.mMimeType = "mobileqq/camera";
        localObject = new ArrayList();
        ((List)localObject).add(0, paramList);
      }
      this.a.jdField_a_of_type_Xdm.a((List)localObject);
      this.a.jdField_a_of_type_Xdm.notifyDataSetChanged();
      this.a.e();
      QQToast.a(this.a, "暂无媒体文件", 1000).a();
      return;
    }
    if (((!this.a.C) && (!this.a.L)) || ((this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId")) || ((this.a.D) && (this.a.jdField_b_of_type_JavaLangString.equals("$VideoAlbumId")))))
    {
      localObject = new LocalMediaInfo();
      ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
      paramList.add(0, localObject);
    }
    this.a.jdField_a_of_type_Xdm.a(paramList);
    label283:
    int i;
    if (paramList.isEmpty())
    {
      QQToast.a(this.a, "暂无媒体文件", 1000).a();
      if (this.a.h)
      {
        this.a.h = false;
        if (this.a.r != -1) {
          break label687;
        }
        i = PhotoListActivity.jdField_m_of_type_Int;
        label316:
        if (i != -1) {
          break label714;
        }
        localObject = (LinkedHashMap)AlbumUtil.jdField_b_of_type_JavaUtilHashMap.get(this.a.jdField_b_of_type_JavaLangString);
        if (localObject == null) {
          break label750;
        }
        j = ((LinkedHashMap)localObject).size();
        if (j <= 0) {
          break label750;
        }
      }
    }
    label410:
    label541:
    label687:
    label698:
    label714:
    label750:
    for (int j = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(j - 1)])).intValue();; j = i)
    {
      i = j;
      int k;
      if (j == -1)
      {
        i = j;
        if (this.a.jdField_u_of_type_Boolean)
        {
          localObject = paramList.iterator();
          k = 0;
          i = j;
          if (((Iterator)localObject).hasNext())
          {
            if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus != 3) {
              break label698;
            }
            i = k;
          }
        }
      }
      if ((i == -1) && (this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId")) && (!this.a.jdField_c_of_type_JavaUtilArrayList.isEmpty()))
      {
        k = paramList.size();
        localObject = (String)this.a.jdField_c_of_type_JavaUtilArrayList.get(this.a.jdField_c_of_type_JavaUtilArrayList.size() - 1);
        j = 0;
        if (j < k) {
          if (((String)localObject).equals(((LocalMediaInfo)paramList.get(j)).path)) {
            i = j;
          }
        }
      }
      for (;;)
      {
        j = this.a.jdField_a_of_type_Xdm.getCount();
        if (j == 0) {
          j = m;
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(j);
          this.a.jdField_a_of_type_Xdm.notifyDataSetChanged();
          this.a.e();
          if ((!this.a.P) || (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager == null)) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager.a(this.a.jdField_c_of_type_JavaUtilArrayList);
          return;
          if ((!this.a.L) || (paramList.size() != 1)) {
            break label283;
          }
          QQToast.a(this.a, "暂无媒体文件", 1000).a();
          if (this.a.jdField_e_of_type_AndroidWidgetTextView == null) {
            break label283;
          }
          this.a.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
          break label283;
          i = this.a.r;
          break label316;
          k += 1;
          break label410;
          j += 1;
          break label512;
          PhotoListActivity.jdField_m_of_type_Int = -1;
          break label541;
          if (i > j - 1)
          {
            j -= 1;
          }
          else
          {
            j = m;
            if (i >= 0) {
              j = i;
            }
          }
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.runOnUiThread(new xdp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoListActivity.QueryPhotoTask
 * JD-Core Version:    0.7.0.1
 */