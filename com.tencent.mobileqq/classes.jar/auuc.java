import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class auuc
{
  public static HashSet a = new HashSet();
  
  public static auub a(AppInterface paramAppInterface)
  {
    auub localauub = new auub();
    String str = "nearby_face_score_config_" + paramAppInterface.getCurrentAccountUin();
    paramAppInterface = paramAppInterface.getApplication().getApplicationContext().getSharedPreferences(str, 4);
    localauub.jdField_a_of_type_Boolean = paramAppInterface.getBoolean("isShowCard", false);
    localauub.jdField_b_of_type_Boolean = paramAppInterface.getBoolean("isShowList", false);
    localauub.jdField_a_of_type_Long = paramAppInterface.getLong("expireTime", 0L);
    localauub.jdField_a_of_type_JavaLangString = paramAppInterface.getString("entranceJumpUrl", "");
    localauub.jdField_b_of_type_JavaLangString = paramAppInterface.getString("entranceJumpUrlForHost", "");
    localauub.c = paramAppInterface.getString("entranceJumpUrlForGuest", "");
    if (QLog.isColorLevel()) {
      QLog.e("Q..troop.faceScore", 2, "FaceScoreUtils.getConfig config.expireTime=" + localauub.jdField_a_of_type_Boolean + "  config.isShowList=" + localauub.jdField_b_of_type_Boolean + "  config.expireTime=" + localauub.jdField_a_of_type_Long + "  config.entranceJumpUrl=" + localauub.jdField_a_of_type_JavaLangString + "  config.entranceJumpUrlForHost=" + localauub.jdField_b_of_type_JavaLangString + "  config.entranceJumpUrlForGuest=" + localauub.c);
    }
    return localauub;
  }
  
  public static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= paramInt)) {
      return "";
    }
    return paramVarArgs[paramInt];
  }
  
  public static void a(AppInterface paramAppInterface, auub paramauub)
  {
    try
    {
      String str = "nearby_face_score_config_" + paramAppInterface.getCurrentAccountUin();
      paramAppInterface.getApplication().getApplicationContext().getSharedPreferences(str, 4).edit().putBoolean("isShowCard", paramauub.jdField_a_of_type_Boolean).putBoolean("isShowList", paramauub.jdField_b_of_type_Boolean).putLong("expireTime", paramauub.jdField_a_of_type_Long).putString("entranceJumpUrl", paramauub.jdField_a_of_type_JavaLangString).putString("entranceJumpUrlForHost", paramauub.jdField_b_of_type_JavaLangString).putString("entranceJumpUrlForGuest", paramauub.c).commit();
      if (QLog.isColorLevel()) {
        QLog.e("Q..troop.faceScore", 2, "FaceScoreUtils.saveConfig config.expireTime=" + paramauub.jdField_a_of_type_Boolean + "  config.isShowList=" + paramauub.jdField_b_of_type_Boolean + "  config.expireTime=" + paramauub.jdField_a_of_type_Long + "  config.entranceJumpUrl=" + paramauub.jdField_a_of_type_JavaLangString + "  config.entranceJumpUrlForHost=" + paramauub.jdField_b_of_type_JavaLangString + "  config.entranceJumpUrlForGuest=" + paramauub.c);
      }
      return;
    }
    finally
    {
      paramAppInterface = finally;
      throw paramAppInterface;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    String str = "nearby_face_score_config_" + paramAppInterface.getCurrentAccountUin();
    paramAppInterface = paramAppInterface.getApplication().getApplicationContext().getSharedPreferences(str, 4);
    str = "has_insert_face_score_msg_" + paramString;
    paramAppInterface.edit().putBoolean(str, true).commit();
    if (QLog.isColorLevel()) {
      QLog.e("Q..troop.faceScore", 2, "FaceScoreUtils.setHasInsertMsgFlag uin=" + paramString);
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "setFaceScoreFlag, msg = " + paramMessageRecord + "  key=" + paramString + " flag=" + paramBoolean);
    }
    if (paramMessageRecord == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramMessageRecord.extStr))
        {
          localJSONObject = new JSONObject();
          localJSONObject.put(paramString, paramBoolean);
          paramMessageRecord.extStr = localJSONObject.toString();
          paramMessageRecord.extLong |= 0x1;
          return;
        }
      }
      catch (JSONException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        return;
      }
      JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
      localJSONObject.put(paramString, paramBoolean);
      paramMessageRecord.extStr = localJSONObject.toString();
    }
  }
  
  public static void a(String paramString1, String paramString2, String... paramVarArgs)
  {
    azqs.b(null, "dc00899", "grp_lbs", paramString2, "face_score", paramString1, 0, 0, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString)
  {
    String str = "nearby_face_score_config_" + paramAppInterface.getCurrentAccountUin();
    boolean bool = paramAppInterface.getApplication().getApplicationContext().getSharedPreferences(str, 4).getBoolean("has_insert_face_score_msg_" + paramString, false);
    if (QLog.isColorLevel()) {
      QLog.e("Q..troop.faceScore", 2, "FaceScoreUtils.getHasInsertMsgFlag uin=" + paramString + "  flag=" + bool);
    }
    return bool;
  }
  
  public static boolean a(MessageRecord paramMessageRecord, String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "getFaceScoreFlag, msg = " + paramMessageRecord + "  key=" + paramString);
    }
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord.extStr != null) && ((paramMessageRecord.extLong & 0x1) == 1) && (paramMessageRecord.extStr.contains(paramString)) && (paramMessageRecord.getExtInfoFromExtStr(paramString).equals("true"))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q..troop.faceScore.FaceScoreUtils", 2, "isFaceScoreGrayTips, ret=" + bool + ", mr=" + paramMessageRecord);
      }
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auuc
 * JD-Core Version:    0.7.0.1
 */