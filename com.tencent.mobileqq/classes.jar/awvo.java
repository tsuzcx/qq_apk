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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class awvo
  extends RecyclerView.Adapter
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MultiCardRecommendFragment jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment;
  public Map<Integer, List<RecommendPerson>> a;
  private boolean jdField_a_of_type_Boolean;
  
  public awvo(MultiCardRecommendFragment paramMultiCardRecommendFragment, QQAppInterface paramQQAppInterface)
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
    if ((paramViewHolder instanceof awvu)) {}
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
      if ((paramViewHolder instanceof awvp))
      {
        localObject = (awvp)paramViewHolder;
        if (((awvp)localObject).jdField_a_of_type_JavaUtilList.size() > 0) {
          ((awvp)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)((awvp)localObject).jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
        }
        i = 0;
        while (i < ((awvp)localObject).b.size()) {
          try
          {
            awvq localawvq = (awvq)((awvp)localObject).b.get(i);
            str1 = ((RecommendPerson)((awvp)localObject).jdField_a_of_type_JavaUtilList.get(i)).uin;
            str2 = ((RecommendPerson)((awvp)localObject).jdField_a_of_type_JavaUtilList.get(i)).troopUin;
            str2 = bglf.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
            str3 = ((RecommendPerson)((awvp)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendReason;
            str4 = ((RecommendPerson)((awvp)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendKeyword;
            localawvq.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
            localawvq.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
            a(localawvq.b, str4, str3, localawvq.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
            localawvq.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131376752, localObject);
            localawvq.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131363951, ((awvp)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localawvq.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(mue.a);
            localawvq.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
            localawvq.jdField_a_of_type_AndroidWidgetButton.setTag(2131376752, localObject);
            localawvq.jdField_a_of_type_AndroidWidgetButton.setTag(2131363951, ((awvp)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localawvq.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(mue.a);
            localawvq.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject);
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
      if ((paramViewHolder instanceof awvs))
      {
        localObject = (awvs)paramViewHolder;
        if (((awvs)localObject).jdField_a_of_type_JavaUtilList.size() > 0) {
          ((awvs)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)((awvs)localObject).jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
        }
        i = 0;
        while (i < ((awvs)localObject).b.size()) {
          try
          {
            awvt localawvt = (awvt)((awvs)localObject).b.get(i);
            str1 = ((RecommendPerson)((awvs)localObject).jdField_a_of_type_JavaUtilList.get(i)).uin;
            str2 = ((RecommendPerson)((awvs)localObject).jdField_a_of_type_JavaUtilList.get(i)).troopUin;
            str2 = bglf.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
            str3 = ((RecommendPerson)((awvs)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendReason;
            str4 = ((RecommendPerson)((awvs)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendKeyword;
            localawvt.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
            localawvt.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
            a(localawvt.b, str4, str3, localawvt.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
            localawvt.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131376752, localObject);
            localawvt.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131363951, ((awvs)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localawvt.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(mue.a);
            localawvt.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
            localawvt.jdField_a_of_type_AndroidWidgetButton.setTag(2131376752, localObject);
            localawvt.jdField_a_of_type_AndroidWidgetButton.setTag(2131363951, ((awvs)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localawvt.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(mue.a);
            localawvt.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject);
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
      if ((paramViewHolder instanceof awvr))
      {
        localObject = (awvr)paramViewHolder;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment != null) && (awvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a != null)) {
          ((awvr)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.getResources().getString(2131718809, new Object[] { Integer.valueOf(awvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a.b) }));
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563020, paramViewGroup, false);
      paramViewGroup = new awvu(this, localView);
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
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563017, paramViewGroup, false);
        paramViewGroup = new awvr(this, localView);
      }
      else if (paramInt == 101)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563015, paramViewGroup, false);
        paramViewGroup = new awvp(this, localView, paramInt);
      }
      else
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563018, paramViewGroup, false);
        paramViewGroup = new awvs(this, localView, paramInt);
      }
    }
    localView.getBackground().clearColorFilter();
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvo
 * JD-Core Version:    0.7.0.1
 */