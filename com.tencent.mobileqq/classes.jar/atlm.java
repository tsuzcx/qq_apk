import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class atlm
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public LinearLayout a;
  public atky a;
  public atlg a;
  public QQAppInterface a;
  private List<aozs> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public atlm(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844938);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
    paramContext = paramContext.getResources();
    this.f = 3;
    this.jdField_b_of_type_Int = aepi.a(1.0F, paramContext);
    this.c = this.jdField_b_of_type_Int;
    this.e = bdoo.b(16.0F);
    this.d = aepi.a(114.0F, paramContext);
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    int k = 0;
    int j = k;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        j = k;
      }
    }
    else {
      return j;
    }
    int m = this.jdField_a_of_type_JavaUtilList.size();
    if (paramInt == 0) {
      i = 1;
    }
    j = i;
    if (paramInt == m - 1) {
      j = i | 0x4;
    }
    if (this.f > m) {}
    for (k = m - 1;; k = this.f - 1)
    {
      i = j;
      if (paramInt == k) {
        i = j | 0x2;
      }
      j = m % this.f;
      k = j;
      if (j == 0) {
        k = 3;
      }
      j = i;
      if (paramInt != m - k) {
        break;
      }
      return i | 0x8;
    }
  }
  
  private int a(LinearLayout paramLinearLayout)
  {
    int i = 0;
    int k = 0;
    int m = paramLinearLayout.getChildCount();
    if (m == 0) {}
    int j;
    do
    {
      return k;
      j = 0;
      k = i;
    } while (j >= m);
    View localView = paramLinearLayout.getChildAt(j);
    if ((localView != null) && ((localView instanceof LinearLayout))) {
      i = ((LinearLayout)localView).getChildCount() + i;
    }
    for (;;)
    {
      j += 1;
      break;
    }
  }
  
  private View a(LinearLayout paramLinearLayout, int paramInt)
  {
    try
    {
      paramLinearLayout = (LinearLayout)paramLinearLayout.getChildAt(paramInt / this.f);
      if (paramLinearLayout == null)
      {
        QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("lineLayout == null  ", new Object[] { Integer.valueOf(paramInt) }));
        return null;
      }
      paramLinearLayout = paramLinearLayout.getChildAt(paramInt % this.f);
      return paramLinearLayout;
    }
    catch (Exception paramLinearLayout)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("findViewByIndex,index = ", new Object[] { Integer.valueOf(paramInt) }), paramLinearLayout);
    }
    return null;
  }
  
  private aozs a(View paramView)
  {
    int i = paramView.getId();
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size())) {
      return (aozs)this.jdField_a_of_type_JavaUtilList.get(i);
    }
    return null;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString, View paramView, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    if (paramView == null) {
      paramStringBuilder1.append(",headView == null");
    }
    int i;
    int j;
    do
    {
      return;
      paramView = paramView.findViewById(2131374634);
      if (paramView == null)
      {
        paramStringBuilder1.append(",qZone == null");
        return;
      }
      i = paramView.getTop();
      j = paramView.getHeight() + i;
      paramStringBuilder1.append(",qZoneTop = ").append(i).append(",qZoneBottom = ").append(j);
    } while (((paramFloat1 >= i) || (i >= paramFloat2)) && ((paramFloat1 >= j) || (j >= paramFloat2)));
    paramStringBuilder2.append(10000L).append("_").append(0).append("_").append(paramInt1).append("_").append(0).append("_").append(atlk.a(paramInt2)).append("_").append(paramString).append(";");
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean, String paramString, View paramView, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    if (paramView == null) {
      paramStringBuilder1.append(",headView == null");
    }
    int i;
    int j;
    do
    {
      return;
      paramView = paramView.findViewById(2131373640);
      if (paramView == null)
      {
        paramStringBuilder1.append(",qcircle == null");
        return;
      }
      if (!paramBoolean)
      {
        paramStringBuilder1.append(",no ShowQQCirle");
        return;
      }
      i = paramView.getTop();
      j = paramView.getHeight() + i;
      paramStringBuilder1.append(",qCircleTop = ").append(i).append(",qCircleBottom = ").append(j);
    } while (((paramFloat1 >= i) || (i >= paramFloat2)) && ((paramFloat1 >= j) || (j >= paramFloat2)));
    paramStringBuilder2.append(10004L).append("_").append(0).append("_").append(paramInt).append("_").append(0).append("_").append(0).append("_").append(paramString).append(";");
  }
  
  private void a(float paramFloat1, float paramFloat2, String paramString, View paramView, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    paramView = paramView.findViewById(2131377399);
    if (paramView == null)
    {
      paramStringBuilder1.append(",tableRoot == null");
      return;
    }
    int n = paramView.getTop();
    int i1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    paramStringBuilder1.append(", r_top = ").append(n).append(", r_count = ").append(i1);
    int i = 0;
    label65:
    if (i < i1)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if (paramView != null) {
        break label97;
      }
    }
    label97:
    int j;
    int k;
    label223:
    Object localObject;
    for (;;)
    {
      i += 1;
      break label65;
      break;
      if ((paramView instanceof LinearLayout))
      {
        j = paramView.getTop() + n;
        k = paramView.getHeight() + j;
        paramStringBuilder1.append(",").append(i).append(" v_top ").append(j).append(" v_bottom ").append(k);
        if (((paramFloat1 < j) && (j < paramFloat2)) || ((paramFloat1 < k) && (k < paramFloat2))) {}
        for (j = 1; (j != 0) && ((paramView instanceof LinearLayout)); j = 0)
        {
          paramView = (LinearLayout)paramView;
          int i2 = paramView.getChildCount();
          j = 0;
          if (j >= i2) {
            break label449;
          }
          localObject = paramView.getChildAt(j);
          if (localObject != null) {
            break label259;
          }
          paramStringBuilder1.append("itemView == null ");
          return;
        }
      }
    }
    label259:
    aozs localaozs = a((View)localObject);
    if ((localaozs == null) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      paramStringBuilder1.append(" item == null ||  item.info == null ");
      return;
    }
    paramStringBuilder1.append(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId).append(",");
    long l = localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
    int i3 = ((View)localObject).getId();
    int m;
    if (this.jdField_a_of_type_Atlg != null)
    {
      localObject = (atlj)this.jdField_a_of_type_Atlg.a().get(Long.valueOf(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
      if (localObject != null)
      {
        m = ((atlj)localObject).jdField_a_of_type_Int;
        k = ((atlj)localObject).jdField_b_of_type_Int;
      }
    }
    for (;;)
    {
      paramStringBuilder2.append(l).append("_").append(i3 + 1).append("_").append(m).append("_").append(k).append("_").append(0).append("_").append(paramString).append(";");
      j += 1;
      break label223;
      label449:
      break;
      k = 0;
      m = 0;
    }
  }
  
  private void a(int paramInt, LinearLayout paramLinearLayout)
  {
    for (;;)
    {
      try
      {
        int i = (paramInt + 1) % this.f;
        if (i != 0) {
          break label265;
        }
        i = this.f;
        j = paramInt / this.f;
        LinearLayout localLinearLayout = (LinearLayout)paramLinearLayout.getChildAt(j);
        if (localLinearLayout != null) {
          break label262;
        }
        localLinearLayout = new LinearLayout(paramLinearLayout.getContext());
        localLinearLayout.setWeightSum(this.f);
        Object localObject = new LinearLayout.LayoutParams(-1, this.d);
        if (j <= 0) {
          break label268;
        }
        j = this.c;
        ((LinearLayout.LayoutParams)localObject).setMargins(0, j, 0, 0);
        paramLinearLayout.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
        localObject = new atln(paramLinearLayout.getContext(), this.jdField_a_of_type_AndroidViewLayoutInflater);
        paramLinearLayout = ((atln)localObject).jdField_a_of_type_AndroidViewView;
        paramLinearLayout.setTag(localObject);
        paramLinearLayout.setId(paramInt);
        localObject = ((atln)localObject).jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaRoundLayout;
        if (localObject != null)
        {
          ((LebaRoundLayout)localObject).jdField_a_of_type_Int = this.e;
          ((LebaRoundLayout)localObject).jdField_b_of_type_Int = a(paramInt);
          localObject = new LinearLayout.LayoutParams(0, this.d, 1.0F);
          if (i > 1)
          {
            i = this.jdField_b_of_type_Int;
            ((LinearLayout.LayoutParams)localObject).setMargins(i, 0, 0, 0);
            localLinearLayout.addView(paramLinearLayout, (ViewGroup.LayoutParams)localObject);
          }
        }
        else
        {
          QLog.i("Q.lebatab.LebaTableLogic", 1, "rootLayout != null");
          continue;
        }
        i = 0;
      }
      catch (Exception paramLinearLayout)
      {
        QLog.i("Q.lebatab.LebaTableLogic", 1, "addTableItem,index = " + paramInt, paramLinearLayout);
        return;
      }
      continue;
      label262:
      continue;
      label265:
      continue;
      label268:
      int j = 0;
    }
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    int i = a(paramLinearLayout);
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if (i != j)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      localStringBuilder.append("removeAllViews");
      i = 0;
      while (i < j)
      {
        a(i, paramLinearLayout);
        localStringBuilder.append(" ").append(i);
        i += 1;
      }
      QLog.i("Q.lebatab.LebaTableLogic", 1, localStringBuilder.toString());
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "notifyDataSetChanged mRootLayout == null");
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      a();
      return;
    }
    a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  private void b(LinearLayout paramLinearLayout)
  {
    Object localObject1 = ThemeUtil.getCurrentThemeId();
    boolean bool1;
    boolean bool2;
    int i;
    label100:
    Object localObject2;
    if (("1000".equals(localObject1)) || ("2105".equals(localObject1)) || ("1103".equals(localObject1)) || ("2101".equals(localObject1)))
    {
      bool1 = true;
      bool2 = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("bindDataToTable themeId %s isNeedWaterMark %b isNight = %b", new Object[] { localObject1, Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      localObject1 = (aozs)this.jdField_a_of_type_JavaUtilList.get(i);
      localObject2 = a(paramLinearLayout, i);
      if (localObject2 != null) {
        break label176;
      }
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("itemView == null %d", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      i += 1;
      break label100;
      bool1 = false;
      break;
      label176:
      if (((View)localObject2).getTag() == null)
      {
        QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("itemView.getTag() == null %d", new Object[] { Integer.valueOf(i) }));
      }
      else
      {
        localObject2 = (atln)((View)localObject2).getTag();
        atlo localatlo = new atlo();
        localatlo.jdField_a_of_type_Aozs = ((aozs)localObject1);
        localatlo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localatlo.jdField_a_of_type_AndroidContentContext = paramLinearLayout.getContext();
        localatlo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localatlo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localatlo.jdField_a_of_type_AndroidViewView$OnClickListener = this;
        localatlo.jdField_a_of_type_Atlg = this.jdField_a_of_type_Atlg;
        localatlo.jdField_a_of_type_Boolean = bool2;
        localatlo.jdField_b_of_type_Int = i;
        localatlo.jdField_b_of_type_Boolean = bool1;
        ((atln)localObject2).a(localatlo);
      }
    }
  }
  
  private void b(List<aozs> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    while (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aozs localaozs = (aozs)paramList.next();
        if ((localaozs != null) && (TextUtils.isEmpty(localaozs.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaUtilList.add(localaozs);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      int j = this.jdField_a_of_type_JavaUtilList.size() % this.f;
      if ((j > 0) && (j < this.f))
      {
        int i = 0;
        while (i < this.f - j)
        {
          this.jdField_a_of_type_JavaUtilList.add(new aozs());
          i += 1;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, View paramView1, View paramView2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (paramView1 == null))
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "statExposure mRootLayout == null || lvView == null");
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    String str = ThemeUtil.getCurrentThemeId();
    paramFloat2 += paramView1.getHeight() - paramView1.getPaddingBottom() - paramView1.getPaddingTop();
    localStringBuilder1.append("reportExposure, e_top = ").append(paramFloat1).append(", e_bottom = ").append(paramFloat2);
    a(paramFloat1, paramFloat2, paramInt1, paramInt2, str, paramView2, localStringBuilder1, localStringBuilder2);
    a(paramFloat1, paramFloat2, paramInt3, paramBoolean, str, paramView2, localStringBuilder1, localStringBuilder2);
    a(paramFloat1, paramFloat2, str, paramView2, localStringBuilder1, localStringBuilder2);
    paramView1 = atlk.a("plugin_exp");
    paramView1.jdField_a_of_type_JavaLangString = localStringBuilder2.toString();
    azpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView1);
    QLog.i("Q.lebatab.LebaTableLogic", 1, localStringBuilder2);
  }
  
  public void a(List<aozs> paramList)
  {
    b(paramList);
    b();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      aozs localaozs = a(paramView);
      if ((localaozs != null) && (this.jdField_a_of_type_Atky != null))
      {
        atli localatli = new atli();
        localatli.jdField_a_of_type_Boolean = true;
        localatli.jdField_a_of_type_Long = localaozs.jdField_a_of_type_Long;
        localatli.jdField_a_of_type_Int = (paramView.getId() + 1);
        if ((paramView instanceof RedTouch))
        {
          localatli.jdField_b_of_type_Int = atlk.a((RedTouch)paramView);
          localatli.c = atlk.b((RedTouch)paramView);
        }
        this.jdField_a_of_type_Atky.a(paramView, localaozs, localatli);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atlm
 * JD-Core Version:    0.7.0.1
 */