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

public class asox
  extends asoy
  implements View.OnClickListener
{
  protected int f;
  
  public asox(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, asmr paramasmr, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramasmr, paramInt4);
    this.b = false;
    this.f = (XPanelContainer.a - (int)paramContext.getResources().getDimension(2131296907));
  }
  
  public View a(aslu paramaslu, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt);
    }
    this.jdField_a_of_type_Asoz = ((asoz)paramaslu);
    if (paramView == null)
    {
      paramaslu = aspy.a().a(this.c);
      paramView = new AbsListView.LayoutParams(-1, this.f);
      if (paramaslu == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form inflater");
        }
        paramaslu = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561980, null);
        paramaslu.setLayoutParams(paramView);
        this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramaslu.findViewById(2131365160));
        this.jdField_a_of_type_Asoz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramaslu.findViewById(2131365252));
        this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramaslu.findViewById(2131365250));
        a(this.c, paramaslu);
        paramaslu.setTag(this.jdField_a_of_type_Asoz);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Asoz);
      paramInt = XPanelContainer.a - (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296907);
      if (paramInt != this.f)
      {
        this.f = paramInt;
        paramView = (AbsListView.LayoutParams)paramaslu.getLayoutParams();
        if (paramView != null)
        {
          paramView.height = this.f;
          paramaslu.setLayoutParams(paramView);
        }
      }
      return paramaslu;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form cache");
      }
      break;
      paramaslu = paramView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asox
 * JD-Core Version:    0.7.0.1
 */