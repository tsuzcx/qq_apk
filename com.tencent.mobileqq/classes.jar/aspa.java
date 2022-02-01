import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.hiboom.RichTextPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class aspa
  extends aslt
{
  protected final BaseChatPie a;
  private boolean a;
  private boolean b;
  private List<String> d;
  
  public aspa(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, asmr paramasmr, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramasmr);
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private URLImageView a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionHotPicSearchAdapter", 2, "getCameraEmoView");
    }
    int i = (int)(this.jdField_d_of_type_Int - 2.0F * this.jdField_a_of_type_Float * (this.jdField_a_of_type_Int - 1));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i / this.jdField_a_of_type_Int, i / this.jdField_a_of_type_Int);
    if (paramInt == 0)
    {
      localLayoutParams.rightMargin = ((int)(this.jdField_a_of_type_Float * 1.0F));
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localURLImageView.setAdjustViewBounds(false);
      localURLImageView.setLayoutParams(localLayoutParams);
      localURLImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131691094));
      return localURLImageView;
      if (paramInt == this.jdField_a_of_type_Int - 1)
      {
        localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Float * 1.0F));
        localLayoutParams.rightMargin = 0;
        localLayoutParams.width = -1;
      }
      else
      {
        localLayoutParams.rightMargin = ((int)(this.jdField_a_of_type_Float * 1.0F));
        localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Float * 1.0F));
      }
    }
  }
  
  private void a(View paramView, aspq paramaspq, int paramInt)
  {
    if ((paramView == null) || (!(paramaspq instanceof asmu))) {
      QLog.e("EmotionHotPicSearchAdapter", 1, "emotionInfo or contentView = null");
    }
    URLImageView localURLImageView;
    asmu localasmu;
    do
    {
      return;
      localURLImageView = (URLImageView)paramView;
      localasmu = (asmu)paramaspq;
      paramView.setTag(localasmu);
      paramView.setVisibility(0);
      if ((QLog.isColorLevel()) && (!bhsr.a(localasmu.i))) {
        QLog.d("EmotionHotPicSearchAdapter", 2, "updateUI info = " + localasmu.i);
      }
    } while (localURLImageView.getTag(2131381109) == paramaspq);
    a(paramaspq, paramInt);
    localURLImageView.setTag(2131381109, paramaspq);
    localURLImageView.setVisibility(0);
    localURLImageView.setURLDrawableDownListener(null);
    paramView = localasmu.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
    if ((paramView instanceof URLDrawable)) {
      localURLImageView.setURLDrawableDownListener(new aspb(this, localasmu));
    }
    localURLImageView.setImageDrawable(paramView);
  }
  
  private void a(aspq paramaspq, int paramInt)
  {
    if ((!(paramaspq instanceof asqu)) || (((asqu)paramaspq).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem == null)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          str = ((asqu)paramaspq).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.getEmoMd5();
        } while ((this.jdField_d_of_type_JavaUtilList.contains(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null));
        if ((((asqu)paramaspq).jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (!this.b)) {
          break;
        }
        int i = ((asoc)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(5)).a();
        if ((i != 0) && (TextUtils.isEmpty(((asqu)paramaspq).jdField_a_of_type_JavaLangString)))
        {
          this.jdField_d_of_type_JavaUtilList.add(str);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "dc00898", "", "", "0X800AE1D", "0X800AE1D", i, 0, "2", "", ((asqu)paramaspq).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.getEmoMd5(), String.valueOf(paramInt + 1));
          return;
        }
      } while (TextUtils.isEmpty(((asqu)paramaspq).jdField_a_of_type_JavaLangString));
      this.jdField_d_of_type_JavaUtilList.add(str);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "dc00898", "", "", "0X800AE2D", "0X800AE2D", 0, 0, "2", "", ((asqu)paramaspq).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.getEmoMd5(), String.valueOf(paramInt + 1));
      return;
    } while ((((asqu)paramaspq).jdField_a_of_type_Int != 2) || (!this.jdField_a_of_type_Boolean));
    this.jdField_d_of_type_JavaUtilList.add(str);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "dc00898", "", "", "0X800AE35", "0X800AE35", RichTextPanel.jdField_a_of_type_Int, 0, "2", "", ((asqu)paramaspq).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.getEmoMd5(), String.valueOf(paramInt + 1));
  }
  
  public View a(aslu paramaslu, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (aspc)paramaslu;
    int i;
    if (paramView == null)
    {
      paramView = aspy.a().a(this.c);
      paramaslu = paramView;
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionHotPicSearchAdapter", 2, "getEmotionView position = " + paramInt + "; view from inflater");
        }
        paramView = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, -1);
        paramView.setPanelType(EmoticonPanelLinearLayout.g);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        paramView.setPadding(0, (int)(2.0F * this.jdField_a_of_type_Float), 0, 0);
        i = 0;
        for (;;)
        {
          paramaslu = paramView;
          if (i >= this.jdField_a_of_type_Int) {
            break;
          }
          paramaslu = a(i);
          paramaslu.setVisibility(8);
          paramaslu.setFocusable(true);
          paramaslu.setFocusableInTouchMode(true);
          paramView.addView(paramaslu);
          i += 1;
        }
      }
      ((EmoticonPanelLinearLayout)paramaslu).setCallBack(this.jdField_a_of_type_Asmr);
      a(this.c, paramaslu);
      paramView = (ViewGroup)paramaslu;
      paramViewGroup.a = new URLImageView[this.jdField_a_of_type_Int];
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        paramViewGroup.a[i] = ((URLImageView)paramView.getChildAt(i));
        i += 1;
      }
      paramaslu.setTag(paramViewGroup);
      i = j;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_Int)
      {
        j = this.jdField_a_of_type_Int * paramInt + i;
        if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramViewGroup.a[i].setTag(null);
          paramViewGroup.a[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          a(paramViewGroup.a[i], (aspq)this.jdField_a_of_type_JavaUtilList.get(j), j);
        }
      }
      return paramaslu;
      paramaslu = paramView;
      i = j;
    }
  }
  
  public aslu a()
  {
    return new aspc();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()) || (paramInt1 < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionHotPicSearchAdapter", 4, "reportDefaultExposeEvent data is null");
      }
      return;
    }
    int i = (paramInt2 + 1) * 4;
    paramInt2 = paramInt1;
    if (QLog.isColorLevel())
    {
      QLog.d("EmotionHotPicSearchAdapter", 4, "reportDefaultExposeEvent lastVisiblePosition: " + i + " firstVisiblePosition: " + paramInt1);
      paramInt2 = paramInt1;
    }
    label91:
    aspq localaspq;
    if ((paramInt2 < i) && (paramInt2 < this.jdField_a_of_type_JavaUtilList.size()))
    {
      localaspq = (aspq)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
      if (((localaspq instanceof asqu)) && (((asqu)localaspq).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem != null)) {
        break label165;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionHotPicSearchAdapter", 4, "searchItem is null ");
      }
    }
    for (;;)
    {
      paramInt2 += 1;
      break label91;
      break;
      label165:
      String str = ((asqu)localaspq).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.getEmoMd5();
      if (!this.jdField_d_of_type_JavaUtilList.contains(str)) {
        break label210;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionHotPicSearchAdapter", 4, "emoMd5 contains ");
      }
    }
    label210:
    if (((asqu)localaspq).jdField_a_of_type_Int == 2) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      a(localaspq, paramInt2);
      break;
      if (((asqu)localaspq).jdField_a_of_type_Int == 1) {
        this.b = true;
      }
    }
  }
  
  public void a(List<aspq> paramList)
  {
    b(paramList);
    super.a(paramList);
  }
  
  public void b(List<aspq> paramList)
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        do
        {
          return;
          paramList = (aspq)paramList.get(0);
        } while ((!(paramList instanceof asqu)) || (((asqu)paramList).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem == null));
        if (((asqu)paramList).jdField_a_of_type_Int != 2) {
          break;
        }
      } while (bhsi.aK(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getApp(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getCurrentAccountUin()) != 5);
      this.jdField_a_of_type_Boolean = true;
      return;
    } while ((((asqu)paramList).jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(12) != EmoticonPanelController.b));
    this.b = true;
  }
  
  public void d()
  {
    this.jdField_d_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspa
 * JD-Core Version:    0.7.0.1
 */