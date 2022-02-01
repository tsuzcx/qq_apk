package com.tencent.aelight.camera.aioeditor.shortvideo;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class QIMPtvTemplateManager$SessionResHttpListener
  implements INetEngineListener
{
  QIMPtvTemplateManager.DLItem jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem;
  QIMPtvTemplateManager.DLSession jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLSession;
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(paramNetResp.mHttpCode), this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem.c }));
    }
    paramNetResp = (QIMPtvTemplateManager.DLItem)paramNetResp.mReq.getUserData();
    if (paramNetResp == null) {
      return;
    }
    Object localObject;
    if (paramNetResp.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString))
    {
      if (QIMPtvTemplateManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager, paramNetResp.jdField_a_of_type_JavaLangString, paramNetResp.jdField_b_of_type_JavaLangString, false)) {
        try
        {
          ZipUtils.unZipFile(new File(QIMPtvTemplateManager.a(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString), QIMPtvTemplateManager.jdField_a_of_type_JavaLangString);
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
      if (!paramNetResp.jdField_b_of_type_Boolean)
      {
        paramNetResp = (QIMPtvTemplateManager.BusinessParam)this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLSession.a));
        if (paramNetResp != null)
        {
          paramNetResp = paramNetResp.b.iterator();
          while (paramNetResp.hasNext())
          {
            localObject = (QIMPtvTemplateManager.DLSession)paramNetResp.next();
            if (QIMPtvTemplateManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager, (QIMPtvTemplateManager.DLSession)localObject, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem)) {
              paramNetResp.remove();
            }
          }
        }
        if (QLog.isColorLevel())
        {
          paramNetResp = new StringBuilder();
          paramNetResp.append("SessionResHttpListener[onResp]: BusinessParam=null  kind=");
          paramNetResp.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLSession.a);
          paramNetResp.append(" mItem.mName=");
          paramNetResp.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString);
          QLog.e("QIMPtvTemplateManager", 2, paramNetResp.toString());
        }
      }
      else
      {
        QIMPtvTemplateManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLSession, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SessionResHttpListener[onResp]: download information no match current=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" callback=");
      ((StringBuilder)localObject).append(paramNetResp.jdField_a_of_type_JavaLangString);
      QLog.e("QIMPtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (QIMPtvTemplateManager.DLItem)paramNetReq.getUserData();
    if (paramNetReq == null) {
      return;
    }
    Object localObject;
    if (paramNetReq.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString))
    {
      localObject = (QIMPtvTemplateManager.BusinessParam)this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLSession.a));
      if (localObject != null)
      {
        if (!paramNetReq.jdField_b_of_type_Boolean)
        {
          paramNetReq = ((QIMPtvTemplateManager.BusinessParam)localObject).b.iterator();
          while (paramNetReq.hasNext())
          {
            localObject = (QIMPtvTemplateManager.DLSession)paramNetReq.next();
            QIMPtvTemplateManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager, (QIMPtvTemplateManager.DLSession)localObject, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem, paramLong1, paramLong2);
          }
        }
        QIMPtvTemplateManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLSession, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem, paramLong1, paramLong2);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramNetReq = new StringBuilder();
        paramNetReq.append("SessionResHttpListener[Progress]: BusinessParam=null  kind=");
        paramNetReq.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLSession.a);
        paramNetReq.append(" mItem.mName=");
        paramNetReq.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString);
        QLog.e("QIMPtvTemplateManager", 2, paramNetReq.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SessionResHttpListener[Progress]: download information no match current=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" callback=");
      ((StringBuilder)localObject).append(paramNetReq.jdField_a_of_type_JavaLangString);
      QLog.e("QIMPtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.SessionResHttpListener
 * JD-Core Version:    0.7.0.1
 */