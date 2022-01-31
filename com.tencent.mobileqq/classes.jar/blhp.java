import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.ttpic.baseutils.string.StringUtils;

class blhp
  implements View.OnClickListener
{
  blhp(blhn paramblhn) {}
  
  public void onClick(View paramView)
  {
    if (blhn.a(this.a).getText().length() > blhn.a(this.a))
    {
      QQToast.a(this.a.getContext(), this.a.getContext().getString(2131689849, new Object[] { Integer.valueOf(blhn.a(this.a)) }), 1).a();
      return;
    }
    if (blhn.a(this.a) != null) {
      localObject = null;
    }
    try
    {
      paramView = blhn.a(this.a).getText().toString();
      localObject = paramView;
    }
    catch (IndexOutOfBoundsException paramView)
    {
      label98:
      break label98;
    }
    paramView = (View)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = StringUtils.removeUTF8Emoji((String)localObject);
    }
    Object localObject = paramView;
    if (!TextUtils.isEmpty(paramView)) {
      localObject = paramView.replaceAll("\\r|\\n", "");
    }
    paramView = (View)localObject;
    if (localObject != null) {
      paramView = ((String)localObject).trim();
    }
    blhn.a(this.a).a(paramView);
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blhp
 * JD-Core Version:    0.7.0.1
 */