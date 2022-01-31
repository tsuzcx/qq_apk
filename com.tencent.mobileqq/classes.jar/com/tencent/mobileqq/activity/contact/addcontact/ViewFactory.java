package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ViewFactory
{
  private static ViewFactory jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final int[] jdField_a_of_type_ArrayOfInt = { 80000000, 80000001, 80000002, 80000004, 80000003 };
  private static final int[] b = { 80000001, 80000000, 80000002, 80000004, 80000003 };
  private static final int[] c = { 80000002, 80000000, 80000001, 80000004, 80000003 };
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2131435486;
    case 80000000: 
      return 2131434364;
    case 80000001: 
      return 2131435487;
    case 80000002: 
      if (UniteSearchActivity.d == 12) {
        return 2131435509;
      }
      return 2131435508;
    case 80000003: 
      return 2131435489;
    }
    return 2131434945;
  }
  
  private View a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText("没有找到相关结果");
    localTextView.setTextSize(0, paramContext.getResources().getDimension(2131558464));
    localTextView.setPadding(0, paramContext.getResources().getDimensionPixelSize(2131559041), 0, 0);
    localTextView.setTextColor(paramContext.getResources().getColor(2131494265));
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 1;
    localLinearLayout.addView(localTextView, paramContext);
    localLinearLayout.setContentDescription("没有找到相关结果");
    return localLinearLayout;
  }
  
  public static ViewFactory a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory == null) {
        jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory = new ViewFactory();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory;
    }
  }
  
  public static int[] a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return jdField_a_of_type_ArrayOfInt;
    case 80000000: 
      return jdField_a_of_type_ArrayOfInt;
    case 80000001: 
      return b;
    case 80000002: 
      return c;
    }
    return jdField_a_of_type_ArrayOfInt;
  }
  
  private View b(Context paramContext)
  {
    return new ViewFactory.GuideView(paramContext);
  }
  
  public View a(int paramInt, Context paramContext, boolean paramBoolean)
  {
    int j = 0;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i = j;
    if (paramBoolean)
    {
      localObject1 = localObject2;
      i = j;
      if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) != null)
      {
        localObject1 = (View)((WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).get();
        i = 1;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      switch (paramInt)
      {
      default: 
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      if ((paramBoolean) && (i == 0)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new WeakReference(localObject2));
      }
      return localObject2;
      localObject2 = b(paramContext);
      continue;
      localObject2 = a(paramContext);
    }
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ViewFactory
 * JD-Core Version:    0.7.0.1
 */