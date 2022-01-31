import NearbyGroup.GroupInfo;
import NearbyGroup.GroupLabel;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class azmn
{
  public static final boolean a = AppSetting.d;
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramContext, paramViewGroup, paramInt, 2131562448);
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(paramInt2, paramViewGroup, false);
    paramViewGroup = new azmp();
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131377804));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131377869));
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131377755));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramContext.findViewById(2131377832));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(paramInt1);
    paramViewGroup.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramContext.findViewById(2131377833));
    paramViewGroup.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(2);
    paramViewGroup.e = ((TextView)paramContext.findViewById(2131365258));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setDistanceTextView(paramViewGroup.e);
    paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131377785));
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131377745));
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131377708));
    paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramContext.findViewById(2131375420));
    paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131368754));
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(null);
    paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131368344));
    paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131376739));
    paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131377753));
    paramViewGroup.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131369200);
    paramViewGroup.jdField_d_of_type_Int = paramInt1;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface)
  {
    HotChatManager.a(paramContext, false);
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, Context paramContext, boolean paramBoolean)
  {
    a(paramView, paramGroupInfo, paramContext, paramBoolean, false);
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramView, paramGroupInfo, paramContext, paramBoolean1, true, paramBoolean2);
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    azmp localazmp = (azmp)paramView.getTag();
    localazmp.jdField_a_of_type_JavaLangString = String.valueOf(paramGroupInfo.lCode);
    localazmp.jdField_a_of_type_AndroidWidgetTextView.setText(paramGroupInfo.strName);
    localazmp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131166861));
    Object localObject1;
    Object localObject2;
    int i;
    if ((paramBoolean2) && (paramGroupInfo.labels != null))
    {
      localObject1 = paramGroupInfo.labels.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GroupLabel)((Iterator)localObject1).next();
        if (((GroupLabel)localObject2).type == 2001L)
        {
          i = android.graphics.Color.rgb((int)((GroupLabel)localObject2).text_color.R, (int)((GroupLabel)localObject2).text_color.G, (int)((GroupLabel)localObject2).text_color.B);
          localazmp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
        }
      }
    }
    if ((paramBoolean1) || (paramBoolean3)) {
      localazmp.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (paramBoolean3) {
      localazmp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    localazmp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    if (TextUtils.isEmpty(paramGroupInfo.strIntro))
    {
      localazmp.jdField_c_of_type_AndroidWidgetTextView.setText(2131696446);
      localazmp.jdField_a_of_type_NearbyGroupGroupInfo = paramGroupInfo;
      if ((paramGroupInfo.labels != null) && (paramGroupInfo.labels.size() != 0)) {
        break label718;
      }
      if ((localazmp.jdField_a_of_type_JavaUtilArrayList == null) || (localazmp.jdField_a_of_type_JavaUtilArrayList.size() == 0))
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(new GroupLabel(paramGroupInfo.iMemberCnt + "", new NearbyGroup.Color(175L, 195L, 213L), 1L, new NearbyGroup.Color(190L, 206L, 220L)));
        localazmp.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
      }
      ((GroupLabel)localazmp.jdField_a_of_type_JavaUtilArrayList.get(0)).strWording = (paramGroupInfo.iMemberCnt + "");
      paramGroupInfo.labels = localazmp.jdField_a_of_type_JavaUtilArrayList;
      a(paramContext, localazmp, paramGroupInfo);
      if ((paramGroupInfo.dwGroupFlagExt & 0x800) == 0L) {
        break label812;
      }
      if (paramGroupInfo.dwCertType != 2L) {
        break label767;
      }
      localazmp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localazmp.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843233);
      label435:
      if ((paramGroupInfo.dwExtFlag & 1L) == 0L) {
        break label825;
      }
      localazmp.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130841988);
      localazmp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    label718:
    for (;;)
    {
      label466:
      if (a)
      {
        localObject1 = "" + paramGroupInfo.strName;
        paramContext = paramGroupInfo.iMemberCnt + ajya.a(2131707390);
        if (paramGroupInfo.labels == null) {
          break label907;
        }
        localObject2 = new StringBuffer();
        int j = paramGroupInfo.labels.size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            GroupLabel localGroupLabel = (GroupLabel)paramGroupInfo.labels.get(i);
            if ((localGroupLabel != null) && (!TextUtils.isEmpty(localGroupLabel.strWording))) {
              ((StringBuffer)localObject2).append(localGroupLabel.strWording).append(" ");
            }
            i += 1;
            continue;
            i = paramContext.getResources().getDisplayMetrics().widthPixels;
            if (localazmp.jdField_b_of_type_Int == 1) {
              i -= actj.a(110.0F, paramContext.getResources());
            }
            for (;;)
            {
              localObject1 = naj.b(naj.c(paramGroupInfo.strIntro));
              TextUtils.ellipsize((CharSequence)localObject1, localazmp.jdField_c_of_type_AndroidWidgetTextView.getPaint(), i, TextUtils.TruncateAt.END, false, new azmo(localazmp, (String)localObject1));
              break;
              i = (i - actj.a(137.0F, paramContext.getResources())) * 2;
            }
            if ((a(paramContext, localazmp, paramGroupInfo)) || (!QLog.isColorLevel())) {
              break;
            }
            QLog.e("NearbyTroops", 2, "fillTroopLabels failed:" + paramGroupInfo.strName);
            break;
            label767:
            if (paramGroupInfo.dwCertType == 1L)
            {
              localazmp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              localazmp.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843233);
              break label435;
            }
            localazmp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label435;
            localazmp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label435;
            localazmp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label466;
          }
        }
        if (((StringBuffer)localObject2).length() <= 0) {
          break label907;
        }
        paramContext = ((StringBuffer)localObject2).toString();
      }
    }
    label907:
    for (;;)
    {
      label812:
      label825:
      localazmp.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramContext);
      paramContext = (String)localObject1 + paramContext;
      paramView.setContentDescription(paramContext + paramGroupInfo.strIntro);
      return;
    }
  }
  
  protected static boolean a(Context paramContext, azmp paramazmp, GroupInfo paramGroupInfo)
  {
    if ((paramContext == null) || (paramazmp == null) || (paramGroupInfo == null) || (paramGroupInfo.labels == null) || (paramGroupInfo.labels.size() == 0)) {
      return false;
    }
    paramazmp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramazmp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
    paramContext = paramGroupInfo.labels;
    paramazmp.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramContext);
    return paramazmp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azmn
 * JD-Core Version:    0.7.0.1
 */