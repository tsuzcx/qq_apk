package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.HotChatInfo;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x897.cmd0x897.GroupVisitorInfo;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class HotChatObserver
  implements BusinessObserver
{
  private void a(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null)
    {
      a(null, null, paramBoolean, null, null, null);
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramBoolean)
    {
      a((String)paramObject[2], (String)paramObject[1], paramBoolean, (String)paramObject[0], (String)paramObject[3], (Boolean)paramObject[4]);
      return;
    }
    a("", (String)paramObject[0], paramBoolean, (String)paramObject[1], (String)paramObject[2], null);
  }
  
  private void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    a(paramBoolean, (byte[])paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (HotChatInfo)paramObject[0], (Common.WifiPOIInfo)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
    }
  }
  
  private void b(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null) {
      a(paramBoolean, ((Integer)paramArrayOfObject[0]).intValue(), (List)paramArrayOfObject[1], (Long)paramArrayOfObject[2]);
    }
  }
  
  private void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2], (String)paramObject[3]);
    }
  }
  
  private void c(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {}
    boolean bool;
    do
    {
      return;
      bool = false;
      if (paramArrayOfObject.length > 2) {
        bool = ((Boolean)paramArrayOfObject[2]).booleanValue();
      }
    } while (!bool);
    if (paramArrayOfObject.length > 3)
    {
      a(paramBoolean, (oidb_0x88d.GroupInfo)paramArrayOfObject[3]);
      return;
    }
    a(paramBoolean, null);
  }
  
  private void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (String)paramObject[1], (String)paramObject[2]);
    }
  }
  
  private void e(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
    }
  }
  
  private void f(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a((String)paramObject[0], paramBoolean, (String)paramObject[1]);
    }
  }
  
  private void g(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      b(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
    }
  }
  
  private void h(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (ArrayList)paramObject[0], (ArrayList)paramObject[1]);
    }
  }
  
  protected void a(int paramInt) {}
  
  public void a(String paramString, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, Boolean paramBoolean1) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2) {}
  
  protected void a(boolean paramBoolean, int paramInt, List<cmd0x897.GroupVisitorInfo> paramList, Long paramLong) {}
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ArrayList<String> paramArrayList) {}
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List<Long> paramList) {}
  
  public void a(boolean paramBoolean, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2) {}
  
  protected void a(boolean paramBoolean, oidb_0x88d.GroupInfo paramGroupInfo) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt, String paramString) {}
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void b(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 1042: 
    case 1043: 
    case 1044: 
    case 1045: 
    case 1048: 
    case 1049: 
    default: 
    case 1031: 
    case 1032: 
    case 1033: 
      do
      {
        return;
        if (paramBoolean) {}
        for (paramInt = 0;; paramInt = -1)
        {
          a(paramInt);
          return;
        }
        a(paramBoolean, paramObject);
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
      a((String)paramObject[0], paramBoolean, (String)paramObject[1]);
      return;
    case 1034: 
      b(paramBoolean, paramObject);
      return;
    case 1035: 
      a(paramBoolean, (Object[])paramObject);
      return;
    case 1036: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (byte[])paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], (String)paramObject[4], (List)paramObject[5]);
      return;
    case 1050: 
      paramObject = (Object[])paramObject;
      List localList = (List)paramObject[4];
      ArrayList localArrayList = new ArrayList();
      paramInt = 0;
      while (paramInt < localList.size())
      {
        localArrayList.add(localList.get(paramInt) + "");
        paramInt += 1;
      }
      a(paramBoolean, (String)paramObject[0], (byte[])paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), localArrayList);
      return;
    case 1051: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    case 1037: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (String)paramObject[3]);
      return;
    case 1052: 
      paramObject = (Object[])paramObject;
      b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (String)paramObject[3]);
      return;
    case 1038: 
      paramObject = (Object[])paramObject;
      b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
    case 1039: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (Long)paramObject[3]);
      return;
    case 1040: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
    case 1041: 
      paramObject = (Object[])paramObject;
      a((String)paramObject[0], (HotChatManager.HotChatStateWrapper)paramObject[1]);
      return;
    case 1046: 
      b(paramBoolean, (Object[])paramObject);
      return;
    case 1047: 
      c(paramBoolean, (Object[])paramObject);
      return;
    case 1053: 
      c(paramBoolean, paramObject);
      return;
    case 1054: 
      d(paramBoolean, paramObject);
      return;
    case 1055: 
      e(paramBoolean, paramObject);
      return;
    case 1056: 
      f(paramBoolean, paramObject);
      return;
    case 1057: 
      g(paramBoolean, paramObject);
      return;
    }
    h(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatObserver
 * JD-Core Version:    0.7.0.1
 */