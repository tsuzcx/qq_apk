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

public class bfpa
{
  public static final boolean a = AppSetting.c;
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramContext, paramViewGroup, paramInt, 2131562943);
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(paramInt2, paramViewGroup, false);
    paramViewGroup = new bfpc();
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131379419));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131379490));
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131379368));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramContext.findViewById(2131379447));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(paramInt1);
    paramViewGroup.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramContext.findViewById(2131379448));
    paramViewGroup.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(2);
    paramViewGroup.e = ((TextView)paramContext.findViewById(2131365622));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setDistanceTextView(paramViewGroup.e);
    paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131379400));
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131379360));
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131379322));
    paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramContext.findViewById(2131376838));
    paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131369464));
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(null);
    paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131368923));
    paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131378273));
    paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131379367));
    paramViewGroup.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131369944);
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
    bfpc localbfpc = (bfpc)paramView.getTag();
    localbfpc.jdField_a_of_type_JavaLangString = String.valueOf(paramGroupInfo.lCode);
    localbfpc.jdField_a_of_type_AndroidWidgetTextView.setText(paramGroupInfo.strName);
    localbfpc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131166997));
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
          localbfpc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
        }
      }
    }
    if ((paramBoolean1) || (paramBoolean3)) {
      localbfpc.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (paramBoolean3) {
      localbfpc.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    localbfpc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    if (TextUtils.isEmpty(paramGroupInfo.strIntro))
    {
      localbfpc.jdField_c_of_type_AndroidWidgetTextView.setText(2131695490);
      localbfpc.jdField_a_of_type_NearbyGroupGroupInfo = paramGroupInfo;
      if ((paramGroupInfo.labels != null) && (paramGroupInfo.labels.size() != 0)) {
        break label718;
      }
      if ((localbfpc.jdField_a_of_type_JavaUtilArrayList == null) || (localbfpc.jdField_a_of_type_JavaUtilArrayList.size() == 0))
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(new GroupLabel(paramGroupInfo.iMemberCnt + "", new NearbyGroup.Color(175L, 195L, 213L), 1L, new NearbyGroup.Color(190L, 206L, 220L)));
        localbfpc.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
      }
      ((GroupLabel)localbfpc.jdField_a_of_type_JavaUtilArrayList.get(0)).strWording = (paramGroupInfo.iMemberCnt + "");
      paramGroupInfo.labels = localbfpc.jdField_a_of_type_JavaUtilArrayList;
      a(paramContext, localbfpc, paramGroupInfo);
      if ((paramGroupInfo.dwGroupFlagExt & 0x800) == 0L) {
        break label812;
      }
      if (paramGroupInfo.dwCertType != 2L) {
        break label767;
      }
      localbfpc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbfpc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843809);
      label435:
      if ((paramGroupInfo.dwExtFlag & 1L) == 0L) {
        break label825;
      }
      localbfpc.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842476);
      localbfpc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    label718:
    for (;;)
    {
      label466:
      if (a)
      {
        localObject1 = "" + paramGroupInfo.strName;
        paramContext = paramGroupInfo.iMemberCnt + anzj.a(2131706272);
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
            if (localbfpc.jdField_b_of_type_Int == 1) {
              i -= agej.a(110.0F, paramContext.getResources());
            }
            for (;;)
            {
              localObject1 = nnr.b(nnr.c(paramGroupInfo.strIntro));
              TextUtils.ellipsize((CharSequence)localObject1, localbfpc.jdField_c_of_type_AndroidWidgetTextView.getPaint(), i, TextUtils.TruncateAt.END, false, new bfpb(localbfpc, (String)localObject1));
              break;
              i = (i - agej.a(137.0F, paramContext.getResources())) * 2;
            }
            if ((a(paramContext, localbfpc, paramGroupInfo)) || (!QLog.isColorLevel())) {
              break;
            }
            QLog.e("NearbyTroops", 2, "fillTroopLabels failed:" + paramGroupInfo.strName);
            break;
            label767:
            if (paramGroupInfo.dwCertType == 1L)
            {
              localbfpc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              localbfpc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843809);
              break label435;
            }
            localbfpc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label435;
            localbfpc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label435;
            localbfpc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
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
      localbfpc.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramContext);
      paramContext = (String)localObject1 + paramContext;
      paramView.setContentDescription(paramContext + paramGroupInfo.strIntro);
      return;
    }
  }
  
  protected static boolean a(Context paramContext, bfpc parambfpc, GroupInfo paramGroupInfo)
  {
    if ((paramContext == null) || (parambfpc == null) || (paramGroupInfo == null) || (paramGroupInfo.labels == null) || (paramGroupInfo.labels.size() == 0)) {
      return false;
    }
    parambfpc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    parambfpc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
    paramContext = paramGroupInfo.labels;
    parambfpc.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramContext);
    return parambfpc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfpa
 * JD-Core Version:    0.7.0.1
 */