import android.text.TextUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;

public class bcgt
{
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = -1L;
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  Class<? extends AbsShareMsg> jdField_a_of_type_JavaLangClass;
  String jdField_a_of_type_JavaLangString = "web";
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = -1;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = null;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString = null;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString = null;
  int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString = null;
  String f = null;
  String g = null;
  String h = null;
  String i = null;
  String j = null;
  String k = null;
  String l = null;
  String m = null;
  String n = null;
  String o = null;
  String p = null;
  String q = null;
  
  public bcgt(Class<? extends AbsShareMsg> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = "web";
    this.jdField_c_of_type_Int = 28;
  }
  
  public bcgt a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    if ((paramInt & 0x1) == 1) {
      this.jdField_d_of_type_Int = 1;
    }
    return this;
  }
  
  public bcgt a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public bcgt a(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public bcgt a(String paramString1, String paramString2)
  {
    this.n = paramString1;
    this.m = paramString2;
    if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2))) {
      this.jdField_a_of_type_Boolean = true;
    }
    return this;
  }
  
  public bcgt a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_e_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_c_of_type_JavaLangString = paramString4;
    this.jdField_d_of_type_JavaLangString = paramString5;
    return this;
  }
  
  public AbsShareMsg a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)this.jdField_a_of_type_JavaLangClass.newInstance());
      label14:
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgTemplateID = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mVersion = this.jdField_c_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgAction = this.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData = this.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsg_A_ActionData = this.jdField_c_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsg_I_ActionData = this.jdField_d_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl = this.jdField_e_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgBrief = this.f;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mCompatibleText = this.g;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mFlag = this.jdField_e_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAction = this.i;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl = this.h;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData = this.j;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData = this.k;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_I_ActionData = this.l;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName = this.n;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceIcon = this.m;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mHasSource = this.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mResid = this.o;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mFileName = this.p;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mFileSize = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSType = this.q;
      }
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
    }
    catch (InstantiationException localInstantiationException)
    {
      break label14;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label14;
    }
  }
  
  public bcgt b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public bcgt b(String paramString)
  {
    this.o = paramString;
    return this;
  }
  
  public bcgt b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.i = paramString1;
    this.h = paramString2;
    this.j = paramString3;
    this.k = paramString4;
    this.l = paramString5;
    return this;
  }
  
  public bcgt c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public bcgt c(String paramString)
  {
    this.p = paramString;
    return this;
  }
  
  public bcgt d(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public bcgt e(String paramString)
  {
    return a("web", paramString, null, null, null);
  }
  
  public bcgt f(String paramString)
  {
    return b("web", paramString, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgt
 * JD-Core Version:    0.7.0.1
 */