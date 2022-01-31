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
import obz;
import qhw;
import qhy;
import qia;
import rmi;
import rmj;
import rml;
import rmm;
import rmn;

public class VideoPlayManager
  implements qia
{
  private int jdField_a_of_type_Int = 1000;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<rmn> jdField_a_of_type_JavaUtilList;
  private Set<qhw> jdField_a_of_type_JavaUtilSet = new ArraySet();
  private qhy jdField_a_of_type_Qhy;
  private rmj jdField_a_of_type_Rmj = new rmj(this, null);
  private rml jdField_a_of_type_Rml = new rml(this, null);
  private rmm jdField_a_of_type_Rmm;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public VideoPlayManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Qhy = new qhy(paramContext.getApplicationContext());
    this.jdField_a_of_type_Qhy.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private qhw a(rmm paramrmm)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      localObject = null;
    }
    qhw localqhw;
    do
    {
      do
      {
        return localObject;
        localqhw = new qhw(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        localqhw.a(this.jdField_a_of_type_Rmj);
        localObject = localqhw;
      } while (paramrmm == null);
      localObject = localqhw;
    } while (!paramrmm.jdField_f_of_type_Boolean);
    localqhw.e(true);
    return localqhw;
  }
  
  private void a(qhw paramqhw)
  {
    if (paramqhw == null) {}
    int i;
    do
    {
      return;
      paramqhw.a(null);
      paramqhw.p();
      i = paramqhw.e();
    } while ((i == 7) || (i == 8) || (i == 0) || (i == 6));
    paramqhw.k();
    ThreadManager.excute(new VideoPlayManager.2(this, paramqhw), 64, null, false);
  }
  
  private void d(rmm paramrmm)
  {
    if (rmm.a(paramrmm) == null)
    {
      ThreadManager.post(new VideoPlayManager.1(this, paramrmm), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    rmm.a(paramrmm).a(paramrmm.jdField_a_of_type_Rmi);
    e(paramrmm);
  }
  
  private void e(rmm paramrmm)
  {
    if ((paramrmm == null) || (rmm.a(paramrmm) == null)) {
      return;
    }
    paramrmm.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
    }
    if (paramrmm.jdField_a_of_type_AndroidViewView == null)
    {
      Object localObject = rmm.a(paramrmm).b();
      if (localObject == null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((rmn)((Iterator)localObject).next()).a(paramrmm, 123, 99, null);
        }
        rmm.a(paramrmm, null);
        return;
      }
      paramrmm.jdField_a_of_type_AndroidViewView = ((View)localObject);
      ((View)localObject).setId(2131309037);
      paramrmm.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      rmm.a(paramrmm).a((IVideoViewBase)localObject);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((rmn)((Iterator)localObject).next()).b(paramrmm);
      }
    }
    rmm.a(paramrmm).b(paramrmm.jdField_f_of_type_Int);
    rmm.a(paramrmm).d(this.e);
    rmm.a(paramrmm).a().setOutputMute(paramrmm.jdField_a_of_type_Boolean);
    paramrmm.jdField_a_of_type_AndroidViewView.setVisibility(0);
    ThreadManager.excute(new VideoPlayManager.PlayStartVideoRunnable(this, paramrmm), 64, null, true);
  }
  
  public int a()
  {
    if (a()) {
      return rmm.a(this.jdField_a_of_type_Rmm).e();
    }
    return -1;
  }
  
  public long a()
  {
    if (a()) {
      return rmm.a(this.jdField_a_of_type_Rmm).b();
    }
    return 0L;
  }
  
  public rmm a()
  {
    return this.jdField_a_of_type_Rmm;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Rmm != null) && (rmm.a(this.jdField_a_of_type_Rmm) != null))
    {
      rmm.a(this.jdField_a_of_type_Rmm).f();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rmn)localIterator.next()).d(this.jdField_a_of_type_Rmm);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Rmm != null) && (rmm.a(this.jdField_a_of_type_Rmm) != null) && ((d()) || (e())))
    {
      rmm.a(this.jdField_a_of_type_Rmm).h();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rmn)localIterator.next()).a(this.jdField_a_of_type_Rmm, paramInt);
      }
    }
  }
  
  public void a(rmm paramrmm)
  {
    this.jdField_a_of_type_Rmm = paramrmm;
    paramrmm = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramrmm.hasNext()) {
      ((rmn)paramrmm.next()).a(this.jdField_a_of_type_Rmm, false);
    }
  }
  
  public void a(rmn paramrmn)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramrmn);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (a()) {
      rmm.a(this.jdField_a_of_type_Rmm).d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Rmm != null) && (rmm.a(this.jdField_a_of_type_Rmm) != null);
  }
  
  public long b()
  {
    if (a()) {
      return rmm.a(this.jdField_a_of_type_Rmm).a();
    }
    return 0L;
  }
  
  public void b()
  {
    a(2);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Rmm != null) && (rmm.a(this.jdField_a_of_type_Rmm) != null) && ((c()) || (b())))
    {
      rmm.a(this.jdField_a_of_type_Rmm).g();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rmn)localIterator.next()).b(this.jdField_a_of_type_Rmm, paramInt);
      }
    }
  }
  
  public void b(rmm paramrmm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager playVideo");
    }
    Iterator localIterator;
    if ((paramrmm != null) && (paramrmm.jdField_a_of_type_Rmi != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() vid=" + paramrmm.jdField_a_of_type_Rmi.a);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo: playerParam=" + paramrmm);
      }
      this.jdField_a_of_type_Rmm = paramrmm;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((rmn)localIterator.next()).a(this.jdField_a_of_type_Rmm, true);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
      }
      return;
    }
    if ((this.jdField_a_of_type_Qhy != null) && (!this.jdField_a_of_type_Qhy.a()))
    {
      this.jdField_a_of_type_Qhy.a();
      return;
    }
    d(paramrmm);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((a()) && (rmm.a(this.jdField_a_of_type_Rmm).a() != null)) {
      rmm.a(this.jdField_a_of_type_Rmm).a().setOutputMute(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (a()) && (rmm.a(this.jdField_a_of_type_Rmm).e() == 2);
  }
  
  public void c()
  {
    if (a())
    {
      a(rmm.a(this.jdField_a_of_type_Rmm));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rmn)localIterator.next()).e(this.jdField_a_of_type_Rmm);
      }
      this.jdField_a_of_type_Rmm.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
      this.jdField_a_of_type_Rmm = null;
    }
    this.jdField_a_of_type_Rml.removeMessages(0);
  }
  
  public void c(int paramInt)
  {
    if (a()) {
      rmm.a(this.jdField_a_of_type_Rmm).b(paramInt);
    }
  }
  
  public void c(rmm paramrmm)
  {
    if (paramrmm != null) {
      a(rmm.a(paramrmm));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Rmm != null) {
        d(this.jdField_a_of_type_Rmm);
      }
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((rmn)localIterator.next()).a(this.jdField_a_of_type_Rmm, 123, 99, null);
    }
    this.jdField_a_of_type_Rmm = null;
  }
  
  public boolean c()
  {
    return (a()) && (rmm.a(this.jdField_a_of_type_Rmm).e() == 5);
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
      rmm.a(this.jdField_a_of_type_Rmm).a(paramInt);
    }
  }
  
  public boolean d()
  {
    return (a()) && (rmm.a(this.jdField_a_of_type_Rmm).e() == 3);
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
        AppRuntime localAppRuntime = obz.a();
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
    return (a()) && (rmm.a(this.jdField_a_of_type_Rmm).e() == 4);
  }
  
  public void f()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "doOnDestory: ");
    }
    this.b = true;
    c();
    if (this.jdField_a_of_type_Rmm != null)
    {
      if (rmm.a(this.jdField_a_of_type_Rmm) != null)
      {
        rmm.a(this.jdField_a_of_type_Rmm).m();
        rmm.a(this.jdField_a_of_type_Rmm, null);
      }
      this.jdField_a_of_type_Rmm = null;
    }
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        qhw localqhw = (qhw)localIterator.next();
        if ((localqhw != null) && (localqhw.e() != 8)) {
          localqhw.m();
        }
      }
    }
    if (this.jdField_a_of_type_Qhy != null)
    {
      this.jdField_a_of_type_Qhy.b();
      this.jdField_a_of_type_Qhy = null;
    }
    this.jdField_a_of_type_Rml.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */