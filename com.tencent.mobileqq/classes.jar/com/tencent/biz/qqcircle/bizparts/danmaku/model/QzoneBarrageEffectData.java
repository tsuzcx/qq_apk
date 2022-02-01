package com.tencent.biz.qqcircle.bizparts.danmaku.model;

import NS_MOBILE_MATERIAL.BubbleSource;
import NS_MOBILE_MATERIAL.MaterialCate;
import NS_MOBILE_MATERIAL.MaterialFile;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_MATERIAL.material_cate_get_rsp;
import android.content.ContentValues;
import android.os.Parcel;
import android.text.TextUtils;
import bjvw;
import bjvx;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import vho;

public class QzoneBarrageEffectData
  extends bjvw
  implements SmartParcelable
{
  public static final String BARRAGE_EFFECT_DATA = "barrage_effect_data";
  public static final bjvx<QzoneBarrageEffectData> DB_CREATOR = new vho();
  private static final String TAG = "SuperPersonalFontData";
  public static final String TYPE_BARRAGE_EFFECT_DATA = "BLOB";
  public static final String TYPE_UIN = "INTEGER UNIQUE";
  public static final String UIN = "uin";
  public static final int VERSION = 1;
  @NeedParcel
  public int defaultFont;
  @NeedParcel
  public ArrayList<QzoneBarrageEffectData.BarrageEffectInfo> fontList = new ArrayList();
  @NeedParcel
  public int newCustomFontId;
  @NeedParcel
  public long newCustomFontIdEndTime;
  @NeedParcel
  public long uin;
  
  public static QzoneBarrageEffectData createFromResponse(long paramLong, material_cate_get_rsp parammaterial_cate_get_rsp)
  {
    if ((parammaterial_cate_get_rsp == null) || (parammaterial_cate_get_rsp.stCate == null) || (parammaterial_cate_get_rsp.stCate.vecItem == null)) {
      return null;
    }
    QzoneBarrageEffectData localQzoneBarrageEffectData = new QzoneBarrageEffectData();
    localQzoneBarrageEffectData.uin = paramLong;
    for (;;)
    {
      boolean bool;
      try
      {
        if (!TextUtils.isEmpty((CharSequence)parammaterial_cate_get_rsp.stCate.mapExtInfo.get("iLastUsedId")))
        {
          localQzoneBarrageEffectData.defaultFont = transferToInt((String)parammaterial_cate_get_rsp.stCate.mapExtInfo.get("iLastUsedId"));
          parammaterial_cate_get_rsp = parammaterial_cate_get_rsp.stCate.vecItem.iterator();
          if (!parammaterial_cate_get_rsp.hasNext()) {
            break label518;
          }
          MaterialItem localMaterialItem = (MaterialItem)parammaterial_cate_get_rsp.next();
          QzoneBarrageEffectData.BarrageEffectInfo localBarrageEffectInfo = new QzoneBarrageEffectData.BarrageEffectInfo();
          localBarrageEffectInfo.coverUrl = localMaterialItem.stThumb.strUrl;
          localBarrageEffectInfo.price = localMaterialItem.iPrice;
          localBarrageEffectInfo.name = localMaterialItem.strItemName;
          localBarrageEffectInfo.id = localMaterialItem.iItemId;
          localBarrageEffectInfo.fontType = localMaterialItem.iItemType;
          if (transferToInt((String)localMaterialItem.mapExtInfo.get("iUserQualType")) != 1) {
            break label560;
          }
          bool = true;
          localBarrageEffectInfo.hasAuth = bool;
          localBarrageEffectInfo.fillData(localMaterialItem);
          localBarrageEffectInfo.fontUsedTips = ((String)localMaterialItem.mapExtInfo.get("strPriceDesc"));
          localBarrageEffectInfo.actId = ((String)localMaterialItem.mapExtInfo.get("iActId"));
          localBarrageEffectInfo.ruleId = ((String)localMaterialItem.mapExtInfo.get("iRuleId"));
          localBarrageEffectInfo.type = localMaterialItem.iTypeId;
          BubbleSource localBubbleSource = new BubbleSource();
          localBubbleSource.strTextColor1 = ((String)localMaterialItem.mapExtInfo.get("strTextColor1"));
          localBubbleSource.strTextColor2 = ((String)localMaterialItem.mapExtInfo.get("strTextColor2"));
          if (localMaterialItem.vecFile.size() > 4)
          {
            localBubbleSource.strAndUrl1 = ((MaterialFile)localMaterialItem.vecFile.get(2)).strUrl;
            localBubbleSource.strAndUrl2 = ((MaterialFile)localMaterialItem.vecFile.get(3)).strUrl;
          }
          if (localMaterialItem.vecFile.size() > 2) {
            localBarrageEffectInfo.strFrameZip = ((MaterialFile)localMaterialItem.vecFile.get(2)).strUrl;
          }
          localBarrageEffectInfo.stSource = localBubbleSource;
          if (localMaterialItem.mapExtInfo.containsKey("iFrameRate")) {
            localBarrageEffectInfo.iFrameRate = Integer.parseInt((String)localMaterialItem.mapExtInfo.get("iFrameRate"));
          }
          localQzoneBarrageEffectData.fontList.add(localBarrageEffectInfo);
          continue;
        }
        localQzoneBarrageEffectData.defaultFont = -1;
      }
      catch (Throwable parammaterial_cate_get_rsp)
      {
        QZLog.e("SuperPersonalFontData", "createFromResponse Throwable, msg = " + parammaterial_cate_get_rsp.getMessage());
        return localQzoneBarrageEffectData;
      }
      continue;
      label518:
      if (QZLog.isColorLevel())
      {
        QZLog.d("SuperPersonalFontData", 2, "font list size = " + localQzoneBarrageEffectData.fontList.size());
        continue;
        label560:
        bool = false;
      }
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
        QZLog.e("SuperPersonalFontData", "transferToInt Throwable, msg = " + paramString.getMessage());
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
        QZLog.e("SuperPersonalFontData", "transferToLong Throwable, msg = " + paramString.getMessage());
      }
    }
    return 0L;
  }
  
  public void writeTo(ContentValues paramContentValues)
  {
    paramContentValues.put("uin", Long.valueOf(this.uin));
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    ParcelableWrapper.writeDataToParcel(localParcel, 0, this);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("barrage_effect_data", arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.model.QzoneBarrageEffectData
 * JD-Core Version:    0.7.0.1
 */