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
      case 3016: 
        return new NormalAvTipsItem(paramInt, 16, 3, 0, paramVideoAppInterface.getApp().getString(2131695903));
      case 3015: 
        return new NormalAvTipsItem(paramInt, 16, 3, 0, paramVideoAppInterface.getApp().getString(2131695905));
      case 3014: 
        return new NormalAvTipsItem(paramInt, 16, 3, 0, paramVideoAppInterface.getApp().getString(2131695904));
      case 3013: 
        paramVideoAppInterface = new NormalAvTipsItem(paramInt, 10, 0, 0, paramVideoAppInterface.getApp().getString(2131695902), 1, "");
        break;
      case 3012: 
        paramVideoAppInterface = new WaitingAvTipsItem(paramInt, 16, 0, 0, paramVideoAppInterface.getApp().getString(2131695452), true);
        break;
      case 3011: 
        return new NormalAvTipsItem(paramInt, 10, 0, 0, paramVideoAppInterface.getApp().getString(2131695454));
      case 3010: 
        return new NormalAvTipsItem(paramInt, 15, 5, 0, "");
      case 3009: 
        return new NormalAvTipsItem(paramInt, 15, 3, 0, "");
      case 3008: 
        return new NormalAvTipsItem(paramInt, 11, 0, 0, paramVideoAppInterface.getApp().getString(2131695909));
      case 3007: 
        return new NormalAvTipsItem(paramInt, 11, 3, 0, paramVideoAppInterface.getApp().getString(2131695938));
      case 3006: 
        paramVideoAppInterface = new NormalAvTipsItem(paramInt, 14, 3, 0, "", 1, "");
        break;
      case 3005: 
        paramVideoAppInterface = new NormalAvTipsItem(paramInt, 10, 0, 0, paramVideoAppInterface.getApp().getString(2131695370), 1, "");
        break;
      case 3004: 
        return new NormalAvTipsItem(paramInt, 16, 3, 0, paramVideoAppInterface.getApp().getString(2131695912));
      case 3003: 
        paramVideoAppInterface = new NormalAvTipsItem(paramInt, 15, 3, 0, paramVideoAppInterface.getApp().getString(2131695417), 1, "");
        break;
      case 3002: 
        paramVideoAppInterface = new NormalAvTipsItem(paramInt, 15, 3, 0, paramVideoAppInterface.getApp().getString(2131691788), 1, "");
        break;
      case 3001: 
        return new NormalAvTipsItem(paramInt, 18, 0, 0, "");
      }
    case 1061: 
      return new NormalAvTipsItem(paramInt, 15, 3, 0, paramVideoAppInterface.getApp().getString(2131695896));
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
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131701119), 1, "");
      break;
    case 1054: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131701123), 1, "");
      break;
    case 1053: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131701124), 1, "");
      break;
    case 1052: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131701118), 1, "");
      break;
    case 1051: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131701120), 1, "");
      break;
    case 1050: 
      return new NormalAvTipsItem(paramInt, 10, 5, 0, HardCodeUtil.a(2131701122));
    case 1049: 
      return new NormalAvTipsItem(paramInt, 11, 10, 0, HardCodeUtil.a(2131701121));
    case 1048: 
      return new NormalAvTipsItem(paramInt, 10, 3, 0, "");
    case 1047: 
      return new NormalAvTipsItem(paramInt, 2, 0, 0, paramVideoAppInterface.getApp().getString(2131695900));
    case 1046: 
      paramVideoAppInterface = new HypeLinkAvTipsItem(paramInt, 9, 5, 1, localResources.getString(2131695806), 0, 7, null);
      paramVideoAppInterface.h = 15;
      break;
    case 1045: 
      return new NormalAvTipsItem(paramInt, 8, 5, 0, "");
    case 1044: 
      paramVideoAppInterface = new HypeLinkAvTipsItem(paramInt, 8, 3, 1, localResources.getString(2131695457), 9, 5, null);
      paramVideoAppInterface.h = 15;
      return paramVideoAppInterface;
    case 1043: 
      return new NormalAvTipsItem(paramInt, 8, 3, 0, localResources.getString(2131695456));
    case 1042: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 8, 3, 0, "", 1, "");
      break;
    case 1041: 
      paramVideoAppInterface = new WaitingAvTipsItem(paramInt, 10, 3, 0, "", true);
      break;
    case 1040: 
      paramVideoAppInterface = new WaitingAvTipsItem(paramInt, 10, 0, 0, paramVideoAppInterface.getApp().getString(2131695952), true);
      break;
    case 1039: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 18, 0, 0, paramVideoAppInterface.getApp().getString(2131695453), 1, "");
      break;
    case 1037: 
      paramVideoAppInterface = new WaitingAvTipsItem(paramInt, 2, 0, 0, "", true);
      break;
    case 1036: 
      paramVideoAppInterface = new WaitingAvTipsItem(paramInt, 2, 0, 0, paramVideoAppInterface.getApp().getString(2131695521), true);
      return paramVideoAppInterface;
    case 1035: 
      paramVideoAppInterface = new HypeLinkAvTipsItem(paramInt, 13, 0, 1, "", 0, -1, null);
      paramVideoAppInterface.h = 13;
      return paramVideoAppInterface;
    case 1034: 
      return new NormalAvTipsItem(paramInt, 14, 0, 0, "");
    case 1033: 
      return new NormalAvTipsItem(paramInt, 14, 5, 0, "");
    case 1032: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 12, 3, 0, paramVideoAppInterface.getApp().getString(2131695587), 1, "");
      break;
    case 1031: 
      return new NormalAvTipsItem(paramInt, 12, 3, 0, paramVideoAppInterface.getApp().getString(2131695702));
    case 1030: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 18, 0, 0, paramVideoAppInterface.getApp().getString(2131720271), 1, "");
      break;
    case 1029: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 12, 3, 0, paramVideoAppInterface.getApp().getString(2131695701), 1, "");
      break;
    case 1028: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 12, 3, 0, paramVideoAppInterface.getApp().getString(2131720254), 1, "");
      break;
    case 1026: 
      return new NormalAvTipsItem(paramInt, 8, 5, 0, "");
    case 1025: 
      return new NormalAvTipsItem(paramInt, 8, 3, 0, "");
    case 1024: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 4, 4, 0, paramVideoAppInterface.getApp().getString(2131695429), 1, "");
      break;
    case 1023: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 7, 3, 0, "", 1, "");
      break;
    case 1022: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 7, 3, 0, "", 1, "");
      break;
    case 1021: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 3, 3, 0, paramVideoAppInterface.getApp().getString(2131695910), 1, "");
      break;
    case 1020: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 3, 0, 0, paramVideoAppInterface.getApp().getString(2131695707), 1, "");
      break;
    case 1019: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 6, 0, 0, paramVideoAppInterface.getApp().getString(2131720280), 1, "");
      break;
    case 1018: 
      return new NormalAvTipsItem(paramInt, 6, 4, 0, paramVideoAppInterface.getApp().getString(2131695837));
    case 1017: 
      return new NormalAvTipsItem(paramInt, 7, 5, 0, paramVideoAppInterface.getApp().getString(2131695973));
    case 1016: 
      return new NormalAvTipsItem(paramInt, 9, 0, 0, "");
    case 1015: 
      return new NormalAvTipsItem(paramInt, 15, 3, 0, paramVideoAppInterface.getApp().getString(2131695894));
    case 1013: 
      return new NormalAvTipsItem(paramInt, 99, 3, 0, paramVideoAppInterface.getApp().getString(2131695934));
    case 1012: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 11, 3, 0, "", 1, "");
      break;
    case 1011: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 11, 3, 0, paramVideoAppInterface.getApp().getString(2131695416), 1, "");
      break;
    case 1010: 
      paramVideoAppInterface = new NormalAvTipsItem(paramInt, 11, 3, 0, "", 1, "");
      return paramVideoAppInterface;
    case 1008: 
      return new NormalAvTipsItem(paramInt, 8, 4, 0, "");
    }
    return null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.data.AVTipsItemFactory
 * JD-Core Version:    0.7.0.1
 */