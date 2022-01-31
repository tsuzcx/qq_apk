import android.app.Dialog;
import android.content.res.Resources;
import android.util.SparseArray;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import java.util.List;

public class bcsp
  extends bcjt
{
  public bcsp(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, List<bcke> paramList)
  {
    if (this.a.isFinishing()) {
      return;
    }
    paramString = (bckg)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.a.jdField_a_of_type_Int);
    if ((paramString == null) || (paramString.jdField_a_of_type_Int == 0)) {}
    for (paramInt2 = 30; paramInt1 >= paramInt2; paramInt2 = paramString.jdField_a_of_type_Int)
    {
      this.a.a(this.a.jdField_a_of_type_JavaLangString);
      return;
    }
    this.a.c();
    bdcd.a(this.a, 230, this.a.getResources().getString(2131698176), this.a.getResources().getString(2131698175), this.a.getResources().getString(2131690648), this.a.getResources().getString(2131698178), new bcsq(this), new bcsr(this)).show();
    bcsl.a("gold_bean", "gap");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsp
 * JD-Core Version:    0.7.0.1
 */