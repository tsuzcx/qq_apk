import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.StatusServlet;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.NewIntent;

public class axzb
  implements DialogInterface.OnClickListener
{
  public axzb(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new ArrayList();
    Object localObject = SignatureHistoryFragment.a(this.a).iterator();
    int i;
    for (paramInt = 0; ((Iterator)localObject).hasNext(); paramInt = i)
    {
      String str = (String)((Iterator)localObject).next();
      i = paramInt;
      if (str != null)
      {
        i = paramInt;
        if (SignatureHistoryFragment.b(this.a) != null)
        {
          i = paramInt;
          if (SignatureHistoryFragment.b(this.a).get(0) != null)
          {
            i = paramInt;
            if (((HistorySignItem)SignatureHistoryFragment.b(this.a).get(0)).richStatus != null)
            {
              i = paramInt;
              if (((HistorySignItem)SignatureHistoryFragment.b(this.a).get(0)).richStatus.feedsId != null)
              {
                if (str.equals(new String(((HistorySignItem)SignatureHistoryFragment.b(this.a).get(0)).richStatus.feedsId))) {
                  paramInt = 1;
                }
                paramDialogInterface.add(str);
                i = paramInt;
              }
            }
          }
        }
      }
    }
    if (SignatureHistoryFragment.a(this.a) == null) {
      SignatureHistoryFragment.a(this.a, new bepp(this.a.getActivity(), this.a.getActivity().getTitleBarHeight()));
    }
    SignatureHistoryFragment.a(this.a).a(alpo.a(2131714506));
    SignatureHistoryFragment.a(this.a).show();
    if ((SignatureHistoryFragment.a(this.a)) && (SignatureHistoryFragment.b(this.a).size() == 1))
    {
      paramDialogInterface = new NewIntent(this.a.getActivity().app.getApp(), StatusServlet.class);
      paramDialogInterface.putExtra("k_cmd", 8);
      this.a.getActivity().app.startServlet(paramDialogInterface);
    }
    while (paramDialogInterface.isEmpty())
    {
      azmj.b(null, "dc00898", "", "", "0X800A98D", "0X800A98D", 1, 0, "0", "0", "", "");
      VasWebviewUtil.reportCommercialDrainage(this.a.getActivity().app.c(), "signature", "signature_10", "", 1, 0, 0, "", "", "");
      return;
    }
    localObject = new NewIntent(this.a.getActivity().app.getApp(), StatusServlet.class);
    ((NewIntent)localObject).putExtra("k_cmd", 5);
    ((NewIntent)localObject).putStringArrayListExtra("k_status_key", paramDialogInterface);
    if (paramInt != 0) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((NewIntent)localObject).putExtra("k_status_flag", paramInt);
      this.a.getActivity().app.startServlet((NewIntent)localObject);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzb
 * JD-Core Version:    0.7.0.1
 */