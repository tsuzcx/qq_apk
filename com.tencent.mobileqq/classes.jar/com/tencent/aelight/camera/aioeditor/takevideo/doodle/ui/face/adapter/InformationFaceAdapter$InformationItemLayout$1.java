package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class InformationFaceAdapter$InformationItemLayout$1
  implements INetEngineListener
{
  InformationFaceAdapter$InformationItemLayout$1(InformationFaceAdapter.InformationItemLayout paramInformationItemLayout, File paramFile, WeakReference paramWeakReference1, WeakReference paramWeakReference2, String paramString, boolean paramBoolean, InformationFaceAdapter.URLDrawableListener paramURLDrawableListener, WeakReference paramWeakReference3) {}
  
  public void onResp(NetResp paramNetResp)
  {
    String str = ((InformationFacePackage.Item)paramNetResp.mReq.getUserData()).g;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResp ,url is :");
      localStringBuilder.append(str);
      localStringBuilder.append(" http status:");
      localStringBuilder.append(paramNetResp.mHttpCode);
      QLog.d("InformationFaceAdapter", 2, localStringBuilder.toString());
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramNetResp.mHttpCode == 200)
    {
      bool1 = bool2;
      if (this.a.exists()) {
        try
        {
          if (ApngDrawable.isApngFile(this.a))
          {
            bool1 = true;
          }
          else
          {
            this.a.delete();
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("InformationFaceAdapter", 2, "onResp ,valid apng file");
              bool1 = bool2;
            }
          }
        }
        catch (IOException paramNetResp)
        {
          paramNetResp.printStackTrace();
          bool1 = bool2;
        }
      }
    }
    ThreadManager.getUIHandler().post(new InformationFaceAdapter.InformationItemLayout.1.1(this, bool1));
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i = (int)(paramLong1 * 100L / paramLong2);
    if (QLog.isColorLevel())
    {
      paramNetReq = new StringBuilder();
      paramNetReq.append("apng percent:");
      paramNetReq.append(i);
      QLog.d("InformationFaceAdapter", 2, paramNetReq.toString());
    }
    ThreadManager.getUIHandler().post(new InformationFaceAdapter.InformationItemLayout.1.2(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout.1
 * JD-Core Version:    0.7.0.1
 */