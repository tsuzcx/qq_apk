import android.graphics.Color;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.GroupBusinessMsg;

public class azhz
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  public azhz()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static azhz a(im_msg_body.GroupBusinessMsg paramGroupBusinessMsg)
  {
    azhz localazhz = new azhz();
    localazhz.jdField_a_of_type_Int = paramGroupBusinessMsg.uint32_flags.get();
    localazhz.jdField_a_of_type_JavaLangString = paramGroupBusinessMsg.bytes_head_url.get().toStringUtf8();
    localazhz.jdField_b_of_type_JavaLangString = paramGroupBusinessMsg.bytes_head_clk_url.get().toStringUtf8();
    localazhz.jdField_c_of_type_JavaLangString = paramGroupBusinessMsg.bytes_nick.get().toStringUtf8();
    localazhz.jdField_d_of_type_JavaLangString = paramGroupBusinessMsg.bytes_rank.get().toStringUtf8();
    try
    {
      localazhz.jdField_b_of_type_Int = Color.parseColor(paramGroupBusinessMsg.bytes_nick_color.get().toStringUtf8());
      localazhz.jdField_c_of_type_Int = Color.parseColor(paramGroupBusinessMsg.bytes_rank_color.get().toStringUtf8());
      localazhz.jdField_d_of_type_Int = Color.parseColor(paramGroupBusinessMsg.bytes_rank_bgcolor.get().toStringUtf8());
      return localazhz;
    }
    catch (Exception paramGroupBusinessMsg)
    {
      QLog.e(azhy.jdField_a_of_type_JavaLangString, 2, "the color string cannot parse to color. " + paramGroupBusinessMsg.getMessage());
    }
    return localazhz;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopBusinessMessage");
    localStringBuilder.append(",").append("nick").append("=").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(",").append("flag").append("=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",").append("clk").append("=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",").append("head").append("=").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azhz
 * JD-Core Version:    0.7.0.1
 */