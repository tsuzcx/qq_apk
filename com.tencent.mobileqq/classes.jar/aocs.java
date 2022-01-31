import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.EmoticonImageView;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiAdapter.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.HashMap;
import java.util.List;

public class aocs
  extends anxi
{
  public BaseChatPie a;
  private boolean a;
  protected int f;
  protected int g;
  private int h = -1;
  private int i;
  private int j;
  
  public aocs(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, anyg paramanyg, BaseChatPie paramBaseChatPie, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyg);
    this.i = paramInt4;
    this.f = ((int)(this.jdField_a_of_type_Float * 30.0F));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public View a(anxj paramanxj, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.g = ((this.d - (int)(18.0F * this.jdField_a_of_type_Float) * 2 - this.f * this.jdField_a_of_type_Int) / (this.jdField_a_of_type_Int - 1));
    long l1 = System.currentTimeMillis();
    aoct localaoct = (aoct)paramanxj;
    if (getItemViewType(paramInt) == 0)
    {
      paramanxj = paramView;
      if (paramView == null)
      {
        paramanxj = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView = new LinearLayout.LayoutParams(-2, -2);
        paramView.topMargin = ((int)(6.0F * this.jdField_a_of_type_Float));
        paramView.leftMargin = ((int)(18.0F * this.jdField_a_of_type_Float));
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setTextSize(8.0F);
        paramViewGroup.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166931));
        paramanxj.addView(paramViewGroup, paramView);
        localaoct.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup;
        paramanxj.setTag(localaoct);
      }
      paramView = (aoam)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int * paramInt);
      if (!(paramView instanceof aocu)) {
        break label1181;
      }
    }
    label1181:
    for (paramView = (aocu)paramView;; paramView = null)
    {
      if (paramView != null) {}
      for (paramView = paramView.d;; paramView = "")
      {
        localaoct.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
        paramView = paramanxj;
        int k;
        long l2;
        do
        {
          if ((paramInt == getCount() - 1) && (this.j != 0)) {
            paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom() + this.j);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SystemAndEmojiAdapter", 2, "getEmoticonView cost = " + (System.currentTimeMillis() - l1));
          }
          return paramView;
          paramanxj = paramView;
          if (paramView == null)
          {
            paramView = aoau.a().a(this.jdField_c_of_type_Int);
            if (paramView == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SystemAndEmojiAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
              }
              paramanxj = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.i);
              paramanxj.setPanelType(EmoticonPanelLinearLayout.jdField_a_of_type_Int);
              paramanxj.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
              paramanxj.setOrientation(0);
              k = this.f + (int)(12.0F * this.jdField_a_of_type_Float);
              if (paramInt == getCount() - 1) {
                k = this.f;
              }
              m = 0;
              if (m < this.jdField_a_of_type_Int)
              {
                paramView = new EmoticonImageView(this.jdField_a_of_type_AndroidContentContext);
                paramViewGroup = new LinearLayout.LayoutParams(this.f, k);
                if (m == 0) {}
                for (paramViewGroup.leftMargin = ((int)(18.0F * this.jdField_a_of_type_Float));; paramViewGroup.leftMargin = this.g)
                {
                  paramView.setLayoutParams(paramViewGroup);
                  paramView.setVisibility(8);
                  paramView.setScaleType(ImageView.ScaleType.FIT_START);
                  paramView.setAdjustViewBounds(false);
                  paramView.setFocusable(true);
                  paramView.setFocusableInTouchMode(true);
                  paramanxj.addView(paramView);
                  m += 1;
                  break;
                }
              }
            }
            for (;;)
            {
              ((EmoticonPanelLinearLayout)paramanxj).setCallBack(this.jdField_a_of_type_Anyg);
              a(this.jdField_c_of_type_Int, paramanxj);
              paramView = (ViewGroup)paramanxj;
              localaoct.jdField_a_of_type_ArrayOfComTencentMobileqqEmoticonviewEmoticonImageView = new EmoticonImageView[this.jdField_a_of_type_Int];
              k = 0;
              while (k < this.jdField_a_of_type_Int)
              {
                localaoct.jdField_a_of_type_ArrayOfComTencentMobileqqEmoticonviewEmoticonImageView[k] = ((EmoticonImageView)paramView.getChildAt(k));
                k += 1;
              }
              paramanxj = paramView;
              if (QLog.isColorLevel())
              {
                QLog.d("SystemAndEmojiAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
                paramanxj = paramView;
              }
            }
            paramanxj.setTag(localaoct);
          }
          k = 0;
          if ((paramInt == 1) || (paramInt == 5)) {
            k = (int)(7.0F * this.jdField_a_of_type_Float);
          }
          paramanxj.setPadding(0, k, 0, 0);
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("SystemAndEmojiAdapter", 2, "inflater view cost = " + (l2 - l1));
          }
          k = 0;
          paramView = paramanxj;
        } while (k >= this.jdField_a_of_type_Int);
        int m = this.jdField_a_of_type_Int * paramInt + k;
        if (m > this.jdField_a_of_type_JavaUtilList.size() - 1) {
          localaoct.jdField_a_of_type_ArrayOfComTencentMobileqqEmoticonviewEmoticonImageView[k].setVisibility(8);
        }
        for (;;)
        {
          k += 1;
          break;
          EmoticonImageView localEmoticonImageView = localaoct.jdField_a_of_type_ArrayOfComTencentMobileqqEmoticonviewEmoticonImageView[k];
          paramViewGroup = (aoam)this.jdField_a_of_type_JavaUtilList.get(m);
          paramView = null;
          if ((paramViewGroup instanceof aocu)) {
            paramView = (aocu)paramViewGroup;
          }
          if (paramView == null)
          {
            localEmoticonImageView.setVisibility(8);
          }
          else
          {
            localaoct.jdField_a_of_type_ArrayOfComTencentMobileqqEmoticonviewEmoticonImageView[k].setTag(paramView);
            if (paramView.jdField_b_of_type_Int == -1)
            {
              localEmoticonImageView.setVisibility(8);
            }
            else
            {
              localEmoticonImageView.setVisibility(0);
              if (paramViewGroup != localEmoticonImageView.getTag(2131379213))
              {
                localEmoticonImageView.setTag(2131379213, paramViewGroup);
                if (ApolloUtil.e(paramView.jdField_b_of_type_Int))
                {
                  localEmoticonImageView.setNewIconVisible(true);
                  ApolloUtil.b(paramView.jdField_b_of_type_Int);
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (!this.jdField_a_of_type_Boolean))
                  {
                    this.jdField_a_of_type_Boolean = true;
                    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
                    if (paramViewGroup != null) {
                      ThreadManagerV2.getUIHandlerV2().postDelayed(new SystemAndEmojiAdapter.1(this, paramViewGroup), 100L);
                    }
                  }
                }
                for (;;)
                {
                  l2 = System.currentTimeMillis();
                  paramViewGroup = paramView.a(false);
                  if (QLog.isColorLevel()) {
                    QLog.d("SystemAndEmojiAdapter", 2, "getdrawable cost = " + (System.currentTimeMillis() - l2));
                  }
                  localEmoticonImageView.setImageDrawable(paramViewGroup);
                  if (paramView.jdField_a_of_type_Int != 1) {
                    break label1137;
                  }
                  paramViewGroup = ayjy.a[paramView.jdField_b_of_type_Int];
                  paramView = paramViewGroup;
                  if (paramViewGroup != null)
                  {
                    paramView = paramViewGroup;
                    if (paramViewGroup.startsWith("/"))
                    {
                      paramView = paramViewGroup;
                      if (paramViewGroup.length() > 1) {
                        paramView = paramViewGroup.substring(1);
                      }
                    }
                  }
                  if (paramView == null) {
                    break;
                  }
                  localEmoticonImageView.setContentDescription(paramView);
                  break;
                  localEmoticonImageView.setNewIconVisible(false);
                }
                label1137:
                if (paramView.jdField_a_of_type_Int == 2) {
                  localEmoticonImageView.setContentDescription(ayjy.a(paramView.jdField_b_of_type_Int));
                } else {
                  localEmoticonImageView.setContentDescription(ajya.a(2131714710));
                }
              }
            }
          }
        }
      }
    }
  }
  
  public anxj a()
  {
    return new aoct();
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(List<aoam> paramList)
  {
    int k = 0;
    super.a(paramList);
    this.jdField_c_of_type_JavaUtilList = paramList;
    b();
    if (aocw.a.containsKey("8.3.0"))
    {
      Object localObject = (List)aocw.a.get("8.3.0");
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int m = ((Integer)((List)localObject).get(0)).intValue();
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label171;
        }
        int n = paramList.size();
        if (k >= n) {
          break label171;
        }
        localObject = (aoam)paramList.get(k);
        if ((localObject == null) || (!(localObject instanceof aocu))) {
          break label164;
        }
        localObject = (aocu)localObject;
        if ((((aocu)localObject).jdField_b_of_type_Boolean) || (((aocu)localObject).jdField_b_of_type_Int != m)) {
          break label164;
        }
      }
    }
    for (;;)
    {
      if (k != -1) {
        this.h = (k / this.jdField_a_of_type_Int);
      }
      return;
      label164:
      k += 1;
      break;
      label171:
      k = -1;
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilList = this.jdField_c_of_type_JavaUtilList;
    notifyDataSetChanged();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView != null) && (this.h >= 0))
    {
      int m = this.h;
      int k = m;
      if (m < 0) {
        k = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setSelection(k);
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    int k = this.jdField_a_of_type_Int;
    Object localObject = (aoam)this.jdField_a_of_type_JavaUtilList.get(k * paramInt);
    if ((localObject instanceof aocu)) {}
    for (localObject = (aocu)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        if (((aocu)localObject).jdField_a_of_type_Int == 3) {
          return 0;
        }
        return 1;
      }
      return -1;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aocs
 * JD-Core Version:    0.7.0.1
 */