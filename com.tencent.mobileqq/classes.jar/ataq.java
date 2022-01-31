import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x69.Submsgtype0x69;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.NumRedBusiInfo;

public class ataq
{
  private static ataq a = new ataq();
  
  public static ataq a()
  {
    return a;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "parsePushRedPointInfo: appid = " + paramInt + ", path = " + paramString1 + ", content = " + paramString2);
    }
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramString1 != null) && (paramString1.length() > 0))
    {
      try
      {
        paramString2 = new JSONObject(paramString2).getString("_red_ext_0x69");
        Object localObject = new Submsgtype0x69();
        ((Submsgtype0x69)localObject).mergeFrom(Base64.decode(paramString2, 0));
        paramString2 = new oidb_0x791.RedDotInfo();
        paramString2.uint32_appid.set(((Submsgtype0x69)localObject).uint32_appid.get());
        paramString2.bool_display_reddot.set(((Submsgtype0x69)localObject).bool_display_reddot.get());
        avpq localavpq = (avpq)paramQQAppInterface.getManager(36);
        if ((!paramString1.equals("7719.771901")) && (!paramString1.equals("7719.771903")))
        {
          paramInt = i;
          if (!paramString1.equals("7719.771904")) {}
        }
        else
        {
          paramInt = localavpq.a(paramString1, 0);
          paramInt = localavpq.a(paramString1, 1) + paramInt;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "parsePushRedPointInfo: num = " + paramInt);
        }
        paramString2.uint32_number.set(paramInt);
        paramString2.uint32_reason.set(((Submsgtype0x69)localObject).uint32_reason.get());
        paramString2.uint32_last_time.set(((Submsgtype0x69)localObject).uint32_last_time.get());
        paramString2.uint64_cmd_uin.set(((Submsgtype0x69)localObject).uint64_cmd_uin.get());
        paramString2.str_face_url.set(((Submsgtype0x69)localObject).bytes_face_url.get());
        paramString2.str_custom_buffer.set(((Submsgtype0x69)localObject).bytes_custom_buffer.get());
        paramString2.uint32_expire_time.set(((Submsgtype0x69)localObject).uint32_expire_time.get());
        paramString2.uint32_cmd_uin_type.set(((Submsgtype0x69)localObject).uint32_cmd_uin_type.get());
        paramString2.uint32_report_type.set(((Submsgtype0x69)localObject).uint32_report_type.get());
        paramString1 = (mxx)paramQQAppInterface.getManager(70);
        if ((paramString2.uint32_appid.get() != 38) && (paramString2.uint32_appid.get() != 42) && (paramString2.uint32_appid.get() != 59) && (paramString2.uint32_appid.get() != 60)) {
          return;
        }
        localObject = paramString1.a(paramString2.uint32_appid.get());
        if ((localObject != null) && (((oidb_0x791.RedDotInfo)localObject).uint32_number.get() == paramInt))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "parsePushRedPointInfo: unread num not change, just return");
          return;
        }
        paramString1.a(true);
        paramString1.a(paramString2);
        new axra(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("nearby_push_red_tmp").a(new String[] { paramString2.uint32_appid.get() + "" }).a();
        if (paramString2.uint32_appid.get() == 59)
        {
          new axra(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("like_exp_red").a();
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      if (paramString2.uint32_appid.get() == 60)
      {
        if (paramString2.uint64_cmd_uin.get() == 1822701914L)
        {
          new axra(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("assist_exp_red").a();
          return;
        }
        new axra(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("c2c_exp_red").a();
        return;
      }
      if (paramString2.uint32_appid.get() == 61) {
        new axra(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("paried_exp_red").a();
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<BusinessInfoCheckUpdate.NumRedInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "queryNearbyMsgInfos");
    }
    if (paramList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new HashMap();
      paramList = paramList.iterator();
      Object localObject2;
      while (paramList.hasNext())
      {
        localObject2 = (BusinessInfoCheckUpdate.NumRedInfo)paramList.next();
        if ((((BusinessInfoCheckUpdate.NumRedInfo)localObject2).appid.get() == 7719) && (((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get().size() > 0))
        {
          localObject2 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            BusinessInfoCheckUpdate.NumRedPath localNumRedPath1 = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject2).next();
            if (((Map)localObject1).containsKey(localNumRedPath1.str_path.get()))
            {
              BusinessInfoCheckUpdate.NumRedPath localNumRedPath2 = (BusinessInfoCheckUpdate.NumRedPath)((Map)localObject1).get(localNumRedPath1.str_path.get());
              if (localNumRedPath1.uint32_expire_time.get() > localNumRedPath2.uint32_expire_time.get()) {
                ((Map)localObject1).put(localNumRedPath1.str_path.get(), localNumRedPath1);
              }
            }
            else
            {
              ((Map)localObject1).put(localNumRedPath1.str_path.get(), localNumRedPath1);
            }
          }
        }
      }
      paramList = ((Map)localObject1).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject1 = (Map.Entry)paramList.next();
        localObject2 = new Submsgtype0x89.NumRedBusiInfo();
        ((Submsgtype0x89.NumRedBusiInfo)localObject2).uint64_msgid.set(((BusinessInfoCheckUpdate.NumRedPath)((Map.Entry)localObject1).getValue()).uint64_msgid.get());
        ((Submsgtype0x89.NumRedBusiInfo)localObject2).uint32_android_app_id.set(7719);
        ((Submsgtype0x89.NumRedBusiInfo)localObject2).str_android_path.set(((BusinessInfoCheckUpdate.NumRedPath)((Map.Entry)localObject1).getValue()).str_path.get());
        localArrayList.add(localObject2);
      }
      ((avpm)paramQQAppInterface.getManager(65)).a(localArrayList, "nearby_num_red_dot", new atar(this, paramQQAppInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ataq
 * JD-Core Version:    0.7.0.1
 */