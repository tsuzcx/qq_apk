import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;

public class baor
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
        localObject1 = paramQQAppInterface.getFaceBitmap(11, paramString, (byte)3, true, 0);
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return bheg.a();
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
        localObject1 = FaceDrawable.getMobileFaceDrawable(paramQQAppInterface, paramString, (byte)3);
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return bheg.b();
  }
  
  public static PhoneContact a(QQAppInterface paramQQAppInterface, String paramString)
  {
    awyz localawyz = (awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (localawyz != null)
    {
      PhoneContact localPhoneContact = localawyz.c(paramString);
      azim localazim = azin.a(paramString);
      paramQQAppInterface = localPhoneContact;
      if (localPhoneContact == null) {
        paramQQAppInterface = localawyz.b(localazim.c);
      }
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramString = localawyz.b("+" + localazim.a + localazim.c);
      }
      paramQQAppInterface = paramString;
      if (paramString == null) {
        paramQQAppInterface = localawyz.b(localazim.a + localazim.c);
      }
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramString = localawyz.b("00" + localazim.a + localazim.c);
      }
      if (paramString == null) {
        return localawyz.b(localazim.a + "-" + localazim.c);
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
          localObject2 = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str);
          paramQQAppInterface = localObject3;
          if (localObject2 != null)
          {
            if ((((Friends)localObject2).remark == null) || (((Friends)localObject2).remark.length() <= 0)) {
              break label226;
            }
            paramQQAppInterface = ((Friends)localObject2).remark;
          }
          label178:
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
        label226:
        paramQQAppInterface = localObject3;
        if (((Friends)localObject2).name == null) {
          break label178;
        }
        paramQQAppInterface = localObject3;
        if (((Friends)localObject2).name.length() <= 0) {
          break label178;
        }
        paramQQAppInterface = ((Friends)localObject2).name;
        break label178;
        localObject1 = localObject2;
      }
      localObject1 = null;
    }
  }
  
  public static String a(String paramString)
  {
    azim localazim = azin.a(paramString);
    if (localazim.a.equals("86")) {
      paramString = localazim.c;
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
    bkzi localbkzi = bkzi.a(paramContext);
    localbkzi.a(2131689514);
    arrayOfInt[0] = 1;
    localbkzi.b(2131690690);
    localbkzi.c(2131690697);
    localbkzi.a(new baos());
    localbkzi.a(new baot(localbkzi, arrayOfInt, paramString, paramContext, paramQQAppInterface));
    localbkzi.show();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.c(paramString);; paramQQAppInterface = null) {
      return (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.uin));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baor
 * JD-Core Version:    0.7.0.1
 */