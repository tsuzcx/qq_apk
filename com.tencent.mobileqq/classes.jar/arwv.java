import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.HashMap;

public class arwv
{
  private static arwv jdField_a_of_type_Arwv;
  private BinaryMessenger jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger;
  private HashMap<String, arwt> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static arwv a()
  {
    if (jdField_a_of_type_Arwv == null) {}
    try
    {
      if (jdField_a_of_type_Arwv == null) {
        jdField_a_of_type_Arwv = new arwv();
      }
      return jdField_a_of_type_Arwv;
    }
    finally {}
  }
  
  private void a()
  {
    a(new arxd("sso_channel", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new arww("com.tencent.qflutter/apm", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new arwz("com.tencent.qflutter/scfsetting", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
  }
  
  private void a(arwt paramarwt)
  {
    if (TextUtils.isEmpty(paramarwt.a())) {
      QLog.d("QFlutter.ChannelManager", 1, "add channel channel name is emptyS");
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramarwt.a()))
      {
        arwt localarwt = (arwt)this.jdField_a_of_type_JavaUtilHashMap.remove(paramarwt.a());
        if (localarwt != null) {
          localarwt.a();
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramarwt.a(), paramarwt);
    } while (!QLog.isColorLevel());
    QLog.d("QFlutter.ChannelManager", 2, String.format("addChannel, channelName: %s", new Object[] { paramarwt.a() }));
  }
  
  private void b() {}
  
  private void c() {}
  
  public <T extends arwt> T a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (arwt)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public void a(BinaryMessenger paramBinaryMessenger)
  {
    if (paramBinaryMessenger == this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger)
    {
      QLog.d("QFlutter.ChannelManager", 1, "already registered channels");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.ChannelManager", 2, "registerChannels");
    }
    this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger = paramBinaryMessenger;
    a();
    b();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwv
 * JD-Core Version:    0.7.0.1
 */