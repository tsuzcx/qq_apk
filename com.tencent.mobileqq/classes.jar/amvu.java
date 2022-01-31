import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.HashMap;
import java.util.Map;
import mqq.app.TicketManagerImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class amvu
  extends amvw
{
  String a;
  
  amvu(QIMMusicConfigManager paramQIMMusicConfigManager)
  {
    super(paramQIMMusicConfigManager);
  }
  
  amvv a()
  {
    return new amvv(this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager);
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.c == 200)
    {
      if (paramNetResp.a != null)
      {
        amvv localamvv = a();
        localamvv.jdField_a_of_type_JavaLangString = new String(paramNetResp.a);
        localamvv.jdField_a_of_type_Boolean = true;
        localamvv.a();
        this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(1, true, localamvv.jdField_a_of_type_JavaLangString);
        return;
      }
      a(false);
      this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(1, false, "have no data.");
      return;
    }
    a(false);
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(1, false, "Http Request fail, code=" + paramNetResp.c);
  }
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new JSONObject(this.jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject1).optInt("ret", -1) != 0) {
          break label348;
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("data");
        if (localObject1 == null) {
          break label348;
        }
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          if ((localObject2 == null) || (!"我喜欢".equals(((JSONObject)localObject2).optString("diss_name")))) {
            break label349;
          }
          l1 = ((JSONObject)localObject2).optLong("diss_id", -1L);
          if (l1 != -1L)
          {
            localObject1 = new HttpNetReq();
            ((HttpNetReq)localObject1).jdField_a_of_type_Int = 0;
            ((HttpNetReq)localObject1).e = 1;
            ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
            long l2 = System.currentTimeMillis() / 1000L;
            localObject2 = ((TicketManagerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.c);
            HashMap localHashMap = new HashMap();
            localHashMap.put("app_id", "2000000025");
            localHashMap.put("app_key", "SApgehUTVGxZKBQZTt");
            localHashMap.put("device_id", DeviceInfoUtil.a());
            localHashMap.put("timestamp", String.valueOf(l2));
            localHashMap.put("sign", a(l2));
            localHashMap.put("dissid", String.valueOf(l1));
            localHashMap.putAll(a(this.c, (String)localObject2));
            ((HttpNetReq)localObject1).jdField_a_of_type_JavaLangString = a("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_songlist_detail.fcg", localHashMap);
            this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject1);
            return;
          }
          a(true);
          this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(1, false, "can not find myFav diss.");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        a(false);
        this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(1, false, "parsed json error, json=" + this.jdField_a_of_type_JavaLangString);
        return;
      }
      long l1 = -1L;
      continue;
      label348:
      return;
      label349:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amvu
 * JD-Core Version:    0.7.0.1
 */