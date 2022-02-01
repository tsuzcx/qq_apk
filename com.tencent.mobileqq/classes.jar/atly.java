import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class atly
  extends atjm
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 50;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private atmb jdField_a_of_type_Atmb;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private LinkedHashMap<String, List<FavFileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private View.OnClickListener c;
  private View.OnClickListener d;
  
  public atly(atmb paramatmb, BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener4)
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
    this.jdField_a_of_type_Atmb = paramatmb;
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
    paramViewGroup = getChild(paramInt1, paramInt2);
    if (paramViewGroup != null) {}
    for (FavFileInfo localFavFileInfo = (FavFileInfo)paramViewGroup;; localFavFileInfo = null)
    {
      this.jdField_a_of_type_Boolean = false;
      if (localFavFileInfo == null)
      {
        if (a(paramInt1, paramInt2) == 1) {}
        while (this.jdField_a_of_type_Atmb.b()) {
          return null;
        }
        paramView = new atjl();
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560879, null);
        paramViewGroup.setClickable(true);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131381122));
        paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131376445));
        paramView.c = ((ImageView)paramViewGroup.findViewById(2131370293));
        paramView.jdField_a_of_type_Boolean = true;
        paramView.jdField_b_of_type_Int = paramInt1;
        paramView.jdField_a_of_type_Int = paramInt2;
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_Atmb.a(paramView.jdField_a_of_type_AndroidWidgetTextView));
        paramViewGroup.setTag(paramView);
        if (this.jdField_b_of_type_JavaUtilLinkedHashMap.size() == 0) {
          paramViewGroup.setVisibility(8);
        }
        while (this.jdField_a_of_type_Atmb.a())
        {
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          paramView.c.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131692362);
          return paramViewGroup;
          paramViewGroup.setVisibility(0);
          this.jdField_a_of_type_Boolean = true;
        }
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramView.c.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131692164);
        return paramViewGroup;
      }
      if (paramView == null) {
        paramViewGroup = paramView;
      }
      for (;;)
      {
        try
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560889, null);
          paramViewGroup = paramView;
          localatjl = new atjl();
          paramViewGroup = paramView;
          localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368320));
          paramViewGroup = paramView;
          localatjl.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368337));
          paramViewGroup = paramView;
          localatjl.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368334));
          paramViewGroup = paramView;
          localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.c);
          paramViewGroup = paramView;
          localatjl.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          paramViewGroup = paramView;
          localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localatjl);
          paramViewGroup = paramView;
          localatjl.jdField_a_of_type_AndroidWidgetImageView.setTag(localatjl);
          paramViewGroup = paramView;
          localatjl.jdField_a_of_type_Boolean = false;
          paramViewGroup = paramView;
          paramView.setTag(localatjl);
        }
        catch (Exception localException2)
        {
          atjl localatjl;
          paramView = paramViewGroup;
          continue;
          continue;
        }
        try
        {
          localatjl.jdField_a_of_type_JavaLangObject = localFavFileInfo;
          localatjl.jdField_b_of_type_Int = paramInt1;
          localatjl.jdField_a_of_type_Int = paramInt2;
          localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
          localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130847845);
          localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
          localatjl.jdField_a_of_type_Boolean = false;
          a(localFavFileInfo, localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView);
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692166) + localFavFileInfo.c;
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
          {
            localatjl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localatjl.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
            if (this.jdField_a_of_type_Atmb.a(localFavFileInfo))
            {
              paramViewGroup = paramViewGroup + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692165);
              localatjl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
              localatjl.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845707);
              localatjl.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
              localatjl.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramViewGroup);
              localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(paramViewGroup);
              return paramView;
              paramViewGroup = paramView;
              localatjl = (atjl)paramView.getTag();
              paramViewGroup = paramView;
              if (!localatjl.jdField_a_of_type_Boolean) {
                continue;
              }
              paramViewGroup = paramView;
              paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560889, null);
              paramViewGroup = paramView;
              localatjl = new atjl();
              paramViewGroup = paramView;
              localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368320));
              paramViewGroup = paramView;
              localatjl.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368337));
              paramViewGroup = paramView;
              localatjl.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368334));
              paramViewGroup = paramView;
              localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.c);
              paramViewGroup = paramView;
              localatjl.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
              paramViewGroup = paramView;
              localatjl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localatjl);
              paramViewGroup = paramView;
              localatjl.jdField_a_of_type_AndroidWidgetImageView.setTag(localatjl);
              paramViewGroup = paramView;
              paramView.setTag(localatjl);
              continue;
            }
            if (atyw.a(localFavFileInfo))
            {
              paramViewGroup = paramViewGroup + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692167);
              localatjl.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840495);
              paramView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167302));
              paramView.setOnLongClickListener(null);
              continue;
            }
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          QLog.e("#######", 1, localException1.toString());
          continue;
          paramViewGroup = paramViewGroup + anzj.a(2131708605);
          localException1.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          localException1.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845705);
          paramView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          continue;
          localException1.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          localException1.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
  }
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new atma(null));
    return paramViewGroup;
  }
  
  private void a(FavFileInfo paramFavFileInfo, AsyncImageView paramAsyncImageView)
  {
    if ((!TextUtils.isEmpty(paramFavFileInfo.e)) && (auog.b(paramFavFileInfo.e)))
    {
      paramAsyncImageView.setAsyncImage(paramFavFileInfo.e);
      return;
    }
    int i = 0;
    String str = "";
    if ((!TextUtils.isEmpty(paramFavFileInfo.k)) && (auog.b(paramFavFileInfo.k))) {
      str = paramFavFileInfo.k;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str))
      {
        paramAsyncImageView.setAsyncImage(str);
        if (i == 0) {
          break;
        }
      }
      long l = System.currentTimeMillis();
      if (l - paramFavFileInfo.a(2) <= 30000L) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.a().a().a(paramFavFileInfo, 2);
      paramFavFileInfo.a(2, l);
      return;
      if ((!TextUtils.isEmpty(paramFavFileInfo.j)) && (auog.b(paramFavFileInfo.j)))
      {
        str = paramFavFileInfo.j;
      }
      else if ((!TextUtils.isEmpty(paramFavFileInfo.i)) && (auog.b(paramFavFileInfo.i)))
      {
        str = paramFavFileInfo.i;
      }
      else if ((!TextUtils.isEmpty(paramFavFileInfo.h)) && (auog.b(paramFavFileInfo.h)))
      {
        str = paramFavFileInfo.h;
      }
      else if ((!TextUtils.isEmpty(paramFavFileInfo.g)) && (auog.b(paramFavFileInfo.g)))
      {
        str = paramFavFileInfo.g;
        i = 1;
      }
      else if ((!TextUtils.isEmpty(paramFavFileInfo.f)) && (auog.b(paramFavFileInfo.f)))
      {
        str = paramFavFileInfo.f;
        i = 1;
      }
      else
      {
        i = 1;
      }
    }
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = a(paramViewGroup);
    }
    paramView.removeAllViews();
    atma localatma = (atma)paramView.getTag();
    int i = 0;
    for (;;)
    {
      View localView;
      if (i < 4)
      {
        localView = a(paramInt1, paramInt2 * 4 + i, paramBoolean, localatma.a[i], paramViewGroup);
        if (localView != null) {}
      }
      else
      {
        return paramView;
      }
      localatma.a[i] = localView;
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
    return this.jdField_a_of_type_Int + this.jdField_b_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
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
    } while (this.jdField_a_of_type_Atmb.b());
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
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atly
 * JD-Core Version:    0.7.0.1
 */