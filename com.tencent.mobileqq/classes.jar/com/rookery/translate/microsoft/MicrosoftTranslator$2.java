package com.rookery.translate.microsoft;

import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.rookery.translate.type.TranslateWithTimeCallback;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import org.apache.http.Header;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

class MicrosoftTranslator$2
  extends AsyncHttpResponseHandler
{
  MicrosoftTranslator$2(MicrosoftTranslator paramMicrosoftTranslator, List paramList, TranslateWithTimeCallback paramTranslateWithTimeCallback, Long paramLong) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    paramArrayOfHeader = null;
    try
    {
      localObject = this.jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator.a.parse(new InputSource(new StringReader(paramString)));
      paramArrayOfHeader = (Header[])localObject;
    }
    catch (SAXException localSAXException)
    {
      for (;;)
      {
        Object localObject;
        NodeList localNodeList;
        a(new TranslateError(localSAXException), paramString);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        a(new TranslateError(localIOException), paramString);
        continue;
        if (this.jdField_a_of_type_JavaUtilList.get(paramInt) != null)
        {
          paramString.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
        }
        else
        {
          paramString.add("");
          continue;
          localIOException.add(Language.AUTO_DETECT);
        }
      }
      this.jdField_a_of_type_ComRookeryTranslateTypeTranslateWithTimeCallback.a(localIOException, paramString, this.jdField_a_of_type_JavaLangLong);
    }
    paramString = new ArrayList();
    localObject = new ArrayList();
    if (paramArrayOfHeader != null)
    {
      localNodeList = paramArrayOfHeader.getElementsByTagName("TranslatedText");
      paramArrayOfHeader = paramArrayOfHeader.getElementsByTagName("From");
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= localNodeList.getLength()) {
          break label270;
        }
        Node localNode = localNodeList.item(paramInt);
        if (localNode.getFirstChild() == null) {
          break;
        }
        paramString.add(localNode.getFirstChild().getNodeValue());
        localNode = paramArrayOfHeader.item(paramInt);
        if (localNode.getFirstChild() == null) {
          break label256;
        }
        ((List)localObject).add(Language.fromString(localNode.getFirstChild().getNodeValue()));
        paramInt += 1;
      }
    }
    label256:
    label270:
    return;
  }
  
  public void a(Throwable paramThrowable, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "[Microsoft] onFailure:" + paramThrowable);
    }
    this.jdField_a_of_type_ComRookeryTranslateTypeTranslateWithTimeCallback.a(new TranslateError(paramThrowable), this.jdField_a_of_type_JavaLangLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.microsoft.MicrosoftTranslator.2
 * JD-Core Version:    0.7.0.1
 */