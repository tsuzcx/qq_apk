import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;

public class aues
{
  public static Bitmap a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    QLog.d("OpenSDKUtils", 2, "getOpenSDKUserFaceBitmap phoneNumber = " + paramString);
    Object localObject2 = localObject1;
    if (paramQQAppInterface != null)
    {
      localObject2 = localObject1;
      if (paramString != null)
      {
        if (paramString.startsWith("+")) {
          break label55;
        }
        localObject2 = localObject1;
      }
    }
    label55:
    do
    {
      return localObject2;
      localObject1 = localObject3;
      if (a(paramQQAppInterface, paramString)) {
        localObject1 = paramQQAppInterface.a(11, paramString, (byte)3, true, 0);
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return bacm.a();
  }
  
  public static Drawable a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    QLog.d("OpenSDKUtils", 2, "getOpenSDKUserFaceBitmap phoneNumber = " + paramString);
    Object localObject2 = localObject1;
    if (paramQQAppInterface != null)
    {
      localObject2 = localObject1;
      if (paramString != null)
      {
        if (paramString.startsWith("+")) {
          break label55;
        }
        localObject2 = localObject1;
      }
    }
    label55:
    do
    {
      return localObject2;
      localObject1 = localObject3;
      if (a(paramQQAppInterface, paramString)) {
        localObject1 = azwp.b(paramQQAppInterface, paramString, (byte)3);
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return bacm.b();
  }
  
  public static PhoneContact a(QQAppInterface paramQQAppInterface, String paramString)
  {
    aroh localaroh = (aroh)paramQQAppInterface.getManager(11);
    if (localaroh != null)
    {
      PhoneContact localPhoneContact = localaroh.c(paramString);
      atod localatod = atoe.a(paramString);
      paramQQAppInterface = localPhoneContact;
      if (localPhoneContact == null) {
        paramQQAppInterface = localaroh.b(localatod.c);
      }
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramString = localaroh.b("+" + localatod.a + localatod.c);
      }
      paramQQAppInterface = paramString;
      if (paramString == null) {
        paramQQAppInterface = localaroh.b(localatod.a + localatod.c);
      }
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramString = localaroh.b("00" + localatod.a + localatod.c);
      }
      if (paramString == null) {
        return localaroh.b(localatod.a + "-" + localatod.c);
      }
      return paramString;
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    QLog.d("OpenSDKUtils", 2, "getOpenSDKUserDisplayName phoneNumber = " + paramString);
    if ((paramQQAppInterface == null) || (paramString == null) || (!paramString.startsWith("+")))
    {
      paramQQAppInterface = "";
      return paramQQAppInterface;
    }
    Object localObject2 = a(paramQQAppInterface, paramString);
    Object localObject1;
    if (localObject2 != null) {
      localObject1 = ((PhoneContact)localObject2).name;
    }
    for (String str = ((PhoneContact)localObject2).uin;; str = null)
    {
      QLog.d("OpenSDKUtils", 2, "getOpenSDKUserDisplayName contactName = " + (String)localObject1 + "uin = " + str);
      localObject2 = localObject4;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = localObject4;
        if (!str.equals("0"))
        {
          localObject2 = ((ajjj)paramQQAppInterface.getManager(51)).e(str);
          paramQQAppInterface = localObject3;
          if (localObject2 != null)
          {
            if ((((Friends)localObject2).remark == null) || (((Friends)localObject2).remark.length() <= 0)) {
              break label225;
            }
            paramQQAppInterface = ((Friends)localObject2).remark;
          }
          label177:
          QLog.d("OpenSDKUtils", 2, "getOpenSDKUserDisplayName FriendDisplayName = " + paramQQAppInterface);
          localObject2 = paramQQAppInterface;
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      for (;;)
      {
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        return a(paramString);
        label225:
        paramQQAppInterface = localObject3;
        if (((Friends)localObject2).name == null) {
          break label177;
        }
        paramQQAppInterface = localObject3;
        if (((Friends)localObject2).name.length() <= 0) {
          break label177;
        }
        paramQQAppInterface = ((Friends)localObject2).name;
        break label177;
        localObject1 = localObject2;
      }
      localObject1 = null;
    }
  }
  
  public static String a(String paramString)
  {
    atod localatod = atoe.a(paramString);
    if (localatod.a.equals("86")) {
      paramString = localatod.c;
    }
    return paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    QLog.d("OpenSDKUtils", 2, "enterActionSheet phoneNumber = " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 1;
    begr localbegr = begr.a(paramContext);
    localbegr.a(2131624041);
    arrayOfInt[0] = 1;
    localbegr.b(2131625026);
    localbegr.c(2131625035);
    localbegr.a(new auet());
    localbegr.a(new aueu(localbegr, arrayOfInt, paramString, paramContext, paramQQAppInterface));
    localbegr.show();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (aroh)paramQQAppInterface.getManager(11);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.c(paramString);; paramQQAppInterface = null) {
      return (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.uin));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aues
 * JD-Core Version:    0.7.0.1
 */