import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.HashMap;

public class arsm
{
  private static arsm jdField_a_of_type_Arsm;
  private BinaryMessenger jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger;
  private HashMap<String, arsk> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static arsm a()
  {
    if (jdField_a_of_type_Arsm == null) {}
    try
    {
      if (jdField_a_of_type_Arsm == null) {
        jdField_a_of_type_Arsm = new arsm();
      }
      return jdField_a_of_type_Arsm;
    }
    finally {}
  }
  
  private void a()
  {
    a(new arsu("sso_channel", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new arsn("com.tencent.qflutter/apm", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new arsq("com.tencent.qflutter/scfsetting", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
  }
  
  private void a(arsk paramarsk)
  {
    if (TextUtils.isEmpty(paramarsk.a())) {
      QLog.d("QFlutter.ChannelManager", 1, "add channel channel name is emptyS");
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramarsk.a()))
      {
        arsk localarsk = (arsk)this.jdField_a_of_type_JavaUtilHashMap.remove(paramarsk.a());
        if (localarsk != null) {
          localarsk.a();
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramarsk.a(), paramarsk);
    } while (!QLog.isColorLevel());
    QLog.d("QFlutter.ChannelManager", 2, String.format("addChannel, channelName: %s", new Object[] { paramarsk.a() }));
  }
  
  private void b() {}
  
  private void c() {}
  
  public <T extends arsk> T a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (arsk)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
 * Qualified Name:     arsm
 * JD-Core Version:    0.7.0.1
 */