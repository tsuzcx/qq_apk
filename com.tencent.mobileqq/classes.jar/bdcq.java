import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe9b.oidb_0xe9b.BasicProfileData;
import tencent.im.oidb.cmd0xe9b.oidb_0xe9b.LabelInfo;
import tencent.im.oidb.cmd0xe9b.oidb_0xe9b.QZoneInfo;
import tencent.im.oidb.cmd0xe9b.oidb_0xe9b.ReqBody;
import tencent.im.oidb.cmd0xe9b.oidb_0xe9b.RspBody;
import tencent.im.oidb.cmd0xe9b.oidb_0xe9b.SelectedPicInfo;

public class bdcq
  extends bdcg
{
  public bdcq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String a(oidb_0xe9b.RspBody paramRspBody)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("parsePbToStr fields:");
    JSONObject localJSONObject = new JSONObject();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("hasBaseProfile=");
    boolean bool1 = a(localJSONObject, paramRspBody);
    localStringBuilder2.append(bool1).append(",");
    localStringBuilder2 = localStringBuilder1.append("hasPL=");
    boolean bool2 = b(localJSONObject, paramRspBody);
    localStringBuilder2.append(bool2).append(",");
    localStringBuilder2 = localStringBuilder1.append("hasQzone=");
    boolean bool3 = c(localJSONObject, paramRspBody);
    localStringBuilder2.append(bool3).append(",");
    localStringBuilder2 = localStringBuilder1.append("hasNicePics=");
    boolean bool4 = d(localJSONObject, paramRspBody);
    localStringBuilder2.append(bool4).append(",");
    localStringBuilder2 = localStringBuilder1.append("hasSign=");
    boolean bool5 = e(localJSONObject, paramRspBody);
    localStringBuilder2.append(bool5);
    QLog.i("Tofu_NewFrdMiniCardHandler", 1, localStringBuilder1.toString());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5)) {
      return localJSONObject.toString();
    }
    return null;
  }
  
  private void a(Exception paramException, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Tofu_NewFrdMiniCardHandler", 2, paramString + "," + paramException.getMessage(), paramException);
    }
  }
  
  private boolean a(JSONObject paramJSONObject, oidb_0xe9b.RspBody paramRspBody)
  {
    boolean bool = false;
    JSONObject localJSONObject;
    if (paramRspBody.msg_basic_profile.has())
    {
      paramRspBody = (oidb_0xe9b.BasicProfileData)paramRspBody.msg_basic_profile.get();
      localJSONObject = new JSONObject();
    }
    try
    {
      if (paramRspBody.uint32_age.has()) {
        localJSONObject.put("age", paramRspBody.uint32_age.get());
      }
      if (paramRspBody.uint32_gender.has()) {
        localJSONObject.put("gender", paramRspBody.uint32_gender.get());
      }
      if (paramRspBody.bytes_place.has()) {
        localJSONObject.put("place", paramRspBody.bytes_place.get().toStringUtf8());
      }
      if (paramRspBody.bytes_addfrd_src.has()) {
        localJSONObject.put("addfrd_src", paramRspBody.bytes_addfrd_src.get().toStringUtf8());
      }
      if (paramRspBody.uint32_comm_frd_num.has()) {
        localJSONObject.put("commfrd_num", paramRspBody.uint32_comm_frd_num.get());
      }
      paramJSONObject.put("field_baseprofile", localJSONObject);
      if (QLog.isColorLevel()) {
        QLog.i("Tofu_NewFrdMiniCardHandler", 2, String.format("fillWithFieldBaseProfile %s", new Object[] { localJSONObject }));
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        a(paramJSONObject, "fillWithFieldBaseProfile");
      }
    }
    bool = true;
    return bool;
  }
  
  private boolean b(JSONObject paramJSONObject, oidb_0xe9b.RspBody paramRspBody)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    JSONArray localJSONArray;
    int i;
    if (paramRspBody.rpt_msg_label.has())
    {
      bool1 = bool2;
      if (paramRspBody.rpt_msg_label.size() > 0)
      {
        paramRspBody = paramRspBody.rpt_msg_label.get();
        localJSONArray = new JSONArray();
        i = 0;
      }
    }
    for (;;)
    {
      try
      {
        if (i < paramRspBody.size())
        {
          oidb_0xe9b.LabelInfo localLabelInfo = (oidb_0xe9b.LabelInfo)paramRspBody.get(i);
          if ((localLabelInfo == null) || (!localLabelInfo.bytes_name.has())) {
            continue;
          }
          localJSONArray.put(i, localLabelInfo.bytes_name.get().toStringUtf8());
          continue;
        }
        paramJSONObject.put("field_personal_labels", localJSONArray);
        if (QLog.isColorLevel()) {
          QLog.i("Tofu_NewFrdMiniCardHandler", 2, String.format("fillWithFieldPersonalityLabel %s", new Object[] { localJSONArray }));
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject, "fillWithFieldPersonalityLabel");
        continue;
        i += 1;
      }
      bool1 = true;
      return bool1;
    }
  }
  
  private boolean c(JSONObject paramJSONObject, oidb_0xe9b.RspBody paramRspBody)
  {
    if (paramRspBody.msg_qzone_info.has())
    {
      paramRspBody = (oidb_0xe9b.QZoneInfo)paramRspBody.msg_qzone_info.get();
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      try
      {
        if (paramRspBody.bytes_space_name.has()) {
          localJSONObject.put("space_name", paramRspBody.bytes_space_name.get().toStringUtf8());
        }
        if (paramRspBody.bytes_update_content.has()) {
          localJSONObject.put("update_content", paramRspBody.bytes_update_content.get().toStringUtf8());
        }
        if ((paramRspBody.str_newly_img_url.has()) && (paramRspBody.str_newly_img_url.size() > 0))
        {
          int i = 0;
          while (i < paramRspBody.str_newly_img_url.get().size())
          {
            localJSONArray.put(i, ((String)paramRspBody.str_newly_img_url.get(i)).toString());
            i += 1;
          }
        }
        localJSONObject.put("img_urls", localJSONArray);
        paramJSONObject.put("field_qzone", localJSONObject);
        if (QLog.isColorLevel()) {
          QLog.i("Tofu_NewFrdMiniCardHandler", 2, String.format("fillWithFieldQzone %s", new Object[] { localJSONObject }));
        }
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          a(paramJSONObject, "fillWithFieldQzone");
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean d(JSONObject paramJSONObject, oidb_0xe9b.RspBody paramRspBody)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    JSONArray localJSONArray;
    int i;
    if (paramRspBody.rpt_msg_selected_pic.has())
    {
      bool1 = bool2;
      if (paramRspBody.rpt_msg_selected_pic.size() > 0)
      {
        paramRspBody = paramRspBody.rpt_msg_selected_pic.get();
        localJSONArray = new JSONArray();
        i = 0;
      }
    }
    try
    {
      while (i < paramRspBody.size())
      {
        oidb_0xe9b.SelectedPicInfo localSelectedPicInfo = (oidb_0xe9b.SelectedPicInfo)paramRspBody.get(i);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ori", localSelectedPicInfo.str_ori_pic_url.get());
        localJSONObject.put("medium", localSelectedPicInfo.str_medium_pic_url.get());
        localJSONArray.put(i, localJSONObject);
        i += 1;
      }
      paramJSONObject.put("field_nicepics", localJSONArray);
      if (QLog.isColorLevel()) {
        QLog.i("Tofu_NewFrdMiniCardHandler", 2, String.format("fillWithFieldNicePics %s", new Object[] { localJSONArray }));
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        a(paramJSONObject, "fillWithFieldNicePics");
      }
    }
    bool1 = true;
    return bool1;
  }
  
  private boolean e(JSONObject paramJSONObject, oidb_0xe9b.RspBody paramRspBody)
  {
    if ((paramRspBody.rpt_bytes_longnick.has()) && (paramRspBody.rpt_bytes_longnick.size() > 0)) {
      try
      {
        paramRspBody = ((ByteStringMicro)paramRspBody.rpt_bytes_longnick.get().get(0)).toByteArray();
        Object localObject = RichStatus.parseStatus(paramRspBody);
        int i = ((RichStatus)localObject).actionId;
        String str = ((RichStatus)localObject).getActionAndData();
        localObject = ((RichStatus)localObject).getPlainText();
        if ((i == 0) && (TextUtils.isEmpty(str)) && (TextUtils.isEmpty((CharSequence)localObject))) {
          return false;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("actionId", i);
        localJSONObject.put("actionAndData", str);
        localJSONObject.put("plainText", localObject);
        if (QLog.isColorLevel()) {
          if (paramRspBody != null) {
            break label182;
          }
        }
        label182:
        for (i = -1;; i = paramRspBody.length)
        {
          QLog.i("Tofu_NewFrdMiniCardHandler", 2, String.format("fillWithFieldSign %s [bytes=%d]", new Object[] { localJSONObject, Integer.valueOf(i) }));
          paramJSONObject.put("sign", localJSONObject);
          break;
        }
        return false;
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject, "fillWithFieldSign");
      }
    }
    return true;
  }
  
  public int a()
  {
    return 11;
  }
  
  public String a(TofuItem paramTofuItem)
  {
    if ((paramTofuItem.bytesFromServer != null) && (paramTofuItem.bytesFromServer.length > 0))
    {
      oidb_0xe9b.RspBody localRspBody = new oidb_0xe9b.RspBody();
      try
      {
        localRspBody.mergeFrom(paramTofuItem.bytesFromServer);
        paramTofuItem = a(localRspBody);
        return paramTofuItem;
      }
      catch (InvalidProtocolBufferMicroException paramTofuItem)
      {
        QLog.d("Tofu_NewFrdMiniCardHandler", 1, "getBusDataFromRspBytes exception=" + paramTofuItem.getMessage(), paramTofuItem);
        return null;
      }
    }
    if (paramTofuItem.bytesFromServer == null) {}
    for (int i = -1;; i = paramTofuItem.bytesFromServer.length)
    {
      QLog.d("Tofu_NewFrdMiniCardHandler", 1, new Object[] { "getBusDataFromRsp bytesFromServer size=", Integer.valueOf(i) });
      return null;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return (c()) || (paramInt == 1) || (paramInt == 2);
  }
  
  public byte[] a(TofuItem paramTofuItem)
  {
    oidb_0xe9b.ReqBody localReqBody = new oidb_0xe9b.ReqBody();
    localReqBody.uint64_fuin.set(paramTofuItem.frdUin);
    return localReqBody.toByteArray();
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcq
 * JD-Core Version:    0.7.0.1
 */