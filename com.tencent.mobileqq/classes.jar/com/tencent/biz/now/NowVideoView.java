package com.tencent.biz.now;

import alud;
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
import apkp;
import azwb;
import bdin;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
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
import nga;
import ngc;
import ngf;
import ngh;
import ngi;
import ngj;

public class NowVideoView
  extends PAImageView
  implements Observer
{
  public static apkp a;
  public static int g;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  public Handler a;
  public RotateAnimation a;
  public ImageView a;
  QQLiveDrawable.OnStateListener jdField_a_of_type_ComTencentImageQQLiveDrawable$OnStateListener = new ngi(this);
  QQLiveDrawable.QQLiveDrawableParams jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public MessageRecord a;
  public String a;
  Thread jdField_a_of_type_JavaLangThread = new NowVideoView.3(this);
  public List<String> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  public nga a;
  public ngj a;
  public boolean a;
  int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e = 0;
  public int f = 0;
  int h = 0;
  
  static
  {
    jdField_a_of_type_Apkp = new apkp(-2236446, 100, 100);
  }
  
  public NowVideoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new ngh(this);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Ngj = new ngj(this);
    ngf.a().a(this);
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqlive://msgId=").append(paramString);
    return localStringBuilder.toString();
  }
  
  public Drawable a(String paramString)
  {
    Object localObject = jdField_a_of_type_Apkp;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localObject = URLDrawable.getDrawable(paramString, jdField_a_of_type_Apkp, jdField_a_of_type_Apkp);
      return localObject;
    }
    catch (Exception paramString) {}
    return jdField_a_of_type_Apkp;
  }
  
  QQLiveDrawable.QQLiveDrawableParams a()
  {
    if (this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams == null) {
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    }
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams;
    if (this.jdField_a_of_type_Int == 0)
    {
      i = 400;
      localQQLiveDrawableParams.mPreviewWidth = i;
      localQQLiveDrawableParams = this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams;
      if (this.jdField_b_of_type_Int != 0) {
        break label151;
      }
    }
    label151:
    for (int i = 200;; i = this.jdField_b_of_type_Int)
    {
      localQQLiveDrawableParams.mPreviewHeight = i;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mPlayPause = false;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mListener = this.jdField_a_of_type_ComTencentImageQQLiveDrawable$OnStateListener;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mDataSourceType = 2;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mDataSourceAdapter = this.jdField_a_of_type_Ngj;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mDataSource = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mCoverUrl = this.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mCoverLoadingDrawable = jdField_a_of_type_Apkp;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mPlayType = 3;
      return this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams;
      i = this.jdField_a_of_type_Int;
      break;
    }
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
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowVideoView", 2, "onVideoStateChange pre = " + paramInt1 + " cur = " + paramInt2);
    }
    if (paramInt2 == 5) {
      this.jdField_a_of_type_Nga.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time, true);
    }
  }
  
  public void a(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public void a(QQAppInterface paramQQAppInterface, azwb paramazwb, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (paramMessageRecord.uniseq == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramazwb.k;
    this.jdField_b_of_type_Int = paramazwb.l;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_b_of_type_Int = 800;
      this.jdField_a_of_type_Int = 640;
    }
    this.jdField_a_of_type_JavaLangString = paramazwb.S;
    this.jdField_b_of_type_JavaLangString = paramazwb.W;
    this.jdField_c_of_type_JavaLangString = paramazwb.T;
    if ((paramMessageRecord != null) && (paramMessageRecord.uniseq == 0L)) {
      this.jdField_d_of_type_JavaLangString = UUID.randomUUID().toString();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if (this.jdField_a_of_type_Nga == null) {
        this.jdField_a_of_type_Nga = ((nga)paramQQAppInterface.getManager(171));
      }
      setImageDrawable(a(this.jdField_c_of_type_JavaLangString));
      if (g == 0) {
        g = getResources().getDimensionPixelSize(2131298914);
      }
      this.jdField_a_of_type_Nga.addObserver(this);
      this.jdField_a_of_type_JavaUtilList.clear();
      if (this.jdField_a_of_type_Nga.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
        ngf.a().a();
      }
      this.e = 0;
      this.f = 0;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      }
      this.jdField_d_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
      if (paramMessageRecord != null) {
        this.jdField_d_of_type_JavaLangString = ("" + paramMessageRecord.uniseq);
      }
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
    if ((paramInt == 3) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842836);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
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
    int i = 2;
    if (!bdin.g(getContext())) {
      QQToast.a(getContext(), 1, 2131694768, 0).b(g);
    }
    for (;;)
    {
      return;
      if (!this.jdField_a_of_type_Nga.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time))
      {
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
        for (;;)
        {
          a(i);
          d();
          return;
          i = 3;
        }
      }
      Object localObject1 = this.jdField_a_of_type_Nga.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
      if ((((ngc)localObject1).jdField_a_of_type_Int == 2) || (((ngc)localObject1).jdField_a_of_type_Int == 1))
      {
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
        for (;;)
        {
          a(i);
          d();
          return;
          i = 3;
        }
      }
      this.jdField_a_of_type_JavaUtilList = new ArrayList(((ngc)localObject1).jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        this.jdField_a_of_type_Nga.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time, true);
        return;
      }
      localObject1 = a();
      if (localObject1 != null)
      {
        ((QQLiveDrawable)localObject1).resume();
        return;
      }
      Object localObject2 = a();
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = a(this.jdField_c_of_type_JavaLangString);
      localObject2 = a(this.jdField_d_of_type_JavaLangString);
      try
      {
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        setImageDrawable((Drawable)localObject1);
        localObject1 = a();
        if (localObject1 != null)
        {
          ((QQLiveDrawable)localObject1).resume();
          return;
        }
      }
      catch (Exception localException)
      {
        a();
      }
    }
  }
  
  public void c()
  {
    Object localObject1 = a();
    if (localObject1 != null) {
      ((QQLiveDrawable)localObject1).pause();
    }
    for (;;)
    {
      return;
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
        if (this.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842836);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void d()
  {
    try
    {
      c();
      label4:
      setImageDrawable(a(this.jdField_c_of_type_JavaLangString));
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842836);
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
    if (this.jdField_a_of_type_Nga != null)
    {
      this.jdField_a_of_type_Nga.deleteObserver(this);
      localObject = this.jdField_a_of_type_Nga.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
      if (localObject != null) {
        ((ngc)localObject).jdField_a_of_type_JavaUtilList.clear();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    Object localObject = a();
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
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    boolean bool = ((Boolean)paramObject[1]).booleanValue();
    paramObservable = (ngc)paramObject[2];
    if (paramObservable == null) {}
    label40:
    do
    {
      do
      {
        do
        {
          break label40;
          break label40;
          break label40;
          break label40;
          break label40;
          do
          {
            return;
          } while ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin.equals(paramObservable.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time != paramObservable.jdField_a_of_type_Long));
          if (!bool) {
            break label520;
          }
          if (i != 1001) {
            break;
          }
        } while (!this.jdField_a_of_type_Nga.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time));
        paramObservable = paramObservable.jdField_a_of_type_JavaUtilList;
        if ((paramObservable == null) || (paramObservable.size() <= 0)) {
          break;
        }
        this.jdField_a_of_type_JavaUtilList = new ArrayList(paramObservable);
      } while (this.jdField_a_of_type_Ngj.a());
      a(1);
      b();
      return;
      d();
      return;
    } while (i != 1003);
    i = paramObservable.jdField_a_of_type_Int;
    paramObject = (Bundle)paramObject[3];
    if (paramObject != null) {}
    for (bool = paramObject.getBoolean("needReqUrl");; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NowVideoView", 2, "updateStatus state = " + i);
      }
      if ((i == 1) || (i == 2))
      {
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
        for (i = 2;; i = 3)
        {
          a(i);
          d();
          return;
        }
      }
      if (i == 3)
      {
        if (this.e < 3)
        {
          long l = (new Random(System.currentTimeMillis()).nextInt(6) + 5) * 1000;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, l);
          this.e += 1;
        }
        while (this.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842836);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
          d();
        }
        break label40;
      }
      if (i != 0) {
        break;
      }
      a(1);
      if ((!ngf.a().a(getContext(), this)) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842836);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      if (!bool) {
        break;
      }
      if (this.f < 3)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList(paramObservable.jdField_a_of_type_JavaUtilList);
        if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
          this.jdField_a_of_type_Nga.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
        }
        this.e += 1;
        return;
      }
      QQToast.a(getContext(), 1, alud.a(2131708069), 1).a();
      return;
      label520:
      if ((i != 1001) || (!this.jdField_a_of_type_Nga.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time))) {
        break;
      }
      d();
      QQToast.a(getContext(), alud.a(2131708068), 0).a();
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842832);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoView
 * JD-Core Version:    0.7.0.1
 */