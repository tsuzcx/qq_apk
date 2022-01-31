import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.ttpic.baseutils.string.StringUtils;

class bhbm
  implements View.OnClickListener
{
  bhbm(bhbk parambhbk) {}
  
  public void onClick(View paramView)
  {
    if (bhbk.a(this.a).getText().length() > bhbk.a(this.a))
    {
      bbmy.a(this.a.getContext(), this.a.getContext().getString(2131624262, new Object[] { Integer.valueOf(bhbk.a(this.a)) }), 1).a();
      return;
    }
    if (bhbk.a(this.a) != null) {
      localObject = null;
    }
    try
    {
      paramView = bhbk.a(this.a).getText().toString();
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
    bhbk.a(this.a).a((String)localObject);
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhbm
 * JD-Core Version:    0.7.0.1
 */