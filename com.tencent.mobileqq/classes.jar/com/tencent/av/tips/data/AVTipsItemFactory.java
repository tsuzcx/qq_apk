package com.tencent.av.tips.data;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class AVTipsItemFactory
{
  public static AvTipsItemBase a(int paramInt, VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return null;
    }
    Resources localResources = paramVideoAppInterface.getApp().getResources();
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          if (AudioHelper.a())
          {
            paramVideoAppInterface = new StringBuilder();
            paramVideoAppInterface.append("CreatAvTipsItem,  未处理的tips类别，tipsID[");
            paramVideoAppInterface.append(paramInt);
            paramVideoAppInterface.append("]");
            paramVideoAppInterface = paramVideoAppInterface.toString();
            QLog.d("AVTipsItemFactory", 1, paramVideoAppInterface);
            throw new IllegalArgumentException(paramVideoAppInterface);
          }
          break;
        case 3017: 
          paramVideoAppInterface = new WaitingAvTipsItem(paramInt, 13, 0, 0, paramVideoAppInterface.getApp().getString(2131893122), true);
          break;
        case 3016: 
          return new NormalAvTipsItem(paramInt, 19, 3, 0, paramVideoAppInterface.getApp().getString(2131893664));
        case 3015: 
          return new NormalAvTipsItem(paramInt, 19, 3, 0, paramVideoAppInterface.getApp().getString(2131893666));
        case 3014: 
          return new NormalAvTipsItem(paramInt, 19, 3, 0, paramVideoAppInterface.getApp().getString(2131893665));
        case 3013: 
          paramVideoAppInterface = new NormalAvTipsItem(paramInt, 13, 0, 0, paramVideoAppInterface.getApp().getString(2131893663), 1, "");
          break;
        case 3012: 
          paramVideoAppInterface = new WaitingAvTipsItem(paramInt, 19, 0, 0, paramVideoAppInterface.getApp().getString(2131893202), true);
          break;
        case 3011: 
          return new NormalAvTipsItem(paramInt, 13, 0, 0, paramVideoAppInterface.getApp().getString(2131893204));
        case 3010: 
          return new NormalAvTipsItem(paramInt, 18, 5, 0, "");
        case 3009: 
          return new NormalAvTipsItem(paramInt, 18, 3, 0, "");
        case 3008: 
          return new NormalAvTipsItem(paramInt, 14, 0, 0, paramVideoAppInterface.getApp().getString(2131893670));
        case 3007: 
          return new NormalAvTipsItem(paramInt, 14, 3, 0, paramVideoAppInterface.getApp().getString(2131893700));
        case 3006: 
          paramVideoAppInterface = new NormalAvTipsItem(paramInt, 17, 3, 0, "", 1, "");
          break;
        case 3005: 
          paramVideoAppInterface = new NormalAvTipsItem(paramInt, 13, 0, 0, paramVideoAppInterface.getApp().getString(2131893111), 1, "");
          break;
        case 3004: 
          return new NormalAvTipsItem(paramInt, 19, 3, 0, paramVideoAppInterface.getApp().getString(2131893673));
        case 3003: 
          paramVideoAppInterface = new NormalAvTipsItem(paramInt, 18, 3, 0, paramVideoAppInterface.getApp().getString(2131893163), 1, "");
          break;
        case 3002: 
          paramVideoAppInterface = new NormalAvTipsItem(paramInt, 18, 3, 0, paramVideoAppInterface.getApp().getString(2131888750), 1, "");
          break;
        case 3001: 
          return new NormalAvTipsItem(paramInt, 21, 0, 0, "");
        }
        break;
      case 1075: 
        return new NormalAvTipsItem(paramInt, 99, 3, 0, "");
      case 1074: 
        return new NormalAvTipsItem(paramInt, 7, 3, 0, paramVideoAppInterface.getApp().getString(2131893198));
      case 1073: 
        return new NormalAvTipsItem(paramInt, 7, 3, 0, paramVideoAppInterface.getApp().getString(2131893236));
      case 1072: 
        return new NormalAvTipsItem(paramInt, 7, 3, 0, paramVideoAppInterface.getApp().getString(2131887096));
      case 1071: 
        return new NormalAvTipsItem(paramInt, 7, 3, 0, paramVideoAppInterface.getApp().getString(2131887095));
      case 1070: 
        return new NormalAvTipsItem(paramInt, 99, 3, 0, paramVideoAppInterface.getApp().getString(2131887098));
      case 1069: 
        return new NormalAvTipsItem(paramInt, 7, 3, 0, paramVideoAppInterface.getApp().getString(2131887094));
      case 1068: 
        return new NormalAvTipsItem(paramInt, 7, 3, 0, paramVideoAppInterface.getApp().getString(2131887099));
      case 1067: 
        return new NormalAvTipsItem(paramInt, 7, 3, 0, paramVideoAppInterface.getApp().getString(2131887093));
      case 1066: 
        return new NormalAvTipsItem(paramInt, 7, 3, 0, paramVideoAppInterface.getApp().getString(2131893202));
      case 1065: 
        return new NormalAvTipsItem(paramInt, 7, 3, 0, paramVideoAppInterface.getApp().getString(2131887092));
      case 1064: 
        return new NormalAvTipsItem(paramInt, 7, 3, 0, paramVideoAppInterface.getApp().getString(2131887105));
      case 1063: 
        return new NormalAvTipsItem(paramInt, 7, 3, 0, paramVideoAppInterface.getApp().getString(2131887091));
      case 1062: 
        return new NormalAvTipsItem(paramInt, 7, 3, 0, paramVideoAppInterface.getApp().getString(2131887104));
      case 1061: 
        return new NormalAvTipsItem(paramInt, 18, 3, 0, paramVideoAppInterface.getApp().getString(2131893657));
      case 1060: 
        return new NormalAvTipsItem(paramInt, 2, 3, 0, "");
      case 1059: 
        return new NormalAvTipsItem(paramInt, 2, 3, 0, "");
      case 1058: 
        paramVideoAppInterface = new NormalAvTipsItem(paramInt, 6, 3, 0, "", 1, "");
        break;
      case 1057: 
        paramVideoAppInterface = new NormalAvTipsItem(paramInt, 6, 3, 0, "", 1, "");
        break;
      case 1056: 
        paramVideoAppInterface = new NormalAvTipsItem(paramInt, 6, 3, 0, "", 1, "");
        break;
      case 1055: 
        paramVideoAppInterface = new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131899136), 1, "");
        break;
      case 1054: 
        paramVideoAppInterface = new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131899140), 1, "");
        break;
      case 1053: 
        paramVideoAppInterface = new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131899141), 1, "");
        break;
      case 1052: 
        paramVideoAppInterface = new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131899135), 1, "");
        break;
      case 1051: 
        paramVideoAppInterface = new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131899137), 1, "");
        break;
      case 1050: 
        return new NormalAvTipsItem(paramInt, 13, 5, 0, HardCodeUtil.a(2131899139));
      case 1049: 
        return new NormalAvTipsItem(paramInt, 14, 10, 0, HardCodeUtil.a(2131899138));
      case 1048: 
        return new NormalAvTipsItem(paramInt, 13, 3, 0, "");
      case 1047: 
        return new NormalAvTipsItem(paramInt, 2, 0, 0, paramVideoAppInterface.getApp().getString(2131893661));
      }
    case 1045: 
      return new NormalAvTipsItem(paramInt, 11, 5, 0, "");
    case 1044: 
      paramVideoAppInterface = new HypeLinkAvTipsItem(paramInt, 11, 3, 0, localResources.getString(2131893210), 9, 5, null);
      paramVideoAppInterface.i = 14;
      break;
    case 1043: 
      return new NormalAvTipsItem(paramInt, 11, 3, 0, localResources.getString(2131893209));
    case 1042: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 11, 3, 0, "", 1, "");
      break;
    case 1041: 
      paramVideoAppInterface = new WaitingAvTipsItem(paramInt, 13, 3, 0, "", true);
      break;
    case 1040: 
      paramVideoAppInterface = new WaitingAvTipsItem(paramInt, 13, 0, 0, paramVideoAppInterface.getApp().getString(2131893714), true);
      paramVideoAppInterface.a(true);
      break;
    case 1039: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 21, 0, 0, paramVideoAppInterface.getApp().getString(2131893203), 1, "");
      break;
    case 1037: 
      paramVideoAppInterface = new WaitingAvTipsItem(paramInt, 2, 0, 0, "", true);
      break;
    case 1036: 
      paramVideoAppInterface = new WaitingAvTipsItem(paramInt, 2, 0, 0, paramVideoAppInterface.getApp().getString(2131893280), true);
      return paramVideoAppInterface;
    case 1035: 
      paramVideoAppInterface = new HypeLinkAvTipsItem(paramInt, 16, 0, 0, "", 0, -1, null);
      paramVideoAppInterface.i = 14;
      return paramVideoAppInterface;
    case 1034: 
      return new NormalAvTipsItem(paramInt, 17, 0, 0, "");
    case 1033: 
      return new NormalAvTipsItem(paramInt, 17, 5, 0, "");
    case 1032: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 15, 3, 0, paramVideoAppInterface.getApp().getString(2131893346), 1, "");
      break;
    case 1031: 
      return new NormalAvTipsItem(paramInt, 15, 3, 0, paramVideoAppInterface.getApp().getString(2131893461));
    case 1030: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 21, 0, 0, paramVideoAppInterface.getApp().getString(2131917906), 1, "");
      break;
    case 1029: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 15, 3, 0, paramVideoAppInterface.getApp().getString(2131893460), 1, "");
      break;
    case 1028: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 15, 3, 0, paramVideoAppInterface.getApp().getString(2131917889), 1, "");
      break;
    case 1026: 
      return new NormalAvTipsItem(paramInt, 11, 5, 0, "");
    case 1025: 
      return new NormalAvTipsItem(paramInt, 11, 3, 0, "");
    case 1024: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 4, 4, 0, paramVideoAppInterface.getApp().getString(2131893176), 1, "");
      break;
    case 1023: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 8, 3, 0, "", 1, "");
      break;
    case 1022: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 8, 3, 0, "", 1, "");
      break;
    case 1021: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 3, 3, 0, paramVideoAppInterface.getApp().getString(2131893671), 1, "");
      break;
    case 1020: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 3, 0, 0, paramVideoAppInterface.getApp().getString(2131893466), 1, "");
      break;
    case 1019: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 6, 0, 0, paramVideoAppInterface.getApp().getString(2131917915), 1, "");
      break;
    case 1018: 
      return new NormalAvTipsItem(paramInt, 6, 4, 0, paramVideoAppInterface.getApp().getString(2131893596));
    case 1017: 
      return new NormalAvTipsItem(paramInt, 8, 5, 0, paramVideoAppInterface.getApp().getString(2131893735));
    case 1016: 
      return new NormalAvTipsItem(paramInt, 12, 0, 0, "");
    case 1015: 
      return new NormalAvTipsItem(paramInt, 18, 3, 0, paramVideoAppInterface.getApp().getString(2131893655));
    case 1013: 
      return new NormalAvTipsItem(paramInt, 99, 3, 0, paramVideoAppInterface.getApp().getString(2131893696));
    case 1012: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 14, 3, 0, "", 1, "");
      break;
    case 1011: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 14, 3, 0, paramVideoAppInterface.getApp().getString(2131893162), 1, "");
      break;
    case 1010: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 14, 3, 0, "", 1, "");
      return paramVideoAppInterface;
    case 1008: 
      return new NormalAvTipsItem(paramInt, 11, 4, 0, "");
    }
    return null;
  }
  
  public static AvTipsItemBase a(int paramInt1, VideoAppInterface paramVideoAppInterface, int paramInt2)
  {
    paramVideoAppInterface = a(paramInt1, paramVideoAppInterface);
    if (paramVideoAppInterface == null) {
      return null;
    }
    paramVideoAppInterface.a(paramInt2);
    return paramVideoAppInterface;
  }
  
  public static AvTipsItemBase a(int paramInt, VideoAppInterface paramVideoAppInterface, String paramString)
  {
    paramVideoAppInterface = a(paramInt, paramVideoAppInterface);
    if (paramVideoAppInterface == null) {
      return null;
    }
    paramVideoAppInterface.a(paramString);
    return paramVideoAppInterface;
  }
  
  public static AvTipsItemBase a(int paramInt1, VideoAppInterface paramVideoAppInterface, String paramString, int paramInt2)
  {
    paramVideoAppInterface = a(paramInt1, paramVideoAppInterface);
    if (paramVideoAppInterface == null) {
      return null;
    }
    paramVideoAppInterface.a(paramString);
    paramVideoAppInterface.a(paramInt2);
    return paramVideoAppInterface;
  }
  
  public static AvTipsItemBase a(int paramInt1, VideoAppInterface paramVideoAppInterface, String paramString, int paramInt2, Drawable paramDrawable, int paramInt3, View.OnClickListener paramOnClickListener)
  {
    paramVideoAppInterface = a(paramInt1, paramVideoAppInterface);
    if (paramVideoAppInterface == null) {
      return null;
    }
    paramVideoAppInterface.a(paramString);
    if (paramInt3 > 0) {
      paramVideoAppInterface.a(paramInt3);
    }
    if (paramVideoAppInterface.a() == 1)
    {
      paramString = (NormalAvTipsItem)paramVideoAppInterface;
      if (paramString != null)
      {
        paramString.b(paramInt2);
        paramString.a(paramDrawable);
      }
    }
    if (paramVideoAppInterface.a() == 3)
    {
      paramString = (HypeLinkAvTipsItem)paramVideoAppInterface;
      if (paramString != null) {
        paramString.a(paramOnClickListener);
      }
    }
    return paramVideoAppInterface;
  }
  
  public static AvTipsItemBase a(int paramInt1, VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, int paramInt2, Drawable paramDrawable, int paramInt3, View.OnClickListener paramOnClickListener)
  {
    paramVideoAppInterface = a(paramInt1, paramVideoAppInterface);
    if (paramVideoAppInterface == null) {
      return null;
    }
    if (paramInt3 > 0) {
      paramVideoAppInterface.a(paramInt3);
    }
    if (paramVideoAppInterface.a() == 1)
    {
      NormalAvTipsItem localNormalAvTipsItem = (NormalAvTipsItem)paramVideoAppInterface;
      if (localNormalAvTipsItem != null)
      {
        localNormalAvTipsItem.b(paramInt2);
        localNormalAvTipsItem.a(paramDrawable);
      }
    }
    if (paramVideoAppInterface.a() == 3)
    {
      paramDrawable = (HypeLinkAvTipsItem)paramVideoAppInterface;
      if (paramDrawable != null)
      {
        paramDrawable.a(paramOnClickListener);
        paramOnClickListener = new StringBuilder();
        paramOnClickListener.append(paramString1);
        paramOnClickListener.append(" ");
        paramOnClickListener.append(paramString2);
        paramDrawable.a(paramOnClickListener.toString());
        paramDrawable.i = 14;
        paramDrawable.h = paramString2.length();
        paramDrawable.g = (paramString1.length() + 1);
      }
    }
    return paramVideoAppInterface;
  }
  
  public static AvTipsItemBase a(String paramString1, String paramString2, VideoAppInterface paramVideoAppInterface, View.OnClickListener paramOnClickListener, int paramInt)
  {
    paramVideoAppInterface = new StringBuilder();
    paramVideoAppInterface.append(paramString1);
    paramVideoAppInterface.append(" ");
    paramVideoAppInterface.append(paramString2);
    paramString1 = new HypeLinkAvTipsItem(1075, 3, 5, 0, paramVideoAppInterface.toString(), paramString1.length() + 1, paramString2.length(), paramOnClickListener);
    paramString1.i = 14;
    paramString1.a(paramInt);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.data.AVTipsItemFactory
 * JD-Core Version:    0.7.0.1
 */