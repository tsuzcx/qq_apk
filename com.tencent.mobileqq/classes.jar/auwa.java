import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.view.TextureRegistry;
import java.util.HashMap;

public class auwa
{
  private static auwa jdField_a_of_type_Auwa;
  private BinaryMessenger jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger;
  private TextureRegistry jdField_a_of_type_IoFlutterViewTextureRegistry;
  private HashMap<String, auvy> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static auwa a()
  {
    if (jdField_a_of_type_Auwa == null) {}
    try
    {
      if (jdField_a_of_type_Auwa == null) {
        jdField_a_of_type_Auwa = new auwa();
      }
      return jdField_a_of_type_Auwa;
    }
    finally {}
  }
  
  private void a()
  {
    a(new auwi("sso_channel", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new auwb("com.tencent.qflutter/apm", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new auwe("com.tencent.qflutter/scfsetting", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
  }
  
  private void b() {}
  
  private void c() {}
  
  public <T extends auvy> T a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (auvy)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public BinaryMessenger a()
  {
    return this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger;
  }
  
  public TextureRegistry a()
  {
    return this.jdField_a_of_type_IoFlutterViewTextureRegistry;
  }
  
  public void a(auvy paramauvy)
  {
    if (TextUtils.isEmpty(paramauvy.a())) {
      QLog.d("QFlutter.ChannelManager", 1, "add channel channel name is emptyS");
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramauvy.a()))
      {
        auvy localauvy = (auvy)this.jdField_a_of_type_JavaUtilHashMap.remove(paramauvy.a());
        if (localauvy != null) {
          localauvy.a();
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramauvy.a(), paramauvy);
    } while (!QLog.isColorLevel());
    QLog.d("QFlutter.ChannelManager", 2, String.format("addChannel, channelName: %s", new Object[] { paramauvy.a() }));
  }
  
  public void a(BinaryMessenger paramBinaryMessenger, TextureRegistry paramTextureRegistry)
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
    this.jdField_a_of_type_IoFlutterViewTextureRegistry = paramTextureRegistry;
    a();
    b();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwa
 * JD-Core Version:    0.7.0.1
 */