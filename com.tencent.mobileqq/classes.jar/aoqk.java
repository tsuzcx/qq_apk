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
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class aoqk
  extends aoqb
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 50;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private int jdField_b_of_type_Int;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private LinkedHashMap<String, List<FileManagerEntity>> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private View.OnClickListener c;
  private View.OnClickListener d;
  
  public aoqk(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener4)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.jdField_a_of_type_AndroidContentContext = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.jdField_b_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramObject);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.c = paramOnClickListener3;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.d = paramOnClickListener4;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = ((int)(2.0F * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_Int = a(4);
  }
  
  private int a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
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
    aoqm localaoqm = (aoqm)paramView.getTag();
    int i = 0;
    for (;;)
    {
      View localView;
      if (i < 4)
      {
        localView = b(paramInt1, paramInt2 * 4 + i, paramBoolean, localaoqm.a[i], paramViewGroup);
        if (localView != null) {}
      }
      else
      {
        return paramView;
      }
      localaoqm.a[i] = localView;
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
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new aoqm(null));
    return paramViewGroup;
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    if (paramViewGroup != null) {}
    View localView;
    for (FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramViewGroup;; localView = null)
    {
      if (localFileManagerEntity == null) {
        return null;
      }
      if (paramView == null) {
        paramViewGroup = paramView;
      }
      for (;;)
      {
        try
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560464, null);
          paramViewGroup = paramView;
          localaoqa = new aoqa();
          paramViewGroup = paramView;
          localaoqa.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367776));
          paramViewGroup = paramView;
          localaoqa.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367793));
          paramViewGroup = paramView;
          localaoqa.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367790));
          paramViewGroup = paramView;
          localaoqa.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          paramViewGroup = paramView;
          localaoqa.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.c);
          paramViewGroup = paramView;
          localaoqa.jdField_a_of_type_AndroidWidgetImageView.setTag(localaoqa);
          paramViewGroup = paramView;
          localaoqa.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localaoqa);
          paramViewGroup = paramView;
          paramView.setTag(localaoqa);
          try
          {
            localaoqa.jdField_a_of_type_JavaLangObject = localFileManagerEntity;
            localaoqa.jdField_a_of_type_Int = paramInt2;
            localaoqa.jdField_b_of_type_Int = paramInt1;
            localaoqa.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
            localaoqa.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            localaoqa.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130846926);
            localaoqa.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
            apug.a(localaoqa.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
            paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692497) + localFileManagerEntity.fileName;
            if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f()) {
              continue;
            }
            localaoqa.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            if (!apel.a(localFileManagerEntity)) {
              continue;
            }
            paramViewGroup = paramViewGroup + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692498);
            localaoqa.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840202);
            paramView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167134));
            paramView.setOnLongClickListener(null);
            localaoqa.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramViewGroup);
            localaoqa.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(paramViewGroup);
            return paramView;
          }
          catch (Exception localException)
          {
            paramViewGroup = paramView;
          }
        }
        catch (Exception paramView)
        {
          aoqa localaoqa;
          localView = paramView;
          continue;
        }
        localException.printStackTrace();
        QLog.e("#######", 1, localException.toString());
        return paramViewGroup;
        paramViewGroup = paramView;
        localaoqa = (aoqa)paramView.getTag();
        continue;
        paramViewGroup = paramViewGroup + ajya.a(2131709705);
        localaoqa.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        localaoqa.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844858);
        paramView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        continue;
        localaoqa.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localaoqa.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public int b()
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
    return a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
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
        if (i != paramInt) {
          break label82;
        }
        paramInt = ((List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str)).size();
        if (paramInt < 4) {
          j = 1;
        }
      }
      else
      {
        return j;
      }
      return paramInt / 4 + 1;
      label82:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoqk
 * JD-Core Version:    0.7.0.1
 */