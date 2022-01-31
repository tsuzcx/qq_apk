import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class bkqi
  implements MessageQueue.IdleHandler
{
  bkqi(bkqg parambkqg, int paramInt1, int paramInt2) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "load Scroll Position,index:" + this.jdField_a_of_type_Int + " top:" + this.b);
    }
    this.jdField_a_of_type_Bkqg.a.setSelectionFromTop(this.jdField_a_of_type_Int, this.b);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqi
 * JD-Core Version:    0.7.0.1
 */