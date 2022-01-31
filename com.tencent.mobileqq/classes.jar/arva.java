import android.annotation.SuppressLint;
import com.tencent.mobileqq.app.QQAppInterface;
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

public final class arva
  extends arvb
{
  private arus jdField_a_of_type_Arus;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public arva(QQAppInterface paramQQAppInterface, arus paramarus)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Arus = paramarus;
  }
  
  @SuppressLint({"SimpleDateFormat"})
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (!paramBoolean) {
      return;
    }
    paramObject = (Object[])paramObject;
    Object localObject3 = (RoomOperate.RspRoomQuery)paramObject[0];
    int i = ((Integer)paramObject[1]).intValue();
    Object localObject2 = (String)paramObject[2];
    paramObject = new LocationRoom.Venue();
    Object localObject4 = (qq_lbs_share.AssemblyPointData)((RoomOperate.RspRoomQuery)localObject3).assembly_Point.get();
    if (localObject4 != null) {
      switch (((qq_lbs_share.AssemblyPointData)localObject4).operation.get())
      {
      }
    }
    int j;
    for (;;)
    {
      localObject4 = ((RoomOperate.RspRoomQuery)localObject3).user_list.get();
      j = ((RoomOperate.RspRoomQuery)localObject3).room_state.get();
      if (((List)localObject4).size() > 0) {
        break;
      }
      QLog.e("LocationObserver", 1, "[queryLocationRoom][error] onQueryRoom: invoked. sessionUin: " + (String)localObject2 + " roomState: " + j + " userDataList: " + ((List)localObject4).size() + " venue: " + paramObject);
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
      QLog.d("LocationObserver", 2, "[queryLocationRoom] onQueryRoom: invoked. sessionUin: " + (String)localObject2 + " userDataList: " + ((List)localObject4).size() + " venue: " + paramObject);
    }
    Object localObject1 = new ArrayList(20);
    localObject3 = ((List)localObject4).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (RoomOperate.UserData)((Iterator)localObject3).next();
      String str = String.valueOf(((RoomOperate.UserData)localObject4).uin.get());
      aruk localaruk = new aruk(str, new LatLng(((RoomOperate.UserData)localObject4).lat.get(), ((RoomOperate.UserData)localObject4).lon.get()), ((RoomOperate.UserData)localObject4).direction.get());
      if (QLog.isColorLevel()) {
        if (j != 1) {
          break label651;
        }
      }
      label651:
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("LocationObserver", 2, new Object[] { "[queryLocationRoom] onQueryRoom invoked  roomState == open: ", Boolean.valueOf(paramBoolean), " uin: ", str, " locationItem: ", localaruk, " join: ", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(((RoomOperate.UserData)localObject4).join_time.get() * 1000L)), " update: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(((RoomOperate.UserData)localObject4).lbs_update_ts.get() * 1000L)) });
        ((List)localObject1).add(localaruk);
        break;
      }
    }
    localObject2 = new arum(i, (String)localObject2);
    this.jdField_a_of_type_Arus.a((arum)localObject2, paramObject, (List)localObject1);
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
      this.jdField_a_of_type_Arus.a(new arum(localInteger.intValue(), str), (LocationRoom.Venue)localObject, paramObject.intValue(), paramBoolean, i);
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LocationObserver", 2, new Object[] { "[venue] onVenueOpt: invoked. success ", " uin: ", str, " uinType: ", localInteger, " optType: ", paramObject });
        }
        this.jdField_a_of_type_Arus.a.a(localInteger.intValue(), str);
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
    paramObject = new arum(paramObject.intValue(), str);
    this.jdField_a_of_type_Arus.a(paramObject, ((Integer)localObject).intValue());
  }
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    super.d(paramBoolean, paramObject);
    Object localObject = (Object[])paramObject;
    paramObject = (Integer)localObject[0];
    localObject = String.valueOf(localObject[1]);
    paramObject = new arum(paramObject.intValue(), (String)localObject);
    this.jdField_a_of_type_Arus.b(paramObject, -1);
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
      arup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject);
      return;
    }
    arup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject, i);
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
      arvg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject);
    }
    label80:
    do
    {
      do
      {
        return;
        if (i == 2)
        {
          arvg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject);
          return;
        }
        if (i == 3)
        {
          arvg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject);
          return;
        }
      } while (i == 4);
      if (i == 101)
      {
        arvg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject, i);
        return;
      }
      if (i == 102)
      {
        arvg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject, i);
        return;
      }
    } while (i != 103);
    arvg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject, i);
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
      this.jdField_a_of_type_Arus.a.a(localInteger.intValue(), (String)localObject);
      this.jdField_a_of_type_Arus.a.b(localInteger.intValue(), (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("LocationObserver", 2, new Object[] { "onOperateRoom: invoked. real report invoked. ", " optType: ", paramObject });
      }
      if (paramObject.intValue() == 1)
      {
        this.jdField_a_of_type_Arus.b(localInteger.intValue(), (String)localObject);
        axqy.b(null, "CliOper", "", "", "0X800A764", "0X800A764", 0, 0, "", "0", "0", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_Arus.a(false);
        return;
        if (paramObject.intValue() == 2)
        {
          this.jdField_a_of_type_Arus.b(localInteger.intValue(), (String)localObject);
          if (this.jdField_a_of_type_Arus.a()) {
            axqy.b(null, "CliOper", "", "", "0X800A76B", "0X800A76B", arus.a(this.jdField_a_of_type_Arus.a()), 0, "", "0", "0", "");
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationObserver", 2, new Object[] { "onOperateRoom: invoked. ", " errorCode: ", Integer.valueOf(j) });
    }
    arum localarum = new arum(localInteger.intValue(), (String)localObject);
    this.jdField_a_of_type_Arus.a(localarum, true);
    this.jdField_a_of_type_Arus.a(localarum, j, paramObject.intValue());
    int i = 0;
    if (j == 10101) {}
    for (i = 3;; i = 2) {
      do
      {
        this.jdField_a_of_type_Arus.a(localInteger.intValue(), (String)localObject, this.jdField_a_of_type_Arus.a(), i);
        return;
      } while ((j != 10001) && (j != 10003) && (j != 10004) && (j != 10100));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arva
 * JD-Core Version:    0.7.0.1
 */