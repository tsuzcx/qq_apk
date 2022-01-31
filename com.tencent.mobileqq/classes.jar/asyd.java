import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.mutualmark.mutualmark.MutualMark;
import tencent.im.mutualmark.mutualmark.ResourceInfo_17;

public class asyd
{
  public float a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public long g;
  
  public asyd()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  public static asyd a(mutualmark.MutualMark paramMutualMark)
  {
    asyd localasyd = new asyd();
    localasyd.jdField_a_of_type_Long = paramMutualMark.uint64_type.get();
    localasyd.jdField_b_of_type_Long = paramMutualMark.uint64_level.get();
    localasyd.jdField_a_of_type_Float = paramMutualMark.float_count.get();
    localasyd.jdField_c_of_type_Long = paramMutualMark.uint64_day.get();
    localasyd.jdField_d_of_type_Long = paramMutualMark.uint64_time.get();
    localasyd.f = paramMutualMark.uint64_icon_status.get();
    if (localasyd.f != 2L)
    {
      localasyd.g = 0L;
      if (paramMutualMark.uint32_close_flag.has()) {
        if (paramMutualMark.uint32_close_flag.get() == 0) {
          break label302;
        }
      }
    }
    label302:
    for (boolean bool = true;; bool = false)
    {
      localasyd.jdField_a_of_type_Boolean = bool;
      mutualmark.ResourceInfo_17 localResourceInfo_17;
      if (paramMutualMark.bytes_resource_info.has()) {
        localResourceInfo_17 = new mutualmark.ResourceInfo_17();
      }
      try
      {
        localResourceInfo_17.mergeFrom(paramMutualMark.bytes_resource_info.get().toByteArray());
        paramMutualMark = localResourceInfo_17;
      }
      catch (Throwable paramMutualMark)
      {
        for (;;)
        {
          QLog.i("MutualMarkPullInfo", 1, "parseFrom error:" + paramMutualMark.getMessage());
          paramMutualMark = null;
        }
      }
      if (paramMutualMark != null)
      {
        if (paramMutualMark.bytes_static_url.has()) {
          localasyd.jdField_a_of_type_JavaLangString = paramMutualMark.bytes_static_url.get().toStringUtf8();
        }
        if (paramMutualMark.bytes_dynamic_url.has()) {
          localasyd.jdField_b_of_type_JavaLangString = paramMutualMark.bytes_dynamic_url.get().toStringUtf8();
        }
        if (paramMutualMark.bytes_cartoon_url.has()) {
          localasyd.jdField_c_of_type_JavaLangString = paramMutualMark.bytes_cartoon_url.get().toStringUtf8();
        }
        if (paramMutualMark.bytes_cartoon_md5.has()) {
          localasyd.jdField_d_of_type_JavaLangString = paramMutualMark.bytes_cartoon_md5.get().toStringUtf8();
        }
        if (paramMutualMark.bytes_word.has()) {
          localasyd.jdField_e_of_type_JavaLangString = paramMutualMark.bytes_word.get().toStringUtf8();
        }
      }
      return localasyd;
      if (!paramMutualMark.uint64_icon_status_end_time.has()) {
        break;
      }
      localasyd.g = paramMutualMark.uint64_icon_status_end_time.get();
      break;
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkPullInfo{");
    localStringBuilder.append("type:").append(this.jdField_a_of_type_Long).append(", ");
    localStringBuilder.append("level:").append(this.jdField_b_of_type_Long).append(", ");
    localStringBuilder.append("count:").append(this.jdField_a_of_type_Float).append(", ");
    localStringBuilder.append("continue_days:").append(this.jdField_c_of_type_Long).append(", ");
    localStringBuilder.append("last_action_time:").append(this.jdField_d_of_type_Long).append(", ");
    localStringBuilder.append("last_change_time:").append(this.jdField_e_of_type_Long).append(", ");
    localStringBuilder.append("icon_status:").append(this.f).append(", ");
    localStringBuilder.append("icon_status_end_time:").append(this.g).append(", ");
    localStringBuilder.append("icon_static_url:").append(this.jdField_a_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_dynamic_url:").append(this.jdField_b_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_cartoon_url:").append(this.jdField_c_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_cartoon_md5:").append(this.jdField_d_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_name:").append(this.jdField_e_of_type_JavaLangString).append(", ");
    localStringBuilder.append("user_close_flag:").append(this.jdField_a_of_type_Boolean).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asyd
 * JD-Core Version:    0.7.0.1
 */