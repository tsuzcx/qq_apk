import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xd51.Oidb_0xd51.AioQuickAppData;

public class apin
{
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("sp_c2c_shortcut_bar", 4).edit();
    String str = "switcher_in_assistant_" + paramQQAppInterface.getCurrentUin();
    localEditor.putBoolean("has_set_switcher_in_assistant_" + paramQQAppInterface.getCurrentUin(), true);
    localEditor.putBoolean(str, paramBoolean);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarSwitcher", 2, new Object[] { "saveGlobalSwitcherStatus() isChecked = ", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarSwitcher", 2, new Object[] { "saveC2CSwitcherStatus() isChecked = ", Boolean.valueOf(paramBoolean), " friendUin = ", paramString });
    }
    amsw localamsw = (amsw)paramQQAppInterface.getManager(51);
    ExtensionInfo localExtensionInfo = localamsw.a(paramString, true);
    paramQQAppInterface = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramQQAppInterface = new ExtensionInfo();
      paramQQAppInterface.uin = paramString;
    }
    paramQQAppInterface.isAioShortcutBarOpen = paramBoolean;
    localamsw.a(paramQQAppInterface);
  }
  
  public static boolean a()
  {
    apif localapif = apig.a();
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarSwitcher", 2, new Object[] { "isKuoLieEnable() isKuoLieEnable = ", Boolean.valueOf(localapif.b()) });
    }
    return localapif.b();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_c2c_shortcut_bar", 4);
    String str = "switcher_in_assistant_" + paramQQAppInterface.getCurrentUin();
    if (localSharedPreferences.getBoolean("has_set_switcher_in_assistant_" + paramQQAppInterface.getCurrentUin(), false)) {}
    for (boolean bool = localSharedPreferences.getBoolean(str, true);; bool = apig.a().a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarSwitcher", 2, new Object[] { "isGlobalSwitcherOpen() switcherOpen = ", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((amsw)paramQQAppInterface.getManager(51)).a(paramString, true);
    if (paramQQAppInterface != null) {}
    for (boolean bool = paramQQAppInterface.isAioShortcutBarOpen;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarSwitcher", 2, "mAppInterface, type:" + paramString + " friendUin: isC2CShortcutBarOpen:" + bool);
      }
      return bool;
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarSwitcher", 2, "isC2CSwitcherOpen extensionInfo is null");
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 1) {
      return (b()) && (a(paramQQAppInterface)) && (a(paramQQAppInterface, paramString));
    }
    if (paramInt == 2) {
      return a();
    }
    QLog.d("C2CShortcutBarSwitcher", 1, new Object[] { "isC2CShortcutAppEnabled() unknown aioType:", Integer.valueOf(paramInt) });
    return false;
  }
  
  public static boolean a(PBBytesField paramPBBytesField)
  {
    paramPBBytesField = paramPBBytesField.get().toByteArray();
    Oidb_0xd51.AioQuickAppData localAioQuickAppData = new Oidb_0xd51.AioQuickAppData();
    try
    {
      localAioQuickAppData.mergeFrom(paramPBBytesField);
      int i = localAioQuickAppData.uint32_switch.get();
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarSwitcher", 2, new Object[] { "isC2CShortcutBarOpen: invoked status =", Integer.valueOf(i) });
      }
      return i == 1;
    }
    catch (Exception paramPBBytesField)
    {
      QLog.e("C2CShortcutBarSwitcher", 1, "isC2CShortcutBarOpen: failed. ", paramPBBytesField);
    }
    return false;
  }
  
  public static boolean b()
  {
    apif localapif = apig.a();
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarSwitcher", 2, new Object[] { "isShowGlobalEntrance() isShowAssistantEntrance = ", Boolean.valueOf(localapif.a()) });
    }
    return localapif.a();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return (b()) && (a(paramQQAppInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apin
 * JD-Core Version:    0.7.0.1
 */