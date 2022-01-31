import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.HashMap;

public class apzi
{
  private static apzi jdField_a_of_type_Apzi;
  private BinaryMessenger jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger;
  private HashMap<String, apzg> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static apzi a()
  {
    if (jdField_a_of_type_Apzi == null) {}
    try
    {
      if (jdField_a_of_type_Apzi == null) {
        jdField_a_of_type_Apzi = new apzi();
      }
      return jdField_a_of_type_Apzi;
    }
    finally {}
  }
  
  private void a()
  {
    a(new apzq("sso_channel", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new apzj("com.tencent.qflutter/apm", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new apzm("com.tencent.qflutter/scfsetting", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
  }
  
  private void a(apzg paramapzg)
  {
    if (TextUtils.isEmpty(paramapzg.a())) {
      QLog.d("QFlutter.ChannelManager", 1, "add channel channel name is emptyS");
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramapzg.a()))
      {
        apzg localapzg = (apzg)this.jdField_a_of_type_JavaUtilHashMap.remove(paramapzg.a());
        if (localapzg != null) {
          localapzg.a();
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramapzg.a(), paramapzg);
    } while (!QLog.isColorLevel());
    QLog.d("QFlutter.ChannelManager", 2, String.format("addChannel, channelName: %s", new Object[] { paramapzg.a() }));
  }
  
  private void b() {}
  
  private void c() {}
  
  public <T extends apzg> T a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (apzg)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apzi
 * JD-Core Version:    0.7.0.1
 */