package com.tencent.biz.qqcircle.localphoto.scan.datamanager;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.localphoto.scan.data.LocalPhotoInfo;
import com.tencent.biz.qqcircle.localphoto.scan.data.LocalPhotoInfo.ImageTag;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCirclePhotocatemetadata.PhotoExifInfo;
import qqcircle.QQCirclePhotocatemetadata.PhotoMetadata;
import qqcircle.QQCirclePhotocatemetadata.PhotoTagInfo;

public class QCircleScanPhotoInfoManager
{
  private static volatile QCircleScanPhotoInfoManager a;
  private static final Object b = new Object();
  private static final Object c = new Object();
  private static EntityManager d;
  private final ArrayList<QQCirclePhotocatemetadata.PhotoMetadata> e = new ArrayList();
  private final ArrayList<QQCirclePhotocatemetadata.PhotoMetadata> f = new ArrayList();
  
  private static QCircleScanPhotoInfoEntity a(LocalPhotoInfo paramLocalPhotoInfo)
  {
    QCircleScanPhotoInfoEntity localQCircleScanPhotoInfoEntity = new QCircleScanPhotoInfoEntity();
    localQCircleScanPhotoInfoEntity.photoId = paramLocalPhotoInfo.a;
    localQCircleScanPhotoInfoEntity.path = paramLocalPhotoInfo.b;
    localQCircleScanPhotoInfoEntity.mineType = paramLocalPhotoInfo.c;
    localQCircleScanPhotoInfoEntity.time = paramLocalPhotoInfo.d;
    localQCircleScanPhotoInfoEntity.modifyTime = paramLocalPhotoInfo.e;
    localQCircleScanPhotoInfoEntity.width = paramLocalPhotoInfo.f;
    localQCircleScanPhotoInfoEntity.height = paramLocalPhotoInfo.g;
    localQCircleScanPhotoInfoEntity.orientation = paramLocalPhotoInfo.h;
    localQCircleScanPhotoInfoEntity.latitude = paramLocalPhotoInfo.i;
    localQCircleScanPhotoInfoEntity.longitude = paramLocalPhotoInfo.j;
    localQCircleScanPhotoInfoEntity.imageTags = QCircleScanPhotoInfoEntity.imageTagToString(paramLocalPhotoInfo.k);
    return localQCircleScanPhotoInfoEntity;
  }
  
  public static QCircleScanPhotoInfoManager a()
  {
    if (a == null) {
      synchronized (b)
      {
        if (a == null)
        {
          QLog.i("QCircleScanPhotoInfoManager", 1, "getInstance");
          a = new QCircleScanPhotoInfoManager();
        }
      }
    }
    return a;
  }
  
  private static QQCirclePhotocatemetadata.PhotoMetadata a(QCircleScanPhotoInfoEntity paramQCircleScanPhotoInfoEntity)
  {
    QQCirclePhotocatemetadata.PhotoMetadata localPhotoMetadata = new QQCirclePhotocatemetadata.PhotoMetadata();
    localPhotoMetadata.id.set(String.valueOf(paramQCircleScanPhotoInfoEntity.photoId));
    localPhotoMetadata.height.set(paramQCircleScanPhotoInfoEntity.height);
    localPhotoMetadata.modifyTime.set(paramQCircleScanPhotoInfoEntity.modifyTime);
    localPhotoMetadata.width.set(paramQCircleScanPhotoInfoEntity.width);
    localPhotoMetadata.path.set(paramQCircleScanPhotoInfoEntity.path);
    localPhotoMetadata.mimeType.set(paramQCircleScanPhotoInfoEntity.mineType);
    localPhotoMetadata.time.set(paramQCircleScanPhotoInfoEntity.time);
    if (!TextUtils.isEmpty(paramQCircleScanPhotoInfoEntity.imageTags))
    {
      Iterator localIterator = QCircleScanPhotoInfoEntity.stringToImagtags(paramQCircleScanPhotoInfoEntity.imageTags).iterator();
      while (localIterator.hasNext())
      {
        LocalPhotoInfo.ImageTag localImageTag = (LocalPhotoInfo.ImageTag)localIterator.next();
        QQCirclePhotocatemetadata.PhotoTagInfo localPhotoTagInfo = new QQCirclePhotocatemetadata.PhotoTagInfo();
        localPhotoTagInfo.classifyConfidence.set(localImageTag.c);
        localPhotoTagInfo.classifyName.set(localImageTag.b);
        localPhotoTagInfo.classifyType.set(localImageTag.a);
        localPhotoMetadata.tags.add(localPhotoTagInfo);
      }
    }
    localPhotoMetadata.exif.orientation.set(paramQCircleScanPhotoInfoEntity.orientation);
    localPhotoMetadata.exif.latitude.set(Math.round(paramQCircleScanPhotoInfoEntity.latitude));
    localPhotoMetadata.exif.longitude.set(Math.round(paramQCircleScanPhotoInfoEntity.longitude));
    return localPhotoMetadata;
  }
  
