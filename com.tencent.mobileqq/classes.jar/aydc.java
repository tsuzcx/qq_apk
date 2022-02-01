import com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto.AnchorInfo;
import com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto.GetAnchorOnline1Rsp;
import com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto.RetInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aydc
  implements ayds
{
  aydc(aydb paramaydb, ayda paramayda) {}
  
  public void a(int paramInt, String paramString)
  {
    aydb.a(this.jdField_a_of_type_Aydb, false);
    aydb.b(this.jdField_a_of_type_Aydb, true);
    this.jdField_a_of_type_Aydb.a(this.jdField_a_of_type_Ayda);
    if (QLog.isColorLevel()) {
      QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 errCode:" + paramInt + " msg:" + paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      aydb.a(this.jdField_a_of_type_Aydb, false);
      aydb.b(this.jdField_a_of_type_Aydb, false);
      Object localObject1 = new NowQQLiveFocusProto.GetAnchorOnline1Rsp();
      ((NowQQLiveFocusProto.GetAnchorOnline1Rsp)localObject1).mergeFrom(paramArrayOfByte);
      Object localObject2 = ((NowQQLiveFocusProto.GetAnchorOnline1Rsp)localObject1).anchor_info.get();
      if (QLog.isColorLevel()) {
        QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 anchorInfoList:" + ((List)localObject2).size() + " rsp code:" + ((NowQQLiveFocusProto.GetAnchorOnline1Rsp)localObject1).ret_info.err_code + " msg:" + ((NowQQLiveFocusProto.GetAnchorOnline1Rsp)localObject1).ret_info.err_msg);
      }
      paramArrayOfByte = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (NowQQLiveFocusProto.AnchorInfo)((Iterator)localObject1).next();
        ayde localayde = new ayde();
        localayde.a(((NowQQLiveFocusProto.AnchorInfo)localObject2).uin.get());
        localayde.d(((NowQQLiveFocusProto.AnchorInfo)localObject2).anchor_logo_url.get());
        localayde.e(((NowQQLiveFocusProto.AnchorInfo)localObject2).audience_sum.get());
        localayde.b(((NowQQLiveFocusProto.AnchorInfo)localObject2).jump_url.get());
        localayde.c(((NowQQLiveFocusProto.AnchorInfo)localObject2).nick_name.get());
        localayde.c(((NowQQLiveFocusProto.AnchorInfo)localObject2).room_id.get());
        localayde.e(((NowQQLiveFocusProto.AnchorInfo)localObject2).room_name.get());
        localayde.d(((NowQQLiveFocusProto.AnchorInfo)localObject2).start_time.get());
        localayde.b(((NowQQLiveFocusProto.AnchorInfo)localObject2).user_type.get());
        localayde.a(((NowQQLiveFocusProto.AnchorInfo)localObject2).type.get());
        localayde.a(((NowQQLiveFocusProto.AnchorInfo)localObject2).cover_url.get());
        paramArrayOfByte.add(localayde);
        if (QLog.isColorLevel()) {
          QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 nick_name:" + localayde.b() + " jump_url:" + localayde.a() + " anchor_logo_url: " + localayde.c() + " anchorInfo.jump_url.get():" + ((NowQQLiveFocusProto.AnchorInfo)localObject2).jump_url.get());
        }
      }
      this.jdField_a_of_type_Ayda.a(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      aydb.a(this.jdField_a_of_type_Aydb, false);
      aydb.b(this.jdField_a_of_type_Aydb, true);
      this.jdField_a_of_type_Aydb.a(this.jdField_a_of_type_Ayda);
      if (QLog.isColorLevel()) {
        QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 Exception:" + paramArrayOfByte.getMessage());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydc
 * JD-Core Version:    0.7.0.1
 */