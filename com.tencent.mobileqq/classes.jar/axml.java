import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.VipUtils;
import java.util.ArrayList;

public class axml
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    switch ((int)paramLong1)
    {
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  return 0;
                                } while (VipUtils.a(paramQQAppInterface, paramString, 2) <= 0);
                                if (paramLong2 == 0L) {
                                  return 2130850195;
                                }
                                if (paramLong2 == 1L) {
                                  return 2130850196;
                                }
                              } while (paramLong2 != 2L);
                              return 2130850197;
                              i = VipUtils.a(paramQQAppInterface, paramString, 3);
                              if (i != 1) {
                                break;
                              }
                              if (paramLong2 == 0L) {
                                return 2130840380;
                              }
                              if (paramLong2 == 1L) {
                                return 2130840381;
                              }
                            } while (paramLong2 != 2L);
                            return 2130840382;
                          } while (i != 2);
                          if (paramLong2 == 0L) {
                            return 2130840383;
                          }
                          if (paramLong2 == 1L) {
                            return 2130840384;
                          }
                        } while (paramLong2 != 2L);
                        return 2130840385;
                        i = VipUtils.a(paramQQAppInterface, paramString, 4);
                        if (i != 1) {
                          break;
                        }
                        if (paramLong2 == 0L) {
                          return 2130840386;
                        }
                        if (paramLong2 == 1L) {
                          return 2130840387;
                        }
                      } while (paramLong2 != 2L);
                      return 2130840388;
                    } while (i != 2);
                    if (paramLong2 == 0L) {
                      return 2130840389;
                    }
                    if (paramLong2 == 1L) {
                      return 2130840390;
                    }
                  } while (paramLong2 != 2L);
                  return 2130840391;
                  i = VipUtils.a(paramQQAppInterface, paramString, 0);
                  if (i != 1) {
                    break;
                  }
                  if (paramLong2 == 1L) {
                    return 2130850217;
                  }
                } while (paramLong2 != 2L);
                return 2130850164;
              } while (i != 2);
              if (paramLong2 == 1L) {
                return 2130850218;
              }
            } while (paramLong2 != 2L);
            return 2130850165;
            i = VipUtils.a(paramQQAppInterface, paramString, 1);
            if (i != 1) {
              break;
            }
            if (paramLong2 == 1L) {
              return 2130850221;
            }
          } while (paramLong2 != 2L);
          return 2130850168;
        } while (i != 2);
        if (paramLong2 == 1L) {
          return 2130850222;
        }
      } while (paramLong2 != 2L);
      return 2130850169;
      i = VipUtils.a(paramQQAppInterface, paramString, 5);
      if ((i == 1) && (paramLong2 == 1L)) {
        return 2130850210;
      }
      if ((i == 2) && (paramLong2 == 1L)) {
        return 2130850211;
      }
      if ((i == 3) && (paramLong2 == 1L)) {
        return 2130850212;
      }
    } while ((i != 4) || (paramLong2 != 1L));
    return 2130850209;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2)
  {
    int i;
    String str;
    if ((paramLong2 == 6L) && (paramLong3 > 0L))
    {
      i = VipUtils.a(paramQQAppInterface, paramString1, 0);
      str = paramString2;
      if (i > 0) {
        str = axmn.a(paramString2, i, false);
      }
    }
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString2;
        } while (paramLong2 <= 0L);
        str = paramString2;
      } while (paramLong1 != 5L);
      i = VipUtils.a(paramQQAppInterface, paramString1, 0);
      str = paramString2;
    } while (i <= 0);
    return axmn.a(paramLong1, i, paramLong2, false);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    int i;
    do
    {
      Object localObject;
      arcb localarcb;
      do
      {
        do
        {
          return paramString2;
          localObject = paramString2.split("/");
        } while (localObject.length < 2);
        localObject = localObject[(localObject.length - 2)];
        localarcb = arcc.a();
      } while ((localarcb == null) || (localarcb.a((String)localObject) <= 0));
      i = VipUtils.a(paramQQAppInterface, paramString1, 0);
    } while (i <= 0);
    return axmn.a(paramString2, i, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramFriends == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfByte.length > 1) {}
      for (paramFriends.relationIconFlag = (paramArrayOfByte[1] << 8 | paramArrayOfByte[0]); paramBoolean; paramFriends.relationIconFlag = paramArrayOfByte[0])
      {
        paramanvk.a(paramFriends);
        paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, paramString);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, String paramString, avhz paramavhz, ArrayList<axlw> paramArrayList) {}
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, StringBuilder paramStringBuilder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axml
 * JD-Core Version:    0.7.0.1
 */