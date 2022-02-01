package com.tencent.av.tips.data;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class AVTipsItemFactory
{
  public static AvTipsItemBase a(int paramInt, VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {}
    Resources localResources;
    do
    {
      return null;
      localResources = paramVideoAppInterface.getApp().getResources();
      switch (paramInt)
      {
      }
    } while (!AudioHelper.d());
    paramVideoAppInterface = "CreatAvTipsItem,  未处理的tips类别，tipsID[" + paramInt + "]";
    QLog.d("AVTipsItemFactory", 1, paramVideoAppInterface);
    throw new IllegalArgumentException(paramVideoAppInterface);
    return new NormalAvTipsItem(paramInt, 8, 4, 0, "");
    return new NormalAvTipsItem(paramInt, 11, 3, 0, "", 1, "");
    return new NormalAvTipsItem(paramInt, 11, 3, 0, paramVideoAppInterface.getApp().getString(2131695406), 1, "");
    return new NormalAvTipsItem(paramInt, 11, 3, 0, "", 1, "");
    return new NormalAvTipsItem(paramInt, 99, 3, 0, paramVideoAppInterface.getApp().getString(2131695919));
    return new NormalAvTipsItem(paramInt, 15, 3, 0, paramVideoAppInterface.getApp().getString(2131695882));
    return new NormalAvTipsItem(paramInt, 15, 3, 0, paramVideoAppInterface.getApp().getString(2131695884));
    return new NormalAvTipsItem(paramInt, 9, 0, 0, "");
    return new NormalAvTipsItem(paramInt, 7, 5, 0, paramVideoAppInterface.getApp().getString(2131695958));
    return new NormalAvTipsItem(paramInt, 6, 4, 0, paramVideoAppInterface.getApp().getString(2131695823));
    return new NormalAvTipsItem(paramInt, 6, 0, 0, paramVideoAppInterface.getApp().getString(2131720565), 1, "");
    return new NormalAvTipsItem(paramInt, 3, 0, 0, paramVideoAppInterface.getApp().getString(2131695693), 1, "");
    return new NormalAvTipsItem(paramInt, 3, 3, 0, paramVideoAppInterface.getApp().getString(2131695895), 1, "");
    return new NormalAvTipsItem(paramInt, 7, 3, 0, "", 1, "");
    return new NormalAvTipsItem(paramInt, 7, 3, 0, "", 1, "");
    return new NormalAvTipsItem(paramInt, 4, 4, 0, paramVideoAppInterface.getApp().getString(2131695419), 1, "");
    return new NormalAvTipsItem(paramInt, 8, 3, 0, "");
    return new NormalAvTipsItem(paramInt, 8, 5, 0, "");
    return new NormalAvTipsItem(paramInt, 12, 3, 0, paramVideoAppInterface.getApp().getString(2131720539), 1, "");
    return new NormalAvTipsItem(paramInt, 12, 3, 0, paramVideoAppInterface.getApp().getString(2131695687), 1, "");
    return new NormalAvTipsItem(paramInt, 18, 0, 0, paramVideoAppInterface.getApp().getString(2131720556), 1, "");
    return new NormalAvTipsItem(paramInt, 12, 3, 0, paramVideoAppInterface.getApp().getString(2131695688));
    return new NormalAvTipsItem(paramInt, 12, 3, 0, paramVideoAppInterface.getApp().getString(2131695576), 1, "");
    return new NormalAvTipsItem(paramInt, 14, 5, 0, "");
    return new NormalAvTipsItem(paramInt, 14, 0, 0, "");
    paramVideoAppInterface = new HypeLinkAvTipsItem(paramInt, 13, 0, 1, "", 0, -1, null);
    paramVideoAppInterface.h = 13;
    return paramVideoAppInterface;
    return new WaitingAvTipsItem(paramInt, 2, 0, 0, paramVideoAppInterface.getApp().getString(2131695510), true);
    return new WaitingAvTipsItem(paramInt, 2, 0, 0, "", true);
    return new NormalAvTipsItem(paramInt, 17, 0, 0, paramVideoAppInterface.getApp().getString(2131695369));
    return new NormalAvTipsItem(paramInt, 18, 0, 0, paramVideoAppInterface.getApp().getString(2131695443), 1, "");
    return new WaitingAvTipsItem(paramInt, 10, 0, 0, paramVideoAppInterface.getApp().getString(2131695937), true);
    return new WaitingAvTipsItem(paramInt, 10, 3, 0, "", true);
    return new NormalAvTipsItem(paramInt, 8, 3, 0, "", 1, "");
    return new NormalAvTipsItem(paramInt, 8, 3, 0, localResources.getString(2131695446));
    paramVideoAppInterface = new HypeLinkAvTipsItem(paramInt, 8, 3, 1, localResources.getString(2131695447), 9, 5, null);
    paramVideoAppInterface.h = 15;
    return paramVideoAppInterface;
    return new NormalAvTipsItem(paramInt, 8, 5, 0, "");
    paramVideoAppInterface = new HypeLinkAvTipsItem(paramInt, 9, 5, 1, localResources.getString(2131695792), 0, 7, null);
    paramVideoAppInterface.h = 15;
    return paramVideoAppInterface;
    return new NormalAvTipsItem(paramInt, 2, 0, 0, paramVideoAppInterface.getApp().getString(2131695888));
    return new NormalAvTipsItem(paramInt, 10, 3, 0, "");
    return new NormalAvTipsItem(paramInt, 11, 10, 0, HardCodeUtil.a(2131700978));
    return new NormalAvTipsItem(paramInt, 10, 5, 0, HardCodeUtil.a(2131700979));
    return new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131700977), 1, "");
    return new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131700975), 1, "");
    return new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131700981), 1, "");
    return new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131700980), 1, "");
    return new NormalAvTipsItem(paramInt, 99, 3, 0, HardCodeUtil.a(2131700976), 1, "");
    return new NormalAvTipsItem(paramInt, 6, 3, 0, "", 1, "");
    return new NormalAvTipsItem(paramInt, 6, 3, 0, "", 1, "");
    return new NormalAvTipsItem(paramInt, 6, 3, 0, "", 1, "");
    return new NormalAvTipsItem(paramInt, 2, 3, 0, "");
    return new NormalAvTipsItem(paramInt, 2, 3, 0, "");
    return new NormalAvTipsItem(paramInt, 18, 0, 0, "");
    return new NormalAvTipsItem(paramInt, 15, 3, 0, paramVideoAppInterface.getApp().getString(2131691866), 1, "");
    return new NormalAvTipsItem(paramInt, 15, 3, 0, paramVideoAppInterface.getApp().getString(2131695407), 1, "");
    return new NormalAvTipsItem(paramInt, 16, 3, 0, paramVideoAppInterface.getApp().getString(2131695897));
    return new NormalAvTipsItem(paramInt, 10, 0, 0, paramVideoAppInterface.getApp().getString(2131695360), 1, "");
    return new NormalAvTipsItem(paramInt, 14, 3, 0, "", 1, "");
    return new NormalAvTipsItem(paramInt, 11, 3, 0, paramVideoAppInterface.getApp().getString(2131695923));
    return new NormalAvTipsItem(paramInt, 11, 0, 0, paramVideoAppInterface.getApp().getString(2131695894));
    return new NormalAvTipsItem(paramInt, 15, 3, 0, "");
    return new NormalAvTipsItem(paramInt, 15, 5, 0, "");
    return new NormalAvTipsItem(paramInt, 10, 0, 0, paramVideoAppInterface.getApp().getString(2131695444));
    return new WaitingAvTipsItem(paramInt, 16, 0, 0, paramVideoAppInterface.getApp().getString(2131695442), true);
    return new NormalAvTipsItem(paramInt, 10, 0, 0, paramVideoAppInterface.getApp().getString(2131695890), 1, "");
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
    AvTipsItemBase localAvTipsItemBase = a(paramInt1, paramVideoAppInterface);
    if (localAvTipsItemBase == null) {
      paramVideoAppInterface = null;
    }
    do
    {
      do
      {
        return paramVideoAppInterface;
        localAvTipsItemBase.a(paramString);
        if (paramInt3 > 0) {
          localAvTipsItemBase.a(paramInt3);
        }
        if (localAvTipsItemBase.a() == 1)
        {
          paramVideoAppInterface = (NormalAvTipsItem)localAvTipsItemBase;
          if (paramVideoAppInterface != null)
          {
            paramVideoAppInterface.b(paramInt2);
            paramVideoAppInterface.a(paramDrawable);
          }
        }
        paramVideoAppInterface = localAvTipsItemBase;
      } while (localAvTipsItemBase.a() != 3);
      paramString = (HypeLinkAvTipsItem)localAvTipsItemBase;
      paramVideoAppInterface = localAvTipsItemBase;
    } while (paramString == null);
    paramString.a(paramOnClickListener);
    return localAvTipsItemBase;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.tips.data.AVTipsItemFactory
 * JD-Core Version:    0.7.0.1
 */