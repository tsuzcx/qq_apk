package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class PokeItemAnimationManager
{
  public static final String b = VFSAssistantUtils.getSDKPrivatePath("Tencent/MobileQQ/poke/");
  public static final String c;
  public static long j = 1500L;
  public static long k = 0L;
  private static PokeItemAnimationManager l;
  public Handler a;
  public HandlerThread d = null;
  public MqqHandler e = null;
  public HandlerThread f = null;
  public MqqHandler g = null;
  PokeItemAnimationManager.DoubleHitInfo[] h = null;
  HashMap<String, PokeItemAnimationManager.AioInfo> i = new HashMap();
  private ArrayList[] m = new ArrayList[6];
  private ArrayList[] n = new ArrayList[6];
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("/dazhao_motion/dazhao_move.png");
    c = localStringBuilder.toString();
  }
  
  private PokeItemAnimationManager()
  {
    int i2 = 0;
    int i1 = 0;
    for (;;)
    {
      localObject = this.m;
      if (i1 >= localObject.length) {
        break;
      }
      localObject[i1] = null;
      i1 += 1;
    }
    i1 = 0;
    for (;;)
    {
      localObject = this.n;
      if (i1 >= localObject.length) {
        break;
      }
      localObject[i1] = null;
      i1 += 1;
    }
    this.h = new PokeItemAnimationManager.DoubleHitInfo[6];
    Object localObject = this.h;
    int i3 = localObject.length;
    i1 = i2;
    while (i1 < i3)
    {
      PokeItemAnimationManager.DoubleHitInfo localDoubleHitInfo = localObject[i1];
      localDoubleHitInfo = new PokeItemAnimationManager.DoubleHitInfo(this);
      localDoubleHitInfo.a = 1;
      localDoubleHitInfo.b = -1L;
      i1 += 1;
    }
    this.f = new HandlerThread("PokeAIOAnimThread");
    this.f.start();
    this.g = new MqqHandler(this.f.getLooper());
  }
  
  private void a(String paramString, Context paramContext)
  {
    File localFile = new File(paramString);
    if ((localFile.exists()) && (localFile.isDirectory()))
    {
      String[] arrayOfString = localFile.list();
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("deal current file:");
          ((StringBuilder)localObject1).append(str);
          QLog.d("LzmaUtils", 2, ((StringBuilder)localObject1).toString());
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append(str);
        if (new File(((StringBuilder)localObject1).toString()).isDirectory())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("/");
          ((StringBuilder)localObject1).append(str);
          a(((StringBuilder)localObject1).toString(), paramContext);
        }
        else if (str.endsWith("7z"))
        {
          localObject1 = str.split("\\.")[0];
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("dirName:");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("LzmaUtils", 2, ((StringBuilder)localObject2).toString());
          }
          Object localObject2 = new File(localFile, (String)localObject1);
          if (((File)localObject2).exists()) {
            FileUtils.delete((String)localObject1, false);
          }
          ((File)localObject2).mkdir();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("/");
          ((StringBuilder)localObject1).append(str);
          LzmaUtils.a(paramContext, ((StringBuilder)localObject1).toString(), ((File)localObject2).getAbsolutePath());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("/");
          ((StringBuilder)localObject1).append(str);
          FileUtils.delete(((StringBuilder)localObject1).toString(), true);
        }
        i1 += 1;
      }
    }
  }
  
  private boolean a(AppInterface paramAppInterface, String paramString, int paramInt1, PokeItemAnimationManager.AioInfo paramAioInfo, PokeItemAnimationManager.StrengthInfo[] paramArrayOfStrengthInfo, int paramInt2, int paramInt3)
  {
    long l1 = SystemClock.uptimeMillis();
    if (paramArrayOfStrengthInfo[paramInt3] == null)
    {
      paramArrayOfStrengthInfo[paramInt3] = new PokeItemAnimationManager.StrengthInfo(this);
      paramArrayOfStrengthInfo[paramInt3].a = 0;
      paramArrayOfStrengthInfo[paramInt3].b = 0;
      paramArrayOfStrengthInfo[paramInt3].c = -1L;
    }
    if (paramInt1 != -1)
    {
      paramArrayOfStrengthInfo[paramInt3].a = paramInt1;
      paramArrayOfStrengthInfo[paramInt3].c = l1;
      paramAioInfo.a = paramInt3;
      return true;
    }
    StringBuilder localStringBuilder;
    if ((paramInt2 != -1) && (paramArrayOfStrengthInfo[paramInt3].c != -1L))
    {
      long l2 = paramArrayOfStrengthInfo[paramInt3].c;
      paramArrayOfStrengthInfo[paramInt3].c = l1;
      if (paramInt2 != paramInt3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramArrayOfStrengthInfo[paramInt2].b);
        ReportController.b(paramAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, localStringBuilder.toString(), "", "", "");
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("Strength click,type:");
          paramAppInterface.append(paramInt3);
          paramAppInterface.append(".with status ");
          paramAppInterface.append(paramArrayOfStrengthInfo[paramInt3].a);
          paramAppInterface.append("to 0");
          QLog.d("PokeMsg", 2, paramAppInterface.toString());
        }
        paramAioInfo.a = paramInt3;
        paramArrayOfStrengthInfo[paramInt3].a = 0;
        paramArrayOfStrengthInfo[paramInt3].b = 1;
        return true;
      }
      if (l1 - l2 < k)
      {
        paramAppInterface = paramArrayOfStrengthInfo[paramInt3];
        paramAppInterface.a += 1;
        paramAppInterface = paramArrayOfStrengthInfo[paramInt3];
        paramAppInterface.b += 1;
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("Strength click ,type:");
          paramAppInterface.append(paramInt3);
          paramAppInterface.append(".with status ");
          paramAppInterface.append(paramArrayOfStrengthInfo[paramInt3].a);
          QLog.d("PokeMsg", 2, paramAppInterface.toString());
        }
      }
      else
      {
        paramAioInfo = new StringBuilder();
        paramAioInfo.append("");
        paramAioInfo.append(paramArrayOfStrengthInfo[paramInt2].b);
        ReportController.b(paramAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, paramAioInfo.toString(), "", "", "");
        paramArrayOfStrengthInfo[paramInt3].a = 0;
        paramArrayOfStrengthInfo[paramInt3].b = 1;
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("Strength click,type:");
          paramAppInterface.append(paramInt3);
          paramAppInterface.append(".with status ");
          paramAppInterface.append(paramArrayOfStrengthInfo[paramInt3].a);
          paramAppInterface.append(",out of time");
          QLog.d("PokeMsg", 2, paramAppInterface.toString());
        }
      }
      return false;
    }
    if (paramInt2 != -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramArrayOfStrengthInfo[paramInt2].b);
      ReportController.b(paramAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, localStringBuilder.toString(), "", "", "");
    }
    paramArrayOfStrengthInfo[paramInt3].c = l1;
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("Strength first click,type:");
      paramAppInterface.append(paramInt3);
      paramAppInterface.append(".with status ");
      paramAppInterface.append(paramArrayOfStrengthInfo[paramInt3].a);
      QLog.d("PokeMsg", 2, paramAppInterface.toString());
    }
    paramAioInfo.a = paramInt3;
    paramArrayOfStrengthInfo[paramInt3].a = 0;
    paramArrayOfStrengthInfo[paramInt3].b = 1;
    return true;
  }
  
  public static PokeItemAnimationManager c()
  {
    if (l == null) {
      try
      {
        if (l == null) {
          l = new PokeItemAnimationManager();
        }
      }
      finally {}
    }
    return l;
  }
  
  public int a(AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Strength D_HIT_TIME_MS");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append("curFriendUin");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("type");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("status");
      ((StringBuilder)localObject1).append(paramInt3);
      QLog.d("PokeMsg", 2, ((StringBuilder)localObject1).toString());
    }
    StringBuilder localStringBuilder;
    if (k == 0L)
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(paramAppInterface.getApp());
      localObject2 = paramAppInterface.getAccount();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("_");
      localStringBuilder.append("aio_poke_strength_rule_interval");
      long l1 = ((SharedPreferences)localObject1).getLong(localStringBuilder.toString(), 0L) * 1000L;
      k = l1;
      if (l1 == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "Strength D_HIT_TIME_MS is not ready");
        }
        return 0;
      }
    }
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if ((!this.i.containsKey(paramString)) || (this.i.get(paramString) == null))
    {
      localObject1 = new PokeItemAnimationManager.AioInfo(this);
      ((PokeItemAnimationManager.AioInfo)localObject1).b = new PokeItemAnimationManager.StrengthInfo[6];
      this.i.put(paramString, localObject1);
    }
    Object localObject1 = (PokeItemAnimationManager.AioInfo)this.i.get(paramString);
    if (localObject1 == null)
    {
      paramAppInterface = new HashMap();
      paramAppInterface.put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pokeStrengthNullPoint", false, 0L, 0L, paramAppInterface, "");
      return 0;
    }
    Object localObject2 = ((PokeItemAnimationManager.AioInfo)localObject1).b;
    paramInt2 = ((PokeItemAnimationManager.AioInfo)localObject1).a;
    paramInt1 -= 1;
    if (paramInt1 == -1) {
      paramInt1 = 0;
    }
    if ((paramInt1 >= 0) && (paramInt1 < 6))
    {
      if (a(paramAppInterface, paramString, paramInt3, (PokeItemAnimationManager.AioInfo)localObject1, (PokeItemAnimationManager.StrengthInfo[])localObject2, paramInt2, paramInt1)) {
        return localObject2[paramInt1].a;
      }
      if (localObject2[paramInt1].a > 3) {
        localObject2[paramInt1].a = 3;
      }
      return localObject2[paramInt1].a;
    }
    if (paramInt2 != -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localObject2[paramInt2].b);
      ReportController.b(paramAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, localStringBuilder.toString(), "", "", "");
      ((PokeItemAnimationManager.AioInfo)localObject1).a = -1;
    }
    return 0;
  }
  
  public void a()
  {
    MqqHandler localMqqHandler = this.g;
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
    if (this.f != null) {
      if (Build.VERSION.SDK_INT >= 18) {
        this.f.quitSafely();
      } else {
        this.f.quit();
      }
    }
    this.f = null;
    this.g = null;
  }
  
  public void a(int paramInt)
  {
    Handler localHandler = this.a;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage();
      ((Message)localObject).what = paramInt1;
      ((Message)localObject).arg1 = paramInt2;
      if (paramBoolean) {
        ((Message)localObject).arg2 = 1;
      } else {
        ((Message)localObject).arg2 = 0;
      }
      this.a.sendMessage((Message)localObject);
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage();
      ((Message)localObject).what = paramInt;
      this.a.sendMessageDelayed((Message)localObject, paramLong);
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage();
      ((Message)localObject).what = paramInt;
      ((Message)localObject).obj = Boolean.valueOf(paramBoolean);
      this.a.sendMessageDelayed((Message)localObject, paramLong);
    }
  }
  
  public void a(View paramView)
  {
    paramView = AIOUtils.b(paramView);
    if (GivingHeartItemBuilder.Holder.class.isInstance(paramView))
    {
      Object localObject = (GivingHeartItemBuilder.Holder)paramView;
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, new Object[] { "==>to be remove obj:", Integer.valueOf(((GivingHeartItemBuilder.Holder)localObject).l) });
      }
      if ((((GivingHeartItemBuilder.Holder)localObject).q instanceof MessageForPoke))
      {
        paramView = (MessageForPoke)((GivingHeartItemBuilder.Holder)localObject).q;
        if (!PokeItemHelper.d(paramView.interactType)) {
          return;
        }
        if (paramView.interactType == 6)
        {
          if (((GivingHeartItemBuilder.Holder)localObject).d.b())
          {
            localObject = ((GivingHeartItemBuilder.Holder)localObject).d.e();
            paramView.mUnlimitedState.a = ((UnlimitedBladeWorks.UnlimitedState)localObject).a;
            paramView.mUnlimitedState.b = ((UnlimitedBladeWorks.UnlimitedState)localObject).b;
            paramView.mUnlimitedState.c = ((UnlimitedBladeWorks.UnlimitedState)localObject).c;
            paramView.mFrameState.h = ((UnlimitedBladeWorks.UnlimitedState)localObject).e;
            paramView.mFrameState.d = ((UnlimitedBladeWorks.UnlimitedState)localObject).d;
          }
        }
        else
        {
          localObject = ((GivingHeartItemBuilder.Holder)localObject).c.getBackground();
          if ((localObject instanceof CustomFrameAnimationDrawable))
          {
            localObject = (CustomFrameAnimationDrawable)localObject;
            ((CustomFrameAnimationDrawable)localObject).f();
            ((CustomFrameAnimationDrawable)localObject).a(null);
            if (QLog.isColorLevel()) {
              QLog.d("GivingHeart", 2, "drawble pause");
            }
            if (paramView.mFrameState.c == ((CustomFrameAnimationDrawable)localObject).k())
            {
              paramView.mFrameState.d = false;
              paramView.mFrameState.h = true;
            }
          }
        }
      }
    }
  }
  
  public void a(FitSystemWindowsRelativeLayout paramFitSystemWindowsRelativeLayout)
  {
    this.a = new WeakReferenceHandler(Looper.getMainLooper(), paramFitSystemWindowsRelativeLayout);
  }
  
  public MqqHandler b()
  {
    if ((this.g == null) || (this.f == null))
    {
      this.f = new HandlerThread("PokeAIOAnimThread");
      this.f.start();
      this.g = new MqqHandler(this.f.getLooper());
    }
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager
 * JD-Core Version:    0.7.0.1
 */