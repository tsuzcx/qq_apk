import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.HashMap;

public class apzk
{
  private static apzk jdField_a_of_type_Apzk;
  private BinaryMessenger jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger;
  private HashMap<String, apzi> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static apzk a()
  {
    if (jdField_a_of_type_Apzk == null) {}
    try
    {
      if (jdField_a_of_type_Apzk == null) {
        jdField_a_of_type_Apzk = new apzk();
      }
      return jdField_a_of_type_Apzk;
    }
    finally {}
  }
  
  private void a()
  {
    a(new apzs("sso_channel", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new apzl("com.tencent.qflutter/apm", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new apzo("com.tencent.qflutter/scfsetting", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
  }
  
  private void a(apzi paramapzi)
  {
    if (TextUtils.isEmpty(paramapzi.a())) {
      QLog.d("QFlutter.ChannelManager", 1, "add channel channel name is emptyS");
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramapzi.a()))
      {
        apzi localapzi = (apzi)this.jdField_a_of_type_JavaUtilHashMap.remove(paramapzi.a());
        if (localapzi != null) {
          localapzi.a();
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramapzi.a(), paramapzi);
    } while (!QLog.isColorLevel());
    QLog.d("QFlutter.ChannelManager", 2, String.format("addChannel, channelName: %s", new Object[] { paramapzi.a() }));
  }
  
  private void b() {}
  
  private void c() {}
  
  public <T extends apzi> T a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (apzi)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
 * Qualified Name:     apzk
 * JD-Core Version:    0.7.0.1
 */