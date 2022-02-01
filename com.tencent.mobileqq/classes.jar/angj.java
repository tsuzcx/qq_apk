import android.view.View.OnClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import java.lang.ref.WeakReference;
import java.util.Deque;

public class angj
  implements PopupWindow.OnDismissListener
{
  public angj(ApolloPanel paramApolloPanel) {}
  
  public void onDismiss()
  {
    View.OnClickListener localOnClickListener = null;
    this.a.a = null;
    if ((ApolloPanel.a(this.a) != null) && (ApolloPanel.a(this.a).size() > 0))
    {
      ango localango = (ango)ApolloPanel.a(this.a).poll();
      if (ApolloPanel.a(this.a).size() == 0) {
        ApolloPanel.a(this.a, null);
      }
      if (localango != null)
      {
        if (localango.jdField_a_of_type_JavaLangRefWeakReference != null) {
          localOnClickListener = (View.OnClickListener)localango.jdField_a_of_type_JavaLangRefWeakReference.get();
        }
        ApolloPanel.a(this.a, localango.jdField_a_of_type_AndroidViewView, localango.jdField_a_of_type_Int, localango.jdField_a_of_type_JavaLangString, localango.b, localOnClickListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angj
 * JD-Core Version:    0.7.0.1
 */