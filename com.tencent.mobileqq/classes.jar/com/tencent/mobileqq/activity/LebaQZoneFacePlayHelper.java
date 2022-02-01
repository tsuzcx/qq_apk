package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class LebaQZoneFacePlayHelper
  implements Handler.Callback
{
  private ImageSwitcher a;
  private ImageSwitcher b;
  private ImageView c;
  private boolean d = false;
  private LebaQZoneFacePlayHelper.FacePlayInfo e;
  private LebaQZoneFacePlayHelper.FacePlayInfo f;
  private LebaQZoneFacePlayHelper.FacePlayInfo g;
  private LebaQZoneFacePlayHelper.FacePlayInfo h;
  private int i;
  private ArrayList<String> j;
  private int k = 0;
  private MqqHandler l;
  private QQAppInterface m;
  private boolean n = false;
  
  public LebaQZoneFacePlayHelper(ImageSwitcher paramImageSwitcher1, ImageSwitcher paramImageSwitcher2, ImageView paramImageView, QQAppInterface paramQQAppInterface)
  {
    this.a = paramImageSwitcher1;
    this.b = paramImageSwitcher2;
    this.c = paramImageView;
    this.l = new MqqHandler(Looper.getMainLooper(), this);
    this.m = paramQQAppInterface;
  }
  
  private LebaQZoneFacePlayHelper.FacePlayInfo a(String paramString)
  {
    Object localObject = this.h;
    if (localObject != null) {
      if (((LebaQZoneFacePlayHelper.FacePlayInfo)localObject).a(paramString))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("命中预加载faceDrawable  uin:");
          ((StringBuilder)localObject).append(paramString);
          QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("没有命中预加载，回收预加载:");
          ((StringBuilder)localObject).append(paramString);
          QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
        }
        this.h.c();
        this.h = null;
      }
    }
    return this.h;
  }
  
  private boolean a(int paramInt)
  {
    return this.k >= paramInt;
  }
  
  private static boolean a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if ((paramArrayList1 == null) && (paramArrayList2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, " equal arrayList1==null&&arrayList2==null");
      }
      return true;
    }
    if ((paramArrayList1 != null) && (paramArrayList2 != null))
    {
      if (paramArrayList1.size() != paramArrayList2.size())
      {
        if (QLog.isColorLevel()) {
          QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "not equal arrayList1.size()!=arrayList2.size()");
        }
        return false;
      }
      int i1 = 0;
      try
      {
        while (i1 < paramArrayList1.size())
        {
          String str1 = (String)paramArrayList1.get(i1);
          String str2 = (String)paramArrayList2.get(i1);
          if (!str1.equals(str2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("not equal index: %d,uin1:%s,uin2:%s", new Object[] { Integer.valueOf(i1), str1, str2 }));
            }
            return false;
          }
          i1 += 1;
        }
        return true;
      }
      catch (Throwable paramArrayList1)
      {
        QLog.e("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 1, paramArrayList1, new Object[0]);
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "not equal  arrayList1==null||arrayList2==null");
    }
    return false;
  }
  
  private boolean b(int paramInt)
  {
    return this.k < paramInt;
  }
  
  private String c(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4) {
            return HardCodeUtil.a(2131903964);
          }
          return HardCodeUtil.a(2131903969);
        }
        return HardCodeUtil.a(2131903967);
      }
      return HardCodeUtil.a(2131903968);
    }
    return HardCodeUtil.a(2131903966);
  }
  
  private boolean h()
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "mQzoneFeedSubIcon=null");
      }
      return false;
    }
    ArrayList localArrayList = this.j;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "activeFeedsUin没有uin数据");
    }
    return false;
  }
  
  private boolean i()
  {
    int i1 = this.i;
    int i2 = this.j.size();
    boolean bool = false;
    if ((i1 >= i2) || ((this.d) && (this.j.size() == 2)) || ((this.d) && (this.i >= this.j.size() - 1)))
    {
      Object localObject = this.h;
      if ((localObject != null) && (this.k != 4)) {
        if (this.d)
        {
          localObject = this.g;
          if ((localObject != null) && (!((LebaQZoneFacePlayHelper.FacePlayInfo)localObject).d()))
          {
            if (!this.g.a.equals(this.j.get(1)))
            {
              if (!this.g.d())
              {
                this.g.c();
                this.g = null;
              }
              localObject = (String)this.j.get(1);
              if ((!this.h.d()) && (this.h.a.equals(localObject)))
              {
                this.g = this.h;
                this.h = null;
              }
              else
              {
                this.g = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)localObject, this.m);
              }
            }
          }
          else
          {
            localObject = (String)this.j.get(1);
            if ((!this.h.d()) && (this.h.a.equals(localObject)))
            {
              this.g = this.h;
              this.h = null;
            }
            else
            {
              this.g = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)localObject, this.m);
            }
          }
          this.b.setImageDrawable(this.g.c);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isPlayFinished play two");
            ((StringBuilder)localObject).append(this.g.a);
            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
          }
          localObject = (String)this.j.get(0);
          LebaQZoneFacePlayHelper.FacePlayInfo localFacePlayInfo = this.h;
          if ((localFacePlayInfo != null) && (!localFacePlayInfo.d()) && (this.h.a.equals(localObject)))
          {
            this.a.setImageDrawable(this.h.c);
            this.e = this.f;
            this.f = this.h;
            this.h = null;
          }
          else
          {
            this.e = this.f;
            localFacePlayInfo = this.h;
            if ((localFacePlayInfo != null) && (!localFacePlayInfo.d()))
            {
              this.h.c();
              this.h = null;
            }
            this.f = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)localObject, this.m);
            this.a.setImageDrawable(this.f.c);
          }
        }
        else
        {
          this.a.setImageDrawable(((LebaQZoneFacePlayHelper.FacePlayInfo)localObject).c);
          this.e = this.f;
          this.f = this.h;
          this.h = null;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isPlayFinished play one");
            ((StringBuilder)localObject).append(this.f.a);
            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      this.k = 4;
    }
    if (this.k == 4) {
      bool = true;
    }
    return bool;
  }
  
  private void j()
  {
    LebaQZoneFacePlayHelper.FacePlayInfo localFacePlayInfo = this.e;
    if ((localFacePlayInfo != null) && (!localFacePlayInfo.d()))
    {
      this.e.c();
      this.e = null;
    }
    localFacePlayInfo = this.f;
    if ((localFacePlayInfo != null) && (!localFacePlayInfo.d()))
    {
      this.f.c();
      this.f = null;
    }
    localFacePlayInfo = this.g;
    if ((localFacePlayInfo != null) && (!localFacePlayInfo.d()))
    {
      this.g.c();
      this.g = null;
    }
    localFacePlayInfo = this.h;
    if ((localFacePlayInfo != null) && (!localFacePlayInfo.d()))
    {
      this.h.c();
      this.h = null;
    }
  }
  
  private void k()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((ImageSwitcher)localObject).getInAnimation();
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    localObject = this.a.getOutAnimation();
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    this.a.setOutAnimation(null);
    this.a.setInAnimation(null);
    this.b.setOutAnimation(null);
    this.b.setInAnimation(null);
    int i1 = 0;
    while (i1 < this.a.getChildCount())
    {
      localObject = this.a.getChildAt(i1);
      if (localObject != null) {
        ((View)localObject).clearAnimation();
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.b.getChildCount())
    {
      localObject = this.b.getChildAt(i1);
      if (localObject != null) {
        ((View)localObject).clearAnimation();
      }
      i1 += 1;
    }
    this.n = false;
  }
  
  private void l()
  {
    if (this.c != null)
    {
      if (!"1000".equals(ThemeUtil.curThemeId))
      {
        this.c.setVisibility(8);
        return;
      }
      if ((this.d) && (this.c.getVisibility() != 0)) {
        this.c.setVisibility(0);
      }
    }
  }
  
  void a()
  {
    try
    {
      if (h())
      {
        if (i())
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "已经播放完毕，不再轮播头像");
          return;
        }
        Object localObject;
        if (a(2))
        {
          if ((this.j.size() > 1) && (this.i > 0)) {
            a(true);
          } else {
            k();
          }
          if (QLog.isColorLevel()) {
            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("play index :%d, uin:%s,total size=:%d", new Object[] { Integer.valueOf(this.i), this.j.get(this.i), Integer.valueOf(this.j.size()) }));
          }
          this.e = this.f;
          localObject = (String)this.j.get(this.i);
          if (this.d)
          {
            if ((this.g != null) && (!this.g.d()))
            {
              if (this.g.a.equals(localObject))
              {
                this.f = this.g;
                this.g = null;
              }
              else if (!this.g.d())
              {
                this.g.c();
                this.g = null;
              }
            }
            else if ((this.f == null) || ((!this.f.d()) && (!this.f.a.equals(localObject)))) {
              this.f = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)localObject, this.m);
            }
            localObject = this.f.b();
            this.a.setImageDrawable((Drawable)localObject);
            boolean bool = QLog.isColorLevel();
            if (bool)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("play two");
              ((StringBuilder)localObject).append(this.f.a);
              QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
            }
            this.g = a((String)this.j.get(this.i + 1));
            if (this.g == null) {
              this.g = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)this.j.get(this.i + 1), this.m);
            }
            localObject = this.g.b();
            if (localObject != null)
            {
              this.b.setImageDrawable((Drawable)localObject);
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("play two");
                ((StringBuilder)localObject).append(this.g.a);
                QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
              }
            }
          }
          else
          {
            this.f = a((String)localObject);
            if (this.f == null) {
              this.f = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)localObject, this.m);
            }
            localObject = this.f.b();
            if (localObject != null)
            {
              this.a.setImageDrawable((Drawable)localObject);
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("play one");
                ((StringBuilder)localObject).append(this.f.a);
                QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
              }
            }
          }
          if (this.i == 0) {
            this.l.sendEmptyMessageDelayed(1688002, 1400L);
          }
          this.i += 1;
          if (((this.d) && (this.i < this.j.size() - 1)) || ((!this.d) && (this.i < this.j.size())))
          {
            localObject = (String)this.j.get(this.i);
            if (this.d) {
              localObject = (String)this.j.get(this.i + 1);
            }
            this.h = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)localObject, this.m);
            return;
          }
          if (((!this.d) && (this.i == this.j.size())) || ((this.d) && (this.i == this.j.size() - 1)))
          {
            this.h = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)this.j.get(0), this.m);
            if (this.d) {
              this.g = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)this.j.get(1), this.m);
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("播放状态不对，不进行播放 playState:");
          ((StringBuilder)localObject).append(this.k);
          QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "非法状态，不进行播放下一张头像");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 1, "播放头像过程中出现错误，请关注异常信息", localThrowable);
      ((IQzoneExceptionReport)QRoute.api(IQzoneExceptionReport.class)).doReport(localThrowable, HardCodeUtil.a(2131903965));
    }
    return;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    d();
    this.m = paramQQAppInterface;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (this.m == null) {
      return;
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 1)) {
      this.d = true;
    } else {
      this.d = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("start play qzone face pre list:%s, current list:%s, currentPlayState:%s, currentIndex:%d", new Object[] { String.valueOf(this.j), String.valueOf(paramArrayList), c(this.k), Integer.valueOf(this.i) }));
    }
    if ((!b(2)) && (a(this.j, paramArrayList)))
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("数据没有发生变化，保持原有的播放状态:");
        paramArrayList.append(this.j);
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, paramArrayList.toString());
      }
    }
    else
    {
      this.l.removeMessages(1688002);
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        this.k = 2;
        this.i = 0;
        ArrayList localArrayList = this.j;
        if (localArrayList == null) {
          this.j = new ArrayList(paramArrayList.size());
        } else {
          localArrayList.clear();
        }
        this.j.addAll(paramArrayList);
        paramArrayList = (String)this.j.get(this.i);
        if (this.d) {
          paramArrayList = (String)this.j.get(this.i + 1);
        }
        this.h = LebaQZoneFacePlayHelper.FacePlayInfo.a(paramArrayList, this.m);
        if (this.a.getVisibility() != 0) {
          this.a.setVisibility(0);
        }
        if (this.d)
        {
          if (this.b.getVisibility() != 0) {
            this.b.setVisibility(0);
          }
          l();
        }
        else
        {
          paramArrayList = this.b;
          if (paramArrayList != null) {
            paramArrayList.setVisibility(8);
          }
          paramArrayList = this.c;
          if (paramArrayList != null) {
            paramArrayList.setVisibility(8);
          }
        }
        a();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "start play qzone face 更新数据为 null，隐藏头像");
      }
      d();
      this.k = 0;
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (this.n) {
      return;
    }
    ((ImageSwitcher)localObject).setAnimateFirstView(false);
    this.b.setAnimateFirstView(false);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(1400L);
    ((Animation)localObject).setAnimationListener(new LebaQZoneFacePlayHelper.1(this, paramBoolean));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(1400L);
    this.a.setInAnimation((Animation)localObject);
    this.b.setInAnimation(localAlphaAnimation);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject).setDuration(1400L);
    this.a.setOutAnimation((Animation)localObject);
    this.b.setOutAnimation((Animation)localObject);
    this.n = true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pausePlayFace pre playState=");
      localStringBuilder.append(c(this.k));
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, localStringBuilder.toString());
    }
    if ((a(2)) && (b(4)))
    {
      this.l.removeMessages(1688002);
      this.k = 1;
    }
  }
  
  public void c()
  {
    l();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resumePlayFace pre playState=");
      ((StringBuilder)localObject).append(c(this.k));
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (!b(4))
    {
      this.k = 2;
      this.i = 0;
      a();
      return;
    }
    if (a(1))
    {
      this.k = 2;
      localObject = this.j;
      if ((localObject != null) && (this.i >= ((ArrayList)localObject).size())) {
        this.i = 0;
      }
      a();
    }
  }
  
  public void d()
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.i = 0;
    }
    k();
    localObject = this.a;
    if (localObject != null)
    {
      ((ImageSwitcher)localObject).setImageDrawable(null);
      this.a.setVisibility(8);
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((ImageSwitcher)localObject).setImageDrawable(null);
      this.b.setVisibility(8);
    }
    localObject = this.c;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    j();
  }
  
  public void e()
  {
    d();
    this.m = null;
  }
  
  public int f()
  {
    ArrayList localArrayList = this.j;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public void g()
  {
    l();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface = this.m;
    if ((localQQAppInterface != null) && ("0".equals(localQQAppInterface.getCurrentAccountUin()))) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1688003: 
      this.i = 0;
      paramMessage = this.j;
      if (paramMessage != null) {
        paramMessage.clear();
      }
      return true;
    }
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper
 * JD-Core Version:    0.7.0.1
 */