package com.tencent.mobileqq.activity.qqsettingme;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeNicknameBean;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import mqq.app.AppRuntime;

class QQSettingMeNicknameProcessor$4
  implements Runnable
{
  QQSettingMeNicknameProcessor$4(QQSettingMeNicknameProcessor paramQQSettingMeNicknameProcessor) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.c.getCurrentUin();
    String str = ContactUtils.c((QQAppInterface)this.this$0.c, (String)localObject2);
    Object localObject1 = localObject2;
    if (str != null) {
      if ("".equals(str.trim())) {
        localObject1 = localObject2;
      } else {
        localObject1 = str;
      }
    }
    localObject2 = new QQSettingMeNicknameBean();
    ((QQSettingMeNicknameBean)localObject2).b = ImageUtil.j();
    ((QQSettingMeNicknameBean)localObject2).a = ((String)localObject1);
    this.this$0.b.postValue(localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeNicknameProcessor.4
 * JD-Core Version:    0.7.0.1
 */