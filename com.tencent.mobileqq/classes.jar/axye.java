import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.TitledImageView;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class axye
  extends axuo
{
  public boolean a;
  
  private RelativeLayout a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Resources localResources = paramContext.getResources();
    TextViewWrapLayout localTextViewWrapLayout = new TextViewWrapLayout(paramContext);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    int i = actn.a(15.0F, localResources);
    localTextViewWrapLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localTextViewWrapLayout.setPadding(0, i, 0, i);
    AnyScaleTypeImageView localAnyScaleTypeImageView = new AnyScaleTypeImageView(paramContext);
    localAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject2 = null;
    try
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = actn.a(70.0F, localResources);
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = actn.a(70.0F, localResources);
      localObject1 = URLDrawable.getDrawable(paramString1, (URLDrawable.URLDrawableOptions)localObject1);
      localAnyScaleTypeImageView.setId(2131367776);
      localAnyScaleTypeImageView.setImageDrawable((Drawable)localObject1);
      paramString1 = new RelativeLayout.LayoutParams(actn.a(70.0F, localResources), actn.a(70.0F, localResources));
      paramString1.addRule(9);
      paramString1.addRule(10);
      localTextViewWrapLayout.addView(localAnyScaleTypeImageView, paramString1);
      i = actn.a(10.0F, localResources);
      paramString1 = new TextView(paramContext);
      paramString1.setId(2131378378);
      paramString1.setText(paramString2);
      paramString1.setTextSize(14.0F);
      paramString1.setTextColor(-8355712);
      paramString1.setTypeface(Typeface.DEFAULT);
      paramString1.setMaxLines(2);
      paramString1.setEllipsize(TextUtils.TruncateAt.END);
      paramString2 = new RelativeLayout.LayoutParams(-1, -2);
      paramString2.topMargin = 0;
      paramString2.leftMargin = i;
      paramString2.addRule(10);
      paramString2.addRule(1, localAnyScaleTypeImageView.getId());
      paramString2.addRule(11);
      paramContext = new TextView(paramContext);
      paramContext.setId(2131378362);
      paramContext.setText(paramString3);
      paramContext.setTextSize(14.0F);
      paramContext.setTextColor(-8355712);
      paramContext.setTypeface(Typeface.DEFAULT);
      paramContext.setMaxLines(2);
      paramContext.setEllipsize(TextUtils.TruncateAt.END);
      paramString3 = new RelativeLayout.LayoutParams(-1, -2);
      paramString3.topMargin = 0;
      paramString3.leftMargin = i;
      paramString3.addRule(3, paramString1.getId());
      paramString3.addRule(1, localAnyScaleTypeImageView.getId());
      localTextViewWrapLayout.addView(paramString1, paramString2);
      localTextViewWrapLayout.addView(paramContext, paramString3);
      localTextViewWrapLayout.a(true);
      return localTextViewWrapLayout;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.e("StructMsgItemLayout5", 2, "getPAVideoPreDialogView():  getDrawable Exception, imgUrl=" + paramString1, localException);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  @TargetApi(16)
  private RelativeLayout a(Context paramContext, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new RelativeLayout(paramContext);
    a(paramContext);
    d(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int j;
    int k;
    label63:
    int m;
    label80:
    int i;
    if (paramBoolean)
    {
      j = localResources.getDimensionPixelSize(2131296349);
      if (!paramBoolean) {
        break label135;
      }
      k = localResources.getDimensionPixelSize(2131296350);
      if (!a(1)) {
        break label147;
      }
      m = actn.a(15.0F, localResources);
      i = actn.a(6.0F, localResources);
      if (!a(2)) {
        break label159;
      }
      i = actn.a(15.0F, localResources);
    }
    for (;;)
    {
      paramContext.setPadding(j, m, k, i);
      paramContext.setLayoutParams(localLayoutParams);
      return paramContext;
      j = localResources.getDimensionPixelSize(2131298789);
      break;
      label135:
      k = localResources.getDimensionPixelSize(2131298790);
      break label63;
      label147:
      m = actn.a(6.0F, localResources);
      break label80;
      label159:
      if (a(1)) {
        i = actn.a(15.0F, localResources);
      }
    }
  }
  
  protected int b()
  {
    return 5;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject3 = paramBundle;
    if (paramBundle == null) {
      localObject3 = new Bundle();
    }
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject5;
    Object localObject4;
    if (((Bundle)localObject3).getBoolean("pre_dialog") == true)
    {
      paramBundle = null;
      localObject2 = null;
      localObject1 = null;
      i = 0;
      localObject5 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (((Iterator)localObject5).hasNext())
      {
        localObject4 = (axun)((Iterator)localObject5).next();
        if ((localObject4 instanceof axzq))
        {
          localObject4 = (axzq)localObject4;
          if (!((axzq)localObject4).a()) {
            break label164;
          }
          localObject2 = ((axzq)localObject4).S;
          localObject4 = ((axzq)localObject4).W;
          paramBundle = (Bundle)localObject1;
          localObject1 = localObject4;
          i = 1;
        }
      }
    }
    for (;;)
    {
      localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = paramBundle;
      paramBundle = (Bundle)localObject4;
      break;
      if ((localObject4 instanceof StructMsgItemTitle))
      {
        localObject4 = ((StructMsgItemTitle)localObject4).b();
        localObject1 = localObject2;
        localObject2 = paramBundle;
        paramBundle = (Bundle)localObject4;
        continue;
        label164:
        if (i != 0) {
          return a(paramContext, paramBundle, (String)localObject1, (String)localObject2);
        }
        localObject5 = paramContext.getResources();
        boolean bool;
        label220:
        int j;
        int m;
        label268:
        String str;
        label401:
        int n;
        int k;
        if (((Bundle)localObject3).getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA)
        {
          bool = true;
          if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
            break label542;
          }
          localObject2 = (RelativeLayout)paramView;
          ((RelativeLayout)localObject2).removeAllViews();
          localObject1 = null;
          paramView = null;
          paramBundle = "";
          i = -1;
          j = 0;
          m = (int)(TypedValue.applyDimension(1, 175.0F, ((Resources)localObject5).getDisplayMetrics()) + 0.5F);
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!localIterator.hasNext()) {
            break label909;
          }
          localObject4 = (axun)localIterator.next();
          ((axun)localObject4).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          str = ((axun)localObject4).jdField_a_of_type_JavaLangString;
          if (!"title".equals(str)) {
            break label562;
          }
          localObject4 = (StructMsgItemTitle)localObject4;
          if (TextUtils.isEmpty(((StructMsgItemTitle)localObject4).b())) {
            break label1263;
          }
          paramView = new TextView(paramContext);
          paramView.setText(((StructMsgItemTitle)localObject4).b());
          paramBundle = ((StructMsgItemTitle)localObject4).b();
          paramView.setId(2131378378);
          paramView.setTag(localObject4);
          paramView.setGravity(3);
          paramView.setGravity(16);
          if (((Bundle)localObject3).getInt("accostType") != AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
            break label554;
          }
          paramView.setMaxLines(2);
          paramView.setEllipsize(TextUtils.TruncateAt.END);
          paramView.setTextColor(-1);
          paramView.setTextSize(2, 18.0F);
          paramView.setBackgroundColor(paramContext.getResources().getColor(2131165226));
          n = actn.a(10.0F, (Resources)localObject5);
          int i1 = actn.a(4.0F, (Resources)localObject5);
          int i2 = actn.a(5.0F, (Resources)localObject5);
          if (!((Bundle)localObject3).getBoolean("pre_dialog", false)) {
            break label1256;
          }
          k = n * 2;
          label481:
          paramView.setPadding(k, i1, n, i2);
        }
        label542:
        label554:
        label562:
        label707:
        label710:
        label859:
        label1256:
        label1263:
        for (;;)
        {
          localObject4 = paramBundle;
          k = j;
          paramBundle = paramView;
          paramView = (View)localObject4;
          j = i;
          i = k;
          for (;;)
          {
            localObject4 = paramBundle;
            k = j;
            j = i;
            i = k;
            paramBundle = paramView;
            paramView = (View)localObject4;
            break label268;
            bool = false;
            break;
            localObject2 = a(paramContext, bool);
            break label220;
            paramView.setMaxLines(1);
            break label401;
            if ("picture".equals(str))
            {
              localObject1 = ((axun)localObject4).a(paramContext, null, (Bundle)localObject3);
              localObject4 = ((View)localObject1).findViewById(2131367947);
              if ((localObject4 != null) && ((localObject4 instanceof AnyScaleTypeImageView))) {
                ((AnyScaleTypeImageView)localObject4).setTag(2131372109, Integer.valueOf(1));
              }
              k = i;
              localObject4 = paramView;
              i = j;
              j = k;
              paramView = paramBundle;
              paramBundle = (Bundle)localObject4;
            }
            else
            {
              if ("video".equals(str))
              {
                if ((localObject4 instanceof axzq))
                {
                  localObject1 = (axzq)localObject4;
                  if (this.jdField_a_of_type_Boolean) {
                    ((axzq)localObject1).c = false;
                  }
                  if (((axzq)localObject1).a()) {
                    if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.hasFlag(4))
                    {
                      j = -2;
                      k = 0;
                      i = j;
                      if (k < this.jdField_a_of_type_JavaUtilArrayList.size())
                      {
                        localObject1 = (axun)this.jdField_a_of_type_JavaUtilArrayList.get(k);
                        if (!"title".equals(((axun)localObject1).jdField_a_of_type_JavaLangString)) {
                          break label859;
                        }
                        ((Bundle)localObject3).putString("public_account_video_title", ((StructMsgItemTitle)localObject1).b());
                        i = j;
                      }
                    }
                  }
                }
                for (;;)
                {
                  ((RelativeLayout)localObject2).setPadding(0, 0, 0, 0);
                  ((RelativeLayout)localObject2).getLayoutParams().width = i;
                  if (((Bundle)localObject3).getBoolean("pre_dialog", false)) {
                    ((LinearLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams()).gravity = 1;
                  }
                  localObject4 = ((axun)localObject4).a(paramContext, null, (Bundle)localObject3);
                  k = 1;
                  localObject1 = paramView;
                  j = i;
                  paramView = paramBundle;
                  i = k;
                  paramBundle = (Bundle)localObject1;
                  localObject1 = localObject4;
                  break;
                  j = -1;
                  break label707;
                  k += 1;
                  break label710;
                  i = -2;
                  ((Bundle)localObject3).putBoolean("v_crap_ctn", true);
                  ((Bundle)localObject3).putBoolean("has_cnr", true);
                  ((Bundle)localObject3).putInt("v_height", m);
                  continue;
                  i = -1;
                }
                if (localObject1 != null)
                {
                  if (j != 0) {
                    break label1226;
                  }
                  if (!bool) {
                    break label1199;
                  }
                  i = ((Resources)localObject5).getDimensionPixelSize(2131296349);
                  k = BaseChatItemLayout.A;
                  if (((Bundle)localObject3).getBoolean("hasHeadIcon", true)) {
                    break label1214;
                  }
                  i = BaseChatItemLayout.A - i * 2;
                }
                for (k = (int)(i / 1.8F);; k = m)
                {
                  localObject3 = new RelativeLayout.LayoutParams(i, k);
                  if (j != 0) {
                    localObject3 = new RelativeLayout.LayoutParams(i, -2);
                  }
                  for (;;)
                  {
                    ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
                    if ((j != 0) && (!TextUtils.isEmpty(paramBundle)) && ((localObject1 instanceof TitledImageView)))
                    {
                      localObject3 = (TitledImageView)localObject1;
                      ((TitledImageView)localObject3).setTitle(paramBundle);
                      ((TitledImageView)localObject3).setTextColor(-1);
                      ((TitledImageView)localObject3).setTextSize(actn.a(2, 18, (Resources)localObject5));
                      ((TitledImageView)localObject3).setTextBackground(paramContext.getResources().getColor(2131165226));
                      ((TitledImageView)localObject3).setTextPadding(actn.a(10.0F, (Resources)localObject5));
                      ((TitledImageView)localObject3).settextBgRadius(actn.a(12.0F, (Resources)localObject5));
                    }
                    if ((j != 0) && (!TextUtils.isEmpty(paramBundle)))
                    {
                      paramContext = ((View)localObject1).getTag(2131376577);
                      if ((paramContext != null) && ((paramContext instanceof axzx))) {
                        ((axzx)paramContext).a.setText(paramBundle);
                      }
                    }
                    if ((j == 0) && (paramView != null))
                    {
                      paramContext = new RelativeLayout.LayoutParams(-1, -2);
                      if (localObject1 != null) {
                        paramContext.addRule(8, ((View)localObject1).getId());
                      }
                      ((RelativeLayout)localObject2).addView(paramView, paramContext);
                    }
                    ((RelativeLayout)localObject2).setId(2131376574);
                    return localObject2;
                    i = ((Resources)localObject5).getDimensionPixelSize(2131298789);
                    break;
                  }
                  i = k - i * 2;
                  break label960;
                }
              }
              k = i;
              localObject4 = paramView;
              i = j;
              j = k;
              paramView = paramBundle;
              paramBundle = (Bundle)localObject4;
            }
          }
          k = n;
          break label481;
        }
      }
      else
      {
        label909:
        label960:
        label1226:
        localObject4 = paramBundle;
        label1199:
        label1214:
        paramBundle = (Bundle)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
    }
  }
  
  public String b()
  {
    return "Layout5";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axye
 * JD-Core Version:    0.7.0.1
 */