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
  private int jdField_a_of_type_Int;
  private ImageSwitcher jdField_a_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LebaQZoneFacePlayHelper.FacePlayInfo jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private ImageSwitcher jdField_b_of_type_AndroidWidgetImageSwitcher;
  private LebaQZoneFacePlayHelper.FacePlayInfo jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo;
  private boolean jdField_b_of_type_Boolean = false;
  private LebaQZoneFacePlayHelper.FacePlayInfo c;
  private LebaQZoneFacePlayHelper.FacePlayInfo d;
  
  public LebaQZoneFacePlayHelper(ImageSwitcher paramImageSwitcher1, ImageSwitcher paramImageSwitcher2, ImageView paramImageView, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidWidgetImageSwitcher = paramImageSwitcher1;
    this.jdField_b_of_type_AndroidWidgetImageSwitcher = paramImageSwitcher2;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private LebaQZoneFacePlayHelper.FacePlayInfo a(String paramString)
  {
    Object localObject = this.d;
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
        this.d.a();
        this.d = null;
      }
    }
    return this.d;
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4) {
            return HardCodeUtil.a(2131706092);
          }
          return HardCodeUtil.a(2131706097);
        }
        return HardCodeUtil.a(2131706095);
      }
      return HardCodeUtil.a(2131706096);
    }
    return HardCodeUtil.a(2131706094);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageSwitcher == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "mQzoneFeedSubIcon=null");
      }
      return false;
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "activeFeedsUin没有uin数据");
    }
    return false;
  }
  
  private boolean a(int paramInt)
  {
    return this.jdField_b_of_type_Int >= paramInt;
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
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, "not equal  arrayList1==null||arrayList2==null");
    }
    return false;
  }
  
  private boolean b()
  {
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    boolean bool = false;
    if ((i >= j) || ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 2)) || ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size() - 1)))
    {
      Object localObject = this.d;
      if ((localObject != null) && (this.jdField_b_of_type_Int != 4)) {
        if (this.jdField_a_of_type_Boolean)
        {
          localObject = this.c;
          if ((localObject != null) && (!((LebaQZoneFacePlayHelper.FacePlayInfo)localObject).a()))
          {
            if (!this.c.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaUtilArrayList.get(1)))
            {
              if (!this.c.a())
              {
                this.c.a();
                this.c = null;
              }
              localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(1);
              if ((!this.d.a()) && (this.d.jdField_a_of_type_JavaLangString.equals(localObject)))
              {
                this.c = this.d;
                this.d = null;
              }
              else
              {
                this.c = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              }
            }
          }
          else
          {
            localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(1);
            if ((!this.d.a()) && (this.d.jdField_a_of_type_JavaLangString.equals(localObject)))
            {
              this.c = this.d;
              this.d = null;
            }
            else
            {
              this.c = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
          this.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable(this.c.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isPlayFinished play two");
            ((StringBuilder)localObject).append(this.c.jdField_a_of_type_JavaLangString);
            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
          }
          localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          LebaQZoneFacePlayHelper.FacePlayInfo localFacePlayInfo = this.d;
          if ((localFacePlayInfo != null) && (!localFacePlayInfo.a()) && (this.d.jdField_a_of_type_JavaLangString.equals(localObject)))
          {
            this.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable(this.d.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable);
            this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo;
            this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = this.d;
            this.d = null;
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo;
            localFacePlayInfo = this.d;
            if ((localFacePlayInfo != null) && (!localFacePlayInfo.a()))
            {
              this.d.a();
              this.d = null;
            }
            this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            this.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable(((LebaQZoneFacePlayHelper.FacePlayInfo)localObject).jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable);
          this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo;
          this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = this.d;
          this.d = null;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isPlayFinished play one");
            ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo.jdField_a_of_type_JavaLangString);
            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      this.jdField_b_of_type_Int = 4;
    }
    if (this.jdField_b_of_type_Int == 4) {
      bool = true;
    }
    return bool;
  }
  
  private boolean b(int paramInt)
  {
    return this.jdField_b_of_type_Int < paramInt;
  }
  
  private void g()
  {
    LebaQZoneFacePlayHelper.FacePlayInfo localFacePlayInfo = this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo;
    if ((localFacePlayInfo != null) && (!localFacePlayInfo.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = null;
    }
    localFacePlayInfo = this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo;
    if ((localFacePlayInfo != null) && (!localFacePlayInfo.a()))
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo.a();
      this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = null;
    }
    localFacePlayInfo = this.c;
    if ((localFacePlayInfo != null) && (!localFacePlayInfo.a()))
    {
      this.c.a();
      this.c = null;
    }
    localFacePlayInfo = this.d;
    if ((localFacePlayInfo != null) && (!localFacePlayInfo.a()))
    {
      this.d.a();
      this.d = null;
    }
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageSwitcher;
    if (localObject == null) {
      return;
    }
    localObject = ((ImageSwitcher)localObject).getInAnimation();
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageSwitcher.getOutAnimation();
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setOutAnimation(null);
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setInAnimation(null);
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setOutAnimation(null);
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setInAnimation(null);
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetImageSwitcher.getChildCount())
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageSwitcher.getChildAt(i);
      if (localObject != null) {
        ((View)localObject).clearAnimation();
      }
      i += 1;
    }
    i = 0;
    while (i < this.jdField_b_of_type_AndroidWidgetImageSwitcher.getChildCount())
    {
      localObject = this.jdField_b_of_type_AndroidWidgetImageSwitcher.getChildAt(i);
      if (localObject != null) {
        ((View)localObject).clearAnimation();
      }
      i += 1;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (!"1000".equals(ThemeUtil.curThemeId))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  void a()
  {
    try
    {
      if (a())
      {
        if (b())
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
          if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 1) && (this.jdField_a_of_type_Int > 0)) {
            a(true);
          } else {
            h();
          }
          if (QLog.isColorLevel()) {
            QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("play index :%d, uin:%s,total size=:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo;
          localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_Boolean)
          {
            if ((this.c != null) && (!this.c.a()))
            {
              if (this.c.jdField_a_of_type_JavaLangString.equals(localObject))
              {
                this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = this.c;
                this.c = null;
              }
              else if (!this.c.a())
              {
                this.c.a();
                this.c = null;
              }
            }
            else if ((this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo == null) || ((!this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo.a()) && (!this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo.jdField_a_of_type_JavaLangString.equals(localObject)))) {
              this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            localObject = this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo.a();
            this.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable((Drawable)localObject);
            boolean bool = QLog.isColorLevel();
            if (bool)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("play two");
              ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo.jdField_a_of_type_JavaLangString);
              QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
            }
            this.c = a((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int + 1));
            if (this.c == null) {
              this.c = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int + 1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            localObject = this.c.a();
            if (localObject != null)
            {
              this.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable((Drawable)localObject);
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("play two");
                ((StringBuilder)localObject).append(this.c.jdField_a_of_type_JavaLangString);
                QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
              }
            }
          }
          else
          {
            this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = a((String)localObject);
            if (this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo == null) {
              this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            localObject = this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo.a();
            if (localObject != null)
            {
              this.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable((Drawable)localObject);
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("play one");
                ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo.jdField_a_of_type_JavaLangString);
                QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
              }
            }
          }
          if (this.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1688002, 1400L);
          }
          this.jdField_a_of_type_Int += 1;
          if (((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) || ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())))
          {
            localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
            if (this.jdField_a_of_type_Boolean) {
              localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int + 1);
            }
            this.d = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            return;
          }
          if (((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilArrayList.size())) || ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)))
          {
            this.d = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (this.jdField_a_of_type_Boolean) {
              this.c = LebaQZoneFacePlayHelper.FacePlayInfo.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("播放状态不对，不进行播放 playState:");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
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
      ((IQzoneExceptionReport)QRoute.api(IQzoneExceptionReport.class)).doReport(localThrowable, HardCodeUtil.a(2131706093));
    }
    return;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 1)) {
      this.jdField_a_of_type_Boolean = true;
    } else {
      this.jdField_a_of_type_Boolean = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, String.format("start play qzone face pre list:%s, current list:%s, currentPlayState:%s, currentIndex:%d", new Object[] { String.valueOf(this.jdField_a_of_type_JavaUtilArrayList), String.valueOf(paramArrayList), a(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    if ((!b(2)) && (a(this.jdField_a_of_type_JavaUtilArrayList, paramArrayList)))
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("数据没有发生变化，保持原有的播放状态:");
        paramArrayList.append(this.jdField_a_of_type_JavaUtilArrayList);
        QLog.i("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, paramArrayList.toString());
      }
    }
    else
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1688002);
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        this.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_Int = 0;
        ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
        if (localArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
        } else {
          localArrayList.clear();
        }
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
        paramArrayList = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Boolean) {
          paramArrayList = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int + 1);
        }
        this.d = LebaQZoneFacePlayHelper.FacePlayInfo.a(paramArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_AndroidWidgetImageSwitcher.getVisibility() != 0) {
          this.jdField_a_of_type_AndroidWidgetImageSwitcher.setVisibility(0);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          if (this.jdField_b_of_type_AndroidWidgetImageSwitcher.getVisibility() != 0) {
            this.jdField_b_of_type_AndroidWidgetImageSwitcher.setVisibility(0);
          }
          i();
        }
        else
        {
          paramArrayList = this.jdField_b_of_type_AndroidWidgetImageSwitcher;
          if (paramArrayList != null) {
            paramArrayList.setVisibility(8);
          }
          paramArrayList = this.jdField_a_of_type_AndroidWidgetImageView;
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
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageSwitcher;
    if (localObject == null) {
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    ((ImageSwitcher)localObject).setAnimateFirstView(false);
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setAnimateFirstView(false);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(1400L);
    ((Animation)localObject).setAnimationListener(new LebaQZoneFacePlayHelper.1(this, paramBoolean));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(1400L);
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setInAnimation((Animation)localObject);
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setInAnimation(localAlphaAnimation);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject).setDuration(1400L);
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setOutAnimation((Animation)localObject);
    this.jdField_b_of_type_AndroidWidgetImageSwitcher.setOutAnimation((Animation)localObject);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pausePlayFace pre playState=");
      localStringBuilder.append(a(this.jdField_b_of_type_Int));
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, localStringBuilder.toString());
    }
    if ((a(2)) && (b(4)))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1688002);
      this.jdField_b_of_type_Int = 1;
    }
  }
  
  public void c()
  {
    i();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resumePlayFace pre playState=");
      ((StringBuilder)localObject).append(a(this.jdField_b_of_type_Int));
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (!b(4))
    {
      this.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_Int = 0;
      a();
      return;
    }
    if (a(1))
    {
      this.jdField_b_of_type_Int = 2;
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject != null) && (this.jdField_a_of_type_Int >= ((ArrayList)localObject).size())) {
        this.jdField_a_of_type_Int = 0;
      }
      a();
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.jdField_a_of_type_Int = 0;
    }
    h();
    localObject = this.jdField_a_of_type_AndroidWidgetImageSwitcher;
    if (localObject != null)
    {
      ((ImageSwitcher)localObject).setImageDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageSwitcher.setVisibility(8);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageSwitcher;
    if (localObject != null)
    {
      ((ImageSwitcher)localObject).setImageDrawable(null);
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    g();
  }
  
  public void e()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void f()
  {
    i();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localQQAppInterface != null) && ("0".equals(localQQAppInterface.getCurrentAccountUin()))) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1688003: 
      this.jdField_a_of_type_Int = 0;
      paramMessage = this.jdField_a_of_type_JavaUtilArrayList;
      if (paramMessage != null) {
        paramMessage.clear();
      }
      return true;
    }
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper
 * JD-Core Version:    0.7.0.1
 */