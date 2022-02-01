import android.view.View.OnClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import java.lang.ref.WeakReference;
import java.util.Deque;

public class anpc
  implements PopupWindow.OnDismissListener
{
  public anpc(ApolloPanel paramApolloPanel) {}
  
  public void onDismiss()
  {
    View.OnClickListener localOnClickListener = null;
    this.a.a = null;
    if ((ApolloPanel.a(this.a) != null) && (ApolloPanel.a(this.a).size() > 0))
    {
      anpi localanpi = (anpi)ApolloPanel.a(this.a).poll();
      if (ApolloPanel.a(this.a).size() == 0) {
        ApolloPanel.a(this.a, null);
      }
      if (localanpi != null)
      {
        if (localanpi.jdField_a_of_type_JavaLangRefWeakReference != null) {
          localOnClickListener = (View.OnClickListener)localanpi.jdField_a_of_type_JavaLangRefWeakReference.get();
        }
        ApolloPanel.a(this.a, localanpi.jdField_a_of_type_AndroidViewView, localanpi.jdField_a_of_type_Int, localanpi.jdField_a_of_type_JavaLangString, localanpi.b, localOnClickListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpc
 * JD-Core Version:    0.7.0.1
 */