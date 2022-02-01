import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.string.StringUtils;

class boym
  implements View.OnClickListener
{
  boym(boyk paramboyk) {}
  
  public void onClick(View paramView)
  {
    if (boyk.a(this.a).getText().length() > boyk.a(this.a)) {
      QQToast.a(this.a.getContext(), this.a.getContext().getString(2131689759, new Object[] { Integer.valueOf(boyk.a(this.a)) }), 1).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (boyk.a(this.a) != null) {
        localObject2 = null;
      }
      try
      {
        localObject1 = boyk.a(this.a).getText().toString();
        localObject2 = localObject1;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Object localObject1;
        label105:
        break label105;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = StringUtils.removeUTF8Emoji((String)localObject2);
      }
      Object localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = ((String)localObject1).replaceAll("\\r|\\n", "");
      }
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
      boyk.a(this.a).a((String)localObject1);
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boym
 * JD-Core Version:    0.7.0.1
 */