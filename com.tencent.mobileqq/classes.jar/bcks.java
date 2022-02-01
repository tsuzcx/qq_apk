import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bcks
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcgx jdField_a_of_type_Bcgx;
  private int b;
  
  public bcks(bcgx parambcgx, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_Bcgx = parambcgx;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296449);
  }
  
  private TextView a(String paramString, View paramView, boolean paramBoolean)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    TextView localTextView;
    if (paramView == null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setMaxLines(2);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 19.0F);
      localTextView.setMaxLines(2);
      localTextView.setLineSpacing(AIOUtils.dp2px(2.5F, localResources), 1.0F);
      localTextView.setGravity(80);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      if (paramBoolean) {
        localTextView.setBackgroundResource(2130841665);
      }
      int i = AIOUtils.dp2px(12.5F, localResources);
      int j = AIOUtils.dp2px(12.0F, localResources);
      localTextView.setPadding(j, 0, j, i);
      localTextView.setId(2131377978);
      paramView = localTextView;
      if (!TextUtils.isEmpty(paramString))
      {
        localTextView.setText(paramString);
        paramView = localTextView;
      }
    }
    do
    {
      do
      {
        return paramView;
        localTextView = (TextView)paramView;
        if (!TextUtils.isEmpty(paramString)) {
          localTextView.setText(paramString);
        }
        paramView = localTextView;
      } while (!paramBoolean);
      paramView = localTextView;
    } while (localTextView.getBackground() != null);
    localTextView.setBackgroundResource(2130841665);
    return localTextView;
  }
  
  public static boolean a(bcgx parambcgx, int paramInt)
  {
    if (paramInt != 0) {
      return false;
    }
    parambcgx = parambcgx.a.iterator();
    label14:
    String str;
    if (parambcgx.hasNext())
    {
      str = ((bcgw)parambcgx.next()).a;
      if (!"picture".equals(str)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (!"title".equals(str)) {
        break;
      }
      break label14;
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (!a(this.jdField_a_of_type_Bcgx, this.jdField_a_of_type_Int)) {
      paramContext = this.jdField_a_of_type_Bcgx.a(paramContext, paramView, paramBundle);
    }
    LinearLayout localLinearLayout;
    Object localObject1;
    Object localObject2;
    do
    {
      return paramContext;
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgItemLayout5Adapter", 2, "layout5 use new style");
      }
      if ((paramView == null) || (!(paramView instanceof LinearLayout))) {
        break label598;
      }
      localLinearLayout = (LinearLayout)paramView;
      localObject1 = (FrameLayout)localLinearLayout.findViewById(2131377960);
      if (localObject1 == null) {
        break label381;
      }
      localObject2 = this.jdField_a_of_type_Bcgx.a.iterator();
      paramView = null;
      if (((Iterator)localObject2).hasNext())
      {
        bcgw localbcgw = (bcgw)((Iterator)localObject2).next();
        String str = localbcgw.a;
        if ("title".equals(str)) {
          paramView = ((StructMsgItemTitle)localbcgw).b();
        }
        for (;;)
        {
          break;
          if ("picture".equals(str)) {
            this.jdField_a_of_type_AndroidViewView = a(localbcgw, (View)localObject1, paramBundle);
          }
        }
      }
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break;
      }
      paramBundle = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377975);
      if (!TextUtils.isEmpty(paramView))
      {
        if (paramBundle != null)
        {
          a(paramView, paramBundle, true);
          return localLinearLayout;
        }
        paramContext = a(paramView, null, true);
        paramView = new ViewGroup.LayoutParams(-1, this.b);
        paramContext.setId(2131377975);
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(paramContext, paramView);
        return localLinearLayout;
      }
      paramContext = localLinearLayout;
    } while (paramBundle == null);
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(paramBundle);
    return localLinearLayout;
    localLinearLayout.removeAllViews();
    for (;;)
    {
      if (localLinearLayout == null)
      {
        localLinearLayout = new LinearLayout(paramContext);
        localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        localLinearLayout.setOrientation(1);
        localLinearLayout.setId(2131377976);
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_Bcgx.a.iterator();
        label331:
        if (((Iterator)localObject1).hasNext())
        {
          paramContext = (bcgw)((Iterator)localObject1).next();
          localObject2 = paramContext.a;
          if ("title".equals(localObject2)) {}
          for (paramContext = ((StructMsgItemTitle)paramContext).b();; paramContext = paramView)
          {
            paramView = paramContext;
            break label331;
            label381:
            localLinearLayout.removeAllViews();
            paramView = null;
            break;
            if ("picture".equals(localObject2)) {
              this.jdField_a_of_type_AndroidViewView = a(paramContext, null, paramBundle);
            }
          }
        }
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          if (!TextUtils.isEmpty(paramView))
          {
            paramContext = new ViewGroup.LayoutParams(-1, this.b);
            paramView = a(paramView.trim(), null, true);
            paramView.setId(2131377975);
            ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(paramView, paramContext);
          }
          localLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
        }
        for (;;)
        {
          return localLinearLayout;
          if ((!TextUtils.isEmpty(paramView)) && (paramView.trim().length() > 0))
          {
            this.jdField_a_of_type_AndroidWidgetTextView = a(paramView.trim(), null, false);
            paramContext = new ViewGroup.LayoutParams(-2, -2);
            this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramContext);
            int i = AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, i, i, i);
            this.jdField_a_of_type_AndroidWidgetTextView.setId(2131377978);
            this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
            localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
          }
        }
      }
      label598:
      paramView = null;
      localLinearLayout = null;
    }
  }
  
  public View a(bcgw parambcgw, View paramView, Bundle paramBundle)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if ((paramView != null) && ((paramView instanceof FrameLayout)))
    {
      paramView = (FrameLayout)paramView;
      parambcgw.a(this.jdField_a_of_type_AndroidContentContext, paramView.findViewById(2131368518), paramBundle);
      return paramView;
    }
    paramView = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    paramView.setId(2131377960);
    if (paramBundle != null) {
      paramBundle.putBoolean("pa_should_change", true);
    }
    parambcgw = (ImageView)parambcgw.a(this.jdField_a_of_type_AndroidContentContext, null, paramBundle).findViewById(2131368518);
    paramBundle = new FrameLayout.LayoutParams(-1, this.b);
    if ((parambcgw != null) && ((parambcgw instanceof PAImageView)))
    {
      PAImageView localPAImageView = (PAImageView)parambcgw;
      localPAImageView.setUseRadiusRound(true, localResources.getDimensionPixelSize(2131296448));
      localPAImageView.setTag(2131373119, Integer.valueOf(1));
    }
    paramView.addView(parambcgw, paramBundle);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcks
 * JD-Core Version:    0.7.0.1
 */