package com.tencent.luggage.wxa.ql;

import com.tencent.luggage.wxa.qz.o;

public class e
{
  public static int a(int paramInt)
  {
    o.d("MicroMsg.PlayerErrorHandler", "getErrCodeType, errorCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 66) && (paramInt != 67) && (paramInt != 69) && (paramInt != 70) && (paramInt != 74)) {
      if (paramInt != 80)
      {
        if (paramInt != 101)
        {
          if (paramInt == 102) {
            break label258;
          }
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    return -1;
                  }
                  break;
                }
                break;
              }
              return 10001;
            }
          case 53: 
          case 54: 
            return 10003;
          }
        }
        return 10004;
      }
      else
      {
        return 10002;
      }
    }
    label258:
    return 10001;
  }
  
  public static String b(int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("errCode:");
    localStringBuilder2.append(paramInt);
    localStringBuilder2.append(", err:");
    localStringBuilder1.append(localStringBuilder2.toString());
    if (paramInt != 66)
    {
      if (paramInt != 67)
      {
        if (paramInt != 69)
        {
          if (paramInt != 70)
          {
            if (paramInt != 74)
            {
              if (paramInt != 80)
              {
                if (paramInt != 101)
                {
                  if (paramInt != 102) {
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        switch (paramInt)
                        {
                        default: 
                          switch (paramInt)
                          {
                          default: 
                            switch (paramInt)
                            {
                            default: 
                              localStringBuilder1.append("unknow exception");
                              break;
                            case 707: 
                              localStringBuilder1.append("error, mmplayer create audio track orror");
                              break;
                            case 706: 
                              localStringBuilder1.append("error, mmplayer decode error");
                              break;
                            case 705: 
                              localStringBuilder1.append("error, mmplayer get audio info error");
                              break;
                            case 704: 
                              localStringBuilder1.append("error, mmplayer create MediaCode error");
                              break;
                            case 703: 
                              localStringBuilder1.append("error, mmplayer media format error");
                              break;
                            case 702: 
                              localStringBuilder1.append("error, mmplayer set source occur error");
                              break;
                            case 701: 
                              localStringBuilder1.append("error, invalid param");
                            }
                            break;
                          case 605: 
                            localStringBuilder1.append("error, invalid param");
                            break;
                          case 604: 
                            localStringBuilder1.append("error, invalid audioID");
                            break;
                          case 603: 
                            localStringBuilder1.append("error, ready exist audioId");
                            break;
                          case 602: 
                            localStringBuilder1.append("error, not found param");
                            break;
                          case 601: 
                            localStringBuilder1.append("error, not found audioId");
                            break;
                          case 600: 
                            localStringBuilder1.append("error create player fail, exceed max count audio players");
                          }
                          break;
                        case 504: 
                          localStringBuilder1.append("error player to stop");
                          break;
                        case 503: 
                          localStringBuilder1.append("error player to pause");
                          break;
                        case 502: 
                          localStringBuilder1.append("error player to start");
                          break;
                        case 501: 
                          localStringBuilder1.append("error player to prepare");
                          break;
                        case 500: 
                          localStringBuilder1.append("error URL format");
                        }
                        break;
                      case 64: 
                        localStringBuilder1.append("invalid audio info");
                        break;
                      case 63: 
                        localStringBuilder1.append("get audio info fail");
                        break;
                      case 62: 
                        localStringBuilder1.append("load or init native decode so fail");
                      }
                      break;
                    case 55: 
                      localStringBuilder1.append("unknow format");
                      break;
                    case 54: 
                      localStringBuilder1.append("file can not read");
                      break;
                    case 53: 
                      localStringBuilder1.append("file not found");
                      break;
                    }
                  } else {
                    localStringBuilder1.append("write AudioTrack data fail");
                  }
                }
                else {
                  localStringBuilder1.append("recognition audio format error");
                }
              }
              else {
                localStringBuilder1.append("connect network fail");
              }
            }
            else {
              localStringBuilder1.append("invalid seek or seek fail");
            }
          }
          else {
            localStringBuilder1.append("create temp file fail");
          }
        }
        else {
          localStringBuilder1.append("so file not found");
        }
      }
      else {
        localStringBuilder1.append("decode audio fail");
      }
    }
    else {
      localStringBuilder1.append("create AudioTrack fail");
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ql.e
 * JD-Core Version:    0.7.0.1
 */