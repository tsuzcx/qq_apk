import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XPanelContainer;

public class anzw
  extends anzx
  implements View.OnClickListener
{
  protected int f;
  
  public anzw(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, anyg paramanyg, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyg, paramInt4);
    this.b = false;
    this.f = (XPanelContainer.a - (int)paramContext.getResources().getDimension(2131296829));
  }
  
  public View a(anxj paramanxj, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt);
    }
    this.jdField_a_of_type_Anzy = ((anzy)paramanxj);
    if (paramView == null)
    {
      paramanxj = aoau.a().a(this.c);
      paramView = new AbsListView.LayoutParams(-1, this.f);
      if (paramanxj == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form inflater");
        }
        paramanxj = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561495, null);
        paramanxj.setLayoutParams(paramView);
        this.jdField_a_of_type_Anzy.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramanxj.findViewById(2131364798));
        this.jdField_a_of_type_Anzy.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramanxj.findViewById(2131364883));
        this.jdField_a_of_type_Anzy.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramanxj.findViewById(2131364881));
        a(this.c, paramanxj);
        paramanxj.setTag(this.jdField_a_of_type_Anzy);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Anzy);
      paramInt = XPanelContainer.a - (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296829);
      if (paramInt != this.f)
      {
        this.f = paramInt;
        paramView = (AbsListView.LayoutParams)paramanxj.getLayoutParams();
        if (paramView != null)
        {
          paramView.height = this.f;
          paramanxj.setLayoutParams(paramView);
        }
      }
      return paramanxj;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form cache");
      }
      break;
      paramanxj = paramView;
    }
  }
  
  public EmoticonPackage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  }
  
  public int getCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anzw
 * JD-Core Version:    0.7.0.1
 */