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

class ayvv
  implements aywl
{
  ayvv(ayvu paramayvu, ayvt paramayvt) {}
  
  public void a(int paramInt, String paramString)
  {
    ayvu.a(this.jdField_a_of_type_Ayvu, false);
    ayvu.b(this.jdField_a_of_type_Ayvu, true);
    this.jdField_a_of_type_Ayvu.a(this.jdField_a_of_type_Ayvt);
    if (QLog.isColorLevel()) {
      QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 errCode:" + paramInt + " msg:" + paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      ayvu.a(this.jdField_a_of_type_Ayvu, false);
      ayvu.b(this.jdField_a_of_type_Ayvu, false);
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
        ayvx localayvx = new ayvx();
        localayvx.a(((NowQQLiveFocusProto.AnchorInfo)localObject2).uin.get());
        localayvx.d(((NowQQLiveFocusProto.AnchorInfo)localObject2).anchor_logo_url.get());
        localayvx.e(((NowQQLiveFocusProto.AnchorInfo)localObject2).audience_sum.get());
        localayvx.b(((NowQQLiveFocusProto.AnchorInfo)localObject2).jump_url.get());
        localayvx.c(((NowQQLiveFocusProto.AnchorInfo)localObject2).nick_name.get());
        localayvx.c(((NowQQLiveFocusProto.AnchorInfo)localObject2).room_id.get());
        localayvx.e(((NowQQLiveFocusProto.AnchorInfo)localObject2).room_name.get());
        localayvx.d(((NowQQLiveFocusProto.AnchorInfo)localObject2).start_time.get());
        localayvx.b(((NowQQLiveFocusProto.AnchorInfo)localObject2).user_type.get());
        localayvx.a(((NowQQLiveFocusProto.AnchorInfo)localObject2).type.get());
        localayvx.a(((NowQQLiveFocusProto.AnchorInfo)localObject2).cover_url.get());
        paramArrayOfByte.add(localayvx);
        if (QLog.isColorLevel()) {
          QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 nick_name:" + localayvx.b() + " jump_url:" + localayvx.a() + " anchor_logo_url: " + localayvx.c() + " anchorInfo.jump_url.get():" + ((NowQQLiveFocusProto.AnchorInfo)localObject2).jump_url.get());
        }
      }
      this.jdField_a_of_type_Ayvt.a(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      ayvu.a(this.jdField_a_of_type_Ayvu, false);
      ayvu.b(this.jdField_a_of_type_Ayvu, true);
      this.jdField_a_of_type_Ayvu.a(this.jdField_a_of_type_Ayvt);
      if (QLog.isColorLevel()) {
        QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 Exception:" + paramArrayOfByte.getMessage());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvv
 * JD-Core Version:    0.7.0.1
 */