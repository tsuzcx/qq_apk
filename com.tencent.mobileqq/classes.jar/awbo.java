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
import android.view.View.OnClickListener;
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
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class awbo
  extends RecyclerView.Adapter
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MultiCardRecommendFragment jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment;
  public Map<Integer, List<RecommendPerson>> a;
  private boolean jdField_a_of_type_Boolean;
  
  public awbo(MultiCardRecommendFragment paramMultiCardRecommendFragment, QQAppInterface paramQQAppInterface)
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
    if ((paramViewHolder instanceof awbu)) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject;
      int i;
      String str1;
      String str2;
      String str3;
      String str4;
      if ((paramViewHolder instanceof awbp))
      {
        localObject = (awbp)paramViewHolder;
        if (((awbp)localObject).jdField_a_of_type_JavaUtilList.size() > 0) {
          ((awbp)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)((awbp)localObject).jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
        }
        i = 0;
        while (i < ((awbp)localObject).b.size()) {
          try
          {
            awbq localawbq = (awbq)((awbp)localObject).b.get(i);
            str1 = ((RecommendPerson)((awbp)localObject).jdField_a_of_type_JavaUtilList.get(i)).uin;
            str2 = ((RecommendPerson)((awbp)localObject).jdField_a_of_type_JavaUtilList.get(i)).troopUin;
            str2 = ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
            str3 = ((RecommendPerson)((awbp)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendReason;
            str4 = ((RecommendPerson)((awbp)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendKeyword;
            localawbq.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
            localawbq.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
            a(localawbq.b, str4, str3, localawbq.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
            localawbq.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131376644, localObject);
            localawbq.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131364000, ((awbp)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localawbq.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(mum.a);
            localawbq.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
            localawbq.jdField_a_of_type_AndroidWidgetButton.setTag(2131376644, localObject);
            localawbq.jdField_a_of_type_AndroidWidgetButton.setTag(2131364000, ((awbp)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localawbq.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(mum.a);
            localawbq.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject);
            i += 1;
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
      if ((paramViewHolder instanceof awbs))
      {
        localObject = (awbs)paramViewHolder;
        if (((awbs)localObject).jdField_a_of_type_JavaUtilList.size() > 0) {
          ((awbs)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)((awbs)localObject).jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
        }
        i = 0;
        while (i < ((awbs)localObject).b.size()) {
          try
          {
            awbt localawbt = (awbt)((awbs)localObject).b.get(i);
            str1 = ((RecommendPerson)((awbs)localObject).jdField_a_of_type_JavaUtilList.get(i)).uin;
            str2 = ((RecommendPerson)((awbs)localObject).jdField_a_of_type_JavaUtilList.get(i)).troopUin;
            str2 = ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
            str3 = ((RecommendPerson)((awbs)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendReason;
            str4 = ((RecommendPerson)((awbs)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendKeyword;
            localawbt.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
            localawbt.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
            a(localawbt.b, str4, str3, localawbt.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
            localawbt.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131376644, localObject);
            localawbt.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131364000, ((awbs)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localawbt.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(mum.a);
            localawbt.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
            localawbt.jdField_a_of_type_AndroidWidgetButton.setTag(2131376644, localObject);
            localawbt.jdField_a_of_type_AndroidWidgetButton.setTag(2131364000, ((awbs)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localawbt.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(mum.a);
            localawbt.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject);
            i += 1;
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
      if ((paramViewHolder instanceof awbr))
      {
        localObject = (awbr)paramViewHolder;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment != null) && (awby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a != null)) {
          ((awbr)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.getResources().getString(2131719219, new Object[] { Integer.valueOf(awby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a.b) }));
        }
      }
    }
  }
  
  @RequiresApi(api=23)
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562936, paramViewGroup, false);
      paramViewGroup = new awbu(this, localView);
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
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562933, paramViewGroup, false);
        paramViewGroup = new awbr(this, localView);
      }
      else if (paramInt == 101)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562931, paramViewGroup, false);
        paramViewGroup = new awbp(this, localView, paramInt);
      }
      else
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562934, paramViewGroup, false);
        paramViewGroup = new awbs(this, localView, paramInt);
      }
    }
    localView.getBackground().clearColorFilter();
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbo
 * JD-Core Version:    0.7.0.1
 */