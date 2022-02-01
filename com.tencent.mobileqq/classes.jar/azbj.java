import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import tencent.im.onlinestatus.OnlineStatusExtInfo.WeatherBizInfo;

public class azbj
{
  private bldo a = new bldo();
  
  public static int a()
  {
    int j;
    if (Build.VERSION.SDK_INT >= 21)
    {
      j = ((BatteryManager)BaseApplication.getContext().getSystemService("batterymanager")).getIntProperty(4);
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 2, new Object[] { "BatterManager ", Integer.valueOf(j) });
      }
    }
    for (int i = j;; i = 0)
    {
      j = i;
      if (i <= 0) {
        j = bhhr.H(BaseApplicationImpl.sApplication.getApplicationContext());
      }
      return j;
    }
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = 12;; paramInt = 24) {
      return AIOUtils.dp2px(paramInt, BaseApplicationImpl.getContext().getResources());
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1) {}
    for (int i = paramInt1 | 0x80;; i = paramInt1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 2, new Object[] { "OnlineStatusHelper ret:", Integer.valueOf(i), " batteryCapacity:", Integer.valueOf(paramInt1), " powerConectStatus:", Integer.valueOf(paramInt2) });
      }
      return i;
    }
  }
  
  private Drawable a(azbu paramazbu, @Nullable Friends paramFriends, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    int i = a(paramInt1);
    Object localObject1 = localObject2;
    if (paramazbu != null)
    {
      if (paramazbu.jdField_a_of_type_Int != 2) {
        break label55;
      }
      paramazbu = paramazbu.jdField_a_of_type_MqqAppAppRuntime$Status;
      if (paramInt2 != 1) {
        break label49;
      }
      paramInt1 = 0;
      localObject1 = azbo.a(paramazbu, paramInt1);
    }
    label49:
    label55:
    do
    {
      return localObject1;
      paramInt1 = i;
      break;
      if (!a(paramazbu)) {
        break label127;
      }
      if (a(paramFriends) > 0) {
        return this.a.a(a(paramFriends), paramInt1);
      }
      if (paramFriends == null) {
        break label104;
      }
      localObject1 = localObject2;
    } while (!a(paramFriends.uin));
    label104:
    paramazbu = URLDrawable.getDrawable(paramazbu.c, URLDrawable.URLDrawableOptions.obtain());
    paramazbu.setBounds(0, 0, i, i);
    return paramazbu;
    label127:
    if (paramazbu.jdField_a_of_type_Long == 1030L)
    {
      localObject1 = (arci)aqxe.a().a(652);
      if ((localObject1 == null) || (paramFriends == null)) {
        break label326;
      }
      localObject1 = ((arci)localObject1).a(paramFriends.weatherTypeId);
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 4, new Object[] { "weatherTypeId=", paramFriends.weatherTypeId });
      }
      if (localObject1 == null) {
        break label326;
      }
    }
    label326:
    for (paramFriends = ((azer)localObject1).d;; paramFriends = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 4, new Object[] { "URL=", paramFriends });
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      if (!TextUtils.isEmpty(paramFriends))
      {
        paramazbu = URLDrawable.getDrawable(paramFriends, (URLDrawable.URLDrawableOptions)localObject1);
        paramazbu.setBounds(0, 0, i, i);
        return paramazbu;
      }
      paramazbu = URLDrawable.getDrawable(paramazbu.c, (URLDrawable.URLDrawableOptions)localObject1);
      paramazbu.setBounds(0, 0, i, i);
      return paramazbu;
      paramazbu = URLDrawable.getDrawable(paramazbu.c, URLDrawable.URLDrawableOptions.obtain());
      paramazbu.setBounds(0, 0, i, i);
      return paramazbu;
    }
  }
  
  public static azbj a()
  {
    return azbl.a();
  }
  
  private String a(Friends paramFriends)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramFriends != null) && (a(paramFriends.uin))) {
      localObject1 = bhmx.a().a();
    }
    while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("在线")))
    {
      paramFriends = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
      if (TextUtils.isEmpty(paramFriends)) {
        break;
      }
      return paramFriends;
      localObject1 = localObject2;
      if (paramFriends != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramFriends.strTermDesc)) {
          localObject1 = paramFriends.strTermDesc;
        }
      }
    }
    return "手机";
  }
  
  public static int b()
  {
    int i = bhhr.I(BaseApplicationImpl.sApplication.getApplicationContext());
    int j = i;
    BatteryManager localBatteryManager;
    if (i == -1)
    {
      j = i;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localBatteryManager = (BatteryManager)BaseApplication.getContext().getSystemService("batterymanager");
        if (Build.VERSION.SDK_INT < 23) {
          break label129;
        }
      }
    }
    label129:
    for (boolean bool = localBatteryManager.isCharging();; bool = false)
    {
      int k = localBatteryManager.getIntProperty(6);
      if ((k == 2) || (k == 5) || (bool)) {}
      for (i = 1;; i = 0)
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("OnLineStatusHelper", 2, new Object[] { "BatterManager isCharging:", Boolean.valueOf(bool), " chargeStatus:", Integer.valueOf(k) });
          j = i;
        }
        return j;
      }
    }
  }
  
  /* Error */
  public static int c()
  {
    // Byte code:
    //   0: getstatic 25	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 21
    //   5: if_icmplt +121 -> 126
    //   8: invokestatic 31	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: ldc 33
    //   13: invokevirtual 37	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   16: checkcast 39	android/os/BatteryManager
    //   19: astore_3
    //   20: getstatic 25	android/os/Build$VERSION:SDK_INT	I
    //   23: bipush 23
    //   25: if_icmplt +96 -> 121
    //   28: aload_3
    //   29: invokevirtual 235	android/os/BatteryManager:isCharging	()Z
    //   32: istore_2
    //   33: aload_3
    //   34: bipush 6
    //   36: invokevirtual 43	android/os/BatteryManager:getIntProperty	(I)I
    //   39: istore_1
    //   40: iload_1
    //   41: iconst_2
    //   42: if_icmpeq +12 -> 54
    //   45: iload_1
    //   46: iconst_5
    //   47: if_icmpeq +7 -> 54
    //   50: iload_2
    //   51: ifeq +47 -> 98
    //   54: iconst_1
    //   55: istore_0
    //   56: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +37 -> 96
    //   62: ldc 51
    //   64: iconst_2
    //   65: iconst_4
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 248
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: iload_2
    //   77: invokestatic 242	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: aastore
    //   81: dup
    //   82: iconst_2
    //   83: ldc 244
    //   85: aastore
    //   86: dup
    //   87: iconst_3
    //   88: iload_1
    //   89: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: aastore
    //   93: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   96: iload_0
    //   97: ireturn
    //   98: iconst_0
    //   99: istore_0
    //   100: goto -44 -> 56
    //   103: astore_3
    //   104: iconst_0
    //   105: istore_0
    //   106: ldc 51
    //   108: iconst_1
    //   109: ldc 250
    //   111: aload_3
    //   112: invokestatic 254	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: iload_0
    //   116: ireturn
    //   117: astore_3
    //   118: goto -12 -> 106
    //   121: iconst_0
    //   122: istore_2
    //   123: goto -90 -> 33
    //   126: iconst_0
    //   127: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   55	61	0	i	int
    //   39	50	1	j	int
    //   32	91	2	bool	boolean
    //   19	15	3	localBatteryManager	BatteryManager
    //   103	9	3	localThrowable1	java.lang.Throwable
    //   117	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	33	103	java/lang/Throwable
    //   33	40	103	java/lang/Throwable
    //   56	96	117	java/lang/Throwable
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    AppRuntime.Status localStatus = paramQQAppInterface.getOnlineStatus();
    long l = paramQQAppInterface.getExtOnlineStatus();
    if ((localStatus == AppRuntime.Status.online) && (l == 1000L)) {
      return 1;
    }
    if ((localStatus == AppRuntime.Status.online) && (l == 1030L)) {
      return 4;
    }
    if ((localStatus == AppRuntime.Status.online) && (l == 1040L)) {
      return 3;
    }
    return 0;
  }
  
  public int a(Friends paramFriends)
  {
    if ((paramFriends == null) || (a(paramFriends.uin))) {
      return a();
    }
    return Math.max(0, Math.min(paramFriends.getBatteryCapacity(), 100));
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    long l2 = paramQQAppInterface.getExtOnlineStatus();
    long l1 = l2;
    if (l2 == -1L)
    {
      l2 = BaseApplicationImpl.getContext().getSharedPreferences("acc_info" + paramQQAppInterface.getCurrentAccountUin(), 0).getLong("getOnlineStatusExt", -1L);
      l1 = l2;
      if (l2 != -1L)
      {
        paramQQAppInterface.setExtOnlineStatus(l2);
        l1 = l2;
      }
    }
    return l1;
  }
  
  public Drawable a(long paramLong, AppRuntime.Status paramStatus, int paramInt, Friends paramFriends)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      azbu localazbu = a(AppRuntime.Status.online, paramLong);
      if (localazbu != null) {
        return a(localazbu, paramFriends, paramInt, 3);
      }
    }
    return azbo.a(paramStatus, a(paramInt));
  }
  
  public Drawable a(azbu paramazbu, Friends paramFriends)
  {
    return a(paramazbu, paramFriends, 0, 1);
  }
  
  public Bundle a(QQAppInterface paramQQAppInterface)
  {
    Bundle localBundle = new Bundle();
    int i = paramQQAppInterface.getBatteryCapacity();
    int j = paramQQAppInterface.getPowerConnect();
    int k = a(i, j);
    localBundle.putInt("BatteryInfo", k);
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusHelper", 2, new Object[] { "OnlineStatusHelper batteryCapacity:", Integer.valueOf(i), " powerConnect:", Integer.valueOf(j), " sendBattery:", Integer.valueOf(k) });
    }
    return localBundle;
  }
  
  public Bundle a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    int i = paramQQAppInterface.getBatteryCapacity();
    int j = paramQQAppInterface.getPowerConnect();
    int k = a(i, j);
    localBundle.putInt("BatteryInfo", k);
    localBundle.putBoolean("from_register", paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusHelper", 2, new Object[] { "buildSetBatteryData batteryCapacity:", Integer.valueOf(i), " powerConnect:", Integer.valueOf(j), " sendBattery:", Integer.valueOf(k), " fromRegister:", Boolean.valueOf(paramBoolean) });
    }
    return localBundle;
  }
  
  public Bundle a(Friends paramFriends)
  {
    Bundle localBundle = new Bundle();
    OnlineStatusExtInfo.WeatherBizInfo localWeatherBizInfo = new OnlineStatusExtInfo.WeatherBizInfo();
    if (!TextUtils.isEmpty(paramFriends.city)) {
      localWeatherBizInfo.string_city.set(paramFriends.city);
    }
    if (!TextUtils.isEmpty(paramFriends.area)) {
      localWeatherBizInfo.string_area.set(paramFriends.area);
    }
    if (!TextUtils.isEmpty(paramFriends.temper)) {
      localWeatherBizInfo.string_temper.set(paramFriends.temper);
    }
    if (!TextUtils.isEmpty(paramFriends.weatherType)) {
      localWeatherBizInfo.string_weather_type.set(paramFriends.weatherType);
    }
    if (!TextUtils.isEmpty(paramFriends.weatherTypeId)) {
      localWeatherBizInfo.string_weather_type_id.set(paramFriends.weatherTypeId);
    }
    try
    {
      i = Integer.valueOf(paramFriends.adCode).intValue();
      localWeatherBizInfo.uint32_adcode.set(i);
      localWeatherBizInfo.uint64_update_time.set(paramFriends.weatherUpdateTime);
      localWeatherBizInfo.uint32_flag.set(paramFriends.weatherFlag);
      localBundle.putByteArray("ExtInfo", localWeatherBizInfo.toByteArray());
      localBundle.putInt("StatusId", 1030);
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 2, "buildWeatherData ");
      }
      return localBundle;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnLineStatusHelper", 4, "number error", localNumberFormatException);
        }
        int i = 0;
      }
    }
  }
  
  public azbu a(AppRuntime.Status paramStatus, long paramLong)
  {
    return a(paramStatus, paramLong, false);
  }
  
  public azbu a(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean)
  {
    if (paramStatus == null)
    {
      localObject = Integer.valueOf(-1);
      QLog.d("OnLineStatusHelper", 1, new Object[] { "getOnlineStatusItem status=", localObject, " onlineStatusIDValue=", Long.valueOf(paramLong) });
      if ((paramStatus != AppRuntime.Status.online) || (paramLong <= 40000L)) {
        break label130;
      }
      localObject = (arci)aqxe.a().a(652);
      if (localObject == null) {
        break label130;
      }
      if (!paramBoolean) {
        break label119;
      }
    }
    label119:
    for (paramStatus = ((arci)localObject).b(paramStatus, paramLong);; paramStatus = ((arci)localObject).a(paramStatus, paramLong))
    {
      localObject = paramStatus;
      if (paramStatus == null) {
        localObject = new azbu(AppRuntime.Status.online);
      }
      return localObject;
      localObject = paramStatus;
      break;
    }
    label130:
    Object localObject = (arck)aqxe.a().a(578);
    if ((localObject != null) && (paramStatus == AppRuntime.Status.online)) {
      return ((arck)localObject).a(paramStatus, paramLong);
    }
    if (localObject != null) {
      return ((arck)localObject).a(paramStatus, 0L);
    }
    return new azbu(AppRuntime.Status.online);
  }
  
  public azfe a()
  {
    return azfe.a();
  }
  
  public String a(long paramLong, AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      if (paramLong == 1000L) {
        return "我的电量";
      }
      azbu localazbu = a(AppRuntime.Status.online, paramLong);
      if ((localazbu != null) && (!TextUtils.isEmpty(localazbu.b))) {
        return localazbu.b;
      }
    }
    return azbo.a(paramStatus);
  }
  
  public String a(QQAppInterface paramQQAppInterface, azbu paramazbu, AppRuntime.Status paramStatus, Friends paramFriends, TextView paramTextView, int paramInt)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      if (paramazbu.jdField_a_of_type_Long > 0L) {}
      for (boolean bool = true;; bool = false) {
        return a(paramQQAppInterface, paramFriends, paramTextView, 4, paramazbu, Boolean.valueOf(bool));
      }
    }
    return b(paramQQAppInterface, paramazbu, paramStatus, paramFriends, paramTextView, paramInt);
  }
  
  public String a(QQAppInterface paramQQAppInterface, Friends paramFriends, TextView paramTextView, int paramInt, azbu paramazbu, Boolean paramBoolean)
  {
    AppRuntime.Status localStatus = a().a(paramazbu);
    if (!Boolean.valueOf(a(paramazbu, paramFriends, paramBoolean.booleanValue())).booleanValue())
    {
      if (paramInt == 1) {}
      for (paramQQAppInterface = ContactUtils.getStatusName(paramFriends);; paramQQAppInterface = azch.b(paramFriends))
      {
        paramFriends = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          paramFriends = BaseApplicationImpl.getContext().getResources().getString(2131718977);
        }
        return paramFriends;
      }
    }
    return a().b(paramQQAppInterface, paramazbu, localStatus, paramFriends, paramTextView, paramInt);
  }
  
  public ArrayList<azbu> a()
  {
    arck localarck = (arck)aqxe.a().a(578);
    if (localarck != null) {
      return localarck.a();
    }
    return null;
  }
  
  public AppRuntime.Status a(azbu paramazbu)
  {
    if (paramazbu != null) {
      return paramazbu.jdField_a_of_type_MqqAppAppRuntime$Status;
    }
    return null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Friends paramFriends, TextView paramTextView, boolean paramBoolean)
  {
    Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
    if (paramFriends == null)
    {
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
    }
    int i = ContactUtils.getFriendStatus(paramFriends.detalStatusFlag, paramFriends.iTermType);
    boolean bool1;
    if (!paramQQAppInterface.getCurrentUin().equals(paramFriends.uin))
    {
      bool1 = true;
      paramQQAppInterface = a(AppRuntime.Status.online, paramFriends.uExtOnlineStatus, bool1);
      boolean bool2 = false;
      bool1 = bool2;
      if (!paramBoolean) {
        break label303;
      }
      bool1 = bool2;
      if (i != 4) {
        break label303;
      }
      bool1 = bool2;
      if (paramFriends.uExtOnlineStatus <= 0L) {
        break label303;
      }
      bool1 = bool2;
      if (paramQQAppInterface == null) {
        break label303;
      }
      if (!a(paramQQAppInterface)) {
        break label213;
      }
      if (a(paramFriends) <= 0) {
        break label207;
      }
      paramBoolean = true;
      label139:
      bool1 = paramBoolean;
      if (!paramBoolean) {
        break label303;
      }
      paramQQAppInterface = a(paramQQAppInterface, paramFriends);
      if (paramQQAppInterface == null) {
        break label274;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramTextView.setCompoundDrawablePadding(AIOUtils.dp2px(4.0F, BaseApplicationImpl.getContext().getResources()));
        paramTextView.setCompoundDrawables(paramQQAppInterface, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
        return;
        bool1 = false;
        break;
        label207:
        paramBoolean = false;
        break label139;
        label213:
        if (paramFriends.uExtOnlineStatus == 40001L)
        {
          paramBoolean = azch.b(paramQQAppInterface);
          break label139;
        }
        if (paramFriends.uExtOnlineStatus == 1040L)
        {
          paramBoolean = azch.b(paramFriends);
          break label139;
        }
        if (!a(paramQQAppInterface, paramFriends))
        {
          paramBoolean = true;
          break label139;
        }
        paramBoolean = false;
        break label139;
        label274:
        paramBoolean = false;
        continue;
      }
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
      label303:
      paramBoolean = bool1;
      paramQQAppInterface = null;
    }
  }
  
  public void a(Friends paramFriends, TextView paramTextView, boolean paramBoolean, azbu paramazbu)
  {
    Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
    if (paramBoolean)
    {
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
    }
    if ((ContactUtils.getFriendStatus(paramFriends.detalStatusFlag, paramFriends.iTermType) == 4) && (paramFriends.uExtOnlineStatus > 0L) && (paramazbu != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label124;
      }
      paramFriends = a().a(paramazbu, paramFriends);
      if (paramFriends == null) {
        break;
      }
      paramTextView.setCompoundDrawablePadding(AIOUtils.dp2px(4.0F, BaseApplicationImpl.getContext().getResources()));
      paramTextView.setCompoundDrawables(paramFriends, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
    }
    label124:
    paramTextView.setCompoundDrawablePadding(0);
    paramTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
  }
  
  public boolean a(azbu paramazbu)
  {
    return (paramazbu != null) && (paramazbu.jdField_a_of_type_Long == 1000L);
  }
  
  boolean a(azbu paramazbu, Friends paramFriends)
  {
    return (paramazbu.jdField_a_of_type_Long == 1030L) && (!azch.a(paramFriends));
  }
  
  public boolean a(azbu paramazbu, Friends paramFriends, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean)
    {
      bool = paramBoolean;
      if (azbu.a(paramazbu.jdField_a_of_type_Long)) {
        if (a().a(paramFriends) <= 0) {
          break label116;
        }
      }
    }
    label116:
    for (paramBoolean = true;; paramBoolean = false)
    {
      bool = paramBoolean;
      paramBoolean = bool;
      if (paramazbu.jdField_a_of_type_Long == 1030L)
      {
        paramBoolean = bool;
        if (!azch.a(paramFriends)) {
          paramBoolean = false;
        }
      }
      bool = paramBoolean;
      if (paramazbu.jdField_a_of_type_Long == 1040L)
      {
        bool = paramBoolean;
        if (!azch.b(paramFriends)) {
          bool = false;
        }
      }
      paramBoolean = bool;
      if (paramazbu.jdField_a_of_type_Long == 40001L)
      {
        paramBoolean = bool;
        if (!azch.b(paramazbu)) {
          paramBoolean = false;
        }
      }
      return paramBoolean;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, View paramView)
  {
    if (a(paramQQAppInterface, paramSessionInfo.curFriendUin))
    {
      paramView = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramSessionInfo.curFriendUin);
      boolean bool;
      if (!paramQQAppInterface.getCurrentUin().equals(paramSessionInfo.curFriendUin))
      {
        bool = true;
        paramQQAppInterface = a(AppRuntime.Status.online, paramView.uExtOnlineStatus, bool);
        if (paramQQAppInterface.jdField_a_of_type_Long != 1028L) {
          break label111;
        }
        if ((paramView != null) && (!TextUtils.isEmpty(paramView.songId))) {
          a().a(paramActivity, paramView.songId);
        }
      }
      label111:
      do
      {
        do
        {
          return true;
          bool = false;
          break;
          if (paramQQAppInterface.jdField_a_of_type_Long != 1030L) {
            break label208;
          }
          paramQQAppInterface = (arci)aqxe.a().a(652);
        } while ((paramQQAppInterface == null) || (paramQQAppInterface.a == null) || (TextUtils.isEmpty(paramQQAppInterface.a.a)));
        paramQQAppInterface = paramQQAppInterface.a.a + paramView.adCode;
        azes.a.a(paramActivity, paramQQAppInterface, 4014);
        azcl.a("0X800AF4C", 2);
        return true;
      } while (paramQQAppInterface.jdField_a_of_type_Long != 1040L);
      label208:
      azes.a.a(paramActivity, paramView.constellationJumpUrl, 4014);
      azcl.a("0X800AF4C", 1);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    boolean bool;
    if (!paramQQAppInterface.getCurrentUin().equals(paramString)) {
      bool = true;
    }
    while (localFriends != null)
    {
      paramQQAppInterface = a(AppRuntime.Status.online, localFriends.uExtOnlineStatus, bool);
      if (paramQQAppInterface.jdField_a_of_type_Long == 1028L)
      {
        return true;
        bool = false;
      }
      else
      {
        if (paramQQAppInterface.jdField_a_of_type_Long == 1030L) {
          return azch.a(localFriends);
        }
        if (paramQQAppInterface.jdField_a_of_type_Long == 1040L) {
          return azch.b(localFriends);
        }
      }
    }
    return false;
  }
  
  protected boolean a(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface)) {
      return false;
    }
    return ((QQAppInterface)localAppRuntime).getCurrentUin().equals(paramString);
  }
  
  public String b(long paramLong, AppRuntime.Status paramStatus)
  {
    azbu localazbu = a(AppRuntime.Status.online, paramLong);
    if (azch.b(localazbu)) {
      return localazbu.d;
    }
    return a(paramLong, paramStatus);
  }
  
  public String b(QQAppInterface paramQQAppInterface, azbu paramazbu, AppRuntime.Status paramStatus, Friends paramFriends, TextView paramTextView, int paramInt)
  {
    if ((paramStatus == AppRuntime.Status.online) && (paramazbu != null))
    {
      if ((paramazbu.jdField_a_of_type_Long == 1000L) && (paramFriends != null)) {
        if (paramQQAppInterface.getCurrentAccountUin().equals(paramFriends.uin)) {
          if (paramQQAppInterface.getPowerConnect() == 1) {
            paramQQAppInterface = paramQQAppInterface.getBatteryCapacity() + "% " + a(paramFriends) + "充电中";
          }
        }
      }
      do
      {
        return paramQQAppInterface;
        return paramQQAppInterface.getBatteryCapacity() + "% " + a(paramFriends) + "电量";
        if (a(paramFriends) > 0)
        {
          if (paramFriends.isBatteryCharging()) {
            return a(paramFriends) + "% " + a(paramFriends) + "充电中";
          }
          return a(paramFriends) + "% " + a(paramFriends) + "电量";
        }
        return ContactUtils.getStatusName(paramFriends);
        if ((paramazbu.jdField_a_of_type_Long == 1028L) && (paramFriends != null)) {
          return azfe.a(paramQQAppInterface, paramFriends, paramTextView);
        }
        if ((paramazbu.jdField_a_of_type_Long == 1030L) && (paramFriends != null)) {
          return azch.a(paramQQAppInterface, paramTextView, paramFriends, paramInt);
        }
        if ((paramazbu.jdField_a_of_type_Long != 1040L) || (paramFriends == null)) {
          break;
        }
        paramQQAppInterface = azeu.b(paramFriends);
        if (QLog.isColorLevel()) {
          QLog.d("OnLineStatusHelper", 2, new Object[] { "getAIOStatusName: invoked. ", " suitableTrend: ", paramQQAppInterface });
        }
      } while (azch.b(paramFriends));
      return "";
      if (paramazbu.jdField_a_of_type_Long > 40001L)
      {
        if (!TextUtils.isEmpty(paramazbu.b))
        {
          long l = paramFriends.autoStatusUpdateSecond;
          paramStatus = azch.a(NetConnInfoCenter.getServerTime(), l);
          QLog.d("OnLineStatusHelper", 1, new Object[] { "getAIOStatusName: invoked. [status-time] ", " passTimeStr: ", paramStatus, " autoStatusUpdateSecond: ", Long.valueOf(l), " extOnlineStatus.title: ", paramazbu.b, " friend.uin: ", paramFriends.uin, " during second: ", Long.valueOf(NetConnInfoCenter.getServerTime() - l) });
          if ((TextUtils.isEmpty(paramStatus)) || (paramQQAppInterface.getCurrentAccountUin().equals(paramFriends.uin))) {
            return paramazbu.b;
          }
          return paramazbu.b + String.format("(%s)", new Object[] { paramStatus });
        }
        return "";
      }
      if (paramazbu.jdField_a_of_type_Long == 40001L)
      {
        if (paramazbu.d == null) {
          return "";
        }
        return paramazbu.d;
      }
      if (!TextUtils.isEmpty(paramazbu.b)) {
        return paramazbu.b;
      }
    }
    return azbo.a(paramStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbj
 * JD-Core Version:    0.7.0.1
 */