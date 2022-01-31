import android.text.Editable;
import android.text.TextUtils;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class bbeo
  implements bbal
{
  public bbeo(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    int k = 1;
    if (this.a.b.getText().length() <= 0) {}
    for (;;)
    {
      return;
      if (paramInt1 < 0)
      {
        if (paramInt2 > this.a.G.length() + 1) {}
        for (;;)
        {
          this.a.b.setSelection(paramInt2);
          return;
          paramInt2 = this.a.G.length() + 1;
        }
      }
      if (paramInt2 < 0)
      {
        if (paramInt1 > this.a.G.length() + 1) {}
        for (;;)
        {
          this.a.b.setSelection(paramInt1);
          return;
          paramInt1 = this.a.G.length() + 1;
        }
      }
      if (!TextUtils.isEmpty(this.a.G))
      {
        int i = 0;
        int j = paramInt1;
        if (paramInt1 < this.a.G.length() + 1)
        {
          j = this.a.G.length() + 1;
          i = 1;
        }
        if (paramInt2 < this.a.G.length() + 1) {
          paramInt2 = this.a.G.length() + 1;
        }
        for (paramInt1 = k; paramInt1 != 0; paramInt1 = i)
        {
          this.a.b.setSelection(j, paramInt2);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbeo
 * JD-Core Version:    0.7.0.1
 */