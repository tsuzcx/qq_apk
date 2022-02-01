package com.tencent.biz.qqcircle.bizparts.danmaku.model;

import NS_MOBILE_MATERIAL.BubbleSource;
import NS_MOBILE_MATERIAL.MaterialCate;
import NS_MOBILE_MATERIAL.MaterialFile;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_MATERIAL.material_cate_get_rsp;
import android.content.ContentValues;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.ParcelableWrapper;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;
import com.tencent.mobileqq.qcircle.api.db.DbCacheData;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class QzoneBarrageEffectData
  extends DbCacheData
  implements SmartParcelable
{
  public static final String BARRAGE_EFFECT_DATA = "barrage_effect_data";
  public static final IDBCacheDataWrapper.DbCreator<QzoneBarrageEffectData> DB_CREATOR = new QzoneBarrageEffectData.1();
  private static final String TAG = "SuperPersonalFontData";
  public static final String TYPE_BARRAGE_EFFECT_DATA = "BLOB";
  public static final String TYPE_UIN = "INTEGER UNIQUE";
  public static final String UIN = "uin";
  public static final int VERSION = 1;
  @NeedParcel
  public int defaultFont = 0;
  @NeedParcel
  public ArrayList<QzoneBarrageEffectData.BarrageEffectInfo> fontList = new ArrayList();
  @NeedParcel
  public int newCustomFontId = 0;
  @NeedParcel
  public long newCustomFontIdEndTime = 0L;
  @NeedParcel
  public long uin = 0L;
  
  public static QzoneBarrageEffectData createFromResponse(long paramLong, material_cate_get_rsp parammaterial_cate_get_rsp)
  {
    QzoneBarrageEffectData localQzoneBarrageEffectData;
    if ((parammaterial_cate_get_rsp != null) && (parammaterial_cate_get_rsp.stCate != null) && (parammaterial_cate_get_rsp.stCate.vecItem != null))
    {
      localQzoneBarrageEffectData = new QzoneBarrageEffectData();
      localQzoneBarrageEffectData.uin = paramLong;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)parammaterial_cate_get_rsp.stCate.mapExtInfo.get("iLastUsedId"))) {
          localQzoneBarrageEffectData.defaultFont = transferToInt((String)parammaterial_cate_get_rsp.stCate.mapExtInfo.get("iLastUsedId"));
        } else {
          localQzoneBarrageEffectData.defaultFont = -1;
        }
        parammaterial_cate_get_rsp = parammaterial_cate_get_rsp.stCate.vecItem.iterator();
        if (parammaterial_cate_get_rsp.hasNext())
        {
          localObject = (MaterialItem)parammaterial_cate_get_rsp.next();
          QzoneBarrageEffectData.BarrageEffectInfo localBarrageEffectInfo = new QzoneBarrageEffectData.BarrageEffectInfo();
          localBarrageEffectInfo.a = ((MaterialItem)localObject).stThumb.strUrl;
          localBarrageEffectInfo.b = ((MaterialItem)localObject).iPrice;
          localBarrageEffectInfo.c = ((MaterialItem)localObject).strItemName;
          localBarrageEffectInfo.i = ((MaterialItem)localObject).iItemId;
          localBarrageEffectInfo.d = ((MaterialItem)localObject).iItemType;
          if (transferToInt((String)((MaterialItem)localObject).mapExtInfo.get("iUserQualType")) != 1) {
            break label583;
          }
          bool = true;
          localBarrageEffectInfo.e = bool;
          localBarrageEffectInfo.a((MaterialItem)localObject);
          localBarrageEffectInfo.f = ((String)((MaterialItem)localObject).mapExtInfo.get("strPriceDesc"));
          localBarrageEffectInfo.g = ((String)((MaterialItem)localObject).mapExtInfo.get("iActId"));
          localBarrageEffectInfo.h = ((String)((MaterialItem)localObject).mapExtInfo.get("iRuleId"));
          localBarrageEffectInfo.m = ((MaterialItem)localObject).iTypeId;
          BubbleSource localBubbleSource = new BubbleSource();
          localBubbleSource.strTextColor1 = ((String)((MaterialItem)localObject).mapExtInfo.get("strTextColor1"));
          localBubbleSource.strTextColor2 = ((String)((MaterialItem)localObject).mapExtInfo.get("strTextColor2"));
          if (((MaterialItem)localObject).vecFile.size() > 4)
          {
            localBubbleSource.strAndUrl1 = ((MaterialFile)((MaterialItem)localObject).vecFile.get(2)).strUrl;
            localBubbleSource.strAndUrl2 = ((MaterialFile)((MaterialItem)localObject).vecFile.get(3)).strUrl;
          }
          if (((MaterialItem)localObject).vecFile.size() > 2) {
            localBarrageEffectInfo.o = ((MaterialFile)((MaterialItem)localObject).vecFile.get(2)).strUrl;
          }
          localBarrageEffectInfo.n = localBubbleSource;
          if (((MaterialItem)localObject).mapExtInfo.containsKey("iFrameRate")) {
            localBarrageEffectInfo.p = Integer.parseInt((String)((MaterialItem)localObject).mapExtInfo.get("iFrameRate"));
          }
          localQzoneBarrageEffectData.fontList.add(localBarrageEffectInfo);
          continue;
        }
        if (QLog.isColorLevel())
        {
          parammaterial_cate_get_rsp = new StringBuilder();
          parammaterial_cate_get_rsp.append("font list size = ");
          parammaterial_cate_get_rsp.append(localQzoneBarrageEffectData.fontList.size());
          QLog.d("SuperPersonalFontData", 2, parammaterial_cate_get_rsp.toString());
          return localQzoneBarrageEffectData;
        }
      }
      catch (Throwable parammaterial_cate_get_rsp)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("createFromResponse Throwable, msg = ");
        ((StringBuilder)localObject).append(parammaterial_cate_get_rsp.getMessage());
        QLog.e("SuperPersonalFontData", 1, ((StringBuilder)localObject).toString());
      }
      return localQzoneBarrageEffectData;
      return null;
      label583:
      boolean bool = false;
    }
  }
  
  private static int transferToInt(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("transferToInt Throwable, msg = ");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("SuperPersonalFontData", 1, localStringBuilder.toString());
      }
    }
    return 0;
  }
  
  private static long transferToLong(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        long l = Long.parseLong(paramString);
        return l;
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("transferToLong Throwable, msg = ");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("SuperPersonalFontData", 1, localStringBuilder.toString());
      }
    }
    return 0L;
  }
  
  public void writeTo(ContentValues paramContentValues)
  {
    paramContentValues.put("uin", Long.valueOf(this.uin));
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    ParcelableWrapper.a(localParcel, 0, this);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("barrage_effect_data", arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.model.QzoneBarrageEffectData
 * JD-Core Version:    0.7.0.1
 */