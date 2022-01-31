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
import onk;
import qub;
import qud;
import quf;
import ryz;
import rza;
import rzc;
import rzd;
import rze;

public class VideoPlayManager
  implements quf
{
  private int jdField_a_of_type_Int = 1000;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<rze> jdField_a_of_type_JavaUtilList;
  private Set<qub> jdField_a_of_type_JavaUtilSet = new ArraySet();
  private qud jdField_a_of_type_Qud;
  private rza jdField_a_of_type_Rza = new rza(this, null);
  private rzc jdField_a_of_type_Rzc = new rzc(this, null);
  private rzd jdField_a_of_type_Rzd;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public VideoPlayManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Qud = new qud(paramContext.getApplicationContext());
    this.jdField_a_of_type_Qud.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private qub a(rzd paramrzd)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      localObject = null;
    }
    qub localqub;
    do
    {
      do
      {
        return localObject;
        localqub = new qub(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        localqub.a(this.jdField_a_of_type_Rza);
        localObject = localqub;
      } while (paramrzd == null);
      localObject = localqub;
    } while (!paramrzd.jdField_f_of_type_Boolean);
    localqub.e(true);
    return localqub;
  }
  
  private void a(qub paramqub)
  {
    if (paramqub == null) {}
    int i;
    do
    {
      return;
      paramqub.a(null);
      paramqub.p();
      i = paramqub.e();
    } while ((i == 7) || (i == 8) || (i == 0) || (i == 6));
    paramqub.k();
    ThreadManager.excute(new VideoPlayManager.2(this, paramqub), 64, null, false);
  }
  
  private void d(rzd paramrzd)
  {
    if (rzd.a(paramrzd) == null)
    {
      ThreadManager.post(new VideoPlayManager.1(this, paramrzd), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    rzd.a(paramrzd).a(paramrzd.jdField_a_of_type_Ryz);
    e(paramrzd);
  }
  
  private void e(rzd paramrzd)
  {
    if ((paramrzd == null) || (rzd.a(paramrzd) == null)) {
      return;
    }
    paramrzd.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
    }
    if (paramrzd.jdField_a_of_type_AndroidViewView == null)
    {
      Object localObject = rzd.a(paramrzd).b();
      if (localObject == null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((rze)((Iterator)localObject).next()).a(paramrzd, 123, 99, null);
        }
        rzd.a(paramrzd, null);
        return;
      }
      paramrzd.jdField_a_of_type_AndroidViewView = ((View)localObject);
      ((View)localObject).setId(2131374778);
      paramrzd.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      rzd.a(paramrzd).a((IVideoViewBase)localObject);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((rze)((Iterator)localObject).next()).b(paramrzd);
      }
    }
    rzd.a(paramrzd).b(paramrzd.jdField_f_of_type_Int);
    rzd.a(paramrzd).d(this.e);
    rzd.a(paramrzd).a().setOutputMute(paramrzd.jdField_a_of_type_Boolean);
    paramrzd.jdField_a_of_type_AndroidViewView.setVisibility(0);
    ThreadManager.excute(new VideoPlayManager.PlayStartVideoRunnable(this, paramrzd), 64, null, true);
  }
  
  public int a()
  {
    if (a()) {
      return rzd.a(this.jdField_a_of_type_Rzd).e();
    }
    return -1;
  }
  
  public long a()
  {
    if (a()) {
      return rzd.a(this.jdField_a_of_type_Rzd).b();
    }
    return 0L;
  }
  
  public rzd a()
  {
    return this.jdField_a_of_type_Rzd;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Rzd != null) && (rzd.a(this.jdField_a_of_type_Rzd) != null))
    {
      rzd.a(this.jdField_a_of_type_Rzd).f();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rze)localIterator.next()).d(this.jdField_a_of_type_Rzd);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Rzd != null) && (rzd.a(this.jdField_a_of_type_Rzd) != null) && ((d()) || (e())))
    {
      rzd.a(this.jdField_a_of_type_Rzd).h();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rze)localIterator.next()).a(this.jdField_a_of_type_Rzd, paramInt);
      }
    }
  }
  
  public void a(rzd paramrzd)
  {
    this.jdField_a_of_type_Rzd = paramrzd;
    paramrzd = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramrzd.hasNext()) {
      ((rze)paramrzd.next()).a(this.jdField_a_of_type_Rzd, false);
    }
  }
  
  public void a(rze paramrze)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramrze);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (a()) {
      rzd.a(this.jdField_a_of_type_Rzd).d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Rzd != null) && (rzd.a(this.jdField_a_of_type_Rzd) != null);
  }
  
  public long b()
  {
    if (a()) {
      return rzd.a(this.jdField_a_of_type_Rzd).a();
    }
    return 0L;
  }
  
  public void b()
  {
    a(2);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Rzd != null) && (rzd.a(this.jdField_a_of_type_Rzd) != null) && ((c()) || (b())))
    {
      rzd.a(this.jdField_a_of_type_Rzd).g();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rze)localIterator.next()).b(this.jdField_a_of_type_Rzd, paramInt);
      }
    }
  }
  
  public void b(rzd paramrzd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager playVideo");
    }
    Iterator localIterator;
    if ((paramrzd != null) && (paramrzd.jdField_a_of_type_Ryz != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() vid=" + paramrzd.jdField_a_of_type_Ryz.a);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo: playerParam=" + paramrzd);
      }
      this.jdField_a_of_type_Rzd = paramrzd;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((rze)localIterator.next()).a(this.jdField_a_of_type_Rzd, true);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
      }
      return;
    }
    if ((this.jdField_a_of_type_Qud != null) && (!this.jdField_a_of_type_Qud.a()))
    {
      this.jdField_a_of_type_Qud.a();
      return;
    }
    d(paramrzd);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((a()) && (rzd.a(this.jdField_a_of_type_Rzd).a() != null)) {
      rzd.a(this.jdField_a_of_type_Rzd).a().setOutputMute(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (a()) && (rzd.a(this.jdField_a_of_type_Rzd).e() == 2);
  }
  
  public void c()
  {
    if (a())
    {
      a(rzd.a(this.jdField_a_of_type_Rzd));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rze)localIterator.next()).e(this.jdField_a_of_type_Rzd);
      }
      this.jdField_a_of_type_Rzd.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
      this.jdField_a_of_type_Rzd = null;
    }
    this.jdField_a_of_type_Rzc.removeMessages(0);
  }
  
  public void c(int paramInt)
  {
    if (a()) {
      rzd.a(this.jdField_a_of_type_Rzd).b(paramInt);
    }
  }
  
  public void c(rzd paramrzd)
  {
    if (paramrzd != null) {
      a(rzd.a(paramrzd));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Rzd != null) {
        d(this.jdField_a_of_type_Rzd);
      }
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((rze)localIterator.next()).a(this.jdField_a_of_type_Rzd, 123, 99, null);
    }
    this.jdField_a_of_type_Rzd = null;
  }
  
  public boolean c()
  {
    return (a()) && (rzd.a(this.jdField_a_of_type_Rzd).e() == 5);
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
      rzd.a(this.jdField_a_of_type_Rzd).a(paramInt);
    }
  }
  
  public boolean d()
  {
    return (a()) && (rzd.a(this.jdField_a_of_type_Rzd).e() == 3);
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
        AppRuntime localAppRuntime = onk.a();
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
    return (a()) && (rzd.a(this.jdField_a_of_type_Rzd).e() == 4);
  }
  
  public void f()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "doOnDestory: ");
    }
    this.b = true;
    c();
    if (this.jdField_a_of_type_Rzd != null)
    {
      if (rzd.a(this.jdField_a_of_type_Rzd) != null)
      {
        rzd.a(this.jdField_a_of_type_Rzd).m();
        rzd.a(this.jdField_a_of_type_Rzd, null);
      }
      this.jdField_a_of_type_Rzd = null;
    }
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        qub localqub = (qub)localIterator.next();
        if ((localqub != null) && (localqub.e() != 8)) {
          localqub.m();
        }
      }
    }
    if (this.jdField_a_of_type_Qud != null)
    {
      this.jdField_a_of_type_Qud.b();
      this.jdField_a_of_type_Qud = null;
    }
    this.jdField_a_of_type_Rzc.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */