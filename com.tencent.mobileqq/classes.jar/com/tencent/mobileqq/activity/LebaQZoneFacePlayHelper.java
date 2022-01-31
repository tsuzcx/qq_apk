package com.tencent.mobileqq.activity;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneExceptionReport;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import syx;
import syy;

public class LebaQZoneFacePlayHelper
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private ImageSwitcher jdField_a_of_type_AndroidWidgetImageSwitcher;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private syy jdField_a_of_type_Syy;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private syy jdField_b_of_type_Syy;
  private syy c;
  
  public LebaQZoneFacePlayHelper(ImageSwitcher paramImageSwitcher, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidWidgetImageSwitcher = paramImageSwitcher;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public LebaQZoneFacePlayHelper(ImageSwitcher paramImageSwitcher, MqqHandler paramMqqHandler, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidWidgetImageSwitcher = paramImageSwitcher;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return "未知状态";
    case 0: 
      return "初始化状态";
    case 1: 
      return "暂停状态";
    case 2: 
      return "已经启动播放状态";
    }
    return "播放完毕状态";
  }
  
  private syy a(String paramString)
  {
    if (this.c != null)
    {
      if (!this.c.a(paramString)) {
        break label54;
      }
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "命中预加载faceDrawable  uin:" + paramString);
      }
    }
    for (;;)
    {
      return this.c;
      label54:
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "没有命中预加载，回收预加载:" + paramString);
      }
      this.c.a();
      this.c = null;
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageSwitcher == null) {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "mQzoneFeedSubIcon=null");
      }
    }
    do
    {
      return false;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "activeFeedsUin没有uin数据");
    return false;
    return true;
  }
  
  private boolean a(int paramInt)
  {
    return this.jdField_b_of_type_Int >= paramInt;
  }
  
  private static boolean a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramArrayList1 == null) && (paramArrayList2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, " equal arrayList1==null&&arrayList2==null");
      }
      return true;
    }
    if ((paramArrayList1 == null) || (paramArrayList2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "not equal  arrayList1==null||arrayList2==null");
      }
      return false;
    }
    if (paramArrayList1.size() != paramArrayList2.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "not equal arrayList1.size()!=arrayList2.size()");
      }
      return false;
    }
    int i = 0;
    try
    {
      while (i < paramArrayList1.size())
      {
        String str1 = (String)paramArrayList1.get(i);
        String str2 = (String)paramArrayList2.get(i);
        if (!str1.equals(str2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("not equal index: %d,uin1:%s,uin2:%s", new Object[] { Integer.valueOf(i), str1, str2 }));
          }
          return false;
        }
        i += 1;
      }
      return true;
    }
    catch (Throwable paramArrayList1)
    {
      QLog.e("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 1, paramArrayList1, new Object[0]);
      return false;
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      this.jdField_b_of_type_Int = 4;
    }
    return this.jdField_b_of_type_Int == 4;
  }
  
  private boolean b(int paramInt)
  {
    return this.jdField_b_of_type_Int < paramInt;
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Syy != null) && (!this.jdField_a_of_type_Syy.a())) {
      this.jdField_a_of_type_Syy.a();
    }
    if ((this.jdField_b_of_type_Syy != null) && (!this.jdField_b_of_type_Syy.a())) {
      this.jdField_b_of_type_Syy.a();
    }
    if ((this.c != null) && (!this.c.a())) {
      this.c.a();
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageSwitcher == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageSwitcher.getInAnimation();
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageSwitcher.getOutAnimation();
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setOutAnimation(null);
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setInAnimation(null);
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetImageSwitcher.getChildCount())
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageSwitcher.getChildAt(i);
      if (localObject != null) {
        ((View)localObject).clearAnimation();
      }
      i += 1;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  void a()
  {
    for (;;)
    {
      try
      {
        if (!a()) {
          break label317;
        }
        if (b())
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "已经播放完毕，不再轮播头像");
          return;
        }
        if (!a(2)) {
          break label282;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 1) && (this.jdField_a_of_type_Int > 0))
        {
          d();
          if (QLog.isColorLevel()) {
            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("play index :%d, uin:%s,total size=:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
          }
          this.jdField_a_of_type_Syy = this.jdField_b_of_type_Syy;
          String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
          this.jdField_b_of_type_Syy = a(str);
          if (this.jdField_b_of_type_Syy == null) {
            this.jdField_b_of_type_Syy = syy.a(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          this.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable(this.jdField_b_of_type_Syy.a);
          if (this.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1688002, 1000L);
          }
          this.jdField_a_of_type_Int += 1;
          if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break;
          }
          this.c = syy.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 1, "播放头像过程中出现错误，请关注异常信息", localThrowable);
        QZoneExceptionReport.a(localThrowable, "播放头像过程中出现错误，请关注异常信息");
        return;
      }
      g();
    }
    this.c = null;
    return;
    label282:
    if (QLog.isColorLevel())
    {
      QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "播放状态不对，不进行播放 playState:" + this.jdField_b_of_type_Int);
      return;
      label317:
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "非法状态，不进行播放下一张头像");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      QZoneEntryReporterInLeba.a(paramQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList.size());
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1688003);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("start play qzone face pre list:%s, current list:%s, currentPlayState:%s, currentIndex:%d", new Object[] { String.valueOf(this.jdField_a_of_type_JavaUtilArrayList), String.valueOf(paramArrayList), a(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    if ((b(2)) || (!a(this.jdField_a_of_type_JavaUtilArrayList, paramArrayList)))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1688002);
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        this.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_Int = 0;
        if (this.jdField_a_of_type_JavaUtilArrayList == null)
        {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
          this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
          this.c = syy.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (this.jdField_a_of_type_AndroidWidgetImageSwitcher.getVisibility() != 0) {
            this.jdField_a_of_type_AndroidWidgetImageSwitcher.setVisibility(0);
          }
          a();
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return;
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "start play qzone face 更新数据为 null，隐藏头像");
      }
      e();
      this.jdField_b_of_type_Int = 0;
      return;
    }
    QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "数据没有发生变化，保持原有的播放状态:" + this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "pausePlayFace pre playState=" + a(this.jdField_b_of_type_Int));
    }
    if ((a(2)) && (b(4)))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1688002);
      this.jdField_b_of_type_Int = 1;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "resumePlayFace pre playState=" + a(this.jdField_b_of_type_Int));
    }
    if (!b(4))
    {
      this.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_Int = 0;
      a();
    }
    while (!a(1)) {
      return;
    }
    this.jdField_b_of_type_Int = 2;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      this.jdField_a_of_type_Int = 0;
    }
    a();
  }
  
  void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageSwitcher == null) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setAnimateFirstView(false);
    Animation localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidWidgetImageSwitcher.getContext(), 2131034166);
    localAnimation.setAnimationListener(new syx(this));
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setInAnimation(localAnimation);
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setOutAnimation(this.jdField_a_of_type_AndroidWidgetImageSwitcher.getContext(), 2131034168);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Int = 0;
    }
    g();
    if (this.jdField_a_of_type_AndroidWidgetImageSwitcher != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageSwitcher.setVisibility(8);
    }
    f();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ("0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1688002: 
      a();
      return true;
    }
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper
 * JD-Core Version:    0.7.0.1
 */