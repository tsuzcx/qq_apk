import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bhbt
{
  @Nullable
  public static Bitmap a(String paramString)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      Object localObject = BaseApplicationImpl.sImageCache.get(paramString);
      if ((localObject != null) && ((localObject instanceof Bitmap))) {
        return (Bitmap)localObject;
      }
      try
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inScaled = false;
        localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        BaseApplicationImpl.sImageCache.put(paramString, localObject);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("TroopGameCardUtil", 1, "getBitmap error " + paramString + localThrowable.getMessage());
        return null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardUtil", 2, "getImageBitmap fail: " + paramString);
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return null;
    case 2: 
      return anvx.a(2131693204);
    case 3: 
      return anvx.a(2131693210);
    case 4: 
      return anvx.a(2131693207);
    case 5: 
      return anvx.a(2131693209);
    case 6: 
      return anvx.a(2131693205);
    case 7: 
      return anvx.a(2131693211);
    }
    return anvx.a(2131693208);
  }
  
  public static String a(boolean paramBoolean)
  {
    String str = bgfz.a();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    if (paramBoolean) {
      return str + "member_game_card_bg_night.png";
    }
    return str + "member_game_card_bg.png";
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel invalid args");
      }
      return false;
    }
    if (bdfk.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel SimpleUI");
      }
      return false;
    }
    if (bdvn.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel StudyMode");
      }
      return false;
    }
    Object localObject = (bgft)aqxe.a().a(695);
    if ((localObject == null) || (!((bgft)localObject).a(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel configData is invalid");
      }
      return false;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return false;
    }
    TroopManager localTroopManager = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel manager is null");
      }
      return false;
    }
    localObject = localTroopManager.b(paramString1);
    if ((localObject == null) || (!((TroopInfo)localObject).isTroopGameCardEnabled()) || (((TroopInfo)localObject).isHomeworkTroop()))
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder().append("checkoutMsgShowGameGradeLevel troopInfo is");
        if (localObject != null) {
          break label231;
        }
      }
      label231:
      for (paramString1 = "null";; paramString1 = ((TroopInfo)localObject).toString())
      {
        QLog.d("TroopGameCardUtil", 2, paramString1);
        return false;
      }
    }
    if (paramString2.equals(localQQAppInterface.getCurrentAccountUin()))
    {
      if (!((TroopInfo)localObject).isShowMyGameCardEnabled()) {
        return false;
      }
    }
    else
    {
      paramString1 = localTroopManager.b(paramString1, paramString2);
      if ((paramString1 == null) || ((paramString1.cmduinFlagEx3Grocery & 1L) != 0L))
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder().append("checkoutMsgShowGameGradeLevel memberInfo");
          if (paramString1 != null) {
            break label324;
          }
        }
        label324:
        for (paramString1 = "is null";; paramString1 = "disable game member card")
        {
          QLog.d("TroopGameCardUtil", 2, paramString1);
          return false;
        }
      }
    }
    return true;
  }
  
  @Nullable
  public static String b(int paramInt)
  {
    if (paramInt / 100000 >= 8) {
      return null;
    }
    switch (paramInt % 100000 / 10000)
    {
    default: 
      return null;
    case 5: 
      return anvx.a(2131693225);
    case 9: 
      return anvx.a(2131693221);
    case 8: 
      return anvx.a(2131693222);
    case 7: 
      return anvx.a(2131693223);
    }
    return anvx.a(2131693224);
  }
  
  @Nullable
  public static String c(int paramInt)
  {
    String str1 = a(paramInt);
    if (!TextUtils.isEmpty(str1))
    {
      if (paramInt / 100000 >= 8)
      {
        if (paramInt >= 860050) {
          return anvx.a(2131693206);
        }
        return anvx.a(2131693203);
      }
      String str2 = b(paramInt);
      return str1 + str2 + anvx.a(2131693212);
    }
    return null;
  }
  
  @Nullable
  public static String d(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    String str = bgfz.a();
    if (TextUtils.isEmpty(str)) {
      return localObject2;
    }
    localObject2 = str + "game_grade_";
    switch (paramInt / 100000)
    {
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      return (String)localObject1 + ".png";
      localObject1 = (String)localObject2 + "1";
      continue;
      localObject1 = (String)localObject2 + "2";
      continue;
      localObject1 = (String)localObject2 + "3";
      continue;
      localObject1 = (String)localObject2 + "4";
      continue;
      localObject1 = (String)localObject2 + "5";
      continue;
      localObject1 = (String)localObject2 + "6";
      continue;
      if (paramInt % 100000 / 10000 >= 6) {
        localObject1 = (String)localObject2 + "8";
      } else {
        localObject1 = (String)localObject2 + "7";
      }
    }
  }
  
  @Nullable
  public static String e(int paramInt)
  {
    int i = paramInt / 100000;
    Object localObject1 = bgfz.a();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    Object localObject2 = (String)localObject1 + "game_grade_star";
    localObject1 = localObject2;
    switch (i)
    {
    default: 
      localObject1 = null;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (i != 8) {
        localObject2 = (String)localObject1 + String.valueOf(paramInt % 10000);
      }
      return (String)localObject2 + ".png";
      localObject1 = (String)localObject2 + "_3_";
      continue;
      localObject1 = (String)localObject2 + "_4_";
      continue;
      localObject1 = (String)localObject2 + "_5_";
    }
  }
  
  @Nullable
  public static String f(int paramInt)
  {
    int i = paramInt / 100000;
    String str = bgfz.a();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    str = str + "game_grade_number_";
    switch (i)
    {
    default: 
      str = null;
    }
    while (!TextUtils.isEmpty(str)) {
      switch (paramInt % 100000 / 10000)
      {
      default: 
        return null;
      case 5: 
        return str + "5.png";
        str = str + "1_";
        continue;
        str = str + "2_";
        continue;
        str = str + "3_";
        continue;
        str = str + "4_";
        continue;
        str = str + "5_";
        continue;
        str = str + "6_";
        break;
      case 9: 
        return str + "1.png";
      case 8: 
        return str + "2.png";
      case 7: 
        return str + "3.png";
      case 6: 
        return str + "4.png";
      }
    }
    return str;
  }
  
  @Nullable
  public static String g(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    String str = bgfz.a();
    str = str + "game_hero_skill_level_";
    if (TextUtils.isEmpty(str)) {
      return localObject2;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      return (String)localObject1 + ".png";
      localObject1 = str + "1";
      continue;
      localObject1 = str + "2";
      continue;
      localObject1 = str + "3";
      continue;
      localObject1 = str + "4";
      continue;
      localObject1 = str + "5";
    }
  }
  
  public static String h(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return anvx.a(2131693218);
    case 2: 
      return anvx.a(2131693219);
    case 3: 
      return anvx.a(2131693214);
    case 4: 
      return anvx.a(2131693216);
    case 5: 
      return anvx.a(2131693217);
    }
    return anvx.a(2131693215);
  }
  
  public static String i(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#66E6F0";
    case 2: 
      return "#66E6F0";
    case 3: 
      return "#C5DCFE";
    case 4: 
      return "#FFD5A6";
    case 5: 
      return "#94CBFB";
    case 6: 
      return "#BBA9F4";
    case 7: 
      return "#E0D4DC";
    }
    return "#FFBBA2";
  }
  
  public static String j(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#00D6E7";
    case 2: 
      return "#00D6E7";
    case 3: 
      return "#A1C6FE";
    case 4: 
      return "#FFBA6C";
    case 5: 
      return "#4FAAFA";
    case 6: 
      return "#8E71EE";
    case 7: 
      return "#CCB8C6";
    }
    return "#FF8F65";
  }
  
  public static String k(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#BAFAF6";
    case 2: 
      return "#BAFAF6";
    case 3: 
      return "#DBEAFF";
    case 4: 
      return "#FFF6C7";
    case 5: 
      return "#BBF5FF";
    case 6: 
      return "#DAD4FF";
    case 7: 
      return "#FAECF5";
    }
    return "#FFEED7";
  }
  
  public static String l(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#79F5EE";
    case 2: 
      return "#79F5EE";
    case 3: 
      return "#B8D4FE";
    case 4: 
      return "#FFEF90";
    case 5: 
      return "#7AEEFF";
    case 6: 
      return "#B6AAFF";
    case 7: 
      return "#F7DAED";
    }
    return "#FFDEB1";
  }
  
  public static String m(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#00D6E7";
    case 2: 
      return "#00D6E7";
    case 3: 
      return "#A1C6FE";
    case 4: 
      return "#FFBA6C";
    case 5: 
      return "#4FAAFA";
    case 6: 
      return "#8E71EE";
    case 7: 
      return "#CCB8C6";
    }
    return "#FF8F65";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbt
 * JD-Core Version:    0.7.0.1
 */