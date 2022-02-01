import com.qq.jce.wup.UniPacket;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneDelPhotoWallRequest;
import cooperation.qzone.QZoneGetPhotoWallRequest;
import cooperation.qzone.QZoneRequestEncoder;

public class bcup
  extends aauq
{
  private static String[] a = { "QzoneService", "SQQzoneSvc" };
  
  private UniPacket a(String paramString)
  {
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setEncodeName("utf8");
    a(localUniPacket);
    localUniPacket.put("uin", Long.valueOf(Long.parseLong(paramString)));
    return localUniPacket;
  }
  
  private Object a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = QZoneRequestEncoder.decodeCoverResponse(paramFromServiceMsg.getWupBuffer());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "decodeGetQZoneCover|jceObj = " + paramFromServiceMsg);
    }
    return paramFromServiceMsg;
  }
  
  private void a(UniPacket paramUniPacket)
  {
    paramUniPacket.setEncodeName("utf8");
    paramUniPacket.put("version", Integer.valueOf(1091030));
    paramUniPacket.put("Q-UA", AppSetting.e());
    paramUniPacket.put("rupt", Boolean.valueOf(false));
  }
  
  private Object b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = QZoneGetPhotoWallRequest.decodePhotoWallResponse(paramFromServiceMsg.getWupBuffer());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonephotowall", 2, "decodeGetQZonePhotoWall|jceObj = " + paramFromServiceMsg);
    }
    return paramFromServiceMsg;
  }
  
  private byte[] b(ToServiceMsg paramToServiceMsg)
  {
    UniPacket localUniPacket = a(paramToServiceMsg.getUin());
    localUniPacket.put("uin", Long.valueOf(Long.parseLong(paramToServiceMsg.getUin())));
    a(localUniPacket);
    localUniPacket.setServantName("QzoneServer");
    localUniPacket.setFuncName("GetNewAndUnread");
    return bhjl.a(localUniPacket.encode());
  }
  
  private Object c(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = QZoneDelPhotoWallRequest.decodeDelResponse(paramFromServiceMsg.getWupBuffer());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonephotowall", 2, "decodeDelQZonePhotoWall|jceObj = " + paramFromServiceMsg);
    }
    return paramFromServiceMsg;
  }
  
  private byte[] c(ToServiceMsg paramToServiceMsg)
  {
    long l4 = 0L;
    String str = (String)paramToServiceMsg.getAttribute("uin");
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("flag", Integer.valueOf(1));
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "handleGetQZoneCover|uin = " + str + ",flag=" + localInteger.intValue());
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(str);
        l3 = l1;
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          l2 = Long.parseLong(paramToServiceMsg.getUin());
          l3 = l1;
          return new QZoneRequestEncoder(l3, l2, localInteger.intValue()).encode();
        }
        catch (Exception paramToServiceMsg)
        {
          long l1;
          long l2;
          long l3;
          break label115;
        }
        paramToServiceMsg = paramToServiceMsg;
        l1 = 0L;
      }
      label115:
      l2 = l4;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.qzonecover.", 2, paramToServiceMsg.toString());
        l3 = l1;
        l2 = l4;
      }
    }
  }
  
  private byte[] d(ToServiceMsg paramToServiceMsg)
  {
    long l4 = 0L;
    String str2 = (String)paramToServiceMsg.getAttribute("uin");
    String str1 = (String)paramToServiceMsg.getAttribute("photo_id");
    Long localLong = (Long)paramToServiceMsg.getAttribute("photo_time");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonephotowall", 2, "handleDetQZonePhotoWall|uin = " + str2);
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(str2);
        l3 = l1;
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          l2 = Long.parseLong(paramToServiceMsg.getUin());
          l3 = l1;
          return new QZoneDelPhotoWallRequest(l3, l2, str1, localLong).encode();
        }
        catch (Exception paramToServiceMsg)
        {
          long l1;
          long l2;
          long l3;
          break label108;
        }
        paramToServiceMsg = paramToServiceMsg;
        l1 = 0L;
      }
      label108:
      l2 = l4;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.qzonephotowall", 2, paramToServiceMsg.toString());
        l3 = l1;
        l2 = l4;
      }
    }
  }
  
  private byte[] e(ToServiceMsg paramToServiceMsg)
  {
    long l4 = 0L;
    String str2 = (String)paramToServiceMsg.getAttribute("uin");
    String str1 = (String)paramToServiceMsg.getAttribute("attachInfo");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonephotowall", 2, "handleGetQZonePhotoWall|uin = " + str2);
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(str2);
        l3 = l1;
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          l2 = Long.parseLong(paramToServiceMsg.getUin());
          l3 = l1;
          return new QZoneGetPhotoWallRequest(l3, l2, str1).encode();
        }
        catch (Exception paramToServiceMsg)
        {
          long l1;
          long l2;
          long l3;
          break label95;
        }
        paramToServiceMsg = paramToServiceMsg;
        l1 = 0L;
      }
      label95:
      l2 = l4;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.qzonephotowall", 2, paramToServiceMsg.toString());
        l3 = l1;
        l2 = l4;
      }
    }
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    Object localObject = null;
    if ("SQQzoneSvc.getCover".equals(str)) {
      localObject = a(paramFromServiceMsg, paramToServiceMsg);
    }
    do
    {
      return localObject;
      if ("SQQzoneSvc.getPhotoWall".equals(str)) {
        return b(paramFromServiceMsg, paramToServiceMsg);
      }
    } while (!"SQQzoneSvc.delPhotoWall".equals(str));
    return c(paramFromServiceMsg, paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      paramToServiceMsg.actionListener.onActionResult(paramFromServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return false;
  }
  
  public byte[] a(ToServiceMsg paramToServiceMsg)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("QzoneService.GetNewAndUnread".equals(str)) {
      return b(paramToServiceMsg);
    }
    if ("SQQzoneSvc.getCover".equals(str)) {
      return c(paramToServiceMsg);
    }
    if ("SQQzoneSvc.getPhotoWall".equals(str)) {
      return e(paramToServiceMsg);
    }
    if ("SQQzoneSvc.delPhotoWall".equals(str)) {
      return d(paramToServiceMsg);
    }
    return null;
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcup
 * JD-Core Version:    0.7.0.1
 */