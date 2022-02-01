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
    try
    {
      paramArrayOfHeader = this.d.b.parse(new InputSource(new StringReader(paramString)));
    }
    catch (IOException paramArrayOfHeader)
    {
      a(new TranslateError(paramArrayOfHeader), paramString);
    }
    catch (SAXException paramArrayOfHeader)
    {
      a(new TranslateError(paramArrayOfHeader), paramString);
    }
    paramArrayOfHeader = null;
    paramString = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfHeader != null)
    {
      NodeList localNodeList = paramArrayOfHeader.getElementsByTagName("TranslatedText");
      paramArrayOfHeader = paramArrayOfHeader.getElementsByTagName("From");
      paramInt = 0;
      while (paramInt < localNodeList.getLength())
      {
        Node localNode = localNodeList.item(paramInt);
        if (localNode.getFirstChild() != null) {
          paramString.add(localNode.getFirstChild().getNodeValue());
        } else if (this.a.get(paramInt) != null) {
          paramString.add(this.a.get(paramInt));
        } else {
          paramString.add("");
        }
        localNode = paramArrayOfHeader.item(paramInt);
        if (localNode.getFirstChild() != null) {
          localArrayList.add(Language.fromString(localNode.getFirstChild().getNodeValue()));
        } else {
          localArrayList.add(Language.AUTO_DETECT);
        }
        paramInt += 1;
      }
    }
    this.b.a(localArrayList, paramString, this.c);
  }
  
  public void a(Throwable paramThrowable, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("[Microsoft] onFailure:");
      paramString.append(paramThrowable);
      QLog.e("Translator", 2, paramString.toString());
    }
    this.b.a(new TranslateError(paramThrowable), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.microsoft.MicrosoftTranslator.2
 * JD-Core Version:    0.7.0.1
 */