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

public class arqi
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public LinearLayout a;
  public arpv a;
  public arqd a;
  public QQAppInterface a;
  private List<anec> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public arqi(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844502);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
    paramContext = paramContext.getResources();
    this.e = 3;
    this.b = actj.a(1.0F, paramContext);
    this.c = this.b;
    this.d = actj.a(114.0F, paramContext);
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
    if (this.e > m) {}
    for (k = m - 1;; k = this.e - 1)
    {
      i = j;
      if (paramInt == k) {
        i = j | 0x2;
      }
      j = m % this.e;
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
      paramLinearLayout = (LinearLayout)paramLinearLayout.getChildAt(paramInt / this.e);
      if (paramLinearLayout == null)
      {
        QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("lineLayout == null  ", new Object[] { Integer.valueOf(paramInt) }));
        return null;
      }
      paramLinearLayout = paramLinearLayout.getChildAt(paramInt % this.e);
      return paramLinearLayout;
    }
    catch (Exception paramLinearLayout)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("findViewByIndex,index = ", new Object[] { Integer.valueOf(paramInt) }), paramLinearLayout);
    }
    return null;
  }
  
  private anec a(View paramView)
  {
    int i = paramView.getId();
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size())) {
      return (anec)this.jdField_a_of_type_JavaUtilList.get(i);
    }
    return null;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt, View paramView, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    if (paramView == null) {
      paramStringBuilder1.append(",headView == null");
    }
    int i;
    int j;
    do
    {
      return;
      paramView = paramView.findViewById(2131374125);
      if (paramView == null)
      {
        paramStringBuilder1.append(",qZone == null");
        return;
      }
      i = paramView.getTop();
      j = paramView.getHeight() + i;
      paramStringBuilder1.append(",qZoneTop = ").append(i).append(",qZoneBottom = ").append(j);
    } while (((paramFloat1 >= i) || (i >= paramFloat2)) && ((paramFloat1 >= j) || (j >= paramFloat2)));
    paramStringBuilder2.append(10000L).append("_").append(0).append("_").append(paramInt).append(";");
  }
  
  private void a(float paramFloat1, float paramFloat2, View paramView, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    paramView = paramView.findViewById(2131369454);
    if (paramView == null)
    {
      paramStringBuilder1.append(",tableRoot == null");
      return;
    }
    int m = paramView.getTop();
    int n = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    paramStringBuilder1.append(", r_top = ").append(m).append(", r_count = ").append(n);
    int i = 0;
    label61:
    if (i < n)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if (paramView != null) {
        break label91;
      }
    }
    label91:
    int j;
    label210:
    Object localObject;
    for (;;)
    {
      i += 1;
      break label61;
      break;
      if ((paramView instanceof LinearLayout))
      {
        j = paramView.getTop() + m;
        k = paramView.getHeight() + j;
        paramStringBuilder1.append(",").append(i).append(" v_top ").append(j).append(" v_bottom ").append(k);
        if (((paramFloat1 < j) && (j < paramFloat2)) || ((paramFloat1 < k) && (k < paramFloat2))) {}
        for (j = 1; (j != 0) && ((paramView instanceof LinearLayout)); j = 0)
        {
          paramView = (LinearLayout)paramView;
          int i1 = paramView.getChildCount();
          j = 0;
          if (j >= i1) {
            break label400;
          }
          localObject = paramView.getChildAt(j);
          if (localObject != null) {
            break label245;
          }
          paramStringBuilder1.append("itemView == null ");
          return;
        }
      }
    }
    label245:
    anec localanec = a((View)localObject);
    if ((localanec == null) || (localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      paramStringBuilder1.append(" item == null ||  item.info == null ");
      return;
    }
    paramStringBuilder1.append(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId).append(",");
    long l = localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
    int i2 = ((View)localObject).getId();
    if (this.jdField_a_of_type_Arqd != null)
    {
      localObject = (Integer)this.jdField_a_of_type_Arqd.a().get(Long.valueOf(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
      if (localObject == null) {}
    }
    for (int k = ((Integer)localObject).intValue();; k = 0)
    {
      paramStringBuilder2.append(l).append("_").append(i2 + 1).append("_").append(k).append(";");
      j += 1;
      break label210;
      label400:
      break;
    }
  }
  
  private void a(int paramInt, LinearLayout paramLinearLayout)
  {
    for (;;)
    {
      try
      {
        int i = (paramInt + 1) % this.e;
        if (i != 0) {
          break label267;
        }
        i = this.e;
        j = paramInt / this.e;
        LinearLayout localLinearLayout = (LinearLayout)paramLinearLayout.getChildAt(j);
        if (localLinearLayout != null) {
          break label264;
        }
        localLinearLayout = new LinearLayout(paramLinearLayout.getContext());
        localLinearLayout.setWeightSum(this.e);
        Object localObject = new LinearLayout.LayoutParams(-1, this.d);
        if (j <= 0) {
          break label270;
        }
        j = this.c;
        ((LinearLayout.LayoutParams)localObject).setMargins(0, j, 0, 0);
        paramLinearLayout.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
        localObject = new arqj(paramLinearLayout.getContext(), this.jdField_a_of_type_AndroidViewLayoutInflater);
        paramLinearLayout = ((arqj)localObject).jdField_a_of_type_AndroidViewView;
        paramLinearLayout.setTag(localObject);
        paramLinearLayout.setId(paramInt);
        localObject = ((arqj)localObject).jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaRoundLayout;
        if (localObject != null)
        {
          ((LebaRoundLayout)localObject).jdField_a_of_type_Int = bbll.b(16.0F);
          ((LebaRoundLayout)localObject).b = a(paramInt);
          localObject = new LinearLayout.LayoutParams(0, this.d, 1.0F);
          if (i > 1)
          {
            i = this.b;
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
      label264:
      continue;
      label267:
      continue;
      label270:
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
    boolean bool = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      anec localanec = (anec)this.jdField_a_of_type_JavaUtilList.get(i);
      Object localObject = a(paramLinearLayout, i);
      if (localObject == null) {
        QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("itemView == null %d", new Object[] { Integer.valueOf(i) }));
      }
      for (;;)
      {
        i += 1;
        break;
        if (((View)localObject).getTag() == null)
        {
          QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("itemView.getTag() == null ", new Object[] { Integer.valueOf(i) }));
        }
        else
        {
          localObject = (arqj)((View)localObject).getTag();
          arqk localarqk = new arqk();
          localarqk.jdField_a_of_type_Anec = localanec;
          localarqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localarqk.jdField_a_of_type_AndroidContentContext = paramLinearLayout.getContext();
          localarqk.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localarqk.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localarqk.jdField_a_of_type_AndroidViewView$OnClickListener = this;
          localarqk.jdField_a_of_type_Arqd = this.jdField_a_of_type_Arqd;
          localarqk.jdField_a_of_type_Boolean = bool;
          localarqk.b = i;
          ((arqj)localObject).a(localarqk);
        }
      }
    }
  }
  
  private void b(List<anec> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    while (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        anec localanec = (anec)paramList.next();
        if ((localanec != null) && (TextUtils.isEmpty(localanec.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaUtilList.add(localanec);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      int j = this.jdField_a_of_type_JavaUtilList.size() % this.e;
      if ((j > 0) && (j < this.e))
      {
        int i = 0;
        while (i < this.e - j)
        {
          this.jdField_a_of_type_JavaUtilList.add(new anec());
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
  
  public void a(float paramFloat1, float paramFloat2, View paramView1, View paramView2, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (paramView1 == null))
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "statExposure mRootLayout == null || lvView == null");
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    paramFloat2 += paramView1.getHeight() - paramView1.getPaddingBottom() - paramView1.getPaddingTop();
    localStringBuilder1.append("reportExposure, e_top = ").append(paramFloat1).append(", e_bottom = ").append(paramFloat2);
    a(paramFloat1, paramFloat2, paramInt, paramView2, localStringBuilder1, localStringBuilder2);
    a(paramFloat1, paramFloat2, paramView2, localStringBuilder1, localStringBuilder2);
    paramView1 = arqg.a("plugin_exp");
    paramView1.jdField_a_of_type_JavaLangString = localStringBuilder2.toString();
    axpz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView1);
    QLog.i("Q.lebatab.LebaTableLogic", 1, localStringBuilder2);
  }
  
  public void a(List<anec> paramList)
  {
    b(paramList);
    b();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      anec localanec = a(paramView);
      if ((localanec != null) && (this.jdField_a_of_type_Arpv != null))
      {
        arqf localarqf = new arqf();
        localarqf.jdField_a_of_type_Boolean = true;
        localarqf.jdField_a_of_type_Long = localanec.jdField_a_of_type_Long;
        localarqf.jdField_a_of_type_Int = (paramView.getId() + 1);
        if ((paramView instanceof RedTouch)) {
          localarqf.b = arqg.a((RedTouch)paramView);
        }
        this.jdField_a_of_type_Arpv.a(paramView, localanec, localarqf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arqi
 * JD-Core Version:    0.7.0.1
 */