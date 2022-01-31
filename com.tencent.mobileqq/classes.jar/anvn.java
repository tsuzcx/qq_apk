import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager.InformationPasterResDownloader;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class anvn
  implements Runnable
{
  public anvn(QIMInformationPasterManager paramQIMInformationPasterManager, List paramList) {}
  
  public void run()
  {
    QIMInformationPasterManager.a(this.jdField_a_of_type_DovComQqImCapturePasterQIMInformationPasterManager).clear();
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "patch pull res");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    InfomationFacePackage.Item localItem;
    while (localIterator.hasNext())
    {
      localItem = (InfomationFacePackage.Item)localIterator.next();
      if ((!TextUtils.isEmpty(localItem.d)) && (!this.jdField_a_of_type_DovComQqImCapturePasterQIMInformationPasterManager.a(localItem))) {
        QIMInformationPasterManager.a(this.jdField_a_of_type_DovComQqImCapturePasterQIMInformationPasterManager).add(localItem);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "need download size:" + QIMInformationPasterManager.a(this.jdField_a_of_type_DovComQqImCapturePasterQIMInformationPasterManager).size());
    }
    localIterator = QIMInformationPasterManager.a(this.jdField_a_of_type_DovComQqImCapturePasterQIMInformationPasterManager).iterator();
    while (localIterator.hasNext())
    {
      localItem = (InfomationFacePackage.Item)localIterator.next();
      this.jdField_a_of_type_DovComQqImCapturePasterQIMInformationPasterManager.a.a(localItem, new anvo(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvn
 * JD-Core Version:    0.7.0.1
 */