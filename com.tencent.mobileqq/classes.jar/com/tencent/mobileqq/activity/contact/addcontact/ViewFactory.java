package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.adapter.GroupSearchAdapter;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public class ViewFactory
{
  private static ViewFactory jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final int[] jdField_a_of_type_ArrayOfInt = { 80000000, 80000001, 80000002, 80000004, 80000003 };
  private static final int[] b = { 80000001, 80000000, 80000002, 80000004, 80000003 };
  private static final int[] c = { 80000002, 80000000, 80000001, 80000004, 80000003 };
  private HashMap<Integer, WeakReference<View>> jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2131689683;
    case 80000004: 
      return 2131719439;
    case 80000003: 
      return 2131689672;
    case 80000002: 
      if (UniteSearchActivity.d == 12) {
        return 2131689696;
      }
      return 2131689695;
    case 80000001: 
      return 2131689698;
    }
    return 2131689666;
  }
  
  private View a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(13);
    localLinearLayout.setOrientation(1);
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setId(2131367608);
    localImageView.setImageResource(2130842409);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams1.gravity = 1;
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramContext.getString(2131718603));
    localTextView.setTextSize(0, paramContext.getResources().getDimension(2131299106));
    localTextView.setPadding(0, AIOUtils.b(30.0F, paramContext.getResources()), 0, 0);
    localTextView.setTextColor(paramContext.getResources().getColor(2131167139));
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams2.gravity = 1;
    localLinearLayout.addView(localImageView, localLayoutParams1);
    localLinearLayout.addView(localTextView, localLayoutParams2);
    localRelativeLayout.addView(localLinearLayout, localLayoutParams);
    localRelativeLayout.setContentDescription(paramContext.getString(2131718603));
    return localRelativeLayout;
  }
  
  private View a(Context paramContext, WeakReference<IFaceDecoder> paramWeakReference, List<ISearchResultGroupModel> paramList)
  {
    paramContext = (ListView)LayoutInflater.from(paramContext).inflate(2131563008, null);
    paramContext.setOnTouchListener(new ViewFactory.1(this));
    paramWeakReference = new GroupSearchAdapter(paramContext, (IFaceDecoder)paramWeakReference.get(), null, -1);
    paramContext.setAdapter(paramWeakReference);
    paramWeakReference.a(SearchUtil.a(paramList, true));
    return paramContext;
  }
  
  public static ViewFactory a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory == null) {
          jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory = new ViewFactory();
        }
      }
    }
    return jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory;
  }
  
  public static int[] a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return jdField_a_of_type_ArrayOfInt;
    case 80000003: 
      return jdField_a_of_type_ArrayOfInt;
    case 80000002: 
      return c;
    case 80000001: 
      return b;
    }
    return jdField_a_of_type_ArrayOfInt;
  }
  
  private View b(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramContext.getString(2131718605));
    localTextView.setTextSize(0, paramContext.getResources().getDimension(2131299106));
    localTextView.setPadding(0, paramContext.getResources().getDimensionPixelSize(2131298451), 0, 0);
    localTextView.setTextColor(paramContext.getResources().getColor(2131167139));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 1;
    localLinearLayout.addView(localTextView, localLayoutParams);
    localLinearLayout.setContentDescription(paramContext.getString(2131718605));
    return localLinearLayout;
  }
  
  private View c(Context paramContext)
  {
    return new ViewFactory.GuideView(paramContext);
  }
  
  public View a(int paramInt, Context paramContext, boolean paramBoolean, IFaceDecoder paramIFaceDecoder, List<ISearchResultGroupModel> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("type = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("ViewFactory", 2, ((StringBuilder)localObject1).toString());
    }
    int j = 0;
    Object localObject1 = null;
    int i = j;
    Object localObject2 = localObject1;
    if (paramBoolean)
    {
      i = j;
      localObject2 = localObject1;
      if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) != null)
      {
        localObject2 = (View)((WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).get();
        i = 1;
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      switch (paramInt)
      {
      default: 
        localObject1 = localObject2;
        break;
      case 80000008: 
        localObject1 = a(paramContext, new WeakReference(paramIFaceDecoder), paramList);
        break;
      case 80000007: 
        localObject1 = a(paramContext);
        break;
      case 80000006: 
        localObject1 = b(paramContext);
        break;
      case 80000005: 
        localObject1 = c(paramContext);
      }
    }
    if ((paramBoolean) && (i == 0)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new WeakReference(localObject1));
    }
    return localObject1;
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ViewFactory
 * JD-Core Version:    0.7.0.1
 */