package com.tencent.biz.qqcircle.localphoto.scan;

import android.app.Application;
import android.content.Intent;
import android.location.Location;
import android.media.ExifInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.localphoto.scan.data.LocalPhotoInfo;
import com.tencent.biz.qqcircle.publish.util.ExifUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class QCirclePhotoLocalClusterHelper
{
  private LocalPhotoCursor a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private SimpleDateFormat g;
  private List<List<LocalPhotoInfo>> h;
  private List<List<LocalPhotoInfo>> i;
  
  public QCirclePhotoLocalClusterHelper()
  {
    List localList = Arrays.asList(QCircleConfigHelper.a("qqcircle", "qqcircle_local_photo_scan_forbidden_dir", "MagazineUnlock,Screenshots").split(","));
    LocalPhotoCursor.Builder localBuilder = new LocalPhotoCursor.Builder().a(QCircleApplication.APP.getApplicationContext());
    Integer localInteger = Integer.valueOf(0);
    this.a = localBuilder.a(QCircleConfigHelper.a("qqcircle", "qqcircle_local_photo_scan_min_size", localInteger).intValue()).b(QCircleConfigHelper.a("qqcircle", "qqcircle_local_photo_scan_max_size", localInteger).intValue()).c(QCircleConfigHelper.a("qqcircle", "qqcircle_album_max_statics_photo_number", Integer.valueOf(100)).intValue()).a(localList).a();
  }
  
  private void a(@NonNull List<List<LocalPhotoInfo>> paramList)
  {
    JSONArray localJSONArray1 = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (List)paramList.next();
      JSONArray localJSONArray2 = new JSONArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalPhotoInfo localLocalPhotoInfo = (LocalPhotoInfo)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("KEY_LOCAL_PHOTO_CLUSTER_PHOTO_ID", localLocalPhotoInfo.a);
        localJSONObject.put("KEY_LOCAL_PHOTO_CLUSTER_PHOTO_PATH", localLocalPhotoInfo.b);
        localJSONArray2.put(localJSONObject);
      }
      localJSONArray1.put(localJSONArray2);
    }
    paramList = new Intent("action_local_photo_cluster");
    paramList.putExtra("KEY_LOCAL_PHOTO_CLUSTER", localJSONArray1.toString());
    QCircleApplication.APP.sendBroadcast(paramList);
  }
  
  private void a(List<List<LocalPhotoInfo>> paramList, List<LocalPhotoInfo> paramList1)
  {
    int j = paramList1.size();
    int k = this.d;
    if (j < k) {
      return;
    }
    paramList.add(paramList1.subList(0, k));
    a(paramList, paramList1.subList(this.d + 1, j));
  }
  
  private boolean a(@NonNull LocalPhotoInfo paramLocalPhotoInfo1, @NonNull LocalPhotoInfo paramLocalPhotoInfo2)
  {
    float[] arrayOfFloat = new float[3];
    Location.distanceBetween(paramLocalPhotoInfo1.i, paramLocalPhotoInfo2.j, paramLocalPhotoInfo2.i, paramLocalPhotoInfo2.j, arrayOfFloat);
    boolean bool = false;
    if (arrayOfFloat[0] < this.f) {
      bool = true;
    }
    return bool;
  }
  
  private List<List<LocalPhotoInfo>> b()
  {
    long l = System.currentTimeMillis();
    Object localObject = c();
    if (localObject == null)
    {
      QLog.i("QCirclePhotoLocalClusterHelper", 1, String.format(Locale.CHINESE, "[collectPhotos] photos are not enough, cost=%dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      return null;
    }
    QLog.i("QCirclePhotoLocalClusterHelper", 1, String.format(Locale.CHINESE, "[collectPhotos] localPhotoInfoList.size=%d, cost=%dms", new Object[] { Integer.valueOf(((List)localObject).size()), Long.valueOf(System.currentTimeMillis() - l) }));
    l = System.currentTimeMillis();
    b((List)localObject);
    QLog.i("QCirclePhotoLocalClusterHelper", 1, String.format(Locale.CHINESE, "[retrievePhotoGpsFromExif] localPhotoInfoList.size=%d, cost=%dms", new Object[] { Integer.valueOf(((List)localObject).size()), Long.valueOf(System.currentTimeMillis() - l) }));
    this.f = QCircleConfigHelper.a("qqcircle", "qqcircle_album_position_strategy_distance", Integer.valueOf(1000)).intValue();
    this.g = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
    l = System.currentTimeMillis();
    List localList = c((List)localObject);
    QLog.i("QCirclePhotoLocalClusterHelper", 1, String.format(Locale.CHINESE, "[clusterByDateAndGps] clusters.size=%d, cost=%dms", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(System.currentTimeMillis() - l) }));
    if (h(localList)) {
      return localList;
    }
    l = System.currentTimeMillis();
    localList = d((List)localObject);
    QLog.i("QCirclePhotoLocalClusterHelper", 1, String.format(Locale.CHINESE, "[clusterByGpsAndDate] clusters.size=%d, cost=%dms", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(System.currentTimeMillis() - l) }));
    if (h(localList)) {
      return localList;
    }
    QLog.i("QCirclePhotoLocalClusterHelper", 1, String.format(Locale.CHINESE, "[clusterByDate] clusters.size=%d", new Object[] { Integer.valueOf(this.h.size()) }));
    if (h(this.h)) {
      return this.h;
    }
    QLog.i("QCirclePhotoLocalClusterHelper", 1, String.format(Locale.CHINESE, "[clusterByGps] clusters.size=%d", new Object[] { Integer.valueOf(this.i.size()) }));
    if (h(this.i)) {
      return this.i;
    }
    localObject = g((List)localObject);
    QLog.i("QCirclePhotoLocalClusterHelper", 1, String.format(Locale.CHINESE, "[clusterBySequence] clusters.size=%d", new Object[] { Integer.valueOf(((List)localObject).size()) }));
    return localObject;
  }
  
  private void b(@NonNull List<LocalPhotoInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LocalPhotoInfo localLocalPhotoInfo = (LocalPhotoInfo)paramList.next();
      if (localLocalPhotoInfo != null)
      {
        ExifInterface localExifInterface = ExifUtil.b(localLocalPhotoInfo.b);
        if (localExifInterface != null) {
          try
          {
            float[] arrayOfFloat = new float[2];
            localExifInterface.getLatLong(arrayOfFloat);
            localLocalPhotoInfo.i = arrayOfFloat[0];
            localLocalPhotoInfo.j = arrayOfFloat[1];
          }
          catch (Exception localException)
          {
            QLog.e("QCirclePhotoLocalClusterHelper", 1, "collectPhotoGps", localException);
          }
        }
      }
    }
  }
  
  @Nullable
  private LinkedList<LocalPhotoInfo> c()
  {
    LinkedList localLinkedList = this.a.a();
    if ((localLinkedList != null) && (localLinkedList.size() != 0))
    {
      this.b = QCircleConfigHelper.a("qqcircle", "qqcircle_local_recommend_min_group", Integer.valueOf(3)).intValue();
      this.c = QCircleConfigHelper.a("qqcircle", "qqcircle_local_recommend_max_group", Integer.valueOf(8)).intValue();
      this.d = QCircleConfigHelper.a("qqcircle", "qqcircle_local_recommend_min_group_cell", Integer.valueOf(4)).intValue();
      this.e = QCircleConfigHelper.a("qqcircle", "qqcircle_local_recommend_max_group_cell", Integer.valueOf(9)).intValue();
      if (localLinkedList.size() < this.b * this.d) {
        return null;
      }
      return localLinkedList;
    }
    QLog.e("QCirclePhotoLocalClusterHelper", 1, "[collectPhotos] no photos found in MediaStore");
    return null;
  }
  
  @NonNull
  private List<List<LocalPhotoInfo>> c(@NonNull List<LocalPhotoInfo> paramList)
  {
    this.h = new ArrayList();
    paramList = e(paramList);
    Object localObject = new TreeSet(new QCirclePhotoLocalClusterHelper.2(this));
    ((TreeSet)localObject).addAll(paramList.keySet());
    ArrayList localArrayList = new ArrayList();
    localObject = ((TreeSet)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      List localList = (List)paramList.get((String)((Iterator)localObject).next());
      if (localList.size() >= this.d)
      {
        this.h.add(localList);
        localArrayList.addAll(f(localList));
      }
    }
    return localArrayList;
  }
  
  @NonNull
  private List<List<LocalPhotoInfo>> d(@NonNull List<LocalPhotoInfo> paramList)
  {
    this.i = f(paramList);
    paramList = new ArrayList();
    Iterator localIterator1 = this.i.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = e((List)localIterator1.next()).values().iterator();
      while (localIterator2.hasNext())
      {
        List localList = (List)localIterator2.next();
        if ((localList != null) && (localList.size() >= this.d)) {
          paramList.add(localList);
        }
      }
    }
    return paramList;
  }
  
  @NonNull
  private HashMap<String, List<LocalPhotoInfo>> e(@NonNull List<LocalPhotoInfo> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LocalPhotoInfo localLocalPhotoInfo = (LocalPhotoInfo)paramList.next();
      String str = this.g.format(new Date(localLocalPhotoInfo.d * 1000L));
      if (!localHashMap.containsKey(str)) {
        localHashMap.put(str, new ArrayList());
      }
      ((List)localHashMap.get(str)).add(localLocalPhotoInfo);
    }
    return localHashMap;
  }
  
  @NonNull
  private List<List<LocalPhotoInfo>> f(@NonNull List<LocalPhotoInfo> paramList)
  {
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (LocalPhotoInfo)paramList.next();
      if ((localObject2 != null) && (((LocalPhotoInfo)localObject2).i != 0.0F) && (((LocalPhotoInfo)localObject2).j != 0.0F))
      {
        int j = ((List)localObject1).size();
        int k = 1;
        j -= 1;
        while (j >= 0)
        {
          if (a((LocalPhotoInfo)((List)((List)localObject1).get(j)).get(0), (LocalPhotoInfo)localObject2))
          {
            ((List)((List)localObject1).get(j)).add(localObject2);
            j = k;
            break label144;
          }
          j -= 1;
        }
        j = 0;
        label144:
        if (j == 0)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject2);
          ((List)localObject1).add(localArrayList);
        }
      }
    }
    paramList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (List)((Iterator)localObject1).next();
      if (((List)localObject2).size() > this.d) {
        paramList.add(localObject2);
      }
    }
    return paramList;
  }
  
  @NonNull
  private List<List<LocalPhotoInfo>> g(@NonNull List<LocalPhotoInfo> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    while (j < this.b)
    {
      ArrayList localArrayList2 = new ArrayList();
      int k = 0;
      for (;;)
      {
        int m = this.d;
        if (k >= m) {
          break;
        }
        localArrayList2.add(paramList.get(m * j + k));
        k += 1;
      }
      localArrayList1.add(localArrayList2);
      j += 1;
    }
    return localArrayList1;
  }
  
  private boolean h(@NonNull List<List<LocalPhotoInfo>> paramList)
  {
    int j;
    int k;
    if (paramList.size() >= this.b)
    {
      j = paramList.size();
      k = this.c;
      localObject = paramList;
      if (j > k) {
        localObject = paramList.subList(0, k);
      }
      j = ((List)localObject).size() - 1;
      while (j >= 0)
      {
        if (((List)((List)localObject).get(j)).size() > this.e) {
          ((List)localObject).set(j, ((List)((List)localObject).get(j)).subList(0, this.e));
        }
        j -= 1;
      }
      return true;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a(localArrayList, (List)((Iterator)localObject).next());
    }
    if (localArrayList.size() >= this.b)
    {
      j = paramList.size();
      k = this.c;
      localObject = localArrayList;
      if (j > k) {
        localObject = localArrayList.subList(0, k);
      }
      paramList.clear();
      paramList.addAll((Collection)localObject);
      return true;
    }
    return false;
  }
  
  public void a()
  {
    ThreadManager.executeOnFileThread(new QCirclePhotoLocalClusterHelper.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.QCirclePhotoLocalClusterHelper
 * JD-Core Version:    0.7.0.1
 */