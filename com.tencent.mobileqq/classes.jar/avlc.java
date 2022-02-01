import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.message.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;

public class avlc
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
    jdField_a_of_type_JavaLangString = avln.jdField_a_of_type_JavaLangString + "GameDetailInfo";
  }
  
  public static avlc a(GameBasicInfo paramGameBasicInfo, GameUserInfo paramGameUserInfo)
  {
    avlc localavlc = new avlc();
    if ((paramGameBasicInfo == null) || (paramGameUserInfo == null)) {
      return localavlc;
    }
    if ((TextUtils.isEmpty(paramGameBasicInfo.mAppId)) || (TextUtils.isEmpty(paramGameUserInfo.mAppId)))
    {
      com.tencent.qphone.base.util.QLog.w(jdField_a_of_type_JavaLangString, 1, "appId is empty.");
      return localavlc;
    }
    if (!paramGameBasicInfo.mAppId.equals(paramGameUserInfo.mAppId))
    {
      com.tencent.qphone.base.util.QLog.w(jdField_a_of_type_JavaLangString, 1, "warning! appId should be the same!");
      return localavlc;
    }
    localavlc.jdField_b_of_type_JavaLangString = paramGameUserInfo.mRoleId;
    localavlc.jdField_c_of_type_JavaLangString = paramGameUserInfo.mAppId;
    localavlc.jdField_d_of_type_JavaLangString = paramGameUserInfo.mFaceUrl;
    localavlc.jdField_a_of_type_Int = paramGameUserInfo.mSex;
    localavlc.g = paramGameUserInfo.mLevelPic;
    localavlc.h = paramGameUserInfo.mLevelText;
    localavlc.e = paramGameUserInfo.mNickInGame;
    localavlc.f = paramGameUserInfo.mPartitioName;
    localavlc.jdField_b_of_type_Int = paramGameUserInfo.mOnlineType;
    localavlc.jdField_c_of_type_Int = paramGameUserInfo.mSwitchInGame;
    localavlc.k = paramGameUserInfo.mOnLineDesc;
    localavlc.i = paramGameBasicInfo.mName;
    localavlc.j = paramGameBasicInfo.mIconUrl;
    localavlc.l = paramGameBasicInfo.mStartGameUrl;
    localavlc.jdField_d_of_type_Int = paramGameBasicInfo.mMsgMaxLen;
    return localavlc;
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
 * Qualified Name:     avlc
 * JD-Core Version:    0.7.0.1
 */