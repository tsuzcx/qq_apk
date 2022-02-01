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
  public static EmptyDrawable j = new EmptyDrawable(-2236446, 100, 100);
  static int s;
  Thread A = new NowVideoView.3(this);
  int a;
  int b;
  public String c;
  public String d;
  public String e;
  NowLiveManager f;
  public String g;
  QQAppInterface h;
  public List<String> i = new ArrayList();
  MessageRecord k;
  boolean l = false;
  Handler m = new NowVideoView.1(this);
  QQLiveDrawable.OnStateListener n = new NowVideoView.2(this);
  int o = 0;
  int p = 0;
  int q = 0;
  int r = 0;
  ImageView t;
  int u = 0;
  QQLiveDrawable.QQLiveDrawableParams v;
  public NowVideoView.ThirdDataSourceAdapter w = new NowVideoView.ThirdDataSourceAdapter(this);
  RotateAnimation x;
  long y = 0L;
  AtomicBoolean z = new AtomicBoolean();
  
  public NowVideoView(Context paramContext)
  {
    super(paramContext);
    NowVideoController.a().a(this);
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqlive://msgId=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
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
      this.f.a(this.k.frienduin, this.c, this.d, this.k.time, true);
    }
  }
  
  public void a(ImageView paramImageView)
  {
    this.t = paramImageView;
  }
  
  public void a(QQAppInterface paramQQAppInterface, StructMsgItemLive paramStructMsgItemLive, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.k != null) && (paramMessageRecord.uniseq == this.k.uniseq)) {
      return;
    }
    this.h = paramQQAppInterface;
    this.a = paramStructMsgItemLive.az;
    this.b = paramStructMsgItemLive.aA;
    if (this.a == 0)
    {
      this.b = 800;
      this.a = 640;
    }
    this.c = paramStructMsgItemLive.au;
    this.d = paramStructMsgItemLive.ay;
    this.e = paramStructMsgItemLive.av;
    if ((paramMessageRecord != null) && (paramMessageRecord.uniseq == 0L))
    {
      this.g = UUID.randomUUID().toString();
    }
    else if (paramMessageRecord != null)
    {
      paramStructMsgItemLive = new StringBuilder();
      paramStructMsgItemLive.append("");
      paramStructMsgItemLive.append(paramMessageRecord.uniseq);
      this.g = paramStructMsgItemLive.toString();
    }
    this.k = paramMessageRecord;
    if (this.f == null) {
      this.f = ((NowLiveManager)paramQQAppInterface.getManager(QQManagerFactory.NOW_LIVE_MANAGER));
    }
    setImageDrawable(b(this.e));
    if (s == 0) {
      s = getResources().getDimensionPixelSize(2131299920);
    }
    this.f.addObserver(this);
    this.i.clear();
    if (this.f.a(this.k.frienduin, this.k.time)) {
      NowVideoController.a().b();
    }
    this.q = 0;
    this.r = 0;
    this.l = false;
    paramQQAppInterface = this.t;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.clearAnimation();
    }
    this.p = 0;
    this.o = 0;
    paramQQAppInterface = this.z;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.set(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.u < 3))
    {
      b();
      this.u += 1;
      return;
    }
    b();
  }
  
  public boolean a(int paramInt)
  {
    ViewParent localViewParent = getParent();
    if (paramInt == 3)
    {
      ImageView localImageView = this.t;
      if (localImageView != null)
      {
        localImageView.clearAnimation();
        this.t.setImageResource(2130844327);
        this.t.setVisibility(0);
      }
    }
    if ((localViewParent != null) && ((localViewParent instanceof NowVideoLayout)))
    {
      ((NowVideoLayout)localViewParent).a(paramInt, this.k.senderuin);
      return true;
    }
    return false;
  }
  
  public Drawable b(String paramString)
  {
    EmptyDrawable localEmptyDrawable = j;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = URLDrawable.getDrawable(paramString, j, j);
      return paramString;
    }
    catch (Exception paramString)
    {
      label24:
      break label24;
    }
    localEmptyDrawable = j;
    return localEmptyDrawable;
  }
  
  public void b()
  {
    if (!NetworkUtil.isNetworkAvailable(getContext()))
    {
      QQToast.makeText(getContext(), 1, 2131892104, 0).show(s);
      return;
    }
    boolean bool = this.f.a(this.k.frienduin, this.k.time);
    int i1 = 3;
    if (!bool)
    {
      if (TextUtils.isEmpty(this.d)) {
        i1 = 2;
      }
      a(i1);
      d();
      return;
    }
    Object localObject1 = this.f.b(this.k.frienduin, this.k.time);
    Object localObject2;
    if ((((NowLiveManager.NowLiveInfo)localObject1).d != 2) && (((NowLiveManager.NowLiveInfo)localObject1).d != 1))
    {
      this.i = new ArrayList(((NowLiveManager.NowLiveInfo)localObject1).e);
      if (this.i.size() == 0)
      {
        this.f.a(this.k.frienduin, this.c, this.d, this.k.time, true);
        return;
      }
      localObject1 = e();
      if (localObject1 != null)
      {
        ((QQLiveDrawable)localObject1).resume();
        return;
      }
      localObject2 = getQQLiveDrawableParams();
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = b(this.e);
      localObject2 = a(this.g);
    }
    try
    {
      localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
      setImageDrawable((Drawable)localObject1);
      localObject1 = e();
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
    if (TextUtils.isEmpty(this.d)) {
      i1 = 2;
    }
    a(i1);
    d();
  }
  
  public void c()
  {
    Object localObject1 = e();
    if (localObject1 != null)
    {
      ((QQLiveDrawable)localObject1).pause();
      return;
    }
    Object localObject2 = getQQLiveDrawableParams();
    ((QQLiveDrawable.QQLiveDrawableParams)localObject2).mPlayPause = true;
    localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
    localObject2 = a(this.g);
    try
    {
      localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
      if ((((URLDrawable)localObject1).getStatus() == 1) && (e() != null))
      {
        setImageDrawable((Drawable)localObject1);
        return;
      }
      setImageDrawable(b(this.e));
      localObject1 = this.t;
      if (localObject1 != null)
      {
        ((ImageView)localObject1).clearAnimation();
        this.t.setImageResource(2130844327);
        this.t.setVisibility(0);
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
      setImageDrawable(b(this.e));
      ImageView localImageView = this.t;
      if (localImageView != null)
      {
        localImageView.clearAnimation();
        this.t.setImageResource(2130844327);
        this.t.setVisibility(0);
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
    this.y = System.currentTimeMillis();
    if ((!this.z.get()) && (this.p == 2)) {
      ThreadManager.post(this.A, 5, null, true);
    }
  }
  
  public QQLiveDrawable e()
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
  
  public void f()
  {
    this.i.clear();
    Object localObject = this.f;
    if (localObject != null)
    {
      ((NowLiveManager)localObject).deleteObserver(this);
      localObject = this.f.b(this.k.frienduin, this.k.time);
      if (localObject != null) {
        ((NowLiveManager.NowLiveInfo)localObject).e.clear();
      }
    }
    this.h = null;
    localObject = e();
    if (localObject != null)
    {
      ((QQLiveDrawable)localObject).setOnStateListener(null);
      ((QQLiveDrawable)localObject).setParams(null);
      ((QQLiveDrawable)localObject).release();
    }
    localObject = getQQLiveDrawableParams();
    if (localObject != null)
    {
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mListener = null;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDataSourceAdapter = null;
    }
    setImageDrawable(null);
    this.l = true;
    this.m.removeMessages(1003);
    this.p = 0;
    localObject = this.z;
    if (localObject != null) {
      ((AtomicBoolean)localObject).set(false);
    }
  }
  
  QQLiveDrawable.QQLiveDrawableParams getQQLiveDrawableParams()
  {
    if (this.v == null) {
      this.v = new QQLiveDrawable.QQLiveDrawableParams();
    }
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = this.v;
    int i2 = this.a;
    int i1 = i2;
    if (i2 == 0) {
      i1 = 400;
    }
    localQQLiveDrawableParams.mPreviewWidth = i1;
    localQQLiveDrawableParams = this.v;
    i2 = this.b;
    i1 = i2;
    if (i2 == 0) {
      i1 = 200;
    }
    localQQLiveDrawableParams.mPreviewHeight = i1;
    localQQLiveDrawableParams = this.v;
    localQQLiveDrawableParams.mPlayPause = false;
    localQQLiveDrawableParams.mListener = this.n;
    localQQLiveDrawableParams.mDataSourceType = 2;
    localQQLiveDrawableParams.mDataSourceAdapter = this.w;
    localQQLiveDrawableParams.mDataSource = this.c;
    localQQLiveDrawableParams.mCoverUrl = this.e;
    localQQLiveDrawableParams.mCoverLoadingDrawable = j;
    localQQLiveDrawableParams.mPlayType = 3;
    return localQQLiveDrawableParams;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i1 = ((Integer)paramObject[0]).intValue();
    boolean bool = ((Boolean)paramObject[1]).booleanValue();
    paramObservable = (NowLiveManager.NowLiveInfo)paramObject[2];
    if (paramObservable == null) {
      return;
    }
    if (this.k.frienduin.equals(paramObservable.a))
    {
      if (this.k.time != paramObservable.b) {
        return;
      }
      if (bool)
      {
        if (i1 == 1001)
        {
          if (!this.f.a(this.k.frienduin, this.k.time)) {
            return;
          }
          paramObservable = paramObservable.e;
          if ((paramObservable != null) && (paramObservable.size() > 0))
          {
            this.i = new ArrayList(paramObservable);
            if (!this.w.a())
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
        else if (i1 == 1003)
        {
          int i2 = paramObservable.d;
          i1 = 3;
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
            paramObject.append(i2);
            QLog.d("NowVideoView", 2, paramObject.toString());
          }
          if ((i2 != 1) && (i2 != 2))
          {
            if (i2 == 3)
            {
              if (this.q < 3)
              {
                long l1 = (new Random(System.currentTimeMillis()).nextInt(6) + 5) * 1000;
                this.m.sendEmptyMessageDelayed(1002, l1);
                this.q += 1;
              }
              else
              {
                d();
              }
              paramObservable = this.t;
              if (paramObservable != null)
              {
                paramObservable.clearAnimation();
                this.t.setImageResource(2130844327);
                this.t.setVisibility(0);
              }
            }
            else if (i2 == 0)
            {
              a(1);
              if (!NowVideoController.a().a(getContext(), this))
              {
                paramObject = this.t;
                if (paramObject != null)
                {
                  paramObject.clearAnimation();
                  this.t.setImageResource(2130844327);
                  this.t.setVisibility(0);
                  return;
                }
              }
              if (bool)
              {
                if (this.r < 3)
                {
                  this.i = new ArrayList(paramObservable.e);
                  if (this.i.size() == 0) {
                    this.f.a(this.k.frienduin, this.c, this.k.time);
                  }
                  this.q += 1;
                  return;
                }
                QQToast.makeText(getContext(), 1, HardCodeUtil.a(2131905493), 1).show();
              }
            }
          }
          else
          {
            if (TextUtils.isEmpty(this.d)) {
              i1 = 2;
            }
            a(i1);
            d();
          }
        }
      }
      else if (i1 == 1001)
      {
        if (!this.f.a(this.k.frienduin, this.k.time)) {
          return;
        }
        d();
        QQToast.makeText(getContext(), HardCodeUtil.a(2131905492), 0).show();
        paramObservable = this.t;
        if (paramObservable != null)
        {
          paramObservable.clearAnimation();
          this.t.setVisibility(0);
          this.t.setImageResource(2130844323);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoView
 * JD-Core Version:    0.7.0.1
 */