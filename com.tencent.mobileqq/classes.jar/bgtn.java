import android.app.Dialog;
import android.content.res.Resources;
import android.util.SparseArray;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import java.util.List;

public class bgtn
  extends bgkn
{
  public bgtn(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, List<bgky> paramList)
  {
    if (this.a.isFinishing()) {
      return;
    }
    paramString = (bgla)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.a.jdField_a_of_type_Int);
    if ((paramString == null) || (paramString.jdField_a_of_type_Int == 0)) {}
    for (paramInt2 = 30; paramInt1 >= paramInt2; paramInt2 = paramString.jdField_a_of_type_Int)
    {
      this.a.a(this.a.jdField_a_of_type_JavaLangString);
      return;
    }
    this.a.c();
    bhdj.a(this.a, 230, this.a.getResources().getString(2131697496), this.a.getResources().getString(2131697495), this.a.getResources().getString(2131690697), this.a.getResources().getString(2131697498), new bgto(this), new bgtp(this)).show();
    bgtj.a("gold_bean", "gap");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtn
 * JD-Core Version:    0.7.0.1
 */