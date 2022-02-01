package com.tencent.luggage.wxa.qm;

import com.tencent.luggage.wxa.qz.o;

public class b
{
  public static int a(int paramInt)
  {
    o.d("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != -4999)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case -4000: 
        return 10002;
      case -4001: 
        return 10004;
      }
      return 10001;
    }
    return -1;
  }
  
  public static String b(int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("errCode:");
    localStringBuilder2.append(paramInt);
    localStringBuilder2.append(", err:");
    localStringBuilder1.append(localStringBuilder2.toString());
    if (paramInt != -30)
    {
      if (paramInt != -3)
      {
        if (paramInt != -2)
        {
          if (paramInt != -1) {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  break;
                case -10: 
                  localStringBuilder1.append(" network respCode 403");
                  break;
                case -11: 
                  localStringBuilder1.append(" network respCode 404");
                  break;
                case -12: 
                  localStringBuilder1.append(" network respCode 500");
                  break;
                case -13: 
                  localStringBuilder1.append(" network respCode 502");
                }
                break;
              case -41: 
                localStringBuilder1.append("prepare error");
                break;
              case -42: 
                localStringBuilder1.append("stop error");
                break;
              case -43: 
                localStringBuilder1.append("error url format");
              }
              break;
            case -4001: 
              localStringBuilder1.append("UnrecognizedInputFormatException");
              break;
            case -4002: 
              localStringBuilder1.append("illegal state exception");
              break;
            case -4003: 
              localStringBuilder1.append("MediaCodec decoder init exception");
              break;
            case -4004: 
              localStringBuilder1.append("load error");
              break;
            }
          } else {
            localStringBuilder1.append("unknow exception");
          }
        }
        else {
          localStringBuilder1.append(" no network");
        }
      }
      else {
        localStringBuilder1.append("connect fail");
      }
    }
    else {
      localStringBuilder1.append(" network error");
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qm.b
 * JD-Core Version:    0.7.0.1
 */