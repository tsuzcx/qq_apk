package com.tencent.mobileqq.armap;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.armap.utils.ARResUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.precover.PrecoverUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipException;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x7b4.cmd0x7b4.POIInfo;
import tencent.im.oidb.cmd0x7b4.cmd0x7b4.TaskCommonInfo;

public class PoiExtraMng
  implements Manager
{
  private ArMapInterface jdField_a_of_type_ComTencentMobileqqArmapArMapInterface;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private HashMap b;
  
  public PoiExtraMng(ArMapInterface paramArMapInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface = paramArMapInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
    this.b = new HashMap(10);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = new JSONObject(paramString);
          if (paramString.has("games"))
          {
            paramString = paramString.getJSONArray("games");
            if (!paramString.isNull(0))
            {
              paramString = paramString.getJSONObject(0);
              if (paramString != null)
              {
                paramString = paramString.getString("md5");
                if ((!TextUtils.isEmpty(paramString)) && (PrecoverUtils.a("1024", paramString)))
                {
                  File localFile = ARResUtil.a("openbox");
                  if ((localFile != null) && (localFile.exists())) {}
                  ZipUtils.a(new File(PrecoverUtils.a("1024", paramString)), ARResUtil.a() + File.separator);
                  return;
                }
              }
            }
          }
        }
        catch (JSONException paramString)
        {
          if (QLog.isColorLevel())
          {
            paramString.printStackTrace();
            return;
          }
        }
        catch (ZipException paramString)
        {
          if (QLog.isColorLevel())
          {
            paramString.printStackTrace();
            return;
          }
        }
        catch (IOException paramString) {}
      }
    } while (!QLog.isColorLevel());
    paramString.printStackTrace();
  }
  
  public cmd0x7b4.TaskCommonInfo a(long paramLong)
  {
    return (cmd0x7b4.TaskCommonInfo)this.b.get(Long.valueOf(paramLong));
  }
  
  public void a(List paramList1, List paramList2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.b.clear();
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        cmd0x7b4.POIInfo localPOIInfo = (cmd0x7b4.POIInfo)paramList1.next();
        if (localPOIInfo != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localPOIInfo.uint64_poi_id.get()), localPOIInfo);
        }
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        paramList1 = (cmd0x7b4.TaskCommonInfo)paramList2.next();
        if (paramList1 != null)
        {
          this.b.put(Long.valueOf(paramList1.uint64_task_id.get()), paramList1);
          if (QLog.isColorLevel()) {
            QLog.i("ARMapActivity", 2, "updatePoiList, id: " + paramList1.uint64_task_id.get());
          }
          int i;
          if (paramList1.uint32_treasure_type.has())
          {
            i = paramList1.uint32_treasure_type.get();
            label200:
            if ((i != 4) && (i != 6) && (i != 7) && (i != 10)) {
              break label255;
            }
            if (!paramList1.bytes_config.has()) {
              break label257;
            }
          }
          label257:
          for (paramList1 = paramList1.bytes_config.get().toStringUtf8();; paramList1 = null)
          {
            a(paramList1);
            break;
            i = -1;
            break label200;
            label255:
            break;
          }
        }
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.PoiExtraMng
 * JD-Core Version:    0.7.0.1
 */