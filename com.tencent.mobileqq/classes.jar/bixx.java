import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.ttpic.baseutils.string.StringUtils;

class bixx
  implements View.OnClickListener
{
  bixx(bixv parambixv) {}
  
  public void onClick(View paramView)
  {
    if (bixv.a(this.a).getText().length() > bixv.a(this.a))
    {
      bcpw.a(this.a.getContext(), this.a.getContext().getString(2131689807, new Object[] { Integer.valueOf(bixv.a(this.a)) }), 1).a();
      return;
    }
    if (bixv.a(this.a) != null) {
      localObject = null;
    }
    try
    {
      paramView = bixv.a(this.a).getText().toString();
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
    bixv.a(this.a).a(paramView);
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bixx
 * JD-Core Version:    0.7.0.1
 */