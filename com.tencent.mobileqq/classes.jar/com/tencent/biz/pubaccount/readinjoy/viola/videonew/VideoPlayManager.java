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
import pkh;
import spn;
import spp;
import spr;
import stv;
import uah;
import uai;
import uak;
import ual;
import uam;

public class VideoPlayManager
  implements spr
{
  private int jdField_a_of_type_Int = 1000;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<uam> jdField_a_of_type_JavaUtilList;
  private Set<spn> jdField_a_of_type_JavaUtilSet = new ArraySet();
  private spp jdField_a_of_type_Spp;
  private uai jdField_a_of_type_Uai = new uai(this, null);
  private uak jdField_a_of_type_Uak = new uak(this);
  private ual jdField_a_of_type_Ual;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public VideoPlayManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Spp = new spp();
    this.jdField_a_of_type_Spp.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private spn a(ual paramual)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      localObject = null;
    }
    spn localspn;
    do
    {
      do
      {
        return localObject;
        localspn = new spn(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        localspn.a(this.jdField_a_of_type_Uai);
        localObject = localspn;
      } while (paramual == null);
      localObject = localspn;
    } while (!paramual.jdField_f_of_type_Boolean);
    localspn.e(true);
    return localspn;
  }
  
  private void a(spn paramspn)
  {
    if (paramspn == null) {}
    do
    {
      return;
      paramspn.a(null);
      paramspn.n();
    } while (paramspn.j());
    paramspn.j();
    ThreadManager.excute(new VideoPlayManager.2(this, paramspn), 64, null, false);
  }
  
  private void d(ual paramual)
  {
    if (ual.a(paramual) == null)
    {
      ThreadManager.post(new VideoPlayManager.1(this, paramual), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    ual.a(paramual).a(paramual.jdField_a_of_type_Uah);
    e(paramual);
  }
  
  private void e(ual paramual)
  {
    if ((paramual == null) || (ual.a(paramual) == null)) {
      return;
    }
    paramual.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
    }
    if (paramual.jdField_a_of_type_Stv == null)
    {
      ual.a(paramual).a(paramual.jdField_a_of_type_AndroidViewViewGroup);
      Object localObject = ual.a(paramual).a();
      if ((localObject == null) || (((stv)localObject).a() == null))
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((uam)((Iterator)localObject).next()).a(paramual, 123, 99, null);
        }
        ual.a(paramual, null);
        return;
      }
      paramual.jdField_a_of_type_Stv = ((stv)localObject);
      ((stv)localObject).a().setId(2131376175);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((uam)((Iterator)localObject).next()).b(paramual);
      }
    }
    ual.a(paramual).b(paramual.jdField_f_of_type_Int);
    ual.a(paramual).d(this.e);
    ual.a(paramual).c(paramual.jdField_a_of_type_Boolean);
    paramual.jdField_a_of_type_Stv.a().setVisibility(0);
    ThreadManager.excute(new VideoPlayManager.PlayStartVideoRunnable(this, paramual), 64, null, true);
  }
  
  public int a()
  {
    if (a()) {
      return ual.a(this.jdField_a_of_type_Ual).b();
    }
    return -1;
  }
  
  public long a()
  {
    if (a()) {
      return ual.a(this.jdField_a_of_type_Ual).b();
    }
    return 0L;
  }
  
  public ual a()
  {
    return this.jdField_a_of_type_Ual;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Ual != null) && (ual.a(this.jdField_a_of_type_Ual) != null))
    {
      ual.a(this.jdField_a_of_type_Ual).d();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((uam)localIterator.next()).d(this.jdField_a_of_type_Ual);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Ual != null) && (ual.a(this.jdField_a_of_type_Ual) != null) && (d()))
    {
      ual.a(this.jdField_a_of_type_Ual).f();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((uam)localIterator.next()).a(this.jdField_a_of_type_Ual, paramInt);
      }
    }
  }
  
  public void a(ual paramual)
  {
    this.jdField_a_of_type_Ual = paramual;
    paramual = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramual.hasNext()) {
      ((uam)paramual.next()).a(this.jdField_a_of_type_Ual, false);
    }
  }
  
  public void a(uam paramuam)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramuam);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Ual != null) {
        d(this.jdField_a_of_type_Ual);
      }
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((uam)localIterator.next()).a(this.jdField_a_of_type_Ual, 123, 99, null);
    }
    this.jdField_a_of_type_Ual = null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Ual != null) && (ual.a(this.jdField_a_of_type_Ual) != null);
  }
  
  public long b()
  {
    if (a()) {
      return ual.a(this.jdField_a_of_type_Ual).a();
    }
    return 0L;
  }
  
  public void b()
  {
    a(2);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Ual != null) && (ual.a(this.jdField_a_of_type_Ual) != null) && ((c()) || (b())))
    {
      ual.a(this.jdField_a_of_type_Ual).e();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((uam)localIterator.next()).b(this.jdField_a_of_type_Ual, paramInt);
      }
    }
  }
  
  public void b(ual paramual)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager playVideo");
    }
    Iterator localIterator;
    if ((paramual != null) && (paramual.jdField_a_of_type_Uah != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() vid=" + paramual.jdField_a_of_type_Uah.a);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo: playerParam=" + paramual);
      }
      this.jdField_a_of_type_Ual = paramual;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((uam)localIterator.next()).a(this.jdField_a_of_type_Ual, true);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
      }
      return;
    }
    if ((this.jdField_a_of_type_Spp != null) && (!this.jdField_a_of_type_Spp.a()))
    {
      this.jdField_a_of_type_Spp.a();
      return;
    }
    d(paramual);
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (a()) {
      ual.a(this.jdField_a_of_type_Ual).d(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (a()) && (ual.a(this.jdField_a_of_type_Ual).d());
  }
  
  public void c()
  {
    if (a())
    {
      a(ual.a(this.jdField_a_of_type_Ual));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((uam)localIterator.next()).e(this.jdField_a_of_type_Ual);
      }
      this.jdField_a_of_type_Ual.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
      this.jdField_a_of_type_Ual = null;
    }
    this.jdField_a_of_type_Uak.removeMessages(0);
  }
  
  public void c(int paramInt)
  {
    if (a()) {
      ual.a(this.jdField_a_of_type_Ual).b(paramInt);
    }
  }
  
  public void c(ual paramual)
  {
    if (paramual != null) {
      a(ual.a(paramual));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (a()) {
      ual.a(this.jdField_a_of_type_Ual).c(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return (a()) && (ual.a(this.jdField_a_of_type_Ual).e());
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
      ual.a(this.jdField_a_of_type_Ual).a(paramInt);
    }
  }
  
  public boolean d()
  {
    return (a()) && (ual.a(this.jdField_a_of_type_Ual).f());
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
        AppRuntime localAppRuntime = pkh.a();
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
    if (this.jdField_a_of_type_Ual != null)
    {
      if (ual.a(this.jdField_a_of_type_Ual) != null)
      {
        ual.a(this.jdField_a_of_type_Ual).l();
        ual.a(this.jdField_a_of_type_Ual, null);
      }
      this.jdField_a_of_type_Ual = null;
    }
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        spn localspn = (spn)localIterator.next();
        if ((localspn != null) && (!localspn.i())) {
          localspn.l();
        }
      }
    }
    if (this.jdField_a_of_type_Spp != null)
    {
      this.jdField_a_of_type_Spp.b();
      this.jdField_a_of_type_Spp = null;
    }
    this.jdField_a_of_type_Uak.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */