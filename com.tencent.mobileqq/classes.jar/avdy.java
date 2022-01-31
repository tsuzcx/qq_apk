import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;

public class avdy
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
    return bbdr.a();
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
        localObject1 = baxt.b(paramQQAppInterface, paramString, (byte)3);
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return bbdr.b();
  }
  
  public static PhoneContact a(QQAppInterface paramQQAppInterface, String paramString)
  {
    askl localaskl = (askl)paramQQAppInterface.getManager(11);
    if (localaskl != null)
    {
      PhoneContact localPhoneContact = localaskl.c(paramString);
      aumb localaumb = aumc.a(paramString);
      paramQQAppInterface = localPhoneContact;
      if (localPhoneContact == null) {
        paramQQAppInterface = localaskl.b(localaumb.c);
      }
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramString = localaskl.b("+" + localaumb.a + localaumb.c);
      }
      paramQQAppInterface = paramString;
      if (paramString == null) {
        paramQQAppInterface = localaskl.b(localaumb.a + localaumb.c);
      }
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramString = localaskl.b("00" + localaumb.a + localaumb.c);
      }
      if (paramString == null) {
        return localaskl.b(localaumb.a + "-" + localaumb.c);
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
          localObject2 = ((ajxn)paramQQAppInterface.getManager(51)).e(str);
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
    aumb localaumb = aumc.a(paramString);
    if (localaumb.a.equals("86")) {
      paramString = localaumb.c;
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
    bfol localbfol = bfol.a(paramContext);
    localbfol.a(2131689581);
    arrayOfInt[0] = 1;
    localbfol.b(2131690587);
    localbfol.c(2131690596);
    localbfol.a(new avdz());
    localbfol.a(new avea(localbfol, arrayOfInt, paramString, paramContext, paramQQAppInterface));
    localbfol.show();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (askl)paramQQAppInterface.getManager(11);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.c(paramString);; paramQQAppInterface = null) {
      return (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.uin));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avdy
 * JD-Core Version:    0.7.0.1
 */