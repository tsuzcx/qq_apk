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

public class astc
  extends RecyclerView.Adapter
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MultiCardRecommendFragment jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment;
  public Map<Integer, List<RecommendPerson>> a;
  private boolean jdField_a_of_type_Boolean;
  
  public astc(MultiCardRecommendFragment paramMultiCardRecommendFragment, QQAppInterface paramQQAppInterface)
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
    if ((paramViewHolder instanceof asti)) {}
    do
    {
      do
      {
        return;
        String str1;
        String str2;
        String str3;
        String str4;
        if ((paramViewHolder instanceof astd))
        {
          paramViewHolder = (astd)paramViewHolder;
          if (paramViewHolder.jdField_a_of_type_JavaUtilList.size() > 0) {
            paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
          }
          paramInt = 0;
          while (paramInt < paramViewHolder.b.size()) {
            try
            {
              aste localaste = (aste)paramViewHolder.b.get(paramInt);
              str1 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).uin;
              str2 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).troopUin;
              str2 = bbcl.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
              str3 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).recommendReason;
              str4 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).recommendKeyword;
              localaste.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
              localaste.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
              a(localaste.b, str4, str3, localaste.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
              localaste.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131375461, paramViewHolder);
              localaste.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131363688, paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt));
              localaste.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(muf.a);
              localaste.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewHolder);
              localaste.jdField_a_of_type_AndroidWidgetButton.setTag(2131375461, paramViewHolder);
              localaste.jdField_a_of_type_AndroidWidgetButton.setTag(2131363688, paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt));
              localaste.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(muf.a);
              localaste.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramViewHolder);
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
        if ((paramViewHolder instanceof astg))
        {
          paramViewHolder = (astg)paramViewHolder;
          if (paramViewHolder.jdField_a_of_type_JavaUtilList.size() > 0) {
            paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
          }
          paramInt = 0;
          while (paramInt < paramViewHolder.b.size()) {
            try
            {
              asth localasth = (asth)paramViewHolder.b.get(paramInt);
              str1 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).uin;
              str2 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).troopUin;
              str2 = bbcl.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
              str3 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).recommendReason;
              str4 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).recommendKeyword;
              localasth.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
              localasth.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
              a(localasth.b, str4, str3, localasth.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
              localasth.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131375461, paramViewHolder);
              localasth.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131363688, paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt));
              localasth.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(muf.a);
              localasth.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewHolder);
              localasth.jdField_a_of_type_AndroidWidgetButton.setTag(2131375461, paramViewHolder);
              localasth.jdField_a_of_type_AndroidWidgetButton.setTag(2131363688, paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt));
              localasth.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(muf.a);
              localasth.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramViewHolder);
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
      } while (!(paramViewHolder instanceof astf));
      paramViewHolder = (astf)paramViewHolder;
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment == null) || (astm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a == null));
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.getResources().getString(2131720512, new Object[] { Integer.valueOf(astm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a.b) }));
  }
  
  @RequiresApi(api=23)
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562563, paramViewGroup, false);
      paramViewGroup = new asti(this, localView);
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
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562560, paramViewGroup, false);
        paramViewGroup = new astf(this, localView);
      }
      else if (paramInt == 101)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562558, paramViewGroup, false);
        paramViewGroup = new astd(this, localView, paramInt);
      }
      else
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562561, paramViewGroup, false);
        paramViewGroup = new astg(this, localView, paramInt);
      }
    }
    localView.getBackground().clearColorFilter();
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     astc
 * JD-Core Version:    0.7.0.1
 */