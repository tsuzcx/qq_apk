import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.message.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;

public class avdr
{
  public static final String a;
  public int a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  static
  {
    jdField_a_of_type_JavaLangString = avec.jdField_a_of_type_JavaLangString + "GameDetailInfo";
  }
  
  public static avdr a(GameBasicInfo paramGameBasicInfo, GameUserInfo paramGameUserInfo)
  {
    avdr localavdr = new avdr();
    if ((paramGameBasicInfo == null) || (paramGameUserInfo == null)) {
      return localavdr;
    }
    if ((TextUtils.isEmpty(paramGameBasicInfo.mAppId)) || (TextUtils.isEmpty(paramGameUserInfo.mAppId)))
    {
      com.tencent.qphone.base.util.QLog.w(jdField_a_of_type_JavaLangString, 1, "appId is empty.");
      return localavdr;
    }
    if (!paramGameBasicInfo.mAppId.equals(paramGameUserInfo.mAppId))
    {
      com.tencent.qphone.base.util.QLog.w(jdField_a_of_type_JavaLangString, 1, "warning! appId should be the same!");
      return localavdr;
    }
    localavdr.jdField_b_of_type_JavaLangString = paramGameUserInfo.mRoleId;
    localavdr.jdField_c_of_type_JavaLangString = paramGameUserInfo.mAppId;
    localavdr.jdField_d_of_type_JavaLangString = paramGameUserInfo.mFaceUrl;
    localavdr.jdField_a_of_type_Int = paramGameUserInfo.mSex;
    localavdr.g = paramGameUserInfo.mLevelPic;
    localavdr.h = paramGameUserInfo.mLevelText;
    localavdr.e = paramGameUserInfo.mNickInGame;
    localavdr.f = paramGameUserInfo.mPartitioName;
    localavdr.jdField_b_of_type_Int = paramGameUserInfo.mOnlineType;
    localavdr.jdField_c_of_type_Int = paramGameUserInfo.mSwitchInGame;
    localavdr.k = paramGameUserInfo.mOnLineDesc;
    localavdr.i = paramGameBasicInfo.mName;
    localavdr.j = paramGameBasicInfo.mIconUrl;
    localavdr.l = paramGameBasicInfo.mStartGameUrl;
    localavdr.jdField_d_of_type_Int = paramGameBasicInfo.mMsgMaxLen;
    return localavdr;
  }
  
  public void a()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(600);
      localStringBuilder.append(" roleId:").append(this.jdField_b_of_type_JavaLangString).append(",appid:").append(this.jdField_c_of_type_JavaLangString).append(",mSwitchInGame:").append(this.jdField_c_of_type_Int).append(",onlineType:").append(this.jdField_b_of_type_Int).append(",mOnLineDesc:").append(this.k).append(",partName:").append(this.f).append(",mMsgMaxLen:").append(this.jdField_d_of_type_Int).append(",levelText:").append(this.h).append(",gameName:").append(this.i).append(",sex:").append(this.jdField_a_of_type_Int).append(",nick:").append(this.e).append(",levelPic:").append(this.g).append(",iconUrl:").append(this.j).append(",faceUrl:").append(this.jdField_d_of_type_JavaLangString).append(",startGameUrl:").append(this.l);
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d(jdField_a_of_type_JavaLangString, 0, localStringBuilder.toString());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.qphone.base.util.QLog.w(jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
    }
  }
  
  public String toString()
  {
    return "GameDetailInfo{mRoleId='" + this.jdField_b_of_type_JavaLangString + '\'' + ", mAppId='" + this.jdField_c_of_type_JavaLangString + '\'' + ", mFaceUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + ", mNickInGame='" + this.e + '\'' + ", mPartitioName='" + this.f + '\'' + ", mLevelPic='" + this.g + '\'' + ", mLevelText='" + this.h + '\'' + ", mSex=" + this.jdField_a_of_type_Int + ", mOnlineType=" + this.jdField_b_of_type_Int + ", mName='" + this.i + '\'' + ", mIconUrl='" + this.j + '\'' + ", mSwitchInGame=" + this.jdField_c_of_type_Int + ", mOnLineDesc='" + this.k + '\'' + ", mStartGameUrl='" + this.l + '\'' + ", mMsgMaxLen=" + this.jdField_d_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdr
 * JD-Core Version:    0.7.0.1
 */