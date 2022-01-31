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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class azud
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private azqk jdField_a_of_type_Azqk;
  private int b;
  
  public azud(azqk paramazqk, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_Azqk = paramazqk;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296358);
  }
  
  private TextView a(azvd paramazvd, View paramView)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    TextView localTextView;
    if (paramView == null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.setMargins(0, 0, 0, 0);
      localTextView.setLayoutParams(paramView);
      localTextView.setMaxLines(3);
      localTextView.setTextColor(-16777216);
      localTextView.setTextSize(2, 16.0F);
      localTextView.setLineSpacing(aekt.a(2.5F, localResources), 1.0F);
      localTextView.setGravity(16);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      int i = aekt.a(15.0F, localResources);
      int j = aekt.a(12.0F, localResources);
      localTextView.setPadding(j, aekt.a(18.0F, localResources), j, i);
      paramView = localTextView;
      if (!TextUtils.isEmpty(paramazvd.b()))
      {
        localTextView.setText(paramazvd.b().trim());
        paramView = localTextView;
      }
    }
    do
    {
      return paramView;
      localTextView = (TextView)paramView;
      paramView = localTextView;
    } while (TextUtils.isEmpty(paramazvd.b()));
    localTextView.setText(paramazvd.b().trim());
    return localTextView;
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
      localTextView.setLineSpacing(aekt.a(2.5F, localResources), 1.0F);
      localTextView.setGravity(80);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setIncludeFontPadding(false);
      if (paramBoolean) {
        localTextView.setBackgroundResource(2130841314);
      }
      int i = aekt.a(8.0F, localResources);
      int j = aekt.a(12.0F, localResources);
      localTextView.setPadding(j, 0, j, i);
      localTextView.setId(2131377186);
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
    localTextView.setBackgroundResource(2130841314);
    return localTextView;
  }
  
  public static boolean a(azqk paramazqk, int paramInt)
  {
    Object localObject = null;
    if (BaseApplicationImpl.sApplication != null) {
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    }
    if ((localObject == null) || (TextUtils.isEmpty(paramazqk.R)) || ((!syb.a((QQAppInterface)localObject, paramazqk.R)) && (!"2909288299".equals(paramazqk.R)) && (!"3338705755".equals(paramazqk.R)))) {}
    int j;
    label83:
    do
    {
      do
      {
        return false;
      } while (paramInt != 0);
      int i = 0;
      j = 0;
      paramInt = 0;
      if (i < paramazqk.a.size())
      {
        localObject = ((azqj)paramazqk.a.get(i)).a;
        int m;
        int k;
        if ("picture".equals(localObject))
        {
          m = paramInt + 1;
          k = j;
        }
        for (;;)
        {
          i += 1;
          j = k;
          paramInt = m;
          break label83;
          if ("summary".equals(localObject))
          {
            k = j;
            m = paramInt;
            if (paramInt != 0)
            {
              k = j + 1;
              m = paramInt;
            }
          }
          else
          {
            if (!"title".equals(localObject)) {
              break;
            }
            k = j;
            m = paramInt;
          }
        }
      }
    } while ((paramInt != 1) || (j > 1));
    return true;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject3 = null;
    paramContext.getResources();
    Object localObject2 = null;
    if (!a(this.jdField_a_of_type_Azqk, this.jdField_a_of_type_Int))
    {
      paramContext = this.jdField_a_of_type_Azqk.a(paramContext, paramView, paramBundle);
      return paramContext;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout6Adapter", 2, "layout6 use new style!");
    }
    Object localObject1 = localObject3;
    FrameLayout localFrameLayout;
    int i;
    int j;
    int k;
    label117:
    String str;
    int m;
    if (paramView != null)
    {
      localObject1 = localObject3;
      if ((paramView instanceof LinearLayout))
      {
        localObject1 = (LinearLayout)paramView;
        localFrameLayout = (FrameLayout)((LinearLayout)localObject1).findViewById(2131377170);
        if (localFrameLayout != null)
        {
          paramView = null;
          localObject3 = new ArrayList();
          i = 0;
          j = 0;
          k = 0;
          paramContext = (Context)localObject2;
          if (k < this.jdField_a_of_type_Azqk.a.size())
          {
            localObject2 = (azqj)this.jdField_a_of_type_Azqk.a.get(k);
            str = ((azqj)localObject2).a;
            if ("title".equals(str))
            {
              localObject2 = ((StructMsgItemTitle)localObject2).b();
              m = j;
              paramView = paramContext;
              paramContext = (Context)localObject2;
              j = i;
              i = m;
            }
          }
        }
      }
    }
    for (;;)
    {
      m = k + 1;
      localObject2 = paramContext;
      paramContext = paramView;
      k = j;
      j = i;
      i = k;
      paramView = (View)localObject2;
      k = m;
      break label117;
      if ("picture".equals(str))
      {
        localObject2 = a((azqj)localObject2, localFrameLayout, paramBundle);
        m = 1;
        paramContext = paramView;
        paramView = (View)localObject2;
        j = i;
        i = m;
      }
      else
      {
        if ("summary".equals(str))
        {
          localObject2 = (azvd)localObject2;
          if ((j != 0) && (!TextUtils.isEmpty(((azvd)localObject2).b())))
          {
            if (((azvd)localObject2).b().trim().length() <= 0)
            {
              localObject2 = paramContext;
              m = i;
              i = j;
              j = m;
              paramContext = paramView;
              paramView = (View)localObject2;
              continue;
            }
            ((ArrayList)localObject3).add(a((azvd)localObject2, ((LinearLayout)localObject1).findViewById(i + 2131377185)));
            localObject2 = paramContext;
            paramContext = paramView;
            m = i + 1;
            i = j;
            j = m;
            paramView = (View)localObject2;
            continue;
            ((LinearLayout)localObject1).removeAllViews();
            if (paramContext != null)
            {
              paramBundle = (TextView)paramContext.findViewById(2131377183);
              if (!TextUtils.isEmpty(paramView)) {
                if (paramBundle == null)
                {
                  paramView = a(paramView, null, true);
                  paramView.setId(2131377183);
                  paramBundle = new ViewGroup.LayoutParams(-1, this.b);
                  ((ViewGroup)paramContext).addView(paramView, paramBundle);
                  label449:
                  ((LinearLayout)localObject1).addView(paramContext);
                }
              }
            }
            for (;;)
            {
              paramContext = (Context)localObject1;
              if (((ArrayList)localObject3).size() <= 0) {
                break;
              }
              paramView = ((ArrayList)localObject3).iterator();
              for (;;)
              {
                paramContext = (Context)localObject1;
                if (!paramView.hasNext()) {
                  break;
                }
                ((LinearLayout)localObject1).addView((View)paramView.next());
              }
              a(paramView, paramBundle, true);
              break label449;
              if (paramBundle == null) {
                break label449;
              }
              ((ViewGroup)paramContext).removeView(paramBundle);
              break label449;
              if (!TextUtils.isEmpty(paramView))
              {
                paramContext = a(paramView.trim(), null, false);
                paramView = new ViewGroup.LayoutParams(-1, -2);
                paramContext.setGravity(16);
                ((LinearLayout)localObject1).addView(paramContext, 0, paramView);
              }
            }
            ((LinearLayout)localObject1).removeAllViews();
            if (localObject1 == null)
            {
              localObject1 = new LinearLayout(paramContext);
              ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
              ((LinearLayout)localObject1).setOrientation(1);
            }
            for (;;)
            {
              i = 0;
              j = 0;
              paramContext = null;
              paramView = null;
              if (j < this.jdField_a_of_type_Azqk.a.size())
              {
                localObject2 = (azqj)this.jdField_a_of_type_Azqk.a.get(j);
                localObject3 = ((azqj)localObject2).a;
                if ("title".equals(localObject3))
                {
                  localObject2 = ((StructMsgItemTitle)localObject2).b();
                  paramView = paramContext;
                  paramContext = (Context)localObject2;
                }
                for (;;)
                {
                  j += 1;
                  localObject2 = paramContext;
                  paramContext = paramView;
                  paramView = (View)localObject2;
                  break;
                  if ("picture".equals(localObject3))
                  {
                    localObject2 = a((azqj)localObject2, null, paramBundle);
                    ((LinearLayout)localObject1).addView((View)localObject2);
                    i = 1;
                    paramContext = paramView;
                    paramView = (View)localObject2;
                  }
                  else
                  {
                    if ("summary".equals(localObject3))
                    {
                      localObject2 = (azvd)localObject2;
                      if ((i != 0) && (!TextUtils.isEmpty(((azvd)localObject2).b())))
                      {
                        if (((azvd)localObject2).b().trim().length() <= 0)
                        {
                          localObject2 = paramContext;
                          paramContext = paramView;
                          paramView = (View)localObject2;
                          continue;
                        }
                        localObject2 = a((azvd)localObject2, null);
                        ((TextView)localObject2).setId(2131377185 + j);
                        ((LinearLayout)localObject1).addView((View)localObject2);
                      }
                    }
                    localObject2 = paramContext;
                    paramContext = paramView;
                    paramView = (View)localObject2;
                  }
                }
              }
              if ((paramContext != null) && (!TextUtils.isEmpty(paramView)))
              {
                paramBundle = new ViewGroup.LayoutParams(-1, this.b);
                paramView = a(paramView.trim(), null, true);
                paramView.setId(2131377183);
                ((ViewGroup)paramContext).addView(paramView, paramBundle);
              }
              for (;;)
              {
                return localObject1;
                if ((!TextUtils.isEmpty(paramView)) && (paramView.trim().length() > 0))
                {
                  paramContext = a(paramView.trim(), null, false);
                  paramView = new LinearLayout.LayoutParams(-1, -2);
                  paramContext.setGravity(16);
                  ((LinearLayout)localObject1).addView(paramContext, 0, paramView);
                }
              }
            }
          }
        }
        localObject2 = paramContext;
        m = i;
        i = j;
        j = m;
        paramContext = paramView;
        paramView = (View)localObject2;
      }
    }
  }
  
  public View a(azqj paramazqj, View paramView, Bundle paramBundle)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if ((paramView != null) && ((paramView instanceof FrameLayout)))
    {
      paramView = (FrameLayout)paramView;
      paramazqj.a(this.jdField_a_of_type_AndroidContentContext, paramView.findViewById(2131368083), paramBundle);
      return paramView;
    }
    paramView = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    paramView.setId(2131377170);
    if (paramBundle != null) {
      paramBundle.putBoolean("pa_should_change", true);
    }
    paramazqj = (ImageView)paramazqj.a(this.jdField_a_of_type_AndroidContentContext, null, paramBundle).findViewById(2131368083);
    paramBundle = new FrameLayout.LayoutParams(-1, this.b);
    if ((paramazqj != null) && ((paramazqj instanceof PAImageView))) {
      ((PAImageView)paramazqj).setUseRadiusRound(true, localResources.getDimensionPixelSize(2131296357));
    }
    paramView.addView(paramazqj, paramBundle);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azud
 * JD-Core Version:    0.7.0.1
 */