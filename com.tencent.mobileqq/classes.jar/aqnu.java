import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class aqnu
  extends aqni
{
  private float jdField_a_of_type_Float = 0.0F;
  public final int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private aqov jdField_a_of_type_Aqov;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  public final int b;
  private Context jdField_b_of_type_AndroidContentContext;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private LinkedHashMap<String, List<WeiYunFileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int jdField_c_of_type_Int = 50;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  private int jdField_d_of_type_Int;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener;
  
  public aqnu(aqov paramaqov, BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener4)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_AndroidContentContext = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.jdField_b_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramObject);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_c_of_type_AndroidViewView$OnClickListener = paramOnClickListener3;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = paramOnClickListener4;
    this.jdField_a_of_type_Aqov = paramaqov;
    this.jdField_a_of_type_Float = this.jdField_b_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_d_of_type_Int = ((int)(2.0F * this.jdField_a_of_type_Float));
    this.jdField_c_of_type_Int = a(4);
  }
  
  private int a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = this.jdField_b_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * ((paramInt - 1) * 2)) / paramInt;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = a(paramViewGroup);
    }
    paramView.removeAllViews();
    aqnw localaqnw = (aqnw)paramView.getTag();
    int i = 0;
    for (;;)
    {
      View localView;
      if (i < 4)
      {
        localView = b(paramInt1, paramInt2 * 4 + i, paramBoolean, localaqnw.a[i], paramViewGroup);
        if (localView != null) {}
      }
      else
      {
        return paramView;
      }
      localaqnw.a[i] = localView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new LinearLayout.LayoutParams(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int);
      }
      ((LinearLayout.LayoutParams)localObject).width = this.jdField_c_of_type_Int;
      ((LinearLayout.LayoutParams)localObject).height = this.jdField_c_of_type_Int;
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = this.jdField_d_of_type_Int;
      }
      ((LinearLayout.LayoutParams)localObject).topMargin = this.jdField_d_of_type_Int;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.addView(localView);
      i += 1;
    }
  }
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.jdField_b_of_type_AndroidContentContext);
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new aqnw(null));
    return paramViewGroup;
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    if (paramViewGroup != null) {}
    label295:
    Object localObject2;
    for (Object localObject1 = (WeiYunFileInfo)paramViewGroup;; localObject2 = null)
    {
      if (localObject1 == null)
      {
        if (a(paramInt1, paramInt2) == 1) {
          return null;
        }
        if (this.jdField_a_of_type_Aqov.c()) {
          return null;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("@#@#@#", 4, "groupPosition[" + paramInt1 + "],position[" + paramInt2 + "] add getMoreButton");
        }
        paramView = new aqnh();
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560648, null);
        paramViewGroup.setClickable(true);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379982));
        paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131375588));
        paramView.c = ((ImageView)paramViewGroup.findViewById(2131369761));
        paramView.jdField_a_of_type_Boolean = true;
        paramView.jdField_b_of_type_Int = paramInt1;
        paramView.jdField_a_of_type_Int = paramInt2;
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_Aqov.a(paramView.jdField_a_of_type_AndroidWidgetTextView));
        paramViewGroup.setTag(paramView);
        if ((this.jdField_b_of_type_JavaUtilLinkedHashMap.size() == 0) && (!this.jdField_a_of_type_Aqov.a()))
        {
          paramViewGroup.setVisibility(8);
          if (!this.jdField_a_of_type_Aqov.b()) {
            break label295;
          }
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          paramView.c.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131692790);
        }
        for (;;)
        {
          return paramViewGroup;
          paramViewGroup.setVisibility(0);
          break;
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramView.c.setVisibility(0);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131692573);
        }
      }
      if (paramView == null) {
        paramViewGroup = paramView;
      }
      for (;;)
      {
        try
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560658, null);
          paramViewGroup = paramView;
          localObject3 = new aqnh();
          paramViewGroup = paramView;
          ((aqnh)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367921));
          paramViewGroup = paramView;
          ((aqnh)localObject3).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367938));
          paramViewGroup = paramView;
          ((aqnh)localObject3).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367935));
          paramViewGroup = paramView;
          ((aqnh)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
          paramViewGroup = paramView;
          ((aqnh)localObject3).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          paramViewGroup = paramView;
          ((aqnh)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject3);
          paramViewGroup = paramView;
          ((aqnh)localObject3).jdField_a_of_type_AndroidWidgetImageView.setTag(localObject3);
          paramViewGroup = paramView;
          ((aqnh)localObject3).jdField_a_of_type_Boolean = false;
          paramViewGroup = paramView;
          paramView.setTag(localObject3);
          paramViewGroup = (ViewGroup)localObject3;
        }
        catch (Exception paramView)
        {
          Object localObject3;
          localObject2 = paramView;
          continue;
          paramViewGroup = (ViewGroup)localObject3;
          continue;
        }
        try
        {
          paramViewGroup.jdField_a_of_type_JavaLangObject = localObject1;
          paramViewGroup.jdField_b_of_type_Int = paramInt1;
          paramViewGroup.jdField_a_of_type_Int = paramInt2;
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130847367);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int);
          paramViewGroup.jdField_a_of_type_Boolean = false;
          if ((((WeiYunFileInfo)localObject1).h != null) && (((WeiYunFileInfo)localObject1).h.length() > 0) && (arso.b(((WeiYunFileInfo)localObject1).h))) {
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(((WeiYunFileInfo)localObject1).h);
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692574) + ((WeiYunFileInfo)localObject1).c;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f()) {
            continue;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (!arbs.a((WeiYunFileInfo)localObject1)) {
            continue;
          }
          localObject1 = (String)localObject3 + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692575);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840306);
          paramView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167194));
          paramView.setOnLongClickListener(null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject1);
          return paramView;
        }
        catch (Exception localException)
        {
          paramViewGroup = paramView;
        }
        localException.printStackTrace();
        QLog.e("#######", 1, localException.toString());
        return paramViewGroup;
        paramViewGroup = paramView;
        localObject3 = (aqnh)paramView.getTag();
        paramViewGroup = paramView;
        if (!((aqnh)localObject3).jdField_a_of_type_Boolean) {
          continue;
        }
        paramViewGroup = paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560658, null);
        paramViewGroup = paramView;
        localObject3 = new aqnh();
        paramViewGroup = paramView;
        ((aqnh)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367921));
        paramViewGroup = paramView;
        ((aqnh)localObject3).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367938));
        paramViewGroup = paramView;
        ((aqnh)localObject3).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367935));
        paramViewGroup = paramView;
        ((aqnh)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        paramViewGroup = paramView;
        ((aqnh)localObject3).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        paramViewGroup = paramView;
        ((aqnh)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject3);
        paramViewGroup = paramView;
        ((aqnh)localObject3).jdField_a_of_type_AndroidWidgetImageView.setTag(localObject3);
        paramViewGroup = paramView;
        paramView.setTag(localObject3);
        paramViewGroup = (ViewGroup)localObject3;
        continue;
        localObject2 = (String)localObject3 + alud.a(2131710120);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845294);
        paramView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject2 = localObject3;
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 + 1 < this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().size()) {
      return 1;
    }
    List localList = (List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(getGroup(paramInt1));
    if (((localList == null) && (paramInt2 == 0)) || ((localList != null) && (paramInt2 == localList.size()))) {
      return 2;
    }
    return 1;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int + this.jdField_d_of_type_Int;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (i == paramInt1)
      {
        localObject = (List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str);
        if (paramInt2 >= ((List)localObject).size()) {
          return null;
        }
        return ((List)localObject).get(paramInt2);
      }
      i += 1;
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
  }
  
  public int getChildrenCount(int paramInt)
  {
    int j = 0;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == paramInt)
      {
        paramInt = ((List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str)).size();
        if (paramInt < 4) {
          paramInt = 1;
        }
      }
    }
    do
    {
      return paramInt;
      return paramInt / 4 + 1;
      i += 1;
      break;
      paramInt = j;
    } while (this.jdField_a_of_type_Aqov.c());
    return 1;
  }
  
  public Object getGroup(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == paramInt) {
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  public int getGroupCount()
  {
    if (this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().size() > 0) {
      return this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().size();
    }
    if (!this.jdField_a_of_type_Aqov.c()) {
      return 1;
    }
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnu
 * JD-Core Version:    0.7.0.1
 */