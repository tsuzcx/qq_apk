import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.leba.widget.LebaTableLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aweh
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public awdg a;
  public awdo a;
  public QQAppInterface a;
  public LebaTableLayout a;
  private List<arpq> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c = 3;
  private int d = 1;
  
  public aweh(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845317);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_Int = ViewUtils.dpToPx(16.0F);
  }
  
  private int a(int paramInt)
  {
    if (this.d == 1) {
      return b(paramInt);
    }
    return 15;
  }
  
  private int a(LebaTableLayout paramLebaTableLayout)
  {
    return paramLebaTableLayout.getChildCount();
  }
  
  private View a(LebaTableLayout paramLebaTableLayout, int paramInt)
  {
    try
    {
      paramLebaTableLayout = paramLebaTableLayout.getChildAt(paramInt);
      return paramLebaTableLayout;
    }
    catch (Exception paramLebaTableLayout)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("findViewByIndex,index = ", new Object[] { Integer.valueOf(paramInt) }), paramLebaTableLayout);
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
      paramView = paramView.findViewById(2131375502);
      if (paramView == null)
      {
        paramStringBuilder1.append(",qZone == null");
        return;
      }
      i = paramView.getTop();
      j = paramView.getHeight() + i;
      paramStringBuilder1.append(",qZoneTop = ").append(i).append(",qZoneBottom = ").append(j);
    } while (((paramFloat1 >= i) || (i >= paramFloat2)) && ((paramFloat1 >= j) || (j >= paramFloat2)));
    paramStringBuilder2.append(10000L).append("_").append(0).append("_").append(paramInt1).append("_").append(0).append("_").append(awds.a(paramInt2)).append("_").append(paramString).append(";");
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
      paramView = paramView.findViewById(2131374485);
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
    paramView = paramView.findViewById(2131378435);
    if (paramView == null) {
      paramStringBuilder1.append(",tableRoot == null");
    }
    int j;
    int i;
    for (;;)
    {
      return;
      j = paramView.getTop();
      int k = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.getChildCount();
      paramStringBuilder1.append(", r_top = ").append(j).append(", r_count = ").append(k);
      i = 0;
      while (i < k)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.getChildAt(i);
        if (paramView != null) {
          break label105;
        }
        paramStringBuilder1.append("itemView == null ");
        i += 1;
      }
    }
    label105:
    int m = paramView.getTop() + j;
    int n = m + paramView.getHeight();
    if (((paramFloat1 < m) && (m < paramFloat2)) || ((paramFloat1 < n) && (n < paramFloat2))) {}
    for (boolean bool = true;; bool = false)
    {
      paramStringBuilder1.append(";").append(i).append("v_top=").append(m).append(",v_bottom=").append(n).append(bool);
      if (!bool) {
        break;
      }
      a(paramString, paramStringBuilder1, paramStringBuilder2, paramView);
      break;
    }
  }
  
  private void a(int paramInt, LebaTableLayout paramLebaTableLayout)
  {
    try
    {
      Object localObject = new awej(paramLebaTableLayout.getContext(), this.jdField_a_of_type_AndroidViewLayoutInflater, this.d);
      View localView = ((awej)localObject).jdField_a_of_type_AndroidViewView;
      localView.setTag(localObject);
      localView.setId(paramInt);
      localObject = ((awej)localObject).jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaRoundLayout;
      if (localObject != null)
      {
        ((LebaRoundLayout)localObject).jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        ((LebaRoundLayout)localObject).jdField_b_of_type_Int = a(paramInt);
      }
      for (;;)
      {
        paramLebaTableLayout.addView(localView);
        return;
        QLog.i("Q.lebatab.LebaTableLogic", 1, "rootLayout != null");
      }
      return;
    }
    catch (Exception paramLebaTableLayout)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "addTableItem,index = " + paramInt, paramLebaTableLayout);
    }
  }
  
  private void a(LebaTableLayout paramLebaTableLayout)
  {
    int i = a(paramLebaTableLayout);
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if ((i != j) || (this.d != this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.jdField_a_of_type_Int))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      c();
      b();
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.removeAllViews();
      localStringBuilder.append("removeAllViews");
      i = 0;
      while (i < j)
      {
        a(i, paramLebaTableLayout);
        localStringBuilder.append(" ").append(i);
        i += 1;
      }
      QLog.i("Q.lebatab.LebaTableLogic", 1, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, View paramView)
  {
    arpq localarpq = a(paramView);
    if ((localarpq == null) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      paramStringBuilder1.append(" item == null ||  item.info == null ");
      return;
    }
    paramStringBuilder1.append(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId);
    long l = localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
    int k = paramView.getId();
    int j;
    int i;
    if (this.jdField_a_of_type_Awdo != null)
    {
      paramStringBuilder1 = (awdr)this.jdField_a_of_type_Awdo.a().get(Long.valueOf(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
      if (paramStringBuilder1 != null)
      {
        j = paramStringBuilder1.jdField_a_of_type_Int;
        i = paramStringBuilder1.jdField_b_of_type_Int;
      }
    }
    for (;;)
    {
      paramStringBuilder2.append(l).append("_").append(k + 1).append("_").append(j).append("_").append(i).append("_").append(0).append("_").append(paramString).append(";");
      return;
      i = 0;
      j = 0;
    }
  }
  
  private int b(int paramInt)
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
    if (this.c > m) {}
    for (k = m - 1;; k = this.c - 1)
    {
      i = j;
      if (paramInt == k) {
        i = j | 0x2;
      }
      j = m % this.c;
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
  
  private void b(LebaTableLayout paramLebaTableLayout)
  {
    Object localObject1 = ThemeUtil.getCurrentThemeId();
    boolean bool1;
    boolean bool3;
    int i;
    if (("1000".equals(localObject1)) || ("2105".equals(localObject1)) || ("1103".equals(localObject1)) || ("2101".equals(localObject1)))
    {
      bool1 = true;
      bool3 = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("bindDataToTable themeId %s isNeedWaterMark %b isNight = %b", new Object[] { localObject1, Boolean.valueOf(bool1), Boolean.valueOf(bool3) }));
      i = 0;
      label100:
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      localObject1 = (arpq)this.jdField_a_of_type_JavaUtilList.get(i);
      localObject2 = a(paramLebaTableLayout, i);
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
      if (((View)localObject2).getTag() != null) {
        break label210;
      }
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("itemView.getTag() == null %d", new Object[] { Integer.valueOf(i) }));
    }
    label210:
    Object localObject2 = (awej)((View)localObject2).getTag();
    awek localawek = new awek();
    localawek.jdField_a_of_type_Arpq = ((arpq)localObject1);
    localawek.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localawek.jdField_a_of_type_AndroidContentContext = paramLebaTableLayout.getContext();
    localawek.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localawek.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localawek.jdField_a_of_type_AndroidViewView$OnClickListener = new awei(this);
    localawek.jdField_a_of_type_Awdo = this.jdField_a_of_type_Awdo;
    localawek.jdField_a_of_type_Boolean = bool3;
    localawek.jdField_b_of_type_Int = i;
    if ((bool1) && (this.d == 1)) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      localawek.jdField_b_of_type_Boolean = bool2;
      ((awej)localObject2).a(localawek);
      break;
    }
  }
  
  private void b(List<arpq> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    while (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        arpq localarpq = (arpq)localIterator.next();
        if ((localarpq != null) && (TextUtils.isEmpty(localarpq.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaUtilList.add(localarpq);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    anxo.b(paramList, a());
    if ((!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.d == 1))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size() % this.c;
      if ((j > 0) && (j < this.c))
      {
        int i = 0;
        while (i < this.c - j)
        {
          this.jdField_a_of_type_JavaUtilList.add(new arpq());
          i += 1;
        }
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout == null)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "notifyDataSetChanged mRootLayout == null");
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      a();
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout);
    b(this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout);
  }
  
  protected arpq a(View paramView)
  {
    int i = paramView.getId();
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size())) {
      return (arpq)this.jdField_a_of_type_JavaUtilList.get(i);
    }
    return null;
  }
  
  public List<Integer> a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      return anxo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, anxo.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.setPadding(0, 0, 0, 0);
      b();
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.removeAllViews();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, View paramView1, View paramView2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout == null) || (paramView1 == null))
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
    paramView2 = awds.a("plugin_exp");
    paramView2.jdField_a_of_type_JavaLangString = localStringBuilder2.toString();
    if (this.d == 1) {}
    for (paramView1 = "2";; paramView1 = "1")
    {
      paramView2.h = paramView1;
      bdkb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView2);
      QLog.i("Q.lebatab.LebaTableLogic", 1, localStringBuilder2);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 2)
    {
      if (paramInt != this.d)
      {
        this.d = paramInt;
        QLog.i("Q.lebatab.LebaTableLogic", 1, "setStyleByQzoneStyle=" + this.d);
        d();
      }
      return;
    }
  }
  
  public void a(List<arpq> paramList)
  {
    b(paramList);
    d();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout == null)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "stopTableItemAnim mRootLayout == null");
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.getChildCount();
    int i = 0;
    label27:
    Object localObject;
    if (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.getChildAt(i);
      if (localObject != null) {
        break label52;
      }
    }
    for (;;)
    {
      i += 1;
      break label27;
      break;
      label52:
      localObject = (awej)((View)localObject).getTag();
      if (localObject != null) {
        ((awej)localObject).a();
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout == null) {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "initTableByStyle mRootLayout == null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.jdField_a_of_type_Int == this.d)
      {
        QLog.i("Q.lebatab.LebaTableLogic", 1, "initTableByStyle equals style = " + this.d);
        return;
      }
      if (this.d == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.jdField_a_of_type_Int = this.d;
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.jdField_b_of_type_Int = ViewUtils.dpToPx(1.0F);
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.c = ViewUtils.dpToPx(1.0F);
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.d = ViewUtils.dpToPx(12.0F);
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.e = ViewUtils.dpToPx(12.0F);
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.f = ViewUtils.dpToPx(16.0F);
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.g = ViewUtils.dpToPx(16.0F);
        return;
      }
    } while (this.d != 2);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.jdField_a_of_type_Int = this.d;
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.jdField_b_of_type_Int = ViewUtils.dpToPx(11.0F);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.c = ViewUtils.dpToPx(11.0F);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.d = ViewUtils.dpToPx(11.0F);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.e = ViewUtils.dpToPx(12.0F);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.f = ViewUtils.dpToPx(16.0F);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.g = ViewUtils.dpToPx(16.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aweh
 * JD-Core Version:    0.7.0.1
 */