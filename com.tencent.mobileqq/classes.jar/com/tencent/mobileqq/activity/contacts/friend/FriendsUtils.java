package com.tencent.mobileqq.activity.contacts.friend;

import com.tencent.mobileqq.friend.status.OnlineStatusIconHelper;

public class FriendsUtils
{
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    OnlineStatusIconHelper localOnlineStatusIconHelper = OnlineStatusIconHelper.a();
    if (paramInt1 == 0) {
      if ((paramInt2 != 69378) && (paramInt2 != 73474) && (paramInt2 != 73730))
      {
        if (1 != localOnlineStatusIconHelper.a(paramInt2, 1)) {
          return 2;
        }
      }
      else {
        return 0;
      }
    }
    if (1 != localOnlineStatusIconHelper.a(paramInt2, 1)) {
      if (paramInt3 != 1)
      {
        if (paramInt3 != 2)
        {
          paramInt2 = 3;
          if (paramInt3 != 3)
          {
            paramInt2 = 4;
            if (paramInt3 != 4)
            {
              if (paramInt3 != 7)
              {
                if (paramInt3 != 8)
                {
                  if (paramInt3 != 9)
                  {
                    if (paramInt3 != 12) {
                      break label121;
                    }
                    return 5;
                  }
                  return 9;
                }
                return 8;
              }
              return 7;
            }
          }
          return paramInt2;
        }
        else
        {
          return 2;
        }
      }
      else {
        return 1;
      }
    }
    label121:
    if ((paramInt3 == 7) || (paramInt3 == 8) || (paramInt3 == 9))
    {
      if (paramInt3 == 7) {
        break label165;
      }
      if (paramInt3 == 8) {
        break label162;
      }
      if (paramInt3 == 9) {}
    }
    else
    {
      return paramInt1;
    }
    return 9;
    label162:
    return 8;
    label165:
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendsUtils
 * JD-Core Version:    0.7.0.1
 */