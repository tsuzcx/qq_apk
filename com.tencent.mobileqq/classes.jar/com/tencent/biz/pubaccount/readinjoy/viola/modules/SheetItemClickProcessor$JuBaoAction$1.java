package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.URLEncoder;
import pha;
import tpl;

public class SheetItemClickProcessor$JuBaoAction$1
  implements Runnable
{
  public SheetItemClickProcessor$JuBaoAction$1(tpl paramtpl, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    try
    {
      localObject = (QQAppInterface)pha.a();
      if (localObject == null) {
        break label87;
      }
      localObject = ((QQAppInterface)localObject).getAccount();
      localObject = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + URLEncoder.encode(this.jdField_a_of_type_JavaLangString, "utf-8") + "&qq=" + (String)localObject + "&_wv=7";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        localException.printStackTrace();
        String str = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=";
      }
    }
    if (BaseActivity.sTopActivity != null) {
      pha.a(BaseActivity.sTopActivity, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.SheetItemClickProcessor.JuBaoAction.1
 * JD-Core Version:    0.7.0.1
 */