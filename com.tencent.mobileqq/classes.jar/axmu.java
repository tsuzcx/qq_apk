import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.mutualmark.mutualmark.MutualMark;
import tencent.im.mutualmark.mutualmark.ResourceInfo;
import tencent.im.mutualmark.mutualmark.ResourceInfo_17;

public class axmu
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
  public long h;
  
  public axmu()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  public static axmu a(mutualmark.MutualMark paramMutualMark)
  {
    localObject3 = null;
    axmu localaxmu = new axmu();
    localaxmu.jdField_a_of_type_Long = paramMutualMark.uint64_type.get();
    localaxmu.jdField_b_of_type_Long = paramMutualMark.uint64_level.get();
    localaxmu.jdField_a_of_type_Float = paramMutualMark.float_count.get();
    localaxmu.jdField_c_of_type_Long = paramMutualMark.uint64_day.get();
    localaxmu.jdField_d_of_type_Long = paramMutualMark.uint64_time.get();
    localaxmu.f = paramMutualMark.uint64_icon_status.get();
    localaxmu.h = paramMutualMark.uint64_sub_level.get();
    if (localaxmu.f != 2L) {
      localaxmu.g = 0L;
    }
    for (;;)
    {
      boolean bool;
      Object localObject1;
      if (paramMutualMark.uint32_close_flag.has())
      {
        if (paramMutualMark.uint32_close_flag.get() != 0)
        {
          bool = true;
          localaxmu.jdField_a_of_type_Boolean = bool;
        }
      }
      else if (paramMutualMark.bytes_resource_info.has()) {
        localObject1 = new mutualmark.ResourceInfo_17();
      }
      try
      {
        ((mutualmark.ResourceInfo_17)localObject1).mergeFrom(paramMutualMark.bytes_resource_info.get().toByteArray());
        a(localaxmu, (mutualmark.ResourceInfo_17)localObject1);
        if (paramMutualMark.bytes_grade_resource_info.has()) {
          localObject1 = new mutualmark.ResourceInfo();
        }
        try
        {
          ((mutualmark.ResourceInfo)localObject1).mergeFrom(paramMutualMark.bytes_grade_resource_info.get().toByteArray());
          paramMutualMark = (mutualmark.MutualMark)localObject1;
        }
        catch (Throwable paramMutualMark)
        {
          for (;;)
          {
            Object localObject2;
            QLog.i("MutualMarkPullInfo", 1, "parseFrom error:" + paramMutualMark.getMessage());
            paramMutualMark = localObject3;
          }
        }
        a(localaxmu, paramMutualMark);
        return localaxmu;
        if (!paramMutualMark.uint64_icon_status_end_time.has()) {
          continue;
        }
        localaxmu.g = paramMutualMark.uint64_icon_status_end_time.get();
        continue;
        bool = false;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.i("MutualMarkPullInfo", 1, "parseFrom error:" + localThrowable.getMessage());
          localObject2 = null;
        }
      }
    }
  }
  
  private static void a(axmu paramaxmu, mutualmark.ResourceInfo paramResourceInfo)
  {
    if ((paramaxmu != null) && (paramResourceInfo != null))
    {
      if (paramResourceInfo.bytes_static_url.has())
      {
        paramaxmu.jdField_a_of_type_JavaLangString = paramResourceInfo.bytes_static_url.get().toStringUtf8();
        paramaxmu.jdField_a_of_type_JavaLangString = axma.c(paramaxmu.jdField_a_of_type_JavaLangString);
      }
      if (paramResourceInfo.bytes_dynamic_url.has())
      {
        paramaxmu.jdField_b_of_type_JavaLangString = paramResourceInfo.bytes_dynamic_url.get().toStringUtf8();
        paramaxmu.jdField_b_of_type_JavaLangString = axma.c(paramaxmu.jdField_b_of_type_JavaLangString);
      }
      if (paramResourceInfo.bytes_cartoon_url.has())
      {
        paramaxmu.jdField_c_of_type_JavaLangString = paramResourceInfo.bytes_cartoon_url.get().toStringUtf8();
        paramaxmu.jdField_c_of_type_JavaLangString = axma.c(paramaxmu.jdField_c_of_type_JavaLangString);
      }
      if (paramResourceInfo.bytes_cartoon_md5.has()) {
        paramaxmu.jdField_d_of_type_JavaLangString = paramResourceInfo.bytes_cartoon_md5.get().toStringUtf8();
      }
      if (paramResourceInfo.bytes_word.has()) {
        paramaxmu.jdField_e_of_type_JavaLangString = paramResourceInfo.bytes_word.get().toStringUtf8();
      }
    }
  }
  
  private static void a(axmu paramaxmu, mutualmark.ResourceInfo_17 paramResourceInfo_17)
  {
    if ((paramaxmu != null) && (paramResourceInfo_17 != null))
    {
      if (paramResourceInfo_17.bytes_static_url.has())
      {
        paramaxmu.jdField_a_of_type_JavaLangString = paramResourceInfo_17.bytes_static_url.get().toStringUtf8();
        paramaxmu.jdField_a_of_type_JavaLangString = axma.c(paramaxmu.jdField_a_of_type_JavaLangString);
      }
      if (paramResourceInfo_17.bytes_dynamic_url.has())
      {
        paramaxmu.jdField_b_of_type_JavaLangString = paramResourceInfo_17.bytes_dynamic_url.get().toStringUtf8();
        paramaxmu.jdField_b_of_type_JavaLangString = axma.c(paramaxmu.jdField_b_of_type_JavaLangString);
      }
      if (paramResourceInfo_17.bytes_cartoon_url.has())
      {
        paramaxmu.jdField_c_of_type_JavaLangString = paramResourceInfo_17.bytes_cartoon_url.get().toStringUtf8();
        paramaxmu.jdField_c_of_type_JavaLangString = axma.c(paramaxmu.jdField_c_of_type_JavaLangString);
      }
      if (paramResourceInfo_17.bytes_cartoon_md5.has()) {
        paramaxmu.jdField_d_of_type_JavaLangString = paramResourceInfo_17.bytes_cartoon_md5.get().toStringUtf8();
      }
      if (paramResourceInfo_17.bytes_word.has()) {
        paramaxmu.jdField_e_of_type_JavaLangString = paramResourceInfo_17.bytes_word.get().toStringUtf8();
      }
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
    localStringBuilder.append("sub_level:").append(this.h).append(", ");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axmu
 * JD-Core Version:    0.7.0.1
 */