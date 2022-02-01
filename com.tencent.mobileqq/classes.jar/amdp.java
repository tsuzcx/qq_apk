import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import org.json.JSONObject;

public class amdp
  implements MediaPlayer.OnPreparedListener
{
  String jdField_a_of_type_JavaLangString;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean;
  
  public amdp(amdk paramamdk, JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("code", 2);
      this.jdField_a_of_type_OrgJsonJSONObject.put("errorMessage", "can't play");
      this.jdField_a_of_type_Amdk.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
      return;
    }
    catch (Exception localException1)
    {
      amdk.a(this.jdField_a_of_type_Amdk, "-->handleJsRequest exception:" + localException1.toString());
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", 2);
        localJSONObject.put("errorMessage", "exception");
        this.jdField_a_of_type_Amdk.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (amdk.a(this.jdField_a_of_type_Amdk).a()) {}
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        amdk.a(this.jdField_a_of_type_Amdk, "-->play failed");
        this.jdField_a_of_type_OrgJsonJSONObject.put("code", 2);
        this.jdField_a_of_type_OrgJsonJSONObject.put("errorMessage", "can't play");
      }
      for (;;)
      {
        this.jdField_a_of_type_Amdk.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
        return;
        this.jdField_a_of_type_OrgJsonJSONObject.put("code", 0);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      amdk.a(this.jdField_a_of_type_Amdk, "-->handleJsRequest exception:" + paramMediaPlayer.toString());
      try
      {
        paramMediaPlayer = new JSONObject();
        paramMediaPlayer.put("code", 2);
        paramMediaPlayer.put("errorMessage", "exception");
        this.jdField_a_of_type_Amdk.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramMediaPlayer.toString() });
        return;
      }
      catch (Exception paramMediaPlayer)
      {
        paramMediaPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdp
 * JD-Core Version:    0.7.0.1
 */