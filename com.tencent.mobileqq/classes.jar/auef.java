import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.view.TextureRegistry;
import java.util.HashMap;

public class auef
{
  private static auef jdField_a_of_type_Auef;
  private BinaryMessenger jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger;
  private TextureRegistry jdField_a_of_type_IoFlutterViewTextureRegistry;
  private HashMap<String, aued> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static auef a()
  {
    if (jdField_a_of_type_Auef == null) {}
    try
    {
      if (jdField_a_of_type_Auef == null) {
        jdField_a_of_type_Auef = new auef();
      }
      return jdField_a_of_type_Auef;
    }
    finally {}
  }
  
  private void a()
  {
    a(new auen("sso_channel", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new aueg("com.tencent.qflutter/apm", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new auej("com.tencent.qflutter/scfsetting", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
  }
  
  private void b() {}
  
  private void c() {}
  
  public <T extends aued> T a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (aued)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
  
  public void a(aued paramaued)
  {
    if (TextUtils.isEmpty(paramaued.a())) {
      QLog.d("QFlutter.ChannelManager", 1, "add channel channel name is emptyS");
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramaued.a()))
      {
        aued localaued = (aued)this.jdField_a_of_type_JavaUtilHashMap.remove(paramaued.a());
        if (localaued != null) {
          localaued.a();
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramaued.a(), paramaued);
    } while (!QLog.isColorLevel());
    QLog.d("QFlutter.ChannelManager", 2, String.format("addChannel, channelName: %s", new Object[] { paramaued.a() }));
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
 * Qualified Name:     auef
 * JD-Core Version:    0.7.0.1
 */