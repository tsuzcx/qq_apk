package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.SlideShowPhotoListManager;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import wur;
import wuu;
import wuv;

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
      else
      {
        paramVarArgs = AlbumUtil.b(this.a, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString, i, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter, this.a.jdField_e_of_type_Long);
      }
    }
    if ((this.a.jdField_c_of_type_JavaUtilArrayList != null) && (this.a.jdField_c_of_type_JavaUtilArrayList.size() != 0))
    {
      i = 0;
      if (i < this.a.jdField_c_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (String)this.a.jdField_c_of_type_JavaUtilArrayList.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
          j = i;
        }
        for (;;)
        {
          i = j + 1;
          break;
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
              if (!PhotoListActivity.d(this.a))
              {
                j = i;
                if (!PhotoListActivity.e(this.a)) {}
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
      }
    }
    if (this.a.J)
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
    if (this.a.L)
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
          if (((PhotoListActivity.d(this.a)) || (PhotoListActivity.e(this.a)) || (PhotoListActivity.f(this.a))) && (this.a.I))
          {
            ((LocalMediaInfo)localObject2).position = Integer.valueOf(m);
            ((ArrayList)localObject1).add(((LocalMediaInfo)localObject2).path);
            if (this.a.jdField_c_of_type_JavaUtilArrayList.contains(((LocalMediaInfo)localObject2).path))
            {
              ((LocalMediaInfo)localObject2).selectStatus = 1;
              if (!this.a.d.contains(((LocalMediaInfo)localObject2).position)) {
                this.a.d.add(((LocalMediaInfo)localObject2).position);
              }
              if ((this.a.I) && (i1 == 1))
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
            if ((!PhotoListActivity.d(this.a)) && (!PhotoListActivity.e(this.a)))
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
      if (((PhotoListActivity.d(this.a)) || (PhotoListActivity.e(this.a)) || (PhotoListActivity.f(this.a))) && (this.a.I))
      {
        System.currentTimeMillis();
        if (PhotoListActivity.jdField_a_of_type_JavaUtilHashMap == null)
        {
          PhotoListActivity.jdField_a_of_type_JavaUtilHashMap = new HashMap();
          i = 0;
          label1793:
          if (i >= n) {
            break label1852;
          }
          localObject2 = (LocalMediaInfo)paramVarArgs.get(i);
          if (((LocalMediaInfo)localObject2).path != null) {
            break label1835;
          }
        }
        for (;;)
        {
          i += 1;
          break label1793;
          PhotoListActivity.jdField_a_of_type_JavaUtilHashMap.clear();
          break;
          label1835:
          PhotoListActivity.jdField_a_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
        }
        label1852:
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
  
  protected void a(List paramList)
  {
    int m = 0;
    this.a.runOnUiThread(new wuv(this));
    Object localObject;
    if (paramList == null)
    {
      localObject = paramList;
      if (this.a.C)
      {
        localObject = paramList;
        if (this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId"))
        {
          paramList = new LocalMediaInfo();
          paramList.mMimeType = "mobileqq/camera";
          localObject = new ArrayList();
          ((List)localObject).add(0, paramList);
        }
      }
      this.a.jdField_a_of_type_Wur.a((List)localObject);
      this.a.jdField_a_of_type_Wur.notifyDataSetChanged();
      this.a.e();
      QQToast.a(this.a, "暂无媒体文件", 1000).a();
      return;
    }
    if (((this.a.C) || (this.a.J)) && (this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId")))
    {
      localObject = new LocalMediaInfo();
      ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
      paramList.add(0, localObject);
    }
    this.a.jdField_a_of_type_Wur.a(paramList);
    label231:
    int i;
    if (paramList.isEmpty())
    {
      QQToast.a(this.a, "暂无媒体文件", 1000).a();
      if (this.a.h)
      {
        this.a.h = false;
        if (this.a.r != -1) {
          break label635;
        }
        i = PhotoListActivity.jdField_m_of_type_Int;
        label264:
        if (i != -1) {
          break label662;
        }
        localObject = (LinkedHashMap)AlbumUtil.jdField_b_of_type_JavaUtilHashMap.get(this.a.jdField_b_of_type_JavaLangString);
        if (localObject == null) {
          break label698;
        }
        j = ((LinkedHashMap)localObject).size();
        if (j <= 0) {
          break label698;
        }
      }
    }
    label646:
    label662:
    label698:
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
          label358:
          i = j;
          if (((Iterator)localObject).hasNext())
          {
            if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus != 3) {
              break label646;
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
        label460:
        if (j < k) {
          if (((String)localObject).equals(((LocalMediaInfo)paramList.get(j)).path)) {
            i = j;
          }
        }
      }
      for (;;)
      {
        label489:
        j = this.a.jdField_a_of_type_Wur.getCount();
        if (j == 0) {
          j = m;
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(j);
          this.a.jdField_a_of_type_Wur.notifyDataSetChanged();
          this.a.e();
          if ((!this.a.N) || (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideShowPhotoListManager == null)) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideShowPhotoListManager.a(this.a.jdField_c_of_type_JavaUtilArrayList);
          return;
          if ((!this.a.J) || (paramList.size() != 1)) {
            break label231;
          }
          QQToast.a(this.a, "暂无媒体文件", 1000).a();
          if (this.a.jdField_e_of_type_AndroidWidgetTextView == null) {
            break label231;
          }
          this.a.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
          break label231;
          label635:
          i = this.a.r;
          break label264;
          k += 1;
          break label358;
          j += 1;
          break label460;
          PhotoListActivity.jdField_m_of_type_Int = -1;
          break label489;
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
    this.a.runOnUiThread(new wuu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoListActivity.QueryPhotoTask
 * JD-Core Version:    0.7.0.1
 */