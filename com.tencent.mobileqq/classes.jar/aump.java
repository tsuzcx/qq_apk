import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.view.TextureRegistry;
import java.util.HashMap;

public class aump
{
  private static aump jdField_a_of_type_Aump;
  private BinaryMessenger jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger;
  private TextureRegistry jdField_a_of_type_IoFlutterViewTextureRegistry;
  private HashMap<String, aumn> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static aump a()
  {
    if (jdField_a_of_type_Aump == null) {}
    try
    {
      if (jdField_a_of_type_Aump == null) {
        jdField_a_of_type_Aump = new aump();
      }
      return jdField_a_of_type_Aump;
    }
    finally {}
  }
  
  private void a()
  {
    a(new aunm("sso_channel", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new aumq("com.tencent.qflutter/apm", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new aunc("com.tencent.qflutter/scfsetting", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new aunf("com.tencent.qflutter/zanranking", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new auni("com.tencent.qflutter/reporter", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
  }
  
  private void b() {}
  
  private void c() {}
  
  public <T extends aumn> T a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (aumn)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
  
  public void a(aumn paramaumn)
  {
    if (TextUtils.isEmpty(paramaumn.a())) {
      QLog.d("QFlutter.ChannelManager", 1, "add channel channel name is emptyS");
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramaumn.a()))
      {
        aumn localaumn = (aumn)this.jdField_a_of_type_JavaUtilHashMap.remove(paramaumn.a());
        if (localaumn != null) {
          localaumn.a();
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramaumn.a(), paramaumn);
    } while (!QLog.isColorLevel());
    QLog.d("QFlutter.ChannelManager", 2, String.format("addChannel, channelName: %s", new Object[] { paramaumn.a() }));
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
 * Qualified Name:     aump
 * JD-Core Version:    0.7.0.1
 */