  private static QQCirclePhotocatemetadata.PhotoMetadata b(LocalPhotoInfo paramLocalPhotoInfo)
  {
    QQCirclePhotocatemetadata.PhotoMetadata localPhotoMetadata = new QQCirclePhotocatemetadata.PhotoMetadata();
    localPhotoMetadata.id.set(String.valueOf(paramLocalPhotoInfo.a));
    localPhotoMetadata.height.set(paramLocalPhotoInfo.g);
    localPhotoMetadata.modifyTime.set(paramLocalPhotoInfo.e);
    localPhotoMetadata.width.set(paramLocalPhotoInfo.f);
    localPhotoMetadata.path.set(paramLocalPhotoInfo.b);
    localPhotoMetadata.mimeType.set(paramLocalPhotoInfo.c);
    localPhotoMetadata.time.set(paramLocalPhotoInfo.d);
    if ((paramLocalPhotoInfo.k != null) && (paramLocalPhotoInfo.k.size() > 0))
    {
      Iterator localIterator = paramLocalPhotoInfo.k.iterator();
      while (localIterator.hasNext())
      {
        LocalPhotoInfo.ImageTag localImageTag = (LocalPhotoInfo.ImageTag)localIterator.next();
        QQCirclePhotocatemetadata.PhotoTagInfo localPhotoTagInfo = new QQCirclePhotocatemetadata.PhotoTagInfo();
        localPhotoTagInfo.classifyConfidence.set(localImageTag.c);
        localPhotoTagInfo.classifyName.set(localImageTag.b);
        localPhotoTagInfo.classifyType.set(localImageTag.a);
        localPhotoMetadata.tags.add(localPhotoTagInfo);
      }
    }
    localPhotoMetadata.exif.orientation.set(paramLocalPhotoInfo.h);
    localPhotoMetadata.exif.latitude.set(Math.round(paramLocalPhotoInfo.i));
    localPhotoMetadata.exif.longitude.set(Math.round(paramLocalPhotoInfo.j));
    return localPhotoMetadata;
  }
  
  private static EntityManager e()
  {
    if (d == null) {
      synchronized (c)
      {
        if (d == null) {
          d = new QCircleScanPhotoInfoEntityManagerFactory("qcirclephoto").createEntityManager();
        }
      }
    }
    return d;
  }
  
  public void a(LocalPhotoInfo paramLocalPhotoInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        this.f.add(b(paramLocalPhotoInfo));
      }
      EntityManager localEntityManager = e();
      String str = QCircleScanPhotoInfoEntity.class.getSimpleName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLocalPhotoInfo.a);
      localStringBuilder.append("");
      localEntityManager.delete(str, "photoId = ?", new String[] { localStringBuilder.toString() });
    }
    else
    {
      if (paramBoolean2) {
        this.e.add(b(paramLocalPhotoInfo));
      }
      paramLocalPhotoInfo = a(paramLocalPhotoInfo);
      e().persistOrReplace(paramLocalPhotoInfo);
    }
    if ((this.f.size() + this.e.size() >= 50) || (paramBoolean3))
    {
      a(this.e, this.f, paramBoolean3);
      this.f.clear();
      this.e.clear();
    }
  }
  
  public void a(ArrayList<QQCirclePhotocatemetadata.PhotoMetadata> paramArrayList1, ArrayList<QQCirclePhotocatemetadata.PhotoMetadata> paramArrayList2, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramArrayList1 != null) {
      localArrayList1.addAll(paramArrayList1);
    }
    ArrayList localArrayList2 = new ArrayList();
    if (paramArrayList2 != null) {
      localArrayList2.addAll(paramArrayList2);
    }
    paramArrayList1 = new QCircleUploadPhotoInfoRequest(paramArrayList1, paramArrayList2, paramBoolean);
    VSNetworkHelper.getInstance().sendRequest(paramArrayList1, new QCircleScanPhotoInfoManager.1(this, localArrayList1));
  }
  
  public boolean b()
  {
    Object localObject = (ArrayList)e().query(QCircleScanPhotoInfoEntity.class);
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (localObject != null)
    {
      bool2 = bool3;
      if (!((ArrayList)localObject).isEmpty())
      {
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          QCircleScanPhotoInfoEntity localQCircleScanPhotoInfoEntity = (QCircleScanPhotoInfoEntity)((Iterator)localObject).next();
          if (!localQCircleScanPhotoInfoEntity.hasUpload)
          {
            localArrayList.add(a(localQCircleScanPhotoInfoEntity));
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (!localArrayList.isEmpty())
        {
          a(localArrayList, null, true);
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  public List<Integer> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ArrayList)e().query(QCircleScanPhotoInfoEntity.class);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Integer.valueOf(((QCircleScanPhotoInfoEntity)((Iterator)localObject).next()).photoId));
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.datamanager.QCircleScanPhotoInfoManager
 * JD-Core Version:    0.7.0.1
 */