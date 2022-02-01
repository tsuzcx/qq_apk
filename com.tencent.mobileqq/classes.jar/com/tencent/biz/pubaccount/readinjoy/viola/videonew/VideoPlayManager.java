package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.content.Context;
import android.support.v4.util.ArraySet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import ozs;
import rwf;
import rwh;
import rwj;
import sab;
import tih;
import tii;
import tik;
import til;
import tim;

public class VideoPlayManager
  implements rwj
{
  private int jdField_a_of_type_Int = 1000;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<tim> jdField_a_of_type_JavaUtilList;
  private Set<rwf> jdField_a_of_type_JavaUtilSet = new ArraySet();
  private rwh jdField_a_of_type_Rwh;
  private tii jdField_a_of_type_Tii = new tii(this, null);
  private tik jdField_a_of_type_Tik = new tik(this);
  private til jdField_a_of_type_Til;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public VideoPlayManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Rwh = new rwh();
    this.jdField_a_of_type_Rwh.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private rwf a(til paramtil)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      localObject = null;
    }
    rwf localrwf;
    do
    {
      do
      {
        return localObject;
        localrwf = new rwf(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        localrwf.a(this.jdField_a_of_type_Tii);
        localObject = localrwf;
      } while (paramtil == null);
      localObject = localrwf;
    } while (!paramtil.jdField_f_of_type_Boolean);
    localrwf.e(true);
    return localrwf;
  }
  
  private void a(rwf paramrwf)
  {
    if (paramrwf == null) {}
    do
    {
      return;
      paramrwf.a(null);
      paramrwf.n();
    } while (paramrwf.j());
    paramrwf.j();
    ThreadManager.excute(new VideoPlayManager.2(this, paramrwf), 64, null, false);
  }
  
  private void d(til paramtil)
  {
    if (til.a(paramtil) == null)
    {
      ThreadManager.post(new VideoPlayManager.1(this, paramtil), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    til.a(paramtil).a(paramtil.jdField_a_of_type_Tih);
    e(paramtil);
  }
  
  private void e(til paramtil)
  {
    if ((paramtil == null) || (til.a(paramtil) == null)) {
      return;
    }
    paramtil.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
    }
    if (paramtil.jdField_a_of_type_Sab == null)
    {
      til.a(paramtil).a(paramtil.jdField_a_of_type_AndroidViewViewGroup);
      Object localObject = til.a(paramtil).a();
      if ((localObject == null) || (((sab)localObject).a() == null))
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((tim)((Iterator)localObject).next()).a(paramtil, 123, 99, null);
        }
        til.a(paramtil, null);
        return;
      }
      paramtil.jdField_a_of_type_Sab = ((sab)localObject);
      ((sab)localObject).a().setId(2131376164);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((tim)((Iterator)localObject).next()).b(paramtil);
      }
    }
    til.a(paramtil).b(paramtil.jdField_f_of_type_Int);
    til.a(paramtil).d(this.e);
    til.a(paramtil).c(paramtil.jdField_a_of_type_Boolean);
    paramtil.jdField_a_of_type_Sab.a().setVisibility(0);
    ThreadManager.excute(new VideoPlayManager.PlayStartVideoRunnable(this, paramtil), 64, null, true);
  }
  
  public int a()
  {
    if (a()) {
      return til.a(this.jdField_a_of_type_Til).b();
    }
    return -1;
  }
  
  public long a()
  {
    if (a()) {
      return til.a(this.jdField_a_of_type_Til).b();
    }
    return 0L;
  }
  
  public til a()
  {
    return this.jdField_a_of_type_Til;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Til != null) && (til.a(this.jdField_a_of_type_Til) != null))
    {
      til.a(this.jdField_a_of_type_Til).d();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((tim)localIterator.next()).d(this.jdField_a_of_type_Til);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Til != null) && (til.a(this.jdField_a_of_type_Til) != null) && (d()))
    {
      til.a(this.jdField_a_of_type_Til).f();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((tim)localIterator.next()).a(this.jdField_a_of_type_Til, paramInt);
      }
    }
  }
  
  public void a(til paramtil)
  {
    this.jdField_a_of_type_Til = paramtil;
    paramtil = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtil.hasNext()) {
      ((tim)paramtil.next()).a(this.jdField_a_of_type_Til, false);
    }
  }
  
  public void a(tim paramtim)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramtim);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Til != null) {
        d(this.jdField_a_of_type_Til);
      }
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((tim)localIterator.next()).a(this.jdField_a_of_type_Til, 123, 99, null);
    }
    this.jdField_a_of_type_Til = null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Til != null) && (til.a(this.jdField_a_of_type_Til) != null);
  }
  
  public long b()
  {
    if (a()) {
      return til.a(this.jdField_a_of_type_Til).a();
    }
    return 0L;
  }
  
  public void b()
  {
    a(2);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Til != null) && (til.a(this.jdField_a_of_type_Til) != null) && ((c()) || (b())))
    {
      til.a(this.jdField_a_of_type_Til).e();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((tim)localIterator.next()).b(this.jdField_a_of_type_Til, paramInt);
      }
    }
  }
  
  public void b(til paramtil)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager playVideo");
    }
    Iterator localIterator;
    if ((paramtil != null) && (paramtil.jdField_a_of_type_Tih != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() vid=" + paramtil.jdField_a_of_type_Tih.a);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo: playerParam=" + paramtil);
      }
      this.jdField_a_of_type_Til = paramtil;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((tim)localIterator.next()).a(this.jdField_a_of_type_Til, true);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
      }
      return;
    }
    if ((this.jdField_a_of_type_Rwh != null) && (!this.jdField_a_of_type_Rwh.a()))
    {
      this.jdField_a_of_type_Rwh.a();
      return;
    }
    d(paramtil);
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (a()) {
      til.a(this.jdField_a_of_type_Til).d(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (a()) && (til.a(this.jdField_a_of_type_Til).d());
  }
  
  public void c()
  {
    if (a())
    {
      a(til.a(this.jdField_a_of_type_Til));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((tim)localIterator.next()).e(this.jdField_a_of_type_Til);
      }
      this.jdField_a_of_type_Til.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
      this.jdField_a_of_type_Til = null;
    }
    this.jdField_a_of_type_Tik.removeMessages(0);
  }
  
  public void c(int paramInt)
  {
    if (a()) {
      til.a(this.jdField_a_of_type_Til).b(paramInt);
    }
  }
  
  public void c(til paramtil)
  {
    if (paramtil != null) {
      a(til.a(paramtil));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (a()) {
      til.a(this.jdField_a_of_type_Til).c(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return (a()) && (til.a(this.jdField_a_of_type_Til).e());
  }
  
  public void d()
  {
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "doOnPause() isPlaying()=" + d());
    }
    if (d())
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = false;
      b();
    }
  }
  
  public void d(int paramInt)
  {
    if (a()) {
      til.a(this.jdField_a_of_type_Til).a(paramInt);
    }
  }
  
  public boolean d()
  {
    return (a()) && (til.a(this.jdField_a_of_type_Til).f());
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
        AppRuntime localAppRuntime = ozs.a();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {}
        for (boolean bool = ((QQAppInterface)localAppRuntime).d();; bool = false)
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
  
  public void f()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "doOnDestory: ");
    }
    this.b = true;
    c();
    if (this.jdField_a_of_type_Til != null)
    {
      if (til.a(this.jdField_a_of_type_Til) != null)
      {
        til.a(this.jdField_a_of_type_Til).l();
        til.a(this.jdField_a_of_type_Til, null);
      }
      this.jdField_a_of_type_Til = null;
    }
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        rwf localrwf = (rwf)localIterator.next();
        if ((localrwf != null) && (!localrwf.i())) {
          localrwf.l();
        }
      }
    }
    if (this.jdField_a_of_type_Rwh != null)
    {
      this.jdField_a_of_type_Rwh.b();
      this.jdField_a_of_type_Rwh = null;
    }
    this.jdField_a_of_type_Tik.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */