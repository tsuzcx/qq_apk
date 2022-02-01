import NearbyGroup.Attr;
import NearbyGroup.Cell;
import NearbyGroup.GPS;
import NearbyGroup.LBSInfo;
import NearbyGroup.Wifi;
import appoint.define.appoint_define.Cell;
import appoint.define.appoint_define.GPS;
import appoint.define.appoint_define.LBSInfo;
import appoint.define.appoint_define.Wifi;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awhp
{
  public static LBSInfo a()
  {
    return a(false, SosoInterface.getRawSosoInfo());
  }
  
  public static LBSInfo a(boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Attr localAttr = null;
    if (paramSosoLbsInfo == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    if (paramSosoLbsInfo.mCells != null)
    {
      localObject1 = paramSosoLbsInfo.mCells.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
        localArrayList.add(new Cell((short)((SosoInterface.SosoCell)localObject2).mMcc, (short)((SosoInterface.SosoCell)localObject2).mMnc, ((SosoInterface.SosoCell)localObject2).mLac, ((SosoInterface.SosoCell)localObject2).mCellId, (short)((SosoInterface.SosoCell)localObject2).mRss));
      }
    }
    for (;;)
    {
      try
      {
        if (paramSosoLbsInfo.mLocation == null) {
          break label313;
        }
        if (!paramBoolean) {
          continue;
        }
        localObject1 = new GPS((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D), (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D), -1, 1);
      }
      catch (Exception localException)
      {
        Iterator localIterator;
        SosoInterface.SosoWifi localSosoWifi;
        localGPS = null;
        continue;
        if (paramSosoLbsInfo.mAttr == null) {
          continue;
        }
        localAttr = new Attr(paramSosoLbsInfo.mAttr.mImei, paramSosoLbsInfo.mAttr.mImsi, paramSosoLbsInfo.mAttr.mPhoneNum);
        return new LBSInfo(localGPS, (ArrayList)localObject2, localArrayList, localAttr);
      }
      localObject2 = new ArrayList();
      if (paramSosoLbsInfo.mWifis != null)
      {
        localIterator = paramSosoLbsInfo.mWifis.iterator();
        if (localIterator.hasNext())
        {
          localSosoWifi = (SosoInterface.SosoWifi)localIterator.next();
          if (localSosoWifi == null) {
            continue;
          }
          ((ArrayList)localObject2).add(new Wifi(localSosoWifi.mMac, (short)localSosoWifi.mRssi));
          continue;
          localObject1 = new GPS((int)(paramSosoLbsInfo.mLocation.mLat84 * 1000000.0D), (int)(paramSosoLbsInfo.mLocation.mLon84 * 1000000.0D), -1, 0);
          continue;
        }
      }
      label313:
      GPS localGPS = null;
    }
  }
  
  public static appoint_define.LBSInfo a(String paramString)
  {
    Object localObject1 = SosoInterface.getRawSosoInfo();
    if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).mLocation == null) || (((SosoInterface.SosoLbsInfo)localObject1).mLocation.mLat02 == 0.0D) || (((SosoInterface.SosoLbsInfo)localObject1).mLocation.mLon02 == 0.0D)) {
      SosoInterface.reqRawLbsData(60000L, paramString);
    }
    for (paramString = SosoInterface.getRawSosoInfo();; paramString = (String)localObject1)
    {
      if (paramString != null)
      {
        localObject1 = new appoint_define.LBSInfo();
        Object localObject2;
        Object localObject3;
        Object localObject4;
        if (paramString.mWifis != null)
        {
          localObject2 = paramString.mWifis.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SosoInterface.SosoWifi)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject4 = new appoint_define.Wifi();
              ((appoint_define.Wifi)localObject4).uint64_mac.set(((SosoInterface.SosoWifi)localObject3).mMac);
              ((appoint_define.Wifi)localObject4).int32_rssi.set(((SosoInterface.SosoWifi)localObject3).mRssi);
              ((appoint_define.LBSInfo)localObject1).rpt_msg_wifis.add((MessageMicro)localObject4);
            }
          }
        }
        if (paramString.mCells != null)
        {
          localObject2 = paramString.mCells.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SosoInterface.SosoCell)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject4 = new appoint_define.Cell();
              ((appoint_define.Cell)localObject4).int32_cellid.set(((SosoInterface.SosoCell)localObject3).mCellId);
              ((appoint_define.Cell)localObject4).int32_lac.set(((SosoInterface.SosoCell)localObject3).mLac);
              ((appoint_define.Cell)localObject4).int32_rssi.set(((SosoInterface.SosoCell)localObject3).mRss);
              ((appoint_define.Cell)localObject4).int32_mcc.set(((SosoInterface.SosoCell)localObject3).mMcc);
              ((appoint_define.Cell)localObject4).int32_mnc.set(((SosoInterface.SosoCell)localObject3).mMnc);
              ((appoint_define.LBSInfo)localObject1).rpt_msg_cells.add((MessageMicro)localObject4);
            }
          }
        }
        if (paramString.mLocation != null)
        {
          localObject2 = new appoint_define.GPS();
          ((appoint_define.GPS)localObject2).int32_lon.set((int)(paramString.mLocation.mLon84 * 1000000.0D));
          ((appoint_define.GPS)localObject2).int32_lat.set((int)(paramString.mLocation.mLat84 * 1000000.0D));
          ((appoint_define.GPS)localObject2).int32_type.set(0);
          ((appoint_define.LBSInfo)localObject1).msg_gps.set((MessageMicro)localObject2);
          return localObject1;
        }
      }
      else
      {
        awkj.a("getLbsInfo", new Object[] { "lbs is null" });
        return null;
      }
      return localObject1;
    }
  }
  
  public static String a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray;
    Object localObject;
    try
    {
      localJSONObject.put("lat", (int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
      localJSONObject.put("lon", (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      localJSONArray = new JSONArray();
      localObject = paramSosoLbsInfo.mWifis.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SosoInterface.SosoWifi localSosoWifi = (SosoInterface.SosoWifi)((Iterator)localObject).next();
        localJSONArray.put(new JSONObject().put("mac", localSosoWifi.mMac).put("rssi", localSosoWifi.mRssi));
        continue;
        return localJSONObject.toString();
      }
    }
    catch (JSONException paramSosoLbsInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LbsUtils", 2, "lbsInfo to json exception", paramSosoLbsInfo);
      }
    }
    for (;;)
    {
      localJSONObject.put("wifis", localJSONArray);
      localJSONArray = new JSONArray();
      paramSosoLbsInfo = paramSosoLbsInfo.mCells.iterator();
      while (paramSosoLbsInfo.hasNext())
      {
        localObject = (SosoInterface.SosoCell)paramSosoLbsInfo.next();
        localJSONArray.put(new JSONObject().put("mcc", ((SosoInterface.SosoCell)localObject).mMcc).put("mnc", ((SosoInterface.SosoCell)localObject).mMnc).put("lac", ((SosoInterface.SosoCell)localObject).mLac).put("cellid", ((SosoInterface.SosoCell)localObject).mCellId).put("rssi", ((SosoInterface.SosoCell)localObject).mRss));
      }
      localJSONObject.put("cells", localJSONArray);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhp
 * JD-Core Version:    0.7.0.1
 */