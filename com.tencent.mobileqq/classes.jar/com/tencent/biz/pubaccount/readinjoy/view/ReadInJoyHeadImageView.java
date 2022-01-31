package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mls;
import mqq.os.MqqHandler;

public class ReadInJoyHeadImageView
  extends KandianUrlImageView
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  private long b;
  
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
    a(ImageUtil.a());
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo == null) {
      return;
    }
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
    if ((!TextUtils.equals(paramString, String.valueOf(this.b))) || (paramReadInJoyUserInfo == null)) {
      return;
    }
    ThreadManager.getUIHandler().post(new mls(this, paramReadInJoyUserInfo));
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyHeadImageView", 2, "uin: " + paramString1 + " onLoadUserInfoFailed:" + paramString2);
  }
  
  public void setHeadImgByUin(long paramLong)
  {
    if (paramLong <= 0L) {
      QLog.d("ReadInJoyHeadImageView", 2, "Uin is illegal");
    }
    ReadInJoyUserInfo localReadInJoyUserInfo;
    do
    {
      return;
      this.b = paramLong;
      localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(this.b, this);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView
 * JD-Core Version:    0.7.0.1
 */