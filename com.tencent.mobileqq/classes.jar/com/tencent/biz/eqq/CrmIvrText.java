package com.tencent.biz.eqq;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextParseLinkUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrmIvrText
  extends QQText
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  String jdField_a_of_type_JavaLangString = "";
  String b = "";
  
  public CrmIvrText(CharSequence paramCharSequence, int paramInt1, int paramInt2, MessageRecord paramMessageRecord, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    super(paramCharSequence, paramInt1, paramInt2, paramMessageRecord);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  static void a(View paramView, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    paramView.post(new CrmIvrText.1(paramQQAppInterface, paramView, paramString1));
  }
  
  protected void parseLinkSpan()
  {
    super.parseLinkSpan();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(QQTextParseLinkUtil.b);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append("QQ语音");
    localObject = Pattern.compile(((StringBuilder)localObject).toString()).matcher(this.mText);
    while (((Matcher)localObject).find())
    {
      int i = ((Matcher)localObject).start();
      int j = ((Matcher)localObject).end();
      addSpan(new CrmIvrText.CrmIvrLinkSpan(this, this.mText.substring(i, j)), i, j, 33);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmIvrText
 * JD-Core Version:    0.7.0.1
 */