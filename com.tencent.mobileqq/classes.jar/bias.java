import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment;

public class bias
  implements DialogInterface.OnDismissListener
{
  public bias(LiangHaoBuyFragment paramLiangHaoBuyFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!LiangHaoBuyFragment.a(this.a)) {
      LiangHaoBuyFragment.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bias
 * JD-Core Version:    0.7.0.1
 */