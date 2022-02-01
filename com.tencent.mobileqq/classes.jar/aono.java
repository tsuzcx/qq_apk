import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class aono
{
  private static volatile aono jdField_a_of_type_Aono;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  public static aono a()
  {
    if (jdField_a_of_type_Aono == null) {}
    try
    {
      if (jdField_a_of_type_Aono == null) {
        jdField_a_of_type_Aono = new aono();
      }
      return jdField_a_of_type_Aono;
    }
    finally {}
  }
  
  private boolean a(BroadcastReceiver paramBroadcastReceiver, Context paramContext)
  {
    return (paramBroadcastReceiver == null) || (paramContext == null);
  }
  
  public Intent a(Context paramContext)
  {
    if (paramContext == null)
    {
      QLog.e("AVGameShareUtil", 1, "getBackFlowIntent error: context is null");
      return null;
    }
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("thridparty_prepare_av_game", true);
    paramContext.addFlags(67108864);
    paramContext.addFlags(268435456);
    paramContext.putExtra("fragment_id", 1);
    return paramContext;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      QLog.e("AVGameShareUtil", 1, "getCoverUrl error: map is null");
      return null;
    }
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    QLog.d("AVGameShareUtil", 1, "getCoverUrl gameId: " + paramString + " coverUrl: " + str);
    return str;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      QLog.e("AVGameShareUtil", 1, "clearCoverMap invalid: map is null");
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(Activity paramActivity, String paramString, int paramInt)
  {
    new aonm(paramActivity, paramString, paramInt).c();
  }
  
  public void a(BroadcastReceiver paramBroadcastReceiver, Context paramContext)
  {
    try
    {
      if (a(paramBroadcastReceiver, paramContext))
      {
        QLog.e("AVGameShareUtil", 2, "unregisterShareReceiver error: iLegalReceiver");
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        QLog.e("AVGameShareUtil", 2, "unregisterShareReceiver error: is registered");
        return;
      }
    }
    catch (Exception paramBroadcastReceiver)
    {
      QLog.e("AVGameShareUtil", 2, "registerShareReceiver error: " + paramBroadcastReceiver.getMessage());
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.app.avgameshare.avgameshareutil");
    paramContext.registerReceiver(paramBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (paramContext == null) {}
    try
    {
      QLog.e("AVGameShareUtil", 1, "notifyFromForward error: context is null");
      return;
    }
    catch (Exception paramContext)
    {
      Intent localIntent;
      QLog.e("AVGameShareUtil", 1, "notifyFromForward error: " + paramContext.getMessage());
    }
    localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.app.avgameshare.avgameshareutil");
    localIntent.putExtra("avgame_share_result_success", paramBoolean);
    localIntent.putExtra("avgame_share_result_type", paramInt);
    localIntent.setPackage(paramContext.getPackageName());
    paramContext.sendBroadcast(localIntent);
    return;
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {}
    try
    {
      QLog.e("AVGameShareUtil", 1, "notifyFromForward error: context is null");
      return;
    }
    catch (Exception paramContext)
    {
      Intent localIntent;
      QLog.e("AVGameShareUtil", 1, "notifyFromForward error: " + paramContext.getMessage());
    }
    localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.app.avgameshare.avgameshareutil");
    localIntent.putExtra("avgame_share_result_success", paramBoolean);
    localIntent.setPackage(paramContext.getPackageName());
    paramContext.sendBroadcast(localIntent);
    return;
  }
  
  public void a(AVGameAppInterface paramAVGameAppInterface, long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, aonu paramaonu)
  {
    QLog.d("AVGameShareUtil", 1, "requestGetShareLink roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString1 + " shareType: " + paramInt1 + " gameId: " + paramString2 + " gameType: " + paramInt2);
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    paramaonu = new aonr(this, l, localHashMap, paramAVGameAppInterface, paramaonu);
    localHashMap.put(Long.valueOf(l), paramaonu);
    paramAVGameAppInterface.addObserver(paramaonu);
    myk.a().a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, l);
  }
  
  public void a(AVGameAppInterface paramAVGameAppInterface, Activity paramActivity, long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt)
  {
    QLog.d("AVGameShareUtil", 1, "shareAVGameResultLink currentUin: " + paramLong2 + " roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString1 + " roundId: " + paramString2 + " gameType: " + paramInt);
    a(paramAVGameAppInterface, paramLong1, paramLong2, paramString1, 2, paramString2, paramInt, new aonq(this, paramActivity, paramLong2, paramLong1, paramInt, paramString1, paramString2));
  }
  
  public void a(AVGameAppInterface paramAVGameAppInterface, BaseActivity paramBaseActivity, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QLog.d("AVGameShareUtil", 1, "sinviteCallbackhareAVGameEntry currentUin: " + paramLong2 + " roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString + " gameSerType:" + paramInt);
    a(paramAVGameAppInterface, paramLong1, paramLong2, paramString, 1, "", paramInt, new aonp(this, paramBaseActivity, paramLong2, paramLong1, paramString));
  }
  
  public void a(AppInterface paramAppInterface, String paramString, aonu paramaonu)
  {
    QLog.d("AVGameShareUtil", 1, "requestGetInviteBackflowInfo key: " + paramString);
    mxc localmxc = (mxc)paramAppInterface.getManager(373);
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    paramaonu = new aons(this, l, localHashMap, paramAppInterface, paramaonu);
    localHashMap.put(Long.valueOf(l), paramaonu);
    paramAppInterface.addObserver(paramaonu);
    if (localmxc != null) {
      localmxc.a(paramString, l);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    QLog.d("AVGameShareUtil", 1, "requestShareUrlAndSendMsg roomId: " + paramLong1 + " curType: " + paramInt1 + " friendUin: " + paramString1 + " shareUin: " + paramLong2 + " shareName: " + paramString2 + " shareType: " + paramInt2 + " gameId: " + paramString3 + " gameType: " + paramInt3);
    mxc localmxc = (mxc)paramQQAppInterface.getManager(373);
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    paramString1 = new aont(this, l, localHashMap, paramQQAppInterface, paramInt1, paramString1, paramString2, paramLong2, paramLong1);
    localHashMap.put(Long.valueOf(l), paramString1);
    paramQQAppInterface.addObserver(paramString1);
    if (localmxc != null) {
      localmxc.a(paramLong1, paramLong2, paramString2, paramInt2, paramString3, paramInt3, l);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    QLog.d("AVGameShareUtil", 1, "addCoverUrl gameId: " + paramString1 + " coverUrl: " + paramString2);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void b(BroadcastReceiver paramBroadcastReceiver, Context paramContext)
  {
    try
    {
      if (a(paramBroadcastReceiver, paramContext))
      {
        QLog.e("AVGameShareUtil", 2, "unregisterShareReceiver error: iLegalReceiver");
        return;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        QLog.e("AVGameShareUtil", 2, "unregisterShareReceiver error: is not registered");
        return;
      }
    }
    catch (Exception paramBroadcastReceiver)
    {
      QLog.e("AVGameShareUtil", 2, "unregisterShareReceiver error: " + paramBroadcastReceiver.getMessage());
      return;
    }
    paramContext.unregisterReceiver(paramBroadcastReceiver);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aono
 * JD-Core Version:    0.7.0.1
 */