package com.tencent.biz.now;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.image.QQLiveDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NowVideoController
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static NowVideoController jdField_a_of_type_ComTencentBizNowNowVideoController;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = new NowVideoController.1(this, Looper.getMainLooper());
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  List<WeakReference<NowVideoView>> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public boolean b = true;
  
  public NowVideoController()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static NowVideoController a()
  {
    if (jdField_a_of_type_ComTencentBizNowNowVideoController == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizNowNowVideoController == null) {
          jdField_a_of_type_ComTencentBizNowNowVideoController = new NowVideoController();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizNowNowVideoController;
  }
  
  private void e()
  {
    QLog.d("NowVideoController", 2, "Check play()");
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localObject1 != null)
    {
      if (((SessionInfo)localObject1).a != 0) {
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentWidgetAbsListView;
      int k = ((AbsListView)localObject1).getFirstVisiblePosition();
      int m = ((AbsListView)localObject1).getLastVisiblePosition();
      int i = k;
      while (i <= m)
      {
        Object localObject2 = ((AbsListView)localObject1).getChildAt(i - k);
        if (localObject2 != null)
        {
          localObject2 = ((View)localObject2).findViewById(2131377986);
          if ((localObject2 instanceof NowVideoView))
          {
            localObject2 = (NowVideoView)localObject2;
            ((NowVideoView)localObject2).getGlobalVisibleRect(jdField_a_of_type_AndroidGraphicsRect);
            ((NowVideoView)localObject2).getHeight();
            int j;
            if (jdField_a_of_type_AndroidGraphicsRect.height() > 0) {
              j = 1;
            } else {
              j = 0;
            }
            if (a(((NowVideoView)localObject2).getContext(), (NowVideoView)localObject2))
            {
              if (j != 0)
              {
                ((NowVideoView)localObject2).a(true);
              }
              else
              {
                localObject2 = ((NowVideoView)localObject2).a();
                if ((localObject2 != null) && (!((QQLiveDrawable)localObject2).isPaused())) {
                  ((QQLiveDrawable)localObject2).pause();
                }
              }
            }
            else {
              ((NowVideoView)localObject2).a();
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
    if (QLog.isColorLevel()) {
      QLog.d("NowVideoController", 2, "#requestPlayCheck():# ");
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      if (!((QQAppInterface)localObject).getMessageFacade().a()) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (localObject != null)
      {
        if (((SessionInfo)localObject).a != 1008) {
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentWidgetAbsListView;
        if (localObject != null)
        {
          int i = ((AbsListView)localObject).getFirstVisiblePosition();
          int j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getLastVisiblePosition();
          this.jdField_a_of_type_ComTencentWidgetAbsListView.postDelayed(new NowVideoController.3(this, i, j), paramLong);
        }
      }
    }
  }
  
  public void a(NowVideoView paramNowVideoView)
  {
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramNowVideoView));
  }
  
  public void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentWidgetAbsListView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.b = true;
      e();
      return;
    }
    this.b = false;
  }
  
  public boolean a(Context paramContext, NowVideoView paramNowVideoView)
  {
    return NetworkUtil.isWifiConnected(paramContext);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowVideoController", 2, "onNetWifi2Mobile(): ====>");
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localQQAppInterface != null) && (this.jdField_a_of_type_ComTencentWidgetAbsListView != null))
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      if (!localQQAppInterface.getMessageFacade().a()) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      d();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((NowVideoView)localWeakReference.get()).e();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentWidgetAbsListView = null;
    this.b = true;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
  }
  
  public void d()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      if (!localQQAppInterface.getMessageFacade().a()) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentWidgetAbsListView != null) && (BaseActivity.sTopActivity != null))
      {
        int i = this.jdField_a_of_type_ComTencentWidgetAbsListView.getFirstVisiblePosition();
        int j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getLastVisiblePosition();
        BaseActivity.sTopActivity.runOnUiThread(new NowVideoController.2(this, i, j));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoController
 * JD-Core Version:    0.7.0.1
 */