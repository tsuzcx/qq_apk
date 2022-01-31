package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ArMapObserver
  implements BusinessObserver
{
  static final String TAG = "ArMapObserver";
  
  public void onApplyCoin(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onDeductItem(boolean paramBoolean, int paramInt) {}
  
  public void onGetARMapConfig(ARMapConfig paramARMapConfig) {}
  
  public void onGetARRedDotInfo(boolean paramBoolean, int paramInt, long paramLong) {}
  
  public void onGetArMapAnimationInfo(boolean paramBoolean, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onGetC2CPOIList(boolean paramBoolean, Object paramObject) {}
  
  public void onGetLevelInfo(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onGetPOIList(boolean paramBoolean, Object paramObject) {}
  
  public void onGetWealthGodInfo(boolean paramBoolean, ArMapHandler.RespWealthGodInfo paramRespWealthGodInfo) {}
  
  public void onGrabArea(boolean paramBoolean) {}
  
  public void onGrabAreaGetCoin(boolean paramBoolean, int paramInt) {}
  
  public void onIncCoins(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {}
  
  public void onOpenPOI(boolean paramBoolean1, int paramInt1, ItemInfo paramItemInfo, boolean paramBoolean2, int paramInt2, int paramInt3, boolean paramBoolean3) {}
  
  public void onPageHistory(boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt) {}
  
  public void onPageItem(boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt) {}
  
  public void onQueryItem(boolean paramBoolean, List paramList) {}
  
  public void onQueryPOI(boolean paramBoolean, POIInfo paramPOIInfo, List paramList, int paramInt1, int paramInt2, long paramLong) {}
  
  public void onQueryTask(boolean paramBoolean, List paramList) {}
  
  public void onReport(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onSetWorldCupInfo(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = -1;
    String str = null;
    Object localObject2 = null;
    Object[] arrayOfObject = null;
    Object localObject1 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ArMapObserver", 2, new Object[] { "onUpdate, type=", Integer.valueOf(paramInt), ", isSuccess=", Boolean.valueOf(paramBoolean) });
    }
    switch (paramInt)
    {
    }
    label279:
    label295:
    label311:
    label376:
    label382:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              onGetPOIList(paramBoolean, paramObject);
              return;
              onGetC2CPOIList(paramBoolean, paramObject);
              return;
            } while (!(paramObject instanceof Object[]));
            onGrabAreaGetCoin(paramBoolean, ((Integer)((Object[])(Object[])paramObject)[0]).intValue());
            return;
            onGrabArea(paramBoolean);
            return;
            if ((paramObject instanceof Object[]))
            {
              arrayOfObject = (Object[])paramObject;
              if (arrayOfObject[0] != null)
              {
                paramObject = (String)arrayOfObject[0];
                if (arrayOfObject[1] != null) {
                  localObject1 = (ItemInfo)arrayOfObject[1];
                }
                if (arrayOfObject[2] == null) {
                  break label376;
                }
                bool1 = ((Boolean)arrayOfObject[2]).booleanValue();
                if (arrayOfObject[3] == null) {
                  break label382;
                }
                str = (String)arrayOfObject[3];
                if (arrayOfObject[4] == null) {
                  break label389;
                }
                localObject2 = (String)arrayOfObject[4];
                if (arrayOfObject[5] == null) {
                  break label396;
                }
              }
              for (bool2 = ((Boolean)arrayOfObject[5]).booleanValue();; bool2 = false)
              {
                try
                {
                  paramInt = Integer.parseInt(paramObject);
                  k = Integer.parseInt(str);
                  j = Integer.parseInt((String)localObject2);
                  i = k;
                }
                catch (NumberFormatException paramObject)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ArMapObserver", 2, "onUpdate NumberFormatException", paramObject);
                    }
                    paramObject.printStackTrace();
                    int j = -1;
                    int k = -1;
                    paramInt = i;
                    i = k;
                  }
                }
                onOpenPOI(paramBoolean, paramInt, (ItemInfo)localObject1, bool1, i, j, bool2);
                return;
                paramObject = "-1";
                break;
                bool1 = false;
                break label279;
                str = "-1";
                break label295;
                localObject2 = "-1";
                break label311;
              }
            }
            onOpenPOI(false, -1, null, false, 0, 0, false);
            return;
            if ((paramObject instanceof Object[]))
            {
              localObject2 = (Object[])paramObject;
              if (localObject2[0] != null)
              {
                paramObject = (POIInfo)localObject2[0];
                localObject1 = str;
                if (localObject2[1] != null) {
                  localObject1 = (List)localObject2[1];
                }
                if (localObject2[2] == null) {
                  break label576;
                }
                paramInt = ((Integer)localObject2[2]).intValue();
                if (localObject2[3] == null) {
                  break label581;
                }
                i = ((Integer)localObject2[3]).intValue();
                if (localObject2[4] == null) {
                  break label587;
                }
              }
              for (long l = ((Long)localObject2[4]).longValue();; l = -1L)
              {
                onQueryPOI(paramBoolean, paramObject, (List)localObject1, paramInt, i, l);
                return;
                paramObject = null;
                break;
                paramInt = -1;
                break label519;
                i = -1;
                break label538;
              }
            }
            onQueryPOI(false, null, null, -1, -1, -1L);
            return;
            if (paramBoolean)
            {
              onQueryItem(true, (List)paramObject);
              return;
            }
            onQueryItem(false, null);
            return;
            if ((paramObject instanceof Object[]))
            {
              localObject1 = (Object[])paramObject;
              paramObject = localObject2;
              if (localObject1[0] != null) {
                paramObject = (List)localObject1[0];
              }
              if (localObject1[1] != null) {
                bool1 = ((Boolean)localObject1[1]).booleanValue();
              }
              if (localObject1[2] != null) {
                i = ((Integer)localObject1[2]).intValue();
              }
              onPageItem(paramBoolean, paramObject, bool1, i);
              return;
            }
            onPageItem(false, null, false, -1);
            return;
            if ((paramObject instanceof Object[]))
            {
              localObject1 = (Object[])paramObject;
              paramObject = arrayOfObject;
              if (localObject1[0] != null) {
                paramObject = (List)localObject1[0];
              }
              bool1 = bool2;
              if (localObject1[1] != null) {
                bool1 = ((Boolean)localObject1[1]).booleanValue();
              }
              if (localObject1[2] != null) {
                i = ((Integer)localObject1[2]).intValue();
              }
              onPageHistory(paramBoolean, paramObject, bool1, i);
              return;
            }
            onPageHistory(false, null, false, -1);
            return;
            if (paramBoolean)
            {
              onDeductItem(true, ((Integer)paramObject).intValue());
              return;
            }
            onDeductItem(false, 0);
            return;
            if (paramBoolean)
            {
              onQueryTask(true, (List)paramObject);
              return;
            }
            onQueryTask(false, null);
            return;
            if ((paramObject instanceof Object[]))
            {
              onReport(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
              return;
            }
            onReport(paramBoolean, false);
            return;
            if ((paramObject instanceof Object[]))
            {
              paramObject = (Object[])paramObject;
              onIncCoins(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Long)paramObject[4]).longValue());
              return;
            }
            onIncCoins(false, 0, 0, 0, 0, 0L);
            return;
            if ((paramObject instanceof Object[]))
            {
              paramObject = (Object[])paramObject;
              onApplyCoin(paramBoolean, ((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), (byte[])paramObject[3]);
              return;
            }
            onApplyCoin(paramBoolean, 0L, 0L, -1, null);
            return;
            if ((paramObject instanceof Object[]))
            {
              paramObject = (Object[])paramObject;
              onGetLevelInfo(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
              return;
            }
            onGetLevelInfo(false, 0, 0, 0);
            return;
          } while (!(paramObject instanceof Object[]));
          paramObject = (Object[])paramObject;
          onGetArMapAnimationInfo(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Long)paramObject[4]).longValue());
          return;
          if ((paramObject instanceof ARMapConfig))
          {
            onGetARMapConfig((ARMapConfig)paramObject);
            return;
          }
          onGetARMapConfig(null);
          return;
        } while (!(paramObject instanceof ArMapHandler.RespWealthGodInfo));
        onGetWealthGodInfo(paramBoolean, (ArMapHandler.RespWealthGodInfo)paramObject);
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
      onGetARRedDotInfo(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue());
      return;
    } while (!(paramObject instanceof Object[]));
    label389:
    label396:
    label538:
    label576:
    label581:
    label587:
    paramObject = (Object[])paramObject;
    label519:
    onSetWorldCupInfo(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapObserver
 * JD-Core Version:    0.7.0.1
 */