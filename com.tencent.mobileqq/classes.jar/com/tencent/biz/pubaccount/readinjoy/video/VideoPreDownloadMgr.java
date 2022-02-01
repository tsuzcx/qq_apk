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
import nzq;
import ozs;
import rwh;
import rwj;
import rwl;
import rwm;
import rwn;
import rwo;
import rwp;
import rzv;
import rzw;
import sac;
import sad;
import sae;
import scq;

public class VideoPreDownloadMgr
  implements rwj
{
  private static String jdField_a_of_type_JavaLangString = "Q.readinjoy.video.VideoPreDownloadMgr";
  private static Set<String> c = new HashSet();
  public Context a;
  private List<rwo> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private rwh jdField_a_of_type_Rwh;
  private rwn jdField_a_of_type_Rwn;
  public rwp a;
  private rzw jdField_a_of_type_Rzw;
  private sae jdField_a_of_type_Sae;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet;
  
  public VideoPreDownloadMgr() {}
  
  public VideoPreDownloadMgr(Context paramContext)
  {
    this();
    a(paramContext);
  }
  
  private sae a(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null) {
      return new sae(1, paramString2);
    }
    if (1 == paramInt) {}
    for (paramInt = 104;; paramInt = 101) {
      return new sae(paramInt, paramString2, new String[] { paramString1 });
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 正式开始预下载 vid=" + paramString2 + ", url=" + paramString1 + ", urlType=" + paramInt1 + ", duration=" + paramInt2);
    }
    rzw localrzw = this.jdField_a_of_type_Rzw;
    if (localrzw == null) {
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
          str = nzq.a(paramString1);
        }
      }
      this.jdField_a_of_type_Sae = a(paramString1, str, paramInt1);
      localrzw.a(this.jdField_a_of_type_Sae, paramInt2, 2000L);
    } while ((!paramBoolean) || (this.jdField_a_of_type_Rwp == null));
    paramString1 = this.jdField_a_of_type_Rwp;
    paramString1.i += 1;
  }
  
  private void a(List<rwo> paramList)
  {
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadSerialTask(this, paramList), 5, null, true);
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, true);
  }
  
  private void e()
  {
    rzw localrzw = this.jdField_a_of_type_Rzw;
    if (localrzw == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "initSerialPreDownload() 设置mCacheMgr回调");
    }
    localrzw.a(new rwl(this));
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "releaseSerialPredownload()");
    }
    if (this.jdField_a_of_type_Rzw != null)
    {
      this.jdField_a_of_type_Rzw.a(null);
      this.jdField_a_of_type_Rzw.b();
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
          localrwo1 = (rwo)localList.get(0);
          localrwo2 = localrwo1;
        }
        catch (Exception localException1)
        {
          try
          {
            localList.remove(0);
            localrwo2 = localrwo1;
            if ((localrwo2 != null) && (!TextUtils.isEmpty(localrwo2.jdField_a_of_type_JavaLangString))) {
              break;
            }
            g();
            return;
          }
          catch (Exception localException2)
          {
            rwo localrwo1;
            rwo localrwo2;
            int i;
            break label64;
          }
          localException1 = localException1;
          localrwo1 = null;
        }
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "preDownloadVideoNotAlreadyList.remove(0) ERROR = " + localException1.getMessage());
          localrwo2 = localrwo1;
        }
      }
      this.jdField_b_of_type_JavaLangString = localrwo2.jdField_a_of_type_JavaLangString;
      i = localrwo2.b;
      if (2 == localrwo2.jdField_a_of_type_Int)
      {
        scq.a().a(localrwo2.jdField_a_of_type_JavaLangString, new rwm(this, i));
        return;
      }
      if (5 == localrwo2.jdField_a_of_type_Int)
      {
        if (a(localrwo2.jdField_a_of_type_JavaLangString, localrwo2.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + localrwo2.jdField_a_of_type_JavaLangString);
          }
          this.jdField_b_of_type_JavaLangString = null;
          g();
          return;
        }
        b(localrwo2.jdField_a_of_type_JavaLangString, localrwo2.jdField_a_of_type_JavaLangString, 0, i);
        return;
      }
      if (a(null, localrwo2.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + localrwo2.jdField_a_of_type_JavaLangString);
        }
        this.jdField_b_of_type_JavaLangString = null;
        g();
        return;
      }
      b(null, localrwo2.jdField_a_of_type_JavaLangString, 0, i);
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
    if (this.jdField_a_of_type_Rwn == null) {}
    do
    {
      List localList;
      do
      {
        return;
        if (this.jdField_a_of_type_Rzw == null) {
          break;
        }
        localList = this.jdField_a_of_type_Rwn.a(paramInt, paramBoolean);
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
    this.jdField_a_of_type_Rwh = new rwh();
    this.jdField_a_of_type_Rwh.a(this);
    if (!this.jdField_a_of_type_Rwh.a())
    {
      this.jdField_a_of_type_Rwh.a();
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
    rwp localrwp = this.jdField_a_of_type_Rwp;
    if (localrwp == null) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      localrwp.g += 1;
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString)))
      {
        localrwp.j += 1;
        if ((this.jdField_b_of_type_JavaUtilSet != null) && (!this.jdField_b_of_type_JavaUtilSet.contains(paramString)))
        {
          this.jdField_b_of_type_JavaUtilSet.add(paramString);
          localrwp.k += 1;
        }
      }
    } while (!c.contains(paramString));
    localrwp.l += 1;
    return;
    localrwp.h += 1;
  }
  
  public void a(rwn paramrwn)
  {
    this.jdField_a_of_type_Rwn = paramrwn;
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    e();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    rzw localrzw = this.jdField_a_of_type_Rzw;
    if (localrzw == null) {}
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
          str = nzq.a(paramString1);
        }
      }
      paramString1 = a(paramString1, str, 101);
      try
      {
        i = localrzw.a(paramString1);
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
    if ((paramBoolean) && (this.jdField_a_of_type_Rwp != null))
    {
      ozs.b(BaseApplication.getContext(), ozs.a(), true, this.jdField_a_of_type_Rwp.a());
      this.jdField_a_of_type_Rwp = null;
    }
    if (this.jdField_a_of_type_Rwh != null)
    {
      this.jdField_a_of_type_Rwh.b();
      this.jdField_a_of_type_Rwh = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Rzw == null) {
      this.jdField_a_of_type_Rzw = sac.a.a().a();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoPreDownloadController initCacheMgr mCacheMgr=" + this.jdField_a_of_type_Rzw);
    }
    if (this.jdField_a_of_type_Rzw == null) {}
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Rzw != null) && (this.jdField_a_of_type_Sae != null)) {
      this.jdField_a_of_type_Rzw.a();
    }
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Sae = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr
 * JD-Core Version:    0.7.0.1
 */