import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class aogt
  implements INetEngine.INetEngineListener
{
  public aogt(VideoFilterTools paramVideoFilterTools) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if (paramNetResp.jdField_a_of_type_Int != 0) {
      UITools.a("VideoFilterTools", "preDownloadResource file failed. errorCode: " + paramNetResp.b + ", errorMsg: " + paramNetResp.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return;
      if (!localFilterDesc.b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c)))
      {
        UITools.a("VideoFilterTools", "preDownloadResource file failed: md5 is not match.");
        FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
        return;
      }
      UITools.a("VideoFilterTools", "preDownloadResource resFile success. file: " + localFilterDesc.jdField_a_of_type_JavaLangString);
      try
      {
        String str = CaptureVideoFilterManager.b;
        FileUtils.a(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c, str, false);
        FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
        if (VideoFilterTools.a(this.a).decrementAndGet() == 0)
        {
          UITools.a("VideoFilterTools", "preDownloadResource updateComboData " + localFilterDesc.jdField_a_of_type_JavaLangString);
          if (!this.a.a(BaseApplicationImpl.sApplication))
          {
            this.a.a();
            return;
          }
        }
      }
      catch (IOException paramNetResp)
      {
        paramNetResp.printStackTrace();
        UITools.a("VideoFilterTools", "preDownloadResource unzip file failed.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aogt
 * JD-Core Version:    0.7.0.1
 */