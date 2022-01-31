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
import com.tencent.mobileqq.emoticonview.SystemAndEmojiAdapter.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.HashMap;
import java.util.List;

public class apyy
  extends apte
{
  public BaseChatPie a;
  public boolean a;
  private boolean b;
  protected int f;
  protected int g;
  public int h = -1;
  public int i = -1;
  private int j = -1;
  private int k;
  private int l;
  
  public apyy(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, apuc paramapuc, BaseChatPie paramBaseChatPie, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramapuc);
    this.k = paramInt4;
    this.f = ((int)(this.jdField_a_of_type_Float * 30.0F));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private int a(List<apws> paramList, int paramInt)
  {
    return a(paramList, -1, paramInt);
  }
  
  private int a(List<apws> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int m = 0;
      int n = paramList.size();
      while (m < n)
      {
        Object localObject = (apws)paramList.get(m);
        if ((localObject instanceof apza))
        {
          localObject = (apza)localObject;
          if ((!((apza)localObject).jdField_b_of_type_Boolean) && (((apza)localObject).jdField_b_of_type_Int == paramInt2) && ((paramInt1 == -1) || (paramInt1 == ((apza)localObject).jdField_a_of_type_Int))) {
            return m;
          }
        }
        m += 1;
      }
    }
    return -1;
  }
  
  public View a(aptf paramaptf, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.g = ((this.d - (int)(18.0F * this.jdField_a_of_type_Float) * 2 - this.f * this.jdField_a_of_type_Int) / (this.jdField_a_of_type_Int - 1));
    long l1 = System.currentTimeMillis();
    apyz localapyz = (apyz)paramaptf;
    if (getItemViewType(paramInt) == 0)
    {
      paramaptf = paramView;
      if (paramView == null)
      {
        paramaptf = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView = new LinearLayout.LayoutParams(-2, -2);
        paramView.topMargin = ((int)(6.0F * this.jdField_a_of_type_Float));
        paramView.leftMargin = ((int)(18.0F * this.jdField_a_of_type_Float));
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setTextSize(8.0F);
        paramViewGroup.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166981));
        paramaptf.addView(paramViewGroup, paramView);
        localapyz.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup;
        paramaptf.setTag(localapyz);
      }
      paramView = (apws)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int * paramInt);
      if (!(paramView instanceof apza)) {
        break label1205;
      }
    }
    label1161:
    label1205:
    for (paramView = (apza)paramView;; paramView = null)
    {
      if (paramView != null) {}
      for (paramView = paramView.d;; paramView = "")
      {
        localapyz.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
        paramView = paramaptf;
        int m;
        long l2;
        label750:
        do
        {
          if ((paramInt == getCount() - 1) && (this.l != 0)) {
            paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom() + this.l);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SystemAndEmojiAdapter", 2, "getEmoticonView cost = " + (System.currentTimeMillis() - l1));
          }
          return paramView;
          paramaptf = paramView;
          if (paramView == null)
          {
            paramView = apxa.a().a(this.jdField_c_of_type_Int);
            if (paramView == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SystemAndEmojiAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
              }
              paramaptf = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.k);
              paramaptf.setPanelType(EmoticonPanelLinearLayout.jdField_a_of_type_Int);
              paramaptf.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
              paramaptf.setOrientation(0);
              m = this.f + (int)(12.0F * this.jdField_a_of_type_Float);
              if (paramInt == getCount() - 1) {
                m = this.f;
              }
              n = 0;
              if (n < this.jdField_a_of_type_Int)
              {
                paramView = new EmoticonImageView(this.jdField_a_of_type_AndroidContentContext);
                paramViewGroup = new LinearLayout.LayoutParams(this.f, m);
                if (n == 0) {}
                for (paramViewGroup.leftMargin = ((int)(18.0F * this.jdField_a_of_type_Float));; paramViewGroup.leftMargin = this.g)
                {
                  paramView.setLayoutParams(paramViewGroup);
                  paramView.setVisibility(8);
                  paramView.setScaleType(ImageView.ScaleType.FIT_START);
                  paramView.setAdjustViewBounds(false);
                  paramView.setFocusable(true);
                  paramView.setFocusableInTouchMode(true);
                  paramaptf.addView(paramView);
                  n += 1;
                  break;
                }
              }
            }
            for (;;)
            {
              ((EmoticonPanelLinearLayout)paramaptf).setCallBack(this.jdField_a_of_type_Apuc);
              a(this.jdField_c_of_type_Int, paramaptf);
              paramView = (ViewGroup)paramaptf;
              localapyz.jdField_a_of_type_ArrayOfComTencentMobileqqEmoticonviewEmoticonImageView = new EmoticonImageView[this.jdField_a_of_type_Int];
              m = 0;
              while (m < this.jdField_a_of_type_Int)
              {
                localapyz.jdField_a_of_type_ArrayOfComTencentMobileqqEmoticonviewEmoticonImageView[m] = ((EmoticonImageView)paramView.getChildAt(m));
                m += 1;
              }
              paramaptf = paramView;
              if (QLog.isColorLevel())
              {
                QLog.d("SystemAndEmojiAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
                paramaptf = paramView;
              }
            }
            paramaptf.setTag(localapyz);
          }
          m = 0;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          if (paramInt == 0) {
            m = (int)(7.0F * this.jdField_a_of_type_Float);
          }
          paramaptf.setPadding(0, m, 0, 0);
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("SystemAndEmojiAdapter", 2, "inflater view cost = " + (l2 - l1));
          }
          m = 0;
          paramView = paramaptf;
        } while (m >= this.jdField_a_of_type_Int);
        int n = this.jdField_a_of_type_Int * paramInt + m;
        if (n > this.jdField_a_of_type_JavaUtilList.size() - 1) {
          localapyz.jdField_a_of_type_ArrayOfComTencentMobileqqEmoticonviewEmoticonImageView[m].setVisibility(8);
        }
        for (;;)
        {
          m += 1;
          break label750;
          if ((paramInt != 1) && (paramInt != 5)) {
            break;
          }
          m = (int)(7.0F * this.jdField_a_of_type_Float);
          break;
          EmoticonImageView localEmoticonImageView = localapyz.jdField_a_of_type_ArrayOfComTencentMobileqqEmoticonviewEmoticonImageView[m];
          paramViewGroup = (apws)this.jdField_a_of_type_JavaUtilList.get(n);
          paramView = null;
          if ((paramViewGroup instanceof apza)) {
            paramView = (apza)paramViewGroup;
          }
          if (paramView == null)
          {
            localEmoticonImageView.setVisibility(8);
          }
          else
          {
            localapyz.jdField_a_of_type_ArrayOfComTencentMobileqqEmoticonviewEmoticonImageView[m].setTag(paramView);
            if (paramView.jdField_b_of_type_Int == -1)
            {
              localEmoticonImageView.setVisibility(8);
            }
            else
            {
              localEmoticonImageView.setVisibility(0);
              if (paramViewGroup != localEmoticonImageView.getTag(2131379971))
              {
                localEmoticonImageView.setTag(2131379971, paramViewGroup);
                if (ApolloUtil.e(paramView.jdField_b_of_type_Int))
                {
                  localEmoticonImageView.setNewIconVisible(true);
                  ApolloUtil.b(paramView.jdField_b_of_type_Int);
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (!this.jdField_b_of_type_Boolean))
                  {
                    this.jdField_b_of_type_Boolean = true;
                    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
                    if (paramViewGroup != null) {
                      ThreadManagerV2.getUIHandlerV2().postDelayed(new SystemAndEmojiAdapter.2(this, paramViewGroup), 100L);
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
                    break label1161;
                  }
                  paramViewGroup = apsp.a(paramView.jdField_b_of_type_Int);
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
                if (paramView.jdField_a_of_type_Int == 2) {
                  localEmoticonImageView.setContentDescription(apsi.a(paramView.jdField_b_of_type_Int));
                } else {
                  localEmoticonImageView.setContentDescription(alud.a(2131715094));
                }
              }
            }
          }
        }
      }
    }
  }
  
  public aptf a()
  {
    return new apyz();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView != null) && (paramInt >= 0))
    {
      int m = paramInt;
      if (paramInt < 0) {
        m = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.abordFling();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setSelection(m);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != -1) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView != null))
    {
      paramInt1 = a(this.jdField_a_of_type_JavaUtilList, paramInt1, paramInt2);
      if (paramInt1 != -1)
      {
        paramInt1 /= this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.post(new SystemAndEmojiAdapter.1(this, paramInt1));
      }
    }
  }
  
  public void a(List<apws> paramList)
  {
    super.a(paramList);
    this.jdField_c_of_type_JavaUtilList = paramList;
    b();
    if (apzf.a.containsKey("8.3.5"))
    {
      List localList = (List)apzf.a.get("8.3.5");
      if ((localList != null) && (localList.size() > 0))
      {
        int m = a(paramList, ((Integer)localList.get(0)).intValue());
        if (m != -1) {
          this.j = (m / this.jdField_a_of_type_Int);
        }
      }
    }
    if ((this.h != -1) && (this.i != -1) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView != null))
    {
      a(this.i, this.h);
      this.h = -1;
      this.i = -1;
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilList = this.jdField_c_of_type_JavaUtilList;
    notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void d()
  {
    a(this.j);
  }
  
  public int getItemViewType(int paramInt)
  {
    int m = this.jdField_a_of_type_Int;
    Object localObject = (apws)this.jdField_a_of_type_JavaUtilList.get(m * paramInt);
    if ((localObject instanceof apza)) {}
    for (localObject = (apza)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        if (((apza)localObject).jdField_a_of_type_Int == 3) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyy
 * JD-Core Version:    0.7.0.1
 */