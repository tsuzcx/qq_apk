package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.content.Context;
import android.support.v4.util.ArraySet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import onh;
import qty;
import qua;
import quc;
import ryw;
import ryx;
import ryz;
import rza;
import rzb;

public class VideoPlayManager
  implements quc
{
  private int jdField_a_of_type_Int = 1000;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<rzb> jdField_a_of_type_JavaUtilList;
  private Set<qty> jdField_a_of_type_JavaUtilSet = new ArraySet();
  private qua jdField_a_of_type_Qua;
  private ryx jdField_a_of_type_Ryx = new ryx(this, null);
  private ryz jdField_a_of_type_Ryz = new ryz(this, null);
  private rza jdField_a_of_type_Rza;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public VideoPlayManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Qua = new qua(paramContext.getApplicationContext());
    this.jdField_a_of_type_Qua.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private qty a(rza paramrza)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      localObject = null;
    }
    qty localqty;
    do
    {
      do
      {
        return localObject;
        localqty = new qty(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        localqty.a(this.jdField_a_of_type_Ryx);
        localObject = localqty;
      } while (paramrza == null);
      localObject = localqty;
    } while (!paramrza.jdField_f_of_type_Boolean);
    localqty.e(true);
    return localqty;
  }
  
  private void a(qty paramqty)
  {
    if (paramqty == null) {}
    int i;
    do
    {
      return;
      paramqty.a(null);
      paramqty.p();
      i = paramqty.e();
    } while ((i == 7) || (i == 8) || (i == 0) || (i == 6));
    paramqty.k();
    ThreadManager.excute(new VideoPlayManager.2(this, paramqty), 64, null, false);
  }
  
  private void d(rza paramrza)
  {
    if (rza.a(paramrza) == null)
    {
      ThreadManager.post(new VideoPlayManager.1(this, paramrza), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    rza.a(paramrza).a(paramrza.jdField_a_of_type_Ryw);
    e(paramrza);
  }
  
  private void e(rza paramrza)
  {
    if ((paramrza == null) || (rza.a(paramrza) == null)) {
      return;
    }
    paramrza.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
    }
    if (paramrza.jdField_a_of_type_AndroidViewView == null)
    {
      Object localObject = rza.a(paramrza).b();
      if (localObject == null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((rzb)((Iterator)localObject).next()).a(paramrza, 123, 99, null);
        }
        rza.a(paramrza, null);
        return;
      }
      paramrza.jdField_a_of_type_AndroidViewView = ((View)localObject);
      ((View)localObject).setId(2131374780);
      paramrza.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      rza.a(paramrza).a((IVideoViewBase)localObject);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((rzb)((Iterator)localObject).next()).b(paramrza);
      }
    }
    rza.a(paramrza).b(paramrza.jdField_f_of_type_Int);
    rza.a(paramrza).d(this.e);
    rza.a(paramrza).a().setOutputMute(paramrza.jdField_a_of_type_Boolean);
    paramrza.jdField_a_of_type_AndroidViewView.setVisibility(0);
    ThreadManager.excute(new VideoPlayManager.PlayStartVideoRunnable(this, paramrza), 64, null, true);
  }
  
  public int a()
  {
    if (a()) {
      return rza.a(this.jdField_a_of_type_Rza).e();
    }
    return -1;
  }
  
  public long a()
  {
    if (a()) {
      return rza.a(this.jdField_a_of_type_Rza).b();
    }
    return 0L;
  }
  
  public rza a()
  {
    return this.jdField_a_of_type_Rza;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Rza != null) && (rza.a(this.jdField_a_of_type_Rza) != null))
    {
      rza.a(this.jdField_a_of_type_Rza).f();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rzb)localIterator.next()).d(this.jdField_a_of_type_Rza);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Rza != null) && (rza.a(this.jdField_a_of_type_Rza) != null) && ((d()) || (e())))
    {
      rza.a(this.jdField_a_of_type_Rza).h();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rzb)localIterator.next()).a(this.jdField_a_of_type_Rza, paramInt);
      }
    }
  }
  
  public void a(rza paramrza)
  {
    this.jdField_a_of_type_Rza = paramrza;
    paramrza = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramrza.hasNext()) {
      ((rzb)paramrza.next()).a(this.jdField_a_of_type_Rza, false);
    }
  }
  
  public void a(rzb paramrzb)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramrzb);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (a()) {
      rza.a(this.jdField_a_of_type_Rza).d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Rza != null) && (rza.a(this.jdField_a_of_type_Rza) != null);
  }
  
  public long b()
  {
    if (a()) {
      return rza.a(this.jdField_a_of_type_Rza).a();
    }
    return 0L;
  }
  
  public void b()
  {
    a(2);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Rza != null) && (rza.a(this.jdField_a_of_type_Rza) != null) && ((c()) || (b())))
    {
      rza.a(this.jdField_a_of_type_Rza).g();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rzb)localIterator.next()).b(this.jdField_a_of_type_Rza, paramInt);
      }
    }
  }
  
  public void b(rza paramrza)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager playVideo");
    }
    Iterator localIterator;
    if ((paramrza != null) && (paramrza.jdField_a_of_type_Ryw != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() vid=" + paramrza.jdField_a_of_type_Ryw.a);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo: playerParam=" + paramrza);
      }
      this.jdField_a_of_type_Rza = paramrza;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((rzb)localIterator.next()).a(this.jdField_a_of_type_Rza, true);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
      }
      return;
    }
    if ((this.jdField_a_of_type_Qua != null) && (!this.jdField_a_of_type_Qua.a()))
    {
      this.jdField_a_of_type_Qua.a();
      return;
    }
    d(paramrza);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((a()) && (rza.a(this.jdField_a_of_type_Rza).a() != null)) {
      rza.a(this.jdField_a_of_type_Rza).a().setOutputMute(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (a()) && (rza.a(this.jdField_a_of_type_Rza).e() == 2);
  }
  
  public void c()
  {
    if (a())
    {
      a(rza.a(this.jdField_a_of_type_Rza));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rzb)localIterator.next()).e(this.jdField_a_of_type_Rza);
      }
      this.jdField_a_of_type_Rza.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
      this.jdField_a_of_type_Rza = null;
    }
    this.jdField_a_of_type_Ryz.removeMessages(0);
  }
  
  public void c(int paramInt)
  {
    if (a()) {
      rza.a(this.jdField_a_of_type_Rza).b(paramInt);
    }
  }
  
  public void c(rza paramrza)
  {
    if (paramrza != null) {
      a(rza.a(paramrza));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Rza != null) {
        d(this.jdField_a_of_type_Rza);
      }
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((rzb)localIterator.next()).a(this.jdField_a_of_type_Rza, 123, 99, null);
    }
    this.jdField_a_of_type_Rza = null;
  }
  
  public boolean c()
  {
    return (a()) && (rza.a(this.jdField_a_of_type_Rza).e() == 5);
  }
  
  public void d()
  {
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "doOnPause() isPlaying()=" + d());
    }
    if ((d()) || (e()))
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = false;
      b();
    }
  }
  
  public void d(int paramInt)
  {
    if (a()) {
      rza.a(this.jdField_a_of_type_Rza).a(paramInt);
    }
  }
  
  public boolean d()
  {
    return (a()) && (rza.a(this.jdField_a_of_type_Rza).e() == 3);
  }
  
  public void e()
  {
    this.c = true;
    if ((this.d) && (b())) {
      a();
    }
    label84:
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      this.d = false;
      return;
      if (this.jdField_f_of_type_Boolean)
      {
        AppRuntime localAppRuntime = onh.a();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {}
        for (boolean bool = ((QQAppInterface)localAppRuntime).c();; bool = false)
        {
          if (bool) {
            break label84;
          }
          this.jdField_a_of_type_Boolean = true;
          b(2);
          break;
        }
      }
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean e()
  {
    return (a()) && (rza.a(this.jdField_a_of_type_Rza).e() == 4);
  }
  
  public void f()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "doOnDestory: ");
    }
    this.b = true;
    c();
    if (this.jdField_a_of_type_Rza != null)
    {
      if (rza.a(this.jdField_a_of_type_Rza) != null)
      {
        rza.a(this.jdField_a_of_type_Rza).m();
        rza.a(this.jdField_a_of_type_Rza, null);
      }
      this.jdField_a_of_type_Rza = null;
    }
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        qty localqty = (qty)localIterator.next();
        if ((localqty != null) && (localqty.e() != 8)) {
          localqty.m();
        }
      }
    }
    if (this.jdField_a_of_type_Qua != null)
    {
      this.jdField_a_of_type_Qua.b();
      this.jdField_a_of_type_Qua = null;
    }
    this.jdField_a_of_type_Ryz.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */