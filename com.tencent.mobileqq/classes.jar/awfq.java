import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richstatus.RichStatus;

public class awfq
  extends awfk
{
  public awfq(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    super(paramContext, paramAppInterface, paramView, paramString);
    this.e = 0;
  }
  
  public View a(RichStatus paramRichStatus)
  {
    paramRichStatus = super.a(paramRichStatus);
    l();
    return paramRichStatus;
  }
  
  protected CharSequence a(RichStatus paramRichStatus, awft paramawft, int paramInt)
  {
    if (paramRichStatus == null) {
      paramawft = "";
    }
    do
    {
      return paramawft;
      localObject1 = paramRichStatus.toSpannableStringWithoutAction(paramawft);
      paramawft = (awft)localObject1;
    } while (TextUtils.isEmpty(paramRichStatus.actionText));
    Object localObject2 = paramRichStatus.actionText;
    paramawft = (awft)localObject2;
    if (!TextUtils.isEmpty(paramRichStatus.dataText)) {
      paramawft = (String)localObject2 + paramRichStatus.dataText;
    }
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848540);
    localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
    ((SpannableStringBuilder)localObject2).insert(0, "[S] ");
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848533);
    String str = awei.a().a(paramRichStatus.actionId);
    paramRichStatus = (RichStatus)localObject1;
    if (!TextUtils.isEmpty(str))
    {
      paramRichStatus = URLDrawable.URLDrawableOptions.obtain();
      paramRichStatus.mLoadingDrawable = ((Drawable)localObject1);
      paramRichStatus.mFailedDrawable = ((Drawable)localObject1);
      paramRichStatus.mRequestWidth = paramInt;
      paramRichStatus.mRequestHeight = paramInt;
      paramRichStatus = URLDrawable.getDrawable(str, paramRichStatus);
      paramRichStatus.setCallback(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
    }
    paramRichStatus.setBounds(0, 0, paramInt, paramInt);
    int i = Color.parseColor("#ffa8a8a8");
    if ((Build.VERSION.SDK_INT >= 4) && (Build.VERSION.SDK_INT != 20)) {}
    for (paramRichStatus = new awcz(paramRichStatus, 1, paramawft, i, localDrawable, paramInt);; paramRichStatus = new awcz(paramRichStatus, 0, paramawft, i, localDrawable, paramInt))
    {
      ((SpannableStringBuilder)localObject2).setSpan(paramRichStatus, 0, "[S]".length(), 17);
      return localObject2;
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected boolean d()
  {
    return false;
  }
  
  protected void e()
  {
    int i = jdField_a_of_type_ArrayOfInt[6];
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(i, i, i, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awfq
 * JD-Core Version:    0.7.0.1
 */