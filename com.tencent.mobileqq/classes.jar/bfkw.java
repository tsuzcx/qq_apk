import android.app.Dialog;
import android.content.res.Resources;
import android.util.SparseArray;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import java.util.List;

public class bfkw
  extends bfch
{
  public bfkw(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, List<bfcs> paramList)
  {
    if (this.a.isFinishing()) {
      return;
    }
    paramString = (bfcu)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.a.jdField_a_of_type_Int);
    if ((paramString == null) || (paramString.jdField_a_of_type_Int == 0)) {}
    for (paramInt2 = 30; paramInt1 >= paramInt2; paramInt2 = paramString.jdField_a_of_type_Int)
    {
      this.a.a(this.a.jdField_a_of_type_JavaLangString);
      return;
    }
    this.a.c();
    bfur.a(this.a, 230, this.a.getResources().getString(2131697219), this.a.getResources().getString(2131697218), this.a.getResources().getString(2131690620), this.a.getResources().getString(2131697221), new bfkx(this), new bfky(this)).show();
    bfks.a("gold_bean", "gap");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkw
 * JD-Core Version:    0.7.0.1
 */