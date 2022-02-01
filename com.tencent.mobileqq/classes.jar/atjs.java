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
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class atjs
  extends atjm
{
  private float jdField_a_of_type_Float = 0.0F;
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  protected BaseFileAssistantActivity a;
  private int jdField_b_of_type_Int;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private LinkedHashMap<String, List<FileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private View.OnClickListener c;
  private View.OnClickListener d;
  
  public atjs(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener4)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.jdField_a_of_type_Int = 50;
    this.jdField_a_of_type_AndroidContentContext = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.jdField_b_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramObject);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.c = paramOnClickListener3;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.d = paramOnClickListener4;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = ((int)(2.0F * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_Int = a(b());
  }
  
  private int a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * ((paramInt - 1) * 2)) / paramInt;
  }
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new atju(null));
    return paramViewGroup;
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = a(paramViewGroup);
    }
    paramView.removeAllViews();
    atju localatju = (atju)paramView.getTag();
    int i = 0;
    for (;;)
    {
      View localView;
      if (i < 4)
      {
        localView = a(paramInt1, paramInt2 * 4 + i, paramBoolean, localatju.a[i], paramViewGroup);
        if (localView != null) {}
      }
      else
      {
        return paramView;
      }
      localatju.a[i] = localView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new LinearLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      }
      ((LinearLayout.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
      ((LinearLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = this.jdField_b_of_type_Int;
      }
      ((LinearLayout.LayoutParams)localObject).topMargin = this.jdField_b_of_type_Int;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.addView(localView);
      i += 1;
    }
  }
  
  protected View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    if (paramViewGroup != null) {}
    for (Object localObject = (FileInfo)paramViewGroup;; localObject = null)
    {
      if (localObject == null) {
        return null;
      }
      if (paramView == null) {}
      for (;;)
      {
        try
        {
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560889, null);
          paramView = paramViewGroup;
          try
          {
            localatjl = new atjl();
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131368320));
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368337));
            paramView = paramViewGroup;
            localatjl.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368334));
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localatjl);
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_AndroidWidgetImageView.setTag(localatjl);
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.c);
            paramView = paramViewGroup;
            paramViewGroup.setTag(localatjl);
            paramView = paramViewGroup;
            ((FileInfo)localObject).a((String)getGroup(paramInt1));
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_JavaLangObject = localObject;
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_Int = paramInt2;
            paramView = paramViewGroup;
            localatjl.jdField_b_of_type_Int = paramInt1;
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130847845);
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
            paramView = paramViewGroup;
            if (((FileInfo)localObject).c() != null)
            {
              paramView = paramViewGroup;
              if (((FileInfo)localObject).c().length() > 0)
              {
                paramView = paramViewGroup;
                if (auog.b(((FileInfo)localObject).c()))
                {
                  paramView = paramViewGroup;
                  localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(((FileInfo)localObject).c());
                }
              }
            }
            paramView = paramViewGroup;
            str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692166) + ((FileInfo)localObject).d();
            paramView = paramViewGroup;
            if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f()) {
              continue;
            }
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            paramView = paramViewGroup;
            if (atyw.a((FileInfo)localObject))
            {
              paramView = paramViewGroup;
              localObject = str + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692167);
              paramView = paramViewGroup;
              localatjl.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840495);
              paramView = paramViewGroup;
              paramViewGroup.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167302));
              paramView = paramViewGroup;
              paramViewGroup.setOnLongClickListener(null);
              paramView = paramViewGroup;
              localatjl.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
              paramView = paramViewGroup;
              localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject);
              return paramViewGroup;
              localatjl = (atjl)paramView.getTag();
              paramViewGroup = paramView;
              continue;
            }
            paramView = paramViewGroup;
            localObject = str + anzj.a(2131708558);
            paramView = paramViewGroup;
            localatjl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
            paramView = paramViewGroup;
            localatjl.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845705);
            continue;
            paramViewGroup.printStackTrace();
          }
          catch (Exception paramViewGroup) {}
        }
        catch (Exception paramViewGroup)
        {
          atjl localatjl;
          String str;
          continue;
        }
        QLog.e("#######", 1, paramViewGroup.toString());
        return paramView;
        paramView = paramViewGroup;
        localatjl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramView = paramViewGroup;
        localatjl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject = str;
      }
    }
  }
  
  protected int b()
  {
    return 4;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int + this.jdField_b_of_type_Int;
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
    return b(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
  }
  
  public int getChildrenCount(int paramInt)
  {
    int k = 0;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (i == paramInt) {
          j = ((List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str)).size() / 4 + 1;
        }
      }
      else
      {
        return j;
      }
      i += 1;
    }
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
    return this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjs
 * JD-Core Version:    0.7.0.1
 */