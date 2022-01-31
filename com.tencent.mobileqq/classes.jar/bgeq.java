import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.thread.QzoneThreadMonitor;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.exception.QZoneStartupFailException;
import java.util.concurrent.ConcurrentHashMap;

public class bgeq
  extends Handler
{
  public bgeq(QzoneThreadMonitor paramQzoneThreadMonitor, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    bges localbges = (bges)paramMessage.obj;
    if (!QzoneThreadMonitor.access$000(this.a).containsKey(localbges.jdField_a_of_type_JavaLangString))
    {
      QZLog.w("QzoneThreadMonitor", 1, new Object[] { "massage has been canceled. id=", localbges.jdField_a_of_type_JavaLangString });
      return;
    }
    if (paramMessage.arg1 >= 10)
    {
      QZLog.w("QzoneThreadMonitor", 1, new Object[] { "stack check for too many times. id=", localbges.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject = QzoneThreadMonitor.access$100(QzoneHandlerThreadFactory.getHandlerThreadLooper(localbges.jdField_b_of_type_JavaLangString).getThread().getStackTrace(), localbges.jdField_b_of_type_JavaLangString + " id=" + localbges.jdField_a_of_type_JavaLangString + ": ");
    QZLog.w("QzoneThreadMonitor", 1, new Object[] { "[stack] ", localbges.jdField_b_of_type_JavaLangString, " id=", localbges.jdField_a_of_type_JavaLangString, " what=", Integer.valueOf(localbges.jdField_a_of_type_Int), " msg.target=", localbges.c, " msg.callback=", localbges.d });
    QZLog.w("QzoneThreadMonitor", 1, new Object[] { localObject });
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "report_backgroudmonitor", "0").equals("1")) {
      bgfy.a(new QZoneStartupFailException(new Throwable((String)localObject)), ((String)localObject).toString());
    }
    paramMessage = Message.obtain(QzoneThreadMonitor.access$200(this.a), 1, paramMessage.arg1 + 1, 0, localbges);
    localObject = QzoneThreadMonitor.access$200(this.a);
    if (localbges.jdField_b_of_type_Int == 1) {}
    for (long l = 500L;; l = 250L)
    {
      ((Handler)localObject).sendMessageDelayed(paramMessage, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgeq
 * JD-Core Version:    0.7.0.1
 */