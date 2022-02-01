import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.VipUtils;
import java.util.ArrayList;

public class awgj
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
                                  return 2130850096;
                                }
                                if (paramLong2 == 1L) {
                                  return 2130850097;
                                }
                              } while (paramLong2 != 2L);
                              return 2130850098;
                              i = VipUtils.a(paramQQAppInterface, paramString, 3);
                              if (i != 1) {
                                break;
                              }
                              if (paramLong2 == 0L) {
                                return 2130840344;
                              }
                              if (paramLong2 == 1L) {
                                return 2130840345;
                              }
                            } while (paramLong2 != 2L);
                            return 2130840346;
                          } while (i != 2);
                          if (paramLong2 == 0L) {
                            return 2130840347;
                          }
                          if (paramLong2 == 1L) {
                            return 2130840348;
                          }
                        } while (paramLong2 != 2L);
                        return 2130840349;
                        i = VipUtils.a(paramQQAppInterface, paramString, 4);
                        if (i != 1) {
                          break;
                        }
                        if (paramLong2 == 0L) {
                          return 2130840350;
                        }
                        if (paramLong2 == 1L) {
                          return 2130840351;
                        }
                      } while (paramLong2 != 2L);
                      return 2130840352;
                    } while (i != 2);
                    if (paramLong2 == 0L) {
                      return 2130840353;
                    }
                    if (paramLong2 == 1L) {
                      return 2130840354;
                    }
                  } while (paramLong2 != 2L);
                  return 2130840355;
                  i = VipUtils.a(paramQQAppInterface, paramString, 0);
                  if (i != 1) {
                    break;
                  }
                  if (paramLong2 == 1L) {
                    return 2130850115;
                  }
                } while (paramLong2 != 2L);
                return 2130850071;
              } while (i != 2);
              if (paramLong2 == 1L) {
                return 2130850116;
              }
            } while (paramLong2 != 2L);
            return 2130850072;
            i = VipUtils.a(paramQQAppInterface, paramString, 1);
            if (i != 1) {
              break;
            }
            if (paramLong2 == 1L) {
              return 2130850119;
            }
          } while (paramLong2 != 2L);
          return 2130850075;
        } while (i != 2);
        if (paramLong2 == 1L) {
          return 2130850120;
        }
      } while (paramLong2 != 2L);
      return 2130850076;
      i = VipUtils.a(paramQQAppInterface, paramString, 5);
      if ((i == 1) && (paramLong2 == 1L)) {
        return 2130850108;
      }
      if ((i == 2) && (paramLong2 == 1L)) {
        return 2130850109;
      }
      if ((i == 3) && (paramLong2 == 1L)) {
        return 2130850110;
      }
    } while ((i != 4) || (paramLong2 != 1L));
    return 2130850107;
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
          str = awgl.a(paramString2, i, false);
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
      apyy localapyy;
      do
      {
        do
        {
          return paramString2;
          localObject = paramString2.split("/");
        } while (localObject.length < 2);
        localObject = localObject[(localObject.length - 2)];
        localapyy = apyz.a();
      } while ((localapyy == null) || (localapyy.a((String)localObject) <= 0));
      i = VipUtils.a(paramQQAppInterface, paramString1, 0);
    } while (i <= 0);
    return awgl.a(paramString2, i, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramFriends == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfByte.length > 1) {}
      for (paramFriends.relationIconFlag = (paramArrayOfByte[1] << 8 | paramArrayOfByte[0]); paramBoolean; paramFriends.relationIconFlag = paramArrayOfByte[0])
      {
        paramamsw.a(paramFriends);
        paramQQAppInterface.getBusinessHandler(1).notifyUI(3, true, paramString);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, String paramString, aucf paramaucf, ArrayList<awfu> paramArrayList) {}
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, StringBuilder paramStringBuilder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgj
 * JD-Core Version:    0.7.0.1
 */