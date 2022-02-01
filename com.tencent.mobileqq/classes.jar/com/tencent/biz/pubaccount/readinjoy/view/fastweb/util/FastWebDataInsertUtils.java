package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.ModuleInfo;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.TextCardInfo;

public class FastWebDataInsertUtils
{
  private static int a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, List<BaseData> paramList)
  {
    int m = 0;
    if ((paramList == null) || (paramList.isEmpty())) {
      paramInt1 = -1;
    }
    label134:
    label143:
    label149:
    label208:
    for (;;)
    {
      return paramInt1;
      int i;
      int k;
      int j;
      if (paramBoolean1)
      {
        i = 0;
        k = 1;
        j = i;
        Object localObject = (BaseData)paramList.get(j);
        i = k;
        if (!(localObject instanceof ProteusItemData)) {
          break label149;
        }
        localObject = (ProteusItemData)localObject;
        i = k;
        if (((ProteusItemData)localObject).x != 1) {
          break label149;
        }
        if (((ProteusItemData)localObject).w != paramInt2)
        {
          i = k;
          if (paramInt2 != 0) {
            break label149;
          }
        }
        if (paramInt1 != k) {
          break label143;
        }
        if (!paramBoolean2) {
          break label134;
        }
        label109:
        paramInt2 = 1;
        paramInt1 = j;
      }
      for (;;)
      {
        label114:
        if (paramInt2 != 0) {
          break label208;
        }
        return -1;
        i = paramList.size() - 1;
        break;
        j += 1;
        break label109;
        i = k + 1;
        if (paramBoolean1) {
          j += 1;
        }
        for (;;)
        {
          if (j >= 0)
          {
            if (j >= paramList.size())
            {
              paramInt1 = i;
              paramInt2 = m;
              break label114;
              j -= 1;
              continue;
            }
            k = i;
            break;
          }
        }
        paramInt1 = i;
        paramInt2 = m;
      }
    }
  }
  
  public static void a(int paramInt, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, List<BaseData> paramList, List<oidb_cmd0xe7e.TextCardInfo> paramList1, SparseArray<Float> paramSparseArray)
  {
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    if (b(paramList))
    {
      QLog.d("FastWeb0xc6dDataUtils", 1, "has inserted text cards!");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("insertTextCards:");
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      oidb_cmd0xe7e.TextCardInfo localTextCardInfo = (oidb_cmd0xe7e.TextCardInfo)localIterator.next();
      try
      {
        int i = localTextCardInfo.uint32_disable_scene.get();
        if ((i & paramInt) == 0) {
          break label164;
        }
        QLog.d("FastWeb0xc6dDataUtils", 1, "insertTextCards: disableScene " + i + " give up ! data : " + localTextCardInfo.bytes_card_json.get().toStringUtf8());
      }
      catch (Exception paramList1)
      {
        QLog.d("FastWeb0xc6dDataUtils", 1, "insertTextCards error! msg=" + paramList1);
      }
      continue;
      label164:
      JSONObject localJSONObject = new JSONObject(localTextCardInfo.bytes_card_json.get().toStringUtf8());
      if (FastWebPtsLiteDataUtil.a(localJSONObject))
      {
        if (!PTSLiteSwitchManager.a().a()) {
          QLog.d("FastWeb0xc6dDataUtils", 1, "insertTextCards give up for pts lite engine not ready ! data : " + localTextCardInfo.bytes_card_json.get().toStringUtf8());
        } else {
          paramList1 = FastWebPtsLiteDataUtil.a(localJSONObject);
        }
      }
      else {
        for (;;)
        {
          paramList1.b = FastWebPTSDataConverter.a(paramSparseArray);
          a(localTextCardInfo.enum_indexing_type.get(), localTextCardInfo.bool_locate_forwards.get(), localTextCardInfo.uint32_location.get(), localTextCardInfo.bool_insert_forwards.get(), paramList, paramList1);
          localStringBuilder.append("\n[data : ").append(localJSONObject.toString()).append("，type : ").append(localTextCardInfo.enum_indexing_type.get()).append(", locate_forwards : ").append(localTextCardInfo.bool_locate_forwards.get()).append(", location :").append(localTextCardInfo.uint32_location.get()).append(", insert_forward : ").append(localTextCardInfo.bool_insert_forwards.get()).append(", disable_scene : ").append(localTextCardInfo.uint32_disable_scene.get()).append("]");
          break;
          paramList1 = FastWebPTSDataConverter.a(localJSONObject, paramArticleInfo, paramFastWebArticleInfo);
          paramList1.x = 1;
          paramList1.w = -1;
        }
      }
    }
    QLog.d("FastWeb0xc6dDataUtils", 1, localStringBuilder.toString());
  }
  
  private static void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, List<BaseData> paramList, BaseData paramBaseData)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        return;
        paramInt1 = a(paramBoolean1, paramInt2, paramBoolean2, paramInt1, paramList);
      } while (paramInt1 == -1);
      if ((paramInt1 >= 0) && (paramInt1 < paramList.size()))
      {
        paramList.add(paramInt1, paramBaseData);
        return;
      }
    } while (paramInt1 < paramList.size());
    paramList.add(paramBaseData);
  }
  
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, List<BaseData> paramList, List<oidb_cmd0xe7e.ModuleInfo> paramList1, ItemShowDispatcher paramItemShowDispatcher, SparseArray<Float> paramSparseArray)
  {
    if ((paramList == null) || (paramList1 == null)) {}
    for (;;)
    {
      return;
      if (a(paramList))
      {
        QLog.d("FastWeb0xc6dDataUtils", 1, "has inserted module!");
        return;
      }
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramSparseArray = (oidb_cmd0xe7e.ModuleInfo)paramList1.next();
        try
        {
          ProteusItemData localProteusItemData = FastWebPTSDataConverter.a(new JSONObject(paramSparseArray.bytes_json.get().toStringUtf8()), paramArticleInfo, paramFastWebArticleInfo);
          localProteusItemData.x = -99;
          localProteusItemData.b = paramSparseArray.bytes_weight.get();
          ItemDatasListUtils.a(paramList, localProteusItemData, paramItemShowDispatcher);
        }
        catch (Exception paramSparseArray)
        {
          QLog.d("FastWeb0xc6dDataUtils", 1, "insertModules error! msg=" + paramSparseArray);
        }
      }
    }
  }
  
  private static boolean a(List<BaseData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseData localBaseData = (BaseData)paramList.next();
      if (((localBaseData instanceof ProteusItemData)) && (((ProteusItemData)localBaseData).x == -99)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(List<BaseData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseData localBaseData = (BaseData)paramList.next();
      if (((localBaseData instanceof ProteusItemData)) && (((ProteusItemData)localBaseData).w == -1)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebDataInsertUtils
 * JD-Core Version:    0.7.0.1
 */