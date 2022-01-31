import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import dov.com.tencent.mobileqq.shortvideo.gesture.GestureMgr.GestureStatusListener;
import dov.com.tencent.mobileqq.shortvideo.gesture.GestureMgrDownload;
import dov.com.tencent.mobileqq.shortvideo.gesture.GestureUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class aoyf
  extends BroadcastReceiver
{
  public aoyf(GestureMgrDownload paramGestureMgrDownload) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    for (;;)
    {
      return;
      if (!"tencent.video.gesturemgr.notify".equals(paramIntent.getAction())) {
        continue;
      }
      int i = paramIntent.getIntExtra("Event_Progress", 0);
      if ((i == 100) || (i < 0))
      {
        this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.a();
        int j = this.a.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_Int = GestureUtil.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo);
        boolean bool;
        if ((i == 100) && (this.a.jdField_a_of_type_Int != 11))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("QavGesture", 2, String.format("receive notify, lastStatus[%s], progress[%s], mStatusGesture[%s], data[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo }));
          }
          paramIntent = new ArrayList();
        }
        synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
        {
          paramIntent.addAll(this.a.jdField_a_of_type_JavaUtilArrayList);
          ??? = paramIntent.iterator();
          while (???.hasNext()) {
            ((GestureMgr.GestureStatusListener)???.next()).a(bool, this.a.a(), this.a.jdField_a_of_type_Int);
          }
          bool = false;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGesture", 4, String.format("receive notify, progress[%s]", new Object[] { Integer.valueOf(i) }));
      }
      paramIntent = new ArrayList();
      synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
      {
        paramIntent.addAll(this.a.jdField_a_of_type_JavaUtilArrayList);
        ??? = paramIntent.iterator();
        if (!???.hasNext()) {
          continue;
        }
        ((GestureMgr.GestureStatusListener)???.next()).a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoyf
 * JD-Core Version:    0.7.0.1
 */