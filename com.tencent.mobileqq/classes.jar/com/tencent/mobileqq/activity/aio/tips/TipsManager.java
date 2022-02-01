package com.tencent.mobileqq.activity.aio.tips;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;
import mqq.os.MqqHandler;

public class TipsManager
  implements Handler.Callback, TipsConstants
{
  private AIOTipsController jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  TipsBarTask jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XPanelContainer jdField_a_of_type_ComTencentWidgetXPanelContainer;
  private ArrayList<TipsTask> jdField_a_of_type_JavaUtilArrayList;
  private Observer jdField_a_of_type_JavaUtilObserver;
  protected final MqqHandler a;
  
  public TipsManager(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, AIOTipsController paramAIOTipsController, XPanelContainer paramXPanelContainer)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController = paramAIOTipsController;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = paramXPanelContainer;
  }
  
  public int a()
  {
    TipsBarTask localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask;
    if (localTipsBarTask != null) {
      return localTipsBarTask.b();
    }
    return -1;
  }
  
  public TipsBarTask a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask;
  }
  
  public void a()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController;
      if (localObject != null) {
        ((AIOTipsController)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask = null;
      a(2000, new Object[0]);
      return;
    }
    Object localObject = new TipsManager.2(this);
    this.jdField_a_of_type_MqqOsMqqHandler.post((Runnable)localObject);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TipsTask)((Iterator)localObject).next()).a(paramInt, paramVarArgs);
      }
    }
  }
  
  public void a(TipsTask paramTipsTask)
  {
    if (paramTipsTask == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramTipsTask)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramTipsTask);
    }
  }
  
  public boolean a(GrayTipsTask paramGrayTipsTask, Object... paramVarArgs)
  {
    if (paramGrayTipsTask != null)
    {
      if (!a(paramGrayTipsTask))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TipsManager", 2, "showGrayTips() failure: mTipsMgr not allow");
        }
        return false;
      }
      paramVarArgs = paramGrayTipsTask.a(paramVarArgs);
      if (paramVarArgs != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramVarArgs, paramVarArgs.selfuin);
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("showGrayTips() success: from ");
          paramVarArgs.append(paramGrayTipsTask.b());
          QLog.d("TipsManager", 2, paramVarArgs.toString());
        }
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("showGrayTips() failure: MessageRecord null, from ");
        paramVarArgs.append(paramGrayTipsTask.b());
        QLog.d("TipsManager", 2, paramVarArgs.toString());
      }
    }
    return false;
  }
  
  public boolean a(TipsBarTask paramTipsBarTask, Object... paramVarArgs)
  {
    if (AIOUtils.m) {
      return false;
    }
    if (paramTipsBarTask != null)
    {
      if (!a(paramTipsBarTask))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TipsManager", 2, "showTipsBar() failure: mTipsMgr not allow");
        }
        return false;
      }
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        paramVarArgs = paramTipsBarTask.a(paramVarArgs);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(paramVarArgs, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask, paramTipsBarTask);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask = paramTipsBarTask;
      }
      else
      {
        paramVarArgs = new TipsManager.1(this, paramTipsBarTask, paramVarArgs);
        this.jdField_a_of_type_MqqOsMqqHandler.post(paramVarArgs);
      }
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("showTipsBar() success: from ");
        paramVarArgs.append(paramTipsBarTask.b());
        QLog.d("TipsManager", 2, paramVarArgs.toString());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showTipsBar() failure: tipsBar == null");
    }
    return false;
  }
  
  boolean a(TipsTask paramTipsTask)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramTipsTask.b());
    ((StringBuilder)localObject1).append("");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    Object localObject3 = paramTipsTask.a();
    boolean bool1 = true;
    boolean bool2 = true;
    int i = -1;
    localObject1 = localObject2;
    int j = i;
    if (localObject3 != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask;
      if (localObject1 != null) {
        i = ((TipsBarTask)localObject1).b();
      }
      localObject1 = localObject2;
      j = 0;
      bool1 = bool2;
      while (j < localObject3.length)
      {
        localObject2 = localObject1;
        if (i == localObject3[j])
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(", not allowed by excludeType: ");
          ((StringBuilder)localObject2).append(localObject3[j]);
          ((StringBuilder)localObject2).append(" ");
          localObject2 = ((StringBuilder)localObject2).toString();
          bool1 = false;
        }
        j += 1;
        localObject1 = localObject2;
      }
      j = i;
    }
    localObject2 = localObject1;
    bool2 = bool1;
    if (bool1)
    {
      localObject2 = localObject1;
      bool2 = bool1;
      if ((paramTipsTask instanceof TipsBarTask))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask;
        localObject2 = localObject1;
        bool2 = bool1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          bool2 = bool1;
          if (((TipsBarTask)localObject3).a() > ((TipsBarTask)paramTipsTask).a())
          {
            paramTipsTask = new StringBuilder();
            paramTipsTask.append((String)localObject1);
            paramTipsTask.append(", not allowed: priority is low ");
            localObject2 = paramTipsTask.toString();
            bool2 = false;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramTipsTask = new StringBuilder();
      paramTipsTask.append("allowShow(): result = ");
      paramTipsTask.append(bool2);
      paramTipsTask.append(" | ");
      paramTipsTask.append((String)localObject2);
      paramTipsTask.append("|curTipsBarType");
      paramTipsTask.append(j);
      QLog.d("TipsManager", 2, paramTipsTask.toString());
    }
    return bool2;
  }
  
  public void b()
  {
    a(1004, new Object[0]);
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController;
    if (localObject != null) {
      ((AIOTipsController)localObject).a();
    }
    localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TipsManager
 * JD-Core Version:    0.7.0.1
 */