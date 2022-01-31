import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.Player;

public class azqw
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  
  public azqw() {}
  
  public azqw(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public azqw(oidb_0x6c2.Player paramPlayer)
  {
    this.jdField_a_of_type_Long = paramPlayer.uint64_uin.get();
    this.jdField_b_of_type_Long = paramPlayer.uint64_time.get();
    this.jdField_a_of_type_Int = paramPlayer.int32_amount.get();
    this.jdField_b_of_type_Int = paramPlayer.int32_index.get();
    this.jdField_a_of_type_JavaLangString = paramPlayer.bytes_tips.get().toStringUtf8();
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", this.jdField_a_of_type_Long);
      localJSONObject.put("time", this.jdField_b_of_type_Long);
      localJSONObject.put("amount", this.jdField_a_of_type_Int);
      localJSONObject.put("index", this.jdField_b_of_type_Int);
      localJSONObject.put("tips", this.jdField_a_of_type_JavaLangString);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(".troop.send_gift", 2, getClass().getSimpleName() + " toJson error. e=" + localJSONException);
      }
    }
  }
  
  public void a(String paramString)
  {
    paramString = new String(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Long = paramString.optLong("uin");
      this.jdField_b_of_type_Long = paramString.optLong("time");
      this.jdField_a_of_type_Int = paramString.optInt("amount");
      this.jdField_b_of_type_Int = paramString.optInt("index");
      this.jdField_a_of_type_JavaLangString = paramString.optString("tips");
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e(".troop.send_gift", 2, getClass().getSimpleName() + " fromJson error. e=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azqw
 * JD-Core Version:    0.7.0.1
 */