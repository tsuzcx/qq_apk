package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import bfvo;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import pay;
import pwf;
import syl;

public class ReadInJoyHeadImageView
  extends NativeReadInjoyImageView
  implements IView, pwf
{
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130841748));
  private WeakReference<pwf> jdField_a_of_type_MqqUtilWeakReference;
  
  public ReadInJoyHeadImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadInJoyHeadImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ReadInJoyHeadImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setRound(true);
    setImagePlaceHolder(bfvo.a());
    this.mController.a(false);
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo == null) {
      return;
    }
    QLog.d("ReadInJoyHeadImageView", 1, " [setHeadImg] load avatar from 0xb81 userinfo, uin:" + paramReadInJoyUserInfo.uin);
    setImageSrc(ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo));
  }
  
  private void b(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo != null)
    {
      if (pay.k()) {
        a(paramReadInJoyUserInfo);
      }
    }
    else {
      return;
    }
    pay.b().post(new ReadInJoyHeadImageView.2(this, paramReadInJoyUserInfo));
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyHeadImageView", 1, "uin: " + paramString1 + " onLoadUserInfoFailed:" + paramString2);
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
      ((pwf)this.jdField_a_of_type_MqqUtilWeakReference.get()).onLoadUserInfoFailed(paramString1, paramString2);
    }
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyHeadImageView", 2, "load uin success: " + paramString + " " + paramReadInJoyUserInfo);
    if ((!TextUtils.equals(paramString, String.valueOf(this.jdField_a_of_type_Long))) || (paramReadInJoyUserInfo == null)) {}
    do
    {
      return;
      ThreadManager.getUIHandler().post(new ReadInJoyHeadImageView.1(this, paramReadInJoyUserInfo));
    } while ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null));
    ((pwf)this.jdField_a_of_type_MqqUtilWeakReference.get()).onLoadUserInfoSucceed(paramString, paramReadInJoyUserInfo);
  }
  
  public void setHeadImgByUin(long paramLong)
  {
    setHeadImgByUin(paramLong, true);
  }
  
  public void setHeadImgByUin(long paramLong, boolean paramBoolean)
  {
    setHeadImgByUin(paramLong, paramBoolean, null);
  }
  
  public void setHeadImgByUin(long paramLong, boolean paramBoolean, pwf parampwf)
  {
    setHeadImgByUin(paramLong, paramBoolean, parampwf, false);
  }
  
  public void setHeadImgByUin(long paramLong, boolean paramBoolean1, pwf parampwf, boolean paramBoolean2)
  {
    if (paramLong <= 0L)
    {
      QLog.d("ReadInJoyHeadImageView", 2, "Uin is illegal");
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    if (paramBoolean1) {
      setImagePlaceHolder(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    if (parampwf != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parampwf);
    }
    b(ReadInJoyUserInfoModule.a(this.jdField_a_of_type_Long, this, paramBoolean2));
  }
  
  public void setHeadImgByUin(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyHeadImageView", 2, "UinStr is illegal");
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        QLog.d("ReadInJoyHeadImageView", 2, paramString.getMessage());
      }
    }
    setHeadImgByUin(l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView
 * JD-Core Version:    0.7.0.1
 */