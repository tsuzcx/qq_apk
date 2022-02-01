package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import obb;
import pay;
import sdl;
import sdn;
import sdp;
import sdq;
import sdr;
import sds;
import sdt;
import sgz;
import sha;
import shg;
import shh;
import shi;
import sjo;

public class VideoPreDownloadMgr
  implements sdn
{
  private static String jdField_a_of_type_JavaLangString = "Q.readinjoy.video.VideoPreDownloadMgr";
  private static Set<String> c = new HashSet();
  public Context a;
  private List<sds> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private sdl jdField_a_of_type_Sdl;
  private sdr jdField_a_of_type_Sdr;
  public sdt a;
  private sha jdField_a_of_type_Sha;
  private shi jdField_a_of_type_Shi;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet;
  
  public VideoPreDownloadMgr() {}
  
  public VideoPreDownloadMgr(Context paramContext)
  {
    this();
    a(paramContext);
  }
  
  private shi a(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null) {
      return new shi(1, paramString2);
    }
    if (1 == paramInt) {}
    for (paramInt = 104;; paramInt = 101) {
      return new shi(paramInt, paramString2, new String[] { paramString1 });
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 正式开始预下载 vid=" + paramString2 + ", url=" + paramString1 + ", urlType=" + paramInt1 + ", duration=" + paramInt2);
    }
    sha localsha = this.jdField_a_of_type_Sha;
    if (localsha == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() start preload ERROR cacheMgr == null!");
      }
    }
    do
    {
      return;
      String str = paramString2;
      if (paramString1 != null) {
        if (paramString2 != null)
        {
          str = paramString2;
          if (!paramString1.equals(paramString2)) {}
        }
        else
        {
          str = obb.a(paramString1);
        }
      }
      paramString1 = a(paramString1, str, paramInt1);
      this.jdField_a_of_type_Shi = paramString1;
      localsha.a(paramString1, paramInt2, 2000L);
    } while ((!paramBoolean) || (this.jdField_a_of_type_Sdt == null));
    paramString1 = this.jdField_a_of_type_Sdt;
    paramString1.i += 1;
  }
  
  private void a(List<sds> paramList)
  {
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadSerialTask(this, paramList), 5, null, true);
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, true);
  }
  
  private void e()
  {
    sha localsha = this.jdField_a_of_type_Sha;
    if (localsha == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "initSerialPreDownload() 设置mCacheMgr回调");
    }
    localsha.a(new sdp(this));
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "releaseSerialPredownload()");
    }
    if (this.jdField_a_of_type_Sha != null)
    {
      this.jdField_a_of_type_Sha.a(null);
      this.jdField_a_of_type_Sha.b();
    }
  }
  
  private void g()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0)) {}
    label64:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        try
        {
          localsds1 = (sds)localList.get(0);
          localsds2 = localsds1;
        }
        catch (Exception localException1)
        {
          try
          {
            localList.remove(0);
            localsds2 = localsds1;
            if ((localsds2 != null) && (!TextUtils.isEmpty(localsds2.jdField_a_of_type_JavaLangString))) {
              break;
            }
            g();
            return;
          }
          catch (Exception localException2)
          {
            sds localsds1;
            sds localsds2;
            int i;
            break label64;
          }
          localException1 = localException1;
          localsds1 = null;
        }
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "preDownloadVideoNotAlreadyList.remove(0) ERROR = " + localException1.getMessage());
          localsds2 = localsds1;
        }
      }
      this.jdField_b_of_type_JavaLangString = localsds2.jdField_a_of_type_JavaLangString;
      i = localsds2.b;
      if (2 == localsds2.jdField_a_of_type_Int)
      {
        sjo.a().a(localsds2.jdField_a_of_type_JavaLangString, new sdq(this, i));
        return;
      }
      if (5 == localsds2.jdField_a_of_type_Int)
      {
        if (a(localsds2.jdField_a_of_type_JavaLangString, localsds2.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + localsds2.jdField_a_of_type_JavaLangString);
          }
          this.jdField_b_of_type_JavaLangString = null;
          g();
          return;
        }
        b(localsds2.jdField_a_of_type_JavaLangString, localsds2.jdField_a_of_type_JavaLangString, 0, i);
        return;
      }
      if (a(null, localsds2.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + localsds2.jdField_a_of_type_JavaLangString);
        }
        this.jdField_b_of_type_JavaLangString = null;
        g();
        return;
      }
      b(null, localsds2.jdField_a_of_type_JavaLangString, 0, i);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 2, "已完成预下载，队列为空");
  }
  
  public void a()
  {
    b(true);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Sdr == null) {}
    do
    {
      List localList;
      do
      {
        return;
        if (this.jdField_a_of_type_Sha == null) {
          break;
        }
        localList = this.jdField_a_of_type_Sdr.a(paramInt, paramBoolean);
      } while ((localList == null) || (localList.size() <= 0));
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "requestPreDownload() 外部触发预下载逻辑 size = " + localList.size());
      }
      a(localList);
      return;
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "requestPreDownload() is off or mCacheMgr is null, return;");
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Sdl = new sdl();
    this.jdField_a_of_type_Sdl.a(this);
    if (!this.jdField_a_of_type_Sdl.a())
    {
      this.jdField_a_of_type_Sdl.a();
      return;
    }
    c();
    e();
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    sdt localsdt = this.jdField_a_of_type_Sdt;
    if (localsdt == null) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      localsdt.g += 1;
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString)))
      {
        localsdt.j += 1;
        if ((this.jdField_b_of_type_JavaUtilSet != null) && (!this.jdField_b_of_type_JavaUtilSet.contains(paramString)))
        {
          this.jdField_b_of_type_JavaUtilSet.add(paramString);
          localsdt.k += 1;
        }
      }
    } while (!c.contains(paramString));
    localsdt.l += 1;
    return;
    localsdt.h += 1;
  }
  
  public void a(sdr paramsdr)
  {
    this.jdField_a_of_type_Sdr = paramsdr;
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    e();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    sha localsha = this.jdField_a_of_type_Sha;
    if (localsha == null) {}
    String str;
    do
    {
      return false;
      str = paramString2;
      if (paramString1 != null) {
        if (paramString2 != null)
        {
          str = paramString2;
          if (!paramString1.equals(paramString2)) {}
        }
        else
        {
          str = obb.a(paramString1);
        }
      }
      paramString1 = a(paramString1, str, 101);
      try
      {
        i = localsha.a(paramString1);
        if ((i == 2) || (i == 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, str + " checkIsVideoCached(), cacheStatus = " + i + ", return TRUE");
          }
          return true;
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, str + " checkIsVideoCached() cacheMgr.isVideoCached Exception = " + paramString1.getMessage());
          }
          int i = 0;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, str + " checkIsVideoCached() return FALSE");
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "resume()");
    }
    c();
    e();
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destroy()");
    }
    ThreadManager.post(new VideoPreDownloadMgr.1(this), 5, null, true);
    if ((paramBoolean) && (this.jdField_a_of_type_Sdt != null))
    {
      pay.b(BaseApplication.getContext(), pay.a(), true, this.jdField_a_of_type_Sdt.a());
      this.jdField_a_of_type_Sdt = null;
    }
    if (this.jdField_a_of_type_Sdl != null)
    {
      this.jdField_a_of_type_Sdl.b();
      this.jdField_a_of_type_Sdl = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Sha == null) {
      this.jdField_a_of_type_Sha = shg.a.a().a();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoPreDownloadController initCacheMgr mCacheMgr=" + this.jdField_a_of_type_Sha);
    }
    if (this.jdField_a_of_type_Sha == null) {}
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Sha != null) && (this.jdField_a_of_type_Shi != null)) {
      this.jdField_a_of_type_Sha.a();
    }
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Shi = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr
 * JD-Core Version:    0.7.0.1
 */