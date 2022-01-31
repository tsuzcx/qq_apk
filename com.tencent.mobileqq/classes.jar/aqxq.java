import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl.2.1;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl.2.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr.ICallBackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import mqq.os.MqqHandler;

public class aqxq
  implements TVK_IDownloadMgr.ICallBackListener
{
  aqxq(aqxo paramaqxo) {}
  
  public void downloadCallBack(String paramString)
  {
    int i;
    int j;
    long l2;
    long l1;
    try
    {
      paramString = arrr.a(paramString);
      i = Integer.parseInt((String)paramString.get("callbacktype"));
      j = Integer.parseInt((String)paramString.get("playid"));
      l2 = Long.parseLong((String)paramString.get("offset"));
      if (this.a.jdField_b_of_type_Int == 0) {
        this.a.jdField_b_of_type_Int = aqxo.a(this.a, this.a.jdField_a_of_type_Arit.a());
      }
      if ((j != this.a.jdField_c_of_type_Int) && (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration() > 1L) && (l2 > this.a.jdField_a_of_type_Long)) {
        this.a.jdField_a_of_type_Long = l2;
      }
      l1 = l2;
      if (l2 < this.a.jdField_a_of_type_Long) {
        l1 = this.a.jdField_a_of_type_Long;
      }
      if (!this.a.jdField_c_of_type_Boolean) {
        break label956;
      }
      QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.a.hashCode() + "].[" + this.a.jdField_a_of_type_Arit.a() + "],playid +[" + j + "] download success! igon");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    if (!this.a.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.a.hashCode() + "]mDownloadMgr[" + this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "]" + this.a.jdField_a_of_type_Arit.a() + "],playid +[" + j + "] File download over igon");
      }
    }
    else
    {
      l2 = arrr.a(this.a.jdField_c_of_type_JavaLangString);
      if (QLog.isDebugVersion()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.a.jdField_a_of_type_Arit.a() + "],playid +[" + j + "],downloadId[" + this.a.jdField_c_of_type_Int + "],pos[" + l1 + "], tmpLen[" + l2 + "],block[" + this.a.jdField_b_of_type_Int + "],bDownloadBlock[" + this.a.jdField_a_of_type_Boolean + "],progress[" + (float)l2 / (float)this.a.jdField_a_of_type_Arit.a() + "]");
      }
      if ((this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (l1 - l2 > this.a.jdField_b_of_type_Int) && (!this.a.jdField_a_of_type_Boolean))
      {
        ThreadManager.getUIHandler().post(new FileVideoManager.VideoControl.2.1(this));
        if (QLog.isColorLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>.FVBlock", 4, "[" + this.a.jdField_a_of_type_Arit.a() + "],setRemainTime for playID[" + this.a.jdField_a_of_type_Int + "]");
          QLog.i("FileVideoManager<FileAssistant>.FVBlock", 4, "[" + this.a.jdField_a_of_type_Arit.a() + "],startDownload for recv block [" + this.a.d + "]");
        }
        this.a.jdField_a_of_type_Boolean = true;
        return;
      }
      if ((this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.a.d > 0) && (l1 - l2 < this.a.jdField_b_of_type_Int))
      {
        ThreadManager.getUIHandler().post(new FileVideoManager.VideoControl.2.2(this));
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>.FVBlock", 1, "[" + this.a.jdField_a_of_type_Arit.a() + "] block is full will be stop [" + this.a.d + "]");
        }
        this.a.jdField_a_of_type_Boolean = false;
      }
      float f = (float)l2 / (float)this.a.jdField_a_of_type_Arit.a();
      this.a.jdField_a_of_type_Arit.a(l2);
      return;
      if (arrr.a(this.a.jdField_c_of_type_JavaLangString) == this.a.jdField_a_of_type_Arit.a())
      {
        aqxo.a(this.a);
        return;
        this.a.jdField_b_of_type_Boolean = false;
        this.a.jdField_a_of_type_Arit.a(false);
        if (this.a.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          paramString = (aqxm)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramString != null) {
            paramString.a(201, "");
          }
        }
        aqxi.a(this.a.jdField_a_of_type_Arit.a());
      }
    }
    return;
    label956:
    switch (i)
    {
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqxq
 * JD-Core Version:    0.7.0.1
 */