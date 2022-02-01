import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;
import tencent.im.beancurd.anniversary.Anniversary;
import tencent.im.beancurd.anniversary.AnniversaryInfo;

public class bejr
  extends bejg
{
  public bejr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    return 8;
  }
  
  public String a(TofuItem paramTofuItem)
  {
    if ((paramTofuItem.bytesFromServer != null) && (paramTofuItem.bytesFromServer.length > 0)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new anniversary.Anniversary();
        ((anniversary.Anniversary)localObject1).mergeFrom(paramTofuItem.bytesFromServer);
        if ((((anniversary.Anniversary)localObject1).rpt_anniversary_info.has()) && (((anniversary.Anniversary)localObject1).rpt_anniversary_info.get() != null) && (((anniversary.Anniversary)localObject1).rpt_anniversary_info.get().size() > 0))
        {
          localObject2 = (anniversary.AnniversaryInfo)((anniversary.Anniversary)localObject1).rpt_anniversary_info.get(0);
          if (((anniversary.AnniversaryInfo)localObject2).uint64_type.has())
          {
            i = (int)((anniversary.AnniversaryInfo)localObject2).uint64_type.get();
            if (((anniversary.AnniversaryInfo)localObject2).uint64_frd_uin.has()) {
              ((anniversary.AnniversaryInfo)localObject2).uint64_frd_uin.get();
            }
            if (((anniversary.AnniversaryInfo)localObject2).uint64_bind_time.has())
            {
              l = ((anniversary.AnniversaryInfo)localObject2).uint64_bind_time.get();
              if (!((anniversary.AnniversaryInfo)localObject2).uint64_n.has()) {
                continue;
              }
              j = (int)((anniversary.AnniversaryInfo)localObject2).uint64_n.get();
              if (!((anniversary.AnniversaryInfo)localObject2).uint64_level.has()) {
                continue;
              }
              k = (int)((anniversary.AnniversaryInfo)localObject2).uint64_level.get();
              if (!((anniversary.AnniversaryInfo)localObject2).str_bg_url.has()) {
                continue;
              }
              localObject1 = ((anniversary.AnniversaryInfo)localObject2).str_bg_url.get();
              if (!((anniversary.AnniversaryInfo)localObject2).str_text_color.has()) {
                break label624;
              }
              localObject2 = ((anniversary.AnniversaryInfo)localObject2).str_text_color.get();
              if ((i < 0) || (l <= 0L) || (j <= 0) || (k < 0) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
                break label631;
              }
              m = 1;
              if (m == 0) {
                continue;
              }
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("key_frd_uin", paramTofuItem.frdUin);
              localJSONObject.put("key_type", i);
              localJSONObject.put("key_bind_time", l);
              localJSONObject.put("key_anniversary_years", j);
              localJSONObject.put("key_inimate_level", k);
              localJSONObject.put("key_bg_url", localObject1);
              localJSONObject.put("key_txt_clr", localObject2);
              paramTofuItem = localJSONObject.toString();
              if (QLog.isColorLevel()) {
                QLog.i("Tofu_IntimateAnniversaryDataHandler", 2, String.format("getBusDataFromRspBytes %s", new Object[] { paramTofuItem }));
              }
              return paramTofuItem;
            }
          }
          else
          {
            i = -1;
            continue;
          }
          long l = 0L;
          continue;
          int j = 0;
          continue;
          int k = 0;
          continue;
          localObject1 = "";
          continue;
          if (localObject1 == null)
          {
            m = -1;
            QLog.d("Tofu_IntimateAnniversaryDataHandler", 1, String.format("getBusDataFromRspBytes not valid. type=%d bindTime=%d years=%d level=%d bgUrl.size=%d txtColor=%s", new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), localObject2 }));
            break label637;
          }
          m = ((String)localObject1).length();
          continue;
        }
        if (((anniversary.Anniversary)localObject1).rpt_anniversary_info.has())
        {
          i = ((anniversary.Anniversary)localObject1).rpt_anniversary_info.size();
          QLog.d("Tofu_IntimateAnniversaryDataHandler", 1, String.format("getBusDataFromRspBytes no data. infos.size=%d", new Object[] { Integer.valueOf(i) }));
        }
      }
      catch (Exception paramTofuItem)
      {
        QLog.d("Tofu_IntimateAnniversaryDataHandler", 1, "getBusDataFromRspBytes exception=" + paramTofuItem.getMessage(), paramTofuItem);
      }
      int i = -1;
      continue;
      if (paramTofuItem.bytesFromServer == null) {}
      for (i = -1;; i = paramTofuItem.bytesFromServer.length)
      {
        QLog.d("Tofu_IntimateAnniversaryDataHandler", 1, new Object[] { "getBusDataFromRspBytes bytesFromServer size=", Integer.valueOf(i) });
        break;
      }
      label624:
      Object localObject2 = "#000";
      continue;
      label631:
      int m = 0;
      continue;
      label637:
      paramTofuItem = null;
    }
  }
  
  public byte[] a(TofuItem paramTofuItem)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejr
 * JD-Core Version:    0.7.0.1
 */