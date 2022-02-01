import KQQ.InfoItem;
import KQQ.PluginInfo;
import KQQ.ReqGetPluginSettings;
import KQQ.RespGetPluginSettings;
import KQQ.SyncReq;
import KQQ.SyncRes;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import java.util.ArrayList;
import java.util.List;
import mqq.app.Packet;

public class bbkg
{
  public static List<PluginInfo> a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject = new UniPacket(true);
    try
    {
      ((UniPacket)localObject).setEncodeName("utf-8");
      ((UniPacket)localObject).decode(paramArrayOfByte);
      paramArrayOfByte = (SyncRes)((UniPacket)localObject).get("SyncRes");
      if ((paramArrayOfByte != null) && (paramArrayOfByte.result == 0))
      {
        paramArrayOfByte = paramArrayOfByte.vecResPkg;
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          paramArrayOfByte = (InfoItem)paramArrayOfByte.get(0);
          if (paramArrayOfByte.vecValue != null)
          {
            paramArrayOfByte = new JceInputStream(paramArrayOfByte.vecValue);
            paramArrayOfByte.setServerEncoding("utf-8");
            localObject = new RespGetPluginSettings();
            ((RespGetPluginSettings)localObject).readFrom(paramArrayOfByte);
            if ((localObject != null) && (((RespGetPluginSettings)localObject).PluginInfoList != null))
            {
              paramArrayOfByte = ((RespGetPluginSettings)localObject).PluginInfoList;
              return paramArrayOfByte;
            }
          }
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    return null;
  }
  
  public static void a(Packet paramPacket, List<Long> paramList)
  {
    SyncReq localSyncReq = new SyncReq();
    ArrayList localArrayList = new ArrayList();
    InfoItem localInfoItem = new InfoItem();
    localInfoItem.cOperType = 1;
    localInfoItem.qwServiceId = 22L;
    localInfoItem.qwTimeStamp = 0L;
    localInfoItem.vecValue = a(paramList);
    localArrayList.add(localInfoItem);
    localSyncReq.vecReqPkg = localArrayList;
    paramPacket.setSSOCommand("ProfileService.SyncReq");
    paramPacket.setServantName("ProfileService");
    paramPacket.setFuncName("SyncReq");
    paramPacket.addRequestPacket("SyncReq", localSyncReq);
  }
  
  public static byte[] a(List<Long> paramList)
  {
    ReqGetPluginSettings localReqGetPluginSettings = new ReqGetPluginSettings();
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0)) {
      localArrayList.addAll(paramList);
    }
    for (;;)
    {
      localReqGetPluginSettings.PluginList = localArrayList;
      paramList = new JceOutputStream();
      localReqGetPluginSettings.writeTo(paramList);
      return paramList.toByteArray();
      localArrayList.add(Long.valueOf(489L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkg
 * JD-Core Version:    0.7.0.1
 */