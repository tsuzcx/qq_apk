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
import ors;
import rjn;
import rjp;
import rjr;
import sqd;
import sqe;
import sqg;
import sqh;
import sqi;

public class VideoPlayManager
  implements rjr
{
  private int jdField_a_of_type_Int = 1000;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<sqi> jdField_a_of_type_JavaUtilList;
  private Set<rjn> jdField_a_of_type_JavaUtilSet = new ArraySet();
  private rjp jdField_a_of_type_Rjp;
  private sqe jdField_a_of_type_Sqe = new sqe(this, null);
  private sqg jdField_a_of_type_Sqg = new sqg(this);
  private sqh jdField_a_of_type_Sqh;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public VideoPlayManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Rjp = new rjp(paramContext.getApplicationContext());
    this.jdField_a_of_type_Rjp.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private rjn a(sqh paramsqh)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      localObject = null;
    }
    rjn localrjn;
    do
    {
      do
      {
        return localObject;
        localrjn = new rjn(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        localrjn.a(this.jdField_a_of_type_Sqe);
        localObject = localrjn;
      } while (paramsqh == null);
      localObject = localrjn;
    } while (!paramsqh.jdField_f_of_type_Boolean);
    localrjn.e(true);
    return localrjn;
  }
  
  private void a(rjn paramrjn)
  {
    if (paramrjn == null) {}
    int i;
    do
    {
      return;
      paramrjn.a(null);
      paramrjn.p();
      i = paramrjn.e();
    } while ((i == 7) || (i == 8) || (i == 0) || (i == 6));
    paramrjn.k();
    ThreadManager.excute(new VideoPlayManager.2(this, paramrjn), 64, null, false);
  }
  
  private void d(sqh paramsqh)
  {
    if (sqh.a(paramsqh) == null)
    {
      ThreadManager.post(new VideoPlayManager.1(this, paramsqh), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    sqh.a(paramsqh).a(paramsqh.jdField_a_of_type_Sqd);
    e(paramsqh);
  }
  
  private void e(sqh paramsqh)
  {
    if ((paramsqh == null) || (sqh.a(paramsqh) == null)) {
      return;
    }
    paramsqh.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
    }
    if (paramsqh.jdField_a_of_type_AndroidViewView == null)
    {
      Object localObject = sqh.a(paramsqh).b();
      if (localObject == null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((sqi)((Iterator)localObject).next()).a(paramsqh, 123, 99, null);
        }
        sqh.a(paramsqh, null);
        return;
      }
      paramsqh.jdField_a_of_type_AndroidViewView = ((View)localObject);
      ((View)localObject).setId(2131375294);
      paramsqh.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      sqh.a(paramsqh).a((IVideoViewBase)localObject);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((sqi)((Iterator)localObject).next()).b(paramsqh);
      }
    }
    sqh.a(paramsqh).b(paramsqh.jdField_f_of_type_Int);
    sqh.a(paramsqh).d(this.e);
    sqh.a(paramsqh).a().setOutputMute(paramsqh.jdField_a_of_type_Boolean);
    paramsqh.jdField_a_of_type_AndroidViewView.setVisibility(0);
    ThreadManager.excute(new VideoPlayManager.PlayStartVideoRunnable(this, paramsqh), 64, null, true);
  }
  
  public int a()
  {
    if (a()) {
      return sqh.a(this.jdField_a_of_type_Sqh).e();
    }
    return -1;
  }
  
  public long a()
  {
    if (a()) {
      return sqh.a(this.jdField_a_of_type_Sqh).b();
    }
    return 0L;
  }
  
  public sqh a()
  {
    return this.jdField_a_of_type_Sqh;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Sqh != null) && (sqh.a(this.jdField_a_of_type_Sqh) != null))
    {
      sqh.a(this.jdField_a_of_type_Sqh).f();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((sqi)localIterator.next()).d(this.jdField_a_of_type_Sqh);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Sqh != null) && (sqh.a(this.jdField_a_of_type_Sqh) != null) && ((d()) || (e())))
    {
      sqh.a(this.jdField_a_of_type_Sqh).h();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((sqi)localIterator.next()).a(this.jdField_a_of_type_Sqh, paramInt);
      }
    }
  }
  
  public void a(sqh paramsqh)
  {
    this.jdField_a_of_type_Sqh = paramsqh;
    paramsqh = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramsqh.hasNext()) {
      ((sqi)paramsqh.next()).a(this.jdField_a_of_type_Sqh, false);
    }
  }
  
  public void a(sqi paramsqi)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramsqi);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (a()) {
      sqh.a(this.jdField_a_of_type_Sqh).d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Sqh != null) && (sqh.a(this.jdField_a_of_type_Sqh) != null);
  }
  
  public long b()
  {
    if (a()) {
      return sqh.a(this.jdField_a_of_type_Sqh).a();
    }
    return 0L;
  }
  
  public void b()
  {
    a(2);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Sqh != null) && (sqh.a(this.jdField_a_of_type_Sqh) != null) && ((c()) || (b())))
    {
      sqh.a(this.jdField_a_of_type_Sqh).g();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((sqi)localIterator.next()).b(this.jdField_a_of_type_Sqh, paramInt);
      }
    }
  }
  
  public void b(sqh paramsqh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager playVideo");
    }
    Iterator localIterator;
    if ((paramsqh != null) && (paramsqh.jdField_a_of_type_Sqd != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() vid=" + paramsqh.jdField_a_of_type_Sqd.a);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo: playerParam=" + paramsqh);
      }
      this.jdField_a_of_type_Sqh = paramsqh;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((sqi)localIterator.next()).a(this.jdField_a_of_type_Sqh, true);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
      }
      return;
    }
    if ((this.jdField_a_of_type_Rjp != null) && (!this.jdField_a_of_type_Rjp.a()))
    {
      this.jdField_a_of_type_Rjp.a();
      return;
    }
    d(paramsqh);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((a()) && (sqh.a(this.jdField_a_of_type_Sqh).a() != null)) {
      sqh.a(this.jdField_a_of_type_Sqh).a().setOutputMute(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (a()) && (sqh.a(this.jdField_a_of_type_Sqh).e() == 2);
  }
  
  public void c()
  {
    if (a())
    {
      a(sqh.a(this.jdField_a_of_type_Sqh));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((sqi)localIterator.next()).e(this.jdField_a_of_type_Sqh);
      }
      this.jdField_a_of_type_Sqh.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
      this.jdField_a_of_type_Sqh = null;
    }
    this.jdField_a_of_type_Sqg.removeMessages(0);
  }
  
  public void c(int paramInt)
  {
    if (a()) {
      sqh.a(this.jdField_a_of_type_Sqh).b(paramInt);
    }
  }
  
  public void c(sqh paramsqh)
  {
    if (paramsqh != null) {
      a(sqh.a(paramsqh));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Sqh != null) {
        d(this.jdField_a_of_type_Sqh);
      }
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((sqi)localIterator.next()).a(this.jdField_a_of_type_Sqh, 123, 99, null);
    }
    this.jdField_a_of_type_Sqh = null;
  }
  
  public boolean c()
  {
    return (a()) && (sqh.a(this.jdField_a_of_type_Sqh).e() == 5);
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
      sqh.a(this.jdField_a_of_type_Sqh).a(paramInt);
    }
  }
  
  public boolean d()
  {
    return (a()) && (sqh.a(this.jdField_a_of_type_Sqh).e() == 3);
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
        AppRuntime localAppRuntime = ors.a();
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
    return (a()) && (sqh.a(this.jdField_a_of_type_Sqh).e() == 4);
  }
  
  public void f()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "doOnDestory: ");
    }
    this.b = true;
    c();
    if (this.jdField_a_of_type_Sqh != null)
    {
      if (sqh.a(this.jdField_a_of_type_Sqh) != null)
      {
        sqh.a(this.jdField_a_of_type_Sqh).m();
        sqh.a(this.jdField_a_of_type_Sqh, null);
      }
      this.jdField_a_of_type_Sqh = null;
    }
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        rjn localrjn = (rjn)localIterator.next();
        if ((localrjn != null) && (localrjn.e() != 8)) {
          localrjn.m();
        }
      }
    }
    if (this.jdField_a_of_type_Rjp != null)
    {
      this.jdField_a_of_type_Rjp.b();
      this.jdField_a_of_type_Rjp = null;
    }
    this.jdField_a_of_type_Sqg.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */