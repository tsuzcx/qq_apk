import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment;

public class bijz
  implements DialogInterface.OnDismissListener
{
  public bijz(LiangHaoBuyFragment paramLiangHaoBuyFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!LiangHaoBuyFragment.a(this.a)) {
      LiangHaoBuyFragment.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bijz
 * JD-Core Version:    0.7.0.1
 */