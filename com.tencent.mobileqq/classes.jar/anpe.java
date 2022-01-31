import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class anpe
{
  public int a;
  public long a;
  public String a;
  public byte[] a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "0";
  
  public anpe()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 30;
  }
  
  public static String a(anpe paramanpe)
  {
    if ((paramanpe == null) || (!paramanpe.a())) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("uin", paramanpe.jdField_a_of_type_JavaLangString);
      if ((paramanpe.jdField_a_of_type_ArrayOfByte != null) && (paramanpe.jdField_a_of_type_ArrayOfByte.length > 0)) {
        localJSONObject.putOpt("sig", bakz.a(paramanpe.jdField_a_of_type_ArrayOfByte));
      }
      localJSONObject.putOpt("matchUin", paramanpe.b);
      localJSONObject.putOpt("tipsWording", paramanpe.c);
      localJSONObject.putOpt("timeStamp", Long.valueOf(paramanpe.jdField_a_of_type_Long));
      localJSONObject.putOpt("matchExpiredTime", Integer.valueOf(paramanpe.jdField_a_of_type_Int));
      paramanpe = localJSONObject.toString();
      return paramanpe;
    }
    catch (JSONException paramanpe) {}
    return null;
  }
  
  public anpe a()
  {
    anpe localanpe = new anpe();
    localanpe.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localanpe.jdField_a_of_type_ArrayOfByte = ((byte[])this.jdField_a_of_type_ArrayOfByte.clone());
    localanpe.b = this.b;
    localanpe.c = this.c;
    localanpe.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localanpe.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localanpe.e = this.e;
    return localanpe;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfByte = azzz.a("");
    this.b = "";
    this.c = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
    this.e = "0";
  }
  
  public boolean a()
  {
    String str = azzz.a(this.jdField_a_of_type_ArrayOfByte);
    return (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(str));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b))) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof anpe));
      paramObject = (anpe)paramObject;
    } while ((!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) || (!this.b.equals(paramObject.b)) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{uin: ").append(this.jdField_a_of_type_JavaLangString).append("}");
    String str = azzz.a(this.jdField_a_of_type_ArrayOfByte);
    int i = 0;
    if (str != null) {
      i = str.length();
    }
    localStringBuilder.append("{sig: ").append(i).append("}");
    localStringBuilder.append("{matchUin: ").append(this.b).append("}");
    localStringBuilder.append("{tipsWording: ").append(this.c).append("}");
    localStringBuilder.append("{timeStamp: ").append(this.jdField_a_of_type_Long).append("}");
    localStringBuilder.append("{nickName: ").append(this.d).append("}");
    localStringBuilder.append("{algorithmID: ").append(this.e).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anpe
 * JD-Core Version:    0.7.0.1
 */