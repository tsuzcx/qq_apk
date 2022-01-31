package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import ors;
import pgr;
import ruf;

public class ReadInJoyNickNameTextView
  extends TextView
  implements pgr
{
  private long jdField_a_of_type_Long;
  private ruf jdField_a_of_type_Ruf;
  private boolean jdField_a_of_type_Boolean;
  
  public ReadInJoyNickNameTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadInJoyNickNameTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyNickNameTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo, boolean paramBoolean)
  {
    if (paramReadInJoyUserInfo == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Boolean) {
        setText(ors.d(paramReadInJoyUserInfo.nick));
      }
      while (this.jdField_a_of_type_Ruf != null)
      {
        this.jdField_a_of_type_Ruf.a(paramReadInJoyUserInfo.nick);
        return;
        setText(paramReadInJoyUserInfo.nick);
      }
    }
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((!TextUtils.equals(paramString, String.valueOf(this.jdField_a_of_type_Long))) || (paramReadInJoyUserInfo == null)) {
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyNickNameTextView.1(this, paramReadInJoyUserInfo));
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyNickNameTextView", 2, "uin: " + paramString1 + " onLoadUserInfoFailed:" + paramString2);
  }
  
  public void setNickNameByUin(long paramLong)
  {
    setNickNameByUin(paramLong, false);
  }
  
  public void setNickNameByUin(long paramLong, boolean paramBoolean)
  {
    if (paramLong <= 0L) {
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
    Object localObject = ReadInJoyUserInfoModule.a(this.jdField_a_of_type_Long, this);
    String str = ReadInJoyUserInfoModule.a();
    if (localObject == null)
    {
      localObject = str;
      if (this.jdField_a_of_type_Boolean) {
        localObject = ors.d(str);
      }
      setText((CharSequence)localObject);
      return;
    }
    a((ReadInJoyUserInfo)localObject, this.jdField_a_of_type_Boolean);
  }
  
  public void setNickNameByUin(String paramString)
  {
    setNickNameByUin(paramString, false);
  }
  
  public void setNickNameByUin(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyNickNameTextView", 2, "UinStr is illegal");
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
        QLog.d("ReadInJoyNickNameTextView", 2, paramString.getMessage());
      }
    }
    setNickNameByUin(l1, paramBoolean);
  }
  
  public void setOnSetNickNameListener(ruf paramruf)
  {
    this.jdField_a_of_type_Ruf = paramruf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView
 * JD-Core Version:    0.7.0.1
 */