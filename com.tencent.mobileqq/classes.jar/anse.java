import android.view.View.OnClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import java.lang.ref.WeakReference;
import java.util.Deque;

public class anse
  implements PopupWindow.OnDismissListener
{
  public anse(ApolloPanel paramApolloPanel) {}
  
  public void onDismiss()
  {
    View.OnClickListener localOnClickListener = null;
    this.a.a = null;
    if ((ApolloPanel.a(this.a) != null) && (ApolloPanel.a(this.a).size() > 0))
    {
      ansj localansj = (ansj)ApolloPanel.a(this.a).poll();
      if (ApolloPanel.a(this.a).size() == 0) {
        ApolloPanel.a(this.a, null);
      }
      if (localansj != null)
      {
        if (localansj.jdField_a_of_type_JavaLangRefWeakReference != null) {
          localOnClickListener = (View.OnClickListener)localansj.jdField_a_of_type_JavaLangRefWeakReference.get();
        }
        ApolloPanel.a(this.a, localansj.jdField_a_of_type_AndroidViewView, localansj.jdField_a_of_type_Int, localansj.jdField_a_of_type_JavaLangString, localansj.b, localOnClickListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anse
 * JD-Core Version:    0.7.0.1
 */