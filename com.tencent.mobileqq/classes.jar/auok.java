import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multicard.MultiCardRecommendFragment;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class auok
  extends RecyclerView.Adapter
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MultiCardRecommendFragment jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment;
  public Map<Integer, List<RecommendPerson>> a;
  private boolean jdField_a_of_type_Boolean;
  
  public auok(MultiCardRecommendFragment paramMultiCardRecommendFragment, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment = paramMultiCardRecommendFragment;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap(16, 0.75F, false);
    this.jdField_a_of_type_Boolean = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  private int a()
  {
    return this.jdField_a_of_type_JavaUtilMap.size();
  }
  
  private void a(TextView paramTextView, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.Adapter", 2, "setTextColorAndSize, needStyleText =" + paramString1 + " totalText =" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramTextView.setText(paramString2);
      return;
    }
    try
    {
      int i = paramString2.indexOf(paramString1);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramString2);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt), i, paramString1.length() + i, 33);
      paramTextView.setText(localSpannableStringBuilder);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramTextView.setText(paramString2);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment = null;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilMap.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() == 0)) {}
    Object[] arrayOfObject;
    do
    {
      return 0;
      if (paramInt >= a()) {
        return 1;
      }
      arrayOfObject = this.jdField_a_of_type_JavaUtilMap.keySet().toArray();
    } while ((arrayOfObject[paramInt] == null) || (!(arrayOfObject[paramInt] instanceof Integer)));
    return ((Integer)arrayOfObject[paramInt]).intValue();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof auoq)) {}
    do
    {
      do
      {
        return;
        String str1;
        String str2;
        String str3;
        String str4;
        if ((paramViewHolder instanceof auol))
        {
          paramViewHolder = (auol)paramViewHolder;
          if (paramViewHolder.jdField_a_of_type_JavaUtilList.size() > 0) {
            paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
          }
          paramInt = 0;
          while (paramInt < paramViewHolder.b.size()) {
            try
            {
              auom localauom = (auom)paramViewHolder.b.get(paramInt);
              str1 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).uin;
              str2 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).troopUin;
              str2 = bdgc.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
              str3 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).recommendReason;
              str4 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).recommendKeyword;
              localauom.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
              localauom.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
              a(localauom.b, str4, str3, localauom.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
              localauom.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131376003, paramViewHolder);
              localauom.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131363745, paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt));
              localauom.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(mww.a);
              localauom.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewHolder);
              localauom.jdField_a_of_type_AndroidWidgetButton.setTag(2131376003, paramViewHolder);
              localauom.jdField_a_of_type_AndroidWidgetButton.setTag(2131363745, paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt));
              localauom.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(mww.a);
              localauom.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramViewHolder);
              paramInt += 1;
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              for (;;)
              {
                localNumberFormatException1.printStackTrace();
              }
            }
          }
        }
        if ((paramViewHolder instanceof auoo))
        {
          paramViewHolder = (auoo)paramViewHolder;
          if (paramViewHolder.jdField_a_of_type_JavaUtilList.size() > 0) {
            paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
          }
          paramInt = 0;
          while (paramInt < paramViewHolder.b.size()) {
            try
            {
              auop localauop = (auop)paramViewHolder.b.get(paramInt);
              str1 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).uin;
              str2 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).troopUin;
              str2 = bdgc.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
              str3 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).recommendReason;
              str4 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).recommendKeyword;
              localauop.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
              localauop.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
              a(localauop.b, str4, str3, localauop.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
              localauop.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131376003, paramViewHolder);
              localauop.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131363745, paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt));
              localauop.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(mww.a);
              localauop.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewHolder);
              localauop.jdField_a_of_type_AndroidWidgetButton.setTag(2131376003, paramViewHolder);
              localauop.jdField_a_of_type_AndroidWidgetButton.setTag(2131363745, paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt));
              localauop.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(mww.a);
              localauop.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramViewHolder);
              paramInt += 1;
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              for (;;)
              {
                localNumberFormatException2.printStackTrace();
              }
            }
          }
        }
      } while (!(paramViewHolder instanceof auon));
      paramViewHolder = (auon)paramViewHolder;
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment == null) || (auou.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a == null));
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.getResources().getString(2131721075, new Object[] { Integer.valueOf(auou.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a.b) }));
  }
  
  @RequiresApi(api=23)
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562782, paramViewGroup, false);
      paramViewGroup = new auoq(this, localView);
    }
    for (;;)
    {
      if ((localView != null) && (localView.getBackground() != null))
      {
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        localView.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_ATOP);
      }
      return paramViewGroup;
      if (paramInt == 1)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562779, paramViewGroup, false);
        paramViewGroup = new auon(this, localView);
      }
      else if (paramInt == 101)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562777, paramViewGroup, false);
        paramViewGroup = new auol(this, localView, paramInt);
      }
      else
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562780, paramViewGroup, false);
        paramViewGroup = new auoo(this, localView, paramInt);
      }
    }
    localView.getBackground().clearColorFilter();
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auok
 * JD-Core Version:    0.7.0.1
 */