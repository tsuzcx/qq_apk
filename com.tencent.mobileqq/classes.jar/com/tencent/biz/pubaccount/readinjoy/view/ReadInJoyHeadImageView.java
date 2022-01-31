package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import bdda;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;
import pgr;
import sfd;

public class ReadInJoyHeadImageView
  extends KandianUrlImageView
  implements IView, pgr
{
  private static final Drawable b = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130841396));
  private long a;
  
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
    a(bdda.a());
    this.jdField_a_of_type_Sfd.a(false);
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo == null) {
      return;
    }
    QLog.d("ReadInJoyHeadImageView", 1, " [setHeadImg] load avatar from 0xb81 userinfo, uin:" + paramReadInJoyUserInfo.uin);
    try
    {
      a(new URL(ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo)));
      return;
    }
    catch (MalformedURLException paramReadInJoyUserInfo)
    {
      QLog.d("ReadInJoyHeadImageView", 2, paramReadInJoyUserInfo.getMessage());
    }
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyHeadImageView", 2, "load uin success: " + paramString + " " + paramReadInJoyUserInfo);
    if ((!TextUtils.equals(paramString, String.valueOf(this.jdField_a_of_type_Long))) || (paramReadInJoyUserInfo == null)) {
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyHeadImageView.1(this, paramReadInJoyUserInfo));
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyHeadImageView", 2, "uin: " + paramString1 + " onLoadUserInfoFailed:" + paramString2);
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
  
  public void setHeadImgByUin(long paramLong)
  {
    setHeadImgByUin(paramLong, true);
  }
  
  public void setHeadImgByUin(long paramLong, boolean paramBoolean)
  {
    if (paramLong <= 0L) {
      QLog.d("ReadInJoyHeadImageView", 2, "Uin is illegal");
    }
    ReadInJoyUserInfo localReadInJoyUserInfo;
    do
    {
      return;
      this.jdField_a_of_type_Long = paramLong;
      if (paramBoolean) {
        a(b);
      }
      localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(this.jdField_a_of_type_Long, this);
    } while (localReadInJoyUserInfo == null);
    a(localReadInJoyUserInfo);
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
  
  public void setImageSrc(String paramString)
  {
    QLog.d("ReadInJoyHeadImageView", 2, "ReadInJoyHeadImageView imagesrc : " + paramString);
    try
    {
      a(new URL(paramString));
      return;
    }
    catch (MalformedURLException paramString)
    {
      QLog.d("ReadInJoyHeadImageView", 2, paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView
 * JD-Core Version:    0.7.0.1
 */