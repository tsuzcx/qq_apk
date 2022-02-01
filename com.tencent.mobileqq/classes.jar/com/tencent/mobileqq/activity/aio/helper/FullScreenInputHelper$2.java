package com.tencent.mobileqq.activity.aio.helper;

import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.xml.sax.XMLReader;

class FullScreenInputHelper$2
  implements Html.TagHandler
{
  static
  {
    if (!FullScreenInputHelper.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  FullScreenInputHelper$2(FullScreenInputHelper paramFullScreenInputHelper) {}
  
  public void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    if (paramString.equalsIgnoreCase("newLine")) {}
    int i;
    do
    {
      do
      {
        paramEditable.append("\n");
        do
        {
          return;
        } while (!paramString.equalsIgnoreCase("emotion"));
        paramXMLReader = FullScreenInputHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperFullScreenInputHelper, paramXMLReader, "id");
      } while (TextUtils.isEmpty(paramXMLReader));
      if ((!jdField_a_of_type_Boolean) && (paramXMLReader == null)) {
        throw new AssertionError();
      }
      i = Integer.parseInt(paramXMLReader);
      paramEditable.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperFullScreenInputHelper.a("\024" + (char)i));
    } while (!QLog.isColorLevel());
    QLog.d("FullScreenInputHelper", 2, "[mix]handleTag: " + paramString + " emotionTag: " + paramXMLReader + " emotionId: " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.2
 * JD-Core Version:    0.7.0.1
 */