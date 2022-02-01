import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class bexs
  extends bexn
  implements View.OnClickListener, bexj
{
  protected beyd a;
  
  public bexs(Context paramContext, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, TroopAppShortcutContainer paramTroopAppShortcutContainer, Bundle paramBundle)
  {
    super(paramContext, paramQQAppInterface, paramFragmentActivity, paramTroopAppShortcutContainer, paramBundle);
    this.jdField_a_of_type_Beyd = new beyd();
  }
  
  private String a(int paramInt)
  {
    if (paramInt > 100000000) {
      return String.valueOf(paramInt / 100000000) + "亿";
    }
    if (paramInt > 10000) {
      return String.valueOf(paramInt / 10000) + "万";
    }
    return String.valueOf(paramInt);
  }
  
  private void a(View paramView)
  {
    bfaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Beyd.jdField_b_of_type_Long, this.jdField_a_of_type_Beyd.c, 1, 0);
    bcef.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBD", "0X800AFBD", 0, 0, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(this.jdField_a_of_type_Beyd.jdField_b_of_type_Long), "", this.jdField_a_of_type_Beyd.jdField_e_of_type_JavaLangString);
  }
  
  private void a(bext parambext)
  {
    if (this.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_Beyd.jdField_a_of_type_Boolean)
      {
        parambext.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        parambext.jdField_a_of_type_AndroidWidgetButton.setTextColor(-5196865);
      }
    }
    for (;;)
    {
      parambext.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      parambext.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      parambext.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      parambext.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      parambext.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698751));
      parambext.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16578534);
      if (this.jdField_a_of_type_Boolean)
      {
        parambext.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#ffffff"));
        continue;
        parambext.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        parambext.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698760));
        parambext.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16578534);
        if (this.jdField_a_of_type_Boolean) {
          parambext.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#ffffff"));
        }
      }
    }
  }
  
  private void b(View paramView)
  {
    bcef.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBE", "0X800AFBE", 0, 0, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(this.jdField_a_of_type_Beyd.jdField_b_of_type_Long), "", this.jdField_a_of_type_Beyd.jdField_e_of_type_JavaLangString);
    if (!bfaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131698757), 0).a();
    }
    do
    {
      return;
      new bexh(this, String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_Beyd.jdField_b_of_type_Long, this.jdField_a_of_type_Beyd.jdField_a_of_type_Long, false, this.jdField_a_of_type_Beyd).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (!QLog.isColorLevel());
    QLog.d("AppsRecommendViewBuilder", 2, "onClickAdd mTroopUin:" + this.jdField_a_of_type_Long + " append_appid:" + this.jdField_a_of_type_Beyd.jdField_b_of_type_Long);
  }
  
  private void b(bext parambext)
  {
    int i = 1;
    int j = this.jdField_a_of_type_Beyd.jdField_b_of_type_JavaUtilList.size();
    if ((this.jdField_a_of_type_Beyd.f > 0) || (this.jdField_a_of_type_Beyd.g > 0) || (this.jdField_a_of_type_Beyd.h > 0)) {
      if (j > 1)
      {
        if (i <= 0) {
          break label209;
        }
        j = 0;
        label56:
        if (j >= parambext.jdField_b_of_type_JavaUtilList.size()) {
          return;
        }
        if (j < i) {
          break label116;
        }
        ((TextView)parambext.jdField_b_of_type_JavaUtilList.get(j)).setVisibility(8);
      }
    }
    for (;;)
    {
      j += 1;
      break label56;
      i = j;
      break;
      i = j;
      if (j > 2) {
        i = 2;
      }
      break;
      label116:
      ((TextView)parambext.jdField_b_of_type_JavaUtilList.get(j)).setText((CharSequence)this.jdField_a_of_type_Beyd.jdField_b_of_type_JavaUtilList.get(j));
      ((TextView)parambext.jdField_b_of_type_JavaUtilList.get(j)).setVisibility(0);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(34.0F);
      localGradientDrawable.setColor(-1315339);
      ((TextView)parambext.jdField_b_of_type_JavaUtilList.get(j)).setBackgroundDrawable(localGradientDrawable);
    }
    label209:
    parambext.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void c(bext parambext)
  {
    GradientDrawable localGradientDrawable;
    if (this.jdField_a_of_type_Beyd.f > 0)
    {
      parambext.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      parambext.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698761).replace("$COUNT", a(this.jdField_a_of_type_Beyd.f)), new Object[0]));
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(34.0F);
      localGradientDrawable.setColor(-1315339);
      parambext.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
      return;
    }
    if (this.jdField_a_of_type_Beyd.g > 0)
    {
      parambext.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      parambext.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698752).replace("$COUNT", a(this.jdField_a_of_type_Beyd.g)), new Object[0]));
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(34.0F);
      localGradientDrawable.setColor(-1315339);
      parambext.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
      return;
    }
    if (this.jdField_a_of_type_Beyd.h > 0)
    {
      parambext.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      parambext.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698762).replace("$COUNT", a(this.jdField_a_of_type_Beyd.h)), new Object[0]));
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(34.0F);
      localGradientDrawable.setColor(-1315339);
      parambext.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
      return;
    }
    parambext.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void d(bext parambext)
  {
    int j = this.jdField_a_of_type_Beyd.jdField_a_of_type_JavaUtilList.size();
    Object localObject = (RelativeLayout.LayoutParams)parambext.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    if (j > 0)
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(-21.0F, parambext.jdField_b_of_type_AndroidWidgetTextView.getResources());
      parambext.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      parambext.jdField_b_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(19.0F, parambext.jdField_b_of_type_AndroidWidgetTextView.getResources()), 0, AIOUtils.dp2px(7.0F, parambext.jdField_b_of_type_AndroidWidgetTextView.getResources()), 0);
      parambext.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      int i = 0;
      if (i < parambext.jdField_a_of_type_JavaUtilList.size())
      {
        if (i >= j) {
          ((ImageView)parambext.jdField_a_of_type_JavaUtilList.get(i)).setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = (String)this.jdField_a_of_type_Beyd.jdField_a_of_type_JavaUtilList.get(i);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
          {
            Drawable localDrawable = bfvo.a(true);
            localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject, 4, localDrawable, localDrawable);
            localDrawable = ((ImageView)parambext.jdField_a_of_type_JavaUtilList.get(i)).getDrawable();
            if ((localDrawable != null) && (localDrawable != localObject) && ((localDrawable instanceof FaceDrawable))) {
              ((FaceDrawable)localDrawable).cancel();
            }
            ((ImageView)parambext.jdField_a_of_type_JavaUtilList.get(i)).setImageDrawable((Drawable)localObject);
            ((ImageView)parambext.jdField_a_of_type_JavaUtilList.get(i)).setVisibility(0);
          }
          else
          {
            localObject = bfvo.a(true);
            ((ImageView)parambext.jdField_a_of_type_JavaUtilList.get(i)).setImageDrawable((Drawable)localObject);
            ((ImageView)parambext.jdField_a_of_type_JavaUtilList.get(i)).setVisibility(0);
          }
        }
      }
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(0.0F, parambext.jdField_b_of_type_AndroidWidgetTextView.getResources());
      parambext.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      parambext.jdField_b_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(7.0F, parambext.jdField_b_of_type_AndroidWidgetTextView.getResources()), 0, AIOUtils.dp2px(7.0F, parambext.jdField_b_of_type_AndroidWidgetTextView.getResources()), 0);
      parambext.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool;
    if (paramView == null)
    {
      paramView = new bext();
      Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559862, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131362830));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131362842));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131362845));
      paramView.c = ((TextView)((View)localObject).findViewById(2131362828));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131362821));
      paramView.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131362846));
      paramInt = 0;
      while (paramInt < paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        paramViewGroup = (ImageView)paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(paramInt);
        paramViewGroup.setVisibility(8);
        paramView.jdField_a_of_type_JavaUtilList.add(paramViewGroup);
        paramInt += 1;
      }
      paramView.jdField_b_of_type_JavaUtilList = new ArrayList();
      paramView.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131378211));
      paramInt = 0;
      while (paramInt < paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        paramViewGroup = (TextView)paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildAt(paramInt);
        paramViewGroup.setVisibility(8);
        paramView.jdField_b_of_type_JavaUtilList.add(paramViewGroup);
        paramInt += 1;
      }
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramView.setClickable(true);
      paramView.setOnClickListener(this);
      localObject = this.jdField_a_of_type_AndroidContentContext;
      ImageView localImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      String str = this.jdField_a_of_type_Beyd.jdField_b_of_type_JavaLangString;
      if (this.jdField_a_of_type_Beyd.jdField_e_of_type_Int != 1) {
        break label431;
      }
      bool = true;
      label310:
      bfaf.a((Context)localObject, localImageView, str, 48.0F, bool);
      if (!this.jdField_a_of_type_Boolean) {
        break label437;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      d(paramViewGroup);
      c(paramViewGroup);
      b(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Beyd.jdField_a_of_type_JavaLangString);
      paramViewGroup.c.setText(this.jdField_a_of_type_Beyd.d);
      a(paramViewGroup);
      if (this.jdField_a_of_type_Boolean)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
        paramView.setBackgroundColor(-16777216);
      }
      return paramView;
      paramViewGroup = (bext)paramView.getTag();
      break;
      label431:
      bool = false;
      break label310;
      label437:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_Beyd;
  }
  
  public void a(int paramInt, String paramString, Object paramObject)
  {
    QLog.e("AppsRecommendViewBuilder", 1, new Object[] { "add appid retCode: ", Integer.valueOf(paramInt) });
    if (paramInt == 41005)
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a();
      if (paramInt > 0)
      {
        paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131698759).replace("$COUNT", String.valueOf(paramInt));
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramString, 0).a();
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131698758), 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131698757), 0).a();
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof beyd))) {}
    Object localObject;
    int i;
    do
    {
      do
      {
        do
        {
          return;
          paramObject = (beyd)paramObject;
          localObject = (beyf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
        } while (localObject == null);
        ArrayList localArrayList = ((beyf)localObject).a(this.jdField_a_of_type_Long);
        if ((localArrayList != null) && (!localArrayList.contains(paramObject)))
        {
          localArrayList.add(paramObject);
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.e();
        }
        localObject = ((beyf)localObject).b(this.jdField_a_of_type_Long);
      } while (localObject == null);
      i = ((ArrayList)localObject).indexOf(paramObject);
    } while ((i < 0) || (i >= ((ArrayList)localObject).size()));
    ((beyd)((ArrayList)localObject).get(i)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.f();
  }
  
  public void a_(Object paramObject)
  {
    if ((paramObject instanceof beyd)) {
      this.jdField_a_of_type_Beyd = ((beyd)paramObject);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
      continue;
      if (this.jdField_b_of_type_Boolean) {
        b(paramView);
      } else {
        a(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexs
 * JD-Core Version:    0.7.0.1
 */