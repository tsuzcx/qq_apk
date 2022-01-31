import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.HashMap;
import java.util.Map;
import mqq.app.TicketManagerImpl;

public final class anul
  extends anuo
{
  public anul(QIMMusicConfigManager paramQIMMusicConfigManager)
  {
    super(paramQIMMusicConfigManager);
  }
  
  anum a()
  {
    return new anum(this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager);
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.c == 200)
    {
      if (paramNetResp.a != null)
      {
        anum localanum = a();
        localanum.jdField_a_of_type_JavaLangString = new String(paramNetResp.a);
        localanum.a();
        this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(0, true, localanum.jdField_a_of_type_JavaLangString);
        return;
      }
      a(false);
      this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(0, false, "Have no data.");
      return;
    }
    a(false);
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(0, false, "Http Request fail, code=" + paramNetResp.c);
  }
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.e = 1;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    long l = System.currentTimeMillis() / 1000L;
    String str = ((TicketManagerImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2)).getSkey(this.c);
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_id", "2000000025");
    localHashMap.put("app_key", "SApgehUTVGxZKBQZTt");
    localHashMap.put("device_id", DeviceInfoUtil.a());
    localHashMap.put("timestamp", String.valueOf(l));
    localHashMap.put("sign", a(l));
    localHashMap.putAll(a(this.c, str));
    localHttpNetReq.jdField_a_of_type_JavaLangString = a("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_songlist_self.fcg", localHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigManager", 2, "QQMusicReq SongList api request, req url=" + localHttpNetReq.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anul
 * JD-Core Version:    0.7.0.1
 */