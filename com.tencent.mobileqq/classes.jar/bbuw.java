import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbuw
  extends bbvi
{
  private bbuw(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  protected void a(boolean paramBoolean, List<byte[]> paramList, List<Integer> paramList1)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onDeleteStatus. isSuccess=").append(paramBoolean).append(", keyListSize=").append(paramList.size()).append(", errorCodeSize=");
      if (paramList1 != null) {
        break label231;
      }
    }
    label231:
    for (paramList1 = "null";; paramList1 = Integer.valueOf(paramList1.size()))
    {
      QLog.d("SignatureHistoryFragment", 2, paramList1);
      if ((SignatureHistoryFragment.a(this.a) != null) && (SignatureHistoryFragment.a(this.a).isShowing())) {
        SignatureHistoryFragment.a(this.a).dismiss();
      }
      if ((!paramBoolean) || (paramList == null)) {
        break label419;
      }
      if (this.a.getActivity() != null) {
        this.a.a(2, 2131691331);
      }
      paramList = paramList.iterator();
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label244;
        }
        paramList1 = (byte[])paramList.next();
        localObject = SignatureHistoryFragment.b(this.a).iterator();
        if (((Iterator)localObject).hasNext())
        {
          HistorySignItem localHistorySignItem = (HistorySignItem)((Iterator)localObject).next();
          if ((localHistorySignItem == null) || (localHistorySignItem.richStatus == null) || (!localHistorySignItem.richStatus.feedsId.equals(new String(paramList1)))) {
            break;
          }
          ((Iterator)localObject).remove();
        }
      }
    }
    label244:
    if (SignatureHistoryFragment.b(this.a).size() == 0) {
      SignatureHistoryFragment.a(this.a, 3);
    }
    SignatureHistoryFragment.a(this.a).clear();
    SignatureHistoryFragment.b(this.a, false);
    SignatureHistoryFragment.a(this.a).setText(2131718270);
    SignatureHistoryFragment.b(this.a, false);
    if (SignatureHistoryFragment.a(this.a) != null) {
      SignatureHistoryFragment.a(this.a).notifyDataSetChanged();
    }
    for (;;)
    {
      if ((paramBoolean) && (this.a.getActivity() != null))
      {
        BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putBoolean(SignatureHistoryFragment.b(this.a) + "_has_history_sig_del_key", true).apply();
        if (this.a.a != null) {
          this.a.a.a(Long.parseLong(SignatureHistoryFragment.a(this.a)));
        }
      }
      return;
      label419:
      if (this.a.getActivity() != null) {
        this.a.a(1, 2131698320);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbuw
 * JD-Core Version:    0.7.0.1
 */