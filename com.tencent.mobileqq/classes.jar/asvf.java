import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import java.util.LinkedHashMap;
import java.util.List;

public class asvf
  extends asti
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private asvh jdField_a_of_type_Asvh;
  protected BaseFileAssistantActivity a;
  private View.OnClickListener b;
  
  public asvf(Context paramContext, LinkedHashMap<String, List<FavFileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener2, asvh paramasvh)
  {
    super(paramContext, paramLinkedHashMap);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_Asvh = paramasvh;
  }
  
  private String a(FavFileInfo paramFavFileInfo)
  {
    String str1 = atxd.b(paramFavFileInfo.jdField_c_of_type_Long);
    String str2 = atwl.a(paramFavFileInfo.b);
    return str1 + " " + paramFavFileInfo.m + " " + str2;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equalsIgnoreCase(""))) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  protected void a(FavFileInfo paramFavFileInfo, AsyncImageView paramAsyncImageView)
  {
    int i = atvo.a(paramFavFileInfo.jdField_c_of_type_JavaLangString);
    atvo.a(paramAsyncImageView, paramFavFileInfo.e, i);
    if ((i != 0) && (!TextUtils.isEmpty(paramFavFileInfo.e)) && (atwl.b(paramFavFileInfo.e))) {
      paramAsyncImageView.setAsyncImage(paramFavFileInfo.e);
    }
    for (;;)
    {
      return;
      if ((i != 0) || (i != 2))
      {
        String str2 = "";
        String str1;
        if ((!TextUtils.isEmpty(paramFavFileInfo.k)) && (atwl.b(paramFavFileInfo.k))) {
          str1 = paramFavFileInfo.k;
        }
        while (!TextUtils.isEmpty(str1))
        {
          paramAsyncImageView.setAsyncImage(str1);
          return;
          if ((!TextUtils.isEmpty(paramFavFileInfo.j)) && (atwl.b(paramFavFileInfo.j)))
          {
            str1 = paramFavFileInfo.j;
          }
          else if ((!TextUtils.isEmpty(paramFavFileInfo.i)) && (atwl.b(paramFavFileInfo.i)))
          {
            str1 = paramFavFileInfo.i;
          }
          else if ((!TextUtils.isEmpty(paramFavFileInfo.h)) && (atwl.b(paramFavFileInfo.h)))
          {
            str1 = paramFavFileInfo.h;
          }
          else
          {
            str1 = str2;
            if (!TextUtils.isEmpty(paramFavFileInfo.g))
            {
              str1 = str2;
              if (atwl.b(paramFavFileInfo.g)) {
                str1 = paramFavFileInfo.g;
              }
            }
          }
        }
      }
    }
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FavFileInfo localFavFileInfo = (FavFileInfo)getChild(paramInt1, paramInt2);
    if (localFavFileInfo == null) {
      return paramView;
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new asvg(this);
        localObject1 = paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560842, paramViewGroup, false);
        localObject1 = paramView;
        ((asvg)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376115));
        localObject1 = paramView;
        ((asvg)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = paramView;
        ((asvg)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localObject1 = paramView;
        ((asvg)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
        localObject1 = paramView;
        ((asvg)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramView.findViewById(2131361941));
        localObject1 = paramView;
        ((asvg)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366568));
        localObject1 = paramView;
        ((asvg)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366555));
        localObject1 = paramView;
        ((asvg)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = paramView;
        ((asvg)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject2);
        localObject1 = paramView;
        ((asvg)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366566));
        localObject1 = paramView;
        ((asvg)localObject2).jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
        localObject1 = paramView;
        ((asvg)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
        localObject1 = paramView;
        ((asvg)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366553));
        localObject1 = paramView;
        ((asvg)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369522));
        localObject1 = paramView;
        ((asvg)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(afur.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localObject1 = paramView;
        paramView.setTag(localObject2);
        paramViewGroup = (ViewGroup)localObject2;
        try
        {
          a(localFavFileInfo, paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView);
          paramViewGroup.jdField_b_of_type_Int = paramInt1;
          paramViewGroup.jdField_a_of_type_Int = paramInt2;
          paramViewGroup.jdField_a_of_type_JavaLangObject = localFavFileInfo;
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.b);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramViewGroup);
          paramViewGroup.jdField_c_of_type_Int = 1;
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFavFileInfo.jdField_c_of_type_JavaLangString);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(a(localFavFileInfo));
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692164);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692139);
          localObject1 = atxd.b(localFavFileInfo.jdField_c_of_type_Long) + a((String)localObject2, (String)localObject1);
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
          {
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(athc.a(localFavFileInfo));
            localObject1 = (LinearLayout.LayoutParams)paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).topMargin = afur.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
            return paramView;
            localObject1 = paramView;
            paramViewGroup = (asvg)paramView.getTag();
          }
          else
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
            continue;
            paramViewGroup.printStackTrace();
          }
        }
        catch (Exception paramViewGroup) {}
      }
      catch (Exception paramViewGroup)
      {
        paramView = (View)localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvf
 * JD-Core Version:    0.7.0.1
 */