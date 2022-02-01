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
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bffn
{
  public static final boolean a = AppSetting.c;
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramContext, paramViewGroup, paramInt, 2131562893);
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(paramInt2, paramViewGroup, false);
    paramViewGroup = new bffp();
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131379492));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131379564));
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131379433));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramContext.findViewById(2131379521));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(paramInt1);
    paramViewGroup.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramContext.findViewById(2131379522));
    paramViewGroup.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(2);
    paramViewGroup.e = ((TextView)paramContext.findViewById(2131365748));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setDistanceTextView(paramViewGroup.e);
    paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131379465));
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131379425));
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131379387));
    paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramContext.findViewById(2131376863));
    paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131369617));
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(null);
    paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131369110));
    paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131378330));
    paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131379432));
    paramViewGroup.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131370108);
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
    bffp localbffp = (bffp)paramView.getTag();
    localbffp.jdField_a_of_type_JavaLangString = String.valueOf(paramGroupInfo.lCode);
    localbffp.jdField_a_of_type_AndroidWidgetTextView.setText(paramGroupInfo.strName);
    localbffp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131167033));
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
          localbffp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
        }
      }
    }
    if ((paramBoolean1) || (paramBoolean3)) {
      localbffp.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (paramBoolean3) {
      localbffp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    localbffp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    if (TextUtils.isEmpty(paramGroupInfo.strIntro))
    {
      localbffp.jdField_c_of_type_AndroidWidgetTextView.setText(2131695881);
      localbffp.jdField_a_of_type_NearbyGroupGroupInfo = paramGroupInfo;
      if ((paramGroupInfo.labels != null) && (paramGroupInfo.labels.size() != 0)) {
        break label718;
      }
      if ((localbffp.jdField_a_of_type_JavaUtilArrayList == null) || (localbffp.jdField_a_of_type_JavaUtilArrayList.size() == 0))
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(new GroupLabel(paramGroupInfo.iMemberCnt + "", new NearbyGroup.Color(175L, 195L, 213L), 1L, new NearbyGroup.Color(190L, 206L, 220L)));
        localbffp.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
      }
      ((GroupLabel)localbffp.jdField_a_of_type_JavaUtilArrayList.get(0)).strWording = (paramGroupInfo.iMemberCnt + "");
      paramGroupInfo.labels = localbffp.jdField_a_of_type_JavaUtilArrayList;
      a(paramContext, localbffp, paramGroupInfo);
      if ((paramGroupInfo.dwGroupFlagExt & 0x800) == 0L) {
        break label812;
      }
      if (paramGroupInfo.dwCertType != 2L) {
        break label767;
      }
      localbffp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbffp.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843910);
      label435:
      if ((paramGroupInfo.dwExtFlag & 1L) == 0L) {
        break label825;
      }
      localbffp.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842552);
      localbffp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    label718:
    for (;;)
    {
      label466:
      if (a)
      {
        localObject1 = "" + paramGroupInfo.strName;
        paramContext = paramGroupInfo.iMemberCnt + anvx.a(2131706854);
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
            if (localbffp.jdField_b_of_type_Int == 1) {
              i -= AIOUtils.dp2px(110.0F, paramContext.getResources());
            }
            for (;;)
            {
              localObject1 = HttpUtil.unEscape(HttpUtil.removeHtmlTags(paramGroupInfo.strIntro));
              TextUtils.ellipsize((CharSequence)localObject1, localbffp.jdField_c_of_type_AndroidWidgetTextView.getPaint(), i, TextUtils.TruncateAt.END, false, new bffo(localbffp, (String)localObject1));
              break;
              i = (i - AIOUtils.dp2px(137.0F, paramContext.getResources())) * 2;
            }
            if ((a(paramContext, localbffp, paramGroupInfo)) || (!QLog.isColorLevel())) {
              break;
            }
            QLog.e("NearbyTroops", 2, "fillTroopLabels failed:" + paramGroupInfo.strName);
            break;
            label767:
            if (paramGroupInfo.dwCertType == 1L)
            {
              localbffp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              localbffp.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843910);
              break label435;
            }
            localbffp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label435;
            localbffp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label435;
            localbffp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
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
      localbffp.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramContext);
      paramContext = (String)localObject1 + paramContext;
      paramView.setContentDescription(paramContext + paramGroupInfo.strIntro);
      return;
    }
  }
  
  protected static boolean a(Context paramContext, bffp parambffp, GroupInfo paramGroupInfo)
  {
    if ((paramContext == null) || (parambffp == null) || (paramGroupInfo == null) || (paramGroupInfo.labels == null) || (paramGroupInfo.labels.size() == 0)) {
      return false;
    }
    parambffp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    parambffp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
    paramContext = paramGroupInfo.labels;
    parambffp.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramContext);
    return parambffp.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffn
 * JD-Core Version:    0.7.0.1
 */