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
import pay;
import sdj;
import sdl;
import sdn;
import shf;
import tmt;
import tmu;
import tmw;
import tmx;
import tmy;

public class VideoPlayManager
  implements sdn
{
  private int jdField_a_of_type_Int = 1000;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<tmy> jdField_a_of_type_JavaUtilList;
  private Set<sdj> jdField_a_of_type_JavaUtilSet = new ArraySet();
  private sdl jdField_a_of_type_Sdl;
  private tmu jdField_a_of_type_Tmu = new tmu(this, null);
  private tmw jdField_a_of_type_Tmw = new tmw(this);
  private tmx jdField_a_of_type_Tmx;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public VideoPlayManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Sdl = new sdl();
    this.jdField_a_of_type_Sdl.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private sdj a(tmx paramtmx)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      localObject = null;
    }
    sdj localsdj;
    do
    {
      do
      {
        return localObject;
        localsdj = new sdj(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        localsdj.a(this.jdField_a_of_type_Tmu);
        localObject = localsdj;
      } while (paramtmx == null);
      localObject = localsdj;
    } while (!paramtmx.jdField_f_of_type_Boolean);
    localsdj.e(true);
    return localsdj;
  }
  
  private void a(sdj paramsdj)
  {
    if (paramsdj == null) {}
    do
    {
      return;
      paramsdj.a(null);
      paramsdj.n();
    } while (paramsdj.j());
    paramsdj.j();
    ThreadManager.excute(new VideoPlayManager.2(this, paramsdj), 64, null, false);
  }
  
  private void d(tmx paramtmx)
  {
    if (tmx.a(paramtmx) == null)
    {
      ThreadManager.post(new VideoPlayManager.1(this, paramtmx), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    tmx.a(paramtmx).a(paramtmx.jdField_a_of_type_Tmt);
    e(paramtmx);
  }
  
  private void e(tmx paramtmx)
  {
    if ((paramtmx == null) || (tmx.a(paramtmx) == null)) {
      return;
    }
    paramtmx.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
    }
    if (paramtmx.jdField_a_of_type_Shf == null)
    {
      tmx.a(paramtmx).a(paramtmx.jdField_a_of_type_AndroidViewViewGroup);
      Object localObject = tmx.a(paramtmx).a();
      if ((localObject == null) || (((shf)localObject).a() == null))
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((tmy)((Iterator)localObject).next()).a(paramtmx, 123, 99, null);
        }
        tmx.a(paramtmx, null);
        return;
      }
      paramtmx.jdField_a_of_type_Shf = ((shf)localObject);
      ((shf)localObject).a().setId(2131375928);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((tmy)((Iterator)localObject).next()).b(paramtmx);
      }
    }
    tmx.a(paramtmx).b(paramtmx.jdField_f_of_type_Int);
    tmx.a(paramtmx).d(this.e);
    tmx.a(paramtmx).c(paramtmx.jdField_a_of_type_Boolean);
    paramtmx.jdField_a_of_type_Shf.a().setVisibility(0);
    ThreadManager.excute(new VideoPlayManager.PlayStartVideoRunnable(this, paramtmx), 64, null, true);
  }
  
  public int a()
  {
    if (a()) {
      return tmx.a(this.jdField_a_of_type_Tmx).b();
    }
    return -1;
  }
  
  public long a()
  {
    if (a()) {
      return tmx.a(this.jdField_a_of_type_Tmx).b();
    }
    return 0L;
  }
  
  public tmx a()
  {
    return this.jdField_a_of_type_Tmx;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Tmx != null) && (tmx.a(this.jdField_a_of_type_Tmx) != null))
    {
      tmx.a(this.jdField_a_of_type_Tmx).d();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((tmy)localIterator.next()).d(this.jdField_a_of_type_Tmx);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Tmx != null) && (tmx.a(this.jdField_a_of_type_Tmx) != null) && (d()))
    {
      tmx.a(this.jdField_a_of_type_Tmx).f();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((tmy)localIterator.next()).a(this.jdField_a_of_type_Tmx, paramInt);
      }
    }
  }
  
  public void a(tmx paramtmx)
  {
    this.jdField_a_of_type_Tmx = paramtmx;
    paramtmx = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtmx.hasNext()) {
      ((tmy)paramtmx.next()).a(this.jdField_a_of_type_Tmx, false);
    }
  }
  
  public void a(tmy paramtmy)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramtmy);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Tmx != null) {
        d(this.jdField_a_of_type_Tmx);
      }
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((tmy)localIterator.next()).a(this.jdField_a_of_type_Tmx, 123, 99, null);
    }
    this.jdField_a_of_type_Tmx = null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Tmx != null) && (tmx.a(this.jdField_a_of_type_Tmx) != null);
  }
  
  public long b()
  {
    if (a()) {
      return tmx.a(this.jdField_a_of_type_Tmx).a();
    }
    return 0L;
  }
  
  public void b()
  {
    a(2);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Tmx != null) && (tmx.a(this.jdField_a_of_type_Tmx) != null) && ((c()) || (b())))
    {
      tmx.a(this.jdField_a_of_type_Tmx).e();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((tmy)localIterator.next()).b(this.jdField_a_of_type_Tmx, paramInt);
      }
    }
  }
  
  public void b(tmx paramtmx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager playVideo");
    }
    Iterator localIterator;
    if ((paramtmx != null) && (paramtmx.jdField_a_of_type_Tmt != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() vid=" + paramtmx.jdField_a_of_type_Tmt.a);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo: playerParam=" + paramtmx);
      }
      this.jdField_a_of_type_Tmx = paramtmx;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((tmy)localIterator.next()).a(this.jdField_a_of_type_Tmx, true);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
      }
      return;
    }
    if ((this.jdField_a_of_type_Sdl != null) && (!this.jdField_a_of_type_Sdl.a()))
    {
      this.jdField_a_of_type_Sdl.a();
      return;
    }
    d(paramtmx);
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (a()) {
      tmx.a(this.jdField_a_of_type_Tmx).d(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (a()) && (tmx.a(this.jdField_a_of_type_Tmx).d());
  }
  
  public void c()
  {
    if (a())
    {
      a(tmx.a(this.jdField_a_of_type_Tmx));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((tmy)localIterator.next()).e(this.jdField_a_of_type_Tmx);
      }
      this.jdField_a_of_type_Tmx.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
      this.jdField_a_of_type_Tmx = null;
    }
    this.jdField_a_of_type_Tmw.removeMessages(0);
  }
  
  public void c(int paramInt)
  {
    if (a()) {
      tmx.a(this.jdField_a_of_type_Tmx).b(paramInt);
    }
  }
  
  public void c(tmx paramtmx)
  {
    if (paramtmx != null) {
      a(tmx.a(paramtmx));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (a()) {
      tmx.a(this.jdField_a_of_type_Tmx).c(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return (a()) && (tmx.a(this.jdField_a_of_type_Tmx).e());
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
      tmx.a(this.jdField_a_of_type_Tmx).a(paramInt);
    }
  }
  
  public boolean d()
  {
    return (a()) && (tmx.a(this.jdField_a_of_type_Tmx).f());
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
        AppRuntime localAppRuntime = pay.a();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {}
        for (boolean bool = ((QQAppInterface)localAppRuntime).isVideoChatting();; bool = false)
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
    if (this.jdField_a_of_type_Tmx != null)
    {
      if (tmx.a(this.jdField_a_of_type_Tmx) != null)
      {
        tmx.a(this.jdField_a_of_type_Tmx).l();
        tmx.a(this.jdField_a_of_type_Tmx, null);
      }
      this.jdField_a_of_type_Tmx = null;
    }
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        sdj localsdj = (sdj)localIterator.next();
        if ((localsdj != null) && (!localsdj.i())) {
          localsdj.l();
        }
      }
    }
    if (this.jdField_a_of_type_Sdl != null)
    {
      this.jdField_a_of_type_Sdl.b();
      this.jdField_a_of_type_Sdl = null;
    }
    this.jdField_a_of_type_Tmw.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */