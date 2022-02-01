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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
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
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "/dazhao_motion/dazhao_move.png";
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
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfJavaUtilArrayList.length)
    {
      this.jdField_a_of_type_ArrayOfJavaUtilArrayList[i] = null;
      i += 1;
    }
    i = 0;
    while (i < this.jdField_b_of_type_ArrayOfJavaUtilArrayList.length)
    {
      this.jdField_b_of_type_ArrayOfJavaUtilArrayList[i] = null;
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioItemPokeItemAnimationManager$DoubleHitInfo = new PokeItemAnimationManager.DoubleHitInfo[6];
    PokeItemAnimationManager.DoubleHitInfo[] arrayOfDoubleHitInfo = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioItemPokeItemAnimationManager$DoubleHitInfo;
    int k = arrayOfDoubleHitInfo.length;
    i = j;
    while (i < k)
    {
      PokeItemAnimationManager.DoubleHitInfo localDoubleHitInfo = arrayOfDoubleHitInfo[i];
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
    if (jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemAnimationManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemAnimationManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemAnimationManager = new PokeItemAnimationManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemAnimationManager;
    }
    finally {}
  }
  
  private void a(String paramString, Context paramContext)
  {
    File localFile1 = new File(paramString);
    if ((localFile1.exists()) && (localFile1.isDirectory()))
    {
      String[] arrayOfString = localFile1.list();
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str1 = arrayOfString[i];
        if (QLog.isColorLevel()) {
          QLog.d("LzmaUtils", 2, "deal current file:" + str1);
        }
        if (new File(paramString + "/" + str1).isDirectory()) {
          a(paramString + "/" + str1, paramContext);
        }
        for (;;)
        {
          i += 1;
          break;
          if (str1.endsWith("7z"))
          {
            String str2 = str1.split("\\.")[0];
            if (QLog.isColorLevel()) {
              QLog.d("LzmaUtils", 2, "dirName:" + str2);
            }
            File localFile2 = new File(localFile1, str2);
            if (localFile2.exists()) {
              FileUtils.a(str2, false);
            }
            localFile2.mkdir();
            LzmaUtils.a(paramContext, paramString + "/" + str1, localFile2.getAbsolutePath());
            FileUtils.a(paramString + "/" + str1, true);
          }
        }
      }
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, PokeItemAnimationManager.AioInfo paramAioInfo, PokeItemAnimationManager.StrengthInfo[] paramArrayOfStrengthInfo, int paramInt2, int paramInt3)
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
    if ((paramInt2 == -1) || (paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Long == -1L))
    {
      if (paramInt2 != -1) {
        ReportController.b(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + paramArrayOfStrengthInfo[paramInt2].jdField_b_of_type_Int, "", "", "");
      }
      paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Long = l1;
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "Strength first click,type:" + paramInt3 + ".with status " + paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int);
      }
      paramAioInfo.jdField_a_of_type_Int = paramInt3;
      paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int = 0;
      paramArrayOfStrengthInfo[paramInt3].jdField_b_of_type_Int = 1;
      return true;
    }
    long l2 = paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Long;
    paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Long = l1;
    if (paramInt2 != paramInt3)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + paramArrayOfStrengthInfo[paramInt2].jdField_b_of_type_Int, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "Strength click,type:" + paramInt3 + ".with status " + paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int + "to 0");
      }
      paramAioInfo.jdField_a_of_type_Int = paramInt3;
      paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int = 0;
      paramArrayOfStrengthInfo[paramInt3].jdField_b_of_type_Int = 1;
      return true;
    }
    if (l1 - l2 < jdField_b_of_type_Long)
    {
      paramQQAppInterface = paramArrayOfStrengthInfo[paramInt3];
      paramQQAppInterface.jdField_a_of_type_Int += 1;
      paramQQAppInterface = paramArrayOfStrengthInfo[paramInt3];
      paramQQAppInterface.jdField_b_of_type_Int += 1;
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "Strength click ,type:" + paramInt3 + ".with status " + paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      return false;
      ReportController.b(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + paramArrayOfStrengthInfo[paramInt2].jdField_b_of_type_Int, "", "", "");
      paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int = 0;
      paramArrayOfStrengthInfo[paramInt3].jdField_b_of_type_Int = 1;
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "Strength click,type:" + paramInt3 + ".with status " + paramArrayOfStrengthInfo[paramInt3].jdField_a_of_type_Int + ",out of time");
      }
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "Strength D_HIT_TIME_MS" + jdField_b_of_type_Long + "curFriendUin" + paramString + "type" + paramInt1 + "status" + paramInt3);
    }
    if (jdField_b_of_type_Long == 0L)
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      localObject2 = paramQQAppInterface.getAccount();
      long l = ((SharedPreferences)localObject1).getLong((String)localObject2 + "_" + "aio_poke_strength_rule_interval", 0L) * 1000L;
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
      paramQQAppInterface = new HashMap();
      paramQQAppInterface.put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pokeStrengthNullPoint", false, 0L, 0L, paramQQAppInterface, "");
      return 0;
    }
    Object localObject2 = ((PokeItemAnimationManager.AioInfo)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioItemPokeItemAnimationManager$StrengthInfo;
    paramInt2 = ((PokeItemAnimationManager.AioInfo)localObject1).jdField_a_of_type_Int;
    if (paramInt1 - 1 == -1) {
      paramInt1 = 0;
    }
    while ((paramInt1 >= 0) && (paramInt1 < 6))
    {
      if (!a(paramQQAppInterface, paramString, paramInt3, (PokeItemAnimationManager.AioInfo)localObject1, (PokeItemAnimationManager.StrengthInfo[])localObject2, paramInt2, paramInt1)) {
        break label398;
      }
      return localObject2[paramInt1].jdField_a_of_type_Int;
      paramInt1 -= 1;
    }
    if (paramInt2 != -1)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + localObject2[paramInt2].jdField_b_of_type_Int, "", "", "");
      ((PokeItemAnimationManager.AioInfo)localObject1).jdField_a_of_type_Int = -1;
    }
    return 0;
    label398:
    if (localObject2[paramInt1].jdField_a_of_type_Int > 3) {
      localObject2[paramInt1].jdField_a_of_type_Int = 3;
    }
    return localObject2[paramInt1].jdField_a_of_type_Int;
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
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandlerThread != null)
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label49;
      }
      this.jdField_b_of_type_AndroidOsHandlerThread.quitSafely();
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidOsHandlerThread = null;
      this.jdField_b_of_type_MqqOsMqqHandler = null;
      return;
      label49:
      this.jdField_b_of_type_AndroidOsHandlerThread.quit();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Message localMessage;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      if (!paramBoolean) {
        break label49;
      }
    }
    label49:
    for (localMessage.arg2 = 1;; localMessage.arg2 = 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = paramInt;
      localMessage.obj = Boolean.valueOf(paramBoolean);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  public void a(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    Object localObject;
    if (GivingHeartItemBuilder.Holder.class.isInstance(paramView))
    {
      localObject = (GivingHeartItemBuilder.Holder)paramView;
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, new Object[] { "==>to be remove obj:", Integer.valueOf(((GivingHeartItemBuilder.Holder)localObject).jdField_b_of_type_Int) });
      }
      if ((((GivingHeartItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPoke))
      {
        paramView = (MessageForPoke)((GivingHeartItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (PokeItemHelper.a(paramView.interactType)) {
          break label82;
        }
      }
    }
    label82:
    do
    {
      do
      {
        do
        {
          return;
          if (paramView.interactType != 6) {
            break;
          }
        } while (!((GivingHeartItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a());
        localObject = ((GivingHeartItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a();
        paramView.mUnlimitedState.jdField_a_of_type_Int = ((UnlimitedBladeWorks.UnlimitedState)localObject).jdField_a_of_type_Int;
        paramView.mUnlimitedState.jdField_b_of_type_Int = ((UnlimitedBladeWorks.UnlimitedState)localObject).jdField_b_of_type_Int;
        paramView.mUnlimitedState.jdField_a_of_type_Long = ((UnlimitedBladeWorks.UnlimitedState)localObject).jdField_a_of_type_Long;
        paramView.mFrameState.c = ((UnlimitedBladeWorks.UnlimitedState)localObject).jdField_b_of_type_Boolean;
        paramView.mFrameState.jdField_a_of_type_Boolean = ((UnlimitedBladeWorks.UnlimitedState)localObject).jdField_a_of_type_Boolean;
        return;
        localObject = ((GivingHeartItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getBackground();
      } while (!(localObject instanceof CustomFrameAnimationDrawable));
      localObject = (CustomFrameAnimationDrawable)localObject;
      ((CustomFrameAnimationDrawable)localObject).f();
      ((CustomFrameAnimationDrawable)localObject).a(null);
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, "drawble pause");
      }
    } while (paramView.mFrameState.jdField_a_of_type_Int != ((CustomFrameAnimationDrawable)localObject).b());
    paramView.mFrameState.jdField_a_of_type_Boolean = false;
    paramView.mFrameState.c = true;
  }
  
  public void a(FitSystemWindowsRelativeLayout paramFitSystemWindowsRelativeLayout)
  {
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), paramFitSystemWindowsRelativeLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager
 * JD-Core Version:    0.7.0.1
 */