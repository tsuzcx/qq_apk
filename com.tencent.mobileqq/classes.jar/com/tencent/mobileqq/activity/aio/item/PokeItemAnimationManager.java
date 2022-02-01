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
  public static long a;
  private static PokeItemAnimationManager jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemAnimationManager;
  public static final String a;
  public static long b;
  public static final String b;
  public Handler a;
  public HandlerThread a;
  HashMap<String, PokeItemAnimationManager.AioInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public MqqHandler a;
  PokeItemAnimationManager.DoubleHitInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioItemPokeItemAnimationManager$DoubleHitInfo = null;
  private ArrayList[] jdField_a_of_type_ArrayOfJavaUtilArrayList = new ArrayList[6];
  public HandlerThread b;
  public MqqHandler b;
  private ArrayList[] b;
  
  static
  {
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath("Tencent/MobileQQ/poke/");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/dazhao_motion/dazhao_move.png");
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_Long = 1500L;
    jdField_b_of_type_Long = 0L;
  }
  
  private PokeItemAnimationManager()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = null;
    this.jdField_a_of_type_MqqOsMqqHandler = null;
    this.jdField_b_of_type_AndroidOsHandlerThread = null;
    this.jdField_b_of_type_MqqOsMqqHandler = null;
    this.jdField_b_of_type_ArrayOfJavaUtilArrayList = new ArrayList[6];
    int j = 0;
    int i = 0;
    for (;;)
    {
      localObject = this.jdField_a_of_type_ArrayOfJavaUtilArrayList;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = null;
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = this.jdField_b_of_type_ArrayOfJavaUtilArrayList;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = null;
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioItemPokeItemAnimationManager$DoubleHitInfo = new PokeItemAnimationManager.DoubleHitInfo[6];
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioItemPokeItemAnimationManager$DoubleHitInfo;
    int k = localObject.length;
    i = j;
    while (i < k)
    {
      PokeItemAnimationManager.DoubleHitInfo localDoubleHitInfo = localObject[i];
      localDoubleHitInfo = new PokeItemAnimationManager.DoubleHitInfo(this);
      localDoubleHitInfo.jdField_a_of_type_Int = 1;
      localDoubleHitInfo.jdField_a_of_type_Long = -1L;
      i += 1;
    }
    this.jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("PokeAIOAnimThread");
    this.jdField_b_of_type_AndroidOsHandlerThread.start();
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public static PokeItemAnimationManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemAnimationManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemAnimationManager == null) {
          jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemAnimationManager = new PokeItemAnimationManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemAnimationManager;
  }
  
  private void a(String paramString, Context paramContext)
  {
    File localFile = new File(paramString);
    if ((localFile.exists()) && (localFile.isDirectory()))
    {
      String[] arrayOfString = localFile.list();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
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
        i += 1;
      }
    }
  }
  
  private boolean a(AppInterface paramAppInterface, String paramString, int paramInt1, PokeItemAnimationManager.AioInfo paramAioInfo, PokeItemAnimationManager.StrengthInfo[] paramArrayOfStrengthInfo, int paramInt2, int paramInt3)
  {
    long l1 = SystemClock.uptimeMillis();
    if (paramArrayOfStrengthInfo[paramInt3] == null)
    {
      paramArrayOfStrengthInfo[paramInt3] = new PokeItemAnimationManager.StrengthInfo(this);
      paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int = 0;
      paramArrayOfStrengthInfo[paramInt3].jdField_b_of_type_Int = 0;
      paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Long = -1L;
    }
    if (paramInt1 != -1)
    {
      paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int = paramInt1;
      paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Long = l1;
      paramAioInfo.jdField_a_of_type_Int = paramInt3;
      return true;
    }
    StringBuilder localStringBuilder;
    if ((paramInt2 != -1) && (paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Long != -1L))
    {
      long l2 = paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Long;
      paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Long = l1;
      if (paramInt2 != paramInt3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramArrayOfStrengthInfo[paramInt2].jdField_b_of_type_Int);
        ReportController.b(paramAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, localStringBuilder.toString(), "", "", "");
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("Strength click,type:");
          paramAppInterface.append(paramInt3);
          paramAppInterface.append(".with status ");
          paramAppInterface.append(paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int);
          paramAppInterface.append("to 0");
          QLog.d("PokeMsg", 2, paramAppInterface.toString());
        }
        paramAioInfo.jdField_a_of_type_Int = paramInt3;
        paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int = 0;
        paramArrayOfStrengthInfo[paramInt3].jdField_b_of_type_Int = 1;
        return true;
      }
      if (l1 - l2 < jdField_b_of_type_Long)
      {
        paramAppInterface = paramArrayOfStrengthInfo[paramInt3];
        paramAppInterface.jdField_a_of_type_Int += 1;
        paramAppInterface = paramArrayOfStrengthInfo[paramInt3];
        paramAppInterface.jdField_b_of_type_Int += 1;
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("Strength click ,type:");
          paramAppInterface.append(paramInt3);
          paramAppInterface.append(".with status ");
          paramAppInterface.append(paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int);
          QLog.d("PokeMsg", 2, paramAppInterface.toString());
        }
      }
      else
      {
        paramAioInfo = new StringBuilder();
        paramAioInfo.append("");
        paramAioInfo.append(paramArrayOfStrengthInfo[paramInt2].jdField_b_of_type_Int);
        ReportController.b(paramAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, paramAioInfo.toString(), "", "", "");
        paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int = 0;
        paramArrayOfStrengthInfo[paramInt3].jdField_b_of_type_Int = 1;
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("Strength click,type:");
          paramAppInterface.append(paramInt3);
          paramAppInterface.append(".with status ");
          paramAppInterface.append(paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int);
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
      localStringBuilder.append(paramArrayOfStrengthInfo[paramInt2].jdField_b_of_type_Int);
      ReportController.b(paramAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, localStringBuilder.toString(), "", "", "");
    }
    paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Long = l1;
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("Strength first click,type:");
      paramAppInterface.append(paramInt3);
      paramAppInterface.append(".with status ");
      paramAppInterface.append(paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int);
      QLog.d("PokeMsg", 2, paramAppInterface.toString());
    }
    paramAioInfo.jdField_a_of_type_Int = paramInt3;
    paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int = 0;
    paramArrayOfStrengthInfo[paramInt3].jdField_b_of_type_Int = 1;
    return true;
  }
  
  public int a(AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Strength D_HIT_TIME_MS");
      ((StringBuilder)localObject1).append(jdField_b_of_type_Long);
      ((StringBuilder)localObject1).append("curFriendUin");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("type");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("status");
      ((StringBuilder)localObject1).append(paramInt3);
      QLog.d("PokeMsg", 2, ((StringBuilder)localObject1).toString());
    }
    StringBuilder localStringBuilder;
    if (jdField_b_of_type_Long == 0L)
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(paramAppInterface.getApp());
      localObject2 = paramAppInterface.getAccount();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("_");
      localStringBuilder.append("aio_poke_strength_rule_interval");
      long l = ((SharedPreferences)localObject1).getLong(localStringBuilder.toString(), 0L) * 1000L;
      jdField_b_of_type_Long = l;
      if (l == 0L)
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
    if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) || (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) == null))
    {
      localObject1 = new PokeItemAnimationManager.AioInfo(this);
      ((PokeItemAnimationManager.AioInfo)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioItemPokeItemAnimationManager$StrengthInfo = new PokeItemAnimationManager.StrengthInfo[6];
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    Object localObject1 = (PokeItemAnimationManager.AioInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject1 == null)
    {
      paramAppInterface = new HashMap();
      paramAppInterface.put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pokeStrengthNullPoint", false, 0L, 0L, paramAppInterface, "");
      return 0;
    }
    Object localObject2 = ((PokeItemAnimationManager.AioInfo)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioItemPokeItemAnimationManager$StrengthInfo;
    paramInt2 = ((PokeItemAnimationManager.AioInfo)localObject1).jdField_a_of_type_Int;
    paramInt1 -= 1;
    if (paramInt1 == -1) {
      paramInt1 = 0;
    }
    if ((paramInt1 >= 0) && (paramInt1 < 6))
    {
      if (a(paramAppInterface, paramString, paramInt3, (PokeItemAnimationManager.AioInfo)localObject1, (PokeItemAnimationManager.StrengthInfo[])localObject2, paramInt2, paramInt1)) {
        return localObject2[paramInt1].jdField_a_of_type_Int;
      }
      if (localObject2[paramInt1].jdField_a_of_type_Int > 3) {
        localObject2[paramInt1].jdField_a_of_type_Int = 3;
      }
      return localObject2[paramInt1].jdField_a_of_type_Int;
    }
    if (paramInt2 != -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localObject2[paramInt2].jdField_b_of_type_Int);
      ReportController.b(paramAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, localStringBuilder.toString(), "", "", "");
      ((PokeItemAnimationManager.AioInfo)localObject1).jdField_a_of_type_Int = -1;
    }
    return 0;
  }
  
  public MqqHandler a()
  {
    if ((this.jdField_b_of_type_MqqOsMqqHandler == null) || (this.jdField_b_of_type_AndroidOsHandlerThread == null))
    {
      this.jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("PokeAIOAnimThread");
      this.jdField_b_of_type_AndroidOsHandlerThread.start();
      this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
    }
    return this.jdField_b_of_type_MqqOsMqqHandler;
  }
  
  public void a()
  {
    MqqHandler localMqqHandler = this.jdField_b_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandlerThread != null) {
      if (Build.VERSION.SDK_INT >= 18) {
        this.jdField_b_of_type_AndroidOsHandlerThread.quitSafely();
      } else {
        this.jdField_b_of_type_AndroidOsHandlerThread.quit();
      }
    }
    this.jdField_b_of_type_AndroidOsHandlerThread = null;
    this.jdField_b_of_type_MqqOsMqqHandler = null;
  }
  
  public void a(int paramInt)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
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
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage();
      ((Message)localObject).what = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, paramLong);
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage();
      ((Message)localObject).what = paramInt;
      ((Message)localObject).obj = Boolean.valueOf(paramBoolean);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, paramLong);
    }
  }
  
  public void a(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    if (GivingHeartItemBuilder.Holder.class.isInstance(paramView))
    {
      Object localObject = (GivingHeartItemBuilder.Holder)paramView;
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, new Object[] { "==>to be remove obj:", Integer.valueOf(((GivingHeartItemBuilder.Holder)localObject).jdField_b_of_type_Int) });
      }
      if ((((GivingHeartItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPoke))
      {
        paramView = (MessageForPoke)((GivingHeartItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (!PokeItemHelper.a(paramView.interactType)) {
          return;
        }
        if (paramView.interactType == 6)
        {
          if (((GivingHeartItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a())
          {
            localObject = ((GivingHeartItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a();
            paramView.mUnlimitedState.jdField_a_of_type_Int = ((UnlimitedBladeWorks.UnlimitedState)localObject).jdField_a_of_type_Int;
            paramView.mUnlimitedState.jdField_b_of_type_Int = ((UnlimitedBladeWorks.UnlimitedState)localObject).jdField_b_of_type_Int;
            paramView.mUnlimitedState.jdField_a_of_type_Long = ((UnlimitedBladeWorks.UnlimitedState)localObject).jdField_a_of_type_Long;
            paramView.mFrameState.c = ((UnlimitedBladeWorks.UnlimitedState)localObject).jdField_b_of_type_Boolean;
            paramView.mFrameState.jdField_a_of_type_Boolean = ((UnlimitedBladeWorks.UnlimitedState)localObject).jdField_a_of_type_Boolean;
          }
        }
        else
        {
          localObject = ((GivingHeartItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getBackground();
          if ((localObject instanceof CustomFrameAnimationDrawable))
          {
            localObject = (CustomFrameAnimationDrawable)localObject;
            ((CustomFrameAnimationDrawable)localObject).f();
            ((CustomFrameAnimationDrawable)localObject).a(null);
            if (QLog.isColorLevel()) {
              QLog.d("GivingHeart", 2, "drawble pause");
            }
            if (paramView.mFrameState.jdField_a_of_type_Int == ((CustomFrameAnimationDrawable)localObject).b())
            {
              paramView.mFrameState.jdField_a_of_type_Boolean = false;
              paramView.mFrameState.c = true;
            }
          }
        }
      }
    }
  }
  
  public void a(FitSystemWindowsRelativeLayout paramFitSystemWindowsRelativeLayout)
  {
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), paramFitSystemWindowsRelativeLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager
 * JD-Core Version:    0.7.0.1
 */