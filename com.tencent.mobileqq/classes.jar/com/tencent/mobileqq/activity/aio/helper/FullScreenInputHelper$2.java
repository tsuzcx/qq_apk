package com.tencent.mobileqq.activity.aio.helper;

import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.xml.sax.XMLReader;

class FullScreenInputHelper$2
  implements Html.TagHandler
{
  FullScreenInputHelper$2(FullScreenInputHelper paramFullScreenInputHelper) {}
  
  public void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    if (paramString.equalsIgnoreCase("newLine"))
    {
      paramEditable.append("\n");
      return;
    }
    int i;
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramString.equalsIgnoreCase("emotion"))
    {
      paramXMLReader = FullScreenInputHelper.a(this.b, paramXMLReader, "id");
      if (!TextUtils.isEmpty(paramXMLReader))
      {
        if ((!a) && (paramXMLReader == null)) {
          throw new AssertionError();
        }
        i = Integer.parseInt(paramXMLReader);
        localObject = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("\024");
        localStringBuilder.append((char)i);
        paramEditable.append(((FullScreenInputHelper)localObject).a(localStringBuilder.toString()));
        if (QLog.isColorLevel())
        {
          paramEditable = new StringBuilder();
          paramEditable.append("[mix]handleTag: ");
          paramEditable.append(paramString);
          paramEditable.append(" emotionTag: ");
          paramEditable.append(paramXMLReader);
          paramEditable.append(" emotionId: ");
          paramEditable.append(i);
          QLog.d("FullScreenInputHelper", 2, paramEditable.toString());
        }
      }
    }
    else if (paramString.equalsIgnoreCase("littleEmotion"))
    {
      paramString = new char[4];
      i = 0;
      int j = 0;
      while (i < 4)
      {
        localObject = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("index");
        localStringBuilder.append(i);
        localObject = FullScreenInputHelper.a((FullScreenInputHelper)localObject, paramXMLReader, localStringBuilder.toString());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if ((!a) && (localObject == null)) {
            throw new AssertionError();
          }
          paramString[i] = ((char)Integer.parseInt((String)localObject));
          j = 1;
        }
        i += 1;
      }
      if (j != 0)
      {
        paramXMLReader = this.b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("\024");
        ((StringBuilder)localObject).append(paramString[0]);
        ((StringBuilder)localObject).append(paramString[1]);
        ((StringBuilder)localObject).append(paramString[2]);
        ((StringBuilder)localObject).append(paramString[3]);
        paramEditable.append(paramXMLReader.a(((StringBuilder)localObject).toString()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.2
 * JD-Core Version:    0.7.0.1
 */