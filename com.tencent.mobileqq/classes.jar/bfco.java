import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;

public class bfco
  implements DialogInterface.OnClickListener
{
  public bfco(ReciteFragment paramReciteFragment, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.a(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.c();
    QQAppInterface localQQAppInterface;
    String str1;
    String str2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.jdField_a_of_type_Bfeo.f;
      str2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.jdField_a_of_type_Bfeo.f;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo == null) {
        break label108;
      }
    }
    label108:
    for (paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title;; paramDialogInterface = "")
    {
      bgjt.a(localQQAppInterface, str1, "Grp_recite", "Out_Recite_Clk", 0, 0, new String[] { str2, "", paramDialogInterface, "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfco
 * JD-Core Version:    0.7.0.1
 */