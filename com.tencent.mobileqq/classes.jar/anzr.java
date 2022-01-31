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

public class anzr
  extends anzs
  implements View.OnClickListener
{
  protected int f;
  
  public anzr(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, anyb paramanyb, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyb, paramInt4);
    this.b = false;
    this.f = (XPanelContainer.a - (int)paramContext.getResources().getDimension(2131296829));
  }
  
  public View a(anxe paramanxe, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt);
    }
    this.jdField_a_of_type_Anzt = ((anzt)paramanxe);
    if (paramView == null)
    {
      paramanxe = aoap.a().a(this.c);
      paramView = new AbsListView.LayoutParams(-1, this.f);
      if (paramanxe == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form inflater");
        }
        paramanxe = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561496, null);
        paramanxe.setLayoutParams(paramView);
        this.jdField_a_of_type_Anzt.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramanxe.findViewById(2131364799));
        this.jdField_a_of_type_Anzt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramanxe.findViewById(2131364884));
        this.jdField_a_of_type_Anzt.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramanxe.findViewById(2131364882));
        a(this.c, paramanxe);
        paramanxe.setTag(this.jdField_a_of_type_Anzt);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Anzt);
      paramInt = XPanelContainer.a - (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296829);
      if (paramInt != this.f)
      {
        this.f = paramInt;
        paramView = (AbsListView.LayoutParams)paramanxe.getLayoutParams();
        if (paramView != null)
        {
          paramView.height = this.f;
          paramanxe.setLayoutParams(paramView);
        }
      }
      return paramanxe;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form cache");
      }
      break;
      paramanxe = paramView;
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
 * Qualified Name:     anzr
 * JD-Core Version:    0.7.0.1
 */