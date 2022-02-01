import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.ilive.pb.LiveGroupTips.GetLiveGroupTipsRsp;

public class bkjt
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public long c;
  public String c;
  public String d;
  public String e;
  
  public static bkjt a(LiveGroupTips.GetLiveGroupTipsRsp paramGetLiveGroupTipsRsp)
  {
    boolean bool = true;
    if (paramGetLiveGroupTipsRsp == null) {
      return null;
    }
    bkjt localbkjt = new bkjt();
    if (paramGetLiveGroupTipsRsp.room_id.has())
    {
      localbkjt.jdField_a_of_type_Long = paramGetLiveGroupTipsRsp.room_id.get();
      if (paramGetLiveGroupTipsRsp.room_title.has()) {
        localbkjt.jdField_a_of_type_JavaLangString = paramGetLiveGroupTipsRsp.room_title.get();
      }
      if (paramGetLiveGroupTipsRsp.room_icon.has()) {
        localbkjt.jdField_b_of_type_JavaLangString = paramGetLiveGroupTipsRsp.room_icon.get();
      }
      if (paramGetLiveGroupTipsRsp.room_viewer.has()) {
        localbkjt.jdField_b_of_type_Long = paramGetLiveGroupTipsRsp.room_viewer.get();
      }
      if (paramGetLiveGroupTipsRsp.viewer_text.has()) {
        localbkjt.jdField_c_of_type_JavaLangString = paramGetLiveGroupTipsRsp.viewer_text.get();
      }
      if (paramGetLiveGroupTipsRsp.puin.has()) {
        localbkjt.jdField_c_of_type_Long = paramGetLiveGroupTipsRsp.puin.get();
      }
      if (paramGetLiveGroupTipsRsp.room_schema.has()) {
        localbkjt.d = paramGetLiveGroupTipsRsp.room_schema.get();
      }
      if (paramGetLiveGroupTipsRsp.is_living.has()) {
        if (paramGetLiveGroupTipsRsp.is_living.get() != 1) {
          break label214;
        }
      }
    }
    for (;;)
    {
      localbkjt.jdField_a_of_type_Boolean = bool;
      if (paramGetLiveGroupTipsRsp.interval.has()) {
        localbkjt.jdField_a_of_type_Int = paramGetLiveGroupTipsRsp.interval.get();
      }
      return localbkjt;
      return null;
      label214:
      bool = false;
    }
  }
  
  @NonNull
  public String toString()
  {
    return "mRoomId = " + this.jdField_a_of_type_Long + " mRoomTitle = " + this.jdField_a_of_type_JavaLangString + " mRoomSubTitle = " + this.jdField_c_of_type_JavaLangString + " mIsLiving = " + this.jdField_a_of_type_Boolean + " mPollTime = " + this.jdField_a_of_type_Int + " mViewNum = " + this.jdField_b_of_type_Long + " puin = " + this.jdField_c_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjt
 * JD-Core Version:    0.7.0.1
 */