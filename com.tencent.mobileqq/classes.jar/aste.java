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

public class aste
  extends RecyclerView.Adapter
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MultiCardRecommendFragment jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment;
  public Map<Integer, List<RecommendPerson>> a;
  private boolean jdField_a_of_type_Boolean;
  
  public aste(MultiCardRecommendFragment paramMultiCardRecommendFragment, QQAppInterface paramQQAppInterface)
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
    if ((paramViewHolder instanceof astk)) {}
    do
    {
      do
      {
        return;
        String str1;
        String str2;
        String str3;
        String str4;
        if ((paramViewHolder instanceof astf))
        {
          paramViewHolder = (astf)paramViewHolder;
          if (paramViewHolder.jdField_a_of_type_JavaUtilList.size() > 0) {
            paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
          }
          paramInt = 0;
          while (paramInt < paramViewHolder.b.size()) {
            try
            {
              astg localastg = (astg)paramViewHolder.b.get(paramInt);
              str1 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).uin;
              str2 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).troopUin;
              str2 = bbcz.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
              str3 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).recommendReason;
              str4 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).recommendKeyword;
              localastg.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
              localastg.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
              a(localastg.b, str4, str3, localastg.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
              localastg.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131375463, paramViewHolder);
              localastg.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131363687, paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt));
              localastg.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(muc.a);
              localastg.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewHolder);
              localastg.jdField_a_of_type_AndroidWidgetButton.setTag(2131375463, paramViewHolder);
              localastg.jdField_a_of_type_AndroidWidgetButton.setTag(2131363687, paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt));
              localastg.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(muc.a);
              localastg.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramViewHolder);
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
        if ((paramViewHolder instanceof asti))
        {
          paramViewHolder = (asti)paramViewHolder;
          if (paramViewHolder.jdField_a_of_type_JavaUtilList.size() > 0) {
            paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
          }
          paramInt = 0;
          while (paramInt < paramViewHolder.b.size()) {
            try
            {
              astj localastj = (astj)paramViewHolder.b.get(paramInt);
              str1 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).uin;
              str2 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).troopUin;
              str2 = bbcz.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
              str3 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).recommendReason;
              str4 = ((RecommendPerson)paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt)).recommendKeyword;
              localastj.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
              localastj.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
              a(localastj.b, str4, str3, localastj.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
              localastj.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131375463, paramViewHolder);
              localastj.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131363687, paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt));
              localastj.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(muc.a);
              localastj.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewHolder);
              localastj.jdField_a_of_type_AndroidWidgetButton.setTag(2131375463, paramViewHolder);
              localastj.jdField_a_of_type_AndroidWidgetButton.setTag(2131363687, paramViewHolder.jdField_a_of_type_JavaUtilList.get(paramInt));
              localastj.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(muc.a);
              localastj.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramViewHolder);
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
      } while (!(paramViewHolder instanceof asth));
      paramViewHolder = (asth)paramViewHolder;
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment == null) || (asto.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a == null));
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.getResources().getString(2131720523, new Object[] { Integer.valueOf(asto.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a.b) }));
  }
  
  @RequiresApi(api=23)
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562562, paramViewGroup, false);
      paramViewGroup = new astk(this, localView);
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
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562559, paramViewGroup, false);
        paramViewGroup = new asth(this, localView);
      }
      else if (paramInt == 101)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562557, paramViewGroup, false);
        paramViewGroup = new astf(this, localView, paramInt);
      }
      else
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562560, paramViewGroup, false);
        paramViewGroup = new asti(this, localView, paramInt);
      }
    }
    localView.getBackground().clearColorFilter();
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aste
 * JD-Core Version:    0.7.0.1
 */