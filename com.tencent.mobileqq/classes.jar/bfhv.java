import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class bfhv
  extends azwy
{
  public bfhv(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAvatarWallPreviewActivity", 2, "onDelPersonalityLabelPhoto,suc:" + paramBoolean + "," + paramString + "," + paramLong1 + "," + paramLong2);
    }
    if ((!paramString.equals(this.a.app.getCurrentAccountUin())) || (TroopAvatarWallPreviewActivity.a(this.a) == null)) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_Int < 0) || (this.a.jdField_a_of_type_Int > this.a.jdField_a_of_type_Bgws.getCount() - 1) || (this.a.jdField_b_of_type_JavaUtilArrayList == null) || (this.a.jdField_a_of_type_Int > this.a.jdField_b_of_type_JavaUtilArrayList.size() - 1));
      l1 = TroopAvatarWallPreviewActivity.a(this.a).getLong("label_id", 0L);
      l2 = Long.valueOf((String)this.a.jdField_b_of_type_JavaUtilArrayList.get(this.a.jdField_a_of_type_Int)).longValue();
    } while ((l1 != paramLong1) || (l2 != paramLong2));
    TroopAvatarWallPreviewActivity.j(this.a);
    TroopAvatarWallPreviewActivity localTroopAvatarWallPreviewActivity = this.a;
    if (paramBoolean) {}
    for (paramString = this.a.getResources().getString(2131692414);; paramString = this.a.getResources().getString(2131691329))
    {
      TroopAvatarWallPreviewActivity.b(localTroopAvatarWallPreviewActivity, paramString);
      if (!paramBoolean) {
        break;
      }
      this.a.jdField_b_of_type_JavaUtilArrayList.remove(this.a.jdField_a_of_type_Int);
      this.a.jdField_a_of_type_JavaUtilList.remove(this.a.jdField_a_of_type_Int);
      this.a.jdField_b_of_type_Int = this.a.jdField_a_of_type_JavaUtilList.size();
      if (this.a.jdField_b_of_type_JavaUtilArrayList.size() == 0) {
        this.a.finish();
      }
      if (this.a.jdField_a_of_type_Int >= this.a.jdField_a_of_type_Bgws.getCount())
      {
        paramString = this.a;
        paramString.jdField_a_of_type_Int -= 1;
      }
      paramString = this.a.jdField_a_of_type_Int + 1 + "/" + this.a.jdField_b_of_type_Int;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.a.jdField_a_of_type_Bgws.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhv
 * JD-Core Version:    0.7.0.1
 */