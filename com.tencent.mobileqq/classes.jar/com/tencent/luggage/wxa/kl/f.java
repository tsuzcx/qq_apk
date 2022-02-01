package com.tencent.luggage.wxa.kl;

public class f
{
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 8)
      {
        if (paramInt != 19)
        {
          if (paramInt != 22)
          {
            if (paramInt != 34)
            {
              if (paramInt != 62)
              {
                if (paramInt != 133)
                {
                  if (paramInt != 256) {
                    return b(paramInt);
                  }
                  return "GATT CONN CANCEL ";
                }
                return "GATT ERROR";
              }
              return "GATT CONN FAIL ESTABLISH";
            }
            return "GATT CONN LMP TIMEOUT";
          }
          return "GATT CONN TERMINATE LOCAL HOST";
        }
        return "GATT CONN TERMINATE PEER USER";
      }
      return "GATT CONN TIMEOUT";
    }
    return "GATT CONN L2C FAILURE";
  }
  
  private static String b(int paramInt)
  {
    if (paramInt != 257)
    {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("UNKNOWN (");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(")");
            return localStringBuilder.toString();
          case 255: 
            return "GATT VALUE OUT OF RANGE";
          case 254: 
            return "GATT PROCEDURE IN PROGRESS";
          }
          return "GATT CCCD CFG ERROR";
        case 143: 
          return "GATT CONGESTED";
        case 142: 
          return "GATT NOT ENCRYPTED";
        case 141: 
          return "GATT ENCRYPTED NO MITM";
        case 140: 
          return "GATT SERVICE STARTED";
        case 139: 
          return "GATT INVALID CFG";
        case 138: 
          return "GATT MORE";
        case 137: 
          return "GATT AUTH FAIL";
        case 136: 
          return "GATT PENDING";
        case 135: 
          return "GATT ILLEGAL PARAMETER";
        case 134: 
          return "GATT CMD STARTED";
        case 133: 
          return "GATT ERROR";
        case 132: 
          return "GATT BUSY";
        case 131: 
          return "GATT DB FULL";
        case 130: 
          return "GATT WRONG STATE";
        case 129: 
          return "GATT INTERNAL ERROR";
        }
        return "GATT NO RESOURCES";
      case 17: 
        return "GATT INSUF RESOURCE";
      case 16: 
        return "GATT UNSUPPORT GRP TYPE";
      case 15: 
        return "GATT INSUF ENCRYPTION";
      case 14: 
        return "GATT ERR UNLIKELY";
      case 13: 
        return "GATT INVALID ATTR LEN";
      case 12: 
        return "GATT INSUF KEY SIZE";
      case 11: 
        return "GATT NOT LONG";
      case 10: 
        return "GATT NOT FOUND";
      case 9: 
        return "GATT PREPARE Q FULL";
      case 8: 
        return "GATT INSUF AUTHORIZATION";
      case 7: 
        return "GATT INVALID OFFSET";
      case 6: 
        return "GATT REQ NOT SUPPORTED";
      case 5: 
        return "GATT INSUF AUTHENTICATION";
      case 4: 
        return "GATT INVALID PDU";
      case 3: 
        return "GATT WRITE NOT PERMIT";
      case 2: 
        return "GATT READ NOT PERMIT";
      case 1: 
        return "GATT INVALID HANDLE";
      }
      return "GATT SUCCESS";
    }
    return "GATT FAILURE, TOO MANY OPEN CONNECTIONS";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kl.f
 * JD-Core Version:    0.7.0.1
 */