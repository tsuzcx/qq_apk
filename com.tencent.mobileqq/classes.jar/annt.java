import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextResDownloader;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.IDynamicTextResDownloadCallback;
import java.util.ArrayList;
import java.util.Iterator;

public class annt
  implements Runnable
{
  public annt(DynamicTextConfigManager paramDynamicTextConfigManager, DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, DynamicTextConfigManager.IDynamicTextResDownloadCallback paramIDynamicTextResDownloadCallback) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean.fontInfos.iterator();
    while (localIterator.hasNext())
    {
      DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo localDynamicTextFontInfo = (DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localIterator.next();
      DynamicTextConfigManager.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager).a(localDynamicTextFontInfo, this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$IDynamicTextResDownloadCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     annt
 * JD-Core Version:    0.7.0.1
 */