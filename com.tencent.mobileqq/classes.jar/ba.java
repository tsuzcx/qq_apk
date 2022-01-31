import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ba
  implements DialogInterface.OnClickListener
{
  public ba(LiteActivity paramLiteActivity, List paramList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    alqo localalqo = (alqo)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(8);
    localalqo.b(113);
    localalqo.a(116);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
        dl.f(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
      }
      localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
    }
    localalqo.a(localArrayList);
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ba
 * JD-Core Version:    0.7.0.1
 */