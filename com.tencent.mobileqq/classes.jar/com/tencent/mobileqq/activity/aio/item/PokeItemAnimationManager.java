package com.tencent.mobileqq.activity.aio.item;

import android.content.SharedPreferences;
import android.os.Environment;
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
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import vhy;
import vhz;
import via;

public class PokeItemAnimationManager
{
  public static long a;
  private static PokeItemAnimationManager jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemAnimationManager;
  public static final String a;
  public static long b;
  public static final String b;
  public Handler a;
  public HandlerThread a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public MqqHandler a;
  private ArrayList[] jdField_a_of_type_ArrayOfJavaUtilArrayList = new ArrayList[6];
  vhz[] jdField_a_of_type_ArrayOfVhz = null;
  private ArrayList[] b;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/poke/";
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "/dazhao_motion/dazhao_move.png";
    jdField_a_of_type_Long = 1500L;
  }
  
  private PokeItemAnimationManager()
  {
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
    this.jdField_a_of_type_ArrayOfVhz = new vhz[6];
    vhz[] arrayOfvhz = this.jdField_a_of_type_ArrayOfVhz;
    int k = arrayOfvhz.length;
    i = j;
    while (i < k)
    {
      vhz localvhz = arrayOfvhz[i];
      localvhz = new vhz(this);
      localvhz.jdField_a_of_type_Int = 1;
      localvhz.jdField_a_of_type_Long = -1L;
      i += 1;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("PokeAIOAnimThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
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
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "Strength D_HIT_TIME_MS" + jdField_b_of_type_Long + "curFriendUin" + paramString + "type" + paramInt1 + "status" + paramInt3);
    }
    long l1;
    if (jdField_b_of_type_Long == 0L)
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      localObject2 = paramQQAppInterface.getAccount();
      l1 = ((SharedPreferences)localObject1).getLong((String)localObject2 + "_" + "aio_poke_strength_rule_interval", 0L) * 1000L;
      jdField_b_of_type_Long = l1;
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
    if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) || (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) == null))
    {
      localObject1 = new vhy(this);
      ((vhy)localObject1).jdField_a_of_type_ArrayOfVia = new via[6];
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    Object localObject2 = (vhy)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject2 == null)
    {
      paramQQAppInterface = new HashMap();
      paramQQAppInterface.put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "pokeStrengthNullPoint", false, 0L, 0L, paramQQAppInterface, "");
      return 0;
    }
    Object localObject1 = ((vhy)localObject2).jdField_a_of_type_ArrayOfVia;
    paramInt2 = ((vhy)localObject2).jdField_a_of_type_Int;
    if (paramInt1 - 1 == -1) {
      paramInt1 = 0;
    }
    while ((paramInt1 >= 0) && (paramInt1 < 6))
    {
      l1 = SystemClock.uptimeMillis();
      if (localObject1[paramInt1] == null)
      {
        localObject1[paramInt1] = new via(this);
        localObject1[paramInt1].jdField_a_of_type_Int = 0;
        localObject1[paramInt1].jdField_b_of_type_Int = 0;
        localObject1[paramInt1].jdField_a_of_type_Long = -1L;
      }
      if (paramInt3 != -1)
      {
        localObject1[paramInt1].jdField_a_of_type_Int = paramInt3;
        localObject1[paramInt1].jdField_a_of_type_Long = l1;
        ((vhy)localObject2).jdField_a_of_type_Int = paramInt1;
        return localObject1[paramInt1].jdField_a_of_type_Int;
        paramInt1 -= 1;
      }
      else
      {
        if ((paramInt2 == -1) || (localObject1[paramInt1].jdField_a_of_type_Long == -1L))
        {
          if (paramInt2 != -1) {
            ReportController.b(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + localObject1[paramInt2].jdField_b_of_type_Int, "", "", "");
          }
          localObject1[paramInt1].jdField_a_of_type_Long = l1;
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "Strength first click,type:" + paramInt1 + ".with status " + localObject1[paramInt1].jdField_a_of_type_Int);
          }
          ((vhy)localObject2).jdField_a_of_type_Int = paramInt1;
          localObject1[paramInt1].jdField_a_of_type_Int = 0;
          localObject1[paramInt1].jdField_b_of_type_Int = 1;
          return localObject1[paramInt1].jdField_a_of_type_Int;
        }
        long l2 = localObject1[paramInt1].jdField_a_of_type_Long;
        localObject1[paramInt1].jdField_a_of_type_Long = l1;
        if (paramInt2 != paramInt1)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + localObject1[paramInt2].jdField_b_of_type_Int, "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "Strength click,type:" + paramInt1 + ".with status " + localObject1[paramInt1].jdField_a_of_type_Int + "to 0");
          }
          ((vhy)localObject2).jdField_a_of_type_Int = paramInt1;
          localObject1[paramInt1].jdField_a_of_type_Int = 0;
          localObject1[paramInt1].jdField_b_of_type_Int = 1;
          return localObject1[paramInt1].jdField_a_of_type_Int;
        }
        if (l1 - l2 < jdField_b_of_type_Long)
        {
          paramQQAppInterface = localObject1[paramInt1];
          paramQQAppInterface.jdField_a_of_type_Int += 1;
          paramQQAppInterface = localObject1[paramInt1];
          paramQQAppInterface.jdField_b_of_type_Int += 1;
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "Strength click ,type:" + paramInt1 + ".with status " + localObject1[paramInt1].jdField_a_of_type_Int);
          }
        }
        for (;;)
        {
          if (localObject1[paramInt1].jdField_a_of_type_Int > 3) {
            localObject1[paramInt1].jdField_a_of_type_Int = 3;
          }
          return localObject1[paramInt1].jdField_a_of_type_Int;
          ReportController.b(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + localObject1[paramInt2].jdField_b_of_type_Int, "", "", "");
          localObject1[paramInt1].jdField_a_of_type_Int = 0;
          localObject1[paramInt1].jdField_b_of_type_Int = 1;
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "Strength click,type:" + paramInt1 + ".with status " + localObject1[paramInt1].jdField_a_of_type_Int + ",out of time");
          }
        }
      }
    }
    if (paramInt2 != -1)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + localObject1[paramInt2].jdField_b_of_type_Int, "", "", "");
      ((vhy)localObject2).jdField_a_of_type_Int = -1;
    }
    return 0;
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
      ((CustomFrameAnimationDrawable)localObject).e();
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