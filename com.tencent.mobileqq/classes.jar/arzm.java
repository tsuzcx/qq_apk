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

public class arzm
  extends arwf
{
  protected final BaseChatPie a;
  private boolean a;
  private boolean b;
  private List<String> d;
  
  public arzm(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, arxd paramarxd, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramarxd);
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
  
  private void a(View paramView, asac paramasac, int paramInt)
  {
    if ((paramView == null) || (!(paramasac instanceof arxg))) {
      QLog.e("EmotionHotPicSearchAdapter", 1, "emotionInfo or contentView = null");
    }
    URLImageView localURLImageView;
    arxg localarxg;
    do
    {
      return;
      localURLImageView = (URLImageView)paramView;
      localarxg = (arxg)paramasac;
      paramView.setTag(localarxg);
      paramView.setVisibility(0);
      if ((QLog.isColorLevel()) && (!bgsp.a(localarxg.i))) {
        QLog.d("EmotionHotPicSearchAdapter", 2, "updateUI info = " + localarxg.i);
      }
    } while (localURLImageView.getTag(2131380929) == paramasac);
    a(paramasac, paramInt);
    localURLImageView.setTag(2131380929, paramasac);
    localURLImageView.setVisibility(0);
    localURLImageView.setURLDrawableDownListener(null);
    paramView = localarxg.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
    if ((paramView instanceof URLDrawable)) {
      localURLImageView.setURLDrawableDownListener(new arzn(this, localarxg));
    }
    localURLImageView.setImageDrawable(paramView);
  }
  
  private void a(asac paramasac, int paramInt)
  {
    if ((!(paramasac instanceof asbg)) || (((asbg)paramasac).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem == null)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          str = ((asbg)paramasac).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.getEmoMd5();
        } while ((this.jdField_d_of_type_JavaUtilList.contains(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null));
        if ((((asbg)paramasac).jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (!this.b)) {
          break;
        }
        int i = ((aryo)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(5)).a();
        if ((i != 0) && (TextUtils.isEmpty(((asbg)paramasac).jdField_a_of_type_JavaLangString)))
        {
          this.jdField_d_of_type_JavaUtilList.add(str);
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "dc00898", "", "", "0X800AE1D", "0X800AE1D", i, 0, "2", "", ((asbg)paramasac).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.getEmoMd5(), String.valueOf(paramInt + 1));
          return;
        }
      } while (TextUtils.isEmpty(((asbg)paramasac).jdField_a_of_type_JavaLangString));
      this.jdField_d_of_type_JavaUtilList.add(str);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "dc00898", "", "", "0X800AE2D", "0X800AE2D", 0, 0, "2", "", ((asbg)paramasac).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.getEmoMd5(), String.valueOf(paramInt + 1));
      return;
    } while ((((asbg)paramasac).jdField_a_of_type_Int != 2) || (!this.jdField_a_of_type_Boolean));
    this.jdField_d_of_type_JavaUtilList.add(str);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "dc00898", "", "", "0X800AE35", "0X800AE35", RichTextPanel.jdField_a_of_type_Int, 0, "2", "", ((asbg)paramasac).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.getEmoMd5(), String.valueOf(paramInt + 1));
  }
  
  public View a(arwg paramarwg, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (arzo)paramarwg;
    int i;
    if (paramView == null)
    {
      paramView = asak.a().a(this.c);
      paramarwg = paramView;
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
          paramarwg = paramView;
          if (i >= this.jdField_a_of_type_Int) {
            break;
          }
          paramarwg = a(i);
          paramarwg.setVisibility(8);
          paramarwg.setFocusable(true);
          paramarwg.setFocusableInTouchMode(true);
          paramView.addView(paramarwg);
          i += 1;
        }
      }
      ((EmoticonPanelLinearLayout)paramarwg).setCallBack(this.jdField_a_of_type_Arxd);
      a(this.c, paramarwg);
      paramView = (ViewGroup)paramarwg;
      paramViewGroup.a = new URLImageView[this.jdField_a_of_type_Int];
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        paramViewGroup.a[i] = ((URLImageView)paramView.getChildAt(i));
        i += 1;
      }
      paramarwg.setTag(paramViewGroup);
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
          a(paramViewGroup.a[i], (asac)this.jdField_a_of_type_JavaUtilList.get(j), j);
        }
      }
      return paramarwg;
      paramarwg = paramView;
      i = j;
    }
  }
  
  public arwg a()
  {
    return new arzo();
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
    asac localasac;
    if ((paramInt2 < i) && (paramInt2 < this.jdField_a_of_type_JavaUtilList.size()))
    {
      localasac = (asac)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
      if (((localasac instanceof asbg)) && (((asbg)localasac).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem != null)) {
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
      String str = ((asbg)localasac).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem.getEmoMd5();
      if (!this.jdField_d_of_type_JavaUtilList.contains(str)) {
        break label210;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionHotPicSearchAdapter", 4, "emoMd5 contains ");
      }
    }
    label210:
    if (((asbg)localasac).jdField_a_of_type_Int == 2) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      a(localasac, paramInt2);
      break;
      if (((asbg)localasac).jdField_a_of_type_Int == 1) {
        this.b = true;
      }
    }
  }
  
  public void a(List<asac> paramList)
  {
    b(paramList);
    super.a(paramList);
  }
  
  public void b(List<asac> paramList)
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
          paramList = (asac)paramList.get(0);
        } while ((!(paramList instanceof asbg)) || (((asbg)paramList).jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchItem == null));
        if (((asbg)paramList).jdField_a_of_type_Int != 2) {
          break;
        }
      } while (bgsg.aK(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getApp(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getCurrentAccountUin()) != 5);
      this.jdField_a_of_type_Boolean = true;
      return;
    } while ((((asbg)paramList).jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(12) != EmoticonPanelController.b));
    this.b = true;
  }
  
  public void d()
  {
    this.jdField_d_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzm
 * JD-Core Version:    0.7.0.1
 */