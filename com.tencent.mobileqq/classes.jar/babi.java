import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mobileqq.tablequery.TableQueryViewer;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class babi
  implements AdapterView.OnItemLongClickListener
{
  public babi(TableQueryViewer paramTableQueryViewer, Context paramContext) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((babc)TableQueryViewer.a(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer).get(paramInt)).b;
    paramView = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
    if ((paramView != null) && (!TextUtils.isEmpty(paramAdapterView)))
    {
      paramView.setPrimaryClip(ClipData.newPlainText("bigT", paramAdapterView));
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer.getContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131690516), 0).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babi
 * JD-Core Version:    0.7.0.1
 */