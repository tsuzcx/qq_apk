import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class azgl
{
  int jdField_a_of_type_Int = 0;
  DownloadInfo jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = null;
  ArrayList<azgh> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  azgl()
  {
    a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.get();
    this.jdField_a_of_type_Int = azgn.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo);
    QLog.d("QavGesture", 1, String.format("GestureMgr, mStatusGesture[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
  
  void a(boolean paramBoolean, azgh paramazgh)
  {
    localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramazgh);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramazgh);
    }
  }
  
  boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.get();
    this.jdField_a_of_type_Int = azgn.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo);
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("checkResReady, mStatusGesture[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    return 11 != this.jdField_a_of_type_Int;
  }
  
  boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("registReceiver[%s]", new Object[] { paramBaseApplicationImpl.getQQProcessName() }));
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.gesturemgr.notify");
    return paramBaseApplicationImpl.registerReceiver(new azgm(this), localIntentFilter) != null;
  }
  
  boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo == null) {
      return false;
    }
    if ((this.jdField_a_of_type_Int == 1) && (azgn.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  boolean d()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.get();
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = azgn.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo);
    if (this.jdField_a_of_type_Int == 11)
    {
      this.jdField_a_of_type_Int = 12;
      BusinessCommonConfig.notifyQQDownload(1, null, 0);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavGesture", 2, String.format("nodifyDownloadRes, lastStatus[%s], mStatusGesture[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgl
 * JD-Core Version:    0.7.0.1
 */