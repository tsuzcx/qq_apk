package com.tencent.biz.now;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewParent;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.structmsg.StructMsgItemLive;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class NowVideoView
  extends PAImageView
  implements Observer
{
  public static EmptyDrawable a;
  static int g;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  Handler jdField_a_of_type_AndroidOsHandler = new NowVideoView.1(this);
  RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  NowLiveManager jdField_a_of_type_ComTencentBizNowNowLiveManager;
  public NowVideoView.ThirdDataSourceAdapter a;
  QQLiveDrawable.OnStateListener jdField_a_of_type_ComTencentImageQQLiveDrawable$OnStateListener = new NowVideoView.2(this);
  QQLiveDrawable.QQLiveDrawableParams jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  public String a;
  Thread jdField_a_of_type_JavaLangThread = new NowVideoView.3(this);
  public List<String> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  boolean jdField_a_of_type_Boolean = false;
  int b;
  public String b;
  int c;
  public String c;
  int d;
  public String d;
  int e = 0;
  int f = 0;
  int h = 0;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable = new EmptyDrawable(-2236446, 100, 100);
  }
  
  public NowVideoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizNowNowVideoView$ThirdDataSourceAdapter = new NowVideoView.ThirdDataSourceAdapter(this);
    NowVideoController.a().a(this);
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqlive://msgId=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public Drawable a(String paramString)
  {
    EmptyDrawable localEmptyDrawable = jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = URLDrawable.getDrawable(paramString, jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable, jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable);
      return paramString;
    }
    catch (Exception paramString)
    {
      label24:
      break label24;
    }
    localEmptyDrawable = jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
    return localEmptyDrawable;
  }
  
  QQLiveDrawable.QQLiveDrawableParams a()
  {
    if (this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams == null) {
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    }
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams;
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j == 0) {
      i = 400;
    }
    localQQLiveDrawableParams.mPreviewWidth = i;
    localQQLiveDrawableParams = this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams;
    j = this.jdField_b_of_type_Int;
    i = j;
    if (j == 0) {
      i = 200;
    }
    localQQLiveDrawableParams.mPreviewHeight = i;
    localQQLiveDrawableParams = this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams;
    localQQLiveDrawableParams.mPlayPause = false;
    localQQLiveDrawableParams.mListener = this.jdField_a_of_type_ComTencentImageQQLiveDrawable$OnStateListener;
    localQQLiveDrawableParams.mDataSourceType = 2;
    localQQLiveDrawableParams.mDataSourceAdapter = this.jdField_a_of_type_ComTencentBizNowNowVideoView$ThirdDataSourceAdapter;
    localQQLiveDrawableParams.mDataSource = this.jdField_a_of_type_JavaLangString;
    localQQLiveDrawableParams.mCoverUrl = this.jdField_c_of_type_JavaLangString;
    localQQLiveDrawableParams.mCoverLoadingDrawable = jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
    localQQLiveDrawableParams.mPlayType = 3;
    return localQQLiveDrawableParams;
  }
  
  public QQLiveDrawable a()
  {
    if ((getDrawable() != null) && ((getDrawable() instanceof URLDrawable)))
    {
      URLDrawable localURLDrawable = (URLDrawable)getDrawable();
      if ((localURLDrawable.getStatus() == 1) && ((localURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
        return (QQLiveDrawable)localURLDrawable.getCurrDrawable();
      }
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      c();
      return;
    }
    catch (Exception localException) {}
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoStateChange pre = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" cur = ");
      localStringBuilder.append(paramInt2);
      QLog.d("NowVideoView", 2, localStringBuilder.toString());
    }
    if (paramInt2 == 5) {
      this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time, true);
    }
  }
  
  public void a(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public void a(QQAppInterface paramQQAppInterface, StructMsgItemLive paramStructMsgItemLive, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (paramMessageRecord.uniseq == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramStructMsgItemLive.o;
    this.jdField_b_of_type_Int = paramStructMsgItemLive.p;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_b_of_type_Int = 800;
      this.jdField_a_of_type_Int = 640;
    }
    this.jdField_a_of_type_JavaLangString = paramStructMsgItemLive.ac;
    this.jdField_b_of_type_JavaLangString = paramStructMsgItemLive.ag;
    this.jdField_c_of_type_JavaLangString = paramStructMsgItemLive.ad;
    if ((paramMessageRecord != null) && (paramMessageRecord.uniseq == 0L))
    {
      this.jdField_d_of_type_JavaLangString = UUID.randomUUID().toString();
    }
    else if (paramMessageRecord != null)
    {
      paramStructMsgItemLive = new StringBuilder();
      paramStructMsgItemLive.append("");
      paramStructMsgItemLive.append(paramMessageRecord.uniseq);
      this.jdField_d_of_type_JavaLangString = paramStructMsgItemLive.toString();
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    if (this.jdField_a_of_type_ComTencentBizNowNowLiveManager == null) {
      this.jdField_a_of_type_ComTencentBizNowNowLiveManager = ((NowLiveManager)paramQQAppInterface.getManager(QQManagerFactory.NOW_LIVE_MANAGER));
    }
    setImageDrawable(a(this.jdField_c_of_type_JavaLangString));
    if (g == 0) {
      g = getResources().getDimensionPixelSize(2131299168);
    }
    this.jdField_a_of_type_ComTencentBizNowNowLiveManager.addObserver(this);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
      NowVideoController.a().a();
    }
    this.e = 0;
    this.f = 0;
    this.jdField_a_of_type_Boolean = false;
    paramQQAppInterface = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.clearAnimation();
    }
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    paramQQAppInterface = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.set(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.h < 3))
    {
      b();
      this.h += 1;
      return;
    }
    b();
  }
  
  public boolean a(int paramInt)
  {
    ViewParent localViewParent = getParent();
    if (paramInt == 3)
    {
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localImageView != null)
      {
        localImageView.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843373);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    if ((localViewParent != null) && ((localViewParent instanceof NowVideoLayout)))
    {
      ((NowVideoLayout)localViewParent).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (!NetworkUtil.isNetworkAvailable(getContext()))
    {
      QQToast.a(getContext(), 1, 2131694424, 0).b(g);
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
    int i = 3;
    if (!bool)
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        i = 2;
      }
      a(i);
      d();
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
    Object localObject2;
    if ((((NowLiveManager.NowLiveInfo)localObject1).jdField_a_of_type_Int != 2) && (((NowLiveManager.NowLiveInfo)localObject1).jdField_a_of_type_Int != 1))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(((NowLiveManager.NowLiveInfo)localObject1).jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time, true);
        return;
      }
      localObject1 = a();
      if (localObject1 != null)
      {
        ((QQLiveDrawable)localObject1).resume();
        return;
      }
      localObject2 = a();
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = a(this.jdField_c_of_type_JavaLangString);
      localObject2 = a(this.jdField_d_of_type_JavaLangString);
    }
    try
    {
      localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
      setImageDrawable((Drawable)localObject1);
      localObject1 = a();
      if (localObject1 != null) {
        ((QQLiveDrawable)localObject1).resume();
      }
      return;
    }
    catch (Exception localException)
    {
      label257:
      break label257;
    }
    a();
    return;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      i = 2;
    }
    a(i);
    d();
  }
  
  public void c()
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      ((QQLiveDrawable)localObject1).pause();
      return;
    }
    Object localObject2 = a();
    ((QQLiveDrawable.QQLiveDrawableParams)localObject2).mPlayPause = true;
    localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
    localObject2 = a(this.jdField_d_of_type_JavaLangString);
    try
    {
      localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
      if ((((URLDrawable)localObject1).getStatus() == 1) && (a() != null))
      {
        setImageDrawable((Drawable)localObject1);
        return;
      }
      setImageDrawable(a(this.jdField_c_of_type_JavaLangString));
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 != null)
      {
        ((ImageView)localObject1).clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843373);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void d()
  {
    try
    {
      c();
      label4:
      setImageDrawable(a(this.jdField_c_of_type_JavaLangString));
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localImageView != null)
      {
        localImageView.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843373);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      return;
    }
    catch (Exception localException)
    {
      break label4;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_d_of_type_Int == 2)) {
      ThreadManager.post(this.jdField_a_of_type_JavaLangThread, 5, null, true);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = this.jdField_a_of_type_ComTencentBizNowNowLiveManager;
    if (localObject != null)
    {
      ((NowLiveManager)localObject).deleteObserver(this);
      localObject = this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
      if (localObject != null) {
        ((NowLiveManager.NowLiveInfo)localObject).jdField_a_of_type_JavaUtilList.clear();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    localObject = a();
    if (localObject != null)
    {
      ((QQLiveDrawable)localObject).setOnStateListener(null);
      ((QQLiveDrawable)localObject).setParams(null);
      ((QQLiveDrawable)localObject).release();
    }
    localObject = a();
    if (localObject != null)
    {
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mListener = null;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDataSourceAdapter = null;
    }
    setImageDrawable(null);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
    this.jdField_d_of_type_Int = 0;
    localObject = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
    if (localObject != null) {
      ((AtomicBoolean)localObject).set(false);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    boolean bool = ((Boolean)paramObject[1]).booleanValue();
    paramObservable = (NowLiveManager.NowLiveInfo)paramObject[2];
    if (paramObservable == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin.equals(paramObservable.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time != paramObservable.jdField_a_of_type_Long) {
        return;
      }
      if (bool)
      {
        if (i == 1001)
        {
          if (!this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
            return;
          }
          paramObservable = paramObservable.jdField_a_of_type_JavaUtilList;
          if ((paramObservable != null) && (paramObservable.size() > 0))
          {
            this.jdField_a_of_type_JavaUtilList = new ArrayList(paramObservable);
            if (!this.jdField_a_of_type_ComTencentBizNowNowVideoView$ThirdDataSourceAdapter.a())
            {
              a(1);
              b();
            }
          }
          else
          {
            d();
          }
        }
        else if (i == 1003)
        {
          int j = paramObservable.jdField_a_of_type_Int;
          i = 3;
          paramObject = (Bundle)paramObject[3];
          if (paramObject != null) {
            bool = paramObject.getBoolean("needReqUrl");
          } else {
            bool = false;
          }
          if (QLog.isColorLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append("updateStatus state = ");
            paramObject.append(j);
            QLog.d("NowVideoView", 2, paramObject.toString());
          }
          if ((j != 1) && (j != 2))
          {
            if (j == 3)
            {
              if (this.e < 3)
              {
                long l = (new Random(System.currentTimeMillis()).nextInt(6) + 5) * 1000;
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, l);
                this.e += 1;
              }
              else
              {
                d();
              }
              paramObservable = this.jdField_a_of_type_AndroidWidgetImageView;
              if (paramObservable != null)
              {
                paramObservable.clearAnimation();
                this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843373);
                this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              }
            }
            else if (j == 0)
            {
              a(1);
              if (!NowVideoController.a().a(getContext(), this))
              {
                paramObject = this.jdField_a_of_type_AndroidWidgetImageView;
                if (paramObject != null)
                {
                  paramObject.clearAnimation();
                  this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843373);
                  this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
                  return;
                }
              }
              if (bool)
              {
                if (this.f < 3)
                {
                  this.jdField_a_of_type_JavaUtilList = new ArrayList(paramObservable.jdField_a_of_type_JavaUtilList);
                  if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
                    this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
                  }
                  this.e += 1;
                  return;
                }
                QQToast.a(getContext(), 1, HardCodeUtil.a(2131707679), 1).a();
              }
            }
          }
          else
          {
            if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              i = 2;
            }
            a(i);
            d();
          }
        }
      }
      else if (i == 1001)
      {
        if (!this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
          return;
        }
        d();
        QQToast.a(getContext(), HardCodeUtil.a(2131707678), 0).a();
        paramObservable = this.jdField_a_of_type_AndroidWidgetImageView;
        if (paramObservable != null)
        {
          paramObservable.clearAnimation();
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843369);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoView
 * JD-Core Version:    0.7.0.1
 */