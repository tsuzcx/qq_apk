import android.annotation.SuppressLint;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x857.TroopTips0x857.LbsShareChangePushInfo;
import tencent.im.oidb.location.RoomOperate.RspRoomQuery;
import tencent.im.oidb.location.RoomOperate.UserData;
import tencent.im.oidb.location.qq_lbs_share.AssemblyPointData;
import tencent.im.s2c.msgtype0x210.submsgtype0x125.submsgtype0x125.MsgBody;

public final class avxd
  extends avxe
{
  private avwv jdField_a_of_type_Avwv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public avxd(QQAppInterface paramQQAppInterface, avwv paramavwv)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Avwv = paramavwv;
  }
  
  @SuppressLint({"SimpleDateFormat"})
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (!paramBoolean) {
      return;
    }
    paramObject = (Object[])paramObject;
    Object localObject2 = (RoomOperate.RspRoomQuery)paramObject[0];
    int i = ((Integer)paramObject[1]).intValue();
    Object localObject3 = (String)paramObject[2];
    paramObject = new LocationRoom.Venue();
    Object localObject4 = (qq_lbs_share.AssemblyPointData)((RoomOperate.RspRoomQuery)localObject2).assembly_Point.get();
    if (localObject4 != null) {
      switch (((qq_lbs_share.AssemblyPointData)localObject4).operation.get())
      {
      }
    }
    Object localObject1;
    int j;
    for (;;)
    {
      localObject1 = ((RoomOperate.RspRoomQuery)localObject2).user_list.get();
      j = ((RoomOperate.RspRoomQuery)localObject2).room_state.get();
      if (((List)localObject1).size() > 0) {
        break;
      }
      QLog.e("LocationObserver", 1, "[queryLocationRoom][error] onQueryRoom: invoked. sessionUin: " + (String)localObject3 + " roomState: " + j + " userDataList: " + ((List)localObject1).size() + " venue: " + paramObject);
      return;
      if (((qq_lbs_share.AssemblyPointData)localObject4).operator.get() <= 0L)
      {
        paramObject = null;
      }
      else
      {
        paramObject.jdField_a_of_type_JavaLangString = String.valueOf(((qq_lbs_share.AssemblyPointData)localObject4).operator.get());
        paramObject.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = new LatLng(((qq_lbs_share.AssemblyPointData)localObject4).lat.get(), ((qq_lbs_share.AssemblyPointData)localObject4).lon.get());
        if (((qq_lbs_share.AssemblyPointData)localObject4).poi_name.has())
        {
          localObject1 = ((qq_lbs_share.AssemblyPointData)localObject4).poi_name.get().toStringUtf8();
          label279:
          paramObject.b = ((String)localObject1);
          if (!((qq_lbs_share.AssemblyPointData)localObject4).poi_address.has()) {
            break label325;
          }
        }
        label325:
        for (localObject1 = ((qq_lbs_share.AssemblyPointData)localObject4).poi_address.get().toStringUtf8();; localObject1 = "")
        {
          paramObject.c = ((String)localObject1);
          break;
          localObject1 = "";
          break label279;
        }
        paramObject = null;
        continue;
        paramObject = null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationObserver", 2, "[queryLocationRoom] onQueryRoom: invoked. sessionUin: " + (String)localObject3 + " userDataList: " + ((List)localObject1).size() + " venue: " + paramObject);
    }
    localObject2 = new avwp(i, (String)localObject3);
    localObject3 = this.jdField_a_of_type_Avwv.a((avwp)localObject2);
    localObject4 = new ArrayList(20);
    Iterator localIterator = ((List)localObject1).iterator();
    if (localIterator.hasNext())
    {
      RoomOperate.UserData localUserData = (RoomOperate.UserData)localIterator.next();
      String str = String.valueOf(localUserData.uin.get());
      avwn localavwn1 = new avwn(str, new LatLng(localUserData.lat.get(), localUserData.lon.get()), localUserData.direction.get());
      if ((localavwn1.a().latitude == 0.0D) && (localavwn1.a().longitude == 0.0D))
      {
        avwn localavwn2 = ((LocationRoom)localObject3).a(str);
        if (localavwn2 != null)
        {
          localObject1 = "[filter]";
          localavwn1.a(localavwn2.a(), Double.valueOf(localavwn2.a()));
          ((List)localObject4).add(localavwn1);
          label590:
          if (!QLog.isColorLevel()) {
            break label794;
          }
          localObject1 = "[queryLocationRoom]" + (String)localObject1 + " onQueryRoom invoked  roomState == open: ";
          if (j != 1) {
            break label796;
          }
        }
      }
      label794:
      label796:
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("LocationObserver", 2, new Object[] { localObject1, Boolean.valueOf(paramBoolean), " uin: ", str, " locationItem: ", localavwn1, " join: ", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(localUserData.join_time.get() * 1000L)), " update: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(localUserData.lbs_update_ts.get() * 1000L)) });
        break;
        localObject1 = "[killed]";
        break label590;
        localObject1 = "[data]";
        ((List)localObject4).add(localavwn1);
        break label590;
        break;
      }
    }
    this.jdField_a_of_type_Avwv.a((avwp)localObject2, paramObject, (List)localObject4);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    super.b(paramBoolean, paramObject);
    Object localObject = (Object[])paramObject;
    if ((localObject == null) || (localObject.length == 0)) {}
    int i;
    do
    {
      return;
      i = ((Integer)localObject[0]).intValue();
      paramObject = (Integer)localObject[1];
      Integer localInteger = (Integer)localObject[2];
      String str = (String)localObject[3];
      localObject = (LocationRoom.Venue)localObject[4];
      this.jdField_a_of_type_Avwv.a(new avwp(localInteger.intValue(), str), (LocationRoom.Venue)localObject, paramObject.intValue(), paramBoolean, i);
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LocationObserver", 2, new Object[] { "[venue] onVenueOpt: invoked. success ", " uin: ", str, " uinType: ", localInteger, " optType: ", paramObject });
        }
        this.jdField_a_of_type_Avwv.a.a(localInteger.intValue(), str);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationObserver", 2, new Object[] { "[venue] onVenueOpt: invoked. failed ", " errorCode: ", Integer.valueOf(i) });
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    super.c(paramBoolean, paramObject);
    Object localObject = (Object[])paramObject;
    paramObject = (Integer)localObject[0];
    String str = String.valueOf(localObject[1]);
    localObject = (Integer)localObject[2];
    paramObject = new avwp(paramObject.intValue(), str);
    this.jdField_a_of_type_Avwv.a(paramObject, ((Integer)localObject).intValue());
  }
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    super.d(paramBoolean, paramObject);
    Object localObject = (Object[])paramObject;
    paramObject = (Integer)localObject[0];
    localObject = String.valueOf(localObject[1]);
    paramObject = new avwp(paramObject.intValue(), (String)localObject);
    this.jdField_a_of_type_Avwv.b(paramObject, -1);
  }
  
  protected void e(boolean paramBoolean, Object paramObject)
  {
    super.e(paramBoolean, paramObject);
    int i;
    if (paramBoolean)
    {
      paramObject = (submsgtype0x125.MsgBody)((Object[])(Object[])paramObject)[0];
      i = paramObject.uint32_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("LocationObserver", 2, new Object[] { "decodeMsg: invoked. ", " optType: ", Integer.valueOf(i) });
      }
    }
    switch (i)
    {
    case 4: 
    default: 
      return;
    case 1: 
    case 2: 
    case 3: 
      avws.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject);
      return;
    }
    avws.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject, i);
  }
  
  protected void f(boolean paramBoolean, Object paramObject)
  {
    super.f(paramBoolean, paramObject);
    int i;
    if (paramBoolean)
    {
      paramObject = (TroopTips0x857.LbsShareChangePushInfo)((Object[])(Object[])paramObject)[0];
      i = paramObject.uint32_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("LocationObserver", 2, new Object[] { "onTroopOptPush: invoked. ", " msgType: ", Integer.valueOf(i) });
      }
      if (i != 1) {
        break label80;
      }
      avxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject);
    }
    label80:
    do
    {
      do
      {
        return;
        if (i == 2)
        {
          avxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject);
          return;
        }
        if (i == 3)
        {
          avxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject);
          return;
        }
      } while (i == 4);
      if (i == 101)
      {
        avxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject, i);
        return;
      }
      if (i == 102)
      {
        avxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject, i);
        return;
      }
    } while (i != 103);
    avxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject, i);
  }
  
  protected void g(boolean paramBoolean, Object paramObject)
  {
    super.g(paramBoolean, paramObject);
    Object localObject = (Object[])paramObject;
    if ((localObject == null) || (localObject.length == 0)) {
      return;
    }
    int j = ((Integer)localObject[0]).intValue();
    paramObject = (Integer)localObject[1];
    Integer localInteger = (Integer)localObject[2];
    localObject = (String)localObject[3];
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationObserver", 2, new Object[] { "onOperateRoom: invoked. ", " uin: ", localObject, " uinType: ", localInteger, " optType: ", paramObject });
      }
      this.jdField_a_of_type_Avwv.a.a(localInteger.intValue(), (String)localObject);
      this.jdField_a_of_type_Avwv.a.b(localInteger.intValue(), (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("LocationObserver", 2, new Object[] { "onOperateRoom: invoked. real report invoked. ", " optType: ", paramObject });
      }
      if (paramObject.intValue() == 1)
      {
        this.jdField_a_of_type_Avwv.b(localInteger.intValue(), (String)localObject);
        bcst.b(null, "CliOper", "", "", "0X800A764", "0X800A764", 0, 0, "", "0", "0", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_Avwv.a(false);
        return;
        if (paramObject.intValue() == 2)
        {
          this.jdField_a_of_type_Avwv.b(localInteger.intValue(), (String)localObject);
          if (this.jdField_a_of_type_Avwv.a()) {
            bcst.b(null, "CliOper", "", "", "0X800A76B", "0X800A76B", avwv.a(this.jdField_a_of_type_Avwv.a()), 0, "", "0", "0", "");
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationObserver", 2, new Object[] { "onOperateRoom: invoked. ", " errorCode: ", Integer.valueOf(j) });
    }
    avwp localavwp = new avwp(localInteger.intValue(), (String)localObject);
    this.jdField_a_of_type_Avwv.a(localavwp, true);
    this.jdField_a_of_type_Avwv.a(localavwp, j, paramObject.intValue());
    int i = 0;
    if (j == 10101) {}
    for (i = 3;; i = 2) {
      do
      {
        this.jdField_a_of_type_Avwv.a(localInteger.intValue(), (String)localObject, this.jdField_a_of_type_Avwv.a(), i);
        return;
      } while ((j != 10001) && (j != 10003) && (j != 10004) && (j != 10100));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxd
 * JD-Core Version:    0.7.0.1
 */