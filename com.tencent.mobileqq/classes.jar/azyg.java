import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azyg
  extends azwz
{
  private TextView a(Context paramContext, List<azus> paramList)
  {
    paramContext = new TextView(paramContext);
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      if ((paramList != null) && (i > 2))
      {
        paramList = (azus)paramList.get(i - 1);
        if ((paramList instanceof azuu))
        {
          paramContext.setText(((azuu)paramList).b());
          paramContext.setGravity(16);
          paramContext.setSingleLine(true);
        }
      }
      return paramContext;
    }
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    if (paramLinearLayout.getWidth() > 0)
    {
      b(paramLinearLayout);
      return;
    }
    paramLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new azyh(this, paramLinearLayout));
  }
  
  private void b(LinearLayout paramLinearLayout)
  {
    int k = paramLinearLayout.getChildCount();
    int i = 4;
    int j = 1;
    Object localObject;
    if (j < k)
    {
      localObject = paramLinearLayout.getChildAt(j);
      if (!(localObject instanceof TextView)) {
        break label107;
      }
      localObject = (TextView)localObject;
      Layout localLayout = ((TextView)localObject).getLayout();
      if (localLayout == null) {
        break label107;
      }
      int m = localLayout.getLineCount();
      if (i > 0)
      {
        ((TextView)localObject).setVisibility(0);
        if (i < m)
        {
          ((TextView)localObject).setMaxLines(i);
          ((TextView)localObject).requestLayout();
        }
        label84:
        i -= m;
      }
    }
    label107:
    for (;;)
    {
      j += 1;
      break;
      ((TextView)localObject).setVisibility(8);
      break label84;
      return;
    }
  }
  
  protected int a(Resources paramResources, int paramInt, azus paramazus)
  {
    int i = 4;
    if (paramInt == 1) {
      i = 7;
    }
    return aepi.a(i, paramResources);
  }
  
  protected ArrayList<azus> a(ArrayList<azus> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList();
    int m = paramArrayList.size();
    int j = 0;
    int i = 0;
    Object localObject2;
    int k;
    if (j < m)
    {
      localObject2 = (azus)paramArrayList.get(j);
      if ((j == 0) && ((localObject2 instanceof StructMsgItemTitle)))
      {
        StructMsgItemTitle localStructMsgItemTitle = (StructMsgItemTitle)localObject2;
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.hasTSum()) && (localStructMsgItemTitle.b().endsWith(alud.a(2131715012))))
        {
          k = 1;
          label92:
          if (k == 0) {
            break label314;
          }
          i = 1;
          label99:
          if (!(localObject2 instanceof azwx)) {
            break label254;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        paramArrayList = new StructMsgItemTitle(alud.a(2131714998));
      }
      for (;;)
      {
        paramArrayList.f("34");
        paramArrayList.g("12");
        paramArrayList.h("2");
        paramArrayList.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
        localArrayList.add(paramArrayList);
        paramArrayList = ((List)localObject1).iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (azus)paramArrayList.next();
          if ((localObject1 instanceof azuu))
          {
            localObject2 = (azuu)localObject1;
            ((azuu)localObject2).f("26");
            ((azuu)localObject2).e("#777777");
            ((azuu)localObject2).g("12");
            ((azuu)localObject2).h("2");
            ((azus)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
            localArrayList.add(localObject1);
          }
        }
        k = 0;
        break label92;
        label254:
        if (((localObject2 instanceof StructMsgItemTitle)) || ((localObject2 instanceof azzm))) {
          ((List)localObject1).add(localObject2);
        }
        j += 1;
        break;
        paramArrayList = (StructMsgItemTitle)((List)localObject1).get(0);
        ((List)localObject1).remove(0);
      }
      return localArrayList;
      label314:
      break label99;
    }
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    int k = 0;
    int j = 0;
    Resources localResources = paramContext.getResources();
    int i = localResources.getDimensionPixelSize(2131298824);
    int m = localResources.getDimensionPixelSize(2131298825);
    int n = localResources.getDimensionPixelSize(2131298823);
    LinearLayout localLinearLayout1;
    LinearLayout localLinearLayout2;
    Object localObject1;
    View localView;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localLinearLayout1 = (LinearLayout)paramView;
      localLinearLayout2 = (LinearLayout)localLinearLayout1.getChildAt(0);
      paramView = (TextView)localLinearLayout1.getChildAt(1);
      localObject1 = a(this.jdField_a_of_type_JavaUtilArrayList);
      if (localLinearLayout2.getChildCount() != ((ArrayList)localObject1).size()) {
        break label484;
      }
      k = ((ArrayList)localObject1).size();
      i = j;
      if (i >= k) {
        break label670;
      }
      localObject2 = (azus)((ArrayList)localObject1).get(i);
      ((azus)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((localObject2 instanceof StructMsgItemTitle)) {
        ((StructMsgItemTitle)localObject2).a(a(), this.l);
      }
      localView = ((azus)localObject2).a(paramContext, localLinearLayout2.getChildAt(i), paramBundle);
      if (localView != null) {
        break label390;
      }
    }
    label390:
    label484:
    do
    {
      return localLinearLayout2;
      localLinearLayout1 = new LinearLayout(paramContext);
      localLinearLayout1.setOrientation(1);
      localLinearLayout2 = new LinearLayout(paramContext);
      localLinearLayout2.setOrientation(1);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout2.setPadding(i, m, m, n);
      localLinearLayout2.setLayoutParams(paramView);
      paramView = a(paramContext, this.jdField_a_of_type_JavaUtilArrayList);
      paramView.setBackgroundResource(2130849870);
      paramView.setPadding(i, 0, 0, 0);
      paramView.setTextSize(1, 13.0F);
      paramView.setGravity(16);
      if (Build.VERSION.SDK_INT > 22) {}
      for (i = localResources.getColor(2131165619, paramContext.getTheme());; i = localResources.getColor(2131165619))
      {
        paramView.setTextColor(i);
        localObject1 = new LinearLayout.LayoutParams(-1, aepi.a(30.0F, localResources));
        ((LinearLayout.LayoutParams)localObject1).leftMargin = aepi.a(2.0F, localResources);
        ((LinearLayout.LayoutParams)localObject1).rightMargin = aepi.a(2.0F, localResources);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localLinearLayout1.addView(localLinearLayout2);
        localLinearLayout1.addView(paramView);
        break;
      }
      aepi.a(10.0F, localResources);
      localObject3 = new LinearLayout.LayoutParams(-1, -2);
      if (i > 0) {
        ((LinearLayout.LayoutParams)localObject3).topMargin = a(localResources, i, (azus)localObject2);
      }
      localObject2 = ((azus)localObject2).jdField_a_of_type_JavaLangString;
      if ("title".equals(localObject2)) {
        localView.setId(-1);
      }
      for (;;)
      {
        i += 1;
        break;
        if ("summary".equals(localObject2)) {
          localView.setId(-1);
        }
      }
      localLinearLayout2.removeAllViews();
      j = ((ArrayList)localObject1).size();
      i = k;
      if (i >= j) {
        break label670;
      }
      localObject3 = (azus)((ArrayList)localObject1).get(i);
      ((azus)localObject3).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((localObject3 instanceof StructMsgItemTitle)) {
        ((StructMsgItemTitle)localObject3).a(a(), this.l);
      }
      localView = ((azus)localObject3).a(paramContext, null, paramBundle);
    } while (localView == null);
    aepi.a(10.0F, localResources);
    Object localObject2 = new LinearLayout.LayoutParams(-1, -2);
    if (i > 0) {
      ((LinearLayout.LayoutParams)localObject2).topMargin = a(localResources, i, (azus)localObject3);
    }
    Object localObject3 = ((azus)localObject3).jdField_a_of_type_JavaLangString;
    if ("title".equals(localObject3)) {
      localView.setId(-1);
    }
    for (;;)
    {
      localLinearLayout2.addView(localView, (ViewGroup.LayoutParams)localObject2);
      i += 1;
      break;
      if ("summary".equals(localObject3)) {
        localView.setId(-1);
      }
    }
    label670:
    a(localLinearLayout2);
    i = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramContext = (azus)this.jdField_a_of_type_JavaUtilArrayList.get(i - 1);
    if ((paramContext instanceof azuu)) {
      paramView.setText(((azuu)paramContext).Y);
    }
    return localLinearLayout1;
  }
  
  public String b()
  {
    return "Layout30";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azyg
 * JD-Core Version:    0.7.0.1
 */