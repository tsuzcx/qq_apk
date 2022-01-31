import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;

class bbhd
  implements AdapterView.OnItemClickListener
{
  bbhd(bbgz parambbgz) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramAdapterView instanceof bbhg));
        paramAdapterView = (bbhg)paramAdapterView;
      } while (paramAdapterView.a == null);
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppShortcutContainer", 2, "onItemClick appInfo:" + paramAdapterView.a.toString());
      }
      if (paramAdapterView.a.a == 1)
      {
        bbgz.a(this.a, 1);
        return;
      }
    } while (paramAdapterView.a.a != 0);
    bclz.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramAdapterView.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhd
 * JD-Core Version:    0.7.0.1
 */