import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.util.SparseArray;
import android.widget.Button;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;

public class batg
  extends baks
{
  public batg(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public void a(SparseArray<balf> paramSparseArray)
  {
    int j = 0;
    this.a.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    Object localObject = (balf)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.a.jdField_a_of_type_Int);
    if (localObject != null)
    {
      paramSparseArray = ((balf)localObject).a;
      if (localObject == null) {
        break label120;
      }
      localObject = ((balf)localObject).b;
      label55:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label126;
      }
      j = paramSparseArray.indexOf((String)localObject);
    }
    label120:
    label126:
    for (int i = ((String)localObject).length() + j;; i = 0)
    {
      paramSparseArray = new SpannableString(paramSparseArray);
      paramSparseArray.setSpan(new StrikethroughSpan(), j, i, 18);
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(paramSparseArray);
      return;
      paramSparseArray = "30金豆秀一下";
      break;
      localObject = null;
      break label55;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     batg
 * JD-Core Version:    0.7.0.1
 */