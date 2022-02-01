import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.VipUtils;
import java.util.ArrayList;

public class axtc
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
                                  return 2130850178;
                                }
                                if (paramLong2 == 1L) {
                                  return 2130850179;
                                }
                              } while (paramLong2 != 2L);
                              return 2130850180;
                              i = VipUtils.a(paramQQAppInterface, paramString, 3);
                              if (i != 1) {
                                break;
                              }
                              if (paramLong2 == 0L) {
                                return 2130840306;
                              }
                              if (paramLong2 == 1L) {
                                return 2130840307;
                              }
                            } while (paramLong2 != 2L);
                            return 2130840308;
                          } while (i != 2);
                          if (paramLong2 == 0L) {
                            return 2130840309;
                          }
                          if (paramLong2 == 1L) {
                            return 2130840310;
                          }
                        } while (paramLong2 != 2L);
                        return 2130840311;
                        i = VipUtils.a(paramQQAppInterface, paramString, 4);
                        if (i != 1) {
                          break;
                        }
                        if (paramLong2 == 0L) {
                          return 2130840312;
                        }
                        if (paramLong2 == 1L) {
                          return 2130840313;
                        }
                      } while (paramLong2 != 2L);
                      return 2130840314;
                    } while (i != 2);
                    if (paramLong2 == 0L) {
                      return 2130840315;
                    }
                    if (paramLong2 == 1L) {
                      return 2130840316;
                    }
                  } while (paramLong2 != 2L);
                  return 2130840317;
                  i = VipUtils.a(paramQQAppInterface, paramString, 0);
                  if (i != 1) {
                    break;
                  }
                  if (paramLong2 == 1L) {
                    return 2130850194;
                  }
                } while (paramLong2 != 2L);
                return 2130850153;
              } while (i != 2);
              if (paramLong2 == 1L) {
                return 2130850195;
              }
            } while (paramLong2 != 2L);
            return 2130850154;
            i = VipUtils.a(paramQQAppInterface, paramString, 1);
            if (i != 1) {
              break;
            }
            if (paramLong2 == 1L) {
              return 2130850198;
            }
          } while (paramLong2 != 2L);
          return 2130850157;
        } while (i != 2);
        if (paramLong2 == 1L) {
          return 2130850199;
        }
      } while (paramLong2 != 2L);
      return 2130850158;
      i = VipUtils.a(paramQQAppInterface, paramString, 5);
      if ((i == 1) && (paramLong2 == 1L)) {
        return 2130850187;
      }
      if ((i == 2) && (paramLong2 == 1L)) {
        return 2130850188;
      }
      if ((i == 3) && (paramLong2 == 1L)) {
        return 2130850189;
      }
    } while ((i != 4) || (paramLong2 != 1L));
    return 2130850186;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2)
  {
    String str = paramString2;
    if (paramLong2 == 2L)
    {
      str = paramString2;
      if (paramLong3 > 0L)
      {
        int i = VipUtils.a(paramQQAppInterface, paramString1, 0);
        str = paramString2;
        if (i > 0) {
          str = axte.a(paramString2, i, false);
        }
      }
    }
    return str;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    int i;
    do
    {
      Object localObject;
      arfi localarfi;
      do
      {
        do
        {
          return paramString2;
          localObject = paramString2.split("/");
        } while (localObject.length < 2);
        localObject = localObject[(localObject.length - 2)];
        localarfi = arfj.a();
      } while ((localarfi == null) || (localarfi.a((String)localObject) <= 0));
      i = VipUtils.a(paramQQAppInterface, paramString1, 0);
    } while (i <= 0);
    return axte.a(paramString2, i, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramFriends == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfByte.length > 1) {}
      for (paramFriends.relationIconFlag = (paramArrayOfByte[1] << 8 | paramArrayOfByte[0]); paramBoolean; paramFriends.relationIconFlag = paramArrayOfByte[0])
      {
        paramanyw.a(paramFriends);
        paramQQAppInterface.a(1).notifyUI(3, true, paramString);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, String paramString, avpd paramavpd, ArrayList<axsn> paramArrayList) {}
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, StringBuilder paramStringBuilder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtc
 * JD-Core Version:    0.7.0.1
 */