package com.tencent.mobileqq.apollo.ai;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.IRenderCommInterface;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.task.ApolloAudioPlayer;
import com.tencent.mobileqq.apollo.task.IAudioPlayerListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import yol;

public class ApolloAILogicProcessor
  implements IRenderCallback, IAILogicInterface, IAudioPlayerListener
{
  private int jdField_a_of_type_Int;
  private IRenderCommInterface jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface;
  private ApolloAIMessage jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage;
  private IApolloAIView jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView;
  private ApolloAudioPlayer jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject;
  private Runnable jdField_a_of_type_JavaLangRunnable = new yol(this);
  private List jdField_a_of_type_JavaUtilList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ApolloAIMessage jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage;
  private int c;
  
  public ApolloAILogicProcessor(IApolloAIView paramIApolloAIView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "[ApolloAILogicProcessor], this:" + this);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView = paramIApolloAIView;
    this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer = new ApolloAudioPlayer(this);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private void a(String paramString, Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", true);
    localIntent.putExtra("finish_animation_up_down", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.addFlags(67108864);
    paramActivity.startActivity(localIntent);
    b();
  }
  
  private void b(ApolloAIMessage paramApolloAIMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "[tryExpress],aiResponses:" + paramApolloAIMessage);
    }
    if (paramApolloAIMessage == null) {}
    label156:
    label325:
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramApolloAIMessage.jdField_c_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface.a(1, null, "Bubble");
      }
      e();
      if ((paramApolloAIMessage.jdField_c_of_type_Int == 2) || (paramApolloAIMessage.jdField_a_of_type_Boolean))
      {
        if ((this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_c_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_c_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView.b(this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage.a());
        }
        if (paramApolloAIMessage.jdField_c_of_type_Int == 5)
        {
          paramApolloAIMessage.g = 8;
          paramApolloAIMessage.jdField_b_of_type_Int = 5;
        }
        if ((TextUtils.isEmpty(paramApolloAIMessage.jdField_a_of_type_JavaLangString)) || (paramApolloAIMessage.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface == null)) {
          break label325;
        }
        ApolloActionManager.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
        this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface.b(4, null, 1, this.jdField_a_of_type_Int, paramApolloAIMessage.jdField_a_of_type_JavaLangString, "");
      }
      do
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage = paramApolloAIMessage;
          this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage = paramApolloAIMessage.a();
          d();
          if ((paramApolloAIMessage.jdField_c_of_type_Int != 4) || (TextUtils.isEmpty(paramApolloAIMessage.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramApolloAIMessage.jdField_d_of_type_JavaLangString)) || (paramApolloAIMessage.jdField_a_of_type_Boolean)) {
            break;
          }
          ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 4000L);
          return;
          if ((paramApolloAIMessage.jdField_c_of_type_Int != 4) || (paramApolloAIMessage.g != 0)) {
            break label156;
          }
          if (paramApolloAIMessage.jdField_b_of_type_Int > 0)
          {
            paramApolloAIMessage.g = 9;
            break label156;
          }
          paramApolloAIMessage.g = 8;
          paramApolloAIMessage.jdField_b_of_type_Int = 4;
          break label156;
          if ((TextUtils.isEmpty(paramApolloAIMessage.jdField_d_of_type_JavaLangString)) || (paramApolloAIMessage.jdField_d_of_type_Int <= 0) || (paramApolloAIMessage.jdField_a_of_type_Int != 1)) {
            break label569;
          }
          if ((!new File(paramApolloAIMessage.jdField_d_of_type_JavaLangString).exists()) || (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface == null)) {
            break label549;
          }
          ApolloActionManager.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
          this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface.b(5, null, 1, this.jdField_a_of_type_Int, (int)Math.ceil(paramApolloAIMessage.jdField_d_of_type_Int / 1000.0F) + "\"", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView != null) && ((this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView instanceof ApolloAIActivity)))
          {
            if (((ApolloAIActivity)this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView).jdField_a_of_type_Boolean) {
              break label540;
            }
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer.a(paramApolloAIMessage.jdField_d_of_type_JavaLangString, 0L);
              this.jdField_a_of_type_Boolean = false;
            }
            else if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.k()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.l())))
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer.a(paramApolloAIMessage.jdField_d_of_type_JavaLangString, 0L);
            }
          }
        }
        this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage = paramApolloAIMessage.a();
        return;
        f();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloAILogicProcessor", 2, "errInfo->audio file NOT exist.");
        return;
      } while (paramApolloAIMessage.jdField_a_of_type_Int <= 1);
    } while (!QLog.isColorLevel());
    label540:
    label549:
    label569:
    QLog.d("ApolloAILogicProcessor", 2, "MSG TYPE is unidentified, DISCARD it.");
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView != null) && ((this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView instanceof ApolloAIActivity)) && (((ApolloAIActivity)this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView).jdField_a_of_type_Boolean)) {
      return;
    }
    String[] arrayOfString = ApolloActionHelper.a(this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.g, this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_b_of_type_Int, this.jdField_a_of_type_Int, true);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface != null)
      {
        IRenderCommInterface localIRenderCommInterface = this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface;
        int i = this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_b_of_type_Int;
        int j = this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = (j + 1);
        localIRenderCommInterface.a(1, null, i, j, arrayOfString[0], arrayOfString[1]);
      }
      return;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "[doReset]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer.a();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView.e();
      }
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "[onMsgFinish]");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_c_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView.b(this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage.a());
      }
      b((ApolloAIMessage)this.jdField_a_of_type_JavaUtilList.remove(0));
      return;
    }
    b();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "[onCompletion]");
    }
    f();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView == null) {}
    do
    {
      return;
      paramString = this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView.a();
      if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage != null)) {
        paramString.a(1, this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.g + "_" + this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_b_of_type_Int);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage != null) && ((this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_c_of_type_Int == 5) || (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_a_of_type_Boolean)))
      {
        f();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_c_of_type_Int != 1)) {
        break label158;
      }
      this.jdField_c_of_type_Int += 1;
      if (this.jdField_c_of_type_Int <= 3) {
        break;
      }
      this.jdField_c_of_type_Int = 0;
    } while (paramString == null);
    paramString.b();
    return;
    d();
    return;
    label158:
    this.jdField_c_of_type_Int = 0;
    d();
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, int[] paramArrayOfInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "[loadXiaoIce], scale:" + paramFloat1 + ",xPos:" + paramFloat2 + ",yPos:" + paramFloat3 + ",mRender:" + this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface + "roleID:" + paramInt + ",dressIDs:" + paramArrayOfInt);
    }
    this.jdField_a_of_type_Int = paramInt;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface != null) && (paramArrayOfInt != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface.a(1, null, paramInt, paramFloat1, paramFloat2, paramFloat3);
        this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface.a(1, null, paramArrayOfInt, null);
      }
      return;
    }
  }
  
  public void a(IRenderCommInterface paramIRenderCommInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface = paramIRenderCommInterface;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "[setRender], render:" + paramIRenderCommInterface);
    }
  }
  
  public void a(ApolloAIMessage paramApolloAIMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "[expressMsg],aiResponses:" + paramApolloAIMessage.toString());
    }
    if ((paramApolloAIMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "mStatus:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) && (!paramApolloAIMessage.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramApolloAIMessage);
      return;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView != null) && (paramApolloAIMessage.jdField_c_of_type_Boolean) && (paramApolloAIMessage.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_c_of_type_Int == 4)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView.b(this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage.a());
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaUtilList.clear();
    b(paramApolloAIMessage);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(boolean paramBoolean, ApolloAIMessage paramApolloAIMessage)
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "[onBubbleClicked],isFromHistory:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer == null) {
      return;
    }
    int k;
    int i;
    int m;
    int j;
    if (paramBoolean)
    {
      k = 1;
      if ((!paramBoolean) || (paramApolloAIMessage == null)) {
        break label215;
      }
      i = paramApolloAIMessage.jdField_b_of_type_Int;
      if ((TextUtils.isEmpty(paramApolloAIMessage.jdField_c_of_type_JavaLangString)) || (!(this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView instanceof ApolloAIActivity))) {
        break label148;
      }
      ApolloAIActivity localApolloAIActivity = (ApolloAIActivity)this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView;
      a(paramApolloAIMessage.jdField_c_of_type_JavaLangString, localApolloAIActivity);
      m = 0;
      j = i;
      i = m;
    }
    for (;;)
    {
      VipUtils.a(null, "cmshow", "Apollo", "clk_msg", k, i, new String[] { String.valueOf(j) });
      return;
      k = 0;
      break;
      label148:
      j = i;
      if (paramApolloAIMessage.jdField_a_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer.a(paramApolloAIMessage.jdField_d_of_type_JavaLangString)) {
          e();
        }
        for (j = 1;; j = 0)
        {
          m = i;
          i = j;
          j = m;
          break;
          b();
          this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer.a(paramApolloAIMessage.jdField_d_of_type_JavaLangString, 0L);
        }
        label215:
        if (this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage == null) {
          break label389;
        }
        i = this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_b_of_type_Int;
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_c_of_type_JavaLangString)) && ((this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView instanceof ApolloAIActivity)))
        {
          paramApolloAIMessage = (ApolloAIActivity)this.jdField_a_of_type_ComTencentMobileqqApolloAiIApolloAIView;
          a(this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_c_of_type_JavaLangString, paramApolloAIMessage);
          j = i;
          i = 0;
          continue;
        }
        j = i;
        if (this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_a_of_type_Int == 1)
        {
          if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
          {
            b((ApolloAIMessage)this.jdField_a_of_type_JavaUtilList.remove(0));
            j = i;
            i = 1;
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer.a(this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_d_of_type_JavaLangString))
          {
            b();
            j = i;
            i = 1;
            continue;
          }
          b(this.jdField_b_of_type_ComTencentMobileqqApolloAiApolloAIMessage);
          j = i;
          i = 0;
          continue;
        }
      }
      i = 0;
      continue;
      label389:
      j = 0;
      i = 0;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "[restoreDefault]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.g = 8;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    e();
    d();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "[onDestroy]");
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer.b();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ai.ApolloAILogicProcessor
 * JD-Core Version:    0.7.0.1
 */