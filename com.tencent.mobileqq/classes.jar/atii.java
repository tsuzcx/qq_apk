import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.view.TextureRegistry;
import java.util.HashMap;

public class atii
{
  private static atii jdField_a_of_type_Atii;
  private BinaryMessenger jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger;
  private TextureRegistry jdField_a_of_type_IoFlutterViewTextureRegistry;
  private HashMap<String, atig> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static atii a()
  {
    if (jdField_a_of_type_Atii == null) {}
    try
    {
      if (jdField_a_of_type_Atii == null) {
        jdField_a_of_type_Atii = new atii();
      }
      return jdField_a_of_type_Atii;
    }
    finally {}
  }
  
  private void a()
  {
    a(new atjb("sso_channel", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new atij("com.tencent.qflutter/apm", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new atix("com.tencent.qflutter/scfsetting", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new atio("tencent_qqcircle", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
  }
  
  private void b() {}
  
  private void c() {}
  
  public <T extends atig> T a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (atig)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
  
  public void a(atig paramatig)
  {
    if (TextUtils.isEmpty(paramatig.a())) {
      QLog.d("QFlutter.ChannelManager", 1, "add channel channel name is emptyS");
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramatig.a()))
      {
        atig localatig = (atig)this.jdField_a_of_type_JavaUtilHashMap.remove(paramatig.a());
        if (localatig != null) {
          localatig.a();
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramatig.a(), paramatig);
    } while (!QLog.isColorLevel());
    QLog.d("QFlutter.ChannelManager", 2, String.format("addChannel, channelName: %s", new Object[] { paramatig.a() }));
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
 * Qualified Name:     atii
 * JD-Core Version:    0.7.0.1
 */