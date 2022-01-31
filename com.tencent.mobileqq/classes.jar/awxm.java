import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class awxm
  extends awum
{
  protected int b()
  {
    return 24;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    RelativeLayout localRelativeLayout;
    int i;
    label49:
    Object localObject;
    if ((paramView != null) && ((paramView.getTag() instanceof awxo)))
    {
      localRelativeLayout = (RelativeLayout)paramView;
      localRelativeLayout.removeAllViews();
      paramView = (awxo)paramView.getTag();
      paramView.a();
      Iterator localIterator = this.a.iterator();
      i = 0;
      if (!localIterator.hasNext()) {
        break label406;
      }
      localObject = (awul)localIterator.next();
      if (!"picture".equals(((awul)localObject).a)) {
        break label227;
      }
      localObject = ((awwo)localObject).a(paramContext, paramView.jdField_a_of_type_AndroidViewView, true, paramBundle);
      i = aciy.a(30.0F, paramContext.getResources());
      localRelativeLayout.addView((View)localObject, new RelativeLayout.LayoutParams(i, i));
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject);
      ((View)localObject).setVisibility(0);
      i = 1;
    }
    for (;;)
    {
      break label49;
      localRelativeLayout = new RelativeLayout(paramContext);
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      i = aciy.a(10.0F, paramContext.getResources());
      int j = aciy.a(13.0F, paramContext.getResources());
      localRelativeLayout.setPadding(j, i, j, aciy.a(11.0F, paramContext.getResources()));
      paramView = new awxo(null);
      break;
      label227:
      if ("title".equals(((awul)localObject).a))
      {
        localObject = (TextView)((awul)localObject).a(paramContext, paramView.jdField_a_of_type_AndroidWidgetTextView, paramBundle);
        ((TextView)localObject).setGravity(16);
        localRelativeLayout.addView((View)localObject, new RelativeLayout.LayoutParams(-2, aciy.a(30.0F, paramContext.getResources())));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        ((TextView)localObject).setVisibility(0);
      }
      else if ("summary".equals(((awul)localObject).a))
      {
        ((awzf)localObject).b(2147483647);
        localObject = (TextView)((awul)localObject).a(paramContext, paramView.b, paramBundle);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.topMargin = aciy.a(34.0F, paramContext.getResources());
        localLayoutParams.bottomMargin = aciy.a(3.0F, paramContext.getResources());
        localRelativeLayout.addView((View)localObject, localLayoutParams);
        paramView.b = ((TextView)localObject);
        ((TextView)localObject).setVisibility(0);
      }
    }
    label406:
    if ((i != 0) && (paramView.jdField_a_of_type_AndroidWidgetTextView != null)) {
      ((RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).leftMargin = aciy.a(38.0F, paramContext.getResources());
    }
    localRelativeLayout.setTag(paramView);
    return localRelativeLayout;
  }
  
  public String b()
  {
    return "layout24";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awxm
 * JD-Core Version:    0.7.0.1
 */