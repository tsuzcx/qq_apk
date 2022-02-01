import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d_common.EduHis;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d_common.SchoolInfo;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.BeancurdcubeProfile;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.BeancurdcubeProfileInfo;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileBirthday;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileCompany;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileEducation;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileEmail;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileHomeLand;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileIntro;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileLocation;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileNickname;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileOccupation;
import tencent.im.oidb.cmd0xe6b.oidb_0xe6b.ReqBody;
import tencent.im.oidb.cmd0xe6b.oidb_0xe6b.RspBody;

public class bdco
  extends bdcg
  implements ampq
{
  ampm jdField_a_of_type_Ampm;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  WeakReference<bdco> jdField_a_of_type_MqqUtilWeakReference = new WeakReference(this);
  volatile boolean jdField_a_of_type_Boolean;
  
  public bdco(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Ampm = ((ampm)paramQQAppInterface.getManager(59));
    this.jdField_a_of_type_Ampm.a(this.jdField_a_of_type_MqqUtilWeakReference);
    this.jdField_a_of_type_Ampm.c(this);
  }
  
  private String a(StringBuilder paramStringBuilder, List<beancurdcube_profile_common.BeancurdcubeProfileInfo> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator1 = paramList.iterator();
    int j = 0;
    JSONObject localJSONObject;
    label164:
    label317:
    label339:
    StringBuilder localStringBuilder;
    label371:
    String str;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        paramList = (beancurdcube_profile_common.BeancurdcubeProfileInfo)localIterator1.next();
        int k = paramList.enum_beancurdcube_profile_type.get();
        localJSONObject = new JSONObject();
        long l = paramList.uint32_last_modify_time.get();
        paramStringBuilder.append("|").append(k);
        switch (k)
        {
        default: 
        case 20002: 
        case 20031: 
          for (;;)
          {
            localJSONObject.put("key_ts", l);
            localJSONObject.put("key_type", k);
            localJSONArray.put(localJSONObject);
            j += 1;
            break;
            paramList = (beancurdcube_profile_common.ProfileNickname)paramList.msg_nickname.get();
            if (paramList.bytes_nickname.has()) {}
            for (paramList = paramList.bytes_nickname.get().toStringUtf8(); !TextUtils.isEmpty(paramList); paramList = "")
            {
              localJSONObject.put("key_profile_nickname", paramList);
              break label164;
            }
            localJSONObject.put("key_profile_birthday", ((beancurdcube_profile_common.ProfileBirthday)paramList.msg_birthday.get()).uint32_birthday.get());
          }
        case 27264: 
          paramList = (beancurdcube_profile_common.ProfileEducation)paramList.msg_education.get();
          if (paramList.msg_edu.has())
          {
            paramList = (oidb_cmd0xd2d_common.EduHis)paramList.msg_edu.get();
            if (paramList == null) {
              continue;
            }
            if (!paramList.rpt_msg_school.has()) {
              break label457;
            }
            paramList = paramList.rpt_msg_school.get();
            if ((paramList == null) || (paramList.size() == 0)) {
              continue;
            }
            localStringBuilder = new StringBuilder();
            Iterator localIterator2 = paramList.iterator();
            int i = 0;
            if (!localIterator2.hasNext()) {
              break label474;
            }
            paramList = (oidb_cmd0xd2d_common.SchoolInfo)localIterator2.next();
            if (!paramList.str_school_name.has()) {
              break label462;
            }
            paramList = paramList.str_school_name.get();
            label410:
            if ((TextUtils.isEmpty(paramList)) || (i >= 3)) {
              break label827;
            }
            if (i <= 0) {
              break label467;
            }
            str = "、";
            label430:
            localStringBuilder.append(str);
            localStringBuilder.append(paramList);
            i += 1;
          }
          break;
        }
      }
    }
    label812:
    label827:
    for (;;)
    {
      break label371;
      paramList = null;
      break label317;
      label457:
      paramList = null;
      break label339;
      label462:
      paramList = null;
      break label410;
      label467:
      str = "";
      break label430;
      label474:
      if (localStringBuilder.length() <= 0) {
        break;
      }
      localJSONObject.put("key_profile_education", localStringBuilder.toString());
      break label164;
      paramList = (beancurdcube_profile_common.ProfileLocation)paramList.msg_location.get();
      if (a(localJSONObject, paramList.uint32_nation.get(), paramList.uint32_province.get(), paramList.uint32_city.get(), paramList.uint32_district.get())) {
        break label164;
      }
      break;
      paramList = (beancurdcube_profile_common.ProfileHomeLand)paramList.msg_homeland.get();
      if (a(localJSONObject, paramList.uint32_nation.get(), paramList.uint32_province.get(), paramList.uint32_city.get(), paramList.uint32_district.get())) {
        break label164;
      }
      break;
      paramList = (beancurdcube_profile_common.ProfileCompany)paramList.msg_company.get();
      if (paramList.company_name.has()) {}
      for (paramList = paramList.company_name.get().toStringUtf8(); !TextUtils.isEmpty(paramList); paramList = null)
      {
        localJSONObject.put("key_profile_company", paramList);
        break label164;
      }
      localJSONObject.put("key_profile_occupation", ((beancurdcube_profile_common.ProfileOccupation)paramList.msg_occupation.get()).uint32_occupation_id.get());
      break label164;
      if (paramList.msg_email.has())
      {
        paramList = (beancurdcube_profile_common.ProfileEmail)paramList.msg_email.get();
        label706:
        if (!paramList.bytes_email.has()) {
          break label752;
        }
      }
      label752:
      for (paramList = paramList.bytes_email.get().toStringUtf8(); !TextUtils.isEmpty(paramList); paramList = null)
      {
        localJSONObject.put("key_profile_email", paramList);
        break label164;
        paramList = null;
        break label706;
      }
      paramList = (beancurdcube_profile_common.ProfileIntro)paramList.msg_intro.get();
      if (paramList.bytes_intro.has()) {}
      for (paramList = paramList.bytes_intro.get().toStringUtf8();; paramList = null)
      {
        if (TextUtils.isEmpty(paramList)) {
          break label812;
        }
        localJSONObject.put("key_profile_introduction", paramList);
        break;
      }
      break;
      if (j > 0) {
        return localJSONArray.toString();
      }
      return null;
    }
  }
  
  private String a(oidb_0xe6b.RspBody paramRspBody, StringBuilder paramStringBuilder)
  {
    if (paramRspBody.msg_profile_info.has())
    {
      paramRspBody = (beancurdcube_profile_common.BeancurdcubeProfile)paramRspBody.msg_profile_info.get();
      if (paramRspBody == null) {
        break label132;
      }
      if (!paramRspBody.rpt_beancurdcube_profile_info.has()) {
        break label72;
      }
    }
    label72:
    for (List localList = paramRspBody.rpt_beancurdcube_profile_info.get();; localList = null)
    {
      if ((localList == null) || (localList.size() <= 0)) {
        break label78;
      }
      return a(paramStringBuilder, localList);
      paramRspBody = null;
      break;
    }
    label78:
    int i;
    if (paramRspBody.rpt_beancurdcube_profile_info.has())
    {
      i = paramRspBody.rpt_beancurdcube_profile_info.get().size();
      QLog.d("Tofu_BaseProfileDataHandler", 1, String.format("getBusDataFromRspBytes rpt_beancurdcube_profile_info.size=%d", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      return null;
      i = -1;
      break;
      label132:
      QLog.d("Tofu_BaseProfileDataHandler", 1, "getBusDataFromRspBytes beancurdcubeProfile is null");
    }
  }
  
  private boolean a(JSONObject paramJSONObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = ampm.a(paramInt1);
    arrayOfString[1] = ampm.a(paramInt2);
    arrayOfString[2] = ampm.a(paramInt3);
    arrayOfString[3] = ampm.a(paramInt4);
    if (!this.jdField_a_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {}
      }
    }
    try
    {
      this.jdField_a_of_type_JavaLangObject.wait(1000L);
      label81:
      if (!this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Tofu_BaseProfileDataHandler", 2, "parseLocation location not ready return");
        }
        return false;
        paramJSONObject = finally;
        throw paramJSONObject;
      }
      String str = this.jdField_a_of_type_Ampm.a(arrayOfString);
      ??? = str;
      if (str.equals("不限")) {
        ??? = "";
      }
      paramJSONObject.put("key_profile_location_desc", ???);
      paramJSONObject.put("key_profile_location_1", arrayOfString[0]);
      paramJSONObject.put("key_profile_location_2", arrayOfString[1]);
      paramJSONObject.put("key_profile_location_3", arrayOfString[2]);
      paramJSONObject.put("key_profile_location_4", arrayOfString[3]);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label81;
    }
  }
  
  public int a()
  {
    return 9;
  }
  
  public String a(TofuItem paramTofuItem)
  {
    Object localObject5 = null;
    StringBuilder localStringBuilder = new StringBuilder(1024);
    Object localObject1 = localObject5;
    if (paramTofuItem.bytesFromServer != null)
    {
      localObject1 = localObject5;
      if (paramTofuItem.bytesFromServer.length > 0) {
        localObject1 = new oidb_0xe6b.RspBody();
      }
    }
    try
    {
      ((oidb_0xe6b.RspBody)localObject1).mergeFrom(paramTofuItem.bytesFromServer);
      localObject1 = a((oidb_0xe6b.RspBody)localObject1, localStringBuilder);
      if (QLog.isColorLevel())
      {
        if (paramTofuItem.bytesFromServer == null)
        {
          i = -1;
          QLog.i("Tofu_BaseProfileDataHandler", 2, String.format("getBusDataFromRspBytes [%s] size=%d types=%s", new Object[] { localObject1, Integer.valueOf(i), localStringBuilder.toString() }));
        }
      }
      else {
        return localObject1;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        QLog.d("Tofu_BaseProfileDataHandler", 1, "getBusDataFromRspBytes InvalidProtocolBufferMicroException=" + localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
        Object localObject2 = localObject5;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("Tofu_BaseProfileDataHandler", 1, "getBusDataFromRspBytes JSONException=" + localJSONException.getMessage(), localJSONException);
        Object localObject3 = localObject5;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("Tofu_BaseProfileDataHandler", 1, "getBusDataFromRspBytes Exception=" + localException.getMessage(), localException);
        Object localObject4 = localObject5;
        continue;
        int i = paramTofuItem.bytesFromServer.length;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ampm.d(this);
    this.jdField_a_of_type_Ampm.b(this.jdField_a_of_type_MqqUtilWeakReference);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 2) && (paramBoolean)) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.i("Tofu_BaseProfileDataHandler", 2, "onGetConfig location parse ready");
      }
      return;
    }
  }
  
  public byte[] a(TofuItem paramTofuItem)
  {
    oidb_0xe6b.ReqBody localReqBody = new oidb_0xe6b.ReqBody();
    localReqBody.uint64_frd_uin.set(paramTofuItem.frdUin);
    localReqBody.uint32_last_query_time.set((int)paramTofuItem.lastPullTsSvr);
    return localReqBody.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdco
 * JD-Core Version:    0.7.0.1
 */