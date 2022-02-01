import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bnth
  extends alqb
  implements Cloneable
{
  public bnth(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = anzj.a(2131696759);
  }
  
  public Object a(int paramInt, bfoy parambfoy, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof bnth))
    {
      paramObject = (bnth)paramObject;
      paramObject.jdField_a_of_type_Bfoz.a(parambfoy.jdField_a_of_type_Bfoz);
      return paramObject;
    }
    paramObject = new bnth(BaseApplication.getContext());
    paramObject.jdField_a_of_type_Bfoz = new bfoz(parambfoy.jdField_a_of_type_Bfoz);
    return paramObject;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    QLog.d("TroopSpecialAttentionMsg", 2, "deSerialize");
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.getString("content");
      this.jdField_a_of_type_Int = paramArrayOfByte.getInt("time");
      this.b = paramArrayOfByte.getInt("color");
      this.c = paramArrayOfByte.getString("messageNavInfo");
      if ((!TextUtils.isEmpty(this.c)) && (this.jdField_a_of_type_Bfoz == null))
      {
        this.jdField_a_of_type_Bfoz = new bfoz();
        this.jdField_a_of_type_Bfoz.a(this.c);
      }
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public byte[] a()
  {
    return b();
  }
  
  public byte[] b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("content", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("time", this.jdField_a_of_type_Int);
      localJSONObject.put("color", this.b);
      if (this.jdField_a_of_type_Bfoz != null) {
        this.c = this.jdField_a_of_type_Bfoz.a();
      }
      localJSONObject.put("messageNavInfo", this.c);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject.toString().getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnth
 * JD-Core Version:    0.7.0.1
 */