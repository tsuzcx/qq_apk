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
import pha;
import sfb;
import sfd;
import sff;
import six;
import trl;
import trm;
import tro;
import trp;
import trq;

public class VideoPlayManager
  implements sff
{
  private int jdField_a_of_type_Int = 1000;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<trq> jdField_a_of_type_JavaUtilList;
  private Set<sfb> jdField_a_of_type_JavaUtilSet = new ArraySet();
  private sfd jdField_a_of_type_Sfd;
  private trm jdField_a_of_type_Trm = new trm(this, null);
  private tro jdField_a_of_type_Tro = new tro(this);
  private trp jdField_a_of_type_Trp;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public VideoPlayManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Sfd = new sfd();
    this.jdField_a_of_type_Sfd.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private sfb a(trp paramtrp)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      localObject = null;
    }
    sfb localsfb;
    do
    {
      do
      {
        return localObject;
        localsfb = new sfb(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        localsfb.a(this.jdField_a_of_type_Trm);
        localObject = localsfb;
      } while (paramtrp == null);
      localObject = localsfb;
    } while (!paramtrp.jdField_f_of_type_Boolean);
    localsfb.e(true);
    return localsfb;
  }
  
  private void a(sfb paramsfb)
  {
    if (paramsfb == null) {}
    do
    {
      return;
      paramsfb.a(null);
      paramsfb.n();
    } while (paramsfb.j());
    paramsfb.j();
    ThreadManager.excute(new VideoPlayManager.2(this, paramsfb), 64, null, false);
  }
  
  private void d(trp paramtrp)
  {
    if (trp.a(paramtrp) == null)
    {
      ThreadManager.post(new VideoPlayManager.1(this, paramtrp), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    trp.a(paramtrp).a(paramtrp.jdField_a_of_type_Trl);
    e(paramtrp);
  }
  
  private void e(trp paramtrp)
  {
    if ((paramtrp == null) || (trp.a(paramtrp) == null)) {
      return;
    }
    paramtrp.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
    }
    if (paramtrp.jdField_a_of_type_Six == null)
    {
      trp.a(paramtrp).a(paramtrp.jdField_a_of_type_AndroidViewViewGroup);
      Object localObject = trp.a(paramtrp).a();
      if ((localObject == null) || (((six)localObject).a() == null))
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((trq)((Iterator)localObject).next()).a(paramtrp, 123, 99, null);
        }
        trp.a(paramtrp, null);
        return;
      }
      paramtrp.jdField_a_of_type_Six = ((six)localObject);
      ((six)localObject).a().setId(2131376024);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((trq)((Iterator)localObject).next()).b(paramtrp);
      }
    }
    trp.a(paramtrp).b(paramtrp.jdField_f_of_type_Int);
    trp.a(paramtrp).d(this.e);
    trp.a(paramtrp).c(paramtrp.jdField_a_of_type_Boolean);
    paramtrp.jdField_a_of_type_Six.a().setVisibility(0);
    ThreadManager.excute(new VideoPlayManager.PlayStartVideoRunnable(this, paramtrp), 64, null, true);
  }
  
  public int a()
  {
    if (a()) {
      return trp.a(this.jdField_a_of_type_Trp).b();
    }
    return -1;
  }
  
  public long a()
  {
    if (a()) {
      return trp.a(this.jdField_a_of_type_Trp).b();
    }
    return 0L;
  }
  
  public trp a()
  {
    return this.jdField_a_of_type_Trp;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Trp != null) && (trp.a(this.jdField_a_of_type_Trp) != null))
    {
      trp.a(this.jdField_a_of_type_Trp).d();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((trq)localIterator.next()).d(this.jdField_a_of_type_Trp);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Trp != null) && (trp.a(this.jdField_a_of_type_Trp) != null) && (d()))
    {
      trp.a(this.jdField_a_of_type_Trp).f();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((trq)localIterator.next()).a(this.jdField_a_of_type_Trp, paramInt);
      }
    }
  }
  
  public void a(trp paramtrp)
  {
    this.jdField_a_of_type_Trp = paramtrp;
    paramtrp = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtrp.hasNext()) {
      ((trq)paramtrp.next()).a(this.jdField_a_of_type_Trp, false);
    }
  }
  
  public void a(trq paramtrq)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramtrq);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (a()) {
      trp.a(this.jdField_a_of_type_Trp).d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Trp != null) && (trp.a(this.jdField_a_of_type_Trp) != null);
  }
  
  public long b()
  {
    if (a()) {
      return trp.a(this.jdField_a_of_type_Trp).a();
    }
    return 0L;
  }
  
  public void b()
  {
    a(2);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Trp != null) && (trp.a(this.jdField_a_of_type_Trp) != null) && ((c()) || (b())))
    {
      trp.a(this.jdField_a_of_type_Trp).e();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((trq)localIterator.next()).b(this.jdField_a_of_type_Trp, paramInt);
      }
    }
  }
  
  public void b(trp paramtrp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager playVideo");
    }
    Iterator localIterator;
    if ((paramtrp != null) && (paramtrp.jdField_a_of_type_Trl != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() vid=" + paramtrp.jdField_a_of_type_Trl.a);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo: playerParam=" + paramtrp);
      }
      this.jdField_a_of_type_Trp = paramtrp;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((trq)localIterator.next()).a(this.jdField_a_of_type_Trp, true);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
      }
      return;
    }
    if ((this.jdField_a_of_type_Sfd != null) && (!this.jdField_a_of_type_Sfd.a()))
    {
      this.jdField_a_of_type_Sfd.a();
      return;
    }
    d(paramtrp);
  }
  
  public void b(boolean paramBoolean)
  {
    if (a()) {
      trp.a(this.jdField_a_of_type_Trp).c(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (a()) && (trp.a(this.jdField_a_of_type_Trp).d());
  }
  
  public void c()
  {
    if (a())
    {
      a(trp.a(this.jdField_a_of_type_Trp));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((trq)localIterator.next()).e(this.jdField_a_of_type_Trp);
      }
      this.jdField_a_of_type_Trp.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
      this.jdField_a_of_type_Trp = null;
    }
    this.jdField_a_of_type_Tro.removeMessages(0);
  }
  
  public void c(int paramInt)
  {
    if (a()) {
      trp.a(this.jdField_a_of_type_Trp).b(paramInt);
    }
  }
  
  public void c(trp paramtrp)
  {
    if (paramtrp != null) {
      a(trp.a(paramtrp));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Trp != null) {
        d(this.jdField_a_of_type_Trp);
      }
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((trq)localIterator.next()).a(this.jdField_a_of_type_Trp, 123, 99, null);
    }
    this.jdField_a_of_type_Trp = null;
  }
  
  public boolean c()
  {
    return (a()) && (trp.a(this.jdField_a_of_type_Trp).e());
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
      trp.a(this.jdField_a_of_type_Trp).a(paramInt);
    }
  }
  
  public boolean d()
  {
    return (a()) && (trp.a(this.jdField_a_of_type_Trp).f());
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
        AppRuntime localAppRuntime = pha.a();
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
    if (this.jdField_a_of_type_Trp != null)
    {
      if (trp.a(this.jdField_a_of_type_Trp) != null)
      {
        trp.a(this.jdField_a_of_type_Trp).l();
        trp.a(this.jdField_a_of_type_Trp, null);
      }
      this.jdField_a_of_type_Trp = null;
    }
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        sfb localsfb = (sfb)localIterator.next();
        if ((localsfb != null) && (!localsfb.i())) {
          localsfb.l();
        }
      }
    }
    if (this.jdField_a_of_type_Sfd != null)
    {
      this.jdField_a_of_type_Sfd.b();
      this.jdField_a_of_type_Sfd = null;
    }
    this.jdField_a_of_type_Tro.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */