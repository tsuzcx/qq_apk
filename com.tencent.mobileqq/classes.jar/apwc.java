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

public class apwc
  extends apwd
  implements View.OnClickListener
{
  protected int f;
  
  public apwc(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, apuc paramapuc, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramapuc, paramInt4);
    this.b = false;
    this.f = (XPanelContainer.a - (int)paramContext.getResources().getDimension(2131296845));
  }
  
  public View a(aptf paramaptf, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt);
    }
    this.jdField_a_of_type_Apwe = ((apwe)paramaptf);
    if (paramView == null)
    {
      paramaptf = apxa.a().a(this.c);
      paramView = new AbsListView.LayoutParams(-1, this.f);
      if (paramaptf == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form inflater");
        }
        paramaptf = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561704, null);
        paramaptf.setLayoutParams(paramView);
        this.jdField_a_of_type_Apwe.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramaptf.findViewById(2131364881));
        this.jdField_a_of_type_Apwe.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramaptf.findViewById(2131364972));
        this.jdField_a_of_type_Apwe.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramaptf.findViewById(2131364970));
        a(this.c, paramaptf);
        paramaptf.setTag(this.jdField_a_of_type_Apwe);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Apwe);
      paramInt = XPanelContainer.a - (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296845);
      if (paramInt != this.f)
      {
        this.f = paramInt;
        paramView = (AbsListView.LayoutParams)paramaptf.getLayoutParams();
        if (paramView != null)
        {
          paramView.height = this.f;
          paramaptf.setLayoutParams(paramView);
        }
      }
      return paramaptf;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form cache");
      }
      break;
      paramaptf = paramView;
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
 * Qualified Name:     apwc
 * JD-Core Version:    0.7.0.1
 */