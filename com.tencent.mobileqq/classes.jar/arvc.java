import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import tencent.im.oidb.location.RoomOperate.ReqRoomOperation;
import tencent.im.oidb.location.RoomOperate.RspRoomOperation;
import tencent.im.oidb.location.qq_lbs_share.ResultInfo;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class arvc
  extends arum<aruq>
{
  private aruq a;
  
  arvc(QQAppInterface paramQQAppInterface, aruq paramaruq)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aruq = paramaruq;
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_Aruq.a();
    if (QLog.isColorLevel()) {
      QLog.d("RoomOperateHandler", 2, new Object[] { "requestOperateRoom: invoked. ", "operateType = [" + paramInt1 + "]  R_OPT_CREATE = 1; //创建房间 R_OPT_JOIN = 2; //加入 R_OPT_QUIT = 3; //退出\n", ", uinType = [" + paramInt2 + "], sessionUin = [" + paramLong + "], location = [" + localObject + "]" });
    }
    if (localObject == null) {
      return;
    }
    RoomOperate.ReqRoomOperation localReqRoomOperation = new RoomOperate.ReqRoomOperation();
    qq_lbs_share.RoomKey localRoomKey = aryx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2, paramLong);
    localReqRoomOperation.room_key.set(localRoomKey);
    localReqRoomOperation.room_key.setHasFlag(true);
    localReqRoomOperation.room_operation.set(paramInt1);
    localReqRoomOperation.lat.set(((LatLng)localObject).latitude);
    localReqRoomOperation.lon.set(((LatLng)localObject).longitude);
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQLBSShareSvc.room_operation");
    ((ToServiceMsg)localObject).extraData.putInt("OPT_ROOM_TYPE", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("uintype", paramInt2);
    ((ToServiceMsg)localObject).extraData.putString("uin", String.valueOf(paramLong));
    ((ToServiceMsg)localObject).putWupBuffer(localReqRoomOperation.toByteArray());
    a().sendPbReq((ToServiceMsg)localObject);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    aryx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramString, false);
    aryw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramString, false);
    a().notifyUI(1, false, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), paramString });
  }
  
  protected aruq a()
  {
    return aruq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      a(paramInt1, paramInt2, l);
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.e("RoomOperateHandler", 1, "requestOperateRoom: failed. ", paramString);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (a(paramToServiceMsg, paramFromServiceMsg, paramObject)) {
      try
      {
        i = paramToServiceMsg.extraData.getInt("OPT_ROOM_TYPE");
        int j = paramToServiceMsg.extraData.getInt("uintype", -1);
        paramToServiceMsg = paramToServiceMsg.extraData.getString("uin");
        paramFromServiceMsg = (qq_lbs_share.ResultInfo)((RoomOperate.RspRoomOperation)new RoomOperate.RspRoomOperation().mergeFrom((byte[])paramObject)).msg_result.get();
        if (aryx.a(paramFromServiceMsg))
        {
          a().notifyUI(1, true, new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
          return;
        }
        a(j, paramToServiceMsg, paramFromServiceMsg.uint32_result.get(), i);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("RoomOperateHandler", 1, "requestOperateRoomResp: failed. ", paramToServiceMsg);
        return;
      }
    }
    if (paramFromServiceMsg != null)
    {
      i = paramFromServiceMsg.getResultCode();
      if (QLog.isColorLevel()) {
        QLog.d("RoomOperateHandler", 2, new Object[] { "requestOperateRoomResp: invoked. ", " resultCode: ", Integer.valueOf(i) });
      }
    }
    a(-2, "", -10001, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arvc
 * JD-Core Version:    0.7.0.1
 */